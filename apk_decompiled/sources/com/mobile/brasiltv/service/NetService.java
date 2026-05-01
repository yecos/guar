package com.mobile.brasiltv.service;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import b8.a;
import com.hpplay.sdk.source.common.global.Constant;
import com.mobile.brasiltv.app.App;
import com.mobile.brasiltv.bean.event.CheckHeartEvent;
import com.mobile.brasiltv.bean.event.LoginSuccessEvent;
import com.mobile.brasiltv.bean.event.NetworkEvent;
import com.mobile.brasiltv.bean.event.RemoteLoginEvent;
import com.mobile.brasiltv.service.NetService;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.utils.f1;
import com.mobile.brasiltv.utils.x;
import com.mobile.brasiltv.utils.y;
import com.umeng.analytics.pro.f;
import h9.t;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import java.util.concurrent.TimeUnit;
import mobile.com.requestframe.util.RemoteLoginAndMsgEvent;
import mobile.com.requestframe.utils.response.HeartBeatData;
import mobile.com.requestframe.utils.response.HeartBeatResult;
import s9.l;
import t9.g;
import t9.i;
import t9.j;
import w6.i;

/* loaded from: classes.dex */
public final class NetService extends Service {

    /* renamed from: h, reason: collision with root package name */
    public static final a f8586h = new a(null);

    /* renamed from: i, reason: collision with root package name */
    public static final String f8587i = "com.swl.amobile.service.netservice";

    /* renamed from: c, reason: collision with root package name */
    public Disposable f8590c;

    /* renamed from: g, reason: collision with root package name */
    public Disposable f8594g;

    /* renamed from: a, reason: collision with root package name */
    public String f8588a = "none";

    /* renamed from: b, reason: collision with root package name */
    public final e f8589b = new e();

    /* renamed from: d, reason: collision with root package name */
    public long f8591d = 120;

    /* renamed from: e, reason: collision with root package name */
    public final long f8592e = 5;

    /* renamed from: f, reason: collision with root package name */
    public final TimeUnit f8593f = TimeUnit.MINUTES;

    /* loaded from: classes3.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }

        public final Intent a() {
            Intent intent = new Intent(NetService.f8587i);
            intent.setPackage(App.f8263e.a().getPackageName());
            return intent;
        }
    }

    /* loaded from: classes3.dex */
    public static final class b extends j implements l {

        /* renamed from: a, reason: collision with root package name */
        public static final b f8595a = new b();

        public b() {
            super(1);
        }

        @Override // s9.l
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final ObservableSource invoke(Long l10) {
            i.g(l10, "it");
            return w6.i.f19214g.b().V1();
        }
    }

    /* loaded from: classes3.dex */
    public static final class c extends ha.a {

        public static final class a extends j implements l {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f8597a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(String str) {
                super(1);
                this.f8597a = str;
            }

            @Override // s9.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return t.f14242a;
            }

            public final void invoke(String str) {
                f1.f8649a.x(y.p(y.f8771a, this.f8597a, null, null, 6, null));
            }
        }

        public c() {
        }

        @Override // ha.a, io.reactivex.Observer
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void onNext(HeartBeatResult heartBeatResult) {
            i.g(heartBeatResult, "t");
            if (heartBeatResult.getData() == null) {
                b0.U(this, "心跳失败 返回的token为null");
                NetService netService = NetService.this;
                netService.j(netService.f8592e);
                return;
            }
            b0.U(this, "心跳成功");
            HeartBeatData data = heartBeatResult.getData();
            i.d(data);
            String userToken = data.getUserToken();
            boolean z10 = false;
            if (userToken != null) {
                if (!(userToken.length() == 0)) {
                    z10 = true;
                }
            }
            if (z10) {
                i.c cVar = w6.i.f19214g;
                HeartBeatData data2 = heartBeatResult.getData();
                t9.i.d(data2);
                String userToken2 = data2.getUserToken();
                t9.i.d(userToken2);
                cVar.z0(userToken2);
            }
            NetService netService2 = NetService.this;
            netService2.j(netService2.f8591d);
        }

