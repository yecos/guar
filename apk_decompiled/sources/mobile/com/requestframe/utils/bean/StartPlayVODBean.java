package mobile.com.requestframe.utils.bean;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.util.Arrays;
import t9.i;

/* loaded from: classes3.dex */
public final class StartPlayVODBean {
    private String authType;
    private Integer columnId;
    private String contentId;
    private int[] episodeNumberList;
    private String portalCode;
    private String seriesContentId;
    private int startTime;
    private String type;
    private String userId;
    private String userToken;

    public StartPlayVODBean(String str, String str2, String str3, String str4, int[] iArr, String str5, Integer num, String str6, String str7, int i10) {
        i.g(str, "userToken");
        i.g(str2, "userId");
        i.g(str3, "portalCode");
        i.g(str5, "type");
        i.g(str6, "contentId");
        this.userToken = str;
        this.userId = str2;
        this.portalCode = str3;
        this.authType = str4;
        this.episodeNumberList = iArr;
        this.type = str5;
        this.columnId = num;
        this.contentId = str6;
        this.seriesContentId = str7;
        this.startTime = i10;
    }

    public final String component1() {
        return this.userToken;
    }

    public final int component10() {
        return this.startTime;
    }

    public final String component2() {
        return this.userId;
    }

    public final String component3() {
        return this.portalCode;
    }

    public final String component4() {
        return this.authType;
    }

    public final int[] component5() {
        return this.episodeNumberList;
    }

    public final String component6() {
        return this.type;
    }

    public final Integer component7() {
        return this.columnId;
    }

    public final String component8() {
        return this.contentId;
    }

    public final String component9() {
        return this.seriesContentId;
    }

    public final StartPlayVODBean copy(String str, String str2, String str3, String str4, int[] iArr, String str5, Integer num, String str6, String str7, int i10) {
        i.g(str, "userToken");
        i.g(str2, "userId");
        i.g(str3, "portalCode");
        i.g(str5, "type");
        i.g(str6, "contentId");
        return new StartPlayVODBean(str, str2, str3, str4, iArr, str5, num, str6, str7, i10);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StartPlayVODBean)) {
            return false;
        }
        StartPlayVODBean startPlayVODBean = (StartPlayVODBean) obj;
        return i.b(this.userToken, startPlayVODBean.userToken) && i.b(this.userId, startPlayVODBean.userId) && i.b(this.portalCode, startPlayVODBean.portalCode) && i.b(this.authType, startPlayVODBean.authType) && i.b(this.episodeNumberList, startPlayVODBean.episodeNumberList) && i.b(this.type, startPlayVODBean.type) && i.b(this.columnId, startPlayVODBean.columnId) && i.b(this.contentId, startPlayVODBean.contentId) && i.b(this.seriesContentId, startPlayVODBean.seriesContentId) && this.startTime == startPlayVODBean.startTime;
    }

    public final String getAuthType() {
        return this.authType;
    }

    public final Integer getColumnId() {
        return this.columnId;
    }

    public final String getContentId() {
        return this.contentId;
    }

    public final int[] getEpisodeNumberList() {
        return this.episodeNumberList;
    }

    public final String getPortalCode() {
        return this.portalCode;
    }

    public final String getSeriesContentId() {
        return this.seriesContentId;
    }

    public final int getStartTime() {
        return this.startTime;
    }

    public final String getType() {
        return this.type;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final String getUserToken() {
        return this.userToken;
    }

    public int hashCode() {
        int hashCode = ((((this.userToken.hashCode() * 31) + this.userId.hashCode()) * 31) + this.portalCode.hashCode()) * 31;
        String str = this.authType;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        int[] iArr = this.episodeNumberList;
        int hashCode3 = (((hashCode2 + (iArr == null ? 0 : Arrays.hashCode(iArr))) * 31) + this.type.hashCode()) * 31;
        Integer num = this.columnId;
        int hashCode4 = (((hashCode3 + (num == null ? 0 : num.hashCode())) * 31) + this.contentId.hashCode()) * 31;
        String str2 = this.seriesContentId;
        return ((hashCode4 + (str2 != null ? str2.hashCode() : 0)) * 31) + this.startTime;
    }

    public final void setAuthType(String str) {
        this.authType = str;
    }

    public final void setColumnId(Integer num) {
        this.columnId = num;
    }

    public final void setContentId(String str) {
        i.g(str, "<set-?>");
        this.contentId = str;
    }

    public final void setEpisodeNumberList(int[] iArr) {
        this.episodeNumberList = iArr;
    }

    public final void setPortalCode(String str) {
        i.g(str, "<set-?>");
        this.portalCode = str;
    }

    public final void setSeriesContentId(String str) {
        this.seriesContentId = str;
    }

    public final void setStartTime(int i10) {
        this.startTime = i10;
    }

    public final void setType(String str) {
        i.g(str, "<set-?>");
        this.type = str;
    }

    public final void setUserId(String str) {
        i.g(str, "<set-?>");
        this.userId = str;
    }

    public final void setUserToken(String str) {
        i.g(str, "<set-?>");
        this.userToken = str;
    }

    public String toString() {
        return "StartPlayVODBean(userToken=" + this.userToken + ", userId=" + this.userId + ", portalCode=" + this.portalCode + ", authType=" + this.authType + ", episodeNumberList=" + Arrays.toString(this.episodeNumberList) + ", type=" + this.type + ", columnId=" + this.columnId + ", contentId=" + this.contentId + ", seriesContentId=" + this.seriesContentId + ", startTime=" + this.startTime + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
