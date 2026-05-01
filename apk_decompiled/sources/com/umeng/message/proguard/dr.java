package com.umeng.message.proguard;

import android.app.Dialog;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.umeng.message.proguard.cc;

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
        To view partially-correct add '--show-bad-code' argument
    */
    public dr(android.content.Context r10, com.umeng.message.proguard.cl r11) {
        /*
            Method dump skipped, instructions count: 292
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.message.proguard.dr.<init>(android.content.Context, com.umeng.message.proguard.cl):void");
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
