package com.mobile.brasiltv.activity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.OverScroller;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import androidx.core.widget.NestedScrollView;
import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.activity.PlayAty;
import com.mobile.brasiltv.bean.AudioTrackBean;
import com.mobile.brasiltv.bean.BaseGuideManager;
import com.mobile.brasiltv.bean.EnterType;
import com.mobile.brasiltv.bean.event.CastPlaySuccessEvent;
import com.mobile.brasiltv.bean.event.CastToCloseOtherPlayEvent;
import com.mobile.brasiltv.bean.event.GoToSharingEvent;
import com.mobile.brasiltv.bean.event.RequestAuthEvent;
import com.mobile.brasiltv.bean.event.SelectedSeason;
import com.mobile.brasiltv.bean.event.ShowVodSharingGuideEvent;
import com.mobile.brasiltv.bean.event.VodFavEvent;
import com.mobile.brasiltv.bean.event.VodSubEvent;
import com.mobile.brasiltv.db.Album;
import com.mobile.brasiltv.db.VodDao;
import com.mobile.brasiltv.mine.activity.AccountBindAty;
import com.mobile.brasiltv.player.TitanPlayerController;
import com.mobile.brasiltv.player.view.ProgramActorInfoView;
import com.mobile.brasiltv.player.view.ProgramRecommendInfoView;
import com.mobile.brasiltv.player.view.ProgramSetInfoView;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.utils.f1;
import com.mobile.brasiltv.utils.h;
import com.mobile.brasiltv.utils.i1;
import com.mobile.brasiltv.utils.j1;
import com.mobile.brasiltv.utils.x;
import com.mobile.brasiltv.utils.y;
import com.mobile.brasiltv.view.DivisionLineView;
import com.mobile.brasiltv.view.KoocanEmptyView;
import com.mobile.brasiltv.view.KoocanNestedScrollView;
import com.mobile.brasiltv.view.MarqueeTextView;
import com.mobile.brasiltv.view.adView.SmallAdNativeContainer;
import com.mobile.brasiltv.view.adView.SmallAdNativeView;
import com.mobile.brasiltv.view.dialog.CommTipsDialog;
import com.mobile.brasiltv.view.dialog.GuideDialog;
import com.msandroid.mobile.R;
import com.titan.ranger.bean.Program;
import com.titans.widget.TitanVODView;
import com.zhy.autolayout.AutoFrameLayout;
import com.zhy.autolayout.AutoLinearLayout;
import com.zhy.autolayout.AutoRelativeLayout;
import com.zhy.autolayout.utils.AutoUtils;
import g5.e1;
import h9.t;
import i6.f0;
import i6.g0;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import k6.g2;
import k7.f;
import mobile.com.requestframe.utils.response.AssetData;
import mobile.com.requestframe.utils.response.Movie;
import mobile.com.requestframe.utils.response.SimpleProgramList;
import na.e;
import org.greenrobot.eventbus.ThreadMode;
import s9.l;
import t9.g;
import t9.i;
import t9.j;

/* loaded from: classes.dex */
public final class PlayAty extends f5.d implements g0, m6.a {
    public static final a G = new a(null);
    public static String H = " ";
    public static String I = "";
    public static String J = "1";
    public static String K = "";
    public static ArrayList L = new ArrayList();
    public int A;
    public String B;
    public boolean C;
    public g2 D;
    public PopupWindow E;

    /* renamed from: q, reason: collision with root package name */
    public String f8011q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f8012r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f8013s;

    /* renamed from: u, reason: collision with root package name */
    public boolean f8015u;

    /* renamed from: w, reason: collision with root package name */
    public boolean f8017w;
    public Map F = new LinkedHashMap();

    /* renamed from: l, reason: collision with root package name */
    public VodDao f8006l = new VodDao(this);

    /* renamed from: m, reason: collision with root package name */
    public String f8007m = "";

    /* renamed from: n, reason: collision with root package name */
    public String f8008n = "";

    /* renamed from: o, reason: collision with root package name */
    public String f8009o = "";

    /* renamed from: p, reason: collision with root package name */
    public EnterType f8010p = EnterType.CATEGORY;

    /* renamed from: t, reason: collision with root package name */
    public int f8014t = -1;

    /* renamed from: v, reason: collision with root package name */
    public o6.b f8016v = o6.c.c();

    /* renamed from: x, reason: collision with root package name */
    public String f8018x = "";

    /* renamed from: y, reason: collision with root package name */
    public String f8019y = "";

    /* renamed from: z, reason: collision with root package name */
    public String f8020z = "";

    /* loaded from: classes3.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }

        public final String a() {
            return PlayAty.H;
        }

        public final ArrayList b() {
            return PlayAty.L;
        }

        public final String c() {
            return PlayAty.K;
        }

        public final void d(String str) {
            i.g(str, "<set-?>");
            PlayAty.J = str;
        }
    }

    /* loaded from: classes3.dex */
    public static final class b implements SmallAdNativeView.NativeAdCallback {
        public b() {
        }

        @Override // com.mobile.brasiltv.view.adView.SmallAdNativeView.NativeAdCallback
        public void onAttachNativeAd() {
            SmallAdNativeContainer smallAdNativeContainer = (SmallAdNativeContainer) PlayAty.this.a3(R$id.adNativeView);
            if (smallAdNativeContainer == null) {
                return;
            }
            smallAdNativeContainer.setVisibility(0);
        }

        @Override // com.mobile.brasiltv.view.adView.SmallAdNativeView.NativeAdCallback
        public void onCloseNativeAd() {
            SmallAdNativeContainer smallAdNativeContainer = (SmallAdNativeContainer) PlayAty.this.a3(R$id.adNativeView);
            if (smallAdNativeContainer == null) {
                return;
            }
            smallAdNativeContainer.setVisibility(8);
        }
    }

