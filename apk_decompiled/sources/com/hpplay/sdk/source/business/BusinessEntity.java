package com.hpplay.sdk.source.business;

import android.content.Context;
import android.text.TextUtils;
import com.hpplay.sdk.source.api.IDaPlayerListener;
import com.hpplay.sdk.source.api.ILelinkPlayerListener;
import com.hpplay.sdk.source.api.INewPlayerListener;
import com.hpplay.sdk.source.bean.DramaInfoBean;
import com.hpplay.sdk.source.bean.OutParameter;
import com.hpplay.sdk.source.browse.api.LelinkServiceInfo;
import com.hpplay.sdk.source.business.cloud.AuthSDK;
import com.hpplay.sdk.source.da.e;
import com.hpplay.sdk.source.da.m;
import com.hpplay.sdk.source.log.SourceLog;
import com.hpplay.sdk.source.mirror.yim.YimMirror;
import com.hpplay.sdk.source.process.ConnectManager;
import com.hpplay.sdk.source.protocol.connect.ConnectBridge;
import com.hpplay.sdk.source.utils.CastUtil;
import com.hpplay.sdk.source.utils.Feature;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

/* loaded from: classes3.dex */
public class BusinessEntity {
    private static int KEEP_SIZE = 1;
    private static final String TAG = "BusinessEntity";
    private static BusinessEntity sInstance;
    private PlayController mLastPlayController;
    private long mPreCastTime = -1;
    private final ConcurrentLinkedQueue<PlayController> mControllers = new ConcurrentLinkedQueue<>();
    private final LelinkPlayerListenerDispatcher mListenerDispatcher = new LelinkPlayerListenerDispatcher();

    private BusinessEntity() {
    }

    private boolean checkSdkUsable() {
        if (AuthSDK.getInstance().checkSdkUsable()) {
            return true;
        }
        SourceLog.w(TAG, "checkSdkUsable auth failed authCode := " + AuthSDK.getInstance().getAuthCode());
        if (this.mListenerDispatcher != null) {
            if (AuthSDK.getInstance().getAuthCode() == -101) {
                this.mListenerDispatcher.onError(null, -1, -2);
            } else {
                this.mListenerDispatcher.onError(null, -1, 0);
            }
        }
        return false;
    }

    private void clearPreCast() {
        int size = (this.mControllers.size() - KEEP_SIZE) + 1;
        Iterator<PlayController> it = this.mControllers.iterator();
        while (it.hasNext()) {
            PlayController next = it.next();
            SourceLog.i(TAG, "clearPreCast " + next.getPlayInfo());
            next.setStopType(1001);
            next.release();
            it.remove();
            size--;
            if (size <= 0) {
                return;
            }
        }
    }

    private void destroyPreCast() {
        if (this.mControllers.size() >= KEEP_SIZE) {
            int size = (this.mControllers.size() - KEEP_SIZE) + 1;
            Iterator<PlayController> it = this.mControllers.iterator();
            while (it.hasNext()) {
                PlayController next = it.next();
                SourceLog.i(TAG, "destroyPreCast " + next.getPlayInfo());
                next.stop(1001);
                next.release();
                it.remove();
                size--;
                if (size <= 0) {
                    return;
                }
            }
        }
    }

    private ConnectBridge getConnectBridge(OutParameter outParameter) {
        LelinkServiceInfo lelinkServiceInfo = outParameter.serviceInfo;
        return (lelinkServiceInfo == null || TextUtils.isEmpty(lelinkServiceInfo.getUid())) ? ConnectManager.getInstance().getLastConnectBridge() : ConnectManager.getInstance().getConnectBridge(lelinkServiceInfo.getUid());
    }

    public static synchronized BusinessEntity getInstance() {
        synchronized (BusinessEntity.class) {
            synchronized (BusinessEntity.class) {
                if (sInstance == null) {
                    sInstance = new BusinessEntity();
                }
            }
            return sInstance;
        }
        return sInstance;
    }

