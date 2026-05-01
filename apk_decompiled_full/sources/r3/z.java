package r3;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Objects;
import r3.f0;

/* loaded from: classes.dex */
public abstract class z {
    public static c4.n a(Method method, k3.j jVar, f0 f0Var) {
        k3.j k10;
        TypeVariable b10;
        TypeVariable<Method>[] typeParameters = method.getTypeParameters();
        if (typeParameters.length == 0 || jVar.j().n()) {
            return null;
        }
        Type genericReturnType = method.getGenericReturnType();
        if (!(genericReturnType instanceof ParameterizedType)) {
            return null;
        }
        ParameterizedType parameterizedType = (ParameterizedType) genericReturnType;
        if (!Objects.equals(jVar.q(), parameterizedType.getRawType())) {
            return null;
        }
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        ArrayList arrayList = new ArrayList(typeParameters.length);
        ArrayList arrayList2 = new ArrayList(typeParameters.length);
        for (int i10 = 0; i10 < actualTypeArguments.length; i10++) {
            TypeVariable d10 = d(actualTypeArguments[i10]);
            if (d10 != null) {
                String name = d10.getName();
                if (name == null || (k10 = jVar.j().k(i10)) == null || (b10 = b(typeParameters, name)) == null) {
                    return null;
                }
                if (g(f0Var, k10, b10.getBounds())) {
                    int indexOf = arrayList.indexOf(name);
                    if (indexOf != -1) {
                        k3.j jVar2 = (k3.j) arrayList2.get(indexOf);
                        if (k10.equals(jVar2)) {
                            continue;
                        } else {
                            boolean N = jVar2.N(k10.q());
                            boolean N2 = k10.N(jVar2.q());
                            if (!N && !N2) {
                                return null;
                            }
                            if ((N ^ N2) && N2) {
                                arrayList2.set(indexOf, k10);
                            }
                        }
                    } else {
                        arrayList.add(name);
                        arrayList2.add(k10);
                    }
                } else {
                    continue;
                }
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return c4.n.f(arrayList, arrayList2);
    }

    public static TypeVariable b(TypeVariable[] typeVariableArr, String str) {
        if (typeVariableArr != null && str != null) {
            for (TypeVariable typeVariable : typeVariableArr) {
                if (str.equals(typeVariable.getName())) {
                    return typeVariable;
                }
            }
        }
        return null;
    }

    public static ParameterizedType c(Type type) {
        if (type instanceof ParameterizedType) {
            return (ParameterizedType) type;
        }
        if (type instanceof WildcardType) {
            WildcardType wildcardType = (WildcardType) type;
            if (wildcardType.getLowerBounds().length != 0) {
                return null;
            }
            Type[] upperBounds = wildcardType.getUpperBounds();
            if (upperBounds.length == 1) {
                return c(upperBounds[0]);
            }
        }
        return null;
    }

    public static TypeVariable d(Type type) {
        if (type instanceof TypeVariable) {
            return (TypeVariable) type;
        }
        if (type instanceof WildcardType) {
            WildcardType wildcardType = (WildcardType) type;
            if (wildcardType.getLowerBounds().length != 0) {
                return null;
            }
            Type[] upperBounds = wildcardType.getUpperBounds();
            if (upperBounds.length == 1) {
                return d(upperBounds[0]);
            }
        }
        return null;
    }

    public static f0 e(Method method, k3.j jVar, c4.o oVar, f0 f0Var) {
        c4.n a10 = a(method, jVar, f0Var);
        return a10 == null ? f0Var : new f0.a(oVar, a10);
    }

    public static boolean f(f0 f0Var, k3.j jVar, Type type) {
        if (!jVar.N(f0Var.a(type).q())) {
            return false;
        }
        ParameterizedType c10 = c(type);
        if (c10 == null || !Objects.equals(jVar.q(), c10.getRawType())) {
            return true;
        }
        Type[] actualTypeArguments = c10.getActualTypeArguments();
        c4.n j10 = jVar.j();
        if (j10.o() != actualTypeArguments.length) {
            return false;
        }
        for (int i10 = 0; i10 < j10.o(); i10++) {
            if (!f(f0Var, j10.k(i10), actualTypeArguments[i10])) {
                return false;
            }
        }
        return true;
    }

    public static boolean g(f0 f0Var, k3.j jVar, Type[] typeArr) {
        for (Type type : typeArr) {
            if (!f(f0Var, jVar, type)) {
                return false;
            }
        }
        return true;
    }
}
