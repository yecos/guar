package com.google.firebase.inappmessaging.internal;

import android.app.Application;
import com.google.firebase.inappmessaging.internal.injection.modules.ProtoStorageClientModule;
import com.google.firebase.inappmessaging.internal.injection.qualifiers.CampaignCache;
import com.google.firebase.inappmessaging.internal.time.Clock;
import com.google.internal.firebase.inappmessaging.v1.sdkserving.FetchEligibleCampaignsResponse;
import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;
import java.io.File;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@ThreadSafe
/* loaded from: classes2.dex */
public class CampaignCacheClient {
    private final Application application;

    @Nullable
    private FetchEligibleCampaignsResponse cachedResponse;
    private final Clock clock;
    private final ProtoStorageClient storageClient;

    @Inject
    public CampaignCacheClient(@CampaignCache ProtoStorageClient protoStorageClient, Application application, Clock clock) {
        this.storageClient = protoStorageClient;
        this.application = application;
        this.clock = clock;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isResponseValid(FetchEligibleCampaignsResponse fetchEligibleCampaignsResponse) {
        long expirationEpochTimestampMillis = fetchEligibleCampaignsResponse.getExpirationEpochTimestampMillis();
        long now = this.clock.now();
        File file = new File(this.application.getApplicationContext().getFilesDir(), ProtoStorageClientModule.CAMPAIGN_CACHE_FILE);
        return expirationEpochTimestampMillis != 0 ? now < expirationEpochTimestampMillis : !file.exists() || now < file.lastModified() + TimeUnit.DAYS.toMillis(1L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ FetchEligibleCampaignsResponse lambda$get$1() {
        return this.cachedResponse;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$get$2(FetchEligibleCampaignsResponse fetchEligibleCampaignsResponse) {
        this.cachedResponse = fetchEligibleCampaignsResponse;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$get$3(Throwable th) {
        this.cachedResponse = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$put$0(FetchEligibleCampaignsResponse fetchEligibleCampaignsResponse) {
        this.cachedResponse = fetchEligibleCampaignsResponse;
    }

    public Maybe<FetchEligibleCampaignsResponse> get() {
        return Maybe.fromCallable(new Callable() { // from class: com.google.firebase.inappmessaging.internal.d
            @Override // java.util.concurrent.Callable
            public final Object call() {
                FetchEligibleCampaignsResponse lambda$get$1;
                lambda$get$1 = CampaignCacheClient.this.lambda$get$1();
                return lambda$get$1;
            }
        }).switchIfEmpty(this.storageClient.read(FetchEligibleCampaignsResponse.parser()).doOnSuccess(new Consumer() { // from class: com.google.firebase.inappmessaging.internal.e
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                CampaignCacheClient.this.lambda$get$2((FetchEligibleCampaignsResponse) obj);
            }
        })).filter(new Predicate() { // from class: com.google.firebase.inappmessaging.internal.f
            @Override // io.reactivex.functions.Predicate
            public final boolean test(Object obj) {
                boolean isResponseValid;
                isResponseValid = CampaignCacheClient.this.isResponseValid((FetchEligibleCampaignsResponse) obj);
                return isResponseValid;
            }
        }).doOnError(new Consumer() { // from class: com.google.firebase.inappmessaging.internal.g
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                CampaignCacheClient.this.lambda$get$3((Throwable) obj);
            }
        });
    }

    public Completable put(final FetchEligibleCampaignsResponse fetchEligibleCampaignsResponse) {
        return this.storageClient.write(fetchEligibleCampaignsResponse).doOnComplete(new Action() { // from class: com.google.firebase.inappmessaging.internal.c
            @Override // io.reactivex.functions.Action
            public final void run() {
                CampaignCacheClient.this.lambda$put$0(fetchEligibleCampaignsResponse);
            }
        });
    }
}
