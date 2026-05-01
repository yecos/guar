package g5;

import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes3.dex */
public abstract class t0 extends androidx.fragment.app.w {

    /* renamed from: h, reason: collision with root package name */
    public final HashMap f13902h;

    /* renamed from: i, reason: collision with root package name */
    public WeakReference f13903i;

    /* renamed from: j, reason: collision with root package name */
    public final List f13904j;

    public t0(androidx.fragment.app.o oVar, List list) {
        super(oVar);
        this.f13904j = list;
        this.f13902h = new HashMap();
    }

    public abstract Fragment a(int i10);

    public abstract CharSequence b(Object obj);

    @Override // androidx.fragment.app.w, androidx.viewpager.widget.a
    public void destroyItem(ViewGroup viewGroup, int i10, Object obj) {
        this.f13903i = new WeakReference(viewGroup);
        this.f13902h.remove(Integer.valueOf(i10));
        super.destroyItem(viewGroup, i10, obj);
    }

    @Override // androidx.viewpager.widget.a
    public int getCount() {
        List list = this.f13904j;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // androidx.fragment.app.w
    public Fragment getItem(int i10) {
        Fragment fragment = (Fragment) this.f13902h.get(Integer.valueOf(i10));
        if (fragment != null) {
            return fragment;
        }
        this.f13904j.get(i10);
        Fragment a10 = a(i10);
        this.f13902h.put(Integer.valueOf(i10), a10);
        return a10;
    }

    @Override // androidx.viewpager.widget.a
    public CharSequence getPageTitle(int i10) {
        return b(this.f13904j.get(i10));
    }
}
