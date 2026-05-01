package com.hpplay.sdk.source.process;

import android.content.Context;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import com.hpplay.sdk.source.a;
import com.hpplay.sdk.source.api.ICloudMirrorPlayListener;
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
import com.hpplay.sdk.source.api.IReceiverPropertiesCallback;
import com.hpplay.sdk.source.api.IRelevantInfoListener;
import com.hpplay.sdk.source.api.ISearchBannerDataCallback;
import com.hpplay.sdk.source.api.ISendPassCallback;
import com.hpplay.sdk.source.api.ISinkKeyEventListener;
import com.hpplay.sdk.source.api.ISinkTouchEventListener;
import com.hpplay.sdk.source.api.LelinkPlayerInfo;
import com.hpplay.sdk.source.b;
import com.hpplay.sdk.source.bean.AudioFrameBean;
import com.hpplay.sdk.source.bean.CastBean;
import com.hpplay.sdk.source.bean.CommonResultBean;
import com.hpplay.sdk.source.bean.DaCastBean;
import com.hpplay.sdk.source.bean.DramaInfoBean;
import com.hpplay.sdk.source.bean.PassBean;
import com.hpplay.sdk.source.bean.ReceiverProperties;
import com.hpplay.sdk.source.bean.ServiceInfoParseBean;
import com.hpplay.sdk.source.bean.SinkTouchEventArea;
import com.hpplay.sdk.source.bean.VideoFrameBean;
import com.hpplay.sdk.source.browse.api.AuthListener;
import com.hpplay.sdk.source.browse.api.IAPI;
import com.hpplay.sdk.source.browse.api.IAPICallbackListener;
import com.hpplay.sdk.source.browse.api.IBrowseListener;
import com.hpplay.sdk.source.browse.api.ICreatePinCodeListener;
import com.hpplay.sdk.source.browse.api.ICreateShortUrlListener;
import com.hpplay.sdk.source.browse.api.IServiceInfoListParseListener;
import com.hpplay.sdk.source.browse.api.IServiceInfoParseListener;
import com.hpplay.sdk.source.browse.api.LelinkServiceInfo;
import com.hpplay.sdk.source.c;
import com.hpplay.sdk.source.d;
import com.hpplay.sdk.source.device.Device;
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
import com.hpplay.sdk.source.q;
import com.hpplay.sdk.source.r;
import com.hpplay.sdk.source.s;
import com.hpplay.sdk.source.t;
import com.hpplay.sdk.source.u;
import com.hpplay.sdk.source.utils.HpplayUtil;
import com.hpplay.sdk.source.v;
import com.hpplay.sdk.source.w;
import com.hpplay.sdk.source.x;
import com.hpplay.sdk.source.z;
import java.util.List;

