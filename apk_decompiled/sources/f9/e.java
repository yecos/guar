package f9;

import com.google.common.base.Preconditions;
import com.google.common.collect.ForwardingMap;
import com.hpplay.cybergarage.upnp.ssdp.SSDP;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import y8.a;
import y8.k;
import y8.k1;
import y8.o0;
import y8.o1;
import y8.p;
import y8.q;
import y8.v0;
import y8.x;
import z8.c2;
import z8.j2;

/* loaded from: classes3.dex */
public final class e extends o0 {

    /* renamed from: k, reason: collision with root package name */
    public static final a.c f13335k = a.c.a("addressTrackerKey");

    /* renamed from: c, reason: collision with root package name */
    public final c f13336c;

    /* renamed from: d, reason: collision with root package name */
    public final o1 f13337d;

    /* renamed from: e, reason: collision with root package name */
    public final o0.d f13338e;

    /* renamed from: f, reason: collision with root package name */
    public final f9.d f13339f;

    /* renamed from: g, reason: collision with root package name */
    public j2 f13340g;

    /* renamed from: h, reason: collision with root package name */
    public final ScheduledExecutorService f13341h;

    /* renamed from: i, reason: collision with root package name */
    public o1.d f13342i;

    /* renamed from: j, reason: collision with root package name */
    public Long f13343j;

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public g f13344a;

        /* renamed from: b, reason: collision with root package name */
        public volatile a f13345b;

        /* renamed from: c, reason: collision with root package name */
        public a f13346c;

        /* renamed from: d, reason: collision with root package name */
        public Long f13347d;

        /* renamed from: e, reason: collision with root package name */
        public int f13348e;

        /* renamed from: f, reason: collision with root package name */
        public final Set f13349f = new HashSet();

        public static class a {

            /* renamed from: a, reason: collision with root package name */
            public AtomicLong f13350a;

            /* renamed from: b, reason: collision with root package name */
            public AtomicLong f13351b;

            public a() {
                this.f13350a = new AtomicLong();
                this.f13351b = new AtomicLong();
            }

            public void a() {
                this.f13350a.set(0L);
                this.f13351b.set(0L);
            }
        }

        public b(g gVar) {
            this.f13345b = new a();
            this.f13346c = new a();
            this.f13344a = gVar;
        }

        public boolean b(i iVar) {
            if (m() && !iVar.n()) {
                iVar.m();
            } else if (!m() && iVar.n()) {
                iVar.p();
            }
            iVar.o(this);
            return this.f13349f.add(iVar);
        }

        public void c() {
            int i10 = this.f13348e;
            this.f13348e = i10 == 0 ? 0 : i10 - 1;
        }

        public void d(long j10) {
            this.f13347d = Long.valueOf(j10);
            this.f13348e++;
            Iterator it = this.f13349f.iterator();
            while (it.hasNext()) {
                ((i) it.next()).m();
            }
        }

        public double e() {
            double d10 = this.f13346c.f13351b.get();
            double f10 = f();
            Double.isNaN(d10);
            Double.isNaN(f10);
            return d10 / f10;
        }

        public long f() {
            return this.f13346c.f13350a.get() + this.f13346c.f13351b.get();
        }

        public void g(boolean z10) {
            g gVar = this.f13344a;
            if (gVar.f13362e == null && gVar.f13363f == null) {
                return;
            }
            if (z10) {
                this.f13345b.f13350a.getAndIncrement();
            } else {
                this.f13345b.f13351b.getAndIncrement();
            }
        }

        public boolean h(long j10) {
            return j10 > this.f13347d.longValue() + Math.min(this.f13344a.f13359b.longValue() * ((long) this.f13348e), Math.max(this.f13344a.f13359b.longValue(), this.f13344a.f13360c.longValue()));
        }

        public boolean i(i iVar) {
            iVar.l();
            return this.f13349f.remove(iVar);
        }

        public void j() {
            this.f13345b.a();
            this.f13346c.a();
        }

        public void k() {
            this.f13348e = 0;
        }

