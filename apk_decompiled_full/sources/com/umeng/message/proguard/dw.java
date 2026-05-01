package com.umeng.message.proguard;

import android.graphics.Rect;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public final class dw {
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00f1, code lost:
    
        r2.add(5);
     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x002e A[Catch: all -> 0x00fa, TryCatch #0 {, blocks: (B:4:0x0005, B:6:0x0011, B:7:0x0018, B:9:0x0023, B:15:0x002e, B:16:0x0035, B:18:0x003c, B:23:0x0080, B:26:0x008a, B:28:0x0090, B:31:0x0097, B:34:0x00a3, B:38:0x00cc, B:42:0x00f1, B:47:0x0048, B:49:0x0050, B:53:0x005b), top: B:3:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x003c A[Catch: all -> 0x00fa, TryCatch #0 {, blocks: (B:4:0x0005, B:6:0x0011, B:7:0x0018, B:9:0x0023, B:15:0x002e, B:16:0x0035, B:18:0x003c, B:23:0x0080, B:26:0x008a, B:28:0x0090, B:31:0x0097, B:34:0x00a3, B:38:0x00cc, B:42:0x00f1, B:47:0x0048, B:49:0x0050, B:53:0x005b), top: B:3:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0080 A[Catch: all -> 0x00fa, TryCatch #0 {, blocks: (B:4:0x0005, B:6:0x0011, B:7:0x0018, B:9:0x0023, B:15:0x002e, B:16:0x0035, B:18:0x003c, B:23:0x0080, B:26:0x008a, B:28:0x0090, B:31:0x0097, B:34:0x00a3, B:38:0x00cc, B:42:0x00f1, B:47:0x0048, B:49:0x0050, B:53:0x005b), top: B:3:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00a3 A[Catch: all -> 0x00fa, TryCatch #0 {, blocks: (B:4:0x0005, B:6:0x0011, B:7:0x0018, B:9:0x0023, B:15:0x002e, B:16:0x0035, B:18:0x003c, B:23:0x0080, B:26:0x008a, B:28:0x0090, B:31:0x0097, B:34:0x00a3, B:38:0x00cc, B:42:0x00f1, B:47:0x0048, B:49:0x0050, B:53:0x005b), top: B:3:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0048 A[Catch: all -> 0x00fa, TryCatch #0 {, blocks: (B:4:0x0005, B:6:0x0011, B:7:0x0018, B:9:0x0023, B:15:0x002e, B:16:0x0035, B:18:0x003c, B:23:0x0080, B:26:0x008a, B:28:0x0090, B:31:0x0097, B:34:0x00a3, B:38:0x00cc, B:42:0x00f1, B:47:0x0048, B:49:0x0050, B:53:0x005b), top: B:3:0x0005 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized List<Integer> a(View view) {
        ArrayList arrayList;
        boolean z10;
        boolean z11;
        Rect rect;
        synchronized (dw.class) {
            arrayList = new ArrayList();
            if (!dx.a()) {
                arrayList.add(1);
            }
            bz a10 = bz.a();
            boolean z12 = false;
            if (a10.b() != null && a10.f11686a) {
                z10 = false;
                if (z10) {
                    arrayList.add(2);
                }
                if (!b(view)) {
                    arrayList.add(3);
                }
                if (view != null) {
                    z11 = false;
                } else {
                    z11 = view.getWidth() >= 20 && view.getHeight() >= 20;
                    if (!z11) {
                        ce.a("Valid", "expose invalid: w:", Integer.valueOf(view.getWidth()), " h:", Integer.valueOf(view.getHeight()));
                    }
                }
                if (!z11) {
                    arrayList.add(4);
                }
                if (view != null && view.getVisibility() == 0 && view.getParent() != null) {
                    rect = new Rect();
                    if (!view.getGlobalVisibleRect(rect)) {
                        long height = rect.height() * rect.width();
                        long height2 = view.getHeight() * view.getWidth();
                        boolean z13 = height >= (50 * height2) / 100;
                        if (!z13) {
                            ce.a("Valid", "expose invalid rect:", rect, " region:", Long.valueOf(height), " size:", Long.valueOf(height2));
                        }
                        z12 = z13;
                    }
                }
            }
            z10 = true;
            if (z10) {
            }
            if (!b(view)) {
            }
            if (view != null) {
            }
            if (!z11) {
            }
            if (view != null) {
                rect = new Rect();
                if (!view.getGlobalVisibleRect(rect)) {
                }
            }
        }
        return arrayList;
    }

    private static boolean b(View view) {
        if (view == null) {
            return false;
        }
        boolean z10 = view.getVisibility() == 0;
        if (z10) {
            do {
                Object parent = view.getParent();
                if (parent == null || !(parent instanceof View)) {
                    break;
                }
                view = (View) parent;
                z10 = view.getVisibility() == 0;
            } while (z10);
        }
        if (!z10) {
            ce.a("Valid", "expose invalid visible.");
        }
        return z10;
    }
}
