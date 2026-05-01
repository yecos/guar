package com.titans.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.mobile.brasiltv.view.RoundedDrawable;
import com.titan.ranger.bean.Program;
import l7.e;
import q8.d;

/* loaded from: classes3.dex */
public class TitanVODView extends TitanVideoView {

    /* renamed from: l, reason: collision with root package name */
    public String f9533l;

    /* renamed from: m, reason: collision with root package name */
    public Long f9534m;

    /* renamed from: n, reason: collision with root package name */
    public String f9535n;

    /* renamed from: o, reason: collision with root package name */
    public String f9536o;

    /* renamed from: p, reason: collision with root package name */
    public TextView f9537p;

    /* renamed from: q, reason: collision with root package name */
    public int f9538q;

    /* renamed from: r, reason: collision with root package name */
    public int f9539r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f9540s;

    public TitanVODView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f9533l = "TitanVodVideoView";
        this.f9534m = 0L;
        this.f9535n = "";
        this.f9536o = "";
        this.f9537p = null;
        this.f9538q = 11;
        this.f9539r = 14;
        this.f9540s = true;
        H();
    }

    private int getBottomMargin() {
        return getResources().getConfiguration().orientation == 2 ? d.a(getContext(), 70.0f) : d.a(getContext(), 25.0f);
    }

    @Override // com.titans.widget.TitanVideoView
    public void B(Program program, String str, String str2) {
        e.j();
        F();
        super.B(program, str, str2);
    }

    public final int E() {
        return getResources().getConfiguration().orientation == 2 ? this.f9539r : this.f9538q;
    }

    public final void F() {
        this.f9537p.setVisibility(8);
        this.f9537p.setText("");
    }

    public void G(boolean z10) {
        this.f9540s = z10;
    }

    public void H() {
        TextView I = I();
        this.f9537p = I;
        addView(I);
    }

    public final TextView I() {
        TextView textView = new TextView(getContext());
        textView.setGravity(17);
        textView.setShadowLayer(1.0f, 1.0f, 3.0f, RoundedDrawable.DEFAULT_BORDER_COLOR);
        textView.setTextColor(Color.parseColor("#FFFFFF"));
        textView.setTextSize(2, E());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 81;
        layoutParams.bottomMargin = getBottomMargin();
        textView.setLayoutParams(layoutParams);
        textView.setText("");
        return textView;
    }

    public void J(String str, String str2) {
        this.f9535n = str;
        this.f9536o = str2;
        F();
        if (t() && getTitanContext() != null && str2.equals(getTitanContext().e())) {
            e.l(str);
        }
    }

    public void K(int i10, int i11) {
        this.f9538q = i10;
        this.f9539r = i11;
        M();
    }

    public final void L() {
        if (this.f9540s && !TextUtils.isEmpty(this.f9535n) && s()) {
            e.k(this.f9537p, getCurrentProgress() + 200 + this.f9534m.longValue());
        }
    }

    public final void M() {
        TextView textView = this.f9537p;
        if (textView != null) {
            textView.setTextSize(2, E());
        }
    }

    @Override // com.titans.widget.TitanVideoView, j8.a
    public void a(int i10, String str, String str2) {
        super.a(i10, str, str2);
        if (str.equals("media")) {
            F();
        }
    }

    @Override // com.titans.widget.TitanVideoView, j8.a
    public void b(int i10, long j10, String str) {
        super.b(i10, j10, str);
        L();
    }

    public String getSubtitlePath() {
        return this.f9535n;
    }

    @Override // com.titans.widget.TitanVideoView, j8.a
    public void h(int i10, int i11, int i12, String str, String str2) {
        super.h(i10, i11, i12, str, str2);
        if (str.equals("media")) {
            e.j();
            F();
            if (this.f9535n == null || getTitanContext() == null || !this.f9536o.equals(getTitanContext().e())) {
                return;
            }
            e.l(this.f9535n);
        }
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f9537p.setTextSize(2, E());
    }

    @Override // com.titans.widget.TitanVideoView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        e.j();
        super.onDetachedFromWindow();
    }

    public void setSubtitleBg(int i10) {
        TextView textView = this.f9537p;
        if (textView != null) {
            if (i10 == 1) {
                textView.setBackgroundColor(RoundedDrawable.DEFAULT_BORDER_COLOR);
            } else {
                textView.setBackgroundColor(Color.argb(0, 0, 0, 0));
            }
        }
    }

    public void setSubtitleColor(int i10) {
        TextView textView = this.f9537p;
        if (textView != null) {
            textView.setTextColor(getContext().getResources().getColor(i10));
        }
    }

    public void setSubtitleVisible(boolean z10) {
        G(z10);
        if (!z10) {
            F();
            return;
        }
        TextView textView = this.f9537p;
        if (textView != null) {
            textView.setVisibility(0);
        }
    }

    public void setSubtitlestime(long j10) {
        this.f9534m = Long.valueOf(j10);
    }
}
