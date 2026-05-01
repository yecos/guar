package mobile.com.requestframe.utils.response;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.io.Serializable;

/* loaded from: classes3.dex */
public final class AddSubscribe implements Serializable {
    private int subscribeId;

    public AddSubscribe(int i10) {
        this.subscribeId = i10;
    }

    public static /* synthetic */ AddSubscribe copy$default(AddSubscribe addSubscribe, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = addSubscribe.subscribeId;
        }
        return addSubscribe.copy(i10);
    }

    public final int component1() {
        return this.subscribeId;
    }

    public final AddSubscribe copy(int i10) {
        return new AddSubscribe(i10);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof AddSubscribe) && this.subscribeId == ((AddSubscribe) obj).subscribeId;
    }

    public final int getSubscribeId() {
        return this.subscribeId;
    }

    public int hashCode() {
        return this.subscribeId;
    }

    public final void setSubscribeId(int i10) {
        this.subscribeId = i10;
    }

    public String toString() {
        return "AddSubscribe(subscribeId=" + this.subscribeId + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
