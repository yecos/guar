package com.hpplay.sdk.source.bean;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes3.dex */
public class AudioFrameBean implements Parcelable {
    public static final Parcelable.Creator<AudioFrameBean> CREATOR = new Parcelable.Creator<AudioFrameBean>() { // from class: com.hpplay.sdk.source.bean.AudioFrameBean.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AudioFrameBean createFromParcel(Parcel parcel) {
            return new AudioFrameBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AudioFrameBean[] newArray(int i10) {
            return new AudioFrameBean[i10];
        }
    };
    public static final int SAMPLE_44100 = 44100;
    public static final int SAMPLE_48000 = 48000;
    public static final int TYPE_PCM = 1;
    public int audioFormat;
    public int channel;

    @Deprecated
    public int length;

    @Deprecated
    public int offset;
    public int sampleRate;
    public int type;

    public AudioFrameBean() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.type);
        parcel.writeInt(this.sampleRate);
        parcel.writeInt(this.channel);
        parcel.writeInt(this.audioFormat);
        parcel.writeInt(this.offset);
        parcel.writeInt(this.length);
    }

    public AudioFrameBean(Parcel parcel) {
        this.type = parcel.readInt();
        this.sampleRate = parcel.readInt();
        this.channel = parcel.readInt();
        this.audioFormat = parcel.readInt();
        this.offset = parcel.readInt();
        this.length = parcel.readInt();
    }
}
