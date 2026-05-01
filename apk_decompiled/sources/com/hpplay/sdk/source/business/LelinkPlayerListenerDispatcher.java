package com.hpplay.sdk.source.business;

import android.text.TextUtils;
import com.hpplay.sdk.source.api.IDaPlayerListener;
import com.hpplay.sdk.source.api.ILelinkPlayerListener;
import com.hpplay.sdk.source.api.INewPlayerListener;
import com.hpplay.sdk.source.bean.CastBean;
import com.hpplay.sdk.source.bean.DaCastBean;
import com.hpplay.sdk.source.bean.OutParameter;
import com.hpplay.sdk.source.log.SourceLog;
import com.hpplay.sdk.source.process.ConnectManager;
import com.hpplay.sdk.source.utils.CastUtil;
import com.raizlabs.android.dbflow.sql.language.Operator;

/* loaded from: classes3.dex */
public class LelinkPlayerListenerDispatcher {
    private static final String TAG = "LelinkPlayerListenerDispatcher";
    private OutParameter mCurrentPlayInfo;
    private IDaPlayerListener mOuterDaPlayerListener;
    private ILelinkPlayerListener mOuterLelinkPlayerListener;
    private INewPlayerListener mOuterNewPlayerListener;

    private CastBean createCastBean(OutParameter outParameter) {
        if (outParameter == null) {
            return new CastBean();
        }
        CastBean castBean = new CastBean();
        castBean.url = outParameter.getPlayUrl();
        castBean.dramaID = outParameter.dramaID;
        castBean.serviceInfo = outParameter.serviceInfo;
        return castBean;
    }

    private DaCastBean createDaCastBean(OutParameter outParameter) {
        return outParameter == null ? new DaCastBean() : new DaCastBean();
    }

    private boolean isSamePlayInfo(OutParameter outParameter, OutParameter outParameter2) {
        return outParameter != null && outParameter2 != null && TextUtils.equals(outParameter.urlID, outParameter2.urlID) && outParameter.castType == outParameter2.castType && outParameter.mimeType == outParameter2.mimeType;
    }

    public void onCompletion(OutParameter outParameter, int i10) {
        if (outParameter == null || outParameter.pushType != 1) {
            INewPlayerListener iNewPlayerListener = this.mOuterNewPlayerListener;
            if (iNewPlayerListener != null) {
                iNewPlayerListener.onCompletion(createCastBean(outParameter), i10);
                return;
            }
            ILelinkPlayerListener iLelinkPlayerListener = this.mOuterLelinkPlayerListener;
            if (iLelinkPlayerListener != null) {
                iLelinkPlayerListener.onCompletion();
            } else {
                SourceLog.w(TAG, "onCompletion invalid listener");
            }
        }
    }

    public void onDaResult(OutParameter outParameter, boolean z10) {
        IDaPlayerListener iDaPlayerListener = this.mOuterDaPlayerListener;
        if (iDaPlayerListener != null) {
            iDaPlayerListener.onResult(createDaCastBean(outParameter), z10);
        }
    }

    public void onError(OutParameter outParameter, int i10, int i11) {
        onError(outParameter, i10, i11, "");
    }

    public void onInfo(OutParameter outParameter, int i10, int i11) {
        if (outParameter == null || outParameter.pushType != 1) {
            INewPlayerListener iNewPlayerListener = this.mOuterNewPlayerListener;
            if (iNewPlayerListener != null) {
                iNewPlayerListener.onInfo(createCastBean(outParameter), i10, i11);
                return;
            }
            ILelinkPlayerListener iLelinkPlayerListener = this.mOuterLelinkPlayerListener;
            if (iLelinkPlayerListener != null) {
                iLelinkPlayerListener.onInfo(i10, i11);
            } else {
                SourceLog.w(TAG, "onInfo invalid listener");
            }
        }
    }

