package a1;

import android.os.Build;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/* loaded from: classes.dex */
public abstract class u {

    /* renamed from: a, reason: collision with root package name */
    public UUID f137a;

    /* renamed from: b, reason: collision with root package name */
    public j1.p f138b;

    /* renamed from: c, reason: collision with root package name */
    public Set f139c;

    public static abstract class a {

        /* renamed from: c, reason: collision with root package name */
        public j1.p f142c;

        /* renamed from: e, reason: collision with root package name */
        public Class f144e;

        /* renamed from: a, reason: collision with root package name */
        public boolean f140a = false;

        /* renamed from: d, reason: collision with root package name */
        public Set f143d = new HashSet();

        /* renamed from: b, reason: collision with root package name */
        public UUID f141b = UUID.randomUUID();

        public a(Class cls) {
            this.f144e = cls;
            this.f142c = new j1.p(this.f141b.toString(), cls.getName());
            a(cls.getName());
        }

        public final a a(String str) {
            this.f143d.add(str);
            return d();
        }

        public final u b() {
            u c10 = c();
            b bVar = this.f142c.f14592j;
            int i10 = Build.VERSION.SDK_INT;
            boolean z10 = (i10 >= 24 && bVar.e()) || bVar.f() || bVar.g() || (i10 >= 23 && bVar.h());
            if (this.f142c.f14599q && z10) {
                throw new IllegalArgumentException("Expedited jobs only support network and storage constraints");
            }
            this.f141b = UUID.randomUUID();
            j1.p pVar = new j1.p(this.f142c);
            this.f142c = pVar;
            pVar.f14583a = this.f141b.toString();
            return c10;
        }

        public abstract u c();

        public abstract a d();
    }

    public u(UUID uuid, j1.p pVar, Set set) {
        this.f137a = uuid;
        this.f138b = pVar;
        this.f139c = set;
    }

    public String a() {
        return this.f137a.toString();
    }

    public Set b() {
        return this.f139c;
    }

    public j1.p c() {
        return this.f138b;
    }
}
