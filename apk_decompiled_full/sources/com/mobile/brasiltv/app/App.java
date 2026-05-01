package com.mobile.brasiltv.app;

import android.app.Notification;
import android.content.Context;
import android.content.ServiceConnection;
import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.installations.FirebaseInstallations;
import com.google.gson.Gson;
import com.hpplay.sdk.source.common.global.Constant;
import com.mobile.brasiltv.app.App;
import com.mobile.brasiltv.base.BaseAPP;
import com.mobile.brasiltv.bean.event.CheckHeartEvent;
import com.mobile.brasiltv.bean.event.LoginSuccessEvent;
import com.mobile.brasiltv.db.MobileDao;
import com.mobile.brasiltv.db.UmengMessage;
import com.mobile.brasiltv.db.VodDao;
import com.taobao.accs.AccsClientConfig;
import com.taobao.accs.common.Constants;
import com.umeng.analytics.MobclickAgent;
import com.umeng.message.PushAgent;
import com.umeng.message.api.UPushAliasCallback;
import com.umeng.message.api.UPushMessageHandler;
import com.umeng.message.entity.UMessage;
import com.umeng.umcrash.UMCrash;
import com.umeng.umcrash.UMCrashCallback;
import com.zhy.autolayout.config.AutoLayoutConifg;
import h9.h;
import m7.f;
import ma.l;
import ma.o;
import o8.k;
import t9.i;
import t9.j;
import w6.i;

/* loaded from: classes.dex */
public final class App extends BaseAPP {

    /* renamed from: e, reason: collision with root package name */
    public static final a f8263e = new a(null);

    /* renamed from: f, reason: collision with root package name */
    public static App f8264f;

    /* renamed from: a, reason: collision with root package name */
    public final h9.g f8265a = h.b(new d());

    /* renamed from: b, reason: collision with root package name */
    public final h9.g f8266b = h.b(new c());

    /* renamed from: c, reason: collision with root package name */
    public final h9.g f8267c = h.b(new e());

    /* renamed from: d, reason: collision with root package name */
    public long f8268d;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(t9.g gVar) {
            this();
        }

        public final App a() {
            App app = App.f8264f;
            if (app != null) {
                return app;
            }
            i.w("instance");
            return null;
        }

