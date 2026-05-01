package mobile.com.requestframe.utils.response;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.io.Serializable;
import t9.i;

/* loaded from: classes3.dex */
public final class StartPlayVODResult implements Serializable {
    private StartPlayVODData data;
    private String errorMessage;
    private String returnCode;

    public StartPlayVODResult(String str, String str2, StartPlayVODData startPlayVODData) {
        i.g(str, "returnCode");
        this.returnCode = str;
        this.errorMessage = str2;
        this.data = startPlayVODData;
    }

    public static /* synthetic */ StartPlayVODResult copy$default(StartPlayVODResult startPlayVODResult, String str, String str2, StartPlayVODData startPlayVODData, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = startPlayVODResult.returnCode;
        }
        if ((i10 & 2) != 0) {
            str2 = startPlayVODResult.errorMessage;
        }
        if ((i10 & 4) != 0) {
            startPlayVODData = startPlayVODResult.data;
        }
        return startPlayVODResult.copy(str, str2, startPlayVODData);
    }

    public final String component1() {
        return this.returnCode;
    }

    public final String component2() {
        return this.errorMessage;
    }

    public final StartPlayVODData component3() {
        return this.data;
    }

    public final StartPlayVODResult copy(String str, String str2, StartPlayVODData startPlayVODData) {
        i.g(str, "returnCode");
        return new StartPlayVODResult(str, str2, startPlayVODData);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StartPlayVODResult)) {
            return false;
        }
        StartPlayVODResult startPlayVODResult = (StartPlayVODResult) obj;
        return i.b(this.returnCode, startPlayVODResult.returnCode) && i.b(this.errorMessage, startPlayVODResult.errorMessage) && i.b(this.data, startPlayVODResult.data);
    }

    public final StartPlayVODData getData() {
        return this.data;
    }

    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public final String getReturnCode() {
        return this.returnCode;
    }

    public int hashCode() {
        int hashCode = this.returnCode.hashCode() * 31;
        String str = this.errorMessage;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        StartPlayVODData startPlayVODData = this.data;
        return hashCode2 + (startPlayVODData != null ? startPlayVODData.hashCode() : 0);
    }

    public final void setData(StartPlayVODData startPlayVODData) {
        this.data = startPlayVODData;
    }

    public final void setErrorMessage(String str) {
        this.errorMessage = str;
    }

    public final void setReturnCode(String str) {
        i.g(str, "<set-?>");
        this.returnCode = str;
    }

    public String toString() {
        return "StartPlayVODResult(returnCode=" + this.returnCode + ", errorMessage=" + this.errorMessage + ", data=" + this.data + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
