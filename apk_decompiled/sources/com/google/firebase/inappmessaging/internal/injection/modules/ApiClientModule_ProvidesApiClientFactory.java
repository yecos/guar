package com.google.firebase.inappmessaging.internal.injection.modules;

import android.app.Application;
import com.google.firebase.inappmessaging.dagger.internal.Factory;
import com.google.firebase.inappmessaging.dagger.internal.Preconditions;
import com.google.firebase.inappmessaging.internal.ApiClient;
import com.google.firebase.inappmessaging.internal.GrpcClient;
import com.google.firebase.inappmessaging.internal.ProviderInstaller;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ApiClientModule_ProvidesApiClientFactory implements Factory<ApiClient> {
    private final Provider<Application> applicationProvider;
    private final Provider<GrpcClient> grpcClientProvider;
    private final ApiClientModule module;
    private final Provider<ProviderInstaller> providerInstallerProvider;

    public ApiClientModule_ProvidesApiClientFactory(ApiClientModule apiClientModule, Provider<GrpcClient> provider, Provider<Application> provider2, Provider<ProviderInstaller> provider3) {
        this.module = apiClientModule;
        this.grpcClientProvider = provider;
        this.applicationProvider = provider2;
        this.providerInstallerProvider = provider3;
    }

    public static ApiClientModule_ProvidesApiClientFactory create(ApiClientModule apiClientModule, Provider<GrpcClient> provider, Provider<Application> provider2, Provider<ProviderInstaller> provider3) {
        return new ApiClientModule_ProvidesApiClientFactory(apiClientModule, provider, provider2, provider3);
    }

    public static ApiClient providesApiClient(ApiClientModule apiClientModule, Provider<GrpcClient> provider, Application application, ProviderInstaller providerInstaller) {
        return (ApiClient) Preconditions.checkNotNull(apiClientModule.providesApiClient(provider, application, providerInstaller), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // javax.inject.Provider
    public ApiClient get() {
        return providesApiClient(this.module, this.grpcClientProvider, this.applicationProvider.get(), this.providerInstallerProvider.get());
    }
}
