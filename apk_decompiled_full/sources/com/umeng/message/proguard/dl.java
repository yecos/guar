package com.umeng.message.proguard;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.material.badge.BadgeDrawable;
import com.umeng.message.push.R;

/* loaded from: classes3.dex */
final class dl {

    /* renamed from: a, reason: collision with root package name */
    final dk f11923a;

    /* renamed from: b, reason: collision with root package name */
    final View f11924b;

    /* renamed from: c, reason: collision with root package name */
    final ef f11925c;

    /* renamed from: d, reason: collision with root package name */
    View.OnClickListener f11926d;

    public dl(Context context, dk dkVar) {
        FrameLayout.LayoutParams layoutParams;
        this.f11923a = dkVar;
        ef efVar = new ef(context);
        this.f11925c = efVar;
        efVar.setClipChildren(false);
        efVar.setClipToPadding(false);
        efVar.setClickable(true);
        final int a10 = ed.a(8.0f);
        efVar.setBackgroundDrawable(new ShapeDrawable(new RectShape() { // from class: com.umeng.message.proguard.dl.1
            @Override // android.graphics.drawable.shapes.RectShape, android.graphics.drawable.shapes.Shape
            public final void draw(Canvas canvas, Paint paint) {
                paint.setColor(-83886081);
                RectF rect = rect();
                int i10 = a10;
                canvas.drawRoundRect(rect, i10, i10, paint);
            }
        }));
        if (Build.VERSION.SDK_INT >= 21) {
            float f10 = a10;
            efVar.setElevation(f10);
            efVar.setTranslationZ(f10);
        }
        if (dkVar.a()) {
            ImageView imageView = new ImageView(context);
            imageView.setImageDrawable(new ei(dkVar.f11921b, ed.a(8.0f)));
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setLayoutParams(new FrameLayout.LayoutParams(-2, -1));
            efVar.addView(imageView);
        } else {
            LinearLayout linearLayout = new LinearLayout(context);
            linearLayout.setOrientation(0);
            linearLayout.setPadding(ed.a(12.0f), 0, ed.a(26.0f), 0);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
            layoutParams2.gravity = 16;
            linearLayout.setLayoutParams(layoutParams2);
            efVar.addView(linearLayout);
            Bitmap bitmap = dkVar.f11921b;
            if (bitmap != null && bitmap.getWidth() > 0 && bitmap.getHeight() > 0) {
                ImageView imageView2 = new ImageView(context);
                int a11 = ed.a(48.0f);
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams((bitmap.getWidth() * a11) / bitmap.getHeight(), a11);
                layoutParams3.gravity = 16;
                layoutParams3.leftMargin = ed.a(4.0f);
                linearLayout.addView(imageView2, layoutParams3);
                imageView2.setImageDrawable(new ei(bitmap, ed.a(8.0f)));
            }
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, -2);
            layoutParams4.gravity = 16;
            if (bitmap != null) {
                layoutParams4.leftMargin = ed.a(10.0f);
            }
            LinearLayout linearLayout2 = new LinearLayout(context);
            linearLayout2.setOrientation(1);
            linearLayout.addView(linearLayout2, layoutParams4);
            TextView textView = new TextView(context);
            textView.setText(dkVar.f11920a.d());
            textView.setSingleLine();
            textView.setMaxLines(1);
            textView.setTypeface(Typeface.DEFAULT_BOLD);
            textView.setTextColor(-14341836);
            textView.setTextSize(2, 16.0f);
            textView.setEllipsize(TextUtils.TruncateAt.END);
            linearLayout2.addView(textView);
            TextView textView2 = new TextView(context);
            textView2.setText(dkVar.f11920a.e());
            textView2.setTextColor(-14341836);
            textView2.setSingleLine();
            textView2.setMaxLines(1);
            textView2.setTextSize(2, 14.0f);
            textView2.setEllipsize(TextUtils.TruncateAt.END);
            LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-1, -2);
            layoutParams5.topMargin = ed.a(4.0f);
            linearLayout2.addView(textView2, layoutParams5);
        }
        int a12 = ed.a(24.0f);
        int a13 = ed.a(10.0f);
        FrameLayout.LayoutParams layoutParams6 = new FrameLayout.LayoutParams(a12, a12);
        layoutParams6.gravity = BadgeDrawable.TOP_END;
        ImageView imageView3 = new ImageView(context);
        imageView3.setImageResource(R.drawable.umeng_union_close);
        imageView3.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView3.setLayoutParams(layoutParams6);
        int a14 = ed.a(4.0f);
        imageView3.setPadding(a14, a13, a13, a14);
        efVar.addView(imageView3);
        this.f11924b = imageView3;
        if (dkVar.f11920a.f()) {
            ImageView imageView4 = new ImageView(context);
            if (dkVar.a()) {
                layoutParams = new FrameLayout.LayoutParams(ed.a(20.0f), ed.a(10.0f));
                layoutParams.gravity = BadgeDrawable.BOTTOM_START;
                imageView4.setImageResource(R.drawable.umeng_union_mark);
            } else {
                layoutParams = new FrameLayout.LayoutParams(ed.a(24.0f), ed.a(14.0f));
                layoutParams.gravity = BadgeDrawable.BOTTOM_END;
                imageView4.setImageResource(R.drawable.umeng_union_mark3);
                imageView4.setPadding(0, 0, a14, a14);
            }
            imageView4.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView4.setLayoutParams(layoutParams);
            efVar.addView(imageView4);
        }
    }
}
