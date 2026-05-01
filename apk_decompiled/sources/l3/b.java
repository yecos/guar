package l3;

import b3.r;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes.dex */
public @interface b {

    public @interface a {
        r.a include() default r.a.NON_NULL;

        String propName() default "";

        String propNamespace() default "";

        boolean required() default false;

        String value();
    }

    /* renamed from: l3.b$b, reason: collision with other inner class name */
    public @interface InterfaceC0270b {
        r.a include() default r.a.NON_NULL;

        String name() default "";

        String namespace() default "";

        boolean required() default false;

        Class type() default Object.class;

        Class value();
    }

    a[] attrs() default {};

    boolean prepend() default false;

    InterfaceC0270b[] props() default {};
}
