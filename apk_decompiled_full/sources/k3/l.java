package k3;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.io.Closeable;
import java.io.IOException;
import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;

/* loaded from: classes.dex */
public class l extends c3.l {

    /* renamed from: b, reason: collision with root package name */
    public LinkedList f14923b;

    /* renamed from: c, reason: collision with root package name */
    public transient Closeable f14924c;

    public l(Closeable closeable, String str) {
        super(str);
        this.f14924c = closeable;
        if (closeable instanceof c3.k) {
            this.f5482a = ((c3.k) closeable).c0();
        }
    }

    public static l g(c3.h hVar, String str) {
        return new l(hVar, str, (Throwable) null);
    }

    public static l h(c3.h hVar, String str, Throwable th) {
        return new l(hVar, str, th);
    }

    public static l i(c3.k kVar, String str, Throwable th) {
        return new l(kVar, str, th);
    }

    public static l j(g gVar, String str) {
        return new l(gVar.S(), str);
    }

    public static l k(g gVar, String str, Throwable th) {
        return new l(gVar.S(), str, th);
    }

    public static l l(IOException iOException) {
        return new l(null, String.format("Unexpected IOException (of type %s): %s", iOException.getClass().getName(), d4.h.o(iOException)));
    }

    public static l p(Throwable th, Object obj, int i10) {
        return r(th, new a(obj, i10));
    }

    public static l q(Throwable th, Object obj, String str) {
        return r(th, new a(obj, str));
    }

    public static l r(Throwable th, a aVar) {
        Closeable closeable;
        l lVar;
        if (th instanceof l) {
            lVar = (l) th;
        } else {
            String o10 = d4.h.o(th);
            if (o10 == null || o10.isEmpty()) {
                o10 = "(was " + th.getClass().getName() + ")";
            }
            if (th instanceof c3.l) {
                Object d10 = ((c3.l) th).d();
                if (d10 instanceof Closeable) {
                    closeable = (Closeable) d10;
                    lVar = new l(closeable, o10, th);
                }
            }
            closeable = null;
            lVar = new l(closeable, o10, th);
        }
        lVar.o(aVar);
        return lVar;
    }

    @Override // c3.l
    public Object d() {
        return this.f14924c;
    }

    public void e(StringBuilder sb) {
        LinkedList linkedList = this.f14923b;
        if (linkedList == null) {
            return;
        }
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            sb.append(((a) it.next()).toString());
            if (it.hasNext()) {
                sb.append("->");
            }
        }
    }

    public String f() {
        String message = super.getMessage();
        if (this.f14923b == null) {
            return message;
        }
        StringBuilder sb = message == null ? new StringBuilder() : new StringBuilder(message);
        sb.append(" (through reference chain: ");
        StringBuilder m10 = m(sb);
        m10.append(ASCIIPropertyListParser.ARRAY_END_TOKEN);
        return m10.toString();
    }

    @Override // java.lang.Throwable
    public String getLocalizedMessage() {
        return f();
    }

    @Override // c3.l, java.lang.Throwable
    public String getMessage() {
        return f();
    }

    public StringBuilder m(StringBuilder sb) {
        e(sb);
        return sb;
    }

    public void n(Object obj, String str) {
        o(new a(obj, str));
    }

    public void o(a aVar) {
        if (this.f14923b == null) {
            this.f14923b = new LinkedList();
        }
        if (this.f14923b.size() < 1000) {
            this.f14923b.addFirst(aVar);
        }
    }

    @Override // c3.l, java.lang.Throwable
    public String toString() {
        return getClass().getName() + ": " + getMessage();
    }

    public static class a implements Serializable {

        /* renamed from: a, reason: collision with root package name */
        public transient Object f14925a;

        /* renamed from: b, reason: collision with root package name */
        public String f14926b;

        /* renamed from: c, reason: collision with root package name */
        public int f14927c;

        /* renamed from: d, reason: collision with root package name */
        public String f14928d;

        public a(Object obj, String str) {
            this.f14927c = -1;
            this.f14925a = obj;
            if (str == null) {
                throw new NullPointerException("Cannot pass null fieldName");
            }
            this.f14926b = str;
        }

        public String a() {
            if (this.f14928d == null) {
                StringBuilder sb = new StringBuilder();
                Object obj = this.f14925a;
                if (obj != null) {
                    Class<?> cls = obj instanceof Class ? (Class) obj : obj.getClass();
                    int i10 = 0;
                    while (cls.isArray()) {
                        cls = cls.getComponentType();
                        i10++;
                    }
                    sb.append(cls.getName());
                    while (true) {
                        i10--;
                        if (i10 < 0) {
                            break;
                        }
                        sb.append("[]");
                    }
                } else {
                    sb.append("UNKNOWN");
                }
                sb.append('[');
                if (this.f14926b != null) {
                    sb.append('\"');
                    sb.append(this.f14926b);
                    sb.append('\"');
                } else {
                    int i11 = this.f14927c;
                    if (i11 >= 0) {
                        sb.append(i11);
                    } else {
                        sb.append('?');
                    }
                }
                sb.append(']');
                this.f14928d = sb.toString();
            }
            return this.f14928d;
        }

        public String toString() {
            return a();
        }

        public a(Object obj, int i10) {
            this.f14925a = obj;
            this.f14927c = i10;
        }
    }

    public l(Closeable closeable, String str, Throwable th) {
        super(str, th);
        this.f14924c = closeable;
        if (th instanceof c3.l) {
            this.f5482a = ((c3.l) th).a();
        } else if (closeable instanceof c3.k) {
            this.f5482a = ((c3.k) closeable).c0();
        }
    }

    public l(Closeable closeable, String str, c3.i iVar) {
        super(str, iVar);
        this.f14924c = closeable;
    }
}
