package androidx.activity;

import android.app.Activity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.lifecycle.d;
import androidx.lifecycle.e;
import androidx.lifecycle.g;
import java.lang.reflect.Field;

/* loaded from: classes.dex */
final class ImmLeaksCleaner implements e {

    /* renamed from: b, reason: collision with root package name */
    public static int f749b;

    /* renamed from: c, reason: collision with root package name */
    public static Field f750c;

    /* renamed from: d, reason: collision with root package name */
    public static Field f751d;

    /* renamed from: e, reason: collision with root package name */
    public static Field f752e;

    /* renamed from: a, reason: collision with root package name */
    public Activity f753a;

    public ImmLeaksCleaner(Activity activity) {
        this.f753a = activity;
    }

    public static void b() {
        try {
            f749b = 2;
            Field declaredField = InputMethodManager.class.getDeclaredField("mServedView");
            f751d = declaredField;
            declaredField.setAccessible(true);
            Field declaredField2 = InputMethodManager.class.getDeclaredField("mNextServedView");
            f752e = declaredField2;
            declaredField2.setAccessible(true);
            Field declaredField3 = InputMethodManager.class.getDeclaredField("mH");
            f750c = declaredField3;
            declaredField3.setAccessible(true);
            f749b = 1;
        } catch (NoSuchFieldException unused) {
        }
    }

    @Override // androidx.lifecycle.e
    public void a(g gVar, d.b bVar) {
        if (bVar != d.b.ON_DESTROY) {
            return;
        }
        if (f749b == 0) {
            b();
        }
        if (f749b == 1) {
            InputMethodManager inputMethodManager = (InputMethodManager) this.f753a.getSystemService("input_method");
            try {
                Object obj = f750c.get(inputMethodManager);
                if (obj == null) {
                    return;
                }
                synchronized (obj) {
                    try {
                        try {
                            View view = (View) f751d.get(inputMethodManager);
                            if (view == null) {
                                return;
                            }
                            if (view.isAttachedToWindow()) {
                                return;
                            }
                            try {
                                f752e.set(inputMethodManager, null);
                                inputMethodManager.isActive();
                            } catch (IllegalAccessException unused) {
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    } catch (ClassCastException unused2) {
                    } catch (IllegalAccessException unused3) {
                    }
                }
            } catch (IllegalAccessException unused4) {
            }
        }
    }
}
