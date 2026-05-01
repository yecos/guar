package com.google.firebase.inappmessaging.internal.injection.modules;

import com.google.firebase.inappmessaging.dagger.internal.Factory;
import com.google.firebase.inappmessaging.dagger.internal.Preconditions;
import com.google.firebase.inappmessaging.internal.time.Clock;

/* loaded from: classes2.dex */
public final class SystemClockModule_ProvidesSystemClockModuleFactory implements Factory<Clock> {
    private final SystemClockModule module;

    public SystemClockModule_ProvidesSystemClockModuleFactory(SystemClockModule systemClockModule) {
        this.module = systemClockModule;
    }

    public static SystemClockModule_ProvidesSystemClockModuleFactory create(SystemClockModule systemClockModule) {
        return new SystemClockModule_ProvidesSystemClockModuleFactory(systemClockModule);
    }

    public static Clock providesSystemClockModule(SystemClockModule systemClockModule) {
        return (Clock) Preconditions.checkNotNull(systemClockModule.providesSystemClockModule(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // javax.inject.Provider
    public Clock get() {
        return providesSystemClockModule(this.module);
    }
}