        public void l(g gVar) {
            this.f13344a = gVar;
        }

        public boolean m() {
            return this.f13347d != null;
        }

        public double n() {
            double d10 = this.f13346c.f13350a.get();
            double f10 = f();
            Double.isNaN(d10);
            Double.isNaN(f10);
            return d10 / f10;
        }

        public void o() {
            this.f13346c.a();
            a aVar = this.f13345b;
            this.f13345b = this.f13346c;
            this.f13346c = aVar;
        }

        public void p() {
            Preconditions.checkState(this.f13347d != null, "not currently ejected");
            this.f13347d = null;
            Iterator it = this.f13349f.iterator();
            while (it.hasNext()) {
                ((i) it.next()).p();
            }
        }
    }

    public static class c extends ForwardingMap {

        /* renamed from: a, reason: collision with root package name */
        public final Map f13352a = new HashMap();

        public void a() {
            for (b bVar : this.f13352a.values()) {
                if (bVar.m()) {
                    bVar.p();
                }
                bVar.k();
            }
        }

        public double b() {
            if (this.f13352a.isEmpty()) {
                return 0.0d;
            }
            Iterator it = this.f13352a.values().iterator();
            int i10 = 0;
            int i11 = 0;
            while (it.hasNext()) {
                i11++;
                if (((b) it.next()).m()) {
                    i10++;
                }
            }
            double d10 = i10;
            double d11 = i11;
            Double.isNaN(d10);
            Double.isNaN(d11);
            return (d10 / d11) * 100.0d;
        }

        public void c(Long l10) {
            for (b bVar : this.f13352a.values()) {
                if (!bVar.m()) {
                    bVar.c();
                }
                if (bVar.m() && bVar.h(l10.longValue())) {
                    bVar.p();
                }
            }
        }

        public void d(g gVar, Collection collection) {
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                SocketAddress socketAddress = (SocketAddress) it.next();
                if (!this.f13352a.containsKey(socketAddress)) {
                    this.f13352a.put(socketAddress, new b(gVar));
                }
            }
        }

        public void e() {
            Iterator it = this.f13352a.values().iterator();
            while (it.hasNext()) {
                ((b) it.next()).j();
            }
        }

        public void f() {
            Iterator it = this.f13352a.values().iterator();
            while (it.hasNext()) {
                ((b) it.next()).o();
            }
        }

        public void g(g gVar) {
            Iterator it = this.f13352a.values().iterator();
            while (it.hasNext()) {
                ((b) it.next()).l(gVar);
            }
        }

        @Override // com.google.common.collect.ForwardingMap, com.google.common.collect.ForwardingObject
        public Map delegate() {
            return this.f13352a;
        }
    }

    public class d extends f9.b {

        /* renamed from: a, reason: collision with root package name */
        public o0.d f13353a;

        public d(o0.d dVar) {
            this.f13353a = dVar;
        }

        @Override // f9.b, y8.o0.d
        public o0.h a(o0.b bVar) {
            i iVar = e.this.new i(this.f13353a.a(bVar));
            List a10 = bVar.a();
            if (e.l(a10) && e.this.f13336c.containsKey(((x) a10.get(0)).a().get(0))) {
                b bVar2 = (b) e.this.f13336c.get(((x) a10.get(0)).a().get(0));
                bVar2.b(iVar);
                if (bVar2.f13347d != null) {
                    iVar.m();
                }
            }
            return iVar;
        }

        @Override // y8.o0.d
        public void f(p pVar, o0.i iVar) {
            this.f13353a.f(pVar, e.this.new h(iVar));
        }

        @Override // f9.b
        public o0.d g() {
            return this.f13353a;
        }
    }

    /* renamed from: f9.e$e, reason: collision with other inner class name */
    public class RunnableC0219e implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public g f13355a;

        public RunnableC0219e(g gVar) {
            this.f13355a = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            e eVar = e.this;
            eVar.f13343j = Long.valueOf(eVar.f13340g.a());
            e.this.f13336c.f();
            for (j jVar : f9.f.a(this.f13355a)) {
                e eVar2 = e.this;
                jVar.a(eVar2.f13336c, eVar2.f13343j.longValue());
            }
            e eVar3 = e.this;
            eVar3.f13336c.c(eVar3.f13343j);
        }
    }

    public static class f implements j {

        /* renamed from: a, reason: collision with root package name */
        public final g f13357a;

        public f(g gVar) {
            this.f13357a = gVar;
        }

        @Override // f9.e.j
        public void a(c cVar, long j10) {
            List<b> m10 = e.m(cVar, this.f13357a.f13363f.f13375d.intValue());
            if (m10.size() < this.f13357a.f13363f.f13374c.intValue() || m10.size() == 0) {
                return;
            }
            for (b bVar : m10) {
                if (cVar.b() >= this.f13357a.f13361d.intValue()) {
                    return;
                }
                if (bVar.f() >= this.f13357a.f13363f.f13375d.intValue()) {
                    double intValue = this.f13357a.f13363f.f13372a.intValue();
                    Double.isNaN(intValue);
                    if (bVar.e() > intValue / 100.0d && new Random().nextInt(100) < this.f13357a.f13363f.f13373b.intValue()) {
                        bVar.d(j10);
                    }
                }
            }
        }
    }

    public static final class g {

        /* renamed from: a, reason: collision with root package name */
        public final Long f13358a;

        /* renamed from: b, reason: collision with root package name */
        public final Long f13359b;

        /* renamed from: c, reason: collision with root package name */
        public final Long f13360c;

        /* renamed from: d, reason: collision with root package name */
        public final Integer f13361d;

        /* renamed from: e, reason: collision with root package name */
        public final c f13362e;

        /* renamed from: f, reason: collision with root package name */
        public final b f13363f;

        /* renamed from: g, reason: collision with root package name */
        public final c2.b f13364g;

        public static class a {

            /* renamed from: a, reason: collision with root package name */
            public Long f13365a = 10000000000L;

            /* renamed from: b, reason: collision with root package name */
            public Long f13366b = 30000000000L;

            /* renamed from: c, reason: collision with root package name */
            public Long f13367c = 30000000000L;

            /* renamed from: d, reason: collision with root package name */
            public Integer f13368d = 10;

            /* renamed from: e, reason: collision with root package name */
            public c f13369e;

            /* renamed from: f, reason: collision with root package name */
            public b f13370f;

            /* renamed from: g, reason: collision with root package name */
            public c2.b f13371g;

            public g a() {
                Preconditions.checkState(this.f13371g != null);
                return new g(this.f13365a, this.f13366b, this.f13367c, this.f13368d, this.f13369e, this.f13370f, this.f13371g);
            }

            public a b(Long l10) {
                Preconditions.checkArgument(l10 != null);
                this.f13366b = l10;
                return this;
            }

            public a c(c2.b bVar) {
                Preconditions.checkState(bVar != null);
                this.f13371g = bVar;
                return this;
            }

            public a d(b bVar) {
                this.f13370f = bVar;
                return this;
            }

            public a e(Long l10) {
                Preconditions.checkArgument(l10 != null);
                this.f13365a = l10;
                return this;
            }

            public a f(Integer num) {
                Preconditions.checkArgument(num != null);
                this.f13368d = num;
                return this;
            }

            public a g(Long l10) {
                Preconditions.checkArgument(l10 != null);
                this.f13367c = l10;
                return this;
            }

            public a h(c cVar) {
                this.f13369e = cVar;
                return this;
            }
        }

        public static class b {

            /* renamed from: a, reason: collision with root package name */
            public final Integer f13372a;

            /* renamed from: b, reason: collision with root package name */
            public final Integer f13373b;

            /* renamed from: c, reason: collision with root package name */
            public final Integer f13374c;

            /* renamed from: d, reason: collision with root package name */
            public final Integer f13375d;

            public static class a {

                /* renamed from: a, reason: collision with root package name */
                public Integer f13376a = 85;

                /* renamed from: b, reason: collision with root package name */
                public Integer f13377b = 100;

                /* renamed from: c, reason: collision with root package name */
                public Integer f13378c = 5;

                /* renamed from: d, reason: collision with root package name */
                public Integer f13379d = 50;

                public b a() {
                    return new b(this.f13376a, this.f13377b, this.f13378c, this.f13379d);
                }

                public a b(Integer num) {
                    Preconditions.checkArgument(num != null);
                    Preconditions.checkArgument(num.intValue() >= 0 && num.intValue() <= 100);
                    this.f13377b = num;
                    return this;
                }

                public a c(Integer num) {
                    Preconditions.checkArgument(num != null);
                    Preconditions.checkArgument(num.intValue() >= 0);
                    this.f13378c = num;
                    return this;
                }

                public a d(Integer num) {
                    Preconditions.checkArgument(num != null);
                    Preconditions.checkArgument(num.intValue() >= 0);
                    this.f13379d = num;
                    return this;
                }

                public a e(Integer num) {
                    Preconditions.checkArgument(num != null);
                    Preconditions.checkArgument(num.intValue() >= 0 && num.intValue() <= 100);
                    this.f13376a = num;
                    return this;
                }
            }

            public b(Integer num, Integer num2, Integer num3, Integer num4) {
                this.f13372a = num;
                this.f13373b = num2;
                this.f13374c = num3;
                this.f13375d = num4;
            }
        }

        public static class c {

            /* renamed from: a, reason: collision with root package name */
            public final Integer f13380a;

            /* renamed from: b, reason: collision with root package name */
            public final Integer f13381b;

            /* renamed from: c, reason: collision with root package name */
            public final Integer f13382c;

            /* renamed from: d, reason: collision with root package name */
            public final Integer f13383d;

            public static final class a {

                /* renamed from: a, reason: collision with root package name */
                public Integer f13384a = Integer.valueOf(SSDP.PORT);

                /* renamed from: b, reason: collision with root package name */
                public Integer f13385b = 100;

                /* renamed from: c, reason: collision with root package name */
                public Integer f13386c = 5;

                /* renamed from: d, reason: collision with root package name */
                public Integer f13387d = 100;

                public c a() {
                    return new c(this.f13384a, this.f13385b, this.f13386c, this.f13387d);
                }

                public a b(Integer num) {
                    Preconditions.checkArgument(num != null);
                    Preconditions.checkArgument(num.intValue() >= 0 && num.intValue() <= 100);
                    this.f13385b = num;
                    return this;
                }

                public a c(Integer num) {
                    Preconditions.checkArgument(num != null);
                    Preconditions.checkArgument(num.intValue() >= 0);
                    this.f13386c = num;
                    return this;
                }

                public a d(Integer num) {
                    Preconditions.checkArgument(num != null);
                    Preconditions.checkArgument(num.intValue() >= 0);
                    this.f13387d = num;
                    return this;
                }

                public a e(Integer num) {
                    Preconditions.checkArgument(num != null);
                    this.f13384a = num;
                    return this;
                }
            }

            public c(Integer num, Integer num2, Integer num3, Integer num4) {
                this.f13380a = num;
                this.f13381b = num2;
                this.f13382c = num3;
                this.f13383d = num4;
            }
        }

        public boolean a() {
            return (this.f13362e == null && this.f13363f == null) ? false : true;
        }

        public g(Long l10, Long l11, Long l12, Integer num, c cVar, b bVar, c2.b bVar2) {
            this.f13358a = l10;
            this.f13359b = l11;
            this.f13360c = l12;
            this.f13361d = num;
            this.f13362e = cVar;
            this.f13363f = bVar;
            this.f13364g = bVar2;
        }
    }

    public class h extends o0.i {

        /* renamed from: a, reason: collision with root package name */
        public final o0.i f13388a;

        public class a extends y8.k {

            /* renamed from: a, reason: collision with root package name */
            public b f13390a;

            public a(b bVar) {
                this.f13390a = bVar;
            }

            @Override // y8.n1
            public void i(k1 k1Var) {
                this.f13390a.g(k1Var.p());
            }
        }

        public class b extends k.a {

            /* renamed from: a, reason: collision with root package name */
            public final b f13392a;

            public b(b bVar) {
                this.f13392a = bVar;
            }

            @Override // y8.k.a
            public y8.k a(k.b bVar, v0 v0Var) {
                return h.this.new a(this.f13392a);
            }
        }

        public h(o0.i iVar) {
            this.f13388a = iVar;
        }

        @Override // y8.o0.i
        public o0.e a(o0.f fVar) {
            o0.e a10 = this.f13388a.a(fVar);
            o0.h c10 = a10.c();
            return c10 != null ? o0.e.i(c10, new b((b) c10.c().b(e.f13335k))) : a10;
        }
    }

    public class i extends f9.c {

        /* renamed from: a, reason: collision with root package name */
        public final o0.h f13394a;

        /* renamed from: b, reason: collision with root package name */
        public b f13395b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f13396c;

        /* renamed from: d, reason: collision with root package name */
        public q f13397d;

        /* renamed from: e, reason: collision with root package name */
        public o0.j f13398e;

        public class a implements o0.j {

            /* renamed from: a, reason: collision with root package name */
            public final o0.j f13400a;

            public a(o0.j jVar) {
                this.f13400a = jVar;
            }

            @Override // y8.o0.j
            public void a(q qVar) {
                i.this.f13397d = qVar;
                if (i.this.f13396c) {
                    return;
                }
                this.f13400a.a(qVar);
            }
        }

        public i(o0.h hVar) {
            this.f13394a = hVar;
        }

        @Override // y8.o0.h
        public y8.a c() {
            return this.f13395b != null ? this.f13394a.c().d().d(e.f13335k, this.f13395b).a() : this.f13394a.c();
        }

        @Override // f9.c, y8.o0.h
        public void g(o0.j jVar) {
            this.f13398e = jVar;
            super.g(new a(jVar));
        }

        @Override // y8.o0.h
        public void h(List list) {
            if (e.l(b()) && e.l(list)) {
                if (e.this.f13336c.containsValue(this.f13395b)) {
                    this.f13395b.i(this);
                }
                SocketAddress socketAddress = (SocketAddress) ((x) list.get(0)).a().get(0);
                if (e.this.f13336c.containsKey(socketAddress)) {
                    ((b) e.this.f13336c.get(socketAddress)).b(this);
                }
            } else if (!e.l(b()) || e.l(list)) {
                if (!e.l(b()) && e.l(list)) {
                    SocketAddress socketAddress2 = (SocketAddress) ((x) list.get(0)).a().get(0);
                    if (e.this.f13336c.containsKey(socketAddress2)) {
                        ((b) e.this.f13336c.get(socketAddress2)).b(this);
                    }
                }
            } else if (e.this.f13336c.containsKey(a().a().get(0))) {
                b bVar = (b) e.this.f13336c.get(a().a().get(0));
                bVar.i(this);
                bVar.j();
            }
            this.f13394a.h(list);
        }

        @Override // f9.c
        public o0.h i() {
            return this.f13394a;
        }

        public void l() {
            this.f13395b = null;
        }

        public void m() {
            this.f13396c = true;
            this.f13398e.a(q.b(k1.f19904u));
        }

        public boolean n() {
            return this.f13396c;
        }

        public void o(b bVar) {
            this.f13395b = bVar;
        }

        public void p() {
            this.f13396c = false;
            q qVar = this.f13397d;
            if (qVar != null) {
                this.f13398e.a(qVar);
            }
        }
    }

    public interface j {
        void a(c cVar, long j10);
    }

    public static class k implements j {

        /* renamed from: a, reason: collision with root package name */
        public final g f13402a;

        public k(g gVar) {
            Preconditions.checkArgument(gVar.f13362e != null, "success rate ejection config is null");
            this.f13402a = gVar;
        }

        public static double b(Collection collection) {
            Iterator it = collection.iterator();
            double d10 = 0.0d;
            while (it.hasNext()) {
                d10 += ((Double) it.next()).doubleValue();
            }
            double size = collection.size();
            Double.isNaN(size);
            return d10 / size;
        }

        public static double c(Collection collection, double d10) {
            Iterator it = collection.iterator();
            double d11 = 0.0d;
            while (it.hasNext()) {
                double doubleValue = ((Double) it.next()).doubleValue() - d10;
                d11 += doubleValue * doubleValue;
            }
            double size = collection.size();
            Double.isNaN(size);
            return Math.sqrt(d11 / size);
        }

        @Override // f9.e.j
        public void a(c cVar, long j10) {
            List<b> m10 = e.m(cVar, this.f13402a.f13362e.f13383d.intValue());
            if (m10.size() < this.f13402a.f13362e.f13382c.intValue() || m10.size() == 0) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            Iterator it = m10.iterator();
            while (it.hasNext()) {
                arrayList.add(Double.valueOf(((b) it.next()).n()));
            }
            double b10 = b(arrayList);
            double c10 = c(arrayList, b10);
            double intValue = this.f13402a.f13362e.f13380a.intValue() / 1000.0f;
            Double.isNaN(intValue);
            double d10 = b10 - (c10 * intValue);
            for (b bVar : m10) {
                if (cVar.b() >= this.f13402a.f13361d.intValue()) {
                    return;
                }
                if (bVar.n() < d10 && new Random().nextInt(100) < this.f13402a.f13362e.f13381b.intValue()) {
                    bVar.d(j10);
                }
            }
        }
    }

    public e(o0.d dVar, j2 j2Var) {
        d dVar2 = new d((o0.d) Preconditions.checkNotNull(dVar, "helper"));
        this.f13338e = dVar2;
        this.f13339f = new f9.d(dVar2);
        this.f13336c = new c();
        this.f13337d = (o1) Preconditions.checkNotNull(dVar.d(), "syncContext");
        this.f13341h = (ScheduledExecutorService) Preconditions.checkNotNull(dVar.c(), "timeService");
        this.f13340g = j2Var;
    }

    public static boolean l(List list) {
        Iterator it = list.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            i10 += ((x) it.next()).a().size();
            if (i10 > 1) {
                return false;
            }
        }
        return true;
    }

    public static List m(c cVar, int i10) {
        ArrayList arrayList = new ArrayList();
        for (b bVar : cVar.values()) {
            if (bVar.f() >= i10) {
                arrayList.add(bVar);
            }
        }
        return arrayList;
    }

    @Override // y8.o0
    public boolean a(o0.g gVar) {
        g gVar2 = (g) gVar.c();
        ArrayList arrayList = new ArrayList();
        Iterator it = gVar.a().iterator();
        while (it.hasNext()) {
            arrayList.addAll(((x) it.next()).a());
        }
        this.f13336c.keySet().retainAll(arrayList);
        this.f13336c.g(gVar2);
        this.f13336c.d(gVar2, arrayList);
        this.f13339f.q(gVar2.f13364g.b());
        if (gVar2.a()) {
            Long valueOf = this.f13343j == null ? gVar2.f13358a : Long.valueOf(Math.max(0L, gVar2.f13358a.longValue() - (this.f13340g.a() - this.f13343j.longValue())));
            o1.d dVar = this.f13342i;
            if (dVar != null) {
                dVar.a();
                this.f13336c.e();
            }
            this.f13342i = this.f13337d.d(new RunnableC0219e(gVar2), valueOf.longValue(), gVar2.f13358a.longValue(), TimeUnit.NANOSECONDS, this.f13341h);
        } else {
            o1.d dVar2 = this.f13342i;
            if (dVar2 != null) {
                dVar2.a();
                this.f13343j = null;
                this.f13336c.a();
            }
        }
        this.f13339f.d(gVar.e().d(gVar2.f13364g.a()).a());
        return true;
    }

    @Override // y8.o0
    public void c(k1 k1Var) {
        this.f13339f.c(k1Var);
    }

    @Override // y8.o0
    public void e() {
        this.f13339f.e();
    }
}
