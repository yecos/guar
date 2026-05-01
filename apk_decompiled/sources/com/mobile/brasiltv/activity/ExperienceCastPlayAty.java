package com.mobile.brasiltv.activity;

import android.content.Intent;
import android.net.Uri;
import android.text.Html;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.cast.MediaMetadata;
import com.google.android.gms.cast.framework.CastSession;
import com.google.android.gms.common.images.WebImage;
import com.hpplay.sdk.source.browse.api.LelinkServiceInfo;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.activity.ExperienceCastPlayAty;
import com.mobile.brasiltv.bean.event.CastExperienceModelToPlayEvent;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.utils.g0;
import com.mobile.brasiltv.utils.h;
import com.mobile.brasiltv.view.dialog.feedback.CastFeedBackDialog;
import com.msandroid.mobile.R;
import com.titans.entity.CdnType;
import com.zhy.autolayout.AutoFrameLayout;
import com.zhy.autolayout.AutoLinearLayout;
import com.zhy.autolayout.utils.AutoUtils;
import i6.p;
import i6.q;
import i9.j;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import k6.z;
import s9.l;
import t9.i;
import z5.c;

/* loaded from: classes.dex */
public final class ExperienceCastPlayAty extends f5.d implements q, c.d, c.e {

    /* renamed from: l, reason: collision with root package name */
    public z f7880l;

    /* renamed from: u, reason: collision with root package name */
    public Map f7889u = new LinkedHashMap();

    /* renamed from: m, reason: collision with root package name */
    public int f7881m = 2;

    /* renamed from: n, reason: collision with root package name */
    public final List f7882n = j.h(o6.c.a(), o6.c.b(), o6.c.c());

    /* renamed from: o, reason: collision with root package name */
    public z5.c f7883o = new z5.c();

    /* renamed from: p, reason: collision with root package name */
    public final String f7884p = "http://www.oi1lgew.com/dl/4.mp4";

    /* renamed from: q, reason: collision with root package name */
    public final String f7885q = "http://www.oi1lgew.com/dl/5.mp4";

    /* renamed from: r, reason: collision with root package name */
    public final String f7886r = "http://www.oi1lgew.com/dl/1080p_short.mp4";

    /* renamed from: s, reason: collision with root package name */
    public final String f7887s = "http://www.oi1lgew.com/dl/pic00.jpg";

    /* renamed from: t, reason: collision with root package name */
    public String f7888t = "";

    /* loaded from: classes3.dex */
    public static final class a implements g0.a {
        public a() {
        }
    }

    /* loaded from: classes3.dex */
    public static final class b extends t9.j implements l {

        /* renamed from: a, reason: collision with root package name */
        public static final b f7891a = new b();

        public b() {
            super(1);
        }

        @Override // s9.l
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Intent invoke(Intent intent) {
            i.g(intent, "intent");
            Intent putExtra = intent.putExtra("from_type", "EXPERIENCE");
            i.f(putExtra, "intent.putExtra(Constant…ant.FROM_TYPE_EXPERIENCE)");
            return putExtra;
        }
    }

    /* loaded from: classes3.dex */
    public static final class c implements SeekBar.OnSeekBarChangeListener {
        public c() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i10, boolean z10) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            i.g(seekBar, "seekBar");
            if (((AutoLinearLayout) ExperienceCastPlayAty.this.c3(R$id.llCastContainer)).getVisibility() == 0) {
                h hVar = h.f8694a;
                if (i.b(hVar.a(), hVar.k())) {
                    g0.f8670a.i(seekBar.getProgress());
                } else if (i.b(hVar.a(), hVar.l())) {
                    ExperienceCastPlayAty.this.f7883o.q(seekBar.getProgress() * 1000);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class d extends ha.a {
        @Override // ha.a
        public void showErrorHint(String str) {
            i.g(str, "returnCode");
        }
    }

    public static final void k3(final ExperienceCastPlayAty experienceCastPlayAty, View view) {
        i.g(experienceCastPlayAty, "this$0");
        final n6.b bVar = new n6.b(false, 1, null);
        String string = experienceCastPlayAty.getResources().getString(R.string.popup_quality_title);
        i.f(string, "resources.getString(R.string.popup_quality_title)");
        final g7.d dVar = new g7.d(experienceCastPlayAty, string, bVar);
        bVar.c(experienceCastPlayAty.f7881m);
        bVar.addData((Collection) experienceCastPlayAty.f7882n);
        bVar.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() { // from class: f5.s0
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view2, int i10) {
                ExperienceCastPlayAty.l3(ExperienceCastPlayAty.this, bVar, dVar, baseQuickAdapter, view2, i10);
            }
        });
        dVar.c(true);
    }

