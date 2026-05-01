package mobile.com.requestframe.utils.response;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.io.Serializable;
import t9.i;

/* loaded from: classes3.dex */
public final class TeamEvent implements Serializable {
    private String eventName;
    private String eventTime;
    private String eventType;

    public TeamEvent(String str, String str2, String str3) {
        i.g(str2, "eventName");
        i.g(str3, "eventTime");
        this.eventType = str;
        this.eventName = str2;
        this.eventTime = str3;
    }

    public static /* synthetic */ TeamEvent copy$default(TeamEvent teamEvent, String str, String str2, String str3, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = teamEvent.eventType;
        }
        if ((i10 & 2) != 0) {
            str2 = teamEvent.eventName;
        }
        if ((i10 & 4) != 0) {
            str3 = teamEvent.eventTime;
        }
        return teamEvent.copy(str, str2, str3);
    }

    public final String component1() {
        return this.eventType;
    }

    public final String component2() {
        return this.eventName;
    }

    public final String component3() {
        return this.eventTime;
    }

    public final TeamEvent copy(String str, String str2, String str3) {
        i.g(str2, "eventName");
        i.g(str3, "eventTime");
        return new TeamEvent(str, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TeamEvent)) {
            return false;
        }
        TeamEvent teamEvent = (TeamEvent) obj;
        return i.b(this.eventType, teamEvent.eventType) && i.b(this.eventName, teamEvent.eventName) && i.b(this.eventTime, teamEvent.eventTime);
    }

    public final String getEventName() {
        return this.eventName;
    }

    public final String getEventTime() {
        return this.eventTime;
    }

    public final String getEventType() {
        return this.eventType;
    }

    public int hashCode() {
        String str = this.eventType;
        return ((((str == null ? 0 : str.hashCode()) * 31) + this.eventName.hashCode()) * 31) + this.eventTime.hashCode();
    }

    public final void setEventName(String str) {
        i.g(str, "<set-?>");
        this.eventName = str;
    }

    public final void setEventTime(String str) {
        i.g(str, "<set-?>");
        this.eventTime = str;
    }

    public final void setEventType(String str) {
        this.eventType = str;
    }

    public String toString() {
        return "TeamEvent(eventType=" + this.eventType + ", eventName=" + this.eventName + ", eventTime=" + this.eventTime + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
