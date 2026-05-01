package y8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;

/* loaded from: classes3.dex */
public abstract class j1 {

    public class a implements Comparator {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f19880a;

        public a(b bVar) {
            this.f19880a = bVar;
        }

        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            int b10 = this.f19880a.b(obj) - this.f19880a.b(obj2);
            return b10 != 0 ? b10 : obj.getClass().getName().compareTo(obj2.getClass().getName());
        }
    }

    public interface b {
        boolean a(Object obj);

        int b(Object obj);
    }

    public static Object a(Class cls, Class cls2) {
        try {
            return cls2.asSubclass(cls).getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (ClassCastException unused) {
            return null;
        } catch (Throwable th) {
            throw new ServiceConfigurationError(String.format("Provider %s could not be instantiated %s", cls2.getName(), th), th);
        }
    }

    public static Iterable b(Class cls, Iterable iterable) {
        ArrayList arrayList = new ArrayList();
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            Object a10 = a(cls, (Class) it.next());
            if (a10 != null) {
                arrayList.add(a10);
            }
        }
        return arrayList;
    }

    public static Iterable c(Class cls, ClassLoader classLoader) {
        ServiceLoader load = ServiceLoader.load(cls, classLoader);
        return !load.iterator().hasNext() ? ServiceLoader.load(cls) : load;
    }

    public static boolean d(ClassLoader classLoader) {
        try {
            Class.forName("android.app.Application", false, classLoader);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static List e(Class cls, Iterable iterable, ClassLoader classLoader, b bVar) {
        Iterable b10 = d(classLoader) ? b(cls, iterable) : c(cls, classLoader);
        ArrayList arrayList = new ArrayList();
        for (Object obj : b10) {
            if (bVar.a(obj)) {
                arrayList.add(obj);
            }
        }
        Collections.sort(arrayList, Collections.reverseOrder(new a(bVar)));
        return Collections.unmodifiableList(arrayList);
    }
}
