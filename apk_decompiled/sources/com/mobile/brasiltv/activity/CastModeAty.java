package com.mobile.brasiltv.activity;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.mediarouter.app.MediaRouteButton;
import com.advertlib.bean.AdInfo;
import com.google.android.gms.cast.framework.CastContext;
import com.google.android.gms.cast.framework.CastSession;
import com.google.android.gms.cast.framework.media.NotificationOptions;
import com.hpplay.component.common.ParamsMap;
import com.hpplay.sdk.source.common.global.Constant;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.activity.CastModeAty;
import com.mobile.brasiltv.bean.event.CastExperienceModelToPlayEvent;
import com.mobile.brasiltv.bean.event.CastToFinishModeAtyEvent;
import com.mobile.brasiltv.bean.event.GoogleCastToPlayEvent;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.utils.h;
import com.mobile.brasiltv.utils.i1;
import com.mobile.brasiltv.view.TitleView;
import com.msandroid.mobile.R;
import com.titans.entity.CdnType;
import com.zhy.autolayout.AutoFrameLayout;
import com.zhy.autolayout.AutoRelativeLayout;
import com.zhy.autolayout.utils.AutoUtils;
import h9.t;
import java.util.LinkedHashMap;
import java.util.Map;
import na.f;
import s1.m;
import s1.q;
import s9.l;
import t9.g;
import t9.i;
import t9.j;
import tv.danmaku.ijk.media.player.misc.IjkMediaFormat;
import w6.i;
import z5.c;

/* loaded from: classes.dex */
public final class CastModeAty extends f5.c implements c.b, c.InterfaceC0353c {

    /* renamed from: v, reason: collision with root package name */
    public static final a f7824v = new a(null);

    /* renamed from: l, reason: collision with root package name */
    public boolean f7826l;

    /* renamed from: o, reason: collision with root package name */
    public boolean f7829o;

    /* renamed from: p, reason: collision with root package name */
    public z5.c f7830p;

    /* renamed from: q, reason: collision with root package name */
    public CastContext f7831q;

    /* renamed from: s, reason: collision with root package name */
    public ObjectAnimator f7833s;

    /* renamed from: u, reason: collision with root package name */
    public Map f7835u = new LinkedHashMap();

    /* renamed from: k, reason: collision with root package name */
    public String f7825k = "";

    /* renamed from: m, reason: collision with root package name */
    public String f7827m = "";

    /* renamed from: n, reason: collision with root package name */
    public String f7828n = "";

    /* renamed from: r, reason: collision with root package name */
    public boolean f7832r = true;

    /* renamed from: t, reason: collision with root package name */
    public final c f7834t = new c();

    /* loaded from: classes3.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }

    /* loaded from: classes3.dex */
    public static final class b extends j implements l {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AdInfo f7837b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(AdInfo adInfo) {
            super(1);
            this.f7837b = adInfo;
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke(((Boolean) obj).booleanValue());
            return t.f14242a;
        }

        public final void invoke(boolean z10) {
            if (!z10) {
                ((TextView) CastModeAty.this.X2(R$id.mTvAdFlag)).setVisibility(8);
                return;
            }
            if (this.f7837b.isShowFlag()) {
                ((TextView) CastModeAty.this.X2(R$id.mTvAdFlag)).setVisibility(0);
            } else {
                ((TextView) CastModeAty.this.X2(R$id.mTvAdFlag)).setVisibility(8);
            }
            ((AutoFrameLayout) CastModeAty.this.X2(R$id.mAflAdWrapper)).setVisibility(0);
            q qVar = q.f18727a;
            Context Q1 = CastModeAty.this.Q1();
            String m10 = d6.b.f12660a.m(CastModeAty.this.Q1());
            a6.a aVar = a6.a.f228a;
            qVar.j(Q1, m10, aVar.a(), this.f7837b);
            m.f18686a.d0(CastModeAty.this.Q1(), aVar.a(), this.f7837b.getAd_id());
        }
    }

