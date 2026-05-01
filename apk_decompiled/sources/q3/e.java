package q3;

import a4.r;
import com.fasterxml.jackson.databind.ser.std.k;
import d4.h;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import k3.a0;
import k3.f;
import k3.j;
import n3.o;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

/* loaded from: classes.dex */
public class e implements Serializable {

    /* renamed from: c, reason: collision with root package name */
    public static final Class f18192c = Node.class;

    /* renamed from: d, reason: collision with root package name */
    public static final Class f18193d = Document.class;

    /* renamed from: e, reason: collision with root package name */
    public static final e f18194e;

    /* renamed from: a, reason: collision with root package name */
    public final Map f18195a;

    /* renamed from: b, reason: collision with root package name */
    public final Map f18196b;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static {
        try {
            a.a();
        } catch (Throwable unused) {
        }
        f18194e = new e();
    }

    public e() {
        HashMap hashMap = new HashMap();
        this.f18195a = hashMap;
        hashMap.put("java.sql.Date", "com.fasterxml.jackson.databind.deser.std.DateDeserializers$SqlDateDeserializer");
        hashMap.put("java.sql.Timestamp", "com.fasterxml.jackson.databind.deser.std.DateDeserializers$TimestampDeserializer");
        HashMap hashMap2 = new HashMap();
        this.f18196b = hashMap2;
        hashMap2.put("java.sql.Timestamp", k.f6693d);
        hashMap2.put("java.sql.Date", "com.fasterxml.jackson.databind.ser.std.SqlDateSerializer");
        hashMap2.put("java.sql.Time", "com.fasterxml.jackson.databind.ser.std.SqlTimeSerializer");
        hashMap2.put("java.sql.Blob", "com.fasterxml.jackson.databind.ext.SqlBlobSerializer");
        hashMap2.put("javax.sql.rowset.serial.SerialBlob", "com.fasterxml.jackson.databind.ext.SqlBlobSerializer");
    }

    public final boolean a(Class cls, Class cls2) {
        return cls2 != null && cls2.isAssignableFrom(cls);
    }

    public k3.k b(j jVar, f fVar, k3.c cVar) {
        Object f10;
        Class q10 = jVar.q();
        if (a(q10, f18192c)) {
            return (k3.k) f("com.fasterxml.jackson.databind.ext.DOMDeserializer$NodeDeserializer", jVar);
        }
        if (a(q10, f18193d)) {
            return (k3.k) f("com.fasterxml.jackson.databind.ext.DOMDeserializer$DocumentDeserializer", jVar);
        }
        String name = q10.getName();
        String str = (String) this.f18195a.get(name);
        if (str != null) {
            return (k3.k) f(str, jVar);
        }
        if ((name.startsWith("javax.xml.") || d(q10, "javax.xml.")) && (f10 = f("com.fasterxml.jackson.databind.ext.CoreXMLDeserializers", jVar)) != null) {
            return ((o) f10).a(jVar, fVar, cVar);
        }
        return null;
    }

    public k3.o c(a0 a0Var, j jVar, k3.c cVar) {
        Object f10;
        Class q10 = jVar.q();
        if (a(q10, f18192c)) {
            return (k3.o) f("com.fasterxml.jackson.databind.ext.DOMSerializer", jVar);
        }
        String name = q10.getName();
        Object obj = this.f18196b.get(name);
        if (obj != null) {
            return obj instanceof k3.o ? (k3.o) obj : (k3.o) f((String) obj, jVar);
        }
        if ((name.startsWith("javax.xml.") || d(q10, "javax.xml.")) && (f10 = f("com.fasterxml.jackson.databind.ext.CoreXMLSerializers", jVar)) != null) {
            return ((r) f10).c(a0Var, jVar, cVar);
        }
        return null;
    }

    public final boolean d(Class cls, String str) {
        do {
            cls = cls.getSuperclass();
            if (cls == null || cls == Object.class) {
                return false;
            }
        } while (!cls.getName().startsWith(str));
        return true;
    }

    public final Object e(Class cls, j jVar) {
        try {
            return h.l(cls, false);
        } catch (Throwable th) {
            throw new IllegalStateException("Failed to create instance of `" + cls.getName() + "` for handling values of type " + h.G(jVar) + ", problem: (" + th.getClass().getName() + ") " + th.getMessage());
        }
    }

    public final Object f(String str, j jVar) {
        try {
            return e(Class.forName(str), jVar);
        } catch (Throwable th) {
            throw new IllegalStateException("Failed to find class `" + str + "` for handling values of type " + h.G(jVar) + ", problem: (" + th.getClass().getName() + ") " + th.getMessage());
        }
    }
}