    public void onLoading(OutParameter outParameter) {
        if (!ConnectManager.getInstance().isConnected(outParameter)) {
            SourceLog.w(TAG, "onLoading ignore, device is disconnect");
            return;
        }
        if (outParameter != null && outParameter.pushType == 1) {
            IDaPlayerListener iDaPlayerListener = this.mOuterDaPlayerListener;
            if (iDaPlayerListener != null) {
                iDaPlayerListener.onLoading(createDaCastBean(outParameter));
                return;
            }
            return;
        }
        INewPlayerListener iNewPlayerListener = this.mOuterNewPlayerListener;
        if (iNewPlayerListener != null) {
            iNewPlayerListener.onLoading(createCastBean(outParameter));
            return;
        }
        ILelinkPlayerListener iLelinkPlayerListener = this.mOuterLelinkPlayerListener;
        if (iLelinkPlayerListener != null) {
            iLelinkPlayerListener.onLoading();
        } else {
            SourceLog.w(TAG, "onLoading invalid listener");
        }
    }

    public void onPause(OutParameter outParameter) {
        if (outParameter == null || outParameter.pushType != 1) {
            INewPlayerListener iNewPlayerListener = this.mOuterNewPlayerListener;
            if (iNewPlayerListener != null) {
                iNewPlayerListener.onPause(createCastBean(outParameter));
                return;
            }
            ILelinkPlayerListener iLelinkPlayerListener = this.mOuterLelinkPlayerListener;
            if (iLelinkPlayerListener != null) {
                iLelinkPlayerListener.onPause();
            } else {
                SourceLog.w(TAG, "onPause invalid listener");
            }
        }
    }

    public void onPositionUpdate(OutParameter outParameter, long j10, long j11) {
        if (outParameter == null || outParameter.pushType != 1) {
            INewPlayerListener iNewPlayerListener = this.mOuterNewPlayerListener;
            if (iNewPlayerListener != null) {
                iNewPlayerListener.onPositionUpdate(createCastBean(outParameter), j10, j11);
                return;
            }
            ILelinkPlayerListener iLelinkPlayerListener = this.mOuterLelinkPlayerListener;
            if (iLelinkPlayerListener != null) {
                iLelinkPlayerListener.onPositionUpdate(j10, j11);
            } else {
                SourceLog.w(TAG, "onPositionUpdate invalid listener");
            }
        }
    }

    public void onSeekComplete(OutParameter outParameter, int i10) {
        if (outParameter == null || outParameter.pushType != 1) {
            INewPlayerListener iNewPlayerListener = this.mOuterNewPlayerListener;
            if (iNewPlayerListener != null) {
                iNewPlayerListener.onSeekComplete(createCastBean(outParameter), i10);
                return;
            }
            ILelinkPlayerListener iLelinkPlayerListener = this.mOuterLelinkPlayerListener;
            if (iLelinkPlayerListener != null) {
                iLelinkPlayerListener.onSeekComplete(i10);
            } else {
                SourceLog.w(TAG, "onSeekComplete invalid listener");
            }
        }
    }

    public void onStart(OutParameter outParameter) {
        if (!ConnectManager.getInstance().isConnected(outParameter)) {
            SourceLog.w(TAG, "onStart ignore, device is disconnect");
            return;
        }
        if (outParameter != null && outParameter.pushType == 1) {
            IDaPlayerListener iDaPlayerListener = this.mOuterDaPlayerListener;
            if (iDaPlayerListener != null) {
                iDaPlayerListener.onStart(createDaCastBean(outParameter));
                return;
            }
            return;
        }
        INewPlayerListener iNewPlayerListener = this.mOuterNewPlayerListener;
        if (iNewPlayerListener != null) {
            iNewPlayerListener.onStart(createCastBean(outParameter));
            return;
        }
        ILelinkPlayerListener iLelinkPlayerListener = this.mOuterLelinkPlayerListener;
        if (iLelinkPlayerListener != null) {
            iLelinkPlayerListener.onStart();
        } else {
            SourceLog.w(TAG, "onStart invalid listener");
        }
    }

