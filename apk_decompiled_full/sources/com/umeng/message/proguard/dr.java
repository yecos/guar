package com.umeng.message.proguard;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.hpplay.cybergarage.upnp.Icon;
import com.umeng.message.proguard.cc;
import com.umeng.message.push.R;
import java.lang.ref.WeakReference;

/* loaded from: classes3.dex */
final class dr extends Dialog {

    /* renamed from: a, reason: collision with root package name */
    final eh f12002a;

    /* renamed from: b, reason: collision with root package name */
    final ImageView f12003b;

    /* renamed from: c, reason: collision with root package name */
    final cl f12004c;

    /* renamed from: d, reason: collision with root package name */
    final LinearLayout f12005d;

    /* renamed from: e, reason: collision with root package name */
    int f12006e;

    /* renamed from: f, reason: collision with root package name */
    View.OnClickListener f12007f;

    /* renamed from: g, reason: collision with root package name */
    private Bitmap f12008g;

    /* renamed from: h, reason: collision with root package name */
    private cc.a f12009h;

    /* JADX WARN: Removed duplicated region for block: B:17:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00e6 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00e7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public dr(Context context, cl clVar) {
        super(context);
        boolean z10;
        TextView textView;
        Window window;
        boolean z11 = true;
        requestWindowFeature(1);
        eh ehVar = new eh(context);
        this.f12002a = ehVar;
        setContentView(ehVar);
        setCancelable(false);
        setCanceledOnTouchOutside(false);
        this.f12004c = clVar;
        View.inflate(context, R.layout.umeng_interstitial_layout, ehVar);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.um_interstitial_content);
        this.f12005d = linearLayout;
        ((ViewGroup) findViewById(R.id.um_interstitial_frame)).addView(clVar.a(), 0);
        ck ckVar = clVar.f11759a;
        ImageView imageView = (ImageView) findViewById(R.id.um_interstitial_mark);
        if (ckVar.f()) {
            imageView.setImageResource(R.drawable.umeng_union_mark2);
            imageView.setVisibility(0);
        } else {
            imageView.setVisibility(8);
        }
        final ImageView imageView2 = (ImageView) findViewById(R.id.um_interstitial_iv_logo);
        if (imageView2 != null) {
            imageView2.setVisibility(8);
            String optString = ckVar.f11740b.optString(Icon.ELEM_NAME);
            if (!TextUtils.isEmpty(optString)) {
                cc.a aVar = new cc.a() { // from class: com.umeng.message.proguard.dr.1
                    @Override // com.umeng.message.proguard.cc.a
                    public final void a(Bitmap bitmap) {
                        dr.this.f12008g = bitmap;
                        imageView2.post(new Runnable() { // from class: com.umeng.message.proguard.dr.1.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                try {
                                    if (dr.this.f12008g != null) {
                                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                        imageView2.setImageBitmap(dr.this.f12008g);
                                        imageView2.setVisibility(0);
                                    }
                                } catch (Throwable unused) {
                                }
                            }
                        });
                    }
                };
                this.f12009h = aVar;
                cb.b(new Runnable() { // from class: com.umeng.message.proguard.cc.1

                    /* renamed from: a */
                    final /* synthetic */ Context f11705a;

                    /* renamed from: b */
                    final /* synthetic */ String f11706b;

                    /* renamed from: c */
                    final /* synthetic */ WeakReference f11707c;

                    public AnonymousClass1(Context context2, String optString2, WeakReference weakReference) {
                        r1 = context2;
                        r2 = optString2;
                        r3 = weakReference;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        Bitmap a10 = cc.a(r1, r2);
                        if (a10 != null) {
                            a aVar2 = (a) r3.get();
                            if (aVar2 != null) {
                                aVar2.a(a10);
                            } else {
                                a10.recycle();
                            }
                        }
                    }
                });
            }
        }
        TextView textView2 = (TextView) findViewById(R.id.um_interstitial_tv_title);
        if (textView2 != null) {
            String d10 = ckVar.d();
            if (TextUtils.isEmpty(d10)) {
                textView2.setVisibility(8);
            } else {
                textView2.setVisibility(0);
                textView2.setText(d10);
                z10 = true;
                textView = (TextView) findViewById(R.id.um_interstitial_tv_content);
                if (textView != null) {
                    String e10 = ckVar.e();
                    if (!TextUtils.isEmpty(e10)) {
                        textView.setVisibility(0);
                        textView.setText(e10);
                        findViewById(R.id.um_interstitial_bottom).setVisibility(z11 ? 0 : 8);
                        this.f12003b = (ImageView) findViewById(R.id.um_interstitial_iv_close);
                        window = getWindow();
                        if (window == null) {
                            return;
                        }
                        window.setBackgroundDrawable(new ColorDrawable(0));
                        WindowManager.LayoutParams attributes = window.getAttributes();
                        attributes.width = -1;
                        attributes.height = -1;
                        attributes.alpha = 1.0f;
                        attributes.dimAmount = 0.6f;
                        window.setAttributes(attributes);
                        this.f12006e = context.getResources().getConfiguration().orientation;
                        clVar.b();
                        linearLayout.getLayoutParams().width = clVar.a().getLayoutParams().width;
                        return;
                    }
                    textView.setVisibility(8);
                }
                z11 = z10;
                findViewById(R.id.um_interstitial_bottom).setVisibility(z11 ? 0 : 8);
                this.f12003b = (ImageView) findViewById(R.id.um_interstitial_iv_close);
                window = getWindow();
                if (window == null) {
                }
            }
        }
        z10 = false;
        textView = (TextView) findViewById(R.id.um_interstitial_tv_content);
        if (textView != null) {
        }
        z11 = z10;
        findViewById(R.id.um_interstitial_bottom).setVisibility(z11 ? 0 : 8);
        this.f12003b = (ImageView) findViewById(R.id.um_interstitial_iv_close);
        window = getWindow();
        if (window == null) {
        }
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        try {
            super.dismiss();
        } catch (Throwable th) {
            ce.d("Interstitial", "dismiss error:", th.getMessage());
        }
        this.f12009h = null;
        try {
            Bitmap bitmap = this.f12008g;
            if (bitmap != null && !bitmap.isRecycled()) {
                this.f12008g.recycle();
            }
        } catch (Throwable unused) {
        }
        this.f12008g = null;
    }

    @Override // android.app.Dialog
    public final void onBackPressed() {
    }

    @Override // android.app.Dialog
    public final void show() {
        try {
            super.show();
        } catch (Throwable th) {
            ce.d("Interstitial", "show error:", th.getMessage());
        }
    }
}
