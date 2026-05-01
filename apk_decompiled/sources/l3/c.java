package l3;

import d4.j;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import k3.k;
import k3.p;

@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes.dex */
public @interface c {
    Class as() default Void.class;

    Class builder() default Void.class;

    Class contentAs() default Void.class;

    Class contentConverter() default j.a.class;

    Class contentUsing() default k.a.class;

    Class converter() default j.a.class;

    Class keyAs() default Void.class;

    Class keyUsing() default p.a.class;

    Class using() default k.a.class;
}
