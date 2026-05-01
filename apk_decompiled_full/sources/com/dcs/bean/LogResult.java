package com.dcs.bean;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.util.ArrayList;
import t9.i;

/* loaded from: classes.dex */
public final class LogResult {
    private ArrayList<Business> global;
    private ArrayList<Business> group;

    public LogResult(ArrayList<Business> arrayList, ArrayList<Business> arrayList2) {
        this.global = arrayList;
        this.group = arrayList2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ LogResult copy$default(LogResult logResult, ArrayList arrayList, ArrayList arrayList2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            arrayList = logResult.global;
        }
        if ((i10 & 2) != 0) {
            arrayList2 = logResult.group;
        }
        return logResult.copy(arrayList, arrayList2);
    }

    public final ArrayList<Business> component1() {
        return this.global;
    }

    public final ArrayList<Business> component2() {
        return this.group;
    }

    public final LogResult copy(ArrayList<Business> arrayList, ArrayList<Business> arrayList2) {
        return new LogResult(arrayList, arrayList2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LogResult)) {
            return false;
        }
        LogResult logResult = (LogResult) obj;
        return i.b(this.global, logResult.global) && i.b(this.group, logResult.group);
    }

    public final ArrayList<Business> getGlobal() {
        return this.global;
    }

    public final ArrayList<Business> getGroup() {
        return this.group;
    }

    public int hashCode() {
        ArrayList<Business> arrayList = this.global;
        int hashCode = (arrayList == null ? 0 : arrayList.hashCode()) * 31;
        ArrayList<Business> arrayList2 = this.group;
        return hashCode + (arrayList2 != null ? arrayList2.hashCode() : 0);
    }

    public final void setGlobal(ArrayList<Business> arrayList) {
        this.global = arrayList;
    }

    public final void setGroup(ArrayList<Business> arrayList) {
        this.group = arrayList;
    }

    public String toString() {
        return "LogResult(global=" + this.global + ", group=" + this.group + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