/* loaded from: classes3.dex */
public class LelinkServiceBinder extends z.a {
    private static final String TAG = "LelinkServiceBinder";
    private Context mContext;
    private i mStubAVListener;
    private a mStubAuthListener;
    private b mStubBrowserListener;
    private c mStubCloudMirrorPlayListener;
    private d mStubCommonListener;
    private e mStubConnectListener;
    private h mStubDaPlayListener;
    private j mStubFavoriteDeviceListener;
    private k mStubHistoryDeviceListener;
    private l mStubLelinkPlayListener;
    private m mStubLogCallback;
    private n mStubMirrorChangeListener;
    private o mStubNewPlayListener;
    private p mStubOnlineCheckListener;
    private t mStubPassCallback;
    private q mStubReceiverPropertiesCallback;
    private r mStubRelevantListener;
    private s mStubSearchBannerDataCallback;
    private u mStubServiceInfoListParseListener;
    private v mStubServiceInfoParseListener;
    private w mStubSinkKeyEventListener;
    private x mStubSinkTouchEventListener;
    private f mSubCreatePinCodeListener;
    private g mSubCreateShortUrlListener;
    private ICreatePinCodeListener mCreatePinCodeListener = new ICreatePinCodeListener() { // from class: com.hpplay.sdk.source.process.LelinkServiceBinder.1
        @Override // com.hpplay.sdk.source.browse.api.ICreatePinCodeListener
        public void onCreatePinCode(String str) {
            if (LelinkServiceBinder.this.mSubCreatePinCodeListener != null) {
                try {
                    LelinkServiceBinder.this.mSubCreatePinCodeListener.onCreatePinCode(str);
                } catch (Exception unused) {
                    SourceLog.w(LelinkServiceBinder.TAG, "onCreatePinCode: process may be closed");
                }
            }
        }
    };
    private ICreateShortUrlListener iCreateShortUrlListener = new ICreateShortUrlListener() { // from class: com.hpplay.sdk.source.process.LelinkServiceBinder.2
        @Override // com.hpplay.sdk.source.browse.api.ICreateShortUrlListener
        public void onCreateShortUrl(String str) {
            if (LelinkServiceBinder.this.mSubCreateShortUrlListener != null) {
                try {
                    LelinkServiceBinder.this.mSubCreateShortUrlListener.onCreateShortUrl(str);
                } catch (Exception unused) {
                    SourceLog.w(LelinkServiceBinder.TAG, "onCreateShortUrl: process may be closed");
                }
            }
        }
    };
    private IBrowseListener mBrowserListener = new IBrowseListener() { // from class: com.hpplay.sdk.source.process.LelinkServiceBinder.3
        @Override // com.hpplay.sdk.source.browse.api.IBrowseListener
        public void onBrowse(int i10, List<LelinkServiceInfo> list) {
            if (LelinkServiceBinder.this.mStubBrowserListener != null) {
                try {
                    LelinkServiceBinder.this.mStubBrowserListener.onResult(i10, list);
                } catch (Exception unused) {
                    SourceLog.w(LelinkServiceBinder.TAG, "onBrowse: process may be closed");
                }
            }
        }
    };
    private IConnectListener mConnectListener = new IConnectListener() { // from class: com.hpplay.sdk.source.process.LelinkServiceBinder.4
        @Override // com.hpplay.sdk.source.api.IConnectListener
        public void onConnect(LelinkServiceInfo lelinkServiceInfo, int i10) {
            if (LelinkServiceBinder.this.mStubConnectListener != null) {
                try {
                    LelinkServiceBinder.this.mStubConnectListener.onConnect(lelinkServiceInfo, i10);
                } catch (Exception unused) {
                    SourceLog.w(LelinkServiceBinder.TAG, "onConnect: process may be closed");
                }
            }
        }

        @Override // com.hpplay.sdk.source.api.IConnectListener
        public void onDisconnect(LelinkServiceInfo lelinkServiceInfo, int i10, int i11) {
            if (LelinkServiceBinder.this.mStubConnectListener != null) {
                try {
                    LelinkServiceBinder.this.mStubConnectListener.onDisconnect(lelinkServiceInfo, i10, i11);
                } catch (Exception unused) {
                    SourceLog.w(LelinkServiceBinder.TAG, "onDisconnect: process may be closed");
                }
            }
        }
    };
    private ILelinkPlayerListener mLelinkPlayerListener = new ILelinkPlayerListener() { // from class: com.hpplay.sdk.source.process.LelinkServiceBinder.5
        @Override // com.hpplay.sdk.source.api.ILelinkPlayerListener
        public void onCompletion() {
            if (LelinkServiceBinder.this.mStubLelinkPlayListener != null) {
                try {
                    LelinkServiceBinder.this.mStubLelinkPlayListener.onCompletion();
                } catch (Exception unused) {
                    SourceLog.w(LelinkServiceBinder.TAG, "onCompletion: process may be closed");
                }
            }
        }

        @Override // com.hpplay.sdk.source.api.ILelinkPlayerListener
        public void onError(int i10, int i11) {
            if (LelinkServiceBinder.this.mStubLelinkPlayListener != null) {
                try {
                    LelinkServiceBinder.this.mStubLelinkPlayListener.onError(i10, i11);
                } catch (Exception unused) {
                    SourceLog.w(LelinkServiceBinder.TAG, "onError: process may be closed");
                }
            }
        }

        @Override // com.hpplay.sdk.source.api.ILelinkPlayerListener
        public void onInfo(int i10, int i11) {
            if (LelinkServiceBinder.this.mStubLelinkPlayListener != null) {
                try {
                    LelinkServiceBinder.this.mStubLelinkPlayListener.onInfo(i10, i11);
                } catch (Exception unused) {
                    SourceLog.w(LelinkServiceBinder.TAG, "onInfo: process may be closed");
                }
            }
        }

        @Override // com.hpplay.sdk.source.api.ILelinkPlayerListener
        public void onLoading() {
            if (LelinkServiceBinder.this.mStubLelinkPlayListener != null) {
                try {
                    LelinkServiceBinder.this.mStubLelinkPlayListener.onLoading();
                } catch (Exception unused) {
                    SourceLog.w(LelinkServiceBinder.TAG, "onLoading: process may be closed");
                }
            }
        }

        @Override // com.hpplay.sdk.source.api.ILelinkPlayerListener
        public void onPause() {
            if (LelinkServiceBinder.this.mStubLelinkPlayListener != null) {
                try {
                    LelinkServiceBinder.this.mStubLelinkPlayListener.onPause();
                } catch (Exception unused) {
                    SourceLog.w(LelinkServiceBinder.TAG, "onPause: process may be closed");
                }
            }
        }

        @Override // com.hpplay.sdk.source.api.ILelinkPlayerListener
        public void onPositionUpdate(long j10, long j11) {
            if (LelinkServiceBinder.this.mStubLelinkPlayListener != null) {
                try {
                    LelinkServiceBinder.this.mStubLelinkPlayListener.onPositionUpdate(j10, j11);
                } catch (Exception unused) {
                    SourceLog.w(LelinkServiceBinder.TAG, "onPositionUpdate: process may be closed");
                }
            }
        }

        @Override // com.hpplay.sdk.source.api.ILelinkPlayerListener
        public void onSeekComplete(int i10) {
            if (LelinkServiceBinder.this.mStubLelinkPlayListener != null) {
                try {
                    LelinkServiceBinder.this.mStubLelinkPlayListener.onSeekComplete(i10);
                } catch (Exception unused) {
                    SourceLog.w(LelinkServiceBinder.TAG, "onSeekComplete: process may be closed");
                }
            }
        }

        @Override // com.hpplay.sdk.source.api.ILelinkPlayerListener
        public void onStart() {
            if (LelinkServiceBinder.this.mStubLelinkPlayListener != null) {
                try {
                    LelinkServiceBinder.this.mStubLelinkPlayListener.onStart();
                } catch (Exception unused) {
                    SourceLog.w(LelinkServiceBinder.TAG, "onStart: process may be closed");
                }
            }
        }

        @Override // com.hpplay.sdk.source.api.ILelinkPlayerListener
        public void onStop() {
            if (LelinkServiceBinder.this.mStubLelinkPlayListener != null) {
                try {
                    LelinkServiceBinder.this.mStubLelinkPlayListener.onStop();
                } catch (Exception unused) {
                    SourceLog.w(LelinkServiceBinder.TAG, "onStop: process may be closed");
                }
            }
        }

        @Override // com.hpplay.sdk.source.api.ILelinkPlayerListener
        public void onVolumeChanged(float f10) {
            if (LelinkServiceBinder.this.mStubLelinkPlayListener != null) {
                try {
                    LelinkServiceBinder.this.mStubLelinkPlayListener.onVolumeChanged(f10);
                } catch (Exception unused) {
                    SourceLog.w(LelinkServiceBinder.TAG, "onVolumeChanged: process may be closed");
                }
            }
        }

        @Override // com.hpplay.sdk.source.api.ILelinkPlayerListener
        public void onInfo(int i10, String str) {
            if (LelinkServiceBinder.this.mStubLelinkPlayListener != null) {
                try {
                    LelinkServiceBinder.this.mStubLelinkPlayListener.onInfo2(i10, str);
                } catch (Exception unused) {
                    SourceLog.w(LelinkServiceBinder.TAG, "onInfo: process may be closed");
                }
            }
        }
    };
    private INewPlayerListener mNewPlayListener = new INewPlayerListener() { // from class: com.hpplay.sdk.source.process.LelinkServiceBinder.6
        @Override // com.hpplay.sdk.source.api.INewPlayerListener
        public void onCompletion(CastBean castBean, int i10) {
            if (LelinkServiceBinder.this.mStubNewPlayListener != null) {
                try {
                    LelinkServiceBinder.this.mStubNewPlayListener.onCompletion(castBean, i10);
                } catch (Exception unused) {
                    SourceLog.w(LelinkServiceBinder.TAG, "onCompletion: process may be closed");
                }
            }
        }

        @Override // com.hpplay.sdk.source.api.INewPlayerListener
        public void onError(CastBean castBean, int i10, int i11) {
            StringBuilder sb = new StringBuilder();
            sb.append("onError callbak ....");
            sb.append(LelinkServiceBinder.this.mStubNewPlayListener != null);
            SourceLog.i(LelinkServiceBinder.TAG, sb.toString());
            if (LelinkServiceBinder.this.mStubNewPlayListener != null) {
                try {
                    LelinkServiceBinder.this.mStubNewPlayListener.onError(castBean, i10, i11);
                } catch (Exception unused) {
                    SourceLog.w(LelinkServiceBinder.TAG, "onError: process may be closed");
                }
            }
        }

        @Override // com.hpplay.sdk.source.api.INewPlayerListener
        public void onInfo(CastBean castBean, int i10, int i11) {
            if (LelinkServiceBinder.this.mStubNewPlayListener != null) {
                try {
                    LelinkServiceBinder.this.mStubNewPlayListener.onInfo(castBean, i10, i11);
                } catch (Exception unused) {
                    SourceLog.w(LelinkServiceBinder.TAG, "onInfo: process may be closed");
                }
            }
        }

        @Override // com.hpplay.sdk.source.api.INewPlayerListener
        public void onLoading(CastBean castBean) {
            if (LelinkServiceBinder.this.mStubNewPlayListener != null) {
                try {
                    LelinkServiceBinder.this.mStubNewPlayListener.onLoading(castBean);
                } catch (Exception unused) {
                    SourceLog.w(LelinkServiceBinder.TAG, "onLoading: process may be closed");
                }
            }
        }

        @Override // com.hpplay.sdk.source.api.INewPlayerListener
        public void onPause(CastBean castBean) {
            if (LelinkServiceBinder.this.mStubNewPlayListener != null) {
                try {
                    LelinkServiceBinder.this.mStubNewPlayListener.onPause(castBean);
                } catch (Exception unused) {
                    SourceLog.w(LelinkServiceBinder.TAG, "onPause: process may be closed");
                }
            }
        }

        @Override // com.hpplay.sdk.source.api.INewPlayerListener
        public void onPositionUpdate(CastBean castBean, long j10, long j11) {
            if (LelinkServiceBinder.this.mStubNewPlayListener != null) {
                try {
                    LelinkServiceBinder.this.mStubNewPlayListener.onPositionUpdate(castBean, j10, j11);
                } catch (Exception unused) {
                    SourceLog.w(LelinkServiceBinder.TAG, "onPositionUpdate: process may be closed");
                }
            }
        }

        @Override // com.hpplay.sdk.source.api.INewPlayerListener
        public void onSeekComplete(CastBean castBean, int i10) {
            if (LelinkServiceBinder.this.mStubNewPlayListener != null) {
                try {
                    LelinkServiceBinder.this.mStubNewPlayListener.onSeekComplete(castBean, i10);
                } catch (Exception unused) {
                    SourceLog.w(LelinkServiceBinder.TAG, "onSeekComplete: process may be closed");
                }
            }
        }

        @Override // com.hpplay.sdk.source.api.INewPlayerListener
        public void onStart(CastBean castBean) {
            if (LelinkServiceBinder.this.mStubNewPlayListener != null) {
                try {
                    LelinkServiceBinder.this.mStubNewPlayListener.onStart(castBean);
                } catch (Exception unused) {
                    SourceLog.w(LelinkServiceBinder.TAG, "onStart: process may be closed");
                }
            }
        }

        @Override // com.hpplay.sdk.source.api.INewPlayerListener
        public void onStop(CastBean castBean) {
            if (LelinkServiceBinder.this.mStubNewPlayListener != null) {
                try {
                    LelinkServiceBinder.this.mStubNewPlayListener.onStop(castBean);
                } catch (Exception unused) {
                    SourceLog.w(LelinkServiceBinder.TAG, "onStop: process may be closed");
                }
            }
        }

        @Override // com.hpplay.sdk.source.api.INewPlayerListener
        public void onVolumeChanged(CastBean castBean, float f10) {
            if (LelinkServiceBinder.this.mStubNewPlayListener != null) {
                try {
                    LelinkServiceBinder.this.mStubNewPlayListener.onVolumeChanged(castBean, f10);
                } catch (Exception unused) {
                    SourceLog.w(LelinkServiceBinder.TAG, "onVolumeChanged: process may be closed");
                }
            }
        }

        @Override // com.hpplay.sdk.source.api.INewPlayerListener
        public void onInfo(CastBean castBean, int i10, String str) {
            if (LelinkServiceBinder.this.mStubNewPlayListener != null) {
                try {
                    LelinkServiceBinder.this.mStubNewPlayListener.onInfo2(castBean, i10, str);
                } catch (Exception unused) {
                    SourceLog.w(LelinkServiceBinder.TAG, "onInfo: process may be closed");
                }
            }
        }
    };
    private IDaPlayerListener mDaPlayerListener = new IDaPlayerListener() { // from class: com.hpplay.sdk.source.process.LelinkServiceBinder.7
        @Override // com.hpplay.sdk.source.api.IDaPlayerListener
        public void onLoading(DaCastBean daCastBean) {
            if (LelinkServiceBinder.this.mStubDaPlayListener != null) {
                try {
                    LelinkServiceBinder.this.mStubDaPlayListener.onLoading(daCastBean);
                } catch (Exception unused) {
                    SourceLog.w(LelinkServiceBinder.TAG, "onLoading: process may be closed");
                }
            }
        }

        @Override // com.hpplay.sdk.source.api.IDaPlayerListener
        public void onResult(DaCastBean daCastBean, boolean z10) {
            if (LelinkServiceBinder.this.mStubDaPlayListener != null) {
                try {
                    LelinkServiceBinder.this.mStubDaPlayListener.onResult(daCastBean, z10);
                } catch (Exception unused) {
                    SourceLog.w(LelinkServiceBinder.TAG, "onResult: process may be closed");
                }
            }
        }

        @Override // com.hpplay.sdk.source.api.IDaPlayerListener
        public void onStart(DaCastBean daCastBean) {
            if (LelinkServiceBinder.this.mStubDaPlayListener != null) {
                try {
                    LelinkServiceBinder.this.mStubDaPlayListener.onStart(daCastBean);
                } catch (Exception unused) {
                    SourceLog.w(LelinkServiceBinder.TAG, "onStart: process may be closed");
                }
            }
        }

        @Override // com.hpplay.sdk.source.api.IDaPlayerListener
        public void onStop(DaCastBean daCastBean) {
            if (LelinkServiceBinder.this.mStubDaPlayListener != null) {
                try {
                    LelinkServiceBinder.this.mStubDaPlayListener.onStop(daCastBean);
                } catch (Exception unused) {
                    SourceLog.w(LelinkServiceBinder.TAG, "onStop: process may be closed");
                }
            }
        }
    };
    private IDebugAVListener mAVListener = new IDebugAVListener() { // from class: com.hpplay.sdk.source.process.LelinkServiceBinder.8
        @Override // com.hpplay.sdk.source.api.IDebugAVListener
        public void onAudioCallback(long j10, int i10, int i11, int i12, byte[] bArr) {
            if (LelinkServiceBinder.this.mStubAVListener != null) {
                try {
                    LelinkServiceBinder.this.mStubAVListener.onAudioCallback(j10, i10, i11, i12, bArr);
                } catch (Exception unused) {
                    SourceLog.w(LelinkServiceBinder.TAG, "onAudioCallback: process may be closed");
                }
            }
        }

        @Override // com.hpplay.sdk.source.api.IDebugAVListener
        public void onVideoCallback(long j10, int i10, int i11, int i12, byte[] bArr) {
            if (LelinkServiceBinder.this.mStubAVListener != null) {
                try {
                    LelinkServiceBinder.this.mStubAVListener.onVideoCallback(j10, i10, i11, i12, bArr);
                } catch (Exception unused) {
                    SourceLog.w(LelinkServiceBinder.TAG, "onVideoCallback: process may be closed");
                }
            }
        }
    };
    private IServiceInfoParseListener mServiceInfoParseListener = new IServiceInfoParseListener() { // from class: com.hpplay.sdk.source.process.LelinkServiceBinder.9
        @Override // com.hpplay.sdk.source.browse.api.IServiceInfoParseListener
        public void onParseResult(int i10, LelinkServiceInfo lelinkServiceInfo) {
            if (LelinkServiceBinder.this.mStubServiceInfoParseListener != null) {
                try {
                    LelinkServiceBinder.this.mStubServiceInfoParseListener.onParseResult(i10, lelinkServiceInfo);
                } catch (Exception unused) {
                    SourceLog.w(LelinkServiceBinder.TAG, "onParseResult: process may be closed");
                }
            }
        }
    };
    private IServiceInfoListParseListener mServiceInfoListParseListener = new IServiceInfoListParseListener() { // from class: com.hpplay.sdk.source.process.LelinkServiceBinder.10
        @Override // com.hpplay.sdk.source.browse.api.IServiceInfoListParseListener
        public void onParseResult(List<ServiceInfoParseBean> list) {
            if (LelinkServiceBinder.this.mStubServiceInfoListParseListener != null) {
                try {
                    LelinkServiceBinder.this.mStubServiceInfoListParseListener.onParseResult(list);
                } catch (Exception unused) {
                    SourceLog.w(LelinkServiceBinder.TAG, "onParseResult: process may be closed");
                }
            }
        }
    };
    private ILogCallback mLogCallback = new ILogCallback() { // from class: com.hpplay.sdk.source.process.LelinkServiceBinder.11
        @Override // com.hpplay.sdk.source.api.ILogCallback
        public void onCastLog(int i10, String str) {
            if (LelinkServiceBinder.this.mStubLogCallback != null) {
                try {
                    LelinkServiceBinder.this.mStubLogCallback.onCastLog(i10, str);
                } catch (Exception unused) {
                }
            }
        }
    };
    private ISearchBannerDataCallback mSearchBannerDataCallback = new ISearchBannerDataCallback() { // from class: com.hpplay.sdk.source.process.LelinkServiceBinder.12
        @Override // com.hpplay.sdk.source.api.ISearchBannerDataCallback
        public void onBannerData(String str) {
            if (LelinkServiceBinder.this.mStubSearchBannerDataCallback != null) {
                try {
                    LelinkServiceBinder.this.mStubSearchBannerDataCallback.onBannerData(str);
                } catch (Exception e10) {
                    SourceLog.w(LelinkServiceBinder.TAG, e10);
                }
            }
        }
    };
    private ISinkKeyEventListener mSinkKeyEventListener = new ISinkKeyEventListener() { // from class: com.hpplay.sdk.source.process.LelinkServiceBinder.13
        @Override // com.hpplay.sdk.source.api.ISinkKeyEventListener
        public void onKeyEvent(KeyEvent keyEvent) {
            if (LelinkServiceBinder.this.mStubSinkKeyEventListener != null) {
                try {
                    LelinkServiceBinder.this.mStubSinkKeyEventListener.onKeyEvent(keyEvent);
                } catch (Exception unused) {
                    SourceLog.w(LelinkServiceBinder.TAG, "onKeyEvent: process may be closed");
                }
            }
        }
    };
    private ISinkTouchEventListener mSinkTouchEventListener = new ISinkTouchEventListener() { // from class: com.hpplay.sdk.source.process.LelinkServiceBinder.14
        @Override // com.hpplay.sdk.source.api.ISinkTouchEventListener
        public void onTouchEvent(MotionEvent motionEvent) {
            if (LelinkServiceBinder.this.mStubSinkTouchEventListener != null) {
                try {
                    LelinkServiceBinder.this.mStubSinkTouchEventListener.onTouchEvent(motionEvent);
                } catch (Exception unused) {
                    SourceLog.w(LelinkServiceBinder.TAG, "onTouchEvent: process may be closed");
                }
            }
        }
    };
    private ISendPassCallback mPassCallback = new ISendPassCallback() { // from class: com.hpplay.sdk.source.process.LelinkServiceBinder.15
        @Override // com.hpplay.sdk.source.api.ISendPassCallback
        public void onSendPassCallBack(PassBean passBean) {
            if (LelinkServiceBinder.this.mStubPassCallback != null) {
                try {
                    LelinkServiceBinder.this.mStubPassCallback.onSendPassCallBack(passBean);
                } catch (Exception e10) {
                    SourceLog.w(LelinkServiceBinder.TAG, e10);
                }
            }
        }
    };
    private AuthListener mAuthListener = new AuthListener() { // from class: com.hpplay.sdk.source.process.LelinkServiceBinder.16
        @Override // com.hpplay.sdk.source.browse.api.AuthListener
        public void onAuthFailed(int i10) {
            if (LelinkServiceBinder.this.mStubAuthListener != null) {
                try {
                    LelinkServiceBinder.this.mStubAuthListener.onAuthFailed(i10);
                } catch (Exception unused) {
                    SourceLog.w(LelinkServiceBinder.TAG, "onAuthFailed: process may be closed");
                }
            }
        }

        @Override // com.hpplay.sdk.source.browse.api.AuthListener
        public void onAuthSuccess(String str, String str2) {
            if (LelinkServiceBinder.this.mStubAuthListener != null) {
                try {
                    LelinkServiceBinder.this.mStubAuthListener.onAuthSuccess(str, str2);
                } catch (Exception unused) {
                    SourceLog.w(LelinkServiceBinder.TAG, "onAuthSuccess: process may be closed");
                }
            }
        }
    };
    private IRelevantInfoListener mRelevantListener = new IRelevantInfoListener() { // from class: com.hpplay.sdk.source.process.LelinkServiceBinder.17
        @Override // com.hpplay.sdk.source.api.IRelevantInfoListener
        public void onReverseInfoResult(int i10, String str) {
            super.onReverseInfoResult(i10, str);
            if (LelinkServiceBinder.this.mStubRelevantListener != null) {
                try {
                    LelinkServiceBinder.this.mStubRelevantListener.onReverseInfoResult(i10, str);
                } catch (Exception unused) {
                    SourceLog.w(LelinkServiceBinder.TAG, "onReverseInfoResult: process may be closed");
                }
            }
        }

        @Override // com.hpplay.sdk.source.api.IRelevantInfoListener
        public void onSendRelevantInfoResult(int i10, String str) {
            if (LelinkServiceBinder.this.mStubRelevantListener != null) {
                try {
                    LelinkServiceBinder.this.mStubRelevantListener.onSendRelevantInfoResult(i10, str);
                } catch (Exception unused) {
                    SourceLog.w(LelinkServiceBinder.TAG, "onSendRelevantInfoResult: process may be closed");
                }
            }
        }
    };
    private ICloudMirrorPlayListener mCloudMirrorPlayListener = new ICloudMirrorPlayListener() { // from class: com.hpplay.sdk.source.process.LelinkServiceBinder.18
        @Override // com.hpplay.sdk.source.api.ICloudMirrorPlayListener
        public void onCloudMessage(long j10, String str) {
            if (LelinkServiceBinder.this.mStubLelinkPlayListener != null) {
                try {
                    LelinkServiceBinder.this.mStubCloudMirrorPlayListener.onCloudMessage(j10, str);
                } catch (Exception unused) {
                    SourceLog.w(LelinkServiceBinder.TAG, "onCloudMessage: process may be closed");
                }
            }
        }

        @Override // com.hpplay.sdk.source.api.ICloudMirrorPlayListener
        public void onCloudMirrorStart(boolean z10, String str, String str2, String str3, String str4, String str5) {
            if (LelinkServiceBinder.this.mStubCloudMirrorPlayListener != null) {
                try {
                    LelinkServiceBinder.this.mStubCloudMirrorPlayListener.onCloudMirrorStart(z10, str, str2, str3, str4, str5);
                } catch (Exception unused) {
                    SourceLog.w(LelinkServiceBinder.TAG, "onCloudMirrorStart: process may be closed");
                }
            }
        }

        @Override // com.hpplay.sdk.source.api.ICloudMirrorPlayListener
        public void onCloudMirrorStop() {
            if (LelinkServiceBinder.this.mStubCloudMirrorPlayListener != null) {
                try {
                    LelinkServiceBinder.this.mStubCloudMirrorPlayListener.onCloudMirrorStop();
                } catch (Exception unused) {
                    SourceLog.w(LelinkServiceBinder.TAG, "onCloudMirrorStop: process may be closed");
                }
            }
        }
    };
    private IAPICallbackListener mOnlineCheckListener = new IAPICallbackListener() { // from class: com.hpplay.sdk.source.process.LelinkServiceBinder.19
        @Override // com.hpplay.sdk.source.browse.api.IAPICallbackListener
        public void onResult(int i10, Object obj) {
            if (LelinkServiceBinder.this.mStubOnlineCheckListener != null) {
                try {
                    LelinkServiceBinder.this.mStubOnlineCheckListener.onResult(i10, (List) obj);
                } catch (Exception unused) {
                    SourceLog.w(LelinkServiceBinder.TAG, "onResult: process may be closed");
                }
            }
        }
    };
    private IMirrorChangeListener mMirrorChangeListener = new IMirrorChangeListener() { // from class: com.hpplay.sdk.source.process.LelinkServiceBinder.20
        @Override // com.hpplay.sdk.source.api.IMirrorChangeListener
        public void onMirrorChange(int i10, int i11) {
            if (LelinkServiceBinder.this.mStubMirrorChangeListener != null) {
                try {
                    LelinkServiceBinder.this.mStubMirrorChangeListener.onMirrorChange(i10, i11);
                } catch (Exception unused) {
                    SourceLog.w(LelinkServiceBinder.TAG, "onMirrorChange: process may be closed");
                }
            }
        }
    };
    private ICommonListener mCommonListener = new ICommonListener() { // from class: com.hpplay.sdk.source.process.LelinkServiceBinder.21
        @Override // com.hpplay.sdk.source.api.ICommonListener
        public CommonResultBean onCallback(int i10, int i11, String str) {
            if (LelinkServiceBinder.this.mStubCommonListener == null) {
                return null;
            }
            try {
                return LelinkServiceBinder.this.mStubCommonListener.onCallback(i10, i11, str);
            } catch (Exception e10) {
                SourceLog.w(LelinkServiceBinder.TAG, e10);
                return null;
            }
        }
    };
    private IFavoriteDeviceListener mFavoriteDeviceListener = new IFavoriteDeviceListener() { // from class: com.hpplay.sdk.source.process.LelinkServiceBinder.22
        @Override // com.hpplay.sdk.source.api.IFavoriteDeviceListener
        public void onAddDevice(int i10, int i11) {
            if (LelinkServiceBinder.this.mStubFavoriteDeviceListener != null) {
                try {
                    LelinkServiceBinder.this.mStubFavoriteDeviceListener.onAddDevice(i10, i11);
                } catch (Exception e10) {
                    SourceLog.w(LelinkServiceBinder.TAG, e10.getMessage());
                }
            }
        }

        @Override // com.hpplay.sdk.source.api.IFavoriteDeviceListener
        public void onGetDeviceList(int i10, int i11, List<LelinkServiceInfo> list) {
            if (LelinkServiceBinder.this.mStubFavoriteDeviceListener != null) {
                try {
                    LelinkServiceBinder.this.mStubFavoriteDeviceListener.onGetDeviceList(i10, i11, list);
                } catch (Exception e10) {
                    SourceLog.w(LelinkServiceBinder.TAG, e10.getMessage());
                }
            }
        }

        @Override // com.hpplay.sdk.source.api.IFavoriteDeviceListener
        public void onRemoveDevice(int i10, int i11) {
            if (LelinkServiceBinder.this.mStubFavoriteDeviceListener != null) {
                try {
                    LelinkServiceBinder.this.mStubFavoriteDeviceListener.onRemoveDevice(i10, i11);
                } catch (Exception e10) {
                    SourceLog.w(LelinkServiceBinder.TAG, e10.getMessage());
                }
            }
        }

        @Override // com.hpplay.sdk.source.api.IFavoriteDeviceListener
        public void onSetDeviceAlias(int i10, int i11) {
            if (LelinkServiceBinder.this.mStubFavoriteDeviceListener != null) {
                try {
                    LelinkServiceBinder.this.mStubFavoriteDeviceListener.onSetDeviceAlias(i10, i11);
                } catch (Exception e10) {
                    SourceLog.w(LelinkServiceBinder.TAG, e10.getMessage());
                }
            }
        }
    };
    private IHistoryDeviceListener mHistoryDeviceListener = new IHistoryDeviceListener() { // from class: com.hpplay.sdk.source.process.LelinkServiceBinder.23
        @Override // com.hpplay.sdk.source.api.IHistoryDeviceListener
        public void onGetDeviceList(int i10, int i11, List<LelinkServiceInfo> list) {
            if (LelinkServiceBinder.this.mStubHistoryDeviceListener != null) {
                try {
                    LelinkServiceBinder.this.mStubHistoryDeviceListener.onGetDeviceList(i10, i11, list);
                } catch (Exception e10) {
                    SourceLog.w(LelinkServiceBinder.TAG, e10.getMessage());
                }
            }
        }

        @Override // com.hpplay.sdk.source.api.IHistoryDeviceListener
        public void onRemoveDevice(int i10, int i11) {
            if (LelinkServiceBinder.this.mStubHistoryDeviceListener != null) {
                try {
                    LelinkServiceBinder.this.mStubHistoryDeviceListener.onRemoveDevice(i10, i11);
                } catch (Exception e10) {
                    SourceLog.w(LelinkServiceBinder.TAG, e10.getMessage());
                }
            }
        }
    };
    private IReceiverPropertiesCallback mReceiverPropertiesCallback = new IReceiverPropertiesCallback() { // from class: com.hpplay.sdk.source.process.LelinkServiceBinder.24
        @Override // com.hpplay.sdk.source.api.IReceiverPropertiesCallback
        public void callback(ReceiverProperties receiverProperties) {
            if (LelinkServiceBinder.this.mStubReceiverPropertiesCallback != null) {
                try {
                    LelinkServiceBinder.this.mStubReceiverPropertiesCallback.callback(receiverProperties);
                } catch (Exception e10) {
                    SourceLog.w(LelinkServiceBinder.TAG, e10.getMessage());
                }
            }
        }
    };

