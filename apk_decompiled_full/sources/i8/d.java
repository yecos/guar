package i8;

import com.hpplay.cybergarage.upnp.Device;
import t9.i;

/* loaded from: classes3.dex */
public enum d {
    SYS_EVENT_TYPE_NET("net"),
    SYS_EVENT_TYPE_DEVICE(Device.ELEM_NAME),
    SYS_EVENT_TYPE_KEY("key"),
    SYS_EVENT_TYPE_APP("app"),
    SYS_EVENT_TYPE_SCREEN("screen"),
    SYS_EVENT_TYPE_FOREGROUND("foreground"),
    SYS_EVENT_TYPE_DOZE("doze");


    /* renamed from: a, reason: collision with root package name */
    public String f14374a;

    d(String str) {
        i.h(str, "value");
        this.f14374a = str;
    }

    public final String a() {
        return this.f14374a;
    }
}
