package i8;

import com.umeng.analytics.pro.bt;
import t9.i;

/* loaded from: classes3.dex */
public enum e {
    NET_TYPE_WIRED("wired"),
    NET_TYPE_WLAN("wlan"),
    NET_TYPE_CELLULAR("cellular"),
    DEVICE_TYPE_DISK("disk"),
    DEVICE_TYPE_MOUSE("mouse"),
    DEVICE_TYPE_KEYBOARD("keyboard"),
    DEVICE_TYPE_RING("ring"),
    DEVICE_TYPE_BATTERY(bt.Z),
    KEY_TYPE_HOME("home"),
    KEY_TYPE_TASK("task"),
    NONE("");


    /* renamed from: a, reason: collision with root package name */
    public String f14387a;

    e(String str) {
        i.h(str, "value");
        this.f14387a = str;
    }

    public final String a() {
        return this.f14387a;
    }
}
