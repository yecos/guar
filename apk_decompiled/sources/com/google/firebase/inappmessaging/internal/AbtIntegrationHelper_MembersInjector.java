package com.google.firebase.inappmessaging.internal;

import com.google.firebase.annotations.concurrent.Blocking;
import com.google.firebase.inappmessaging.dagger.MembersInjector;
import com.google.firebase.inappmessaging.dagger.internal.InjectedFieldSignature;
import java.util.concurrent.Executor;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class AbtIntegrationHelper_MembersInjector implements MembersInjector<AbtIntegrationHelper> {
    private final Provider<Executor> executorProvider;

    public AbtIntegrationHelper_MembersInjector(Provider<Executor> provider) {
        this.executorProvider = provider;
    }

    public static MembersInjector<AbtIntegrationHelper> create(Provider<Executor> provider) {
        return new AbtIntegrationHelper_MembersInjector(provider);
    }

    @Blocking
    @InjectedFieldSignature("com.google.firebase.inappmessaging.internal.AbtIntegrationHelper.executor")
    public static void injectExecutor(AbtIntegrationHelper abtIntegrationHelper, Executor executor) {
        abtIntegrationHelper.executor = executor;
    }

    @Override // com.google.firebase.inappmessaging.dagger.MembersInjector
    public void injectMembers(AbtIntegrationHelper abtIntegrationHelper) {
        injectExecutor(abtIntegrationHelper, this.executorProvider.get());
    }
}
