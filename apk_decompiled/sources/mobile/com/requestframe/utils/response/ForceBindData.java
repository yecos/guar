package mobile.com.requestframe.utils.response;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import t9.i;

/* loaded from: classes3.dex */
public final class ForceBindData {
    private String bindMethod;
    private Integer freeBindTime;

    public ForceBindData(String str, Integer num) {
        this.bindMethod = str;
        this.freeBindTime = num;
    }

    public static /* synthetic */ ForceBindData copy$default(ForceBindData forceBindData, String str, Integer num, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = forceBindData.bindMethod;
        }
        if ((i10 & 2) != 0) {
            num = forceBindData.freeBindTime;
        }
        return forceBindData.copy(str, num);
    }

    public final String component1() {
        return this.bindMethod;
    }

    public final Integer component2() {
        return this.freeBindTime;
    }

    public final ForceBindData copy(String str, Integer num) {
        return new ForceBindData(str, num);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ForceBindData)) {
            return false;
        }
        ForceBindData forceBindData = (ForceBindData) obj;
        return i.b(this.bindMethod, forceBindData.bindMethod) && i.b(this.freeBindTime, forceBindData.freeBindTime);
    }

    public final String getBindMethod() {
        return this.bindMethod;
    }

    public final Integer getFreeBindTime() {
        return this.freeBindTime;
    }

    public int hashCode() {
        String str = this.bindMethod;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Integer num = this.freeBindTime;
        return hashCode + (num != null ? num.hashCode() : 0);
    }

    public final void setBindMethod(String str) {
        this.bindMethod = str;
    }

    public final void setFreeBindTime(Integer num) {
        this.freeBindTime = num;
    }

    public String toString() {
        return "ForceBindData(bindMethod=" + this.bindMethod + ", freeBindTime=" + this.freeBindTime + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
