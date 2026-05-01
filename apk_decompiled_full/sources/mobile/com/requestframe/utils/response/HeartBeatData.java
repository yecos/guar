package mobile.com.requestframe.utils.response;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import t9.i;

/* loaded from: classes3.dex */
public final class HeartBeatData {
    private int availableTime;
    private String userToken;

    public HeartBeatData(String str, int i10) {
        this.userToken = str;
        this.availableTime = i10;
    }

    public static /* synthetic */ HeartBeatData copy$default(HeartBeatData heartBeatData, String str, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = heartBeatData.userToken;
        }
        if ((i11 & 2) != 0) {
            i10 = heartBeatData.availableTime;
        }
        return heartBeatData.copy(str, i10);
    }

    public final String component1() {
        return this.userToken;
    }

    public final int component2() {
        return this.availableTime;
    }

    public final HeartBeatData copy(String str, int i10) {
        return new HeartBeatData(str, i10);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HeartBeatData)) {
            return false;
        }
        HeartBeatData heartBeatData = (HeartBeatData) obj;
        return i.b(this.userToken, heartBeatData.userToken) && this.availableTime == heartBeatData.availableTime;
    }

    public final int getAvailableTime() {
        return this.availableTime;
    }

    public final String getUserToken() {
        return this.userToken;
    }

    public int hashCode() {
        String str = this.userToken;
        return ((str == null ? 0 : str.hashCode()) * 31) + this.availableTime;
    }

    public final void setAvailableTime(int i10) {
        this.availableTime = i10;
    }

    public final void setUserToken(String str) {
        this.userToken = str;
    }

    public String toString() {
        return "HeartBeatData(userToken=" + this.userToken + ", availableTime=" + this.availableTime + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
