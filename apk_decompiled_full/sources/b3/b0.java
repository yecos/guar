package b3;

import java.io.Serializable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes.dex */
public @interface b0 {

    public static class a implements Serializable {

        /* renamed from: c, reason: collision with root package name */
        public static final a f4472c;

        /* renamed from: a, reason: collision with root package name */
        public final j0 f4473a;

        /* renamed from: b, reason: collision with root package name */
        public final j0 f4474b;

        static {
            j0 j0Var = j0.DEFAULT;
            f4472c = new a(j0Var, j0Var);
        }

        public a(j0 j0Var, j0 j0Var2) {
            this.f4473a = j0Var;
            this.f4474b = j0Var2;
        }

        public static boolean a(j0 j0Var, j0 j0Var2) {
            j0 j0Var3 = j0.DEFAULT;
            return j0Var == j0Var3 && j0Var2 == j0Var3;
        }

        public static a b(j0 j0Var, j0 j0Var2) {
            if (j0Var == null) {
                j0Var = j0.DEFAULT;
            }
            if (j0Var2 == null) {
                j0Var2 = j0.DEFAULT;
            }
            return a(j0Var, j0Var2) ? f4472c : new a(j0Var, j0Var2);
        }

        public static a c() {
            return f4472c;
        }

        public static a d(b0 b0Var) {
            return b0Var == null ? f4472c : b(b0Var.nulls(), b0Var.contentNulls());
        }

        public j0 e() {
            j0 j0Var = this.f4474b;
            if (j0Var == j0.DEFAULT) {
                return null;
            }
            return j0Var;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj == null || obj.getClass() != getClass()) {
                return false;
            }
            a aVar = (a) obj;
            return aVar.f4473a == this.f4473a && aVar.f4474b == this.f4474b;
        }

        public j0 f() {
            j0 j0Var = this.f4473a;
            if (j0Var == j0.DEFAULT) {
                return null;
            }
            return j0Var;
        }

        public int hashCode() {
            return this.f4473a.ordinal() + (this.f4474b.ordinal() << 2);
        }

        public String toString() {
            return String.format("JsonSetter.Value(valueNulls=%s,contentNulls=%s)", this.f4473a, this.f4474b);
        }
    }

    j0 contentNulls() default j0.DEFAULT;

    j0 nulls() default j0.DEFAULT;

    String value() default "";
}
