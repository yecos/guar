package androidx.savedstate;

import android.os.Bundle;
import androidx.lifecycle.d;
import androidx.lifecycle.e;
import androidx.lifecycle.g;
import androidx.savedstate.Recreator;
import i.b;
import java.util.Map;

/* loaded from: classes.dex */
public final class SavedStateRegistry {

    /* renamed from: b, reason: collision with root package name */
    public Bundle f3343b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f3344c;

    /* renamed from: d, reason: collision with root package name */
    public Recreator.a f3345d;

    /* renamed from: a, reason: collision with root package name */
    public i.b f3342a = new i.b();

    /* renamed from: e, reason: collision with root package name */
    public boolean f3346e = true;

    public interface a {
        void a(androidx.savedstate.b bVar);
    }

    public interface b {
        Bundle a();
    }

    public Bundle a(String str) {
        if (!this.f3344c) {
            throw new IllegalStateException("You can consumeRestoredStateForKey only after super.onCreate of corresponding component");
        }
        Bundle bundle = this.f3343b;
        if (bundle == null) {
            return null;
        }
        Bundle bundle2 = bundle.getBundle(str);
        this.f3343b.remove(str);
        if (this.f3343b.isEmpty()) {
            this.f3343b = null;
        }
        return bundle2;
    }

    public void b(d dVar, Bundle bundle) {
        if (this.f3344c) {
            throw new IllegalStateException("SavedStateRegistry was already restored.");
        }
        if (bundle != null) {
            this.f3343b = bundle.getBundle("androidx.lifecycle.BundlableSavedStateRegistry.key");
        }
        dVar.a(new e() { // from class: androidx.savedstate.SavedStateRegistry.1
            @Override // androidx.lifecycle.e
            public void a(g gVar, d.b bVar) {
                if (bVar == d.b.ON_START) {
                    SavedStateRegistry.this.f3346e = true;
                } else if (bVar == d.b.ON_STOP) {
                    SavedStateRegistry.this.f3346e = false;
                }
            }
        });
        this.f3344c = true;
    }

    public void c(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        Bundle bundle3 = this.f3343b;
        if (bundle3 != null) {
            bundle2.putAll(bundle3);
        }
        b.d c10 = this.f3342a.c();
        while (c10.hasNext()) {
            Map.Entry entry = (Map.Entry) c10.next();
            bundle2.putBundle((String) entry.getKey(), ((b) entry.getValue()).a());
        }
        bundle.putBundle("androidx.lifecycle.BundlableSavedStateRegistry.key", bundle2);
    }

    public void d(String str, b bVar) {
        if (((b) this.f3342a.f(str, bVar)) != null) {
            throw new IllegalArgumentException("SavedStateProvider with the given key is already registered");
        }
    }

    public void e(Class cls) {
        if (!this.f3346e) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
        if (this.f3345d == null) {
            this.f3345d = new Recreator.a(this);
        }
        try {
            cls.getDeclaredConstructor(new Class[0]);
            this.f3345d.b(cls.getName());
        } catch (NoSuchMethodException e10) {
            throw new IllegalArgumentException("Class" + cls.getSimpleName() + " must have default constructor in order to be automatically recreated", e10);
        }
    }
}