    public LelinkServiceBinder(Context context) {
        this.mContext = context.getApplicationContext();
    }

    @Override // com.hpplay.sdk.source.z
    public void addFavoriteDevice(LelinkServiceInfo lelinkServiceInfo) {
        LelinkSdkManager.getInstance().addFavoriteDevice(lelinkServiceInfo);
    }

    @Override // com.hpplay.sdk.source.z
    public void addPinCodeToLelinkServiceInfo(String str) {
        LelinkSdkManager.getInstance().addPinCodeToLelinkServiceInfo(str);
    }

    @Override // com.hpplay.sdk.source.z
    public void addQRCodeToLelinkServiceInfo(String str) {
        LelinkSdkManager.getInstance().addQRCodeToLelinkServiceInfo(str);
    }

    @Override // com.hpplay.sdk.source.z
    public void addVolume() {
        LelinkSdkManager.getInstance().addVolume();
    }

    @Override // com.hpplay.sdk.source.z
    public void appendPlayList(DramaInfoBean[] dramaInfoBeanArr, int i10, int i11, int i12) {
        LelinkSdkManager.getInstance().appendPlayList(dramaInfoBeanArr, i10, i11, i12);
    }

    @Override // com.hpplay.sdk.source.z
    public void browse(boolean z10, boolean z11) {
        LelinkSdkManager.getInstance().startBrowseThread(z10, z11);
    }

