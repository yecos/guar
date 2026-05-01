package l3;

import d4.j;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import k3.o;

@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes.dex */
public @interface f {

    public enum a {
        ALWAYS,
        NON_NULL,
        NON_DEFAULT,
        NON_EMPTY,
        DEFAULT_INCLUSION
    }

    public enum b {
        DYNAMIC,
        STATIC,
        DEFAULT_TYPING
    }

    Class as() default Void.class;

    Class contentAs() default Void.class;

    Class contentConverter() default j.a.class;

    Class contentUsing() default o.a.class;

    Class converter() default j.a.class;

    a include() default a.DEFAULT_INCLUSION;

    Class keyAs() default Void.class;

    Class keyUsing() default o.a.class;

    Class nullsUsing() default o.a.class;

    b typing() default b.DEFAULT_TYPING;

    Class using() default o.a.class;
}
