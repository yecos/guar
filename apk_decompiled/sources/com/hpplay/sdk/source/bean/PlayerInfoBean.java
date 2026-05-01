package com.hpplay.sdk.source.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.hpplay.sdk.source.log.SourceLog;
import com.taobao.accs.common.Constants;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class PlayerInfoBean implements Parcelable, Cloneable {
    public static final Parcelable.Creator<PlayerInfoBean> CREATOR = new Parcelable.Creator<PlayerInfoBean>() { // from class: com.hpplay.sdk.source.bean.PlayerInfoBean.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PlayerInfoBean createFromParcel(Parcel parcel) {
            return new PlayerInfoBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PlayerInfoBean[] newArray(int i10) {
            return new PlayerInfoBean[i10];
        }
    };
    private static final String TAG = "PlayerInfoBean";
    private AesBean aes;
    private String header;
    private boolean isEmpty;
    private int loopMode;
    private int manifestVer;
    private String monitor;
    private String sessionID;
    private String tid;
    private String uri;
    private String vsession;
    private String vuuid;

    public PlayerInfoBean() {
        this.loopMode = -1;
        this.isEmpty = true;
        this.aes = new AesBean();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public JSONObject encode() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("manifestVer", this.manifestVer);
            jSONObject.put("uri", this.uri);
            jSONObject.put("header", this.header);
            jSONObject.put("sessionID", this.sessionID);
            jSONObject.put("loopMode", this.loopMode);
            jSONObject.put(Constants.KEY_MONIROT, this.monitor);
            jSONObject.put("tid", this.tid);
            jSONObject.put("vuuid", this.vuuid);
            jSONObject.put("vsession", this.vsession);
            AesBean aesBean = this.aes;
            if (aesBean != null) {
                jSONObject.put("aes", aesBean.encode());
            }
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
        }
        return jSONObject;
    }

    public AesBean getAesBean() {
        return this.aes;
    }

    public String getHeader() {
        return this.header;
    }

    public int getLoopMode() {
        return this.loopMode;
    }

    public int getManifestVer() {
        return this.manifestVer;
    }

    public String getMonitor() {
        return this.monitor;
    }

    public String getSessionId() {
        return this.sessionID;
    }

    public String getTid() {
        return this.tid;
    }

    public String getUri() {
        return this.uri;
    }

    public String getVsession() {
        return this.vsession;
    }

    public String getVuuid() {
        return this.vuuid;
    }

    public boolean isEmpty() {
        return this.isEmpty;
    }

    public void setHeader(String str) {
        this.header = str;
        this.isEmpty = false;
    }

    public void setLoopMode(int i10) {
        this.loopMode = i10;
        this.isEmpty = false;
    }

    public void setManifestVer(int i10) {
        this.manifestVer = i10;
        this.isEmpty = false;
    }

    public void setMonitor(String str) {
        this.monitor = str;
        this.isEmpty = false;
    }

    public void setSessionId(String str) {
        this.sessionID = str;
        this.isEmpty = false;
    }

    public void setTid(String str) {
        this.tid = str;
        this.isEmpty = false;
    }

    public void setUri(String str) {
        this.uri = str;
        this.isEmpty = false;
    }

    public void setVsession(String str) {
        this.vsession = str;
        this.isEmpty = false;
    }

    public void setVuuid(String str) {
        this.vuuid = str;
        this.isEmpty = false;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.manifestVer);
        parcel.writeString(this.uri);
        parcel.writeString(this.header);
        parcel.writeString(this.sessionID);
        parcel.writeInt(this.loopMode);
        parcel.writeString(this.monitor);
        parcel.writeParcelable(this.aes, i10);
        parcel.writeString(this.tid);
        parcel.writeString(this.vuuid);
        parcel.writeString(this.vsession);
        parcel.writeInt(this.isEmpty ? 1 : 0);
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public PlayerInfoBean m46clone() {
        try {
            PlayerInfoBean playerInfoBean = new PlayerInfoBean();
            playerInfoBean.manifestVer = this.manifestVer;
            playerInfoBean.uri = this.uri;
            playerInfoBean.header = this.header;
            playerInfoBean.sessionID = this.sessionID;
            playerInfoBean.loopMode = this.loopMode;
            playerInfoBean.monitor = this.monitor;
            AesBean aesBean = this.aes;
            if (aesBean != null) {
                playerInfoBean.aes = aesBean.m39clone();
            }
            playerInfoBean.tid = this.tid;
            playerInfoBean.vuuid = this.vuuid;
            playerInfoBean.vsession = this.vsession;
            playerInfoBean.isEmpty = this.isEmpty;
            return playerInfoBean;
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
            return null;
        }
    }

    public PlayerInfoBean(Parcel parcel) {
        this.loopMode = -1;
        this.isEmpty = true;
        this.manifestVer = parcel.readInt();
        this.uri = parcel.readString();
        this.header = parcel.readString();
        this.sessionID = parcel.readString();
        this.loopMode = parcel.readInt();
        this.monitor = parcel.readString();
        this.aes = (AesBean) parcel.readParcelable(AesBean.class.getClassLoader());
        this.tid = parcel.readString();
        this.vuuid = parcel.readString();
        this.vsession = parcel.readString();
        this.isEmpty = parcel.readInt() == 1;
    }
}
