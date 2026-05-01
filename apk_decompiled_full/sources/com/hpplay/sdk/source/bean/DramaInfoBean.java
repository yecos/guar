package com.hpplay.sdk.source.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.hpplay.cybergarage.xml.XML;
import com.hpplay.sdk.source.log.SourceLog;
import java.net.URLDecoder;
import java.net.URLEncoder;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class DramaInfoBean implements Parcelable, Cloneable {
    public static final String APPEND_PLAY_LIST = "append-playlist";
    public static final String CATEGORY_HIGH = "high";
    public static final String CATEGORY_STD = "std";
    public static final String CATEGORY_SUPER = "super";
    public static final String CLEAR_PLAY_LIST = "clear-playlist";
    public static final Parcelable.Creator<DramaInfoBean> CREATOR = new Parcelable.Creator<DramaInfoBean>() { // from class: com.hpplay.sdk.source.bean.DramaInfoBean.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DramaInfoBean createFromParcel(Parcel parcel) {
            return new DramaInfoBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DramaInfoBean[] newArray(int i10) {
            return new DramaInfoBean[i10];
        }
    };
    public static final String SET_PLAY_LIST = "set-playlist";
    private static final String TAG = "DramaInfoBean";
    public String name;
    public UrlBean[] urls;

    public static class UrlBean implements Parcelable, Cloneable {
        public static final Parcelable.Creator<UrlBean> CREATOR = new Parcelable.Creator<UrlBean>() { // from class: com.hpplay.sdk.source.bean.DramaInfoBean.UrlBean.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public UrlBean createFromParcel(Parcel parcel) {
                return new UrlBean(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public UrlBean[] newArray(int i10) {
                return new UrlBean[i10];
            }
        };
        public String category;
        public int height;
        public String id;
        public String url;
        public int width;

        public static UrlBean formJSON(JSONObject jSONObject) {
            UrlBean urlBean = new UrlBean();
            urlBean.id = jSONObject.optString("id");
            urlBean.url = jSONObject.optString("url");
            urlBean.category = jSONObject.optString("category");
            urlBean.width = jSONObject.optInt("width");
            urlBean.height = jSONObject.optInt("height");
            return urlBean;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String toJSON() {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("id", this.id);
                jSONObject.put("url", this.url);
                jSONObject.put("category", this.category);
                jSONObject.put("width", this.width);
                jSONObject.put("height", this.height);
                return jSONObject.toString();
            } catch (Exception e10) {
                SourceLog.w(DramaInfoBean.TAG, e10);
                return null;
            }
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeString(this.id);
            parcel.writeString(this.url);
            parcel.writeString(this.category);
            parcel.writeInt(this.width);
            parcel.writeInt(this.height);
        }

        public UrlBean() {
        }

        /* renamed from: clone, reason: merged with bridge method [inline-methods] */
        public UrlBean m42clone() {
            try {
                UrlBean urlBean = new UrlBean();
                urlBean.id = this.id;
                urlBean.url = this.url;
                urlBean.category = this.category;
                urlBean.width = this.width;
                urlBean.height = this.height;
                return urlBean;
            } catch (Exception e10) {
                SourceLog.w(DramaInfoBean.TAG, e10);
                return null;
            }
        }

        private UrlBean(Parcel parcel) {
            this.id = parcel.readString();
            this.url = parcel.readString();
            this.category = parcel.readString();
            this.width = parcel.readInt();
            this.height = parcel.readInt();
        }
    }

    public static DramaInfoBean formJSON(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            DramaInfoBean dramaInfoBean = new DramaInfoBean();
            dramaInfoBean.name = URLDecoder.decode(jSONObject.optString("name"), XML.CHARSET_UTF8);
            JSONArray optJSONArray = jSONObject.optJSONArray("urls");
            if (optJSONArray != null) {
                dramaInfoBean.urls = new UrlBean[optJSONArray.length()];
                for (int i10 = 0; i10 < optJSONArray.length(); i10++) {
                    dramaInfoBean.urls[i10] = UrlBean.formJSON(optJSONArray.optJSONObject(i10));
                }
            }
            return dramaInfoBean;
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
            return null;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public JSONObject toJson() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("name", URLEncoder.encode(this.name, XML.CHARSET_UTF8));
            JSONArray jSONArray = new JSONArray();
            UrlBean[] urlBeanArr = this.urls;
            if (urlBeanArr != null) {
                for (UrlBean urlBean : urlBeanArr) {
                    jSONArray.put(urlBean.toJSON());
                }
            }
            jSONObject.put("urls", jSONArray);
            return jSONObject;
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
            return null;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.name);
        parcel.writeParcelableArray(this.urls, i10);
    }

    public DramaInfoBean() {
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public DramaInfoBean m41clone() {
        try {
            DramaInfoBean dramaInfoBean = new DramaInfoBean();
            dramaInfoBean.name = this.name;
            UrlBean[] urlBeanArr = this.urls;
            if (urlBeanArr != null) {
                int length = urlBeanArr.length;
                UrlBean[] urlBeanArr2 = new UrlBean[length];
                for (int i10 = 0; i10 < length; i10++) {
                    urlBeanArr2[i10] = this.urls[i10].m42clone();
                }
                dramaInfoBean.urls = urlBeanArr2;
            }
            return dramaInfoBean;
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
            return null;
        }
    }

    private DramaInfoBean(Parcel parcel) {
        this.name = parcel.readString();
        Parcelable[] readParcelableArray = parcel.readParcelableArray(UrlBean.class.getClassLoader());
        if (readParcelableArray != null) {
            this.urls = new UrlBean[readParcelableArray.length];
            for (int i10 = 0; i10 < readParcelableArray.length; i10++) {
                this.urls[i10] = (UrlBean) readParcelableArray[i10];
            }
        }
    }
}
