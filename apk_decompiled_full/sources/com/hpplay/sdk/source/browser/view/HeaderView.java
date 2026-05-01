package com.hpplay.sdk.source.browser.view;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.hpplay.common.log.LeLog;

/* loaded from: classes3.dex */
public class HeaderView extends RelativeLayout {

    /* renamed from: a, reason: collision with root package name */
    private static final String f7490a = "HeaderView";

    /* renamed from: b, reason: collision with root package name */
    private Context f7491b;

    /* renamed from: c, reason: collision with root package name */
    private LinearLayout f7492c;

    /* renamed from: d, reason: collision with root package name */
    private TextView f7493d;

    /* renamed from: e, reason: collision with root package name */
    private LoadingView f7494e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f7495f;

    public HeaderView(Context context) {
        super(context);
        this.f7495f = false;
        this.f7491b = context;
        d();
    }

    private void d() {
        setPadding(com.hpplay.sdk.source.browser.b.b.a(this.f7491b, 0.0d), com.hpplay.sdk.source.browser.b.b.a(this.f7491b, 20.0d), com.hpplay.sdk.source.browser.b.b.a(this.f7491b, 0.0d), com.hpplay.sdk.source.browser.b.b.a(this.f7491b, 24.0d));
        LinearLayout linearLayout = new LinearLayout(this.f7491b);
        this.f7492c = linearLayout;
        linearLayout.setOrientation(0);
        this.f7492c.setGravity(17);
        this.f7492c.setId(com.hpplay.sdk.source.browser.b.c.a());
        this.f7492c.setBackgroundDrawable(getDefaultBackgroundDrawable());
        addView(this.f7492c, new RelativeLayout.LayoutParams(-1, com.hpplay.sdk.source.browser.b.b.a(this.f7491b, 104.0d)));
        TextView textView = new TextView(this.f7491b);
        this.f7493d = textView;
        textView.setText("正在搜索投屏设备");
        this.f7493d.setTextColor(-1);
        this.f7493d.setTextSize(2, 14.0f);
        this.f7493d.setGravity(17);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.rightMargin = com.hpplay.sdk.source.browser.b.b.a(this.f7491b, 20.0d);
        this.f7492c.addView(this.f7493d, layoutParams);
        this.f7494e = new LoadingView(this.f7491b);
        this.f7492c.addView(this.f7494e, new LinearLayout.LayoutParams(com.hpplay.sdk.source.browser.b.b.a(this.f7491b, 56.0d), com.hpplay.sdk.source.browser.b.b.a(this.f7491b, 56.0d)));
    }

    private GradientDrawable getDefaultBackgroundDrawable() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(-14868961);
        gradientDrawable.setCornerRadius(30.0f);
        return gradientDrawable;
    }

    public void a() {
        LeLog.i(f7490a, "startBrowserAnim isAnimating:" + this.f7495f);
        if (this.f7495f) {
            return;
        }
        this.f7494e.setVisibility(0);
        this.f7494e.a();
        this.f7493d.setText("正在搜索投屏设备");
        this.f7495f = true;
    }

    public void b() {
        LeLog.i(f7490a, "stopBrowserAnim isAnimating:" + this.f7495f);
        this.f7495f = false;
        this.f7494e.setVisibility(8);
        this.f7494e.b();
        this.f7493d.setText("【搜索结束，点击右上角按钮继续搜索】");
    }

    public void c() {
        b();
    }

    public HeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f7495f = false;
        this.f7491b = context;
        d();
    }

    public HeaderView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f7495f = false;
        this.f7491b = context;
        d();
    }
}
