package n0;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import android.util.SparseArray;
import com.hpplay.component.protocol.PlistBuilder;
import com.umeng.analytics.pro.q;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import n0.p0;
import n0.t0;

/* loaded from: classes.dex */
public final class q1 extends p0 implements ServiceConnection {

    /* renamed from: q, reason: collision with root package name */
    public static final boolean f16964q = Log.isLoggable("MediaRouteProviderProxy", 3);

    /* renamed from: i, reason: collision with root package name */
    public final ComponentName f16965i;

    /* renamed from: j, reason: collision with root package name */
    public final d f16966j;

    /* renamed from: k, reason: collision with root package name */
    public final ArrayList f16967k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f16968l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f16969m;

    /* renamed from: n, reason: collision with root package name */
    public a f16970n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f16971o;

    /* renamed from: p, reason: collision with root package name */
    public b f16972p;

    public final class a implements IBinder.DeathRecipient {

        /* renamed from: a, reason: collision with root package name */
        public final Messenger f16973a;

        /* renamed from: b, reason: collision with root package name */
        public final e f16974b;

        /* renamed from: c, reason: collision with root package name */
        public final Messenger f16975c;

        /* renamed from: f, reason: collision with root package name */
        public int f16978f;

        /* renamed from: g, reason: collision with root package name */
        public int f16979g;

        /* renamed from: d, reason: collision with root package name */
        public int f16976d = 1;

        /* renamed from: e, reason: collision with root package name */
        public int f16977e = 1;

        /* renamed from: h, reason: collision with root package name */
        public final SparseArray f16980h = new SparseArray();

        /* renamed from: n0.q1$a$a, reason: collision with other inner class name */
        public class RunnableC0290a implements Runnable {
            public RunnableC0290a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.e();
            }
        }

