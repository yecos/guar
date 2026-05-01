package ta;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public abstract class g {
    public static String a(Class cls, String str) {
        StringBuffer stringBuffer = new StringBuffer(f(ua.f.a(cls).c()));
        if (!TextUtils.isEmpty(str)) {
            stringBuffer.append(" WHERE ");
            stringBuffer.append(str);
        }
        return stringBuffer.toString();
    }

    public static h b(Class cls, Object obj) {
        ua.f a10 = ua.f.a(cls);
        ua.a b10 = a10.b();
        if (obj == null) {
            throw new va.b("getDeleteSQL:idValue is null");
        }
        StringBuffer stringBuffer = new StringBuffer(f(a10.c()));
        stringBuffer.append(" WHERE ");
        stringBuffer.append(b10.a());
        stringBuffer.append("=?");
        h hVar = new h();
        hVar.e(stringBuffer.toString());
        hVar.a(obj);
        return hVar;
    }

    public static h c(Object obj) {
        ua.f a10 = ua.f.a(obj.getClass());
        ua.a b10 = a10.b();
        Object d10 = b10.d(obj);
        if (d10 == null) {
            throw new va.b("getDeleteSQL:" + obj.getClass() + " id value is null");
        }
        StringBuffer stringBuffer = new StringBuffer(f(a10.c()));
        stringBuffer.append(" WHERE ");
        stringBuffer.append(b10.a());
        stringBuffer.append("=?");
        h hVar = new h();
        hVar.e(stringBuffer.toString());
        hVar.a(d10);
        return hVar;
    }

    public static h d(Object obj) {
        List<ua.b> g10 = g(obj);
        StringBuffer stringBuffer = new StringBuffer();
        if (g10 == null || g10.size() <= 0) {
            return null;
        }
        h hVar = new h();
        stringBuffer.append("INSERT INTO ");
        stringBuffer.append(ua.f.a(obj.getClass()).c());
        stringBuffer.append(" (");
        for (ua.b bVar : g10) {
            stringBuffer.append(bVar.a());
            stringBuffer.append(",");
            hVar.a(bVar.b());
        }
        stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        stringBuffer.append(") VALUES ( ");
        int size = g10.size();
        for (int i10 = 0; i10 < size; i10++) {
            stringBuffer.append("?,");
        }
        stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        stringBuffer.append(")");
        hVar.e(stringBuffer.toString());
        return hVar;
    }

    public static String e(Class cls) {
        ua.f a10 = ua.f.a(cls);
        ua.a b10 = a10.b();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("CREATE TABLE IF NOT EXISTS ");
        stringBuffer.append(a10.c());
        stringBuffer.append(" ( ");
        Class b11 = b10.b();
        if (b11 == Integer.TYPE || b11 == Integer.class || b11 == Long.TYPE || b11 == Long.class) {
            stringBuffer.append(b10.a());
            stringBuffer.append(" INTEGER PRIMARY KEY AUTOINCREMENT,");
        } else {
            stringBuffer.append(b10.a());
            stringBuffer.append(" TEXT PRIMARY KEY,");
        }
        for (ua.e eVar : a10.f19088d.values()) {
            stringBuffer.append(eVar.a());
            Class b12 = eVar.b();
            if (b12 == Integer.TYPE || b12 == Integer.class || b12 == Long.TYPE || b12 == Long.class) {
                stringBuffer.append(" INTEGER");
            } else if (b12 == Float.TYPE || b12 == Float.class || b12 == Double.TYPE || b12 == Double.class) {
                stringBuffer.append(" REAL");
            } else if (b12 == Boolean.TYPE || b12 == Boolean.class) {
                stringBuffer.append(" NUMERIC");
            }
            stringBuffer.append(",");
        }
        Iterator it = a10.f19090f.values().iterator();
        while (it.hasNext()) {
            stringBuffer.append(((ua.c) it.next()).a());
            stringBuffer.append(" INTEGER");
            stringBuffer.append(",");
        }
        stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        stringBuffer.append(" )");
        return stringBuffer.toString();
    }

    public static String f(String str) {
        return "DELETE FROM " + str;
    }

    public static List g(Object obj) {
        ArrayList arrayList = new ArrayList();
        ua.f a10 = ua.f.a(obj.getClass());
        Object d10 = a10.b().d(obj);
        if (!(d10 instanceof Integer) && (d10 instanceof String) && d10 != null) {
            arrayList.add(new ua.b(a10.b().a(), d10));
        }
        Iterator it = a10.f19088d.values().iterator();
        while (it.hasNext()) {
            ua.b o10 = o((ua.e) it.next(), obj);
            if (o10 != null) {
                arrayList.add(o10);
            }
        }
        Iterator it2 = a10.f19090f.values().iterator();
        while (it2.hasNext()) {
            ua.b n10 = n((ua.c) it2.next(), obj);
            if (n10 != null) {
                arrayList.add(n10);
            }
        }
        return arrayList;
    }

    public static String h(Class cls) {
        return k(ua.f.a(cls).c());
    }

    public static String i(Class cls, String str) {
        StringBuffer stringBuffer = new StringBuffer(k(ua.f.a(cls).c()));
        if (!TextUtils.isEmpty(str)) {
            stringBuffer.append(" WHERE ");
            stringBuffer.append(str);
        }
        return stringBuffer.toString();
    }

    public static h j(Class cls, Object obj) {
        ua.f a10 = ua.f.a(cls);
        StringBuffer stringBuffer = new StringBuffer(k(a10.c()));
        stringBuffer.append(" WHERE ");
        stringBuffer.append(a10.b().a());
        stringBuffer.append("=?");
        h hVar = new h();
        hVar.e(stringBuffer.toString());
        hVar.a(obj);
        return hVar;
    }

    public static String k(String str) {
        StringBuffer stringBuffer = new StringBuffer("SELECT * FROM ");
        stringBuffer.append(str);
        return stringBuffer.toString();
    }

    public static h l(Object obj) {
        ua.f a10 = ua.f.a(obj.getClass());
        Object d10 = a10.b().d(obj);
        if (d10 == null) {
            throw new va.b("this entity[" + obj.getClass() + "]'s id value is null");
        }
        ArrayList<ua.b> arrayList = new ArrayList();
        Iterator it = a10.f19088d.values().iterator();
        while (it.hasNext()) {
            ua.b o10 = o((ua.e) it.next(), obj);
            if (o10 != null) {
                arrayList.add(o10);
            }
        }
        Iterator it2 = a10.f19090f.values().iterator();
        while (it2.hasNext()) {
            ua.b n10 = n((ua.c) it2.next(), obj);
            if (n10 != null) {
                arrayList.add(n10);
            }
        }
        if (arrayList.size() == 0) {
            return null;
        }
        h hVar = new h();
        StringBuffer stringBuffer = new StringBuffer("UPDATE ");
        stringBuffer.append(a10.c());
        stringBuffer.append(" SET ");
        for (ua.b bVar : arrayList) {
            stringBuffer.append(bVar.a());
            stringBuffer.append("=?,");
            hVar.a(bVar.b());
        }
        stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        stringBuffer.append(" WHERE ");
        stringBuffer.append(a10.b().a());
        stringBuffer.append("=?");
        hVar.a(d10);
        hVar.e(stringBuffer.toString());
        return hVar;
    }

    public static h m(Object obj, String str) {
        ua.f a10 = ua.f.a(obj.getClass());
        ArrayList<ua.b> arrayList = new ArrayList();
        Iterator it = a10.f19088d.values().iterator();
        while (it.hasNext()) {
            ua.b o10 = o((ua.e) it.next(), obj);
            if (o10 != null) {
                arrayList.add(o10);
            }
        }
        Iterator it2 = a10.f19090f.values().iterator();
        while (it2.hasNext()) {
            ua.b n10 = n((ua.c) it2.next(), obj);
            if (n10 != null) {
                arrayList.add(n10);
            }
        }
        if (arrayList.size() == 0) {
            throw new va.b("this entity[" + obj.getClass() + "] has no property");
        }
        h hVar = new h();
        StringBuffer stringBuffer = new StringBuffer("UPDATE ");
        stringBuffer.append(a10.c());
        stringBuffer.append(" SET ");
        for (ua.b bVar : arrayList) {
            stringBuffer.append(bVar.a());
            stringBuffer.append("=?,");
            hVar.a(bVar.b());
        }
        stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        if (!TextUtils.isEmpty(str)) {
            stringBuffer.append(" WHERE ");
            stringBuffer.append(str);
        }
        hVar.e(stringBuffer.toString());
        return hVar;
    }

    public static ua.b n(ua.c cVar, Object obj) {
        String a10 = cVar.a();
        Object d10 = cVar.d(obj);
        if (d10 != null) {
            Object d11 = d10.getClass() == e.class ? ua.f.a(cVar.m()).b().d(((e) d10).a()) : ua.f.a(d10.getClass()).b().d(d10);
            if (a10 != null && d11 != null) {
                return new ua.b(a10, d11);
            }
        }
        return null;
    }

    public static ua.b o(ua.e eVar, Object obj) {
        String a10 = eVar.a();
        Object d10 = eVar.d(obj);
        if (d10 != null) {
            return new ua.b(a10, d10);
        }
        if (eVar.c() == null || eVar.c().trim().length() == 0) {
            return null;
        }
        return new ua.b(a10, eVar.c());
    }
}
