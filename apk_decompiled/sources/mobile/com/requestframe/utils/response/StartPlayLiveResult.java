package mobile.com.requestframe.utils.response;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import t9.i;

/* loaded from: classes3.dex */
public final class StartPlayLiveResult {
    private StartPlayLiveData data;
    private String errorMessage;
    private String returnCode;

    public StartPlayLiveResult(String str, String str2, StartPlayLiveData startPlayLiveData) {
        this.returnCode = str;
        this.errorMessage = str2;
        this.data = startPlayLiveData;
    }

    public static /* synthetic */ StartPlayLiveResult copy$default(StartPlayLiveResult startPlayLiveResult, String str, String str2, StartPlayLiveData startPlayLiveData, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = startPlayLiveResult.returnCode;
        }
        if ((i10 & 2) != 0) {
            str2 = startPlayLiveResult.errorMessage;
        }
        if ((i10 & 4) != 0) {
            startPlayLiveData = startPlayLiveResult.data;
        }
        return startPlayLiveResult.copy(str, str2, startPlayLiveData);
    }

    public final String component1() {
        return this.returnCode;
    }

    public final String component2() {
        return this.errorMessage;
    }

    public final StartPlayLiveData component3() {
        return this.data;
    }

    public final StartPlayLiveResult copy(String str, String str2, StartPlayLiveData startPlayLiveData) {
        return new StartPlayLiveResult(str, str2, startPlayLiveData);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StartPlayLiveResult)) {
            return false;
        }
        StartPlayLiveResult startPlayLiveResult = (StartPlayLiveResult) obj;
        return i.b(this.returnCode, startPlayLiveResult.returnCode) && i.b(this.errorMessage, startPlayLiveResult.errorMessage) && i.b(this.data, startPlayLiveResult.data);
    }

    public final StartPlayLiveData getData() {
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
        StartPlayLiveData startPlayLiveData = this.data;
        return hashCode2 + (startPlayLiveData != null ? startPlayLiveData.hashCode() : 0);
    }

    public final void setData(StartPlayLiveData startPlayLiveData) {
        this.data = startPlayLiveData;
    }

    public final void setErrorMessage(String str) {
        this.errorMessage = str;
    }

    public final void setReturnCode(String str) {
        this.returnCode = str;
    }

    public String toString() {
        return "StartPlayLiveResult(returnCode=" + this.returnCode + ", errorMessage=" + this.errorMessage + ", data=" + this.data + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
