package com.hpplay.sdk.source.browser.view;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.hpplay.common.log.LeLog;
import com.hpplay.glide.Glide;
import com.mobile.brasiltv.view.RoundedDrawable;

/* loaded from: classes3.dex */
public class NetWorkView extends RelativeLayout {

    /* renamed from: a, reason: collision with root package name */
    private static final String f7529a = "NetWorkView";

    /* renamed from: b, reason: collision with root package name */
    private Context f7530b;

    /* renamed from: c, reason: collision with root package name */
    private WebView f7531c;

    /* renamed from: d, reason: collision with root package name */
    private RelativeLayout f7532d;

    /* renamed from: e, reason: collision with root package name */
    private String f7533e;

    /* renamed from: f, reason: collision with root package name */
    private com.hpplay.sdk.source.browser.d f7534f;

    /* renamed from: g, reason: collision with root package name */
    private WebViewClient f7535g;

    /* renamed from: h, reason: collision with root package name */
    private View.OnClickListener f7536h;

    public NetWorkView(Context context) {
        super(context);
        this.f7535g = new WebViewClient() { // from class: com.hpplay.sdk.source.browser.view.NetWorkView.1
            @Override // android.webkit.WebViewClient
            public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                CharSequence description;
                int errorCode;
                super.onReceivedError(webView, webResourceRequest, webResourceError);
                StringBuilder sb = new StringBuilder();
                sb.append("onReceivedError error:");
                description = webResourceError.getDescription();
                sb.append((Object) description);
                errorCode = webResourceError.getErrorCode();
                sb.append(errorCode);
                LeLog.i(NetWorkView.f7529a, sb.toString());
                NetWorkView.this.a();
            }
        };
        this.f7536h = new View.OnClickListener() { // from class: com.hpplay.sdk.source.browser.view.NetWorkView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                NetWorkView.this.e();
            }
        };
        this.f7530b = context;
        d();
    }

    private void d() {
        setBackgroundColor(-1);
        RelativeLayout relativeLayout = new RelativeLayout(this.f7530b);
        ViewGroup.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        relativeLayout.setId(com.hpplay.sdk.source.browser.b.c.a());
        addView(relativeLayout, layoutParams);
        ImageView imageView = new ImageView(this.f7530b);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(com.hpplay.sdk.source.browser.b.b.a(this.f7530b, 50.0d), com.hpplay.sdk.source.browser.b.b.a(this.f7530b, 50.0d));
        layoutParams2.setMargins(com.hpplay.sdk.source.browser.b.b.b(this.f7530b, 28.0d), com.hpplay.sdk.source.browser.b.b.b(this.f7530b, 24.0d), com.hpplay.sdk.source.browser.b.b.b(this.f7530b, 28.0d), com.hpplay.sdk.source.browser.b.b.b(this.f7530b, 24.0d));
        Glide.with(this.f7530b).load(b.f7592f).into(imageView);
        relativeLayout.addView(imageView, layoutParams2);
        imageView.setClickable(true);
        imageView.setOnClickListener(this.f7536h);
        TextView textView = new TextView(this.f7530b);
        textView.setText("投屏帮助");
        textView.setOnClickListener(this.f7536h);
        textView.setTextColor(RoundedDrawable.DEFAULT_BORDER_COLOR);
        textView.setTextSize(2, 18.0f);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(13);
        relativeLayout.addView(textView, layoutParams3);
        RelativeLayout relativeLayout2 = new RelativeLayout(this.f7530b);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams4.addRule(3, relativeLayout.getId());
        layoutParams4.addRule(13);
        addView(relativeLayout2, layoutParams4);
        this.f7531c = b();
        relativeLayout2.addView(this.f7531c, new RelativeLayout.LayoutParams(-1, -1));
        this.f7532d = c();
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams5.addRule(13);
        relativeLayout2.addView(this.f7532d, layoutParams5);
        setClickable(true);
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        requestFocusFromTouch();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        LeLog.i(f7529a, "destroyView");
        com.hpplay.sdk.source.browser.d dVar = this.f7534f;
        if (dVar != null) {
            dVar.a();
        }
    }

    private GradientDrawable getDefaultBackgroundDrawable() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(-15107585);
        gradientDrawable.setCornerRadius(30.0f);
        return gradientDrawable;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i10, KeyEvent keyEvent) {
        if (i10 != 4) {
            return super.onKeyUp(i10, keyEvent);
        }
        e();
        return true;
    }

    public void setCallback(com.hpplay.sdk.source.browser.d dVar) {
        this.f7534f = dVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        WebView webView = this.f7531c;
        if (webView != null) {
            webView.setVisibility(8);
        }
        RelativeLayout relativeLayout = this.f7532d;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(0);
        }
    }

    private WebView b() {
        try {
            com.hpplay.sdk.source.browser.b.d.a();
            WebView webView = new WebView(this.f7530b);
            this.f7531c = webView;
            WebSettings settings = webView.getSettings();
            settings.setJavaScriptCanOpenWindowsAutomatically(true);
            settings.setJavaScriptEnabled(true);
            settings.setSupportZoom(true);
            settings.setBuiltInZoomControls(true);
            settings.setUseWideViewPort(true);
            settings.setLoadWithOverviewMode(true);
            settings.setAppCacheEnabled(true);
            settings.setDomStorageEnabled(true);
            settings.setLoadsImagesAutomatically(true);
        } catch (Exception e10) {
            LeLog.w(f7529a, e10);
        }
        return this.f7531c;
    }

    private RelativeLayout c() {
        setClickable(true);
        this.f7532d = new RelativeLayout(this.f7530b);
        ImageView imageView = new ImageView(this.f7530b);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.hpplay.sdk.source.browser.b.b.a(this.f7530b, 160.0d), com.hpplay.sdk.source.browser.b.b.a(this.f7530b, 160.0d));
        layoutParams.addRule(14);
        imageView.setId(com.hpplay.sdk.source.browser.b.c.a());
        this.f7532d.addView(imageView, layoutParams);
        Glide.with(this.f7530b).load(b.f7596j).into(imageView);
        TextView textView = new TextView(this.f7530b);
        textView.setText("网络异常，请检查你的网络");
        textView.setTextColor(-14868961);
        textView.setTextSize(2, 16.0f);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(3, imageView.getId());
        layoutParams2.setMargins(0, com.hpplay.sdk.source.browser.b.b.a(this.f7530b, 24.0d), 0, com.hpplay.sdk.source.browser.b.b.a(this.f7530b, 24.0d));
        layoutParams2.addRule(14);
        textView.setId(com.hpplay.sdk.source.browser.b.c.a());
        this.f7532d.addView(textView, layoutParams2);
        TextView textView2 = new TextView(this.f7530b);
        textView2.setText("点击重试");
        textView2.setBackgroundDrawable(getDefaultBackgroundDrawable());
        textView2.setTextColor(-1);
        textView2.setTextSize(2, 16.0f);
        textView2.setPadding(com.hpplay.sdk.source.browser.b.b.a(this.f7530b, 48.0d), com.hpplay.sdk.source.browser.b.b.a(this.f7530b, 18.0d), com.hpplay.sdk.source.browser.b.b.a(this.f7530b, 48.0d), com.hpplay.sdk.source.browser.b.b.a(this.f7530b, 18.0d));
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(3, textView.getId());
        layoutParams3.addRule(14);
        this.f7532d.addView(textView2, layoutParams3);
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.hpplay.sdk.source.browser.view.NetWorkView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                NetWorkView netWorkView = NetWorkView.this;
                netWorkView.a(netWorkView.f7533e);
            }
        });
        return this.f7532d;
    }

    public NetWorkView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f7535g = new WebViewClient() { // from class: com.hpplay.sdk.source.browser.view.NetWorkView.1
            @Override // android.webkit.WebViewClient
            public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                CharSequence description;
                int errorCode;
                super.onReceivedError(webView, webResourceRequest, webResourceError);
                StringBuilder sb = new StringBuilder();
                sb.append("onReceivedError error:");
                description = webResourceError.getDescription();
                sb.append((Object) description);
                errorCode = webResourceError.getErrorCode();
                sb.append(errorCode);
                LeLog.i(NetWorkView.f7529a, sb.toString());
                NetWorkView.this.a();
            }
        };
        this.f7536h = new View.OnClickListener() { // from class: com.hpplay.sdk.source.browser.view.NetWorkView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                NetWorkView.this.e();
            }
        };
        this.f7530b = context;
        d();
    }

    public void a(String str) {
        RelativeLayout relativeLayout = this.f7532d;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(8);
        }
        WebView webView = this.f7531c;
        if (webView != null) {
            this.f7533e = str;
            webView.loadUrl(str);
            this.f7531c.setWebViewClient(this.f7535g);
            this.f7531c.setVisibility(0);
        }
    }

    public NetWorkView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f7535g = new WebViewClient() { // from class: com.hpplay.sdk.source.browser.view.NetWorkView.1
            @Override // android.webkit.WebViewClient
            public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                CharSequence description;
                int errorCode;
                super.onReceivedError(webView, webResourceRequest, webResourceError);
                StringBuilder sb = new StringBuilder();
                sb.append("onReceivedError error:");
                description = webResourceError.getDescription();
                sb.append((Object) description);
                errorCode = webResourceError.getErrorCode();
                sb.append(errorCode);
                LeLog.i(NetWorkView.f7529a, sb.toString());
                NetWorkView.this.a();
            }
        };
        this.f7536h = new View.OnClickListener() { // from class: com.hpplay.sdk.source.browser.view.NetWorkView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                NetWorkView.this.e();
            }
        };
        this.f7530b = context;
        d();
    }
}
