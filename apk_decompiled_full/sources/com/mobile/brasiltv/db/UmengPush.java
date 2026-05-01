package com.mobile.brasiltv.db;

import android.os.Parcel;
import android.os.Parcelable;
import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import com.hpplay.cybergarage.upnp.Argument;
import sa.a;
import sa.e;
import sa.f;
import t9.g;
import t9.i;

@e(name = "umengpush")
/* loaded from: classes3.dex */
public class UmengPush implements Parcelable {
    private String alias;
    private String channelNumber;

    @f
    private int clientSave;
    private String columnId;
    private String contentID;
    private String contentType;

    @a(column = "id")
    private int id;

    @f
    private boolean isCheck;
    private String isNews;
    private boolean isRead;
    private String msgId;
    private String name;
    private String programType;
    private String saveTime;

    @f
    private long serialVersionUID;
    private String specialFlag;
    private String text;
    private String tittle;
    private String trySee;
    private int type;
    private String urlString;
    public static final Companion Companion = new Companion(null);
    public static final Parcelable.Creator<UmengPush> CREATOR = new Parcelable.Creator<UmengPush>() { // from class: com.mobile.brasiltv.db.UmengPush$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public UmengPush createFromParcel(Parcel parcel) {
            i.g(parcel, "source");
            return new UmengPush(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public UmengPush[] newArray(int i10) {
            return new UmengPush[i10];
        }
    };

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }
    }

    public UmengPush() {
        this.clientSave = 1;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final String getAlias() {
        return this.alias;
    }

    public final String getChannelNumber() {
        return this.channelNumber;
    }

    public final int getClientSave() {
        return this.clientSave;
    }

    public final String getColumnId() {
        return this.columnId;
    }

    public final String getContentID() {
        return this.contentID;
    }

    public final String getContentType() {
        return this.contentType;
    }

    public final int getId() {
        return this.id;
    }

    public final String getIsNews() {
        return this.isNews;
    }

    public final String getMsgId() {
        return this.msgId;
    }

    public final String getName() {
        return this.name;
    }

    public final String getProgramType() {
        return this.programType;
    }

    public final String getSaveTime() {
        return this.saveTime;
    }

    public final long getSerialVersionUID() {
        return this.serialVersionUID;
    }

    public final String getSpecialFlag() {
        return this.specialFlag;
    }

    public final String getText() {
        return this.text;
    }

    public final String getTittle() {
        return this.tittle;
    }

    public final String getTrySee() {
        return this.trySee;
    }

    public final int getType() {
        return this.type;
    }

    public final String getUrlString() {
        return this.urlString;
    }

    public final boolean isCheck() {
        return this.isCheck;
    }

    public final String isNews() {
        return this.isNews;
    }

    public final boolean isRead() {
        return this.isRead;
    }

    public final void setAlias(String str) {
        this.alias = str;
    }

    public final void setChannelNumber(String str) {
        this.channelNumber = str;
    }

    public final void setCheck(boolean z10) {
        this.isCheck = z10;
    }

    public final void setClientSave(int i10) {
        this.clientSave = i10;
    }

    public final void setColumnId(String str) {
        this.columnId = str;
    }

    public final void setContentID(String str) {
        this.contentID = str;
    }

    public final void setContentType(String str) {
        this.contentType = str;
    }

    public final void setId(int i10) {
        this.id = i10;
    }

    public final void setMsgId(String str) {
        this.msgId = str;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final void setNews(String str) {
        this.isNews = str;
    }

    public final void setProgramType(String str) {
        this.programType = str;
    }

    public final void setRead(boolean z10) {
        this.isRead = z10;
    }

    public final void setSaveTime(String str) {
        this.saveTime = str;
    }

    public final void setSerialVersionUID(long j10) {
        this.serialVersionUID = j10;
    }

    public final void setSpecialFlag(String str) {
        this.specialFlag = str;
    }

    public final void setText(String str) {
        this.text = str;
    }

    public final void setTittle(String str) {
        this.tittle = str;
    }

    public final void setTrySee(String str) {
        this.trySee = str;
    }

    public final void setType(int i10) {
        this.type = i10;
    }

    public final void setUrlString(String str) {
        this.urlString = str;
    }

    public String toString() {
        return "UmengPush(id=" + this.id + ", isCheck=" + this.isCheck + ", type=" + this.type + ", msgId=" + this.msgId + ", contentID=" + this.contentID + ", contentType=" + this.contentType + ", isNews=" + this.isNews + ", trySee=" + this.trySee + ", programType=" + this.programType + ", channelNumber=" + this.channelNumber + ", urlString=" + this.urlString + ", saveTime=" + this.saveTime + ", text=" + this.text + ", tittle=" + this.tittle + ", isRead=" + this.isRead + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        i.g(parcel, "dest");
        parcel.writeInt(this.id);
        parcel.writeByte(this.isCheck ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.type);
        parcel.writeString(this.msgId);
        parcel.writeString(this.contentID);
        parcel.writeString(this.contentType);
        parcel.writeString(this.isNews);
        parcel.writeString(this.channelNumber);
        parcel.writeString(this.urlString);
        parcel.writeString(this.saveTime);
        parcel.writeString(this.text);
        parcel.writeString(this.tittle);
        parcel.writeByte(this.isRead ? (byte) 1 : (byte) 0);
    }

    public UmengPush(Parcel parcel) {
        i.g(parcel, Argument.IN);
        this.clientSave = 1;
        this.id = parcel.readInt();
        this.isCheck = parcel.readByte() != 0;
        this.type = parcel.readInt();
        this.msgId = parcel.readString();
        this.contentID = parcel.readString();
        this.contentType = parcel.readString();
        this.isNews = parcel.readString();
        this.channelNumber = parcel.readString();
        this.urlString = parcel.readString();
        this.saveTime = parcel.readString();
        this.text = parcel.readString();
        this.tittle = parcel.readString();
        this.isRead = parcel.readByte() != 0;
    }
}
