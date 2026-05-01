package com.hpplay.sdk.source.process;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Process;
import android.view.KeyEvent;
import android.view.MotionEvent;
import com.hpplay.sdk.source.a;
import com.hpplay.sdk.source.api.IBindSdkListener;
import com.hpplay.sdk.source.api.ICommonListener;
import com.hpplay.sdk.source.api.IConnectListener;
import com.hpplay.sdk.source.api.IDaPlayerListener;
import com.hpplay.sdk.source.api.IDebugAVListener;
import com.hpplay.sdk.source.api.IFavoriteDeviceListener;
import com.hpplay.sdk.source.api.IHistoryDeviceListener;
import com.hpplay.sdk.source.api.ILelinkPlayerListener;
import com.hpplay.sdk.source.api.ILogCallback;
import com.hpplay.sdk.source.api.IMirrorChangeListener;
import com.hpplay.sdk.source.api.INewPlayerListener;
import com.hpplay.sdk.source.api.ISearchBannerDataCallback;
import com.hpplay.sdk.source.api.ISendPassCallback;
import com.hpplay.sdk.source.api.ISinkKeyEventListener;
import com.hpplay.sdk.source.api.ISinkTouchEventListener;
import com.hpplay.sdk.source.b;
import com.hpplay.sdk.source.bean.CastBean;
import com.hpplay.sdk.source.bean.CommonResultBean;
import com.hpplay.sdk.source.bean.DaCastBean;
import com.hpplay.sdk.source.bean.PassBean;
import com.hpplay.sdk.source.bean.ServiceInfoParseBean;
import com.hpplay.sdk.source.bean.SinkTouchEventArea;
import com.hpplay.sdk.source.browse.api.AuthListener;
import com.hpplay.sdk.source.browse.api.IAPICallbackListener;
import com.hpplay.sdk.source.browse.api.IBrowseListener;
import com.hpplay.sdk.source.browse.api.ICreatePinCodeListener;
import com.hpplay.sdk.source.browse.api.ICreateShortUrlListener;
import com.hpplay.sdk.source.browse.api.IServiceInfoListParseListener;
import com.hpplay.sdk.source.browse.api.IServiceInfoParseListener;
import com.hpplay.sdk.source.browse.api.LelinkServiceInfo;
import com.hpplay.sdk.source.common.global.Constant;
import com.hpplay.sdk.source.common.store.Session;
import com.hpplay.sdk.source.d;
import com.hpplay.sdk.source.e;
import com.hpplay.sdk.source.f;
import com.hpplay.sdk.source.g;
import com.hpplay.sdk.source.h;
import com.hpplay.sdk.source.i;
import com.hpplay.sdk.source.j;
import com.hpplay.sdk.source.k;
import com.hpplay.sdk.source.l;
import com.hpplay.sdk.source.log.SourceLog;
import com.hpplay.sdk.source.m;
import com.hpplay.sdk.source.n;
import com.hpplay.sdk.source.o;
import com.hpplay.sdk.source.p;
import com.hpplay.sdk.source.s;
import com.hpplay.sdk.source.t;
import com.hpplay.sdk.source.u;
import com.hpplay.sdk.source.utils.Feature;
import com.hpplay.sdk.source.v;
import com.hpplay.sdk.source.w;
import com.hpplay.sdk.source.x;
import com.hpplay.sdk.source.z;
import java.util.List;

