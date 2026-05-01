package com.mobile.brasiltv.bean;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import t9.g;
import t9.i;

/* loaded from: classes3.dex */
public final class LiveTabEntity {
    private boolean isSelected;
    private String name;
    private int position;

    public LiveTabEntity(String str, boolean z10, int i10) {
        i.g(str, "name");
        this.name = str;
        this.isSelected = z10;
        this.position = i10;
    }

    public static /* synthetic */ LiveTabEntity copy$default(LiveTabEntity liveTabEntity, String str, boolean z10, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = liveTabEntity.name;
        }
        if ((i11 & 2) != 0) {
            z10 = liveTabEntity.isSelected;
        }
        if ((i11 & 4) != 0) {
            i10 = liveTabEntity.position;
        }
        return liveTabEntity.copy(str, z10, i10);
    }

    public final String component1() {
        return this.name;
    }

    public final boolean component2() {
        return this.isSelected;
    }

    public final int component3() {
        return this.position;
    }

    public final LiveTabEntity copy(String str, boolean z10, int i10) {
        i.g(str, "name");
        return new LiveTabEntity(str, z10, i10);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LiveTabEntity)) {
            return false;
        }
        LiveTabEntity liveTabEntity = (LiveTabEntity) obj;
        return i.b(this.name, liveTabEntity.name) && this.isSelected == liveTabEntity.isSelected && this.position == liveTabEntity.position;
    }

    public final String getName() {
        return this.name;
    }

    public final int getPosition() {
        return this.position;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = this.name.hashCode() * 31;
        boolean z10 = this.isSelected;
        int i10 = z10;
        if (z10 != 0) {
            i10 = 1;
        }
        return ((hashCode + i10) * 31) + this.position;
    }

    public final boolean isSelected() {
        return this.isSelected;
    }

    public final void setName(String str) {
        i.g(str, "<set-?>");
        this.name = str;
    }

    public final void setPosition(int i10) {
        this.position = i10;
    }

    public final void setSelected(boolean z10) {
        this.isSelected = z10;
    }

    public String toString() {
        return "LiveTabEntity(name=" + this.name + ", isSelected=" + this.isSelected + ", position=" + this.position + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }

    public /* synthetic */ LiveTabEntity(String str, boolean z10, int i10, int i11, g gVar) {
        this(str, (i11 & 2) != 0 ? false : z10, (i11 & 4) != 0 ? 0 : i10);
    }
}
