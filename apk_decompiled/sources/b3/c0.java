package b3;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes.dex */
public @interface c0 {

    public @interface a {
        String name() default "";

        String[] names() default {};

        Class value();
    }

    a[] value();
}
