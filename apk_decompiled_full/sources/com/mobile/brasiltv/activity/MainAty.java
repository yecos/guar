package com.mobile.brasiltv.activity;

import android.app.Dialog;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import b6.d3;
import b6.r3;
import b6.z;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.hpplay.sdk.source.common.global.Constant;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.activity.MainAty;
import com.mobile.brasiltv.bean.MainTabEntity;
import com.mobile.brasiltv.bean.RootColumnId;
import com.mobile.brasiltv.bean.SubtitleManager;
import com.mobile.brasiltv.bean.event.CastPlaySuccessEvent;
import com.mobile.brasiltv.bean.event.CastToCloseFloatViewEvent;
import com.mobile.brasiltv.bean.event.CastToCloseOtherPlayEvent;
import com.mobile.brasiltv.bean.event.GotoCREvent;
import com.mobile.brasiltv.bean.event.GotoHomeTabEvent;
import com.mobile.brasiltv.bean.event.VodPageRestartEvent;
import com.mobile.brasiltv.business.message.inapp.bean.InAppMsg;
import com.mobile.brasiltv.mine.activity.EmailAty;
import com.mobile.brasiltv.mine.activity.LoginAty;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.utils.i1;
import com.mobile.brasiltv.utils.n0;
import com.mobile.brasiltv.utils.p0;
import com.mobile.brasiltv.utils.s0;
import com.mobile.brasiltv.view.AutoText;
import com.mobile.brasiltv.view.KoocanEmptyView;
import com.mobile.brasiltv.view.KoocanNetTabLayout;
import com.mobile.brasiltv.view.NoScrollViewPager;
import com.mobile.brasiltv.view.OpenNotifyDialog;
import com.mobile.brasiltv.view.dialog.CouponDialog;
import com.mobile.brasiltv.view.dialog.DialogManager;
import com.mobile.brasiltv.view.dialog.ForceBindDialog;
import com.mobile.brasiltv.view.dialog.ForceBindNormalDialog;
import com.mobile.brasiltv.view.dialog.ServiceExpirationTipDialog;
import com.mobile.brasiltv.view.dialog.StandardDialog;
import com.msandroid.mobile.R;
import com.zhy.autolayout.AutoLinearLayout;
import com.zhy.autolayout.AutoRelativeLayout;
import com.zhy.autolayout.utils.AutoUtils;
import g5.x0;
import h9.t;
import i6.g0;
import i6.u;
import i6.v;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Callable;
import k6.b1;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: classes.dex */
public final class MainAty extends f5.d implements v {
    public static boolean C;
    public static boolean D;
    public static boolean G;
    public static boolean I;

    /* renamed from: l, reason: collision with root package name */
    public ServiceExpirationTipDialog f7907l;

    /* renamed from: m, reason: collision with root package name */
    public CouponDialog f7908m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f7909n;

    /* renamed from: t, reason: collision with root package name */
    public r3 f7915t;

    /* renamed from: u, reason: collision with root package name */
    public z f7916u;

    /* renamed from: v, reason: collision with root package name */
    public d3 f7917v;

    /* renamed from: w, reason: collision with root package name */
    public t6.c f7918w;

    /* renamed from: x, reason: collision with root package name */
    public t6.b f7919x;

    /* renamed from: y, reason: collision with root package name */
    public b1 f7920y;
    public static final a A = new a(null);
    public static String B = "";
    public static ArrayList E = new ArrayList();
    public static ArrayList F = new ArrayList();
    public static boolean H = true;
    public static float J = -1.0f;
    public static int K = 1;
    public static int L = 1;

    /* renamed from: z, reason: collision with root package name */
    public Map f7921z = new LinkedHashMap();

    /* renamed from: o, reason: collision with root package name */
    public z5.c f7910o = new z5.c();

    /* renamed from: p, reason: collision with root package name */
    public final h9.g f7911p = h9.h.b(new b());

    /* renamed from: q, reason: collision with root package name */
    public final h9.g f7912q = h9.h.b(new l());

    /* renamed from: r, reason: collision with root package name */
    public final h9.g f7913r = h9.h.b(j.f7930a);

    /* renamed from: s, reason: collision with root package name */
    public final h9.g f7914s = h9.h.b(k.f7931a);

    /* loaded from: classes3.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(t9.g gVar) {
            this();
        }

        public final ArrayList a() {
            return MainAty.F;
        }

        public final String b() {
            return MainAty.B;
        }

        public final float c() {
            return MainAty.J;
        }

        public final int d() {
            return MainAty.K;
        }

        public final int e() {
            return MainAty.L;
        }

        public final boolean f() {
            return MainAty.H;
        }

        public final ArrayList g() {
            return MainAty.E;
        }

        public final boolean h() {
            return MainAty.C;
        }

        public final boolean i() {
            return MainAty.I;
        }

        public final void j(boolean z10) {
            MainAty.G = z10;
        }

        public final void k(String str) {
            t9.i.g(str, "<set-?>");
            MainAty.B = str;
        }

        public final void l(float f10) {
            MainAty.J = f10;
        }

        public final void m(int i10) {
            MainAty.K = i10;
        }

        public final void n(int i10) {
            MainAty.L = i10;
        }

        public final void o(boolean z10) {
            MainAty.H = z10;
        }

        public final void p(boolean z10) {
            MainAty.C = z10;
        }

        public final void q(boolean z10) {
            MainAty.D = z10;
        }

        public final void r(boolean z10) {
            MainAty.I = z10;
        }
    }

    /* loaded from: classes3.dex */
    public static final class b extends t9.j implements s9.a {
        public b() {
            super(0);
        }

        @Override // s9.a
        public final Integer invoke() {
            return Integer.valueOf(n5.a.f17268a.a(MainAty.this));
        }
    }

