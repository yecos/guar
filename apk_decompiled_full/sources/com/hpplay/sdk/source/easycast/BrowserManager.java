package com.hpplay.sdk.source.easycast;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;
import com.hpplay.common.asyncmanager.AsyncManager;
import com.hpplay.sdk.source.api.INewPlayerListener;
import com.hpplay.sdk.source.api.LelinkPlayerInfo;
import com.hpplay.sdk.source.api.LelinkSourceSDK;
import com.hpplay.sdk.source.api.PlayerListenerConstant;
import com.hpplay.sdk.source.bean.CastBean;
import com.hpplay.sdk.source.browse.api.IServiceSelectListener;
import com.hpplay.sdk.source.browse.api.LelinkServiceInfo;
import com.hpplay.sdk.source.easycast.bean.EasyCastBean;
import com.hpplay.sdk.source.log.SourceLog;
import com.raizlabs.android.dbflow.sql.language.Operator;

/* loaded from: classes3.dex */
public class BrowserManager {
    private static final String TAG = "BrowserManager";
    private static BrowserManager sInstance;
    private IEasyCastListener mCastListener;
    private ViewGroup mContainer;
    private Context mContext;
    private BrowserController mController;
    private EasyCastBean mLastCastBean;
    private LelinkServiceInfo mLastSelectInfo;
    private String mPassword;
    private boolean useDLNA = true;
    private boolean useLelink = true;
    private boolean isPush = true;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private boolean isCastError = false;
    private int mErrorWhat = -1;
    private int mErrorExtra = -1;
    private IServiceSelectListener mSelectListener = new IServiceSelectListener() { // from class: com.hpplay.sdk.source.easycast.BrowserManager.1
        @Override // com.hpplay.sdk.source.browse.api.IServiceSelectListener
        public void onSelect(LelinkServiceInfo lelinkServiceInfo) {
            SourceLog.i(BrowserManager.TAG, "onSelect info:" + lelinkServiceInfo);
            BrowserManager.this.mLastSelectInfo = lelinkServiceInfo;
            BrowserManager.this.startPlay(lelinkServiceInfo);
        }
    };
    private INewPlayerListener mPlayerListener = new INewPlayerListener() { // from class: com.hpplay.sdk.source.easycast.BrowserManager.2
        @Override // com.hpplay.sdk.source.api.INewPlayerListener
        public void onCompletion(CastBean castBean, int i10) {
            BrowserManager browserManager = BrowserManager.this;
            if (browserManager.checkSameCast(castBean, browserManager.mLastCastBean)) {
                SourceLog.w(BrowserManager.TAG, "onCompletion ");
                BrowserManager.this.mHandler.post(new Runnable() { // from class: com.hpplay.sdk.source.easycast.BrowserManager.2.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (BrowserManager.this.mCastListener != null) {
                            BrowserManager.this.mCastListener.onCastCompletion(BrowserManager.this.mLastSelectInfo, BrowserManager.this.mLastCastBean);
                        }
                        BrowserManager browserManager2 = BrowserManager.this;
                        browserManager2.startPush(browserManager2.mLastSelectInfo);
                    }
                });
            }
        }

        @Override // com.hpplay.sdk.source.api.INewPlayerListener
        public void onError(CastBean castBean, int i10, int i11) {
            String str;
            if (i11 == -2 || i11 == 0) {
                str = "SDK认证失败";
            } else if (i11 == 210004) {
                str = "接收端不在线";
            } else if (i11 == 210011) {
                str = "网络通讯异常";
            } else {
                if (i11 == 211026) {
                    BrowserManager.this.mHandler.post(new Runnable() { // from class: com.hpplay.sdk.source.easycast.BrowserManager.2.6
                        @Override // java.lang.Runnable
                        public void run() {
                            BrowserManager.this.showPWDDialog();
                        }
                    });
                    return;
                }
                str = "未知异常";
            }
            TextUtils.isEmpty(str);
            BrowserManager.this.isCastError = true;
            BrowserManager.this.mErrorWhat = i10;
            BrowserManager.this.mErrorExtra = i11;
            SourceLog.i(BrowserManager.TAG, "onError:" + i10 + Operator.Operation.DIVISION + i11);
            BrowserManager.this.notifyError(i10, i11);
        }

        @Override // com.hpplay.sdk.source.api.INewPlayerListener
        public void onInfo(CastBean castBean, int i10, int i11) {
        }

        @Override // com.hpplay.sdk.source.api.INewPlayerListener
        public void onLoading(CastBean castBean) {
            BrowserManager browserManager = BrowserManager.this;
            if (browserManager.checkSameCast(castBean, browserManager.mLastCastBean)) {
                BrowserManager.this.isCastError = false;
                SourceLog.i(BrowserManager.TAG, "onLoading info:" + castBean);
                BrowserManager.this.destroyView();
                BrowserManager.this.mHandler.post(new Runnable() { // from class: com.hpplay.sdk.source.easycast.BrowserManager.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (BrowserManager.this.mCastListener != null) {
                            BrowserManager.this.mCastListener.onCastLoading(BrowserManager.this.mLastSelectInfo, BrowserManager.this.mLastCastBean);
                        }
                    }
                });
            }
        }

        @Override // com.hpplay.sdk.source.api.INewPlayerListener
        public void onPause(CastBean castBean) {
            BrowserManager browserManager = BrowserManager.this;
            if (browserManager.checkSameCast(castBean, browserManager.mLastCastBean)) {
                BrowserManager.this.mHandler.post(new Runnable() { // from class: com.hpplay.sdk.source.easycast.BrowserManager.2.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (BrowserManager.this.mCastListener != null) {
                            BrowserManager.this.mCastListener.onCastPause(BrowserManager.this.mLastSelectInfo, BrowserManager.this.mLastCastBean);
                        }
                    }
                });
            }
        }

        @Override // com.hpplay.sdk.source.api.INewPlayerListener
        public void onPositionUpdate(CastBean castBean, final long j10, final long j11) {
            BrowserManager browserManager = BrowserManager.this;
            if (browserManager.checkSameCast(castBean, browserManager.mLastCastBean)) {
                BrowserManager.this.mHandler.post(new Runnable() { // from class: com.hpplay.sdk.source.easycast.BrowserManager.2.7
                    @Override // java.lang.Runnable
                    public void run() {
                        if (BrowserManager.this.mCastListener != null) {
                            BrowserManager.this.mCastListener.onCastPositionUpdate(BrowserManager.this.mLastSelectInfo, BrowserManager.this.mLastCastBean, j10, j11);
                        }
                    }
                });
            }
        }

        @Override // com.hpplay.sdk.source.api.INewPlayerListener
        public void onSeekComplete(CastBean castBean, int i10) {
        }

        @Override // com.hpplay.sdk.source.api.INewPlayerListener
        public void onStart(CastBean castBean) {
            BrowserManager browserManager = BrowserManager.this;
            if (browserManager.checkSameCast(castBean, browserManager.mLastCastBean)) {
                BrowserManager.this.isCastError = false;
                SourceLog.i(BrowserManager.TAG, "onStart info:" + castBean);
                BrowserManager.this.mHandler.post(new Runnable() { // from class: com.hpplay.sdk.source.easycast.BrowserManager.2.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (BrowserManager.this.mCastListener != null) {
                            BrowserManager.this.mCastListener.onCastStart(BrowserManager.this.mLastSelectInfo, BrowserManager.this.mLastCastBean);
                        }
                    }
                });
            }
        }

        @Override // com.hpplay.sdk.source.api.INewPlayerListener
        public void onStop(CastBean castBean) {
            BrowserManager browserManager = BrowserManager.this;
            if (browserManager.checkSameCast(castBean, browserManager.mLastCastBean)) {
                SourceLog.w(BrowserManager.TAG, "onStop ");
                BrowserManager.this.mHandler.post(new Runnable() { // from class: com.hpplay.sdk.source.easycast.BrowserManager.2.5
                    @Override // java.lang.Runnable
                    public void run() {
                        if (BrowserManager.this.mCastListener != null) {
                            BrowserManager.this.mCastListener.onCastStop(BrowserManager.this.mLastSelectInfo, BrowserManager.this.mLastCastBean);
                        }
                    }
                });
            }
        }

        @Override // com.hpplay.sdk.source.api.INewPlayerListener
        public void onVolumeChanged(CastBean castBean, float f10) {
        }

        @Override // com.hpplay.sdk.source.api.INewPlayerListener
        public void onInfo(CastBean castBean, int i10, String str) {
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkSameCast(CastBean castBean, EasyCastBean easyCastBean) {
        if (castBean != null && easyCastBean != null) {
            return TextUtils.isEmpty(castBean.url) || TextUtils.equals(castBean.url, easyCastBean.url);
        }
        SourceLog.w(TAG, "checkSameCast true, but invalid input");
        return true;
    }

    public static synchronized BrowserManager getInstance() {
        synchronized (BrowserManager.class) {
            synchronized (BrowserManager.class) {
                if (sInstance == null) {
                    sInstance = new BrowserManager();
                }
            }
            return sInstance;
        }
        return sInstance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyError(int i10, int i11) {
        String str;
        String str2;
        if (this.mController != null) {
            switch (i11) {
                case 210000:
                case 210010:
                case 211000:
                case 211010:
                    str = "投屏异常";
                    str2 = "请退出后重连";
                    break;
                case 210004:
                case 210011:
                    str = "网络异常";
                    str2 = "请检查\n大屏和手机端网络后重试";
                    break;
                case PlayerListenerConstant.EXTRA_ERROR_MIRROR_SINK_UNSUPPORTED /* 211052 */:
                    str = "不支持该功能";
                    str2 = "大屏设备不支持该功能";
                    break;
                case PlayerListenerConstant.EXTRA_ERROR_MIRROR_SINK_CLOUD_UNSUPPORTED /* 211055 */:
                    str = "大屏设备版本过低";
                    str2 = "请升级大屏设备软件版本后重试";
                    break;
                default:
                    str = "服务异常 " + i11;
                    str2 = "未知错误\n请重启大屏和手机app后重试";
                    break;
            }
            SourceLog.i(TAG, "notifyError:" + str + Operator.Operation.DIVISION + str2);
            this.mController.notifyError(str, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showPWDDialog() {
        final EditText editText = new EditText(this.mContext);
        new AlertDialog.Builder(this.mContext).setTitle("请输入密码").setView(editText).setPositiveButton("确定", new DialogInterface.OnClickListener() { // from class: com.hpplay.sdk.source.easycast.BrowserManager.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i10) {
                if (TextUtils.isEmpty(editText.getText().toString())) {
                    Toast.makeText(BrowserManager.this.mContext.getApplicationContext(), "请输入密码", 1).show();
                    return;
                }
                BrowserManager.this.mPassword = editText.getText().toString();
                BrowserManager browserManager = BrowserManager.this;
                browserManager.startPlay(browserManager.mLastSelectInfo);
            }
        }).setNegativeButton("取消", (DialogInterface.OnClickListener) null).show();
    }

    private void startMirror(final LelinkServiceInfo lelinkServiceInfo) {
        if (this.mCastListener == null) {
            SourceLog.i(TAG, "startMirror ignore");
        } else {
            AsyncManager.getInstance().exeRunnable(new Runnable() { // from class: com.hpplay.sdk.source.easycast.BrowserManager.5
                @Override // java.lang.Runnable
                public void run() {
                    EasyCastBean onCast = BrowserManager.this.mCastListener.onCast(lelinkServiceInfo);
                    if (onCast == null) {
                        SourceLog.i(BrowserManager.TAG, "startMirror ignore,invalid input");
                        return;
                    }
                    SourceLog.i(BrowserManager.TAG, "startMirror ");
                    BrowserManager.this.mLastCastBean = onCast;
                    LelinkPlayerInfo lelinkPlayerInfo = new LelinkPlayerInfo();
                    lelinkPlayerInfo.setMirrorAudioEnable(onCast.mirrorAudioEnable);
                    lelinkPlayerInfo.setLelinkServiceInfo(lelinkServiceInfo);
                    LelinkSourceSDK.getInstance().setNewPlayListener(BrowserManager.this.mPlayerListener);
                    LelinkSourceSDK.getInstance().startMirror(lelinkPlayerInfo);
                }
            }, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startPlay(LelinkServiceInfo lelinkServiceInfo) {
        if (this.isPush) {
            startPush(lelinkServiceInfo);
        } else {
            startMirror(lelinkServiceInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startPush(final LelinkServiceInfo lelinkServiceInfo) {
        if (this.mCastListener == null) {
            SourceLog.i(TAG, "startPush ignore");
        } else {
            AsyncManager.getInstance().exeRunnable(new Runnable() { // from class: com.hpplay.sdk.source.easycast.BrowserManager.4
                @Override // java.lang.Runnable
                public void run() {
                    EasyCastBean onCast = BrowserManager.this.mCastListener.onCast(lelinkServiceInfo);
                    if (onCast == null) {
                        SourceLog.i(BrowserManager.TAG, "startPush ignore,invalid input");
                        return;
                    }
                    SourceLog.i(BrowserManager.TAG, "startPush");
                    BrowserManager.this.mLastCastBean = onCast;
                    LelinkPlayerInfo lelinkPlayerInfo = new LelinkPlayerInfo();
                    lelinkPlayerInfo.setUrl(onCast.url);
                    lelinkPlayerInfo.setType(onCast.type);
                    lelinkPlayerInfo.setStartPosition(onCast.startPosition);
                    if (!TextUtils.isEmpty(BrowserManager.this.mPassword)) {
                        lelinkPlayerInfo.setCastPwd(BrowserManager.this.mPassword);
                    }
                    lelinkPlayerInfo.setLelinkServiceInfo(lelinkServiceInfo);
                    LelinkSourceSDK.getInstance().setNewPlayListener(BrowserManager.this.mPlayerListener);
                    LelinkSourceSDK.getInstance().startPlayMedia(lelinkPlayerInfo);
                }
            }, null);
        }
    }

    public void destroyView() {
        this.mHandler.post(new Runnable() { // from class: com.hpplay.sdk.source.easycast.BrowserManager.6
            @Override // java.lang.Runnable
            public void run() {
                if (BrowserManager.this.mController != null) {
                    BrowserManager.this.mController.destroyView();
                }
                if (!BrowserManager.this.isCastError || BrowserManager.this.mCastListener == null) {
                    return;
                }
                BrowserManager.this.mCastListener.onCastError(BrowserManager.this.mLastSelectInfo, BrowserManager.this.mLastCastBean, BrowserManager.this.mErrorWhat, BrowserManager.this.mErrorExtra);
            }
        });
    }

    public boolean isShowing() {
        BrowserController browserController = this.mController;
        return browserController != null && browserController.isShowing();
    }

    public void setEasyCastListener(IEasyCastListener iEasyCastListener) {
        SourceLog.i(TAG, "setEasyCastListener:" + iEasyCastListener);
        this.mCastListener = iEasyCastListener;
        BrowserController browserController = this.mController;
        if (browserController != null) {
            browserController.setCastListener(iEasyCastListener);
        }
    }

    public void startBrowse() {
        startBrowse(this.useLelink, this.useDLNA, this.mContainer, this.isPush);
    }

    public void startBrowse(boolean z10, boolean z11, ViewGroup viewGroup, boolean z12) {
        this.isPush = z12;
        this.useDLNA = z11;
        this.useLelink = z10;
        this.mContext = viewGroup.getContext();
        BrowserController browserController = this.mController;
        if (browserController != null) {
            browserController.release();
            this.mController = null;
        }
        ViewGroup viewGroup2 = this.mContainer;
        if (viewGroup2 != null) {
            viewGroup2.removeAllViews();
            this.mContainer = null;
        }
        this.mContainer = viewGroup;
        if (!LelinkSourceSDK.getInstance().isBindSuccess()) {
            if (TextUtils.isEmpty(LelinkSourceSDK.getInstance().getAppID()) || TextUtils.isEmpty(LelinkSourceSDK.getInstance().getAppSecret())) {
                SourceLog.i(TAG, "startBrowse ignore, invalid init info");
                return;
            } else {
                LelinkSourceSDK.getInstance().setBindSdkListener(BrowserDevice.getInstance().getBindListener()).setBrowseResultListener(BrowserDevice.getInstance().getBrowseListener()).setConnectListener(BrowserDevice.getInstance().getConnectListener()).bindSdk();
                return;
            }
        }
        SourceLog.i(TAG, "startBrowse useLelink:" + z10 + ", useDlna:" + z11);
        LelinkSourceSDK.getInstance().setBrowseResultListener(BrowserDevice.getInstance().getBrowseListener()).setConnectListener(BrowserDevice.getInstance().getConnectListener());
        BrowserController browserController2 = new BrowserController(viewGroup, this.isPush);
        this.mController = browserController2;
        browserController2.setServiceSelectListener(this.mSelectListener);
        this.mController.setCastListener(this.mCastListener);
        this.mController.browser();
    }
}