/* loaded from: classes3.dex */
public class LelinkServiceConnection implements ServiceConnection {
    private static final String TAG = "LelinkServiceConnection";
    private boolean isBinded;
    private IDebugAVListener mAppAVListener;
    private AuthListener mAppAuthListener;
    private IBindSdkListener mAppBindListener;
    private IBrowseListener mAppBrowseListener;
    private ICommonListener mAppCommonListener;
    private IConnectListener mAppConnectListener;
    private IFavoriteDeviceListener mAppFavoriteDeviceListener;
    private IHistoryDeviceListener mAppHistoryDeviceListener;
    private IServiceInfoListParseListener mAppInfoListListener;
    private ILelinkPlayerListener mAppLelinkPlayerListener;
    private ILogCallback mAppLogCallback;
    private IMirrorChangeListener mAppMirrorChangeListener;
    private IAPICallbackListener mAppOnlineCheckListener;
    private IServiceInfoParseListener mAppResultListener;
    private ISinkKeyEventListener mAppSinkKeyEventListener;
    private ISinkTouchEventListener mAppSinkTouchEventListener;
    private Context mContext;
    private ICreatePinCodeListener mCreatePinCodeListener;
    private ICreateShortUrlListener mCreateShortUrlListener;
    private OnBindStatusListener mOnBindStatusListener;
    private IDaPlayerListener mOuterDaPlayListener;
    private INewPlayerListener mOuterNewPlayListener;
    private ISendPassCallback mPassCallback;
    private z mSDKInterface;
    private ISearchBannerDataCallback mSearchBannerDataCallback;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    f mAICreatePinCodeListener = new f.a() { // from class: com.hpplay.sdk.source.process.LelinkServiceConnection.1
        @Override // com.hpplay.sdk.source.f
        public void onCreatePinCode(String str) {
            if (LelinkServiceConnection.this.mCreatePinCodeListener != null) {
                LelinkServiceConnection.this.mCreatePinCodeListener.onCreatePinCode(str);
            }
        }
    };
    g mAICreateShortUrlListener = new g.a() { // from class: com.hpplay.sdk.source.process.LelinkServiceConnection.2
        @Override // com.hpplay.sdk.source.g
        public void onCreateShortUrl(String str) {
            if (LelinkServiceConnection.this.mCreateShortUrlListener != null) {
                LelinkServiceConnection.this.mCreateShortUrlListener.onCreateShortUrl(str);
            }
        }
    };
    private b mBrowseResultListener = new b.a() { // from class: com.hpplay.sdk.source.process.LelinkServiceConnection.3
        @Override // com.hpplay.sdk.source.b
        public void onResult(int i10, List<LelinkServiceInfo> list) {
            if (LelinkServiceConnection.this.mAppBrowseListener != null) {
                LelinkServiceConnection.this.mAppBrowseListener.onBrowse(i10, list);
            }
        }
    };
    private e mConnectListener = new e.a() { // from class: com.hpplay.sdk.source.process.LelinkServiceConnection.4
        @Override // com.hpplay.sdk.source.e
        public void onConnect(LelinkServiceInfo lelinkServiceInfo, int i10) {
            SourceLog.i(LelinkServiceConnection.TAG, "onConnect " + LelinkServiceConnection.this.mAppConnectListener);
            if (LelinkServiceConnection.this.mAppConnectListener != null) {
                LelinkServiceConnection.this.mAppConnectListener.onConnect(lelinkServiceInfo, i10);
            }
        }

        @Override // com.hpplay.sdk.source.e
        public void onDisconnect(LelinkServiceInfo lelinkServiceInfo, int i10, int i11) {
            SourceLog.i(LelinkServiceConnection.TAG, "onDisconnect " + LelinkServiceConnection.this.mAppConnectListener);
            if (LelinkServiceConnection.this.mAppConnectListener != null) {
                LelinkServiceConnection.this.mAppConnectListener.onDisconnect(lelinkServiceInfo, i10, i11);
            }
        }
    };
    private l mLelinkPlayerListener = new l.a() { // from class: com.hpplay.sdk.source.process.LelinkServiceConnection.5
        @Override // com.hpplay.sdk.source.l
        public void onCompletion() {
            if (LelinkServiceConnection.this.mAppLelinkPlayerListener != null) {
                LelinkServiceConnection.this.mAppLelinkPlayerListener.onCompletion();
            }
        }

        @Override // com.hpplay.sdk.source.l
        public void onError(int i10, int i11) {
            if (LelinkServiceConnection.this.mAppLelinkPlayerListener != null) {
                LelinkServiceConnection.this.mAppLelinkPlayerListener.onError(i10, i11);
            }
        }

        @Override // com.hpplay.sdk.source.l
        public void onInfo(int i10, int i11) {
            if (LelinkServiceConnection.this.mAppLelinkPlayerListener != null) {
                LelinkServiceConnection.this.mAppLelinkPlayerListener.onInfo(i10, i11);
            }
        }

        @Override // com.hpplay.sdk.source.l
        public void onInfo2(int i10, String str) {
            if (LelinkServiceConnection.this.mAppLelinkPlayerListener != null) {
                LelinkServiceConnection.this.mAppLelinkPlayerListener.onInfo(i10, str);
            }
        }

        @Override // com.hpplay.sdk.source.l
        public void onLoading() {
            if (LelinkServiceConnection.this.mAppLelinkPlayerListener != null) {
                LelinkServiceConnection.this.mAppLelinkPlayerListener.onLoading();
            }
        }

        @Override // com.hpplay.sdk.source.l
        public void onPause() {
            if (LelinkServiceConnection.this.mAppLelinkPlayerListener != null) {
                LelinkServiceConnection.this.mAppLelinkPlayerListener.onPause();
            }
        }

        @Override // com.hpplay.sdk.source.l
        public void onPositionUpdate(long j10, long j11) {
            if (LelinkServiceConnection.this.mAppLelinkPlayerListener != null) {
                LelinkServiceConnection.this.mAppLelinkPlayerListener.onPositionUpdate(j10, j11);
            }
        }

        @Override // com.hpplay.sdk.source.l
        public void onSeekComplete(int i10) {
            if (LelinkServiceConnection.this.mAppLelinkPlayerListener != null) {
                LelinkServiceConnection.this.mAppLelinkPlayerListener.onSeekComplete(i10);
            }
        }

        @Override // com.hpplay.sdk.source.l
        public void onStart() {
            if (LelinkServiceConnection.this.mAppLelinkPlayerListener != null) {
                LelinkServiceConnection.this.mAppLelinkPlayerListener.onStart();
            }
        }

        @Override // com.hpplay.sdk.source.l
        public void onStop() {
            if (LelinkServiceConnection.this.mAppLelinkPlayerListener != null) {
                LelinkServiceConnection.this.mAppLelinkPlayerListener.onStop();
            }
        }

        @Override // com.hpplay.sdk.source.l
        public void onVolumeChanged(float f10) {
            if (LelinkServiceConnection.this.mAppLelinkPlayerListener != null) {
                LelinkServiceConnection.this.mAppLelinkPlayerListener.onVolumeChanged(f10);
            }
        }
    };
    private o mNewPlayListener = new o.a() { // from class: com.hpplay.sdk.source.process.LelinkServiceConnection.6
        @Override // com.hpplay.sdk.source.o
        public void onCompletion(CastBean castBean, int i10) {
            if (LelinkServiceConnection.this.mOuterNewPlayListener != null) {
                LelinkServiceConnection.this.mOuterNewPlayListener.onCompletion(castBean, i10);
            }
        }

        @Override // com.hpplay.sdk.source.o
        public void onError(CastBean castBean, int i10, int i11) {
            SourceLog.i(LelinkServiceConnection.TAG, " callback onError " + i10 + "  extra : " + i11);
            if (LelinkServiceConnection.this.mOuterNewPlayListener != null) {
                LelinkServiceConnection.this.mOuterNewPlayListener.onError(castBean, i10, i11);
            }
        }

        @Override // com.hpplay.sdk.source.o
        public void onInfo(CastBean castBean, int i10, int i11) {
            if (LelinkServiceConnection.this.mOuterNewPlayListener != null) {
                LelinkServiceConnection.this.mOuterNewPlayListener.onInfo(castBean, i10, i11);
            }
        }

        @Override // com.hpplay.sdk.source.o
        public void onInfo2(CastBean castBean, int i10, String str) {
            if (LelinkServiceConnection.this.mOuterNewPlayListener != null) {
                LelinkServiceConnection.this.mOuterNewPlayListener.onInfo(castBean, i10, str);
            }
        }

        @Override // com.hpplay.sdk.source.o
        public void onLoading(CastBean castBean) {
            if (LelinkServiceConnection.this.mOuterNewPlayListener != null) {
                LelinkServiceConnection.this.mOuterNewPlayListener.onLoading(castBean);
            }
        }

        @Override // com.hpplay.sdk.source.o
        public void onPause(CastBean castBean) {
            if (LelinkServiceConnection.this.mOuterNewPlayListener != null) {
                LelinkServiceConnection.this.mOuterNewPlayListener.onPause(castBean);
            }
        }

        @Override // com.hpplay.sdk.source.o
        public void onPositionUpdate(CastBean castBean, long j10, long j11) {
            if (LelinkServiceConnection.this.mOuterNewPlayListener != null) {
                LelinkServiceConnection.this.mOuterNewPlayListener.onPositionUpdate(castBean, j10, j11);
            }
        }

        @Override // com.hpplay.sdk.source.o
        public void onSeekComplete(CastBean castBean, int i10) {
            if (LelinkServiceConnection.this.mOuterNewPlayListener != null) {
                LelinkServiceConnection.this.mOuterNewPlayListener.onSeekComplete(castBean, i10);
            }
        }

        @Override // com.hpplay.sdk.source.o
        public void onStart(CastBean castBean) {
            if (LelinkServiceConnection.this.mOuterNewPlayListener != null) {
                LelinkServiceConnection.this.mOuterNewPlayListener.onStart(castBean);
            }
        }

        @Override // com.hpplay.sdk.source.o
        public void onStop(CastBean castBean) {
            if (LelinkServiceConnection.this.mOuterNewPlayListener != null) {
                LelinkServiceConnection.this.mOuterNewPlayListener.onStop(castBean);
            }
        }

        @Override // com.hpplay.sdk.source.o
        public void onVolumeChanged(CastBean castBean, float f10) {
            if (LelinkServiceConnection.this.mOuterNewPlayListener != null) {
                LelinkServiceConnection.this.mOuterNewPlayListener.onVolumeChanged(castBean, f10);
            }
        }
    };
    private h mDaPlayListener = new h.a() { // from class: com.hpplay.sdk.source.process.LelinkServiceConnection.7
        @Override // com.hpplay.sdk.source.h
        public void onLoading(DaCastBean daCastBean) {
            if (LelinkServiceConnection.this.mOuterDaPlayListener != null) {
                LelinkServiceConnection.this.mOuterDaPlayListener.onLoading(daCastBean);
            }
        }

        @Override // com.hpplay.sdk.source.h
        public void onResult(DaCastBean daCastBean, boolean z10) {
            if (LelinkServiceConnection.this.mOuterDaPlayListener != null) {
                LelinkServiceConnection.this.mOuterDaPlayListener.onResult(daCastBean, z10);
            }
        }

        @Override // com.hpplay.sdk.source.h
        public void onStart(DaCastBean daCastBean) {
            if (LelinkServiceConnection.this.mOuterDaPlayListener != null) {
                LelinkServiceConnection.this.mOuterDaPlayListener.onStart(daCastBean);
            }
        }

        @Override // com.hpplay.sdk.source.h
        public void onStop(DaCastBean daCastBean) {
            if (LelinkServiceConnection.this.mOuterDaPlayListener != null) {
                LelinkServiceConnection.this.mOuterDaPlayListener.onStop(daCastBean);
            }
        }
    };
    private a mAuthListener = new a.AbstractBinderC0123a() { // from class: com.hpplay.sdk.source.process.LelinkServiceConnection.8
        @Override // com.hpplay.sdk.source.a
        public void onAuthFailed(int i10) {
            if (LelinkServiceConnection.this.mAppAuthListener != null) {
                LelinkServiceConnection.this.mAppAuthListener.onAuthFailed(i10);
            }
            Feature.isAuthFailedBrowse();
            LelinkServiceConnection.this.callbackBindSuccess();
        }

        @Override // com.hpplay.sdk.source.a
        public void onAuthSuccess(String str, String str2) {
            SourceLog.i(LelinkServiceConnection.TAG, " onAuthSuccess success " + LelinkServiceConnection.this.isBinded);
            if (LelinkServiceConnection.this.mAppAuthListener != null) {
                LelinkServiceConnection.this.mAppAuthListener.onAuthSuccess(str, str2);
            }
            LelinkServiceConnection.this.callbackBindSuccess();
        }
    };
    private i mAVListener = new i.a() { // from class: com.hpplay.sdk.source.process.LelinkServiceConnection.9
        @Override // com.hpplay.sdk.source.i
        public void onAudioCallback(long j10, int i10, int i11, int i12, byte[] bArr) {
            if (LelinkServiceConnection.this.mAppAVListener != null) {
                LelinkServiceConnection.this.mAppAVListener.onAudioCallback(j10, i10, i11, i12, bArr);
            }
        }

        @Override // com.hpplay.sdk.source.i
        public void onVideoCallback(long j10, int i10, int i11, int i12, byte[] bArr) {
            if (LelinkServiceConnection.this.mAppAVListener != null) {
                LelinkServiceConnection.this.mAppAVListener.onVideoCallback(j10, i10, i11, i12, bArr);
            }
        }
    };
    private v mResultListener = new v.a() { // from class: com.hpplay.sdk.source.process.LelinkServiceConnection.10
        @Override // com.hpplay.sdk.source.v
        public void onParseResult(int i10, LelinkServiceInfo lelinkServiceInfo) {
            if (LelinkServiceConnection.this.mAppResultListener != null) {
                LelinkServiceConnection.this.mAppResultListener.onParseResult(i10, lelinkServiceInfo);
            }
        }
    };
    private u mInfoListListener = new u.a() { // from class: com.hpplay.sdk.source.process.LelinkServiceConnection.11
        @Override // com.hpplay.sdk.source.u
        public void onParseResult(List<ServiceInfoParseBean> list) {
            if (LelinkServiceConnection.this.mAppInfoListListener != null) {
                LelinkServiceConnection.this.mAppInfoListListener.onParseResult(list);
            }
        }
    };
    private m mLogCallback = new m.a() { // from class: com.hpplay.sdk.source.process.LelinkServiceConnection.12
        @Override // com.hpplay.sdk.source.m
        public void onCastLog(int i10, String str) {
            if (LelinkServiceConnection.this.mAppLogCallback != null) {
                LelinkServiceConnection.this.mAppLogCallback.onCastLog(i10, str);
            }
        }
    };
    private s mAISearchBannerDataCallback = new s.a() { // from class: com.hpplay.sdk.source.process.LelinkServiceConnection.13
        @Override // com.hpplay.sdk.source.s
        public void onBannerData(String str) {
            if (LelinkServiceConnection.this.mSearchBannerDataCallback != null) {
                LelinkServiceConnection.this.mSearchBannerDataCallback.onBannerData(str);
            }
        }
    };
    private w mSinkKeyEventListener = new w.a() { // from class: com.hpplay.sdk.source.process.LelinkServiceConnection.14
        @Override // com.hpplay.sdk.source.w
        public void onKeyEvent(final KeyEvent keyEvent) {
            if (LelinkServiceConnection.this.mAppSinkKeyEventListener != null) {
                try {
                    LelinkServiceConnection.this.mHandler.post(new Runnable() { // from class: com.hpplay.sdk.source.process.LelinkServiceConnection.14.1
                        @Override // java.lang.Runnable
                        public void run() {
                            LelinkServiceConnection.this.mAppSinkKeyEventListener.onKeyEvent(keyEvent);
                        }
                    });
                } catch (Exception e10) {
                    SourceLog.w(LelinkServiceConnection.TAG, e10);
                }
            }
        }
    };
    private x mSinkTouchEventListener = new x.a() { // from class: com.hpplay.sdk.source.process.LelinkServiceConnection.15
        @Override // com.hpplay.sdk.source.x
        public void onTouchEvent(final MotionEvent motionEvent) {
            if (LelinkServiceConnection.this.mAppSinkTouchEventListener != null) {
                try {
                    LelinkServiceConnection.this.mHandler.post(new Runnable() { // from class: com.hpplay.sdk.source.process.LelinkServiceConnection.15.1
                        @Override // java.lang.Runnable
                        public void run() {
                            LelinkServiceConnection.this.mAppSinkTouchEventListener.onTouchEvent(motionEvent);
                        }
                    });
                } catch (Exception e10) {
                    SourceLog.w(LelinkServiceConnection.TAG, e10);
                }
            }
        }
    };
    private t mAIPassCallback = new t.a() { // from class: com.hpplay.sdk.source.process.LelinkServiceConnection.16
        @Override // com.hpplay.sdk.source.t
        public void onSendPassCallBack(PassBean passBean) {
            if (LelinkServiceConnection.this.mPassCallback != null) {
                LelinkServiceConnection.this.mPassCallback.onSendPassCallBack(passBean);
            }
        }
    };
    public p mOnlineCheckListener = new p.a() { // from class: com.hpplay.sdk.source.process.LelinkServiceConnection.17
        @Override // com.hpplay.sdk.source.p
        public void onResult(int i10, List<LelinkServiceInfo> list) {
            if (LelinkServiceConnection.this.mAppOnlineCheckListener != null) {
                LelinkServiceConnection.this.mAppOnlineCheckListener.onResult(i10, list);
            }
        }
    };
    private n mMirrorChangeListener = new n.a() { // from class: com.hpplay.sdk.source.process.LelinkServiceConnection.18
        @Override // com.hpplay.sdk.source.n
        public void onMirrorChange(int i10, int i11) {
            if (LelinkServiceConnection.this.mAppMirrorChangeListener != null) {
                LelinkServiceConnection.this.mAppMirrorChangeListener.onMirrorChange(i10, i11);
            }
        }
    };
    private d mCommonListener = new d.a() { // from class: com.hpplay.sdk.source.process.LelinkServiceConnection.19
        @Override // com.hpplay.sdk.source.d
        public CommonResultBean onCallback(int i10, int i11, String str) {
            if (LelinkServiceConnection.this.mAppCommonListener != null) {
                return LelinkServiceConnection.this.mAppCommonListener.onCallback(i10, i11, str);
            }
            return null;
        }
    };
    private j mFavoriteDeviceListener = new j.a() { // from class: com.hpplay.sdk.source.process.LelinkServiceConnection.20
        @Override // com.hpplay.sdk.source.j
        public void onAddDevice(int i10, int i11) {
            if (LelinkServiceConnection.this.mAppFavoriteDeviceListener != null) {
                LelinkServiceConnection.this.mAppFavoriteDeviceListener.onAddDevice(i10, i11);
            }
        }

        @Override // com.hpplay.sdk.source.j
        public void onGetDeviceList(int i10, int i11, List<LelinkServiceInfo> list) {
            if (LelinkServiceConnection.this.mAppFavoriteDeviceListener != null) {
                LelinkServiceConnection.this.mAppFavoriteDeviceListener.onGetDeviceList(i10, i11, list);
            }
        }

        @Override // com.hpplay.sdk.source.j
        public void onRemoveDevice(int i10, int i11) {
            if (LelinkServiceConnection.this.mAppFavoriteDeviceListener != null) {
                LelinkServiceConnection.this.mAppFavoriteDeviceListener.onRemoveDevice(i10, i11);
            }
        }

        @Override // com.hpplay.sdk.source.j
        public void onSetDeviceAlias(int i10, int i11) {
            if (LelinkServiceConnection.this.mAppFavoriteDeviceListener != null) {
                LelinkServiceConnection.this.mAppFavoriteDeviceListener.onSetDeviceAlias(i10, i11);
            }
        }
    };
    private k mHistoryDeviceListener = new k.a() { // from class: com.hpplay.sdk.source.process.LelinkServiceConnection.21
        @Override // com.hpplay.sdk.source.k
        public void onGetDeviceList(int i10, int i11, List<LelinkServiceInfo> list) {
            if (LelinkServiceConnection.this.mAppHistoryDeviceListener != null) {
                LelinkServiceConnection.this.mAppHistoryDeviceListener.onGetDeviceList(i10, i11, list);
            }
        }

        @Override // com.hpplay.sdk.source.k
        public void onRemoveDevice(int i10, int i11) {
            if (LelinkServiceConnection.this.mAppHistoryDeviceListener != null) {
                LelinkServiceConnection.this.mAppHistoryDeviceListener.onRemoveDevice(i10, i11);
            }
        }
    };

