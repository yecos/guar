package l8;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.Surface;
import com.google.android.gms.cast.MediaTrack;
import com.hpplay.component.protocol.PlistBuilder;
import com.titan.ranger.NativeJni;
import com.titan.ranger.bean.Env;
import com.titan.ranger.bean.Program;
import com.titan.thumbnail.PreviewUtil;
import com.titan.thumbnail.ThumbnailRequest;
import com.umeng.analytics.pro.bd;
import com.umeng.analytics.pro.bt;
import java.util.List;
import t9.x;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* loaded from: classes.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public final String f16358a;

    /* renamed from: b, reason: collision with root package name */
    public final l8.e[] f16359b;

    /* renamed from: c, reason: collision with root package name */
    public String f16360c;

    /* renamed from: d, reason: collision with root package name */
    public k8.a f16361d;

    /* renamed from: e, reason: collision with root package name */
    public j8.a f16362e;

    /* renamed from: f, reason: collision with root package name */
    public j8.b f16363f;

    /* renamed from: g, reason: collision with root package name */
    public Env f16364g;

    /* renamed from: h, reason: collision with root package name */
    public volatile boolean f16365h;

    /* renamed from: i, reason: collision with root package name */
    public HandlerThread f16366i;

    /* renamed from: j, reason: collision with root package name */
    public Handler f16367j;

    /* renamed from: m, reason: collision with root package name */
    public static final b f16357m = new b(null);

    /* renamed from: k, reason: collision with root package name */
    public static final h9.g f16355k = h9.h.b(a.f16368a);

    /* renamed from: l, reason: collision with root package name */
    public static String f16356l = "[2.5.4]";

    /* loaded from: classes3.dex */
    public static final class a extends t9.j implements s9.a {

        /* renamed from: a, reason: collision with root package name */
        public static final a f16368a = new a();

        public a() {
            super(0);
        }

        @Override // s9.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final h invoke() {
            return new h(null);
        }
    }

    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ z9.g[] f16369a = {x.e(new t9.r(x.a(b.class), "instance", "getInstance()Lcom/titan/media/TitanPlayer;"))};

        public b() {
        }

        public /* synthetic */ b(t9.g gVar) {
            this();
        }

        public final h a() {
            return b();
        }

        public final h b() {
            h9.g gVar = h.f16355k;
            z9.g gVar2 = f16369a[0];
            return (h) gVar.getValue();
        }

        public final String c() {
            return h.f16356l;
        }

        public final void d(String str) {
            t9.i.h(str, "<set-?>");
            h.f16356l = str;
        }
    }

    /* loaded from: classes3.dex */
    public static final class c implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f16371b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ j8.a f16372c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ j8.b f16373d;

        public c(String str, j8.a aVar, j8.b bVar) {
            this.f16371b = str;
            this.f16372c = aVar;
            this.f16373d = bVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            h.this.f16360c = this.f16371b;
            h.this.f16362e = this.f16372c;
            h.this.f16363f = this.f16373d;
            NativeJni.c().f(this.f16371b);
            h.this.s(0);
            h.this.s(1);
            h.this.f16361d = new k8.a(0);
            k8.a aVar = h.this.f16361d;
            if (aVar != null) {
                aVar.s(com.hpplay.a.a.a.d.SOCKET_READ_TIMEOUT, false);
            }
            h.this.q();
            h.this.q();
            StringBuilder sb = new StringBuilder();
            sb.append("titan:2.5.4;ranger:");
            sb.append(NativeJni.f9456d);
        }
    }

    /* loaded from: classes3.dex */
    public static final class d implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i8.d f16374a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ i8.e f16375b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ i8.c f16376c;

        public d(i8.d dVar, i8.e eVar, i8.c cVar) {
            this.f16374a = dVar;
            this.f16375b = eVar;
            this.f16376c = cVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            NativeJni.c().m(this.f16374a.a(), this.f16375b.a(), this.f16376c.a());
        }
    }

    /* loaded from: classes3.dex */
    public static final class e implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i8.d f16377a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ i8.e f16378b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f16379c;

        public e(i8.d dVar, i8.e eVar, int i10) {
            this.f16377a = dVar;
            this.f16378b = eVar;
            this.f16379c = i10;
        }

        @Override // java.lang.Runnable
        public final void run() {
            NativeJni.c().m(this.f16377a.a(), this.f16378b.a(), String.valueOf(this.f16379c));
        }
    }

    /* loaded from: classes3.dex */
    public static final class f implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f16381b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f16382c;

        public f(int i10, String str) {
            this.f16381b = i10;
            this.f16382c = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            l8.e eVar = h.this.f16359b[this.f16381b];
            if (eVar != null) {
                eVar.s0(this.f16382c);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class g implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f16384b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f16385c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Program f16386d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f16387e;

        public g(int i10, String str, Program program, String str2) {
            this.f16384b = i10;
            this.f16385c = str;
            this.f16386d = program;
            this.f16387e = str2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            l8.e eVar = h.this.f16359b[this.f16384b];
            if (eVar != null) {
                eVar.t0(this.f16385c, this.f16386d, this.f16387e);
            }
        }
    }

    /* renamed from: l8.h$h, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class RunnableC0284h implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f16389b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f16390c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Program f16391d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f16392e;

        public RunnableC0284h(int i10, String str, Program program, String str2) {
            this.f16389b = i10;
            this.f16390c = str;
            this.f16391d = program;
            this.f16392e = str2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            l8.e eVar = h.this.f16359b[this.f16389b];
            if (eVar != null) {
                eVar.u0(this.f16390c, this.f16391d, this.f16392e);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class i implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f16394b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f16395c;

        public i(int i10, String str) {
            this.f16394b = i10;
            this.f16395c = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            l8.e eVar = h.this.f16359b[this.f16394b];
            if (eVar != null) {
                eVar.A0(this.f16395c);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class j implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f16397b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f16398c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ long f16399d;

        public j(int i10, String str, long j10) {
            this.f16397b = i10;
            this.f16398c = str;
            this.f16399d = j10;
        }

        @Override // java.lang.Runnable
        public final void run() {
            l8.e eVar = h.this.f16359b[this.f16397b];
            if (eVar != null) {
                eVar.C0(this.f16398c, this.f16399d);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class k implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ List f16400a;

        public k(List list) {
            this.f16400a = list;
        }

        @Override // java.lang.Runnable
        public final void run() {
            NativeJni.c().s(m8.a.a().toJson(this.f16400a));
        }
    }

    /* loaded from: classes3.dex */
    public static final class l implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Env f16402b;

        public l(Env env) {
            this.f16402b = env;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Env env = this.f16402b;
            k8.a aVar = h.this.f16361d;
            env.setTitan_port(aVar != null ? aVar.j() : -1);
            h.this.E(this.f16402b);
            NativeJni.c().u(m8.a.a().toJson(this.f16402b));
        }
    }

    /* loaded from: classes3.dex */
    public static final class m implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f16404b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f16405c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f16406d;

        public m(int i10, String str, String str2) {
            this.f16404b = i10;
            this.f16405c = str;
            this.f16406d = str2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            l8.e eVar = h.this.f16359b[this.f16404b];
            if (eVar != null) {
                eVar.J0(this.f16405c, this.f16406d);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class n implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f16408b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f16409c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f16410d;

        public n(int i10, String str, int i11) {
            this.f16408b = i10;
            this.f16409c = str;
            this.f16410d = i11;
        }

        @Override // java.lang.Runnable
        public final void run() {
            String str;
            l8.e eVar = h.this.f16359b[this.f16408b];
            String str2 = this.f16409c;
            switch (str2.hashCode()) {
                case -2060497896:
                    str = MediaTrack.ROLE_SUBTITLE;
                    break;
                case -1662454116:
                    str = "subtitle_delay";
                    break;
                case -1024974996:
                    str = "buffer_time";
                    break;
                case -810883302:
                    if (!str2.equals(PlistBuilder.VALUE_TYPE_VOLUME) || eVar == null) {
                        return;
                    }
                    eVar.P0(this.f16410d);
                    return;
                case -46576386:
                    str = bt.aZ;
                    break;
                case 93166550:
                    if (!str2.equals("audio") || eVar == null) {
                        return;
                    }
                    eVar.D0(this.f16410d);
                    return;
                case 109641799:
                    if (!str2.equals("speed") || eVar == null) {
                        return;
                    }
                    eVar.M0(this.f16410d);
                    return;
                case 782236819:
                    str = "hdr_map";
                    break;
                case 1330532588:
                    if (!str2.equals("thumbnail") || eVar == null) {
                        return;
                    }
                    eVar.G0(this.f16410d);
                    return;
                case 1689832893:
                    if (!str2.equals("polling_period") || eVar == null) {
                        return;
                    }
                    eVar.L0(this.f16410d);
                    return;
                case 1943400114:
                    if (!str2.equals("mediacodec") || eVar == null) {
                        return;
                    }
                    eVar.H0(this.f16410d);
                    return;
                case 2132222038:
                    str = "default_subtitle";
                    break;
                default:
                    return;
            }
            str2.equals(str);
        }
    }

    /* loaded from: classes3.dex */
    public static final class o implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f16412b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f16413c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f16414d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Context f16415e;

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ int f16416f;

        public o(int i10, String str, String str2, Context context, int i11) {
            this.f16412b = i10;
            this.f16413c = str;
            this.f16414d = str2;
            this.f16415e = context;
            this.f16416f = i11;
        }

        @Override // java.lang.Runnable
        public final void run() {
            l8.e eVar = h.this.f16359b[this.f16412b];
            String str = this.f16413c;
            if (str.hashCode() == -985752863 && str.equals("player")) {
                if (eVar != null) {
                    eVar.I0(this.f16415e);
                }
                if (!h.this.f16365h && t9.i.b(this.f16414d, "ijk")) {
                    String loadLibrariesOnce = IjkMediaPlayer.loadLibrariesOnce(null);
                    if (loadLibrariesOnce != null) {
                        NativeJni.c().k(this.f16412b, "onError", 0, 1300, 0L, loadLibrariesOnce);
                    }
                    h.this.f16365h = true;
                    h.this.q();
                    h.this.q();
                    StringBuilder sb = new StringBuilder();
                    sb.append("ijk:");
                    sb.append(IjkMediaPlayer.getIjkVersion());
                    sb.append(";ffmpeg:");
                    sb.append(IjkMediaPlayer.getFFVersion());
                    b bVar = h.f16357m;
                    bVar.d(bVar.c() + "-[" + IjkMediaPlayer.getIjkVersion() + "]-[" + IjkMediaPlayer.getFFVersion() + ']');
                }
                if (eVar != null) {
                    eVar.W0(this.f16414d, this.f16416f);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class p implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f16418b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Surface f16419c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f16420d;

        public p(int i10, Surface surface, String str) {
            this.f16418b = i10;
            this.f16419c = surface;
            this.f16420d = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            l8.e eVar = h.this.f16359b[this.f16418b];
            if (eVar != null) {
                eVar.N0(this.f16419c, this.f16420d);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class q implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f16422b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f16423c;

        public q(int i10, String str) {
            this.f16422b = i10;
            this.f16423c = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            l8.e eVar = h.this.f16359b[this.f16422b];
            if (eVar != null) {
                eVar.T0(this.f16423c);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class r implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f16425b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f16426c;

        public r(int i10, String str) {
            this.f16425b = i10;
            this.f16426c = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            l8.e eVar = h.this.f16359b[this.f16425b];
            if (eVar != null) {
                eVar.V0(this.f16426c);
            }
        }
    }

    public h() {
        String simpleName = h.class.getSimpleName();
        t9.i.c(simpleName, "javaClass.simpleName");
        this.f16358a = simpleName;
        this.f16359b = new l8.e[2];
        this.f16360c = "";
        HandlerThread handlerThread = new HandlerThread("handlerTitan", -4);
        this.f16366i = handlerThread;
        handlerThread.start();
        HandlerThread handlerThread2 = this.f16366i;
        this.f16367j = new Handler(handlerThread2 != null ? handlerThread2.getLooper() : null);
    }

    public final void A(int i10, String str) {
        t9.i.h(str, "name");
        x(new i(i10, str));
    }

    public final void B(int i10, String str, long j10) {
        t9.i.h(str, "name");
        x(new j(i10, str, j10));
    }

    public final void C(List list) {
        t9.i.h(list, "entries");
        x(new k(list));
    }

    public final void D(Env env) {
        t9.i.h(env, bd.f9974a);
        x(new l(env));
    }

    public final void E(Env env) {
        this.f16364g = env;
    }

    public final void F(int i10, String str, String str2) {
        t9.i.h(str, "name");
        t9.i.h(str2, "media");
        x(new m(i10, str, str2));
    }

    public final void G(int i10, String str, int i11) {
        t9.i.h(str, "key");
        x(new n(i10, str, i11));
    }

    public final void H(int i10, String str, String str2, Context context, int i11) {
        t9.i.h(str, "key");
        t9.i.h(str2, "value");
        x(new o(i10, str, str2, context, i11));
    }

    public final void I(int i10, Surface surface, String str) {
        t9.i.h(str, "surfaceId");
        x(new p(i10, surface, str));
    }

    public final void J(int i10, String str) {
        t9.i.h(str, "name");
        x(new q(i10, str));
    }

    public final void K(int i10, String str) {
        t9.i.h(str, "name");
        x(new r(i10, str));
    }

    public final Env m() {
        return this.f16364g;
    }

    public final String n(int i10) {
        String c02;
        l8.e eVar = this.f16359b[i10];
        return (eVar == null || (c02 = eVar.c0()) == null) ? "none" : c02;
    }

    public final long o(int i10) {
        l8.e eVar = this.f16359b[i10];
        if (eVar != null) {
            return eVar.V();
        }
        return -1L;
    }

    public final d8.c p(int i10) {
        l8.e eVar = this.f16359b[i10];
        if (eVar != null) {
            return eVar.f0();
        }
        return null;
    }

    public final String q() {
        return this.f16358a;
    }

    public final void r(String str, j8.a aVar, j8.b bVar) {
        t9.i.h(str, "workPath");
        t9.i.h(aVar, "playerCallback");
        t9.i.h(bVar, "rangerCallback");
        x(new c(str, aVar, bVar));
    }

    public final void s(int i10) {
        this.f16359b[i10] = new l8.e(i10);
        j8.a aVar = this.f16362e;
        if (aVar == null || this.f16363f == null) {
            return;
        }
        l8.e eVar = this.f16359b[i10];
        if (eVar != null) {
            if (aVar == null) {
                t9.i.q();
            }
            j8.b bVar = this.f16363f;
            if (bVar == null) {
                t9.i.q();
            }
            eVar.E0(aVar, bVar);
        }
        if (i10 == 0) {
            PreviewUtil previewUtil = PreviewUtil.INSTANCE;
            l8.e eVar2 = this.f16359b[i10];
            previewUtil.setPreviewCallback(eVar2 != null ? eVar2.h0() : null);
            ThumbnailRequest thumbnailRequest = ThumbnailRequest.INSTANCE;
            l8.e eVar3 = this.f16359b[i10];
            thumbnailRequest.setThumbnailCallback(eVar3 != null ? eVar3.h0() : null);
        }
    }

    public final boolean t(int i10) {
        l8.e eVar = this.f16359b[i10];
        if (eVar != null) {
            return eVar.o0();
        }
        return false;
    }

    public final void u(i8.d dVar, i8.e eVar, int i10) {
        t9.i.h(dVar, "obj");
        t9.i.h(eVar, "type");
        x(new e(dVar, eVar, i10));
    }

    public final void v(i8.d dVar, i8.e eVar, i8.c cVar) {
        t9.i.h(dVar, "obj");
        t9.i.h(eVar, "type");
        t9.i.h(cVar, "event");
        x(new d(dVar, eVar, cVar));
    }

    public final void w(int i10, String str) {
        t9.i.h(str, "name");
        x(new f(i10, str));
    }

    public final void x(Runnable runnable) {
        Handler handler = this.f16367j;
        if (handler != null) {
            handler.post(runnable);
        }
    }

    public final void y(int i10, String str, Program program, String str2) {
        t9.i.h(str, "name");
        t9.i.h(program, "program");
        t9.i.h(str2, "extra");
        x(new g(i10, str, program, str2));
    }

    public final void z(int i10, String str, Program program, String str2) {
        t9.i.h(str, "name");
        t9.i.h(program, "program");
        t9.i.h(str2, "extra");
        x(new RunnableC0284h(i10, str, program, str2));
    }

    public /* synthetic */ h(t9.g gVar) {
        this();
    }
}
