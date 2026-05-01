package mobile.com.requestframe.utils.bean;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import t9.i;

/* loaded from: classes3.dex */
public final class ExchangeBean {
    private String exchangeCode;
    private String userId;
    private String userToken;

    public ExchangeBean(String str, String str2, String str3) {
        i.g(str, "userToken");
        i.g(str2, "userId");
        i.g(str3, "exchangeCode");
        this.userToken = str;
        this.userId = str2;
        this.exchangeCode = str3;
    }

    public static /* synthetic */ ExchangeBean copy$default(ExchangeBean exchangeBean, String str, String str2, String str3, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = exchangeBean.userToken;
        }
        if ((i10 & 2) != 0) {
            str2 = exchangeBean.userId;
        }
        if ((i10 & 4) != 0) {
            str3 = exchangeBean.exchangeCode;
        }
        return exchangeBean.copy(str, str2, str3);
    }

    public final String component1() {
        return this.userToken;
    }

    public final String component2() {
        return this.userId;
    }

    public final String component3() {
        return this.exchangeCode;
    }

    public final ExchangeBean copy(String str, String str2, String str3) {
        i.g(str, "userToken");
        i.g(str2, "userId");
        i.g(str3, "exchangeCode");
        return new ExchangeBean(str, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ExchangeBean)) {
            return false;
        }
        ExchangeBean exchangeBean = (ExchangeBean) obj;
        return i.b(this.userToken, exchangeBean.userToken) && i.b(this.userId, exchangeBean.userId) && i.b(this.exchangeCode, exchangeBean.exchangeCode);
    }

    public final String getExchangeCode() {
        return this.exchangeCode;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final String getUserToken() {
        return this.userToken;
    }

    public int hashCode() {
        return (((this.userToken.hashCode() * 31) + this.userId.hashCode()) * 31) + this.exchangeCode.hashCode();
    }

    public final void setExchangeCode(String str) {
        i.g(str, "<set-?>");
        this.exchangeCode = str;
    }

    public final void setUserId(String str) {
        i.g(str, "<set-?>");
        this.userId = str;
    }

    public final void setUserToken(String str) {
        i.g(str, "<set-?>");
        this.userToken = str;
    }

    public String toString() {
        return "ExchangeBean(userToken=" + this.userToken + ", userId=" + this.userId + ", exchangeCode=" + this.exchangeCode + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