    private boolean isCurrentDevice(OutParameter outParameter) {
        OutParameter playInfo;
        LelinkServiceInfo lelinkServiceInfo;
        PlayController playController = this.mLastPlayController;
        return (playController == null || (playInfo = playController.getPlayInfo()) == null || (lelinkServiceInfo = playInfo.serviceInfo) == null || !lelinkServiceInfo.equals(outParameter.serviceInfo)) ? false : true;
    }

    private boolean isMirroring() {
        OutParameter playInfo;
        PlayController lastPlayController = getInstance().getLastPlayController();
        return (lastPlayController == null || (playInfo = lastPlayController.getPlayInfo()) == null || playInfo.castType != 2) ? false : true;
    }

    public void addVolume() {
        if (checkSdkUsable()) {
            PlayController playController = this.mLastPlayController;
            if (playController == null) {
                SourceLog.w(TAG, "addVolume ignore");
            } else {
                playController.addVolume();
            }
        }
    }

    public void appendPlayList(DramaInfoBean[] dramaInfoBeanArr, int i10, int i11, int i12) {
        if (checkSdkUsable()) {
            SourceLog.i(TAG, "appendPlayList " + this.mControllers.size());
            Iterator<PlayController> it = this.mControllers.iterator();
            while (it.hasNext()) {
                it.next().appendPlayList(dramaInfoBeanArr, i10, i11, i12);
            }
        }
    }

    public void clearPlayList() {
        if (checkSdkUsable()) {
            SourceLog.i(TAG, "clearPlayList " + this.mControllers.size());
            Iterator<PlayController> it = this.mControllers.iterator();
            while (it.hasNext()) {
                it.next().clearPlayList();
            }
        }
    }

    public void dispatch(Context context, OutParameter outParameter, boolean z10) {
        dispatch(context, outParameter);
    }

    public void dispatchPlay(Context context, OutParameter outParameter) {
        this.mListenerDispatcher.setCurrentPlayInfo(outParameter);
        int currentTimeMillis = this.mPreCastTime == -1 ? -1 : (int) (System.currentTimeMillis() - this.mPreCastTime);
        this.mPreCastTime = System.currentTimeMillis();
        PlayController playController = new PlayController(context, outParameter);
        playController.setDataSource(outParameter, currentTimeMillis);
        playController.start();
        playController.setLelinkPlayerListener(this.mListenerDispatcher);
        this.mControllers.add(playController);
        this.mLastPlayController = playController;
    }

    public void enableMultiCast(boolean z10) {
        boolean isSupportCloudMultiCast = CastUtil.isSupportCloudMultiCast();
        if (z10) {
            KEEP_SIZE = isSupportCloudMultiCast ? Integer.MAX_VALUE : 4;
        } else {
            KEEP_SIZE = 1;
        }
    }

    public ConcurrentLinkedQueue<PlayController> getControllers() {
        return this.mControllers;
    }

    public PlayController getLastPlayController() {
        return this.mLastPlayController;
    }

    public OutParameter getLastPlayInfo() {
        PlayController lastPlayController = getInstance().getLastPlayController();
        if (lastPlayController == null) {
            return null;
        }
        return lastPlayController.getPlayInfo();
    }

    public int getLastPlayState() {
        PlayController playController;
        if (checkSdkUsable() && (playController = this.mLastPlayController) != null) {
            return playController.getCurrentPlayState();
        }
        return -1;
    }

    public LelinkPlayerListenerDispatcher getListenerDispatcher() {
        return this.mListenerDispatcher;
    }

    public void onAppPause() {
        if (checkSdkUsable()) {
            SourceLog.i(TAG, "onAppPause " + this.mControllers.size());
            Iterator<PlayController> it = this.mControllers.iterator();
            while (it.hasNext()) {
                it.next().onAppPause();
            }
        }
    }