    public static final void l3(ExperienceCastPlayAty experienceCastPlayAty, n6.b bVar, g7.d dVar, BaseQuickAdapter baseQuickAdapter, View view, int i10) {
        i.g(experienceCastPlayAty, "this$0");
        i.g(bVar, "$qualityAdapter");
        i.g(dVar, "$qualityPop");
        experienceCastPlayAty.f7881m = i10;
        if (bVar.b() != i10) {
            h hVar = h.f8694a;
            if (i.b(hVar.a(), hVar.k())) {
                experienceCastPlayAty.z3();
            } else if (i.b(hVar.a(), hVar.l())) {
                experienceCastPlayAty.A3();
            }
        }
        dVar.dismiss();
    }

    public static final void m3(ExperienceCastPlayAty experienceCastPlayAty, View view) {
        i.g(experienceCastPlayAty, "this$0");
        experienceCastPlayAty.finish();
    }

    public static final void n3(ExperienceCastPlayAty experienceCastPlayAty, View view) {
        i.g(experienceCastPlayAty, "this$0");
        b0.d0(experienceCastPlayAty, CastByNativeDeviceAty.class, b.f7891a);
    }

    public static final void o3(ExperienceCastPlayAty experienceCastPlayAty, View view) {
        i.g(experienceCastPlayAty, "this$0");
        new CastFeedBackDialog(experienceCastPlayAty).show();
    }

    public static final void p3(ExperienceCastPlayAty experienceCastPlayAty, View view) {
        i.g(experienceCastPlayAty, "this$0");
        h hVar = h.f8694a;
        if (!i.b(hVar.a(), hVar.k())) {
            if (i.b(hVar.a(), hVar.l())) {
                experienceCastPlayAty.f7883o.k();
                return;
            }
            return;
        }
        g0 g0Var = g0.f8670a;
        if (g0Var.f()) {
            g0Var.g();
        } else if (g0Var.e()) {
            g0Var.h();
        } else if (g0Var.d()) {
            experienceCastPlayAty.z3();
        }
    }

    public static final void q3(ExperienceCastPlayAty experienceCastPlayAty, View view) {
        i.g(experienceCastPlayAty, "this$0");
        b0.l(experienceCastPlayAty);
    }

    public static final void s3(ExperienceCastPlayAty experienceCastPlayAty, View view) {
        i.g(experienceCastPlayAty, "this$0");
        experienceCastPlayAty.finish();
    }

    public final void A3() {
        int i10 = this.f7881m;
        this.f7883o.j(i10 != 0 ? i10 != 1 ? i10 != 2 ? this.f7884p : this.f7884p : this.f7885q : this.f7886r, 0, 0L, g3());
        this.f7883o.l(this, "Experience", "Experience", "Experience", "vod", CdnType.TYPE_ICDN, (r21 & 64) != 0 ? "" : null, (r21 & 128) != 0 ? "" : null);
        this.f7888t = h.f8694a.l();
        e3();
    }

    @Override // z5.c.d
    public void L0() {
    }

    @Override // z5.c.d
    public void L1(int i10) {
        ((ImageView) c3(R$id.mImagePlayCast)).setImageResource(R.drawable.icon_play_white);
        h3(i10);
    }

