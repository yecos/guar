package r3;

import com.umeng.analytics.pro.bt;
import java.util.HashSet;
import java.util.Set;
import l3.e;
import r3.a;

/* loaded from: classes.dex */
public class w extends r3.a {

    /* renamed from: a, reason: collision with root package name */
    public final m3.m f18489a;

    /* renamed from: b, reason: collision with root package name */
    public final r3.c f18490b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f18491c;

    /* renamed from: d, reason: collision with root package name */
    public final String f18492d;

    /* renamed from: e, reason: collision with root package name */
    public final String f18493e;

    /* renamed from: f, reason: collision with root package name */
    public final String f18494f;

    public interface a {
    }

    public static class b extends a.AbstractC0314a {

        /* renamed from: a, reason: collision with root package name */
        public final String f18495a;

        /* renamed from: b, reason: collision with root package name */
        public final String f18496b;

        /* renamed from: c, reason: collision with root package name */
        public final String f18497c;

        /* renamed from: d, reason: collision with root package name */
        public final String f18498d;

        public b() {
            this("set", "with", "get", bt.ae, null);
        }

        @Override // r3.a.AbstractC0314a
        public r3.a a(m3.m mVar, r3.c cVar, k3.c cVar2) {
            k3.b g10 = mVar.C() ? mVar.g() : null;
            e.a E = g10 != null ? g10.E(cVar) : null;
            return new w(mVar, cVar, E == null ? this.f18496b : E.f15922b, this.f18497c, this.f18498d, null);
        }

        @Override // r3.a.AbstractC0314a
        public r3.a b(m3.m mVar, r3.c cVar) {
            return new w(mVar, cVar, this.f18495a, this.f18497c, this.f18498d, null);
        }

        @Override // r3.a.AbstractC0314a
        public r3.a c(m3.m mVar, r3.c cVar) {
            return new c(mVar, cVar);
        }

        public b(String str, String str2, String str3, String str4, a aVar) {
            this.f18495a = str;
            this.f18496b = str2;
            this.f18497c = str3;
            this.f18498d = str4;
        }
    }

    public static class c extends w {

        /* renamed from: g, reason: collision with root package name */
        public final Set f18499g;

        public c(m3.m mVar, r3.c cVar) {
            super(mVar, cVar, null, "get", bt.ae, null);
            this.f18499g = new HashSet();
            for (String str : s3.a.b(cVar.e())) {
                this.f18499g.add(str);
            }
        }

        @Override // r3.w, r3.a
        public String c(j jVar, String str) {
            return this.f18499g.contains(str) ? str : super.c(jVar, str);
        }
    }

    public w(m3.m mVar, r3.c cVar, String str, String str2, String str3, a aVar) {
        this.f18489a = mVar;
        this.f18490b = cVar;
        this.f18491c = mVar.D(k3.q.USE_STD_BEAN_NAMING);
        this.f18494f = str;
        this.f18492d = str2;
        this.f18493e = str3;
    }

    @Override // r3.a
    public String a(j jVar, String str) {
        if (this.f18493e == null) {
            return null;
        }
        Class e10 = jVar.e();
        if ((e10 == Boolean.class || e10 == Boolean.TYPE) && str.startsWith(this.f18493e)) {
            return this.f18491c ? h(str, 2) : g(str, 2);
        }
        return null;
    }

    @Override // r3.a
    public String b(j jVar, String str) {
        String str2 = this.f18494f;
        if (str2 == null || !str.startsWith(str2)) {
            return null;
        }
        return this.f18491c ? h(str, this.f18494f.length()) : g(str, this.f18494f.length());
    }

    @Override // r3.a
    public String c(j jVar, String str) {
        String str2 = this.f18492d;
        if (str2 == null || !str.startsWith(str2)) {
            return null;
        }
        if ("getCallbacks".equals(str)) {
            if (e(jVar)) {
                return null;
            }
        } else if ("getMetaClass".equals(str) && f(jVar)) {
            return null;
        }
        return this.f18491c ? h(str, this.f18492d.length()) : g(str, this.f18492d.length());
    }

    @Override // r3.a
    public String d(g gVar, String str) {
        return str;
    }

    public boolean e(j jVar) {
        Class e10 = jVar.e();
        if (!e10.isArray()) {
            return false;
        }
        String name = e10.getComponentType().getName();
        if (name.contains(".cglib")) {
            return name.startsWith("net.sf.cglib") || name.startsWith("org.hibernate.repackage.cglib") || name.startsWith("org.springframework.cglib");
        }
        return false;
    }

    public boolean f(j jVar) {
        return jVar.e().getName().startsWith("groovy.lang");
    }

    public String g(String str, int i10) {
        int length = str.length();
        if (length == i10) {
            return null;
        }
        char charAt = str.charAt(i10);
        char lowerCase = Character.toLowerCase(charAt);
        if (charAt == lowerCase) {
            return str.substring(i10);
        }
        StringBuilder sb = new StringBuilder(length - i10);
        sb.append(lowerCase);
        while (true) {
            i10++;
            if (i10 >= length) {
                break;
            }
            char charAt2 = str.charAt(i10);
            char lowerCase2 = Character.toLowerCase(charAt2);
            if (charAt2 == lowerCase2) {
                sb.append((CharSequence) str, i10, length);
                break;
            }
            sb.append(lowerCase2);
        }
        return sb.toString();
    }

    public String h(String str, int i10) {
        int length = str.length();
        if (length == i10) {
            return null;
        }
        char charAt = str.charAt(i10);
        char lowerCase = Character.toLowerCase(charAt);
        if (charAt == lowerCase) {
            return str.substring(i10);
        }
        int i11 = i10 + 1;
        if (i11 < length && Character.isUpperCase(str.charAt(i11))) {
            return str.substring(i10);
        }
        StringBuilder sb = new StringBuilder(length - i10);
        sb.append(lowerCase);
        sb.append((CharSequence) str, i11, length);
        return sb.toString();
    }
}
