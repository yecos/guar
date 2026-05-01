package mobile.com.requestframe.utils.response;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.util.List;
import t9.i;

/* loaded from: classes3.dex */
public final class GetProgramData {
    private String alias;
    private String channelCode;
    private int channelNumber;
    private String name;
    private List<Program> programList;
    private String restricted;
    private String supportBusiness;
    private String tags;

    public GetProgramData(String str, String str2, String str3, int i10, String str4, String str5, List<Program> list, String str6) {
        i.g(str, "channelCode");
        i.g(str2, "name");
        this.channelCode = str;
        this.name = str2;
        this.supportBusiness = str3;
        this.channelNumber = i10;
        this.tags = str4;
        this.restricted = str5;
        this.programList = list;
        this.alias = str6;
    }

    public final String component1() {
        return this.channelCode;
    }

    public final String component2() {
        return this.name;
    }

    public final String component3() {
        return this.supportBusiness;
    }

    public final int component4() {
        return this.channelNumber;
    }

    public final String component5() {
        return this.tags;
    }

    public final String component6() {
        return this.restricted;
    }

    public final List<Program> component7() {
        return this.programList;
    }

    public final String component8() {
        return this.alias;
    }

    public final GetProgramData copy(String str, String str2, String str3, int i10, String str4, String str5, List<Program> list, String str6) {
        i.g(str, "channelCode");
        i.g(str2, "name");
        return new GetProgramData(str, str2, str3, i10, str4, str5, list, str6);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GetProgramData)) {
            return false;
        }
        GetProgramData getProgramData = (GetProgramData) obj;
        return i.b(this.channelCode, getProgramData.channelCode) && i.b(this.name, getProgramData.name) && i.b(this.supportBusiness, getProgramData.supportBusiness) && this.channelNumber == getProgramData.channelNumber && i.b(this.tags, getProgramData.tags) && i.b(this.restricted, getProgramData.restricted) && i.b(this.programList, getProgramData.programList) && i.b(this.alias, getProgramData.alias);
    }

    public final String getAlias() {
        return this.alias;
    }

    public final String getChannelCode() {
        return this.channelCode;
    }

    public final int getChannelNumber() {
        return this.channelNumber;
    }

    public final String getName() {
        return this.name;
    }

    public final List<Program> getProgramList() {
        return this.programList;
    }

    public final String getRestricted() {
        return this.restricted;
    }

    public final String getSupportBusiness() {
        return this.supportBusiness;
    }

    public final String getTags() {
        return this.tags;
    }

    public int hashCode() {
        int hashCode = ((this.channelCode.hashCode() * 31) + this.name.hashCode()) * 31;
        String str = this.supportBusiness;
        int hashCode2 = (((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.channelNumber) * 31;
        String str2 = this.tags;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.restricted;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        List<Program> list = this.programList;
        int hashCode5 = (hashCode4 + (list == null ? 0 : list.hashCode())) * 31;
        String str4 = this.alias;
        return hashCode5 + (str4 != null ? str4.hashCode() : 0);
    }

    public final void setAlias(String str) {
        this.alias = str;
    }

    public final void setChannelCode(String str) {
        i.g(str, "<set-?>");
        this.channelCode = str;
    }

    public final void setChannelNumber(int i10) {
        this.channelNumber = i10;
    }

    public final void setName(String str) {
        i.g(str, "<set-?>");
        this.name = str;
    }

    public final void setProgramList(List<Program> list) {
        this.programList = list;
    }

    public final void setRestricted(String str) {
        this.restricted = str;
    }

    public final void setSupportBusiness(String str) {
        this.supportBusiness = str;
    }

    public final void setTags(String str) {
        this.tags = str;
    }

    public String toString() {
        return "GetProgramData(channelCode=" + this.channelCode + ", name=" + this.name + ", supportBusiness=" + this.supportBusiness + ", channelNumber=" + this.channelNumber + ", tags=" + this.tags + ", restricted=" + this.restricted + ", programList=" + this.programList + ", alias=" + this.alias + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
