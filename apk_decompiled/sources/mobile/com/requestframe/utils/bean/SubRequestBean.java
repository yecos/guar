package mobile.com.requestframe.utils.bean;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import t9.g;
import t9.i;

/* loaded from: classes3.dex */
public final class SubRequestBean {
    private String programId;
    private String securityKey;

    public SubRequestBean(String str, String str2) {
        i.g(str, "programId");
        this.programId = str;
        this.securityKey = str2;
    }

    public static /* synthetic */ SubRequestBean copy$default(SubRequestBean subRequestBean, String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = subRequestBean.programId;
        }
        if ((i10 & 2) != 0) {
            str2 = subRequestBean.securityKey;
        }
        return subRequestBean.copy(str, str2);
    }

    public final String component1() {
        return this.programId;
    }

    public final String component2() {
        return this.securityKey;
    }

    public final SubRequestBean copy(String str, String str2) {
        i.g(str, "programId");
        return new SubRequestBean(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SubRequestBean)) {
            return false;
        }
        SubRequestBean subRequestBean = (SubRequestBean) obj;
        return i.b(this.programId, subRequestBean.programId) && i.b(this.securityKey, subRequestBean.securityKey);
    }

    public final String getProgramId() {
        return this.programId;
    }

    public final String getSecurityKey() {
        return this.securityKey;
    }

    public int hashCode() {
        int hashCode = this.programId.hashCode() * 31;
        String str = this.securityKey;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public final void setProgramId(String str) {
        i.g(str, "<set-?>");
        this.programId = str;
    }

    public final void setSecurityKey(String str) {
        this.securityKey = str;
    }

    public String toString() {
        return "SubRequestBean(programId=" + this.programId + ", securityKey=" + this.securityKey + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }

    public /* synthetic */ SubRequestBean(String str, String str2, int i10, g gVar) {
        this(str, (i10 & 2) != 0 ? null : str2);
    }
}
