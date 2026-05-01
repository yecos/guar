package com.hpplay.sdk.source.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.hpplay.cybergarage.xml.XML;
import com.hpplay.sdk.source.log.SourceLog;
import com.umeng.analytics.pro.bt;
import java.net.URLEncoder;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class MediaAssetBean implements Parcelable, Cloneable {
    public static final Parcelable.Creator<MediaAssetBean> CREATOR = new Parcelable.Creator<MediaAssetBean>() { // from class: com.hpplay.sdk.source.bean.MediaAssetBean.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MediaAssetBean createFromParcel(Parcel parcel) {
            return new MediaAssetBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MediaAssetBean[] newArray(int i10) {
            return new MediaAssetBean[i10];
        }
    };
    private static final String TAG = "MediaAssetBean";
    private String actor;
    private String album;
    private String albumArtURI;
    private String director;
    private long duration;
    private String id;
    private boolean isEmpty;
    private String manifestVer;
    private String mediaType;
    private String metaData;
    private String name;
    private String resolution;
    private long size;
    private String uri;

    public MediaAssetBean() {
        this.isEmpty = true;
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
            jSONObject.put("id", this.id);
            jSONObject.put("mediaType", this.mediaType);
            jSONObject.put("name", this.name);
            jSONObject.put("director", this.director);
            jSONObject.put("actor", this.actor);
            jSONObject.put("album", this.album);
            jSONObject.put("albumArtURI", this.albumArtURI);
            jSONObject.put("duration", this.duration);
            jSONObject.put("size", this.size);
            jSONObject.put(bt.f10065z, this.resolution);
            jSONObject.put("metaData", this.metaData);
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
        }
        return jSONObject;
    }

    public String getActor() {
        return this.actor;
    }

    public String getAlbum() {
        return this.album;
    }

    public String getAlbumArtURI() {
        return this.albumArtURI;
    }

    public String getDirector() {
        return this.director;
    }

    public long getDuration() {
        return this.duration;
    }

    public String getId() {
        return this.id;
    }

    public String getManifestVer() {
        return this.manifestVer;
    }

    public String getMediaType() {
        return this.mediaType;
    }

    public String getMetaData() {
        return this.metaData;
    }

    public String getName() {
        return this.name;
    }

    public String getResolution() {
        return this.resolution;
    }

    public long getSize() {
        return this.size;
    }

    public String getUri() {
        return this.uri;
    }

    public boolean isEmpty() {
        return this.isEmpty;
    }

    public void setActor(String str) {
        try {
            this.actor = URLEncoder.encode(str, XML.CHARSET_UTF8);
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
        }
        this.isEmpty = false;
    }

    public void setAlbum(String str) {
        try {
            this.album = URLEncoder.encode(str, XML.CHARSET_UTF8);
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
        }
        this.isEmpty = false;
    }

    public void setAlbumArtURI(String str) {
        this.albumArtURI = str;
        this.isEmpty = false;
    }

    public void setDirector(String str) {
        try {
            this.director = URLEncoder.encode(str, XML.CHARSET_UTF8);
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
        }
        this.isEmpty = false;
    }

    public void setDuration(long j10) {
        this.duration = j10;
        this.isEmpty = false;
    }

    public void setId(String str) {
        this.id = str;
        this.isEmpty = false;
    }

    public void setManifestVer(String str) {
        this.manifestVer = str;
        this.isEmpty = false;
    }

    public void setMediaType(String str) {
        this.mediaType = str;
        this.isEmpty = false;
    }

    public void setMetaData(String str) {
        try {
            this.metaData = URLEncoder.encode(str, XML.CHARSET_UTF8);
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
        }
    }

    public void setName(String str) {
        try {
            this.name = URLEncoder.encode(str, XML.CHARSET_UTF8);
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
        }
        this.isEmpty = false;
    }

    public void setResolution(String str) {
        this.resolution = str;
        this.isEmpty = false;
    }

    public void setSize(long j10) {
        this.size = j10;
        this.isEmpty = false;
    }

    public void setUri(String str) {
        this.uri = str;
        this.isEmpty = false;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.manifestVer);
        parcel.writeString(this.uri);
        parcel.writeString(this.id);
        parcel.writeString(this.mediaType);
        parcel.writeString(this.name);
        parcel.writeString(this.director);
        parcel.writeString(this.actor);
        parcel.writeString(this.album);
        parcel.writeString(this.albumArtURI);
        parcel.writeLong(this.duration);
        parcel.writeLong(this.size);
        parcel.writeString(this.resolution);
        parcel.writeInt(this.isEmpty ? 1 : 0);
        parcel.writeString(this.metaData);
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public MediaAssetBean m43clone() {
        try {
            MediaAssetBean mediaAssetBean = new MediaAssetBean();
            mediaAssetBean.manifestVer = this.manifestVer;
            mediaAssetBean.uri = this.uri;
            mediaAssetBean.id = this.id;
            mediaAssetBean.mediaType = this.mediaType;
            mediaAssetBean.name = this.name;
            mediaAssetBean.director = this.director;
            mediaAssetBean.actor = this.actor;
            mediaAssetBean.album = this.album;
            mediaAssetBean.albumArtURI = this.albumArtURI;
            mediaAssetBean.duration = this.duration;
            mediaAssetBean.size = this.size;
            mediaAssetBean.resolution = this.resolution;
            mediaAssetBean.isEmpty = this.isEmpty;
            return mediaAssetBean;
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
            return null;
        }
    }

    public MediaAssetBean(Parcel parcel) {
        this.isEmpty = true;
        this.manifestVer = parcel.readString();
        this.uri = parcel.readString();
        this.id = parcel.readString();
        this.mediaType = parcel.readString();
        this.name = parcel.readString();
        this.director = parcel.readString();
        this.actor = parcel.readString();
        this.album = parcel.readString();
        this.albumArtURI = parcel.readString();
        this.duration = parcel.readLong();
        this.size = parcel.readLong();
        this.resolution = parcel.readString();
        this.isEmpty = parcel.readInt() == 1;
        this.metaData = parcel.readString();
    }
}
