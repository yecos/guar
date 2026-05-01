package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.e;
import androidx.fragment.R$id;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.f;
import androidx.fragment.app.y;
import androidx.fragment.app.z;
import androidx.lifecycle.d;
import com.hpplay.cybergarage.soap.SOAP;
import com.umeng.analytics.pro.q;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public abstract class o {
    public static boolean O = false;
    public static boolean P = true;
    public androidx.activity.result.c A;
    public androidx.activity.result.c B;
    public boolean D;
    public boolean E;
    public boolean F;
    public boolean G;
    public boolean H;
    public ArrayList I;
    public ArrayList J;
    public ArrayList K;
    public ArrayList L;
    public r M;

    /* renamed from: b, reason: collision with root package name */
    public boolean f2339b;

    /* renamed from: d, reason: collision with root package name */
    public ArrayList f2341d;

    /* renamed from: e, reason: collision with root package name */
    public ArrayList f2342e;

    /* renamed from: g, reason: collision with root package name */
    public OnBackPressedDispatcher f2344g;

    /* renamed from: l, reason: collision with root package name */
    public ArrayList f2349l;

    /* renamed from: r, reason: collision with root package name */
    public androidx.fragment.app.l f2355r;

    /* renamed from: s, reason: collision with root package name */
    public androidx.fragment.app.g f2356s;

    /* renamed from: t, reason: collision with root package name */
    public Fragment f2357t;

    /* renamed from: u, reason: collision with root package name */
    public Fragment f2358u;

    /* renamed from: z, reason: collision with root package name */
    public androidx.activity.result.c f2363z;

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f2338a = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    public final x f2340c = new x();

    /* renamed from: f, reason: collision with root package name */
    public final androidx.fragment.app.m f2343f = new androidx.fragment.app.m(this);

    /* renamed from: h, reason: collision with root package name */
    public final androidx.activity.b f2345h = new c(false);

    /* renamed from: i, reason: collision with root package name */
    public final AtomicInteger f2346i = new AtomicInteger();

    /* renamed from: j, reason: collision with root package name */
    public final Map f2347j = Collections.synchronizedMap(new HashMap());

    /* renamed from: k, reason: collision with root package name */
    public final Map f2348k = Collections.synchronizedMap(new HashMap());

    /* renamed from: m, reason: collision with root package name */
    public Map f2350m = Collections.synchronizedMap(new HashMap());

    /* renamed from: n, reason: collision with root package name */
    public final z.g f2351n = new d();

    /* renamed from: o, reason: collision with root package name */
    public final androidx.fragment.app.n f2352o = new androidx.fragment.app.n(this);

    /* renamed from: p, reason: collision with root package name */
    public final CopyOnWriteArrayList f2353p = new CopyOnWriteArrayList();

    /* renamed from: q, reason: collision with root package name */
    public int f2354q = -1;

    /* renamed from: v, reason: collision with root package name */
    public androidx.fragment.app.k f2359v = null;

    /* renamed from: w, reason: collision with root package name */
    public androidx.fragment.app.k f2360w = new e();

    /* renamed from: x, reason: collision with root package name */
    public k0 f2361x = null;

    /* renamed from: y, reason: collision with root package name */
    public k0 f2362y = new f();
    public ArrayDeque C = new ArrayDeque();
    public Runnable N = new g();

    public class a implements androidx.activity.result.b {
        public a() {
        }

        @Override // androidx.activity.result.b
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(androidx.activity.result.a aVar) {
            l lVar = (l) o.this.C.pollFirst();
            if (lVar == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("No IntentSenders were started for ");
                sb.append(this);
                return;
            }
            String str = lVar.f2378a;
            int i10 = lVar.f2379b;
            Fragment i11 = o.this.f2340c.i(str);
            if (i11 != null) {
                i11.onActivityResult(i10, aVar.b(), aVar.a());
                return;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Intent Sender result delivered for unknown Fragment ");
            sb2.append(str);
        }
    }

    public class b implements androidx.activity.result.b {
        public b() {
        }

        @Override // androidx.activity.result.b
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(Map map) {
            String[] strArr = (String[]) map.keySet().toArray(new String[0]);
            ArrayList arrayList = new ArrayList(map.values());
            int[] iArr = new int[arrayList.size()];
            for (int i10 = 0; i10 < arrayList.size(); i10++) {
                iArr[i10] = ((Boolean) arrayList.get(i10)).booleanValue() ? 0 : -1;
            }
            l lVar = (l) o.this.C.pollFirst();
            if (lVar == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("No permissions were requested for ");
                sb.append(this);
                return;
            }
            String str = lVar.f2378a;
            int i11 = lVar.f2379b;
            Fragment i12 = o.this.f2340c.i(str);
            if (i12 != null) {
                i12.onRequestPermissionsResult(i11, strArr, iArr);
                return;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Permission request result delivered for unknown Fragment ");
            sb2.append(str);
        }
    }

    public class c extends androidx.activity.b {
        public c(boolean z10) {
            super(z10);
        }

        @Override // androidx.activity.b
        public void b() {
            o.this.B0();
        }
    }

    public class d implements z.g {
        public d() {
        }

        @Override // androidx.fragment.app.z.g
        public void a(Fragment fragment, x.b bVar) {
            o.this.f(fragment, bVar);
        }

        @Override // androidx.fragment.app.z.g
        public void b(Fragment fragment, x.b bVar) {
            if (bVar.b()) {
                return;
            }
            o.this.c1(fragment, bVar);
        }
    }

    public class e extends androidx.fragment.app.k {
        public e() {
        }

        @Override // androidx.fragment.app.k
        public Fragment a(ClassLoader classLoader, String str) {
            return o.this.t0().b(o.this.t0().f(), str, null);
        }
    }

    public class f implements k0 {
        public f() {
        }

        @Override // androidx.fragment.app.k0
        public j0 a(ViewGroup viewGroup) {
            return new androidx.fragment.app.c(viewGroup);
        }
    }

    public class g implements Runnable {
        public g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            o.this.a0(true);
        }
    }

    public class h extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ViewGroup f2371a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f2372b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Fragment f2373c;

        public h(ViewGroup viewGroup, View view, Fragment fragment) {
            this.f2371a = viewGroup;
            this.f2372b = view;
            this.f2373c = fragment;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f2371a.endViewTransition(this.f2372b);
            animator.removeListener(this);
            Fragment fragment = this.f2373c;
            View view = fragment.mView;
            if (view == null || !fragment.mHidden) {
                return;
            }
            view.setVisibility(8);
        }
    }

    public class i implements s {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Fragment f2375a;

        public i(Fragment fragment) {
            this.f2375a = fragment;
        }

        @Override // androidx.fragment.app.s
        public void a(o oVar, Fragment fragment) {
            this.f2375a.onAttachFragment(fragment);
        }
    }

    public class j implements androidx.activity.result.b {
        public j() {
        }

        @Override // androidx.activity.result.b
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(androidx.activity.result.a aVar) {
            l lVar = (l) o.this.C.pollFirst();
            if (lVar == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("No Activities were started for result for ");
                sb.append(this);
                return;
            }
            String str = lVar.f2378a;
            int i10 = lVar.f2379b;
            Fragment i11 = o.this.f2340c.i(str);
            if (i11 != null) {
                i11.onActivityResult(i10, aVar.b(), aVar.a());
                return;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Activity result delivered for unknown Fragment ");
            sb2.append(str);
        }
    }

    public static class k extends c.a {
        @Override // c.a
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public Intent a(Context context, androidx.activity.result.e eVar) {
            Bundle bundleExtra;
            Intent intent = new Intent("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST");
            Intent a10 = eVar.a();
            if (a10 != null && (bundleExtra = a10.getBundleExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE")) != null) {
                intent.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundleExtra);
                a10.removeExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
                if (a10.getBooleanExtra("androidx.fragment.extra.ACTIVITY_OPTIONS_BUNDLE", false)) {
                    eVar = new e.b(eVar.d()).b(null).c(eVar.c(), eVar.b()).a();
                }
            }
            intent.putExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST", eVar);
            if (o.F0(2)) {
                StringBuilder sb = new StringBuilder();
                sb.append("CreateIntent created the following intent: ");
                sb.append(intent);
            }
            return intent;
        }

        @Override // c.a
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public androidx.activity.result.a c(int i10, Intent intent) {
            return new androidx.activity.result.a(i10, intent);
        }
    }

    public interface m {
        boolean a(ArrayList arrayList, ArrayList arrayList2);
    }

    public class n implements m {

        /* renamed from: a, reason: collision with root package name */
        public final String f2380a;

        /* renamed from: b, reason: collision with root package name */
        public final int f2381b;

        /* renamed from: c, reason: collision with root package name */
        public final int f2382c;

        public n(String str, int i10, int i11) {
            this.f2380a = str;
            this.f2381b = i10;
            this.f2382c = i11;
        }

        @Override // androidx.fragment.app.o.m
        public boolean a(ArrayList arrayList, ArrayList arrayList2) {
            Fragment fragment = o.this.f2358u;
            if (fragment == null || this.f2381b >= 0 || this.f2380a != null || !fragment.getChildFragmentManager().X0()) {
                return o.this.Z0(arrayList, arrayList2, this.f2380a, this.f2381b, this.f2382c);
            }
            return false;
        }
    }

    /* renamed from: androidx.fragment.app.o$o, reason: collision with other inner class name */
    public static class C0033o implements Fragment.l {

        /* renamed from: a, reason: collision with root package name */
        public final boolean f2384a;

        /* renamed from: b, reason: collision with root package name */
        public final androidx.fragment.app.a f2385b;

        /* renamed from: c, reason: collision with root package name */
        public int f2386c;

        public C0033o(androidx.fragment.app.a aVar, boolean z10) {
            this.f2384a = z10;
            this.f2385b = aVar;
        }

        @Override // androidx.fragment.app.Fragment.l
        public void a() {
            this.f2386c++;
        }

        @Override // androidx.fragment.app.Fragment.l
        public void b() {
            int i10 = this.f2386c - 1;
            this.f2386c = i10;
            if (i10 != 0) {
                return;
            }
            this.f2385b.f2173t.l1();
        }

        public void c() {
            androidx.fragment.app.a aVar = this.f2385b;
            aVar.f2173t.t(aVar, this.f2384a, false, false);
        }

        public void d() {
            boolean z10 = this.f2386c > 0;
            for (Fragment fragment : this.f2385b.f2173t.s0()) {
                fragment.setOnStartEnterTransitionListener(null);
                if (z10 && fragment.isPostponed()) {
                    fragment.startPostponedEnterTransition();
                }
            }
            androidx.fragment.app.a aVar = this.f2385b;
            aVar.f2173t.t(aVar, this.f2384a, !z10, true);
        }

        public boolean e() {
            return this.f2386c == 0;
        }
    }

    public static boolean F0(int i10) {
        return O || Log.isLoggable("FragmentManager", i10);
    }

    public static void c0(ArrayList arrayList, ArrayList arrayList2, int i10, int i11) {
        while (i10 < i11) {
            androidx.fragment.app.a aVar = (androidx.fragment.app.a) arrayList.get(i10);
            if (((Boolean) arrayList2.get(i10)).booleanValue()) {
                aVar.v(-1);
                aVar.A(i10 == i11 + (-1));
            } else {
                aVar.v(1);
                aVar.z();
            }
            i10++;
        }
    }

    public static int i1(int i10) {
        if (i10 == 4097) {
            return q.a.f10539s;
        }
        if (i10 == 4099) {
            return q.a.f10523c;
        }
        if (i10 != 8194) {
            return 0;
        }
        return q.a.f10521a;
    }

    public static Fragment z0(View view) {
        Object tag = view.getTag(R$id.fragment_container_view_tag);
        if (tag instanceof Fragment) {
            return (Fragment) tag;
        }
        return null;
    }

    public void A(Configuration configuration) {
        for (Fragment fragment : this.f2340c.n()) {
            if (fragment != null) {
                fragment.performConfigurationChanged(configuration);
            }
        }
    }

    public androidx.lifecycle.x A0(Fragment fragment) {
        return this.M.l(fragment);
    }

    public boolean B(MenuItem menuItem) {
        if (this.f2354q < 1) {
            return false;
        }
        for (Fragment fragment : this.f2340c.n()) {
            if (fragment != null && fragment.performContextItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public void B0() {
        a0(true);
        if (this.f2345h.c()) {
            X0();
        } else {
            this.f2344g.c();
        }
    }

    public void C() {
        this.E = false;
        this.F = false;
        this.M.o(false);
        S(1);
    }

    public void C0(Fragment fragment) {
        if (F0(2)) {
            StringBuilder sb = new StringBuilder();
            sb.append("hide: ");
            sb.append(fragment);
        }
        if (fragment.mHidden) {
            return;
        }
        fragment.mHidden = true;
        fragment.mHiddenChanged = true ^ fragment.mHiddenChanged;
        p1(fragment);
    }

    public boolean D(Menu menu, MenuInflater menuInflater) {
        if (this.f2354q < 1) {
            return false;
        }
        ArrayList arrayList = null;
        boolean z10 = false;
        for (Fragment fragment : this.f2340c.n()) {
            if (fragment != null && H0(fragment) && fragment.performCreateOptionsMenu(menu, menuInflater)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(fragment);
                z10 = true;
            }
        }
        if (this.f2342e != null) {
            for (int i10 = 0; i10 < this.f2342e.size(); i10++) {
                Fragment fragment2 = (Fragment) this.f2342e.get(i10);
                if (arrayList == null || !arrayList.contains(fragment2)) {
                    fragment2.onDestroyOptionsMenu();
                }
            }
        }
        this.f2342e = arrayList;
        return z10;
    }

    public void D0(Fragment fragment) {
        if (fragment.mAdded && G0(fragment)) {
            this.D = true;
        }
    }

    public void E() {
        this.G = true;
        a0(true);
        X();
        S(-1);
        this.f2355r = null;
        this.f2356s = null;
        this.f2357t = null;
        if (this.f2344g != null) {
            this.f2345h.d();
            this.f2344g = null;
        }
        androidx.activity.result.c cVar = this.f2363z;
        if (cVar != null) {
            cVar.c();
            this.A.c();
            this.B.c();
        }
    }

    public boolean E0() {
        return this.G;
    }

    public void F() {
        S(1);
    }

    public void G() {
        for (Fragment fragment : this.f2340c.n()) {
            if (fragment != null) {
                fragment.performLowMemory();
            }
        }
    }

    public final boolean G0(Fragment fragment) {
        return (fragment.mHasMenu && fragment.mMenuVisible) || fragment.mChildFragmentManager.o();
    }

    public void H(boolean z10) {
        for (Fragment fragment : this.f2340c.n()) {
            if (fragment != null) {
                fragment.performMultiWindowModeChanged(z10);
            }
        }
    }

    public boolean H0(Fragment fragment) {
        if (fragment == null) {
            return true;
        }
        return fragment.isMenuVisible();
    }

    public void I(Fragment fragment) {
        Iterator it = this.f2353p.iterator();
        while (it.hasNext()) {
            ((s) it.next()).a(this, fragment);
        }
    }

    public boolean I0(Fragment fragment) {
        if (fragment == null) {
            return true;
        }
        o oVar = fragment.mFragmentManager;
        return fragment.equals(oVar.x0()) && I0(oVar.f2357t);
    }

    public boolean J(MenuItem menuItem) {
        if (this.f2354q < 1) {
            return false;
        }
        for (Fragment fragment : this.f2340c.n()) {
            if (fragment != null && fragment.performOptionsItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public boolean J0(int i10) {
        return this.f2354q >= i10;
    }

    public void K(Menu menu) {
        if (this.f2354q < 1) {
            return;
        }
        for (Fragment fragment : this.f2340c.n()) {
            if (fragment != null) {
                fragment.performOptionsMenuClosed(menu);
            }
        }
    }

    public boolean K0() {
        return this.E || this.F;
    }

    public final void L(Fragment fragment) {
        if (fragment == null || !fragment.equals(f0(fragment.mWho))) {
            return;
        }
        fragment.performPrimaryNavigationFragmentChanged();
    }

    public void L0(Fragment fragment, String[] strArr, int i10) {
        if (this.B == null) {
            this.f2355r.k(fragment, strArr, i10);
            return;
        }
        this.C.addLast(new l(fragment.mWho, i10));
        this.B.a(strArr);
    }

    public void M() {
        S(5);
    }

    public void M0(Fragment fragment, Intent intent, int i10, Bundle bundle) {
        if (this.f2363z == null) {
            this.f2355r.n(fragment, intent, i10, bundle);
            return;
        }
        this.C.addLast(new l(fragment.mWho, i10));
        if (intent != null && bundle != null) {
            intent.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundle);
        }
        this.f2363z.a(intent);
    }

    public void N(boolean z10) {
        for (Fragment fragment : this.f2340c.n()) {
            if (fragment != null) {
                fragment.performPictureInPictureModeChanged(z10);
            }
        }
    }

    public void N0(Fragment fragment, IntentSender intentSender, int i10, Intent intent, int i11, int i12, int i13, Bundle bundle) {
        Intent intent2;
        if (this.A == null) {
            this.f2355r.o(fragment, intentSender, i10, intent, i11, i12, i13, bundle);
            return;
        }
        if (bundle != null) {
            if (intent == null) {
                intent2 = new Intent();
                intent2.putExtra("androidx.fragment.extra.ACTIVITY_OPTIONS_BUNDLE", true);
            } else {
                intent2 = intent;
            }
            if (F0(2)) {
                StringBuilder sb = new StringBuilder();
                sb.append("ActivityOptions ");
                sb.append(bundle);
                sb.append(" were added to fillInIntent ");
                sb.append(intent2);
                sb.append(" for fragment ");
                sb.append(fragment);
            }
            intent2.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundle);
        } else {
            intent2 = intent;
        }
        androidx.activity.result.e a10 = new e.b(intentSender).b(intent2).c(i12, i11).a();
        this.C.addLast(new l(fragment.mWho, i10));
        if (F0(2)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Fragment ");
            sb2.append(fragment);
            sb2.append("is launching an IntentSender for result ");
        }
        this.A.a(a10);
    }

    public boolean O(Menu menu) {
        boolean z10 = false;
        if (this.f2354q < 1) {
            return false;
        }
        for (Fragment fragment : this.f2340c.n()) {
            if (fragment != null && H0(fragment) && fragment.performPrepareOptionsMenu(menu)) {
                z10 = true;
            }
        }
        return z10;
    }

    public final void O0(androidx.collection.b bVar) {
        int size = bVar.size();
        for (int i10 = 0; i10 < size; i10++) {
            Fragment fragment = (Fragment) bVar.h(i10);
            if (!fragment.mAdded) {
                View requireView = fragment.requireView();
                fragment.mPostponedAlpha = requireView.getAlpha();
                requireView.setAlpha(0.0f);
            }
        }
    }

    public void P() {
        t1();
        L(this.f2358u);
    }

    public void P0(Fragment fragment) {
        if (!this.f2340c.c(fragment.mWho)) {
            if (F0(3)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Ignoring moving ");
                sb.append(fragment);
                sb.append(" to state ");
                sb.append(this.f2354q);
                sb.append("since it is not added to ");
                sb.append(this);
                return;
            }
            return;
        }
        R0(fragment);
        View view = fragment.mView;
        if (view != null && fragment.mIsNewlyAdded && fragment.mContainer != null) {
            float f10 = fragment.mPostponedAlpha;
            if (f10 > 0.0f) {
                view.setAlpha(f10);
            }
            fragment.mPostponedAlpha = 0.0f;
            fragment.mIsNewlyAdded = false;
            f.d c10 = androidx.fragment.app.f.c(this.f2355r.f(), fragment, true, fragment.getPopDirection());
            if (c10 != null) {
                Animation animation = c10.f2252a;
                if (animation != null) {
                    fragment.mView.startAnimation(animation);
                } else {
                    c10.f2253b.setTarget(fragment.mView);
                    c10.f2253b.start();
                }
            }
        }
        if (fragment.mHiddenChanged) {
            u(fragment);
        }
    }

    public void Q() {
        this.E = false;
        this.F = false;
        this.M.o(false);
        S(7);
    }

    public void Q0(int i10, boolean z10) {
        androidx.fragment.app.l lVar;
        if (this.f2355r == null && i10 != -1) {
            throw new IllegalStateException("No activity");
        }
        if (z10 || i10 != this.f2354q) {
            this.f2354q = i10;
            if (P) {
                this.f2340c.r();
            } else {
                Iterator it = this.f2340c.n().iterator();
                while (it.hasNext()) {
                    P0((Fragment) it.next());
                }
                for (v vVar : this.f2340c.k()) {
                    Fragment k10 = vVar.k();
                    if (!k10.mIsNewlyAdded) {
                        P0(k10);
                    }
                    if (k10.mRemoving && !k10.isInBackStack()) {
                        this.f2340c.q(vVar);
                    }
                }
            }
            r1();
            if (this.D && (lVar = this.f2355r) != null && this.f2354q == 7) {
                lVar.p();
                this.D = false;
            }
        }
    }

    public void R() {
        this.E = false;
        this.F = false;
        this.M.o(false);
        S(5);
    }

    public void R0(Fragment fragment) {
        S0(fragment, this.f2354q);
    }

    public final void S(int i10) {
        try {
            this.f2339b = true;
            this.f2340c.d(i10);
            Q0(i10, false);
            if (P) {
                Iterator it = r().iterator();
                while (it.hasNext()) {
                    ((j0) it.next()).j();
                }
            }
            this.f2339b = false;
            a0(true);
        } catch (Throwable th) {
            this.f2339b = false;
            throw th;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0051, code lost:
    
        if (r2 != 5) goto L102;
     */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0066  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void S0(androidx.fragment.app.Fragment r10, int r11) {
        /*
            Method dump skipped, instructions count: 385
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.o.S0(androidx.fragment.app.Fragment, int):void");
    }

    public void T() {
        this.F = true;
        this.M.o(true);
        S(4);
    }

    public void T0() {
        if (this.f2355r == null) {
            return;
        }
        this.E = false;
        this.F = false;
        this.M.o(false);
        for (Fragment fragment : this.f2340c.n()) {
            if (fragment != null) {
                fragment.noteStateNotSaved();
            }
        }
    }

    public void U() {
        S(2);
    }

    public void U0(androidx.fragment.app.i iVar) {
        View view;
        for (v vVar : this.f2340c.k()) {
            Fragment k10 = vVar.k();
            if (k10.mContainerId == iVar.getId() && (view = k10.mView) != null && view.getParent() == null) {
                k10.mContainer = iVar;
                vVar.b();
            }
        }
    }

    public final void V() {
        if (this.H) {
            this.H = false;
            r1();
        }
    }

    public void V0(v vVar) {
        Fragment k10 = vVar.k();
        if (k10.mDeferStart) {
            if (this.f2339b) {
                this.H = true;
                return;
            }
            k10.mDeferStart = false;
            if (P) {
                vVar.m();
            } else {
                R0(k10);
            }
        }
    }

    public void W(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        int size2;
        String str2 = str + "    ";
        this.f2340c.e(str, fileDescriptor, printWriter, strArr);
        ArrayList arrayList = this.f2342e;
        if (arrayList != null && (size2 = arrayList.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Fragments Created Menus:");
            for (int i10 = 0; i10 < size2; i10++) {
                Fragment fragment = (Fragment) this.f2342e.get(i10);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i10);
                printWriter.print(": ");
                printWriter.println(fragment.toString());
            }
        }
        ArrayList arrayList2 = this.f2341d;
        if (arrayList2 != null && (size = arrayList2.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Back Stack:");
            for (int i11 = 0; i11 < size; i11++) {
                androidx.fragment.app.a aVar = (androidx.fragment.app.a) this.f2341d.get(i11);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i11);
                printWriter.print(": ");
                printWriter.println(aVar.toString());
                aVar.x(str2, printWriter);
            }
        }
        printWriter.print(str);
        printWriter.println("Back Stack Index: " + this.f2346i.get());
        synchronized (this.f2338a) {
            int size3 = this.f2338a.size();
            if (size3 > 0) {
                printWriter.print(str);
                printWriter.println("Pending Actions:");
                for (int i12 = 0; i12 < size3; i12++) {
                    m mVar = (m) this.f2338a.get(i12);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i12);
                    printWriter.print(": ");
                    printWriter.println(mVar);
                }
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mHost=");
        printWriter.println(this.f2355r);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.f2356s);
        if (this.f2357t != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.f2357t);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.f2354q);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.E);
        printWriter.print(" mStopped=");
        printWriter.print(this.F);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.G);
        if (this.D) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.D);
        }
    }

    public void W0(int i10, int i11) {
        if (i10 >= 0) {
            Y(new n(null, i10, i11), false);
            return;
        }
        throw new IllegalArgumentException("Bad id: " + i10);
    }

    public final void X() {
        if (P) {
            Iterator it = r().iterator();
            while (it.hasNext()) {
                ((j0) it.next()).j();
            }
        } else {
            if (this.f2350m.isEmpty()) {
                return;
            }
            for (Fragment fragment : this.f2350m.keySet()) {
                n(fragment);
                R0(fragment);
            }
        }
    }

    public boolean X0() {
        return Y0(null, -1, 0);
    }

    public void Y(m mVar, boolean z10) {
        if (!z10) {
            if (this.f2355r == null) {
                if (!this.G) {
                    throw new IllegalStateException("FragmentManager has not been attached to a host.");
                }
                throw new IllegalStateException("FragmentManager has been destroyed");
            }
            p();
        }
        synchronized (this.f2338a) {
            if (this.f2355r == null) {
                if (!z10) {
                    throw new IllegalStateException("Activity has been destroyed");
                }
            } else {
                this.f2338a.add(mVar);
                l1();
            }
        }
    }

    public final boolean Y0(String str, int i10, int i11) {
        a0(false);
        Z(true);
        Fragment fragment = this.f2358u;
        if (fragment != null && i10 < 0 && str == null && fragment.getChildFragmentManager().X0()) {
            return true;
        }
        boolean Z0 = Z0(this.I, this.J, str, i10, i11);
        if (Z0) {
            this.f2339b = true;
            try {
                e1(this.I, this.J);
            } finally {
                q();
            }
        }
        t1();
        V();
        this.f2340c.b();
        return Z0;
    }

    public final void Z(boolean z10) {
        if (this.f2339b) {
            throw new IllegalStateException("FragmentManager is already executing transactions");
        }
        if (this.f2355r == null) {
            if (!this.G) {
                throw new IllegalStateException("FragmentManager has not been attached to a host.");
            }
            throw new IllegalStateException("FragmentManager has been destroyed");
        }
        if (Looper.myLooper() != this.f2355r.g().getLooper()) {
            throw new IllegalStateException("Must be called from main thread of fragment host");
        }
        if (!z10) {
            p();
        }
        if (this.I == null) {
            this.I = new ArrayList();
            this.J = new ArrayList();
        }
        this.f2339b = true;
        try {
            e0(null, null);
        } finally {
            this.f2339b = false;
        }
    }

    public boolean Z0(ArrayList arrayList, ArrayList arrayList2, String str, int i10, int i11) {
        int i12;
        ArrayList arrayList3 = this.f2341d;
        if (arrayList3 == null) {
            return false;
        }
        if (str == null && i10 < 0 && (i11 & 1) == 0) {
            int size = arrayList3.size() - 1;
            if (size < 0) {
                return false;
            }
            arrayList.add(this.f2341d.remove(size));
            arrayList2.add(Boolean.TRUE);
        } else {
            if (str != null || i10 >= 0) {
                int size2 = arrayList3.size() - 1;
                while (size2 >= 0) {
                    androidx.fragment.app.a aVar = (androidx.fragment.app.a) this.f2341d.get(size2);
                    if ((str != null && str.equals(aVar.C())) || (i10 >= 0 && i10 == aVar.f2175v)) {
                        break;
                    }
                    size2--;
                }
                if (size2 < 0) {
                    return false;
                }
                if ((i11 & 1) != 0) {
                    while (true) {
                        size2--;
                        if (size2 < 0) {
                            break;
                        }
                        androidx.fragment.app.a aVar2 = (androidx.fragment.app.a) this.f2341d.get(size2);
                        if (str == null || !str.equals(aVar2.C())) {
                            if (i10 < 0 || i10 != aVar2.f2175v) {
                                break;
                            }
                        }
                    }
                }
                i12 = size2;
            } else {
                i12 = -1;
            }
            if (i12 == this.f2341d.size() - 1) {
                return false;
            }
            for (int size3 = this.f2341d.size() - 1; size3 > i12; size3--) {
                arrayList.add(this.f2341d.remove(size3));
                arrayList2.add(Boolean.TRUE);
            }
        }
        return true;
    }

    public boolean a0(boolean z10) {
        Z(z10);
        boolean z11 = false;
        while (k0(this.I, this.J)) {
            z11 = true;
            this.f2339b = true;
            try {
                e1(this.I, this.J);
            } finally {
                q();
            }
        }
        t1();
        V();
        this.f2340c.b();
        return z11;
    }

    public final int a1(ArrayList arrayList, ArrayList arrayList2, int i10, int i11, androidx.collection.b bVar) {
        int i12 = i11;
        for (int i13 = i11 - 1; i13 >= i10; i13--) {
            androidx.fragment.app.a aVar = (androidx.fragment.app.a) arrayList.get(i13);
            boolean booleanValue = ((Boolean) arrayList2.get(i13)).booleanValue();
            if (aVar.G() && !aVar.E(arrayList, i13 + 1, i11)) {
                if (this.L == null) {
                    this.L = new ArrayList();
                }
                C0033o c0033o = new C0033o(aVar, booleanValue);
                this.L.add(c0033o);
                aVar.I(c0033o);
                if (booleanValue) {
                    aVar.z();
                } else {
                    aVar.A(false);
                }
                i12--;
                if (i13 != i12) {
                    arrayList.remove(i13);
                    arrayList.add(i12, aVar);
                }
                d(bVar);
            }
        }
        return i12;
    }

    public void b0(m mVar, boolean z10) {
        if (z10 && (this.f2355r == null || this.G)) {
            return;
        }
        Z(z10);
        if (mVar.a(this.I, this.J)) {
            this.f2339b = true;
            try {
                e1(this.I, this.J);
            } finally {
                q();
            }
        }
        t1();
        V();
        this.f2340c.b();
    }

    public void b1(Bundle bundle, String str, Fragment fragment) {
        if (fragment.mFragmentManager != this) {
            s1(new IllegalStateException("Fragment " + fragment + " is not currently in the FragmentManager"));
        }
        bundle.putString(str, fragment.mWho);
    }

    public void c1(Fragment fragment, x.b bVar) {
        HashSet hashSet = (HashSet) this.f2350m.get(fragment);
        if (hashSet != null && hashSet.remove(bVar) && hashSet.isEmpty()) {
            this.f2350m.remove(fragment);
            if (fragment.mState < 5) {
                w(fragment);
                R0(fragment);
            }
        }
    }

    public final void d(androidx.collection.b bVar) {
        int i10 = this.f2354q;
        if (i10 < 1) {
            return;
        }
        int min = Math.min(i10, 5);
        for (Fragment fragment : this.f2340c.n()) {
            if (fragment.mState < min) {
                S0(fragment, min);
                if (fragment.mView != null && !fragment.mHidden && fragment.mIsNewlyAdded) {
                    bVar.add(fragment);
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:96:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0143  */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4, types: [boolean, int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void d0(java.util.ArrayList r18, java.util.ArrayList r19, int r20, int r21) {
        /*
            Method dump skipped, instructions count: 450
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.o.d0(java.util.ArrayList, java.util.ArrayList, int, int):void");
    }

    public void d1(Fragment fragment) {
        if (F0(2)) {
            StringBuilder sb = new StringBuilder();
            sb.append("remove: ");
            sb.append(fragment);
            sb.append(" nesting=");
            sb.append(fragment.mBackStackNesting);
        }
        boolean z10 = !fragment.isInBackStack();
        if (!fragment.mDetached || z10) {
            this.f2340c.s(fragment);
            if (G0(fragment)) {
                this.D = true;
            }
            fragment.mRemoving = true;
            p1(fragment);
        }
    }

    public void e(androidx.fragment.app.a aVar) {
        if (this.f2341d == null) {
            this.f2341d = new ArrayList();
        }
        this.f2341d.add(aVar);
    }

    public final void e0(ArrayList arrayList, ArrayList arrayList2) {
        int indexOf;
        int indexOf2;
        ArrayList arrayList3 = this.L;
        int size = arrayList3 == null ? 0 : arrayList3.size();
        int i10 = 0;
        while (i10 < size) {
            C0033o c0033o = (C0033o) this.L.get(i10);
            if (arrayList != null && !c0033o.f2384a && (indexOf2 = arrayList.indexOf(c0033o.f2385b)) != -1 && arrayList2 != null && ((Boolean) arrayList2.get(indexOf2)).booleanValue()) {
                this.L.remove(i10);
                i10--;
                size--;
                c0033o.c();
            } else if (c0033o.e() || (arrayList != null && c0033o.f2385b.E(arrayList, 0, arrayList.size()))) {
                this.L.remove(i10);
                i10--;
                size--;
                if (arrayList == null || c0033o.f2384a || (indexOf = arrayList.indexOf(c0033o.f2385b)) == -1 || arrayList2 == null || !((Boolean) arrayList2.get(indexOf)).booleanValue()) {
                    c0033o.d();
                } else {
                    c0033o.c();
                }
            }
            i10++;
        }
    }

    public final void e1(ArrayList arrayList, ArrayList arrayList2) {
        if (arrayList.isEmpty()) {
            return;
        }
        if (arrayList.size() != arrayList2.size()) {
            throw new IllegalStateException("Internal error with the back stack records");
        }
        e0(arrayList, arrayList2);
        int size = arrayList.size();
        int i10 = 0;
        int i11 = 0;
        while (i10 < size) {
            if (!((androidx.fragment.app.a) arrayList.get(i10)).f2451r) {
                if (i11 != i10) {
                    d0(arrayList, arrayList2, i11, i10);
                }
                i11 = i10 + 1;
                if (((Boolean) arrayList2.get(i10)).booleanValue()) {
                    while (i11 < size && ((Boolean) arrayList2.get(i11)).booleanValue() && !((androidx.fragment.app.a) arrayList.get(i11)).f2451r) {
                        i11++;
                    }
                }
                d0(arrayList, arrayList2, i10, i11);
                i10 = i11 - 1;
            }
            i10++;
        }
        if (i11 != size) {
            d0(arrayList, arrayList2, i11, size);
        }
    }

    public void f(Fragment fragment, x.b bVar) {
        if (this.f2350m.get(fragment) == null) {
            this.f2350m.put(fragment, new HashSet());
        }
        ((HashSet) this.f2350m.get(fragment)).add(bVar);
    }

    public Fragment f0(String str) {
        return this.f2340c.f(str);
    }

    public void f1(Fragment fragment) {
        this.M.n(fragment);
    }

    public v g(Fragment fragment) {
        if (F0(2)) {
            StringBuilder sb = new StringBuilder();
            sb.append("add: ");
            sb.append(fragment);
        }
        v v10 = v(fragment);
        fragment.mFragmentManager = this;
        this.f2340c.p(v10);
        if (!fragment.mDetached) {
            this.f2340c.a(fragment);
            fragment.mRemoving = false;
            if (fragment.mView == null) {
                fragment.mHiddenChanged = false;
            }
            if (G0(fragment)) {
                this.D = true;
            }
        }
        return v10;
    }

    public Fragment g0(int i10) {
        return this.f2340c.g(i10);
    }

    public final void g1() {
        ArrayList arrayList = this.f2349l;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        androidx.appcompat.app.m.a(this.f2349l.get(0));
        throw null;
    }

    public void h(s sVar) {
        this.f2353p.add(sVar);
    }

    public Fragment h0(String str) {
        return this.f2340c.h(str);
    }

    public void h1(Parcelable parcelable) {
        v vVar;
        if (parcelable == null) {
            return;
        }
        q qVar = (q) parcelable;
        if (qVar.f2387a == null) {
            return;
        }
        this.f2340c.t();
        Iterator it = qVar.f2387a.iterator();
        while (it.hasNext()) {
            u uVar = (u) it.next();
            if (uVar != null) {
                Fragment h10 = this.M.h(uVar.f2404b);
                if (h10 != null) {
                    if (F0(2)) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("restoreSaveState: re-attaching retained ");
                        sb.append(h10);
                    }
                    vVar = new v(this.f2352o, this.f2340c, h10, uVar);
                } else {
                    vVar = new v(this.f2352o, this.f2340c, this.f2355r.f().getClassLoader(), q0(), uVar);
                }
                Fragment k10 = vVar.k();
                k10.mFragmentManager = this;
                if (F0(2)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("restoreSaveState: active (");
                    sb2.append(k10.mWho);
                    sb2.append("): ");
                    sb2.append(k10);
                }
                vVar.o(this.f2355r.f().getClassLoader());
                this.f2340c.p(vVar);
                vVar.u(this.f2354q);
            }
        }
        for (Fragment fragment : this.M.k()) {
            if (!this.f2340c.c(fragment.mWho)) {
                if (F0(2)) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("Discarding retained Fragment ");
                    sb3.append(fragment);
                    sb3.append(" that was not found in the set of active Fragments ");
                    sb3.append(qVar.f2387a);
                }
                this.M.n(fragment);
                fragment.mFragmentManager = this;
                v vVar2 = new v(this.f2352o, this.f2340c, fragment);
                vVar2.u(1);
                vVar2.m();
                fragment.mRemoving = true;
                vVar2.m();
            }
        }
        this.f2340c.u(qVar.f2388b);
        if (qVar.f2389c != null) {
            this.f2341d = new ArrayList(qVar.f2389c.length);
            int i10 = 0;
            while (true) {
                androidx.fragment.app.b[] bVarArr = qVar.f2389c;
                if (i10 >= bVarArr.length) {
                    break;
                }
                androidx.fragment.app.a a10 = bVarArr[i10].a(this);
                if (F0(2)) {
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("restoreAllState: back stack #");
                    sb4.append(i10);
                    sb4.append(" (index ");
                    sb4.append(a10.f2175v);
                    sb4.append("): ");
                    sb4.append(a10);
                    PrintWriter printWriter = new PrintWriter(new i0("FragmentManager"));
                    a10.y("  ", printWriter, false);
                    printWriter.close();
                }
                this.f2341d.add(a10);
                i10++;
            }
        } else {
            this.f2341d = null;
        }
        this.f2346i.set(qVar.f2390d);
        String str = qVar.f2391e;
        if (str != null) {
            Fragment f02 = f0(str);
            this.f2358u = f02;
            L(f02);
        }
        ArrayList arrayList = qVar.f2392f;
        if (arrayList != null) {
            for (int i11 = 0; i11 < arrayList.size(); i11++) {
                Bundle bundle = (Bundle) qVar.f2393g.get(i11);
                bundle.setClassLoader(this.f2355r.f().getClassLoader());
                this.f2347j.put(arrayList.get(i11), bundle);
            }
        }
        this.C = new ArrayDeque(qVar.f2394h);
    }

    public void i(Fragment fragment) {
        this.M.f(fragment);
    }

    public Fragment i0(String str) {
        return this.f2340c.i(str);
    }

    public int j() {
        return this.f2346i.getAndIncrement();
    }

    public final void j0() {
        if (P) {
            Iterator it = r().iterator();
            while (it.hasNext()) {
                ((j0) it.next()).k();
            }
        } else if (this.L != null) {
            while (!this.L.isEmpty()) {
                ((C0033o) this.L.remove(0)).d();
            }
        }
    }

    public Parcelable j1() {
        int size;
        j0();
        X();
        a0(true);
        this.E = true;
        this.M.o(true);
        ArrayList v10 = this.f2340c.v();
        androidx.fragment.app.b[] bVarArr = null;
        if (v10.isEmpty()) {
            F0(2);
            return null;
        }
        ArrayList w10 = this.f2340c.w();
        ArrayList arrayList = this.f2341d;
        if (arrayList != null && (size = arrayList.size()) > 0) {
            bVarArr = new androidx.fragment.app.b[size];
            for (int i10 = 0; i10 < size; i10++) {
                bVarArr[i10] = new androidx.fragment.app.b((androidx.fragment.app.a) this.f2341d.get(i10));
                if (F0(2)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("saveAllState: adding back stack #");
                    sb.append(i10);
                    sb.append(": ");
                    sb.append(this.f2341d.get(i10));
                }
            }
        }
        q qVar = new q();
        qVar.f2387a = v10;
        qVar.f2388b = w10;
        qVar.f2389c = bVarArr;
        qVar.f2390d = this.f2346i.get();
        Fragment fragment = this.f2358u;
        if (fragment != null) {
            qVar.f2391e = fragment.mWho;
        }
        qVar.f2392f.addAll(this.f2347j.keySet());
        qVar.f2393g.addAll(this.f2347j.values());
        qVar.f2394h = new ArrayList(this.C);
        return qVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void k(androidx.fragment.app.l lVar, androidx.fragment.app.g gVar, Fragment fragment) {
        String str;
        if (this.f2355r != null) {
            throw new IllegalStateException("Already attached");
        }
        this.f2355r = lVar;
        this.f2356s = gVar;
        this.f2357t = fragment;
        if (fragment != null) {
            h(new i(fragment));
        } else if (lVar instanceof s) {
            h((s) lVar);
        }
        if (this.f2357t != null) {
            t1();
        }
        if (lVar instanceof androidx.activity.c) {
            androidx.activity.c cVar = (androidx.activity.c) lVar;
            OnBackPressedDispatcher onBackPressedDispatcher = cVar.getOnBackPressedDispatcher();
            this.f2344g = onBackPressedDispatcher;
            androidx.lifecycle.g gVar2 = cVar;
            if (fragment != null) {
                gVar2 = fragment;
            }
            onBackPressedDispatcher.a(gVar2, this.f2345h);
        }
        if (fragment != null) {
            this.M = fragment.mFragmentManager.m0(fragment);
        } else if (lVar instanceof androidx.lifecycle.y) {
            this.M = r.j(((androidx.lifecycle.y) lVar).getViewModelStore());
        } else {
            this.M = new r(false);
        }
        this.M.o(K0());
        this.f2340c.x(this.M);
        Object obj = this.f2355r;
        if (obj instanceof androidx.activity.result.d) {
            ActivityResultRegistry activityResultRegistry = ((androidx.activity.result.d) obj).getActivityResultRegistry();
            if (fragment != null) {
                str = fragment.mWho + SOAP.DELIM;
            } else {
                str = "";
            }
            String str2 = "FragmentManager:" + str;
            this.f2363z = activityResultRegistry.j(str2 + "StartActivityForResult", new c.c(), new j());
            this.A = activityResultRegistry.j(str2 + "StartIntentSenderForResult", new k(), new a());
            this.B = activityResultRegistry.j(str2 + "RequestPermissions", new c.b(), new b());
        }
    }

    public final boolean k0(ArrayList arrayList, ArrayList arrayList2) {
        synchronized (this.f2338a) {
            if (this.f2338a.isEmpty()) {
                return false;
            }
            int size = this.f2338a.size();
            boolean z10 = false;
            for (int i10 = 0; i10 < size; i10++) {
                z10 |= ((m) this.f2338a.get(i10)).a(arrayList, arrayList2);
            }
            this.f2338a.clear();
            this.f2355r.g().removeCallbacks(this.N);
            return z10;
        }
    }

    public Fragment.m k1(Fragment fragment) {
        v m10 = this.f2340c.m(fragment.mWho);
        if (m10 == null || !m10.k().equals(fragment)) {
            s1(new IllegalStateException("Fragment " + fragment + " is not currently in the FragmentManager"));
        }
        return m10.r();
    }

    public void l(Fragment fragment) {
        if (F0(2)) {
            StringBuilder sb = new StringBuilder();
            sb.append("attach: ");
            sb.append(fragment);
        }
        if (fragment.mDetached) {
            fragment.mDetached = false;
            if (fragment.mAdded) {
                return;
            }
            this.f2340c.a(fragment);
            if (F0(2)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("add from attach: ");
                sb2.append(fragment);
            }
            if (G0(fragment)) {
                this.D = true;
            }
        }
    }

    public int l0() {
        ArrayList arrayList = this.f2341d;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    public void l1() {
        synchronized (this.f2338a) {
            ArrayList arrayList = this.L;
            boolean z10 = (arrayList == null || arrayList.isEmpty()) ? false : true;
            boolean z11 = this.f2338a.size() == 1;
            if (z10 || z11) {
                this.f2355r.g().removeCallbacks(this.N);
                this.f2355r.g().post(this.N);
                t1();
            }
        }
    }

    public y m() {
        return new androidx.fragment.app.a(this);
    }

    public final r m0(Fragment fragment) {
        return this.M.i(fragment);
    }

    public void m1(Fragment fragment, boolean z10) {
        ViewGroup p02 = p0(fragment);
        if (p02 == null || !(p02 instanceof androidx.fragment.app.i)) {
            return;
        }
        ((androidx.fragment.app.i) p02).setDrawDisappearingViewsLast(!z10);
    }

    public final void n(Fragment fragment) {
        HashSet hashSet = (HashSet) this.f2350m.get(fragment);
        if (hashSet != null) {
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                ((x.b) it.next()).a();
            }
            hashSet.clear();
            w(fragment);
            this.f2350m.remove(fragment);
        }
    }

    public androidx.fragment.app.g n0() {
        return this.f2356s;
    }

    public void n1(Fragment fragment, d.c cVar) {
        if (fragment.equals(f0(fragment.mWho)) && (fragment.mHost == null || fragment.mFragmentManager == this)) {
            fragment.mMaxState = cVar;
            return;
        }
        throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
    }

    public boolean o() {
        boolean z10 = false;
        for (Fragment fragment : this.f2340c.l()) {
            if (fragment != null) {
                z10 = G0(fragment);
            }
            if (z10) {
                return true;
            }
        }
        return false;
    }

    public Fragment o0(Bundle bundle, String str) {
        String string = bundle.getString(str);
        if (string == null) {
            return null;
        }
        Fragment f02 = f0(string);
        if (f02 == null) {
            s1(new IllegalStateException("Fragment no longer exists for key " + str + ": unique id " + string));
        }
        return f02;
    }

    public void o1(Fragment fragment) {
        if (fragment == null || (fragment.equals(f0(fragment.mWho)) && (fragment.mHost == null || fragment.mFragmentManager == this))) {
            Fragment fragment2 = this.f2358u;
            this.f2358u = fragment;
            L(fragment2);
            L(this.f2358u);
            return;
        }
        throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
    }

    public final void p() {
        if (K0()) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
    }

    public final ViewGroup p0(Fragment fragment) {
        ViewGroup viewGroup = fragment.mContainer;
        if (viewGroup != null) {
            return viewGroup;
        }
        if (fragment.mContainerId > 0 && this.f2356s.d()) {
            View c10 = this.f2356s.c(fragment.mContainerId);
            if (c10 instanceof ViewGroup) {
                return (ViewGroup) c10;
            }
        }
        return null;
    }

    public final void p1(Fragment fragment) {
        ViewGroup p02 = p0(fragment);
        if (p02 == null || fragment.getEnterAnim() + fragment.getExitAnim() + fragment.getPopEnterAnim() + fragment.getPopExitAnim() <= 0) {
            return;
        }
        int i10 = R$id.visible_removing_fragment_view_tag;
        if (p02.getTag(i10) == null) {
            p02.setTag(i10, fragment);
        }
        ((Fragment) p02.getTag(i10)).setPopDirection(fragment.getPopDirection());
    }

    public final void q() {
        this.f2339b = false;
        this.J.clear();
        this.I.clear();
    }

    public androidx.fragment.app.k q0() {
        androidx.fragment.app.k kVar = this.f2359v;
        if (kVar != null) {
            return kVar;
        }
        Fragment fragment = this.f2357t;
        return fragment != null ? fragment.mFragmentManager.q0() : this.f2360w;
    }

    public void q1(Fragment fragment) {
        if (F0(2)) {
            StringBuilder sb = new StringBuilder();
            sb.append("show: ");
            sb.append(fragment);
        }
        if (fragment.mHidden) {
            fragment.mHidden = false;
            fragment.mHiddenChanged = !fragment.mHiddenChanged;
        }
    }

    public final Set r() {
        HashSet hashSet = new HashSet();
        Iterator it = this.f2340c.k().iterator();
        while (it.hasNext()) {
            ViewGroup viewGroup = ((v) it.next()).k().mContainer;
            if (viewGroup != null) {
                hashSet.add(j0.o(viewGroup, y0()));
            }
        }
        return hashSet;
    }

    public x r0() {
        return this.f2340c;
    }

    public final void r1() {
        Iterator it = this.f2340c.k().iterator();
        while (it.hasNext()) {
            V0((v) it.next());
        }
    }

    public final Set s(ArrayList arrayList, int i10, int i11) {
        ViewGroup viewGroup;
        HashSet hashSet = new HashSet();
        while (i10 < i11) {
            Iterator it = ((androidx.fragment.app.a) arrayList.get(i10)).f2436c.iterator();
            while (it.hasNext()) {
                Fragment fragment = ((y.a) it.next()).f2454b;
                if (fragment != null && (viewGroup = fragment.mContainer) != null) {
                    hashSet.add(j0.n(viewGroup, this));
                }
            }
            i10++;
        }
        return hashSet;
    }

    public List s0() {
        return this.f2340c.n();
    }

    public final void s1(RuntimeException runtimeException) {
        Log.e("FragmentManager", runtimeException.getMessage());
        Log.e("FragmentManager", "Activity state:");
        PrintWriter printWriter = new PrintWriter(new i0("FragmentManager"));
        androidx.fragment.app.l lVar = this.f2355r;
        if (lVar != null) {
            try {
                lVar.h("  ", null, printWriter, new String[0]);
                throw runtimeException;
            } catch (Exception e10) {
                Log.e("FragmentManager", "Failed dumping state", e10);
                throw runtimeException;
            }
        }
        try {
            W("  ", null, printWriter, new String[0]);
            throw runtimeException;
        } catch (Exception e11) {
            Log.e("FragmentManager", "Failed dumping state", e11);
            throw runtimeException;
        }
    }

    public void t(androidx.fragment.app.a aVar, boolean z10, boolean z11, boolean z12) {
        if (z10) {
            aVar.A(z12);
        } else {
            aVar.z();
        }
        ArrayList arrayList = new ArrayList(1);
        ArrayList arrayList2 = new ArrayList(1);
        arrayList.add(aVar);
        arrayList2.add(Boolean.valueOf(z10));
        if (z11 && this.f2354q >= 1) {
            z.B(this.f2355r.f(), this.f2356s, arrayList, arrayList2, 0, 1, true, this.f2351n);
        }
        if (z12) {
            Q0(this.f2354q, true);
        }
        for (Fragment fragment : this.f2340c.l()) {
            if (fragment != null && fragment.mView != null && fragment.mIsNewlyAdded && aVar.D(fragment.mContainerId)) {
                float f10 = fragment.mPostponedAlpha;
                if (f10 > 0.0f) {
                    fragment.mView.setAlpha(f10);
                }
                if (z12) {
                    fragment.mPostponedAlpha = 0.0f;
                } else {
                    fragment.mPostponedAlpha = -1.0f;
                    fragment.mIsNewlyAdded = false;
                }
            }
        }
    }

    public androidx.fragment.app.l t0() {
        return this.f2355r;
    }

    public final void t1() {
        synchronized (this.f2338a) {
            if (this.f2338a.isEmpty()) {
                this.f2345h.f(l0() > 0 && I0(this.f2357t));
            } else {
                this.f2345h.f(true);
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        Fragment fragment = this.f2357t;
        if (fragment != null) {
            sb.append(fragment.getClass().getSimpleName());
            sb.append("{");
            sb.append(Integer.toHexString(System.identityHashCode(this.f2357t)));
            sb.append("}");
        } else {
            androidx.fragment.app.l lVar = this.f2355r;
            if (lVar != null) {
                sb.append(lVar.getClass().getSimpleName());
                sb.append("{");
                sb.append(Integer.toHexString(System.identityHashCode(this.f2355r)));
                sb.append("}");
            } else {
                sb.append("null");
            }
        }
        sb.append("}}");
        return sb.toString();
    }

    public final void u(Fragment fragment) {
        Animator animator;
        if (fragment.mView != null) {
            f.d c10 = androidx.fragment.app.f.c(this.f2355r.f(), fragment, !fragment.mHidden, fragment.getPopDirection());
            if (c10 == null || (animator = c10.f2253b) == null) {
                if (c10 != null) {
                    fragment.mView.startAnimation(c10.f2252a);
                    c10.f2252a.start();
                }
                fragment.mView.setVisibility((!fragment.mHidden || fragment.isHideReplaced()) ? 0 : 8);
                if (fragment.isHideReplaced()) {
                    fragment.setHideReplaced(false);
                }
            } else {
                animator.setTarget(fragment.mView);
                if (!fragment.mHidden) {
                    fragment.mView.setVisibility(0);
                } else if (fragment.isHideReplaced()) {
                    fragment.setHideReplaced(false);
                } else {
                    ViewGroup viewGroup = fragment.mContainer;
                    View view = fragment.mView;
                    viewGroup.startViewTransition(view);
                    c10.f2253b.addListener(new h(viewGroup, view, fragment));
                }
                c10.f2253b.start();
            }
        }
        D0(fragment);
        fragment.mHiddenChanged = false;
        fragment.onHiddenChanged(fragment.mHidden);
    }

    public LayoutInflater.Factory2 u0() {
        return this.f2343f;
    }

    public v v(Fragment fragment) {
        v m10 = this.f2340c.m(fragment.mWho);
        if (m10 != null) {
            return m10;
        }
        v vVar = new v(this.f2352o, this.f2340c, fragment);
        vVar.o(this.f2355r.f().getClassLoader());
        vVar.u(this.f2354q);
        return vVar;
    }

    public androidx.fragment.app.n v0() {
        return this.f2352o;
    }

    public final void w(Fragment fragment) {
        fragment.performDestroyView();
        this.f2352o.n(fragment, false);
        fragment.mContainer = null;
        fragment.mView = null;
        fragment.mViewLifecycleOwner = null;
        fragment.mViewLifecycleOwnerLiveData.n(null);
        fragment.mInLayout = false;
    }

    public Fragment w0() {
        return this.f2357t;
    }

    public void x(Fragment fragment) {
        if (F0(2)) {
            StringBuilder sb = new StringBuilder();
            sb.append("detach: ");
            sb.append(fragment);
        }
        if (fragment.mDetached) {
            return;
        }
        fragment.mDetached = true;
        if (fragment.mAdded) {
            if (F0(2)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("remove from detach: ");
                sb2.append(fragment);
            }
            this.f2340c.s(fragment);
            if (G0(fragment)) {
                this.D = true;
            }
            p1(fragment);
        }
    }

    public Fragment x0() {
        return this.f2358u;
    }

    public void y() {
        this.E = false;
        this.F = false;
        this.M.o(false);
        S(4);
    }

    public k0 y0() {
        k0 k0Var = this.f2361x;
        if (k0Var != null) {
            return k0Var;
        }
        Fragment fragment = this.f2357t;
        return fragment != null ? fragment.mFragmentManager.y0() : this.f2362y;
    }

    public void z() {
        this.E = false;
        this.F = false;
        this.M.o(false);
        S(0);
    }

    public static class l implements Parcelable {
        public static final Parcelable.Creator<l> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        public String f2378a;

        /* renamed from: b, reason: collision with root package name */
        public int f2379b;

        public class a implements Parcelable.Creator {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public l createFromParcel(Parcel parcel) {
                return new l(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public l[] newArray(int i10) {
                return new l[i10];
            }
        }

        public l(String str, int i10) {
            this.f2378a = str;
            this.f2379b = i10;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeString(this.f2378a);
            parcel.writeInt(this.f2379b);
        }

        public l(Parcel parcel) {
            this.f2378a = parcel.readString();
            this.f2379b = parcel.readInt();
        }
    }
}
