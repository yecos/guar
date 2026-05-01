package mobile.com.requestframe.utils.response;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.io.Serializable;
import t9.i;

/* loaded from: classes3.dex */
public final class VodRecommendsRespone implements Serializable {
    private RecommendList data;
    private String errorMessage;
    private String returnCode;

    public VodRecommendsRespone(String str, String str2, RecommendList recommendList) {
        this.returnCode = str;
        this.errorMessage = str2;
        this.data = recommendList;
    }

    public static /* synthetic */ VodRecommendsRespone copy$default(VodRecommendsRespone vodRecommendsRespone, String str, String str2, RecommendList recommendList, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = vodRecommendsRespone.returnCode;
        }
        if ((i10 & 2) != 0) {
            str2 = vodRecommendsRespone.errorMessage;
        }
        if ((i10 & 4) != 0) {
            recommendList = vodRecommendsRespone.data;
        }
        return vodRecommendsRespone.copy(str, str2, recommendList);
    }

    public final String component1() {
        return this.returnCode;
    }

    public final String component2() {
        return this.errorMessage;
    }

    public final RecommendList component3() {
        return this.data;
    }

    public final VodRecommendsRespone copy(String str, String str2, RecommendList recommendList) {
        return new VodRecommendsRespone(str, str2, recommendList);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VodRecommendsRespone)) {
            return false;
        }
        VodRecommendsRespone vodRecommendsRespone = (VodRecommendsRespone) obj;
        return i.b(this.returnCode, vodRecommendsRespone.returnCode) && i.b(this.errorMessage, vodRecommendsRespone.errorMessage) && i.b(this.data, vodRecommendsRespone.data);
    }

    public final RecommendList getData() {
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
        RecommendList recommendList = this.data;
        return hashCode2 + (recommendList != null ? recommendList.hashCode() : 0);
    }

    public final void setData(RecommendList recommendList) {
        this.data = recommendList;
    }

    public final void setErrorMessage(String str) {
        this.errorMessage = str;
    }

    public final void setReturnCode(String str) {
        this.returnCode = str;
    }

    public String toString() {
        return "VodRecommendsRespone(returnCode=" + this.returnCode + ", errorMessage=" + this.errorMessage + ", data=" + this.data + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
