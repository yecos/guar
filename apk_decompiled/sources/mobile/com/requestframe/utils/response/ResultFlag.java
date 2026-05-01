package mobile.com.requestframe.utils.response;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import t9.i;

/* loaded from: classes3.dex */
public final class ResultFlag {
    private int authDays;
    private String resultFlag;

    public ResultFlag(String str, int i10) {
        i.g(str, "resultFlag");
        this.resultFlag = str;
        this.authDays = i10;
    }

    public static /* synthetic */ ResultFlag copy$default(ResultFlag resultFlag, String str, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = resultFlag.resultFlag;
        }
        if ((i11 & 2) != 0) {
            i10 = resultFlag.authDays;
        }
        return resultFlag.copy(str, i10);
    }

    public final String component1() {
        return this.resultFlag;
    }

    public final int component2() {
        return this.authDays;
    }

    public final ResultFlag copy(String str, int i10) {
        i.g(str, "resultFlag");
        return new ResultFlag(str, i10);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ResultFlag)) {
            return false;
        }
        ResultFlag resultFlag = (ResultFlag) obj;
        return i.b(this.resultFlag, resultFlag.resultFlag) && this.authDays == resultFlag.authDays;
    }

    public final int getAuthDays() {
        return this.authDays;
    }

    public final String getResultFlag() {
        return this.resultFlag;
    }

    public int hashCode() {
        return (this.resultFlag.hashCode() * 31) + this.authDays;
    }

    public final void setAuthDays(int i10) {
        this.authDays = i10;
    }

    public final void setResultFlag(String str) {
        i.g(str, "<set-?>");
        this.resultFlag = str;
    }

    public String toString() {
        return "ResultFlag(resultFlag=" + this.resultFlag + ", authDays=" + this.authDays + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
