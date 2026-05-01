package g5;

import androidx.fragment.app.Fragment;
import java.util.List;

/* loaded from: classes3.dex */
public final class a1 extends androidx.fragment.app.t {

    /* renamed from: a, reason: collision with root package name */
    public List f13635a;

    /* renamed from: b, reason: collision with root package name */
    public List f13636b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a1(List list, List list2, androidx.fragment.app.o oVar) {
        super(oVar);
        t9.i.g(list, "fragList");
        t9.i.g(list2, "titleList");
        t9.i.g(oVar, "fm");
        this.f13635a = list;
        this.f13636b = list2;
    }

    @Override // androidx.viewpager.widget.a
    public int getCount() {
        return this.f13636b.size();
    }

    @Override // androidx.fragment.app.t
    public Fragment getItem(int i10) {
        return (Fragment) this.f13635a.get(i10);
    }

    @Override // androidx.viewpager.widget.a
    public CharSequence getPageTitle(int i10) {
        return (CharSequence) this.f13636b.get(i10);
    }
}
