package u8;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import io.reactivex.subjects.BehaviorSubject;
import t8.c;

/* loaded from: classes3.dex */
public abstract class b extends Fragment {

    /* renamed from: a, reason: collision with root package name */
    public final BehaviorSubject f19072a = BehaviorSubject.create();

    public final s8.b O2() {
        return c.b(this.f19072a);
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f19072a.onNext(t8.b.ATTACH);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f19072a.onNext(t8.b.CREATE);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        this.f19072a.onNext(t8.b.DESTROY);
        super.onDestroy();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        this.f19072a.onNext(t8.b.DESTROY_VIEW);
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        this.f19072a.onNext(t8.b.DETACH);
        super.onDetach();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        this.f19072a.onNext(t8.b.PAUSE);
        super.onPause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.f19072a.onNext(t8.b.RESUME);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        this.f19072a.onNext(t8.b.START);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        this.f19072a.onNext(t8.b.STOP);
        super.onStop();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f19072a.onNext(t8.b.CREATE_VIEW);
    }
}