    public void onAppResume() {
        if (checkSdkUsable()) {
            SourceLog.i(TAG, "onAppResume " + this.mControllers.size());
            Iterator<PlayController> it = this.mControllers.iterator();
            while (it.hasNext()) {
                it.next().onAppResume();
            }
        }
    }

    public void onDaResult(OutParameter outParameter, boolean z10) {
        this.mListenerDispatcher.onDaResult(outParameter, z10);
    }

    public void onWifiConnected() {
        Iterator<PlayController> it = this.mControllers.iterator();
        while (it.hasNext()) {
            it.next().onWifiConnected();
        }
    }

    public void pause() {
        if (checkSdkUsable()) {
            SourceLog.i(TAG, "pause " + this.mControllers.size());
            Iterator<PlayController> it = this.mControllers.iterator();
            while (it.hasNext()) {
                it.next().pause();
            }
        }
    }

    public void playDrama(String str) {
        if (checkSdkUsable()) {
            SourceLog.i(TAG, "playDrama " + this.mControllers.size() + " / " + str);
            Iterator<PlayController> it = this.mControllers.iterator();
            while (it.hasNext()) {
                it.next().playDrama(str);
            }
        }
    }

    public void playNextDrama() {
        if (checkSdkUsable()) {
            SourceLog.i(TAG, "playNextDrama " + this.mControllers.size());
            Iterator<PlayController> it = this.mControllers.iterator();
            while (it.hasNext()) {
                it.next().playNextDrama();
            }
        }
    }

    public void playPreDrama() {
        if (checkSdkUsable()) {
            SourceLog.i(TAG, "playPreDrama " + this.mControllers.size());
            Iterator<PlayController> it = this.mControllers.iterator();
            while (it.hasNext()) {
                it.next().playPreDrama();
            }
        }
    }

    public void release() {
        SourceLog.i(TAG, "release");
        try {
            Iterator<PlayController> it = this.mControllers.iterator();
            while (it.hasNext()) {
                it.next().release();
            }
            this.mControllers.clear();
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
        }
    }

    public void resume() {
        if (checkSdkUsable()) {
            SourceLog.i(TAG, "resume " + this.mControllers.size());
            Iterator<PlayController> it = this.mControllers.iterator();
            while (it.hasNext()) {
                it.next().resume();
            }
        }
    }

    public void seekTo(int i10) {
        if (checkSdkUsable()) {
            Iterator<PlayController> it = this.mControllers.iterator();
            while (it.hasNext()) {
                it.next().seekTo(i10);
            }
        }
    }

    public void selectAudioTrack(int i10) {
        if (checkSdkUsable()) {
            PlayController playController = this.mLastPlayController;
            if (playController == null) {
                SourceLog.w(TAG, "selectAudioTrack ignore");
            } else {
                playController.selectAudiotrack(i10);
            }
        }
    }

    public void setDaPlayListener(IDaPlayerListener iDaPlayerListener) {
        this.mListenerDispatcher.setDaPlayListener(iDaPlayerListener);
    }

    public void setMirrorScreenSecret(boolean z10) {
        if (checkSdkUsable()) {
            PlayController playController = this.mLastPlayController;
            if (playController == null) {
                SourceLog.w(TAG, "setMirrorScreenSecret ignore");
            } else {
                playController.setMirrorScreenSecret(z10);
            }
        }
    }

    public void setNewPlayerListener(INewPlayerListener iNewPlayerListener) {
        this.mListenerDispatcher.setNewPlayerListener(iNewPlayerListener);
    }

    public void setPlayerListener(ILelinkPlayerListener iLelinkPlayerListener) {
        this.mListenerDispatcher.setPlayerListener(iLelinkPlayerListener);
    }

    public void setVolume(int i10) {
        if (checkSdkUsable()) {
            PlayController playController = this.mLastPlayController;
            if (playController == null) {
                SourceLog.w(TAG, "setVolume ignore");
            } else {
                playController.setVolume(i10);
            }
        }
    }