    /* loaded from: classes3.dex */
    public static final class c extends t9.j implements s9.l {
        public c() {
            super(1);
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Boolean) obj);
            return t.f14242a;
        }

        public final void invoke(Boolean bool) {
            t9.i.f(bool, "granted");
            if (bool.booleanValue()) {
                return;
            }
            MainAty.this.s4();
        }
    }

    /* loaded from: classes3.dex */
    public static final class d implements w5.n {
        public d() {
        }

        @Override // w5.n
        public void a(InAppMsg inAppMsg) {
            t9.i.g(inAppMsg, Constant.KEY_MSG);
            if (t9.i.b(d6.b.f12660a.l(), inAppMsg.getUserId())) {
                w5.m mVar = w5.m.f19178a;
                if (mVar.v(inAppMsg, mVar.B()) || mVar.v(inAppMsg, mVar.A())) {
                    MainAty.this.l4();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class e implements w5.n {
        public e() {
        }

        @Override // w5.n
        public void a(InAppMsg inAppMsg) {
            t9.i.g(inAppMsg, Constant.KEY_MSG);
            if (t9.i.b(d6.b.f12660a.l(), inAppMsg.getUserId())) {
                w5.m mVar = w5.m.f19178a;
                if (mVar.v(inAppMsg, mVar.x()) || mVar.v(inAppMsg, mVar.y()) || mVar.v(inAppMsg, mVar.z())) {
                    MainAty.this.l4();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class f implements v5.h {
        public f() {
        }

        public static final void c(MainAty mainAty) {
            t9.i.g(mainAty, "this$0");
            v5.g gVar = v5.g.f19112a;
            if (gVar.n() + gVar.k() + gVar.l() == 0) {
                ((KoocanNetTabLayout) mainAty.g3(R$id.mainAtyTab)).hideMsg(2);
            } else {
                ((KoocanNetTabLayout) mainAty.g3(R$id.mainAtyTab)).showDot(2);
            }
        }

        @Override // v5.h
        public void a() {
            KoocanNetTabLayout koocanNetTabLayout = (KoocanNetTabLayout) MainAty.this.g3(R$id.mainAtyTab);
            final MainAty mainAty = MainAty.this;
            koocanNetTabLayout.post(new Runnable() { // from class: f5.h1
                @Override // java.lang.Runnable
                public final void run() {
                    MainAty.f.c(MainAty.this);
                }
            });
        }
    }

    /* loaded from: classes3.dex */
    public static final class g extends t9.j implements s9.l {

        /* renamed from: a, reason: collision with root package name */
        public static final g f7927a = new g();

        public g() {
            super(1);
        }

        public final void b(Integer num) {
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            b((Integer) obj);
            return t.f14242a;
        }
    }

    /* loaded from: classes3.dex */
    public static final class h extends t9.j implements s9.l {

        /* renamed from: a, reason: collision with root package name */
        public static final h f7928a = new h();

        public h() {
            super(1);
        }

        public final void invoke(Throwable th) {
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return t.f14242a;
        }
    }

    /* loaded from: classes3.dex */
    public static final class i implements OnTabSelectListener {
        public i() {
        }

        @Override // com.flyco.tablayout.listener.OnTabSelectListener
        public void onTabReselect(int i10) {
        }

        @Override // com.flyco.tablayout.listener.OnTabSelectListener
        public void onTabSelect(int i10) {
            MainAty.this.z4(i10);
            if (i10 == 0) {
                ((NoScrollViewPager) MainAty.this.g3(R$id.mainViewPager)).setCurrentItem(0, false);
                b0.N(MainAty.this);
                com.mobile.brasiltv.utils.h hVar = com.mobile.brasiltv.utils.h.f8694a;
                if (hVar.o() && hVar.s()) {
                    ((ImageView) MainAty.this.g3(R$id.ivCastFloat)).setVisibility(0);
                }
            } else if (i10 == 1) {
                ((NoScrollViewPager) MainAty.this.g3(R$id.mainViewPager)).setCurrentItem(1, false);
                b0.O(MainAty.this, MainAty.A.c());
                com.mobile.brasiltv.utils.h hVar2 = com.mobile.brasiltv.utils.h.f8694a;
                if (hVar2.o() && hVar2.s()) {
                    ((ImageView) MainAty.this.g3(R$id.ivCastFloat)).setVisibility(8);
                }
            } else if (i10 == 2) {
                MainAty.this.k4();
                ((NoScrollViewPager) MainAty.this.g3(R$id.mainViewPager)).setCurrentItem(2, false);
                b0.N(MainAty.this);
                com.mobile.brasiltv.utils.h hVar3 = com.mobile.brasiltv.utils.h.f8694a;
                if (hVar3.o() && hVar3.s()) {
                    ((ImageView) MainAty.this.g3(R$id.ivCastFloat)).setVisibility(0);
                }
            }
            MainAty.this.M3();
        }
    }

    /* loaded from: classes3.dex */
    public static final class j extends t9.j implements s9.a {

        /* renamed from: a, reason: collision with root package name */
        public static final j f7930a = new j();

        public j() {
            super(0);
        }

        @Override // s9.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final ArrayList invoke() {
            return new ArrayList();
        }
    }

    /* loaded from: classes3.dex */
    public static final class k extends t9.j implements s9.a {

        /* renamed from: a, reason: collision with root package name */
        public static final k f7931a = new k();

        public k() {
            super(0);
        }

        @Override // s9.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final ArrayList invoke() {
            return new ArrayList();
        }
    }

    /* loaded from: classes3.dex */
    public static final class l extends t9.j implements s9.a {
        public l() {
            super(0);
        }

        @Override // s9.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final x0 invoke() {
            androidx.fragment.app.o supportFragmentManager = MainAty.this.getSupportFragmentManager();
            t9.i.f(supportFragmentManager, "supportFragmentManager");
            return new x0(supportFragmentManager, MainAty.this.Q3(), MainAty.this.R3());
        }
    }

    /* loaded from: classes3.dex */
    public static final class m extends t9.j implements s9.l {
        public m() {
            super(1);
        }

        public final void b(List list) {
            t9.i.g(list, "it");
            if (b0.I(list)) {
                w5.m.f19178a.W(MainAty.this.Q1(), (InAppMsg) list.get(0));
            }
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            b((List) obj);
            return t.f14242a;
        }
    }

    /* loaded from: classes3.dex */
    public static final class o extends t9.j implements s9.a {
        public o() {
            super(0);
        }

        /* renamed from: invoke, reason: collision with other method in class */
        public final void m53invoke() {
            b0.c0(MainAty.this, LoginAty.class);
        }

        @Override // s9.a
        public /* bridge */ /* synthetic */ Object invoke() {
            m53invoke();
            return t.f14242a;
        }
    }

    /* loaded from: classes3.dex */
    public static final class q implements OpenNotifyDialog.NotificationListener {
        @Override // com.mobile.brasiltv.view.OpenNotifyDialog.NotificationListener
        public void onOpen(Dialog dialog) {
            t9.i.g(dialog, "dialog");
            b0.j(dialog);
        }
    }

    /* loaded from: classes3.dex */
    public static final class r extends t9.j implements s9.l {
        public r() {
            super(1);
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Boolean) obj);
            return t.f14242a;
        }

        public final void invoke(Boolean bool) {
            t9.i.f(bool, "it");
            if (bool.booleanValue()) {
                ((KoocanNetTabLayout) MainAty.this.g3(R$id.mainAtyTab)).updateTabStyles();
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class s extends t9.j implements s9.l {

        /* renamed from: a, reason: collision with root package name */
        public static final s f7938a = new s();

        public s() {
            super(1);
        }

        public final void invoke(Throwable th) {
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return t.f14242a;
        }
    }

    public static final void H3(StandardDialog standardDialog, View view) {
        t9.i.g(standardDialog, "$dialog");
        b0.j(standardDialog);
    }

    public static final void I3(MainAty mainAty, StandardDialog standardDialog, View view) {
        t9.i.g(mainAty, "this$0");
        t9.i.g(standardDialog, "$dialog");
        mainAty.startActivity(new Intent("android.settings.APPLICATION_DEVELOPMENT_SETTINGS"));
        standardDialog.dismiss();
        Object systemService = mainAty.Q1().getSystemService("notification");
        t9.i.e(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        ((NotificationManager) systemService).cancelAll();
        mainAty.finish();
    }

    public static final void K3(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void Y3(MainAty mainAty, View view) {
        t9.i.g(mainAty, "this$0");
        com.mobile.brasiltv.utils.h hVar = com.mobile.brasiltv.utils.h.f8694a;
        if (hVar.s()) {
            ((ImageView) mainAty.g3(R$id.ivCastFloat)).setVisibility(8);
            ((KoocanNetTabLayout) mainAty.g3(R$id.mainAtyTab)).setCurrentTab(1);
            ((NoScrollViewPager) mainAty.g3(R$id.mainViewPager)).setCurrentItem(1, false);
            return;
        }
        Intent intent = new Intent(mainAty, (Class<?>) PlayAty.class);
        g0.a aVar = g0.f14313b0;
        intent.putExtra(aVar.j(), hVar.n());
        intent.putExtra(aVar.a(), hVar.b());
        intent.putExtra(aVar.f(), hVar.j());
        intent.putExtra(aVar.b(), hVar.c());
        intent.putExtra(aVar.i(), hVar.m());
        intent.putExtra(aVar.c(), hVar.q());
        intent.putExtra(aVar.d(), hVar.r());
        intent.putExtra(aVar.e(), hVar.i());
        intent.putExtra(aVar.k(), true);
        mainAty.startActivity(intent);
    }

    public static final void c4(MainAty mainAty, View view) {
        t9.i.g(mainAty, "this$0");
        int i10 = R$id.mTvNotice;
        ((AutoText) mainAty.g3(i10)).setText("");
        ((AutoText) mainAty.g3(i10)).stopScroll();
        ((AutoLinearLayout) mainAty.g3(R$id.mLayoutNotice)).setVisibility(8);
        ((NoScrollViewPager) mainAty.g3(R$id.mainViewPager)).setPadding(0, 0, 0, 0);
    }

    public static final void e4(MainAty mainAty, ObservableEmitter observableEmitter) {
        t9.i.g(mainAty, "this$0");
        t9.i.g(observableEmitter, "it");
        SubtitleManager subtitleManager = SubtitleManager.INSTANCE;
        s6.a aVar = s6.a.f18777a;
        String c10 = aVar.a().c();
        subtitleManager.setMGlobalAudioLanguage(t9.i.b(c10, "pt") ? n0.f8733a.d(mainAty, SubtitleManager.GLOBAL_AUDIO_LANGUAGE, 0) : t9.i.b(c10, "es") ? n0.f8733a.d(mainAty, SubtitleManager.GLOBAL_AUDIO_LANGUAGE, 2) : n0.f8733a.d(mainAty, SubtitleManager.GLOBAL_AUDIO_LANGUAGE, 0));
        String c11 = aVar.a().c();
        subtitleManager.setMGlobalLanguage(t9.i.b(c11, "pt") ? n0.f8733a.d(mainAty, SubtitleManager.GLOBAL_SUBTITLE_LANGUAGE, 0) : t9.i.b(c11, "es") ? n0.f8733a.d(mainAty, SubtitleManager.GLOBAL_SUBTITLE_LANGUAGE, 2) : n0.f8733a.d(mainAty, SubtitleManager.GLOBAL_SUBTITLE_LANGUAGE, 0));
        n0 n0Var = n0.f8733a;
        subtitleManager.setMGlobalSize(n0Var.d(mainAty, SubtitleManager.GLOBAL_SUBTITLE_SIZE, 0));
        subtitleManager.setMGlobalColor(n0Var.d(mainAty, SubtitleManager.GLOBAL_SUBTITLE_COLOR, 0));
        subtitleManager.setMGlobalSwitch(n0Var.b(mainAty, SubtitleManager.GLOBAL_SUBTITLE_SWITCH, true));
        observableEmitter.onNext(0);
    }

    public static final void f4(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void g4(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void q4(MainAty mainAty) {
        CouponDialog couponDialog;
        t9.i.g(mainAty, "this$0");
        CouponDialog couponDialog2 = mainAty.f7908m;
        boolean z10 = false;
        if (couponDialog2 != null && couponDialog2.isShowing()) {
            z10 = true;
        }
        if (z10 && (couponDialog = mainAty.f7908m) != null) {
            couponDialog.dismiss();
        }
        CouponDialog couponDialog3 = new CouponDialog(mainAty);
        mainAty.f7908m = couponDialog3;
        couponDialog3.show();
    }

    public static final Boolean w4(MainAty mainAty) {
        Drawable drawable;
        Drawable drawable2;
        Drawable drawable3;
        t9.i.g(mainAty, "this$0");
        ArrayList<MainTabEntity> tabData = ((KoocanNetTabLayout) mainAty.g3(R$id.mainAtyTab)).getTabData();
        if (tabData.size() < 2) {
            return Boolean.FALSE;
        }
        a7.d dVar = a7.d.f279a;
        String n10 = dVar.n(RootColumnId.mainColumn.getPosterList(), dVar.g());
        String n11 = dVar.n(RootColumnId.mainColumn.getPosterList(), dVar.h());
        Drawable drawable4 = null;
        try {
            RequestManager with = Glide.with((androidx.fragment.app.e) mainAty);
            boolean isEmpty = TextUtils.isEmpty(n10);
            Object obj = n10;
            if (!isEmpty) {
                String a10 = a3.e.a(n10, "key_poster");
                obj = a10 != null ? b0.W(a10) : null;
            } else if (n10 == null) {
                obj = a3.e.a("", "key_poster");
            }
            drawable = with.load(obj).submit().get();
        } catch (Exception unused) {
            drawable = null;
        }
        try {
            RequestManager with2 = Glide.with((androidx.fragment.app.e) mainAty);
            boolean isEmpty2 = TextUtils.isEmpty(n11);
            Object obj2 = n11;
            if (!isEmpty2) {
                String a11 = a3.e.a(n11, "key_poster");
                obj2 = a11 != null ? b0.W(a11) : null;
            } else if (n11 == null) {
                obj2 = a3.e.a("", "key_poster");
            }
            drawable2 = with2.load(obj2).submit().get();
        } catch (Exception unused2) {
            drawable2 = null;
        }
        boolean z10 = false;
        boolean z11 = true;
        if (drawable != null && drawable2 != null) {
            tabData.get(0).setSelectedDrawable(drawable);
            tabData.get(0).setUnSelectDrawable(drawable2);
            z10 = true;
        }
        a7.d dVar2 = a7.d.f279a;
        String n12 = dVar2.n(RootColumnId.tvColumn.getPosterList(), dVar2.g());
        String n13 = dVar2.n(RootColumnId.tvColumn.getPosterList(), dVar2.h());
        try {
            RequestManager with3 = Glide.with((androidx.fragment.app.e) mainAty);
            boolean isEmpty3 = TextUtils.isEmpty(n12);
            Object obj3 = n12;
            if (!isEmpty3) {
                String a12 = a3.e.a(n12, "key_poster");
                obj3 = a12 != null ? b0.W(a12) : null;
            } else if (n12 == null) {
                obj3 = a3.e.a("", "key_poster");
            }
            drawable3 = with3.load(obj3).submit().get();
        } catch (Exception unused3) {
            drawable3 = null;
        }
        try {
            RequestManager with4 = Glide.with((androidx.fragment.app.e) mainAty);
            boolean isEmpty4 = TextUtils.isEmpty(n13);
            Object obj4 = n13;
            if (!isEmpty4) {
                String a13 = a3.e.a(n13, "key_poster");
                obj4 = a13 != null ? b0.W(a13) : null;
            } else if (n13 == null) {
                obj4 = a3.e.a("", "key_poster");
            }
            drawable4 = with4.load(obj4).submit().get();
        } catch (Exception unused4) {
        }
        if (drawable3 == null || drawable4 == null) {
            z11 = z10;
        } else {
            tabData.get(1).setSelectedDrawable(drawable3);
            tabData.get(1).setUnSelectDrawable(drawable4);
        }
        return Boolean.valueOf(z11);
    }

    public static final void x4(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void y4(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public final void G3() {
        if (Settings.Global.getInt(getContentResolver(), "always_finish_activities", 0) == 1) {
            i1.B(Q1());
            final StandardDialog standardDialog = new StandardDialog(this);
            String string = getResources().getString(R.string.tips);
            t9.i.f(string, "resources.getString(R.string.tips)");
            String string2 = getResources().getString(R.string.open_not_keep_activities);
            t9.i.f(string2, "resources.getString(R.st…open_not_keep_activities)");
            String string3 = getResources().getString(R.string.later);
            String string4 = getResources().getString(R.string.go_to_setting);
            t9.i.f(string4, "resources.getString(R.string.go_to_setting)");
            standardDialog.setDialogConfig(string, string2, string3, string4, new View.OnClickListener() { // from class: f5.c1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MainAty.H3(StandardDialog.this, view);
                }
            }, new View.OnClickListener() { // from class: f5.d1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MainAty.I3(MainAty.this, standardDialog, view);
                }
            });
            b0.S(standardDialog, DialogManager.DIALOG_NO_KEEP_ACTIVITIES);
        }
    }

    public final void J3() {
        if (!D || q5.i.f18197a.j(Q1())) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 33) {
            Observable o10 = new c8.b(this).o("android.permission.POST_NOTIFICATIONS");
            final c cVar = new c();
            o10.subscribe(new Consumer() { // from class: f5.e1
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    MainAty.K3(s9.l.this, obj);
                }
            });
        } else {
            s4();
        }
        D = false;
    }

    public final void L3() {
        Configuration configuration;
        if (getRequestedOrientation() != 1) {
            Resources resources = getResources();
            boolean z10 = false;
            if (resources != null && (configuration = resources.getConfiguration()) != null && configuration.orientation == 1) {
                z10 = true;
            }
            if (z10) {
                return;
            }
            Resources resources2 = getResources();
            Configuration configuration2 = resources2 != null ? resources2.getConfiguration() : null;
            if (configuration2 != null) {
                configuration2.orientation = 1;
            }
            setRequestedOrientation(1);
        }
    }

    public final void M3() {
        if (this.f7909n) {
            int currentTab = ((KoocanNetTabLayout) g3(R$id.mainAtyTab)).getCurrentTab();
            if (currentTab == 0) {
                O3();
            } else if (currentTab != 2) {
                w5.m.f19178a.X();
            } else {
                N3();
            }
        }
    }

    public final void N3() {
        w5.m mVar = w5.m.f19178a;
        mVar.X();
        mVar.Z(w6.i.f19214g.H(), i9.j.h(mVar.B(), mVar.A()));
        mVar.R(new d());
        l4();
    }

    public final void O3() {
        w5.m mVar = w5.m.f19178a;
        mVar.X();
        mVar.Z(w6.i.f19214g.H(), i9.j.h(mVar.x(), mVar.y(), mVar.z()));
        mVar.R(new e());
        l4();
    }

    public final int P3() {
        return ((Number) this.f7911p.getValue()).intValue();
    }

    public final ArrayList Q3() {
        return (ArrayList) this.f7913r.getValue();
    }

    @Override // f5.d
    public void R2() {
        o4(new b1(this, this));
        C = true;
        ha.b bVar = ha.b.f14245a;
        if (TextUtils.isEmpty(bVar.a())) {
            bVar.b("setModuleBridging");
        }
        L3();
        G3();
        J3();
        a4();
        ((KoocanNetTabLayout) g3(R$id.mainAtyTab)).setTextVisible(false);
        i4();
        h4();
        n4(this);
        m4();
        X3();
        b4();
        Z3();
        d4();
    }

    public final ArrayList R3() {
        return (ArrayList) this.f7914s.getValue();
    }

    public final x0 S3() {
        return (x0) this.f7912q.getValue();
    }

    @Override // f5.d
    public int T2() {
        return R.layout.aty_main;
    }

    @Override // f5.d
    /* renamed from: T3, reason: merged with bridge method [inline-methods] */
    public b1 S2() {
        b1 b1Var = this.f7920y;
        if (b1Var != null) {
            return b1Var;
        }
        t9.i.w("mPresenter");
        return null;
    }

    public final void U3(Configuration configuration) {
        if (configuration.orientation != 2) {
            z4(((KoocanNetTabLayout) g3(R$id.mainAtyTab)).getCurrentTab());
            return;
        }
        ((AutoLinearLayout) g3(R$id.mLayoutNotice)).setVisibility(8);
        ((NoScrollViewPager) g3(R$id.mainViewPager)).setPadding(0, 0, 0, 0);
        int i10 = R$id.mTvNotice;
        CharSequence text = ((AutoText) g3(i10)).getText();
        t9.i.f(text, "mTvNotice.text");
        if (text.length() > 0) {
            ((AutoText) g3(i10)).pauseScroll();
        }
    }

    public final void V3() {
        int i10 = R$id.mainAtyTab;
        ViewGroup.LayoutParams layoutParams = ((KoocanNetTabLayout) g3(i10)).getLayoutParams();
        t9.i.e(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
        layoutParams2.height = 0;
        ((KoocanNetTabLayout) g3(i10)).setLayoutParams(layoutParams2);
    }

    public final void W3() {
        ((AutoLinearLayout) g3(R$id.mLayoutNotice)).setVisibility(8);
        ((AutoText) g3(R$id.mTvNotice)).stopScroll();
    }

    public final void X3() {
        ((ImageView) g3(R$id.ivCastFloat)).setOnClickListener(new View.OnClickListener() { // from class: f5.a1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MainAty.Y3(MainAty.this, view);
            }
        });
    }

    @Override // i6.v
    public void Y(int i10, String str) {
        ServiceExpirationTipDialog serviceExpirationTipDialog;
        t9.i.g(str, "hintContent");
        ServiceExpirationTipDialog serviceExpirationTipDialog2 = this.f7907l;
        boolean z10 = false;
        if (serviceExpirationTipDialog2 != null && serviceExpirationTipDialog2.isShowing()) {
            z10 = true;
        }
        if (z10 && (serviceExpirationTipDialog = this.f7907l) != null) {
            serviceExpirationTipDialog.dismiss();
        }
        ServiceExpirationTipDialog serviceExpirationTipDialog3 = new ServiceExpirationTipDialog(this, i10, str);
        this.f7907l = serviceExpirationTipDialog3;
        b0.S(serviceExpirationTipDialog3, DialogManager.DIALOG_EXPIRED);
    }

    public final void Z3() {
        v5.g.f19112a.o(new f());
    }

    @Override // i6.v
    public void a2(int i10) {
        b0.S(new ForceBindNormalDialog(Q1(), i10, new n()), DialogManager.DIALOG_FORCE_BIND);
    }

    public final void a4() {
        this.f7915t = new r3();
        this.f7916u = new z();
        this.f7917v = new d3();
        ArrayList Q3 = Q3();
        r3 r3Var = this.f7915t;
        d3 d3Var = null;
        if (r3Var == null) {
            t9.i.w("mVodFragment");
            r3Var = null;
        }
        Q3.add(r3Var);
        ArrayList Q32 = Q3();
        z zVar = this.f7916u;
        if (zVar == null) {
            t9.i.w("mLiveFragment");
            zVar = null;
        }
        Q32.add(zVar);
        ArrayList Q33 = Q3();
        d3 d3Var2 = this.f7917v;
        if (d3Var2 == null) {
            t9.i.w("mMine1Fragment");
        } else {
            d3Var = d3Var2;
        }
        Q33.add(d3Var);
        R3().addAll(i9.j.c(b0.A(this, R.string.nav_button_home), b0.A(this, R.string.nav_button_live), b0.A(this, R.string.nav_button_mine)));
    }

    @Override // f5.c, androidx.appcompat.app.d, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        t9.i.g(context, "newBase");
        super.attachBaseContext(context);
        String language = Locale.getDefault().getLanguage();
        t9.i.f(language, "getDefault().language");
        B = language;
        b0.U(this, "cur record language: " + B);
    }

    public final void b4() {
        ((ImageView) g3(R$id.mIvCloseNotice)).setOnClickListener(new View.OnClickListener() { // from class: f5.b1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MainAty.c4(MainAty.this, view);
            }
        });
    }

    @xa.j(threadMode = ThreadMode.MAIN)
    public final void castPlayEvent(CastPlaySuccessEvent castPlaySuccessEvent) {
        t9.i.g(castPlaySuccessEvent, "event");
        com.mobile.brasiltv.utils.h hVar = com.mobile.brasiltv.utils.h.f8694a;
        hVar.C(t9.i.b(castPlaySuccessEvent.getFromType(), "LIVE"));
        if (((KoocanNetTabLayout) g3(R$id.mainAtyTab)).getCurrentTab() == 1 && hVar.s()) {
            ((ImageView) g3(R$id.ivCastFloat)).setVisibility(8);
        } else {
            ((ImageView) g3(R$id.ivCastFloat)).setVisibility(0);
        }
        if (hVar.s()) {
            hVar.y("");
        }
    }

    @xa.j(threadMode = ThreadMode.MAIN)
    public final void castToCloseOtherPlay(CastToCloseOtherPlayEvent castToCloseOtherPlayEvent) {
        t9.i.g(castToCloseOtherPlayEvent, "event");
        if (t9.i.b(castToCloseOtherPlayEvent.getFromType(), "LIVE")) {
            com.mobile.brasiltv.utils.h hVar = com.mobile.brasiltv.utils.h.f8694a;
            if (!hVar.s()) {
                ((ImageView) g3(R$id.ivCastFloat)).setVisibility(8);
                if (castToCloseOtherPlayEvent.getStop()) {
                    if (t9.i.b(hVar.a(), hVar.k())) {
                        if (hVar.t()) {
                            com.mobile.brasiltv.utils.g.f8651a.G();
                            return;
                        }
                        return;
                    } else {
                        if (t9.i.b(hVar.a(), hVar.l())) {
                            this.f7910o.r();
                            return;
                        }
                        return;
                    }
                }
                return;
            }
        }
        if (t9.i.b(castToCloseOtherPlayEvent.getFromType(), "VOD")) {
            com.mobile.brasiltv.utils.h hVar2 = com.mobile.brasiltv.utils.h.f8694a;
            if (hVar2.s()) {
                ((ImageView) g3(R$id.ivCastFloat)).setVisibility(8);
                if (castToCloseOtherPlayEvent.getStop()) {
                    if (t9.i.b(hVar2.a(), hVar2.k())) {
                        if (hVar2.t()) {
                            com.mobile.brasiltv.utils.g.f8651a.G();
                        }
                    } else if (t9.i.b(hVar2.a(), hVar2.l())) {
                        this.f7910o.r();
                    }
                }
            }
        }
    }

    public final void d4() {
        Observable compose = Observable.create(new ObservableOnSubscribe() { // from class: f5.v0
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(ObservableEmitter observableEmitter) {
                MainAty.e4(MainAty.this, observableEmitter);
            }
        }).compose(p0.b());
        final g gVar = g.f7927a;
        Consumer consumer = new Consumer() { // from class: f5.y0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                MainAty.f4(s9.l.this, obj);
            }
        };
        final h hVar = h.f7928a;
        compose.subscribe(consumer, new Consumer() { // from class: f5.z0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                MainAty.g4(s9.l.this, obj);
            }
        });
    }

    @xa.j(threadMode = ThreadMode.MAIN)
    public final void disConnectEvent(CastToCloseFloatViewEvent castToCloseFloatViewEvent) {
        t9.i.g(castToCloseFloatViewEvent, "event");
        ((ImageView) g3(R$id.ivCastFloat)).setVisibility(8);
        com.mobile.brasiltv.utils.h.f8694a.v(false);
    }

    public View g3(int i10) {
        Map map = this.f7921z;
        View view = (View) map.get(Integer.valueOf(i10));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i10);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i10), findViewById);
        return findViewById;
    }

    @xa.j(threadMode = ThreadMode.MAIN)
    public final void gotoCRMessage(GotoCREvent gotoCREvent) {
        t9.i.g(gotoCREvent, "event");
        ((KoocanNetTabLayout) g3(R$id.mainAtyTab)).setCurrentTab(0);
        ((NoScrollViewPager) g3(R$id.mainViewPager)).setCurrentItem(0);
    }

    @xa.j(threadMode = ThreadMode.MAIN)
    public final void gotoHomeTabMessage(GotoHomeTabEvent gotoHomeTabEvent) {
        t9.i.g(gotoHomeTabEvent, "event");
        ((KoocanNetTabLayout) g3(R$id.mainAtyTab)).setCurrentTab(gotoHomeTabEvent.getTab());
        ((NoScrollViewPager) g3(R$id.mainViewPager)).setCurrentItem(gotoHomeTabEvent.getTab());
    }

    public final void h4() {
        ((KoocanNetTabLayout) g3(R$id.mainAtyTab)).setOnTabSelectListener(new i());
    }

    public void i4() {
        ArrayList<MainTabEntity> E0 = S2().E0();
        int i10 = R$id.mainAtyTab;
        ((KoocanNetTabLayout) g3(i10)).setTabData(E0);
        ((KoocanNetTabLayout) g3(i10)).setCurrentTab(0);
    }

    public final void j4() {
        int i10 = R$id.mainViewPager;
        ((NoScrollViewPager) g3(i10)).setAdapter(S3());
        ((NoScrollViewPager) g3(i10)).setOffscreenPageLimit(S3().getCount());
        ((KoocanNetTabLayout) g3(R$id.mainAtyTab)).setCurrentTab(0);
        ((NoScrollViewPager) g3(i10)).setCurrentItem(0);
    }

    @Override // i6.v
    public void k0() {
        CouponDialog couponDialog;
        ServiceExpirationTipDialog serviceExpirationTipDialog;
        ServiceExpirationTipDialog serviceExpirationTipDialog2 = this.f7907l;
        if ((serviceExpirationTipDialog2 != null && serviceExpirationTipDialog2.isShowing()) && (serviceExpirationTipDialog = this.f7907l) != null) {
            b0.j(serviceExpirationTipDialog);
        }
        CouponDialog couponDialog2 = this.f7908m;
        if ((couponDialog2 != null && couponDialog2.isShowing()) && (couponDialog = this.f7908m) != null) {
            couponDialog.dismiss();
        }
        W3();
        d3 d3Var = this.f7917v;
        if (d3Var != null) {
            if (d3Var == null) {
                t9.i.w("mMine1Fragment");
                d3Var = null;
            }
            d3Var.w3();
        }
    }

    @Override // i5.a
    public void k2() {
        n2();
    }

    public final void k4() {
        if (this.f7909n && ((KoocanNetTabLayout) g3(R$id.mainAtyTab)).getCurrentTab() == 2) {
            d3 d3Var = this.f7917v;
            if (d3Var == null) {
                t9.i.w("mMine1Fragment");
                d3Var = null;
            }
            d3Var.Q3();
        }
    }

    public final void l4() {
        w5.m.f19178a.M(new m());
    }

    @Override // i6.v
    public void m1() {
        b0.S(new ForceBindDialog(Q1(), new o(), new p()), DialogManager.DIALOG_FORCE_BIND);
    }

    public final void m4() {
        if (Build.VERSION.SDK_INT < 23) {
            return;
        }
        this.f7919x = new t6.b();
        Q1().registerReceiver(this.f7919x, new IntentFilter("android.os.action.DEVICE_IDLE_MODE_CHANGED"));
    }

    public final void n4(Context context) {
        this.f7918w = new t6.c();
        IntentFilter intentFilter = new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        if (Build.VERSION.SDK_INT >= 26) {
            context.registerReceiver(this.f7918w, intentFilter, 4);
        } else {
            context.registerReceiver(this.f7918w, intentFilter);
        }
    }

    public void o4(b1 b1Var) {
        t9.i.g(b1Var, "<set-?>");
        this.f7920y = b1Var;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        z zVar = this.f7916u;
        z zVar2 = null;
        if (zVar == null) {
            t9.i.w("mLiveFragment");
            zVar = null;
        }
        if (!zVar.J3()) {
            S2().o0();
            return;
        }
        z zVar3 = this.f7916u;
        if (zVar3 == null) {
            t9.i.w("mLiveFragment");
        } else {
            zVar2 = zVar3;
        }
        zVar2.I3();
    }

    @Override // androidx.appcompat.app.d, androidx.fragment.app.e, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        t9.i.g(configuration, "newConfig");
        super.onConfigurationChanged(configuration);
        getResources().getConfiguration().orientation = configuration.orientation;
        U3(configuration);
    }

    @Override // f5.d, f5.c, u8.a, androidx.appcompat.app.d, androidx.fragment.app.e, android.app.Activity
    public void onDestroy() {
        DialogManager.INSTANCE.clear();
        super.onDestroy();
        u4(this);
        t4();
    }

    @Override // i6.v
    public void onError() {
        ((KoocanEmptyView) g3(R$id.loadingView)).setVisibility(8);
    }

    @Override // androidx.appcompat.app.d, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i10, KeyEvent keyEvent) {
        if (((KoocanNetTabLayout) g3(R$id.mainAtyTab)).getCurrentTab() == 1 && ((ImageView) g3(R$id.ivCastFloat)).getVisibility() == 0 && com.mobile.brasiltv.utils.h.f8694a.s()) {
            if (i10 == 24) {
                com.mobile.brasiltv.utils.g0.f8670a.a();
                return true;
            }
            if (i10 == 25) {
                com.mobile.brasiltv.utils.g0.f8670a.o();
                return true;
            }
        }
        return super.onKeyDown(i10, keyEvent);
    }

    @Override // androidx.fragment.app.e, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        b0.U(this, "onNewIntent");
    }

    @Override // f5.c, u8.a, androidx.fragment.app.e, android.app.Activity
    public void onPause() {
        super.onPause();
        if (((AutoLinearLayout) g3(R$id.mLayoutNotice)).getVisibility() == 0) {
            ((AutoText) g3(R$id.mTvNotice)).pauseScroll();
        }
    }

    @Override // android.app.Activity
    public void onRestart() {
        super.onRestart();
        xa.c.c().j(new VodPageRestartEvent());
    }

    @Override // android.app.Activity
    public void onRestoreInstanceState(Bundle bundle) {
        t9.i.g(bundle, "savedInstanceState");
        super.onRestoreInstanceState(bundle);
        SplashAty.f8183s.b(bundle.getBoolean("enterSplashPage", false));
    }

    @Override // f5.c, u8.a, androidx.fragment.app.e, android.app.Activity
    public void onResume() {
        super.onResume();
        AutoLinearLayout autoLinearLayout = (AutoLinearLayout) g3(R$id.mLayoutNotice);
        boolean z10 = false;
        if (autoLinearLayout != null && autoLinearLayout.getVisibility() == 0) {
            z10 = true;
        }
        if (z10) {
            ((AutoText) g3(R$id.mTvNotice)).resumeScroll();
        }
        k4();
        M3();
    }

    @Override // androidx.appcompat.app.d, androidx.activity.ComponentActivity, o.p, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        t9.i.g(bundle, "outState");
        bundle.putBoolean("enterSplashPage", SplashAty.f8183s.a());
        super.onSaveInstanceState(bundle);
    }

    @Override // i6.v
    public void p0() {
        this.f7909n = true;
        j4();
        v4();
        M3();
    }

    @Override // m5.a
    /* renamed from: p4, reason: merged with bridge method [inline-methods] */
    public void Y0(u uVar) {
        t9.i.g(uVar, "presenter");
    }

    public final void r4() {
        int i10 = R$id.mainAtyTab;
        ViewGroup.LayoutParams layoutParams = ((KoocanNetTabLayout) g3(i10)).getLayoutParams();
        t9.i.e(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
        layoutParams2.height = s0.a(this, 55.0f);
        ((KoocanNetTabLayout) g3(i10)).setLayoutParams(layoutParams2);
    }

    @Override // i6.v
    public void s() {
        ((KoocanEmptyView) g3(R$id.loadingView)).setVisibility(8);
    }

    @Override // i6.v
    public void s2(String str) {
        t9.i.g(str, "info");
        int i10 = R$id.mLayoutNotice;
        ViewGroup.LayoutParams layoutParams = ((AutoLinearLayout) g3(i10)).getLayoutParams();
        t9.i.e(layoutParams, "null cannot be cast to non-null type com.zhy.autolayout.AutoRelativeLayout.LayoutParams");
        ((AutoRelativeLayout.LayoutParams) layoutParams).setMargins(0, P3(), 0, 0);
        NoScrollViewPager noScrollViewPager = (NoScrollViewPager) g3(R$id.mainViewPager);
        int i11 = R$id.mainAtyTab;
        noScrollViewPager.setPadding(0, ((KoocanNetTabLayout) g3(i11)).getCurrentTab() == 2 ? 0 : P3(), 0, 0);
        ((AutoLinearLayout) g3(i10)).setVisibility(0);
        int i12 = R$id.mTvNotice;
        ((AutoText) g3(i12)).setText(str);
        ((AutoText) g3(i12)).setTextColor(getResources().getColor(R.color.color_important));
        ((AutoText) g3(i12)).setTextSize(AutoUtils.getPercentWidthSize(24));
        ((AutoText) g3(i12)).setContentPaddingLeft(50);
        ((AutoText) g3(i12)).startScroll();
        if (((KoocanNetTabLayout) g3(i11)).getCurrentTab() == 2) {
            W3();
        }
    }

    public final void s4() {
        b0.S(new OpenNotifyDialog(this, new q()), DialogManager.DIALOG_OPEN_NOTIFY);
    }

    public final void t4() {
        if (this.f7919x != null) {
            Q1().unregisterReceiver(this.f7919x);
        }
    }

    public final void u4(Context context) {
        t6.c cVar = this.f7918w;
        if (cVar != null) {
            context.unregisterReceiver(cVar);
        }
    }

    @Override // f5.c, android.content.ContextWrapper, android.content.Context
    public void unbindService(ServiceConnection serviceConnection) {
        t9.i.g(serviceConnection, "conn");
        try {
            super.unbindService(serviceConnection);
        } catch (IllegalArgumentException e10) {
            e10.printStackTrace();
        }
    }

    @Override // i6.v
    public void v1() {
        runOnUiThread(new Runnable() { // from class: f5.x0
            @Override // java.lang.Runnable
            public final void run() {
                MainAty.q4(MainAty.this);
            }
        });
    }

    public final void v4() {
        Observable observeOn = Observable.fromCallable(new Callable() { // from class: f5.f1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Boolean w42;
                w42 = MainAty.w4(MainAty.this);
                return w42;
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final r rVar = new r();
        Consumer consumer = new Consumer() { // from class: f5.g1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                MainAty.x4(s9.l.this, obj);
            }
        };
        final s sVar = s.f7938a;
        observeOn.subscribe(consumer, new Consumer() { // from class: f5.w0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                MainAty.y4(s9.l.this, obj);
            }
        });
    }

    public final void z4(int i10) {
        int i11 = R$id.mTvNotice;
        CharSequence text = ((AutoText) g3(i11)).getText();
        t9.i.f(text, "mTvNotice.text");
        if (text.length() > 0) {
            int i12 = R$id.mLayoutNotice;
            ((AutoLinearLayout) g3(i12)).setVisibility(i10 == 2 ? 8 : 0);
            ((NoScrollViewPager) g3(R$id.mainViewPager)).setPadding(0, i10 == 2 ? 0 : P3(), 0, 0);
            if (((AutoLinearLayout) g3(i12)).getVisibility() == 0) {
                ((AutoText) g3(i11)).resumeScroll();
            } else {
                ((AutoText) g3(i11)).pauseScroll();
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class n extends t9.j implements s9.a {
        public n() {
            super(0);
        }

        /* renamed from: invoke, reason: collision with other method in class */
        public final void m52invoke() {
            i1.K(MainAty.this.Q1(), "freeForceBind");
            b0.c0(MainAty.this, EmailAty.class);
        }

        @Override // s9.a
        public /* bridge */ /* synthetic */ Object invoke() {
            m52invoke();
            return t.f14242a;
        }
    }

    /* loaded from: classes3.dex */
    public static final class p extends t9.j implements s9.a {
        public p() {
            super(0);
        }

        /* renamed from: invoke, reason: collision with other method in class */
        public final void m54invoke() {
            i1.K(MainAty.this.Q1(), "forceBind");
            b0.c0(MainAty.this, EmailAty.class);
        }

        @Override // s9.a
        public /* bridge */ /* synthetic */ Object invoke() {
            m54invoke();
            return t.f14242a;
        }
    }
}