    @Override // com.hpplay.sdk.source.z
    public boolean canPlayLocalMedia(LelinkServiceInfo lelinkServiceInfo) {
        return LelinkSdkManager.getInstance().canPlayLocalMedia(lelinkServiceInfo);
    }

    @Override // com.hpplay.sdk.source.z
    public boolean canPlayScreen(LelinkServiceInfo lelinkServiceInfo) {
        return LelinkSdkManager.getInstance().canPlayScreen(lelinkServiceInfo);
    }

    @Override // com.hpplay.sdk.source.z
    public void clearPlayList() {
        LelinkSdkManager.getInstance().clearPlayList();
    }

    @Override // com.hpplay.sdk.source.z
    public void connect(LelinkServiceInfo lelinkServiceInfo) {
        LelinkSdkManager.getInstance().connect(lelinkServiceInfo);
    }

    @Override // com.hpplay.sdk.source.z
    public void createPinCode() {
        Device.createPinCode(this.mCreatePinCodeListener);
    }

    @Override // com.hpplay.sdk.source.z
    public void createShortUrl() {
        Device.createShortUrl(this.iCreateShortUrlListener);
    }

    @Override // com.hpplay.sdk.source.z
    public boolean disconnect(LelinkServiceInfo lelinkServiceInfo) {
        return LelinkSdkManager.getInstance().disconnect(lelinkServiceInfo);
    }

