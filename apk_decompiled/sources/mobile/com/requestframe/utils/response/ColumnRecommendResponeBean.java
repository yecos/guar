package mobile.com.requestframe.utils.response;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.io.Serializable;
import t9.i;

/* loaded from: classes3.dex */
public final class ColumnRecommendResponeBean implements Serializable {
    private ColumnRecommendData data;
    private String errorMessage;
    private String returnCode;

    public ColumnRecommendResponeBean(String str, String str2, ColumnRecommendData columnRecommendData) {
        this.returnCode = str;
        this.errorMessage = str2;
        this.data = columnRecommendData;
    }

    public static /* synthetic */ ColumnRecommendResponeBean copy$default(ColumnRecommendResponeBean columnRecommendResponeBean, String str, String str2, ColumnRecommendData columnRecommendData, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = columnRecommendResponeBean.returnCode;
        }
        if ((i10 & 2) != 0) {
            str2 = columnRecommendResponeBean.errorMessage;
        }
        if ((i10 & 4) != 0) {
            columnRecommendData = columnRecommendResponeBean.data;
        }
        return columnRecommendResponeBean.copy(str, str2, columnRecommendData);
    }

    public final String component1() {
        return this.returnCode;
    }

    public final String component2() {
        return this.errorMessage;
    }

    public final ColumnRecommendData component3() {
        return this.data;
    }

    public final ColumnRecommendResponeBean copy(String str, String str2, ColumnRecommendData columnRecommendData) {
        return new ColumnRecommendResponeBean(str, str2, columnRecommendData);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ColumnRecommendResponeBean)) {
            return false;
        }
        ColumnRecommendResponeBean columnRecommendResponeBean = (ColumnRecommendResponeBean) obj;
        return i.b(this.returnCode, columnRecommendResponeBean.returnCode) && i.b(this.errorMessage, columnRecommendResponeBean.errorMessage) && i.b(this.data, columnRecommendResponeBean.data);
    }

    public final ColumnRecommendData getData() {
        return this.data;
    }

    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public final String getReturnCode() {
        return this.returnCode;
    }

    public int hashCode() {
        String str = this.returnCode;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.errorMessage;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        ColumnRecommendData columnRecommendData = this.data;
        return hashCode2 + (columnRecommendData != null ? columnRecommendData.hashCode() : 0);
    }

    public final void setData(ColumnRecommendData columnRecommendData) {
        this.data = columnRecommendData;
    }

    public final void setErrorMessage(String str) {
        this.errorMessage = str;
    }

    public final void setReturnCode(String str) {
        this.returnCode = str;
    }

    public String toString() {
        return "ColumnRecommendResponeBean(returnCode=" + this.returnCode + ", errorMessage=" + this.errorMessage + ", data=" + this.data + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
