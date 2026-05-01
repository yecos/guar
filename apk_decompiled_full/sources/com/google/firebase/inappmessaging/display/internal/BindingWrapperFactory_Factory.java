package com.google.firebase.inappmessaging.display.internal;

import android.app.Application;
import com.google.firebase.inappmessaging.display.dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class BindingWrapperFactory_Factory implements Factory<BindingWrapperFactory> {
    private final Provider<Application> applicationProvider;

    public BindingWrapperFactory_Factory(Provider<Application> provider) {
        this.applicationProvider = provider;
    }

    public static BindingWrapperFactory_Factory create(Provider<Application> provider) {
        return new BindingWrapperFactory_Factory(provider);
    }

    public static BindingWrapperFactory newInstance(Application application) {
        return new BindingWrapperFactory(application);
    }

    @Override // javax.inject.Provider
    public BindingWrapperFactory get() {
        return newInstance(this.applicationProvider.get());
    }
}
