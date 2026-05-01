package com.hpplay.component.protocol.connection;

import android.text.TextUtils;
import com.hpplay.component.common.ParamsMap;
import com.hpplay.component.common.utils.CLog;
import com.hpplay.component.protocol.NLProtocolBuiler;
import com.hpplay.component.protocol.ProtocolBuilder;
import com.hpplay.component.protocol.ProtocolUtils;
import com.hpplay.component.protocol.encrypt.LelinkEncrypt;
import com.hpplay.component.protocol.plist.NSDictionary;
import com.hpplay.component.protocol.plist.PropertyListParser;

/* loaded from: classes2.dex */
public class LelinkV2Connection extends IConnection {
    private static final String FEATURE = "feature";
    private static final String TAG = "LelinkV2Connection";
    private int cseq;
    private LelinkEncrypt mLelinkEncrypt;
    private String mResult;

    public LelinkV2Connection(ParamsMap paramsMap) {
        super(paramsMap);
        this.cseq = 0;
        LelinkEncrypt lelinkEncrypt = new LelinkEncrypt(this.sessionId);
        this.mLelinkEncrypt = lelinkEncrypt;
        lelinkEncrypt.setSrpPassword(paramsMap.getScreenCode());
    }

    @Override // com.hpplay.component.protocol.connection.IConnection
    public boolean checkConnection() {
        int i10 = this.mKeepAliveTimeout;
        return i10 > 0 ? this.mProtocolSender.tcpCheckTvState(this.mIp, this.mPort, i10) : this.mProtocolSender.tcpCheckTvState(this.mIp, this.mPort);
    }

    public String getFeature() {
        if (TextUtils.isEmpty(this.mResult) || !this.mResult.contains("feature")) {
            return "";
        }
        try {
            NSDictionary nSDictionary = (NSDictionary) PropertyListParser.parse(ProtocolUtils.removeHeader(this.mResult.getBytes()));
            return nSDictionary.containsKey("feature") ? nSDictionary.objectForKey("feature").toString() : "";
        } catch (Exception e10) {
            e10.printStackTrace();
            return "";
        }
    }

    @Override // com.hpplay.component.protocol.connection.IConnection
    public boolean startConnect() {
        byte[] interactiveEncryptData;
        try {
            String valueOf = String.valueOf(this.paramsMap.getParam(ParamsMap.ConnectParams.KEY_CONNECT_JSON, ""));
            String str = new NLProtocolBuiler().getNewConnectionCmd().setPlatfrom().setUserAgent("HappyCast5,0/500.0").setContentType("application/json").setNewLelinkClientId(getSessionId()).setNewClientUid(this.paramsMap.getCuid()).setNewSessionId(getSessionId()).setNewCSEQ(this.cseq + "").setContentLength(valueOf.length() + "").getString(true) + valueOf;
            if (!this.mProtocolSender.connectServer(this.mTimeout) || !this.mProtocolSender.checkEncrypt(this.mLelinkEncrypt, TAG) || (interactiveEncryptData = this.mProtocolSender.interactiveEncryptData(this.mLelinkEncrypt.buildEncryptData(str.getBytes()))) == null) {
                return false;
            }
            String str2 = new String(this.mLelinkEncrypt.decryptData(interactiveEncryptData));
            this.mResult = str2;
            if (!TextUtils.isEmpty(str2)) {
                if (this.mResult.contains(ProtocolBuilder.LELINK_STATE_SUCCESS)) {
                    return true;
                }
            }
            return false;
        } catch (Exception e10) {
            CLog.w(TAG, e10);
            throw e10;
        }
    }
}