    /* loaded from: classes3.dex */
    public static final class c extends Handler {
        public c() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            i.g(message, Constant.KEY_MSG);
            super.handleMessage(message);
            if (message.what == 1) {
                CastModeAty.this.a3();
            }
        }
    }

    public static final void e3(CastModeAty castModeAty, View view) {
        i.g(castModeAty, "this$0");
        b0.l(castModeAty);
    }

    public static final void f3(CastModeAty castModeAty, View view) {
        i.g(castModeAty, "this$0");
        int i10 = R$id.mTvRealChromeCast;
        if (((MediaRouteButton) castModeAty.X2(i10)).getVisibility() != 0) {
            ((TextView) castModeAty.X2(R$id.mTvMockChromeCast)).performClick();
        } else {
            i1.j(castModeAty, w6.i.f19214g.H(), "CHROME_CAST");
            ((MediaRouteButton) castModeAty.X2(i10)).performClick();
        }
    }

    public static final void g3(CastModeAty castModeAty, View view) {
        i.g(castModeAty, "this$0");
        if (castModeAty.f7832r) {
            castModeAty.r3();
        } else {
            castModeAty.m3();
        }
    }

    public static final void h3(CastModeAty castModeAty, View view) {
        i.g(castModeAty, "this$0");
        i1.j(castModeAty, w6.i.f19214g.H(), "DLNA");
    }

    public static final void j3(AdInfo adInfo, CastModeAty castModeAty, View view) {
        i.g(castModeAty, "this$0");
        if (i.b(adInfo.getAction_type(), "1") && !TextUtils.isEmpty(adInfo.getAction())) {
            b0.j0(castModeAty.Q1(), adInfo.getAction(), false, true, false, false, 24, null);
            q.f18727a.h(castModeAty.Q1(), d6.b.f12660a.m(castModeAty.Q1()), a6.a.f228a.a(), adInfo);
        } else if (i.b(adInfo.getAction_type(), CdnType.DIGITAL_TYPE_PCDN)) {
            b0.m(castModeAty.Q1());
        }
    }

    public static final void p3(CastModeAty castModeAty, View view) {
        i.g(castModeAty, "this$0");
        b0.l(castModeAty);
    }

    @Override // z5.c.InterfaceC0353c
    public void D0(CastSession castSession, String str) {
        Z2();
        h hVar = h.f8694a;
        hVar.w(hVar.l());
        if (i.b(this.f7825k, "EXPERIENCE")) {
            xa.c.c().j(new CastExperienceModelToPlayEvent(false));
        } else if (i.b(this.f7825k, "LIVE") || i.b(this.f7825k, "VOD")) {
            xa.c.c().j(new GoogleCastToPlayEvent(this.f7825k));
        } else if (this.f7826l) {
            b0.c0(this, ExperienceCastPlayAty.class);
        }
        finish();
    }

    @Override // z5.c.InterfaceC0353c
    public void K0(CastSession castSession, int i10) {
    }

    @Override // z5.c.b
    public void P0() {
        ((MediaRouteButton) X2(R$id.mTvRealChromeCast)).setVisibility(0);
        Z2();
    }

    @Override // z5.c.InterfaceC0353c
    public void V0(CastSession castSession) {
        Z2();
        s3();
    }

    public View X2(int i10) {
        Map map = this.f7835u;
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

    @Override // z5.c.InterfaceC0353c
    public void Z(CastSession castSession, boolean z10) {
    }

    public final void Z2() {
        this.f7829o = false;
        ((ImageView) X2(R$id.mIvChromeCastLoading)).setVisibility(8);
        ((TextView) X2(R$id.mTvChromeCastHint)).setVisibility(8);
        b3();
        this.f7834t.removeMessages(1);
    }

    public final void a3() {
        this.f7829o = false;
        ((ImageView) X2(R$id.mIvChromeCastLoading)).setVisibility(8);
        b3();
        o3();
    }

    @Override // z5.c.InterfaceC0353c
    public void b1(CastSession castSession, int i10) {
        Z2();
    }

    public final void b3() {
        ObjectAnimator objectAnimator = this.f7833s;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        this.f7833s = null;
    }

    public final void c3() {
        if (this.f7832r) {
            Z2();
        }
    }

    public final void d3() {
        ((TitleView) X2(R$id.mTitleView)).setTvMenuClickListener(new View.OnClickListener() { // from class: f5.r
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CastModeAty.e3(CastModeAty.this, view);
            }
        });
        ((AutoFrameLayout) X2(R$id.mTvChromeCastWrapper)).setOnClickListener(new View.OnClickListener() { // from class: f5.s
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CastModeAty.f3(CastModeAty.this, view);
            }
        });
        ((TextView) X2(R$id.mTvMockChromeCast)).setOnClickListener(new View.OnClickListener() { // from class: f5.t
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CastModeAty.g3(CastModeAty.this, view);
            }
        });
        ((TextView) X2(R$id.mTvDLNACast)).setOnClickListener(new View.OnClickListener() { // from class: f5.u
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CastModeAty.h3(CastModeAty.this, view);
            }
        });
    }

    @Override // z5.c.b
    public void g1() {
        ((MediaRouteButton) X2(R$id.mTvRealChromeCast)).setVisibility(0);
        Z2();
    }

    public final void i3() {
        TextView tvMenuView = ((TitleView) X2(R$id.mTitleView)).getTvMenuView();
        if (tvMenuView != null) {
            tvMenuView.setText(getResources().getString(R.string.cast_faq));
            tvMenuView.setBackgroundResource(R.drawable.bg_cast_help);
            tvMenuView.setTextColor(getResources().getColor(R.color.color_1ecd6a));
            ViewGroup.LayoutParams layoutParams = tvMenuView.getLayoutParams();
            i.e(layoutParams, "null cannot be cast to non-null type com.zhy.autolayout.AutoRelativeLayout.LayoutParams");
            AutoRelativeLayout.LayoutParams layoutParams2 = (AutoRelativeLayout.LayoutParams) layoutParams;
            ((RelativeLayout.LayoutParams) layoutParams2).width = AutoUtils.getPercentWidthSize(100);
            ((RelativeLayout.LayoutParams) layoutParams2).height = AutoUtils.getPercentWidthSize(42);
            layoutParams2.addRule(15);
            tvMenuView.setLayoutParams(layoutParams2);
        }
        m mVar = m.f18686a;
        Context Q1 = Q1();
        a6.a aVar = a6.a.f228a;
        String a10 = aVar.a();
        i.c cVar = w6.i.f19214g;
        final AdInfo H = mVar.H(Q1, a10, "picture", cVar.I(), true, cVar.r());
        if (H != null) {
            Context Q12 = Q1();
            int i10 = R$id.mIvAd;
            ImageView imageView = (ImageView) X2(i10);
            String a11 = aVar.a();
            t9.i.f(imageView, "mIvAd");
            mVar.g0(Q12, imageView, a11, H, (r23 & 16) != 0 ? null : null, (r23 & 32) != 0 ? null : new b(H), (r23 & 64) != 0 ? null : Integer.MIN_VALUE, (r23 & 128) != 0 ? false : false, (r23 & 256) != 0 ? -1 : 0);
            ((ImageView) X2(i10)).setOnClickListener(new View.OnClickListener() { // from class: f5.v
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CastModeAty.j3(AdInfo.this, this, view);
                }
            });
        }
        if (k3()) {
            int i11 = R$id.mTvChromeCastHint;
            ((TextView) X2(i11)).setVisibility(0);
            ((TextView) X2(i11)).setTextColor(getResources().getColor(R.color.color_secondary_assist));
            TextView textView = (TextView) X2(i11);
            String str = this.f7825k;
            textView.setText(t9.i.b(str, "VOD") ? getResources().getString(R.string.cast_not_supported_vod_chrome) : t9.i.b(str, "LIVE") ? getResources().getString(R.string.cast_not_supported_live_chrome) : "");
            int i12 = R$id.mTvMockChromeCast;
            ((TextView) X2(i12)).setBackgroundResource(R.drawable.bg_disable_cast_mode);
            ((TextView) X2(i12)).setTextColor(getResources().getColor(R.color.color_737780));
            ((TextView) X2(i12)).setEnabled(false);
        }
    }

    @Override // i5.a
    public void k2() {
        n2();
    }

    public final boolean k3() {
        return !this.f7826l && (t9.i.b(this.f7825k, "LIVE") || (t9.i.b(this.f7825k, "VOD") && !l3()));
    }

    @Override // z5.c.b
    public void l0() {
        if (this.f7829o) {
            ((MediaRouteButton) X2(R$id.mTvRealChromeCast)).performClick();
        }
        ((MediaRouteButton) X2(R$id.mTvRealChromeCast)).setVisibility(0);
        Z2();
    }

    public final boolean l3() {
        return t9.i.b(this.f7827m, IjkMediaFormat.CODEC_NAME_H264) && t9.i.b(this.f7828n, "mp4");
    }

    public final void m3() {
        int i10 = R$id.mTvChromeCastHint;
        ((TextView) X2(i10)).setVisibility(0);
        ((TextView) X2(i10)).setTextColor(getResources().getColor(R.color.color_f72f2f));
        ((TextView) X2(i10)).setText(Html.fromHtml(getResources().getString(R.string.cast_search_chrome_not_available)));
        ((TextView) X2(i10)).setOnClickListener(null);
    }

    public final void n3() {
        String e10 = f.e(getApplicationContext(), "last_cast_mode");
        if (b0.J(e10)) {
            ((TextView) X2(R$id.mTvLastTime)).setVisibility(8);
            return;
        }
        int i10 = R$id.mTvLastTime;
        ((TextView) X2(i10)).setVisibility(0);
        int i11 = t9.i.b(e10, "CHROME_CAST") ? R.id.mTvChromeCastWrapper : R.id.mTvDLNACast;
        ViewGroup.LayoutParams layoutParams = ((TextView) X2(i10)).getLayoutParams();
        t9.i.e(layoutParams, "null cannot be cast to non-null type com.zhy.autolayout.AutoRelativeLayout.LayoutParams");
        AutoRelativeLayout.LayoutParams layoutParams2 = (AutoRelativeLayout.LayoutParams) layoutParams;
        layoutParams2.addRule(6, i11);
        layoutParams2.addRule(7, i11);
        ((TextView) X2(i10)).setLayoutParams(layoutParams2);
    }

    public final void o3() {
        int i10 = R$id.mTvChromeCastHint;
        ((TextView) X2(i10)).setVisibility(0);
        ((TextView) X2(i10)).setTextColor(getResources().getColor(R.color.color_f72f2f));
        ((TextView) X2(i10)).setText(Html.fromHtml(getResources().getString(R.string.cast_search_chrome_fail)));
        ((TextView) X2(i10)).setOnClickListener(new View.OnClickListener() { // from class: f5.w
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CastModeAty.p3(CastModeAty.this, view);
            }
        });
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0085, code lost:
    
        if (r4.getCastState() == 1) goto L23;
     */
    @Override // f5.c, i5.a, u8.a, androidx.appcompat.app.d, androidx.fragment.app.e, androidx.activity.ComponentActivity, o.p, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onCreate(android.os.Bundle r4) {
        /*
            r3 = this;
            super.onCreate(r4)
            r4 = 2131558495(0x7f0d005f, float:1.8742307E38)
            r3.setContentView(r4)
            android.content.Intent r4 = r3.getIntent()
            java.lang.String r0 = "from_type"
            java.lang.String r4 = r4.getStringExtra(r0)
            java.lang.String r0 = ""
            if (r4 != 0) goto L18
            r4 = r0
        L18:
            r3.f7825k = r4
            android.content.Intent r4 = r3.getIntent()
            java.lang.String r1 = "experience_mode"
            r2 = 0
            boolean r4 = r4.getBooleanExtra(r1, r2)
            r3.f7826l = r4
            android.content.Intent r4 = r3.getIntent()
            java.lang.String r1 = "cast_video_encode_format"
            java.lang.String r4 = r4.getStringExtra(r1)
            if (r4 != 0) goto L34
            r4 = r0
        L34:
            r3.f7827m = r4
            android.content.Intent r4 = r3.getIntent()
            java.lang.String r1 = "cast_video_stream_format"
            java.lang.String r4 = r4.getStringExtra(r1)
            if (r4 != 0) goto L43
            goto L44
        L43:
            r0 = r4
        L44:
            r3.f7828n = r0
            r3.i3()
            r3.d3()
            z5.c$a r4 = z5.c.f20224e
            boolean r4 = r4.a(r3)
            r3.f7832r = r4
            boolean r4 = r3.k3()
            if (r4 == 0) goto L5c
            r3.f7832r = r2
        L5c:
            boolean r4 = r3.f7832r
            if (r4 == 0) goto L94
            com.google.android.gms.cast.framework.CastContext r4 = com.google.android.gms.cast.framework.CastContext.getSharedInstance(r3)
            r3.f7831q = r4
            z5.c r4 = new z5.c
            r4.<init>()
            r3.f7830p = r4
            android.content.Context r4 = r3.getApplicationContext()
            int r0 = com.mobile.brasiltv.R$id.mTvRealChromeCast
            android.view.View r1 = r3.X2(r0)
            androidx.mediarouter.app.MediaRouteButton r1 = (androidx.mediarouter.app.MediaRouteButton) r1
            com.google.android.gms.cast.framework.CastButtonFactory.setUpMediaRouteButton(r4, r1)
            com.google.android.gms.cast.framework.CastContext r4 = r3.f7831q
            if (r4 == 0) goto L88
            int r4 = r4.getCastState()
            r1 = 1
            if (r4 != r1) goto L88
            goto L89
        L88:
            r1 = 0
        L89:
            if (r1 != 0) goto L94
            android.view.View r4 = r3.X2(r0)
            androidx.mediarouter.app.MediaRouteButton r4 = (androidx.mediarouter.app.MediaRouteButton) r4
            r4.setVisibility(r2)
        L94:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mobile.brasiltv.activity.CastModeAty.onCreate(android.os.Bundle):void");
    }

    @Override // f5.c, u8.a, androidx.appcompat.app.d, androidx.fragment.app.e, android.app.Activity
    public void onDestroy() {
        b3();
        this.f7834t.removeMessages(1);
        super.onDestroy();
    }

    @Override // f5.c, u8.a, androidx.fragment.app.e, android.app.Activity
    public void onPause() {
        c3();
        z5.c cVar = this.f7830p;
        if (cVar != null) {
            cVar.n(this);
        }
        z5.c cVar2 = this.f7830p;
        if (cVar2 != null) {
            cVar2.p(this);
        }
        super.onPause();
    }

    @Override // f5.c, u8.a, androidx.fragment.app.e, android.app.Activity
    public void onResume() {
        z5.c cVar = this.f7830p;
        if (cVar != null) {
            cVar.c(this, this);
        }
        z5.c cVar2 = this.f7830p;
        if (cVar2 != null) {
            cVar2.g(this, this);
        }
        super.onResume();
        n3();
    }

    public final void q3() {
        int i10 = R$id.mTvChromeCastHint;
        ((TextView) X2(i10)).setVisibility(0);
        ((TextView) X2(i10)).setTextColor(getResources().getColor(R.color.color_1ecd6a));
        ((TextView) X2(i10)).setText(getResources().getString(R.string.cast_searching_chrome));
        ((TextView) X2(i10)).setOnClickListener(null);
    }

    @Override // z5.c.b
    public void r1() {
        ((MediaRouteButton) X2(R$id.mTvRealChromeCast)).setVisibility(8);
        Z2();
    }

    public final void r3() {
        this.f7829o = true;
        ((ImageView) X2(R$id.mIvChromeCastLoading)).setVisibility(0);
        s3();
        q3();
        this.f7834t.sendEmptyMessageDelayed(1, NotificationOptions.SKIP_STEP_TEN_SECONDS_IN_MS);
    }

    public final void s3() {
        b3();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat((ImageView) X2(R$id.mIvChromeCastLoading), ParamsMap.MirrorParams.KEY_ROTATION, 0.0f, 359.0f);
        this.f7833s = ofFloat;
        if (ofFloat != null) {
            ofFloat.setRepeatCount(-1);
        }
        ObjectAnimator objectAnimator = this.f7833s;
        if (objectAnimator != null) {
            objectAnimator.setDuration(2000L);
        }
        ObjectAnimator objectAnimator2 = this.f7833s;
        if (objectAnimator2 != null) {
            objectAnimator2.setInterpolator(new LinearInterpolator());
        }
        ObjectAnimator objectAnimator3 = this.f7833s;
        if (objectAnimator3 != null) {
            objectAnimator3.start();
        }
    }

    @xa.j
    public final void toFinishAty(CastToFinishModeAtyEvent castToFinishModeAtyEvent) {
        t9.i.g(castToFinishModeAtyEvent, "event");
        finish();
    }

    @Override // z5.c.InterfaceC0353c
    public void w1(CastSession castSession, int i10) {
    }
}
