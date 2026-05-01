package com.hpplay.sdk.source.pass;

import android.content.Context;
import android.text.TextUtils;
import com.hpplay.common.asyncmanager.AsyncHttpParameter;
import com.hpplay.common.asyncmanager.AsyncHttpRequestListener;
import com.hpplay.component.common.ParamsMap;
import com.hpplay.sdk.source.bean.PassBean;
import com.hpplay.sdk.source.browse.data.BrowserInfo;
import com.hpplay.sdk.source.business.IMQueue;
import com.hpplay.sdk.source.business.cloud.CloudAPI;
import com.hpplay.sdk.source.c.a;
import com.hpplay.sdk.source.common.store.Session;
import com.hpplay.sdk.source.log.SourceLog;
import com.hpplay.sdk.source.process.LelinkSdkManager;
import java.util.Arrays;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class NetCastPassSender {
    private final String TAG = "NetCastPassSender";
    private Context mContext;

    public NetCastPassSender(Context context) {
        this.mContext = context;
    }

    private String padLeft(String str, int i10) {
        if (str.length() >= i10) {
            return str;
        }
        byte[] bArr = new byte[i10];
        byte[] bytes = str.getBytes();
        Arrays.fill(bArr, (byte) 48);
        System.arraycopy(bytes, 0, bArr, i10 - bytes.length, bytes.length);
        return new String(bArr);
    }

    public void callbackPass(PassBean passBean) {
        SourceLog.i("NetCastPassSender", "callbackPass,mPassCallback: " + LelinkSdkManager.getInstance().mPassCallback);
        if (LelinkSdkManager.getInstance().mPassCallback != null) {
            LelinkSdkManager.getInstance().mPassCallback.onSendPassCallBack(passBean);
        }
    }

    public void sendMsg(String str, int i10, String str2) {
        final PassBean passBean = new PassBean();
        passBean.action = i10;
        passBean.uid = str;
        SourceLog.i("NetCastPassSender", "sendMsg ===== " + str);
        if (TextUtils.isEmpty(str)) {
            SourceLog.w("NetCastPassSender", "sendMsg, can not find cast user info");
            passBean.result = 0;
            callbackPass(passBean);
            return;
        }
        String str3 = padLeft(Integer.toHexString(i10), 8) + "," + str2;
        JSONObject jSONObject = new JSONObject();
        jSONObject.putOpt("suid", Session.getInstance().getUID());
        jSONObject.putOpt(ParamsMap.DeviceParams.KEY_RECEIVER_UID, str);
        jSONObject.putOpt(ParamsMap.DeviceParams.KEY_APPID, Session.getInstance().appKey);
        jSONObject.putOpt(ParamsMap.DeviceParams.KEY_AUTH_TOKEN, a.a());
        jSONObject.putOpt("content", str3);
        jSONObject.putOpt(BrowserInfo.KEY_VER, "2.0");
        String jSONObject2 = jSONObject.toString();
        SourceLog.i("NetCastPassSender", "sendMsg " + jSONObject2);
        AsyncHttpParameter asyncHttpParameter = new AsyncHttpParameter(CloudAPI.sPassthroughPushUrl, jSONObject2);
        AsyncHttpParameter.In in = asyncHttpParameter.in;
        in.requestMethod = 1;
        in.connectTimeout = 2000;
        in.readTimeout = 2000;
        IMQueue.getInstance().addTask(asyncHttpParameter, new AsyncHttpRequestListener() { // from class: com.hpplay.sdk.source.pass.NetCastPassSender.1
            @Override // com.hpplay.common.asyncmanager.AsyncHttpRequestListener
            public void onRequestResult(AsyncHttpParameter asyncHttpParameter2) {
                if (asyncHttpParameter2.out.resultType == 0) {
                    SourceLog.i("NetCastPassSender", "sendMsg success");
                    passBean.result = 1;
                } else {
                    SourceLog.i("NetCastPassSender", "sendMsg failed");
                    passBean.result = 0;
                }
                NetCastPassSender.this.callbackPass(passBean);
            }
        });
    }
}
