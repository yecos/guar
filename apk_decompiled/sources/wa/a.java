package wa;

import com.umeng.analytics.pro.bx;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;
import ta.e;
import ua.c;
import ua.d;

/* loaded from: classes3.dex */
public abstract class a {
    public static List a(Class cls) {
        ArrayList arrayList = new ArrayList();
        try {
            for (Field field : cls.getDeclaredFields()) {
                if (!b.l(field) && b.j(field)) {
                    c cVar = new c();
                    if (field.getType() == e.class) {
                        Class cls2 = (Class) ((ParameterizedType) field.getGenericType()).getActualTypeArguments()[1];
                        if (cls2 != null) {
                            cVar.n(cls2);
                        }
                    } else {
                        cVar.n(field.getType());
                    }
                    cVar.e(b.c(field));
                    cVar.i(field.getName());
                    cVar.f(field.getType());
                    cVar.k(b.f(cls, field));
                    cVar.j(b.e(cls, field));
                    arrayList.add(cVar);
                }
            }
            return arrayList;
        } catch (Exception e10) {
            throw new RuntimeException(e10.getMessage(), e10);
        }
    }

    public static List b(Class cls) {
        ArrayList arrayList = new ArrayList();
        try {
            for (Field field : cls.getDeclaredFields()) {
                if (!b.l(field) && b.k(field)) {
                    d dVar = new d();
                    dVar.e(b.c(field));
                    dVar.i(field.getName());
                    if (!(field.getGenericType() instanceof ParameterizedType)) {
                        throw new va.b("getOneToManyList Exception:" + field.getName() + "'s type is null");
                    }
                    ParameterizedType parameterizedType = (ParameterizedType) field.getGenericType();
                    if (parameterizedType.getActualTypeArguments().length == 1) {
                        Class cls2 = (Class) parameterizedType.getActualTypeArguments()[0];
                        if (cls2 != null) {
                            dVar.n(cls2);
                        }
                    } else {
                        Class cls3 = (Class) parameterizedType.getActualTypeArguments()[1];
                        if (cls3 != null) {
                            dVar.n(cls3);
                        }
                    }
                    dVar.f(field.getType());
                    dVar.k(b.f(cls, field));
                    dVar.j(b.e(cls, field));
                    arrayList.add(dVar);
                }
            }
            return arrayList;
        } catch (Exception e10) {
            throw new RuntimeException(e10.getMessage(), e10);
        }
    }

    public static Field c(Class cls) {
        Field field;
        Field[] declaredFields = cls.getDeclaredFields();
        if (declaredFields == null) {
            throw new RuntimeException("this model[" + cls + "] has no field");
        }
        int length = declaredFields.length;
        int i10 = 0;
        while (true) {
            if (i10 >= length) {
                field = null;
                break;
            }
            field = declaredFields[i10];
            if (field.getAnnotation(sa.a.class) != null) {
                break;
            }
            i10++;
        }
        if (field == null) {
            int length2 = declaredFields.length;
            int i11 = 0;
            while (true) {
                if (i11 >= length2) {
                    break;
                }
                Field field2 = declaredFields[i11];
                if (bx.f10121d.equals(field2.getName())) {
                    field = field2;
                    break;
                }
                i11++;
            }
        }
        if (field != null) {
            return field;
        }
        for (Field field3 : declaredFields) {
            if ("id".equals(field3.getName())) {
                return field3;
            }
        }
        return field;
    }

    public static String d(Class cls) {
        Field c10 = c(cls);
        if (c10 == null) {
            return null;
        }
        return c10.getName();
    }

    public static List e(Class cls) {
        ArrayList arrayList = new ArrayList();
        try {
            Field[] declaredFields = cls.getDeclaredFields();
            String d10 = d(cls);
            for (Field field : declaredFields) {
                if (!b.l(field) && b.h(field) && !field.getName().equals(d10)) {
                    ua.e eVar = new ua.e();
                    eVar.e(b.c(field));
                    eVar.i(field.getName());
                    eVar.f(field.getType());
                    eVar.g(b.g(field));
                    eVar.k(b.f(cls, field));
                    eVar.j(b.e(cls, field));
                    eVar.h(field);
                    arrayList.add(eVar);
                }
            }
            return arrayList;
        } catch (Exception e10) {
            throw new RuntimeException(e10.getMessage(), e10);
        }
    }

    public static String f(Class cls) {
        sa.e eVar = (sa.e) cls.getAnnotation(sa.e.class);
        return (eVar == null || eVar.name().trim().length() == 0) ? cls.getName().replace('.', '_') : eVar.name();
    }
}
