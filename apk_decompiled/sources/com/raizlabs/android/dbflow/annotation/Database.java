package com.raizlabs.android.dbflow.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes.dex */
public @interface Database {
    boolean backupEnabled() default false;

    boolean consistencyCheckEnabled() default false;

    @Deprecated
    String databaseExtension() default "";

    boolean foreignKeyConstraintsEnforced() default false;

    @Deprecated
    String generatedClassSeparator() default "_";

    @Deprecated
    boolean inMemory() default false;

    ConflictAction insertConflict() default ConflictAction.NONE;

    @Deprecated
    String name() default "";

    ConflictAction updateConflict() default ConflictAction.NONE;

    int version();
}