    /* loaded from: classes3.dex */
    public static final class c extends j implements l {

        /* renamed from: a, reason: collision with root package name */
        public static final c f8022a = new c();

        public c() {
            super(1);
        }

        @Override // s9.l
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Intent invoke(Intent intent) {
            i.g(intent, "intent");
            Intent putExtra = intent.putExtra("from_type", "VOD");
            i.f(putExtra, "intent.putExtra(Constant…, Constant.FROM_TYPE_VOD)");
            return putExtra;
        }
    }

    /* loaded from: classes3.dex */
    public static final class d extends j implements l {
        public d() {
            super(1);
        }

        public final void b(CommTipsDialog commTipsDialog) {
            i.g(commTipsDialog, "it");
            commTipsDialog.dismiss();
            PlayAty.this.startActivity(new Intent("android.settings.WIFI_SETTINGS"));
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            b((CommTipsDialog) obj);
            return t.f14242a;
        }
    }

    public static final void D3(PlayAty playAty, boolean z10, String str) {
        i.g(playAty, "this$0");
        i.g(str, "$errorCode");
        ((AutoFrameLayout) playAty.a3(R$id.mPlayLoadingView)).setVisibility(8);
        String string = z10 ? playAty.getResources().getString(R.string.vod_no_media) : ma.j.a(playAty, str);
        TitanPlayerController titanPlayerController = (TitanPlayerController) playAty.a3(R$id.mVodPlayer);
        if (titanPlayerController != null) {
            i.f(string, "errorMessage");
            titanPlayerController.B4(string);
        }
    }

    public static final void F3(PlayAty playAty) {
        i.g(playAty, "this$0");
        Context Q1 = playAty.Q1();
        int i10 = R$id.mInfoView;
        AutoLinearLayout autoLinearLayout = (AutoLinearLayout) ((ProgramActorInfoView) playAty.a3(i10).findViewById(R$id.mActorInfoView))._$_findCachedViewById(R$id.mShareLayout);
        String string = playAty.a3(i10).getContext().getString(R.string.sharing_guide_tips);
        i.f(string, "mInfoView.context.getStr…tring.sharing_guide_tips)");
        new BaseGuideManager(Q1, autoLinearLayout, "keyVodSharing", string, GuideDialog.Direction.TOP_RIGHT, null, false, false, null, 480, null).showGuide();
    }

    public static final void m3(PlayAty playAty, View view) {
        i.g(playAty, "this$0");
        playAty.h3();
        TitanPlayerController titanPlayerController = (TitanPlayerController) playAty.a3(R$id.mVodPlayer);
        if (titanPlayerController != null) {
            TitanPlayerController.l2(titanPlayerController, false, 1, null);
        }
    }

    public static final void o3(PlayAty playAty, View view) {
        i.g(playAty, "this$0");
        i1.N(playAty.Q1());
        b0.c0(playAty, AccountBindAty.class);
    }

    public static final void s3(PlayAty playAty, String str) {
        i.g(playAty, "this$0");
        i.g(str, "$contentId");
        playAty.G2();
        g2 S2 = playAty.S2();
        h hVar = h.f8694a;
        AssetData d10 = hVar.d();
        i.d(d10);
        S2.E0(str, d10);
        AssetData d11 = hVar.d();
        i.d(d11);
        playAty.E3(d11);
    }

    public static /* synthetic */ void u3(PlayAty playAty, String str, int i10, String str2, String str3, int[] iArr, int i11, Object obj) {
        playAty.t3(str, i10, str2, (i11 & 8) != 0 ? null : str3, (i11 & 16) != 0 ? null : iArr);
    }

    public static final void w3(PlayAty playAty) {
        i.g(playAty, "this$0");
        PopupWindow popupWindow = playAty.E;
        g7.b bVar = popupWindow instanceof g7.b ? (g7.b) popupWindow : null;
        if (bVar != null) {
            bVar.a(1.0f);
        }
        playAty.E = null;
    }

    public final void A3(o6.b bVar) {
        i.g(bVar, "<set-?>");
        this.f8016v = bVar;
    }

    @Override // m5.a
    /* renamed from: B3, reason: merged with bridge method [inline-methods] */
    public void Y0(f0 f0Var) {
        i.g(f0Var, "presenter");
    }

    public final void C3() {
        String string = getString(R.string.cast_wifi_not_connect_tips);
        i.f(string, "getString(R.string.cast_wifi_not_connect_tips)");
        new CommTipsDialog(this, string, getString(R.string.cast), getString(R.string.cast_wifi_setting), null, null, new d(), null, false, 432, null).show();
    }

    @Override // i6.g0
    public void D1() {
    }

    @Override // i6.g0
    public void D2(HashMap hashMap, AudioTrackBean audioTrackBean) {
        i.g(hashMap, "audioInfoMap");
        TitanPlayerController titanPlayerController = (TitanPlayerController) a3(R$id.mVodPlayer);
        if (titanPlayerController != null) {
            titanPlayerController.S3((ArrayList) hashMap.get(this.f8016v.c()), audioTrackBean);
        }
    }

    @Override // i6.g0
    public void E0(final String str, final boolean z10) {
        i.g(str, "errorCode");
        TitanPlayerController titanPlayerController = (TitanPlayerController) a3(R$id.mVodPlayer);
        if (titanPlayerController != null) {
            titanPlayerController.post(new Runnable() { // from class: f5.x2
                @Override // java.lang.Runnable
                public final void run() {
                    PlayAty.D3(PlayAty.this, z10, str);
                }
            });
        }
    }

