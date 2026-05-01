package com.bigbee.bean;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import t1.a;

/* loaded from: classes.dex */
public final class ServerTime {
    private long timestamp;

    public ServerTime(long j10) {
        this.timestamp = j10;
    }

    public static /* synthetic */ ServerTime copy$default(ServerTime serverTime, long j10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            j10 = serverTime.timestamp;
        }
        return serverTime.copy(j10);
    }

    public final long component1() {
        return this.timestamp;
    }

    public final ServerTime copy(long j10) {
        return new ServerTime(j10);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ServerTime) && this.timestamp == ((ServerTime) obj).timestamp;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public int hashCode() {
        return a.a(this.timestamp);
    }

    public final void setTimestamp(long j10) {
        this.timestamp = j10;
    }

    public String toString() {
        return "ServerTime(timestamp=" + this.timestamp + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
