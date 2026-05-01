package com.hpplay.sdk.source.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.hpplay.sdk.source.log.SourceLog;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class DanmakuPropertyBean implements Parcelable {
    public static final Parcelable.Creator<DanmakuPropertyBean> CREATOR = new Parcelable.Creator<DanmakuPropertyBean>() { // from class: com.hpplay.sdk.source.bean.DanmakuPropertyBean.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DanmakuPropertyBean createFromParcel(Parcel parcel) {
            return new DanmakuPropertyBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DanmakuPropertyBean[] newArray(int i10) {
            return new DanmakuPropertyBean[i10];
        }
    };
    public static final int LINES_1 = 1;
    public static final int LINES_10 = 10;
    public static final int LINES_2 = 2;
    public static final int LINES_3 = 3;
    public static final int LINES_4 = 4;
    public static final int LINES_5 = 5;
    public static final int LINES_6 = 6;
    public static final int LINES_7 = 7;
    public static final int LINES_8 = 8;
    public static final int LINES_9 = 9;
    public static final float SPEED_1 = 1.5f;
    public static final float SPEED_10 = 0.1f;
    public static final float SPEED_2 = 1.3f;
    public static final float SPEED_3 = 1.1f;
    public static final float SPEED_4 = 0.9f;
    public static final float SPEED_5 = 0.7f;
    public static final float SPEED_6 = 0.5f;
    public static final float SPEED_7 = 0.4f;
    public static final float SPEED_8 = 0.3f;
    public static final float SPEED_9 = 0.2f;
    private static final String TAG = "DanmakuPropertyBean";
    private int lineSpace;
    private int lines;
    private int padding;
    private int rowSpace;
    private float speed;
    private boolean swch;

    public DanmakuPropertyBean(Parcel parcel) {
        this.swch = parcel.readByte() != 0;
        this.padding = parcel.readInt();
        this.lines = parcel.readInt();
        this.rowSpace = parcel.readInt();
        this.lineSpace = parcel.readInt();
        this.speed = parcel.readFloat();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void setLineSpace(int i10) {
        this.lineSpace = i10;
    }

    public void setLines(int i10) {
        this.lines = i10;
    }

    public void setPadding(int i10) {
        this.padding = i10;
    }

    public void setRowSpace(int i10) {
        this.rowSpace = i10;
    }

    public void setSpeed(float f10) {
        this.speed = f10;
    }

    public void setSwitch(boolean z10) {
        this.swch = z10;
    }

    public String toJson(int i10) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("manifestVer", i10);
            jSONObject.put("swch", this.swch);
            jSONObject.put("padding", this.padding);
            jSONObject.put("speed", this.speed);
            jSONObject.put("lines", this.lines);
            jSONObject.put("rowSpace", this.rowSpace);
            jSONObject.put("lineSpace", this.lineSpace);
            SourceLog.i(TAG, jSONObject.toString());
            return jSONObject.toString();
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
            return null;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeByte(this.swch ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.padding);
        parcel.writeInt(this.lines);
        parcel.writeInt(this.rowSpace);
        parcel.writeInt(this.lineSpace);
        parcel.writeFloat(this.speed);
    }

    public DanmakuPropertyBean() {
    }
}
