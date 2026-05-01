package androidx.fragment.app;

import android.view.ViewGroup;
import androidx.lifecycle.d;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class y {

    /* renamed from: a, reason: collision with root package name */
    public final k f2434a;

    /* renamed from: b, reason: collision with root package name */
    public final ClassLoader f2435b;

    /* renamed from: d, reason: collision with root package name */
    public int f2437d;

    /* renamed from: e, reason: collision with root package name */
    public int f2438e;

    /* renamed from: f, reason: collision with root package name */
    public int f2439f;

    /* renamed from: g, reason: collision with root package name */
    public int f2440g;

    /* renamed from: h, reason: collision with root package name */
    public int f2441h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f2442i;

    /* renamed from: k, reason: collision with root package name */
    public String f2444k;

    /* renamed from: l, reason: collision with root package name */
    public int f2445l;

    /* renamed from: m, reason: collision with root package name */
    public CharSequence f2446m;

    /* renamed from: n, reason: collision with root package name */
    public int f2447n;

    /* renamed from: o, reason: collision with root package name */
    public CharSequence f2448o;

    /* renamed from: p, reason: collision with root package name */
    public ArrayList f2449p;

    /* renamed from: q, reason: collision with root package name */
    public ArrayList f2450q;

    /* renamed from: s, reason: collision with root package name */
    public ArrayList f2452s;

    /* renamed from: c, reason: collision with root package name */
    public ArrayList f2436c = new ArrayList();

    /* renamed from: j, reason: collision with root package name */
    public boolean f2443j = true;

    /* renamed from: r, reason: collision with root package name */
    public boolean f2451r = false;

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public int f2453a;

        /* renamed from: b, reason: collision with root package name */
        public Fragment f2454b;

        /* renamed from: c, reason: collision with root package name */
        public int f2455c;

        /* renamed from: d, reason: collision with root package name */
        public int f2456d;

        /* renamed from: e, reason: collision with root package name */
        public int f2457e;

        /* renamed from: f, reason: collision with root package name */
        public int f2458f;

        /* renamed from: g, reason: collision with root package name */
        public d.c f2459g;

        /* renamed from: h, reason: collision with root package name */
        public d.c f2460h;

        public a() {
        }

        public a(int i10, Fragment fragment) {
            this.f2453a = i10;
            this.f2454b = fragment;
            d.c cVar = d.c.RESUMED;
            this.f2459g = cVar;
            this.f2460h = cVar;
        }

        public a(int i10, Fragment fragment, d.c cVar) {
            this.f2453a = i10;
            this.f2454b = fragment;
            this.f2459g = fragment.mMaxState;
            this.f2460h = cVar;
        }
    }

    public y(k kVar, ClassLoader classLoader) {
        this.f2434a = kVar;
        this.f2435b = classLoader;
    }

    public y b(int i10, Fragment fragment) {
        n(i10, fragment, null, 1);
        return this;
    }

    public y c(int i10, Fragment fragment, String str) {
        n(i10, fragment, str, 1);
        return this;
    }

    public y d(ViewGroup viewGroup, Fragment fragment, String str) {
        fragment.mContainer = viewGroup;
        return c(viewGroup.getId(), fragment, str);
    }

    public y e(Fragment fragment, String str) {
        n(0, fragment, str, 1);
        return this;
    }

    public void f(a aVar) {
        this.f2436c.add(aVar);
        aVar.f2455c = this.f2437d;
        aVar.f2456d = this.f2438e;
        aVar.f2457e = this.f2439f;
        aVar.f2458f = this.f2440g;
    }

    public y g(Fragment fragment) {
        f(new a(7, fragment));
        return this;
    }

    public abstract int h();

    public abstract int i();

    public abstract void j();

    public abstract void k();

    public y l(Fragment fragment) {
        f(new a(6, fragment));
        return this;
    }

    public y m() {
        if (this.f2442i) {
            throw new IllegalStateException("This transaction is already being added to the back stack");
        }
        this.f2443j = false;
        return this;
    }

    public void n(int i10, Fragment fragment, String str, int i11) {
        Class<?> cls = fragment.getClass();
        int modifiers = cls.getModifiers();
        if (cls.isAnonymousClass() || !Modifier.isPublic(modifiers) || (cls.isMemberClass() && !Modifier.isStatic(modifiers))) {
            throw new IllegalStateException("Fragment " + cls.getCanonicalName() + " must be a public static class to be  properly recreated from instance state.");
        }
        if (str != null) {
            String str2 = fragment.mTag;
            if (str2 != null && !str.equals(str2)) {
                throw new IllegalStateException("Can't change tag of fragment " + fragment + ": was " + fragment.mTag + " now " + str);
            }
            fragment.mTag = str;
        }
        if (i10 != 0) {
            if (i10 == -1) {
                throw new IllegalArgumentException("Can't add fragment " + fragment + " with tag " + str + " to container view with no id");
            }
            int i12 = fragment.mFragmentId;
            if (i12 != 0 && i12 != i10) {
                throw new IllegalStateException("Can't change container ID of fragment " + fragment + ": was " + fragment.mFragmentId + " now " + i10);
            }
            fragment.mFragmentId = i10;
            fragment.mContainerId = i10;
        }
        f(new a(i11, fragment));
    }

    public y o(Fragment fragment) {
        f(new a(4, fragment));
        return this;
    }

    public y p(Fragment fragment) {
        f(new a(3, fragment));
        return this;
    }

    public y q(int i10, Fragment fragment) {
        return r(i10, fragment, null);
    }

    public y r(int i10, Fragment fragment, String str) {
        if (i10 == 0) {
            throw new IllegalArgumentException("Must use non-zero containerViewId");
        }
        n(i10, fragment, str, 2);
        return this;
    }

    public y s(Fragment fragment, d.c cVar) {
        f(new a(10, fragment, cVar));
        return this;
    }

    public y t(boolean z10) {
        this.f2451r = z10;
        return this;
    }

    public y u(Fragment fragment) {
        f(new a(5, fragment));
        return this;
    }
}
