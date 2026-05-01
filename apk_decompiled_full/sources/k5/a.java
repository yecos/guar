package k5;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.e;
import t9.i;
import u8.b;

/* loaded from: classes3.dex */
public abstract class a extends b {

    /* renamed from: b, reason: collision with root package name */
    public boolean f15011b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f15012c;

    public final boolean P2() {
        if (getActivity() != null) {
            e activity = getActivity();
            i.d(activity);
            if (!activity.isFinishing()) {
                e activity2 = getActivity();
                i.d(activity2);
                if (!activity2.isDestroyed() && isAdded()) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean Q2() {
        return this.f15011b;
    }

    public final boolean R2() {
        return this.f15011b && this.f15012c;
    }

    public final boolean S2() {
        return this.f15012c;
    }

    public abstract void T2();

    public void U2() {
    }

    public void V2() {
        if (this.f15011b && this.f15012c) {
            T2();
        }
    }

    public final void W2(boolean z10) {
        this.f15011b = z10;
    }

    @Override // u8.b, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        i.g(view, "view");
        super.onViewCreated(view, bundle);
        this.f15011b = true;
        if (this.f15012c) {
            T2();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z10) {
        super.setUserVisibleHint(z10);
        if (getUserVisibleHint()) {
            this.f15012c = true;
            V2();
        } else {
            this.f15012c = false;
            U2();
        }
    }
}
