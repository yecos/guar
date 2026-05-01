package com.hpplay.component.protocol.connection;

import android.text.TextUtils;
import com.hpplay.component.common.ParamsMap;
import com.hpplay.component.common.utils.CLog;
import com.hpplay.component.protocol.ProtocolSender;
import com.hpplay.component.protocol.ProtocolUtils;
import java.net.URL;

/* loaded from: classes2.dex */
public abstract class IConnection {
    public static final int DEFAULT_TIME_OUT = 10000;
    public static final String SUPPORT_LOW_RECEIVER_APK_VERSION_NUM = "5.0";
    public static final String SUPPORT_LOW_RECEIVER_APK_VERSION_NUM_1 = "3.";
    public static final String SUPPORT_NEW_LELINK_PROTOCOL_VERSION_NUM = "5.5";
    private static final String TAG = "IConnection";
    public String mDeviceName;
    public String mHid;
    public String mIp;
    public int mKeepAliveTimeout;
    public int mPort;
    public ProtocolSender mProtocolSender = new ProtocolSender();
    public int mTimeout;
    public ParamsMap paramsMap;
    public String sessionId;

    public IConnection(ParamsMap paramsMap) {
        this.mPort = 0;
        this.paramsMap = paramsMap;
        this.mIp = paramsMap.getIp();
        int intParam = paramsMap.getIntParam("connect_timeout");
        this.mTimeout = intParam;
        this.mTimeout = intParam == 0 ? 10000 : intParam;
        this.mKeepAliveTimeout = paramsMap.getIntParam(ParamsMap.ConnectParams.KEY_KEEP_ALIVE_TIMEOUT);
        CLog.i(TAG, Thread.currentThread() + "  ip == >  " + paramsMap.getIp().replace(".", "") + " port == > " + paramsMap.getPort());
        try {
            this.mPort = paramsMap.getPort();
        } catch (Exception unused) {
            String stringParam = paramsMap.getStringParam(ParamsMap.PushParams.KEY_LOCATION_URI);
            if (!TextUtils.isEmpty(stringParam)) {
                this.mPort = getPort(stringParam);
                CLog.i(TAG, "parse uri port " + this.mPort);
            }
        }
        CLog.i(TAG, Thread.currentThread() + "  ip == >  " + paramsMap.getIp().replace(".", "") + " port == > " + this.mPort);
        this.mProtocolSender.setConnectInfo(this.mIp, this.mPort);
        this.sessionId = ProtocolUtils.createSessionId(paramsMap.getCuid());
    }

    private int getPort(String str) {
        try {
            return new URL(str).getPort();
        } catch (Exception unused) {
            return 0;
        }
    }

    public abstract boolean checkConnection();

    public boolean checkConnection(int i10) {
        return false;
    }

    public void disConnect() {
        this.mProtocolSender.release();
    }

    public ProtocolSender getProtocolSender() {
        return this.mProtocolSender;
    }

    public String getSessionId() {
        return this.sessionId;
    }

    public abstract boolean startConnect();
}
