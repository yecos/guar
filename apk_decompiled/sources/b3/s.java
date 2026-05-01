package b3;

import java.io.Serializable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes.dex */
public @interface s {

    public static class a implements Serializable {

        /* renamed from: b, reason: collision with root package name */
        public static final a f4577b = new a(null);

        /* renamed from: a, reason: collision with root package name */
        public final Set f4578a;

        public a(Set set) {
            this.f4578a = set;
        }

        public static Set a(String[] strArr) {
            if (strArr == null || strArr.length == 0) {
                return Collections.emptySet();
            }
            HashSet hashSet = new HashSet(strArr.length);
            for (String str : strArr) {
                hashSet.add(str);
            }
            return hashSet;
        }

        public static boolean b(Set set, Set set2) {
            return set == null ? set2 == null : set.equals(set2);
        }

        public static a c() {
            return f4577b;
        }

        public static a d(s sVar) {
            return sVar == null ? f4577b : new a(a(sVar.value()));
        }

        public Set e() {
            return this.f4578a;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            return obj != null && obj.getClass() == getClass() && b(this.f4578a, ((a) obj).f4578a);
        }

        public int hashCode() {
            Set set = this.f4578a;
            if (set == null) {
                return 0;
            }
            return set.size();
        }

        public String toString() {
            return String.format("JsonIncludeProperties.Value(included=%s)", this.f4578a);
        }
    }

    String[] value() default {};
}
