package mobile.com.requestframe.utils.response;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import t9.i;

/* loaded from: classes3.dex */
public final class ShelveDataBean {
    private ShelveListData data;
    private String errorMessage;
    private String returnCode;

    public ShelveDataBean(String str, String str2, ShelveListData shelveListData) {
        i.g(str, "returnCode");
        i.g(str2, "errorMessage");
        this.returnCode = str;
        this.errorMessage = str2;
        this.data = shelveListData;
    }

    public static /* synthetic */ ShelveDataBean copy$default(ShelveDataBean shelveDataBean, String str, String str2, ShelveListData shelveListData, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = shelveDataBean.returnCode;
        }
        if ((i10 & 2) != 0) {
            str2 = shelveDataBean.errorMessage;
        }
        if ((i10 & 4) != 0) {
            shelveListData = shelveDataBean.data;
        }
        return shelveDataBean.copy(str, str2, shelveListData);
    }

    public final String component1() {
        return this.returnCode;
    }

    public final String component2() {
        return this.errorMessage;
    }

    public final ShelveListData component3() {
        return this.data;
    }

    public final ShelveDataBean copy(String str, String str2, ShelveListData shelveListData) {
        i.g(str, "returnCode");
        i.g(str2, "errorMessage");
        return new ShelveDataBean(str, str2, shelveListData);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ShelveDataBean)) {
            return false;
        }
        ShelveDataBean shelveDataBean = (ShelveDataBean) obj;
        return i.b(this.returnCode, shelveDataBean.returnCode) && i.b(this.errorMessage, shelveDataBean.errorMessage) && i.b(this.data, shelveDataBean.data);
    }

    public final ShelveListData getData() {
        return this.data;
    }

    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public final String getReturnCode() {
        return this.returnCode;
    }

    public int hashCode() {
        int hashCode = ((this.returnCode.hashCode() * 31) + this.errorMessage.hashCode()) * 31;
        ShelveListData shelveListData = this.data;
        return hashCode + (shelveListData == null ? 0 : shelveListData.hashCode());
    }

    public final void setData(ShelveListData shelveListData) {
        this.data = shelveListData;
    }

    public final void setErrorMessage(String str) {
        i.g(str, "<set-?>");
        this.errorMessage = str;
    }

    public final void setReturnCode(String str) {
        i.g(str, "<set-?>");
        this.returnCode = str;
    }

    public String toString() {
        return "ShelveDataBean(returnCode=" + this.returnCode + ", errorMessage=" + this.errorMessage + ", data=" + this.data + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
