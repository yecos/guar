package androidx.activity.result;

import android.content.Intent;
import android.os.Bundle;
import androidx.lifecycle.d;
import androidx.lifecycle.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import o.j;

/* loaded from: classes.dex */
public abstract class ActivityResultRegistry {

    /* renamed from: a, reason: collision with root package name */
    public Random f769a = new Random();

    /* renamed from: b, reason: collision with root package name */
    public final Map f770b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    public final Map f771c = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    public final Map f772d = new HashMap();

    /* renamed from: e, reason: collision with root package name */
    public ArrayList f773e = new ArrayList();

    /* renamed from: f, reason: collision with root package name */
    public final transient Map f774f = new HashMap();

    /* renamed from: g, reason: collision with root package name */
    public final Map f775g = new HashMap();

    /* renamed from: h, reason: collision with root package name */
    public final Bundle f776h = new Bundle();

    public class a extends androidx.activity.result.c {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f781a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f782b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ c.a f783c;

        public a(String str, int i10, c.a aVar) {
            this.f781a = str;
            this.f782b = i10;
            this.f783c = aVar;
        }

        @Override // androidx.activity.result.c
        public void b(Object obj, j jVar) {
            ActivityResultRegistry.this.f773e.add(this.f781a);
            Integer num = (Integer) ActivityResultRegistry.this.f771c.get(this.f781a);
            ActivityResultRegistry.this.f(num != null ? num.intValue() : this.f782b, this.f783c, obj, jVar);
        }

        @Override // androidx.activity.result.c
        public void c() {
            ActivityResultRegistry.this.l(this.f781a);
        }
    }

    public class b extends androidx.activity.result.c {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f785a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f786b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ c.a f787c;

        public b(String str, int i10, c.a aVar) {
            this.f785a = str;
            this.f786b = i10;
            this.f787c = aVar;
        }

        @Override // androidx.activity.result.c
        public void b(Object obj, j jVar) {
            ActivityResultRegistry.this.f773e.add(this.f785a);
            Integer num = (Integer) ActivityResultRegistry.this.f771c.get(this.f785a);
            ActivityResultRegistry.this.f(num != null ? num.intValue() : this.f786b, this.f787c, obj, jVar);
        }

        @Override // androidx.activity.result.c
        public void c() {
            ActivityResultRegistry.this.l(this.f785a);
        }
    }

    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public final androidx.activity.result.b f789a;

        /* renamed from: b, reason: collision with root package name */
        public final c.a f790b;

