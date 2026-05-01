package mobile.com.requestframe.utils.response;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import t9.i;

/* loaded from: classes3.dex */
public final class WorkInfoBean {
    private String contact;
    private String workingTimeDesc;

    public WorkInfoBean(String str, String str2) {
        i.g(str2, "contact");
        this.workingTimeDesc = str;
        this.contact = str2;
    }

    public static /* synthetic */ WorkInfoBean copy$default(WorkInfoBean workInfoBean, String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = workInfoBean.workingTimeDesc;
        }
        if ((i10 & 2) != 0) {
            str2 = workInfoBean.contact;
        }
        return workInfoBean.copy(str, str2);
    }

    public final String component1() {
        return this.workingTimeDesc;
    }

    public final String component2() {
        return this.contact;
    }

    public final WorkInfoBean copy(String str, String str2) {
        i.g(str2, "contact");
        return new WorkInfoBean(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WorkInfoBean)) {
            return false;
        }
        WorkInfoBean workInfoBean = (WorkInfoBean) obj;
        return i.b(this.workingTimeDesc, workInfoBean.workingTimeDesc) && i.b(this.contact, workInfoBean.contact);
    }

    public final String getContact() {
        return this.contact;
    }

    public final String getWorkingTimeDesc() {
        return this.workingTimeDesc;
    }

    public int hashCode() {
        String str = this.workingTimeDesc;
        return ((str == null ? 0 : str.hashCode()) * 31) + this.contact.hashCode();
    }

    public final void setContact(String str) {
        i.g(str, "<set-?>");
        this.contact = str;
    }

    public final void setWorkingTimeDesc(String str) {
        this.workingTimeDesc = str;
    }

    public String toString() {
        return "WorkInfoBean(workingTimeDesc=" + this.workingTimeDesc + ", contact=" + this.contact + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
