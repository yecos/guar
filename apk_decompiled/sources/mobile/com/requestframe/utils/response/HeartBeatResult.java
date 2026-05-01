package mobile.com.requestframe.utils.response;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.io.Serializable;
import t9.i;

/* loaded from: classes3.dex */
public final class HeartBeatResult implements Serializable {
    private HeartBeatData data;
    private String errorMessage;
    private String returnCode;

    public HeartBeatResult(String str, String str2, HeartBeatData heartBeatData) {
        this.returnCode = str;
        this.errorMessage = str2;
        this.data = heartBeatData;
    }

    public static /* synthetic */ HeartBeatResult copy$default(HeartBeatResult heartBeatResult, String str, String str2, HeartBeatData heartBeatData, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = heartBeatResult.returnCode;
        }
        if ((i10 & 2) != 0) {
            str2 = heartBeatResult.errorMessage;
        }
        if ((i10 & 4) != 0) {
            heartBeatData = heartBeatResult.data;
        }
        return heartBeatResult.copy(str, str2, heartBeatData);
    }

    public final String component1() {
        return this.returnCode;
    }

    public final String component2() {
        return this.errorMessage;
    }

    public final HeartBeatData component3() {
        return this.data;
    }

    public final HeartBeatResult copy(String str, String str2, HeartBeatData heartBeatData) {
        return new HeartBeatResult(str, str2, heartBeatData);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HeartBeatResult)) {
            return false;
        }
        HeartBeatResult heartBeatResult = (HeartBeatResult) obj;
        return i.b(this.returnCode, heartBeatResult.returnCode) && i.b(this.errorMessage, heartBeatResult.errorMessage) && i.b(this.data, heartBeatResult.data);
    }

    public final HeartBeatData getData() {
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
        HeartBeatData heartBeatData = this.data;
        return hashCode2 + (heartBeatData != null ? heartBeatData.hashCode() : 0);
    }

    public final void setData(HeartBeatData heartBeatData) {
        this.data = heartBeatData;
    }

    public final void setErrorMessage(String str) {
        this.errorMessage = str;
    }

    public final void setReturnCode(String str) {
        this.returnCode = str;
    }

    public String toString() {
        return "HeartBeatResult(returnCode=" + this.returnCode + ", errorMessage=" + this.errorMessage + ", data=" + this.data + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
