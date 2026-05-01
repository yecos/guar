package com.hpplay.sdk.source.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.hpplay.sdk.source.log.SourceLog;
import java.util.Arrays;
import java.util.Collection;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class ReceiverPropertyBean implements Parcelable, Cloneable {
    public static final Parcelable.Creator<ReceiverPropertyBean> CREATOR = new Parcelable.Creator<ReceiverPropertyBean>() { // from class: com.hpplay.sdk.source.bean.ReceiverPropertyBean.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ReceiverPropertyBean createFromParcel(Parcel parcel) {
            return new ReceiverPropertyBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ReceiverPropertyBean[] newArray(int i10) {
            return new ReceiverPropertyBean[i10];
        }
    };
    private static final String TAG = "ReceiverPropertyBean";
    private int action;
    private String[] value;

    public ReceiverPropertyBean() {
    }

    public static ReceiverPropertyBean fromString(String str) {
        try {
            ReceiverPropertyBean receiverPropertyBean = new ReceiverPropertyBean();
            JSONObject jSONObject = new JSONObject(str);
            receiverPropertyBean.action = jSONObject.getInt("action");
            JSONArray jSONArray = jSONObject.getJSONArray("value");
            String[] strArr = new String[jSONArray.length()];
            for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                strArr[i10] = jSONArray.getString(i10);
            }
            receiverPropertyBean.value = strArr;
            return receiverPropertyBean;
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
            return null;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("manifestVer", 1);
            jSONObject.put("propertyId", UUID.randomUUID().toString());
            jSONObject.put("action", this.action);
            jSONObject.put("value", new JSONArray((Collection) Arrays.asList(this.value)));
            SourceLog.i(TAG, jSONObject.toString());
            return jSONObject.toString();
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
            return null;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.action);
        parcel.writeStringArray(this.value);
    }

    public ReceiverPropertyBean(int i10, String[] strArr) {
        this.action = i10;
        this.value = strArr;
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public ReceiverPropertyBean m47clone() {
        try {
            ReceiverPropertyBean receiverPropertyBean = new ReceiverPropertyBean();
            receiverPropertyBean.action = this.action;
            receiverPropertyBean.value = this.value;
            return receiverPropertyBean;
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
            return null;
        }
    }

    public ReceiverPropertyBean(Parcel parcel) {
        this.action = parcel.readInt();
        this.value = (String[]) parcel.readArray(Object.class.getClassLoader());
    }
}
