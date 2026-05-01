package com.google.firebase.inappmessaging.model;

import com.google.auto.value.AutoValue;
import com.google.firebase.inappmessaging.model.AutoValue_RateLimit;

@AutoValue
/* loaded from: classes2.dex */
public abstract class RateLimit {

    @AutoValue.Builder
    public static abstract class Builder {
        public abstract RateLimit build();

        public abstract Builder setLimit(long j10);

        public abstract Builder setLimiterKey(String str);

        public abstract Builder setTimeToLiveMillis(long j10);
    }

    public static Builder builder() {
        return new AutoValue_RateLimit.Builder();
    }

    public abstract long limit();

    public abstract String limiterKey();

    public abstract long timeToLiveMillis();
}
