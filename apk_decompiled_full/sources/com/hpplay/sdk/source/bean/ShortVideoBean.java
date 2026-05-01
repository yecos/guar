package com.hpplay.sdk.source.bean;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes3.dex */
public class ShortVideoBean implements Parcelable {
    public static final Parcelable.Creator<ShortVideoBean> CREATOR = new Parcelable.Creator<ShortVideoBean>() { // from class: com.hpplay.sdk.source.bean.ShortVideoBean.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ShortVideoBean createFromParcel(Parcel parcel) {
            return new ShortVideoBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ShortVideoBean[] newArray(int i10) {
            return new ShortVideoBean[i10];
        }
    };
    public String imgUrl;
    public String key;

    public ShortVideoBean(Parcel parcel) {
        this.key = parcel.readString();
        this.imgUrl = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.key);
        parcel.writeString(this.imgUrl);
    }
}
