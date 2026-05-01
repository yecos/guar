package com.hpplay.component.protocol.connection;

import android.text.TextUtils;
import com.hpplay.component.common.ParamsMap;
import com.hpplay.component.common.protocol.ProtocolListener;
import com.hpplay.component.common.utils.CLog;
import com.hpplay.component.common.utils.ModuleIds;
import com.hpplay.component.modulelinker.api.ModuleLinker;
import com.hpplay.component.protocol.ProtocolBuilder;
import com.hpplay.sdk.source.bean.DramaInfoBean;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class IMConnection extends IConnection {
    private static final int CONNECT_FAILED_TIME_OUT = 20000;
    private static final int IM_DEFAULT_PLAT = 0;
    private static final int MSG_CONNECT_FAILED = 501;
    private static final String TAG = "IMConnection";
    private static final int WAITING_TIME_OUT = 15000;
    private boolean isConnectServ;
    private int mConnectState;
    private ModuleLinker mModuleLinker;
    private ProtocolListener mProtocolListener;
    ProtocolListener protocolListener;

    public IMConnection(ParamsMap paramsMap, ProtocolListener protocolListener) {
        super(paramsMap);
        this.isConnectServ = false;
        this.protocolListener = new ProtocolListener() { // from class: com.hpplay.component.protocol.connection.IMConnection.1
            @Override // com.hpplay.component.common.protocol.ProtocolListener
            public void onResult(int i10, String... strArr) {
                if (100001 != i10) {
                    if (ParamsMap.IMParams.KEY_RECEIVE_CONNECT_IM == i10) {
                        IMConnection.this.connectTvResult(strArr[0]);
                    }
                } else if (TextUtils.equals(strArr[0], "successful")) {
                    IMConnection.this.isConnectServ = true;
                    IMConnection.this.wakeup();
                }
            }
        };
        try {
            this.mProtocolListener = protocolListener;
            this.mModuleLinker = ModuleLinker.getInstance();
        } catch (Exception e10) {
            CLog.w(TAG, e10);
        }
    }

    private void waitState(long j10) {
        synchronized (this) {
            try {
                wait(j10);
            } catch (InterruptedException e10) {
                CLog.w(TAG, e10);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wakeup() {
        synchronized (this) {
            try {
                notifyAll();
            } catch (Exception e10) {
                CLog.w(TAG, e10);
            }
        }
    }

    @Override // com.hpplay.component.protocol.connection.IConnection
    public boolean checkConnection() {
        return true;
    }

    public void connectTvResult(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            int optInt = jSONObject.optInt("st");
            int optInt2 = jSONObject.optInt(DramaInfoBean.CATEGORY_STD);
            this.mConnectState = optInt;
            wakeup();
            if (optInt == 2) {
                CLog.i(TAG, "im connect state allow");
                return;
            }
            if (optInt == 1) {
                CLog.i(TAG, "im connect state waiting");
            } else if (optInt2 == 1) {
                CLog.i(TAG, "im connect state time out");
            } else if (optInt2 == 3) {
                CLog.i(TAG, "im connect state black list");
            } else {
                CLog.i(TAG, "im connect state black reject");
            }
            this.mProtocolListener.onResult(4, jSONObject.toString());
        } catch (Exception e10) {
            CLog.w(TAG, e10);
            wakeup();
        }
    }

    @Override // com.hpplay.component.protocol.connection.IConnection
    public boolean startConnect() {
        ModuleLinker moduleLinker = this.mModuleLinker;
        if (moduleLinker == null) {
            return false;
        }
        boolean booleanValue = ((Boolean) moduleLinker.callMethod(ModuleIds.METHOD_IMCONTROLLER_ISCONNECTED, new Object[0])).booleanValue();
        this.isConnectServ = booleanValue;
        if (!booleanValue) {
            this.mModuleLinker.callMethod(ModuleIds.METHOD_IMCONTROLLER_SETINFOS, this.paramsMap);
            this.mModuleLinker.callMethod(ModuleIds.METHOD_IMCONTROLLER_SETIMMSGRECEIVER, Integer.valueOf(ParamsMap.IMParams.KEY_RECEIVE_CONNECT_STATE), this.protocolListener);
            this.mModuleLinker.callMethod(ModuleIds.METHOD_IMCONTROLLER_CONNECTTV, new Object[0]);
            waitState(20000L);
        }
        if (this.isConnectServ) {
            this.mModuleLinker.callMethod(ModuleIds.METHOD_IMCONTROLLER_SETIMMSGRECEIVER, Long.valueOf(ParamsMap.IMParams.KEY_RECEIVE_CONNECT_IM), this.protocolListener);
            Object callMethod = this.mModuleLinker.callMethod(ModuleIds.METHOD_IMCONTROLLER_CONNECTTV, this.paramsMap.getParam(ParamsMap.IMParams.KEY_DEVICE_NAME, ""), null, this.sessionId);
            if (callMethod != null && callMethod.toString().contains(ProtocolBuilder.LELINK_STATE_SUCCESS)) {
                CLog.i(TAG, "   send connect tv msg successful ");
                waitState(20000L);
            } else if (callMethod != null && callMethod.toString().contains(ProtocolBuilder.LELINK_UNSUPPORT_FORBIDDEN)) {
                CLog.i(TAG, " receiver is offline ");
            }
        }
        if (this.mConnectState == 1) {
            CLog.i(TAG, "   wait connect ");
            waitState(15000L);
        }
        CLog.i(TAG, " call im result " + this.mConnectState);
        return this.mConnectState == 2;
    }
}
