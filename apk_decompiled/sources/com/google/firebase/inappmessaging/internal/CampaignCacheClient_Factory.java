package com.google.firebase.inappmessaging.internal;

import android.app.Application;
import com.google.firebase.inappmessaging.dagger.internal.Factory;
import com.google.firebase.inappmessaging.internal.time.Clock;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class CampaignCacheClient_Factory implements Factory<CampaignCacheClient> {
    private final Provider<Application> applicationProvider;
    private final Provider<Clock> clockProvider;
    private final Provider<ProtoStorageClient> storageClientProvider;

    public CampaignCacheClient_Factory(Provider<ProtoStorageClient> provider, Provider<Application> provider2, Provider<Clock> provider3) {
        this.storageClientProvider = provider;
        this.applicationProvider = provider2;
        this.clockProvider = provider3;
    }

    public static CampaignCacheClient_Factory create(Provider<ProtoStorageClient> provider, Provider<Application> provider2, Provider<Clock> provider3) {
        return new CampaignCacheClient_Factory(provider, provider2, provider3);
    }

    public static CampaignCacheClient newInstance(ProtoStorageClient protoStorageClient, Application application, Clock clock) {
        return new CampaignCacheClient(protoStorageClient, application, clock);
    }

    @Override // javax.inject.Provider
    public CampaignCacheClient get() {
        return newInstance(this.storageClientProvider.get(), this.applicationProvider.get(), this.clockProvider.get());
    }
}
