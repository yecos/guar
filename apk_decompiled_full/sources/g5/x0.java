package g5;

import android.os.Parcelable;
import androidx.fragment.app.Fragment;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public final class x0 extends androidx.fragment.app.w {

    /* renamed from: h, reason: collision with root package name */
    public ArrayList f13951h;

    /* renamed from: i, reason: collision with root package name */
    public ArrayList f13952i;

    /* renamed from: j, reason: collision with root package name */
    public int f13953j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x0(androidx.fragment.app.o oVar, ArrayList arrayList, ArrayList arrayList2) {
        super(oVar);
        t9.i.g(oVar, "fm");
        t9.i.g(arrayList, "mFragmentList");
        t9.i.g(arrayList2, "mStringList");
        this.f13951h = arrayList;
        this.f13952i = arrayList2;
    }

    @Override // androidx.viewpager.widget.a
    public int getCount() {
        return this.f13951h.size();
    }

    @Override // androidx.fragment.app.w
    public Fragment getItem(int i10) {
        Object obj = this.f13951h.get(i10);
        t9.i.f(obj, "mFragmentList[position]");
        return (Fragment) obj;
    }

    @Override // androidx.viewpager.widget.a
    public int getItemPosition(Object obj) {
        t9.i.g(obj, "object");
        int i10 = this.f13953j;
        if (i10 <= 0) {
            return super.getItemPosition(obj);
        }
        this.f13953j = i10 - 1;
        return -2;
    }

    @Override // androidx.viewpager.widget.a
    public CharSequence getPageTitle(int i10) {
        Object obj = this.f13952i.get(i10);
        t9.i.f(obj, "mStringList[position]");
        return (CharSequence) obj;
    }

    @Override // androidx.viewpager.widget.a
    public void notifyDataSetChanged() {
        this.f13953j = getCount();
        super.notifyDataSetChanged();
    }

    @Override // androidx.fragment.app.w, androidx.viewpager.widget.a
    public Parcelable saveState() {
        return null;
    }
}
