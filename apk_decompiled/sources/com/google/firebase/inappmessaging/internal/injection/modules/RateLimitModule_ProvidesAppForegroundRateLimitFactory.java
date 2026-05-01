package com.google.firebase.inappmessaging.internal.injection.modules;

import com.google.firebase.inappmessaging.dagger.internal.Factory;
import com.google.firebase.inappmessaging.dagger.internal.Preconditions;
import com.google.firebase.inappmessaging.model.RateLimit;

/* loaded from: classes2.dex */
public final class RateLimitModule_ProvidesAppForegroundRateLimitFactory implements Factory<RateLimit> {
    private final RateLimitModule module;

    public RateLimitModule_ProvidesAppForegroundRateLimitFactory(RateLimitModule rateLimitModule) {
        this.module = rateLimitModule;
    }

    public static RateLimitModule_ProvidesAppForegroundRateLimitFactory create(RateLimitModule rateLimitModule) {
        return new RateLimitModule_ProvidesAppForegroundRateLimitFactory(rateLimitModule);
    }

    public static RateLimit providesAppForegroundRateLimit(RateLimitModule rateLimitModule) {
        return (RateLimit) Preconditions.checkNotNull(rateLimitModule.providesAppForegroundRateLimit(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // javax.inject.Provider
    public RateLimit get() {
        return providesAppForegroundRateLimit(this.module);
    }
}