    public void E3(AssetData assetData) {
        i.g(assetData, "program");
        p3(this.f8012r);
        ((KoocanEmptyView) a3(R$id.mPlayEmptyView)).setVisibility(8);
        ((AutoFrameLayout) a3(R$id.mPlayLoadingView)).setVisibility(8);
        a3(R$id.mInfoView).setVisibility(0);
        TitanPlayerController titanPlayerController = (TitanPlayerController) a3(R$id.mVodPlayer);
        if (titanPlayerController != null) {
            titanPlayerController.s2(this.f8006l, assetData, this.f8007m, this.f8010p, this.f8011q, this.f8012r, (r17 & 64) != 0);
        }
        int i10 = R$id.mActorInfoView;
        ((ProgramActorInfoView) a3(i10)).d(assetData);
        ((ProgramActorInfoView) a3(i10)).h(this.f8006l, assetData, this.f8007m, this.f8015u);
        ((ProgramActorInfoView) a3(i10)).m(assetData);
    }

    @Override // i6.g0
    public void G1(List list) {
        i.g(list, "t");
        int i10 = R$id.mProgramRecommendInfo;
        ((ProgramRecommendInfoView) a3(i10)).f(this.f8012r);
        ((ProgramRecommendInfoView) a3(i10)).c(list);
    }

    @Override // i6.g0
    public void G2() {
        TitanPlayerController titanPlayerController = (TitanPlayerController) a3(R$id.mVodPlayer);
        if (titanPlayerController != null) {
            titanPlayerController.P1();
        }
    }

    public final void G3() {
        ((KoocanNestedScrollView) a3(R$id.mScroller)).scrollTo(0, 0);
    }

    public final void H3(AssetData assetData) {
        ((ProgramActorInfoView) a3(R$id.mActorInfoView)).k(assetData);
        if (this.f8012r && i.b(assetData.getHasFavorite(), "1")) {
            f1.a.j(f1.f8649a, Q1(), R.string.vod_fav_bl_success, 0, 4, null);
        }
    }

    @Override // i6.g0
    public void I0(List list) {
        i.g(list, "list");
        TitanPlayerController titanPlayerController = (TitanPlayerController) a3(R$id.mVodPlayer);
        if (titanPlayerController != null) {
            titanPlayerController.setSubData(list);
        }
    }

    public final void I3(AssetData assetData) {
        ((ProgramActorInfoView) a3(R$id.mActorInfoView)).l(assetData);
    }

    @Override // i6.g0
    public void N0(AssetData assetData) {
        i.g(assetData, "program");
        ((AutoFrameLayout) a3(R$id.mPlayLoadingView)).setVisibility(8);
        TitanPlayerController titanPlayerController = (TitanPlayerController) a3(R$id.mVodPlayer);
        if (titanPlayerController != null) {
            titanPlayerController.s2(this.f8006l, assetData, this.f8007m, this.f8010p, this.f8011q, this.f8012r, false);
        }
        int i10 = R$id.mActorInfoView;
        ((ProgramActorInfoView) a3(i10)).d(assetData);
        ((ProgramActorInfoView) a3(i10)).g(this.f8006l, assetData, this.f8007m, this.f8015u);
        ((ProgramActorInfoView) a3(i10)).m(assetData);
    }

    @Override // f5.c
    public void N2() {
        super.N2();
        S2().O();
    }

    @Override // f5.d
    public void R2() {
        z3(new g2(this, this));
        l3();
        ((KoocanEmptyView) a3(R$id.mPlayEmptyView)).setBackground(0);
        Intent intent = getIntent();
        i.f(intent, "intent");
        k3(intent);
        r3(this.f8009o, this.f8008n, null);
    }

    @Override // i6.g0
    public void T1(String str, Program program) {
        TitanVODView titanVODView;
        TitanVODView titanVODView2;
        TitanVODView titanVODView3;
        i.g(str, "contentId");
        i.g(program, "program");
        int i10 = R$id.mVodPlayer;
        TitanPlayerController titanPlayerController = (TitanPlayerController) a3(i10);
        if (titanPlayerController != null) {
            titanPlayerController.W4(str);
        }
        TitanPlayerController titanPlayerController2 = (TitanPlayerController) a3(i10);
        if (titanPlayerController2 != null) {
            titanPlayerController2.X4(S2().a0());
        }
        h hVar = h.f8694a;
        if (!hVar.o()) {
            int i11 = R$id.mVideoViewVod;
            n8.b titanContext = ((TitanVODView) a3(i11)).getTitanContext();
            if ((titanContext != null ? titanContext.a() : null) != null && (titanVODView3 = (TitanVODView) a3(i11)) != null) {
                titanVODView3.C();
            }
            TitanPlayerController titanPlayerController3 = (TitanPlayerController) a3(i10);
            if (titanPlayerController3 != null) {
                titanPlayerController3.b3();
            }
            ((TitanVODView) a3(i11)).B(program, str, program.getBuss());
            TitanPlayerController titanPlayerController4 = (TitanPlayerController) a3(i10);
            if (titanPlayerController4 != null) {
                Movie X = S2().X();
                i.d(X);
                titanPlayerController4.T2(X);
                return;
            }
            return;
        }
        TitanPlayerController titanPlayerController5 = (TitanPlayerController) a3(i10);
        if (titanPlayerController5 != null) {
            TitanPlayerController.V1(titanPlayerController5, false, false, 2, null);
        }
        int i12 = R$id.mVideoViewVod;
        n8.b titanContext2 = ((TitanVODView) a3(i12)).getTitanContext();
        if ((titanContext2 != null ? titanContext2.h() : null) != null && (titanVODView2 = (TitanVODView) a3(i12)) != null) {
            titanVODView2.D();
        }
        n8.b titanContext3 = ((TitanVODView) a3(i12)).getTitanContext();
        if ((titanContext3 != null ? titanContext3.a() : null) != null && (titanVODView = (TitanVODView) a3(i12)) != null) {
            titanVODView.C();
        }
        TitanPlayerController titanPlayerController6 = (TitanPlayerController) a3(i10);
        if (titanPlayerController6 != null) {
            titanPlayerController6.c3();
        }
        ((TitanVODView) a3(i12)).v(program, program.getBuss());
        hVar.K(false);
    }