    public interface OnBindStatusListener {
        void onServiceConnected(z zVar);

        void onServiceDisconnected();
    }

    public LelinkServiceConnection(Context context, OnBindStatusListener onBindStatusListener) {
        this.isBinded = false;
        try {
            this.isBinded = false;
            this.mContext = context;
            this.mOnBindStatusListener = onBindStatusListener;
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
        }
    }

    private void callbackBindFailed() {
        SourceLog.w(TAG, "callbackBindFailed");
        this.isBinded = false;
        IBindSdkListener iBindSdkListener = this.mAppBindListener;
        if (iBindSdkListener != null) {
            iBindSdkListener.onBindCallback(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callbackBindSuccess() {
        SourceLog.w(TAG, "callbackBindSuccess");
        IBindSdkListener iBindSdkListener = this.mAppBindListener;
        if (iBindSdkListener != null && !this.isBinded) {
            this.isBinded = true;
            iBindSdkListener.onBindCallback(true);
        } else {
            SourceLog.w(TAG, "callbackBindSuccess ignore " + this.isBinded);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        boolean z10;
        SourceLog.i(TAG, "onServiceConnected");
        z asInterface = z.a.asInterface(iBinder);
        this.mSDKInterface = asInterface;
        if (asInterface != null) {
            try {
                Session session = Session.getInstance();
                asInterface.initSdkWithUserId(session.appKey, session.appSecret, session.userID, session.appVersion, session.oaID);
                OnBindStatusListener onBindStatusListener = this.mOnBindStatusListener;
                if (onBindStatusListener != null) {
                    onBindStatusListener.onServiceConnected(asInterface);
                }
                if (this.mAppBrowseListener != null) {
                    asInterface.setLelinkServiceInfoListener(this.mBrowseResultListener);
                }
                if (this.mAppConnectListener != null) {
                    asInterface.setConnectStatusListener(this.mConnectListener);
                }
                if (this.mAppLelinkPlayerListener != null) {
                    asInterface.setLelinkPlayListenerListener(this.mLelinkPlayerListener);
                }
                if (this.mAppAuthListener != null) {
                    asInterface.setAuthListener(this.mAuthListener);
                }
                if (this.mAppResultListener != null) {
                    asInterface.setServiceInfoParseListener(this.mResultListener);
                }
                if (this.mCreatePinCodeListener != null) {
                    asInterface.setCreatePinCodeListener(this.mAICreatePinCodeListener);
                }
                if (this.mCreateShortUrlListener != null) {
                    asInterface.setCreateShortUrlListener(this.mAICreateShortUrlListener);
                }
                if (this.mAppAVListener != null) {
                    asInterface.setDebugAVListener(this.mAVListener);
                }
                if (this.mAppLogCallback != null) {
                    asInterface.setLogCallback(this.mLogCallback);
                }
            } catch (Exception e10) {
                SourceLog.w(TAG, e10);
            }
            z10 = true;
        } else {
            SourceLog.w(TAG, "onServiceConnected invalid sdkInterface");
            z10 = false;
        }
        if (z10) {
            callbackBindSuccess();
        } else {
            callbackBindFailed();
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        SourceLog.i(TAG, "onServiceDisconnected");
        this.isBinded = false;
        OnBindStatusListener onBindStatusListener = this.mOnBindStatusListener;
        if (onBindStatusListener != null) {
            onBindStatusListener.onServiceDisconnected();
        }
        callbackBindFailed();
    }

    public void setAICreatePinCodeListener(ICreatePinCodeListener iCreatePinCodeListener) {
        this.mCreatePinCodeListener = iCreatePinCodeListener;
    }

    public void setAICreateShortUrlListener(ICreateShortUrlListener iCreateShortUrlListener) {
        this.mCreateShortUrlListener = iCreateShortUrlListener;
    }

    public void setAuthListener(AuthListener authListener) {
        this.mAppAuthListener = authListener;
        z zVar = this.mSDKInterface;
        if (zVar != null) {
            try {
                zVar.setAuthListener(this.mAuthListener);
            } catch (Exception unused) {
                SourceLog.w(TAG, "setAuthListener: process may be closed");
            }
        }
    }

    public void setBindListener(IBindSdkListener iBindSdkListener) {
        this.mAppBindListener = iBindSdkListener;
    }

    public void setBrowseResultListener(IBrowseListener iBrowseListener) {
        this.mAppBrowseListener = iBrowseListener;
        z zVar = this.mSDKInterface;
        if (zVar != null) {
            try {
                zVar.setLelinkServiceInfoListener(this.mBrowseResultListener);
            } catch (Exception unused) {
                SourceLog.w(TAG, "setBrowseResultListener: process may be closed");
            }
        }
    }

    public void setCommonListener(ICommonListener iCommonListener) {
        this.mAppCommonListener = iCommonListener;
        z zVar = this.mSDKInterface;
        if (zVar != null) {
            try {
                zVar.setCommonListener(this.mCommonListener);
            } catch (Exception e10) {
                SourceLog.w(TAG, e10);
            }
        }
    }

    public void setConnectListener(IConnectListener iConnectListener) {
        this.mAppConnectListener = iConnectListener;
        z zVar = this.mSDKInterface;
        if (zVar != null) {
            try {
                zVar.setConnectStatusListener(this.mConnectListener);
            } catch (Exception unused) {
                SourceLog.w(TAG, "setConnectListener: process may be closed");
            }
        }
    }

    public void setDaPlayListener(IDaPlayerListener iDaPlayerListener) {
        this.mOuterDaPlayListener = iDaPlayerListener;
        z zVar = this.mSDKInterface;
        if (zVar != null) {
            try {
                zVar.setDaPlayListenerListener(this.mDaPlayListener);
            } catch (Exception unused) {
                SourceLog.w(TAG, "setNewPlayListener: process may be closed");
            }
        }
    }

    public void setDebugAVListener(IDebugAVListener iDebugAVListener) {
        this.mAppAVListener = iDebugAVListener;
        z zVar = this.mSDKInterface;
        if (zVar != null) {
            try {
                zVar.setDebugAVListener(this.mAVListener);
            } catch (Exception unused) {
                SourceLog.w(TAG, "setDebugAVListener: process may be closed");
            }
        }
    }

    public void setDebugMode(boolean z10) {
        SourceLog.i(TAG, "setDebugMode," + z10);
        z zVar = this.mSDKInterface;
        if (zVar != null) {
            try {
                zVar.setDebugMode(z10);
            } catch (Exception e10) {
                SourceLog.w(TAG, e10);
            }
        }
    }

    public void setDebugTimestamp(boolean z10) {
        SourceLog.i(TAG, "setDebugTimestamp," + z10);
        z zVar = this.mSDKInterface;
        if (zVar != null) {
            try {
                zVar.setDebugTimestamp(z10);
            } catch (Exception e10) {
                SourceLog.w(TAG, e10);
            }
        }
    }

    public void setFavoriteDeviceListener(IFavoriteDeviceListener iFavoriteDeviceListener) {
        this.mAppFavoriteDeviceListener = iFavoriteDeviceListener;
        z zVar = this.mSDKInterface;
        if (zVar != null) {
            try {
                zVar.setFavoriteDeviceListener(this.mFavoriteDeviceListener);
            } catch (Exception e10) {
                SourceLog.w(TAG, e10);
            }
        }
    }

    public void setHistoryDeviceListener(IHistoryDeviceListener iHistoryDeviceListener) {
        this.mAppHistoryDeviceListener = iHistoryDeviceListener;
        z zVar = this.mSDKInterface;
        if (zVar != null) {
            try {
                zVar.setHistoryDeviceListener(this.mHistoryDeviceListener);
            } catch (Exception e10) {
                SourceLog.w(TAG, e10);
            }
        }
    }

    public void setLogCallback(ILogCallback iLogCallback) {
        this.mAppLogCallback = iLogCallback;
        z zVar = this.mSDKInterface;
        if (zVar != null) {
            try {
                zVar.setLogCallback(this.mLogCallback);
            } catch (Exception unused) {
                SourceLog.w(TAG, "setLogCallback: process may be closed");
            }
        }
    }

    public void setMirrorChangeListener(IMirrorChangeListener iMirrorChangeListener) {
        this.mAppMirrorChangeListener = iMirrorChangeListener;
        z zVar = this.mSDKInterface;
        if (zVar != null) {
            try {
                zVar.setMirrorChangeListener(this.mMirrorChangeListener);
            } catch (Exception unused) {
                SourceLog.w(TAG, "setMirrorChangeListener: process may be closed");
            }
        }
    }

    public void setNewPlayListener(INewPlayerListener iNewPlayerListener) {
        this.mOuterNewPlayListener = iNewPlayerListener;
        z zVar = this.mSDKInterface;
        if (zVar != null) {
            try {
                zVar.setNewPlayListenerListener(this.mNewPlayListener);
            } catch (Exception unused) {
                SourceLog.w(TAG, "setNewPlayListener: process may be closed");
            }
        }
    }

    public void setOnlineCheckListener(IAPICallbackListener iAPICallbackListener) {
        this.mAppOnlineCheckListener = iAPICallbackListener;
    }

    public void setPassCallback(ISendPassCallback iSendPassCallback) {
        this.mPassCallback = iSendPassCallback;
        z zVar = this.mSDKInterface;
        if (zVar != null) {
            try {
                zVar.setSendPassCallback(this.mAIPassCallback);
            } catch (Exception e10) {
                SourceLog.w(TAG, e10);
            }
        }
    }

    public void setPlayListener(ILelinkPlayerListener iLelinkPlayerListener) {
        this.mAppLelinkPlayerListener = iLelinkPlayerListener;
        z zVar = this.mSDKInterface;
        if (zVar != null) {
            try {
                zVar.setLelinkPlayListenerListener(this.mLelinkPlayerListener);
            } catch (Exception unused) {
                SourceLog.w(TAG, "setPlayListener: process may be closed");
            }
        }
    }

    public void setSearchBannerDataCallback(ISearchBannerDataCallback iSearchBannerDataCallback) {
        this.mSearchBannerDataCallback = iSearchBannerDataCallback;
        z zVar = this.mSDKInterface;
        if (zVar != null) {
            try {
                zVar.setSearchBannerDataCallback(this.mAISearchBannerDataCallback);
            } catch (Exception e10) {
                SourceLog.w(TAG, e10);
            }
        }
    }

    public void setServiceInfoListParseListener(IServiceInfoListParseListener iServiceInfoListParseListener) {
        this.mAppInfoListListener = iServiceInfoListParseListener;
        z zVar = this.mSDKInterface;
        if (zVar != null) {
            try {
                zVar.setServiceInfoListParseListener(this.mInfoListListener);
            } catch (Exception unused) {
                SourceLog.w(TAG, "setServiceInfoParseListener: process may be closed");
            }
        }
    }

    public void setServiceInfoParseListener(IServiceInfoParseListener iServiceInfoParseListener) {
        this.mAppResultListener = iServiceInfoParseListener;
        z zVar = this.mSDKInterface;
        if (zVar != null) {
            try {
                zVar.setServiceInfoParseListener(this.mResultListener);
            } catch (Exception unused) {
                SourceLog.w(TAG, "setServiceInfoParseListener: process may be closed");
            }
        }
    }

    public void setSinkKeyEventListener(ISinkKeyEventListener iSinkKeyEventListener) {
        this.mAppSinkKeyEventListener = iSinkKeyEventListener;
        z zVar = this.mSDKInterface;
        if (zVar != null) {
            try {
                zVar.setSinkKeyEventListener(this.mSinkKeyEventListener);
            } catch (Exception unused) {
                SourceLog.w(TAG, "setSinkKeyEventListener: process may be closed");
            }
        }
    }

    public void setSinkTouchEventListener(SinkTouchEventArea sinkTouchEventArea, float f10, ISinkTouchEventListener iSinkTouchEventListener) {
        this.mAppSinkTouchEventListener = iSinkTouchEventListener;
        z zVar = this.mSDKInterface;
        if (zVar != null) {
            try {
                zVar.setSinkTouchEventListener(sinkTouchEventArea, f10, this.mSinkTouchEventListener);
            } catch (Exception unused) {
                SourceLog.w(TAG, "setSinkTouchEventListener: process may be closed");
            }
        }
    }

    public void startBind() {
        try {
            this.mContext.bindService(new Intent(this.mContext, (Class<?>) LelinkSdkService.class), this, 1);
            SourceLog.i(TAG, "startBind");
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
        }
    }

    public void unBind() {
        Context context = this.mContext;
        if (context != null) {
            try {
                context.unbindService(this);
            } catch (Exception unused) {
            }
            try {
                int i10 = this.mContext.getSharedPreferences(Constant.KEY_PROCESS_PID, 4).getInt(Constant.KEY_PROCESS_PID, 0);
                if (i10 > 0 && i10 != Process.myPid()) {
                    Process.killProcess(i10);
                }
                if (Feature.isNubiaChannel()) {
                    this.mContext.stopService(new Intent(this.mContext, (Class<?>) LelinkSdkService.class));
                }
                this.mSDKInterface = null;
                SourceLog.i(TAG, "unBind " + i10);
            } catch (Exception e10) {
                SourceLog.w(TAG, e10);
            }
            this.mSDKInterface = null;
        }
    }
}
