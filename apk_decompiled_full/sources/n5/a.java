package n5;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.mobile.brasiltv.base.R$id;
import com.mobile.brasiltv.view.RoundedDrawable;
import t9.i;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: b, reason: collision with root package name */
    public static final int f17269b = 0;

    /* renamed from: e, reason: collision with root package name */
    public static o5.a f17272e;

    /* renamed from: a, reason: collision with root package name */
    public static final a f17268a = new a();

    /* renamed from: c, reason: collision with root package name */
    public static final int f17270c = R$id.statusbarutil_fake_status_bar_view;

    /* renamed from: d, reason: collision with root package name */
    public static final int f17271d = R$id.statusbarutil_translucent_view;

    public static final int d(int i10, int i11) {
        if (i11 == 0) {
            return i10;
        }
        float f10 = 1 - (i11 / 255.0f);
        double d10 = ((i10 >> 16) & 255) * f10;
        Double.isNaN(d10);
        int i12 = (int) (d10 + 0.5d);
        double d11 = ((i10 >> 8) & 255) * f10;
        Double.isNaN(d11);
        double d12 = (i10 & 255) * f10;
        Double.isNaN(d12);
        return ((int) (d12 + 0.5d)) | (i12 << 16) | RoundedDrawable.DEFAULT_BORDER_COLOR | (((int) (d11 + 0.5d)) << 8);
    }

    public static final View e(Activity activity, int i10, int i11) {
        View view = new View(activity);
        view.setLayoutParams(new LinearLayout.LayoutParams(-1, f17268a.a(activity)));
        view.setBackgroundColor(d(i10, i11));
        view.setId(f17270c);
        return view;
    }

    public static /* synthetic */ void f(a aVar, Activity activity, int i10, int i11, int i12, Object obj) {
        if ((i12 & 4) != 0) {
            i11 = f17269b;
        }
        aVar.c(activity, i10, i11);
    }

    public static final void g(Activity activity) {
        View findViewById = activity.findViewById(R.id.content);
        i.e(findViewById, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup = (ViewGroup) findViewById;
        int childCount = viewGroup.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = viewGroup.getChildAt(i10);
            if (childAt instanceof ViewGroup) {
                childAt.setFitsSystemWindows(true);
                ((ViewGroup) childAt).setClipToPadding(true);
            }
        }
    }

    public final int a(Context context) {
        Resources resources = context != null ? context.getResources() : null;
        int identifier = resources != null ? resources.getIdentifier("status_bar_height", "dimen", "android") : 0;
        if (identifier <= 0 || resources == null) {
            return 0;
        }
        return resources.getDimensionPixelSize(identifier);
    }

    public final void b(o5.a aVar) {
        i.g(aVar, "compatConfig");
        f17272e = aVar;
    }

    public final void c(Activity activity, int i10, int i11) {
        i.g(activity, "activity");
        o5.a aVar = f17272e;
        if (aVar != null && aVar.a()) {
            o5.a aVar2 = f17272e;
            if (aVar2 != null && aVar2.b()) {
                activity.getWindow().addFlags(67108864);
                View decorView = activity.getWindow().getDecorView();
                i.e(decorView, "null cannot be cast to non-null type android.view.ViewGroup");
                ViewGroup viewGroup = (ViewGroup) decorView;
                View findViewById = viewGroup.findViewById(f17270c);
                if (findViewById != null) {
                    if (findViewById.getVisibility() == 8) {
                        findViewById.setVisibility(0);
                    }
                    findViewById.setBackgroundColor(d(i10, i11));
                } else {
                    viewGroup.addView(e(activity, i10, i11));
                }
                g(activity);
                return;
            }
            activity.getWindow().getDecorView().setSystemUiVisibility(1280);
            if (Build.VERSION.SDK_INT >= 21) {
                activity.getWindow().addFlags(Integer.MIN_VALUE);
                activity.getWindow().clearFlags(67108864);
                activity.getWindow().setStatusBarColor(d(i10, i11));
                return;
            }
            activity.getWindow().addFlags(67108864);
            View decorView2 = activity.getWindow().getDecorView();
            i.e(decorView2, "null cannot be cast to non-null type android.view.ViewGroup");
            ViewGroup viewGroup2 = (ViewGroup) decorView2;
            if (viewGroup2.findViewById(f17270c) == null) {
                viewGroup2.addView(e(activity, i10, i11));
                g(activity);
            }
        }
    }

    public final void h(Activity activity) {
        i.g(activity, "activity");
        f(this, activity, 0, 0, 4, null);
    }
}
