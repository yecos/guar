package u8;

import android.os.Bundle;
import androidx.appcompat.app.d;
import io.reactivex.subjects.BehaviorSubject;
import t8.c;

/* loaded from: classes3.dex */
public abstract class a extends d {

    /* renamed from: a, reason: collision with root package name */
    public final BehaviorSubject f19071a = BehaviorSubject.create();

    public final s8.b O1() {
        return c.a(this.f19071a);
    }

    public final s8.b P1(t8.a aVar) {
        return s8.d.c(this.f19071a, aVar);
    }

    @Override // androidx.appcompat.app.d, androidx.fragment.app.e, androidx.activity.ComponentActivity, o.p, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f19071a.onNext(t8.a.CREATE);
    }

    @Override // androidx.appcompat.app.d, androidx.fragment.app.e, android.app.Activity
    public void onDestroy() {
        this.f19071a.onNext(t8.a.DESTROY);
        super.onDestroy();
    }

    @Override // androidx.fragment.app.e, android.app.Activity
    public void onPause() {
        this.f19071a.onNext(t8.a.PAUSE);
        super.onPause();
    }

    @Override // androidx.fragment.app.e, android.app.Activity
    public void onResume() {
        super.onResume();
        this.f19071a.onNext(t8.a.RESUME);
    }

    @Override // androidx.appcompat.app.d, androidx.fragment.app.e, android.app.Activity
    public void onStart() {
        super.onStart();
        this.f19071a.onNext(t8.a.START);
    }

    @Override // androidx.appcompat.app.d, androidx.fragment.app.e, android.app.Activity
    public void onStop() {
        this.f19071a.onNext(t8.a.STOP);
        super.onStop();
    }
}
