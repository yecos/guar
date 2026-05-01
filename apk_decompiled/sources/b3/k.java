package b3;

import java.io.Serializable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Locale;
import java.util.TimeZone;

@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes.dex */
public @interface k {

    public enum a {
        ACCEPT_SINGLE_VALUE_AS_ARRAY,
        ACCEPT_CASE_INSENSITIVE_PROPERTIES,
        ACCEPT_CASE_INSENSITIVE_VALUES,
        WRITE_DATE_TIMESTAMPS_AS_NANOSECONDS,
        WRITE_DATES_WITH_ZONE_ID,
        WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED,
        WRITE_SORTED_MAP_ENTRIES,
        ADJUST_DATES_TO_CONTEXT_TIME_ZONE
    }

    public static class b {

        /* renamed from: c, reason: collision with root package name */
        public static final b f4518c = new b(0, 0);

        /* renamed from: a, reason: collision with root package name */
        public final int f4519a;

        /* renamed from: b, reason: collision with root package name */
        public final int f4520b;

        public b(int i10, int i11) {
            this.f4519a = i10;
            this.f4520b = i11;
        }

        public static b a(k kVar) {
            return b(kVar.with(), kVar.without());
        }

        public static b b(a[] aVarArr, a[] aVarArr2) {
            int i10 = 0;
            for (a aVar : aVarArr) {
                i10 |= 1 << aVar.ordinal();
            }
            int i11 = 0;
            for (a aVar2 : aVarArr2) {
                i11 |= 1 << aVar2.ordinal();
            }
            return new b(i10, i11);
        }

        public static b c() {
            return f4518c;
        }

        public Boolean d(a aVar) {
            int ordinal = 1 << aVar.ordinal();
            if ((this.f4520b & ordinal) != 0) {
                return Boolean.FALSE;
            }
            if ((ordinal & this.f4519a) != 0) {
                return Boolean.TRUE;
            }
            return null;
        }

        public b e(b bVar) {
            if (bVar == null) {
                return this;
            }
            int i10 = bVar.f4520b;
            int i11 = bVar.f4519a;
            if (i10 == 0 && i11 == 0) {
                return this;
            }
            int i12 = this.f4519a;
            if (i12 == 0 && this.f4520b == 0) {
                return bVar;
            }
            int i13 = ((i10 ^ (-1)) & i12) | i11;
            int i14 = this.f4520b;
            int i15 = i10 | ((i11 ^ (-1)) & i14);
            return (i13 == i12 && i15 == i14) ? this : new b(i13, i15);
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj == null || obj.getClass() != getClass()) {
                return false;
            }
            b bVar = (b) obj;
            return bVar.f4519a == this.f4519a && bVar.f4520b == this.f4520b;
        }

        public int hashCode() {
            return this.f4520b + this.f4519a;
        }

