package mobile.com.requestframe.utils.response;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import t9.i;

/* loaded from: classes3.dex */
public final class PlayInfo {
    private String idx_url;
    private String idx_url2;
    private String media_code;
    private String media_format;
    private String media_url;
    private String media_url2;
    private String metadata;
    private String server_code;
    private String server_code2;
    private String snapshot_url;
    private String snapshot_url2;
    private int status_code;

    public PlayInfo(int i10, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
        i.g(str, "media_code");
        i.g(str2, "server_code");
        i.g(str3, "media_url");
        i.g(str4, "idx_url");
        i.g(str5, "snapshot_url");
        i.g(str6, "server_code2");
        i.g(str7, "media_url2");
        i.g(str8, "idx_url2");
        i.g(str9, "snapshot_url2");
        i.g(str10, "media_format");
        i.g(str11, "metadata");
        this.status_code = i10;
        this.media_code = str;
        this.server_code = str2;
        this.media_url = str3;
        this.idx_url = str4;
        this.snapshot_url = str5;
        this.server_code2 = str6;
        this.media_url2 = str7;
        this.idx_url2 = str8;
        this.snapshot_url2 = str9;
        this.media_format = str10;
        this.metadata = str11;
    }

    public final int component1() {
        return this.status_code;
    }

    public final String component10() {
        return this.snapshot_url2;
    }

    public final String component11() {
        return this.media_format;
    }

    public final String component12() {
        return this.metadata;
    }

    public final String component2() {
        return this.media_code;
    }

    public final String component3() {
        return this.server_code;
    }

    public final String component4() {
        return this.media_url;
    }

    public final String component5() {
        return this.idx_url;
    }

    public final String component6() {
        return this.snapshot_url;
    }

    public final String component7() {
        return this.server_code2;
    }

    public final String component8() {
        return this.media_url2;
    }

    public final String component9() {
        return this.idx_url2;
    }

    public final PlayInfo copy(int i10, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
        i.g(str, "media_code");
        i.g(str2, "server_code");
        i.g(str3, "media_url");
        i.g(str4, "idx_url");
        i.g(str5, "snapshot_url");
        i.g(str6, "server_code2");
        i.g(str7, "media_url2");
        i.g(str8, "idx_url2");
        i.g(str9, "snapshot_url2");
        i.g(str10, "media_format");
        i.g(str11, "metadata");
        return new PlayInfo(i10, str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PlayInfo)) {
            return false;
        }
        PlayInfo playInfo = (PlayInfo) obj;
        return this.status_code == playInfo.status_code && i.b(this.media_code, playInfo.media_code) && i.b(this.server_code, playInfo.server_code) && i.b(this.media_url, playInfo.media_url) && i.b(this.idx_url, playInfo.idx_url) && i.b(this.snapshot_url, playInfo.snapshot_url) && i.b(this.server_code2, playInfo.server_code2) && i.b(this.media_url2, playInfo.media_url2) && i.b(this.idx_url2, playInfo.idx_url2) && i.b(this.snapshot_url2, playInfo.snapshot_url2) && i.b(this.media_format, playInfo.media_format) && i.b(this.metadata, playInfo.metadata);
    }

    public final String getIdx_url() {
        return this.idx_url;
    }

    public final String getIdx_url2() {
        return this.idx_url2;
    }

    public final String getMedia_code() {
        return this.media_code;
    }

    public final String getMedia_format() {
        return this.media_format;
    }

    public final String getMedia_url() {
        return this.media_url;
    }

    public final String getMedia_url2() {
        return this.media_url2;
    }

    public final String getMetadata() {
        return this.metadata;
    }

    public final String getServer_code() {
        return this.server_code;
    }

    public final String getServer_code2() {
        return this.server_code2;
    }

    public final String getSnapshot_url() {
        return this.snapshot_url;
    }

    public final String getSnapshot_url2() {
        return this.snapshot_url2;
    }

    public final int getStatus_code() {
        return this.status_code;
    }

    public int hashCode() {
        return (((((((((((((((((((((this.status_code * 31) + this.media_code.hashCode()) * 31) + this.server_code.hashCode()) * 31) + this.media_url.hashCode()) * 31) + this.idx_url.hashCode()) * 31) + this.snapshot_url.hashCode()) * 31) + this.server_code2.hashCode()) * 31) + this.media_url2.hashCode()) * 31) + this.idx_url2.hashCode()) * 31) + this.snapshot_url2.hashCode()) * 31) + this.media_format.hashCode()) * 31) + this.metadata.hashCode();
    }

    public final void setIdx_url(String str) {
        i.g(str, "<set-?>");
        this.idx_url = str;
    }

    public final void setIdx_url2(String str) {
        i.g(str, "<set-?>");
        this.idx_url2 = str;
    }

    public final void setMedia_code(String str) {
        i.g(str, "<set-?>");
        this.media_code = str;
    }

    public final void setMedia_format(String str) {
        i.g(str, "<set-?>");
        this.media_format = str;
    }

    public final void setMedia_url(String str) {
        i.g(str, "<set-?>");
        this.media_url = str;
    }

    public final void setMedia_url2(String str) {
        i.g(str, "<set-?>");
        this.media_url2 = str;
    }

    public final void setMetadata(String str) {
        i.g(str, "<set-?>");
        this.metadata = str;
    }

    public final void setServer_code(String str) {
        i.g(str, "<set-?>");
        this.server_code = str;
    }

    public final void setServer_code2(String str) {
        i.g(str, "<set-?>");
        this.server_code2 = str;
    }

    public final void setSnapshot_url(String str) {
        i.g(str, "<set-?>");
        this.snapshot_url = str;
    }

    public final void setSnapshot_url2(String str) {
        i.g(str, "<set-?>");
        this.snapshot_url2 = str;
    }

    public final void setStatus_code(int i10) {
        this.status_code = i10;
    }

    public String toString() {
        return "PlayInfo(status_code=" + this.status_code + ", media_code=" + this.media_code + ", server_code=" + this.server_code + ", media_url=" + this.media_url + ", idx_url=" + this.idx_url + ", snapshot_url=" + this.snapshot_url + ", server_code2=" + this.server_code2 + ", media_url2=" + this.media_url2 + ", idx_url2=" + this.idx_url2 + ", snapshot_url2=" + this.snapshot_url2 + ", media_format=" + this.media_format + ", metadata=" + this.metadata + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
