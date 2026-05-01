package com.hpplay.sdk.source.bean;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes3.dex */
public class PassBean implements Parcelable {
    public static final Parcelable.Creator<PassBean> CREATOR = new Parcelable.Creator<PassBean>() { // from class: com.hpplay.sdk.source.bean.PassBean.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PassBean createFromParcel(Parcel parcel) {
            return new PassBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PassBean[] newArray(int i10) {
            return new PassBean[i10];
        }
    };
    public static final int PASS_ACTION_REGISTER = 1;
    public static final int PASS_ACTION_UNREGISTER = 0;
    public static final int PASS_CMD_REGISTER_SINK_KEY_EVENT = 28;
    public static final int PASS_CMD_REGISTER_SINK_TOUCH_EVENT = 31;
    public static final int PASS_RESULT_FAIL = 0;
    public static final int PASS_RESULT_SUCCESS = 1;
    public int action;
    public int cmd;
    public int result;
    public String uid;

    public PassBean() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.cmd);
        parcel.writeInt(this.result);
        parcel.writeInt(this.action);
        parcel.writeString(this.uid);
    }

    public PassBean(Parcel parcel) {
        this.cmd = parcel.readInt();
        this.action = parcel.readInt();
        this.result = parcel.readInt();
        this.uid = parcel.readString();
    }
}