        public String toString() {
            return this == f4518c ? "EMPTY" : String.format("(enabled=0x%x,disabled=0x%x)", Integer.valueOf(this.f4519a), Integer.valueOf(this.f4520b));
        }
    }

    public enum c {
        ANY,
        NATURAL,
        SCALAR,
        ARRAY,
        OBJECT,
        NUMBER,
        NUMBER_FLOAT,
        NUMBER_INT,
        STRING,
        BOOLEAN,
        BINARY;

        public boolean a() {
            return this == NUMBER || this == NUMBER_INT || this == NUMBER_FLOAT;
        }
    }

    public static class d implements Serializable {

        /* renamed from: h, reason: collision with root package name */
        public static final d f4533h = new d();

        /* renamed from: a, reason: collision with root package name */
        public final String f4534a;

        /* renamed from: b, reason: collision with root package name */
        public final c f4535b;

        /* renamed from: c, reason: collision with root package name */
        public final Locale f4536c;

        /* renamed from: d, reason: collision with root package name */
        public final String f4537d;

        /* renamed from: e, reason: collision with root package name */
        public final Boolean f4538e;

        /* renamed from: f, reason: collision with root package name */
        public final b f4539f;

        /* renamed from: g, reason: collision with root package name */
        public transient TimeZone f4540g;

        public d() {
            this("", c.ANY, "", "", b.c(), null);
        }

        public static boolean a(Object obj, Object obj2) {
            if (obj == null) {
                return obj2 == null;
            }
            if (obj2 == null) {
                return false;
            }
            return obj.equals(obj2);
        }

        public static final d b() {
            return f4533h;
        }

        public static d c(boolean z10) {
            return new d("", null, null, null, null, b.c(), Boolean.valueOf(z10));
        }

        public static final d d(k kVar) {
            return kVar == null ? f4533h : new d(kVar);
        }

        public static d p(d dVar, d dVar2) {
            return dVar == null ? dVar2 : dVar.r(dVar2);
        }

        public Boolean e(a aVar) {
            return this.f4539f.d(aVar);
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj == null || obj.getClass() != getClass()) {
                return false;
            }
            d dVar = (d) obj;
            return this.f4535b == dVar.f4535b && this.f4539f.equals(dVar.f4539f) && a(this.f4538e, dVar.f4538e) && a(this.f4537d, dVar.f4537d) && a(this.f4534a, dVar.f4534a) && a(this.f4540g, dVar.f4540g) && a(this.f4536c, dVar.f4536c);
        }

        public Boolean f() {
            return this.f4538e;
        }

        public Locale g() {
            return this.f4536c;
        }

        public String h() {
            return this.f4534a;
        }

        public int hashCode() {
            String str = this.f4537d;
            int hashCode = str == null ? 1 : str.hashCode();
            String str2 = this.f4534a;
            if (str2 != null) {
                hashCode ^= str2.hashCode();
            }
            int hashCode2 = hashCode + this.f4535b.hashCode();
            Boolean bool = this.f4538e;
            if (bool != null) {
                hashCode2 ^= bool.hashCode();
            }
            Locale locale = this.f4536c;
            if (locale != null) {
                hashCode2 += locale.hashCode();
            }
            return hashCode2 ^ this.f4539f.hashCode();
        }

        public c i() {
            return this.f4535b;
        }

        public TimeZone j() {
            TimeZone timeZone = this.f4540g;
            if (timeZone != null) {
                return timeZone;
            }
            String str = this.f4537d;
            if (str == null) {
                return null;
            }
            TimeZone timeZone2 = TimeZone.getTimeZone(str);
            this.f4540g = timeZone2;
            return timeZone2;
        }

        public boolean k() {
            return this.f4538e != null;
        }

        public boolean l() {
            return this.f4536c != null;
        }

        public boolean m() {
            String str = this.f4534a;
            return str != null && str.length() > 0;
        }

        public boolean n() {
            return this.f4535b != c.ANY;
        }

        public boolean o() {
            String str;
            return (this.f4540g == null && ((str = this.f4537d) == null || str.isEmpty())) ? false : true;
        }

        public d q(Boolean bool) {
            return bool == this.f4538e ? this : new d(this.f4534a, this.f4535b, this.f4536c, this.f4537d, this.f4540g, this.f4539f, bool);
        }

        public final d r(d dVar) {
            d dVar2;
            String str;
            TimeZone timeZone;
            if (dVar == null || dVar == (dVar2 = f4533h) || dVar == this) {
                return this;
            }
            if (this == dVar2) {
                return dVar;
            }
            String str2 = dVar.f4534a;
            if (str2 == null || str2.isEmpty()) {
                str2 = this.f4534a;
            }
            String str3 = str2;
            c cVar = dVar.f4535b;
            if (cVar == c.ANY) {
                cVar = this.f4535b;
            }
            c cVar2 = cVar;
            Locale locale = dVar.f4536c;
            if (locale == null) {
                locale = this.f4536c;
            }
            Locale locale2 = locale;
            b bVar = this.f4539f;
            b e10 = bVar == null ? dVar.f4539f : bVar.e(dVar.f4539f);
            Boolean bool = dVar.f4538e;
            if (bool == null) {
                bool = this.f4538e;
            }
            Boolean bool2 = bool;
            String str4 = dVar.f4537d;
            if (str4 == null || str4.isEmpty()) {
                str = this.f4537d;
                timeZone = this.f4540g;
            } else {
                timeZone = dVar.f4540g;
                str = str4;
            }
            return new d(str3, cVar2, locale2, str, timeZone, e10, bool2);
        }

        public String toString() {
            return String.format("JsonFormat.Value(pattern=%s,shape=%s,lenient=%s,locale=%s,timezone=%s,features=%s)", this.f4534a, this.f4535b, this.f4538e, this.f4536c, this.f4537d, this.f4539f);
        }

        public d(k kVar) {
            this(kVar.pattern(), kVar.shape(), kVar.locale(), kVar.timezone(), b.a(kVar), kVar.lenient().a());
        }

        public d(String str, c cVar, String str2, String str3, b bVar, Boolean bool) {
            this(str, cVar, (str2 == null || str2.length() == 0 || "##default".equals(str2)) ? null : new Locale(str2), (str3 == null || str3.length() == 0 || "##default".equals(str3)) ? null : str3, null, bVar, bool);
        }

        public d(String str, c cVar, Locale locale, String str2, TimeZone timeZone, b bVar, Boolean bool) {
            this.f4534a = str == null ? "" : str;
            this.f4535b = cVar == null ? c.ANY : cVar;
            this.f4536c = locale;
            this.f4540g = timeZone;
            this.f4537d = str2;
            this.f4539f = bVar == null ? b.c() : bVar;
            this.f4538e = bool;
        }
    }

    p0 lenient() default p0.DEFAULT;

    String locale() default "##default";

    String pattern() default "";

    c shape() default c.ANY;

    String timezone() default "##default";

    a[] with() default {};

    a[] without() default {};
}
