package g3;

import c3.k;
import java.util.HashSet;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public final Object f13560a;

    /* renamed from: b, reason: collision with root package name */
    public String f13561b;

    /* renamed from: c, reason: collision with root package name */
    public String f13562c;

    /* renamed from: d, reason: collision with root package name */
    public HashSet f13563d;

    public a(Object obj) {
        this.f13560a = obj;
    }

    public static a e(c3.h hVar) {
        return new a(hVar);
    }

    public static a f(k kVar) {
        return new a(kVar);
    }

    public a a() {
        return new a(this.f13560a);
    }

    public Object b() {
        return this.f13560a;
    }

    public boolean c(String str) {
        String str2 = this.f13561b;
        if (str2 == null) {
            this.f13561b = str;
            return false;
        }
        if (str.equals(str2)) {
            return true;
        }
        String str3 = this.f13562c;
        if (str3 == null) {
            this.f13562c = str;
            return false;
        }
        if (str.equals(str3)) {
            return true;
        }
        if (this.f13563d == null) {
            HashSet hashSet = new HashSet(16);
            this.f13563d = hashSet;
            hashSet.add(this.f13561b);
            this.f13563d.add(this.f13562c);
        }
        return !this.f13563d.add(str);
    }

    public void d() {
        this.f13561b = null;
        this.f13562c = null;
        this.f13563d = null;
    }
}
