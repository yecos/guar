package mobile.com.requestframe.utils.response;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.io.Serializable;
import java.util.List;
import t9.i;

/* loaded from: classes3.dex */
public final class ChildColumnList implements Serializable {
    private String alias;
    private String brief;
    private String code;
    private String free;
    private int id;
    private String name;
    private String orderFlag;
    private int parentId;
    private List<? extends PosterList> posterList;
    private String recmdTitle;
    private String remark;
    private String restricted;
    private Integer sequence;
    private String style;
    private String timeNotice;
    private String trySee;
    private String type;

    public ChildColumnList(int i10, int i11, String str, String str2, String str3, String str4, String str5, String str6, String str7, Integer num, String str8, String str9, String str10, String str11, List<? extends PosterList> list, String str12, String str13) {
        i.g(str, "name");
        this.id = i10;
        this.parentId = i11;
        this.name = str;
        this.brief = str2;
        this.timeNotice = str3;
        this.recmdTitle = str4;
        this.trySee = str5;
        this.type = str6;
        this.orderFlag = str7;
        this.sequence = num;
        this.code = str8;
        this.remark = str9;
        this.alias = str10;
        this.restricted = str11;
        this.posterList = list;
        this.free = str12;
        this.style = str13;
    }

    public final int component1() {
        return this.id;
    }

    public final Integer component10() {
        return this.sequence;
    }

    public final String component11() {
        return this.code;
    }

    public final String component12() {
        return this.remark;
    }

    public final String component13() {
        return this.alias;
    }

    public final String component14() {
        return this.restricted;
    }

    public final List<PosterList> component15() {
        return this.posterList;
    }

    public final String component16() {
        return this.free;
    }

    public final String component17() {
        return this.style;
    }

    public final int component2() {
        return this.parentId;
    }

    public final String component3() {
        return this.name;
    }

    public final String component4() {
        return this.brief;
    }

    public final String component5() {
        return this.timeNotice;
    }

    public final String component6() {
        return this.recmdTitle;
    }

    public final String component7() {
        return this.trySee;
    }

    public final String component8() {
        return this.type;
    }

    public final String component9() {
        return this.orderFlag;
    }

    public final ChildColumnList copy(int i10, int i11, String str, String str2, String str3, String str4, String str5, String str6, String str7, Integer num, String str8, String str9, String str10, String str11, List<? extends PosterList> list, String str12, String str13) {
        i.g(str, "name");
        return new ChildColumnList(i10, i11, str, str2, str3, str4, str5, str6, str7, num, str8, str9, str10, str11, list, str12, str13);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ChildColumnList)) {
            return false;
        }
        ChildColumnList childColumnList = (ChildColumnList) obj;
        return this.id == childColumnList.id && this.parentId == childColumnList.parentId && i.b(this.name, childColumnList.name) && i.b(this.brief, childColumnList.brief) && i.b(this.timeNotice, childColumnList.timeNotice) && i.b(this.recmdTitle, childColumnList.recmdTitle) && i.b(this.trySee, childColumnList.trySee) && i.b(this.type, childColumnList.type) && i.b(this.orderFlag, childColumnList.orderFlag) && i.b(this.sequence, childColumnList.sequence) && i.b(this.code, childColumnList.code) && i.b(this.remark, childColumnList.remark) && i.b(this.alias, childColumnList.alias) && i.b(this.restricted, childColumnList.restricted) && i.b(this.posterList, childColumnList.posterList) && i.b(this.free, childColumnList.free) && i.b(this.style, childColumnList.style);
    }

    public final String getAlias() {
        return this.alias;
    }

    public final String getBrief() {
        return this.brief;
    }

    public final String getCode() {
        return this.code;
    }

    public final String getFree() {
        return this.free;
    }

    public final int getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final String getOrderFlag() {
        return this.orderFlag;
    }

    public final int getParentId() {
        return this.parentId;
    }

    public final List<PosterList> getPosterList() {
        return this.posterList;
    }

    public final String getRecmdTitle() {
        return this.recmdTitle;
    }

    public final String getRemark() {
        return this.remark;
    }

    public final String getRestricted() {
        return this.restricted;
    }

    public final Integer getSequence() {
        return this.sequence;
    }

    public final String getStyle() {
        return this.style;
    }

    public final String getTimeNotice() {
        return this.timeNotice;
    }

    public final String getTrySee() {
        return this.trySee;
    }

    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        int hashCode = ((((this.id * 31) + this.parentId) * 31) + this.name.hashCode()) * 31;
        String str = this.brief;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.timeNotice;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.recmdTitle;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.trySee;
        int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.type;
        int hashCode6 = (hashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.orderFlag;
        int hashCode7 = (hashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31;
        Integer num = this.sequence;
        int hashCode8 = (hashCode7 + (num == null ? 0 : num.hashCode())) * 31;
        String str7 = this.code;
        int hashCode9 = (hashCode8 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.remark;
        int hashCode10 = (hashCode9 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.alias;
        int hashCode11 = (hashCode10 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.restricted;
        int hashCode12 = (hashCode11 + (str10 == null ? 0 : str10.hashCode())) * 31;
        List<? extends PosterList> list = this.posterList;
        int hashCode13 = (hashCode12 + (list == null ? 0 : list.hashCode())) * 31;
        String str11 = this.free;
        int hashCode14 = (hashCode13 + (str11 == null ? 0 : str11.hashCode())) * 31;
        String str12 = this.style;
        return hashCode14 + (str12 != null ? str12.hashCode() : 0);
    }

    public final void setAlias(String str) {
        this.alias = str;
    }

    public final void setBrief(String str) {
        this.brief = str;
    }

    public final void setCode(String str) {
        this.code = str;
    }

    public final void setFree(String str) {
        this.free = str;
    }

    public final void setId(int i10) {
        this.id = i10;
    }

    public final void setName(String str) {
        i.g(str, "<set-?>");
        this.name = str;
    }

    public final void setOrderFlag(String str) {
        this.orderFlag = str;
    }

    public final void setParentId(int i10) {
        this.parentId = i10;
    }

    public final void setPosterList(List<? extends PosterList> list) {
        this.posterList = list;
    }

    public final void setRecmdTitle(String str) {
        this.recmdTitle = str;
    }

    public final void setRemark(String str) {
        this.remark = str;
    }

    public final void setRestricted(String str) {
        this.restricted = str;
    }

    public final void setSequence(Integer num) {
        this.sequence = num;
    }

    public final void setStyle(String str) {
        this.style = str;
    }

    public final void setTimeNotice(String str) {
        this.timeNotice = str;
    }

    public final void setTrySee(String str) {
        this.trySee = str;
    }

    public final void setType(String str) {
        this.type = str;
    }

    public String toString() {
        return "ChildColumnList(id=" + this.id + ", parentId=" + this.parentId + ", name=" + this.name + ", brief=" + this.brief + ", timeNotice=" + this.timeNotice + ", recmdTitle=" + this.recmdTitle + ", trySee=" + this.trySee + ", type=" + this.type + ", orderFlag=" + this.orderFlag + ", sequence=" + this.sequence + ", code=" + this.code + ", remark=" + this.remark + ", alias=" + this.alias + ", restricted=" + this.restricted + ", posterList=" + this.posterList + ", free=" + this.free + ", style=" + this.style + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
