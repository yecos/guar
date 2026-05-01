package g5;

import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public final class i0 extends androidx.viewpager.widget.a {

    /* renamed from: a, reason: collision with root package name */
    public ArrayList f13716a;

    public i0(ArrayList arrayList) {
        t9.i.g(arrayList, "viewList");
        this.f13716a = arrayList;
    }

    @Override // androidx.viewpager.widget.a
    public void destroyItem(ViewGroup viewGroup, int i10, Object obj) {
        t9.i.g(viewGroup, "container");
        t9.i.g(obj, "object");
        viewGroup.removeView((View) this.f13716a.get(i10));
    }

    @Override // androidx.viewpager.widget.a
    public int getCount() {
        return this.f13716a.size();
    }

    @Override // androidx.viewpager.widget.a
    public Object instantiateItem(ViewGroup viewGroup, int i10) {
        t9.i.g(viewGroup, "container");
        Object obj = this.f13716a.get(i10);
        t9.i.f(obj, "viewList[position]");
        View view = (View) obj;
        viewGroup.addView(view);
        return view;
    }

    @Override // androidx.viewpager.widget.a
    public boolean isViewFromObject(View view, Object obj) {
        t9.i.g(view, "view");
        t9.i.g(obj, "object");
        return t9.i.b(view, obj);
    }
}
