package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public abstract class p {
    public static int a(RecyclerView.a0 a0Var, m mVar, View view, View view2, RecyclerView.o oVar, boolean z10) {
        if (oVar.getChildCount() == 0 || a0Var.b() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z10) {
            return Math.abs(oVar.getPosition(view) - oVar.getPosition(view2)) + 1;
        }
        return Math.min(mVar.n(), mVar.d(view2) - mVar.g(view));
    }

    public static int b(RecyclerView.a0 a0Var, m mVar, View view, View view2, RecyclerView.o oVar, boolean z10, boolean z11) {
        if (oVar.getChildCount() == 0 || a0Var.b() == 0 || view == null || view2 == null) {
            return 0;
        }
        int max = z11 ? Math.max(0, (a0Var.b() - Math.max(oVar.getPosition(view), oVar.getPosition(view2))) - 1) : Math.max(0, Math.min(oVar.getPosition(view), oVar.getPosition(view2)));
        if (z10) {
            return Math.round((max * (Math.abs(mVar.d(view2) - mVar.g(view)) / (Math.abs(oVar.getPosition(view) - oVar.getPosition(view2)) + 1))) + (mVar.m() - mVar.g(view)));
        }
        return max;
    }

    public static int c(RecyclerView.a0 a0Var, m mVar, View view, View view2, RecyclerView.o oVar, boolean z10) {
        if (oVar.getChildCount() == 0 || a0Var.b() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z10) {
            return a0Var.b();
        }
        return (int) (((mVar.d(view2) - mVar.g(view)) / (Math.abs(oVar.getPosition(view) - oVar.getPosition(view2)) + 1)) * a0Var.b());
    }
}
