package mobile.com.requestframe.utils.bean;

import com.google.android.gms.common.Scopes;
import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import t9.i;

/* loaded from: classes3.dex */
public final class EmailResetPwdBean {
    private String email;
    private String lang;

    public EmailResetPwdBean(String str, String str2) {
        i.g(str, Scopes.EMAIL);
        i.g(str2, "lang");
        this.email = str;
        this.lang = str2;
    }

    public static /* synthetic */ EmailResetPwdBean copy$default(EmailResetPwdBean emailResetPwdBean, String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = emailResetPwdBean.email;
        }
        if ((i10 & 2) != 0) {
            str2 = emailResetPwdBean.lang;
        }
        return emailResetPwdBean.copy(str, str2);
    }

    public final String component1() {
        return this.email;
    }

    public final String component2() {
        return this.lang;
    }

    public final EmailResetPwdBean copy(String str, String str2) {
        i.g(str, Scopes.EMAIL);
        i.g(str2, "lang");
        return new EmailResetPwdBean(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof EmailResetPwdBean)) {
            return false;
        }
        EmailResetPwdBean emailResetPwdBean = (EmailResetPwdBean) obj;
        return i.b(this.email, emailResetPwdBean.email) && i.b(this.lang, emailResetPwdBean.lang);
    }

    public final String getEmail() {
        return this.email;
    }

    public final String getLang() {
        return this.lang;
    }

    public int hashCode() {
        return (this.email.hashCode() * 31) + this.lang.hashCode();
    }

    public final void setEmail(String str) {
        i.g(str, "<set-?>");
        this.email = str;
    }

    public final void setLang(String str) {
        i.g(str, "<set-?>");
        this.lang = str;
    }

    public String toString() {
        return "EmailResetPwdBean(email=" + this.email + ", lang=" + this.lang + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
