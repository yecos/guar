package androidx.fragment.app;

import android.os.Bundle;
import androidx.lifecycle.d;
import java.util.Map;

/* loaded from: classes.dex */
class FragmentManager$6 implements androidx.lifecycle.e {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f2170a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ androidx.lifecycle.d f2171b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ o f2172c;

    @Override // androidx.lifecycle.e
    public void a(androidx.lifecycle.g gVar, d.b bVar) {
        Map map;
        Map map2;
        if (bVar == d.b.ON_START) {
            map2 = this.f2172c.f2347j;
            if (((Bundle) map2.get(this.f2170a)) != null) {
                throw null;
            }
        }
        if (bVar == d.b.ON_DESTROY) {
            this.f2171b.c(this);
            map = this.f2172c.f2348k;
            map.remove(this.f2170a);
        }
    }
}
