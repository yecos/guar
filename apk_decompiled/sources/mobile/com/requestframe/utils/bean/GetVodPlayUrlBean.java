package mobile.com.requestframe.utils.bean;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import com.taobao.accs.utl.BaseMonitor;
import t9.i;

/* loaded from: classes3.dex */
public final class GetVodPlayUrlBean {
    private String auth;
    private String license;
    private String media_code;

    public GetVodPlayUrlBean(String str, String str2, String str3) {
        i.g(str, "media_code");
        i.g(str2, BaseMonitor.ALARM_POINT_AUTH);
        i.g(str3, "license");
        this.media_code = str;
        this.auth = str2;
        this.license = str3;
    }

    public static /* synthetic */ GetVodPlayUrlBean copy$default(GetVodPlayUrlBean getVodPlayUrlBean, String str, String str2, String str3, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = getVodPlayUrlBean.media_code;
        }
        if ((i10 & 2) != 0) {
            str2 = getVodPlayUrlBean.auth;
        }
        if ((i10 & 4) != 0) {
            str3 = getVodPlayUrlBean.license;
        }
        return getVodPlayUrlBean.copy(str, str2, str3);
    }

    public final String component1() {
        return this.media_code;
    }

    public final String component2() {
        return this.auth;
    }

    public final String component3() {
        return this.license;
    }

    public final GetVodPlayUrlBean copy(String str, String str2, String str3) {
        i.g(str, "media_code");
        i.g(str2, BaseMonitor.ALARM_POINT_AUTH);
        i.g(str3, "license");
        return new GetVodPlayUrlBean(str, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GetVodPlayUrlBean)) {
            return false;
        }
        GetVodPlayUrlBean getVodPlayUrlBean = (GetVodPlayUrlBean) obj;
        return i.b(this.media_code, getVodPlayUrlBean.media_code) && i.b(this.auth, getVodPlayUrlBean.auth) && i.b(this.license, getVodPlayUrlBean.license);
    }

    public final String getAuth() {
        return this.auth;
    }

    public final String getLicense() {
        return this.license;
    }

    public final String getMedia_code() {
        return this.media_code;
    }

    public int hashCode() {
        return (((this.media_code.hashCode() * 31) + this.auth.hashCode()) * 31) + this.license.hashCode();
    }

    public final void setAuth(String str) {
        i.g(str, "<set-?>");
        this.auth = str;
    }

    public final void setLicense(String str) {
        i.g(str, "<set-?>");
        this.license = str;
    }

    public final void setMedia_code(String str) {
        i.g(str, "<set-?>");
        this.media_code = str;
    }

    public String toString() {
        return "GetVodPlayUrlBean(media_code=" + this.media_code + ", auth=" + this.auth + ", license=" + this.license + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
