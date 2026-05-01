package com.hpplay.sdk.source.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.hpplay.sdk.source.browse.api.LelinkServiceInfo;

/* loaded from: classes3.dex */
public class ServiceInfoParseBean implements Parcelable {
    public static final Parcelable.Creator<ServiceInfoParseBean> CREATOR = new Parcelable.Creator<ServiceInfoParseBean>() { // from class: com.hpplay.sdk.source.bean.ServiceInfoParseBean.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ServiceInfoParseBean createFromParcel(Parcel parcel) {
            return new ServiceInfoParseBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ServiceInfoParseBean[] newArray(int i10) {
            return new ServiceInfoParseBean[i10];
        }
    };
    public LelinkServiceInfo info;
    public int resultCode;
    public String uid;

    public ServiceInfoParseBean() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        String str;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass() || (str = this.uid) == null) {
            return false;
        }
        return str.equals(((ServiceInfoParseBean) obj).uid);
    }

    public int hashCode() {
        return super.hashCode();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.resultCode);
        parcel.writeString(this.uid);
        parcel.writeParcelable(this.info, i10);
    }

    public ServiceInfoParseBean(int i10, String str, LelinkServiceInfo lelinkServiceInfo) {
        this.resultCode = i10;
        this.uid = str;
        this.info = lelinkServiceInfo;
    }

    public ServiceInfoParseBean(Parcel parcel) {
        this.resultCode = parcel.readInt();
        this.uid = parcel.readString();
        this.info = (LelinkServiceInfo) parcel.readParcelable(LelinkServiceInfo.class.getClassLoader());
    }
}
