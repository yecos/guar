package androidx.fragment.app;

import androidx.lifecycle.w;
import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class r extends androidx.lifecycle.v {

    /* renamed from: j, reason: collision with root package name */
    public static final w.b f2395j = new a();

    /* renamed from: f, reason: collision with root package name */
    public final boolean f2399f;

    /* renamed from: c, reason: collision with root package name */
    public final HashMap f2396c = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    public final HashMap f2397d = new HashMap();

    /* renamed from: e, reason: collision with root package name */
    public final HashMap f2398e = new HashMap();

    /* renamed from: g, reason: collision with root package name */
    public boolean f2400g = false;

    /* renamed from: h, reason: collision with root package name */
    public boolean f2401h = false;

    /* renamed from: i, reason: collision with root package name */
    public boolean f2402i = false;

    public class a implements w.b {
        @Override // androidx.lifecycle.w.b
        public androidx.lifecycle.v a(Class cls) {
            return new r(true);
        }
    }

    public r(boolean z10) {
        this.f2399f = z10;
    }

    public static r j(androidx.lifecycle.x xVar) {
        return (r) new androidx.lifecycle.w(xVar, f2395j).a(r.class);
    }

    @Override // androidx.lifecycle.v
    public void d() {
        if (o.F0(3)) {
            StringBuilder sb = new StringBuilder();
            sb.append("onCleared called for ");
            sb.append(this);
        }
        this.f2400g = true;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || r.class != obj.getClass()) {
            return false;
        }
        r rVar = (r) obj;
        return this.f2396c.equals(rVar.f2396c) && this.f2397d.equals(rVar.f2397d) && this.f2398e.equals(rVar.f2398e);
    }

    public void f(Fragment fragment) {
        if (this.f2402i) {
            o.F0(2);
            return;
        }
        if (this.f2396c.containsKey(fragment.mWho)) {
            return;
        }
        this.f2396c.put(fragment.mWho, fragment);
        if (o.F0(2)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Updating retained Fragments: Added ");
            sb.append(fragment);
        }
    }

    public void g(Fragment fragment) {
        if (o.F0(3)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Clearing non-config state for ");
            sb.append(fragment);
        }
        r rVar = (r) this.f2397d.get(fragment.mWho);
        if (rVar != null) {
            rVar.d();
            this.f2397d.remove(fragment.mWho);
        }
        androidx.lifecycle.x xVar = (androidx.lifecycle.x) this.f2398e.get(fragment.mWho);
        if (xVar != null) {
            xVar.a();
            this.f2398e.remove(fragment.mWho);
        }
    }

    public Fragment h(String str) {
        return (Fragment) this.f2396c.get(str);
    }

    public int hashCode() {
        return (((this.f2396c.hashCode() * 31) + this.f2397d.hashCode()) * 31) + this.f2398e.hashCode();
    }

    public r i(Fragment fragment) {
        r rVar = (r) this.f2397d.get(fragment.mWho);
        if (rVar != null) {
            return rVar;
        }
        r rVar2 = new r(this.f2399f);
        this.f2397d.put(fragment.mWho, rVar2);
        return rVar2;
    }

    public Collection k() {
        return new ArrayList(this.f2396c.values());
    }

    public androidx.lifecycle.x l(Fragment fragment) {
        androidx.lifecycle.x xVar = (androidx.lifecycle.x) this.f2398e.get(fragment.mWho);
        if (xVar != null) {
            return xVar;
        }
        androidx.lifecycle.x xVar2 = new androidx.lifecycle.x();
        this.f2398e.put(fragment.mWho, xVar2);
        return xVar2;
    }

    public boolean m() {
        return this.f2400g;
    }

    public void n(Fragment fragment) {
        if (this.f2402i) {
            o.F0(2);
            return;
        }
        if ((this.f2396c.remove(fragment.mWho) != null) && o.F0(2)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Updating retained Fragments: Removed ");
            sb.append(fragment);
        }
    }

    public void o(boolean z10) {
        this.f2402i = z10;
    }

    public boolean p(Fragment fragment) {
        if (this.f2396c.containsKey(fragment.mWho)) {
            return this.f2399f ? this.f2400g : !this.f2401h;
        }
        return true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("FragmentManagerViewModel{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("} Fragments (");
        Iterator it = this.f2396c.values().iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") Child Non Config (");
        Iterator it2 = this.f2397d.keySet().iterator();
        while (it2.hasNext()) {
            sb.append((String) it2.next());
            if (it2.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") ViewModelStores (");
        Iterator it3 = this.f2398e.keySet().iterator();
        while (it3.hasNext()) {
            sb.append((String) it3.next());
            if (it3.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(ASCIIPropertyListParser.ARRAY_END_TOKEN);
        return sb.toString();
    }
}
