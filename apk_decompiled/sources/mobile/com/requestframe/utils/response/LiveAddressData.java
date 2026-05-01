package mobile.com.requestframe.utils.response;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.util.List;
import t9.i;

/* loaded from: classes3.dex */
public final class LiveAddressData {
    private String audioType;
    private String bitRateType;
    private String encodeFormat;
    private String playCode;
    private List<String> playUrlList;
    private String quality;

    public LiveAddressData(List<String> list, String str, String str2, String str3, String str4, String str5) {
        this.playUrlList = list;
        this.quality = str;
        this.bitRateType = str2;
        this.encodeFormat = str3;
        this.audioType = str4;
        this.playCode = str5;
    }

    public static /* synthetic */ LiveAddressData copy$default(LiveAddressData liveAddressData, List list, String str, String str2, String str3, String str4, String str5, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = liveAddressData.playUrlList;
        }
        if ((i10 & 2) != 0) {
            str = liveAddressData.quality;
        }
        String str6 = str;
        if ((i10 & 4) != 0) {
            str2 = liveAddressData.bitRateType;
        }
        String str7 = str2;
        if ((i10 & 8) != 0) {
            str3 = liveAddressData.encodeFormat;
        }
        String str8 = str3;
        if ((i10 & 16) != 0) {
            str4 = liveAddressData.audioType;
        }
        String str9 = str4;
        if ((i10 & 32) != 0) {
            str5 = liveAddressData.playCode;
        }
        return liveAddressData.copy(list, str6, str7, str8, str9, str5);
    }

    public final List<String> component1() {
        return this.playUrlList;
    }

    public final String component2() {
        return this.quality;
    }

    public final String component3() {
        return this.bitRateType;
    }

    public final String component4() {
        return this.encodeFormat;
    }

    public final String component5() {
        return this.audioType;
    }

    public final String component6() {
        return this.playCode;
    }

    public final LiveAddressData copy(List<String> list, String str, String str2, String str3, String str4, String str5) {
        return new LiveAddressData(list, str, str2, str3, str4, str5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LiveAddressData)) {
            return false;
        }
        LiveAddressData liveAddressData = (LiveAddressData) obj;
        return i.b(this.playUrlList, liveAddressData.playUrlList) && i.b(this.quality, liveAddressData.quality) && i.b(this.bitRateType, liveAddressData.bitRateType) && i.b(this.encodeFormat, liveAddressData.encodeFormat) && i.b(this.audioType, liveAddressData.audioType) && i.b(this.playCode, liveAddressData.playCode);
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

    public final String getPlayCode() {
        return this.playCode;
    }

    public final List<String> getPlayUrlList() {
        return this.playUrlList;
    }

    public final String getQuality() {
        return this.quality;
    }

    public int hashCode() {
        List<String> list = this.playUrlList;
        int hashCode = (list == null ? 0 : list.hashCode()) * 31;
        String str = this.quality;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.bitRateType;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.encodeFormat;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.audioType;
        int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.playCode;
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

    public final void setPlayCode(String str) {
        this.playCode = str;
    }

    public final void setPlayUrlList(List<String> list) {
        this.playUrlList = list;
    }

    public final void setQuality(String str) {
        this.quality = str;
    }

    public String toString() {
        return "LiveAddressData(playUrlList=" + this.playUrlList + ", quality=" + this.quality + ", bitRateType=" + this.bitRateType + ", encodeFormat=" + this.encodeFormat + ", audioType=" + this.audioType + ", playCode=" + this.playCode + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
