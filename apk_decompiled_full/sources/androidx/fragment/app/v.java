package androidx.fragment.app;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.fragment.R$id;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.j0;
import androidx.lifecycle.d;
import b0.c1;

/* loaded from: classes.dex */
public class v {

    /* renamed from: a, reason: collision with root package name */
    public final n f2416a;

    /* renamed from: b, reason: collision with root package name */
    public final x f2417b;

    /* renamed from: c, reason: collision with root package name */
    public final Fragment f2418c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f2419d = false;

    /* renamed from: e, reason: collision with root package name */
    public int f2420e = -1;

    public class a implements View.OnAttachStateChangeListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f2421a;

        public a(View view) {
            this.f2421a = view;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            this.f2421a.removeOnAttachStateChangeListener(this);
            c1.h0(this.f2421a);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }

    public static /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f2423a;

        static {
            int[] iArr = new int[d.c.values().length];
            f2423a = iArr;
            try {
                iArr[d.c.RESUMED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2423a[d.c.STARTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f2423a[d.c.CREATED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f2423a[d.c.INITIALIZED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public v(n nVar, x xVar, Fragment fragment) {
        this.f2416a = nVar;
        this.f2417b = xVar;
        this.f2418c = fragment;
    }

    public void a() {
        if (o.F0(3)) {
            StringBuilder sb = new StringBuilder();
            sb.append("moveto ACTIVITY_CREATED: ");
            sb.append(this.f2418c);
        }
        Fragment fragment = this.f2418c;
        fragment.performActivityCreated(fragment.mSavedFragmentState);
        n nVar = this.f2416a;
        Fragment fragment2 = this.f2418c;
        nVar.a(fragment2, fragment2.mSavedFragmentState, false);
    }

    public void b() {
        int j10 = this.f2417b.j(this.f2418c);
        Fragment fragment = this.f2418c;
        fragment.mContainer.addView(fragment.mView, j10);
    }

    public void c() {
        if (o.F0(3)) {
            StringBuilder sb = new StringBuilder();
            sb.append("moveto ATTACHED: ");
            sb.append(this.f2418c);
        }
        Fragment fragment = this.f2418c;
        Fragment fragment2 = fragment.mTarget;
        v vVar = null;
        if (fragment2 != null) {
            v m10 = this.f2417b.m(fragment2.mWho);
            if (m10 == null) {
                throw new IllegalStateException("Fragment " + this.f2418c + " declared target fragment " + this.f2418c.mTarget + " that does not belong to this FragmentManager!");
            }
            Fragment fragment3 = this.f2418c;
            fragment3.mTargetWho = fragment3.mTarget.mWho;
            fragment3.mTarget = null;
            vVar = m10;
        } else {
            String str = fragment.mTargetWho;
            if (str != null && (vVar = this.f2417b.m(str)) == null) {
                throw new IllegalStateException("Fragment " + this.f2418c + " declared target fragment " + this.f2418c.mTargetWho + " that does not belong to this FragmentManager!");
            }
        }
        if (vVar != null && (o.P || vVar.k().mState < 1)) {
            vVar.m();
        }
        Fragment fragment4 = this.f2418c;
        fragment4.mHost = fragment4.mFragmentManager.t0();
        Fragment fragment5 = this.f2418c;
        fragment5.mParentFragment = fragment5.mFragmentManager.w0();
        this.f2416a.g(this.f2418c, false);
        this.f2418c.performAttach();
        this.f2416a.b(this.f2418c, false);
    }

    public int d() {
        Fragment fragment;
        ViewGroup viewGroup;
        Fragment fragment2 = this.f2418c;
        if (fragment2.mFragmentManager == null) {
            return fragment2.mState;
        }
        int i10 = this.f2420e;
        int i11 = b.f2423a[fragment2.mMaxState.ordinal()];
        if (i11 != 1) {
            i10 = i11 != 2 ? i11 != 3 ? i11 != 4 ? Math.min(i10, -1) : Math.min(i10, 0) : Math.min(i10, 1) : Math.min(i10, 5);
        }
        Fragment fragment3 = this.f2418c;
        if (fragment3.mFromLayout) {
            if (fragment3.mInLayout) {
                i10 = Math.max(this.f2420e, 2);
                View view = this.f2418c.mView;
                if (view != null && view.getParent() == null) {
                    i10 = Math.min(i10, 2);
                }
            } else {
                i10 = this.f2420e < 4 ? Math.min(i10, fragment3.mState) : Math.min(i10, 1);
            }
        }
        if (!this.f2418c.mAdded) {
            i10 = Math.min(i10, 1);
        }
        j0.e.b l10 = (!o.P || (viewGroup = (fragment = this.f2418c).mContainer) == null) ? null : j0.n(viewGroup, fragment.getParentFragmentManager()).l(this);
        if (l10 == j0.e.b.ADDING) {
            i10 = Math.min(i10, 6);
        } else if (l10 == j0.e.b.REMOVING) {
            i10 = Math.max(i10, 3);
        } else {
            Fragment fragment4 = this.f2418c;
            if (fragment4.mRemoving) {
                i10 = fragment4.isInBackStack() ? Math.min(i10, 1) : Math.min(i10, -1);
            }
        }
        Fragment fragment5 = this.f2418c;
        if (fragment5.mDeferStart && fragment5.mState < 5) {
            i10 = Math.min(i10, 4);
        }
        if (o.F0(2)) {
            StringBuilder sb = new StringBuilder();
            sb.append("computeExpectedState() of ");
            sb.append(i10);
            sb.append(" for ");
            sb.append(this.f2418c);
        }
        return i10;
    }

    public void e() {
        if (o.F0(3)) {
            StringBuilder sb = new StringBuilder();
            sb.append("moveto CREATED: ");
            sb.append(this.f2418c);
        }
        Fragment fragment = this.f2418c;
        if (fragment.mIsCreated) {
            fragment.restoreChildFragmentState(fragment.mSavedFragmentState);
            this.f2418c.mState = 1;
            return;
        }
        this.f2416a.h(fragment, fragment.mSavedFragmentState, false);
        Fragment fragment2 = this.f2418c;
        fragment2.performCreate(fragment2.mSavedFragmentState);
        n nVar = this.f2416a;
        Fragment fragment3 = this.f2418c;
        nVar.c(fragment3, fragment3.mSavedFragmentState, false);
    }

    public void f() {
        String str;
        if (this.f2418c.mFromLayout) {
            return;
        }
        if (o.F0(3)) {
            StringBuilder sb = new StringBuilder();
            sb.append("moveto CREATE_VIEW: ");
            sb.append(this.f2418c);
        }
        Fragment fragment = this.f2418c;
        LayoutInflater performGetLayoutInflater = fragment.performGetLayoutInflater(fragment.mSavedFragmentState);
        Fragment fragment2 = this.f2418c;
        ViewGroup viewGroup = fragment2.mContainer;
        if (viewGroup == null) {
            int i10 = fragment2.mContainerId;
            if (i10 == 0) {
                viewGroup = null;
            } else {
                if (i10 == -1) {
                    throw new IllegalArgumentException("Cannot create fragment " + this.f2418c + " for a container view with no id");
                }
                viewGroup = (ViewGroup) fragment2.mFragmentManager.n0().c(this.f2418c.mContainerId);
                if (viewGroup == null) {
                    Fragment fragment3 = this.f2418c;
                    if (!fragment3.mRestored) {
                        try {
                            str = fragment3.getResources().getResourceName(this.f2418c.mContainerId);
                        } catch (Resources.NotFoundException unused) {
                            str = "unknown";
                        }
                        throw new IllegalArgumentException("No view found for id 0x" + Integer.toHexString(this.f2418c.mContainerId) + " (" + str + ") for fragment " + this.f2418c);
                    }
                }
            }
        }
        Fragment fragment4 = this.f2418c;
        fragment4.mContainer = viewGroup;
        fragment4.performCreateView(performGetLayoutInflater, viewGroup, fragment4.mSavedFragmentState);
        View view = this.f2418c.mView;
        if (view != null) {
            boolean z10 = false;
            view.setSaveFromParentEnabled(false);
            Fragment fragment5 = this.f2418c;
            fragment5.mView.setTag(R$id.fragment_container_view_tag, fragment5);
            if (viewGroup != null) {
                b();
            }
            Fragment fragment6 = this.f2418c;
            if (fragment6.mHidden) {
                fragment6.mView.setVisibility(8);
            }
            if (c1.P(this.f2418c.mView)) {
                c1.h0(this.f2418c.mView);
            } else {
                View view2 = this.f2418c.mView;
                view2.addOnAttachStateChangeListener(new a(view2));
            }
            this.f2418c.performViewCreated();
            n nVar = this.f2416a;
            Fragment fragment7 = this.f2418c;
            nVar.m(fragment7, fragment7.mView, fragment7.mSavedFragmentState, false);
            int visibility = this.f2418c.mView.getVisibility();
            float alpha = this.f2418c.mView.getAlpha();
            if (o.P) {
                this.f2418c.setPostOnViewCreatedAlpha(alpha);
                Fragment fragment8 = this.f2418c;
                if (fragment8.mContainer != null && visibility == 0) {
                    View findFocus = fragment8.mView.findFocus();
                    if (findFocus != null) {
                        this.f2418c.setFocusedView(findFocus);
                        if (o.F0(2)) {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("requestFocus: Saved focused view ");
                            sb2.append(findFocus);
                            sb2.append(" for Fragment ");
                            sb2.append(this.f2418c);
                        }
                    }
                    this.f2418c.mView.setAlpha(0.0f);
                }
            } else {
                Fragment fragment9 = this.f2418c;
                if (visibility == 0 && fragment9.mContainer != null) {
                    z10 = true;
                }
                fragment9.mIsNewlyAdded = z10;
            }
        }
        this.f2418c.mState = 2;
    }

    public void g() {
        Fragment f10;
        if (o.F0(3)) {
            StringBuilder sb = new StringBuilder();
            sb.append("movefrom CREATED: ");
            sb.append(this.f2418c);
        }
        Fragment fragment = this.f2418c;
        boolean z10 = true;
        boolean z11 = fragment.mRemoving && !fragment.isInBackStack();
        if (!(z11 || this.f2417b.o().p(this.f2418c))) {
            String str = this.f2418c.mTargetWho;
            if (str != null && (f10 = this.f2417b.f(str)) != null && f10.mRetainInstance) {
                this.f2418c.mTarget = f10;
            }
            this.f2418c.mState = 0;
            return;
        }
        l lVar = this.f2418c.mHost;
        if (lVar instanceof androidx.lifecycle.y) {
            z10 = this.f2417b.o().m();
        } else if (lVar.f() instanceof Activity) {
            z10 = true ^ ((Activity) lVar.f()).isChangingConfigurations();
        }
        if (z11 || z10) {
            this.f2417b.o().g(this.f2418c);
        }
        this.f2418c.performDestroy();
        this.f2416a.d(this.f2418c, false);
        for (v vVar : this.f2417b.k()) {
            if (vVar != null) {
                Fragment k10 = vVar.k();
                if (this.f2418c.mWho.equals(k10.mTargetWho)) {
                    k10.mTarget = this.f2418c;
                    k10.mTargetWho = null;
                }
            }
        }
        Fragment fragment2 = this.f2418c;
        String str2 = fragment2.mTargetWho;
        if (str2 != null) {
            fragment2.mTarget = this.f2417b.f(str2);
        }
        this.f2417b.q(this);
    }

    public void h() {
        View view;
        if (o.F0(3)) {
            StringBuilder sb = new StringBuilder();
            sb.append("movefrom CREATE_VIEW: ");
            sb.append(this.f2418c);
        }
        Fragment fragment = this.f2418c;
        ViewGroup viewGroup = fragment.mContainer;
        if (viewGroup != null && (view = fragment.mView) != null) {
            viewGroup.removeView(view);
        }
        this.f2418c.performDestroyView();
        this.f2416a.n(this.f2418c, false);
        Fragment fragment2 = this.f2418c;
        fragment2.mContainer = null;
        fragment2.mView = null;
        fragment2.mViewLifecycleOwner = null;
        fragment2.mViewLifecycleOwnerLiveData.n(null);
        this.f2418c.mInLayout = false;
    }

    public void i() {
        if (o.F0(3)) {
            StringBuilder sb = new StringBuilder();
            sb.append("movefrom ATTACHED: ");
            sb.append(this.f2418c);
        }
        this.f2418c.performDetach();
        boolean z10 = false;
        this.f2416a.e(this.f2418c, false);
        Fragment fragment = this.f2418c;
        fragment.mState = -1;
        fragment.mHost = null;
        fragment.mParentFragment = null;
        fragment.mFragmentManager = null;
        if (fragment.mRemoving && !fragment.isInBackStack()) {
            z10 = true;
        }
        if (z10 || this.f2417b.o().p(this.f2418c)) {
            if (o.F0(3)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("initState called for fragment: ");
                sb2.append(this.f2418c);
            }
            this.f2418c.initState();
        }
    }

    public void j() {
        Fragment fragment = this.f2418c;
        if (fragment.mFromLayout && fragment.mInLayout && !fragment.mPerformedCreateView) {
            if (o.F0(3)) {
                StringBuilder sb = new StringBuilder();
                sb.append("moveto CREATE_VIEW: ");
                sb.append(this.f2418c);
            }
            Fragment fragment2 = this.f2418c;
            fragment2.performCreateView(fragment2.performGetLayoutInflater(fragment2.mSavedFragmentState), null, this.f2418c.mSavedFragmentState);
            View view = this.f2418c.mView;
            if (view != null) {
                view.setSaveFromParentEnabled(false);
                Fragment fragment3 = this.f2418c;
                fragment3.mView.setTag(R$id.fragment_container_view_tag, fragment3);
                Fragment fragment4 = this.f2418c;
                if (fragment4.mHidden) {
                    fragment4.mView.setVisibility(8);
                }
                this.f2418c.performViewCreated();
                n nVar = this.f2416a;
                Fragment fragment5 = this.f2418c;
                nVar.m(fragment5, fragment5.mView, fragment5.mSavedFragmentState, false);
                this.f2418c.mState = 2;
            }
        }
    }

    public Fragment k() {
        return this.f2418c;
    }

    public final boolean l(View view) {
        if (view == this.f2418c.mView) {
            return true;
        }
        for (ViewParent parent = view.getParent(); parent != null; parent = parent.getParent()) {
            if (parent == this.f2418c.mView) {
                return true;
            }
        }
        return false;
    }

    public void m() {
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        ViewGroup viewGroup3;
        if (this.f2419d) {
            if (o.F0(2)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Ignoring re-entrant call to moveToExpectedState() for ");
                sb.append(k());
                return;
            }
            return;
        }
        try {
            this.f2419d = true;
            while (true) {
                int d10 = d();
                Fragment fragment = this.f2418c;
                int i10 = fragment.mState;
                if (d10 == i10) {
                    if (o.P && fragment.mHiddenChanged) {
                        if (fragment.mView != null && (viewGroup = fragment.mContainer) != null) {
                            j0 n10 = j0.n(viewGroup, fragment.getParentFragmentManager());
                            if (this.f2418c.mHidden) {
                                n10.c(this);
                            } else {
                                n10.e(this);
                            }
                        }
                        Fragment fragment2 = this.f2418c;
                        o oVar = fragment2.mFragmentManager;
                        if (oVar != null) {
                            oVar.D0(fragment2);
                        }
                        Fragment fragment3 = this.f2418c;
                        fragment3.mHiddenChanged = false;
                        fragment3.onHiddenChanged(fragment3.mHidden);
                    }
                    return;
                }
                if (d10 <= i10) {
                    switch (i10 - 1) {
                        case -1:
                            i();
                            break;
                        case 0:
                            g();
                            break;
                        case 1:
                            h();
                            this.f2418c.mState = 1;
                            break;
                        case 2:
                            fragment.mInLayout = false;
                            fragment.mState = 2;
                            break;
                        case 3:
                            if (o.F0(3)) {
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append("movefrom ACTIVITY_CREATED: ");
                                sb2.append(this.f2418c);
                            }
                            Fragment fragment4 = this.f2418c;
                            if (fragment4.mView != null && fragment4.mSavedViewState == null) {
                                t();
                            }
                            Fragment fragment5 = this.f2418c;
                            if (fragment5.mView != null && (viewGroup3 = fragment5.mContainer) != null) {
                                j0.n(viewGroup3, fragment5.getParentFragmentManager()).d(this);
                            }
                            this.f2418c.mState = 3;
                            break;
                        case 4:
                            w();
                            break;
                        case 5:
                            fragment.mState = 5;
                            break;
                        case 6:
                            n();
                            break;
                    }
                } else {
                    switch (i10 + 1) {
                        case 0:
                            c();
                            break;
                        case 1:
                            e();
                            break;
                        case 2:
                            j();
                            f();
                            break;
                        case 3:
                            a();
                            break;
                        case 4:
                            if (fragment.mView != null && (viewGroup2 = fragment.mContainer) != null) {
                                j0.n(viewGroup2, fragment.getParentFragmentManager()).b(j0.e.c.b(this.f2418c.mView.getVisibility()), this);
                            }
                            this.f2418c.mState = 4;
                            break;
                        case 5:
                            v();
                            break;
                        case 6:
                            fragment.mState = 6;
                            break;
                        case 7:
                            p();
                            break;
                    }
                }
            }
        } finally {
            this.f2419d = false;
        }
    }

    public void n() {
        if (o.F0(3)) {
            StringBuilder sb = new StringBuilder();
            sb.append("movefrom RESUMED: ");
            sb.append(this.f2418c);
        }
        this.f2418c.performPause();
        this.f2416a.f(this.f2418c, false);
    }

    public void o(ClassLoader classLoader) {
        Bundle bundle = this.f2418c.mSavedFragmentState;
        if (bundle == null) {
            return;
        }
        bundle.setClassLoader(classLoader);
        Fragment fragment = this.f2418c;
        fragment.mSavedViewState = fragment.mSavedFragmentState.getSparseParcelableArray("android:view_state");
        Fragment fragment2 = this.f2418c;
        fragment2.mSavedViewRegistryState = fragment2.mSavedFragmentState.getBundle("android:view_registry_state");
        Fragment fragment3 = this.f2418c;
        fragment3.mTargetWho = fragment3.mSavedFragmentState.getString("android:target_state");
        Fragment fragment4 = this.f2418c;
        if (fragment4.mTargetWho != null) {
            fragment4.mTargetRequestCode = fragment4.mSavedFragmentState.getInt("android:target_req_state", 0);
        }
        Fragment fragment5 = this.f2418c;
        Boolean bool = fragment5.mSavedUserVisibleHint;
        if (bool != null) {
            fragment5.mUserVisibleHint = bool.booleanValue();
            this.f2418c.mSavedUserVisibleHint = null;
        } else {
            fragment5.mUserVisibleHint = fragment5.mSavedFragmentState.getBoolean("android:user_visible_hint", true);
        }
        Fragment fragment6 = this.f2418c;
        if (fragment6.mUserVisibleHint) {
            return;
        }
        fragment6.mDeferStart = true;
    }

    public void p() {
        if (o.F0(3)) {
            StringBuilder sb = new StringBuilder();
            sb.append("moveto RESUMED: ");
            sb.append(this.f2418c);
        }
        View focusedView = this.f2418c.getFocusedView();
        if (focusedView != null && l(focusedView)) {
            boolean requestFocus = focusedView.requestFocus();
            if (o.F0(2)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("requestFocus: Restoring focused view ");
                sb2.append(focusedView);
                sb2.append(" ");
                sb2.append(requestFocus ? "succeeded" : "failed");
                sb2.append(" on Fragment ");
                sb2.append(this.f2418c);
                sb2.append(" resulting in focused view ");
                sb2.append(this.f2418c.mView.findFocus());
            }
        }
        this.f2418c.setFocusedView(null);
        this.f2418c.performResume();
        this.f2416a.i(this.f2418c, false);
        Fragment fragment = this.f2418c;
        fragment.mSavedFragmentState = null;
        fragment.mSavedViewState = null;
        fragment.mSavedViewRegistryState = null;
    }

    public final Bundle q() {
        Bundle bundle = new Bundle();
        this.f2418c.performSaveInstanceState(bundle);
        this.f2416a.j(this.f2418c, bundle, false);
        if (bundle.isEmpty()) {
            bundle = null;
        }
        if (this.f2418c.mView != null) {
            t();
        }
        if (this.f2418c.mSavedViewState != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putSparseParcelableArray("android:view_state", this.f2418c.mSavedViewState);
        }
        if (this.f2418c.mSavedViewRegistryState != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBundle("android:view_registry_state", this.f2418c.mSavedViewRegistryState);
        }
        if (!this.f2418c.mUserVisibleHint) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBoolean("android:user_visible_hint", this.f2418c.mUserVisibleHint);
        }
        return bundle;
    }

    public Fragment.m r() {
        Bundle q10;
        if (this.f2418c.mState <= -1 || (q10 = q()) == null) {
            return null;
        }
        return new Fragment.m(q10);
    }

    public u s() {
        u uVar = new u(this.f2418c);
        Fragment fragment = this.f2418c;
        if (fragment.mState <= -1 || uVar.f2415m != null) {
            uVar.f2415m = fragment.mSavedFragmentState;
        } else {
            Bundle q10 = q();
            uVar.f2415m = q10;
            if (this.f2418c.mTargetWho != null) {
                if (q10 == null) {
                    uVar.f2415m = new Bundle();
                }
                uVar.f2415m.putString("android:target_state", this.f2418c.mTargetWho);
                int i10 = this.f2418c.mTargetRequestCode;
                if (i10 != 0) {
                    uVar.f2415m.putInt("android:target_req_state", i10);
                }
            }
        }
        return uVar;
    }

    public void t() {
        if (this.f2418c.mView == null) {
            return;
        }
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        this.f2418c.mView.saveHierarchyState(sparseArray);
        if (sparseArray.size() > 0) {
            this.f2418c.mSavedViewState = sparseArray;
        }
        Bundle bundle = new Bundle();
        this.f2418c.mViewLifecycleOwner.e(bundle);
        if (bundle.isEmpty()) {
            return;
        }
        this.f2418c.mSavedViewRegistryState = bundle;
    }

    public void u(int i10) {
        this.f2420e = i10;
    }

    public void v() {
        if (o.F0(3)) {
            StringBuilder sb = new StringBuilder();
            sb.append("moveto STARTED: ");
            sb.append(this.f2418c);
        }
        this.f2418c.performStart();
        this.f2416a.k(this.f2418c, false);
    }

    public void w() {
        if (o.F0(3)) {
            StringBuilder sb = new StringBuilder();
            sb.append("movefrom STARTED: ");
            sb.append(this.f2418c);
        }
        this.f2418c.performStop();
        this.f2416a.l(this.f2418c, false);
    }

    public v(n nVar, x xVar, ClassLoader classLoader, k kVar, u uVar) {
        this.f2416a = nVar;
        this.f2417b = xVar;
        Fragment a10 = kVar.a(classLoader, uVar.f2403a);
        this.f2418c = a10;
        Bundle bundle = uVar.f2412j;
        if (bundle != null) {
            bundle.setClassLoader(classLoader);
        }
        a10.setArguments(uVar.f2412j);
        a10.mWho = uVar.f2404b;
        a10.mFromLayout = uVar.f2405c;
        a10.mRestored = true;
        a10.mFragmentId = uVar.f2406d;
        a10.mContainerId = uVar.f2407e;
        a10.mTag = uVar.f2408f;
        a10.mRetainInstance = uVar.f2409g;
        a10.mRemoving = uVar.f2410h;
        a10.mDetached = uVar.f2411i;
        a10.mHidden = uVar.f2413k;
        a10.mMaxState = d.c.values()[uVar.f2414l];
        Bundle bundle2 = uVar.f2415m;
        if (bundle2 != null) {
            a10.mSavedFragmentState = bundle2;
        } else {
            a10.mSavedFragmentState = new Bundle();
        }
        if (o.F0(2)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Instantiated fragment ");
            sb.append(a10);
        }
    }

    public v(n nVar, x xVar, Fragment fragment, u uVar) {
        this.f2416a = nVar;
        this.f2417b = xVar;
        this.f2418c = fragment;
        fragment.mSavedViewState = null;
        fragment.mSavedViewRegistryState = null;
        fragment.mBackStackNesting = 0;
        fragment.mInLayout = false;
        fragment.mAdded = false;
        Fragment fragment2 = fragment.mTarget;
        fragment.mTargetWho = fragment2 != null ? fragment2.mWho : null;
        fragment.mTarget = null;
        Bundle bundle = uVar.f2415m;
        if (bundle != null) {
            fragment.mSavedFragmentState = bundle;
        } else {
            fragment.mSavedFragmentState = new Bundle();
        }
    }
}
