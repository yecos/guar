package b3;

import java.io.Serializable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes.dex */
public @interface b {

    public static class a implements Serializable {

        /* renamed from: c, reason: collision with root package name */
        public static final a f4469c = new a(null, null);

        /* renamed from: a, reason: collision with root package name */
        public final Object f4470a;

        /* renamed from: b, reason: collision with root package name */
        public final Boolean f4471b;

        public a(Object obj, Boolean bool) {
            this.f4470a = obj;
            this.f4471b = bool;
        }

        public static boolean a(Object obj, Boolean bool) {
            return obj == null && bool == null;
        }

        public static a b(Object obj, Boolean bool) {
            if ("".equals(obj)) {
                obj = null;
            }
            return a(obj, bool) ? f4469c : new a(obj, bool);
        }

        public static a c(Object obj) {
            return b(obj, null);
        }

        public static a d(b bVar) {
            return bVar == null ? f4469c : b(bVar.value(), bVar.useInput().a());
        }

        public Object e() {
            return this.f4470a;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj != null && obj.getClass() == getClass()) {
                a aVar = (a) obj;
                if (p0.b(this.f4471b, aVar.f4471b)) {
                    Object obj2 = this.f4470a;
                    return obj2 == null ? aVar.f4470a == null : obj2.equals(aVar.f4470a);
                }
            }
            return false;
        }

        public boolean f() {
            return this.f4470a != null;
        }

        public boolean g(boolean z10) {
            Boolean bool = this.f4471b;
            return bool == null ? z10 : bool.booleanValue();
        }

        public a h(Object obj) {
            if (obj == null) {
                if (this.f4470a == null) {
                    return this;
                }
            } else if (obj.equals(this.f4470a)) {
                return this;
            }
            return new a(obj, this.f4471b);
        }

        public int hashCode() {
            Object obj = this.f4470a;
            int hashCode = obj != null ? 1 + obj.hashCode() : 1;
            Boolean bool = this.f4471b;
            return bool != null ? hashCode + bool.hashCode() : hashCode;
        }

        public String toString() {
            return String.format("JacksonInject.Value(id=%s,useInput=%s)", this.f4470a, this.f4471b);
        }
    }

    p0 useInput() default p0.DEFAULT;

    String value() default "";
}
