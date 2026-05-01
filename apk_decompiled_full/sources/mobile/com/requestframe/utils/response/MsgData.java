package mobile.com.requestframe.utils.response;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.util.ArrayList;
import t9.i;

/* loaded from: classes3.dex */
public final class MsgData {
    private ArrayList<Msg> msgList;
    private int totalSize;

    public MsgData(ArrayList<Msg> arrayList, int i10) {
        this.msgList = arrayList;
        this.totalSize = i10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MsgData copy$default(MsgData msgData, ArrayList arrayList, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            arrayList = msgData.msgList;
        }
        if ((i11 & 2) != 0) {
            i10 = msgData.totalSize;
        }
        return msgData.copy(arrayList, i10);
    }

    public final ArrayList<Msg> component1() {
        return this.msgList;
    }

    public final int component2() {
        return this.totalSize;
    }

    public final MsgData copy(ArrayList<Msg> arrayList, int i10) {
        return new MsgData(arrayList, i10);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MsgData)) {
            return false;
        }
        MsgData msgData = (MsgData) obj;
        return i.b(this.msgList, msgData.msgList) && this.totalSize == msgData.totalSize;
    }

    public final ArrayList<Msg> getMsgList() {
        return this.msgList;
    }

    public final int getTotalSize() {
        return this.totalSize;
    }

    public int hashCode() {
        ArrayList<Msg> arrayList = this.msgList;
        return ((arrayList == null ? 0 : arrayList.hashCode()) * 31) + this.totalSize;
    }

    public final void setMsgList(ArrayList<Msg> arrayList) {
        this.msgList = arrayList;
    }

    public final void setTotalSize(int i10) {
        this.totalSize = i10;
    }

    public String toString() {
        return "MsgData(msgList=" + this.msgList + ", totalSize=" + this.totalSize + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
