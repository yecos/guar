package com.mobile.brasiltv.activity;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.view.View;
import android.view.WindowManager;
import android.webkit.DownloadListener;
import android.webkit.JsPromptResult;
import android.webkit.SslErrorHandler;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import ba.s;
import ba.t;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.activity.WebViewAty;
import com.mobile.brasiltv.bean.event.CreateOrderEvent;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.view.Controller;
import com.mobile.brasiltv.view.LoadingDialog;
import com.mobile.brasiltv.view.webview.CommonParams;
import com.mobile.brasiltv.view.webview.ExtraJson;
import com.mobile.brasiltv.view.webview.LollipopFixedWebView;
import com.msandroid.mobile.R;
import com.taobao.accs.common.Constants;
import com.zhy.autolayout.AutoRelativeLayout;
import i6.d1;
import i6.e1;
import java.util.LinkedHashMap;
import java.util.Map;
import k6.q4;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: classes.dex */
public final class WebViewAty extends f5.d implements e1 {
    public static final a B = new a(null);
    public static final String C = "bundleUrl";
    public static final String D = "show_back";
    public static final String E = "backToMain";
    public static final String F = "header";
    public static final String G = "extra_json";
    public static final String H = "follow_sersor";
    public static final String I = "bundle_enter_browser";
    public static final String J = "bundle_share_invitation_code";
    public static final String K = "bundle_dont_care_invite_code";
    public static final String L = "bundle_repay_payment_type";
    public static final String M = "bundle_not_override_url";

    /* renamed from: m, reason: collision with root package name */
    public ValueCallback f8237m;

    /* renamed from: n, reason: collision with root package name */
    public ValueCallback f8238n;

    /* renamed from: x, reason: collision with root package name */
    public boolean f8248x;

    /* renamed from: z, reason: collision with root package name */
    public q4 f8250z;
    public Map A = new LinkedHashMap();

    /* renamed from: l, reason: collision with root package name */
    public final String f8236l = "image/*";

    /* renamed from: o, reason: collision with root package name */
    public final int f8239o = 1;

    /* renamed from: p, reason: collision with root package name */
    public final h9.g f8240p = h9.h.b(new l());

    /* renamed from: q, reason: collision with root package name */
    public final h9.g f8241q = h9.h.b(new f());

    /* renamed from: r, reason: collision with root package name */
    public final h9.g f8242r = h9.h.b(new b());

    /* renamed from: s, reason: collision with root package name */
    public final h9.g f8243s = h9.h.b(new d());

    /* renamed from: t, reason: collision with root package name */
    public final h9.g f8244t = h9.h.b(new e());

    /* renamed from: u, reason: collision with root package name */
    public final h9.g f8245u = h9.h.b(new i());

    /* renamed from: v, reason: collision with root package name */
    public final h9.g f8246v = h9.h.b(new h());

    /* renamed from: w, reason: collision with root package name */
    public final h9.g f8247w = h9.h.b(new g());

    /* renamed from: y, reason: collision with root package name */
    public String f8249y = "";

    /* loaded from: classes3.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(t9.g gVar) {
            this();
        }

        public final String a() {
            return WebViewAty.E;
        }

        public final String b() {
            return WebViewAty.I;
        }

        public final String c() {
            return WebViewAty.G;
        }

        public final String d() {
            return WebViewAty.H;
        }

        public final String e() {
            return WebViewAty.F;
        }

        public final String f() {
            return WebViewAty.M;
        }

        public final String g() {
            return WebViewAty.L;
        }

        public final String h() {
            return WebViewAty.J;
        }

        public final String i() {
            return WebViewAty.D;
        }

        public final String j() {
            return WebViewAty.C;
        }

        public final boolean k(Context context, String str) {
            t9.i.g(context, com.umeng.analytics.pro.f.X);
            t9.i.g(str, "url");
            if (!t.o(str, "urlOpen=out", false, 2, null) && !t.o(str, ".page.link", false, 2, null)) {
                return false;
            }
            b0.f0(context, str);
            return true;
        }
    }

    /* loaded from: classes3.dex */
    public static final class b extends t9.j implements s9.a {
        public b() {
            super(0);
        }

