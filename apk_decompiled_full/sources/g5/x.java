package g5;

import androidx.fragment.app.Fragment;
import java.util.List;

/* loaded from: classes3.dex */
public final class x extends androidx.fragment.app.t {

    /* renamed from: a, reason: collision with root package name */
    public List f13949a;

    /* renamed from: b, reason: collision with root package name */
    public List f13950b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(List list, List list2, androidx.fragment.app.o oVar) {
        super(oVar);
        t9.i.g(list, "frag");
        t9.i.g(list2, "titles");
        t9.i.g(oVar, "fm");
        this.f13949a = list;
        this.f13950b = list2;
    }

    @Override // androidx.viewpager.widget.a
    public int getCount() {
        return this.f13949a.size();
    }

    @Override // androidx.fragment.app.t
    public Fragment getItem(int i10) {
        return (Fragment) this.f13949a.get(i10);
    }

    @Override // androidx.viewpager.widget.a
    public int getItemPosition(Object obj) {
        t9.i.g(obj, "frag");
        return super.getItemPosition(obj);
    }

    @Override // androidx.viewpager.widget.a
    public CharSequence getPageTitle(int i10) {
        return (CharSequence) this.f13950b.get(i10);
    }
}
