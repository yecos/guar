package com.google.firebase.inappmessaging.internal.injection.modules;

import android.app.Application;
import com.google.firebase.inappmessaging.dagger.Module;
import com.google.firebase.inappmessaging.dagger.Provides;
import com.google.firebase.inappmessaging.internal.ProtoStorageClient;
import com.google.firebase.inappmessaging.internal.injection.qualifiers.CampaignCache;
import com.google.firebase.inappmessaging.internal.injection.qualifiers.ImpressionStore;
import com.google.firebase.inappmessaging.internal.injection.qualifiers.RateLimit;
import javax.inject.Singleton;

@Module
/* loaded from: classes2.dex */
public class ProtoStorageClientModule {
    public static final String CAMPAIGN_CACHE_FILE = "fiam_eligible_campaigns_cache_file";
    public static final String IMPRESSIONS_STORE_FILE = "fiam_impressions_store_file";
    public static final String RATE_LIMIT_STORE_FILE = "rate_limit_store_file";

    @Provides
    @Singleton
    @CampaignCache
    public ProtoStorageClient providesProtoStorageClientForCampaign(Application application) {
        return new ProtoStorageClient(application, CAMPAIGN_CACHE_FILE);
    }

    @Provides
    @Singleton
    @ImpressionStore
    public ProtoStorageClient providesProtoStorageClientForImpressionStore(Application application) {
        return new ProtoStorageClient(application, IMPRESSIONS_STORE_FILE);
    }

    @Provides
    @RateLimit
    @Singleton
    public ProtoStorageClient providesProtoStorageClientForLimiterStore(Application application) {
        return new ProtoStorageClient(application, RATE_LIMIT_STORE_FILE);
    }
}
