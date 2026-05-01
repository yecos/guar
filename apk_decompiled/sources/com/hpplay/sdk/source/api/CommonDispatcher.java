package com.hpplay.sdk.source.api;

import com.hpplay.sdk.source.bean.CommonResultBean;
import com.hpplay.sdk.source.bean.MirrorSinkBean;
import com.hpplay.sdk.source.browse.api.IAPI;
import com.hpplay.sdk.source.log.SourceLog;
import com.hpplay.sdk.source.transceiver.IHostStatusChangeListener;
import com.hpplay.sdk.source.transceiver.IRemoteServerListener;
import com.hpplay.sdk.source.transceiver.ISinkHostSettingChangeListener;
import com.hpplay.sdk.source.transceiver.ISinkNotifySourceCastListener;
import com.hpplay.sdk.source.transceiver.bean.RemoteServerBean;
import com.taobao.accs.common.Constants;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class CommonDispatcher implements ICommonListener {
    private static final String TAG = "CommonDispatcher";
    private ISinkHostSettingChangeListener mHostSettingChangeListener;
    private IHostStatusChangeListener mHostStatusChangeListener;
    private IRemoteServerListener mRemoteServerListener;
    private ISinkNotifySourceCastListener mSinkNotifySourceCastListener;
    private ISinkPreparedListener mSinkPreparedListener;

    private CommonResultBean dispatchHostStatusChange(int i10, String str) {
        if (this.mHostStatusChangeListener == null) {
            return null;
        }
        try {
            this.mHostStatusChangeListener.onHostChange(new JSONObject(str).optBoolean(Constants.KEY_HOST));
            return null;
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
            return null;
        }
    }

    private CommonResultBean dispatchRemoteServer(int i10, String str) {
        SourceLog.i(TAG, "dispatchRemoteServer " + str);
        if (this.mRemoteServerListener == null) {
            return null;
        }
        if (i10 == 1) {
            try {
                new JSONObject(str);
                this.mRemoteServerListener.onServerStarted(RemoteServerBean.formJson(str));
                return null;
            } catch (Exception e10) {
                SourceLog.w(TAG, e10);
                return null;
            }
        }
        if (i10 != 2) {
            return null;
        }
        try {
            this.mRemoteServerListener.onServerFailed(new JSONObject(str).optInt("error"));
            return null;
        } catch (Exception e11) {
            SourceLog.w(TAG, e11);
            return null;
        }
    }

    private CommonResultBean dispatchSinkHostSettingChange(int i10, String str) {
        SourceLog.i(TAG, "dispatchSinkHostSettingChange " + str);
        if (this.mHostSettingChangeListener == null) {
            return null;
        }
        int i11 = -1;
        try {
            JSONObject jSONObject = new JSONObject(str);
            i11 = jSONObject.optInt("value");
            jSONObject.optString("tu");
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
        }
        if (i10 == 1) {
            this.mHostSettingChangeListener.onCastSetting(i11);
            return null;
        }
        if (i10 != 2) {
            return null;
        }
        this.mHostSettingChangeListener.onReverseCastSetting(i11);
        return null;
    }

    private CommonResultBean dispatchSinkNotifySourceCast(int i10, String str) {
        if (this.mSinkNotifySourceCastListener == null) {
            return null;
        }
        try {
            this.mSinkNotifySourceCastListener.onSinkNotifySourceCast(new JSONObject(str).optInt("action"));
            return null;
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
            return null;
        }
    }

    private CommonResultBean dispatchSinkPrepared(int i10, String str) {
        SourceLog.i(TAG, "dispatchSinkPrepared " + str);
        ISinkPreparedListener iSinkPreparedListener = this.mSinkPreparedListener;
        if (iSinkPreparedListener == null || i10 != 1) {
            return null;
        }
        try {
            iSinkPreparedListener.onSinkPrepared(MirrorSinkBean.formJson(str));
            return null;
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
            return null;
        }
    }

    @Override // com.hpplay.sdk.source.api.ICommonListener
    public CommonResultBean onCallback(int i10, int i11, String str) {
        if (i10 == 1) {
            return dispatchRemoteServer(i11, str);
        }
        if (i10 == 2) {
            return dispatchSinkPrepared(i11, str);
        }
        if (i10 == 3) {
            return dispatchSinkHostSettingChange(i11, str);
        }
        if (i10 == 4) {
            return dispatchHostStatusChange(i11, str);
        }
        if (i10 != 5) {
            return null;
        }
        return dispatchSinkNotifySourceCast(i11, str);
    }

    public void setHostStatusChangeListener(IHostStatusChangeListener iHostStatusChangeListener) {
        this.mHostStatusChangeListener = iHostStatusChangeListener;
        if (iHostStatusChangeListener == null) {
            LelinkSourceSDK.getInstance().setOption(IAPI.OPTION_UNREGISTER_LISTENER_BY_COMMON, 4);
        } else {
            LelinkSourceSDK.getInstance().setOption(IAPI.OPTION_REGISTER_LISTENER_BY_COMMON, 4);
        }
    }

    public void setOnSinkPreparedListener(ISinkPreparedListener iSinkPreparedListener) {
        this.mSinkPreparedListener = iSinkPreparedListener;
        if (iSinkPreparedListener == null) {
            LelinkSourceSDK.getInstance().setOption(IAPI.OPTION_UNREGISTER_LISTENER_BY_COMMON, 2);
        } else {
            LelinkSourceSDK.getInstance().setOption(IAPI.OPTION_REGISTER_LISTENER_BY_COMMON, 2);
        }
    }

    public void setRemoteSeverListener(IRemoteServerListener iRemoteServerListener) {
        this.mRemoteServerListener = iRemoteServerListener;
        if (iRemoteServerListener == null) {
            LelinkSourceSDK.getInstance().setOption(IAPI.OPTION_UNREGISTER_LISTENER_BY_COMMON, 1);
        } else {
            LelinkSourceSDK.getInstance().setOption(IAPI.OPTION_REGISTER_LISTENER_BY_COMMON, 1);
        }
    }

    public void setSinkHostSettingChangeListener(ISinkHostSettingChangeListener iSinkHostSettingChangeListener) {
        this.mHostSettingChangeListener = iSinkHostSettingChangeListener;
        if (iSinkHostSettingChangeListener == null) {
            LelinkSourceSDK.getInstance().setOption(IAPI.OPTION_UNREGISTER_LISTENER_BY_COMMON, 3);
        } else {
            LelinkSourceSDK.getInstance().setOption(IAPI.OPTION_REGISTER_LISTENER_BY_COMMON, 3);
        }
    }

    public void setSinkNotifySourceCastListener(ISinkNotifySourceCastListener iSinkNotifySourceCastListener) {
        this.mSinkNotifySourceCastListener = iSinkNotifySourceCastListener;
        if (iSinkNotifySourceCastListener == null) {
            LelinkSourceSDK.getInstance().setOption(IAPI.OPTION_UNREGISTER_LISTENER_BY_COMMON, 5);
        } else {
            LelinkSourceSDK.getInstance().setOption(IAPI.OPTION_REGISTER_LISTENER_BY_COMMON, 5);
        }
    }
}
