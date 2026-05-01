package mobile.com.requestframe.utils.bean;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import t9.i;

/* loaded from: classes3.dex */
public final class ColumnRecommendResourceRequestBean {
    private int columnId;
    private String columnType;
    private String portalCode;
    private String userId;
    private String userToken;

    public ColumnRecommendResourceRequestBean(String str, String str2, String str3, int i10, String str4) {
        i.g(str, "userToken");
        i.g(str2, "userId");
        i.g(str3, "portalCode");
        i.g(str4, "columnType");
        this.userToken = str;
        this.userId = str2;
        this.portalCode = str3;
        this.columnId = i10;
        this.columnType = str4;
    }

    public static /* synthetic */ ColumnRecommendResourceRequestBean copy$default(ColumnRecommendResourceRequestBean columnRecommendResourceRequestBean, String str, String str2, String str3, int i10, String str4, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = columnRecommendResourceRequestBean.userToken;
        }
        if ((i11 & 2) != 0) {
            str2 = columnRecommendResourceRequestBean.userId;
        }
        String str5 = str2;
        if ((i11 & 4) != 0) {
            str3 = columnRecommendResourceRequestBean.portalCode;
        }
        String str6 = str3;
        if ((i11 & 8) != 0) {
            i10 = columnRecommendResourceRequestBean.columnId;
        }
        int i12 = i10;
        if ((i11 & 16) != 0) {
            str4 = columnRecommendResourceRequestBean.columnType;
        }
        return columnRecommendResourceRequestBean.copy(str, str5, str6, i12, str4);
    }

    public final String component1() {
        return this.userToken;
    }

    public final String component2() {
        return this.userId;
    }

    public final String component3() {
        return this.portalCode;
    }

    public final int component4() {
        return this.columnId;
    }

    public final String component5() {
        return this.columnType;
    }

    public final ColumnRecommendResourceRequestBean copy(String str, String str2, String str3, int i10, String str4) {
        i.g(str, "userToken");
        i.g(str2, "userId");
        i.g(str3, "portalCode");
        i.g(str4, "columnType");
        return new ColumnRecommendResourceRequestBean(str, str2, str3, i10, str4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ColumnRecommendResourceRequestBean)) {
            return false;
        }
        ColumnRecommendResourceRequestBean columnRecommendResourceRequestBean = (ColumnRecommendResourceRequestBean) obj;
        return i.b(this.userToken, columnRecommendResourceRequestBean.userToken) && i.b(this.userId, columnRecommendResourceRequestBean.userId) && i.b(this.portalCode, columnRecommendResourceRequestBean.portalCode) && this.columnId == columnRecommendResourceRequestBean.columnId && i.b(this.columnType, columnRecommendResourceRequestBean.columnType);
    }

    public final int getColumnId() {
        return this.columnId;
    }

    public final String getColumnType() {
        return this.columnType;
    }

    public final String getPortalCode() {
        return this.portalCode;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final String getUserToken() {
        return this.userToken;
    }

    public int hashCode() {
        return (((((((this.userToken.hashCode() * 31) + this.userId.hashCode()) * 31) + this.portalCode.hashCode()) * 31) + this.columnId) * 31) + this.columnType.hashCode();
    }

    public final void setColumnId(int i10) {
        this.columnId = i10;
    }

    public final void setColumnType(String str) {
        i.g(str, "<set-?>");
        this.columnType = str;
    }

    public final void setPortalCode(String str) {
        i.g(str, "<set-?>");
        this.portalCode = str;
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
        return "ColumnRecommendResourceRequestBean(userToken=" + this.userToken + ", userId=" + this.userId + ", portalCode=" + this.portalCode + ", columnId=" + this.columnId + ", columnType=" + this.columnType + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
