package k6;

import android.app.Dialog;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import anet.channel.util.Utils;
import b6.z;
import c2.i;
import com.dcs.bean.DomainInfo;
import com.google.android.gms.cast.framework.CastContext;
import com.google.android.gms.cast.framework.SessionManager;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.dynamiclinks.PendingDynamicLinkData;
import com.google.firebase.dynamiclinks.ktx.FirebaseDynamicLinksKt;
import com.google.firebase.ktx.Firebase;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mobile.bean.UpdateBean;
import com.mobile.brasiltv.activity.MainAty;
import com.mobile.brasiltv.app.App;
import com.mobile.brasiltv.bean.MainTabEntity;
import com.mobile.brasiltv.bean.MemberInfo;
import com.mobile.brasiltv.bean.RootColumnId;
import com.mobile.brasiltv.bean.event.CancelFreezeAtyEvent;
import com.mobile.brasiltv.bean.event.CastToCloseOtherPlayEvent;
import com.mobile.brasiltv.bean.event.CloseForcePageEvent;
import com.mobile.brasiltv.bean.event.GetFreeTimeEvent;
import com.mobile.brasiltv.bean.event.HasNewUpdateEvent;
import com.mobile.brasiltv.bean.event.HomePageAdEvent;
import com.mobile.brasiltv.bean.event.InterstitialEvent;
import com.mobile.brasiltv.bean.event.LoginSuccessEvent;
import com.mobile.brasiltv.bean.event.RequestActiveEvent;
import com.mobile.brasiltv.bean.event.RequestAuthAndSlbEvent;
import com.mobile.brasiltv.bean.event.UpdateMineViewEvent;
import com.mobile.brasiltv.bean.event.UpdateRestrictEvent;
import com.mobile.brasiltv.db.MobileDao;
import com.mobile.brasiltv.db.SwitchAccountBean;
import com.mobile.brasiltv.mine.activity.ForceChangePwdAty;
import com.mobile.brasiltv.mine.activity.LoginAty;
import com.mobile.brasiltv.service.NetService;
import com.mobile.brasiltv.utils.CheckNoticeUtils;
import com.mobile.brasiltv.view.NoticeDialog;
import com.mobile.brasiltv.view.dialog.DialogManager;
import com.mobile.brasiltv.view.dialog.NumberLimitDialog;
import com.mobile.brasiltv.view.dialog.VersionForbiddenDialog;
import com.msandroid.mobile.R;
import com.taobao.accs.common.Constants;
import com.titans.entity.CdnType;
import com.umeng.analytics.pro.bt;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import k6.b1;
import mobile.com.requestframe.utils.bean.LoginThirdPartBean;
import mobile.com.requestframe.utils.bean.SnTokenBean;
import mobile.com.requestframe.utils.response.ActiveResult;
import mobile.com.requestframe.utils.response.ApkQueryCouponResult;
import mobile.com.requestframe.utils.response.BaseResult;
import mobile.com.requestframe.utils.response.CheckForceBindResult;
import mobile.com.requestframe.utils.response.ChildColumnList;
import mobile.com.requestframe.utils.response.ColumnContentsBean;
import mobile.com.requestframe.utils.response.CouponCodeList;
import mobile.com.requestframe.utils.response.ForceBindData;
import mobile.com.requestframe.utils.response.FreeResult;
import mobile.com.requestframe.utils.response.GetAuthInfoData;
import mobile.com.requestframe.utils.response.GetAuthInfoResult;
import mobile.com.requestframe.utils.response.GetHomeData;
import mobile.com.requestframe.utils.response.GetHomeResult;
import mobile.com.requestframe.utils.response.HomeRecommend;
import mobile.com.requestframe.utils.response.LoginResult;
import mobile.com.requestframe.utils.response.QueryCouponData;
import mobile.com.requestframe.utils.response.SnTokenData;
import mobile.com.requestframe.utils.response.SnTokenResult;
import mobile.com.requestframe.utils.response.ThirdPartResult;
import mobile.com.requestframe.utils.response.UserData;
import w6.i;

/* loaded from: classes.dex */
public final class b1 implements i6.u {

    /* renamed from: a, reason: collision with root package name */
    public final f5.c f15033a;

    /* renamed from: b, reason: collision with root package name */
    public final i6.v f15034b;

    /* renamed from: c, reason: collision with root package name */
    public final String f15035c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f15036d;

    /* renamed from: e, reason: collision with root package name */
    public Disposable f15037e;

    /* renamed from: f, reason: collision with root package name */
    public NoticeDialog f15038f;

    /* renamed from: g, reason: collision with root package name */
    public final h9.g f15039g;

    /* renamed from: h, reason: collision with root package name */
    public final h9.g f15040h;

    /* renamed from: i, reason: collision with root package name */
    public long f15041i;

    /* renamed from: j, reason: collision with root package name */
    public final h9.g f15042j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f15043k;

    /* renamed from: l, reason: collision with root package name */
    public HashMap f15044l;

    /* renamed from: m, reason: collision with root package name */
    public BroadcastReceiver f15045m;

    /* renamed from: n, reason: collision with root package name */
    public Integer f15046n;

    /* loaded from: classes3.dex */
    public static final class a extends ha.a {

        /* renamed from: k6.b1$a$a, reason: collision with other inner class name */
        public static final class C0248a extends t9.j implements s9.l {

            /* renamed from: a, reason: collision with root package name */
            public static final C0248a f15048a = new C0248a();

            public C0248a() {
                super(1);
            }

            @Override // s9.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return h9.t.f14242a;
            }

            public final void invoke(String str) {
                com.mobile.brasiltv.utils.f1.f8649a.x(com.mobile.brasiltv.utils.y.p(com.mobile.brasiltv.utils.y.f8771a, "CUSTOM_NO_ASSOCIATED_PORTAL", null, null, 6, null));
            }
        }

        public static final class b extends t9.j implements s9.l {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f15049a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(String str) {
                super(1);
                this.f15049a = str;
            }

            @Override // s9.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return h9.t.f14242a;
            }

