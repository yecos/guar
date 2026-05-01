package la;

import android.os.Build;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.taobao.accs.common.Constants;
import com.umeng.analytics.pro.bt;
import java.util.Map;
import java.util.Set;
import t9.j;

/* loaded from: classes3.dex */
public final class c extends la.d {

    /* renamed from: b, reason: collision with root package name */
    public final h9.g f16442b = h9.h.b(a.f16451a);

    /* renamed from: c, reason: collision with root package name */
    public final h9.g f16443c = h9.h.b(i.f16459a);

    /* renamed from: d, reason: collision with root package name */
    public final h9.g f16444d = h9.h.b(b.f16452a);

    /* renamed from: e, reason: collision with root package name */
    public final h9.g f16445e = h9.h.b(e.f16455a);

    /* renamed from: f, reason: collision with root package name */
    public final h9.g f16446f = h9.h.b(f.f16456a);

    /* renamed from: g, reason: collision with root package name */
    public final h9.g f16447g = h9.h.b(g.f16457a);

    /* renamed from: h, reason: collision with root package name */
    public final h9.g f16448h = h9.h.b(C0286c.f16453a);

    /* renamed from: i, reason: collision with root package name */
    public final h9.g f16449i = h9.h.b(d.f16454a);

    /* renamed from: j, reason: collision with root package name */
    public final h9.g f16450j = h9.h.b(h.f16458a);

    public static final class a extends j implements s9.a {

        /* renamed from: a, reason: collision with root package name */
        public static final a f16451a = new a();

        public a() {
            super(0);
        }

        @Override // s9.a
        public final Integer invoke() {
            return Integer.valueOf(na.a.b());
        }
    }

    public static final class b extends j implements s9.a {

        /* renamed from: a, reason: collision with root package name */
        public static final b f16452a = new b();

        public b() {
            super(0);
        }

        @Override // s9.a
        public final String invoke() {
            return na.a.g();
        }
    }

    /* renamed from: la.c$c, reason: collision with other inner class name */
    public static final class C0286c extends j implements s9.a {

        /* renamed from: a, reason: collision with root package name */
        public static final C0286c f16453a = new C0286c();

        public C0286c() {
            super(0);
        }

        @Override // s9.a
        public final String invoke() {
            return Build.CPU_ABI;
        }
    }

    public static final class d extends j implements s9.a {

        /* renamed from: a, reason: collision with root package name */
        public static final d f16454a = new d();

        public d() {
            super(0);
        }

        @Override // s9.a
        public final String invoke() {
            return na.a.e();
        }
    }

    public static final class e extends j implements s9.a {

        /* renamed from: a, reason: collision with root package name */
        public static final e f16455a = new e();

        public e() {
            super(0);
        }

        @Override // s9.a
        public final String invoke() {
            return Build.HARDWARE;
        }
    }

    public static final class f extends j implements s9.a {

        /* renamed from: a, reason: collision with root package name */
        public static final f f16456a = new f();

        public f() {
            super(0);
        }

        @Override // s9.a
        public final String invoke() {
            return Build.MODEL;
        }
    }

    public static final class g extends j implements s9.a {

        /* renamed from: a, reason: collision with root package name */
        public static final g f16457a = new g();

        public g() {
            super(0);
        }

        @Override // s9.a
        public final String invoke() {
            return Build.PRODUCT;
        }
    }

    public static final class h extends j implements s9.a {

        /* renamed from: a, reason: collision with root package name */
        public static final h f16458a = new h();

        public h() {
            super(0);
        }

        @Override // s9.a
        public final String invoke() {
            return na.c.f17340b;
        }
    }

    public static final class i extends j implements s9.a {

        /* renamed from: a, reason: collision with root package name */
        public static final i f16459a = new i();

        public i() {
            super(0);
        }

        @Override // s9.a
        public final String invoke() {
            return Build.VERSION.RELEASE;
        }
    }

    @Override // la.d
    public Iterable a() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("loginType", "3");
        jsonObject.addProperty("appLanguage", na.a.a());
        jsonObject.addProperty("apkVersion", String.valueOf(d()));
        jsonObject.addProperty("sysVersion", l());
        jsonObject.addProperty("appId", e());
        jsonObject.addProperty("hardwareInfo", h());
        jsonObject.addProperty(Constants.KEY_MODEL, i());
        jsonObject.addProperty("product", j());
        jsonObject.addProperty(bt.f10062w, f());
        jsonObject.addProperty("deviceToken", g());
        jsonObject.addProperty("reserve1", k());
        jsonObject.addProperty("sn", na.a.h());
        jsonObject.addProperty("drmId", na.a.d());
        Set<Map.Entry<String, JsonElement>> entrySet = jsonObject.entrySet();
        t9.i.f(entrySet, "newParams.entrySet()");
        return entrySet;
    }

    @Override // la.d
    public boolean c() {
        return true;
    }

    public final int d() {
        return ((Number) this.f16442b.getValue()).intValue();
    }

    public final String e() {
        return (String) this.f16444d.getValue();
    }

    public final String f() {
        return (String) this.f16448h.getValue();
    }

    public final String g() {
        return (String) this.f16449i.getValue();
    }

    public final String h() {
        return (String) this.f16445e.getValue();
    }

    public final String i() {
        return (String) this.f16446f.getValue();
    }

    public final String j() {
        return (String) this.f16447g.getValue();
    }

    public final String k() {
        return (String) this.f16450j.getValue();
    }

    public final String l() {
        return (String) this.f16443c.getValue();
    }
}