    public void setWatermarkVisible(boolean z10) {
        if (checkSdkUsable()) {
            PlayController playController = this.mLastPlayController;
            if (playController == null) {
                SourceLog.w(TAG, "setWatermarkVisible ignore");
            } else {
                playController.setWatermarkVisible(z10);
            }
        }
    }

    public void stop(int i10) {
        Iterator<PlayController> it = this.mControllers.iterator();
        while (it.hasNext()) {
            it.next().stop(i10);
        }
        if (Feature.hasCloudMirror()) {
            YimMirror.getInstance().resetMultiCast();
        }
    }

    public void stopWithCallback(int i10) {
        Iterator<PlayController> it = this.mControllers.iterator();
        while (it.hasNext()) {
            it.next().stopWithCallback(i10);
        }
        if (Feature.hasCloudMirror()) {
            YimMirror.getInstance().resetMultiCast();
        }
    }

    public void subVolume() {
        if (checkSdkUsable()) {
            PlayController playController = this.mLastPlayController;
            if (playController == null) {
                SourceLog.w(TAG, "subVolume ignore");
            } else {
                playController.subVolume();
            }
        }
    }

    public void switchLelink() {
        PlayController playController = this.mLastPlayController;
        if (playController != null) {
            playController.doChangeChannel(1);
        }
    }

    public void switchYim() {
        PlayController playController = this.mLastPlayController;
        if (playController != null) {
            playController.doChangeChannel(4);
        }
    }

    public synchronized void dispatch(final Context context, final OutParameter outParameter) {
        if (!checkSdkUsable()) {
            SourceLog.i(TAG, "dispatch ignore");
            return;
        }
        if (outParameter == null) {
            return;
        }
        SourceLog.i(TAG, "dispatch " + outParameter);
        SourceLog.i(TAG, "dispatch KEEP_SIZE: " + KEEP_SIZE + ", mControllers:" + this.mControllers.size());
        this.mListenerDispatcher.setCurrentPlayInfo(outParameter);
        if (getConnectBridge(outParameter) != null && ((CastUtil.isSupportLelinkV2(outParameter.serviceInfo) || CastUtil.isSupportIM(outParameter.serviceInfo)) && outParameter.castType != 2 && !isMirroring() && isCurrentDevice(outParameter))) {
            clearPreCast();
            if (outParameter.castType != 1 && outParameter.mimeType == 102 && outParameter.urls == null) {
                e.d().a(outParameter, new m() { // from class: com.hpplay.sdk.source.business.BusinessEntity.1
                    @Override // com.hpplay.sdk.source.da.m
                    public void onDaResult(boolean z10, String str) {
                        boolean z11;
                        if (!z10 || TextUtils.isEmpty(str)) {
                            BusinessEntity.this.dispatchPlay(context, outParameter);
                            z11 = false;
                        } else {
                            e.d().a(context, outParameter, str);
                            z11 = true;
                        }
                        BusinessEntity.getInstance().onDaResult(outParameter, z11);
                    }
                });
            } else {
                dispatchPlay(context, outParameter);
            }
        }
        destroyPreCast();
        if (outParameter.castType != 1) {
        }
        dispatchPlay(context, outParameter);
    }

    public void stop(int i10, LelinkServiceInfo lelinkServiceInfo) {
        if (lelinkServiceInfo == null) {
            return;
        }
        try {
            Iterator<PlayController> it = this.mControllers.iterator();
            while (it.hasNext()) {
                try {
                    PlayController next = it.next();
                    if (lelinkServiceInfo.equals(next.getPlayInfo().serviceInfo)) {
                        next.stop(i10);
                        it.remove();
                    }
                } catch (Exception e10) {
                    SourceLog.w(TAG, e10);
                }
            }
        } catch (Exception e11) {
            SourceLog.w(TAG, e11);
        }
    }
}
