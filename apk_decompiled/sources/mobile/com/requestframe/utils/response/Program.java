package mobile.com.requestframe.utils.response;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import com.umeng.analytics.AnalyticsConfig;
import t9.g;
import t9.i;

/* loaded from: classes3.dex */
public final class Program {
    private String endTime;
    private boolean isSub;
    private String programName;
    private String remark;
    private String startTime;
    private String type;

    public Program(String str, String str2, String str3, String str4, String str5, boolean z10) {
        i.g(str, "programName");
        i.g(str2, AnalyticsConfig.RTD_START_TIME);
        i.g(str3, "endTime");
        this.programName = str;
        this.startTime = str2;
        this.endTime = str3;
        this.type = str4;
        this.remark = str5;
        this.isSub = z10;
    }

    public static /* synthetic */ Program copy$default(Program program, String str, String str2, String str3, String str4, String str5, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = program.programName;
        }
        if ((i10 & 2) != 0) {
            str2 = program.startTime;
        }
        String str6 = str2;
        if ((i10 & 4) != 0) {
            str3 = program.endTime;
        }
        String str7 = str3;
        if ((i10 & 8) != 0) {
            str4 = program.type;
        }
        String str8 = str4;
        if ((i10 & 16) != 0) {
            str5 = program.remark;
        }
        String str9 = str5;
        if ((i10 & 32) != 0) {
            z10 = program.isSub;
        }
        return program.copy(str, str6, str7, str8, str9, z10);
    }

    public final String component1() {
        return this.programName;
    }

    public final String component2() {
        return this.startTime;
    }

    public final String component3() {
        return this.endTime;
    }

    public final String component4() {
        return this.type;
    }

    public final String component5() {
        return this.remark;
    }

    public final boolean component6() {
        return this.isSub;
    }

    public final Program copy(String str, String str2, String str3, String str4, String str5, boolean z10) {
        i.g(str, "programName");
        i.g(str2, AnalyticsConfig.RTD_START_TIME);
        i.g(str3, "endTime");
        return new Program(str, str2, str3, str4, str5, z10);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Program)) {
            return false;
        }
        Program program = (Program) obj;
        return i.b(this.programName, program.programName) && i.b(this.startTime, program.startTime) && i.b(this.endTime, program.endTime) && i.b(this.type, program.type) && i.b(this.remark, program.remark) && this.isSub == program.isSub;
    }

    public final String getEndTime() {
        return this.endTime;
    }

    public final String getProgramName() {
        return this.programName;
    }

    public final String getRemark() {
        return this.remark;
    }

    public final String getStartTime() {
        return this.startTime;
    }

    public final String getType() {
        return this.type;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((this.programName.hashCode() * 31) + this.startTime.hashCode()) * 31) + this.endTime.hashCode()) * 31;
        String str = this.type;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.remark;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        boolean z10 = this.isSub;
        int i10 = z10;
        if (z10 != 0) {
            i10 = 1;
        }
        return hashCode3 + i10;
    }

    public final boolean isSub() {
        return this.isSub;
    }

    public final void setEndTime(String str) {
        i.g(str, "<set-?>");
        this.endTime = str;
    }

    public final void setProgramName(String str) {
        i.g(str, "<set-?>");
        this.programName = str;
    }

    public final void setRemark(String str) {
        this.remark = str;
    }

    public final void setStartTime(String str) {
        i.g(str, "<set-?>");
        this.startTime = str;
    }

    public final void setSub(boolean z10) {
        this.isSub = z10;
    }

    public final void setType(String str) {
        this.type = str;
    }

    public String toString() {
        return "Program(programName=" + this.programName + ", startTime=" + this.startTime + ", endTime=" + this.endTime + ", type=" + this.type + ", remark=" + this.remark + ", isSub=" + this.isSub + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }

    public /* synthetic */ Program(String str, String str2, String str3, String str4, String str5, boolean z10, int i10, g gVar) {
        this(str, str2, str3, str4, str5, (i10 & 32) != 0 ? false : z10);
    }
}
