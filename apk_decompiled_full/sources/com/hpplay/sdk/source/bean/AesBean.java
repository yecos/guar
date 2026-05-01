package com.hpplay.sdk.source.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.hpplay.sdk.source.log.SourceLog;
import com.taobao.accs.common.Constants;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class AesBean implements Parcelable, Cloneable {
    public static final Parcelable.Creator<AesBean> CREATOR = new Parcelable.Creator<AesBean>() { // from class: com.hpplay.sdk.source.bean.AesBean.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AesBean createFromParcel(Parcel parcel) {
            return new AesBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AesBean[] newArray(int i10) {
            return new AesBean[i10];
        }
    };
    private static final String TAG = "AesBean";
    private String iv;
    private String key;
    private int mode;

    public AesBean() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public JSONObject encode() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(Constants.KEY_MODE, this.mode);
            jSONObject.put("key", this.key);
            jSONObject.put("iv", this.iv);
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
        }
        return jSONObject;
    }

    public String getIv() {
        return this.iv;
    }

    public String getKey() {
        return this.key;
    }

    public int getMode() {
        return this.mode;
    }

    public void setIv(String str) {
        this.iv = str;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setMode(int i10) {
        this.mode = i10;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.mode);
        parcel.writeString(this.key);
        parcel.writeString(this.iv);
    }

    public AesBean(Parcel parcel) {
        this.mode = parcel.readInt();
        this.key = parcel.readString();
        this.iv = parcel.readString();
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public AesBean m39clone() {
        try {
            AesBean aesBean = new AesBean();
            aesBean.mode = this.mode;
            aesBean.key = this.key;
            aesBean.iv = this.iv;
            return aesBean;
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
            return null;
        }
    }
}
