package com.raizlabs.android.dbflow.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.CLASS)
/* loaded from: classes.dex */
public @interface ColumnMapReference {
    String columnMapFieldName();

    String columnName();

    NotNull notNull() default @NotNull(onNullConflict = ConflictAction.NONE);
}
