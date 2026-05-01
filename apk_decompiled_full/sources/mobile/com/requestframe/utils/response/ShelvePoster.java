package mobile.com.requestframe.utils.response;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.io.Serializable;
import t9.i;

/* loaded from: classes3.dex */
public final class ShelvePoster implements Serializable {
    private String fileType;
    private String fileUrl;
    private String name;
    private String size;

    public ShelvePoster(String str, String str2, String str3, String str4) {
        this.name = str;
        this.fileUrl = str2;
        this.size = str3;
        this.fileType = str4;
    }

    public static /* synthetic */ ShelvePoster copy$default(ShelvePoster shelvePoster, String str, String str2, String str3, String str4, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = shelvePoster.name;
        }
        if ((i10 & 2) != 0) {
            str2 = shelvePoster.fileUrl;
        }
        if ((i10 & 4) != 0) {
            str3 = shelvePoster.size;
        }
        if ((i10 & 8) != 0) {
            str4 = shelvePoster.fileType;
        }
        return shelvePoster.copy(str, str2, str3, str4);
    }

    public final String component1() {
        return this.name;
    }

    public final String component2() {
        return this.fileUrl;
    }

    public final String component3() {
        return this.size;
    }

    public final String component4() {
        return this.fileType;
    }

    public final ShelvePoster copy(String str, String str2, String str3, String str4) {
        return new ShelvePoster(str, str2, str3, str4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ShelvePoster)) {
            return false;
        }
        ShelvePoster shelvePoster = (ShelvePoster) obj;
        return i.b(this.name, shelvePoster.name) && i.b(this.fileUrl, shelvePoster.fileUrl) && i.b(this.size, shelvePoster.size) && i.b(this.fileType, shelvePoster.fileType);
    }

    public final String getFileType() {
        return this.fileType;
    }

    public final String getFileUrl() {
        return this.fileUrl;
    }

    public final String getName() {
        return this.name;
    }

    public final String getSize() {
        return this.size;
    }

    public int hashCode() {
        String str = this.name;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.fileUrl;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.size;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.fileType;
        return hashCode3 + (str4 != null ? str4.hashCode() : 0);
    }

    public final void setFileType(String str) {
        this.fileType = str;
    }

    public final void setFileUrl(String str) {
        this.fileUrl = str;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final void setSize(String str) {
        this.size = str;
    }

    public String toString() {
        return "ShelvePoster(name=" + this.name + ", fileUrl=" + this.fileUrl + ", size=" + this.size + ", fileType=" + this.fileType + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
