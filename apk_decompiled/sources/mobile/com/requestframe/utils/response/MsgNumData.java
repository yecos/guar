package mobile.com.requestframe.utils.response;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;

/* loaded from: classes3.dex */
public final class MsgNumData {
    private int actNum;
    private int sysNum;

    public MsgNumData(int i10, int i11) {
        this.sysNum = i10;
        this.actNum = i11;
    }

    public static /* synthetic */ MsgNumData copy$default(MsgNumData msgNumData, int i10, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = msgNumData.sysNum;
        }
        if ((i12 & 2) != 0) {
            i11 = msgNumData.actNum;
        }
        return msgNumData.copy(i10, i11);
    }

    public final int component1() {
        return this.sysNum;
    }

    public final int component2() {
        return this.actNum;
    }

    public final MsgNumData copy(int i10, int i11) {
        return new MsgNumData(i10, i11);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MsgNumData)) {
            return false;
        }
        MsgNumData msgNumData = (MsgNumData) obj;
        return this.sysNum == msgNumData.sysNum && this.actNum == msgNumData.actNum;
    }

    public final int getActNum() {
        return this.actNum;
    }

    public final int getSysNum() {
        return this.sysNum;
    }

    public int hashCode() {
        return (this.sysNum * 31) + this.actNum;
    }

    public final void setActNum(int i10) {
        this.actNum = i10;
    }

    public final void setSysNum(int i10) {
        this.sysNum = i10;
    }

    public String toString() {
        return "MsgNumData(sysNum=" + this.sysNum + ", actNum=" + this.actNum + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
