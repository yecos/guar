package i8;

import t9.i;

/* loaded from: classes3.dex */
public enum c {
    EVENT_TYPE_START("start"),
    EVENT_TYPE_PAUSE("pause"),
    EVENT_TYPE_RESUME("resume"),
    EVENT_TYPE_STOP("stop");


    /* renamed from: a, reason: collision with root package name */
    public String f14365a;

    c(String str) {
        i.h(str, "value");
        this.f14365a = str;
    }

    public final String a() {
        return this.f14365a;
    }
}
