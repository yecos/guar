package mobile.com.requestframe.utils.response;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import t9.i;

/* loaded from: classes3.dex */
public final class GetEmailSuffix {
    private String emailSuffixStr;

    public GetEmailSuffix(String str) {
        this.emailSuffixStr = str;
    }

    public static /* synthetic */ GetEmailSuffix copy$default(GetEmailSuffix getEmailSuffix, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = getEmailSuffix.emailSuffixStr;
        }
        return getEmailSuffix.copy(str);
    }

    public final String component1() {
        return this.emailSuffixStr;
    }

    public final GetEmailSuffix copy(String str) {
        return new GetEmailSuffix(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof GetEmailSuffix) && i.b(this.emailSuffixStr, ((GetEmailSuffix) obj).emailSuffixStr);
    }

    public final String getEmailSuffixStr() {
        return this.emailSuffixStr;
    }

    public int hashCode() {
        String str = this.emailSuffixStr;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    public final void setEmailSuffixStr(String str) {
        this.emailSuffixStr = str;
    }

    public String toString() {
        return "GetEmailSuffix(emailSuffixStr=" + this.emailSuffixStr + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
