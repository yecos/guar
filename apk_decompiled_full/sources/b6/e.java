package b6;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.LinkedHashMap;
import java.util.Map;
import l5.a;

/* loaded from: classes3.dex */
public abstract class e<P extends l5.a> extends f {

    /* renamed from: f, reason: collision with root package name */
    public Activity f4697f;

    /* renamed from: g, reason: collision with root package name */
    public View f4698g;

    /* renamed from: h, reason: collision with root package name */
    public Map f4699h = new LinkedHashMap();

    /* renamed from: e, reason: collision with root package name */
    public boolean f4696e = true;

    @Override // b6.f
    public void X2() {
        this.f4699h.clear();
    }

    public abstract void Y2();

    public final Activity Z2() {
        Activity activity = this.f4697f;
        if (activity != null) {
            return activity;
        }
        t9.i.w("mActivity");
        return null;
    }

    public abstract l5.a a3();

    public View b3() {
        return this.f4698g;
    }

    public abstract int c3();

    public final void d3(Activity activity) {
        t9.i.g(activity, "<set-?>");
        this.f4697f = activity;
    }

    public void e3(View view) {
        this.f4698g = view;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        t9.i.g(context, com.umeng.analytics.pro.f.X);
        super.onAttach(context);
        androidx.fragment.app.e activity = getActivity();
        t9.i.d(activity);
        d3(activity);
    }

    @Override // u8.b, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        t9.i.g(layoutInflater, "inflater");
        if (b3() == null) {
            e3(layoutInflater.inflate(c3(), viewGroup, false));
        }
        return b3();
    }

    @Override // u8.b, androidx.fragment.app.Fragment
    public void onDestroy() {
        a3().g();
        super.onDestroy();
    }

    @Override // b6.f, u8.b, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        X2();
    }

    @Override // k5.a, u8.b, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        t9.i.g(view, "view");
        super.onViewCreated(view, bundle);
        if (this.f4696e) {
            this.f4696e = false;
            Y2();
            a3().e();
        }
    }
}