    @Override // com.hpplay.sdk.source.z
    public List<LelinkServiceInfo> getConnectInfos() {
        return LelinkSdkManager.getInstance().getConnectInfos();
    }

    @Override // com.hpplay.sdk.source.z
    public void getFavoriteDeviceList(int i10, int i11) {
        LelinkSdkManager.getInstance().getFavoriteDeviceList(i10, i11);
    }

    @Override // com.hpplay.sdk.source.z
    public void getHistoryDeviceList(int i10, int i11) {
        LelinkSdkManager.getInstance().getHistoryDeviceList(i10, i11);
    }

    @Override // com.hpplay.sdk.source.z
    public String getOption(int i10) {
        Object option = LelinkSdkManager.getInstance().getOption(i10, new Object[0]);
        if (option == null) {
            return null;
        }
        return option.toString();
    }

    @Override // com.hpplay.sdk.source.z
    public String getSDKInfos(int i10) {
        return LelinkSdkManager.getInstance().getSDKInfos(i10);
    }

    @Override // com.hpplay.sdk.source.z
    public void initSdkWithUserId(String str, String str2, String str3, String str4, String str5) {
        LelinkSdkManager.getInstance().initSDK(this.mContext, str, str2, str3, str5, str4);
    }

    @Override // com.hpplay.sdk.source.z
    public void multiMirrorControl(boolean z10, List<LelinkServiceInfo> list) {
        LelinkSdkManager.getInstance().multiMirrorControl(z10, list);
    }