        @Override // s9.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke() {
            return Boolean.valueOf(WebViewAty.this.getIntent().getBooleanExtra(WebViewAty.B.a(), true));
        }
    }

    /* loaded from: classes3.dex */
    public static final class c extends t9.j implements s9.l {
        public c() {
            super(1);
        }

        @Override // s9.l
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Intent invoke(Intent intent) {
            t9.i.g(intent, "it");
            Intent putExtra = intent.putExtra(OrderConfirmAty.f7966m.a(), WebViewAty.this.f8249y);
            t9.i.f(putExtra, "it.putExtra(OrderConfirm…YMENT_TYPE, mPaymentType)");
            return putExtra;
        }
    }

    /* loaded from: classes3.dex */
    public static final class d extends t9.j implements s9.a {
        public d() {
            super(0);
        }

        @Override // s9.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke() {
            return Boolean.valueOf(WebViewAty.this.getIntent().getBooleanExtra(WebViewAty.B.e(), true));
        }
    }

    /* loaded from: classes3.dex */
    public static final class e extends t9.j implements s9.a {
        public e() {
            super(0);
        }

        @Override // s9.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke() {
            return Boolean.valueOf(WebViewAty.this.getIntent().getBooleanExtra(WebViewAty.B.b(), false));
        }
    }

    /* loaded from: classes3.dex */
    public static final class f extends t9.j implements s9.a {
        public f() {
            super(0);
        }

        @Override // s9.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke() {
            return Boolean.valueOf(WebViewAty.this.getIntent().getBooleanExtra(WebViewAty.B.i(), false));
        }
    }

    /* loaded from: classes3.dex */
    public static final class g extends t9.j implements s9.a {
        public g() {
            super(0);
        }

        @Override // s9.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke() {
            return Boolean.valueOf(WebViewAty.this.getIntent().getBooleanExtra(WebViewAty.B.f(), false));
        }
    }

    /* loaded from: classes3.dex */
    public static final class h extends t9.j implements s9.a {
        public h() {
            super(0);
        }

        @Override // s9.a
        public final String invoke() {
            return WebViewAty.this.getIntent().getStringExtra(WebViewAty.B.g());
        }
    }

    /* loaded from: classes3.dex */
    public static final class i extends t9.j implements s9.a {
        public i() {
            super(0);
        }

        @Override // s9.a
        public final String invoke() {
            return WebViewAty.this.getIntent().getStringExtra(WebViewAty.B.h());
        }
    }

    /* loaded from: classes3.dex */
    public static final class j extends WebViewClient {

        /* renamed from: a, reason: collision with root package name */
        public boolean f8259a = true;

        public j() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:25:0x0077, code lost:
        
            if (ba.t.o(r4, r2, false, 2, null) == true) goto L33;
         */
        @Override // android.webkit.WebViewClient
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void onPageFinished(android.webkit.WebView r7, java.lang.String r8) {
            /*
                r6 = this;
                java.lang.StringBuilder r8 = new java.lang.StringBuilder
                r8.<init>()
                java.lang.String r0 = "onPageFinished progress: "
                r8.append(r0)
                r0 = 0
                if (r7 == 0) goto L16
                int r1 = r7.getProgress()
                java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
                goto L17
            L16:
                r1 = r0
            L17:
                r8.append(r1)
                java.lang.String r1 = ", title: "
                r8.append(r1)
                if (r7 == 0) goto L26
                java.lang.String r1 = r7.getTitle()
                goto L27
            L26:
                r1 = r0
            L27:
                r8.append(r1)
                java.lang.String r8 = r8.toString()
                com.mobile.brasiltv.utils.b0.U(r6, r8)
                r8 = 1
                r1 = 0
                if (r7 == 0) goto L3f
                int r2 = r7.getProgress()
                r3 = 100
                if (r2 != r3) goto L3f
                r2 = 1
                goto L40
            L3f:
                r2 = 0
            L40:
                if (r2 == 0) goto L5d
                com.mobile.brasiltv.activity.WebViewAty r2 = com.mobile.brasiltv.activity.WebViewAty.this
                int r3 = com.mobile.brasiltv.R$id.atyWebView
                android.view.View r2 = r2.Y2(r3)
                com.mobile.brasiltv.view.webview.LollipopFixedWebView r2 = (com.mobile.brasiltv.view.webview.LollipopFixedWebView) r2
                if (r2 != 0) goto L4f
                goto L52
            L4f:
                r2.setVisibility(r1)
            L52:
                boolean r2 = r6.f8259a
                if (r2 == 0) goto L5d
                r6.f8259a = r1
                com.mobile.brasiltv.activity.WebViewAty r2 = com.mobile.brasiltv.activity.WebViewAty.this
                com.mobile.brasiltv.activity.WebViewAty.Z2(r2, r7)
            L5d:
                if (r7 == 0) goto L9f
                java.lang.String r2 = r7.getTitle()
                if (r2 == 0) goto L9f
                com.mobile.brasiltv.activity.WebViewAty r3 = com.mobile.brasiltv.activity.WebViewAty.this
                java.lang.String r4 = r7.getUrl()
                if (r4 == 0) goto L7a
                java.lang.String r5 = "url"
                t9.i.f(r4, r5)
                r5 = 2
                boolean r0 = ba.t.o(r4, r2, r1, r5, r0)
                if (r0 != r8) goto L7a
                goto L7b
            L7a:
                r8 = 0
            L7b:
                if (r8 == 0) goto L8b
                int r7 = com.mobile.brasiltv.R$id.atyWebViewTitle
                android.view.View r7 = r3.Y2(r7)
                android.widget.TextView r7 = (android.widget.TextView) r7
                java.lang.String r8 = " "
                r7.setText(r8)
                goto L9f
            L8b:
                int r8 = com.mobile.brasiltv.R$id.atyWebViewTitle
                android.view.View r8 = r3.Y2(r8)
                android.widget.TextView r8 = (android.widget.TextView) r8
                java.lang.String r7 = r7.getTitle()
                if (r7 == 0) goto L9a
                goto L9c
            L9a:
                java.lang.String r7 = ""
            L9c:
                r8.setText(r7)
            L9f:
                com.mobile.brasiltv.view.LoadingDialog$Companion r7 = com.mobile.brasiltv.view.LoadingDialog.Companion
                r7.hidden()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mobile.brasiltv.activity.WebViewAty.j.onPageFinished(android.webkit.WebView, java.lang.String):void");
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            try {
                LoadingDialog.Companion.show(WebViewAty.this.getFragmentManager());
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:3:0x000d, code lost:
        
            r2 = r15.getUrl();
         */
        /* JADX WARN: Code restructure failed: missing block: B:9:0x001f, code lost:
        
            r2 = r15.getUrl();
         */
        @Override // android.webkit.WebViewClient
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void onReceivedHttpError(android.webkit.WebView r14, android.webkit.WebResourceRequest r15, android.webkit.WebResourceResponse r16) {
            /*
                r13 = this;
                super.onReceivedHttpError(r14, r15, r16)
                long r3 = android.os.SystemClock.elapsedRealtime()
                c2.d r0 = c2.d.f5311a
                java.lang.String r1 = ""
                if (r15 == 0) goto L1c
                android.net.Uri r2 = f5.h6.a(r15)
                if (r2 == 0) goto L1c
                java.lang.String r2 = r2.getPath()
                if (r2 != 0) goto L1a
                goto L1c
            L1a:
                r5 = r2
                goto L1d
            L1c:
                r5 = r1
            L1d:
                if (r15 == 0) goto L2d
                android.net.Uri r2 = f5.h6.a(r15)
                if (r2 == 0) goto L2d
                java.lang.String r2 = r2.getHost()
                if (r2 != 0) goto L2c
                goto L2d
            L2c:
                r1 = r2
            L2d:
                java.lang.String r2 = a3.d.f161a
                java.lang.String r6 = a3.d.a(r1, r2)
                java.lang.String r1 = "encryption(request?.url?…\"\", DESUtils.MAC_DES_KEY)"
                t9.i.f(r6, r1)
                if (r16 == 0) goto L40
                int r1 = f5.i6.a(r16)
                r7 = r1
                goto L42
            L40:
                r1 = -1
                r7 = -1
            L42:
                java.lang.String r8 = na.e.f17345e
                r9 = 0
                r10 = 1
                r11 = 64
                r12 = 0
                r1 = r3
                c2.d.e(r0, r1, r3, r5, r6, r7, r8, r9, r10, r11, r12)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mobile.brasiltv.activity.WebViewAty.j.onReceivedHttpError(android.webkit.WebView, android.webkit.WebResourceRequest, android.webkit.WebResourceResponse):void");
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            super.onReceivedSslError(webView, sslErrorHandler, sslError);
            if (sslErrorHandler != null) {
                sslErrorHandler.proceed();
            }
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (WebViewAty.this.A3()) {
                return true;
            }
            if (str != null && s.l(str, "tel:", false, 2, null)) {
                Intent intent = new Intent("android.intent.action.DIAL", Uri.parse(str));
                intent.setFlags(268435456);
                WebViewAty.this.startActivity(intent);
                return false;
            }
            if (str != null && s.l(str, "mailto:", false, 2, null)) {
                Intent intent2 = new Intent("android.intent.action.SENDTO");
                intent2.setData(Uri.parse(str));
                WebViewAty.this.startActivity(intent2);
                return false;
            }
            if (str != null && t.o(str, "alipays://platformapi", false, 2, null)) {
                return false;
            }
            if (str != null && webView != null) {
                webView.loadUrl(str);
            }
            b0.U(this, "should override url loading and url: " + str);
            return true;
        }
    }

    /* loaded from: classes3.dex */
    public static final class k extends WebChromeClient {
        public k() {
        }

        @Override // android.webkit.WebChromeClient
        public Bitmap getDefaultVideoPoster() {
            Bitmap defaultVideoPoster = super.getDefaultVideoPoster();
            return defaultVideoPoster == null ? BitmapFactory.decodeResource(WebViewAty.this.Q1().getResources(), R.mipmap.ic_logo) : defaultVideoPoster;
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
            t9.i.g(webView, "view");
            t9.i.g(str, "url");
            t9.i.g(str2, Constants.SHARED_MESSAGE_ID_FILE);
            t9.i.g(str3, "defaultValue");
            t9.i.g(jsPromptResult, "result");
            b0.U(this, "onJsPrompt:" + str2);
            jsPromptResult.confirm();
            return super.onJsPrompt(webView, str, str2, str2, jsPromptResult);
        }

        /* JADX WARN: Code restructure failed: missing block: B:16:0x0053, code lost:
        
            if (r3 == false) goto L27;
         */
        @Override // android.webkit.WebChromeClient
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void onReceivedTitle(android.webkit.WebView r7, java.lang.String r8) {
            /*
                r6 = this;
                super.onReceivedTitle(r7, r8)
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "onReceivedTitle title: "
                r0.append(r1)
                r1 = 0
                if (r7 == 0) goto L15
                java.lang.String r2 = r7.getTitle()
                goto L16
            L15:
                r2 = r1
            L16:
                r0.append(r2)
                java.lang.String r0 = r0.toString()
                com.mobile.brasiltv.utils.b0.U(r6, r0)
                if (r8 == 0) goto L76
                com.mobile.brasiltv.activity.WebViewAty r0 = com.mobile.brasiltv.activity.WebViewAty.this
                java.lang.String r2 = "koocan.com"
                r3 = 0
                r4 = 2
                boolean r8 = ba.t.o(r8, r2, r3, r4, r1)
                java.lang.String r2 = " "
                if (r8 != 0) goto L6b
                if (r7 == 0) goto L37
                java.lang.String r8 = r7.getTitle()
                goto L38
            L37:
                r8 = r1
            L38:
                if (r8 == 0) goto L56
                java.lang.String r8 = r7.getUrl()
                if (r8 == 0) goto L53
                java.lang.String r5 = "url"
                t9.i.f(r8, r5)
                java.lang.String r5 = r7.getTitle()
                t9.i.d(r5)
                boolean r8 = ba.t.o(r8, r5, r3, r4, r1)
                if (r8 != 0) goto L53
                r3 = 1
            L53:
                if (r3 != 0) goto L56
                goto L6b
            L56:
                int r8 = com.mobile.brasiltv.R$id.atyWebViewTitle
                android.view.View r8 = r0.Y2(r8)
                android.widget.TextView r8 = (android.widget.TextView) r8
                if (r7 == 0) goto L67
                java.lang.String r7 = r7.getTitle()
                if (r7 == 0) goto L67
                r2 = r7
            L67:
                r8.setText(r2)
                goto L76
            L6b:
                int r7 = com.mobile.brasiltv.R$id.atyWebViewTitle
                android.view.View r7 = r0.Y2(r7)
                android.widget.TextView r7 = (android.widget.TextView) r7
                r7.setText(r2)
            L76:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mobile.brasiltv.activity.WebViewAty.k.onReceivedTitle(android.webkit.WebView, java.lang.String):void");
        }

        @Override // android.webkit.WebChromeClient
        public boolean onShowFileChooser(WebView webView, ValueCallback valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
            t9.i.g(webView, "webView");
            t9.i.g(fileChooserParams, "fileChooserParams");
            b0.U(this, "onShowFileChooser(ValueCallback<Uri> uploadMsg, String acceptType, String capture)");
            WebViewAty.this.f8238n = valueCallback;
            Intent intent = new Intent("android.intent.action.GET_CONTENT");
            intent.addCategory("android.intent.category.OPENABLE");
            intent.setType(WebViewAty.this.f8236l);
            WebViewAty.this.startActivityForResult(Intent.createChooser(intent, "File Browser"), WebViewAty.this.f8239o);
            return true;
        }
    }

    /* loaded from: classes3.dex */
    public static final class l extends t9.j implements s9.a {
        public l() {
            super(0);
        }

        @Override // s9.a
        public final String invoke() {
            String stringExtra = WebViewAty.this.getIntent().getStringExtra(WebViewAty.B.j());
            return stringExtra == null ? "" : stringExtra;
        }
    }

    public static final void J3(WebViewAty webViewAty, String str, String str2, String str3, String str4, long j10) {
        t9.i.g(webViewAty, "this$0");
        b0.U(webViewAty, "DownloadListener: " + str);
        t9.i.f(str, "url");
        webViewAty.t3(str);
    }

    public static final void q3(WebViewAty webViewAty, View view) {
        t9.i.g(webViewAty, "this$0");
        webViewAty.onBackPressed();
    }

    public static final void r3(View view) {
    }

    public static final void s3(WebViewAty webViewAty, View view) {
        t9.i.g(webViewAty, "this$0");
        webViewAty.w3();
    }

    public final boolean A3() {
        return ((Boolean) this.f8247w.getValue()).booleanValue();
    }

    public final String B3() {
        return (String) this.f8246v.getValue();
    }

    public final String C3() {
        return (String) this.f8245u.getValue();
    }

    public final String D3() {
        return (String) this.f8240p.getValue();
    }

    public final boolean E3() {
        return ((Boolean) this.f8244t.getValue()).booleanValue();
    }

    public final void F3(int i10, int i11, Intent intent) {
        Uri[] uriArr;
        if (i10 != this.f8239o || this.f8238n == null) {
            return;
        }
        if (i11 != -1 || intent == null) {
            uriArr = null;
        } else {
            String dataString = intent.getDataString();
            ClipData clipData = intent.getClipData();
            if (clipData != null) {
                uriArr = new Uri[clipData.getItemCount()];
                int itemCount = clipData.getItemCount();
                for (int i12 = 0; i12 < itemCount; i12++) {
                    uriArr[i12] = clipData.getItemAt(i12).getUri();
                }
            } else {
                uriArr = null;
            }
            if (dataString != null) {
                uriArr = new Uri[]{Uri.parse(dataString)};
            }
        }
        ValueCallback valueCallback = this.f8238n;
        if (valueCallback != null) {
            valueCallback.onReceiveValue(uriArr);
        }
        this.f8238n = null;
    }

    public void G3(q4 q4Var) {
        t9.i.g(q4Var, "<set-?>");
        this.f8250z = q4Var;
    }

    @Override // m5.a
    /* renamed from: H3, reason: merged with bridge method [inline-methods] */
    public void Y0(d1 d1Var) {
        t9.i.g(d1Var, "presenter");
    }

    public final void I3(String str) {
        t9.i.g(str, "url");
        b0.U(this, "h5 url: " + str);
        p3();
        int i10 = R$id.atyWebView;
        WebSettings settings = ((LollipopFixedWebView) Y2(i10)).getSettings();
        t9.i.f(settings, "atyWebView.settings");
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setJavaScriptEnabled(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        if (Build.VERSION.SDK_INT >= 21) {
            settings.setMixedContentMode(0);
        }
        settings.setSupportZoom(true);
        settings.setDomStorageEnabled(true);
        if (A3()) {
            settings.setBuiltInZoomControls(true);
        }
        ((LollipopFixedWebView) Y2(i10)).addJavascriptInterface(new Controller(this), "Controller");
        LollipopFixedWebView lollipopFixedWebView = (LollipopFixedWebView) Y2(i10);
        boolean E3 = E3();
        String C3 = C3();
        if (C3 == null) {
            C3 = "";
        }
        lollipopFixedWebView.addJavascriptInterface(new CommonParams(E3, C3), "xxl_pub");
        ((LollipopFixedWebView) Y2(i10)).addJavascriptInterface(new ExtraJson(getIntent().getStringExtra(G)), "xxl_extra");
        ((LollipopFixedWebView) Y2(i10)).setVerticalScrollBarEnabled(true);
        ((LollipopFixedWebView) Y2(i10)).setHorizontalScrollBarEnabled(true);
        ((LollipopFixedWebView) Y2(i10)).setWebViewClient(new j());
        ((LollipopFixedWebView) Y2(i10)).setWebChromeClient(new k());
        ((LollipopFixedWebView) Y2(i10)).setDownloadListener(new DownloadListener() { // from class: f5.g6
            @Override // android.webkit.DownloadListener
            public final void onDownloadStart(String str2, String str3, String str4, String str5, long j10) {
                WebViewAty.J3(WebViewAty.this, str2, str3, str4, str5, j10);
            }
        });
        ((LollipopFixedWebView) Y2(i10)).loadUrl(str);
    }

    public final void K3() {
        Intent intent = new Intent(this, (Class<?>) MainAty.class);
        intent.putExtra(K, true);
        startActivity(intent);
        finish();
    }

    @Override // f5.d
    public void R2() {
        G3(new q4(this, this));
        String B3 = B3();
        if (!(B3 == null || B3.length() == 0)) {
            this.f8248x = true;
            String B32 = B3();
            t9.i.d(B32);
            this.f8249y = B32;
        }
        int i10 = R$id.atyBack;
        ((ImageView) Y2(i10)).setVisibility(0);
        ((ImageView) Y2(i10)).setOnClickListener(new View.OnClickListener() { // from class: f5.d6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WebViewAty.q3(WebViewAty.this, view);
            }
        });
        ((ImageView) Y2(R$id.shareIcon)).setOnClickListener(new View.OnClickListener() { // from class: f5.e6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WebViewAty.r3(view);
            }
        });
        ((ImageView) Y2(R$id.atyExit)).setOnClickListener(new View.OnClickListener() { // from class: f5.f6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WebViewAty.s3(WebViewAty.this, view);
            }
        });
        if (!y3()) {
            ((AutoRelativeLayout) Y2(R$id.atyWebViewHeader)).setVisibility(8);
        }
        if (getIntent().getBooleanExtra(H, false)) {
            setRequestedOrientation(10);
        }
        String D3 = D3();
        t9.i.f(D3, "url");
        I3(D3);
    }

    @Override // f5.d
    public int T2() {
        return R.layout.aty_webview;
    }

    public View Y2(int i10) {
        Map map = this.A;
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

    @Override // androidx.fragment.app.e, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        if (i10 == this.f8239o) {
            if (this.f8237m == null && this.f8238n == null) {
                return;
            }
            Uri data = (intent == null || i11 != -1) ? null : intent.getData();
            if (this.f8238n != null) {
                F3(i10, i11, intent);
                return;
            }
            ValueCallback valueCallback = this.f8237m;
            if (valueCallback != null) {
                if (valueCallback != null) {
                    valueCallback.onReceiveValue(data);
                }
                this.f8237m = null;
            }
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.f8248x) {
            u3();
            return;
        }
        int i10 = R$id.atyWebView;
        if (((LollipopFixedWebView) Y2(i10)).canGoBack() && !t9.i.b(((LollipopFixedWebView) Y2(i10)).getUrl(), D3())) {
            ((LollipopFixedWebView) Y2(i10)).goBack();
            b0.U(this, "webView.goBack()");
            return;
        }
        b0.U(this, "exit()");
        if (x3()) {
            K3();
        } else {
            setResult(10010, getIntent());
            finish();
        }
    }

    @Override // androidx.appcompat.app.d, androidx.fragment.app.e, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        t9.i.g(configuration, "newConfig");
        super.onConfigurationChanged(configuration);
        if (configuration.orientation != 1) {
            WindowManager.LayoutParams attributes = getWindow().getAttributes();
            attributes.flags |= 1024;
            getWindow().setAttributes(attributes);
        } else {
            getWindow().addFlags(1024);
            WindowManager.LayoutParams attributes2 = getWindow().getAttributes();
            attributes2.flags &= -1025;
            getWindow().setAttributes(attributes2);
            getWindow().clearFlags(1024);
        }
    }

    @xa.j(threadMode = ThreadMode.MAIN)
    public final void onEventCreateOrder(CreateOrderEvent createOrderEvent) {
        t9.i.g(createOrderEvent, "event");
        this.f8249y = createOrderEvent.getPaymentType();
        this.f8248x = true;
    }

    @Override // f5.c, u8.a, androidx.fragment.app.e, android.app.Activity
    public void onPause() {
        ((LollipopFixedWebView) Y2(R$id.atyWebView)).onPause();
        super.onPause();
        LoadingDialog.Companion.hidden();
    }

    @Override // f5.c, u8.a, androidx.fragment.app.e, android.app.Activity
    public void onResume() {
        super.onResume();
        ((LollipopFixedWebView) Y2(R$id.atyWebView)).onResume();
    }

    public final void p3() {
        String a10 = com.mobile.brasiltv.utils.e.a(this);
        Object b10 = n7.a.b(this, "clear_webview_cache_version", "");
        t9.i.e(b10, "null cannot be cast to non-null type kotlin.String");
        if (t9.i.b((String) b10, a10)) {
            return;
        }
        b0.U(this, "清除缓存");
        ((LollipopFixedWebView) Y2(R$id.atyWebView)).clearCache(true);
        n7.a.e(this, "clear_webview_cache_version", a10);
    }

    public final void t3(String str) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addCategory("android.intent.category.BROWSABLE");
        intent.setData(Uri.parse(str));
        if (getPackageManager().resolveActivity(intent, 0) != null) {
            startActivity(intent);
        }
    }

    public final void u3() {
        b0.d0(this, OrderConfirmAty.class, new c());
        this.f8248x = false;
        this.f8249y = "";
        finish();
    }

    public final void v3(View view) {
        ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f)).setDuration(250L).start();
    }

    public final void w3() {
        b0.U(this, "exit()");
        if (this.f8248x) {
            u3();
        } else if (x3()) {
            K3();
        } else {
            setResult(10010, getIntent());
            finish();
        }
    }

    public final boolean x3() {
        return ((Boolean) this.f8242r.getValue()).booleanValue();
    }

    public final boolean y3() {
        return ((Boolean) this.f8243s.getValue()).booleanValue();
    }

    @Override // f5.d
    /* renamed from: z3, reason: merged with bridge method [inline-methods] */
    public q4 S2() {
        q4 q4Var = this.f8250z;
        if (q4Var != null) {
            return q4Var;
        }
        t9.i.w("mPresenter");
        return null;
    }
}
