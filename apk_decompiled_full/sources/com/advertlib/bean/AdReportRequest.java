package com.advertlib.bean;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.util.List;
import t9.i;

/* loaded from: classes.dex */
public final class AdReportRequest {
    private List<AdReportBean> report_content;

    public AdReportRequest(List<AdReportBean> list) {
        i.g(list, "report_content");
        this.report_content = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AdReportRequest copy$default(AdReportRequest adReportRequest, List list, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = adReportRequest.report_content;
        }
        return adReportRequest.copy(list);
    }

    public final List<AdReportBean> component1() {
        return this.report_content;
    }

    public final AdReportRequest copy(List<AdReportBean> list) {
        i.g(list, "report_content");
        return new AdReportRequest(list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof AdReportRequest) && i.b(this.report_content, ((AdReportRequest) obj).report_content);
    }

    public final List<AdReportBean> getReport_content() {
        return this.report_content;
    }

    public int hashCode() {
        return this.report_content.hashCode();
    }

    public final void setReport_content(List<AdReportBean> list) {
        i.g(list, "<set-?>");
        this.report_content = list;
    }

    public String toString() {
        return "AdReportRequest(report_content=" + this.report_content + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
