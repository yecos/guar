package mobile.com.requestframe.utils.response;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.io.Serializable;
import t9.i;

/* loaded from: classes3.dex */
public final class LiveAddress implements Serializable {
    private String AVFormat;
    private String cdnType;
    private String license;
    private String playCode;
    private String quality;
    private String tag;

    public LiveAddress(String str, String str2, String str3, String str4, String str5, String str6) {
        i.g(str2, "cdnType");
        i.g(str4, "license");
        i.g(str5, "tag");
        i.g(str6, "AVFormat");
        this.playCode = str;
        this.cdnType = str2;
        this.quality = str3;
        this.license = str4;
        this.tag = str5;
        this.AVFormat = str6;
    }

    public static /* synthetic */ LiveAddress copy$default(LiveAddress liveAddress, String str, String str2, String str3, String str4, String str5, String str6, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = liveAddress.playCode;
        }
        if ((i10 & 2) != 0) {
            str2 = liveAddress.cdnType;
        }
        String str7 = str2;
        if ((i10 & 4) != 0) {
            str3 = liveAddress.quality;
        }
        String str8 = str3;
        if ((i10 & 8) != 0) {
            str4 = liveAddress.license;
        }
        String str9 = str4;
        if ((i10 & 16) != 0) {
            str5 = liveAddress.tag;
        }
        String str10 = str5;
        if ((i10 & 32) != 0) {
            str6 = liveAddress.AVFormat;
        }
        return liveAddress.copy(str, str7, str8, str9, str10, str6);
    }

    public final String component1() {
        return this.playCode;
    }

    public final String component2() {
        return this.cdnType;
    }

    public final String component3() {
        return this.quality;
    }

    public final String component4() {
        return this.license;
    }

    public final String component5() {
        return this.tag;
    }

    public final String component6() {
        return this.AVFormat;
    }

    public final LiveAddress copy(String str, String str2, String str3, String str4, String str5, String str6) {
        i.g(str2, "cdnType");
        i.g(str4, "license");
        i.g(str5, "tag");
        i.g(str6, "AVFormat");
        return new LiveAddress(str, str2, str3, str4, str5, str6);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LiveAddress)) {
            return false;
        }
        LiveAddress liveAddress = (LiveAddress) obj;
        return i.b(this.playCode, liveAddress.playCode) && i.b(this.cdnType, liveAddress.cdnType) && i.b(this.quality, liveAddress.quality) && i.b(this.license, liveAddress.license) && i.b(this.tag, liveAddress.tag) && i.b(this.AVFormat, liveAddress.AVFormat);
    }

    public final String getAVFormat() {
        return this.AVFormat;
    }

    public final String getCdnType() {
        return this.cdnType;
    }

    public final String getLicense() {
        return this.license;
    }

    public final String getPlayCode() {
        return this.playCode;
    }

    public final String getQuality() {
        return this.quality;
    }

    public final String getTag() {
        return this.tag;
    }

    public int hashCode() {
        String str = this.playCode;
        int hashCode = (((str == null ? 0 : str.hashCode()) * 31) + this.cdnType.hashCode()) * 31;
        String str2 = this.quality;
        return ((((((hashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.license.hashCode()) * 31) + this.tag.hashCode()) * 31) + this.AVFormat.hashCode();
    }

    public final void setAVFormat(String str) {
        i.g(str, "<set-?>");
        this.AVFormat = str;
    }

    public final void setCdnType(String str) {
        i.g(str, "<set-?>");
        this.cdnType = str;
    }

    public final void setLicense(String str) {
        i.g(str, "<set-?>");
        this.license = str;
    }

    public final void setPlayCode(String str) {
        this.playCode = str;
    }

    public final void setQuality(String str) {
        this.quality = str;
    }

    public final void setTag(String str) {
        i.g(str, "<set-?>");
        this.tag = str;
    }

    public String toString() {
        return "LiveAddress(playCode=" + this.playCode + ", cdnType=" + this.cdnType + ", quality=" + this.quality + ", license=" + this.license + ", tag=" + this.tag + ", AVFormat=" + this.AVFormat + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
