package f5;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.hpplay.sdk.source.common.global.Constant;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.activity.MainAty;
import com.mobile.brasiltv.activity.SplashAty;
import com.mobile.brasiltv.app.App;
import com.mobile.brasiltv.bean.event.ReCreateEvent;
import com.mobile.brasiltv.bean.event.RemoteLoginEvent;
import com.mobile.brasiltv.mine.activity.LoginAty;
import com.mobile.brasiltv.utils.f1;
import com.mobile.brasiltv.view.BlackListDialog;
import com.mobile.brasiltv.view.LoadingView;
import com.mobile.brasiltv.view.dialog.DialogManager;
import com.mobile.brasiltv.view.dialog.RemoteLoginTipDialog;
import com.msandroid.mobile.R;
import com.umeng.analytics.MobclickAgent;
import com.umeng.message.PushAgent;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import mobile.com.requestframe.util.RemoteLoginAndMsgEvent;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: classes.dex */
public abstract class c extends i5.a implements View.OnClickListener {

    /* renamed from: c, reason: collision with root package name */
    public boolean f13111c;

    /* renamed from: d, reason: collision with root package name */
    public Toast f13112d;

    /* renamed from: e, reason: collision with root package name */
    public RemoteLoginTipDialog f13113e;

    /* renamed from: f, reason: collision with root package name */
    public RemoteLoginTipDialog f13114f;

    /* renamed from: g, reason: collision with root package name */
    public BlackListDialog f13115g;

    /* renamed from: h, reason: collision with root package name */
    public LoadingView f13116h;

    /* renamed from: j, reason: collision with root package name */
    public Map f13118j = new LinkedHashMap();

    /* renamed from: i, reason: collision with root package name */
    public final h9.g f13117i = h9.h.b(new d());

    /* loaded from: classes3.dex */
    public static final class a extends t9.j implements s9.l {

        /* renamed from: a, reason: collision with root package name */
        public static final a f13119a = new a();