    @Override // com.hpplay.sdk.source.z
    public void multiPushControl(boolean z10, List<LelinkServiceInfo> list, String str, int i10) {
        LelinkSdkManager.getInstance().multiPushControl(z10, list, str, i10);
    }

    @Override // com.hpplay.sdk.source.z
    public void pause() {
        LelinkSdkManager.getInstance().pause();
    }

    @Override // com.hpplay.sdk.source.z
    public void removeFavoriteDevice(List<LelinkServiceInfo> list) {
        LelinkSdkManager.getInstance().removeFavoriteDevice(list);
    }

    @Override // com.hpplay.sdk.source.z
    public void removeHistoryDevice(List<LelinkServiceInfo> list, int i10) {
        LelinkSdkManager.getInstance().removeHistoryDevice(list, i10);
    }

    @Override // com.hpplay.sdk.source.z
    public void resume() {
        LelinkSdkManager.getInstance().resume();
    }

    @Override // com.hpplay.sdk.source.z
    public void seekTo(int i10) {
        LelinkSdkManager.getInstance().seekTo(i10);
    }

    @Override // com.hpplay.sdk.source.z
    public void setAuthListener(a aVar) {
        this.mStubAuthListener = aVar;
        LelinkSdkManager.getInstance().setAuthListener(this.mAuthListener);
    }

