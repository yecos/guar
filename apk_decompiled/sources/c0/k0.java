package c0;

import android.view.View;
import android.view.accessibility.AccessibilityRecord;

/* loaded from: classes.dex */
public class k0 {

    /* renamed from: a, reason: collision with root package name */
    public final AccessibilityRecord f5291a;

    public k0(Object obj) {
        this.f5291a = (AccessibilityRecord) obj;
    }

    public static k0 a() {
        return new k0(AccessibilityRecord.obtain());
    }

    public static void d(AccessibilityRecord accessibilityRecord, int i10) {
        accessibilityRecord.setMaxScrollX(i10);
    }

    public static void e(AccessibilityRecord accessibilityRecord, int i10) {
        accessibilityRecord.setMaxScrollY(i10);
    }

    public static void g(AccessibilityRecord accessibilityRecord, View view, int i10) {
        accessibilityRecord.setSource(view, i10);
    }

    public void b(int i10) {
        this.f5291a.setFromIndex(i10);
    }

    public void c(int i10) {
        this.f5291a.setItemCount(i10);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof k0)) {
            return false;
        }
        k0 k0Var = (k0) obj;
        AccessibilityRecord accessibilityRecord = this.f5291a;
        if (accessibilityRecord == null) {
            if (k0Var.f5291a != null) {
                return false;
            }
        } else if (!accessibilityRecord.equals(k0Var.f5291a)) {
            return false;
        }
        return true;
    }

    public void f(boolean z10) {
        this.f5291a.setScrollable(z10);
    }

    public void h(int i10) {
        this.f5291a.setToIndex(i10);
    }

    public int hashCode() {
        AccessibilityRecord accessibilityRecord = this.f5291a;
        if (accessibilityRecord == null) {
            return 0;
        }
        return accessibilityRecord.hashCode();
    }
}