        public a() {
            super(1);
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Long) obj);
            return h9.t.f14242a;
        }

        public final void invoke(Long l10) {
            ma.l.a("dispatch");
            ma.h hVar = ma.h.f16853a;
            App.a aVar = App.f8263e;
            App a10 = aVar.a();
            String packageName = aVar.a().getPackageName();
            t9.i.f(packageName, "App.instance.getPackageName()");
            hVar.d(a10, packageName);
        }
    }

    /* loaded from: classes3.dex */
    public static final class b extends t9.j implements s9.l {

        /* renamed from: a, reason: collision with root package name */
        public static final b f13120a = new b();

        public b() {
            super(1);
        }

        @Override // s9.l
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Intent invoke(Intent intent) {
            t9.i.g(intent, "it");
            Intent putExtra = intent.putExtra("can_back", false);
            t9.i.f(putExtra, "it.putExtra(LoginAty.CAN_BACK, false)");
            return putExtra;
        }
    }

    /* renamed from: f5.c$c, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0217c extends t9.j implements s9.l {

        /* renamed from: a, reason: collision with root package name */
        public static final C0217c f13121a = new C0217c();

        public C0217c() {
            super(1);
        }

        @Override // s9.l
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Intent invoke(Intent intent) {
            t9.i.g(intent, "it");
            Intent putExtra = intent.putExtra("can_back", false);
            t9.i.f(putExtra, "it.putExtra(LoginAty.CAN_BACK, false)");
            return putExtra;
        }
    }

    /* loaded from: classes3.dex */
    public static final class d extends t9.j implements s9.a {
        public d() {
            super(0);
        }

        @Override // s9.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final com.mobile.brasiltv.utils.c invoke() {
            return new com.mobile.brasiltv.utils.c(c.this);
        }
    }

    /* loaded from: classes3.dex */
    public static final class e extends t9.j implements s9.l {

        /* renamed from: a, reason: collision with root package name */
        public static final e f13123a = new e();

        public e() {
            super(1);
        }

        @Override // s9.l
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Intent invoke(Intent intent) {
            t9.i.g(intent, "it");
            Intent putExtra = intent.putExtra("can_back", false);
            t9.i.f(putExtra, "it.putExtra(LoginAty.CAN_BACK, false)");
            return putExtra;
        }
    }

    public static final void K2(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void P2(c cVar, DialogInterface dialogInterface) {
        t9.i.g(cVar, "this$0");
        cVar.f13116h = null;
        cVar.N2();
    }

    public final void J2() {
        RemoteLoginTipDialog remoteLoginTipDialog = this.f13113e;
        if (remoteLoginTipDialog != null) {
            remoteLoginTipDialog.dismiss();
        }
        RemoteLoginTipDialog remoteLoginTipDialog2 = this.f13114f;
        if (remoteLoginTipDialog2 != null) {
            remoteLoginTipDialog2.dismiss();
        }
        BlackListDialog blackListDialog = this.f13115g;
        if (blackListDialog != null) {
            blackListDialog.dismiss();
        }
    }

    public final BlackListDialog L2() {
        return this.f13115g;
    }

    public final com.mobile.brasiltv.utils.c M2() {
        return (com.mobile.brasiltv.utils.c) this.f13117i.getValue();
    }

    public void N2() {
    }

    public final void O2(boolean z10) {
        if (this.f13116h == null) {
            this.f13116h = LoadingView.Companion.create$default(LoadingView.Companion, this, false, false, new DialogInterface.OnDismissListener() { // from class: f5.b
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    c.P2(c.this, dialogInterface);
                }
            }, 6, null);
            h9.t tVar = h9.t.f14242a;
        }
        if (z10) {
            LoadingView loadingView = this.f13116h;
            if (loadingView != null) {
                loadingView.show();
                return;
            }
            return;
        }
        LoadingView loadingView2 = this.f13116h;
        if (loadingView2 != null) {
            loadingView2.dismiss();
        }
    }

    public final void Q2(String str, int i10) {
        t9.i.g(str, "info");
        if (isFinishing()) {
            return;
        }
        Toast toast = this.f13112d;
        if (toast != null) {
            toast.cancel();
        }
        this.f13112d = new Toast(Q1());
        View inflate = LayoutInflater.from(Q1()).inflate(R.layout.toast_koocan_white_center, (ViewGroup) null);
        ((TextView) inflate.findViewById(R$id.mTvToast)).setText(str);
        Toast toast2 = this.f13112d;
        if (toast2 != null) {
            toast2.setView(inflate);
        }
        r2.a.a(this.f13112d);
        Toast toast3 = this.f13112d;
        if (toast3 != null) {
            toast3.setDuration(i10);
        }
        Toast toast4 = this.f13112d;
        if (toast4 != null) {
            toast4.show();
        }
    }

    @Override // androidx.appcompat.app.d, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        t9.i.g(context, "newBase");
        super.attachBaseContext(context);
    }

    @xa.j(threadMode = ThreadMode.MAIN)
    public final void blackList(ma.e eVar) {
        t9.i.g(eVar, "event");
        boolean z10 = this instanceof MainAty;
        BlackListDialog blackListDialog = new BlackListDialog(this, w6.i.f19214g.H(), z10);
        this.f13115g = blackListDialog;
        if (z10) {
            com.mobile.brasiltv.utils.b0.S(blackListDialog, DialogManager.DIALOG_BLACK_LIST);
        } else {
            blackListDialog.show();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        t9.i.g(motionEvent, "ev");
        if (motionEvent.getToolType(motionEvent.getPointerCount() - 1) != 3) {
            return super.dispatchTouchEvent(motionEvent);
        }
        com.mobile.brasiltv.utils.i1.M(Q1(), "2");
        f1.a.p(com.mobile.brasiltv.utils.f1.f8649a, this, "EA31 " + com.mobile.brasiltv.utils.x.f8754a.y(Q1(), R.string.contact_seller), 0, 4, null);
        Observable<Long> subscribeOn = Observable.timer(2L, TimeUnit.SECONDS).subscribeOn(Schedulers.computation());
        final a aVar = a.f13119a;
        subscribeOn.subscribe(new Consumer() { // from class: f5.a
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                c.K2(s9.l.this, obj);
            }
        });
        return true;
    }

    @xa.j(threadMode = ThreadMode.MAIN)
    public final void needToLogin(ma.n nVar) {
        t9.i.g(nVar, "event");
        new IllegalStateException("查看登陆问题");
        com.mobile.brasiltv.utils.b0.d0(this, LoginAty.class, b.f13120a);
    }

    @xa.j(threadMode = ThreadMode.MAIN)
    public final void notifyTokenInvalid(ma.s sVar) {
        t9.i.g(sVar, "event");
        com.mobile.brasiltv.utils.b0.d0(this, LoginAty.class, C0217c.f13121a);
    }

    public void onClick(View view) {
        t9.i.g(view, "view");
    }

    @Override // i5.a, u8.a, androidx.appcompat.app.d, androidx.fragment.app.e, androidx.activity.ComponentActivity, o.p, android.app.Activity
    public void onCreate(Bundle bundle) {
        com.mobile.brasiltv.utils.a.b().f(this);
        super.onCreate(bundle);
        if (bundle == null || (!(TextUtils.isEmpty(ha.b.f14245a.a()) || t2.a.f18798a.d() == null) || (this instanceof SplashAty))) {
            if (!xa.c.c().h(this)) {
                xa.c.c().o(this);
            }
            PushAgent.getInstance(this).onAppStart();
            ma.b.f16848a.a(this);
            return;
        }
        if (this instanceof MainAty) {
            bundle.remove("android:support:fragments");
        }
        com.mobile.brasiltv.utils.d.f8644a.a(this);
        finish();
    }

    @Override // u8.a, androidx.appcompat.app.d, androidx.fragment.app.e, android.app.Activity
    public void onDestroy() {
        com.mobile.brasiltv.utils.a.b().d(this);
        if (xa.c.c().h(this)) {
            xa.c.c().r(this);
        }
        c2.i.f5350q.a().n();
        ma.b.f16848a.d(this);
        super.onDestroy();
    }

    @Override // u8.a, androidx.fragment.app.e, android.app.Activity
    public void onPause() {
        super.onPause();
        this.f13111c = false;
        String simpleName = getClass().getSimpleName();
        t9.i.f(simpleName, "javaClass.simpleName");
        if (!ba.t.o(simpleName, "MainAty", false, 2, null)) {
            MobclickAgent.onPageEnd(getClass().getSimpleName());
        }
        MobclickAgent.onPause(this);
        c2.i.f5350q.a().o(this);
    }

    @Override // u8.a, androidx.fragment.app.e, android.app.Activity
    public void onResume() {
        super.onResume();
        this.f13111c = true;
        String simpleName = getClass().getSimpleName();
        t9.i.f(simpleName, "javaClass.simpleName");
        if (!ba.t.o(simpleName, "MainAty", false, 2, null)) {
            MobclickAgent.onPageStart(getClass().getSimpleName());
        }
        MobclickAgent.onResume(this);
        c2.i.f5350q.a().p(this);
    }

    @xa.j
    public final void receiveLoginEvent(ReCreateEvent reCreateEvent) {
        t9.i.g(reCreateEvent, "event");
        recreate();
    }

    @Override // androidx.appcompat.app.d, androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(int i10) {
        super.setContentView(i10);
    }

    @xa.j(threadMode = ThreadMode.MAIN)
    public final void showRemoteLoginTip(RemoteLoginEvent remoteLoginEvent) {
        t9.i.g(remoteLoginEvent, Constant.KEY_MSG);
        if (this.f13111c) {
            RemoteLoginTipDialog remoteLoginTipDialog = new RemoteLoginTipDialog(this);
            this.f13113e = remoteLoginTipDialog;
            remoteLoginTipDialog.show(remoteLoginEvent.getMsg(), this instanceof MainAty);
        }
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

    @xa.j(threadMode = ThreadMode.MAIN)
    public final void verifyTokenError(ma.u uVar) {
        t9.i.g(uVar, "event");
        new IllegalStateException("查看token验证问题");
        com.mobile.brasiltv.utils.b0.d0(this, LoginAty.class, e.f13123a);
    }

    public final void z0(String str) {
        t9.i.g(str, "info");
        Q2(str, 0);
    }

    @xa.j(threadMode = ThreadMode.MAIN)
    public final void showRemoteLoginTip(RemoteLoginAndMsgEvent remoteLoginAndMsgEvent) {
        t9.i.g(remoteLoginAndMsgEvent, "event");
        if (this.f13111c) {
            RemoteLoginTipDialog remoteLoginTipDialog = this.f13114f;
            if (remoteLoginTipDialog != null && remoteLoginTipDialog.isShowing()) {
                if (this instanceof MainAty) {
                    com.mobile.brasiltv.utils.b0.j(remoteLoginTipDialog);
                } else {
                    remoteLoginTipDialog.dismiss();
                }
            }
            RemoteLoginTipDialog remoteLoginTipDialog2 = new RemoteLoginTipDialog(this);
            this.f13114f = remoteLoginTipDialog2;
            remoteLoginTipDialog2.show(remoteLoginAndMsgEvent.getLoginCountry(), remoteLoginAndMsgEvent.getLoginCity(), remoteLoginAndMsgEvent.getLoginIp(), remoteLoginAndMsgEvent.getLoginTime(), this instanceof MainAty);
        }
    }
}
