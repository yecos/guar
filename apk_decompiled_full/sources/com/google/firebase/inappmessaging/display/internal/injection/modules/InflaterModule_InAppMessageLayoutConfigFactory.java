package com.google.firebase.inappmessaging.display.internal.injection.modules;

import com.google.firebase.inappmessaging.display.dagger.internal.Factory;
import com.google.firebase.inappmessaging.display.dagger.internal.Preconditions;
import com.google.firebase.inappmessaging.display.internal.InAppMessageLayoutConfig;

/* loaded from: classes2.dex */
public final class InflaterModule_InAppMessageLayoutConfigFactory implements Factory<InAppMessageLayoutConfig> {
    private final InflaterModule module;

    public InflaterModule_InAppMessageLayoutConfigFactory(InflaterModule inflaterModule) {
        this.module = inflaterModule;
    }

    public static InflaterModule_InAppMessageLayoutConfigFactory create(InflaterModule inflaterModule) {
        return new InflaterModule_InAppMessageLayoutConfigFactory(inflaterModule);
    }

    public static InAppMessageLayoutConfig inAppMessageLayoutConfig(InflaterModule inflaterModule) {
        return (InAppMessageLayoutConfig) Preconditions.checkNotNull(inflaterModule.inAppMessageLayoutConfig(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // javax.inject.Provider
    public InAppMessageLayoutConfig get() {
        return inAppMessageLayoutConfig(this.module);
    }
}
