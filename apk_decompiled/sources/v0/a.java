package v0;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import androidx.startup.InitializationProvider;
import androidx.startup.R$string;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: d, reason: collision with root package name */
    public static volatile a f19092d;

    /* renamed from: e, reason: collision with root package name */
    public static final Object f19093e = new Object();

    /* renamed from: c, reason: collision with root package name */
    public final Context f19096c;

    /* renamed from: b, reason: collision with root package name */
    public final Set f19095b = new HashSet();

    /* renamed from: a, reason: collision with root package name */
    public final Map f19094a = new HashMap();

    public a(Context context) {
        this.f19096c = context.getApplicationContext();
    }

    public static a c(Context context) {
        if (f19092d == null) {
            synchronized (f19093e) {
                if (f19092d == null) {
                    f19092d = new a(context);
                }
            }
        }
        return f19092d;
    }

    public void a() {
        try {
            try {
                w0.b.a("Startup");
                Bundle bundle = this.f19096c.getPackageManager().getProviderInfo(new ComponentName(this.f19096c.getPackageName(), InitializationProvider.class.getName()), 128).metaData;
                String string = this.f19096c.getString(R$string.androidx_startup);
                if (bundle != null) {
                    HashSet hashSet = new HashSet();
                    for (String str : bundle.keySet()) {
                        if (string.equals(bundle.getString(str, null))) {
                            Class<?> cls = Class.forName(str);
                            if (b.class.isAssignableFrom(cls)) {
                                this.f19095b.add(cls);
                                b(cls, hashSet);
                            }
                        }
                    }
                }
            } finally {
                w0.b.b();
            }
        } catch (PackageManager.NameNotFoundException | ClassNotFoundException e10) {
            throw new c(e10);
        }
    }

    public Object b(Class cls, Set set) {
        Object obj;
        synchronized (f19093e) {
            if (w0.b.d()) {
                try {
                    w0.b.a(cls.getSimpleName());
                } finally {
                    w0.b.b();
                }
            }
            if (set.contains(cls)) {
                throw new IllegalStateException(String.format("Cannot initialize %s. Cycle detected.", cls.getName()));
            }
            if (this.f19094a.containsKey(cls)) {
                obj = this.f19094a.get(cls);
            } else {
                set.add(cls);
                try {
                    b bVar = (b) cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                    List<Class> dependencies = bVar.dependencies();
                    if (!dependencies.isEmpty()) {
                        for (Class cls2 : dependencies) {
                            if (!this.f19094a.containsKey(cls2)) {
                                b(cls2, set);
                            }
                        }
                    }
                    obj = bVar.a(this.f19096c);
                    set.remove(cls);
                    this.f19094a.put(cls, obj);
                } catch (Throwable th) {
                    throw new c(th);
                }
            }
        }
        return obj;
    }
}