    @Override // com.hpplay.sdk.source.z
    public void setCloudMirrorPlayListener(c cVar) {
        this.mStubCloudMirrorPlayListener = cVar;
        LelinkSdkManager.getInstance().setCloudMirrorPlayListener(this.mCloudMirrorPlayListener);
    }

    @Override // com.hpplay.sdk.source.z
    public void setCommonListener(d dVar) {
        this.mStubCommonListener = dVar;
        LelinkSdkManager.getInstance().setCommonListener(this.mCommonListener);
    }

    @Override // com.hpplay.sdk.source.z
    public void setConnectStatusListener(e eVar) {
        this.mStubConnectListener = eVar;
        LelinkSdkManager.getInstance().setConnectListener(this.mConnectListener);
    }

    @Override // com.hpplay.sdk.source.z
    public void setCreatePinCodeListener(f fVar) {
        this.mSubCreatePinCodeListener = fVar;
    }

    @Override // com.hpplay.sdk.source.z
    public void setCreateShortUrlListener(g gVar) {
        this.mSubCreateShortUrlListener = gVar;
    }

    @Override // com.hpplay.sdk.source.z
    public void setDaPlayListenerListener(h hVar) {
        this.mStubDaPlayListener = hVar;
        LelinkSdkManager.getInstance().setDaPlayListener(this.mDaPlayerListener);
    }

    @Override // com.hpplay.sdk.source.z
    public void setDebugAVListener(i iVar) {
        this.mStubAVListener = iVar;
        LelinkSdkManager.getInstance().setDebugAVListener(this.mAVListener);
    }

    @Override // com.hpplay.sdk.source.z
    public void setDebugMode(boolean z10) {
        SourceLog.i(TAG, "setDebugMode," + z10);
        LelinkSdkManager.getInstance().isDebug(z10);
    }

    @Override // com.hpplay.sdk.source.z
    public void setDebugTimestamp(boolean z10) {
        LelinkSdkManager.getInstance().isDebugTimestamp(z10);
    }

    @Override // com.hpplay.sdk.source.z
    public void setFavoriteDeviceAlias(LelinkServiceInfo lelinkServiceInfo, String str) {
        LelinkSdkManager.getInstance().setFavoriteDeviceAlias(lelinkServiceInfo, str);
    }

    @Override // com.hpplay.sdk.source.z
    public void setFavoriteDeviceListener(j jVar) {
        this.mStubFavoriteDeviceListener = jVar;
        LelinkSdkManager.getInstance().setFavoriteDeviceListener(this.mFavoriteDeviceListener);
    }

    @Override // com.hpplay.sdk.source.z
    public void setHistoryDeviceListener(k kVar) {
        this.mStubHistoryDeviceListener = kVar;
        LelinkSdkManager.getInstance().setHistoryDeviceListener(this.mHistoryDeviceListener);
    }

    @Override // com.hpplay.sdk.source.z
    public void setLelinkPlayListenerListener(l lVar) {
        this.mStubLelinkPlayListener = lVar;
        LelinkSdkManager.getInstance().setPlayerListener(this.mLelinkPlayerListener);
    }

    @Override // com.hpplay.sdk.source.z
    public void setLelinkServiceInfoListener(b bVar) {
        this.mStubBrowserListener = bVar;
        LelinkSdkManager.getInstance().setBrowseListener(this.mBrowserListener);
    }

