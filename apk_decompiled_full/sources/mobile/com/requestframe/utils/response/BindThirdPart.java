package mobile.com.requestframe.utils.response;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import t9.i;

/* loaded from: classes3.dex */
public final class BindThirdPart {
    private String googleNickName;
    private String googlePhotoUrl;

    public BindThirdPart(String str, String str2) {
        i.g(str, "googleNickName");
        i.g(str2, "googlePhotoUrl");
        this.googleNickName = str;
        this.googlePhotoUrl = str2;
    }

    public static /* synthetic */ BindThirdPart copy$default(BindThirdPart bindThirdPart, String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = bindThirdPart.googleNickName;
        }
        if ((i10 & 2) != 0) {
            str2 = bindThirdPart.googlePhotoUrl;
        }
        return bindThirdPart.copy(str, str2);
    }

    public final String component1() {
        return this.googleNickName;
    }

    public final String component2() {
        return this.googlePhotoUrl;
    }

    public final BindThirdPart copy(String str, String str2) {
        i.g(str, "googleNickName");
        i.g(str2, "googlePhotoUrl");
        return new BindThirdPart(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BindThirdPart)) {
            return false;
        }
        BindThirdPart bindThirdPart = (BindThirdPart) obj;
        return i.b(this.googleNickName, bindThirdPart.googleNickName) && i.b(this.googlePhotoUrl, bindThirdPart.googlePhotoUrl);
    }

    public final String getGoogleNickName() {
        return this.googleNickName;
    }

    public final String getGooglePhotoUrl() {
        return this.googlePhotoUrl;
    }

    public int hashCode() {
        return (this.googleNickName.hashCode() * 31) + this.googlePhotoUrl.hashCode();
    }

    public final void setGoogleNickName(String str) {
        i.g(str, "<set-?>");
        this.googleNickName = str;
    }

    public final void setGooglePhotoUrl(String str) {
        i.g(str, "<set-?>");
        this.googlePhotoUrl = str;
    }

    public String toString() {
        return "BindThirdPart(googleNickName=" + this.googleNickName + ", googlePhotoUrl=" + this.googlePhotoUrl + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
