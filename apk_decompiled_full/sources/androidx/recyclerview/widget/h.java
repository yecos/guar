package androidx.recyclerview.widget;

import android.graphics.Canvas;
import android.os.Build;
import android.view.View;
import androidx.recyclerview.R$id;
import b0.c1;

/* loaded from: classes.dex */
public class h implements g {

    /* renamed from: a, reason: collision with root package name */
    public static final g f3249a = new h();

    public static float e(RecyclerView recyclerView, View view) {
        int childCount = recyclerView.getChildCount();
        float f10 = 0.0f;
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = recyclerView.getChildAt(i10);
            if (childAt != view) {
                float u10 = c1.u(childAt);
                if (u10 > f10) {
                    f10 = u10;
                }
            }
        }
        return f10;
    }

    @Override // androidx.recyclerview.widget.g
    public void a(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            int i10 = R$id.item_touch_helper_previous_elevation;
            Object tag = view.getTag(i10);
            if (tag instanceof Float) {
                c1.s0(view, ((Float) tag).floatValue());
            }
            view.setTag(i10, null);
        }
        view.setTranslationX(0.0f);
        view.setTranslationY(0.0f);
    }

    @Override // androidx.recyclerview.widget.g
    public void b(View view) {
    }

    @Override // androidx.recyclerview.widget.g
    public void c(Canvas canvas, RecyclerView recyclerView, View view, float f10, float f11, int i10, boolean z10) {
        if (Build.VERSION.SDK_INT >= 21 && z10) {
            int i11 = R$id.item_touch_helper_previous_elevation;
            if (view.getTag(i11) == null) {
                Float valueOf = Float.valueOf(c1.u(view));
                c1.s0(view, e(recyclerView, view) + 1.0f);
                view.setTag(i11, valueOf);
            }
        }
        view.setTranslationX(f10);
        view.setTranslationY(f11);
    }

    @Override // androidx.recyclerview.widget.g
    public void d(Canvas canvas, RecyclerView recyclerView, View view, float f10, float f11, int i10, boolean z10) {
    }
}
