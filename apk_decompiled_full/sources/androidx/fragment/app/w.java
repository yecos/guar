package androidx.fragment.app;

import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.d;
import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class w extends androidx.viewpager.widget.a {

    /* renamed from: a, reason: collision with root package name */
    public final o f2424a;

    /* renamed from: b, reason: collision with root package name */
    public final int f2425b;

    /* renamed from: c, reason: collision with root package name */
    public y f2426c;

    /* renamed from: d, reason: collision with root package name */
    public ArrayList f2427d;

    /* renamed from: e, reason: collision with root package name */
    public ArrayList f2428e;

    /* renamed from: f, reason: collision with root package name */
    public Fragment f2429f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f2430g;

    public w(o oVar) {
        this(oVar, 0);
    }

    @Override // androidx.viewpager.widget.a
    public void destroyItem(ViewGroup viewGroup, int i10, Object obj) {
        Fragment fragment = (Fragment) obj;
        if (this.f2426c == null) {
            this.f2426c = this.f2424a.m();
        }
        while (this.f2427d.size() <= i10) {
            this.f2427d.add(null);
        }
        this.f2427d.set(i10, fragment.isAdded() ? this.f2424a.k1(fragment) : null);
        this.f2428e.set(i10, null);
        this.f2426c.p(fragment);
        if (fragment.equals(this.f2429f)) {
            this.f2429f = null;
        }
    }

    @Override // androidx.viewpager.widget.a
    public void finishUpdate(ViewGroup viewGroup) {
        y yVar = this.f2426c;
        if (yVar != null) {
            if (!this.f2430g) {
                try {
                    this.f2430g = true;
                    yVar.k();
                } finally {
                    this.f2430g = false;
                }
            }
            this.f2426c = null;
        }
    }

    public abstract Fragment getItem(int i10);

    @Override // androidx.viewpager.widget.a
    public Object instantiateItem(ViewGroup viewGroup, int i10) {
        Fragment.m mVar;
        Fragment fragment;
        if (this.f2428e.size() > i10 && (fragment = (Fragment) this.f2428e.get(i10)) != null) {
            return fragment;
        }
        if (this.f2426c == null) {
            this.f2426c = this.f2424a.m();
        }
        Fragment item = getItem(i10);
        if (this.f2427d.size() > i10 && (mVar = (Fragment.m) this.f2427d.get(i10)) != null) {
            item.setInitialSavedState(mVar);
        }
        while (this.f2428e.size() <= i10) {
            this.f2428e.add(null);
        }
        item.setMenuVisibility(false);
        if (this.f2425b == 0) {
            item.setUserVisibleHint(false);
        }
        this.f2428e.set(i10, item);
        this.f2426c.b(viewGroup.getId(), item);
        if (this.f2425b == 1) {
            this.f2426c.s(item, d.c.STARTED);
        }
        return item;
    }

    @Override // androidx.viewpager.widget.a
    public boolean isViewFromObject(View view, Object obj) {
        return ((Fragment) obj).getView() == view;
    }

    @Override // androidx.viewpager.widget.a
    public void restoreState(Parcelable parcelable, ClassLoader classLoader) {
        if (parcelable != null) {
            Bundle bundle = (Bundle) parcelable;
            bundle.setClassLoader(classLoader);
            Parcelable[] parcelableArray = bundle.getParcelableArray("states");
            this.f2427d.clear();
            this.f2428e.clear();
            if (parcelableArray != null) {
                for (Parcelable parcelable2 : parcelableArray) {
                    this.f2427d.add((Fragment.m) parcelable2);
                }
            }
            for (String str : bundle.keySet()) {
                if (str.startsWith(m7.f.f16828a)) {
                    int parseInt = Integer.parseInt(str.substring(1));
                    Fragment o02 = this.f2424a.o0(bundle, str);
                    if (o02 != null) {
                        while (this.f2428e.size() <= parseInt) {
                            this.f2428e.add(null);
                        }
                        o02.setMenuVisibility(false);
                        this.f2428e.set(parseInt, o02);
                    } else {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Bad fragment at key ");
                        sb.append(str);
                    }
                }
            }
        }
    }

    @Override // androidx.viewpager.widget.a
    public Parcelable saveState() {
        Bundle bundle;
        if (this.f2427d.size() > 0) {
            bundle = new Bundle();
            Fragment.m[] mVarArr = new Fragment.m[this.f2427d.size()];
            this.f2427d.toArray(mVarArr);
            bundle.putParcelableArray("states", mVarArr);
        } else {
            bundle = null;
        }
        for (int i10 = 0; i10 < this.f2428e.size(); i10++) {
            Fragment fragment = (Fragment) this.f2428e.get(i10);
            if (fragment != null && fragment.isAdded()) {
                if (bundle == null) {
                    bundle = new Bundle();
                }
                this.f2424a.b1(bundle, m7.f.f16828a + i10, fragment);
            }
        }
        return bundle;
    }

    @Override // androidx.viewpager.widget.a
    public void setPrimaryItem(ViewGroup viewGroup, int i10, Object obj) {
        Fragment fragment = (Fragment) obj;
        Fragment fragment2 = this.f2429f;
        if (fragment != fragment2) {
            if (fragment2 != null) {
                fragment2.setMenuVisibility(false);
                if (this.f2425b == 1) {
                    if (this.f2426c == null) {
                        this.f2426c = this.f2424a.m();
                    }
                    this.f2426c.s(this.f2429f, d.c.STARTED);
                } else {
                    this.f2429f.setUserVisibleHint(false);
                }
            }
            fragment.setMenuVisibility(true);
            if (this.f2425b == 1) {
                if (this.f2426c == null) {
                    this.f2426c = this.f2424a.m();
                }
                this.f2426c.s(fragment, d.c.RESUMED);
            } else {
                fragment.setUserVisibleHint(true);
            }
            this.f2429f = fragment;
        }
    }

    @Override // androidx.viewpager.widget.a
    public void startUpdate(ViewGroup viewGroup) {
        if (viewGroup.getId() != -1) {
            return;
        }
        throw new IllegalStateException("ViewPager with adapter " + this + " requires a view id");
    }

    public w(o oVar, int i10) {
        this.f2426c = null;
        this.f2427d = new ArrayList();
        this.f2428e = new ArrayList();
        this.f2429f = null;
        this.f2424a = oVar;
        this.f2425b = i10;
    }
}
