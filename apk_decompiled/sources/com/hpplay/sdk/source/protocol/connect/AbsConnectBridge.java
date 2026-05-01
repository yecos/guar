package com.hpplay.sdk.source.protocol.connect;

import android.text.TextUtils;
import com.hpplay.sdk.source.api.IConnectListener;
import com.hpplay.sdk.source.bean.PassBean;
import com.hpplay.sdk.source.browse.api.LelinkServiceInfo;
import com.hpplay.sdk.source.browse.data.BrowserInfo;
import com.hpplay.sdk.source.common.store.ConnectCache;
import com.hpplay.sdk.source.log.SourceLog;
import com.hpplay.sdk.source.pass.bean.BaseBean;
import com.hpplay.sdk.source.process.LelinkSdkManager;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public abstract class AbsConnectBridge {
    private static final String TAG = "AbsConnectBridge";
    private boolean isConnected;
    protected BrowserInfo mConnectBrowserInfo;
    protected String mConnectSession;
    protected LelinkServiceInfo mServiceInfo;
    protected IConnectListener mAppListener = null;
    private Map<Integer, Integer> mPassSMMap = new HashMap();
    private final Map<Object, OnPassReceivedListener> onPassReceivedListenerMap = new HashMap();
    private final Map<Object, OnPassSendCompleteListener> onPassSendCompleteListenerMap = new HashMap();

    public interface OnPassReceivedListener {
        void onPassReversed(int i10, BaseBean baseBean);
    }

    public interface OnPassSendCompleteListener {
        void onPassReversed(PassBean passBean);
    }

    private String getSinkKey() {
        String str;
        String str2;
        LelinkServiceInfo lelinkServiceInfo = this.mServiceInfo;
        if (lelinkServiceInfo != null) {
            str = String.valueOf(lelinkServiceInfo.getAppId());
            str2 = this.mServiceInfo.getUid();
        } else {
            str = "";
            str2 = "";
        }
        return str + str2;
    }

    public void addOnPassReceivedListener(Object obj, OnPassReceivedListener onPassReceivedListener) {
        if (this.onPassReceivedListenerMap.containsKey(obj)) {
            return;
        }
        this.onPassReceivedListenerMap.put(obj, onPassReceivedListener);
    }

    public void addOnPassSendCompleteListener(Object obj, OnPassSendCompleteListener onPassSendCompleteListener) {
        if (this.onPassSendCompleteListenerMap.containsKey(obj)) {
            return;
        }
        this.onPassSendCompleteListenerMap.put(obj, onPassSendCompleteListener);
    }

    public void callbackPass(PassBean passBean) {
        SourceLog.i(TAG, "callbackPass");
        if (LelinkSdkManager.getInstance().mPassCallback != null) {
            LelinkSdkManager.getInstance().mPassCallback.onSendPassCallBack(passBean);
        }
        Iterator<OnPassSendCompleteListener> it = this.onPassSendCompleteListenerMap.values().iterator();
        while (it.hasNext()) {
            it.next().onPassReversed(passBean);
        }
    }

    public void connect(LelinkServiceInfo lelinkServiceInfo) {
        this.mServiceInfo = lelinkServiceInfo;
    }

    public void disconnect(int i10) {
        this.onPassReceivedListenerMap.clear();
    }

    public String getConnectBean() {
        String sinkKey = getSinkKey();
        if (TextUtils.isEmpty(sinkKey)) {
            return null;
        }
        return ConnectCache.getInstance().get(sinkKey);
    }

    public String getConnectSession() {
        return this.mConnectSession;
    }

    public LelinkServiceInfo getServiceInfo() {
        return this.mServiceInfo;
    }

    public boolean isConnected() {
        return this.isConnected;
    }

    public boolean isSupportPassMsg(int i10) {
        String sinkKey = getSinkKey();
        if (this.mPassSMMap.size() == 0 && !TextUtils.isEmpty(sinkKey)) {
            try {
                setSinkSM(new JSONObject(ConnectCache.getInstance().get(sinkKey)).optString("sm"));
            } catch (Exception e10) {
                SourceLog.w(TAG, "isSupportPassMsg " + e10.getMessage());
            }
        }
        return this.mPassSMMap.containsKey(Integer.valueOf(i10));
    }

    public abstract boolean isSupportTrack();

    public abstract boolean isSupportUrlList();

    public void notifyPassReceivedData(int i10, BaseBean baseBean) {
        Iterator<OnPassReceivedListener> it = this.onPassReceivedListenerMap.values().iterator();
        while (it.hasNext()) {
            it.next().onPassReversed(i10, baseBean);
        }
    }

    public void release() {
    }

    public void removeOnPassReceivedListener(Object obj) {
        this.onPassReceivedListenerMap.remove(obj);
    }

    public void removeOnPassSendCompleteListener(Object obj) {
        this.onPassSendCompleteListenerMap.remove(obj);
    }

    public void saveConnectBean(String str) {
        String sinkKey = getSinkKey();
        if (TextUtils.isEmpty(sinkKey)) {
            return;
        }
        ConnectCache.getInstance().save(sinkKey, str);
    }

    public abstract void sendPassData(int i10, String str, String str2);

    public void setConnectListener(IConnectListener iConnectListener) {
        this.mAppListener = iConnectListener;
    }

    public void setConnected(boolean z10) {
        this.isConnected = z10;
    }

    public void setSinkSM(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            for (String str2 : str.split(";")) {
                String[] split = str2.split(",");
                this.mPassSMMap.put(Integer.valueOf(split[0]), Integer.valueOf(split[1]));
            }
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
        }
    }
}
