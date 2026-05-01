package com.raizlabs.android.dbflow.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes.dex */
public @interface Column {
    Collate collate() default Collate.NONE;

    String defaultValue() default "";

    String getterName() default "";

    int length() default -1;

    String name() default "";

    String setterName() default "";

    Class<? extends com.raizlabs.android.dbflow.converter.TypeConverter> typeConverter() default com.raizlabs.android.dbflow.converter.TypeConverter.class;
}
