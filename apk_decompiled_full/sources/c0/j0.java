package c0;

import android.os.Build;
import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class j0 {

    /* renamed from: a, reason: collision with root package name */
    public final Object f5289a;

    public static class a extends AccessibilityNodeProvider {

        /* renamed from: a, reason: collision with root package name */
        public final j0 f5290a;

        public a(j0 j0Var) {
            this.f5290a = j0Var;
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public AccessibilityNodeInfo createAccessibilityNodeInfo(int i10) {
            g0 b10 = this.f5290a.b(i10);
            if (b10 == null) {
                return null;
            }
            return b10.u0();
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public List findAccessibilityNodeInfosByText(String str, int i10) {
            List c10 = this.f5290a.c(str, i10);
            if (c10 == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            int size = c10.size();
            for (int i11 = 0; i11 < size; i11++) {
                arrayList.add(((g0) c10.get(i11)).u0());
            }
            return arrayList;
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public boolean performAction(int i10, int i11, Bundle bundle) {
            return this.f5290a.f(i10, i11, bundle);
        }
    }

    public static class b extends a {
        public b(j0 j0Var) {
            super(j0Var);
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public AccessibilityNodeInfo findFocus(int i10) {
            g0 d10 = this.f5290a.d(i10);
            if (d10 == null) {
                return null;
            }
            return d10.u0();
        }
    }

    public static class c extends b {
        public c(j0 j0Var) {
            super(j0Var);
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public void addExtraDataToAccessibilityNodeInfo(int i10, AccessibilityNodeInfo accessibilityNodeInfo, String str, Bundle bundle) {
            this.f5290a.a(i10, g0.v0(accessibilityNodeInfo), str, bundle);
        }
    }

    public j0() {
        if (Build.VERSION.SDK_INT >= 26) {
            this.f5289a = new c(this);
        } else {
            this.f5289a = new b(this);
        }
    }

    public void a(int i10, g0 g0Var, String str, Bundle bundle) {
    }

    public g0 b(int i10) {
        return null;
    }

    public List c(String str, int i10) {
        return null;
    }

    public g0 d(int i10) {
        return null;
    }

    public Object e() {
        return this.f5289a;
    }

    public boolean f(int i10, int i11, Bundle bundle) {
        return false;
    }

    public j0(Object obj) {
        this.f5289a = obj;
    }
}
