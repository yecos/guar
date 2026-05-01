package n0;

import android.content.Context;
import android.media.MediaRoute2Info;
import android.media.MediaRouter2;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.Log;
import android.util.SparseArray;
import androidx.mediarouter.R$string;
import com.hpplay.component.protocol.PlistBuilder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import n0.g0;
import n0.n0;
import n0.p0;
import n0.q0;
import n0.s0;
import n0.t0;

/* loaded from: classes.dex */
public class g0 extends p0 {

    /* renamed from: s, reason: collision with root package name */
    public static final boolean f16880s = Log.isLoggable("MR2Provider", 3);

    /* renamed from: i, reason: collision with root package name */
    public final MediaRouter2 f16881i;

    /* renamed from: j, reason: collision with root package name */
    public final a f16882j;

    /* renamed from: k, reason: collision with root package name */
    public final Map f16883k;

    /* renamed from: l, reason: collision with root package name */
    public final MediaRouter2.RouteCallback f16884l;

    /* renamed from: m, reason: collision with root package name */
    public final MediaRouter2.TransferCallback f16885m;

    /* renamed from: n, reason: collision with root package name */
    public final MediaRouter2.ControllerCallback f16886n;

    /* renamed from: o, reason: collision with root package name */
    public final Handler f16887o;

    /* renamed from: p, reason: collision with root package name */
    public final Executor f16888p;

    /* renamed from: q, reason: collision with root package name */
    public List f16889q;

    /* renamed from: r, reason: collision with root package name */
    public Map f16890r;

    public static abstract class a {
        public abstract void a(p0.e eVar);

        public abstract void b(int i10);

        public abstract void c(String str, int i10);
    }

    public class b extends MediaRouter2.ControllerCallback {
        public b() {
        }

        @Override // android.media.MediaRouter2.ControllerCallback
        public void onControllerUpdated(MediaRouter2.RoutingController routingController) {
            g0.this.F(routingController);
        }
    }

    public class c extends p0.b {

        /* renamed from: f, reason: collision with root package name */
        public final String f16892f;

        /* renamed from: g, reason: collision with root package name */
        public final MediaRouter2.RoutingController f16893g;

        /* renamed from: h, reason: collision with root package name */
        public final Messenger f16894h;

        /* renamed from: i, reason: collision with root package name */
        public final Messenger f16895i;

        /* renamed from: k, reason: collision with root package name */
        public final Handler f16897k;

        /* renamed from: j, reason: collision with root package name */
        public final SparseArray f16896j = new SparseArray();

        /* renamed from: l, reason: collision with root package name */
        public AtomicInteger f16898l = new AtomicInteger(1);

        /* renamed from: m, reason: collision with root package name */
        public final Runnable f16899m = new Runnable() { // from class: n0.l0
            @Override // java.lang.Runnable
            public final void run() {
                g0.c.this.r();
            }
        };

        /* renamed from: n, reason: collision with root package name */
        public int f16900n = -1;

        public class a extends Handler {
            public a() {
                super(Looper.getMainLooper());
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                int i10 = message.what;
                int i11 = message.arg1;
                Object obj = message.obj;
                Bundle peekData = message.peekData();
                t0.d dVar = (t0.d) c.this.f16896j.get(i11);
                if (dVar == null) {
                    return;
                }
                c.this.f16896j.remove(i11);
                if (i10 == 3) {
                    dVar.b((Bundle) obj);
                } else {
                    if (i10 != 4) {
                        return;
                    }
                    dVar.a(peekData == null ? null : peekData.getString("error"), (Bundle) obj);
                }
            }
        }

