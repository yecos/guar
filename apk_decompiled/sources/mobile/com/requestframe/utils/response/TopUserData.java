package mobile.com.requestframe.utils.response;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import t9.i;

/* loaded from: classes3.dex */
public final class TopUserData {
    private String iconUrl;
    private int uploadNum;
    private String userAccount;

    public TopUserData(String str, String str2, int i10) {
        this.iconUrl = str;
        this.userAccount = str2;
        this.uploadNum = i10;
    }

    public static /* synthetic */ TopUserData copy$default(TopUserData topUserData, String str, String str2, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = topUserData.iconUrl;
        }
        if ((i11 & 2) != 0) {
            str2 = topUserData.userAccount;
        }
        if ((i11 & 4) != 0) {
            i10 = topUserData.uploadNum;
        }
        return topUserData.copy(str, str2, i10);
    }

    public final String component1() {
        return this.iconUrl;
    }

    public final String component2() {
        return this.userAccount;
    }

    public final int component3() {
        return this.uploadNum;
    }

    public final TopUserData copy(String str, String str2, int i10) {
        return new TopUserData(str, str2, i10);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TopUserData)) {
            return false;
        }
        TopUserData topUserData = (TopUserData) obj;
        return i.b(this.iconUrl, topUserData.iconUrl) && i.b(this.userAccount, topUserData.userAccount) && this.uploadNum == topUserData.uploadNum;
    }

    public final String getIconUrl() {
        return this.iconUrl;
    }

    public final int getUploadNum() {
        return this.uploadNum;
    }

    public final String getUserAccount() {
        return this.userAccount;
    }

    public int hashCode() {
        String str = this.iconUrl;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.userAccount;
        return ((hashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.uploadNum;
    }

    public final void setIconUrl(String str) {
        this.iconUrl = str;
    }

    public final void setUploadNum(int i10) {
        this.uploadNum = i10;
    }

    public final void setUserAccount(String str) {
        this.userAccount = str;
    }

    public String toString() {
        return "TopUserData(iconUrl=" + this.iconUrl + ", userAccount=" + this.userAccount + ", uploadNum=" + this.uploadNum + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
