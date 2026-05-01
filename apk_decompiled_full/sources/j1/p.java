package j1;

import com.google.android.gms.cast.framework.media.NotificationOptions;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class p {

    /* renamed from: s, reason: collision with root package name */
    public static final String f14581s = a1.k.f("WorkSpec");

    /* renamed from: t, reason: collision with root package name */
    public static final j.a f14582t = new a();

    /* renamed from: a, reason: collision with root package name */
    public String f14583a;

    /* renamed from: b, reason: collision with root package name */
    public a1.s f14584b;

    /* renamed from: c, reason: collision with root package name */
    public String f14585c;

    /* renamed from: d, reason: collision with root package name */
    public String f14586d;

    /* renamed from: e, reason: collision with root package name */
    public androidx.work.b f14587e;

    /* renamed from: f, reason: collision with root package name */
    public androidx.work.b f14588f;

    /* renamed from: g, reason: collision with root package name */
    public long f14589g;

    /* renamed from: h, reason: collision with root package name */
    public long f14590h;

    /* renamed from: i, reason: collision with root package name */
    public long f14591i;

    /* renamed from: j, reason: collision with root package name */
    public a1.b f14592j;

    /* renamed from: k, reason: collision with root package name */
    public int f14593k;

    /* renamed from: l, reason: collision with root package name */
    public a1.a f14594l;

    /* renamed from: m, reason: collision with root package name */
    public long f14595m;

    /* renamed from: n, reason: collision with root package name */
    public long f14596n;

    /* renamed from: o, reason: collision with root package name */
    public long f14597o;

    /* renamed from: p, reason: collision with root package name */
    public long f14598p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f14599q;

    /* renamed from: r, reason: collision with root package name */
    public a1.o f14600r;

    public class a implements j.a {
        @Override // j.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public List apply(List list) {
            if (list == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList(list.size());
            Iterator it = list.iterator();
            if (!it.hasNext()) {
                return arrayList;
            }
            androidx.appcompat.app.m.a(it.next());
            throw null;
        }
    }

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public String f14601a;

        /* renamed from: b, reason: collision with root package name */
        public a1.s f14602b;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            if (this.f14602b != bVar.f14602b) {
                return false;
            }
            return this.f14601a.equals(bVar.f14601a);
        }

        public int hashCode() {
            return (this.f14601a.hashCode() * 31) + this.f14602b.hashCode();
        }
    }

    public p(String str, String str2) {
        this.f14584b = a1.s.ENQUEUED;
        androidx.work.b bVar = androidx.work.b.f3645c;
        this.f14587e = bVar;
        this.f14588f = bVar;
        this.f14592j = a1.b.f82i;
        this.f14594l = a1.a.EXPONENTIAL;
        this.f14595m = NotificationOptions.SKIP_STEP_THIRTY_SECONDS_IN_MS;
        this.f14598p = -1L;
        this.f14600r = a1.o.RUN_AS_NON_EXPEDITED_WORK_REQUEST;
        this.f14583a = str;
        this.f14585c = str2;
    }

    public long a() {
        if (c()) {
            return this.f14596n + Math.min(18000000L, this.f14594l == a1.a.LINEAR ? this.f14595m * this.f14593k : (long) Math.scalb(this.f14595m, this.f14593k - 1));
        }
        if (!d()) {
            long j10 = this.f14596n;
            if (j10 == 0) {
                j10 = System.currentTimeMillis();
            }
            return j10 + this.f14589g;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j11 = this.f14596n;
        long j12 = j11 == 0 ? currentTimeMillis + this.f14589g : j11;
        long j13 = this.f14591i;
        long j14 = this.f14590h;
        if (j13 != j14) {
            return j12 + j14 + (j11 == 0 ? j13 * (-1) : 0L);
        }
        return j12 + (j11 != 0 ? j14 : 0L);
    }

    public boolean b() {
        return !a1.b.f82i.equals(this.f14592j);
    }

    public boolean c() {
        return this.f14584b == a1.s.ENQUEUED && this.f14593k > 0;
    }

    public boolean d() {
        return this.f14590h != 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || p.class != obj.getClass()) {
            return false;
        }
        p pVar = (p) obj;
        if (this.f14589g != pVar.f14589g || this.f14590h != pVar.f14590h || this.f14591i != pVar.f14591i || this.f14593k != pVar.f14593k || this.f14595m != pVar.f14595m || this.f14596n != pVar.f14596n || this.f14597o != pVar.f14597o || this.f14598p != pVar.f14598p || this.f14599q != pVar.f14599q || !this.f14583a.equals(pVar.f14583a) || this.f14584b != pVar.f14584b || !this.f14585c.equals(pVar.f14585c)) {
            return false;
        }
        String str = this.f14586d;
        if (str == null ? pVar.f14586d == null : str.equals(pVar.f14586d)) {
            return this.f14587e.equals(pVar.f14587e) && this.f14588f.equals(pVar.f14588f) && this.f14592j.equals(pVar.f14592j) && this.f14594l == pVar.f14594l && this.f14600r == pVar.f14600r;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((((this.f14583a.hashCode() * 31) + this.f14584b.hashCode()) * 31) + this.f14585c.hashCode()) * 31;
        String str = this.f14586d;
        int hashCode2 = (((((hashCode + (str != null ? str.hashCode() : 0)) * 31) + this.f14587e.hashCode()) * 31) + this.f14588f.hashCode()) * 31;
        long j10 = this.f14589g;
        int i10 = (hashCode2 + ((int) (j10 ^ (j10 >>> 32)))) * 31;
        long j11 = this.f14590h;
        int i11 = (i10 + ((int) (j11 ^ (j11 >>> 32)))) * 31;
        long j12 = this.f14591i;
        int hashCode3 = (((((((i11 + ((int) (j12 ^ (j12 >>> 32)))) * 31) + this.f14592j.hashCode()) * 31) + this.f14593k) * 31) + this.f14594l.hashCode()) * 31;
        long j13 = this.f14595m;
        int i12 = (hashCode3 + ((int) (j13 ^ (j13 >>> 32)))) * 31;
        long j14 = this.f14596n;
        int i13 = (i12 + ((int) (j14 ^ (j14 >>> 32)))) * 31;
        long j15 = this.f14597o;
        int i14 = (i13 + ((int) (j15 ^ (j15 >>> 32)))) * 31;
        long j16 = this.f14598p;
        return ((((i14 + ((int) (j16 ^ (j16 >>> 32)))) * 31) + (this.f14599q ? 1 : 0)) * 31) + this.f14600r.hashCode();
    }

    public String toString() {
        return "{WorkSpec: " + this.f14583a + "}";
    }

    public p(p pVar) {
        this.f14584b = a1.s.ENQUEUED;
        androidx.work.b bVar = androidx.work.b.f3645c;
        this.f14587e = bVar;
        this.f14588f = bVar;
        this.f14592j = a1.b.f82i;
        this.f14594l = a1.a.EXPONENTIAL;
        this.f14595m = NotificationOptions.SKIP_STEP_THIRTY_SECONDS_IN_MS;
        this.f14598p = -1L;
        this.f14600r = a1.o.RUN_AS_NON_EXPEDITED_WORK_REQUEST;
        this.f14583a = pVar.f14583a;
        this.f14585c = pVar.f14585c;
        this.f14584b = pVar.f14584b;
        this.f14586d = pVar.f14586d;
        this.f14587e = new androidx.work.b(pVar.f14587e);
        this.f14588f = new androidx.work.b(pVar.f14588f);
        this.f14589g = pVar.f14589g;
        this.f14590h = pVar.f14590h;
        this.f14591i = pVar.f14591i;
        this.f14592j = new a1.b(pVar.f14592j);
        this.f14593k = pVar.f14593k;
        this.f14594l = pVar.f14594l;
        this.f14595m = pVar.f14595m;
        this.f14596n = pVar.f14596n;
        this.f14597o = pVar.f14597o;
        this.f14598p = pVar.f14598p;
        this.f14599q = pVar.f14599q;
        this.f14600r = pVar.f14600r;
    }
}