    @Override // f5.d
    public int T2() {
        return R.layout.aty_play;
    }

    @Override // i6.g0
    public void W0(AssetData assetData) {
        i.g(assetData, "data");
        H3(assetData);
    }

    public View a3(int i10) {
        Map map = this.F;
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

    @xa.j
    public final void castPlayEvent(CastPlaySuccessEvent castPlaySuccessEvent) {
        i.g(castPlaySuccessEvent, "event");
        y3();
    }

    @Override // i6.g0
    public void d0(AssetData assetData) {
        i.g(assetData, "program");
        TitanPlayerController titanPlayerController = (TitanPlayerController) a3(R$id.mVodPlayer);
        if (titanPlayerController != null) {
            TitanPlayerController.k3(titanPlayerController, 0L, 1, null);
        }
        e.f17341a = true;
        Intent intent = new Intent(this, (Class<?>) PlayAty.class);
        intent.putExtra("extra_switch_season", true);
        intent.putExtra(g0.f14313b0.j(), this.f8007m);
        intent.putExtra("extra_program", assetData);
        v3(intent);
    }

    @Override // i6.g0
    public void d2() {
        String z10 = r5.i.f18523a.z();
        if (z10.length() == 0) {
            z10 = "20900";
        }
        String str = z10;
        y yVar = y.f8771a;
        String c10 = yVar.c(str);
        String str2 = c10 + ASCIIPropertyListParser.DATE_DATE_FIELD_DELIMITER + x.f8754a.y(Q1(), R.string.failed_ec5);
        c2.d dVar = c2.d.f5311a;
        String str3 = H;
        String str4 = e.f17342b;
        i.f(str4, "dcsMark");
        dVar.g("", str3, str4, yVar.n(), "", c10, str, "apk");
        f1.f8649a.x(str2);
    }

    @Override // i6.g0
    public void f0(AssetData assetData) {
        i.g(assetData, "data");
        I3(assetData);
    }

    public final void f3(int i10, int i11) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i10, i11);
        TitanPlayerController titanPlayerController = (TitanPlayerController) a3(R$id.mVodPlayer);
        if (titanPlayerController != null) {
            titanPlayerController.setLayoutParams(layoutParams);
        }
        f.c("playerWindow redraw", new Object[0]);
        ((TitanVODView) a3(R$id.mVideoViewVod)).requestLayout();
    }

    @Override // i6.g0
    public void g0(boolean z10) {
        O2(z10);
    }

    public final void g3() {
        PopupWindow popupWindow;
        PopupWindow popupWindow2 = this.E;
        boolean z10 = false;
        if (popupWindow2 != null && popupWindow2.isShowing()) {
            z10 = true;
        }
        if (z10 && (popupWindow = this.E) != null) {
            popupWindow.dismiss();
        }
        ((ProgramSetInfoView) a3(R$id.mProgramSetInfoView)).h();
    }

    @xa.j(threadMode = ThreadMode.MAIN)
    public final void goToSharing(GoToSharingEvent goToSharingEvent) {
        i.g(goToSharingEvent, "event");
        i1.I(Q1(), "vodDetail");
        b0.j0(this, w6.i.f19214g.C() + "/#/shareApp", false, true, false, false, 24, null);
    }

    public final void h() {
        G3();
        a3(R$id.mInfoView).setVisibility(8);
        ((AutoFrameLayout) a3(R$id.mPlayLoadingView)).setVisibility(0);
    }

    public final void h3() {
        int i10 = R$id.mVodPlayer;
        TitanPlayerController titanPlayerController = (TitanPlayerController) a3(i10);
        if (!(titanPlayerController != null && titanPlayerController.B2())) {
            if (this.C) {
                return;
            }
            TitanPlayerController titanPlayerController2 = (TitanPlayerController) a3(i10);
            if (titanPlayerController2 != null) {
                titanPlayerController2.o2();
            }
            this.C = true;
            return;
        }
        try {
            Field declaredField = NestedScrollView.class.getDeclaredField("mScroller");
            declaredField.setAccessible(true);
            Object obj = declaredField.get((KoocanNestedScrollView) a3(R$id.mScroller));
            if (obj instanceof OverScroller) {
                Method declaredMethod = OverScroller.class.getDeclaredMethod("forceFinished", Boolean.TYPE);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke((OverScroller) obj, Boolean.TRUE);
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    @xa.j
    public final void handleRequestAuth(RequestAuthEvent requestAuthEvent) {
        i.g(requestAuthEvent, "event");
        if (!requestAuthEvent.isVideoStop() && this.f8017w) {
            S2().a0().clear();
            if (requestAuthEvent.isCast()) {
                h hVar = h.f8694a;
                this.f8016v = i.b(hVar.f(), "480p") ? o6.c.c() : i.b(hVar.f(), "720p") ? o6.c.b() : o6.c.a();
            }
            int i10 = R$id.mVodPlayer;
            TitanPlayerController titanPlayerController = (TitanPlayerController) a3(i10);
            if (titanPlayerController != null) {
                titanPlayerController.setVodQualityVisibility(8);
            }
            TitanPlayerController titanPlayerController2 = (TitanPlayerController) a3(i10);
            if (titanPlayerController2 != null) {
                titanPlayerController2.setVodSubtitleAudioVisibility(8);
            }
            H = requestAuthEvent.getData().getName();
            f0.a.a(S2(), this.f8009o, requestAuthEvent.getData().getContentId(), this.f8014t, this.f8007m, this.f8016v.c(), this.f8012r, this.f8013s, requestAuthEvent.isCast(), null, null, false, 1792, null);
            I = (i.b("movie", this.f8008n) || i.b("1", this.f8007m)) ? "" : String.valueOf(requestAuthEvent.getIndex());
        }
    }

    @xa.j
    public final void handleVodFavorite(VodFavEvent vodFavEvent) {
        i.g(vodFavEvent, "event");
        if (this.f8017w) {
            S2().l0(this.f8007m, vodFavEvent, this.f8012r);
        }
    }

    @xa.j
    public final void handleVodSubscribe(VodSubEvent vodSubEvent) {
        i.g(vodSubEvent, "event");
        if (this.f8017w) {
            S2().m0(this.f8007m, vodSubEvent);
        }
    }

    @Override // i6.g0
    public void i0() {
        f1.a.j(f1.f8649a, this, R.string.vod_sub_success, 0, 4, null);
    }

    @Override // f5.d
    /* renamed from: i3, reason: merged with bridge method [inline-methods] */
    public g2 S2() {
        g2 g2Var = this.D;
        if (g2Var != null) {
            return g2Var;
        }
        i.w("mPresenter");
        return null;
    }

    public final o6.b j3() {
        return this.f8016v;
    }

    @Override // i5.a
    public void k2() {
        n2();
    }

    public final void k3(Intent intent) {
        TitanPlayerController titanPlayerController;
        g0.a aVar = g0.f14313b0;
        String stringExtra = intent.getStringExtra(aVar.g());
        if (stringExtra == null) {
            stringExtra = "";
        }
        K = stringExtra;
        String stringExtra2 = intent.getStringExtra(aVar.j());
        if (stringExtra2 == null) {
            stringExtra2 = "1";
        }
        this.f8007m = stringExtra2;
        String stringExtra3 = intent.getStringExtra(aVar.f());
        if (stringExtra3 == null) {
            stringExtra3 = "movie";
        }
        this.f8008n = stringExtra3;
        String stringExtra4 = intent.getStringExtra(aVar.a());
        if (stringExtra4 == null) {
            stringExtra4 = " ";
        }
        this.f8009o = stringExtra4;
        this.f8010p = (EnterType) intent.getSerializableExtra(aVar.b());
        String stringExtra5 = intent.getStringExtra(aVar.i());
        if (stringExtra5 == null) {
            stringExtra5 = null;
        }
        this.f8011q = stringExtra5;
        this.f8012r = intent.getBooleanExtra(aVar.c(), false);
        this.f8013s = intent.getBooleanExtra(aVar.d(), false);
        this.f8014t = intent.getIntExtra(aVar.e(), -1);
        this.f8015u = intent.getBooleanExtra(aVar.k(), false);
        this.B = intent.getStringExtra(aVar.h());
        h hVar = h.f8694a;
        if (hVar.o() && !hVar.s() && i.b(this.f8009o, hVar.b())) {
            this.f8015u = true;
        }
        int i10 = R$id.mVodPlayer;
        TitanPlayerController titanPlayerController2 = (TitanPlayerController) a3(i10);
        if (titanPlayerController2 != null) {
            titanPlayerController2.A2(this.f8013s);
        }
        TitanPlayerController titanPlayerController3 = (TitanPlayerController) a3(i10);
        if (titanPlayerController3 != null) {
            titanPlayerController3.setVodFuncCallback(this);
        }
        int e10 = MainAty.A.e();
        this.f8016v = e10 != 1 ? e10 != 2 ? e10 != 3 ? o6.c.c() : o6.c.a() : o6.c.b() : o6.c.c();
        TitanPlayerController titanPlayerController4 = (TitanPlayerController) a3(i10);
        if (titanPlayerController4 != null) {
            titanPlayerController4.setVodQualityVisibility(8);
        }
        TitanPlayerController titanPlayerController5 = (TitanPlayerController) a3(i10);
        if (titanPlayerController5 != null) {
            titanPlayerController5.setVodQualityVisibility(8);
        }
        e.f17341a = true;
        q3();
        n3();
        if (!this.f8015u || (titanPlayerController = (TitanPlayerController) a3(i10)) == null) {
            return;
        }
        TitanPlayerController.V1(titanPlayerController, false, false, 2, null);
    }

    public final void l3() {
        int a10 = n5.a.f17268a.a(this);
        int percentHeightSize = AutoUtils.getPercentHeightSize(88);
        AutoRelativeLayout.LayoutParams layoutParams = new AutoRelativeLayout.LayoutParams(percentHeightSize, percentHeightSize);
        layoutParams.setMargins(0, a10, 0, 0);
        int i10 = R$id.mNavBack;
        ((ImageView) a3(i10)).setLayoutParams(layoutParams);
        ((ImageView) a3(i10)).setOnClickListener(new View.OnClickListener() { // from class: f5.u2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PlayAty.m3(PlayAty.this, view);
            }
        });
    }

    @Override // m6.a
    public void m() {
        String str;
        String mDetailDataContentId;
        SimpleProgramList curPlayProgram;
        g2 S2 = S2();
        HashMap a02 = S2().a0();
        int i10 = R$id.mVodPlayer;
        TitanPlayerController titanPlayerController = (TitanPlayerController) a3(i10);
        String str2 = "";
        if (titanPlayerController == null || (curPlayProgram = titanPlayerController.getCurPlayProgram()) == null || (str = curPlayProgram.getContentId()) == null) {
            str = "";
        }
        TitanPlayerController titanPlayerController2 = (TitanPlayerController) a3(i10);
        if (titanPlayerController2 != null && (mDetailDataContentId = titanPlayerController2.getMDetailDataContentId()) != null) {
            str2 = mDetailDataContentId;
        }
        g2.t0(S2, a02, str, str2, 0, null, 24, null);
    }

    public final void n3() {
        if (!d6.b.f12660a.y() || !this.f8013s) {
            ((MarqueeTextView) a3(R$id.mTvBindTip)).setVisibility(8);
            return;
        }
        int i10 = R$id.mTvBindTip;
        ((MarqueeTextView) a3(i10)).setVisibility(0);
        ((MarqueeTextView) a3(i10)).setOnClickListener(new View.OnClickListener() { // from class: f5.v2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PlayAty.o3(PlayAty.this, view);
            }
        });
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        h3();
        TitanPlayerController titanPlayerController = (TitanPlayerController) a3(R$id.mVodPlayer);
        if (titanPlayerController != null) {
            TitanPlayerController.l2(titanPlayerController, false, 1, null);
        }
    }

    @Override // androidx.appcompat.app.d, androidx.fragment.app.e, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        i.g(configuration, "newConfig");
        super.onConfigurationChanged(configuration);
        if (((TitanVODView) a3(R$id.mVideoViewVod)) == null) {
            f1.f8649a.w(R.string.exit_and_retry_text);
            return;
        }
        getResources().getConfiguration().orientation = configuration.orientation;
        int i10 = R$id.mVodPlayer;
        TitanPlayerController titanPlayerController = (TitanPlayerController) a3(i10);
        if (titanPlayerController != null) {
            titanPlayerController.Q1(configuration);
        }
        if (configuration.orientation == 2) {
            TitanPlayerController titanPlayerController2 = (TitanPlayerController) a3(i10);
            if (titanPlayerController2 != null) {
                titanPlayerController2.setRatioEnable(false);
            }
            f3(-1, -1);
            ((ImageView) a3(R$id.mNavBack)).setVisibility(8);
        } else {
            TitanPlayerController titanPlayerController3 = (TitanPlayerController) a3(i10);
            if (titanPlayerController3 != null) {
                titanPlayerController3.setRatioEnable(true);
            }
            f3(-1, AutoUtils.getPercentHeightSize(448));
            ((ImageView) a3(R$id.mNavBack)).setVisibility(0);
        }
        g3();
    }

    @Override // f5.d, f5.c, u8.a, androidx.appcompat.app.d, androidx.fragment.app.e, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (!this.C) {
            TitanPlayerController titanPlayerController = (TitanPlayerController) a3(R$id.mVodPlayer);
            if (titanPlayerController != null) {
                titanPlayerController.o2();
            }
            this.C = true;
        }
        e.f17341a = false;
    }

    @Override // androidx.appcompat.app.d, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i10, KeyEvent keyEvent) {
        h hVar = h.f8694a;
        if (i.b(hVar.a(), hVar.k())) {
            if (i10 != 24) {
                if (i10 == 25 && ((AutoLinearLayout) a3(R$id.llCastContainer)).getVisibility() == 0) {
                    com.mobile.brasiltv.utils.g0.f8670a.o();
                    return true;
                }
            } else if (((AutoLinearLayout) a3(R$id.llCastContainer)).getVisibility() == 0) {
                com.mobile.brasiltv.utils.g0.f8670a.a();
                return true;
            }
        }
        return super.onKeyDown(i10, keyEvent);
    }

    @Override // androidx.fragment.app.e, android.app.Activity
    public void onNewIntent(Intent intent) {
        i.g(intent, "intent");
        super.onNewIntent(intent);
        v3(intent);
    }

    @Override // f5.c, u8.a, androidx.fragment.app.e, android.app.Activity
    public void onPause() {
        TitanPlayerController titanPlayerController;
        super.onPause();
        this.f8017w = false;
        int i10 = R$id.mVodPlayer;
        TitanPlayerController titanPlayerController2 = (TitanPlayerController) a3(i10);
        if (titanPlayerController2 != null) {
            titanPlayerController2.p2();
        }
        if (!this.f8015u && (titanPlayerController = (TitanPlayerController) a3(i10)) != null) {
            TitanPlayerController.k3(titanPlayerController, 0L, 1, null);
        }
        if (getResources().getConfiguration().orientation == 2) {
            getResources().getConfiguration().orientation = 1;
            setRequestedOrientation(1);
        }
    }

    @Override // f5.c, u8.a, androidx.fragment.app.e, android.app.Activity
    public void onResume() {
        String str;
        String mDetailDataContentId;
        SimpleProgramList curPlayProgram;
        super.onResume();
        this.f8017w = true;
        int i10 = R$id.mVodPlayer;
        TitanPlayerController titanPlayerController = (TitanPlayerController) a3(i10);
        if (titanPlayerController != null) {
            titanPlayerController.q2();
        }
        h hVar = h.f8694a;
        if (!hVar.o() && !hVar.p()) {
            n8.b titanContext = ((TitanVODView) a3(R$id.mVideoViewVod)).getTitanContext();
            if ((titanContext != null ? titanContext.h() : null) == null) {
                g2 S2 = S2();
                HashMap a02 = S2().a0();
                TitanPlayerController titanPlayerController2 = (TitanPlayerController) a3(i10);
                if (titanPlayerController2 == null || (curPlayProgram = titanPlayerController2.getCurPlayProgram()) == null || (str = curPlayProgram.getContentId()) == null) {
                    str = "";
                }
                TitanPlayerController titanPlayerController3 = (TitanPlayerController) a3(i10);
                g2.t0(S2, a02, str, (titanPlayerController3 == null || (mDetailDataContentId = titanPlayerController3.getMDetailDataContentId()) == null) ? "" : mDetailDataContentId, 0, null, 24, null);
            }
        }
        hVar.x(false);
        ((ProgramActorInfoView) a3(R$id.mActorInfoView)).setIsResumed(true);
        this.C = false;
    }

    @Override // u8.a, androidx.appcompat.app.d, androidx.fragment.app.e, android.app.Activity
    public void onStop() {
        super.onStop();
        ((ProgramActorInfoView) a3(R$id.mActorInfoView)).setIsResumed(false);
        Log.e("TAG-FIX", "onStop--2");
    }

    public final void p3(boolean z10) {
        b0.U(this, "ProgramInfoView isCr " + z10);
        int i10 = R$id.mProgramRecommendInfo;
        ((ProgramRecommendInfoView) a3(i10)).clearAnimation();
        if (z10) {
            ((ProgramRecommendInfoView) a3(i10)).setVisibility(0);
            ((DivisionLineView) a3(R$id.mProgramInfoLine)).setVisibility(0);
        } else {
            ((ProgramRecommendInfoView) a3(i10)).setVisibility(0);
            ((DivisionLineView) a3(R$id.mProgramInfoLine)).setVisibility(0);
        }
    }

    public final void q3() {
        int i10 = R$id.adNativeView;
        SmallAdNativeContainer smallAdNativeContainer = (SmallAdNativeContainer) a3(i10);
        if (smallAdNativeContainer != null) {
            smallAdNativeContainer.setNativeAdCallback(new b());
        }
        a6.a aVar = a6.a.f228a;
        if (aVar.s()) {
            SmallAdNativeContainer smallAdNativeContainer2 = (SmallAdNativeContainer) a3(i10);
            if (smallAdNativeContainer2 != null) {
                String string = Q1().getString(R.string.vod_detail_ad_id);
                i.f(string, "context.getString(R.string.vod_detail_ad_id)");
                smallAdNativeContainer2.loadAd(new e1(string, aVar.r(), null, true, 4, null), this.f8012r);
                return;
            }
            return;
        }
        SmallAdNativeContainer smallAdNativeContainer3 = (SmallAdNativeContainer) a3(i10);
        if (smallAdNativeContainer3 != null) {
            String string2 = Q1().getString(R.string.vod_detail_ad_id);
            i.f(string2, "context.getString(R.string.vod_detail_ad_id)");
            smallAdNativeContainer3.loadOwn(new e1(string2, aVar.r(), null, true, 4, null), this.f8012r);
        }
    }

    public final void r3(final String str, String str2, AssetData assetData) {
        if (TextUtils.isEmpty(ha.b.f14245a.a())) {
            return;
        }
        h();
        if (this.f8015u && h.f8694a.d() != null) {
            new Handler().post(new Runnable() { // from class: f5.w2
                @Override // java.lang.Runnable
                public final void run() {
                    PlayAty.s3(PlayAty.this, str);
                }
            });
        } else if (assetData != null) {
            G2();
            S2().E0(str, assetData);
            E3(assetData);
        } else if (i.b("1", this.f8007m)) {
            this.f8018x = str;
            this.f8019y = String.valueOf(this.f8011q);
            this.f8020z = String.valueOf(this.f8011q);
            this.A = 0;
            u3(this, str, 0, String.valueOf(this.f8011q), null, null, 24, null);
        } else {
            x3(str);
        }
        if (this.f8012r) {
            S2().P(str);
        } else {
            S2().c0(str, this.f8007m);
        }
    }

    @xa.j
    public final void selectedSeason(SelectedSeason selectedSeason) {
        i.g(selectedSeason, "event");
        if (this.f8017w) {
            S2().q0(selectedSeason.getProgramSeason(), this.f8007m);
        }
    }

    @xa.j(threadMode = ThreadMode.MAIN)
    public final void showVodSharingGuide(ShowVodSharingGuideEvent showVodSharingGuideEvent) {
        i.g(showVodSharingGuideEvent, "event");
        a3(R$id.mInfoView).post(new Runnable() { // from class: f5.t2
            @Override // java.lang.Runnable
            public final void run() {
                PlayAty.F3(PlayAty.this);
            }
        });
    }

    @Override // m6.a
    public void t0(View view, boolean z10, boolean z11) {
        i.g(view, "qualityView");
        List Y = S2().Y();
        if (Y.isEmpty()) {
            return;
        }
        String string = getResources().getString(R.string.popup_quality_title);
        i.f(string, "resources.getString(R.string.popup_quality_title)");
        int i10 = 0;
        int i11 = 0;
        for (Object obj : Y) {
            int i12 = i10 + 1;
            if (i10 < 0) {
                i9.j.j();
            }
            if (i.b(((o6.d) obj).c(), this.f8016v.c())) {
                i11 = i10;
            }
            i10 = i12;
        }
        if (z10) {
            n6.c cVar = new n6.c(false);
            g7.j jVar = new g7.j(this, string, cVar);
            cVar.b(i11);
            cVar.addData((Collection) Y);
            jVar.m(this, 5);
            this.E = jVar;
        } else {
            n6.b bVar = new n6.b(false);
            g7.d dVar = new g7.d(this, string, bVar);
            bVar.c(i11);
            bVar.addData((Collection) Y);
            dVar.c(true);
            this.E = dVar;
        }
        PopupWindow popupWindow = this.E;
        if (popupWindow != null) {
            popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: f5.y2
                @Override // android.widget.PopupWindow.OnDismissListener
                public final void onDismiss() {
                    PlayAty.w3(PlayAty.this);
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0044  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void t3(java.lang.String r64, int r65, java.lang.String r66, java.lang.String r67, int[] r68) {
        /*
            Method dump skipped, instructions count: 447
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mobile.brasiltv.activity.PlayAty.t3(java.lang.String, int, java.lang.String, java.lang.String, int[]):void");
    }

    @Override // i6.g0
    public void u1(boolean z10) {
        TitanPlayerController titanPlayerController;
        int i10 = R$id.mVodPlayer;
        TitanPlayerController titanPlayerController2 = (TitanPlayerController) a3(i10);
        if (titanPlayerController2 != null) {
            titanPlayerController2.a2();
        }
        if (!z10 || (titanPlayerController = (TitanPlayerController) a3(i10)) == null) {
            return;
        }
        titanPlayerController.I4();
    }

    public final void v3(Intent intent) {
        k3(intent);
        int i10 = R$id.mVodPlayer;
        TitanPlayerController titanPlayerController = (TitanPlayerController) a3(i10);
        if (titanPlayerController != null) {
            titanPlayerController.Z1();
        }
        TitanPlayerController titanPlayerController2 = (TitanPlayerController) a3(i10);
        if (titanPlayerController2 != null) {
            titanPlayerController2.e3();
        }
        ((TitanVODView) a3(R$id.mVideoViewVod)).D();
        if (!intent.getBooleanExtra("extra_switch_season", false)) {
            r3(this.f8009o, this.f8008n, null);
            return;
        }
        Serializable serializableExtra = intent.getSerializableExtra("extra_program");
        i.e(serializableExtra, "null cannot be cast to non-null type mobile.com.requestframe.utils.response.AssetData");
        AssetData assetData = (AssetData) serializableExtra;
        this.f8009o = assetData.getContentId();
        String programType = assetData.getProgramType();
        this.f8008n = programType;
        r3(this.f8009o, programType, assetData);
    }

    @Override // i6.g0
    public void w2() {
        TitanPlayerController titanPlayerController = (TitanPlayerController) a3(R$id.mVodPlayer);
        if (titanPlayerController != null) {
            titanPlayerController.T3();
        }
    }

    public final void x3(String str) {
        int[] iArr;
        Album queryRecordInfo = this.f8006l.queryRecordInfo(str);
        if (queryRecordInfo != null) {
            iArr = new int[]{queryRecordInfo.getSeriesNumber()};
        } else {
            queryRecordInfo = new Album();
            queryRecordInfo.setPlayContentId(str);
            queryRecordInfo.setContentId(str);
            queryRecordInfo.setPlayName(this.f8011q);
            queryRecordInfo.setAlias(this.f8011q);
            queryRecordInfo.setPlayIndex(0);
            iArr = null;
        }
        this.f8018x = String.valueOf(queryRecordInfo.getPlayContentId());
        this.f8019y = String.valueOf(queryRecordInfo.getPlayName());
        this.f8020z = String.valueOf(queryRecordInfo.getAlias());
        int playIndex = queryRecordInfo.getPlayIndex();
        this.A = playIndex;
        t3(this.f8018x, playIndex, this.f8019y, "1", iArr);
    }

    @Override // i6.g0
    public void y0(String str) {
        i.g(str, "errorCode");
        j1.h(this, str);
        ((AutoFrameLayout) a3(R$id.mPlayLoadingView)).setVisibility(8);
        int i10 = R$id.mPlayEmptyView;
        ((KoocanEmptyView) a3(i10)).changeType(KoocanEmptyView.Type.NO_DISCUSS);
        KoocanEmptyView koocanEmptyView = (KoocanEmptyView) a3(i10);
        String string = getResources().getString(R.string.vod_program_exception);
        i.f(string, "resources.getString(R.st…ng.vod_program_exception)");
        koocanEmptyView.setTip(string);
        ((KoocanEmptyView) a3(i10)).setVisibility(0);
        a3(R$id.mInfoView).setVisibility(8);
    }

    public final void y3() {
        h hVar = h.f8694a;
        hVar.M(this.f8007m);
        hVar.J(this.f8008n);
        hVar.y(this.f8009o);
        hVar.A(this.f8010p);
        hVar.L(this.f8011q);
        hVar.z(this.f8012r);
        hVar.B(this.f8013s);
        hVar.I(this.f8014t);
        hVar.D(S2().b0());
        hVar.F(S2().X());
        hVar.G(this.f8016v.c());
        hVar.h().clear();
        hVar.h().putAll(S2().a0());
        hVar.g().putAll(S2().Z());
    }

    @Override // m6.a
    public void z(View view, boolean z10, Movie movie) {
        i.g(view, "castView");
        if (b8.a.f5079a.c(this)) {
            xa.c.c().j(new CastToCloseOtherPlayEvent("VOD", false, 2, null));
            b0.d0(this, CastByNativeDeviceAty.class, c.f8022a);
        } else {
            C3();
        }
        i1.g(this, "EVENT_CAST_VOD_CLICK");
    }

    @Override // i6.g0
    public long z1() {
        TitanPlayerController titanPlayerController = (TitanPlayerController) a3(R$id.mVodPlayer);
        if (titanPlayerController != null) {
            return titanPlayerController.V2();
        }
        return 0L;
    }

    public void z3(g2 g2Var) {
        i.g(g2Var, "<set-?>");
        this.D = g2Var;
    }
}
