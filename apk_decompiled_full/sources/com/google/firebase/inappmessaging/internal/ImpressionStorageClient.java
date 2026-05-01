package com.google.firebase.inappmessaging.internal;

import com.google.firebase.inappmessaging.internal.injection.qualifiers.ImpressionStore;
import com.google.internal.firebase.inappmessaging.v1.CampaignProto;
import com.google.internal.firebase.inappmessaging.v1.sdkserving.CampaignImpression;
import com.google.internal.firebase.inappmessaging.v1.sdkserving.CampaignImpressionList;
import com.google.internal.firebase.inappmessaging.v1.sdkserving.FetchEligibleCampaignsResponse;
import io.reactivex.Completable;
import io.reactivex.CompletableSource;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.HashSet;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes2.dex */
public class ImpressionStorageClient {
    private static final CampaignImpressionList EMPTY_IMPRESSIONS = CampaignImpressionList.getDefaultInstance();
    private Maybe<CampaignImpressionList> cachedImpressionsMaybe = Maybe.empty();
    private final ProtoStorageClient storageClient;

    @Inject
    public ImpressionStorageClient(@ImpressionStore ProtoStorageClient protoStorageClient) {
        this.storageClient = protoStorageClient;
    }

    private static CampaignImpressionList appendImpression(CampaignImpressionList campaignImpressionList, CampaignImpression campaignImpression) {
        return CampaignImpressionList.newBuilder(campaignImpressionList).addAlreadySeenCampaigns(campaignImpression).build();
    }

    private void clearInMemCache() {
        this.cachedImpressionsMaybe = Maybe.empty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: initInMemCache, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public void lambda$storeImpression$0(CampaignImpressionList campaignImpressionList) {
        this.cachedImpressionsMaybe = Maybe.just(campaignImpressionList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ CompletableSource lambda$clearImpressions$4(HashSet hashSet, CampaignImpressionList campaignImpressionList) {
        Logging.logd("Existing impressions: " + campaignImpressionList.toString());
        CampaignImpressionList.Builder newBuilder = CampaignImpressionList.newBuilder();
        for (CampaignImpression campaignImpression : campaignImpressionList.getAlreadySeenCampaignsList()) {
            if (!hashSet.contains(campaignImpression.getCampaignId())) {
                newBuilder.addAlreadySeenCampaigns(campaignImpression);
            }
        }
        final CampaignImpressionList build = newBuilder.build();
        Logging.logd("New cleared impression list: " + build.toString());
        return this.storageClient.write(build).doOnComplete(new Action() { // from class: com.google.firebase.inappmessaging.internal.d0
            @Override // io.reactivex.functions.Action
            public final void run() {
                ImpressionStorageClient.this.lambda$clearImpressions$3(build);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getAllImpressions$2(Throwable th) {
        clearInMemCache();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ CompletableSource lambda$storeImpression$1(CampaignImpression campaignImpression, CampaignImpressionList campaignImpressionList) {
        final CampaignImpressionList appendImpression = appendImpression(campaignImpressionList, campaignImpression);
        return this.storageClient.write(appendImpression).doOnComplete(new Action() { // from class: com.google.firebase.inappmessaging.internal.b0
            @Override // io.reactivex.functions.Action
            public final void run() {
                ImpressionStorageClient.this.lambda$storeImpression$0(appendImpression);
            }
        });
    }

    public Completable clearImpressions(FetchEligibleCampaignsResponse fetchEligibleCampaignsResponse) {
        final HashSet hashSet = new HashSet();
        for (CampaignProto.ThickContent thickContent : fetchEligibleCampaignsResponse.getMessagesList()) {
            hashSet.add(thickContent.getPayloadCase().equals(CampaignProto.ThickContent.PayloadCase.VANILLA_PAYLOAD) ? thickContent.getVanillaPayload().getCampaignId() : thickContent.getExperimentalPayload().getCampaignId());
        }
        Logging.logd("Potential impressions to clear: " + hashSet.toString());
        return getAllImpressions().defaultIfEmpty(EMPTY_IMPRESSIONS).flatMapCompletable(new Function() { // from class: com.google.firebase.inappmessaging.internal.h0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                CompletableSource lambda$clearImpressions$4;
                lambda$clearImpressions$4 = ImpressionStorageClient.this.lambda$clearImpressions$4(hashSet, (CampaignImpressionList) obj);
                return lambda$clearImpressions$4;
            }
        });
    }

    public Maybe<CampaignImpressionList> getAllImpressions() {
        return this.cachedImpressionsMaybe.switchIfEmpty(this.storageClient.read(CampaignImpressionList.parser()).doOnSuccess(new Consumer() { // from class: com.google.firebase.inappmessaging.internal.z
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ImpressionStorageClient.this.lambda$storeImpression$0((CampaignImpressionList) obj);
            }
        })).doOnError(new Consumer() { // from class: com.google.firebase.inappmessaging.internal.a0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ImpressionStorageClient.this.lambda$getAllImpressions$2((Throwable) obj);
            }
        });
    }

    public Single<Boolean> isImpressed(CampaignProto.ThickContent thickContent) {
        return getAllImpressions().map(new Function() { // from class: com.google.firebase.inappmessaging.internal.e0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return ((CampaignImpressionList) obj).getAlreadySeenCampaignsList();
            }
        }).flatMapObservable(new Function() { // from class: com.google.firebase.inappmessaging.internal.f0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return Observable.fromIterable((List) obj);
            }
        }).map(new Function() { // from class: com.google.firebase.inappmessaging.internal.g0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return ((CampaignImpression) obj).getCampaignId();
            }
        }).contains(thickContent.getPayloadCase().equals(CampaignProto.ThickContent.PayloadCase.VANILLA_PAYLOAD) ? thickContent.getVanillaPayload().getCampaignId() : thickContent.getExperimentalPayload().getCampaignId());
    }

    public Completable storeImpression(final CampaignImpression campaignImpression) {
        return getAllImpressions().defaultIfEmpty(EMPTY_IMPRESSIONS).flatMapCompletable(new Function() { // from class: com.google.firebase.inappmessaging.internal.c0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                CompletableSource lambda$storeImpression$1;
                lambda$storeImpression$1 = ImpressionStorageClient.this.lambda$storeImpression$1(campaignImpression, (CampaignImpressionList) obj);
                return lambda$storeImpression$1;
            }
        });
    }
}
