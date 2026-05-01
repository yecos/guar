package com.hpplay.sdk.source.browser.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

/* loaded from: classes3.dex */
public class FooterView extends LinearLayout {

    /* renamed from: a, reason: collision with root package name */
    private static final String f7486a = "FooterView";

    /* renamed from: b, reason: collision with root package name */
    private Context f7487b;

    /* renamed from: c, reason: collision with root package name */
    private com.hpplay.sdk.source.browser.b f7488c;

    public FooterView(Context context) {
        super(context);
        this.f7487b = context;
        a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        this.f7488c.a(com.hpplay.sdk.source.browser.b.a.f7463d);
    }

    public void setCallback(com.hpplay.sdk.source.browser.b bVar) {
        this.f7488c = bVar;
    }

    private void a() {
        int i10;
        setOrientation(1);
        boolean z10 = this.f7487b.getResources().getConfiguration().orientation == 2;
        LinearLayout linearLayout = new LinearLayout(this.f7487b);
        linearLayout.setGravity(1);
        if (z10) {
            double d10 = com.hpplay.sdk.source.browser.b.b.f7465b;
            Double.isNaN(d10);
            i10 = (int) (d10 * 0.6d);
        } else {
            i10 = -1;
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i10, -2);
        linearLayout.setOrientation(0);
        layoutParams.topMargin = com.hpplay.sdk.source.browser.b.b.a(this.f7487b, 35.0d);
        addView(linearLayout, layoutParams);
        TextView textView = new TextView(this.f7487b);
        textView.setText("未搜索到想要的设备？点击 ");
        textView.setTextColor(-1);
        textView.setTextSize(2, 12.0f);
        linearLayout.addView(textView, new LinearLayout.LayoutParams(-2, -2));
        TextView textView2 = new TextView(this.f7487b);
        textView2.setText("查看详情 >");
        textView2.setTextColor(-13395457);
        textView2.setTextSize(2, 12.0f);
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.hpplay.sdk.source.browser.view.FooterView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FooterView.this.b();
            }
        });
        linearLayout.addView(textView2, new LinearLayout.LayoutParams(-2, -2));
        addView(new View(this.f7487b), new LinearLayout.LayoutParams(-1, -2));
    }

    public FooterView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f7487b = context;
        a();
    }

    public FooterView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f7487b = context;
        a();
    }
}
