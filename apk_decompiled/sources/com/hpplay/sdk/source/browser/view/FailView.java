package com.hpplay.sdk.source.browser.view;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.hpplay.common.log.LeLog;
import com.hpplay.glide.Glide;

/* loaded from: classes3.dex */
public class FailView extends RelativeLayout {

    /* renamed from: a, reason: collision with root package name */
    private static final String f7480a = "FailView";

    /* renamed from: b, reason: collision with root package name */
    private Context f7481b;

    /* renamed from: c, reason: collision with root package name */
    private String f7482c;

    /* renamed from: d, reason: collision with root package name */
    private String f7483d;

    /* renamed from: e, reason: collision with root package name */
    private com.hpplay.sdk.source.browser.d f7484e;

    public FailView(Context context) {
        super(context);
        this.f7482c = null;
        this.f7483d = null;
        this.f7481b = context;
        a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        LeLog.i(f7480a, "destroyView");
        com.hpplay.sdk.source.browser.d dVar = this.f7484e;
        if (dVar != null) {
            dVar.a();
        }
    }

    private GradientDrawable getDefaultBackgroundDrawable() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(-14868961);
        gradientDrawable.setCornerRadius(30.0f);
        return gradientDrawable;
    }

    public void setCallback(com.hpplay.sdk.source.browser.d dVar) {
        this.f7484e = dVar;
    }

    private void a() {
        setClickable(true);
        RelativeLayout relativeLayout = new RelativeLayout(this.f7481b);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        relativeLayout.setBackgroundDrawable(getDefaultBackgroundDrawable());
        addView(relativeLayout, layoutParams);
        ImageView imageView = new ImageView(this.f7481b);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(com.hpplay.sdk.source.browser.b.b.a(this.f7481b, 160.0d), com.hpplay.sdk.source.browser.b.b.a(this.f7481b, 160.0d));
        layoutParams2.addRule(14);
        layoutParams2.setMargins(220, com.hpplay.sdk.source.browser.b.b.a(this.f7481b, 40.0d), 220, com.hpplay.sdk.source.browser.b.b.a(this.f7481b, 24.0d));
        imageView.setId(com.hpplay.sdk.source.browser.b.c.a());
        relativeLayout.addView(imageView, layoutParams2);
        Glide.with(imageView.getContext()).load(b.f7590d).into(imageView);
        TextView textView = new TextView(this.f7481b);
        if (TextUtils.isEmpty(this.f7482c)) {
            textView.setText("服务器异常");
        } else {
            textView.setText(this.f7482c);
        }
        textView.setTextColor(-2433050);
        textView.setTextSize(2, 18.0f);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(3, imageView.getId());
        layoutParams3.addRule(14);
        textView.setId(com.hpplay.sdk.source.browser.b.c.a());
        relativeLayout.addView(textView, layoutParams3);
        TextView textView2 = new TextView(this.f7481b);
        if (TextUtils.isEmpty(this.f7483d)) {
            textView2.setText("未知错误\n请重启大屏和手机App后重试");
        } else {
            textView2.setText(this.f7483d);
        }
        textView2.setTextColor(-6972250);
        textView2.setTextSize(2, 14.0f);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams4.addRule(3, textView.getId());
        layoutParams4.setMargins(0, com.hpplay.sdk.source.browser.b.b.a(this.f7481b, 20.0d), 0, com.hpplay.sdk.source.browser.b.b.a(this.f7481b, 63.0d));
        textView2.setId(com.hpplay.sdk.source.browser.b.c.a());
        layoutParams4.addRule(14);
        textView2.setTextAlignment(4);
        relativeLayout.addView(textView2, layoutParams4);
        TextView textView3 = new TextView(this.f7481b);
        textView3.setText("知道了");
        textView3.setOnClickListener(new View.OnClickListener() { // from class: com.hpplay.sdk.source.browser.view.FailView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FailView.this.b();
            }
        });
        textView3.setTextColor(-13395457);
        textView3.setTextSize(2, 16.0f);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams5.addRule(3, textView2.getId());
        layoutParams5.addRule(14);
        layoutParams5.setMargins(0, com.hpplay.sdk.source.browser.b.b.a(this.f7481b, 63.0d), 0, com.hpplay.sdk.source.browser.b.b.a(this.f7481b, 22.0d));
        relativeLayout.addView(textView3, layoutParams5);
    }

    public FailView(Context context, String str, String str2) {
        super(context);
        this.f7482c = null;
        this.f7483d = null;
        LeLog.i(f7480a, "FailView title:" + str + ", extra:" + str2);
        this.f7481b = context;
        this.f7482c = str;
        this.f7483d = str2;
        a();
    }

    public FailView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f7482c = null;
        this.f7483d = null;
        this.f7481b = context;
        a();
    }

    public FailView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f7482c = null;
        this.f7483d = null;
        this.f7481b = context;
        a();
    }
}