        public c(androidx.activity.result.b bVar, c.a aVar) {
            this.f789a = bVar;
            this.f790b = aVar;
        }
    }

    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public final androidx.lifecycle.d f791a;

        /* renamed from: b, reason: collision with root package name */
        public final ArrayList f792b = new ArrayList();

        public d(androidx.lifecycle.d dVar) {
            this.f791a = dVar;
        }

        public void a(androidx.lifecycle.e eVar) {
            this.f791a.a(eVar);
            this.f792b.add(eVar);
        }

        public void b() {
            Iterator it = this.f792b.iterator();
            while (it.hasNext()) {
                this.f791a.c((androidx.lifecycle.e) it.next());
            }
            this.f792b.clear();
        }
    }

    public final void a(int i10, String str) {
        this.f770b.put(Integer.valueOf(i10), str);
        this.f771c.put(str, Integer.valueOf(i10));
    }

    public final boolean b(int i10, int i11, Intent intent) {
        String str = (String) this.f770b.get(Integer.valueOf(i10));
        if (str == null) {
            return false;
        }
        this.f773e.remove(str);
        d(str, i11, intent, (c) this.f774f.get(str));
        return true;
    }

    public final boolean c(int i10, Object obj) {
        androidx.activity.result.b bVar;
        String str = (String) this.f770b.get(Integer.valueOf(i10));
        if (str == null) {
            return false;
        }
        this.f773e.remove(str);
        c cVar = (c) this.f774f.get(str);
        if (cVar != null && (bVar = cVar.f789a) != null) {
            bVar.a(obj);
            return true;
        }
        this.f776h.remove(str);
        this.f775g.put(str, obj);
        return true;
    }

    public final void d(String str, int i10, Intent intent, c cVar) {
        androidx.activity.result.b bVar;
        if (cVar != null && (bVar = cVar.f789a) != null) {
            bVar.a(cVar.f790b.c(i10, intent));
        } else {
            this.f775g.remove(str);
            this.f776h.putParcelable(str, new androidx.activity.result.a(i10, intent));
        }
    }

    public final int e() {
        int nextInt = this.f769a.nextInt(2147418112);
        while (true) {
            int i10 = nextInt + 65536;
            if (!this.f770b.containsKey(Integer.valueOf(i10))) {
                return i10;
            }
            nextInt = this.f769a.nextInt(2147418112);
        }
    }

    public abstract void f(int i10, c.a aVar, Object obj, j jVar);

    public final void g(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        ArrayList<Integer> integerArrayList = bundle.getIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS");
        ArrayList<String> stringArrayList = bundle.getStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS");
        if (stringArrayList == null || integerArrayList == null) {
            return;
        }
        this.f773e = bundle.getStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS");
        this.f769a = (Random) bundle.getSerializable("KEY_COMPONENT_ACTIVITY_RANDOM_OBJECT");
        this.f776h.putAll(bundle.getBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT"));
        for (int i10 = 0; i10 < stringArrayList.size(); i10++) {
            String str = stringArrayList.get(i10);
            if (this.f771c.containsKey(str)) {
                Integer num = (Integer) this.f771c.remove(str);
                if (!this.f776h.containsKey(str)) {
                    this.f770b.remove(num);
                }
            }
            a(integerArrayList.get(i10).intValue(), stringArrayList.get(i10));
        }
    }

    public final void h(Bundle bundle) {
        bundle.putIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS", new ArrayList<>(this.f771c.values()));
        bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS", new ArrayList<>(this.f771c.keySet()));
        bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS", new ArrayList<>(this.f773e));
        bundle.putBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT", (Bundle) this.f776h.clone());
        bundle.putSerializable("KEY_COMPONENT_ACTIVITY_RANDOM_OBJECT", this.f769a);
    }

    public final androidx.activity.result.c i(final String str, g gVar, final c.a aVar, final androidx.activity.result.b bVar) {
        androidx.lifecycle.d lifecycle = gVar.getLifecycle();
        if (lifecycle.b().a(d.c.STARTED)) {
            throw new IllegalStateException("LifecycleOwner " + gVar + " is attempting to register while current state is " + lifecycle.b() + ". LifecycleOwners must call register before they are STARTED.");
        }
        int k10 = k(str);
        d dVar = (d) this.f772d.get(str);
        if (dVar == null) {
            dVar = new d(lifecycle);
        }
        dVar.a(new androidx.lifecycle.e() { // from class: androidx.activity.result.ActivityResultRegistry.1
            @Override // androidx.lifecycle.e
            public void a(g gVar2, d.b bVar2) {
                if (!d.b.ON_START.equals(bVar2)) {
                    if (d.b.ON_STOP.equals(bVar2)) {
                        ActivityResultRegistry.this.f774f.remove(str);
                        return;
                    } else {
                        if (d.b.ON_DESTROY.equals(bVar2)) {
                            ActivityResultRegistry.this.l(str);
                            return;
                        }
                        return;
                    }
                }
                ActivityResultRegistry.this.f774f.put(str, new c(bVar, aVar));
                if (ActivityResultRegistry.this.f775g.containsKey(str)) {
                    Object obj = ActivityResultRegistry.this.f775g.get(str);
                    ActivityResultRegistry.this.f775g.remove(str);
                    bVar.a(obj);
                }
                androidx.activity.result.a aVar2 = (androidx.activity.result.a) ActivityResultRegistry.this.f776h.getParcelable(str);
                if (aVar2 != null) {
                    ActivityResultRegistry.this.f776h.remove(str);
                    bVar.a(aVar.c(aVar2.b(), aVar2.a()));
                }
            }
        });
        this.f772d.put(str, dVar);
        return new a(str, k10, aVar);
    }

    public final androidx.activity.result.c j(String str, c.a aVar, androidx.activity.result.b bVar) {
        int k10 = k(str);
        this.f774f.put(str, new c(bVar, aVar));
        if (this.f775g.containsKey(str)) {
            Object obj = this.f775g.get(str);
            this.f775g.remove(str);
            bVar.a(obj);
        }
        androidx.activity.result.a aVar2 = (androidx.activity.result.a) this.f776h.getParcelable(str);
        if (aVar2 != null) {
            this.f776h.remove(str);
            bVar.a(aVar.c(aVar2.b(), aVar2.a()));
        }
        return new b(str, k10, aVar);
    }

    public final int k(String str) {
        Integer num = (Integer) this.f771c.get(str);
        if (num != null) {
            return num.intValue();
        }
        int e10 = e();
        a(e10, str);
        return e10;
    }

    public final void l(String str) {
        Integer num;
        if (!this.f773e.contains(str) && (num = (Integer) this.f771c.remove(str)) != null) {
            this.f770b.remove(num);
        }
        this.f774f.remove(str);
        if (this.f775g.containsKey(str)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Dropping pending result for request ");
            sb.append(str);
            sb.append(": ");
            sb.append(this.f775g.get(str));
            this.f775g.remove(str);
        }
        if (this.f776h.containsKey(str)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Dropping pending result for request ");
            sb2.append(str);
            sb2.append(": ");
            sb2.append(this.f776h.getParcelable(str));
            this.f776h.remove(str);
        }
        d dVar = (d) this.f772d.get(str);
        if (dVar != null) {
            dVar.b();
            this.f772d.remove(str);
        }
    }
}
