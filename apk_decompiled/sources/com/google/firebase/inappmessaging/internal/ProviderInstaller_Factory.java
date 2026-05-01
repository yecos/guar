package com.google.firebase.inappmessaging.internal;

import android.app.Application;
import com.google.firebase.inappmessaging.dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ProviderInstaller_Factory implements Factory<ProviderInstaller> {
    private final Provider<Application> applicationProvider;

    public ProviderInstaller_Factory(Provider<Application> provider) {
        this.applicationProvider = provider;
    }

    public static ProviderInstaller_Factory create(Provider<Application> provider) {
        return new ProviderInstaller_Factory(provider);
    }

    public static ProviderInstaller newInstance(Application application) {
        return new ProviderInstaller(application);
    }

    @Override // javax.inject.Provider
    public ProviderInstaller get() {
        return newInstance(this.applicationProvider.get());
    }
}
