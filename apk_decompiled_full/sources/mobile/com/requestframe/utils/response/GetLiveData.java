package mobile.com.requestframe.utils.response;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.io.Serializable;
import java.util.List;
import t9.i;

/* loaded from: classes3.dex */
public final class GetLiveData implements Serializable {
    private List<Channel> channelList;
    private int channelListTotalSize;
    private String dataVersion;
    private String expireTimeStr;

    public GetLiveData(String str, String str2, int i10, List<Channel> list) {
        i.g(list, "channelList");
        this.dataVersion = str;
        this.expireTimeStr = str2;
        this.channelListTotalSize = i10;
        this.channelList = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GetLiveData copy$default(GetLiveData getLiveData, String str, String str2, int i10, List list, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = getLiveData.dataVersion;
        }
        if ((i11 & 2) != 0) {
            str2 = getLiveData.expireTimeStr;
        }
        if ((i11 & 4) != 0) {
            i10 = getLiveData.channelListTotalSize;
        }
        if ((i11 & 8) != 0) {
            list = getLiveData.channelList;
        }
        return getLiveData.copy(str, str2, i10, list);
    }

    public final String component1() {
        return this.dataVersion;
    }

    public final String component2() {
        return this.expireTimeStr;
    }

    public final int component3() {
        return this.channelListTotalSize;
    }

    public final List<Channel> component4() {
        return this.channelList;
    }

    public final GetLiveData copy(String str, String str2, int i10, List<Channel> list) {
        i.g(list, "channelList");
        return new GetLiveData(str, str2, i10, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GetLiveData)) {
            return false;
        }
        GetLiveData getLiveData = (GetLiveData) obj;
        return i.b(this.dataVersion, getLiveData.dataVersion) && i.b(this.expireTimeStr, getLiveData.expireTimeStr) && this.channelListTotalSize == getLiveData.channelListTotalSize && i.b(this.channelList, getLiveData.channelList);
    }

    public final List<Channel> getChannelList() {
        return this.channelList;
    }

    public final int getChannelListTotalSize() {
        return this.channelListTotalSize;
    }

    public final String getDataVersion() {
        return this.dataVersion;
    }

    public final String getExpireTimeStr() {
        return this.expireTimeStr;
    }

    public int hashCode() {
        String str = this.dataVersion;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.expireTimeStr;
        return ((((hashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.channelListTotalSize) * 31) + this.channelList.hashCode();
    }

    public final void setChannelList(List<Channel> list) {
        i.g(list, "<set-?>");
        this.channelList = list;
    }

    public final void setChannelListTotalSize(int i10) {
        this.channelListTotalSize = i10;
    }

    public final void setDataVersion(String str) {
        this.dataVersion = str;
    }

    public final void setExpireTimeStr(String str) {
        this.expireTimeStr = str;
    }

    public String toString() {
        return "GetLiveData(dataVersion=" + this.dataVersion + ", expireTimeStr=" + this.expireTimeStr + ", channelListTotalSize=" + this.channelListTotalSize + ", channelList=" + this.channelList + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
