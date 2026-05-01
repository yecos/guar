package com.hpplay.sdk.source.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import com.hpplay.sdk.source.log.SourceLog;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class ReceiverProperties implements Parcelable {
    public static final Parcelable.Creator<ReceiverProperties> CREATOR = new Parcelable.Creator<ReceiverProperties>() { // from class: com.hpplay.sdk.source.bean.ReceiverProperties.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ReceiverProperties createFromParcel(Parcel parcel) {
            return new ReceiverProperties(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ReceiverProperties[] newArray(int i10) {
            return new ReceiverProperties[i10];
        }
    };
    private static final String TAG = "ReceiverProperties";
    public int isSupport;
    public int playMode;
    public int player;
    public int rotateAngle;

    public ReceiverProperties() {
    }

    public static ReceiverProperties fromJson(String str) {
        ReceiverProperties receiverProperties = new ReceiverProperties();
        try {
            JSONObject jSONObject = new JSONObject(str);
            receiverProperties.isSupport = jSONObject.optInt("isSupport");
            receiverProperties.player = jSONObject.optInt("player");
            receiverProperties.playMode = jSONObject.optInt("playMode");
            receiverProperties.rotateAngle = jSONObject.optInt("rotateAngle");
            return receiverProperties;
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
            return null;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "ReceiverProperties{isSupport=" + this.isSupport + ", player=" + this.player + ", playMode=" + this.playMode + ", rotateAngle=" + this.rotateAngle + ASCIIPropertyListParser.DICTIONARY_END_TOKEN;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.player);
        parcel.writeInt(this.playMode);
        parcel.writeInt(this.rotateAngle);
        parcel.writeInt(this.isSupport);
    }

    public ReceiverProperties(Parcel parcel) {
        this.player = parcel.readInt();
        this.playMode = parcel.readInt();
        this.rotateAngle = parcel.readInt();
        this.isSupport = parcel.readInt();
    }
}
