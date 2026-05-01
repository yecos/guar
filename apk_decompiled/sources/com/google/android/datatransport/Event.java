package com.google.android.datatransport;

import com.google.auto.value.AutoValue;

@AutoValue
/* loaded from: classes.dex */
public abstract class Event<T> {
    public static <T> Event<T> ofData(int i10, T t10) {
        return new AutoValue_Event(Integer.valueOf(i10), t10, Priority.DEFAULT);
    }

    public static <T> Event<T> ofTelemetry(int i10, T t10) {
        return new AutoValue_Event(Integer.valueOf(i10), t10, Priority.VERY_LOW);
    }

    public static <T> Event<T> ofUrgent(int i10, T t10) {
        return new AutoValue_Event(Integer.valueOf(i10), t10, Priority.HIGHEST);
    }

    public abstract Integer getCode();

    public abstract T getPayload();

    public abstract Priority getPriority();

    public static <T> Event<T> ofData(T t10) {
        return new AutoValue_Event(null, t10, Priority.DEFAULT);
    }

    public static <T> Event<T> ofTelemetry(T t10) {
        return new AutoValue_Event(null, t10, Priority.VERY_LOW);
    }

    public static <T> Event<T> ofUrgent(T t10) {
        return new AutoValue_Event(null, t10, Priority.HIGHEST);
    }
}
