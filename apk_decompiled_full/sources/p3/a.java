package p3;

import c3.k;
import java.util.Collection;

/* loaded from: classes.dex */
public class a extends g {
    public a(k kVar, String str, c3.i iVar, Class cls, String str2, Collection collection) {
        super(kVar, str, iVar, cls, str2, collection);
    }

    public static a v(k kVar, Object obj, String str, Collection collection) {
        Class<?> cls = obj instanceof Class ? (Class) obj : obj.getClass();
        a aVar = new a(kVar, String.format("Ignored field \"%s\" (class %s) encountered; mapper configured not to allow this", str, cls.getName()), kVar.z(), cls, str, collection);
        aVar.n(obj, str);
        return aVar;
    }
}