            public final void invoke(String str) {
                com.mobile.brasiltv.utils.y yVar = com.mobile.brasiltv.utils.y.f8771a;
                com.mobile.brasiltv.utils.f1.f8649a.x(com.mobile.brasiltv.utils.y.p(yVar, this.f15049a, yVar.a(), null, 4, null));
            }
        }

        public a() {
        }

        @Override // ha.a, io.reactivex.Observer
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void onNext(ActiveResult activeResult) {
            t9.i.g(activeResult, "t");
            super.onNext(activeResult);
            UserData data = activeResult.getData();
            if (!com.mobile.brasiltv.utils.b0.I(data != null ? data.getPortalCodeList() : null)) {
                com.mobile.brasiltv.utils.x.f8754a.w(b1.this.t0(), C0248a.f15048a);
                return;
            }
            i.c cVar = w6.i.f19214g;
            if (!t9.i.b(cVar.A(), "")) {
                UserData data2 = activeResult.getData();
                t9.i.d(data2);
                if (!t9.i.b(data2.getRestrictedStatus(), cVar.A())) {
                    xa.c c10 = xa.c.c();
                    UserData data3 = activeResult.getData();
                    t9.i.d(data3);
                    c10.m(new UpdateRestrictEvent(data3.getRestrictedStatus(), false, 2, null));
                }
            }
            d6.b bVar = d6.b.f12660a;
            f5.c t02 = b1.this.t0();
            UserData data4 = activeResult.getData();
            t9.i.d(data4);
            bVar.F(t02, data4, "", "", (r21 & 16) != 0 ? "" : null, (r21 & 32) != 0 ? "" : null, (r21 & 64) != 0 ? "" : null, (r21 & 128) != 0);
            if (TextUtils.isEmpty(cVar.E())) {
                if (cVar.F().length() > 0) {
                    com.mobile.brasiltv.utils.i1.G(b1.this.t0(), CdnType.DIGITAL_TYPE_PEERSTAR, "6:2");
                }
            }
            b1.this.d1(cVar.H(), cVar.F().length() > 0);
            b1.this.e1();
            xa.c c11 = xa.c.c();
            UserData data5 = activeResult.getData();
            c11.j(new LoginSuccessEvent(data5 != null ? data5.getHeartBeatTime() : null));
            xa.c.c().j(new CancelFreezeAtyEvent());
            s6.a aVar = s6.a.f18777a;
            if (aVar.a().u()) {
                LoginAty.C.a(b1.this.t0(), false, true);
                return;
            }
            b1.this.a0(activeResult.getData());
            b1.this.h0();
            b1.this.M0();
            b1.this.L0();
            b1.this.q0(activeResult.getData());
            if (aVar.a().q()) {
                b1.this.f0(activeResult.getData());
            }
            b1.this.S0();
            d6.a.f12650a.k();
        }

        @Override // ha.a, io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            t9.i.g(disposable, "d");
            super.onSubscribe(disposable);
            b1.this.f15037e = disposable;
        }

        @Override // ha.a
        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            xa.c.c().j(new CancelFreezeAtyEvent());
            if (t9.i.b("portal200001", str)) {
                MainAty.A.r(true);
                com.mobile.brasiltv.utils.b0.S(new VersionForbiddenDialog(b1.this.t0()), DialogManager.DIALOG_VERSION_FORBIDDEN);
                return;
            }
            if (t9.i.b("aaa100080", str)) {
                i.c cVar = w6.i.f19214g;
                cVar.u0("");
                cVar.a0("");
                cVar.w0("");
                com.mobile.brasiltv.utils.y0.f8789a.N(b1.this.t0());
            } else if (t9.i.b("aaa100094", str)) {
                new NumberLimitDialog(b1.this.t0()).show();
                return;
            }
            com.mobile.brasiltv.utils.x.f8754a.w(b1.this.t0(), new b(str));
        }
    }

    /* loaded from: classes3.dex */
    public static final class a0 extends ha.a {
        public a0() {
        }

        @Override // ha.a, io.reactivex.Observer
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void onNext(CheckForceBindResult checkForceBindResult) {
            t9.i.g(checkForceBindResult, "t");
            if (!t9.i.b(checkForceBindResult.getReturnCode(), "0") || checkForceBindResult.getData() == null) {
                return;
            }
            ForceBindData data = checkForceBindResult.getData();
            if (t9.i.b(Scopes.EMAIL, data != null ? data.getBindMethod() : null)) {
                ForceBindData data2 = checkForceBindResult.getData();
                if ((data2 != null ? data2.getFreeBindTime() : null) != null) {
                    ForceBindData data3 = checkForceBindResult.getData();
                    Integer freeBindTime = data3 != null ? data3.getFreeBindTime() : null;
                    t9.i.d(freeBindTime);
                    if (freeBindTime.intValue() > 0) {
                        b1 b1Var = b1.this;
                        ForceBindData data4 = checkForceBindResult.getData();
                        Integer freeBindTime2 = data4 != null ? data4.getFreeBindTime() : null;
                        t9.i.d(freeBindTime2);
                        b1Var.b0(freeBindTime2.intValue());
                        return;
                    }
                }
                b1.e0(b1.this, true, 0, 2, null);
            }
        }

        @Override // ha.a, io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            t9.i.g(disposable, "d");
            super.onSubscribe(disposable);
        }

        @Override // ha.a
        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
        }
    }

    /* loaded from: classes3.dex */
    public static final class b extends t9.j implements s9.a {

        /* renamed from: a, reason: collision with root package name */
        public static final b f15051a = new b();

        public b() {
            super(0);
        }

        @Override // s9.a
        public final String invoke() {
            return na.f.f(na.a.f17333a, "key_user_id", "");
        }
    }

    /* loaded from: classes3.dex */
    public static final class b0 extends v2.a {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f15053b;

        public b0(boolean z10) {
            this.f15053b = z10;
        }

        @Override // v2.a
        public void b(String str) {
            t9.i.g(str, "returnCode");
            c2.i.f5350q.a().i(na.e.f17344d);
            String o10 = com.mobile.brasiltv.utils.y.f8771a.o(str, "v1", "EA6");
            if (!ba.t.o(o10, "EA6", false, 2, null)) {
                com.mobile.brasiltv.utils.f1.f8649a.x(o10);
            } else {
                if (this.f15053b) {
                    return;
                }
                com.mobile.brasiltv.utils.f1.f8649a.q(b1.this.t0(), o10);
            }
        }

        @Override // io.reactivex.Observer
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void onNext(String str) {
            t9.i.g(str, "t");
            na.e.f17344d = str;
            na.f.k(b1.this.t0(), "realtime_dcs", String.valueOf(SystemClock.elapsedRealtime()));
            c2.i.f5350q.a().i(na.e.f17344d);
            s1.m.f18686a.f0(Long.valueOf(i2.h.f14287a.a()));
            if (this.f15053b) {
                return;
            }
            b1.this.R0();
            b1.this.F0();
        }
    }

    /* loaded from: classes3.dex */
    public static final class c extends t9.j implements s9.a {

        /* renamed from: a, reason: collision with root package name */
        public static final c f15054a = new c();

        public c() {
            super(0);
        }

        @Override // s9.a
        public final String invoke() {
            return na.f.f(na.a.f17333a, "key_user_identity", "");
        }
    }

    /* loaded from: classes3.dex */
    public static final class c0 extends t9.j implements s9.l {
        public c0() {
            super(1);
        }

        public final void b(SwitchAccountBean switchAccountBean) {
            com.mobile.brasiltv.utils.b0.U(b1.this, "增加账号记录成功！");
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            b((SwitchAccountBean) obj);
            return h9.t.f14242a;
        }
    }

    /* loaded from: classes3.dex */
    public static final class d implements v1.b {
        @Override // v1.b
        public void a(String str, boolean z10) {
            t9.i.g(str, "adType");
            a6.a aVar = a6.a.f228a;
            if (t9.i.b(str, aVar.i())) {
                xa.c.c().m(new HomePageAdEvent());
            } else if (t9.i.b(str, aVar.d())) {
                xa.c.c().m(new InterstitialEvent());
            }
        }

        @Override // v1.b
        public void b(boolean z10) {
        }
    }

    /* loaded from: classes3.dex */
    public static final class d0 extends t9.j implements s9.l {
        public d0() {
            super(1);
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return h9.t.f14242a;
        }

        public final void invoke(Throwable th) {
            com.mobile.brasiltv.utils.b0.U(b1.this, "增加账号记录失败！");
        }
    }

    /* loaded from: classes3.dex */
    public static final class e extends t9.j implements s9.l {

        /* renamed from: a, reason: collision with root package name */
        public static final e f15057a = new e();

        public e() {
            super(1);
        }

        @Override // s9.l
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(CheckNoticeUtils.NoteInfo noteInfo) {
            t9.i.g(noteInfo, "noteInfo");
            return Boolean.valueOf(!TextUtils.isEmpty(noteInfo.getInfo()));
        }
    }

    /* loaded from: classes3.dex */
    public static final class e0 extends t9.j implements s9.l {
        public e0() {
            super(1);
        }

        @Override // s9.l
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final String invoke(String str) {
            String str2;
            String str3;
            Object obj;
            Object obj2;
            t9.i.g(str, "it");
            b1.this.m0();
            b1.this.Y0();
            b1.this.c0();
            na.c.d();
            Pair b10 = m7.c.b();
            if (b10 == null || (obj2 = b10.first) == null || (str2 = obj2.toString()) == null) {
                str2 = b2.a.f4468g;
            }
            if (b10 == null || (obj = b10.second) == null || (str3 = obj.toString()) == null) {
                str3 = b2.a.f4468g;
            }
            t2.a aVar = t2.a.f18798a;
            t9.i.f(str2, "bbMainDomain");
            t9.i.f(str3, "bbSecondDomain");
            DomainInfo b11 = aVar.b(str2, str3, "key_tdc");
            i.b bVar = c2.i.f5350q;
            bVar.a().u();
            c2.i a10 = bVar.a();
            String g10 = na.a.g();
            t9.i.f(g10, "getPackageName()");
            int b12 = na.a.b();
            String str4 = Build.VERSION.RELEASE;
            t9.i.f(str4, "RELEASE");
            String y10 = com.mobile.brasiltv.utils.y0.f8789a.y(b1.this.t0());
            String str5 = na.c.f17339a;
            t9.i.f(str5, "reserve1");
            i.c cVar = w6.i.f19214g;
            a10.z((r27 & 1) != 0 ? false : false, b11, g10, b12, str4, y10, str5, cVar.E(), cVar.l(), MemberInfo.INSTANCE.getLastUserName(), (r27 & 1024) != 0 ? false : false);
            b1.this.l0();
            b1.this.W0();
            b1.this.U0();
            if (Build.VERSION.SDK_INT < 31) {
                s6.a.f18777a.a().a();
            }
            return str;
        }
    }

    /* loaded from: classes3.dex */
    public static final class f extends t9.j implements s9.l {
        public f() {
            super(1);
        }

        public final void b(CheckNoticeUtils.NoteInfo noteInfo) {
            if (noteInfo.getShowModel() != 2) {
                i6.v G0 = b1.this.G0();
                String info = noteInfo.getInfo();
                t9.i.f(info, "noteInfo.info");
                G0.s2(info);
                return;
            }
            b1 b1Var = b1.this;
            f5.c t02 = b1.this.t0();
            t9.i.e(t02, "null cannot be cast to non-null type android.app.Activity");
            String info2 = noteInfo.getInfo();
            t9.i.f(info2, "noteInfo.info");
            b1Var.f15038f = new NoticeDialog(t02, info2);
            NoticeDialog noticeDialog = b1.this.f15038f;
            t9.i.d(noticeDialog);
            com.mobile.brasiltv.utils.b0.S(noticeDialog, DialogManager.DIALOG_NOTICE);
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            b((CheckNoticeUtils.NoteInfo) obj);
            return h9.t.f14242a;
        }
    }

    /* loaded from: classes3.dex */
    public static final class f0 extends t9.j implements s9.l {
        public f0() {
            super(1);
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((String) obj);
            return h9.t.f14242a;
        }

        public final void invoke(String str) {
            b1.this.t0().startService(NetService.f8586h.a());
        }
    }

    /* loaded from: classes3.dex */
    public static final class g extends t9.j implements s9.l {

        /* renamed from: a, reason: collision with root package name */
        public static final g f15061a = new g();

        public g() {
            super(1);
        }

        public final void invoke(Throwable th) {
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return h9.t.f14242a;
        }
    }

    /* loaded from: classes3.dex */
    public static final class g0 extends t9.j implements s9.l {

        /* renamed from: a, reason: collision with root package name */
        public static final g0 f15062a = new g0();

        public g0() {
            super(1);
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return h9.t.f14242a;
        }

        public final void invoke(Throwable th) {
            th.printStackTrace();
        }
    }

    /* loaded from: classes3.dex */
    public static final class h implements h7.a {
        public h() {
        }

        @Override // h7.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onOver(UpdateBean updateBean) {
            t9.i.g(updateBean, "result");
            b1.this.I0(updateBean);
        }

        @Override // h7.a
        public void onCompleted() {
        }

        @Override // h7.a
        public void onError(Throwable th) {
            com.mobile.brasiltv.utils.b0.U(this, th != null ? th.getLocalizedMessage() : null);
            xa.c.c().m(new HasNewUpdateEvent(false));
        }
    }

    /* loaded from: classes3.dex */
    public static final class h0 extends ha.a {
        @Override // ha.a, io.reactivex.Observer
        public void onNext(BaseResult baseResult) {
            t9.i.g(baseResult, "t");
        }

        @Override // ha.a
        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
        }
    }

    /* loaded from: classes3.dex */
    public static final class i extends ha.a {

        public static final class a extends t9.j implements s9.l {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ GetAuthInfoResult f15065a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(GetAuthInfoResult getAuthInfoResult) {
                super(1);
                this.f15065a = getAuthInfoResult;
            }

            @Override // s9.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return h9.t.f14242a;
            }

            public final void invoke(String str) {
                com.mobile.brasiltv.utils.y yVar = com.mobile.brasiltv.utils.y.f8771a;
                String returnCode = this.f15065a.getReturnCode();
                t9.i.d(returnCode);
                com.mobile.brasiltv.utils.f1.f8649a.x(com.mobile.brasiltv.utils.y.p(yVar, returnCode, null, null, 6, null));
            }
        }

        public static final class b extends t9.j implements s9.l {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f15066a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(String str) {
                super(1);
                this.f15066a = str;
            }

            @Override // s9.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return h9.t.f14242a;
            }

            public final void invoke(String str) {
                com.mobile.brasiltv.utils.f1.f8649a.x(com.mobile.brasiltv.utils.y.p(com.mobile.brasiltv.utils.y.f8771a, this.f15066a, null, null, 6, null));
            }
        }

        public i() {
        }

        @Override // ha.a, io.reactivex.Observer
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void onNext(GetAuthInfoResult getAuthInfoResult) {
            String tips;
            t9.i.g(getAuthInfoResult, "t");
            k7.f.e("获取授权信息成功，result: " + getAuthInfoResult, new Object[0]);
            if (t9.i.b(getAuthInfoResult.getReturnCode(), "aaa100028")) {
                k7.f.f("授权信息接口，needToReLogin", new Object[0]);
                com.mobile.brasiltv.utils.b0.c0(b1.this.t0(), LoginAty.class);
                return;
            }
            if (com.mobile.brasiltv.utils.b0.T(getAuthInfoResult.getReturnCode(), "aaa100027")) {
                com.mobile.brasiltv.utils.x.f8754a.w(b1.this.t0(), new a(getAuthInfoResult));
                return;
            }
            String str = "";
            if (getAuthInfoResult.getData() != null) {
                i.c cVar = w6.i.f19214g;
                GetAuthInfoData data = getAuthInfoResult.getData();
                t9.i.d(data);
                cVar.t0(data.getShowFlag());
                GetAuthInfoData data2 = getAuthInfoResult.getData();
                t9.i.d(data2);
                cVar.T(data2.getBindMail());
                GetAuthInfoData data3 = getAuthInfoResult.getData();
                t9.i.d(data3);
                cVar.g0(data3.getHasPay());
                GetAuthInfoData data4 = getAuthInfoResult.getData();
                t9.i.d(data4);
                cVar.q0(data4.getRestrictedStatus());
                GetAuthInfoData data5 = getAuthInfoResult.getData();
                t9.i.d(data5);
                cVar.h0(data5.getHasPwd());
                GetAuthInfoData data6 = getAuthInfoResult.getData();
                t9.i.d(data6);
                cVar.y0(data6.getUserIdentity());
                GetAuthInfoData data7 = getAuthInfoResult.getData();
                t9.i.d(data7);
                String childLockPwd = data7.getChildLockPwd();
                if (childLockPwd == null) {
                    childLockPwd = "";
                }
                cVar.W(childLockPwd);
                GetAuthInfoData data8 = getAuthInfoResult.getData();
                t9.i.d(data8);
                Integer remainingDays = data8.getRemainingDays();
                cVar.p0(remainingDays != null ? remainingDays.intValue() : 0);
                GetAuthInfoData data9 = getAuthInfoResult.getData();
                t9.i.d(data9);
                Integer expRemainingDays = data9.getExpRemainingDays();
                cVar.c0(expRemainingDays != null ? expRemainingDays.intValue() : 0);
                GetAuthInfoData data10 = getAuthInfoResult.getData();
                t9.i.d(data10);
                String qrcodeMessage = data10.getQrcodeMessage();
                if (qrcodeMessage == null) {
                    qrcodeMessage = "";
                }
                cVar.o0(qrcodeMessage);
                GetAuthInfoData data11 = getAuthInfoResult.getData();
                t9.i.d(data11);
                cVar.P(data11.getActiveTime());
            }
            d6.b bVar = d6.b.f12660a;
            GetAuthInfoData data12 = getAuthInfoResult.getData();
            bVar.B(data12 != null ? data12.getAuthInfoList() : null);
            b1 b1Var = b1.this;
            GetAuthInfoData data13 = getAuthInfoResult.getData();
            if (data13 != null && (tips = data13.getTips()) != null) {
                str = tips;
            }
            b1Var.H0(str);
            i.c cVar2 = w6.i.f19214g;
            cVar2.S(cVar2.y() + "?lang=" + com.mobile.brasiltv.utils.f0.a() + "&userId=" + cVar2.H() + "&packageId=&appId=" + na.a.g() + "&packageType=1&appVersion=" + na.a.b() + "&timeStamp=" + System.currentTimeMillis() + "&tk=" + cVar2.J() + "&loginType=3");
            StringBuilder sb = new StringBuilder();
            sb.append("购买VIP连接：");
            sb.append(cVar2.g());
            k7.f.e(sb.toString(), new Object[0]);
            b1.this.B0();
            xa.c.c().m(new UpdateMineViewEvent());
        }

        @Override // ha.a, io.reactivex.Observer
        public void onComplete() {
        }

        @Override // ha.a
        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            com.mobile.brasiltv.utils.x.f8754a.w(b1.this.t0(), new b(str));
            b1.this.B0();
        }
    }

    /* loaded from: classes3.dex */
    public static final class j extends t9.j implements s9.l {
        public j() {
            super(1);
        }

        public final void b(PendingDynamicLinkData pendingDynamicLinkData) {
            Uri link = pendingDynamicLinkData != null ? pendingDynamicLinkData.getLink() : null;
            if (link != null) {
                com.mobile.brasiltv.utils.b0.j0(b1.this.t0(), link.toString(), true, false, true, false, 16, null);
            }
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            b((PendingDynamicLinkData) obj);
            return h9.t.f14242a;
        }
    }

    /* loaded from: classes3.dex */
    public static final class k extends ha.a {
        public k() {
        }

        @Override // ha.a, io.reactivex.Observer
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void onNext(FreeResult freeResult) {
            t9.i.g(freeResult, "t");
            super.onNext(freeResult);
            xa.c.c().m(new GetFreeTimeEvent());
        }

        @Override // ha.a
        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            String c10 = com.mobile.brasiltv.utils.y.f8771a.c(str);
            k7.f.e(b1.this.f15035c, "getFreeTime " + c10);
        }
    }

    /* loaded from: classes3.dex */
    public static final class l extends ha.a {

        public static final class a extends t9.j implements s9.l {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f15070a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(String str) {
                super(1);
                this.f15070a = str;
            }

            @Override // s9.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return h9.t.f14242a;
            }

            public final void invoke(String str) {
                com.mobile.brasiltv.utils.y yVar = com.mobile.brasiltv.utils.y.f8771a;
                String p10 = com.mobile.brasiltv.utils.y.p(yVar, this.f15070a, null, null, 6, null);
                if (!t9.i.b(na.d.c(this.f15070a), "no_report_type")) {
                    p10 = com.mobile.brasiltv.utils.y.p(yVar, this.f15070a, null, null, 6, null);
                }
                com.mobile.brasiltv.utils.f1.f8649a.x(p10);
            }
        }

        public l() {
        }

        @Override // ha.a, io.reactivex.Observer
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void onNext(ChildColumnList childColumnList) {
            t9.i.g(childColumnList, "childColumn");
        }

        @Override // ha.a, io.reactivex.Observer
        public void onComplete() {
            com.mobile.brasiltv.utils.b0.U(this, "loadMainColumn:onCompleted");
            b1.this.G0().s();
            b1.this.G0().p0();
            b1.this.v0();
        }

        @Override // ha.a
        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            b1.this.G0().onError();
            com.mobile.brasiltv.utils.x.f8754a.w(b1.this.t0(), new a(str));
        }
    }

    /* loaded from: classes3.dex */
    public static final class m extends t9.j implements s9.l {

        /* renamed from: a, reason: collision with root package name */
        public static final m f15071a = new m();

        public m() {
            super(1);
        }

        @Override // s9.l
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final String invoke(String str) {
            t9.i.g(str, Constants.KEY_HOST);
            return r5.i.f18523a.y(str);
        }
    }

    /* loaded from: classes3.dex */
    public static final class n extends t9.j implements s9.l {

        /* renamed from: a, reason: collision with root package name */
        public static final n f15072a = new n();

        public n() {
            super(1);
        }

        @Override // s9.l
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final SnTokenData invoke(SnTokenResult snTokenResult) {
            t9.i.g(snTokenResult, "it");
            return snTokenResult.getData();
        }
    }

    /* loaded from: classes3.dex */
    public static final class o extends ha.a {

        public static final class a extends t9.j implements s9.l {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f15074a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(String str) {
                super(1);
                this.f15074a = str;
            }

            @Override // s9.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return h9.t.f14242a;
            }

            public final void invoke(String str) {
                com.mobile.brasiltv.utils.y yVar = com.mobile.brasiltv.utils.y.f8771a;
                com.mobile.brasiltv.utils.f1.f8649a.x(com.mobile.brasiltv.utils.y.p(yVar, this.f15074a, yVar.l(), null, 4, null));
            }
        }

        public o() {
        }

        @Override // ha.a, io.reactivex.Observer
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void onNext(SnTokenData snTokenData) {
            String c10;
            t9.i.g(snTokenData, "t");
            super.onNext(snTokenData);
            if ("1".equals(snTokenData.isNew())) {
                i.c cVar = w6.i.f19214g;
                String sn = snTokenData.getSn();
                if (sn == null || sn.length() == 0) {
                    c10 = ma.m.c(snTokenData.getSnToken());
                    t9.i.f(c10, "{\n                      …                        }");
                } else {
                    c10 = snTokenData.getSn();
                    if (c10 == null) {
                        c10 = "";
                    }
                }
                cVar.u0(c10);
                if (TextUtils.isEmpty(cVar.E())) {
                    com.mobile.brasiltv.utils.i1.G(b1.this.t0(), CdnType.DIGITAL_TYPE_PEERSTAR, "6:1");
                }
                b1 b1Var = b1.this;
                String userId = snTokenData.getUserId();
                b1Var.d1(userId != null ? userId : "", true);
            } else {
                i.c cVar2 = w6.i.f19214g;
                String c11 = ma.m.c(snTokenData.getSnToken());
                t9.i.f(c11, "getMd5(t.snToken)");
                cVar2.u0(c11);
                String snToken = snTokenData.getSnToken();
                cVar2.v0(snToken != null ? snToken : "");
            }
            na.f.k(Utils.context, "key_sn", w6.i.f19214g.E());
            b1.this.Z();
        }

        @Override // ha.a
        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            if (!t9.i.b("portal200001", str)) {
                com.mobile.brasiltv.utils.x.f8754a.w(b1.this.t0(), new a(str));
            } else {
                MainAty.A.r(true);
                com.mobile.brasiltv.utils.b0.S(new VersionForbiddenDialog(b1.this.t0()), DialogManager.DIALOG_VERSION_FORBIDDEN);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class p extends ha.a {
        @Override // ha.a, io.reactivex.Observer
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void onNext(ThirdPartResult thirdPartResult) {
            t9.i.g(thirdPartResult, "t");
            a6.f.f268a.b(thirdPartResult.getData());
        }

        @Override // ha.a
        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            com.mobile.brasiltv.utils.b0.U(this, "get third part fail.");
        }
    }

    /* loaded from: classes3.dex */
    public static final class q implements v2.b {
        @Override // v2.b
        public void a(long j10, long j11, String str, String str2, int i10, boolean z10) {
            t9.i.g(str, "uri");
            t9.i.g(str2, "domain");
            c2.d.f5311a.d(j10, SystemClock.elapsedRealtime(), str, str2, i10, (r23 & 32) != 0 ? "" : na.e.f17345e, (r23 & 64) != 0 ? null : null, z10);
        }
    }

    /* loaded from: classes3.dex */
    public static final class r extends ha.a {

        public static final class a extends t9.j implements s9.l {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f15076a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ b1 f15077b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(String str, b1 b1Var) {
                super(1);
                this.f15076a = str;
                this.f15077b = b1Var;
            }

            public static final void c(t9.w wVar) {
                t9.i.g(wVar, "$msg");
                com.mobile.brasiltv.utils.f1.f8649a.x((String) wVar.f18961a);
            }

            @Override // s9.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return h9.t.f14242a;
            }

            public final void invoke(String str) {
                final t9.w wVar = new t9.w();
                com.mobile.brasiltv.utils.y yVar = com.mobile.brasiltv.utils.y.f8771a;
                wVar.f18961a = com.mobile.brasiltv.utils.y.p(yVar, this.f15076a, yVar.e(), null, 4, null);
                this.f15077b.t0().runOnUiThread(new Runnable() { // from class: k6.c1
                    @Override // java.lang.Runnable
                    public final void run() {
                        b1.r.a.c(t9.w.this);
                    }
                });
            }
        }

        public r() {
        }

        @Override // ha.a, io.reactivex.Observer
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void onNext(GetHomeResult getHomeResult) {
            t9.i.g(getHomeResult, "t");
            if (getHomeResult.getData() != null) {
                GetHomeData data = getHomeResult.getData();
                t9.i.d(data);
                if (com.mobile.brasiltv.utils.b0.I(data.getRecommendList())) {
                    com.mobile.brasiltv.utils.b0.U(this, "首页数据获取成功 " + getHomeResult);
                    com.mobile.brasiltv.utils.n0 n0Var = com.mobile.brasiltv.utils.n0.f8733a;
                    f5.c t02 = b1.this.t0();
                    GetHomeData data2 = getHomeResult.getData();
                    t9.i.d(data2);
                    n0Var.j(t02, "home_data_version", data2.getVersion());
                    f5.c t03 = b1.this.t0();
                    GetHomeData data3 = getHomeResult.getData();
                    t9.i.d(data3);
                    n0Var.j(t03, "home_data_free_version", data3.getFreeVersion());
                    Gson gson = new Gson();
                    GetHomeData data4 = getHomeResult.getData();
                    t9.i.d(data4);
                    na.f.m(b1.this.t0(), "home", "home_data", gson.toJson(data4.getRecommendList()));
                    MainAty.a aVar = MainAty.A;
                    aVar.g().clear();
                    ArrayList g10 = aVar.g();
                    GetHomeData data5 = getHomeResult.getData();
                    t9.i.d(data5);
                    ArrayList<HomeRecommend> recommendList = data5.getRecommendList();
                    t9.i.d(recommendList);
                    g10.addAll(recommendList);
                }
            }
        }

        @Override // ha.a
        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            if (t9.i.b(str, "304")) {
                com.mobile.brasiltv.utils.b0.U(this, "首页数据有缓存");
                MainAty.a aVar = MainAty.A;
                if (com.mobile.brasiltv.utils.b0.I(aVar.a())) {
                    aVar.j(true);
                    aVar.g().clear();
                    aVar.g().addAll(aVar.a());
                    return;
                }
                com.mobile.brasiltv.utils.n0.f8733a.k(b1.this.t0(), new String[]{"home_data_version", "home_data_free_version"}, new String[]{"", ""});
            }
            MainAty.A.j(false);
            com.mobile.brasiltv.utils.x.f8754a.w(b1.this.t0(), new a(str, b1.this));
        }
    }

    /* loaded from: classes3.dex */
    public static final class s extends TypeToken<ArrayList<HomeRecommend>> {
    }

    /* loaded from: classes3.dex */
    public static final class t extends t9.j implements s9.l {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ t9.w f15078a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ b1 f15079b;

        public static final class a extends t9.j implements s9.a {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b1 f15080a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(b1 b1Var) {
                super(0);
                this.f15080a = b1Var;
            }

            @Override // s9.a
            public /* bridge */ /* synthetic */ Object invoke() {
                m92invoke();
                return h9.t.f14242a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m92invoke() {
                this.f15080a.G0().s();
                this.f15080a.G0().p0();
                this.f15080a.v0();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public t(t9.w wVar, b1 b1Var) {
            super(1);
            this.f15078a = wVar;
            this.f15079b = b1Var;
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Boolean) obj);
            return h9.t.f14242a;
        }

        public final void invoke(Boolean bool) {
            t9.i.f(bool, "it");
            if (!bool.booleanValue()) {
                this.f15079b.A0();
                return;
            }
            w6.i b10 = w6.i.f19214g.b();
            Object obj = this.f15078a.f18961a;
            t9.i.d(obj);
            b10.N1((ColumnContentsBean) obj, new a(this.f15079b));
        }
    }

    /* loaded from: classes3.dex */
    public static final class u extends ha.a {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ t9.w f15082b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f15083c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f15084d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f15085e;

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ String f15086f;

        /* renamed from: g, reason: collision with root package name */
        public final /* synthetic */ t9.w f15087g;

        /* renamed from: h, reason: collision with root package name */
        public final /* synthetic */ String f15088h;

        public static final class a extends t9.j implements s9.l {

            /* renamed from: a, reason: collision with root package name */
            public static final a f15089a = new a();

            public a() {
                super(1);
            }

            @Override // s9.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return h9.t.f14242a;
            }

            public final void invoke(String str) {
                com.mobile.brasiltv.utils.f1.f8649a.x(com.mobile.brasiltv.utils.y.p(com.mobile.brasiltv.utils.y.f8771a, "CUSTOM_NO_ASSOCIATED_PORTAL", null, null, 6, null));
            }
        }

        public static final class b extends t9.j implements s9.l {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f15090a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ t9.w f15091b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ b1 f15092c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(String str, t9.w wVar, b1 b1Var) {
                super(1);
                this.f15090a = str;
                this.f15091b = wVar;
                this.f15092c = b1Var;
            }

            @Override // s9.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return h9.t.f14242a;
            }

            public final void invoke(String str) {
                com.mobile.brasiltv.utils.y yVar = com.mobile.brasiltv.utils.y.f8771a;
                String p10 = com.mobile.brasiltv.utils.y.p(yVar, this.f15090a, yVar.i(), null, 4, null);
                if (t9.i.b(this.f15091b.f18961a, "7") && t9.i.b(this.f15090a, "aaa100003")) {
                    na.f.k(this.f15092c.t0(), "qr_auth_code", "");
                } else {
                    com.mobile.brasiltv.utils.f1.f8649a.x(p10);
                }
            }
        }

        public u(t9.w wVar, String str, String str2, String str3, String str4, t9.w wVar2, String str5) {
            this.f15082b = wVar;
            this.f15083c = str;
            this.f15084d = str2;
            this.f15085e = str3;
            this.f15086f = str4;
            this.f15087g = wVar2;
            this.f15088h = str5;
        }

        @Override // ha.a, io.reactivex.Observer
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void onNext(LoginResult loginResult) {
            String str;
            String str2;
            String str3;
            String str4;
            String str5;
            String areaCode;
            t9.i.g(loginResult, "t");
            super.onNext(loginResult);
            UserData data = loginResult.getData();
            if (!com.mobile.brasiltv.utils.b0.I(data != null ? data.getPortalCodeList() : null)) {
                com.mobile.brasiltv.utils.x.f8754a.w(b1.this.t0(), a.f15089a);
                return;
            }
            d6.b bVar = d6.b.f12660a;
            f5.c t02 = b1.this.t0();
            UserData data2 = loginResult.getData();
            t9.i.d(data2);
            bVar.F(t02, data2, this.f15083c, this.f15084d, (r21 & 16) != 0 ? "" : null, (r21 & 32) != 0 ? "" : null, (r21 & 64) != 0 ? "" : this.f15085e, (r21 & 128) != 0);
            if (!TextUtils.isEmpty((CharSequence) this.f15082b.f18961a)) {
                UserData data3 = loginResult.getData();
                if (t9.i.b(data3 != null ? data3.getPwdTip() : null, "yes")) {
                    UserData data4 = loginResult.getData();
                    if (t9.i.b(data4 != null ? data4.getHasPwd() : null, "1")) {
                        com.mobile.brasiltv.utils.b0.c0(b1.this.t0(), ForceChangePwdAty.class);
                        SwitchAccountBean switchAccountBean = new SwitchAccountBean();
                        switchAccountBean.setAccountType((String) this.f15082b.f18961a);
                        switchAccountBean.setAreaCode(this.f15086f);
                        switchAccountBean.setUserName((String) this.f15087g.f18961a);
                        switchAccountBean.setPassword(this.f15084d);
                        switchAccountBean.setVerificationToken(this.f15088h);
                        s5.e.f18766a.n(s5.c.QUICK_LOGIN, switchAccountBean, null);
                        return;
                    }
                }
            }
            b1.this.e1();
            SwitchAccountBean switchAccountBean2 = new SwitchAccountBean();
            String str6 = "";
            if (t9.i.b(this.f15082b.f18961a, "7")) {
                UserData data5 = loginResult.getData();
                if (data5 == null || (str = data5.getUserId()) == null) {
                    str = "";
                }
            } else {
                str = this.f15083c;
            }
            switchAccountBean2.setUserName(str);
            switchAccountBean2.setPassword(this.f15084d);
            UserData data6 = loginResult.getData();
            if (data6 == null || (str2 = data6.getUserId()) == null) {
                str2 = "";
            }
            switchAccountBean2.setUserId(str2);
            switchAccountBean2.setAccountType((String) this.f15082b.f18961a);
            UserData data7 = loginResult.getData();
            if (data7 == null || (str3 = data7.getAreaCode()) == null) {
                str3 = "";
            }
            switchAccountBean2.setAreaCode(str3);
            switchAccountBean2.setVerificationToken(this.f15088h);
            UserData data8 = loginResult.getData();
            if (data8 == null || (str4 = data8.getEmail()) == null) {
                str4 = "";
            }
            switchAccountBean2.setEmail(str4);
            UserData data9 = loginResult.getData();
            if (data9 == null || (str5 = data9.getMobile()) == null) {
                str5 = "";
            }
            switchAccountBean2.setPhone(str5);
            UserData data10 = loginResult.getData();
            if (data10 != null && (areaCode = data10.getAreaCode()) != null) {
                str6 = areaCode;
            }
            switchAccountBean2.setAreaCode(str6);
            b1.this.Z0(switchAccountBean2);
            xa.c.c().j(new CloseForcePageEvent());
            xa.c c10 = xa.c.c();
            UserData data11 = loginResult.getData();
            c10.j(new LoginSuccessEvent(data11 != null ? data11.getHeartBeatTime() : null));
            b1.this.a0(loginResult.getData());
            b1.this.h0();
            b1.this.M0();
            b1.this.L0();
            b1.this.q0(loginResult.getData());
            b1.this.S0();
            d6.a.f12650a.k();
        }

        @Override // ha.a
        public void handleVerifyTokenError() {
            super.handleVerifyTokenError();
            MemberInfo memberInfo = MemberInfo.INSTANCE;
            memberInfo.putUserName("");
            memberInfo.putPassword("", false);
            na.f.k(b1.this.t0(), "verification_token", "");
        }

        @Override // ha.a
        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            if (t9.i.b("portal200001", str)) {
                MainAty.A.r(true);
                com.mobile.brasiltv.utils.b0.S(new VersionForbiddenDialog(b1.this.t0()), DialogManager.DIALOG_VERSION_FORBIDDEN);
            } else {
                if (t9.i.b("aaa100094", str)) {
                    new NumberLimitDialog(b1.this.t0()).show();
                    return;
                }
                com.mobile.brasiltv.utils.x.f8754a.w(b1.this.t0(), new b(str, this.f15082b, b1.this));
                com.mobile.brasiltv.utils.b0.c0(b1.this.t0(), LoginAty.class);
                b1.this.G0().onError();
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class v extends ha.a {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f15094b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f15095c;

        public static final class a extends t9.j implements s9.l {

            /* renamed from: a, reason: collision with root package name */
            public static final a f15096a = new a();

            public a() {
                super(1);
            }

            @Override // s9.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return h9.t.f14242a;
            }

            public final void invoke(String str) {
                com.mobile.brasiltv.utils.f1.f8649a.x(com.mobile.brasiltv.utils.y.p(com.mobile.brasiltv.utils.y.f8771a, "CUSTOM_NO_ASSOCIATED_PORTAL", null, null, 6, null));
            }
        }

        public static final class b extends t9.j implements s9.l {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f15097a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(String str) {
                super(1);
                this.f15097a = str;
            }

            @Override // s9.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return h9.t.f14242a;
            }

            public final void invoke(String str) {
                com.mobile.brasiltv.utils.y yVar = com.mobile.brasiltv.utils.y.f8771a;
                com.mobile.brasiltv.utils.f1.f8649a.x(com.mobile.brasiltv.utils.y.p(yVar, this.f15097a, yVar.j(), null, 4, null));
            }
        }

        public v(String str, String str2) {
            this.f15094b = str;
            this.f15095c = str2;
        }

        @Override // ha.a, io.reactivex.Observer
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void onNext(LoginResult loginResult) {
            String str;
            String str2;
            String str3;
            String str4;
            String areaCode;
            t9.i.g(loginResult, "t");
            UserData data = loginResult.getData();
            if (!com.mobile.brasiltv.utils.b0.I(data != null ? data.getPortalCodeList() : null)) {
                com.mobile.brasiltv.utils.x.f8754a.w(b1.this.t0(), a.f15096a);
                return;
            }
            d6.b bVar = d6.b.f12660a;
            f5.c t02 = b1.this.t0();
            UserData data2 = loginResult.getData();
            t9.i.d(data2);
            bVar.F(t02, data2, "", "", (r21 & 16) != 0 ? "" : this.f15094b, (r21 & 32) != 0 ? "" : this.f15095c, (r21 & 64) != 0 ? "" : null, (r21 & 128) != 0);
            if (!TextUtils.isEmpty(this.f15094b)) {
                UserData data3 = loginResult.getData();
                if (t9.i.b(data3 != null ? data3.getPwdTip() : null, "yes")) {
                    UserData data4 = loginResult.getData();
                    if (t9.i.b(data4 != null ? data4.getHasPwd() : null, "1")) {
                        com.mobile.brasiltv.utils.b0.c0(b1.this.t0(), ForceChangePwdAty.class);
                        x7.a aVar = new x7.a();
                        aVar.b(this.f15095c);
                        s5.e.f18766a.o(s5.c.THIRD_PART_LOGIN, this.f15094b, aVar, "0", "1", null);
                        return;
                    }
                }
            }
            b1.this.e1();
            SwitchAccountBean switchAccountBean = new SwitchAccountBean();
            switchAccountBean.setAccountType(this.f15094b);
            UserData data5 = loginResult.getData();
            String str5 = "";
            if (data5 == null || (str = data5.getEmail()) == null) {
                str = "";
            }
            switchAccountBean.setUserName(str);
            UserData data6 = loginResult.getData();
            if (data6 == null || (str2 = data6.getEmail()) == null) {
                str2 = "";
            }
            switchAccountBean.setEmail(str2);
            UserData data7 = loginResult.getData();
            if (data7 == null || (str3 = data7.getMobile()) == null) {
                str3 = "";
            }
            switchAccountBean.setPhone(str3);
            UserData data8 = loginResult.getData();
            if (data8 == null || (str4 = data8.getUserId()) == null) {
                str4 = "";
            }
            switchAccountBean.setUserId(str4);
            switchAccountBean.setAuthCode(this.f15095c);
            UserData data9 = loginResult.getData();
            if (data9 != null && (areaCode = data9.getAreaCode()) != null) {
                str5 = areaCode;
            }
            switchAccountBean.setAreaCode(str5);
            b1.this.Z0(switchAccountBean);
            xa.c.c().j(new CloseForcePageEvent());
            xa.c c10 = xa.c.c();
            UserData data10 = loginResult.getData();
            c10.j(new LoginSuccessEvent(data10 != null ? data10.getHeartBeatTime() : null));
            b1.this.a0(loginResult.getData());
            b1.this.h0();
            b1.this.M0();
            b1.this.L0();
            b1.this.q0(loginResult.getData());
            b1.this.S0();
            d6.a.f12650a.k();
        }

        @Override // ha.a
        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            if (t9.i.b("portal200001", str)) {
                MainAty.A.r(true);
                com.mobile.brasiltv.utils.b0.S(new VersionForbiddenDialog(b1.this.t0()), DialogManager.DIALOG_VERSION_FORBIDDEN);
            } else {
                if (t9.i.b("aaa100094", str)) {
                    new NumberLimitDialog(b1.this.t0()).show();
                    return;
                }
                com.mobile.brasiltv.utils.x.f8754a.w(b1.this.t0(), new b(str));
                com.mobile.brasiltv.utils.b0.c0(b1.this.t0(), LoginAty.class);
                b1.this.G0().onError();
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class w extends t9.j implements s9.a {

        /* renamed from: a, reason: collision with root package name */
        public static final w f15098a = new w();

        public w() {
            super(0);
        }

        @Override // s9.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final c5.a invoke() {
            return new c5.a(new ja.c(".update"), new la.a(".update"));
        }
    }

    /* loaded from: classes3.dex */
    public static final class x extends t9.j implements s9.l {

        /* renamed from: a, reason: collision with root package name */
        public static final x f15099a = new x();

        public x() {
            super(1);
        }

        @Override // s9.l
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(ApkQueryCouponResult apkQueryCouponResult) {
            t9.i.g(apkQueryCouponResult, "it");
            return Boolean.valueOf(apkQueryCouponResult.getData() != null);
        }
    }

    /* loaded from: classes3.dex */
    public static final class y extends ha.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ t9.w f15100a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ b1 f15101b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f15102c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f15103d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f15104e;

        public y(t9.w wVar, b1 b1Var, String str, String str2, String str3) {
            this.f15100a = wVar;
            this.f15101b = b1Var;
            this.f15102c = str;
            this.f15103d = str2;
            this.f15104e = str3;
        }

        @Override // ha.a, io.reactivex.Observer
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void onNext(ApkQueryCouponResult apkQueryCouponResult) {
            t9.i.g(apkQueryCouponResult, "apkQueryCouponResult");
            long j10 = y6.a.j();
            QueryCouponData data = apkQueryCouponResult.getData();
            if (com.mobile.brasiltv.utils.b0.I(data != null ? data.getCouponCodeList() : null)) {
                QueryCouponData data2 = apkQueryCouponResult.getData();
                t9.i.d(data2);
                List<CouponCodeList> couponCodeList = data2.getCouponCodeList();
                t9.i.d(couponCodeList);
                this.f15101b.k1(couponCodeList, j10 / 1000);
            }
            QueryCouponData data3 = apkQueryCouponResult.getData();
            String receiveFlag = data3 != null ? data3.getReceiveFlag() : null;
            if (receiveFlag == null || receiveFlag.length() == 0) {
                return;
            }
            QueryCouponData data4 = apkQueryCouponResult.getData();
            t9.i.d(data4);
            boolean b10 = t9.i.b(data4.getReceiveFlag(), "1");
            w6.i.f19214g.i0(b10);
            na.f.i(this.f15101b.t0(), this.f15102c, b10);
            na.f.k(this.f15101b.t0(), this.f15103d, String.valueOf(j10));
            f5.c t02 = this.f15101b.t0();
            String str = this.f15104e;
            t9.i.d(apkQueryCouponResult.getData());
            na.f.k(t02, str, String.valueOf(r8.getDataCacheTime() * 60 * 1000));
        }

        @Override // ha.a
        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            if (this.f15100a.f18961a != null) {
                w6.i.f19214g.i0(false);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class z extends BroadcastReceiver {
        public z() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            int intExtra = intent != null ? intent.getIntExtra(FirebaseAnalytics.Param.LEVEL, 0) : 0;
            int intExtra2 = intent != null ? intent.getIntExtra("scale", 0) : 0;
            Integer num = b1.this.f15046n;
            if (num == null || num.intValue() != intExtra) {
                q8.e.b(bt.Z, (intExtra * 100) / intExtra2);
            }
            b1.this.f15046n = Integer.valueOf(intExtra);
        }
    }

    public b1(f5.c cVar, i6.v vVar) {
        t9.i.g(cVar, com.umeng.analytics.pro.f.X);
        t9.i.g(vVar, "view");
        this.f15033a = cVar;
        this.f15034b = vVar;
        this.f15035c = "MainPresenter";
        this.f15039g = h9.h.b(b.f15051a);
        this.f15040h = h9.h.b(c.f15054a);
        this.f15042j = h9.h.b(w.f15098a);
        this.f15043k = true;
        vVar.Y0(this);
        this.f15044l = new HashMap();
    }

    public static final SnTokenData D0(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        return (SnTokenData) lVar.invoke(obj);
    }

    public static final void J0(b1 b1Var, DialogInterface dialogInterface, boolean z10) {
        t9.i.g(b1Var, "this$0");
        if (z10) {
            return;
        }
        if (MainAty.A.i()) {
            DialogManager dialogManager = DialogManager.INSTANCE;
            if (!dialogManager.hasDialogSaved(DialogManager.DIALOG_VERSION_FORBIDDEN)) {
                dialogManager.showByManager(new VersionForbiddenDialog(b1Var.f15033a), DialogManager.DIALOG_VERSION_FORBIDDEN);
            }
        }
        DialogManager dialogManager2 = DialogManager.INSTANCE;
        t9.i.e(dialogInterface, "null cannot be cast to non-null type android.app.Dialog");
        dialogManager2.showNext((Dialog) dialogInterface);
    }

    public static final void N0(t9.w wVar, b1 b1Var, t9.w wVar2, ObservableEmitter observableEmitter) {
        t9.i.g(wVar, "$cacheColumnData");
        t9.i.g(b1Var, "this$0");
        t9.i.g(wVar2, "$columnContentsBean");
        t9.i.g(observableEmitter, "it");
        Object b10 = n7.a.b(b1Var.f15033a, "root_column", "");
        t9.i.e(b10, "null cannot be cast to non-null type kotlin.String");
        String str = (String) b10;
        wVar.f18961a = str;
        if (!com.mobile.brasiltv.utils.b0.J(str)) {
            Gson a10 = s2.b.a();
            Object obj = wVar.f18961a;
            t9.i.d(obj);
            wVar2.f18961a = a10.fromJson((String) obj, ColumnContentsBean.class);
        }
        if (wVar2.f18961a == null) {
            observableEmitter.onNext(Boolean.FALSE);
            return;
        }
        int d10 = na.f.d(b1Var.f15033a, "column_cache_time", 0);
        String f10 = na.f.f(b1Var.f15033a, "service_time_root_column", "0");
        t9.i.f(f10, "getStrings(context, Cons…CE_TIME_ROOT_COLUMN, \"0\")");
        long parseLong = Long.parseLong(f10);
        String f11 = na.f.f(na.a.f17333a, "realtime_dcs", "0");
        t9.i.f(f11, "getStrings(AppHelper.mCo…nstant.REALTIME_DCS, \"0\")");
        long a11 = (i2.h.f14287a.a() + SystemClock.elapsedRealtime()) - Long.parseLong(f11);
        StringBuilder sb = new StringBuilder();
        sb.append("root column: nowTime: ");
        sb.append(a11);
        sb.append(", lastCacheTime: ");
        sb.append(parseLong);
        sb.append(", cacheTime: ");
        int i10 = 60000 * d10;
        sb.append(i10);
        sb.append(", needRequest= ");
        sb.append(a11 > ((long) i10) + parseLong);
        k7.f.e(sb.toString(), new Object[0]);
        if (parseLong == 0 || d10 == 0 || a11 >= parseLong + (d10 * 60 * 1000)) {
            observableEmitter.onNext(Boolean.FALSE);
        } else {
            observableEmitter.onNext(Boolean.TRUE);
        }
    }

    public static final void O0(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final boolean T0(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        return ((Boolean) lVar.invoke(obj)).booleanValue();
    }

    public static final void a1(b1 b1Var, SwitchAccountBean switchAccountBean, ObservableEmitter observableEmitter) {
        t9.i.g(b1Var, "this$0");
        t9.i.g(switchAccountBean, "$account");
        t9.i.g(observableEmitter, "it");
        Context applicationContext = b1Var.f15033a.getApplicationContext();
        t9.i.f(applicationContext, "context.applicationContext");
        MobileDao mobileDao = new MobileDao(applicationContext);
        if (mobileDao.queryAccount(switchAccountBean.getUserId()) == null) {
            mobileDao.addAccount(switchAccountBean);
        }
        observableEmitter.onNext(switchAccountBean);
        observableEmitter.onComplete();
    }

    public static final void b1(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void c1(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static /* synthetic */ void e0(b1 b1Var, boolean z10, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = 0;
        }
        b1Var.d0(z10, i10);
    }

    public static final void f1(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void g1(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void h1(b1 b1Var, ObservableEmitter observableEmitter) {
        t9.i.g(b1Var, "this$0");
        t9.i.g(observableEmitter, "it");
        com.mobile.brasiltv.utils.y0 y0Var = com.mobile.brasiltv.utils.y0.f8789a;
        y0Var.K(b1Var.f15033a);
        y0Var.L();
        b1Var.K0();
        observableEmitter.onNext("cold launcher");
        observableEmitter.onComplete();
    }

    public static final boolean i0(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        return ((Boolean) lVar.invoke(obj)).booleanValue();
    }

    public static final String i1(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        return (String) lVar.invoke(obj);
    }

    public static final void j0(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void k0(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void w0(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void x0(Exception exc) {
        t9.i.g(exc, "e");
        exc.printStackTrace();
    }

    public final void A0() {
        w6.i.f19214g.b().I1().compose(this.f15033a.O1()).subscribe(new l());
    }

    public final void B0() {
        r5.i iVar = r5.i.f18523a;
        iVar.L("");
        iVar.s(this.f15033a);
        iVar.v();
        la.b.f16439b.a(m.f15071a);
    }

    public final void C0() {
        w6.i b10 = w6.i.f19214g.b();
        com.mobile.brasiltv.utils.y0 y0Var = com.mobile.brasiltv.utils.y0.f8789a;
        Observable compose = b10.l2(new SnTokenBean(y0Var.l(this.f15033a), y0Var.y(this.f15033a), y0Var.q(), y0Var.w(), y0Var.n(), y0Var.u(this.f15033a), y0Var.v(this.f15033a), y0Var.r(), y0Var.m(), ma.h.f16853a.e(this.f15033a), null, null, null, null, null, null, null, null, null, null, null, 2096128, null)).compose(this.f15033a.O1());
        final n nVar = n.f15072a;
        compose.map(new Function() { // from class: k6.o0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                SnTokenData D0;
                D0 = b1.D0(s9.l.this, obj);
                return D0;
            }
        }).subscribe(new o());
    }

    public ArrayList E0() {
        ArrayList arrayList = new ArrayList();
        String string = this.f15033a.getString(R.string.nav_button_home);
        t9.i.f(string, "context.getString(R.string.nav_button_home)");
        arrayList.add(new MainTabEntity(string, R.drawable.icon_home_select, R.drawable.icon_home, null, null, null, null, false, 0, 504, null));
        String string2 = this.f15033a.getString(R.string.nav_button_live);
        t9.i.f(string2, "context.getString(R.string.nav_button_live)");
        arrayList.add(new MainTabEntity(string2, R.drawable.icon_tv_select, R.drawable.icon_tv, null, null, null, null, false, 0, 504, null));
        arrayList.add(u0());
        return arrayList;
    }

    public final void F0() {
        w6.i.f19214g.b().S1().compose(this.f15033a.O1()).subscribe(new p());
    }

    public final i6.v G0() {
        return this.f15034b;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final void H0(String str) {
        if (str == null || str.length() == 0) {
            return;
        }
        i.c cVar = w6.i.f19214g;
        if (t9.i.b(cVar.e(), "1")) {
            String I = cVar.I();
            switch (I.hashCode()) {
                case 50:
                    if (I.equals("2")) {
                        String o10 = d6.b.f12660a.o();
                        String str2 = "vip_expire_key" + cVar.H();
                        if (com.mobile.brasiltv.utils.b0.K(o10)) {
                            App.a aVar = App.f8263e;
                            if (!t9.i.b(o10, na.f.e(aVar.a(), str2))) {
                                this.f15034b.Y(0, str);
                                na.f.k(aVar.a(), str2, o10);
                                break;
                            }
                        }
                    }
                    break;
                case 51:
                    if (I.equals("3")) {
                        int n10 = cVar.n();
                        String n11 = d6.b.f12660a.n();
                        String str3 = "vip_expire_soon_key" + cVar.H();
                        if ((4 <= n10 && n10 < 8) && com.mobile.brasiltv.utils.b0.K(n11)) {
                            App.a aVar2 = App.f8263e;
                            if (!t9.i.b(n11, na.f.e(aVar2.a(), str3))) {
                                this.f15034b.Y(cVar.n(), str);
                                na.f.k(aVar2.a(), str3, n11);
                                break;
                            }
                        }
                        if (1 <= n10 && n10 < 4) {
                            Object obj = this.f15044l.get(cVar.H());
                            Boolean bool = Boolean.TRUE;
                            if (!t9.i.b(obj, bool)) {
                                this.f15034b.Y(cVar.n(), str);
                                this.f15044l.put(cVar.H(), bool);
                                break;
                            }
                        }
                    }
                    break;
                case 52:
                    if (I.equals("4")) {
                        int z10 = cVar.z();
                        String o11 = d6.b.f12660a.o();
                        String str4 = "vip_expire_soon_key" + cVar.H();
                        if ((4 <= z10 && z10 < 8) && com.mobile.brasiltv.utils.b0.K(o11)) {
                            App.a aVar3 = App.f8263e;
                            if (!t9.i.b(o11, na.f.e(aVar3.a(), str4))) {
                                this.f15034b.Y(cVar.z(), str);
                                na.f.k(aVar3.a(), str4, o11);
                                break;
                            }
                        }
                        if (1 <= z10 && z10 < 4) {
                            Object obj2 = this.f15044l.get(cVar.H());
                            Boolean bool2 = Boolean.TRUE;
                            if (!t9.i.b(obj2, bool2)) {
                                this.f15034b.Y(cVar.z(), str);
                                this.f15044l.put(cVar.H(), bool2);
                                break;
                            }
                        }
                    }
                    break;
            }
        }
    }

    public final void I0(UpdateBean updateBean) {
        d5.c cVar = new d5.c();
        cVar.q(updateBean.getForceUpdate() == 1);
        cVar.w(updateBean.getMd5());
        cVar.y(updateBean.getUrl());
        cVar.x(updateBean.getSpareUrl());
        cVar.p(s6.a.f18777a.a().i());
        cVar.t(updateBean.getDefaultDownloadUrl());
        com.mobile.brasiltv.utils.x xVar = com.mobile.brasiltv.utils.x.f8754a;
        cVar.v(xVar.h());
        cVar.u(y5.a.f19767a);
        cVar.s(R.mipmap.ic_logo);
        cVar.r(R.mipmap.ic_logo);
        cVar.n(na.a.c());
        String r02 = r0();
        if (r02.length() == 0) {
            r02 = w6.i.f19214g.l();
        }
        cVar.z(r02);
        cVar.o(xVar.h());
        i7.a m10 = new i7.a(this.f15033a, updateBean, cVar, Boolean.FALSE).m(new h7.e() { // from class: k6.r0
            @Override // h7.e
            public final void a(DialogInterface dialogInterface, boolean z10) {
                b1.J0(b1.this, dialogInterface, z10);
            }
        });
        t9.i.f(m10, "CommonUpgradeDialog(cont…Dialog)\n                }");
        com.mobile.brasiltv.utils.b0.S(m10, DialogManager.DIALOG_UPDATE);
        xa.c.c().m(new HasNewUpdateEvent(true));
    }

    public final void K0() {
        q qVar = new q();
        String obj = m7.c.i().first.toString();
        String obj2 = m7.c.i().second.toString();
        String f10 = na.f.f(this.f15033a, "DCS_URL", "");
        t9.i.f(f10, "urlStr");
        if (f10.length() > 0) {
            List<String> M = ba.t.M(ba.s.j(ba.s.j(ba.s.j(ba.s.j(f10, obj, "", false, 4, null), obj2, "", false, 4, null), "http://", "", false, 4, null), "https://", "", false, 4, null), new String[]{"|"}, false, 0, 6, null);
            if (com.mobile.brasiltv.utils.b0.I(M)) {
                String str = "";
                String str2 = str;
                for (String str3 : M) {
                    if (str3.length() > 0) {
                        if (str.length() == 0) {
                            str = str3;
                        } else if (str2.length() == 0) {
                            str2 = str3;
                        }
                    }
                }
                if (str.length() > 0) {
                    obj = str;
                }
                if (str2.length() > 0) {
                    obj2 = str2;
                }
            }
            na.f.k(this.f15033a, "DCS_URL", "");
        }
        t2.a.f18798a.k(App.f8263e.a(), new h9.k(obj, obj2), qVar, new ja.c(".dcs"));
    }

    public final void L0() {
        if (s6.a.f18777a.a().t()) {
            MainAty.a aVar = MainAty.A;
            if (com.mobile.brasiltv.utils.b0.I(aVar.g())) {
                return;
            }
            String h10 = na.f.h(this.f15033a, "home", "home_data");
            if (!TextUtils.isEmpty(h10)) {
                ArrayList arrayList = (ArrayList) new Gson().fromJson(h10, new s().getType());
                if (com.mobile.brasiltv.utils.b0.I(arrayList)) {
                    aVar.a().clear();
                    aVar.a().addAll(arrayList);
                }
            }
            com.mobile.brasiltv.utils.n0 n0Var = com.mobile.brasiltv.utils.n0.f8733a;
            String e10 = n0Var.e(this.f15033a, "home_data_version", "");
            String e11 = n0Var.e(this.f15033a, "home_data_free_version", "");
            w6.i b10 = w6.i.f19214g.b();
            if (e10 == null) {
                e10 = "";
            }
            b10.x1(e10, e11 != null ? e11 : "").compose(this.f15033a.O1()).subscribe(new r());
        }
    }

    public final void M0() {
        g0();
        if (RootColumnId.mainId != -1) {
            k7.f.e("请求过根栏目，已加载fragment，不再加载根栏目", new Object[0]);
            return;
        }
        final t9.w wVar = new t9.w();
        final t9.w wVar2 = new t9.w();
        Observable compose = Observable.create(new ObservableOnSubscribe() { // from class: k6.v0
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(ObservableEmitter observableEmitter) {
                b1.N0(t9.w.this, this, wVar2, observableEmitter);
            }
        }).compose(ma.q.b());
        final t tVar = new t(wVar2, this);
        compose.subscribe(new Consumer() { // from class: k6.w0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                b1.O0(s9.l.this, obj);
            }
        });
    }

    public final void P0(String str, String str2, String str3, String str4, String str5) {
        t9.i.g(str, "userName");
        t9.i.g(str2, "password");
        t9.i.g(str3, "verificationToken");
        t9.i.g(str4, "qrAuthCode");
        t9.i.g(str5, "areaCode");
        d6.b bVar = d6.b.f12660a;
        bVar.h(this.f15033a);
        t9.w wVar = new t9.w();
        wVar.f18961a = bVar.j(this.f15033a);
        k7.f.e("loginType:" + ((String) wVar.f18961a), new Object[0]);
        t9.w wVar2 = new t9.w();
        wVar2.f18961a = str;
        if (TextUtils.equals((CharSequence) wVar.f18961a, "4")) {
            wVar.f18961a = CdnType.DIGITAL_TYPE_PCDN;
        }
        if (t9.i.b(wVar.f18961a, "7")) {
            if (str4.length() > 0) {
                wVar2.f18961a = str4;
            }
        }
        w6.i.f19214g.b().W1((String) wVar.f18961a, str5, (String) wVar2.f18961a, str2, null, null, str3).compose(this.f15033a.O1()).subscribe(new u(wVar, str, str2, str4, str5, wVar2, str3));
    }

    public final void Q0(String str, String str2) {
        w6.i.f19214g.b().Z1(new LoginThirdPartBean(str, str2, "0", "1", null, 16, null)).compose(this.f15033a.O1()).subscribe(new v(str, str2));
    }

    public final void R0() {
        if (TextUtils.isEmpty(w6.i.f19214g.E())) {
            k7.f.e("不存在SN，获取SNToken", new Object[0]);
            C0();
            return;
        }
        MemberInfo memberInfo = MemberInfo.INSTANCE;
        String lastUserName = memberInfo.getLastUserName();
        String lastPassword = memberInfo.getLastPassword();
        String e10 = na.f.e(this.f15033a, "verification_token");
        String e11 = na.f.e(this.f15033a, "qr_auth_code");
        String e12 = na.f.e(this.f15033a, "login_area_code");
        d6.b bVar = d6.b.f12660a;
        bVar.h(this.f15033a);
        String j10 = bVar.j(this.f15033a);
        String k10 = bVar.k(this.f15033a);
        if (bVar.v(this.f15033a) && com.mobile.brasiltv.utils.b0.K(k10)) {
            com.mobile.brasiltv.utils.b0.U(this, "tp type login");
            Q0(j10, k10);
            return;
        }
        if (TextUtils.isEmpty(e11) && (TextUtils.isEmpty(lastUserName) || (TextUtils.isEmpty(lastPassword) && TextUtils.isEmpty(e10)))) {
            k7.f.e("存在SN，不存在用户名密码，激活", new Object[0]);
            Z();
            return;
        }
        k7.f.e("存在用户名密码，登录", new Object[0]);
        t9.i.f(e10, "verificationToken");
        t9.i.f(e11, "qrAuthCode");
        t9.i.f(e12, "areaCode");
        P0(lastUserName, lastPassword, e10, e11, e12);
    }

    public final void S0() {
        t9.w wVar = new t9.w();
        StringBuilder sb = new StringBuilder();
        i.c cVar = w6.i.f19214g;
        sb.append(cVar.H());
        sb.append("isHasCouponQualification");
        String sb2 = sb.toString();
        String str = cVar.H() + "couponQualificationTime";
        String str2 = cVar.H() + "couponQualificationInvalidTime";
        String f10 = na.f.f(this.f15033a, str, "0");
        t9.i.f(f10, "getStrings(context, spKeyTime, \"0\")");
        long parseLong = Long.parseLong(f10);
        String f11 = na.f.f(this.f15033a, str2, "0");
        t9.i.f(f11, "getStrings(context, spKeyInvalidTime, \"0\")");
        if (y6.a.j() - parseLong < Long.parseLong(f11)) {
            cVar.i0(na.f.c(this.f15033a, sb2, false));
        } else {
            wVar.f18961a = "1";
        }
        Observable compose = cVar.b().M0("0", (String) wVar.f18961a).compose(this.f15033a.O1());
        final x xVar = x.f15099a;
        compose.filter(new Predicate() { // from class: k6.x0
            @Override // io.reactivex.functions.Predicate
            public final boolean test(Object obj) {
                boolean T0;
                T0 = b1.T0(s9.l.this, obj);
                return T0;
            }
        }).observeOn(Schedulers.computation()).subscribe(new y(wVar, this, sb2, str, str2));
    }

    public final void U0() {
        IntentFilter intentFilter = new IntentFilter("android.intent.action.BATTERY_CHANGED");
        z zVar = new z();
        this.f15045m = zVar;
        this.f15033a.registerReceiver(zVar, intentFilter);
    }

    public final void V0() {
        w6.i.f19214g.b().U0().compose(this.f15033a.O1()).subscribe(new a0());
    }

    public final void W0() {
        RootColumnId.mainId = -1;
        i.c cVar = w6.i.f19214g;
        k7.f.e("sn：" + (cVar.E().length() > 0 ? cVar.E() : ""), new Object[0]);
        boolean j10 = t2.a.f18798a.j();
        z2.c a10 = z2.c.f20149d.a();
        String E = cVar.E();
        String g10 = na.a.g();
        t9.i.f(g10, "getPackageName()");
        String str = Build.VERSION.RELEASE;
        t9.i.f(str, "RELEASE");
        String str2 = na.c.f17340b;
        t9.i.f(str2, "encryptReserve1");
        a10.g(E, "", "", null, null, g10, str, str2, 1, r0(), s0()).compose(this.f15033a.P1(t8.a.DESTROY)).subscribe(new b0(j10));
        if (j10) {
            R0();
            F0();
        }
    }

    public final void X0() {
        i.c cVar = w6.i.f19214g;
        String I = cVar.I();
        if (t9.i.b(I, "3") || t9.i.b(I, "4") || t9.i.b(cVar.e(), "0")) {
            com.mobile.brasiltv.utils.n0 n0Var = com.mobile.brasiltv.utils.n0.f8733a;
            if (!com.mobile.brasiltv.utils.n0.c(n0Var, this.f15033a, "live_first_play_free_column", false, 4, null)) {
                n0Var.i(this.f15033a, "live_last_play_column_index", 0);
                z.a aVar = b6.z.f5049u;
                String c10 = com.mobile.brasiltv.utils.b0.H(aVar.c()) ? aVar.c() : "";
                n0Var.j(this.f15033a, "live_last_play_chanel", c10);
                aVar.n(c10);
            }
            com.mobile.brasiltv.utils.n0.h(n0Var, this.f15033a, "live_first_play_free_column", false, 4, null);
        }
    }

    public final void Y0() {
        DialogManager.INSTANCE.reset();
    }

    public final void Z() {
        Disposable disposable = this.f15037e;
        if (disposable != null) {
            disposable.dispose();
        }
        w6.i.f19214g.b().J0().subscribe(new a());
    }

    public final void Z0(final SwitchAccountBean switchAccountBean) {
        Observable compose = Observable.create(new ObservableOnSubscribe() { // from class: k6.l0
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(ObservableEmitter observableEmitter) {
                b1.a1(b1.this, switchAccountBean, observableEmitter);
            }
        }).compose(ma.q.b());
        final c0 c0Var = new c0();
        Consumer consumer = new Consumer() { // from class: k6.m0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                b1.b1(s9.l.this, obj);
            }
        };
        final d0 d0Var = new d0();
        compose.subscribe(consumer, new Consumer() { // from class: k6.n0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                b1.c1(s9.l.this, obj);
            }
        });
    }

    public final void a0(UserData userData) {
        k7.f.e("cacheColumnTime: userData: " + userData, new Object[0]);
        if (com.mobile.brasiltv.utils.b0.J(userData != null ? userData.getCacheTime() : null)) {
            return;
        }
        if (t9.i.b(userData != null ? userData.getCacheTime() : null, "0")) {
            return;
        }
        String cacheTime = userData != null ? userData.getCacheTime() : null;
        t9.i.d(cacheTime);
        List M = ba.t.M(cacheTime, new String[]{","}, false, 0, 6, null);
        if (!M.isEmpty()) {
            if (M.size() > 1) {
                na.f.j(this.f15033a, "column_cache_time", Integer.parseInt((String) M.get(0)) + Integer.parseInt((String) M.get(1)));
            }
        } else {
            f5.c cVar = this.f15033a;
            String cacheTime2 = userData.getCacheTime();
            t9.i.d(cacheTime2);
            na.f.j(cVar, "column_cache_time", Integer.parseInt(cacheTime2));
        }
    }

    public final void b0(int i10) {
        long days = i10 - TimeUnit.MILLISECONDS.toDays(Math.abs(new Date(com.mobile.brasiltv.utils.b0.Z(na.e.f17344d)).getTime() - new Date(com.mobile.brasiltv.utils.b0.Z(com.mobile.brasiltv.utils.n0.f8733a.e(this.f15033a, "first_active_time_new", "0"))).getTime()));
        if (days > 0) {
            d0(false, (int) days);
        } else {
            e0(this, true, 0, 2, null);
        }
    }

    public final void c0() {
        s1.m mVar = s1.m.f18686a;
        f5.c cVar = this.f15033a;
        i.c cVar2 = w6.i.f19214g;
        mVar.Y(cVar, cVar2.E(), cVar2.l(), new ja.c(".advert"), new d(), (r20 & 32) != 0 ? "1.0" : null, (r20 & 64) != 0 ? false : false, (r20 & 128) != 0 ? null : new la.a(".advert"));
    }

    public final void d0(boolean z10, int i10) {
        if (z10) {
            this.f15034b.m1();
        } else {
            this.f15034b.a2(i10);
        }
    }

    public final void d1(String str, boolean z10) {
        i.c cVar = w6.i.f19214g;
        cVar.a0(str);
        cVar.w0("1");
        s1.m.f18686a.e0(cVar.E(), cVar.l());
        c2.l.f5383a.e(cVar.l(), cVar.E());
        if (z10) {
            com.mobile.brasiltv.utils.y0.f8789a.N(this.f15033a);
        }
    }

    @Override // l5.a
    public void e() {
        if (!xa.c.c().h(this)) {
            xa.c.c().o(this);
        }
        Observable create = Observable.create(new ObservableOnSubscribe() { // from class: k6.k0
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(ObservableEmitter observableEmitter) {
                b1.h1(b1.this, observableEmitter);
            }
        });
        final e0 e0Var = new e0();
        Observable compose = create.map(new Function() { // from class: k6.s0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                String i12;
                i12 = b1.i1(s9.l.this, obj);
                return i12;
            }
        }).compose(ma.q.b());
        final f0 f0Var = new f0();
        Consumer consumer = new Consumer() { // from class: k6.t0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                b1.f1(s9.l.this, obj);
            }
        };
        final g0 g0Var = g0.f15062a;
        compose.subscribe(consumer, new Consumer() { // from class: k6.u0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                b1.g1(s9.l.this, obj);
            }
        });
    }

    public final void e1() {
        if (w6.i.f19214g.N()) {
            com.mobile.brasiltv.utils.e0.f8646a.e(App.f8263e.a(), "keyShowVodFreeIntro", true);
        }
    }

    public final void f0(UserData userData) {
        if (t9.i.b(userData != null ? userData.getBindMail() : null, "0")) {
            com.mobile.brasiltv.utils.n0 n0Var = com.mobile.brasiltv.utils.n0.f8733a;
            if (t9.i.b(n0Var.e(this.f15033a, "first_active_time_new", "0"), "0")) {
                n0Var.j(this.f15033a, "first_active_time_new", na.e.f17344d);
            }
            V0();
        }
    }

    @Override // l5.a
    public void g() {
        if (xa.c.c().h(this)) {
            xa.c.c().r(this);
        }
        z0().f();
        Disposable disposable = this.f15037e;
        if (disposable != null) {
            disposable.dispose();
        }
        this.f15033a.stopService(NetService.f8586h.a());
        String language = Locale.getDefault().getLanguage();
        StringBuilder sb = new StringBuilder();
        sb.append("old language: ");
        MainAty.a aVar = MainAty.A;
        sb.append(aVar.b());
        sb.append(" cur language: ");
        sb.append(language);
        com.mobile.brasiltv.utils.b0.U(this, sb.toString());
        if (!TextUtils.equals(aVar.b(), language)) {
            t9.i.f(language, "curLanguage");
            aVar.k(language);
            return;
        }
        aVar.p(false);
        v5.g.f19112a.p();
        r5.i.f18523a.J();
        d6.b.f12660a.A();
        w5.m.f19178a.X();
        com.mobile.brasiltv.utils.f1.f8649a.v();
        j1();
        ma.l.a("MainAty");
    }

    public final void g0() {
        if (this.f15036d) {
            return;
        }
        if (!com.mobile.brasiltv.utils.b0.h(this.f15033a, "com.android.vending")) {
            com.mobile.brasiltv.utils.i1.q(this.f15033a, w6.i.f19214g.l());
        }
        w7.a aVar = w7.a.f19265a;
        f5.c cVar = this.f15033a;
        String string = cVar.getResources().getString(R.string.server_client_id);
        t9.i.f(string, "context.resources.getStr….string.server_client_id)");
        z7.b a10 = aVar.a(cVar, 1, string);
        int c10 = a10.c(this.f15033a);
        this.f15036d = true;
        if (a10.a(c10)) {
            return;
        }
        com.mobile.brasiltv.utils.i1.x(this.f15033a, w6.i.f19214g.l(), c10);
    }

    @xa.j
    public final void getFreeTimeEvent(GetFreeTimeEvent getFreeTimeEvent) {
        t9.i.g(getFreeTimeEvent, "event");
        p0();
        S0();
    }

    public final void h0() {
        f5.c cVar = this.f15033a;
        i.c cVar2 = w6.i.f19214g;
        Observable b10 = CheckNoticeUtils.b(cVar, cVar2.l(), cVar2.H());
        final e eVar = e.f15057a;
        Observable filter = b10.filter(new Predicate() { // from class: k6.y0
            @Override // io.reactivex.functions.Predicate
            public final boolean test(Object obj) {
                boolean i02;
                i02 = b1.i0(s9.l.this, obj);
                return i02;
            }
        });
        final f fVar = new f();
        Consumer consumer = new Consumer() { // from class: k6.z0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                b1.j0(s9.l.this, obj);
            }
        };
        final g gVar = g.f15061a;
        filter.subscribe(consumer, new Consumer() { // from class: k6.a1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                b1.k0(s9.l.this, obj);
            }
        });
    }

    public final void j1() {
        BroadcastReceiver broadcastReceiver = this.f15045m;
        if (broadcastReceiver != null) {
            this.f15033a.unregisterReceiver(broadcastReceiver);
            this.f15045m = null;
            this.f15046n = null;
        }
    }

    public final void k1(List list, long j10) {
        String i10 = y6.a.i(j10, "yyyy-MM-dd");
        v5.g gVar = v5.g.f19112a;
        gVar.v(0);
        gVar.g(list.size());
        Iterator it = list.iterator();
        String str = "";
        while (it.hasNext()) {
            CouponCodeList couponCodeList = (CouponCodeList) it.next();
            if (t9.i.b(couponCodeList.getStatus(), "0")) {
                if (couponCodeList.getInvalidTime().length() > 0) {
                    long m10 = y6.a.m(couponCodeList.getInvalidTime(), "yyyy-MM-dd HH:mm:ss") / 1000;
                    String substring = couponCodeList.getInvalidTime().substring(0, 11);
                    t9.i.f(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                    if (!(str.length() > 0) || substring.compareTo(str) <= 0) {
                        long j11 = m10 - j10;
                        if (j11 > 0 && j11 < 259200) {
                            if ((str.length() == 0) || str.compareTo(substring) > 0) {
                                str = substring;
                            }
                            if (t9.i.b(str, i10)) {
                                break;
                            }
                        }
                    }
                } else {
                    continue;
                }
            }
        }
        if (str.length() == 0) {
            return;
        }
        f5.c cVar = this.f15033a;
        StringBuilder sb = new StringBuilder();
        i.c cVar2 = w6.i.f19214g;
        sb.append(cVar2.H());
        sb.append("coupon_date_key");
        String f10 = na.f.f(cVar, sb.toString(), "");
        if (t9.i.b(f10, str) || f10.compareTo(str) >= 0) {
            return;
        }
        na.f.k(this.f15033a, cVar2.H() + "coupon_date_key", str);
        this.f15034b.v1();
    }

    public final void l0() {
        h7.h.f(new u6.c());
        c5.a z02 = z0();
        f5.c cVar = this.f15033a;
        i.c cVar2 = w6.i.f19214g;
        z02.g(cVar, cVar2.E(), cVar2.l(), new h());
    }

    public final void l1() {
        String e10 = na.a.e();
        t9.i.f(e10, "getDeviceToken()");
        if (e10.length() == 0) {
            return;
        }
        w6.i.f19214g.b().o2().compose(this.f15033a.O1()).subscribe(new h0());
    }

    @xa.j
    public final void loginSuccess(LoginSuccessEvent loginSuccessEvent) {
        t9.i.g(loginSuccessEvent, "event");
        com.mobile.brasiltv.utils.k.f8726a.a();
        X0();
        DialogManager.INSTANCE.clearSaveDialog(DialogManager.DIALOG_EXPIRED, DialogManager.DIALOG_NEW_BIND);
        this.f15034b.k0();
        MainAty.A.o(true);
        n0();
        l1();
    }

    public final void m0() {
        List M = ba.t.M(s6.a.f18777a.a().f(this.f15033a), new String[]{File.separator + "%s"}, false, 0, 6, null);
        if (M == null || M.isEmpty()) {
            return;
        }
        try {
            z6.a.b(new File((String) M.get(0)));
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public final void n0() {
        com.mobile.brasiltv.utils.h hVar = com.mobile.brasiltv.utils.h.f8694a;
        if (hVar.o()) {
            xa.c.c().j(new CastToCloseOtherPlayEvent(hVar.s() ? "VOD" : "LIVE", true));
        }
    }

    public void o0() {
        SessionManager sessionManager;
        if (System.currentTimeMillis() - this.f15041i > 2000) {
            com.mobile.brasiltv.utils.f1.f8649a.w(R.string.twice_end_koocan);
            this.f15041i = System.currentTimeMillis();
            return;
        }
        if (s6.a.f18777a.a().p()) {
            com.mobile.brasiltv.utils.g0.f8670a.b();
            CastContext sharedInstance = CastContext.getSharedInstance();
            if (sharedInstance != null && (sessionManager = sharedInstance.getSessionManager()) != null) {
                sessionManager.endCurrentSession(true);
            }
        }
        Object systemService = this.f15033a.getSystemService("notification");
        t9.i.e(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        ((NotificationManager) systemService).cancelAll();
        q8.e.a("stop");
        c2.i.f5350q.a().h();
        b6.z.f5049u.g().clear();
        this.f15033a.finish();
        ma.h.f16853a.d(this.f15033a, "");
    }

    public final void p0() {
        w6.i.f19214g.b().d1().subscribe(new i());
    }

    public final void q0(UserData userData) {
        k7.f.e("不请求授权信息接口", new Object[0]);
        i.c cVar = w6.i.f19214g;
        t9.i.d(userData);
        cVar.t0(userData.getShowFlag());
        String bindMail = userData.getBindMail();
        if (bindMail == null) {
            bindMail = "0";
        }
        cVar.T(bindMail);
        cVar.g0(userData.getHasPay());
        cVar.q0(userData.getRestrictedStatus());
        cVar.h0(userData.getHasPwd());
        cVar.y0(userData.getUserIdentity());
        String childLockPwd = userData.getChildLockPwd();
        if (childLockPwd == null) {
            childLockPwd = "";
        }
        cVar.W(childLockPwd);
        Integer remainingDays = userData.getRemainingDays();
        cVar.p0(remainingDays != null ? remainingDays.intValue() : 0);
        Integer expRemainingDays = userData.getExpRemainingDays();
        cVar.c0(expRemainingDays != null ? expRemainingDays.intValue() : 0);
        String qrcodeMessage = userData.getQrcodeMessage();
        if (qrcodeMessage == null) {
            qrcodeMessage = "";
        }
        cVar.o0(qrcodeMessage);
        cVar.P(userData.getActiveTime());
        String playlistUrl = userData.getPlaylistUrl();
        if (playlistUrl == null) {
            playlistUrl = "";
        }
        cVar.k0(playlistUrl);
        d6.b.f12660a.B(userData.getAuthInfoList());
        String tips = userData.getTips();
        H0(tips != null ? tips : "");
        cVar.S(cVar.y() + "?lang=" + com.mobile.brasiltv.utils.f0.a() + "&userId=" + cVar.H() + "&packageId=&appId=" + na.a.g() + "&packageType=1&appVersion=" + na.a.b() + "&timeStamp=" + System.currentTimeMillis() + "&tk=" + cVar.J() + "&loginType=3");
        StringBuilder sb = new StringBuilder();
        sb.append("购买VIP连接：");
        sb.append(cVar.g());
        k7.f.e(sb.toString(), new Object[0]);
        if (t9.i.b(userData.getGetFreeAuthFlag(), "yes") && t9.i.b(userData.getUserIdentity(), "1") && t9.i.b(userData.getHasPay(), "0") && t9.i.b(userData.getHasFreeAuth(), "0")) {
            y0();
        }
        B0();
        xa.c.c().m(new UpdateMineViewEvent());
    }

    public final String r0() {
        return (String) this.f15039g.getValue();
    }

    @xa.j
    public final void requestActive(RequestActiveEvent requestActiveEvent) {
        NoticeDialog noticeDialog;
        t9.i.g(requestActiveEvent, "event");
        boolean z10 = false;
        k7.f.e("收到请求激活事件", new Object[0]);
        Z();
        DialogManager.INSTANCE.clearSaveDialog(DialogManager.DIALOG_EXPIRED, DialogManager.DIALOG_NEW_BIND, DialogManager.DIALOG_NOTICE);
        this.f15034b.k0();
        NoticeDialog noticeDialog2 = this.f15038f;
        if (noticeDialog2 != null && noticeDialog2.isShowing()) {
            z10 = true;
        }
        if (z10 && (noticeDialog = this.f15038f) != null) {
            com.mobile.brasiltv.utils.b0.j(noticeDialog);
        }
        MainAty.A.o(true);
        n0();
    }

    @xa.j
    public final void requestAuthAndSlb(RequestAuthAndSlbEvent requestAuthAndSlbEvent) {
        t9.i.g(requestAuthAndSlbEvent, "event");
        k7.f.e("收到请求授权信息和slb事件", new Object[0]);
        h0();
        M0();
        L0();
        if (requestAuthAndSlbEvent.isNeedGetAuthInfo() || requestAuthAndSlbEvent.getUserData() == null) {
            p0();
        } else {
            q0(requestAuthAndSlbEvent.getUserData());
        }
        S0();
        d6.a.f12650a.k();
    }

    public final String s0() {
        return (String) this.f15040h.getValue();
    }

    public final f5.c t0() {
        return this.f15033a;
    }

    public final MainTabEntity u0() {
        String d10 = y6.a.d("MM-dd HH:mm");
        if (d10.compareTo("10-28 00:00:00") > 0 && d10.compareTo("11-04 00:00:00") < 0) {
            String string = this.f15033a.getString(R.string.nav_button_mine);
            t9.i.f(string, "context.getString(R.string.nav_button_mine)");
            return new MainTabEntity(string, R.drawable.icon_my_halloween_select, R.drawable.icon_my_halloween, null, null, null, null, false, 0, 504, null);
        }
        if (d10.compareTo("12-22 00:00:00") > 0 && d10.compareTo("12-29 00:00:00") < 0) {
            String string2 = this.f15033a.getString(R.string.nav_button_mine);
            t9.i.f(string2, "context.getString(R.string.nav_button_mine)");
            return new MainTabEntity(string2, R.drawable.icon_my_christmas_select, R.drawable.icon_my_christmas, null, null, null, null, false, 0, 504, null);
        }
        if (d10.compareTo("12-29 00:00:00") > 0 || d10.compareTo("01-05 00:00:00") < 0) {
            String string3 = this.f15033a.getString(R.string.nav_button_mine);
            t9.i.f(string3, "context.getString(R.string.nav_button_mine)");
            return new MainTabEntity(string3, R.drawable.icon_my_new_years_select, R.drawable.icon_my_new_years, null, null, null, null, false, 0, 504, null);
        }
        String string4 = this.f15033a.getString(R.string.nav_button_mine);
        t9.i.f(string4, "context.getString(R.string.nav_button_mine)");
        return new MainTabEntity(string4, R.drawable.icon_my_select, R.drawable.icon_my, null, null, null, null, false, 0, 504, null);
    }

    public final void v0() {
        Task<PendingDynamicLinkData> dynamicLink = FirebaseDynamicLinksKt.getDynamicLinks(Firebase.INSTANCE).getDynamicLink(this.f15033a.getIntent());
        f5.c cVar = this.f15033a;
        final j jVar = new j();
        dynamicLink.addOnSuccessListener(cVar, new OnSuccessListener() { // from class: k6.p0
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                b1.w0(s9.l.this, obj);
            }
        }).addOnFailureListener(this.f15033a, new OnFailureListener() { // from class: k6.q0
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                b1.x0(exc);
            }
        });
    }

    public final void y0() {
        w6.i.f19214g.b().w1().compose(this.f15033a.O1()).subscribe(new k());
    }

    public final c5.a z0() {
        return (c5.a) this.f15042j.getValue();
    }
}