        @Override // ha.a, io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            t9.i.g(disposable, "d");
            super.onSubscribe(disposable);
            NetService.this.f8590c = disposable;
        }

        @Override // ha.a
        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            b0.U(this, "心跳失败 " + str);
            x.f8754a.w(App.f8263e.a(), new a(str));
        }
    }

    /* loaded from: classes3.dex */
    public static final class d extends ha.a {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ CheckHeartEvent f8599b;

        public static final class a extends j implements l {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f8600a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(String str) {
                super(1);
                this.f8600a = str;
            }

            @Override // s9.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return t.f14242a;
            }

            public final void invoke(String str) {
                f1.f8649a.x(y.p(y.f8771a, this.f8600a, null, null, 6, null));
            }
        }

        public d(CheckHeartEvent checkHeartEvent) {
            this.f8599b = checkHeartEvent;
        }

        @Override // ha.a, io.reactivex.Observer
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void onNext(HeartBeatResult heartBeatResult) {
            String J;
            t9.i.g(heartBeatResult, "t");
            b0.U(this, "心跳正常");
            i.c cVar = w6.i.f19214g;
            HeartBeatData data = heartBeatResult.getData();
            if (data == null || (J = data.getUserToken()) == null) {
                J = cVar.J();
            }
            cVar.z0(J);
        }

        @Override // ha.a
        public void handleNeedToLogin(String str) {
            t9.i.g(str, "errorCode");
            if (t9.i.b(str, "aaa100028")) {
                xa.c.c().j(new RemoteLoginEvent(this.f8599b.getMsg()));
            } else {
                super.handleNeedToLogin(str);
            }
        }

        @Override // ha.a, io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            t9.i.g(disposable, "d");
            super.onSubscribe(disposable);
            NetService.this.f8594g = disposable;
        }

        @Override // ha.a
        public void sendRemoteLoginEvent(RemoteLoginAndMsgEvent remoteLoginAndMsgEvent) {
            xa.c.c().j(new RemoteLoginAndMsgEvent(this.f8599b.getMsg().getLoginIp(), this.f8599b.getMsg().getLoginTime(), this.f8599b.getMsg().getLoginCountry(), this.f8599b.getMsg().getLoginCity()));
        }

        @Override // ha.a
        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            b0.U(this, "心跳异常:" + str);
            x.f8754a.w(App.f8263e.a(), new a(str));
        }
    }

    /* loaded from: classes3.dex */
    public static final class e extends BroadcastReceiver {
        public e() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            t9.i.g(context, f.X);
            t9.i.g(intent, "intent");
            if (!t9.i.b(NetService.this.f8588a, "none")) {
                q8.e.d(NetService.this.f8588a, "stop");
            }
            a.C0074a c0074a = b8.a.f5079a;
            if (!c0074a.b(context)) {
                NetService.this.f8588a = "none";
                xa.c.c().j(new NetworkEvent(NetworkEvent.NetState.NO_NET));
            } else if (c0074a.c(context)) {
                q8.e.d("wlan", "start");
                NetService.this.f8588a = "wlan";
                xa.c.c().j(new NetworkEvent(NetworkEvent.NetState.WIFI));
            } else if (c0074a.a(context)) {
                q8.e.d("cellular", "start");
                NetService.this.f8588a = "cellular";
                xa.c.c().j(new NetworkEvent(NetworkEvent.NetState.MOBILE));
            }
        }
    }

    public static final ObservableSource k(l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        return (ObservableSource) lVar.invoke(obj);
    }

    @xa.j
    public final void handRemoteLoginEvent(CheckHeartEvent checkHeartEvent) {
        t9.i.g(checkHeartEvent, Constant.KEY_MSG);
        b0.U(this, "异地登录通知, 开始检查心跳是否异常...");
        Disposable disposable = this.f8594g;
        if (disposable != null) {
            disposable.dispose();
        }
        w6.i.f19214g.b().V1().subscribe(new d(checkHeartEvent));
    }

    public final void j(long j10) {
        Disposable disposable = this.f8590c;
        if (disposable != null) {
            disposable.dispose();
        }
        Observable<Long> timer = Observable.timer(j10, this.f8593f);
        final b bVar = b.f8595a;
        timer.flatMap(new Function() { // from class: v6.a
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource k10;
                k10 = NetService.k(l.this, obj);
                return k10;
            }
        }).subscribe(new c());
    }

    public final void l() {
        if (xa.c.c().h(this)) {
            return;
        }
        xa.c.c().o(this);
    }

    public final void m() {
        registerReceiver(this.f8589b, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }

    public final void n() {
        if (xa.c.c().h(this)) {
            xa.c.c().r(this);
        }
        Disposable disposable = this.f8590c;
        if (disposable != null) {
            disposable.dispose();
        }
        Disposable disposable2 = this.f8594g;
        if (disposable2 != null) {
            disposable2.dispose();
        }
    }

    public final void o() {
        unregisterReceiver(this.f8589b);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        t9.i.g(intent, "arg0");
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        m();
        l();
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        o();
        n();
    }

    @xa.j
    public final void receiveLoginEvent(LoginSuccessEvent loginSuccessEvent) {
        t9.i.g(loginSuccessEvent, "event");
        String heartBeatTime = loginSuccessEvent.getHeartBeatTime();
        if (!(heartBeatTime == null || heartBeatTime.length() == 0)) {
            String heartBeatTime2 = loginSuccessEvent.getHeartBeatTime();
            t9.i.d(heartBeatTime2);
            this.f8591d = Long.parseLong(heartBeatTime2);
        }
        b0.U(this, "登录成功, " + this.f8591d + " 分钟开始心跳");
        j(this.f8591d);
    }
}
