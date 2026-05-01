package com.raizlabs.android.dbflow.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes.dex */
public @interface ForeignKeyReference {
    String columnName();

    String foreignKeyColumnName();

    NotNull notNull() default @NotNull(onNullConflict = ConflictAction.NONE);
}
