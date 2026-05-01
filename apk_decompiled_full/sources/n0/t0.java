package n0;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.media.session.MediaSessionCompat;
import android.text.TextUtils;
import android.util.Log;
import android.view.Display;
import com.google.common.util.concurrent.ListenableFuture;
import com.hpplay.cybergarage.soap.SOAP;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;
import n0.g0;
import n0.p0;
import n0.s0;
import n0.t0;
import n0.t1;
import n0.u1;
import n0.v1;

/* loaded from: classes.dex */
public final class t0 {

    /* renamed from: c, reason: collision with root package name */
    public static final boolean f17009c = Log.isLoggable("MediaRouter", 3);

    /* renamed from: d, reason: collision with root package name */
    public static e f17010d;

    /* renamed from: a, reason: collision with root package name */
    public final Context f17011a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f17012b = new ArrayList();

    public static abstract class b {
        public void onProviderAdded(t0 t0Var, h hVar) {
        }

        public void onProviderChanged(t0 t0Var, h hVar) {
        }

        public void onProviderRemoved(t0 t0Var, h hVar) {
        }

        public void onRouteAdded(t0 t0Var, i iVar) {
        }

        public void onRouteChanged(t0 t0Var, i iVar) {
        }

        public void onRoutePresentationDisplayChanged(t0 t0Var, i iVar) {
        }

        public void onRouteRemoved(t0 t0Var, i iVar) {
        }

        @Deprecated
        public void onRouteSelected(t0 t0Var, i iVar) {
        }

        @Deprecated
        public void onRouteUnselected(t0 t0Var, i iVar) {
        }

        public void onRouteVolumeChanged(t0 t0Var, i iVar) {
        }

        public void onRouteSelected(t0 t0Var, i iVar, int i10) {
            onRouteSelected(t0Var, iVar);
        }

        public void onRouteUnselected(t0 t0Var, i iVar, int i10) {
            onRouteUnselected(t0Var, iVar);
        }

        public void onRouteSelected(t0 t0Var, i iVar, int i10, i iVar2) {
            onRouteSelected(t0Var, iVar, i10);
        }
    }

    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        public final t0 f17013a;

        /* renamed from: b, reason: collision with root package name */
        public final b f17014b;

        /* renamed from: c, reason: collision with root package name */
        public s0 f17015c = s0.f17005c;

        /* renamed from: d, reason: collision with root package name */
        public int f17016d;

        public c(t0 t0Var, b bVar) {
            this.f17013a = t0Var;
            this.f17014b = bVar;
        }

