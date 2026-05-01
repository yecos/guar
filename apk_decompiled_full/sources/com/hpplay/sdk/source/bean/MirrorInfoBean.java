package com.hpplay.sdk.source.bean;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes3.dex */
public class MirrorInfoBean implements Parcelable {
    public static final Parcelable.Creator<MirrorInfoBean> CREATOR = new Parcelable.Creator<MirrorInfoBean>() { // from class: com.hpplay.sdk.source.bean.MirrorInfoBean.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MirrorInfoBean createFromParcel(Parcel parcel) {
            return new MirrorInfoBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MirrorInfoBean[] newArray(int i10) {
            return new MirrorInfoBean[i10];
        }
    };
    private boolean audioEnable;
    private int bitRate;
    private int captureType;
    private String connectSessionId;
    private int height;
    private boolean isAutoBitRate;
    private boolean isCloudMirror;
    private boolean isCustomAudio;
    private boolean isFullScreen;
    private boolean isShowExternalScreen;
    private boolean isUseRealResolution;
    private String mSessionId;
    private String mUri;
    private String roomId;
    private String screenCode;
    private int width;

    public MirrorInfoBean() {
        this.isCustomAudio = false;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getBitRate() {
        return this.bitRate;
    }

    public int getCaptureType() {
        return this.captureType;
    }

    public String getConnectSessionId() {
        return this.connectSessionId;
    }

    public int getHeight() {
        return this.height;
    }

    public String getRoomId() {
        return this.roomId;
    }

    public String getScreenCode() {
        return this.screenCode;
    }

    public String getSessionId() {
        return this.mSessionId;
    }

    public String getUri() {
        return this.mUri;
    }

    public int getWidth() {
        return this.width;
    }

    public boolean isAudioEnable() {
        return this.audioEnable;
    }

    public boolean isAutoBitRate() {
        return this.isAutoBitRate;
    }

    public boolean isCloudMirror() {
        return this.isCloudMirror;
    }

    public boolean isCustomAudio() {
        return this.isCustomAudio;
    }

    public boolean isFullScreen() {
        return this.isFullScreen;
    }

    public boolean isShowExternalScreen() {
        return this.isShowExternalScreen;
    }

    public boolean isUseRealResolution() {
        return this.isUseRealResolution;
    }

    public void setAudioEnable(boolean z10) {
        this.audioEnable = z10;
    }

    public void setAutoBitRate(boolean z10) {
        this.isAutoBitRate = z10;
    }

    public void setBitRate(int i10) {
        this.bitRate = i10;
    }

    public void setCaptureType(int i10) {
        this.captureType = i10;
    }

    public void setCloudMirror(boolean z10) {
        this.isCloudMirror = z10;
    }

    public void setConnectSessionId(String str) {
        this.connectSessionId = str;
    }

    public void setCustomAudio(boolean z10) {
        this.isCustomAudio = z10;
    }

    public void setFullScreen(boolean z10) {
        this.isFullScreen = z10;
    }

    public void setHeight(int i10) {
        this.height = i10;
    }

    public void setRoomId(String str) {
        this.roomId = str;
    }

    public void setScreenCode(String str) {
        this.screenCode = str;
    }

    public void setSessionId(String str) {
        this.mSessionId = str;
    }

    public void setShowExternalScreen(boolean z10) {
        this.isShowExternalScreen = z10;
    }

    public void setUri(String str) {
        this.mUri = str;
    }

    public void setUseRealResolution(boolean z10) {
        this.isUseRealResolution = z10;
    }

    public void setWidth(int i10) {
        this.width = i10;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.height);
        parcel.writeInt(this.width);
        parcel.writeInt(this.bitRate);
        parcel.writeString(this.screenCode);
        parcel.writeString(this.connectSessionId);
        parcel.writeString(this.mUri);
        parcel.writeByte(this.audioEnable ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isFullScreen ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isShowExternalScreen ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isCloudMirror ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isAutoBitRate ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.captureType);
        parcel.writeString(this.roomId);
        parcel.writeString(this.mSessionId);
        parcel.writeByte(this.isUseRealResolution ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isCustomAudio ? (byte) 1 : (byte) 0);
    }

    public MirrorInfoBean(Parcel parcel) {
        this.isCustomAudio = false;
        this.height = parcel.readInt();
        this.width = parcel.readInt();
        this.bitRate = parcel.readInt();
        this.screenCode = parcel.readString();
        this.connectSessionId = parcel.readString();
        this.mUri = parcel.readString();
        this.audioEnable = parcel.readByte() != 0;
        this.isFullScreen = parcel.readByte() != 0;
        this.isShowExternalScreen = parcel.readByte() != 0;
        this.isCloudMirror = parcel.readByte() != 0;
        this.isAutoBitRate = parcel.readByte() != 0;
        this.captureType = parcel.readInt();
        this.roomId = parcel.readString();
        this.mSessionId = parcel.readString();
        this.isUseRealResolution = parcel.readByte() != 0;
        this.isCustomAudio = parcel.readByte() != 0;
    }
}
