package com.google.firebase.inappmessaging.display.internal.injection.modules;

import android.app.Application;
import com.bumptech.glide.RequestManager;
import com.google.firebase.inappmessaging.display.dagger.internal.Factory;
import com.google.firebase.inappmessaging.display.dagger.internal.Preconditions;
import com.google.firebase.inappmessaging.display.internal.GlideErrorListener;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class GlideModule_ProvidesGlideRequestManagerFactory implements Factory<RequestManager> {
    private final Provider<Application> applicationProvider;
    private final Provider<GlideErrorListener> glideErrorListenerProvider;
    private final GlideModule module;

    public GlideModule_ProvidesGlideRequestManagerFactory(GlideModule glideModule, Provider<Application> provider, Provider<GlideErrorListener> provider2) {
        this.module = glideModule;
        this.applicationProvider = provider;
        this.glideErrorListenerProvider = provider2;
    }

    public static GlideModule_ProvidesGlideRequestManagerFactory create(GlideModule glideModule, Provider<Application> provider, Provider<GlideErrorListener> provider2) {
        return new GlideModule_ProvidesGlideRequestManagerFactory(glideModule, provider, provider2);
    }

    public static RequestManager providesGlideRequestManager(GlideModule glideModule, Application application, GlideErrorListener glideErrorListener) {
        return (RequestManager) Preconditions.checkNotNull(glideModule.providesGlideRequestManager(application, glideErrorListener), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // javax.inject.Provider
    public RequestManager get() {
        return providesGlideRequestManager(this.module, this.applicationProvider.get(), this.glideErrorListenerProvider.get());
    }
}
