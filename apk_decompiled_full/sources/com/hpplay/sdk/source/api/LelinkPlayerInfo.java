package com.hpplay.sdk.source.api;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.SparseArray;
import com.hpplay.sdk.source.bean.DanmakuBean;
import com.hpplay.sdk.source.bean.DramaInfoBean;
import com.hpplay.sdk.source.bean.MediaAssetBean;
import com.hpplay.sdk.source.bean.MicroAppInfoBean;
import com.hpplay.sdk.source.bean.PlayerInfoBean;
import com.hpplay.sdk.source.browse.api.IAPI;
import com.hpplay.sdk.source.browse.api.LelinkServiceInfo;
import com.hpplay.sdk.source.log.SourceLog;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class LelinkPlayerInfo implements Parcelable, IAPI, Cloneable {
    public static final int CAPTURE_AUDIO_APP = 3;
    public static final int CAPTURE_AUDIO_ASUS_ALL = 4;
    public static final int CAPTURE_AUDIO_AUTO = 2;
    public static final int CAPTURE_AUDIO_CLOSE = 0;
    public static final int CAPTURE_AUDIO_OPEN = 1;
    public static final Parcelable.Creator<LelinkPlayerInfo> CREATOR = new Parcelable.Creator<LelinkPlayerInfo>() { // from class: com.hpplay.sdk.source.api.LelinkPlayerInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LelinkPlayerInfo createFromParcel(Parcel parcel) {
            return new LelinkPlayerInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LelinkPlayerInfo[] newArray(int i10) {
            return new LelinkPlayerInfo[i10];
        }
    };
    public static final int FULLSCREEN_AUTO = 0;
    public static final int FULLSCREEN_OFF = 2;
    public static final int FULLSCREEN_ON = 1;
    public static final int LOOP_MODE_DEFAULT = 0;
    public static final int LOOP_MODE_SINGLE = 1;
    public static final int LOOP_MODE_UNDEFINED = -1;
    public static final int MONITOR_PAUSE = 3;
    public static final int MONITOR_RESUME = 4;
    public static final int MONITOR_START = 1;
    public static final int MONITOR_STOP = 2;
    private static final String TAG = "LelinkPlayerInfo";
    public static final int TYPE_AUDIO = 101;
    public static final int TYPE_IMAGE = 103;
    public static final int TYPE_MICRO_APP = 105;
    public static final int TYPE_MIRROR = 2;
    public static final int TYPE_SCREEN = 100;
    public static final int TYPE_URL = 1;
    public static final int TYPE_VIDEO = 102;
    private int bitRateLevel;
    private String dramaID;
    private int fullScreenType;
    private int headDuration;
    private boolean isAutoBitrate;
    private boolean isZoom;
    private String localPath;
    private LelinkServiceInfo mLelinkServiceInfo;
    private MediaAssetBean mediaAssetBean;
    private MicroAppInfoBean microAppInfoBean;
    private int mirrorAudioType;
    private boolean mirrorInner;
    private int mirrorSendTimeout;
    private String params;
    private int period;
    private PlayerInfoBean playerInfoBean;
    private boolean requestAudioFocus;
    private int resolutionLevel;
    private boolean retryDLNAHttp;
    private String screenCode;
    private String screenShotPath;
    private int startPosition;
    private ArrayList<LelinkServiceInfo> subMirrorInfos;
    private int tailDuration;
    private int type;
    private Uri uri;
    private String url;
    private DramaInfoBean[] urlList;
    private boolean useSystemMirrorCapture;

    public LelinkPlayerInfo() {
        this.resolutionLevel = -1;
        this.bitRateLevel = -1;
        this.mirrorAudioType = 0;
        this.requestAudioFocus = true;
        this.useSystemMirrorCapture = false;
        this.isZoom = true;
        this.isAutoBitrate = false;
        this.mirrorInner = true;
        this.retryDLNAHttp = true;
        this.subMirrorInfos = new ArrayList<>();
        PlayerInfoBean playerInfoBean = new PlayerInfoBean();
        this.playerInfoBean = playerInfoBean;
        playerInfoBean.getAesBean().setMode(1);
    }

    public void clearActivityTaskWhenStartMirror(boolean z10) {
        if (z10) {
            this.mirrorInner = false;
        } else {
            this.mirrorInner = true;
        }
    }

    public LelinkPlayerInfo cloneNoSubDevice() {
        try {
            LelinkPlayerInfo lelinkPlayerInfo = new LelinkPlayerInfo();
            LelinkServiceInfo lelinkServiceInfo = this.mLelinkServiceInfo;
            if (lelinkServiceInfo != null) {
                lelinkPlayerInfo.mLelinkServiceInfo = lelinkServiceInfo.m48clone();
            }
            lelinkPlayerInfo.url = this.url;
            lelinkPlayerInfo.localPath = this.localPath;
            lelinkPlayerInfo.uri = this.uri;
            lelinkPlayerInfo.params = this.params;
            lelinkPlayerInfo.startPosition = this.startPosition;
            lelinkPlayerInfo.type = this.type;
            lelinkPlayerInfo.resolutionLevel = this.resolutionLevel;
            lelinkPlayerInfo.bitRateLevel = this.bitRateLevel;
            lelinkPlayerInfo.mirrorAudioType = this.mirrorAudioType;
            lelinkPlayerInfo.requestAudioFocus = this.requestAudioFocus;
            lelinkPlayerInfo.screenCode = this.screenCode;
            lelinkPlayerInfo.isZoom = this.isZoom;
            lelinkPlayerInfo.screenShotPath = this.screenShotPath;
            MediaAssetBean mediaAssetBean = this.mediaAssetBean;
            if (mediaAssetBean != null) {
                lelinkPlayerInfo.mediaAssetBean = mediaAssetBean.m43clone();
            }
            PlayerInfoBean playerInfoBean = this.playerInfoBean;
            if (playerInfoBean != null) {
                lelinkPlayerInfo.playerInfoBean = playerInfoBean.m46clone();
            }
            lelinkPlayerInfo.fullScreenType = this.fullScreenType;
            lelinkPlayerInfo.isAutoBitrate = this.isAutoBitrate;
            lelinkPlayerInfo.mirrorInner = this.mirrorInner;
            lelinkPlayerInfo.retryDLNAHttp = this.retryDLNAHttp;
            lelinkPlayerInfo.mirrorSendTimeout = this.mirrorSendTimeout;
            MicroAppInfoBean microAppInfoBean = this.microAppInfoBean;
            if (microAppInfoBean != null) {
                lelinkPlayerInfo.microAppInfoBean = microAppInfoBean.m44clone();
            }
            DramaInfoBean[] dramaInfoBeanArr = this.urlList;
            if (dramaInfoBeanArr != null) {
                DramaInfoBean[] dramaInfoBeanArr2 = new DramaInfoBean[dramaInfoBeanArr.length];
                int i10 = 0;
                while (true) {
                    DramaInfoBean[] dramaInfoBeanArr3 = this.urlList;
                    if (i10 >= dramaInfoBeanArr3.length) {
                        break;
                    }
                    dramaInfoBeanArr2[i10] = dramaInfoBeanArr3[i10].m41clone();
                    i10++;
                }
                lelinkPlayerInfo.urlList = dramaInfoBeanArr2;
            }
            lelinkPlayerInfo.dramaID = this.dramaID;
            lelinkPlayerInfo.period = this.period;
            lelinkPlayerInfo.headDuration = this.headDuration;
            lelinkPlayerInfo.tailDuration = this.tailDuration;
            return lelinkPlayerInfo;
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
            return null;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getBitRateLevel() {
        return this.bitRateLevel;
    }

    public String getCastPwd() {
        return this.screenCode;
    }

    @Deprecated
    public DanmakuBean getDanmukuInfo() {
        return null;
    }

    public String getDramaID() {
        DramaInfoBean[] dramaInfoBeanArr;
        try {
            if (TextUtils.isEmpty(this.dramaID) && (dramaInfoBeanArr = this.urlList) != null && dramaInfoBeanArr.length > 0) {
                this.dramaID = dramaInfoBeanArr[0].urls[0].id;
            }
        } catch (Exception e10) {
            SourceLog.w(TAG, "getDramaID :" + e10);
        }
        return this.dramaID;
    }

    public int getFullScreen() {
        return this.fullScreenType;
    }

    public int getHeadDuration() {
        return this.headDuration;
    }

    public String getHeader() {
        return this.playerInfoBean.getHeader();
    }

    @Deprecated
    public Intent getIntent() {
        return null;
    }

    public LelinkServiceInfo getLelinkServiceInfo() {
        return this.mLelinkServiceInfo;
    }

    @Deprecated
    public Uri getLoaclUri() {
        return this.uri;
    }

    public String getLocalPath() {
        return this.localPath;
    }

    public Uri getLocalUri() {
        return this.uri;
    }

    public int getLoopMode() {
        return this.playerInfoBean.getLoopMode();
    }

    public MediaAssetBean getMediaAsset() {
        return this.mediaAssetBean;
    }

    public MicroAppInfoBean getMicroAppInfoBean() {
        return this.microAppInfoBean;
    }

    public int getMirrorAudioType() {
        return this.mirrorAudioType;
    }

    public int getMirrorSendTimeout() {
        return this.mirrorSendTimeout;
    }

    @Deprecated
    public SparseArray<Object> getMonitors() {
        return null;
    }

    @Override // com.hpplay.sdk.source.browse.api.IAPI
    @Deprecated
    public Object getOption(int i10, Object... objArr) {
        switch (i10) {
            case IAPI.OPTION_6 /* 65542 */:
                return this.screenCode;
            case IAPI.OPTION_10 /* 1048592 */:
                return Integer.valueOf(this.fullScreenType);
            case IAPI.OPTION_18 /* 1048600 */:
                return Boolean.valueOf(this.isZoom);
            case IAPI.OPTION_19 /* 1048601 */:
                return this.screenShotPath;
            case IAPI.OPTION_22 /* 1048610 */:
                return Boolean.TRUE;
            case IAPI.OPTION_30 /* 1048624 */:
                return Boolean.FALSE;
            case IAPI.OPTION_31 /* 1048625 */:
                return Boolean.valueOf(this.isAutoBitrate);
            case IAPI.OPTION_38 /* 1048632 */:
                return Boolean.valueOf(this.mirrorInner);
            case IAPI.OPTION_52 /* 1048658 */:
                return Boolean.FALSE;
            default:
                return null;
        }
    }

    public String getParams() {
        return this.params;
    }

    public int getPeriod() {
        return this.period;
    }

    public PlayerInfoBean getPlayInfoBean() {
        return this.playerInfoBean;
    }

    public int getResolutionLevel() {
        return this.resolutionLevel;
    }

    public int getStartPosition() {
        return this.startPosition;
    }

    public ArrayList<LelinkServiceInfo> getSubMirrorInfos() {
        return this.subMirrorInfos;
    }

    public int getTailDuration() {
        return this.tailDuration;
    }

    public int getType() {
        return this.type;
    }

    public String getUrl() {
        if (!TextUtils.isEmpty(this.url)) {
            return this.url;
        }
        DramaInfoBean[] dramaInfoBeanArr = this.urlList;
        if (dramaInfoBeanArr != null && dramaInfoBeanArr.length > 0) {
            for (DramaInfoBean dramaInfoBean : dramaInfoBeanArr) {
                DramaInfoBean.UrlBean[] urlBeanArr = dramaInfoBean.urls;
                if (urlBeanArr != null && urlBeanArr.length > 0) {
                    for (DramaInfoBean.UrlBean urlBean : urlBeanArr) {
                        if (TextUtils.equals(this.dramaID, urlBean.id)) {
                            return urlBean.url;
                        }
                    }
                }
            }
        }
        return null;
    }

    public DramaInfoBean[] getUrlList() {
        return this.urlList;
    }

    public boolean isAutoBitrate() {
        return this.isAutoBitrate;
    }

    public boolean isClearActivityTaskWhenStartMirror() {
        return !this.mirrorInner;
    }

    @Deprecated
    public boolean isMirrorAudioEnable() {
        return this.mirrorAudioType != 0;
    }

    public boolean isRequestAudioFocus() {
        return this.requestAudioFocus;
    }

    public boolean isRetryDLNAHttp() {
        return this.retryDLNAHttp;
    }

    public boolean isUseSystemMirrorCapture() {
        return this.useSystemMirrorCapture;
    }

    public void setAesIv(String str) {
        this.playerInfoBean.getAesBean().setIv(str);
    }

    public void setAesKey(String str) {
        this.playerInfoBean.getAesBean().setKey(str);
    }

    public void setAutoBitrate(boolean z10) {
        this.isAutoBitrate = z10;
    }

    public void setBitRateLevel(int i10) {
        this.bitRateLevel = i10;
    }

    public void setCastPwd(String str) {
        this.screenCode = str;
    }

    @Deprecated
    public void setDanmukuInfo(DanmakuBean danmakuBean) {
    }

    public void setFullScreen(int i10) {
        this.fullScreenType = i10;
    }

    public void setHeader(String str) {
        this.playerInfoBean.setHeader(str);
    }

    @Deprecated
    public void setIntent(Intent intent) {
    }

    public void setLelinkServiceInfo(LelinkServiceInfo lelinkServiceInfo) {
        this.mLelinkServiceInfo = lelinkServiceInfo;
    }

    @Deprecated
    public void setLoaclUri(Uri uri) {
        this.uri = uri;
    }

    public void setLocalPath(String str) {
        this.localPath = str;
    }

    public void setLocalUri(Uri uri) {
        this.uri = uri;
    }

    public void setLoopMode(int i10) {
        this.playerInfoBean.setLoopMode(i10);
    }

    public void setMediaAsset(MediaAssetBean mediaAssetBean) {
        this.mediaAssetBean = mediaAssetBean;
    }

    public void setMicroAppInfoBean(MicroAppInfoBean microAppInfoBean) {
        this.microAppInfoBean = microAppInfoBean;
    }

    @Deprecated
    public void setMirrorAudioEnable(boolean z10) {
        if (z10) {
            this.mirrorAudioType = 1;
        } else {
            this.mirrorAudioType = 0;
        }
    }

    public void setMirrorAudioType(int i10) {
        if (i10 == 4) {
            this.mirrorAudioType = i10;
        } else if (i10 != 3 || Build.VERSION.SDK_INT >= 29) {
            this.mirrorAudioType = i10;
        } else {
            SourceLog.w(TAG, "setMirrorAudioType ignore");
        }
    }

    public void setMirrorSendTimeout(int i10) {
        this.mirrorSendTimeout = i10;
    }

    @Override // com.hpplay.sdk.source.browse.api.IAPI
    @Deprecated
    public Object setOption(int i10, Object... objArr) {
        try {
            switch (i10) {
                case IAPI.OPTION_6 /* 65542 */:
                    if (objArr == null) {
                        return null;
                    }
                    Object obj = objArr[0];
                    if (obj != null) {
                        this.screenCode = obj.toString();
                        break;
                    }
                    break;
                case IAPI.OPTION_10 /* 1048592 */:
                    Object obj2 = objArr[0];
                    if (!(obj2 instanceof Boolean)) {
                        this.fullScreenType = ((Integer) obj2).intValue();
                        break;
                    } else {
                        this.fullScreenType = ((Boolean) obj2).booleanValue() ? 1 : 2;
                        break;
                    }
                case IAPI.OPTION_18 /* 1048600 */:
                    this.isZoom = ((Boolean) objArr[0]).booleanValue();
                    break;
                case IAPI.OPTION_19 /* 1048601 */:
                    this.screenShotPath = (String) objArr[0];
                    break;
                case IAPI.OPTION_31 /* 1048625 */:
                    this.isAutoBitrate = ((Boolean) objArr[0]).booleanValue();
                    break;
                case IAPI.OPTION_38 /* 1048632 */:
                    this.mirrorInner = ((Boolean) objArr[0]).booleanValue();
                    break;
                default:
                    return null;
            }
            return null;
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
            return null;
        }
    }

    public void setParams(String str) {
        this.params = str;
    }

    public void setPlayList(DramaInfoBean[] dramaInfoBeanArr, String str, int i10, int i11, int i12) {
        this.urlList = dramaInfoBeanArr;
        this.dramaID = str;
        this.period = i10;
        this.headDuration = i11;
        this.tailDuration = i12;
    }

    public void setRequestAudioFocus(boolean z10) {
        this.requestAudioFocus = z10;
    }

    public void setResolutionLevel(int i10) {
        this.resolutionLevel = i10;
    }

    public void setRetryDLNAHttp(boolean z10) {
        this.retryDLNAHttp = z10;
    }

    public void setStartPosition(int i10) {
        this.startPosition = i10;
    }

    public void setSubMirrorInfos(LelinkServiceInfo... lelinkServiceInfoArr) {
        if (lelinkServiceInfoArr != null) {
            for (LelinkServiceInfo lelinkServiceInfo : lelinkServiceInfoArr) {
                this.subMirrorInfos.add(lelinkServiceInfo);
            }
        }
    }

    public void setType(int i10) {
        this.type = i10;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public void useSystemMirrorCapture(boolean z10) {
        this.useSystemMirrorCapture = z10;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeParcelable(this.mLelinkServiceInfo, i10);
        parcel.writeString(this.url);
        parcel.writeString(this.dramaID);
        parcel.writeInt(this.period);
        parcel.writeInt(this.headDuration);
        parcel.writeInt(this.tailDuration);
        parcel.writeParcelableArray(this.urlList, i10);
        parcel.writeString(this.localPath);
        parcel.writeString(this.params);
        parcel.writeInt(this.startPosition);
        parcel.writeInt(this.type);
        parcel.writeInt(this.resolutionLevel);
        parcel.writeInt(this.bitRateLevel);
        parcel.writeInt(this.mirrorAudioType);
        parcel.writeByte(this.requestAudioFocus ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.useSystemMirrorCapture ? (byte) 1 : (byte) 0);
        parcel.writeString(this.screenCode);
        parcel.writeByte(this.isZoom ? (byte) 1 : (byte) 0);
        parcel.writeParcelable(this.mediaAssetBean, i10);
        parcel.writeParcelable(this.playerInfoBean, i10);
        parcel.writeInt(this.fullScreenType);
        parcel.writeString(this.screenShotPath);
        parcel.writeByte(this.isAutoBitrate ? (byte) 1 : (byte) 0);
        parcel.writeParcelable(this.uri, i10);
        parcel.writeByte(this.mirrorInner ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.retryDLNAHttp ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.mirrorSendTimeout);
        parcel.writeParcelable(this.microAppInfoBean, i10);
        if (this.subMirrorInfos.size() <= 0) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(this.subMirrorInfos.size());
        Iterator<LelinkServiceInfo> it = this.subMirrorInfos.iterator();
        while (it.hasNext()) {
            parcel.writeParcelable(it.next(), i10);
        }
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public LelinkPlayerInfo m38clone() {
        LelinkPlayerInfo cloneNoSubDevice = cloneNoSubDevice();
        if (cloneNoSubDevice != null && cloneNoSubDevice.subMirrorInfos != null) {
            ArrayList<LelinkServiceInfo> arrayList = new ArrayList<>();
            Iterator<LelinkServiceInfo> it = this.subMirrorInfos.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().m48clone());
            }
            cloneNoSubDevice.subMirrorInfos = arrayList;
        }
        return cloneNoSubDevice;
    }

    public void setFullScreen(boolean z10) {
        this.fullScreenType = z10 ? 1 : 2;
    }

    public LelinkPlayerInfo(Parcel parcel) {
        this.resolutionLevel = -1;
        this.bitRateLevel = -1;
        this.mirrorAudioType = 0;
        boolean z10 = true;
        this.requestAudioFocus = true;
        this.useSystemMirrorCapture = false;
        this.isZoom = true;
        this.isAutoBitrate = false;
        this.mirrorInner = true;
        this.retryDLNAHttp = true;
        this.subMirrorInfos = new ArrayList<>();
        try {
            this.mLelinkServiceInfo = (LelinkServiceInfo) parcel.readParcelable(LelinkServiceInfo.class.getClassLoader());
            this.url = parcel.readString();
            this.dramaID = parcel.readString();
            this.period = parcel.readInt();
            this.headDuration = parcel.readInt();
            this.tailDuration = parcel.readInt();
            Parcelable[] readParcelableArray = parcel.readParcelableArray(DramaInfoBean.class.getClassLoader());
            if (readParcelableArray != null && readParcelableArray.length > 0) {
                this.urlList = new DramaInfoBean[readParcelableArray.length];
                for (int i10 = 0; i10 < readParcelableArray.length; i10++) {
                    this.urlList[i10] = (DramaInfoBean) readParcelableArray[i10];
                }
            }
            this.localPath = parcel.readString();
            this.params = parcel.readString();
            this.startPosition = parcel.readInt();
            this.type = parcel.readInt();
            this.resolutionLevel = parcel.readInt();
            this.bitRateLevel = parcel.readInt();
            this.mirrorAudioType = parcel.readInt();
            this.requestAudioFocus = parcel.readByte() != 0;
            this.useSystemMirrorCapture = parcel.readByte() != 0;
            this.screenCode = parcel.readString();
            this.isZoom = parcel.readByte() != 0;
            this.mediaAssetBean = (MediaAssetBean) parcel.readParcelable(MediaAssetBean.class.getClassLoader());
            this.playerInfoBean = (PlayerInfoBean) parcel.readParcelable(PlayerInfoBean.class.getClassLoader());
            this.fullScreenType = parcel.readInt();
            this.screenShotPath = parcel.readString();
            this.isAutoBitrate = parcel.readByte() != 0;
            this.uri = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
            this.mirrorInner = parcel.readByte() != 0;
            if (parcel.readByte() == 0) {
                z10 = false;
            }
            this.retryDLNAHttp = z10;
            this.mirrorSendTimeout = parcel.readInt();
            this.microAppInfoBean = (MicroAppInfoBean) parcel.readParcelable(MicroAppInfoBean.class.getClassLoader());
            int readInt = parcel.readInt();
            if (readInt > 0) {
                ArrayList<LelinkServiceInfo> arrayList = new ArrayList<>();
                for (int i11 = 0; i11 < readInt; i11++) {
                    arrayList.add((LelinkServiceInfo) parcel.readParcelable(LelinkServiceInfo.class.getClassLoader()));
                }
                this.subMirrorInfos = arrayList;
            }
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
        }
    }
}
