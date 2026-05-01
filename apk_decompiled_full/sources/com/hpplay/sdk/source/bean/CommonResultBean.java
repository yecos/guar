package com.hpplay.sdk.source.bean;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes3.dex */
public class CommonResultBean implements Parcelable {
    public static final Parcelable.Creator<CommonResultBean> CREATOR = new Parcelable.Creator<CommonResultBean>() { // from class: com.hpplay.sdk.source.bean.CommonResultBean.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CommonResultBean createFromParcel(Parcel parcel) {
            return new CommonResultBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CommonResultBean[] newArray(int i10) {
            return new CommonResultBean[i10];
        }
    };
    public int event;
    public String json;
    public int listener;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.listener);
        parcel.writeInt(this.event);
        parcel.writeString(this.json);
    }

    private CommonResultBean(Parcel parcel) {
        this.listener = parcel.readInt();
        this.event = parcel.readInt();
        this.json = parcel.readString();
    }

    public CommonResultBean() {
    }
}