        public class b implements Runnable {
            public b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                a aVar = a.this;
                q1.this.J(aVar);
            }
        }

        public a(Messenger messenger) {
            this.f16973a = messenger;
            e eVar = new e(this);
            this.f16974b = eVar;
            this.f16975c = new Messenger(eVar);
        }

        public void a(int i10, String str) {
            Bundle bundle = new Bundle();
            bundle.putString("memberRouteId", str);
            int i11 = this.f16976d;
            this.f16976d = i11 + 1;
            s(12, i11, i10, null, bundle);
        }

        public int b(String str, t0.d dVar) {
            int i10 = this.f16977e;
            this.f16977e = i10 + 1;
            int i11 = this.f16976d;
            this.f16976d = i11 + 1;
            Bundle bundle = new Bundle();
            bundle.putString("memberRouteId", str);
            s(11, i11, i10, null, bundle);
            this.f16980h.put(i11, dVar);
            return i10;
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            q1.this.f16966j.post(new b());
        }

        public int c(String str, String str2) {
            int i10 = this.f16977e;
            this.f16977e = i10 + 1;
            Bundle bundle = new Bundle();
            bundle.putString("routeId", str);
            bundle.putString("routeGroupId", str2);
            int i11 = this.f16976d;
            this.f16976d = i11 + 1;
            s(3, i11, i10, null, bundle);
            return i10;
        }

        public void d() {
            s(2, 0, 0, null, null);
            this.f16974b.a();
            this.f16973a.getBinder().unlinkToDeath(this, 0);
            q1.this.f16966j.post(new RunnableC0290a());
        }

        public void e() {
            int size = this.f16980h.size();
            for (int i10 = 0; i10 < size; i10++) {
                ((t0.d) this.f16980h.valueAt(i10)).a(null, null);
            }
            this.f16980h.clear();
        }

        public boolean f(int i10, String str, Bundle bundle) {
            t0.d dVar = (t0.d) this.f16980h.get(i10);
            if (dVar == null) {
                return false;
            }
            this.f16980h.remove(i10);
            dVar.a(str, bundle);
            return true;
        }

        public boolean g(int i10, Bundle bundle) {
            t0.d dVar = (t0.d) this.f16980h.get(i10);
            if (dVar == null) {
                return false;
            }
            this.f16980h.remove(i10);
            dVar.b(bundle);
            return true;
        }

        public void h(int i10) {
            q1.this.H(this, i10);
        }

        public boolean i(Bundle bundle) {
            if (this.f16978f == 0) {
                return false;
            }
            q1.this.I(this, q0.a(bundle));
            return true;
        }

        public void j(int i10, Bundle bundle) {
            t0.d dVar = (t0.d) this.f16980h.get(i10);
            if (bundle == null || !bundle.containsKey("routeId")) {
                dVar.a("DynamicGroupRouteController is created without valid route id.", bundle);
            } else {
                this.f16980h.remove(i10);
                dVar.b(bundle);
            }
        }

        public boolean k(int i10, Bundle bundle) {
            if (this.f16978f == 0) {
                return false;
            }
            Bundle bundle2 = (Bundle) bundle.getParcelable("groupRoute");
            n0 d10 = bundle2 != null ? n0.d(bundle2) : null;
            ArrayList parcelableArrayList = bundle.getParcelableArrayList("dynamicRoutes");
            ArrayList arrayList = new ArrayList();
            Iterator it = parcelableArrayList.iterator();
            while (it.hasNext()) {
                arrayList.add(p0.b.c.a((Bundle) it.next()));
            }
            q1.this.N(this, i10, d10, arrayList);
            return true;
        }

        public boolean l(int i10) {
            if (i10 == this.f16979g) {
                this.f16979g = 0;
                q1.this.K(this, "Registration failed");
            }
            t0.d dVar = (t0.d) this.f16980h.get(i10);
            if (dVar == null) {
                return true;
            }
            this.f16980h.remove(i10);
            dVar.a(null, null);
            return true;
        }

        public boolean m(int i10) {
            return true;
        }

        public boolean n(int i10, int i11, Bundle bundle) {
            if (this.f16978f != 0 || i10 != this.f16979g || i11 < 1) {
                return false;
            }
            this.f16979g = 0;
            this.f16978f = i11;
            q1.this.I(this, q0.a(bundle));
            q1.this.L(this);
            return true;
        }

        public boolean o() {
            int i10 = this.f16976d;
            this.f16976d = i10 + 1;
            this.f16979g = i10;
            if (!s(1, i10, 4, null, null)) {
                return false;
            }
            try {
                this.f16973a.getBinder().linkToDeath(this, 0);
                return true;
            } catch (RemoteException unused) {
                binderDied();
                return false;
            }
        }

        public void p(int i10) {
            int i11 = this.f16976d;
            this.f16976d = i11 + 1;
            s(4, i11, i10, null, null);
        }

        public void q(int i10, String str) {
            Bundle bundle = new Bundle();
            bundle.putString("memberRouteId", str);
            int i11 = this.f16976d;
            this.f16976d = i11 + 1;
            s(13, i11, i10, null, bundle);
        }

        public void r(int i10) {
            int i11 = this.f16976d;
            this.f16976d = i11 + 1;
            s(5, i11, i10, null, null);
        }

        public final boolean s(int i10, int i11, int i12, Object obj, Bundle bundle) {
            Message obtain = Message.obtain();
            obtain.what = i10;
            obtain.arg1 = i11;
            obtain.arg2 = i12;
            obtain.obj = obj;
            obtain.setData(bundle);
            obtain.replyTo = this.f16975c;
            try {
                this.f16973a.send(obtain);
                return true;
            } catch (DeadObjectException unused) {
                return false;
            } catch (RemoteException e10) {
                if (i10 == 2) {
                    return false;
                }
                Log.e("MediaRouteProviderProxy", "Could not send message to service.", e10);
                return false;
            }
        }

        public void t(o0 o0Var) {
            int i10 = this.f16976d;
            this.f16976d = i10 + 1;
            s(10, i10, 0, o0Var != null ? o0Var.a() : null, null);
        }

        public void u(int i10, int i11) {
            Bundle bundle = new Bundle();
            bundle.putInt(PlistBuilder.VALUE_TYPE_VOLUME, i11);
            int i12 = this.f16976d;
            this.f16976d = i12 + 1;
            s(7, i12, i10, null, bundle);
        }

        public void v(int i10, int i11) {
            Bundle bundle = new Bundle();
            bundle.putInt("unselectReason", i11);
            int i12 = this.f16976d;
            this.f16976d = i12 + 1;
            s(6, i12, i10, null, bundle);
        }

        public void w(int i10, List list) {
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("memberRouteIds", new ArrayList<>(list));
            int i11 = this.f16976d;
            this.f16976d = i11 + 1;
            s(14, i11, i10, null, bundle);
        }

        public void x(int i10, int i11) {
            Bundle bundle = new Bundle();
            bundle.putInt(PlistBuilder.VALUE_TYPE_VOLUME, i11);
            int i12 = this.f16976d;
            this.f16976d = i12 + 1;
            s(8, i12, i10, null, bundle);
        }
    }

    public interface b {
        void a(p0.e eVar);
    }

    public interface c {
        void a(a aVar);

        int b();

        void c();
    }

    public static final class d extends Handler {
    }

    public static final class e extends Handler {

        /* renamed from: a, reason: collision with root package name */
        public final WeakReference f16984a;

        public e(a aVar) {
            this.f16984a = new WeakReference(aVar);
        }

        public void a() {
            this.f16984a.clear();
        }

        public final boolean b(a aVar, int i10, int i11, int i12, Object obj, Bundle bundle) {
            switch (i10) {
                case 0:
                    aVar.l(i11);
                    return true;
                case 1:
                    aVar.m(i11);
                    return true;
                case 2:
                    if (obj == null || (obj instanceof Bundle)) {
                        return aVar.n(i11, i12, (Bundle) obj);
                    }
                    return false;
                case 3:
                    if (obj == null || (obj instanceof Bundle)) {
                        return aVar.g(i11, (Bundle) obj);
                    }
                    return false;
                case 4:
                    if (obj == null || (obj instanceof Bundle)) {
                        return aVar.f(i11, bundle == null ? null : bundle.getString("error"), (Bundle) obj);
                    }
                    return false;
                case 5:
                    if (obj == null || (obj instanceof Bundle)) {
                        return aVar.i((Bundle) obj);
                    }
                    return false;
                case 6:
                    if (!(obj instanceof Bundle)) {
                        return false;
                    }
                    aVar.j(i11, (Bundle) obj);
                    return false;
                case 7:
                    if (obj == null || (obj instanceof Bundle)) {
                        return aVar.k(i12, (Bundle) obj);
                    }
                    return false;
                case 8:
                    aVar.h(i12);
                    return false;
                default:
                    return false;
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            a aVar = (a) this.f16984a.get();
            if (aVar == null || b(aVar, message.what, message.arg1, message.arg2, message.obj, message.peekData()) || !q1.f16964q) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Unhandled message from server: ");
            sb.append(message);
        }
    }

    public final class f extends p0.b implements c {

        /* renamed from: f, reason: collision with root package name */
        public final String f16985f;

        /* renamed from: g, reason: collision with root package name */
        public String f16986g;

        /* renamed from: h, reason: collision with root package name */
        public String f16987h;

        /* renamed from: i, reason: collision with root package name */
        public boolean f16988i;

        /* renamed from: k, reason: collision with root package name */
        public int f16990k;

        /* renamed from: l, reason: collision with root package name */
        public a f16991l;

        /* renamed from: j, reason: collision with root package name */
        public int f16989j = -1;

        /* renamed from: m, reason: collision with root package name */
        public int f16992m = -1;

        public class a extends t0.d {
            public a() {
            }

            @Override // n0.t0.d
            public void a(String str, Bundle bundle) {
                StringBuilder sb = new StringBuilder();
                sb.append("Error: ");
                sb.append(str);
                sb.append(", data: ");
                sb.append(bundle);
            }

            @Override // n0.t0.d
            public void b(Bundle bundle) {
                f.this.f16986g = bundle.getString("groupableTitle");
                f.this.f16987h = bundle.getString("transferableTitle");
            }
        }

        public f(String str) {
            this.f16985f = str;
        }

        @Override // n0.q1.c
        public void a(a aVar) {
            a aVar2 = new a();
            this.f16991l = aVar;
            int b10 = aVar.b(this.f16985f, aVar2);
            this.f16992m = b10;
            if (this.f16988i) {
                aVar.r(b10);
                int i10 = this.f16989j;
                if (i10 >= 0) {
                    aVar.u(this.f16992m, i10);
                    this.f16989j = -1;
                }
                int i11 = this.f16990k;
                if (i11 != 0) {
                    aVar.x(this.f16992m, i11);
                    this.f16990k = 0;
                }
            }
        }

        @Override // n0.q1.c
        public int b() {
            return this.f16992m;
        }

        @Override // n0.q1.c
        public void c() {
            a aVar = this.f16991l;
            if (aVar != null) {
                aVar.p(this.f16992m);
                this.f16991l = null;
                this.f16992m = 0;
            }
        }

        @Override // n0.p0.e
        public void d() {
            q1.this.M(this);
        }

        @Override // n0.p0.e
        public void e() {
            this.f16988i = true;
            a aVar = this.f16991l;
            if (aVar != null) {
                aVar.r(this.f16992m);
            }
        }

        @Override // n0.p0.e
        public void f(int i10) {
            a aVar = this.f16991l;
            if (aVar != null) {
                aVar.u(this.f16992m, i10);
            } else {
                this.f16989j = i10;
                this.f16990k = 0;
            }
        }

        @Override // n0.p0.e
        public void g() {
            h(0);
        }

        @Override // n0.p0.e
        public void h(int i10) {
            this.f16988i = false;
            a aVar = this.f16991l;
            if (aVar != null) {
                aVar.v(this.f16992m, i10);
            }
        }

        @Override // n0.p0.e
        public void i(int i10) {
            a aVar = this.f16991l;
            if (aVar != null) {
                aVar.x(this.f16992m, i10);
            } else {
                this.f16990k += i10;
            }
        }

        @Override // n0.p0.b
        public String j() {
            return this.f16986g;
        }

        @Override // n0.p0.b
        public String k() {
            return this.f16987h;
        }

        @Override // n0.p0.b
        public void m(String str) {
            a aVar = this.f16991l;
            if (aVar != null) {
                aVar.a(this.f16992m, str);
            }
        }

        @Override // n0.p0.b
        public void n(String str) {
            a aVar = this.f16991l;
            if (aVar != null) {
                aVar.q(this.f16992m, str);
            }
        }

        @Override // n0.p0.b
        public void o(List list) {
            a aVar = this.f16991l;
            if (aVar != null) {
                aVar.w(this.f16992m, list);
            }
        }

        public void q(n0 n0Var, List list) {
            l(n0Var, list);
        }
    }

    public final class g extends p0.e implements c {

        /* renamed from: a, reason: collision with root package name */
        public final String f16995a;

        /* renamed from: b, reason: collision with root package name */
        public final String f16996b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f16997c;

        /* renamed from: d, reason: collision with root package name */
        public int f16998d = -1;

        /* renamed from: e, reason: collision with root package name */
        public int f16999e;

        /* renamed from: f, reason: collision with root package name */
        public a f17000f;

        /* renamed from: g, reason: collision with root package name */
        public int f17001g;

        public g(String str, String str2) {
            this.f16995a = str;
            this.f16996b = str2;
        }

        @Override // n0.q1.c
        public void a(a aVar) {
            this.f17000f = aVar;
            int c10 = aVar.c(this.f16995a, this.f16996b);
            this.f17001g = c10;
            if (this.f16997c) {
                aVar.r(c10);
                int i10 = this.f16998d;
                if (i10 >= 0) {
                    aVar.u(this.f17001g, i10);
                    this.f16998d = -1;
                }
                int i11 = this.f16999e;
                if (i11 != 0) {
                    aVar.x(this.f17001g, i11);
                    this.f16999e = 0;
                }
            }
        }

        @Override // n0.q1.c
        public int b() {
            return this.f17001g;
        }

        @Override // n0.q1.c
        public void c() {
            a aVar = this.f17000f;
            if (aVar != null) {
                aVar.p(this.f17001g);
                this.f17000f = null;
                this.f17001g = 0;
            }
        }

        @Override // n0.p0.e
        public void d() {
            q1.this.M(this);
        }

        @Override // n0.p0.e
        public void e() {
            this.f16997c = true;
            a aVar = this.f17000f;
            if (aVar != null) {
                aVar.r(this.f17001g);
            }
        }

        @Override // n0.p0.e
        public void f(int i10) {
            a aVar = this.f17000f;
            if (aVar != null) {
                aVar.u(this.f17001g, i10);
            } else {
                this.f16998d = i10;
                this.f16999e = 0;
            }
        }

        @Override // n0.p0.e
        public void g() {
            h(0);
        }

        @Override // n0.p0.e
        public void h(int i10) {
            this.f16997c = false;
            a aVar = this.f17000f;
            if (aVar != null) {
                aVar.v(this.f17001g, i10);
            }
        }

        @Override // n0.p0.e
        public void i(int i10) {
            a aVar = this.f17000f;
            if (aVar != null) {
                aVar.x(this.f17001g, i10);
            } else {
                this.f16999e += i10;
            }
        }
    }

    public q1(Context context, ComponentName componentName) {
        super(context, new p0.d(componentName));
        this.f16967k = new ArrayList();
        this.f16965i = componentName;
        this.f16966j = new d();
    }

    public final void A() {
        if (this.f16969m) {
            return;
        }
        boolean z10 = f16964q;
        if (z10) {
            StringBuilder sb = new StringBuilder();
            sb.append(this);
            sb.append(": Binding");
        }
        Intent intent = new Intent("android.media.MediaRouteProviderService");
        intent.setComponent(this.f16965i);
        try {
            boolean bindService = n().bindService(intent, this, Build.VERSION.SDK_INT >= 29 ? q.a.f10521a : 1);
            this.f16969m = bindService;
            if (bindService || !z10) {
                return;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this);
            sb2.append(": Bind failed");
        } catch (SecurityException unused) {
            if (f16964q) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(this);
                sb3.append(": Bind failed");
            }
        }
    }

    public final p0.b B(String str) {
        q0 o10 = o();
        if (o10 == null) {
            return null;
        }
        List b10 = o10.b();
        int size = b10.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (((n0) b10.get(i10)).l().equals(str)) {
                f fVar = new f(str);
                this.f16967k.add(fVar);
                if (this.f16971o) {
                    fVar.a(this.f16970n);
                }
                U();
                return fVar;
            }
        }
        return null;
    }

    public final p0.e C(String str, String str2) {
        q0 o10 = o();
        if (o10 == null) {
            return null;
        }
        List b10 = o10.b();
        int size = b10.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (((n0) b10.get(i10)).l().equals(str)) {
                g gVar = new g(str, str2);
                this.f16967k.add(gVar);
                if (this.f16971o) {
                    gVar.a(this.f16970n);
                }
                U();
                return gVar;
            }
        }
        return null;
    }

    public final void D() {
        int size = this.f16967k.size();
        for (int i10 = 0; i10 < size; i10++) {
            ((c) this.f16967k.get(i10)).c();
        }
    }

    public final void E() {
        if (this.f16970n != null) {
            w(null);
            this.f16971o = false;
            D();
            this.f16970n.d();
            this.f16970n = null;
        }
    }

    public final c F(int i10) {
        Iterator it = this.f16967k.iterator();
        while (it.hasNext()) {
            c cVar = (c) it.next();
            if (cVar.b() == i10) {
                return cVar;
            }
        }
        return null;
    }

    public boolean G(String str, String str2) {
        return this.f16965i.getPackageName().equals(str) && this.f16965i.getClassName().equals(str2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void H(a aVar, int i10) {
        if (this.f16970n == aVar) {
            c F = F(i10);
            b bVar = this.f16972p;
            if (bVar != null && (F instanceof p0.e)) {
                bVar.a((p0.e) F);
            }
            M(F);
        }
    }

    public void I(a aVar, q0 q0Var) {
        if (this.f16970n == aVar) {
            if (f16964q) {
                StringBuilder sb = new StringBuilder();
                sb.append(this);
                sb.append(": Descriptor changed, descriptor=");
                sb.append(q0Var);
            }
            w(q0Var);
        }
    }

    public void J(a aVar) {
        if (this.f16970n == aVar) {
            if (f16964q) {
                StringBuilder sb = new StringBuilder();
                sb.append(this);
                sb.append(": Service connection died");
            }
            E();
        }
    }

    public void K(a aVar, String str) {
        if (this.f16970n == aVar) {
            if (f16964q) {
                StringBuilder sb = new StringBuilder();
                sb.append(this);
                sb.append(": Service connection error - ");
                sb.append(str);
            }
            T();
        }
    }

    public void L(a aVar) {
        if (this.f16970n == aVar) {
            this.f16971o = true;
            z();
            o0 p10 = p();
            if (p10 != null) {
                this.f16970n.t(p10);
            }
        }
    }

    public void M(c cVar) {
        this.f16967k.remove(cVar);
        cVar.c();
        U();
    }

    public void N(a aVar, int i10, n0 n0Var, List list) {
        if (this.f16970n == aVar) {
            if (f16964q) {
                StringBuilder sb = new StringBuilder();
                sb.append(this);
                sb.append(": DynamicRouteDescriptors changed, descriptors=");
                sb.append(list);
            }
            c F = F(i10);
            if (F instanceof f) {
                ((f) F).q(n0Var, list);
            }
        }
    }

    public void O() {
        if (this.f16970n == null && Q()) {
            T();
            A();
        }
    }

    public void P(b bVar) {
        this.f16972p = bVar;
    }

    public final boolean Q() {
        if (this.f16968l) {
            return (p() == null && this.f16967k.isEmpty()) ? false : true;
        }
        return false;
    }

    public void R() {
        if (this.f16968l) {
            return;
        }
        if (f16964q) {
            StringBuilder sb = new StringBuilder();
            sb.append(this);
            sb.append(": Starting");
        }
        this.f16968l = true;
        U();
    }

    public void S() {
        if (this.f16968l) {
            if (f16964q) {
                StringBuilder sb = new StringBuilder();
                sb.append(this);
                sb.append(": Stopping");
            }
            this.f16968l = false;
            U();
        }
    }

    public final void T() {
        if (this.f16969m) {
            if (f16964q) {
                StringBuilder sb = new StringBuilder();
                sb.append(this);
                sb.append(": Unbinding");
            }
            this.f16969m = false;
            E();
            try {
                n().unbindService(this);
            } catch (IllegalArgumentException e10) {
                Log.e("MediaRouteProviderProxy", this + ": unbindService failed", e10);
            }
        }
    }

    public final void U() {
        if (Q()) {
            A();
        } else {
            T();
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        boolean z10 = f16964q;
        if (z10) {
            StringBuilder sb = new StringBuilder();
            sb.append(this);
            sb.append(": Connected");
        }
        if (this.f16969m) {
            E();
            Messenger messenger = iBinder != null ? new Messenger(iBinder) : null;
            if (!r0.a(messenger)) {
                Log.e("MediaRouteProviderProxy", this + ": Service returned invalid messenger binder");
                return;
            }
            a aVar = new a(messenger);
            if (aVar.o()) {
                this.f16970n = aVar;
            } else if (z10) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(this);
                sb2.append(": Registration failed");
            }
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        if (f16964q) {
            StringBuilder sb = new StringBuilder();
            sb.append(this);
            sb.append(": Service disconnected");
        }
        E();
    }

    @Override // n0.p0
    public p0.b r(String str) {
        if (str != null) {
            return B(str);
        }
        throw new IllegalArgumentException("initialMemberRouteId cannot be null.");
    }

    @Override // n0.p0
    public p0.e s(String str) {
        if (str != null) {
            return C(str, null);
        }
        throw new IllegalArgumentException("routeId cannot be null");
    }

    @Override // n0.p0
    public p0.e t(String str, String str2) {
        if (str == null) {
            throw new IllegalArgumentException("routeId cannot be null");
        }
        if (str2 != null) {
            return C(str, str2);
        }
        throw new IllegalArgumentException("routeGroupId cannot be null");
    }

    public String toString() {
        return "Service connection " + this.f16965i.flattenToShortString();
    }

    @Override // n0.p0
    public void u(o0 o0Var) {
        if (this.f16971o) {
            this.f16970n.t(o0Var);
        }
        U();
    }

    public final void z() {
        int size = this.f16967k.size();
        for (int i10 = 0; i10 < size; i10++) {
            ((c) this.f16967k.get(i10)).a(this.f16970n);
        }
    }
}
