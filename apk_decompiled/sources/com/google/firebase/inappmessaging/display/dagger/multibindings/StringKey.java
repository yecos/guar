package com.google.firebase.inappmessaging.display.dagger.multibindings;

import com.google.firebase.inappmessaging.display.dagger.MapKey;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Documented
@Retention(RetentionPolicy.RUNTIME)
@MapKey
/* loaded from: classes.dex */
public @interface StringKey {
    String value();
}
