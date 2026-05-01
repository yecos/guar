package mobile.com.requestframe.utils.response;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import t9.i;

/* loaded from: classes3.dex */
public final class GetShortVideoResult {
    private ShortAssetDataList data;
    private String errorMessage;
    private String returnCode;

    public GetShortVideoResult(String str, String str2, ShortAssetDataList shortAssetDataList) {
        i.g(str, "returnCode");
        i.g(str2, "errorMessage");
        this.returnCode = str;
        this.errorMessage = str2;
        this.data = shortAssetDataList;
    }

    public static /* synthetic */ GetShortVideoResult copy$default(GetShortVideoResult getShortVideoResult, String str, String str2, ShortAssetDataList shortAssetDataList, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = getShortVideoResult.returnCode;
        }
        if ((i10 & 2) != 0) {
            str2 = getShortVideoResult.errorMessage;
        }
        if ((i10 & 4) != 0) {
            shortAssetDataList = getShortVideoResult.data;
        }
        return getShortVideoResult.copy(str, str2, shortAssetDataList);
    }

    public final String component1() {
        return this.returnCode;
    }

    public final String component2() {
        return this.errorMessage;
    }

    public final ShortAssetDataList component3() {
        return this.data;
    }

    public final GetShortVideoResult copy(String str, String str2, ShortAssetDataList shortAssetDataList) {
        i.g(str, "returnCode");
        i.g(str2, "errorMessage");
        return new GetShortVideoResult(str, str2, shortAssetDataList);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GetShortVideoResult)) {
            return false;
        }
        GetShortVideoResult getShortVideoResult = (GetShortVideoResult) obj;
        return i.b(this.returnCode, getShortVideoResult.returnCode) && i.b(this.errorMessage, getShortVideoResult.errorMessage) && i.b(this.data, getShortVideoResult.data);
    }

    public final ShortAssetDataList getData() {
        return this.data;
    }

    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public final String getReturnCode() {
        return this.returnCode;
    }

    public int hashCode() {
        int hashCode = ((this.returnCode.hashCode() * 31) + this.errorMessage.hashCode()) * 31;
        ShortAssetDataList shortAssetDataList = this.data;
        return hashCode + (shortAssetDataList == null ? 0 : shortAssetDataList.hashCode());
    }

    public final void setData(ShortAssetDataList shortAssetDataList) {
        this.data = shortAssetDataList;
    }

    public final void setErrorMessage(String str) {
        i.g(str, "<set-?>");
        this.errorMessage = str;
    }

    public final void setReturnCode(String str) {
        i.g(str, "<set-?>");
        this.returnCode = str;
    }

    public String toString() {
        return "GetShortVideoResult(returnCode=" + this.returnCode + ", errorMessage=" + this.errorMessage + ", data=" + this.data + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
