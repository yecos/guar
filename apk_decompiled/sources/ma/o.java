package ma;

import android.content.Context;
import java.util.List;
import okhttp3.Dns;

/* loaded from: classes.dex */
public final class o implements Dns {

    /* renamed from: a, reason: collision with root package name */
    public final Context f16866a;

    /* renamed from: b, reason: collision with root package name */
    public ja.b f16867b;

    /* loaded from: classes3.dex */
    public static final class a implements ha.c {
        public a() {
        }

        @Override // ha.c
        public void a(String str, String str2, String str3, String str4) {
            t9.i.g(str, "type");
            t9.i.g(str2, "hostnameMapper");
            t9.i.g(str3, "mapper");
            t9.i.g(str4, "resolver");
            d.f16852a.a(o.this.a(), str, str2, str3, str4);
        }
    }

    public o(Context context) {
        t9.i.g(context, com.umeng.analytics.pro.f.X);
        this.f16866a = context;
        this.f16867b = ja.b.f14706f.a();
    }

    public final Context a() {
        return this.f16866a;
    }

    @Override // okhttp3.Dns
    public List lookup(String str) {
        t9.i.g(str, "hostname");
        this.f16867b.o(new a());
        return this.f16867b.j(str, ".bigbee");
    }
}
