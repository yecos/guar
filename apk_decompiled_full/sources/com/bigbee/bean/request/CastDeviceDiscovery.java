package com.bigbee.bean.request;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.util.ArrayList;
import t1.a;
import t9.i;

/* loaded from: classes.dex */
public final class CastDeviceDiscovery {
    private String cast_ver;
    private ArrayList<Device> devices;
    private long duration;
    private boolean isConnectToWifi;

    public CastDeviceDiscovery(String str, long j10, ArrayList<Device> arrayList, boolean z10) {
        i.g(str, "cast_ver");
        i.g(arrayList, "devices");
        this.cast_ver = str;
        this.duration = j10;
        this.devices = arrayList;
        this.isConnectToWifi = z10;
    }

    public static /* synthetic */ CastDeviceDiscovery copy$default(CastDeviceDiscovery castDeviceDiscovery, String str, long j10, ArrayList arrayList, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = castDeviceDiscovery.cast_ver;
        }
        if ((i10 & 2) != 0) {
            j10 = castDeviceDiscovery.duration;
        }
        long j11 = j10;
        if ((i10 & 4) != 0) {
            arrayList = castDeviceDiscovery.devices;
        }
        ArrayList arrayList2 = arrayList;
        if ((i10 & 8) != 0) {
            z10 = castDeviceDiscovery.isConnectToWifi;
        }
        return castDeviceDiscovery.copy(str, j11, arrayList2, z10);
    }

    public final String component1() {
        return this.cast_ver;
    }

    public final long component2() {
        return this.duration;
    }

    public final ArrayList<Device> component3() {
        return this.devices;
    }

    public final boolean component4() {
        return this.isConnectToWifi;
    }

    public final CastDeviceDiscovery copy(String str, long j10, ArrayList<Device> arrayList, boolean z10) {
        i.g(str, "cast_ver");
        i.g(arrayList, "devices");
        return new CastDeviceDiscovery(str, j10, arrayList, z10);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CastDeviceDiscovery)) {
            return false;
        }
        CastDeviceDiscovery castDeviceDiscovery = (CastDeviceDiscovery) obj;
        return i.b(this.cast_ver, castDeviceDiscovery.cast_ver) && this.duration == castDeviceDiscovery.duration && i.b(this.devices, castDeviceDiscovery.devices) && this.isConnectToWifi == castDeviceDiscovery.isConnectToWifi;
    }

    public final String getCast_ver() {
        return this.cast_ver;
    }

    public final ArrayList<Device> getDevices() {
        return this.devices;
    }

    public final long getDuration() {
        return this.duration;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((this.cast_ver.hashCode() * 31) + a.a(this.duration)) * 31) + this.devices.hashCode()) * 31;
        boolean z10 = this.isConnectToWifi;
        int i10 = z10;
        if (z10 != 0) {
            i10 = 1;
        }
        return hashCode + i10;
    }

    public final boolean isConnectToWifi() {
        return this.isConnectToWifi;
    }

    public final void setCast_ver(String str) {
        i.g(str, "<set-?>");
        this.cast_ver = str;
    }

    public final void setConnectToWifi(boolean z10) {
        this.isConnectToWifi = z10;
    }

    public final void setDevices(ArrayList<Device> arrayList) {
        i.g(arrayList, "<set-?>");
        this.devices = arrayList;
    }

    public final void setDuration(long j10) {
        this.duration = j10;
    }

    public String toString() {
        return "CastDeviceDiscovery(cast_ver=" + this.cast_ver + ", duration=" + this.duration + ", devices=" + this.devices + ", isConnectToWifi=" + this.isConnectToWifi + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
