package mobile.com.requestframe.utils.response;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.io.Serializable;
import t9.i;

/* loaded from: classes3.dex */
public final class SearchByNameResult implements Serializable {
    private SearchData data;
    private String errorMessage;
    private String returnCode;

    public SearchByNameResult(String str, String str2, SearchData searchData) {
        this.returnCode = str;
        this.errorMessage = str2;
        this.data = searchData;
    }

    public static /* synthetic */ SearchByNameResult copy$default(SearchByNameResult searchByNameResult, String str, String str2, SearchData searchData, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = searchByNameResult.returnCode;
        }
        if ((i10 & 2) != 0) {
            str2 = searchByNameResult.errorMessage;
        }
        if ((i10 & 4) != 0) {
            searchData = searchByNameResult.data;
        }
        return searchByNameResult.copy(str, str2, searchData);
    }

    public final String component1() {
        return this.returnCode;
    }

    public final String component2() {
        return this.errorMessage;
    }

    public final SearchData component3() {
        return this.data;
    }

    public final SearchByNameResult copy(String str, String str2, SearchData searchData) {
        return new SearchByNameResult(str, str2, searchData);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SearchByNameResult)) {
            return false;
        }
        SearchByNameResult searchByNameResult = (SearchByNameResult) obj;
        return i.b(this.returnCode, searchByNameResult.returnCode) && i.b(this.errorMessage, searchByNameResult.errorMessage) && i.b(this.data, searchByNameResult.data);
    }

    public final SearchData getData() {
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
        SearchData searchData = this.data;
        return hashCode2 + (searchData != null ? searchData.hashCode() : 0);
    }

    public final void setData(SearchData searchData) {
        this.data = searchData;
    }

    public final void setErrorMessage(String str) {
        this.errorMessage = str;
    }

    public final void setReturnCode(String str) {
        this.returnCode = str;
    }

    public String toString() {
        return "SearchByNameResult(returnCode=" + this.returnCode + ", errorMessage=" + this.errorMessage + ", data=" + this.data + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