    @Override // z5.c.e
    public void N1(long j10, long j11) {
        long j12 = 1000;
        long j13 = j11 / j12;
        long j14 = j10 / j12;
        int i10 = R$id.mSeekBarCast;
        int i11 = (int) j13;
        if (((SeekBar) c3(i10)).getMax() != i11) {
            ((SeekBar) c3(i10)).setMax(i11);
        }
        ((SeekBar) c3(i10)).setProgress((int) j14);
        String l10 = y6.a.l(j13);
        String l11 = y6.a.l(j14);
        int i12 = R$id.mTextTotalTimeCast;
        if (!i.b(((TextView) c3(i12)).getText(), '/' + l10)) {
            ((TextView) c3(i12)).setText('/' + l10);
        }
        ((TextView) c3(R$id.mTextCurTimeCast)).setText(l11);
    }

    @Override // f5.d
    public void R2() {
        w3(new z(this, this));
        ((AutoLinearLayout) c3(R$id.llCastContainer)).setVisibility(0);
        r3();
        j3();
        i3();
        z3();
    }

    @Override // f5.d
    public int T2() {
        return R.layout.aty_experience_cast_play;
    }

    @Override // z5.c.d
    public void U() {
        ((ImageView) c3(R$id.mImagePlayCast)).setImageResource(R.drawable.icon_play_white);
    }

    @Override // z5.c.d
    public void b0() {
    }

    @Override // z5.c.d
    public void c2() {
        int i10 = R$id.mTvCastState;
        ((TextView) c3(i10)).setText(Q1().getResources().getString(R.string.cast_status_casting));
        ((TextView) c3(i10)).setTextColor(Q1().getResources().getColor(R.color.color_fffefe));
        ((TextView) c3(R$id.mTvPleaseWait)).setVisibility(8);
        ((TextView) c3(R$id.mTvCastRecommendHint)).setVisibility(4);
        v3();
        ((ImageView) c3(R$id.mImagePlayCast)).setImageResource(R.drawable.icon_pause_white);
    }

