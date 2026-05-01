package q8;

import l8.h;

/* loaded from: classes.dex */
public abstract class e {
    public static void a(String str) {
        h.f16357m.a().v(i8.d.SYS_EVENT_TYPE_APP, i8.e.NONE, g(str));
    }

    public static void b(String str, int i10) {
        h.f16357m.a().u(i8.d.SYS_EVENT_TYPE_DEVICE, f(str), i10);
    }

    public static void c(String str) {
        h.f16357m.a().v(i8.d.SYS_EVENT_TYPE_DOZE, i8.e.NONE, g(str));
    }

    public static void d(String str, String str2) {
        h.f16357m.a().v(i8.d.SYS_EVENT_TYPE_NET, h(str), g(str2));
    }

    public static void e(String str) {
        h.f16357m.a().v(i8.d.SYS_EVENT_TYPE_SCREEN, i8.e.NONE, g(str));
    }

    public static i8.e f(String str) {
        str.hashCode();
        switch (str) {
            case "battery":
                return i8.e.DEVICE_TYPE_BATTERY;
            case "disk":
                return i8.e.DEVICE_TYPE_DISK;
            case "ring":
                return i8.e.DEVICE_TYPE_RING;
            case "mouse":
                return i8.e.DEVICE_TYPE_MOUSE;
            case "keyboard":
                return i8.e.DEVICE_TYPE_KEYBOARD;
            default:
                return i8.e.NONE;
        }
    }

    public static i8.c g(String str) {
        str.hashCode();
        switch (str) {
        }
        return i8.c.EVENT_TYPE_START;
    }

    public static i8.e h(String str) {
        str.hashCode();
        switch (str) {
            case "cellular":
                return i8.e.NET_TYPE_CELLULAR;
            case "wlan":
                return i8.e.NET_TYPE_WLAN;
            case "wired":
                return i8.e.NET_TYPE_WIRED;
            default:
                return i8.e.NONE;
        }
    }
}
