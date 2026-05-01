package b3;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.io.Serializable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes.dex */
public @interface r {

    public enum a {
        ALWAYS,
        NON_NULL,
        NON_ABSENT,
        NON_EMPTY,
        NON_DEFAULT,
        CUSTOM,
        USE_DEFAULTS
    }

    public static class b implements Serializable {

        /* renamed from: e, reason: collision with root package name */
        public static final b f4572e;

        /* renamed from: a, reason: collision with root package name */
        public final a f4573a;

        /* renamed from: b, reason: collision with root package name */
        public final a f4574b;

        /* renamed from: c, reason: collision with root package name */
        public final Class f4575c;

        /* renamed from: d, reason: collision with root package name */
        public final Class f4576d;

        static {
            a aVar = a.USE_DEFAULTS;
            f4572e = new b(aVar, aVar, null, null);
        }

        public b(a aVar, a aVar2, Class cls, Class cls2) {
            this.f4573a = aVar == null ? a.USE_DEFAULTS : aVar;
            this.f4574b = aVar2 == null ? a.USE_DEFAULTS : aVar2;
            this.f4575c = cls == Void.class ? null : cls;
            this.f4576d = cls2 == Void.class ? null : cls2;
        }

        public static b a(a aVar, a aVar2) {
            a aVar3 = a.USE_DEFAULTS;
            return ((aVar == aVar3 || aVar == null) && (aVar2 == aVar3 || aVar2 == null)) ? f4572e : new b(aVar, aVar2, null, null);
        }

        public static b b(a aVar, a aVar2, Class cls, Class cls2) {
            if (cls == Void.class) {
                cls = null;
            }
            if (cls2 == Void.class) {
                cls2 = null;
            }
            a aVar3 = a.USE_DEFAULTS;
            return ((aVar == aVar3 || aVar == null) && (aVar2 == aVar3 || aVar2 == null) && cls == null && cls2 == null) ? f4572e : new b(aVar, aVar2, cls, cls2);
        }

        public static b c() {
            return f4572e;
        }

        public static b d(r rVar) {
            if (rVar == null) {
                return f4572e;
            }
            a value = rVar.value();
            a content = rVar.content();
            a aVar = a.USE_DEFAULTS;
            if (value == aVar && content == aVar) {
                return f4572e;
            }
            Class valueFilter = rVar.valueFilter();
            if (valueFilter == Void.class) {
                valueFilter = null;
            }
            Class contentFilter = rVar.contentFilter();
            return new b(value, content, valueFilter, contentFilter != Void.class ? contentFilter : null);
        }

        public static b i(b bVar, b bVar2) {
            return bVar == null ? bVar2 : bVar.m(bVar2);
        }

        public static b j(b... bVarArr) {
            b bVar = null;
            for (b bVar2 : bVarArr) {
                if (bVar2 != null) {
                    if (bVar != null) {
                        bVar2 = bVar.m(bVar2);
                    }
                    bVar = bVar2;
                }
            }
            return bVar;
        }

        public Class e() {
            return this.f4576d;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj == null || obj.getClass() != getClass()) {
                return false;
            }
            b bVar = (b) obj;
            return bVar.f4573a == this.f4573a && bVar.f4574b == this.f4574b && bVar.f4575c == this.f4575c && bVar.f4576d == this.f4576d;
        }

        public a f() {
            return this.f4574b;
        }

        public Class g() {
            return this.f4575c;
        }

        public a h() {
            return this.f4573a;
        }

        public int hashCode() {
            return (this.f4573a.hashCode() << 2) + this.f4574b.hashCode();
        }

        public b k(Class cls) {
            a aVar;
            if (cls == null || cls == Void.class) {
                aVar = a.USE_DEFAULTS;
                cls = null;
            } else {
                aVar = a.CUSTOM;
            }
            return b(this.f4573a, aVar, this.f4575c, cls);
        }

        public b l(a aVar) {
            return aVar == this.f4574b ? this : new b(this.f4573a, aVar, this.f4575c, this.f4576d);
        }

        public b m(b bVar) {
            if (bVar != null && bVar != f4572e) {
                a aVar = bVar.f4573a;
                a aVar2 = bVar.f4574b;
                Class cls = bVar.f4575c;
                Class cls2 = bVar.f4576d;
                a aVar3 = this.f4573a;
                boolean z10 = true;
                boolean z11 = (aVar == aVar3 || aVar == a.USE_DEFAULTS) ? false : true;
                a aVar4 = this.f4574b;
                boolean z12 = (aVar2 == aVar4 || aVar2 == a.USE_DEFAULTS) ? false : true;
                Class cls3 = this.f4575c;
                if (cls == cls3 && cls2 == cls3) {
                    z10 = false;
                }
                if (z11) {
                    return z12 ? new b(aVar, aVar2, cls, cls2) : new b(aVar, aVar4, cls, cls2);
                }
                if (z12) {
                    return new b(aVar3, aVar2, cls, cls2);
                }
                if (z10) {
                    return new b(aVar3, aVar4, cls, cls2);
                }
            }
            return this;
        }

        public b n(a aVar) {
            return aVar == this.f4573a ? this : new b(aVar, this.f4574b, this.f4575c, this.f4576d);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(80);
            sb.append("JsonInclude.Value(value=");
            sb.append(this.f4573a);
            sb.append(",content=");
            sb.append(this.f4574b);
            if (this.f4575c != null) {
                sb.append(",valueFilter=");
                sb.append(this.f4575c.getName());
                sb.append(".class");
            }
            if (this.f4576d != null) {
                sb.append(",contentFilter=");
                sb.append(this.f4576d.getName());
                sb.append(".class");
            }
            sb.append(ASCIIPropertyListParser.ARRAY_END_TOKEN);
            return sb.toString();
        }
    }

    a content() default a.ALWAYS;

    Class contentFilter() default Void.class;

    a value() default a.ALWAYS;

    Class valueFilter() default Void.class;
}
