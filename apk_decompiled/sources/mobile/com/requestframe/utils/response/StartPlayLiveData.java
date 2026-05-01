package mobile.com.requestframe.utils.response;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.util.List;
import t9.i;

/* loaded from: classes3.dex */
public final class StartPlayLiveData {
    private List<LiveAddress> liveAddressList;
    private String name;

    public StartPlayLiveData(List<LiveAddress> list, String str) {
        i.g(str, "name");
        this.liveAddressList = list;
        this.name = str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ StartPlayLiveData copy$default(StartPlayLiveData startPlayLiveData, List list, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = startPlayLiveData.liveAddressList;
        }
        if ((i10 & 2) != 0) {
            str = startPlayLiveData.name;
        }
        return startPlayLiveData.copy(list, str);
    }

    public final List<LiveAddress> component1() {
        return this.liveAddressList;
    }

    public final String component2() {
        return this.name;
    }

    public final StartPlayLiveData copy(List<LiveAddress> list, String str) {
        i.g(str, "name");
        return new StartPlayLiveData(list, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StartPlayLiveData)) {
            return false;
        }
        StartPlayLiveData startPlayLiveData = (StartPlayLiveData) obj;
        return i.b(this.liveAddressList, startPlayLiveData.liveAddressList) && i.b(this.name, startPlayLiveData.name);
    }

    public final List<LiveAddress> getLiveAddressList() {
        return this.liveAddressList;
    }

    public final String getName() {
        return this.name;
    }

    public int hashCode() {
        List<LiveAddress> list = this.liveAddressList;
        return ((list == null ? 0 : list.hashCode()) * 31) + this.name.hashCode();
    }

    public final void setLiveAddressList(List<LiveAddress> list) {
        this.liveAddressList = list;
    }

    public final void setName(String str) {
        i.g(str, "<set-?>");
        this.name = str;
    }

    public String toString() {
        return "StartPlayLiveData(liveAddressList=" + this.liveAddressList + ", name=" + this.name + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
