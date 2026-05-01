package r3;

import java.lang.annotation.Annotation;
import java.util.HashMap;

/* loaded from: classes.dex */
public final class p implements d4.b {

    /* renamed from: a, reason: collision with root package name */
    public HashMap f18465a;

    public p() {
    }

    public p(HashMap hashMap) {
        this.f18465a = hashMap;
    }

    public static p e(p pVar, p pVar2) {
        HashMap hashMap;
        HashMap hashMap2;
        if (pVar == null || (hashMap = pVar.f18465a) == null || hashMap.isEmpty()) {
            return pVar2;
        }
        if (pVar2 == null || (hashMap2 = pVar2.f18465a) == null || hashMap2.isEmpty()) {
            return pVar;
        }
        HashMap hashMap3 = new HashMap();
        for (Annotation annotation : pVar2.f18465a.values()) {
            hashMap3.put(annotation.annotationType(), annotation);
        }
        for (Annotation annotation2 : pVar.f18465a.values()) {
            hashMap3.put(annotation2.annotationType(), annotation2);
        }
        return new p(hashMap3);
    }

    public static p f(Class cls, Annotation annotation) {
        HashMap hashMap = new HashMap(4);
        hashMap.put(cls, annotation);
        return new p(hashMap);
    }

    @Override // d4.b
    public boolean a(Class cls) {
        HashMap hashMap = this.f18465a;
        if (hashMap == null) {
            return false;
        }
        return hashMap.containsKey(cls);
    }

    @Override // d4.b
    public boolean b(Class[] clsArr) {
        if (this.f18465a != null) {
            for (Class cls : clsArr) {
                if (this.f18465a.containsKey(cls)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean c(Annotation annotation) {
        if (this.f18465a == null) {
            this.f18465a = new HashMap();
        }
        Annotation annotation2 = (Annotation) this.f18465a.put(annotation.annotationType(), annotation);
        return annotation2 == null || !annotation2.equals(annotation);
    }

    public boolean d(Annotation annotation) {
        return c(annotation);
    }

    @Override // d4.b
    public Annotation get(Class cls) {
        HashMap hashMap = this.f18465a;
        if (hashMap == null) {
            return null;
        }
        return (Annotation) hashMap.get(cls);
    }

    @Override // d4.b
    public int size() {
        HashMap hashMap = this.f18465a;
        if (hashMap == null) {
            return 0;
        }
        return hashMap.size();
    }

    public String toString() {
        HashMap hashMap = this.f18465a;
        return hashMap == null ? "[null]" : hashMap.toString();
    }
}
