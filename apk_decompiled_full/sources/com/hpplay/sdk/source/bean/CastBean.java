package com.hpplay.sdk.source.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.hpplay.sdk.source.browse.api.LelinkServiceInfo;

/* loaded from: classes3.dex */
public class CastBean implements Parcelable {
    public static final Parcelable.Creator<CastBean> CREATOR = new Parcelable.Creator<CastBean>() { // from class: com.hpplay.sdk.source.bean.CastBean.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CastBean createFromParcel(Parcel parcel) {
            return new CastBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CastBean[] newArray(int i10) {
            return new CastBean[i10];
        }
    };
    public String dramaID;
    public String errorInfo;
    public LelinkServiceInfo serviceInfo;
    public String url;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.url);
        parcel.writeString(this.dramaID);
        parcel.writeParcelable(this.serviceInfo, i10);
        parcel.writeString(this.errorInfo);
    }

    private CastBean(Parcel parcel) {
        this.url = parcel.readString();
        this.dramaID = parcel.readString();
        this.serviceInfo = (LelinkServiceInfo) parcel.readParcelable(CastBean.class.getClassLoader());
        this.errorInfo = parcel.readString();
    }

    public CastBean() {
    }
}