        public c(MediaRouter2.RoutingController routingController, String str) {
            this.f16893g = routingController;
            this.f16892f = str;
            Messenger A = g0.A(routingController);
            this.f16894h = A;
            this.f16895i = A == null ? null : new Messenger(new a());
            this.f16897k = new Handler(Looper.getMainLooper());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void r() {
            this.f16900n = -1;
        }

        @Override // n0.p0.e
        public void d() {
            this.f16893g.release();
        }

        @Override // n0.p0.e
        public void f(int i10) {
            MediaRouter2.RoutingController routingController = this.f16893g;
            if (routingController == null) {
                return;
            }
            routingController.setVolume(i10);
            this.f16900n = i10;
            s();
        }

        @Override // n0.p0.e
        public void i(int i10) {
            int volumeMax;
            MediaRouter2.RoutingController routingController = this.f16893g;
            if (routingController == null) {
                return;
            }
            int i11 = this.f16900n;
            if (i11 < 0) {
                i11 = routingController.getVolume();
            }
            int i12 = i11 + i10;
            volumeMax = this.f16893g.getVolumeMax();
            int max = Math.max(0, Math.min(i12, volumeMax));
            this.f16900n = max;
            this.f16893g.setVolume(max);
            s();
        }

        @Override // n0.p0.b
        public void m(String str) {
            if (str == null || str.isEmpty()) {
                return;
            }
            MediaRoute2Info B = g0.this.B(str);
            if (B != null) {
                this.f16893g.selectRoute(B);
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("onAddMemberRoute: Specified route not found. routeId=");
            sb.append(str);
        }

        @Override // n0.p0.b
        public void n(String str) {
            if (str == null || str.isEmpty()) {
                return;
            }
            MediaRoute2Info B = g0.this.B(str);
            if (B != null) {
                this.f16893g.deselectRoute(B);
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("onRemoveMemberRoute: Specified route not found. routeId=");
            sb.append(str);
        }

        @Override // n0.p0.b
        public void o(List list) {
            if (list == null || list.isEmpty()) {
                return;
            }
            String str = (String) list.get(0);
            MediaRoute2Info B = g0.this.B(str);
            if (B != null) {
                g0.this.f16881i.transferTo(B);
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("onUpdateMemberRoutes: Specified route not found. routeId=");
            sb.append(str);
        }

        public final void s() {
            this.f16897k.removeCallbacks(this.f16899m);
            this.f16897k.postDelayed(this.f16899m, 1000L);
        }

        public void t(String str, int i10) {
            int andIncrement = this.f16898l.getAndIncrement();
            Message obtain = Message.obtain();
            obtain.what = 7;
            obtain.arg1 = andIncrement;
            Bundle bundle = new Bundle();
            bundle.putInt(PlistBuilder.VALUE_TYPE_VOLUME, i10);
            bundle.putString("routeId", str);
            obtain.setData(bundle);
            obtain.replyTo = this.f16895i;
            try {
                this.f16894h.send(obtain);
            } catch (DeadObjectException unused) {
            } catch (RemoteException e10) {
                Log.e("MR2Provider", "Could not send control request to service.", e10);
            }
        }

        public void u(String str, int i10) {
            int andIncrement = this.f16898l.getAndIncrement();
            Message obtain = Message.obtain();
            obtain.what = 8;
            obtain.arg1 = andIncrement;
            Bundle bundle = new Bundle();
            bundle.putInt(PlistBuilder.VALUE_TYPE_VOLUME, i10);
            bundle.putString("routeId", str);
            obtain.setData(bundle);
            obtain.replyTo = this.f16895i;
            try {
                this.f16894h.send(obtain);
            } catch (DeadObjectException unused) {
            } catch (RemoteException e10) {
                Log.e("MR2Provider", "Could not send control request to service.", e10);
            }
        }
    }

    public class d extends p0.e {

        /* renamed from: a, reason: collision with root package name */
        public final String f16903a;

        /* renamed from: b, reason: collision with root package name */
        public final c f16904b;

        public d(String str, c cVar) {
            this.f16903a = str;
            this.f16904b = cVar;
        }

        @Override // n0.p0.e
        public void f(int i10) {
            c cVar;
            String str = this.f16903a;
            if (str == null || (cVar = this.f16904b) == null) {
                return;
            }
            cVar.t(str, i10);
        }

        @Override // n0.p0.e
        public void i(int i10) {
            c cVar;
            String str = this.f16903a;
            if (str == null || (cVar = this.f16904b) == null) {
                return;
            }
            cVar.u(str, i10);
        }
    }

    public class e extends MediaRouter2.RouteCallback {
        public e() {
        }

        @Override // android.media.MediaRouter2.RouteCallback
        public void onRoutesAdded(List list) {
            g0.this.E();
        }

        @Override // android.media.MediaRouter2.RouteCallback
        public void onRoutesChanged(List list) {
            g0.this.E();
        }

        @Override // android.media.MediaRouter2.RouteCallback
        public void onRoutesRemoved(List list) {
            g0.this.E();
        }
    }

    public class f extends MediaRouter2.TransferCallback {
        public f() {
        }

        @Override // android.media.MediaRouter2.TransferCallback
        public void onStop(MediaRouter2.RoutingController routingController) {
            p0.e eVar = (p0.e) g0.this.f16883k.remove(routingController);
            if (eVar != null) {
                g0.this.f16882j.a(eVar);
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("onStop: No matching routeController found. routingController=");
            sb.append(routingController);
        }

        @Override // android.media.MediaRouter2.TransferCallback
        public void onTransfer(MediaRouter2.RoutingController routingController, MediaRouter2.RoutingController routingController2) {
            MediaRouter2.RoutingController systemController;
            List selectedRoutes;
            String id;
            g0.this.f16883k.remove(routingController);
            systemController = g0.this.f16881i.getSystemController();
            if (routingController2 == systemController) {
                g0.this.f16882j.b(3);
                return;
            }
            selectedRoutes = routingController2.getSelectedRoutes();
            if (selectedRoutes.isEmpty()) {
                return;
            }
            id = n0.b.a(selectedRoutes.get(0)).getId();
            g0.this.f16883k.put(routingController2, g0.this.new c(routingController2, id));
            g0.this.f16882j.c(id, 3);
            g0.this.F(routingController2);
        }

        @Override // android.media.MediaRouter2.TransferCallback
        public void onTransferFailure(MediaRoute2Info mediaRoute2Info) {
            StringBuilder sb = new StringBuilder();
            sb.append("Transfer failed. requestedRoute=");
            sb.append(mediaRoute2Info);
        }
    }

    public g0(Context context, a aVar) {
        super(context);
        MediaRouter2 mediaRouter2;
        this.f16883k = new ArrayMap();
        this.f16884l = new e();
        this.f16885m = new f();
        this.f16886n = new b();
        this.f16889q = new ArrayList();
        this.f16890r = new ArrayMap();
        mediaRouter2 = MediaRouter2.getInstance(context);
        this.f16881i = mediaRouter2;
        this.f16882j = aVar;
        final Handler handler = new Handler(Looper.getMainLooper());
        this.f16887o = handler;
        Objects.requireNonNull(handler);
        this.f16888p = new Executor() { // from class: n0.c0
            @Override // java.util.concurrent.Executor
            public final void execute(Runnable runnable) {
                handler.post(runnable);
            }
        };
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0004, code lost:
    
        r1 = r1.getControlHints();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.os.Messenger A(android.media.MediaRouter2.RoutingController r1) {
        /*
            r0 = 0
            if (r1 != 0) goto L4
            return r0
        L4:
            android.os.Bundle r1 = n0.c.a(r1)
            if (r1 != 0) goto Lb
            goto L14
        Lb:
            java.lang.String r0 = "androidx.mediarouter.media.KEY_MESSENGER"
            android.os.Parcelable r1 = r1.getParcelable(r0)
            r0 = r1
            android.os.Messenger r0 = (android.os.Messenger) r0
        L14:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: n0.g0.A(android.media.MediaRouter2$RoutingController):android.os.Messenger");
    }

    public static String C(p0.e eVar) {
        MediaRouter2.RoutingController routingController;
        String id;
        if (!(eVar instanceof c) || (routingController = ((c) eVar).f16893g) == null) {
            return null;
        }
        id = routingController.getId();
        return id;
    }

    public static /* synthetic */ boolean D(MediaRoute2Info mediaRoute2Info) {
        boolean isSystemRoute;
        isSystemRoute = mediaRoute2Info.isSystemRoute();
        return !isSystemRoute;
    }

    public MediaRoute2Info B(String str) {
        String id;
        if (str == null) {
            return null;
        }
        Iterator it = this.f16889q.iterator();
        while (it.hasNext()) {
            MediaRoute2Info a10 = n0.b.a(it.next());
            id = a10.getId();
            if (TextUtils.equals(id, str)) {
                return a10;
            }
        }
        return null;
    }

    public void E() {
        List routes;
        Stream stream;
        Stream distinct;
        Stream filter;
        Collector list;
        Object collect;
        Stream stream2;
        Stream map;
        Stream filter2;
        Collector list2;
        Object collect2;
        Bundle extras;
        String id;
        routes = this.f16881i.getRoutes();
        stream = routes.stream();
        distinct = stream.distinct();
        filter = distinct.filter(new Predicate() { // from class: n0.f0
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                boolean D;
                D = g0.D((MediaRoute2Info) obj);
                return D;
            }
        });
        list = Collectors.toList();
        collect = filter.collect(list);
        List list3 = (List) collect;
        if (list3.equals(this.f16889q)) {
            return;
        }
        this.f16889q = list3;
        this.f16890r.clear();
        Iterator it = this.f16889q.iterator();
        while (it.hasNext()) {
            MediaRoute2Info a10 = n0.b.a(it.next());
            extras = a10.getExtras();
            if (extras == null || extras.getString("androidx.mediarouter.media.KEY_ORIGINAL_ROUTE_ID") == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("Cannot find the original route Id. route=");
                sb.append(a10);
            } else {
                Map map2 = this.f16890r;
                id = a10.getId();
                map2.put(id, extras.getString("androidx.mediarouter.media.KEY_ORIGINAL_ROUTE_ID"));
            }
        }
        stream2 = this.f16889q.stream();
        map = stream2.map(new Function() { // from class: n0.d0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return i1.c((MediaRoute2Info) obj);
            }
        });
        filter2 = map.filter(new Predicate() { // from class: n0.e0
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return b0.a((n0) obj);
            }
        });
        list2 = Collectors.toList();
        collect2 = filter2.collect(list2);
        w(new q0.a().d(true).b((List) collect2).c());
    }

    public void F(MediaRouter2.RoutingController routingController) {
        List selectedRoutes;
        List selectedRoutes2;
        Bundle controlHints;
        List selectableRoutes;
        List deselectableRoutes;
        String id;
        int volume;
        int volumeMax;
        int volumeHandling;
        c cVar = (c) this.f16883k.get(routingController);
        if (cVar == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("setDynamicRouteDescriptors: No matching routeController found. routingController=");
            sb.append(routingController);
            return;
        }
        selectedRoutes = routingController.getSelectedRoutes();
        List a10 = i1.a(selectedRoutes);
        selectedRoutes2 = routingController.getSelectedRoutes();
        n0 c10 = i1.c(n0.b.a(selectedRoutes2.get(0)));
        controlHints = routingController.getControlHints();
        String string = n().getString(R$string.mr_dialog_default_group_name);
        n0 n0Var = null;
        if (controlHints != null) {
            try {
                String string2 = controlHints.getString("androidx.mediarouter.media.KEY_SESSION_NAME");
                if (!TextUtils.isEmpty(string2)) {
                    string = string2;
                }
                Bundle bundle = controlHints.getBundle("androidx.mediarouter.media.KEY_GROUP_ROUTE");
                if (bundle != null) {
                    n0Var = n0.d(bundle);
                }
            } catch (Exception unused) {
            }
        }
        if (n0Var == null) {
            id = routingController.getId();
            n0.a p10 = new n0.a(id, string).g(2).p(1);
            volume = routingController.getVolume();
            n0.a r10 = p10.r(volume);
            volumeMax = routingController.getVolumeMax();
            n0.a t10 = r10.t(volumeMax);
            volumeHandling = routingController.getVolumeHandling();
            n0Var = t10.s(volumeHandling).b(c10.f()).d(a10).e();
        }
        selectableRoutes = routingController.getSelectableRoutes();
        List a11 = i1.a(selectableRoutes);
        deselectableRoutes = routingController.getDeselectableRoutes();
        List a12 = i1.a(deselectableRoutes);
        q0 o10 = o();
        if (o10 == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        List<n0> b10 = o10.b();
        if (!b10.isEmpty()) {
            for (n0 n0Var2 : b10) {
                String l10 = n0Var2.l();
                arrayList.add(new p0.b.c.a(n0Var2).e(a10.contains(l10) ? 3 : 1).b(a11.contains(l10)).d(a12.contains(l10)).c(true).a());
            }
        }
        cVar.l(n0Var, arrayList);
    }

    public void G(String str) {
        MediaRoute2Info B = B(str);
        if (B != null) {
            this.f16881i.transferTo(B);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("transferTo: Specified route not found. routeId=");
        sb.append(str);
    }

    public final o0 H(o0 o0Var, boolean z10) {
        if (o0Var == null) {
            o0Var = new o0(s0.f17005c, false);
        }
        List e10 = o0Var.c().e();
        if (!z10) {
            e10.remove("android.media.intent.category.LIVE_AUDIO");
        } else if (!e10.contains("android.media.intent.category.LIVE_AUDIO")) {
            e10.add("android.media.intent.category.LIVE_AUDIO");
        }
        return new o0(new s0.a().a(e10).d(), o0Var.d());
    }

    @Override // n0.p0
    public p0.b r(String str) {
        Iterator it = this.f16883k.entrySet().iterator();
        while (it.hasNext()) {
            c cVar = (c) ((Map.Entry) it.next()).getValue();
            if (TextUtils.equals(str, cVar.f16892f)) {
                return cVar;
            }
        }
        return null;
    }

    @Override // n0.p0
    public p0.e s(String str) {
        return new d((String) this.f16890r.get(str), null);
    }

    @Override // n0.p0
    public p0.e t(String str, String str2) {
        String id;
        String str3 = (String) this.f16890r.get(str);
        for (c cVar : this.f16883k.values()) {
            id = cVar.f16893g.getId();
            if (TextUtils.equals(str2, id)) {
                return new d(str3, cVar);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Could not find the matching GroupRouteController. routeId=");
        sb.append(str);
        sb.append(", routeGroupId=");
        sb.append(str2);
        return new d(str3, null);
    }

    @Override // n0.p0
    public void u(o0 o0Var) {
        if (t0.h() <= 0) {
            this.f16881i.unregisterRouteCallback(this.f16884l);
            this.f16881i.unregisterTransferCallback(this.f16885m);
            this.f16881i.unregisterControllerCallback(this.f16886n);
        } else {
            this.f16881i.registerRouteCallback(this.f16888p, this.f16884l, i1.b(H(o0Var, t0.p())));
            this.f16881i.registerTransferCallback(this.f16888p, this.f16885m);
            this.f16881i.registerControllerCallback(this.f16888p, this.f16886n);
        }
    }
}
