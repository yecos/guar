package com.hpplay.sdk.source.bean;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes3.dex */
public class DaCastBean implements Parcelable {
    public static final Parcelable.Creator<DaCastBean> CREATOR = new Parcelable.Creator<DaCastBean>() { // from class: com.hpplay.sdk.source.bean.DaCastBean.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DaCastBean createFromParcel(Parcel parcel) {
            return new DaCastBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DaCastBean[] newArray(int i10) {
            return new DaCastBean[i10];
        }
    };

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
    }

    private DaCastBean(Parcel parcel) {
    }

    public DaCastBean() {
    }
}
