package mobile.com.requestframe.utils.bean;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;

/* loaded from: classes3.dex */
public class BaseResponse {
    public String errorMessage;
    public String returnCode;

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public String getReturnCode() {
        return this.returnCode;
    }

    public void setErrorMessage(String str) {
        this.errorMessage = str;
    }

    public void setReturnCode(String str) {
        this.returnCode = str;
    }

    public String toString() {
        return "BaseResponse{returnCode='" + this.returnCode + "', errorMessage='" + this.errorMessage + '\'' + ASCIIPropertyListParser.DICTIONARY_END_TOKEN;
    }
}
