package mobile.com.requestframe.utils.response;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import t9.i;

/* loaded from: classes3.dex */
public final class FreeDataBean {
    private Integer authDays;

    public FreeDataBean(Integer num) {
        this.authDays = num;
    }

    public static /* synthetic */ FreeDataBean copy$default(FreeDataBean freeDataBean, Integer num, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            num = freeDataBean.authDays;
        }
        return freeDataBean.copy(num);
    }

    public final Integer component1() {
        return this.authDays;
    }

    public final FreeDataBean copy(Integer num) {
        return new FreeDataBean(num);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof FreeDataBean) && i.b(this.authDays, ((FreeDataBean) obj).authDays);
    }

    public final Integer getAuthDays() {
        return this.authDays;
    }

    public int hashCode() {
        Integer num = this.authDays;
        if (num == null) {
            return 0;
        }
        return num.hashCode();
    }

    public final void setAuthDays(Integer num) {
        this.authDays = num;
    }

    public String toString() {
        return "FreeDataBean(authDays=" + this.authDays + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
