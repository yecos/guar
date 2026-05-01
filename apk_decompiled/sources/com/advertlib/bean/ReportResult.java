package com.advertlib.bean;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import com.taobao.accs.common.Constants;
import t9.i;

/* loaded from: classes.dex */
public final class ReportResult {
    private final String message;
    private final String returnCode;

    public ReportResult(String str, String str2) {
        i.g(str, Constants.SHARED_MESSAGE_ID_FILE);
        i.g(str2, "returnCode");
        this.message = str;
        this.returnCode = str2;
    }

    public static /* synthetic */ ReportResult copy$default(ReportResult reportResult, String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = reportResult.message;
        }
        if ((i10 & 2) != 0) {
            str2 = reportResult.returnCode;
        }
        return reportResult.copy(str, str2);
    }

    public final String component1() {
        return this.message;
    }

    public final String component2() {
        return this.returnCode;
    }

    public final ReportResult copy(String str, String str2) {
        i.g(str, Constants.SHARED_MESSAGE_ID_FILE);
        i.g(str2, "returnCode");
        return new ReportResult(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ReportResult)) {
            return false;
        }
        ReportResult reportResult = (ReportResult) obj;
        return i.b(this.message, reportResult.message) && i.b(this.returnCode, reportResult.returnCode);
    }

    public final String getMessage() {
        return this.message;
    }

    public final String getReturnCode() {
        return this.returnCode;
    }

    public int hashCode() {
        return (this.message.hashCode() * 31) + this.returnCode.hashCode();
    }

    public String toString() {
        return "ReportResult(message=" + this.message + ", returnCode=" + this.returnCode + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