        public boolean a(i iVar, int i10, i iVar2, int i11) {
            if ((this.f17016d & 2) != 0 || iVar.E(this.f17015c)) {
                return true;
            }
            if (t0.p() && iVar.w() && i10 == 262 && i11 == 3 && iVar2 != null) {
                return !iVar2.w();
            }
            return false;
        }
    }

    public static abstract class d {
        public abstract void a(String str, Bundle bundle);

        public abstract void b(Bundle bundle);
    }

    public static final class e implements v1.e, t1.c {
        public f A;
        public g B;
        public d C;
        public MediaSessionCompat D;
        public MediaSessionCompat E;

        /* renamed from: a, reason: collision with root package name */
        public final Context f17017a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f17018b;

        /* renamed from: c, reason: collision with root package name */
        public final g0 f17019c;

        /* renamed from: l, reason: collision with root package name */
        public final t.a f17028l;

        /* renamed from: m, reason: collision with root package name */
        public final v1 f17029m;

        /* renamed from: n, reason: collision with root package name */
        public final boolean f17030n;

        /* renamed from: o, reason: collision with root package name */
        public o1 f17031o;

        /* renamed from: p, reason: collision with root package name */
        public t1 f17032p;

        /* renamed from: q, reason: collision with root package name */
        public i f17033q;

        /* renamed from: r, reason: collision with root package name */
        public i f17034r;

        /* renamed from: s, reason: collision with root package name */
        public i f17035s;

        /* renamed from: t, reason: collision with root package name */
        public p0.e f17036t;

        /* renamed from: u, reason: collision with root package name */
        public i f17037u;

        /* renamed from: v, reason: collision with root package name */
        public p0.e f17038v;

        /* renamed from: x, reason: collision with root package name */
        public o0 f17040x;

        /* renamed from: y, reason: collision with root package name */
        public o0 f17041y;

        /* renamed from: z, reason: collision with root package name */
        public int f17042z;

        /* renamed from: d, reason: collision with root package name */
        public final ArrayList f17020d = new ArrayList();

        /* renamed from: e, reason: collision with root package name */
        public final ArrayList f17021e = new ArrayList();

        /* renamed from: f, reason: collision with root package name */
        public final Map f17022f = new HashMap();

        /* renamed from: g, reason: collision with root package name */
        public final ArrayList f17023g = new ArrayList();

        /* renamed from: h, reason: collision with root package name */
        public final ArrayList f17024h = new ArrayList();

        /* renamed from: i, reason: collision with root package name */
        public final u1.b f17025i = new u1.b();

        /* renamed from: j, reason: collision with root package name */
        public final f f17026j = new f();

        /* renamed from: k, reason: collision with root package name */
        public final c f17027k = new c();

        /* renamed from: w, reason: collision with root package name */
        public final Map f17039w = new HashMap();
        public MediaSessionCompat.j F = new a();
        public p0.b.d G = new b();

        public class a implements MediaSessionCompat.j {
            public a() {
            }

            @Override // android.support.v4.media.session.MediaSessionCompat.j
            public void a() {
                MediaSessionCompat mediaSessionCompat = e.this.D;
                if (mediaSessionCompat != null) {
                    if (mediaSessionCompat.h()) {
                        e eVar = e.this;
                        eVar.g(eVar.D.e());
                    } else {
                        e eVar2 = e.this;
                        eVar2.F(eVar2.D.e());
                    }
                }
            }
        }

        public class b implements p0.b.d {
            public b() {
            }

            @Override // n0.p0.b.d
            public void a(p0.b bVar, n0 n0Var, Collection collection) {
                e eVar = e.this;
                if (bVar != eVar.f17038v || n0Var == null) {
                    if (bVar == eVar.f17036t) {
                        if (n0Var != null) {
                            eVar.U(eVar.f17035s, n0Var);
                        }
                        e.this.f17035s.L(collection);
                        return;
                    }
                    return;
                }
                h q10 = eVar.f17037u.q();
                String l10 = n0Var.l();
                i iVar = new i(q10, l10, e.this.h(q10, l10));
                iVar.F(n0Var);
                e eVar2 = e.this;
                if (eVar2.f17035s == iVar) {
                    return;
                }
                eVar2.D(eVar2, iVar, eVar2.f17038v, 3, eVar2.f17037u, collection);
                e eVar3 = e.this;
                eVar3.f17037u = null;
                eVar3.f17038v = null;
            }
        }

        public final class c extends Handler {

            /* renamed from: a, reason: collision with root package name */
            public final ArrayList f17045a = new ArrayList();

            /* renamed from: b, reason: collision with root package name */
            public final List f17046b = new ArrayList();

            public c() {
            }

            public final void a(c cVar, int i10, Object obj, int i11) {
                t0 t0Var = cVar.f17013a;
                b bVar = cVar.f17014b;
                int i12 = 65280 & i10;
                if (i12 != 256) {
                    if (i12 != 512) {
                        return;
                    }
                    h hVar = (h) obj;
                    switch (i10) {
                        case 513:
                            bVar.onProviderAdded(t0Var, hVar);
                            break;
                        case 514:
                            bVar.onProviderRemoved(t0Var, hVar);
                            break;
                        case 515:
                            bVar.onProviderChanged(t0Var, hVar);
                            break;
                    }
                }
                i iVar = (i10 == 264 || i10 == 262) ? (i) ((a0.d) obj).second : (i) obj;
                i iVar2 = (i10 == 264 || i10 == 262) ? (i) ((a0.d) obj).first : null;
                if (iVar == null || !cVar.a(iVar, i10, iVar2, i11)) {
                    return;
                }
                switch (i10) {
                    case 257:
                        bVar.onRouteAdded(t0Var, iVar);
                        break;
                    case 258:
                        bVar.onRouteRemoved(t0Var, iVar);
                        break;
                    case 259:
                        bVar.onRouteChanged(t0Var, iVar);
                        break;
                    case 260:
                        bVar.onRouteVolumeChanged(t0Var, iVar);
                        break;
                    case 261:
                        bVar.onRoutePresentationDisplayChanged(t0Var, iVar);
                        break;
                    case 262:
                        bVar.onRouteSelected(t0Var, iVar, i11, iVar);
                        break;
                    case 263:
                        bVar.onRouteUnselected(t0Var, iVar, i11);
                        break;
                    case 264:
                        bVar.onRouteSelected(t0Var, iVar, i11, iVar2);
                        break;
                }
            }

            public void b(int i10, Object obj) {
                obtainMessage(i10, obj).sendToTarget();
            }

            public void c(int i10, Object obj, int i11) {
                Message obtainMessage = obtainMessage(i10, obj);
                obtainMessage.arg1 = i11;
                obtainMessage.sendToTarget();
            }

            public final void d(int i10, Object obj) {
                if (i10 == 262) {
                    i iVar = (i) ((a0.d) obj).second;
                    e.this.f17029m.D(iVar);
                    if (e.this.f17033q == null || !iVar.w()) {
                        return;
                    }
                    Iterator it = this.f17046b.iterator();
                    while (it.hasNext()) {
                        e.this.f17029m.C((i) it.next());
                    }
                    this.f17046b.clear();
                }
                if (i10 == 264) {
                    i iVar2 = (i) ((a0.d) obj).second;
                    this.f17046b.add(iVar2);
                    e.this.f17029m.A(iVar2);
                    e.this.f17029m.D(iVar2);
                    return;
                }
                switch (i10) {
                    case 257:
                        e.this.f17029m.A((i) obj);
                        break;
                    case 258:
                        e.this.f17029m.C((i) obj);
                        break;
                    case 259:
                        e.this.f17029m.B((i) obj);
                        break;
                }
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                int i10 = message.what;
                Object obj = message.obj;
                int i11 = message.arg1;
                if (i10 == 259 && e.this.v().k().equals(((i) obj).k())) {
                    e.this.V(true);
                }
                d(i10, obj);
                try {
                    int size = e.this.f17020d.size();
                    while (true) {
                        size--;
                        if (size < 0) {
                            break;
                        }
                        t0 t0Var = (t0) ((WeakReference) e.this.f17020d.get(size)).get();
                        if (t0Var == null) {
                            e.this.f17020d.remove(size);
                        } else {
                            this.f17045a.addAll(t0Var.f17012b);
                        }
                    }
                    int size2 = this.f17045a.size();
                    for (int i12 = 0; i12 < size2; i12++) {
                        a((c) this.f17045a.get(i12), i10, obj, i11);
                    }
                } finally {
                    this.f17045a.clear();
                }
            }
        }

        public final class d {

            /* renamed from: a, reason: collision with root package name */
            public final MediaSessionCompat f17048a;

            /* renamed from: b, reason: collision with root package name */
            public int f17049b;

            /* renamed from: c, reason: collision with root package name */
            public int f17050c;

            /* renamed from: d, reason: collision with root package name */
            public k0.l f17051d;

            public class a extends k0.l {

                /* renamed from: n0.t0$e$d$a$a, reason: collision with other inner class name */
                public class RunnableC0291a implements Runnable {

                    /* renamed from: a, reason: collision with root package name */
                    public final /* synthetic */ int f17054a;

                    public RunnableC0291a(int i10) {
                        this.f17054a = i10;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        i iVar = e.this.f17035s;
                        if (iVar != null) {
                            iVar.G(this.f17054a);
                        }
                    }
                }

                public class b implements Runnable {

                    /* renamed from: a, reason: collision with root package name */
                    public final /* synthetic */ int f17056a;

                    public b(int i10) {
                        this.f17056a = i10;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        i iVar = e.this.f17035s;
                        if (iVar != null) {
                            iVar.H(this.f17056a);
                        }
                    }
                }

                public a(int i10, int i11, int i12, String str) {
                    super(i10, i11, i12, str);
                }

                @Override // k0.l
                public void e(int i10) {
                    e.this.f17027k.post(new b(i10));
                }

                @Override // k0.l
                public void f(int i10) {
                    e.this.f17027k.post(new RunnableC0291a(i10));
                }
            }

            public d(MediaSessionCompat mediaSessionCompat) {
                this.f17048a = mediaSessionCompat;
            }

            public void a() {
                MediaSessionCompat mediaSessionCompat = this.f17048a;
                if (mediaSessionCompat != null) {
                    mediaSessionCompat.p(e.this.f17025i.f17123d);
                    this.f17051d = null;
                }
            }

            public void b(int i10, int i11, int i12, String str) {
                if (this.f17048a != null) {
                    k0.l lVar = this.f17051d;
                    if (lVar != null && i10 == this.f17049b && i11 == this.f17050c) {
                        lVar.h(i12);
                        return;
                    }
                    a aVar = new a(i10, i11, i12, str);
                    this.f17051d = aVar;
                    this.f17048a.q(aVar);
                }
            }

            public MediaSessionCompat.Token c() {
                MediaSessionCompat mediaSessionCompat = this.f17048a;
                if (mediaSessionCompat != null) {
                    return mediaSessionCompat.f();
                }
                return null;
            }
        }

        /* renamed from: n0.t0$e$e, reason: collision with other inner class name */
        public final class C0292e extends g0.a {
            public C0292e() {
            }

            @Override // n0.g0.a
            public void a(p0.e eVar) {
                if (eVar == e.this.f17036t) {
                    d(2);
                } else if (t0.f17009c) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("A RouteController unrelated to the selected route is released. controller=");
                    sb.append(eVar);
                }
            }

            @Override // n0.g0.a
            public void b(int i10) {
                d(i10);
            }

            @Override // n0.g0.a
            public void c(String str, int i10) {
                i iVar;
                Iterator it = e.this.u().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        iVar = null;
                        break;
                    }
                    iVar = (i) it.next();
                    if (iVar.r() == e.this.f17019c && TextUtils.equals(str, iVar.e())) {
                        break;
                    }
                }
                if (iVar != null) {
                    e.this.J(iVar, i10);
                    return;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("onSelectRoute: The target RouteInfo is not found for descriptorId=");
                sb.append(str);
            }

            public void d(int i10) {
                i i11 = e.this.i();
                if (e.this.v() != i11) {
                    e.this.J(i11, i10);
                }
            }
        }

        public final class f extends p0.a {
            public f() {
            }

            @Override // n0.p0.a
            public void a(p0 p0Var, q0 q0Var) {
                e.this.T(p0Var, q0Var);
            }
        }

        public final class g implements u1.c {

            /* renamed from: a, reason: collision with root package name */
            public final u1 f17060a;

            /* renamed from: b, reason: collision with root package name */
            public boolean f17061b;

            public g(Object obj) {
                u1 b10 = u1.b(e.this.f17017a, obj);
                this.f17060a = b10;
                b10.d(this);
                e();
            }

            @Override // n0.u1.c
            public void a(int i10) {
                i iVar;
                if (this.f17061b || (iVar = e.this.f17035s) == null) {
                    return;
                }
                iVar.G(i10);
            }

            @Override // n0.u1.c
            public void b(int i10) {
                i iVar;
                if (this.f17061b || (iVar = e.this.f17035s) == null) {
                    return;
                }
                iVar.H(i10);
            }

            public void c() {
                this.f17061b = true;
                this.f17060a.d(null);
            }

            public Object d() {
                return this.f17060a.a();
            }

            public void e() {
                this.f17060a.c(e.this.f17025i);
            }
        }

        public e(Context context) {
            this.f17017a = context;
            this.f17028l = t.a.a(context);
            this.f17030n = o.i.a((ActivityManager) context.getSystemService("activity"));
            if (Build.VERSION.SDK_INT >= 30) {
                this.f17018b = p1.a(context);
            } else {
                this.f17018b = false;
            }
            if (this.f17018b) {
                this.f17019c = new g0(context, new C0292e());
            } else {
                this.f17019c = null;
            }
            this.f17029m = v1.z(context, this);
        }

        public final boolean A(i iVar) {
            return iVar.r() == this.f17029m && iVar.J("android.media.intent.category.LIVE_AUDIO") && !iVar.J("android.media.intent.category.LIVE_VIDEO");
        }

        public boolean B() {
            o1 o1Var = this.f17031o;
            if (o1Var == null) {
                return false;
            }
            return o1Var.d();
        }

        public void C() {
            if (this.f17035s.y()) {
                List<i> l10 = this.f17035s.l();
                HashSet hashSet = new HashSet();
                Iterator it = l10.iterator();
                while (it.hasNext()) {
                    hashSet.add(((i) it.next()).f17079c);
                }
                Iterator it2 = this.f17039w.entrySet().iterator();
                while (it2.hasNext()) {
                    Map.Entry entry = (Map.Entry) it2.next();
                    if (!hashSet.contains(entry.getKey())) {
                        p0.e eVar = (p0.e) entry.getValue();
                        eVar.h(0);
                        eVar.d();
                        it2.remove();
                    }
                }
                for (i iVar : l10) {
                    if (!this.f17039w.containsKey(iVar.f17079c)) {
                        p0.e t10 = iVar.r().t(iVar.f17078b, this.f17035s.f17078b);
                        t10.e();
                        this.f17039w.put(iVar.f17079c, t10);
                    }
                }
            }
        }

        public void D(e eVar, i iVar, p0.e eVar2, int i10, i iVar2, Collection collection) {
            f fVar;
            g gVar = this.B;
            if (gVar != null) {
                gVar.b();
                this.B = null;
            }
            g gVar2 = new g(eVar, iVar, eVar2, i10, iVar2, collection);
            this.B = gVar2;
            if (gVar2.f17064b != 3 || (fVar = this.A) == null) {
                gVar2.d();
                return;
            }
            ListenableFuture onPrepareTransfer = fVar.onPrepareTransfer(this.f17035s, gVar2.f17066d);
            if (onPrepareTransfer == null) {
                this.B.d();
            } else {
                this.B.f(onPrepareTransfer);
            }
        }

        public void E(i iVar) {
            if (!(this.f17036t instanceof p0.b)) {
                throw new IllegalStateException("There is no currently selected dynamic group route.");
            }
            i.a p10 = p(iVar);
            if (this.f17035s.l().contains(iVar) && p10 != null && p10.d()) {
                if (this.f17035s.l().size() <= 1) {
                    return;
                }
                ((p0.b) this.f17036t).n(iVar.e());
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("Ignoring attempt to remove a non-unselectable member route : ");
                sb.append(iVar);
            }
        }

        public void F(Object obj) {
            int k10 = k(obj);
            if (k10 >= 0) {
                ((g) this.f17024h.remove(k10)).c();
            }
        }

        public void G(i iVar, int i10) {
            p0.e eVar;
            p0.e eVar2;
            if (iVar == this.f17035s && (eVar2 = this.f17036t) != null) {
                eVar2.f(i10);
            } else {
                if (this.f17039w.isEmpty() || (eVar = (p0.e) this.f17039w.get(iVar.f17079c)) == null) {
                    return;
                }
                eVar.f(i10);
            }
        }

        public void H(i iVar, int i10) {
            p0.e eVar;
            p0.e eVar2;
            if (iVar == this.f17035s && (eVar2 = this.f17036t) != null) {
                eVar2.i(i10);
            } else {
                if (this.f17039w.isEmpty() || (eVar = (p0.e) this.f17039w.get(iVar.f17079c)) == null) {
                    return;
                }
                eVar.i(i10);
            }
        }

        public void I(i iVar, int i10) {
            if (!this.f17021e.contains(iVar)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Ignoring attempt to select removed route: ");
                sb.append(iVar);
            } else {
                if (!iVar.f17083g) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Ignoring attempt to select disabled route: ");
                    sb2.append(iVar);
                    return;
                }
                if (Build.VERSION.SDK_INT >= 30) {
                    p0 r10 = iVar.r();
                    g0 g0Var = this.f17019c;
                    if (r10 == g0Var && this.f17035s != iVar) {
                        g0Var.G(iVar.e());
                        return;
                    }
                }
                J(iVar, i10);
            }
        }

        public void J(i iVar, int i10) {
            if (t0.f17010d == null || (this.f17034r != null && iVar.v())) {
                StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
                StringBuilder sb = new StringBuilder();
                for (int i11 = 3; i11 < stackTrace.length; i11++) {
                    StackTraceElement stackTraceElement = stackTrace[i11];
                    sb.append(stackTraceElement.getClassName());
                    sb.append(".");
                    sb.append(stackTraceElement.getMethodName());
                    sb.append(SOAP.DELIM);
                    sb.append(stackTraceElement.getLineNumber());
                    sb.append("  ");
                }
                if (t0.f17010d == null) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("setSelectedRouteInternal is called while sGlobal is null: pkgName=");
                    sb2.append(this.f17017a.getPackageName());
                    sb2.append(", callers=");
                    sb2.append(sb.toString());
                } else {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("Default route is selected while a BT route is available: pkgName=");
                    sb3.append(this.f17017a.getPackageName());
                    sb3.append(", callers=");
                    sb3.append(sb.toString());
                }
            }
            if (this.f17035s == iVar) {
                return;
            }
            if (this.f17037u != null) {
                this.f17037u = null;
                p0.e eVar = this.f17038v;
                if (eVar != null) {
                    eVar.h(3);
                    this.f17038v.d();
                    this.f17038v = null;
                }
            }
            if (x() && iVar.q().g()) {
                p0.b r10 = iVar.r().r(iVar.f17078b);
                if (r10 != null) {
                    r10.p(p.a.getMainExecutor(this.f17017a), this.G);
                    this.f17037u = iVar;
                    this.f17038v = r10;
                    r10.e();
                    return;
                }
                StringBuilder sb4 = new StringBuilder();
                sb4.append("setSelectedRouteInternal: Failed to create dynamic group route controller. route=");
                sb4.append(iVar);
            }
            p0.e s10 = iVar.r().s(iVar.f17078b);
            if (s10 != null) {
                s10.e();
            }
            if (t0.f17009c) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("Route selected: ");
                sb5.append(iVar);
            }
            if (this.f17035s != null) {
                D(this, iVar, s10, i10, null, null);
                return;
            }
            this.f17035s = iVar;
            this.f17036t = s10;
            this.f17027k.c(262, new a0.d(null, iVar), i10);
        }

        public void K(MediaSessionCompat mediaSessionCompat) {
            this.E = mediaSessionCompat;
            if (Build.VERSION.SDK_INT >= 21) {
                L(mediaSessionCompat != null ? new d(mediaSessionCompat) : null);
                return;
            }
            MediaSessionCompat mediaSessionCompat2 = this.D;
            if (mediaSessionCompat2 != null) {
                F(mediaSessionCompat2.e());
                this.D.j(this.F);
            }
            this.D = mediaSessionCompat;
            if (mediaSessionCompat != null) {
                mediaSessionCompat.a(this.F);
                if (mediaSessionCompat.h()) {
                    g(mediaSessionCompat.e());
                }
            }
        }

        public final void L(d dVar) {
            d dVar2 = this.C;
            if (dVar2 != null) {
                dVar2.a();
            }
            this.C = dVar;
            if (dVar != null) {
                R();
            }
        }

        public void M(o1 o1Var) {
            o1 o1Var2 = this.f17031o;
            this.f17031o = o1Var;
            if (x()) {
                if ((o1Var2 == null ? false : o1Var2.d()) != (o1Var != null ? o1Var.d() : false)) {
                    this.f17019c.y(this.f17041y);
                }
            }
        }

        public void N() {
            a(this.f17029m);
            g0 g0Var = this.f17019c;
            if (g0Var != null) {
                a(g0Var);
            }
            t1 t1Var = new t1(this.f17017a, this);
            this.f17032p = t1Var;
            t1Var.i();
        }

        public void O(i iVar) {
            if (!(this.f17036t instanceof p0.b)) {
                throw new IllegalStateException("There is no currently selected dynamic group route.");
            }
            i.a p10 = p(iVar);
            if (p10 == null || !p10.c()) {
                return;
            }
            ((p0.b) this.f17036t).o(Collections.singletonList(iVar.e()));
        }

        public void P() {
            s0.a aVar = new s0.a();
            int size = this.f17020d.size();
            int i10 = 0;
            boolean z10 = false;
            boolean z11 = false;
            while (true) {
                size--;
                if (size < 0) {
                    break;
                }
                t0 t0Var = (t0) ((WeakReference) this.f17020d.get(size)).get();
                if (t0Var == null) {
                    this.f17020d.remove(size);
                } else {
                    int size2 = t0Var.f17012b.size();
                    i10 += size2;
                    for (int i11 = 0; i11 < size2; i11++) {
                        c cVar = (c) t0Var.f17012b.get(i11);
                        aVar.c(cVar.f17015c);
                        int i12 = cVar.f17016d;
                        if ((i12 & 1) != 0) {
                            z10 = true;
                            z11 = true;
                        }
                        if ((i12 & 4) != 0 && !this.f17030n) {
                            z10 = true;
                        }
                        if ((i12 & 8) != 0) {
                            z10 = true;
                        }
                    }
                }
            }
            this.f17042z = i10;
            s0 d10 = z10 ? aVar.d() : s0.f17005c;
            Q(aVar.d(), z11);
            o0 o0Var = this.f17040x;
            if (o0Var != null && o0Var.c().equals(d10) && this.f17040x.d() == z11) {
                return;
            }
            if (!d10.f() || z11) {
                this.f17040x = new o0(d10, z11);
            } else if (this.f17040x == null) {
                return;
            } else {
                this.f17040x = null;
            }
            if (t0.f17009c) {
                StringBuilder sb = new StringBuilder();
                sb.append("Updated discovery request: ");
                sb.append(this.f17040x);
            }
            int size3 = this.f17023g.size();
            for (int i13 = 0; i13 < size3; i13++) {
                p0 p0Var = ((h) this.f17023g.get(i13)).f17073a;
                if (p0Var != this.f17019c) {
                    p0Var.x(this.f17040x);
                }
            }
        }

        public final void Q(s0 s0Var, boolean z10) {
            if (x()) {
                o0 o0Var = this.f17041y;
                if (o0Var != null && o0Var.c().equals(s0Var) && this.f17041y.d() == z10) {
                    return;
                }
                if (!s0Var.f() || z10) {
                    this.f17041y = new o0(s0Var, z10);
                } else if (this.f17041y == null) {
                    return;
                } else {
                    this.f17041y = null;
                }
                if (t0.f17009c) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Updated MediaRoute2Provider's discovery request: ");
                    sb.append(this.f17041y);
                }
                this.f17019c.x(this.f17041y);
            }
        }

        public void R() {
            i iVar = this.f17035s;
            if (iVar == null) {
                d dVar = this.C;
                if (dVar != null) {
                    dVar.a();
                    return;
                }
                return;
            }
            this.f17025i.f17120a = iVar.s();
            this.f17025i.f17121b = this.f17035s.u();
            this.f17025i.f17122c = this.f17035s.t();
            this.f17025i.f17123d = this.f17035s.n();
            this.f17025i.f17124e = this.f17035s.o();
            if (this.f17018b && this.f17035s.r() == this.f17019c) {
                this.f17025i.f17125f = g0.C(this.f17036t);
            } else {
                this.f17025i.f17125f = null;
            }
            int size = this.f17024h.size();
            for (int i10 = 0; i10 < size; i10++) {
                ((g) this.f17024h.get(i10)).e();
            }
            if (this.C != null) {
                if (this.f17035s == o() || this.f17035s == m()) {
                    this.C.a();
                } else {
                    u1.b bVar = this.f17025i;
                    this.C.b(bVar.f17122c == 1 ? 2 : 0, bVar.f17121b, bVar.f17120a, bVar.f17125f);
                }
            }
        }

        public final void S(h hVar, q0 q0Var) {
            boolean z10;
            if (hVar.h(q0Var)) {
                int i10 = 0;
                if (q0Var == null || !(q0Var.c() || q0Var == this.f17029m.o())) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Ignoring invalid provider descriptor: ");
                    sb.append(q0Var);
                    z10 = false;
                } else {
                    List<n0> b10 = q0Var.b();
                    ArrayList<a0.d> arrayList = new ArrayList();
                    ArrayList<a0.d> arrayList2 = new ArrayList();
                    z10 = false;
                    for (n0 n0Var : b10) {
                        if (n0Var == null || !n0Var.x()) {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("Ignoring invalid system route descriptor: ");
                            sb2.append(n0Var);
                        } else {
                            String l10 = n0Var.l();
                            int b11 = hVar.b(l10);
                            if (b11 < 0) {
                                i iVar = new i(hVar, l10, h(hVar, l10));
                                int i11 = i10 + 1;
                                hVar.f17074b.add(i10, iVar);
                                this.f17021e.add(iVar);
                                if (n0Var.j().size() > 0) {
                                    arrayList.add(new a0.d(iVar, n0Var));
                                } else {
                                    iVar.F(n0Var);
                                    if (t0.f17009c) {
                                        StringBuilder sb3 = new StringBuilder();
                                        sb3.append("Route added: ");
                                        sb3.append(iVar);
                                    }
                                    this.f17027k.b(257, iVar);
                                }
                                i10 = i11;
                            } else if (b11 < i10) {
                                StringBuilder sb4 = new StringBuilder();
                                sb4.append("Ignoring route descriptor with duplicate id: ");
                                sb4.append(n0Var);
                            } else {
                                i iVar2 = (i) hVar.f17074b.get(b11);
                                int i12 = i10 + 1;
                                Collections.swap(hVar.f17074b, b11, i10);
                                if (n0Var.j().size() > 0) {
                                    arrayList2.add(new a0.d(iVar2, n0Var));
                                } else if (U(iVar2, n0Var) != 0 && iVar2 == this.f17035s) {
                                    i10 = i12;
                                    z10 = true;
                                }
                                i10 = i12;
                            }
                        }
                    }
                    for (a0.d dVar : arrayList) {
                        i iVar3 = (i) dVar.first;
                        iVar3.F((n0) dVar.second);
                        if (t0.f17009c) {
                            StringBuilder sb5 = new StringBuilder();
                            sb5.append("Route added: ");
                            sb5.append(iVar3);
                        }
                        this.f17027k.b(257, iVar3);
                    }
                    for (a0.d dVar2 : arrayList2) {
                        i iVar4 = (i) dVar2.first;
                        if (U(iVar4, (n0) dVar2.second) != 0 && iVar4 == this.f17035s) {
                            z10 = true;
                        }
                    }
                }
                for (int size = hVar.f17074b.size() - 1; size >= i10; size--) {
                    i iVar5 = (i) hVar.f17074b.get(size);
                    iVar5.F(null);
                    this.f17021e.remove(iVar5);
                }
                V(z10);
                for (int size2 = hVar.f17074b.size() - 1; size2 >= i10; size2--) {
                    i iVar6 = (i) hVar.f17074b.remove(size2);
                    if (t0.f17009c) {
                        StringBuilder sb6 = new StringBuilder();
                        sb6.append("Route removed: ");
                        sb6.append(iVar6);
                    }
                    this.f17027k.b(258, iVar6);
                }
                if (t0.f17009c) {
                    StringBuilder sb7 = new StringBuilder();
                    sb7.append("Provider changed: ");
                    sb7.append(hVar);
                }
                this.f17027k.b(515, hVar);
            }
        }

        public void T(p0 p0Var, q0 q0Var) {
            h j10 = j(p0Var);
            if (j10 != null) {
                S(j10, q0Var);
            }
        }

        public int U(i iVar, n0 n0Var) {
            int F = iVar.F(n0Var);
            if (F != 0) {
                if ((F & 1) != 0) {
                    if (t0.f17009c) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Route changed: ");
                        sb.append(iVar);
                    }
                    this.f17027k.b(259, iVar);
                }
                if ((F & 2) != 0) {
                    if (t0.f17009c) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("Route volume changed: ");
                        sb2.append(iVar);
                    }
                    this.f17027k.b(260, iVar);
                }
                if ((F & 4) != 0) {
                    if (t0.f17009c) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("Route presentation display changed: ");
                        sb3.append(iVar);
                    }
                    this.f17027k.b(261, iVar);
                }
            }
            return F;
        }

        public void V(boolean z10) {
            i iVar = this.f17033q;
            if (iVar != null && !iVar.B()) {
                StringBuilder sb = new StringBuilder();
                sb.append("Clearing the default route because it is no longer selectable: ");
                sb.append(this.f17033q);
                this.f17033q = null;
            }
            if (this.f17033q == null && !this.f17021e.isEmpty()) {
                Iterator it = this.f17021e.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    i iVar2 = (i) it.next();
                    if (z(iVar2) && iVar2.B()) {
                        this.f17033q = iVar2;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("Found default route: ");
                        sb2.append(this.f17033q);
                        break;
                    }
                }
            }
            i iVar3 = this.f17034r;
            if (iVar3 != null && !iVar3.B()) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Clearing the bluetooth route because it is no longer selectable: ");
                sb3.append(this.f17034r);
                this.f17034r = null;
            }
            if (this.f17034r == null && !this.f17021e.isEmpty()) {
                Iterator it2 = this.f17021e.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    i iVar4 = (i) it2.next();
                    if (A(iVar4) && iVar4.B()) {
                        this.f17034r = iVar4;
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append("Found bluetooth route: ");
                        sb4.append(this.f17034r);
                        break;
                    }
                }
            }
            i iVar5 = this.f17035s;
            if (iVar5 == null || !iVar5.x()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("Unselecting the current route because it is no longer selectable: ");
                sb5.append(this.f17035s);
                J(i(), 0);
                return;
            }
            if (z10) {
                C();
                R();
            }
        }

        @Override // n0.t1.c
        public void a(p0 p0Var) {
            if (j(p0Var) == null) {
                h hVar = new h(p0Var);
                this.f17023g.add(hVar);
                if (t0.f17009c) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Provider added: ");
                    sb.append(hVar);
                }
                this.f17027k.b(513, hVar);
                S(hVar, p0Var.o());
                p0Var.v(this.f17026j);
                p0Var.x(this.f17040x);
            }
        }

        @Override // n0.t1.c
        public void b(p0 p0Var) {
            h j10 = j(p0Var);
            if (j10 != null) {
                p0Var.v(null);
                p0Var.x(null);
                S(j10, null);
                if (t0.f17009c) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Provider removed: ");
                    sb.append(j10);
                }
                this.f17027k.b(514, j10);
                this.f17023g.remove(j10);
            }
        }

        @Override // n0.v1.e
        public void c(String str) {
            i a10;
            this.f17027k.removeMessages(262);
            h j10 = j(this.f17029m);
            if (j10 == null || (a10 = j10.a(str)) == null) {
                return;
            }
            a10.I();
        }

        @Override // n0.t1.c
        public void d(q1 q1Var, p0.e eVar) {
            if (this.f17036t == eVar) {
                I(i(), 2);
            }
        }

        public void f(i iVar) {
            if (!(this.f17036t instanceof p0.b)) {
                throw new IllegalStateException("There is no currently selected dynamic group route.");
            }
            i.a p10 = p(iVar);
            if (!this.f17035s.l().contains(iVar) && p10 != null && p10.b()) {
                ((p0.b) this.f17036t).m(iVar.e());
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Ignoring attempt to add a non-groupable route to dynamic group : ");
            sb.append(iVar);
        }

        public void g(Object obj) {
            if (k(obj) < 0) {
                this.f17024h.add(new g(obj));
            }
        }

        public String h(h hVar, String str) {
            String flattenToShortString = hVar.c().flattenToShortString();
            String str2 = flattenToShortString + SOAP.DELIM + str;
            if (l(str2) < 0) {
                this.f17022f.put(new a0.d(flattenToShortString, str), str2);
                return str2;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Either ");
            sb.append(str);
            sb.append(" isn't unique in ");
            sb.append(flattenToShortString);
            sb.append(" or we're trying to assign a unique ID for an already added route");
            int i10 = 2;
            while (true) {
                String format = String.format(Locale.US, "%s_%d", str2, Integer.valueOf(i10));
                if (l(format) < 0) {
                    this.f17022f.put(new a0.d(flattenToShortString, str), format);
                    return format;
                }
                i10++;
            }
        }

        public i i() {
            Iterator it = this.f17021e.iterator();
            while (it.hasNext()) {
                i iVar = (i) it.next();
                if (iVar != this.f17033q && A(iVar) && iVar.B()) {
                    return iVar;
                }
            }
            return this.f17033q;
        }

        public final h j(p0 p0Var) {
            int size = this.f17023g.size();
            for (int i10 = 0; i10 < size; i10++) {
                if (((h) this.f17023g.get(i10)).f17073a == p0Var) {
                    return (h) this.f17023g.get(i10);
                }
            }
            return null;
        }

        public final int k(Object obj) {
            int size = this.f17024h.size();
            for (int i10 = 0; i10 < size; i10++) {
                if (((g) this.f17024h.get(i10)).d() == obj) {
                    return i10;
                }
            }
            return -1;
        }

        public final int l(String str) {
            int size = this.f17021e.size();
            for (int i10 = 0; i10 < size; i10++) {
                if (((i) this.f17021e.get(i10)).f17079c.equals(str)) {
                    return i10;
                }
            }
            return -1;
        }

        public i m() {
            return this.f17034r;
        }

        public int n() {
            return this.f17042z;
        }

        public i o() {
            i iVar = this.f17033q;
            if (iVar != null) {
                return iVar;
            }
            throw new IllegalStateException("There is no default route.  The media router has not yet been fully initialized.");
        }

        public i.a p(i iVar) {
            return this.f17035s.h(iVar);
        }

        public MediaSessionCompat.Token q() {
            d dVar = this.C;
            if (dVar != null) {
                return dVar.c();
            }
            MediaSessionCompat mediaSessionCompat = this.E;
            if (mediaSessionCompat != null) {
                return mediaSessionCompat.f();
            }
            return null;
        }

        public i r(String str) {
            Iterator it = this.f17021e.iterator();
            while (it.hasNext()) {
                i iVar = (i) it.next();
                if (iVar.f17079c.equals(str)) {
                    return iVar;
                }
            }
            return null;
        }

        public t0 s(Context context) {
            int size = this.f17020d.size();
            while (true) {
                size--;
                if (size < 0) {
                    t0 t0Var = new t0(context);
                    this.f17020d.add(new WeakReference(t0Var));
                    return t0Var;
                }
                t0 t0Var2 = (t0) ((WeakReference) this.f17020d.get(size)).get();
                if (t0Var2 == null) {
                    this.f17020d.remove(size);
                } else if (t0Var2.f17011a == context) {
                    return t0Var2;
                }
            }
        }

        public o1 t() {
            return this.f17031o;
        }

        public List u() {
            return this.f17021e;
        }

        public i v() {
            i iVar = this.f17035s;
            if (iVar != null) {
                return iVar;
            }
            throw new IllegalStateException("There is no currently selected route.  The media router has not yet been fully initialized.");
        }

        public String w(h hVar, String str) {
            return (String) this.f17022f.get(new a0.d(hVar.c().flattenToShortString(), str));
        }

        public boolean x() {
            return this.f17018b;
        }

        public boolean y(s0 s0Var, int i10) {
            if (s0Var.f()) {
                return false;
            }
            if ((i10 & 2) == 0 && this.f17030n) {
                return true;
            }
            int size = this.f17021e.size();
            for (int i11 = 0; i11 < size; i11++) {
                i iVar = (i) this.f17021e.get(i11);
                if (((i10 & 1) == 0 || !iVar.w()) && iVar.E(s0Var)) {
                    return true;
                }
            }
            return false;
        }

        public final boolean z(i iVar) {
            return iVar.r() == this.f17029m && iVar.f17078b.equals("DEFAULT_ROUTE");
        }
    }

    public interface f {
        ListenableFuture onPrepareTransfer(i iVar, i iVar2);
    }

    public static final class g {

        /* renamed from: a, reason: collision with root package name */
        public final p0.e f17063a;

        /* renamed from: b, reason: collision with root package name */
        public final int f17064b;

        /* renamed from: c, reason: collision with root package name */
        public final i f17065c;

        /* renamed from: d, reason: collision with root package name */
        public final i f17066d;

        /* renamed from: e, reason: collision with root package name */
        public final i f17067e;

        /* renamed from: f, reason: collision with root package name */
        public final List f17068f;

        /* renamed from: g, reason: collision with root package name */
        public final WeakReference f17069g;

        /* renamed from: h, reason: collision with root package name */
        public ListenableFuture f17070h = null;

        /* renamed from: i, reason: collision with root package name */
        public boolean f17071i = false;

        /* renamed from: j, reason: collision with root package name */
        public boolean f17072j = false;

        public g(e eVar, i iVar, p0.e eVar2, int i10, i iVar2, Collection collection) {
            this.f17069g = new WeakReference(eVar);
            this.f17066d = iVar;
            this.f17063a = eVar2;
            this.f17064b = i10;
            this.f17065c = eVar.f17035s;
            this.f17067e = iVar2;
            this.f17068f = collection != null ? new ArrayList(collection) : null;
            eVar.f17027k.postDelayed(new Runnable() { // from class: n0.w0
                @Override // java.lang.Runnable
                public final void run() {
                    t0.g.this.d();
                }
            }, 15000L);
        }

        public void b() {
            if (this.f17071i || this.f17072j) {
                return;
            }
            this.f17072j = true;
            p0.e eVar = this.f17063a;
            if (eVar != null) {
                eVar.h(0);
                this.f17063a.d();
            }
        }

        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void d() {
            ListenableFuture listenableFuture;
            t0.d();
            if (this.f17071i || this.f17072j) {
                return;
            }
            e eVar = (e) this.f17069g.get();
            if (eVar == null || eVar.B != this || ((listenableFuture = this.f17070h) != null && listenableFuture.isCancelled())) {
                b();
                return;
            }
            this.f17071i = true;
            eVar.B = null;
            g();
            e();
        }

        public final void e() {
            e eVar = (e) this.f17069g.get();
            if (eVar == null) {
                return;
            }
            i iVar = this.f17066d;
            eVar.f17035s = iVar;
            eVar.f17036t = this.f17063a;
            i iVar2 = this.f17067e;
            if (iVar2 == null) {
                eVar.f17027k.c(262, new a0.d(this.f17065c, iVar), this.f17064b);
            } else {
                eVar.f17027k.c(264, new a0.d(iVar2, iVar), this.f17064b);
            }
            eVar.f17039w.clear();
            eVar.C();
            eVar.R();
            List list = this.f17068f;
            if (list != null) {
                eVar.f17035s.L(list);
            }
        }

        public void f(ListenableFuture listenableFuture) {
            e eVar = (e) this.f17069g.get();
            if (eVar == null || eVar.B != this) {
                b();
                return;
            }
            if (this.f17070h != null) {
                throw new IllegalStateException("future is already set");
            }
            this.f17070h = listenableFuture;
            Runnable runnable = new Runnable() { // from class: n0.u0
                @Override // java.lang.Runnable
                public final void run() {
                    t0.g.this.d();
                }
            };
            final e.c cVar = eVar.f17027k;
            Objects.requireNonNull(cVar);
            listenableFuture.addListener(runnable, new Executor() { // from class: n0.v0
                @Override // java.util.concurrent.Executor
                public final void execute(Runnable runnable2) {
                    t0.e.c.this.post(runnable2);
                }
            });
        }

        public final void g() {
            e eVar = (e) this.f17069g.get();
            if (eVar != null) {
                i iVar = eVar.f17035s;
                i iVar2 = this.f17065c;
                if (iVar != iVar2) {
                    return;
                }
                eVar.f17027k.c(263, iVar2, this.f17064b);
                p0.e eVar2 = eVar.f17036t;
                if (eVar2 != null) {
                    eVar2.h(this.f17064b);
                    eVar.f17036t.d();
                }
                if (!eVar.f17039w.isEmpty()) {
                    for (p0.e eVar3 : eVar.f17039w.values()) {
                        eVar3.h(this.f17064b);
                        eVar3.d();
                    }
                    eVar.f17039w.clear();
                }
                eVar.f17036t = null;
            }
        }
    }

    public static final class h {

        /* renamed from: a, reason: collision with root package name */
        public final p0 f17073a;

        /* renamed from: b, reason: collision with root package name */
        public final List f17074b = new ArrayList();

        /* renamed from: c, reason: collision with root package name */
        public final p0.d f17075c;

        /* renamed from: d, reason: collision with root package name */
        public q0 f17076d;

        public h(p0 p0Var) {
            this.f17073a = p0Var;
            this.f17075c = p0Var.q();
        }

        public i a(String str) {
            int size = this.f17074b.size();
            for (int i10 = 0; i10 < size; i10++) {
                if (((i) this.f17074b.get(i10)).f17078b.equals(str)) {
                    return (i) this.f17074b.get(i10);
                }
            }
            return null;
        }

        public int b(String str) {
            int size = this.f17074b.size();
            for (int i10 = 0; i10 < size; i10++) {
                if (((i) this.f17074b.get(i10)).f17078b.equals(str)) {
                    return i10;
                }
            }
            return -1;
        }

        public ComponentName c() {
            return this.f17075c.a();
        }

        public String d() {
            return this.f17075c.b();
        }

        public p0 e() {
            t0.d();
            return this.f17073a;
        }

        public List f() {
            t0.d();
            return Collections.unmodifiableList(this.f17074b);
        }

        public boolean g() {
            q0 q0Var = this.f17076d;
            return q0Var != null && q0Var.d();
        }

        public boolean h(q0 q0Var) {
            if (this.f17076d == q0Var) {
                return false;
            }
            this.f17076d = q0Var;
            return true;
        }

        public String toString() {
            return "MediaRouter.RouteProviderInfo{ packageName=" + d() + " }";
        }
    }

    public static class i {

        /* renamed from: a, reason: collision with root package name */
        public final h f17077a;

        /* renamed from: b, reason: collision with root package name */
        public final String f17078b;

        /* renamed from: c, reason: collision with root package name */
        public final String f17079c;

        /* renamed from: d, reason: collision with root package name */
        public String f17080d;

        /* renamed from: e, reason: collision with root package name */
        public String f17081e;

        /* renamed from: f, reason: collision with root package name */
        public Uri f17082f;

        /* renamed from: g, reason: collision with root package name */
        public boolean f17083g;

        /* renamed from: h, reason: collision with root package name */
        public int f17084h;

        /* renamed from: i, reason: collision with root package name */
        public boolean f17085i;

        /* renamed from: k, reason: collision with root package name */
        public int f17087k;

        /* renamed from: l, reason: collision with root package name */
        public int f17088l;

        /* renamed from: m, reason: collision with root package name */
        public int f17089m;

        /* renamed from: n, reason: collision with root package name */
        public int f17090n;

        /* renamed from: o, reason: collision with root package name */
        public int f17091o;

        /* renamed from: p, reason: collision with root package name */
        public int f17092p;

        /* renamed from: q, reason: collision with root package name */
        public Display f17093q;

        /* renamed from: s, reason: collision with root package name */
        public Bundle f17095s;

        /* renamed from: t, reason: collision with root package name */
        public IntentSender f17096t;

        /* renamed from: u, reason: collision with root package name */
        public n0 f17097u;

        /* renamed from: w, reason: collision with root package name */
        public Map f17099w;

        /* renamed from: j, reason: collision with root package name */
        public final ArrayList f17086j = new ArrayList();

        /* renamed from: r, reason: collision with root package name */
        public int f17094r = -1;

        /* renamed from: v, reason: collision with root package name */
        public List f17098v = new ArrayList();

        public static final class a {

            /* renamed from: a, reason: collision with root package name */
            public final p0.b.c f17100a;

            public a(p0.b.c cVar) {
                this.f17100a = cVar;
            }

            public int a() {
                p0.b.c cVar = this.f17100a;
                if (cVar != null) {
                    return cVar.c();
                }
                return 1;
            }

            public boolean b() {
                p0.b.c cVar = this.f17100a;
                return cVar != null && cVar.d();
            }

            public boolean c() {
                p0.b.c cVar = this.f17100a;
                return cVar != null && cVar.e();
            }

            public boolean d() {
                p0.b.c cVar = this.f17100a;
                return cVar == null || cVar.f();
            }
        }

        public i(h hVar, String str, String str2) {
            this.f17077a = hVar;
            this.f17078b = str;
            this.f17079c = str2;
        }

        public static boolean D(i iVar) {
            return TextUtils.equals(iVar.r().q().b(), "android");
        }

        public final boolean A(List list, List list2) {
            if (list == list2) {
                return true;
            }
            if (list == null || list2 == null) {
                return false;
            }
            ListIterator listIterator = list.listIterator();
            ListIterator listIterator2 = list2.listIterator();
            while (listIterator.hasNext() && listIterator2.hasNext()) {
                if (!z((IntentFilter) listIterator.next(), (IntentFilter) listIterator2.next())) {
                    return false;
                }
            }
            return (listIterator.hasNext() || listIterator2.hasNext()) ? false : true;
        }

        public boolean B() {
            return this.f17097u != null && this.f17083g;
        }

        public boolean C() {
            t0.d();
            return t0.f17010d.v() == this;
        }

        public boolean E(s0 s0Var) {
            if (s0Var == null) {
                throw new IllegalArgumentException("selector must not be null");
            }
            t0.d();
            return s0Var.h(this.f17086j);
        }

        public int F(n0 n0Var) {
            if (this.f17097u != n0Var) {
                return K(n0Var);
            }
            return 0;
        }

        public void G(int i10) {
            t0.d();
            t0.f17010d.G(this, Math.min(this.f17092p, Math.max(0, i10)));
        }

        public void H(int i10) {
            t0.d();
            if (i10 != 0) {
                t0.f17010d.H(this, i10);
            }
        }

        public void I() {
            t0.d();
            t0.f17010d.I(this, 3);
        }

        public boolean J(String str) {
            if (str == null) {
                throw new IllegalArgumentException("category must not be null");
            }
            t0.d();
            int size = this.f17086j.size();
            for (int i10 = 0; i10 < size; i10++) {
                if (((IntentFilter) this.f17086j.get(i10)).hasCategory(str)) {
                    return true;
                }
            }
            return false;
        }

        public int K(n0 n0Var) {
            int i10;
            this.f17097u = n0Var;
            if (n0Var == null) {
                return 0;
            }
            if (a0.c.a(this.f17080d, n0Var.o())) {
                i10 = 0;
            } else {
                this.f17080d = n0Var.o();
                i10 = 1;
            }
            if (!a0.c.a(this.f17081e, n0Var.g())) {
                this.f17081e = n0Var.g();
                i10 |= 1;
            }
            if (!a0.c.a(this.f17082f, n0Var.k())) {
                this.f17082f = n0Var.k();
                i10 |= 1;
            }
            if (this.f17083g != n0Var.w()) {
                this.f17083g = n0Var.w();
                i10 |= 1;
            }
            if (this.f17084h != n0Var.e()) {
                this.f17084h = n0Var.e();
                i10 |= 1;
            }
            if (!A(this.f17086j, n0Var.f())) {
                this.f17086j.clear();
                this.f17086j.addAll(n0Var.f());
                i10 |= 1;
            }
            if (this.f17087k != n0Var.q()) {
                this.f17087k = n0Var.q();
                i10 |= 1;
            }
            if (this.f17088l != n0Var.p()) {
                this.f17088l = n0Var.p();
                i10 |= 1;
            }
            if (this.f17089m != n0Var.h()) {
                this.f17089m = n0Var.h();
                i10 |= 1;
            }
            if (this.f17090n != n0Var.u()) {
                this.f17090n = n0Var.u();
                i10 |= 3;
            }
            if (this.f17091o != n0Var.t()) {
                this.f17091o = n0Var.t();
                i10 |= 3;
            }
            if (this.f17092p != n0Var.v()) {
                this.f17092p = n0Var.v();
                i10 |= 3;
            }
            if (this.f17094r != n0Var.r()) {
                this.f17094r = n0Var.r();
                this.f17093q = null;
                i10 |= 5;
            }
            if (!a0.c.a(this.f17095s, n0Var.i())) {
                this.f17095s = n0Var.i();
                i10 |= 1;
            }
            if (!a0.c.a(this.f17096t, n0Var.s())) {
                this.f17096t = n0Var.s();
                i10 |= 1;
            }
            if (this.f17085i != n0Var.a()) {
                this.f17085i = n0Var.a();
                i10 |= 5;
            }
            List j10 = n0Var.j();
            ArrayList arrayList = new ArrayList();
            boolean z10 = j10.size() != this.f17098v.size();
            Iterator it = j10.iterator();
            while (it.hasNext()) {
                i r10 = t0.f17010d.r(t0.f17010d.w(q(), (String) it.next()));
                if (r10 != null) {
                    arrayList.add(r10);
                    if (!z10 && !this.f17098v.contains(r10)) {
                        z10 = true;
                    }
                }
            }
            if (!z10) {
                return i10;
            }
            this.f17098v = arrayList;
            return i10 | 1;
        }

        public void L(Collection collection) {
            this.f17098v.clear();
            if (this.f17099w == null) {
                this.f17099w = new androidx.collection.a();
            }
            this.f17099w.clear();
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                p0.b.c cVar = (p0.b.c) it.next();
                i b10 = b(cVar);
                if (b10 != null) {
                    this.f17099w.put(b10.f17079c, cVar);
                    if (cVar.c() == 2 || cVar.c() == 3) {
                        this.f17098v.add(b10);
                    }
                }
            }
            t0.f17010d.f17027k.b(259, this);
        }

        public boolean a() {
            return this.f17085i;
        }

        public i b(p0.b.c cVar) {
            return q().a(cVar.b().l());
        }

        public int c() {
            return this.f17084h;
        }

        public String d() {
            return this.f17081e;
        }

        public String e() {
            return this.f17078b;
        }

        public int f() {
            return this.f17089m;
        }

        public p0.b g() {
            p0.e eVar = t0.f17010d.f17036t;
            if (eVar instanceof p0.b) {
                return (p0.b) eVar;
            }
            return null;
        }

        public a h(i iVar) {
            Map map = this.f17099w;
            if (map == null || !map.containsKey(iVar.f17079c)) {
                return null;
            }
            return new a((p0.b.c) this.f17099w.get(iVar.f17079c));
        }

        public Bundle i() {
            return this.f17095s;
        }

        public Uri j() {
            return this.f17082f;
        }

        public String k() {
            return this.f17079c;
        }

        public List l() {
            return Collections.unmodifiableList(this.f17098v);
        }

        public String m() {
            return this.f17080d;
        }

        public int n() {
            return this.f17088l;
        }

        public int o() {
            return this.f17087k;
        }

        public int p() {
            return this.f17094r;
        }

        public h q() {
            return this.f17077a;
        }

        public p0 r() {
            return this.f17077a.e();
        }

        public int s() {
            return this.f17091o;
        }

        public int t() {
            return this.f17090n;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("MediaRouter.RouteInfo{ uniqueId=" + this.f17079c + ", name=" + this.f17080d + ", description=" + this.f17081e + ", iconUri=" + this.f17082f + ", enabled=" + this.f17083g + ", connectionState=" + this.f17084h + ", canDisconnect=" + this.f17085i + ", playbackType=" + this.f17087k + ", playbackStream=" + this.f17088l + ", deviceType=" + this.f17089m + ", volumeHandling=" + this.f17090n + ", volume=" + this.f17091o + ", volumeMax=" + this.f17092p + ", presentationDisplayId=" + this.f17094r + ", extras=" + this.f17095s + ", settingsIntent=" + this.f17096t + ", providerPackageName=" + this.f17077a.d());
            if (y()) {
                sb.append(", members=[");
                int size = this.f17098v.size();
                for (int i10 = 0; i10 < size; i10++) {
                    if (i10 > 0) {
                        sb.append(", ");
                    }
                    if (this.f17098v.get(i10) != this) {
                        sb.append(((i) this.f17098v.get(i10)).k());
                    }
                }
                sb.append(']');
            }
            sb.append(" }");
            return sb.toString();
        }

        public int u() {
            return this.f17092p;
        }

        public boolean v() {
            t0.d();
            return t0.f17010d.o() == this;
        }

        public boolean w() {
            if (v() || this.f17089m == 3) {
                return true;
            }
            return D(this) && J("android.media.intent.category.LIVE_AUDIO") && !J("android.media.intent.category.LIVE_VIDEO");
        }

        public boolean x() {
            return this.f17083g;
        }

        public boolean y() {
            return l().size() >= 1;
        }

        public final boolean z(IntentFilter intentFilter, IntentFilter intentFilter2) {
            int countActions;
            if (intentFilter == intentFilter2) {
                return true;
            }
            if (intentFilter == null || intentFilter2 == null || (countActions = intentFilter.countActions()) != intentFilter2.countActions()) {
                return false;
            }
            for (int i10 = 0; i10 < countActions; i10++) {
                if (!intentFilter.getAction(i10).equals(intentFilter2.getAction(i10))) {
                    return false;
                }
            }
            int countCategories = intentFilter.countCategories();
            if (countCategories != intentFilter2.countCategories()) {
                return false;
            }
            for (int i11 = 0; i11 < countCategories; i11++) {
                if (!intentFilter.getCategory(i11).equals(intentFilter2.getCategory(i11))) {
                    return false;
                }
            }
            return true;
        }
    }

    public t0(Context context) {
        this.f17011a = context;
    }

    public static void d() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new IllegalStateException("The media router service must only be accessed on the application's main thread.");
        }
    }

    public static int h() {
        e eVar = f17010d;
        if (eVar == null) {
            return 0;
        }
        return eVar.n();
    }

    public static t0 i(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("context must not be null");
        }
        d();
        if (f17010d == null) {
            e eVar = new e(context.getApplicationContext());
            f17010d = eVar;
            eVar.N();
        }
        return f17010d.s(context);
    }

    public static boolean n() {
        e eVar = f17010d;
        if (eVar == null) {
            return false;
        }
        return eVar.x();
    }

    public static boolean p() {
        e eVar = f17010d;
        if (eVar == null) {
            return false;
        }
        return eVar.B();
    }

    public void a(s0 s0Var, b bVar) {
        b(s0Var, bVar, 0);
    }

    public void b(s0 s0Var, b bVar, int i10) {
        c cVar;
        boolean z10;
        if (s0Var == null) {
            throw new IllegalArgumentException("selector must not be null");
        }
        if (bVar == null) {
            throw new IllegalArgumentException("callback must not be null");
        }
        d();
        if (f17009c) {
            StringBuilder sb = new StringBuilder();
            sb.append("addCallback: selector=");
            sb.append(s0Var);
            sb.append(", callback=");
            sb.append(bVar);
            sb.append(", flags=");
            sb.append(Integer.toHexString(i10));
        }
        int e10 = e(bVar);
        if (e10 < 0) {
            cVar = new c(this, bVar);
            this.f17012b.add(cVar);
        } else {
            cVar = (c) this.f17012b.get(e10);
        }
        boolean z11 = true;
        if (i10 != cVar.f17016d) {
            cVar.f17016d = i10;
            z10 = true;
        } else {
            z10 = false;
        }
        if (cVar.f17015c.b(s0Var)) {
            z11 = z10;
        } else {
            cVar.f17015c = new s0.a(cVar.f17015c).c(s0Var).d();
        }
        if (z11) {
            f17010d.P();
        }
    }

    public void c(i iVar) {
        d();
        f17010d.f(iVar);
    }

    public final int e(b bVar) {
        int size = this.f17012b.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (((c) this.f17012b.get(i10)).f17014b == bVar) {
                return i10;
            }
        }
        return -1;
    }

    public i f() {
        d();
        return f17010d.m();
    }

    public i g() {
        d();
        return f17010d.o();
    }

    public MediaSessionCompat.Token j() {
        return f17010d.q();
    }

    public o1 k() {
        d();
        return f17010d.t();
    }

    public List l() {
        d();
        return f17010d.u();
    }

    public i m() {
        d();
        return f17010d.v();
    }

    public boolean o(s0 s0Var, int i10) {
        if (s0Var == null) {
            throw new IllegalArgumentException("selector must not be null");
        }
        d();
        return f17010d.y(s0Var, i10);
    }

    public void q(b bVar) {
        if (bVar == null) {
            throw new IllegalArgumentException("callback must not be null");
        }
        d();
        if (f17009c) {
            StringBuilder sb = new StringBuilder();
            sb.append("removeCallback: callback=");
            sb.append(bVar);
        }
        int e10 = e(bVar);
        if (e10 >= 0) {
            this.f17012b.remove(e10);
            f17010d.P();
        }
    }

    public void r(i iVar) {
        d();
        f17010d.E(iVar);
    }

    public void s(i iVar) {
        if (iVar == null) {
            throw new IllegalArgumentException("route must not be null");
        }
        d();
        if (f17009c) {
            StringBuilder sb = new StringBuilder();
            sb.append("selectRoute: ");
            sb.append(iVar);
        }
        f17010d.I(iVar, 3);
    }

    public void t(MediaSessionCompat mediaSessionCompat) {
        if (f17009c) {
            StringBuilder sb = new StringBuilder();
            sb.append("addMediaSessionCompat: ");
            sb.append(mediaSessionCompat);
        }
        f17010d.K(mediaSessionCompat);
    }

    public void u(f fVar) {
        d();
        f17010d.A = fVar;
    }

    public void v(o1 o1Var) {
        d();
        f17010d.M(o1Var);
    }

    public void w(i iVar) {
        d();
        f17010d.O(iVar);
    }

    public void x(int i10) {
        if (i10 < 0 || i10 > 3) {
            throw new IllegalArgumentException("Unsupported reason to unselect route");
        }
        d();
        i i11 = f17010d.i();
        if (f17010d.v() != i11) {
            f17010d.I(i11, i10);
        }
    }
}