        public final void b(App app) {
            i.g(app, "<set-?>");
            App.f8264f = app;
        }
    }

    public static final class b extends k7.a {
        public b(k7.h hVar) {
            super(hVar);
        }

        @Override // k7.c
        public boolean b(int i10, String str) {
            return false;
        }
    }

    public static final class c extends j implements s9.a {
        public c() {
            super(0);
        }

        @Override // s9.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final VodDao invoke() {
            return new VodDao(App.this);
        }
    }

    public static final class d extends j implements s9.a {
        public d() {
            super(0);
        }

        @Override // s9.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final MobileDao invoke() {
            return new MobileDao(App.this);
        }
    }

    public static final class e extends j implements s9.a {
        public e() {
            super(0);
        }

        @Override // s9.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final com.mobile.brasiltv.utils.c invoke() {
            return new com.mobile.brasiltv.utils.c(App.this);
        }
    }

    public static final class f implements f.d {
        @Override // m7.f.d
        public void a(PushAgent pushAgent, String str) {
            i.g(str, "deviceToken");
        }

        @Override // m7.f.d
        public void b(PushAgent pushAgent) {
            i.g(pushAgent, "mPushAgent");
            pushAgent.setNotificationOnForeground(false);
            pushAgent.setNotificationPlaySound(1);
        }

        @Override // m7.f.d
        public void c(PushAgent pushAgent, String str, String str2) {
        }
    }

    public static final class g extends m7.e {
        @Override // m7.e
        public Notification c(Context context, UMessage uMessage) {
            Notification c10 = super.c(context, uMessage);
            i.f(c10, "super.getNotification(context, msg)");
            return c10;
        }

        @Override // m7.e
        public void d(Context context, UMessage uMessage) {
            i.g(context, com.umeng.analytics.pro.f.X);
            i.g(uMessage, Constant.KEY_MSG);
            try {
                UmengMessage umengMessage = (UmengMessage) new Gson().fromJson(uMessage.custom, UmengMessage.class);
                umengMessage.setMsgId(uMessage.msg_id);
                umengMessage.setTicker(uMessage.ticker);
                umengMessage.setTitle(uMessage.title);
                umengMessage.setText(uMessage.text);
                umengMessage.setMessageTime(y6.a.c());
                UmengMessage.Companion companion = UmengMessage.Companion;
                umengMessage.setStatus(companion.getUN_READ());
                if (i.b(companion.getTYPE_LOGIN(), umengMessage.getMessageType())) {
                    xa.c c10 = xa.c.c();
                    i.f(umengMessage, Constants.SHARED_MESSAGE_ID_FILE);
                    c10.j(new CheckHeartEvent(umengMessage));
                }
            } catch (Exception e10) {
                e10.printStackTrace();
            }
            super.d(context, uMessage);
        }
    }

    public App() {
        f8263e.b(this);
    }

    public static final void h(Task task) {
        i.g(task, "task");
        if (!task.isSuccessful()) {
            task.getException();
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("firebase id=");
        sb.append((String) task.getResult());
        na.a.i((String) task.getResult());
    }

    public static final void o(App app) {
        i.g(app, "this$0");
        app.s();
        q8.e.a("start");
    }

    public static final void p(App app, boolean z10, String str) {
        i.g(app, "this$0");
    }

    public static final void q(App app, boolean z10, String str) {
        i.g(app, "this$0");
    }

    public static final void t(App app, Context context, UMessage uMessage) {
        i.g(app, "this$0");
        i.g(context, "p0");
        i.g(uMessage, "p1");
    }

    public static final String u() {
        return d6.b.f12660a.l() + "_" + l.b();
    }

    @Override // android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        if (com.mobile.brasiltv.utils.e.d(this)) {
            o0.a.l(this);
        }
    }

    public final void g() {
        FirebaseInstallations.getInstance().getId().addOnCompleteListener(new OnCompleteListener() { // from class: h5.d
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                App.h(task);
            }
        });
    }

    public final MobileDao i() {
        return (MobileDao) this.f8265a.getValue();
    }

    public final com.mobile.brasiltv.utils.c j() {
        return (com.mobile.brasiltv.utils.c) this.f8267c.getValue();
    }

    public final void k() {
        AutoLayoutConifg.getInstance().useDeviceSize().init(this);
    }

    public final void l() {
        ja.b.f14706f.b(this);
    }

    public final void m() {
        s6.a aVar = s6.a.f18777a;
        v7.b.f19124a = aVar.a().j();
        v7.b.f19125b = aVar.a().k();
    }

    public final void n() {
        k7.f.a(new b(k7.h.k().b(false).c("MobileLog").a()));
    }

    @Override // com.mobile.brasiltv.base.BaseAPP, android.app.Application
    public void onCreate() {
        super.onCreate();
        m7.f.d(this);
        if (!com.mobile.brasiltv.utils.e.d(this)) {
            s();
            return;
        }
        n2.a.a(this);
        q8.a.b(this);
        this.f8268d = System.currentTimeMillis() / 1000;
        na.a.f17333a = this;
        g8.a.f14066a.b(this);
        s6.a.f18777a.b(new e5.a());
        m();
        n();
        k();
        new Thread(new Runnable() { // from class: h5.c
            @Override // java.lang.Runnable
            public final void run() {
                App.o(App.this);
            }
        }).start();
        l8.h a10 = l8.h.f16357m.a();
        String absolutePath = getApplicationContext().getDir("luna", 0).getAbsolutePath();
        i.f(absolutePath, "this.applicationContext.…ODE_PRIVATE).absolutePath");
        k kVar = k.f17660a;
        a10.r(absolutePath, kVar.f(), kVar.g());
        r();
        c6.a.a().b(this);
        g();
        l();
        c2.i.f5350q.a().k(this, false, (r16 & 4) != 0 ? null : null, (r16 & 8) != 0 ? null : null, new o(this), new ma.c(this));
        t2.a.f18798a.l(this);
    }

    @Override // android.app.Application
    public void onTerminate() {
        super.onTerminate();
        if (xa.c.c().h(this)) {
            xa.c.c().r(this);
        }
        q8.e.a("stop");
    }

    @Override // android.app.Application, android.content.ComponentCallbacks2
    public void onTrimMemory(int i10) {
        super.onTrimMemory(i10);
        Glide.get(this).trimMemory(i10);
    }

    public final void r() {
        if (xa.c.c().h(this)) {
            return;
        }
        xa.c.c().o(this);
    }

    @xa.j
    public final void registPushTagAndAlias(LoginSuccessEvent loginSuccessEvent) {
        i.g(loginSuccessEvent, "event");
        PushAgent pushAgent = PushAgent.getInstance(this);
        i.c cVar = w6.i.f19214g;
        pushAgent.setAlias(cVar.H(), "userId", new UPushAliasCallback() { // from class: h5.a
            @Override // com.umeng.message.api.UPushAliasCallback
            public final void onMessage(boolean z10, String str) {
                App.p(App.this, z10, str);
            }
        });
        PushAgent.getInstance(this).setAlias(cVar.E(), "sn", new UPushAliasCallback() { // from class: h5.b
            @Override // com.umeng.message.api.UPushAliasCallback
            public final void onMessage(boolean z10, String str) {
                App.q(App.this, z10, str);
            }
        });
    }

    public final void s() {
        MobclickAgent.setPageCollectionMode(MobclickAgent.PageMode.LEGACY_MANUAL);
        String b10 = a5.g.b(this);
        if (b10 == null) {
            b10 = AccsClientConfig.DEFAULT_CONFIGTAG;
        }
        m7.f.b(this, com.mobile.brasiltv.utils.e.c(this, "UMENG_APPKEY"), b10, m7.a.DEVICE_TYPE_PHONE, com.mobile.brasiltv.utils.e.c(this, "UMENG_MSG_SECRET"), new f(), "com.mobile.brasiltv");
        m7.f.e(new g());
        PushAgent.getInstance(this).setNotificationClickHandler(new UPushMessageHandler() { // from class: h5.e
            @Override // com.umeng.message.api.UPushMessageHandler
            public final void handleMessage(Context context, UMessage uMessage) {
                App.t(App.this, context, uMessage);
            }
        });
        UMCrash.registerUMCrashCallback(new UMCrashCallback() { // from class: h5.f
            @Override // com.umeng.umcrash.UMCrashCallback
            public final String onCallback() {
                String u10;
                u10 = App.u();
                return u10;
            }
        });
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void unbindService(ServiceConnection serviceConnection) {
        t9.i.g(serviceConnection, "conn");
        try {
            super.unbindService(serviceConnection);
        } catch (IllegalArgumentException e10) {
            e10.printStackTrace();
        }
    }
}
