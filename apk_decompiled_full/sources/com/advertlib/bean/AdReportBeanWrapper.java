package com.advertlib.bean;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import t9.i;

/* loaded from: classes.dex */
public final class AdReportBeanWrapper {
    private final AdReportBean bean;
    private final int id;

    public AdReportBeanWrapper(int i10, AdReportBean adReportBean) {
        i.g(adReportBean, "bean");
        this.id = i10;
        this.bean = adReportBean;
    }

    public static /* synthetic */ AdReportBeanWrapper copy$default(AdReportBeanWrapper adReportBeanWrapper, int i10, AdReportBean adReportBean, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = adReportBeanWrapper.id;
        }
        if ((i11 & 2) != 0) {
            adReportBean = adReportBeanWrapper.bean;
        }
        return adReportBeanWrapper.copy(i10, adReportBean);
    }

    public final int component1() {
        return this.id;
    }

    public final AdReportBean component2() {
        return this.bean;
    }

    public final AdReportBeanWrapper copy(int i10, AdReportBean adReportBean) {
        i.g(adReportBean, "bean");
        return new AdReportBeanWrapper(i10, adReportBean);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AdReportBeanWrapper)) {
            return false;
        }
        AdReportBeanWrapper adReportBeanWrapper = (AdReportBeanWrapper) obj;
        return this.id == adReportBeanWrapper.id && i.b(this.bean, adReportBeanWrapper.bean);
    }

    public final AdReportBean getBean() {
        return this.bean;
    }

    public final int getId() {
        return this.id;
    }

    public int hashCode() {
        return (this.id * 31) + this.bean.hashCode();
    }

    public String toString() {
        return "AdReportBeanWrapper(id=" + this.id + ", bean=" + this.bean + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
