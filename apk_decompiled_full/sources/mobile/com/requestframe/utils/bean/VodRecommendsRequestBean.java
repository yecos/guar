package mobile.com.requestframe.utils.bean;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.util.List;
import t9.i;

/* loaded from: classes3.dex */
public final class VodRecommendsRequestBean {
    private String portalCode;
    private List<String> recommendCodeArr;
    private String userId;
    private String userToken;

    public VodRecommendsRequestBean(String str, String str2, String str3, List<String> list) {
        i.g(str, "userToken");
        i.g(str2, "userId");
        i.g(str3, "portalCode");
        i.g(list, "recommendCodeArr");
        this.userToken = str;
        this.userId = str2;
        this.portalCode = str3;
        this.recommendCodeArr = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ VodRecommendsRequestBean copy$default(VodRecommendsRequestBean vodRecommendsRequestBean, String str, String str2, String str3, List list, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = vodRecommendsRequestBean.userToken;
        }
        if ((i10 & 2) != 0) {
            str2 = vodRecommendsRequestBean.userId;
        }
        if ((i10 & 4) != 0) {
            str3 = vodRecommendsRequestBean.portalCode;
        }
        if ((i10 & 8) != 0) {
            list = vodRecommendsRequestBean.recommendCodeArr;
        }
        return vodRecommendsRequestBean.copy(str, str2, str3, list);
    }

    public final String component1() {
        return this.userToken;
    }

    public final String component2() {
        return this.userId;
    }

    public final String component3() {
        return this.portalCode;
    }

    public final List<String> component4() {
        return this.recommendCodeArr;
    }

    public final VodRecommendsRequestBean copy(String str, String str2, String str3, List<String> list) {
        i.g(str, "userToken");
        i.g(str2, "userId");
        i.g(str3, "portalCode");
        i.g(list, "recommendCodeArr");
        return new VodRecommendsRequestBean(str, str2, str3, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VodRecommendsRequestBean)) {
            return false;
        }
        VodRecommendsRequestBean vodRecommendsRequestBean = (VodRecommendsRequestBean) obj;
        return i.b(this.userToken, vodRecommendsRequestBean.userToken) && i.b(this.userId, vodRecommendsRequestBean.userId) && i.b(this.portalCode, vodRecommendsRequestBean.portalCode) && i.b(this.recommendCodeArr, vodRecommendsRequestBean.recommendCodeArr);
    }

    public final String getPortalCode() {
        return this.portalCode;
    }

    public final List<String> getRecommendCodeArr() {
        return this.recommendCodeArr;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final String getUserToken() {
        return this.userToken;
    }

    public int hashCode() {
        return (((((this.userToken.hashCode() * 31) + this.userId.hashCode()) * 31) + this.portalCode.hashCode()) * 31) + this.recommendCodeArr.hashCode();
    }

    public final void setPortalCode(String str) {
        i.g(str, "<set-?>");
        this.portalCode = str;
    }

    public final void setRecommendCodeArr(List<String> list) {
        i.g(list, "<set-?>");
        this.recommendCodeArr = list;
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
        return "VodRecommendsRequestBean(userToken=" + this.userToken + ", userId=" + this.userId + ", portalCode=" + this.portalCode + ", recommendCodeArr=" + this.recommendCodeArr + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
