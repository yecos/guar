package com.hpplay.sdk.source.api;

import android.content.Context;
import android.hardware.display.VirtualDisplay;
import android.net.Uri;
import com.hpplay.sdk.source.bean.AudioFrameBean;
import com.hpplay.sdk.source.bean.DramaInfoBean;
import com.hpplay.sdk.source.bean.SinkParameterBean;
import com.hpplay.sdk.source.bean.SinkTouchEventArea;
import com.hpplay.sdk.source.bean.VideoFrameBean;
import com.hpplay.sdk.source.browse.api.IBrowseListener;
import com.hpplay.sdk.source.browse.api.ICreatePinCodeListener;
import com.hpplay.sdk.source.browse.api.ICreateShortUrlListener;
import com.hpplay.sdk.source.browse.api.IServiceInfoListParseListener;
import com.hpplay.sdk.source.browse.api.IServiceInfoParseListener;
import com.hpplay.sdk.source.browse.api.LelinkServiceInfo;
import java.util.List;

/* loaded from: classes3.dex */
public interface ILelinkSourceSDK {
    void addFavoriteDevice(LelinkServiceInfo lelinkServiceInfo);

    void addPinCodeToLelinkServiceInfo(String str, IServiceInfoParseListener iServiceInfoParseListener);

    void addQRCodeToLelinkServiceInfo(String str, IServiceInfoParseListener iServiceInfoParseListener);

    void addVolume();

    void appendPlayList(DramaInfoBean[] dramaInfoBeanArr, int i10, int i11, int i12);

    void bindSdk(Context context, String str, String str2, IBindSdkListener iBindSdkListener);

    void bindSdk(Context context, String str, String str2, String str3, IBindSdkListener iBindSdkListener);

    void bindSdk(Context context, String str, String str2, String str3, String str4, String str5, IBindSdkListener iBindSdkListener);

    boolean canPlayLocalMedia(LelinkServiceInfo lelinkServiceInfo);

    boolean canPlayScreen(LelinkServiceInfo lelinkServiceInfo);

    void clearPlayList();

    void connect(LelinkServiceInfo lelinkServiceInfo);

    void createLelinkServiceInfo(SinkParameterBean sinkParameterBean, IServiceInfoParseListener iServiceInfoParseListener);

    void createLelinkServiceInfoList(List<SinkParameterBean> list, IServiceInfoListParseListener iServiceInfoListParseListener);

    void createPinCode(ICreatePinCodeListener iCreatePinCodeListener);

    void createShortUrl(ICreateShortUrlListener iCreateShortUrlListener);

    boolean disconnect(LelinkServiceInfo lelinkServiceInfo);

    List<LelinkServiceInfo> getConnectInfos();

    void getFavoriteDeviceList(int i10, int i11);

    void getHistoryDeviceList(int i10, int i11);

    Object getOption(int i10, Object... objArr);

    String getSDKInfos(int i10);

    VirtualDisplay getVirtualDisplay();

    void pause();

    void removeFavoriteDevice(List<LelinkServiceInfo> list);

    void removeHistoryDevice(List<LelinkServiceInfo> list, int i10);

    void resume();

    void seekTo(int i10);

    void setBrowseResultListener(IBrowseListener iBrowseListener);

    void setCommonListener(ICommonListener iCommonListener);

    void setConnectListener(IConnectListener iConnectListener);

    void setDaPlayListener(IDaPlayerListener iDaPlayerListener);

    void setDebugAVListener(IDebugAVListener iDebugAVListener);

    void setDebugMode(boolean z10);

    void setDebugTimestamp(boolean z10);

    void setFavoriteDeviceAlias(LelinkServiceInfo lelinkServiceInfo, String str);

    void setFavoriteDeviceListener(IFavoriteDeviceListener iFavoriteDeviceListener);

    void setHistoryDeviceListener(IHistoryDeviceListener iHistoryDeviceListener);

    void setLogCallback(ILogCallback iLogCallback);

    void setMirrorChangeListener(IMirrorChangeListener iMirrorChangeListener);

    void setNewPlayListener(INewPlayerListener iNewPlayerListener);

    void setOption(int i10, Object... objArr);

    void setPlayListener(ILelinkPlayerListener iLelinkPlayerListener);

    void setSearchBannerDataCallback(ISearchBannerDataCallback iSearchBannerDataCallback);

    void setSendPassCallback(ISendPassCallback iSendPassCallback);

    void setSinkKeyEventListener(ISinkKeyEventListener iSinkKeyEventListener);

    void setSinkTouchEventListener(SinkTouchEventArea sinkTouchEventArea, float f10, ISinkTouchEventListener iSinkTouchEventListener);

    void setVolume(int i10);

    void startBrowse(boolean z10, boolean z11);

    void startMirror(LelinkPlayerInfo lelinkPlayerInfo);

    void startPlayMedia(LelinkPlayerInfo lelinkPlayerInfo);

    void startPlayMedia(String str, int i10, boolean z10);

    void startPlayMediaImmed(LelinkServiceInfo lelinkServiceInfo, Uri uri, int i10);

    void startPlayMediaImmed(LelinkServiceInfo lelinkServiceInfo, String str, int i10, boolean z10);

    void stopBrowse();

    void stopPlay();

    void subVolume();

    void unBindSdk();

    void updateAudioData(byte[] bArr, AudioFrameBean audioFrameBean);

    void updateVideoData(byte[] bArr, VideoFrameBean videoFrameBean);
}
