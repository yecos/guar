package com.umeng.message.proguard;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.hpplay.sdk.source.common.global.Constant;
import java.lang.ref.WeakReference;

/* loaded from: classes3.dex */
final class di {

    /* renamed from: a, reason: collision with root package name */
    WeakReference<dl> f11917a;

    public final boolean a(final dl dlVar, Activity activity) {
        int a10;
        try {
            if (activity.isFinishing()) {
                ce.d("Banner", "Activity is finishing or does not have valid window token. Cannot show");
                return false;
            }
            Point a11 = ed.a((Context) activity);
            int min = Math.min(a11.x, a11.y);
            int max = Math.max(a11.x, a11.y);
            int a12 = min - ed.a(32.0f);
            if (dlVar.f11923a.a()) {
                Bitmap bitmap = dlVar.f11923a.f11921b;
                a10 = (bitmap.getHeight() * a12) / bitmap.getWidth();
                int min2 = Math.min(Math.min(max / 5, ed.a(144.0f)), a10);
                if (a10 > min2) {
                    a12 = (a12 * min2) / a10;
                    a10 = min2;
                }
            } else {
                a10 = ed.a(80.0f);
            }
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(a12, a10, Constant.STOP_FROM_SINK, 327968, -3);
            Rect rect = new Rect();
            activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
            layoutParams.y = Math.min(rect.top, ed.a(56.0f)) + ed.a(4.0f);
            layoutParams.dimAmount = 0.3f;
            layoutParams.gravity = 49;
            layoutParams.windowAnimations = 0;
            WindowManager a13 = a((Context) activity);
            ef efVar = dlVar.f11925c;
            if (efVar.getParent() != null) {
                ((ViewGroup) efVar.getParent()).removeView(efVar);
            }
            a13.addView(efVar, layoutParams);
            if (dlVar.f11923a.f11920a.f11740b.optInt("f_close", 0) == 1) {
                dlVar.f11925c.setOnTouchListener(new ek(dlVar.f11925c, new View.OnClickListener() { // from class: com.umeng.message.proguard.di.1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        View.OnClickListener onClickListener = dlVar.f11926d;
                        if (onClickListener != null) {
                            onClickListener.onClick(view);
                        }
                    }
                }));
            }
            this.f11917a = new WeakReference<>(dlVar);
            return true;
        } catch (Throwable th) {
            ce.d("Banner", "show failed:", th.getMessage());
            return false;
        }
    }

    public final boolean a() {
        dl dlVar;
        WeakReference<dl> weakReference = this.f11917a;
        if (weakReference == null || (dlVar = weakReference.get()) == null) {
            return false;
        }
        return dlVar.f11925c.isShown();
    }

    public final void a(Activity activity) {
        try {
            WeakReference<dl> weakReference = this.f11917a;
            if (weakReference != null) {
                dl dlVar = weakReference.get();
                if (dlVar == null) {
                    return;
                }
                a((Context) activity).removeViewImmediate(dlVar.f11925c);
                Bitmap bitmap = dlVar.f11923a.f11921b;
                if (bitmap != null && !bitmap.isRecycled()) {
                    bitmap.recycle();
                }
            }
        } catch (Throwable unused) {
        }
        this.f11917a = null;
    }

    private static WindowManager a(Context context) {
        return (WindowManager) context.getSystemService("window");
    }
}
