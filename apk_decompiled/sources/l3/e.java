package l3;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes.dex */
public @interface e {

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final String f15921a;

        /* renamed from: b, reason: collision with root package name */
        public final String f15922b;

        public a(e eVar) {
            this(eVar.buildMethodName(), eVar.withPrefix());
        }

        public a(String str, String str2) {
            this.f15921a = str;
            this.f15922b = str2;
        }
    }

    String buildMethodName() default "build";

    String withPrefix() default "with";
}