    public View c3(int i10) {
        Map map = this.f7889u;
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
    public final void castToPlay(CastExperienceModelToPlayEvent castExperienceModelToPlayEvent) {
        i.g(castExperienceModelToPlayEvent, "event");
        boolean z10 = !i.b(this.f7888t, h.f8694a.a());
        if (z10) {
            y3(this.f7888t);
        }
        if (castExperienceModelToPlayEvent.isDLNA()) {
            if (z10) {
                i3();
            }
            z3();
        } else {
            A3();
            if (z10) {
                t3();
            }
        }
    }

    @Override // z5.c.d
    public void e0() {
    }

    public final void e3() {
        int i10 = R$id.mTvCastState;
        ((TextView) c3(i10)).setText(Q1().getResources().getString(R.string.cast_status_prepare));
        ((TextView) c3(i10)).setTextColor(Q1().getResources().getColor(R.color.color_fffefe));
        ((TextView) c3(R$id.mTvPleaseWait)).setVisibility(0);
        ((TextView) c3(R$id.mTvCastRecommendHint)).setVisibility(4);
        v3();
        ((ImageView) c3(R$id.mImagePlayCast)).setImageResource(R.drawable.icon_pause_white);
        int i11 = this.f7881m;
        if (i11 == 2) {
            ((ImageView) c3(R$id.mIvCastQuality)).setImageResource(R.mipmap.icon_cast_definition_480);
        } else if (i11 == 1) {
            ((ImageView) c3(R$id.mIvCastQuality)).setImageResource(R.mipmap.icon_cast_definition_720);
        } else if (i11 == 0) {
            ((ImageView) c3(R$id.mIvCastQuality)).setImageResource(R.mipmap.icon_cast_definition_1080);
        }
    }

    @Override // f5.d
    /* renamed from: f3, reason: merged with bridge method [inline-methods] */
    public z S2() {
        z zVar = this.f7880l;
        if (zVar != null) {
            return zVar;
        }
        i.w("mPresenter");
        return null;
    }

    @Override // android.app.Activity
    public void finish() {
        y3(h.f8694a.a());
        super.finish();
    }

    public final MediaMetadata g3() {
        MediaMetadata mediaMetadata = new MediaMetadata(1);
        mediaMetadata.putString(MediaMetadata.KEY_TITLE, "Experience Video");
        mediaMetadata.putString(MediaMetadata.KEY_SUBTITLE, "");
        mediaMetadata.addImage(new WebImage(Uri.parse(this.f7887s)));
        return mediaMetadata;
    }

    public final void h3(int i10) {
        if (i10 == 1) {
            ((ImageView) c3(R$id.mImagePlayCast)).setImageResource(R.drawable.icon_play_white);
            return;
        }
        if (i10 == 3) {
            int i11 = R$id.mTvCastState;
            ((TextView) c3(i11)).setText(Q1().getResources().getString(R.string.cast_status_casting));
            ((TextView) c3(i11)).setTextColor(Q1().getResources().getColor(R.color.color_fffefe));
            ((TextView) c3(R$id.mTvPleaseWait)).setVisibility(8);
            ((TextView) c3(R$id.mTvCastRecommendHint)).setVisibility(4);
            v3();
            ((ImageView) c3(R$id.mImagePlayCast)).setImageResource(R.drawable.icon_pause_white);
            return;
        }
        if (i10 != 4) {
            return;
        }
        int i12 = R$id.mTvCastState;
        ((TextView) c3(i12)).setText(Q1().getResources().getString(R.string.cast_status_casting_failed));
        ((TextView) c3(i12)).append("(4)");
        ((TextView) c3(i12)).setTextColor(Q1().getResources().getColor(R.color.color_f72f2f));
        ((TextView) c3(R$id.mTvPleaseWait)).setVisibility(8);
        ((TextView) c3(R$id.mTvCastRecommendHint)).setVisibility(0);
        ((ImageView) c3(R$id.mImagePlayCast)).setImageResource(R.drawable.icon_play_white);
        u3();
    }

    public final void i3() {
        g0.f8670a.j(new a());
    }

    public final void j3() {
        ((ImageView) c3(R$id.mIvCastQuality)).setOnClickListener(new View.OnClickListener() { // from class: f5.m0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ExperienceCastPlayAty.k3(ExperienceCastPlayAty.this, view);
            }
        });
        ((ImageView) c3(R$id.mIvCastClose)).setOnClickListener(new View.OnClickListener() { // from class: f5.n0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ExperienceCastPlayAty.m3(ExperienceCastPlayAty.this, view);
            }
        });
        ((ImageView) c3(R$id.mIvCastSwitchDevice)).setOnClickListener(new View.OnClickListener() { // from class: f5.o0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ExperienceCastPlayAty.n3(ExperienceCastPlayAty.this, view);
            }
        });
        ((ImageView) c3(R$id.mIvCastFeedback)).setOnClickListener(new View.OnClickListener() { // from class: f5.p0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ExperienceCastPlayAty.o3(ExperienceCastPlayAty.this, view);
            }
        });
        ((SeekBar) c3(R$id.mSeekBarCast)).setOnSeekBarChangeListener(new c());
        ((ImageView) c3(R$id.mImagePlayCast)).setOnClickListener(new View.OnClickListener() { // from class: f5.q0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ExperienceCastPlayAty.p3(ExperienceCastPlayAty.this, view);
            }
        });
        ((TextView) c3(R$id.mTvCastRecommendHint)).setOnClickListener(new View.OnClickListener() { // from class: f5.r0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ExperienceCastPlayAty.q3(ExperienceCastPlayAty.this, view);
            }
        });
    }

    @Override // i5.a
    public void k2() {
        n2();
    }

    @Override // androidx.appcompat.app.d, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i10, KeyEvent keyEvent) {
        h hVar = h.f8694a;
        if (i.b(hVar.a(), hVar.k())) {
            if (i10 != 24) {
                if (i10 == 25 && ((AutoLinearLayout) c3(R$id.llCastContainer)).getVisibility() == 0) {
                    g0.f8670a.o();
                    return true;
                }
            } else if (((AutoLinearLayout) c3(R$id.llCastContainer)).getVisibility() == 0) {
                g0.f8670a.a();
                return true;
            }
        }
        return super.onKeyDown(i10, keyEvent);
    }

    public final void r3() {
        int a10 = n5.a.f17268a.a(this);
        int percentHeightSize = AutoUtils.getPercentHeightSize(88);
        AutoFrameLayout.LayoutParams layoutParams = new AutoFrameLayout.LayoutParams(percentHeightSize, percentHeightSize);
        layoutParams.setMargins(0, a10, 0, 0);
        int i10 = R$id.mNavBack;
        ((ImageView) c3(i10)).setLayoutParams(layoutParams);
        ((ImageView) c3(i10)).setOnClickListener(new View.OnClickListener() { // from class: f5.l0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ExperienceCastPlayAty.s3(ExperienceCastPlayAty.this, view);
            }
        });
        ((TextView) c3(R$id.mTvCastRecommendHint)).setText(Html.fromHtml(getResources().getString(R.string.cast_recommend_hint)));
    }

    public final void t3() {
        this.f7883o.l(this, "Experience", "Experience", "Experience", "vod", CdnType.TYPE_ICDN, (r21 & 64) != 0 ? "" : null, (r21 & 128) != 0 ? "" : null);
    }

    public final void u3() {
        w6.i.f19214g.b().s2("Experience", ((TextView) c3(R$id.mTvCastDevice)).getText().toString(), h.f8694a.a(), this.f7881m == 0 ? "480P" : "720P").subscribe(new d());
    }

    public final void v3() {
        CastDevice castDevice;
        String friendlyName;
        String name;
        h hVar = h.f8694a;
        String str = "";
        if (i.b(hVar.a(), hVar.k())) {
            int i10 = R$id.mTvCastDevice;
            TextView textView = (TextView) c3(i10);
            LelinkServiceInfo c10 = g0.f8670a.c();
            if (c10 != null && (name = c10.getName()) != null) {
                str = name;
            }
            textView.setText(str);
            ((TextView) c3(i10)).append("-DLNA");
            ((TextView) c3(R$id.mTvTitle)).setText(getResources().getString(R.string.cast_test_dlna));
            return;
        }
        int i11 = R$id.mTvCastDevice;
        TextView textView2 = (TextView) c3(i11);
        CastSession i12 = this.f7883o.i();
        if (i12 != null && (castDevice = i12.getCastDevice()) != null && (friendlyName = castDevice.getFriendlyName()) != null) {
            str = friendlyName;
        }
        textView2.setText(str);
        ((TextView) c3(i11)).append("-ChromeCast");
        ((TextView) c3(R$id.mTvTitle)).setText(getResources().getString(R.string.cast_test_google));
    }

    public void w3(z zVar) {
        i.g(zVar, "<set-?>");
        this.f7880l = zVar;
    }

    @Override // m5.a
    /* renamed from: x3, reason: merged with bridge method [inline-methods] */
    public void Y0(p pVar) {
        i.g(pVar, "presenter");
    }

    public final void y3(String str) {
        h hVar = h.f8694a;
        if (i.b(str, hVar.k())) {
            g0 g0Var = g0.f8670a;
            g0Var.b();
            g0Var.l(false);
        } else if (i.b(str, hVar.l())) {
            this.f7883o.s();
            this.f7883o.r();
        }
    }

    public final void z3() {
        g0 g0Var = g0.f8670a;
        g0Var.k("EXPERIENCE");
        g0Var.l(true);
        g0Var.m(this.f7881m);
        this.f7888t = h.f8694a.k();
        e3();
    }
}
