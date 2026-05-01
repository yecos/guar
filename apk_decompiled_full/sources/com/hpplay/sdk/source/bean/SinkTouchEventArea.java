package com.hpplay.sdk.source.bean;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes3.dex */
public class SinkTouchEventArea implements Parcelable {
    public static final Parcelable.Creator<SinkTouchEventArea> CREATOR = new Parcelable.Creator<SinkTouchEventArea>() { // from class: com.hpplay.sdk.source.bean.SinkTouchEventArea.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SinkTouchEventArea createFromParcel(Parcel parcel) {
            return new SinkTouchEventArea(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SinkTouchEventArea[] newArray(int i10) {
            return new SinkTouchEventArea[i10];
        }
    };
    public final int height;
    public final int width;

    public SinkTouchEventArea(int i10, int i11) {
        this.width = i10;
        this.height = i11;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.width);
        parcel.writeInt(this.height);
    }

    public SinkTouchEventArea(Parcel parcel) {
        this.width = parcel.readInt();
        this.height = parcel.readInt();
    }
}
