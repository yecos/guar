package mobile.com.requestframe.utils.response;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import t9.i;

/* loaded from: classes3.dex */
public final class CdnUrl {
    private String tag;
    private String url;

    public CdnUrl(String str, String str2) {
        i.g(str, "tag");
        i.g(str2, "url");
        this.tag = str;
        this.url = str2;
    }

    public static /* synthetic */ CdnUrl copy$default(CdnUrl cdnUrl, String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = cdnUrl.tag;
        }
        if ((i10 & 2) != 0) {
            str2 = cdnUrl.url;
        }
        return cdnUrl.copy(str, str2);
    }

    public final String component1() {
        return this.tag;
    }

    public final String component2() {
        return this.url;
    }

    public final CdnUrl copy(String str, String str2) {
        i.g(str, "tag");
        i.g(str2, "url");
        return new CdnUrl(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CdnUrl)) {
            return false;
        }
        CdnUrl cdnUrl = (CdnUrl) obj;
        return i.b(this.tag, cdnUrl.tag) && i.b(this.url, cdnUrl.url);
    }

    public final String getTag() {
        return this.tag;
    }

    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        return (this.tag.hashCode() * 31) + this.url.hashCode();
    }

    public final void setTag(String str) {
        i.g(str, "<set-?>");
        this.tag = str;
    }

    public final void setUrl(String str) {
        i.g(str, "<set-?>");
        this.url = str;
    }

    public String toString() {
        return "CdnUrl(tag=" + this.tag + ", url=" + this.url + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
