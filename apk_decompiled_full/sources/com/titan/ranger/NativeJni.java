package com.titan.ranger;

import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import com.google.gson.Gson;
import com.hpplay.component.common.dlna.IDLNAController;
import com.titan.ranger.bean.RangerResult;
import java.util.HashMap;

/* loaded from: classes3.dex */
public class NativeJni {

    /* renamed from: d, reason: collision with root package name */
    public static String f9456d;

    /* renamed from: e, reason: collision with root package name */
    public static NativeJni f9457e;

    /* renamed from: a, reason: collision with root package name */
    public final String f9458a = NativeJni.class.getSimpleName();

    /* renamed from: b, reason: collision with root package name */
    public Handler f9459b;

    /* renamed from: c, reason: collision with root package name */
    public HandlerThread f9460c;

    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f9461a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f9462b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ long f9463c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ long f9464d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ com.titan.ranger.c f9465e;

        public a(int i10, String str, long j10, long j11, com.titan.ranger.c cVar) {
            this.f9461a = i10;
            this.f9462b = str;
            this.f9463c = j10;
            this.f9464d = j11;
            this.f9465e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            NativeJni.this.a(IDLNAController.SEEK, com.titan.ranger.a.l(this.f9461a, this.f9462b, this.f9463c, this.f9464d));
            com.titan.ranger.c cVar = this.f9465e;
            if (cVar != null) {
                cVar.a("");
            }
        }
    }

    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f9467a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f9468b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f9469c;

        public b(int i10, String str, String str2) {
            this.f9467a = i10;
            this.f9468b = str;
            this.f9469c = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            NativeJni.this.a("SetMedia", com.titan.ranger.a.m(this.f9467a, this.f9468b, this.f9469c));
        }
    }

    public class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f9471a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f9472b;

        public c(int i10, String str) {
            this.f9471a = i10;
            this.f9472b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            NativeJni.this.a(IDLNAController.PAUSE, com.titan.ranger.a.j(this.f9471a, this.f9472b));
        }
    }

    public class d implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f9474a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f9475b;

        public d(int i10, String str) {
            this.f9474a = i10;
            this.f9475b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            NativeJni.this.a(IDLNAController.RESUME, com.titan.ranger.a.j(this.f9474a, this.f9475b));
        }
    }

    public class e implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f9477a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f9478b;

        public e(int i10, String str) {
            this.f9477a = i10;
            this.f9478b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            NativeJni.this.a("StopProgram", com.titan.ranger.a.j(this.f9477a, this.f9478b));
        }
    }

    public class f implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f9480a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f9481b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ long f9482c;

        public f(int i10, long j10, long j11) {
            this.f9480a = i10;
            this.f9481b = j10;
            this.f9482c = j11;
        }

        @Override // java.lang.Runnable
        public void run() {
            NativeJni.this.a("OnPlayBuffer", com.titan.ranger.a.e(this.f9480a, this.f9481b, this.f9482c));
        }
    }

    public static class g implements com.titan.ranger.c {
        @Override // com.titan.ranger.c
        public void a(String str) {
            NativeJni.f9456d = str;
        }
    }

    public class h implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f9484a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f9485b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f9486c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f9487d;

        public h(int i10, String str, String str2, int i11) {
            this.f9484a = i10;
            this.f9485b = str;
            this.f9486c = str2;
            this.f9487d = i11;
        }

        @Override // java.lang.Runnable
        public void run() {
            NativeJni.this.a("OnPlayerOperation", com.titan.ranger.a.g(this.f9484a, this.f9485b, this.f9486c, this.f9487d));
        }
    }

    public class i implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f9489a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f9490b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f9491c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f9492d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ long f9493e;

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ String f9494f;

        public i(int i10, String str, int i11, int i12, long j10, String str2) {
            this.f9489a = i10;
            this.f9490b = str;
            this.f9491c = i11;
            this.f9492d = i12;
            this.f9493e = j10;
            this.f9494f = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            NativeJni.this.a("OnPlayerEvent", com.titan.ranger.a.f(this.f9489a, this.f9490b, this.f9491c, this.f9492d, this.f9493e, this.f9494f));
        }
    }

    public class j implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f9496a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f9497b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f9498c;

        public j(int i10, String str, String str2) {
            this.f9496a = i10;
            this.f9497b = str;
            this.f9498c = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            NativeJni.this.a("OnMediaInfo", com.titan.ranger.a.c(this.f9496a, this.f9497b, this.f9498c));
        }
    }

    public class k implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f9500a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f9501b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f9502c;

        public k(int i10, String str, String str2) {
            this.f9500a = i10;
            this.f9501b = str;
            this.f9502c = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            NativeJni.this.a("OnPlayEvent", com.titan.ranger.a.d(this.f9500a, this.f9501b, this.f9502c));
        }
    }

    public class l implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f9504a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f9505b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f9506c;

        public l(String str, String str2, String str3) {
            this.f9504a = str;
            this.f9505b = str2;
            this.f9506c = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            NativeJni.this.a("OnSystemEvent", com.titan.ranger.a.h(this.f9504a, this.f9505b, this.f9506c));
        }
    }

    public class m implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f9508a;

        public m(String str) {
            this.f9508a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            HashMap hashMap = new HashMap();
            hashMap.put("work_path", this.f9508a);
            NativeJni.this.a("Init", m8.a.a().toJson(hashMap));
        }
    }

    public class n implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.titan.ranger.c f9510a;

        public n(com.titan.ranger.c cVar) {
            this.f9510a = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            String res = ((RangerResult) m8.a.a().fromJson(NativeJni.this.a("GetVersion", "{}"), RangerResult.class)).getRes();
            com.titan.ranger.c cVar = this.f9510a;
            if (cVar != null) {
                cVar.a(res);
            }
        }
    }

    public class o implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f9512a;

        public o(String str) {
            this.f9512a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            NativeJni.this.a("SetEnv", com.titan.ranger.a.b(this.f9512a));
        }
    }

    public class p implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f9514a;

        public p(String str) {
            this.f9514a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            NativeJni.this.a("SetEntries", com.titan.ranger.a.a(this.f9514a));
        }
    }

    public class q implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f9516a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f9517b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f9518c;

        public q(int i10, String str, int i11) {
            this.f9516a = i10;
            this.f9517b = str;
            this.f9518c = i11;
        }

        @Override // java.lang.Runnable
        public void run() {
            NativeJni.this.a("SetPlayer", com.titan.ranger.a.i(this.f9516a, this.f9517b, this.f9518c));
        }
    }

    public class r implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f9520a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f9521b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f9522c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f9523d;

        public r(int i10, String str, String str2, String str3) {
            this.f9520a = i10;
            this.f9521b = str;
            this.f9522c = str2;
            this.f9523d = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            NativeJni.this.a("PrepareProgram", com.titan.ranger.a.k(this.f9520a, this.f9521b, this.f9522c, this.f9523d));
        }
    }

    public class s implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f9525a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f9526b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f9527c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f9528d;

        public s(int i10, String str, String str2, String str3) {
            this.f9525a = i10;
            this.f9526b = str;
            this.f9527c = str2;
            this.f9528d = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            NativeJni.this.a("PrepareCast", com.titan.ranger.a.k(this.f9525a, this.f9526b, this.f9527c, this.f9528d));
        }
    }

    public class t implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f9530a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f9531b;

        public t(int i10, String str) {
            this.f9530a = i10;
            this.f9531b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            NativeJni.this.a("StopCast", com.titan.ranger.a.j(this.f9530a, this.f9531b));
        }
    }

    static {
        System.loadLibrary("ranger-jni");
        System.loadLibrary("c++_shared");
        f9456d = "";
    }

    public NativeJni() {
        HandlerThread handlerThread = new HandlerThread("handlerRanger");
        this.f9460c = handlerThread;
        handlerThread.start();
        this.f9459b = new Handler(this.f9460c.getLooper());
    }

    private native String Call(String str, String str2);

    public static NativeJni c() {
        if (f9457e == null) {
            synchronized (NativeJni.class) {
                if (f9457e == null) {
                    NativeJni nativeJni = new NativeJni();
                    f9457e = nativeJni;
                    nativeJni.d(new g());
                }
            }
        }
        return f9457e;
    }

    public final String a(String str, String str2) {
        return Call(str, str2);
    }

    public void d(com.titan.ranger.c cVar) {
        this.f9459b.post(new n(cVar));
    }

    public void e(int i10, String str, com.titan.ranger.b bVar) {
        String a10 = a("GetStatus", com.titan.ranger.a.j(i10, str));
        Gson a11 = m8.a.a();
        Status status = (Status) a11.fromJson(((RangerResult) a11.fromJson(a10, RangerResult.class)).getRes(), Status.class);
        if (bVar != null) {
            bVar.a(status);
        }
    }

    public void f(String str) {
        Handler handler = this.f9459b;
        if (handler == null) {
            Log.e(this.f9458a, "threadHandler is not initialized");
        } else {
            handler.post(new m(str));
        }
    }

    public void g(int i10, String str, int i11) {
        this.f9459b.post(new q(i10, str, i11));
    }

    public void h(int i10, String str, String str2) {
        this.f9459b.post(new j(i10, str, str2));
    }

    public void i(int i10, String str, String str2) {
        this.f9459b.post(new k(i10, str, str2));
    }

    public void j(int i10, long j10, long j11) {
        this.f9459b.post(new f(i10, j10, j11));
    }

    public void k(int i10, String str, int i11, int i12, long j10, String str2) {
        this.f9459b.post(new i(i10, str, i11, i12, j10, str2));
    }

    public void l(int i10, String str, String str2, int i11) {
        this.f9459b.post(new h(i10, str, str2, i11));
    }

    public void m(String str, String str2, String str3) {
        this.f9459b.post(new l(str, str2, str3));
    }

    public void n(int i10, String str) {
        this.f9459b.post(new c(i10, str));
    }

    public void o(int i10, String str, String str2, String str3) {
        this.f9459b.post(new s(i10, str, str2, str3));
    }

    public void p(int i10, String str, String str2, String str3) {
        this.f9459b.post(new r(i10, str, str2, str3));
    }

    public void q(int i10, String str) {
        this.f9459b.post(new d(i10, str));
    }

    public void r(int i10, String str, long j10, long j11, com.titan.ranger.c cVar) {
        this.f9459b.post(new a(i10, str, j10, j11, cVar));
    }

    public void s(String str) {
        this.f9459b.post(new p(str));
    }

    public void t(int i10, String str, String str2) {
        this.f9459b.post(new b(i10, str, str2));
    }

    public void u(String str) {
        this.f9459b.post(new o(str));
    }

    public void v(int i10, String str) {
        this.f9459b.post(new t(i10, str));
    }

    public void w(int i10, String str) {
        this.f9459b.post(new e(i10, str));
    }
}
