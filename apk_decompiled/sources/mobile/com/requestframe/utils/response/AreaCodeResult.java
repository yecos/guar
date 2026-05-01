package mobile.com.requestframe.utils.response;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.io.Serializable;
import t9.i;

/* loaded from: classes3.dex */
public final class AreaCodeResult implements Serializable {
    private AreaCodeData data;
    private String errorMessage;
    private String returnCode;

    public AreaCodeResult(String str, String str2, AreaCodeData areaCodeData) {
        this.returnCode = str;
        this.errorMessage = str2;
        this.data = areaCodeData;
    }

    public static /* synthetic */ AreaCodeResult copy$default(AreaCodeResult areaCodeResult, String str, String str2, AreaCodeData areaCodeData, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = areaCodeResult.returnCode;
        }
        if ((i10 & 2) != 0) {
            str2 = areaCodeResult.errorMessage;
        }
        if ((i10 & 4) != 0) {
            areaCodeData = areaCodeResult.data;
        }
        return areaCodeResult.copy(str, str2, areaCodeData);
    }

    public final String component1() {
        return this.returnCode;
    }

    public final String component2() {
        return this.errorMessage;
    }

    public final AreaCodeData component3() {
        return this.data;
    }

    public final AreaCodeResult copy(String str, String str2, AreaCodeData areaCodeData) {
        return new AreaCodeResult(str, str2, areaCodeData);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AreaCodeResult)) {
            return false;
        }
        AreaCodeResult areaCodeResult = (AreaCodeResult) obj;
        return i.b(this.returnCode, areaCodeResult.returnCode) && i.b(this.errorMessage, areaCodeResult.errorMessage) && i.b(this.data, areaCodeResult.data);
    }

    public final AreaCodeData getData() {
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
        AreaCodeData areaCodeData = this.data;
        return hashCode2 + (areaCodeData != null ? areaCodeData.hashCode() : 0);
    }

    public final void setData(AreaCodeData areaCodeData) {
        this.data = areaCodeData;
    }

    public final void setErrorMessage(String str) {
        this.errorMessage = str;
    }

    public final void setReturnCode(String str) {
        this.returnCode = str;
    }

    public String toString() {
        return "AreaCodeResult(returnCode=" + this.returnCode + ", errorMessage=" + this.errorMessage + ", data=" + this.data + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
