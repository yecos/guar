package com.hpplay.sdk.source.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.hpplay.sdk.source.log.SourceLog;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class WatermarkBean implements Parcelable {
    public static final Parcelable.Creator<WatermarkBean> CREATOR = new Parcelable.Creator<WatermarkBean>() { // from class: com.hpplay.sdk.source.bean.WatermarkBean.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public WatermarkBean createFromParcel(Parcel parcel) {
            return new WatermarkBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public WatermarkBean[] newArray(int i10) {
            return new WatermarkBean[i10];
        }
    };
    private static final String TAG = "WatermarkBean";
    public int sourceId;
    public String sourcePath;
    public float xPositionRatio;
    public float yPositionRatio;

    public WatermarkBean() {
        this.xPositionRatio = -1.0f;
        this.yPositionRatio = -1.0f;
        this.sourceId = -1;
    }

    public static WatermarkBean formJson(String str) {
        try {
            WatermarkBean watermarkBean = new WatermarkBean();
            JSONObject jSONObject = new JSONObject(str);
            watermarkBean.xPositionRatio = (float) jSONObject.optDouble("xPositionRatio");
            watermarkBean.yPositionRatio = (float) jSONObject.optDouble("yPositionRatio");
            watermarkBean.sourceId = jSONObject.optInt("sourceId");
            watermarkBean.sourcePath = jSONObject.optString("sourcePath");
            return watermarkBean;
        } catch (JSONException e10) {
            SourceLog.w(TAG, e10);
            return null;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toJson() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("xPositionRatio", this.xPositionRatio);
            jSONObject.put("yPositionRatio", this.yPositionRatio);
            jSONObject.put("sourceId", this.sourceId);
            jSONObject.put("sourcePath", this.sourcePath);
            return jSONObject.toString();
        } catch (JSONException e10) {
            SourceLog.w(TAG, e10);
            return "";
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeFloat(this.xPositionRatio);
        parcel.writeFloat(this.yPositionRatio);
        parcel.writeInt(this.sourceId);
        parcel.writeString(this.sourcePath);
    }

    public WatermarkBean(Parcel parcel) {
        this.xPositionRatio = -1.0f;
        this.yPositionRatio = -1.0f;
        this.sourceId = -1;
        this.xPositionRatio = parcel.readFloat();
        this.yPositionRatio = parcel.readFloat();
        this.sourceId = parcel.readInt();
        this.sourcePath = parcel.readString();
    }
}
