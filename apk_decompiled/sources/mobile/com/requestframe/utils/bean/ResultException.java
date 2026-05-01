package mobile.com.requestframe.utils.bean;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.io.IOException;

/* loaded from: classes3.dex */
public class ResultException extends IOException {
    private String errorData;
    private String errorMessage;
    private String returnCode;

    public ResultException(String str, String str2, String str3) {
        this.returnCode = str;
        this.errorMessage = str2;
        this.errorData = str3;
    }

    public String getErrorData() {
        return this.errorData;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public String getReturnCode() {
        return this.returnCode;
    }

    public void setErrorData(String str) {
        this.errorData = str;
    }

    public void setErrorMessage(String str) {
        this.errorMessage = str;
    }

    public void setReturnCode(String str) {
        this.returnCode = str;
    }

    @Override // java.lang.Throwable
    public String toString() {
        return "ResultException{returnCode='" + this.returnCode + "', errorMessage='" + this.errorMessage + "', errorData='" + this.errorData + '\'' + ASCIIPropertyListParser.DICTIONARY_END_TOKEN;
    }
}
