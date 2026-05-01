package com.google.firebase.inappmessaging.internal.injection.modules;

import com.google.firebase.inappmessaging.dagger.internal.Factory;
import com.google.firebase.inappmessaging.dagger.internal.Preconditions;
import javax.inject.Provider;
import y8.d;

/* loaded from: classes2.dex */
public final class GrpcChannelModule_ProvidesGrpcChannelFactory implements Factory<d> {
    private final Provider<String> hostProvider;
    private final GrpcChannelModule module;

    public GrpcChannelModule_ProvidesGrpcChannelFactory(GrpcChannelModule grpcChannelModule, Provider<String> provider) {
        this.module = grpcChannelModule;
        this.hostProvider = provider;
    }

    public static GrpcChannelModule_ProvidesGrpcChannelFactory create(GrpcChannelModule grpcChannelModule, Provider<String> provider) {
        return new GrpcChannelModule_ProvidesGrpcChannelFactory(grpcChannelModule, provider);
    }

    public static d providesGrpcChannel(GrpcChannelModule grpcChannelModule, String str) {
        return (d) Preconditions.checkNotNull(grpcChannelModule.providesGrpcChannel(str), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // javax.inject.Provider
    public d get() {
        return providesGrpcChannel(this.module, this.hostProvider.get());
    }
}
