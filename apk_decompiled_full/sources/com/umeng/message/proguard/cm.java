package com.umeng.message.proguard;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.umeng.message.proguard.bx;

/* loaded from: classes3.dex */
public final class cm extends cn {

    /* renamed from: c, reason: collision with root package name */
    private ImageView f11761c;

    /* renamed from: d, reason: collision with root package name */
    private Bitmap f11762d;

    public cm(Context context, cl clVar) {
        super(context, clVar);
    }

    @Override // com.umeng.message.proguard.cn
    public final void a(Bitmap bitmap) {
        this.f11762d = bitmap;
    }

    @Override // com.umeng.message.proguard.cn
    public final void b() {
        ImageView imageView = new ImageView(this.f11763a);
        this.f11761c = imageView;
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        this.f11761c.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    }

    @Override // com.umeng.message.proguard.cn
    public final void c() {
        int i10;
        int i11;
        ImageView imageView = this.f11761c;
        if (imageView == null) {
            return;
        }
        imageView.setImageBitmap(this.f11762d);
        if (bt.a(this.f11764b.f11759a) != bx.c.INTERSTITIAL || this.f11762d.getHeight() == 0) {
            return;
        }
        DisplayMetrics displayMetrics = this.f11763a.getResources().getDisplayMetrics();
        boolean z10 = displayMetrics.widthPixels < displayMetrics.heightPixels;
        float width = (this.f11762d.getWidth() * 1.0f) / this.f11762d.getHeight();
        int a10 = ed.a(72.0f);
        int a11 = ed.a(144.0f);
        if (z10) {
            i10 = displayMetrics.widthPixels - a10;
            i11 = (int) (i10 / width);
            int i12 = displayMetrics.heightPixels;
            if (i11 > i12 - a11) {
                i11 = i12 - a11;
                i10 = (int) (i11 * width);
            }
        } else {
            i10 = displayMetrics.heightPixels - a11;
            int i13 = (int) (i10 * width);
            int i14 = displayMetrics.widthPixels;
            if (i13 > i14 - a10) {
                int i15 = i14 - a10;
                i11 = i10;
                i10 = i15;
            } else {
                i11 = i10;
                if (i10 < i13) {
                    i10 = i13;
                }
            }
        }
        ViewGroup.LayoutParams layoutParams = this.f11761c.getLayoutParams();
        layoutParams.width = i10;
        layoutParams.height = i11;
        this.f11761c.setLayoutParams(layoutParams);
    }

    @Override // com.umeng.message.proguard.cn
    public final void d() {
        try {
            Bitmap bitmap = this.f11762d;
            if (bitmap == null || bitmap.isRecycled()) {
                return;
            }
            this.f11762d.recycle();
        } catch (Throwable unused) {
        }
    }

    @Override // com.umeng.message.proguard.cn
    public final View a() {
        return this.f11761c;
    }
}
