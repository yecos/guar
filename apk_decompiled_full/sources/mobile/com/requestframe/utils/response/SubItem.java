package mobile.com.requestframe.utils.response;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import t9.g;
import t9.i;

/* loaded from: classes3.dex */
public final class SubItem {
    private boolean downloadError;
    private boolean downloadFinished;
    private String fileType;
    private String md5;
    private String url;

    public SubItem(String str, String str2, String str3, boolean z10, boolean z11) {
        this.url = str;
        this.fileType = str2;
        this.md5 = str3;
        this.downloadFinished = z10;
        this.downloadError = z11;
    }

    public static /* synthetic */ SubItem copy$default(SubItem subItem, String str, String str2, String str3, boolean z10, boolean z11, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = subItem.url;
        }
        if ((i10 & 2) != 0) {
            str2 = subItem.fileType;
        }
        String str4 = str2;
        if ((i10 & 4) != 0) {
            str3 = subItem.md5;
        }
        String str5 = str3;
        if ((i10 & 8) != 0) {
            z10 = subItem.downloadFinished;
        }
        boolean z12 = z10;
        if ((i10 & 16) != 0) {
            z11 = subItem.downloadError;
        }
        return subItem.copy(str, str4, str5, z12, z11);
    }

    public final String component1() {
        return this.url;
    }

    public final String component2() {
        return this.fileType;
    }

    public final String component3() {
        return this.md5;
    }

    public final boolean component4() {
        return this.downloadFinished;
    }

    public final boolean component5() {
        return this.downloadError;
    }

    public final SubItem copy(String str, String str2, String str3, boolean z10, boolean z11) {
        return new SubItem(str, str2, str3, z10, z11);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SubItem)) {
            return false;
        }
        SubItem subItem = (SubItem) obj;
        return i.b(this.url, subItem.url) && i.b(this.fileType, subItem.fileType) && i.b(this.md5, subItem.md5) && this.downloadFinished == subItem.downloadFinished && this.downloadError == subItem.downloadError;
    }

    public final boolean getDownloadError() {
        return this.downloadError;
    }

    public final boolean getDownloadFinished() {
        return this.downloadFinished;
    }

    public final String getFileType() {
        return this.fileType;
    }

    public final String getMd5() {
        return this.md5;
    }

    public final String getUrl() {
        return this.url;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        String str = this.url;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.fileType;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.md5;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        boolean z10 = this.downloadFinished;
        int i10 = z10;
        if (z10 != 0) {
            i10 = 1;
        }
        int i11 = (hashCode3 + i10) * 31;
        boolean z11 = this.downloadError;
        return i11 + (z11 ? 1 : z11 ? 1 : 0);
    }

    public final void setDownloadError(boolean z10) {
        this.downloadError = z10;
    }

    public final void setDownloadFinished(boolean z10) {
        this.downloadFinished = z10;
    }

    public final void setFileType(String str) {
        this.fileType = str;
    }

    public final void setMd5(String str) {
        this.md5 = str;
    }

    public final void setUrl(String str) {
        this.url = str;
    }

    public String toString() {
        return "SubItem(url=" + this.url + ", fileType=" + this.fileType + ", md5=" + this.md5 + ", downloadFinished=" + this.downloadFinished + ", downloadError=" + this.downloadError + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }

    public /* synthetic */ SubItem(String str, String str2, String str3, boolean z10, boolean z11, int i10, g gVar) {
        this(str, str2, str3, (i10 & 8) != 0 ? false : z10, (i10 & 16) != 0 ? false : z11);
    }
}