    @Override // com.hpplay.sdk.source.z
    public boolean setLelinkServiceInfoOption(int i10, LelinkServiceInfo lelinkServiceInfo) {
        switch (i10) {
            case IAPI.OPTION_35 /* 1048629 */:
            case IAPI.OPTION_37 /* 1048631 */:
            case IAPI.OPTION_63 /* 1048675 */:
            case IAPI.OPTION_QUERY_SUPPORT_MULTI_CHANNEL /* 2097159 */:
            case IAPI.OPTION_QUERY_SUPPORT_URL_LIST /* 2097160 */:
            case IAPI.OPTION_QUERY_SUPPORT_REVERSE_CONTROL /* 2097173 */:
            case IAPI.OPTION_TEMP_RESTRICT /* 2097175 */:
            case IAPI.OPTION_QUERY_SUPPORT_TRACK /* 2097177 */:
            case IAPI.OPTION_SET_RECEIVER_PROPERTY /* 2097234 */:
            case IAPI.OPTION_GET_RECEIVER_PROPERTIES /* 2097235 */:
                Object option = LelinkSdkManager.getInstance().getOption(i10, lelinkServiceInfo);
                return option != null && !TextUtils.isEmpty(option.toString()) && HpplayUtil.isDigitsOnly(option.toString()) && Integer.parseInt(option.toString()) == 0;
            default:
                return false;
        }
    }

    @Override // com.hpplay.sdk.source.z
    public void setLogCallback(m mVar) {
        this.mStubLogCallback = mVar;
        LelinkSdkManager.getInstance().setLogCallback(this.mLogCallback);
    }

    @Override // com.hpplay.sdk.source.z
    public void setMirrorChangeListener(n nVar) {
        this.mStubMirrorChangeListener = nVar;
        LelinkSdkManager.getInstance().setMirrorChangeListener(this.mMirrorChangeListener);
    }

    @Override // com.hpplay.sdk.source.z
    public void setNewPlayListenerListener(o oVar) {
        this.mStubNewPlayListener = oVar;
        LelinkSdkManager.getInstance().setNewPlayerListener(this.mNewPlayListener);
    }

    @Override // com.hpplay.sdk.source.z
    public void setOption(int i10, String[] strArr) {
        LelinkSdkManager.getInstance().setOption(i10, strArr);
    }

    @Override // com.hpplay.sdk.source.z
    public void setReceiverPropertiesCallback(q qVar) {
        this.mStubReceiverPropertiesCallback = qVar;
        LelinkSdkManager.getInstance().setReceiverPropertiesCallback(this.mReceiverPropertiesCallback);
    }

    @Override // com.hpplay.sdk.source.z
    public void setRelevantInfoListener(r rVar) {
        this.mStubRelevantListener = rVar;
        LelinkSdkManager.getInstance().setRelevantInfoListener(this.mRelevantListener);
    }

    @Override // com.hpplay.sdk.source.z
    public void setSearchBannerDataCallback(s sVar) {
        this.mStubSearchBannerDataCallback = sVar;
        LelinkSdkManager.getInstance().setSearchBannerDataCallback(this.mSearchBannerDataCallback);
    }

    @Override // com.hpplay.sdk.source.z
    public void setSendPassCallback(t tVar) {
        this.mStubPassCallback = tVar;
        LelinkSdkManager.getInstance().setPassCallback(this.mPassCallback);
    }

    @Override // com.hpplay.sdk.source.z
    public void setServiceInfoListParseListener(u uVar) {
        this.mStubServiceInfoListParseListener = uVar;
        LelinkSdkManager.getInstance().setServiceInfoListParseListener(this.mServiceInfoListParseListener);
    }

    @Override // com.hpplay.sdk.source.z
    public void setServiceInfoParseListener(v vVar) {
        this.mStubServiceInfoParseListener = vVar;
        LelinkSdkManager.getInstance().setServiceInfoParseListener(this.mServiceInfoParseListener);
    }

    @Override // com.hpplay.sdk.source.z
    public void setSinkKeyEventListener(w wVar) {
        this.mStubSinkKeyEventListener = wVar;
        LelinkSdkManager.getInstance().setSinkKeyEventListener(this.mSinkKeyEventListener);
    }

    @Override // com.hpplay.sdk.source.z
    public void setSinkTouchEventListener(SinkTouchEventArea sinkTouchEventArea, float f10, x xVar) {
        this.mStubSinkTouchEventListener = xVar;
        LelinkSdkManager.getInstance().setSinkTouchEventListener(sinkTouchEventArea, f10, this.mSinkTouchEventListener);
    }

    @Override // com.hpplay.sdk.source.z
    public void setSystemApp(boolean z10) {
        LelinkSdkManager.getInstance().setSystemApp(z10);
    }

    @Override // com.hpplay.sdk.source.z
    public void setVolume(int i10) {
        LelinkSdkManager.getInstance().setVolume(i10);
    }

    @Override // com.hpplay.sdk.source.z
    public void startMirrorForPlayerInfo(LelinkPlayerInfo lelinkPlayerInfo) {
        LelinkSdkManager.getInstance().startMirror(lelinkPlayerInfo);
    }

    @Override // com.hpplay.sdk.source.z
    public void startOnlineCheck(p pVar, List<LelinkServiceInfo> list) {
        this.mStubOnlineCheckListener = pVar;
        LelinkSdkManager.getInstance().startOnlineCheck(this.mOnlineCheckListener, list);
    }

    @Override // com.hpplay.sdk.source.z
    public void startPlayMedia(String str, int i10, boolean z10) {
        LelinkSdkManager.getInstance().startPlayMedia(null, str, i10, z10);
    }

    @Override // com.hpplay.sdk.source.z
    public void startPlayMediaForPlayerInfo(LelinkPlayerInfo lelinkPlayerInfo) {
        LelinkSdkManager.getInstance().startPlayCheck(lelinkPlayerInfo);
    }

    @Override // com.hpplay.sdk.source.z
    public void startPlayMediaImmed(LelinkServiceInfo lelinkServiceInfo, String str, int i10, boolean z10) {
        LelinkSdkManager.getInstance().startPlayMedia(lelinkServiceInfo, str, i10, z10);
    }

    @Override // com.hpplay.sdk.source.z
    public void stopBrowse() {
        LelinkSdkManager.getInstance().stopBrowseThread();
    }

    @Override // com.hpplay.sdk.source.z
    public void stopPlay() {
        LelinkSdkManager.getInstance().stopPlay();
    }

    @Override // com.hpplay.sdk.source.z
    public void subVolume() {
        LelinkSdkManager.getInstance().subVolume();
    }

    @Override // com.hpplay.sdk.source.z
    public void updateAudioData(byte[] bArr, AudioFrameBean audioFrameBean) {
        LelinkSdkManager.getInstance().updateAudioData(bArr, audioFrameBean);
    }

    @Override // com.hpplay.sdk.source.z
    public void updateVideoData(byte[] bArr, VideoFrameBean videoFrameBean) {
        LelinkSdkManager.getInstance().updateVideoData(bArr, videoFrameBean);
    }
}
