package mobile.com.requestframe.utils.response;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.io.Serializable;
import java.util.List;
import t9.i;

/* loaded from: classes3.dex */
public final class ShelveAddress implements Serializable {
    private String audioType;
    private String bitRateType;
    private String encodeFormat;
    private List<String> playUrlList;
    private String quality;
    private String urlInvalidTime;

    public ShelveAddress(List<String> list, String str, String str2, String str3, String str4, String str5) {
        i.g(list, "playUrlList");
        this.playUrlList = list;
        this.urlInvalidTime = str;
        this.quality = str2;
        this.bitRateType = str3;
        this.encodeFormat = str4;
        this.audioType = str5;
    }

    public static /* synthetic */ ShelveAddress copy$default(ShelveAddress shelveAddress, List list, String str, String str2, String str3, String str4, String str5, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = shelveAddress.playUrlList;
        }
        if ((i10 & 2) != 0) {
            str = shelveAddress.urlInvalidTime;
        }
        String str6 = str;
        if ((i10 & 4) != 0) {
            str2 = shelveAddress.quality;
        }
        String str7 = str2;
        if ((i10 & 8) != 0) {
            str3 = shelveAddress.bitRateType;
        }
        String str8 = str3;
        if ((i10 & 16) != 0) {
            str4 = shelveAddress.encodeFormat;
        }
        String str9 = str4;
        if ((i10 & 32) != 0) {
            str5 = shelveAddress.audioType;
        }
        return shelveAddress.copy(list, str6, str7, str8, str9, str5);
    }

    public final List<String> component1() {
        return this.playUrlList;
    }

    public final String component2() {
        return this.urlInvalidTime;
    }

    public final String component3() {
        return this.quality;
    }

    public final String component4() {
        return this.bitRateType;
    }

    public final String component5() {
        return this.encodeFormat;
    }

    public final String component6() {
        return this.audioType;
    }

    public final ShelveAddress copy(List<String> list, String str, String str2, String str3, String str4, String str5) {
        i.g(list, "playUrlList");
        return new ShelveAddress(list, str, str2, str3, str4, str5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ShelveAddress)) {
            return false;
        }
        ShelveAddress shelveAddress = (ShelveAddress) obj;
        return i.b(this.playUrlList, shelveAddress.playUrlList) && i.b(this.urlInvalidTime, shelveAddress.urlInvalidTime) && i.b(this.quality, shelveAddress.quality) && i.b(this.bitRateType, shelveAddress.bitRateType) && i.b(this.encodeFormat, shelveAddress.encodeFormat) && i.b(this.audioType, shelveAddress.audioType);
    }

    public final String getAudioType() {
        return this.audioType;
    }

    public final String getBitRateType() {
        return this.bitRateType;
    }

    public final String getEncodeFormat() {
        return this.encodeFormat;
    }

    public final List<String> getPlayUrlList() {
        return this.playUrlList;
    }

    public final String getQuality() {
        return this.quality;
    }

    public final String getUrlInvalidTime() {
        return this.urlInvalidTime;
    }

    public int hashCode() {
        int hashCode = this.playUrlList.hashCode() * 31;
        String str = this.urlInvalidTime;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.quality;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.bitRateType;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.encodeFormat;
        int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.audioType;
        return hashCode5 + (str5 != null ? str5.hashCode() : 0);
    }

    public final void setAudioType(String str) {
        this.audioType = str;
    }

    public final void setBitRateType(String str) {
        this.bitRateType = str;
    }

    public final void setEncodeFormat(String str) {
        this.encodeFormat = str;
    }

    public final void setPlayUrlList(List<String> list) {
        i.g(list, "<set-?>");
        this.playUrlList = list;
    }

    public final void setQuality(String str) {
        this.quality = str;
    }

    public final void setUrlInvalidTime(String str) {
        this.urlInvalidTime = str;
    }

    public String toString() {
        return "ShelveAddress(playUrlList=" + this.playUrlList + ", urlInvalidTime=" + this.urlInvalidTime + ", quality=" + this.quality + ", bitRateType=" + this.bitRateType + ", encodeFormat=" + this.encodeFormat + ", audioType=" + this.audioType + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