    public void onStop(OutParameter outParameter) {
        if (outParameter != null && outParameter.pushType == 1) {
            IDaPlayerListener iDaPlayerListener = this.mOuterDaPlayerListener;
            if (iDaPlayerListener != null) {
                iDaPlayerListener.onStop(createDaCastBean(outParameter));
                return;
            }
            return;
        }
        if (CastUtil.isSupportCloudMultiCast() || isSamePlayInfo(outParameter, this.mCurrentPlayInfo)) {
            INewPlayerListener iNewPlayerListener = this.mOuterNewPlayerListener;
            if (iNewPlayerListener != null) {
                iNewPlayerListener.onStop(createCastBean(outParameter));
                return;
            }
            ILelinkPlayerListener iLelinkPlayerListener = this.mOuterLelinkPlayerListener;
            if (iLelinkPlayerListener != null) {
                iLelinkPlayerListener.onStop();
                return;
            } else {
                SourceLog.w(TAG, "onStop invalid listener");
                return;
            }
        }
        if (outParameter == null || this.mCurrentPlayInfo == null) {
            SourceLog.w(TAG, "onStop ignore, unEqual playInfo");
            return;
        }
        SourceLog.w(TAG, "onStop ignore, unEqual playInfo " + outParameter.urlID + Operator.Operation.DIVISION + this.mCurrentPlayInfo.urlID);
    }

    public void onVolumeChanged(OutParameter outParameter, float f10) {
        if (outParameter == null || outParameter.pushType != 1) {
            INewPlayerListener iNewPlayerListener = this.mOuterNewPlayerListener;
            if (iNewPlayerListener != null) {
                iNewPlayerListener.onVolumeChanged(createCastBean(outParameter), f10);
                return;
            }
            ILelinkPlayerListener iLelinkPlayerListener = this.mOuterLelinkPlayerListener;
            if (iLelinkPlayerListener != null) {
                iLelinkPlayerListener.onVolumeChanged(f10);
            } else {
                SourceLog.w(TAG, "onVolumeChanged invalid listener");
            }
        }
    }

    public void setCurrentPlayInfo(OutParameter outParameter) {
        this.mCurrentPlayInfo = outParameter;
    }

    public void setDaPlayListener(IDaPlayerListener iDaPlayerListener) {
        this.mOuterDaPlayerListener = iDaPlayerListener;
    }

    public void setNewPlayerListener(INewPlayerListener iNewPlayerListener) {
        SourceLog.i(TAG, "setNewPlayerListener " + iNewPlayerListener);
        this.mOuterNewPlayerListener = iNewPlayerListener;
    }

    public void setPlayerListener(ILelinkPlayerListener iLelinkPlayerListener) {
        SourceLog.i(TAG, "setPlayerListener " + iLelinkPlayerListener);
        this.mOuterLelinkPlayerListener = iLelinkPlayerListener;
    }

    public void onError(OutParameter outParameter, int i10, int i11, String str) {
        if (outParameter == null || outParameter.pushType != 1) {
            if (this.mOuterNewPlayerListener != null) {
                SourceLog.i(TAG, " New  PlayerListener onError callback");
                CastBean createCastBean = createCastBean(outParameter);
                createCastBean.errorInfo = str;
                this.mOuterNewPlayerListener.onError(createCastBean, i10, i11);
                return;
            }
            if (this.mOuterLelinkPlayerListener == null) {
                SourceLog.w(TAG, "onError invalid listener");
            } else {
                SourceLog.i(TAG, " PlayerListener onError callback");
                this.mOuterLelinkPlayerListener.onError(i10, i11);
            }
        }
    }

    public void onInfo(OutParameter outParameter, int i10, String str) {
        if (outParameter == null || outParameter.pushType != 1) {
            INewPlayerListener iNewPlayerListener = this.mOuterNewPlayerListener;
            if (iNewPlayerListener != null) {
                iNewPlayerListener.onInfo(createCastBean(outParameter), i10, str);
                return;
            }
            ILelinkPlayerListener iLelinkPlayerListener = this.mOuterLelinkPlayerListener;
            if (iLelinkPlayerListener != null) {
                iLelinkPlayerListener.onInfo(i10, str);
            } else {
                SourceLog.w(TAG, "onInfo invalid listener");
            }
        }
    }
}
