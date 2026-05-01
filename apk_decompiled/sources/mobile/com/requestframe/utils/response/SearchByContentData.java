package mobile.com.requestframe.utils.response;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import t9.i;

/* loaded from: classes3.dex */
public final class SearchByContentData {
    private SearchByContent data;
    private String errorMessage;
    private String returnCode;

    public SearchByContentData(String str, String str2, SearchByContent searchByContent) {
        i.g(str, "returnCode");
        this.returnCode = str;
        this.errorMessage = str2;
        this.data = searchByContent;
    }

    public static /* synthetic */ SearchByContentData copy$default(SearchByContentData searchByContentData, String str, String str2, SearchByContent searchByContent, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = searchByContentData.returnCode;
        }
        if ((i10 & 2) != 0) {
            str2 = searchByContentData.errorMessage;
        }
        if ((i10 & 4) != 0) {
            searchByContent = searchByContentData.data;
        }
        return searchByContentData.copy(str, str2, searchByContent);
    }

    public final String component1() {
        return this.returnCode;
    }

    public final String component2() {
        return this.errorMessage;
    }

    public final SearchByContent component3() {
        return this.data;
    }

    public final SearchByContentData copy(String str, String str2, SearchByContent searchByContent) {
        i.g(str, "returnCode");
        return new SearchByContentData(str, str2, searchByContent);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SearchByContentData)) {
            return false;
        }
        SearchByContentData searchByContentData = (SearchByContentData) obj;
        return i.b(this.returnCode, searchByContentData.returnCode) && i.b(this.errorMessage, searchByContentData.errorMessage) && i.b(this.data, searchByContentData.data);
    }

    public final SearchByContent getData() {
        return this.data;
    }

    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public final String getReturnCode() {
        return this.returnCode;
    }

    public int hashCode() {
        int hashCode = this.returnCode.hashCode() * 31;
        String str = this.errorMessage;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        SearchByContent searchByContent = this.data;
        return hashCode2 + (searchByContent != null ? searchByContent.hashCode() : 0);
    }

    public final void setData(SearchByContent searchByContent) {
        this.data = searchByContent;
    }

    public final void setErrorMessage(String str) {
        this.errorMessage = str;
    }

    public final void setReturnCode(String str) {
        i.g(str, "<set-?>");
        this.returnCode = str;
    }

    public String toString() {
        return "SearchByContentData(returnCode=" + this.returnCode + ", errorMessage=" + this.errorMessage + ", data=" + this.data + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
