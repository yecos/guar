package ua;

import java.util.Date;

/* loaded from: classes3.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public String f19073a;

    /* renamed from: b, reason: collision with root package name */
    public Object f19074b;

    public b(String str, Object obj) {
        this.f19073a = str;
        this.f19074b = obj;
    }

    public String a() {
        return this.f19073a;
    }

    public Object b() {
        Object obj = this.f19074b;
        return ((obj instanceof Date) || (obj instanceof java.sql.Date)) ? wa.b.f19269a.format(obj) : obj;
    }
}
