package com.google.firebase.inappmessaging.internal;

import android.text.TextUtils;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.annotations.concurrent.Blocking;
import com.google.firebase.inappmessaging.CommonTypesProto;
import com.google.firebase.inappmessaging.MessagesProto;
import com.google.firebase.inappmessaging.internal.injection.qualifiers.AppForeground;
import com.google.firebase.inappmessaging.internal.injection.qualifiers.ProgrammaticTrigger;
import com.google.firebase.inappmessaging.internal.injection.scopes.FirebaseAppScope;
import com.google.firebase.inappmessaging.internal.time.Clock;
import com.google.firebase.inappmessaging.model.InAppMessage;
import com.google.firebase.inappmessaging.model.MessageType;
import com.google.firebase.inappmessaging.model.ProtoMarshallerClient;
import com.google.firebase.inappmessaging.model.RateLimit;
import com.google.firebase.inappmessaging.model.TriggeredInAppMessage;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.installations.InstallationTokenResult;
import com.google.internal.firebase.inappmessaging.v1.CampaignProto;
import com.google.internal.firebase.inappmessaging.v1.sdkserving.CampaignImpressionList;
import com.google.internal.firebase.inappmessaging.v1.sdkserving.FetchEligibleCampaignsResponse;
import io.reactivex.Completable;
import io.reactivex.CompletableSource;
import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.MaybeEmitter;
import io.reactivex.MaybeOnSubscribe;
import io.reactivex.MaybeSource;
import io.reactivex.Single;
import io.reactivex.flowables.ConnectableFlowable;
import io.reactivex.functions.Action;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import java.util.Comparator;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.Executor;
import javax.inject.Inject;

@FirebaseAppScope
/* loaded from: classes2.dex */
public class InAppMessageStreamManager {
    public static final String ON_FOREGROUND = "ON_FOREGROUND";
    private final AbtIntegrationHelper abtIntegrationHelper;
    private final AnalyticsEventsManager analyticsEventsManager;
    private final ApiClient apiClient;
    private final ConnectableFlowable<String> appForegroundEventFlowable;
    private final RateLimit appForegroundRateLimit;

    @Blocking
    private final Executor blockingExecutor;
    private final CampaignCacheClient campaignCacheClient;
    private final Clock clock;
    private final DataCollectionHelper dataCollectionHelper;
    private final FirebaseInstallationsApi firebaseInstallations;
    private final ImpressionStorageClient impressionStorageClient;
    private final ConnectableFlowable<String> programmaticTriggerEventFlowable;
    private final RateLimiterClient rateLimiterClient;
    private final Schedulers schedulers;
    private final TestDeviceHelper testDeviceHelper;

    /* renamed from: com.google.firebase.inappmessaging.internal.InAppMessageStreamManager$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$firebase$inappmessaging$MessagesProto$Content$MessageDetailsCase;

        static {
            int[] iArr = new int[MessagesProto.Content.MessageDetailsCase.values().length];
            $SwitchMap$com$google$firebase$inappmessaging$MessagesProto$Content$MessageDetailsCase = iArr;
            try {
                iArr[MessagesProto.Content.MessageDetailsCase.BANNER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$firebase$inappmessaging$MessagesProto$Content$MessageDetailsCase[MessagesProto.Content.MessageDetailsCase.IMAGE_ONLY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$firebase$inappmessaging$MessagesProto$Content$MessageDetailsCase[MessagesProto.Content.MessageDetailsCase.MODAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$firebase$inappmessaging$MessagesProto$Content$MessageDetailsCase[MessagesProto.Content.MessageDetailsCase.CARD.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    @Inject
    public InAppMessageStreamManager(@AppForeground ConnectableFlowable<String> connectableFlowable, @ProgrammaticTrigger ConnectableFlowable<String> connectableFlowable2, CampaignCacheClient campaignCacheClient, Clock clock, ApiClient apiClient, AnalyticsEventsManager analyticsEventsManager, Schedulers schedulers, ImpressionStorageClient impressionStorageClient, RateLimiterClient rateLimiterClient, @AppForeground RateLimit rateLimit, TestDeviceHelper testDeviceHelper, FirebaseInstallationsApi firebaseInstallationsApi, DataCollectionHelper dataCollectionHelper, AbtIntegrationHelper abtIntegrationHelper, @Blocking Executor executor) {
        this.appForegroundEventFlowable = connectableFlowable;
        this.programmaticTriggerEventFlowable = connectableFlowable2;
        this.campaignCacheClient = campaignCacheClient;
        this.clock = clock;
        this.apiClient = apiClient;
        this.analyticsEventsManager = analyticsEventsManager;
        this.schedulers = schedulers;
        this.impressionStorageClient = impressionStorageClient;
        this.rateLimiterClient = rateLimiterClient;
        this.appForegroundRateLimit = rateLimit;
        this.testDeviceHelper = testDeviceHelper;
        this.dataCollectionHelper = dataCollectionHelper;
        this.firebaseInstallations = firebaseInstallationsApi;
        this.abtIntegrationHelper = abtIntegrationHelper;
        this.blockingExecutor = executor;
    }

    public static FetchEligibleCampaignsResponse cacheExpiringResponse() {
        return FetchEligibleCampaignsResponse.newBuilder().setExpirationEpochTimestampMillis(1L).build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int compareByPriority(CampaignProto.ThickContent thickContent, CampaignProto.ThickContent thickContent2) {
        if (thickContent.getIsTestCampaign() && !thickContent2.getIsTestCampaign()) {
            return -1;
        }
        if (!thickContent2.getIsTestCampaign() || thickContent.getIsTestCampaign()) {
            return Integer.compare(thickContent.getPriority().getValue(), thickContent2.getPriority().getValue());
        }
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean containsTriggeringCondition(String str, CampaignProto.ThickContent thickContent) {
        if (isAppForegroundEvent(str) && thickContent.getIsTestCampaign()) {
            return true;
        }
        for (CommonTypesProto.TriggeringCondition triggeringCondition : thickContent.getTriggeringConditionsList()) {
            if (hasFiamTrigger(triggeringCondition, str) || hasAnalyticsTrigger(triggeringCondition, str)) {
                Logging.logd(String.format("The event %s is contained in the list of triggers", str));
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getContentIfNotRateLimited, reason: merged with bridge method [inline-methods] */
    public Maybe<CampaignProto.ThickContent> lambda$createFirebaseInAppMessageStream$12(String str, final CampaignProto.ThickContent thickContent) {
        return (thickContent.getIsTestCampaign() || !isAppForegroundEvent(str)) ? Maybe.just(thickContent) : this.rateLimiterClient.isRateLimited(this.appForegroundRateLimit).doOnSuccess(new Consumer() { // from class: com.google.firebase.inappmessaging.internal.o0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                InAppMessageStreamManager.lambda$getContentIfNotRateLimited$22((Boolean) obj);
            }
        }).onErrorResumeNext(Single.just(Boolean.FALSE)).filter(new Predicate() { // from class: com.google.firebase.inappmessaging.internal.p0
            @Override // io.reactivex.functions.Predicate
            public final boolean test(Object obj) {
                boolean lambda$getContentIfNotRateLimited$23;
                lambda$getContentIfNotRateLimited$23 = InAppMessageStreamManager.lambda$getContentIfNotRateLimited$23((Boolean) obj);
                return lambda$getContentIfNotRateLimited$23;
            }
        }).map(new Function() { // from class: com.google.firebase.inappmessaging.internal.q0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                CampaignProto.ThickContent lambda$getContentIfNotRateLimited$24;
                lambda$getContentIfNotRateLimited$24 = InAppMessageStreamManager.lambda$getContentIfNotRateLimited$24(CampaignProto.ThickContent.this, (Boolean) obj);
                return lambda$getContentIfNotRateLimited$24;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getTriggeredInAppMessageMaybe, reason: merged with bridge method [inline-methods] */
    public Maybe<TriggeredInAppMessage> lambda$createFirebaseInAppMessageStream$14(final String str, Function<CampaignProto.ThickContent, Maybe<CampaignProto.ThickContent>> function, Function<CampaignProto.ThickContent, Maybe<CampaignProto.ThickContent>> function2, Function<CampaignProto.ThickContent, Maybe<CampaignProto.ThickContent>> function3, FetchEligibleCampaignsResponse fetchEligibleCampaignsResponse) {
        return Flowable.fromIterable(fetchEligibleCampaignsResponse.getMessagesList()).filter(new Predicate() { // from class: com.google.firebase.inappmessaging.internal.j0
            @Override // io.reactivex.functions.Predicate
            public final boolean test(Object obj) {
                boolean lambda$getTriggeredInAppMessageMaybe$25;
                lambda$getTriggeredInAppMessageMaybe$25 = InAppMessageStreamManager.this.lambda$getTriggeredInAppMessageMaybe$25((CampaignProto.ThickContent) obj);
                return lambda$getTriggeredInAppMessageMaybe$25;
            }
        }).filter(new Predicate() { // from class: com.google.firebase.inappmessaging.internal.k0
            @Override // io.reactivex.functions.Predicate
            public final boolean test(Object obj) {
                boolean containsTriggeringCondition;
                containsTriggeringCondition = InAppMessageStreamManager.containsTriggeringCondition(str, (CampaignProto.ThickContent) obj);
                return containsTriggeringCondition;
            }
        }).flatMapMaybe(function).flatMapMaybe(function2).flatMapMaybe(function3).sorted(new Comparator() { // from class: com.google.firebase.inappmessaging.internal.l0
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int compareByPriority;
                compareByPriority = InAppMessageStreamManager.compareByPriority((CampaignProto.ThickContent) obj, (CampaignProto.ThickContent) obj2);
                return compareByPriority;
            }
        }).firstElement().flatMap(new Function() { // from class: com.google.firebase.inappmessaging.internal.m0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                MaybeSource lambda$getTriggeredInAppMessageMaybe$27;
                lambda$getTriggeredInAppMessageMaybe$27 = InAppMessageStreamManager.this.lambda$getTriggeredInAppMessageMaybe$27(str, (CampaignProto.ThickContent) obj);
                return lambda$getTriggeredInAppMessageMaybe$27;
            }
        });
    }

    private static boolean hasAnalyticsTrigger(CommonTypesProto.TriggeringCondition triggeringCondition, String str) {
        return triggeringCondition.getEvent().getName().equals(str);
    }

    private static boolean hasFiamTrigger(CommonTypesProto.TriggeringCondition triggeringCondition, String str) {
        return triggeringCondition.getFiamTrigger().toString().equals(str);
    }

    private static boolean isActive(Clock clock, CampaignProto.ThickContent thickContent) {
        long campaignStartTimeMillis;
        long campaignEndTimeMillis;
        if (thickContent.getPayloadCase().equals(CampaignProto.ThickContent.PayloadCase.VANILLA_PAYLOAD)) {
            campaignStartTimeMillis = thickContent.getVanillaPayload().getCampaignStartTimeMillis();
            campaignEndTimeMillis = thickContent.getVanillaPayload().getCampaignEndTimeMillis();
        } else {
            if (!thickContent.getPayloadCase().equals(CampaignProto.ThickContent.PayloadCase.EXPERIMENTAL_PAYLOAD)) {
                return false;
            }
            campaignStartTimeMillis = thickContent.getExperimentalPayload().getCampaignStartTimeMillis();
            campaignEndTimeMillis = thickContent.getExperimentalPayload().getCampaignEndTimeMillis();
        }
        long now = clock.now();
        return now > campaignStartTimeMillis && now < campaignEndTimeMillis;
    }

    public static boolean isAppForegroundEvent(CommonTypesProto.TriggeringCondition triggeringCondition) {
        return triggeringCondition.getFiamTrigger().toString().equals(ON_FOREGROUND);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$createFirebaseInAppMessageStream$0(String str) {
        Logging.logd("Event Triggered: " + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ CampaignProto.ThickContent lambda$createFirebaseInAppMessageStream$10(CampaignProto.ThickContent thickContent, Boolean bool) {
        return thickContent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Maybe lambda$createFirebaseInAppMessageStream$11(final CampaignProto.ThickContent thickContent) {
        return thickContent.getIsTestCampaign() ? Maybe.just(thickContent) : this.impressionStorageClient.isImpressed(thickContent).doOnError(new Consumer() { // from class: com.google.firebase.inappmessaging.internal.h1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                InAppMessageStreamManager.lambda$createFirebaseInAppMessageStream$7((Throwable) obj);
            }
        }).onErrorResumeNext(Single.just(Boolean.FALSE)).doOnSuccess(new Consumer() { // from class: com.google.firebase.inappmessaging.internal.i1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                InAppMessageStreamManager.logImpressionStatus(CampaignProto.ThickContent.this, (Boolean) obj);
            }
        }).filter(new Predicate() { // from class: com.google.firebase.inappmessaging.internal.j1
            @Override // io.reactivex.functions.Predicate
            public final boolean test(Object obj) {
                boolean lambda$createFirebaseInAppMessageStream$9;
                lambda$createFirebaseInAppMessageStream$9 = InAppMessageStreamManager.lambda$createFirebaseInAppMessageStream$9((Boolean) obj);
                return lambda$createFirebaseInAppMessageStream$9;
            }
        }).map(new Function() { // from class: com.google.firebase.inappmessaging.internal.k1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                CampaignProto.ThickContent lambda$createFirebaseInAppMessageStream$10;
                lambda$createFirebaseInAppMessageStream$10 = InAppMessageStreamManager.lambda$createFirebaseInAppMessageStream$10(CampaignProto.ThickContent.this, (Boolean) obj);
                return lambda$createFirebaseInAppMessageStream$10;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Maybe lambda$createFirebaseInAppMessageStream$13(CampaignProto.ThickContent thickContent) {
        int i10 = AnonymousClass1.$SwitchMap$com$google$firebase$inappmessaging$MessagesProto$Content$MessageDetailsCase[thickContent.getContent().getMessageDetailsCase().ordinal()];
        if (i10 == 1 || i10 == 2 || i10 == 3 || i10 == 4) {
            return Maybe.just(thickContent);
        }
        Logging.logd("Filtering non-displayable message");
        return Maybe.empty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$createFirebaseInAppMessageStream$15(Throwable th) {
        Logging.logw("Impressions store read fail: " + th.getMessage());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ FetchEligibleCampaignsResponse lambda$createFirebaseInAppMessageStream$16(CampaignImpressionList campaignImpressionList, InstallationIdResult installationIdResult) {
        return this.apiClient.getFiams(installationIdResult, campaignImpressionList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$createFirebaseInAppMessageStream$17(FetchEligibleCampaignsResponse fetchEligibleCampaignsResponse) {
        Logging.logi(String.format(Locale.US, "Successfully fetched %d messages from backend", Integer.valueOf(fetchEligibleCampaignsResponse.getMessagesList().size())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createFirebaseInAppMessageStream$18(FetchEligibleCampaignsResponse fetchEligibleCampaignsResponse) {
        this.impressionStorageClient.clearImpressions(fetchEligibleCampaignsResponse).subscribe();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$createFirebaseInAppMessageStream$19(Throwable th) {
        Logging.logw("Service fetch error: " + th.getMessage());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$createFirebaseInAppMessageStream$2(Throwable th) {
        Logging.logw("Cache read error: " + th.getMessage());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Maybe lambda$createFirebaseInAppMessageStream$20(Maybe maybe, final CampaignImpressionList campaignImpressionList) {
        if (!this.dataCollectionHelper.isAutomaticDataCollectionEnabled()) {
            Logging.logi("Automatic data collection is disabled, not attempting campaign fetch from service.");
            return Maybe.just(cacheExpiringResponse());
        }
        Maybe doOnSuccess = maybe.filter(new Predicate() { // from class: com.google.firebase.inappmessaging.internal.x0
            @Override // io.reactivex.functions.Predicate
            public final boolean test(Object obj) {
                boolean validIID;
                validIID = InAppMessageStreamManager.validIID((InstallationIdResult) obj);
                return validIID;
            }
        }).map(new Function() { // from class: com.google.firebase.inappmessaging.internal.y0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                FetchEligibleCampaignsResponse lambda$createFirebaseInAppMessageStream$16;
                lambda$createFirebaseInAppMessageStream$16 = InAppMessageStreamManager.this.lambda$createFirebaseInAppMessageStream$16(campaignImpressionList, (InstallationIdResult) obj);
                return lambda$createFirebaseInAppMessageStream$16;
            }
        }).switchIfEmpty(Maybe.just(cacheExpiringResponse())).doOnSuccess(new Consumer() { // from class: com.google.firebase.inappmessaging.internal.z0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                InAppMessageStreamManager.lambda$createFirebaseInAppMessageStream$17((FetchEligibleCampaignsResponse) obj);
            }
        }).doOnSuccess(new Consumer() { // from class: com.google.firebase.inappmessaging.internal.a1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                InAppMessageStreamManager.this.lambda$createFirebaseInAppMessageStream$18((FetchEligibleCampaignsResponse) obj);
            }
        });
        final AnalyticsEventsManager analyticsEventsManager = this.analyticsEventsManager;
        Objects.requireNonNull(analyticsEventsManager);
        Maybe doOnSuccess2 = doOnSuccess.doOnSuccess(new Consumer() { // from class: com.google.firebase.inappmessaging.internal.b1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                AnalyticsEventsManager.this.updateContextualTriggers((FetchEligibleCampaignsResponse) obj);
            }
        });
        final TestDeviceHelper testDeviceHelper = this.testDeviceHelper;
        Objects.requireNonNull(testDeviceHelper);
        return doOnSuccess2.doOnSuccess(new Consumer() { // from class: com.google.firebase.inappmessaging.internal.c1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                TestDeviceHelper.this.processCampaignFetch((FetchEligibleCampaignsResponse) obj);
            }
        }).doOnError(new Consumer() { // from class: com.google.firebase.inappmessaging.internal.d1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                InAppMessageStreamManager.lambda$createFirebaseInAppMessageStream$19((Throwable) obj);
            }
        }).onErrorResumeNext(Maybe.empty());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ fb.b lambda$createFirebaseInAppMessageStream$21(final String str) {
        Maybe<FetchEligibleCampaignsResponse> onErrorResumeNext = this.campaignCacheClient.get().doOnSuccess(new Consumer() { // from class: com.google.firebase.inappmessaging.internal.i0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                Logging.logd("Fetched from cache");
            }
        }).doOnError(new Consumer() { // from class: com.google.firebase.inappmessaging.internal.t0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                InAppMessageStreamManager.lambda$createFirebaseInAppMessageStream$2((Throwable) obj);
            }
        }).onErrorResumeNext(Maybe.empty());
        Consumer consumer = new Consumer() { // from class: com.google.firebase.inappmessaging.internal.e1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                InAppMessageStreamManager.this.lambda$createFirebaseInAppMessageStream$6((FetchEligibleCampaignsResponse) obj);
            }
        };
        final Function function = new Function() { // from class: com.google.firebase.inappmessaging.internal.l1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Maybe lambda$createFirebaseInAppMessageStream$11;
                lambda$createFirebaseInAppMessageStream$11 = InAppMessageStreamManager.this.lambda$createFirebaseInAppMessageStream$11((CampaignProto.ThickContent) obj);
                return lambda$createFirebaseInAppMessageStream$11;
            }
        };
        final Function function2 = new Function() { // from class: com.google.firebase.inappmessaging.internal.m1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Maybe lambda$createFirebaseInAppMessageStream$12;
                lambda$createFirebaseInAppMessageStream$12 = InAppMessageStreamManager.this.lambda$createFirebaseInAppMessageStream$12(str, (CampaignProto.ThickContent) obj);
                return lambda$createFirebaseInAppMessageStream$12;
            }
        };
        final Function function3 = new Function() { // from class: com.google.firebase.inappmessaging.internal.n1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Maybe lambda$createFirebaseInAppMessageStream$13;
                lambda$createFirebaseInAppMessageStream$13 = InAppMessageStreamManager.lambda$createFirebaseInAppMessageStream$13((CampaignProto.ThickContent) obj);
                return lambda$createFirebaseInAppMessageStream$13;
            }
        };
        Function<? super FetchEligibleCampaignsResponse, ? extends MaybeSource<? extends R>> function4 = new Function() { // from class: com.google.firebase.inappmessaging.internal.o1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Maybe lambda$createFirebaseInAppMessageStream$14;
                lambda$createFirebaseInAppMessageStream$14 = InAppMessageStreamManager.this.lambda$createFirebaseInAppMessageStream$14(str, function, function2, function3, (FetchEligibleCampaignsResponse) obj);
                return lambda$createFirebaseInAppMessageStream$14;
            }
        };
        Maybe<CampaignImpressionList> onErrorResumeNext2 = this.impressionStorageClient.getAllImpressions().doOnError(new Consumer() { // from class: com.google.firebase.inappmessaging.internal.p1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                InAppMessageStreamManager.lambda$createFirebaseInAppMessageStream$15((Throwable) obj);
            }
        }).defaultIfEmpty(CampaignImpressionList.getDefaultInstance()).onErrorResumeNext(Maybe.just(CampaignImpressionList.getDefaultInstance()));
        final Maybe observeOn = Maybe.zip(taskToMaybe(this.firebaseInstallations.getId(), this.blockingExecutor), taskToMaybe(this.firebaseInstallations.getToken(false), this.blockingExecutor), new BiFunction() { // from class: com.google.firebase.inappmessaging.internal.q1
            @Override // io.reactivex.functions.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return InstallationIdResult.create((String) obj, (InstallationTokenResult) obj2);
            }
        }).observeOn(this.schedulers.io());
        Function<? super CampaignImpressionList, ? extends MaybeSource<? extends R>> function5 = new Function() { // from class: com.google.firebase.inappmessaging.internal.r1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Maybe lambda$createFirebaseInAppMessageStream$20;
                lambda$createFirebaseInAppMessageStream$20 = InAppMessageStreamManager.this.lambda$createFirebaseInAppMessageStream$20(observeOn, (CampaignImpressionList) obj);
                return lambda$createFirebaseInAppMessageStream$20;
            }
        };
        if (shouldIgnoreCache(str)) {
            Logging.logi(String.format("Forcing fetch from service rather than cache. Test Device: %s | App Fresh Install: %s", Boolean.valueOf(this.testDeviceHelper.isDeviceInTestMode()), Boolean.valueOf(this.testDeviceHelper.isAppInstallFresh())));
            return onErrorResumeNext2.flatMap(function5).flatMap(function4).toFlowable();
        }
        Logging.logd("Attempting to fetch campaigns using cache");
        return onErrorResumeNext.switchIfEmpty(onErrorResumeNext2.flatMap(function5).doOnSuccess(consumer)).flatMap(function4).toFlowable();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$createFirebaseInAppMessageStream$4(Throwable th) {
        Logging.logw("Cache write error: " + th.getMessage());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ CompletableSource lambda$createFirebaseInAppMessageStream$5(Throwable th) {
        return Completable.complete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createFirebaseInAppMessageStream$6(FetchEligibleCampaignsResponse fetchEligibleCampaignsResponse) {
        this.campaignCacheClient.put(fetchEligibleCampaignsResponse).doOnComplete(new Action() { // from class: com.google.firebase.inappmessaging.internal.u0
            @Override // io.reactivex.functions.Action
            public final void run() {
                Logging.logd("Wrote to cache");
            }
        }).doOnError(new Consumer() { // from class: com.google.firebase.inappmessaging.internal.v0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                InAppMessageStreamManager.lambda$createFirebaseInAppMessageStream$4((Throwable) obj);
            }
        }).onErrorResumeNext(new Function() { // from class: com.google.firebase.inappmessaging.internal.w0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                CompletableSource lambda$createFirebaseInAppMessageStream$5;
                lambda$createFirebaseInAppMessageStream$5 = InAppMessageStreamManager.lambda$createFirebaseInAppMessageStream$5((Throwable) obj);
                return lambda$createFirebaseInAppMessageStream$5;
            }
        }).subscribe();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$createFirebaseInAppMessageStream$7(Throwable th) {
        Logging.logw("Impression store read fail: " + th.getMessage());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$createFirebaseInAppMessageStream$9(Boolean bool) {
        return !bool.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$getContentIfNotRateLimited$22(Boolean bool) {
        Logging.logi("App foreground rate limited ? : " + bool);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$getContentIfNotRateLimited$23(Boolean bool) {
        return !bool.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ CampaignProto.ThickContent lambda$getContentIfNotRateLimited$24(CampaignProto.ThickContent thickContent, Boolean bool) {
        return thickContent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$getTriggeredInAppMessageMaybe$25(CampaignProto.ThickContent thickContent) {
        return this.testDeviceHelper.isDeviceInTestMode() || isActive(this.clock, thickContent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$taskToMaybe$28(MaybeEmitter maybeEmitter, Object obj) {
        maybeEmitter.onSuccess(obj);
        maybeEmitter.onComplete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$taskToMaybe$29(MaybeEmitter maybeEmitter, Exception exc) {
        maybeEmitter.onError(exc);
        maybeEmitter.onComplete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$taskToMaybe$30(Task task, Executor executor, final MaybeEmitter maybeEmitter) {
        task.addOnSuccessListener(executor, new OnSuccessListener() { // from class: com.google.firebase.inappmessaging.internal.r0
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                InAppMessageStreamManager.lambda$taskToMaybe$28(MaybeEmitter.this, obj);
            }
        });
        task.addOnFailureListener(executor, new OnFailureListener() { // from class: com.google.firebase.inappmessaging.internal.s0
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                InAppMessageStreamManager.lambda$taskToMaybe$29(MaybeEmitter.this, exc);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void logImpressionStatus(CampaignProto.ThickContent thickContent, Boolean bool) {
        if (thickContent.getPayloadCase().equals(CampaignProto.ThickContent.PayloadCase.VANILLA_PAYLOAD)) {
            Logging.logi(String.format("Already impressed campaign %s ? : %s", thickContent.getVanillaPayload().getCampaignName(), bool));
        } else if (thickContent.getPayloadCase().equals(CampaignProto.ThickContent.PayloadCase.EXPERIMENTAL_PAYLOAD)) {
            Logging.logi(String.format("Already impressed experiment %s ? : %s", thickContent.getExperimentalPayload().getCampaignName(), bool));
        }
    }

    private boolean shouldIgnoreCache(String str) {
        return this.testDeviceHelper.isAppInstallFresh() ? isAppForegroundEvent(str) : this.testDeviceHelper.isDeviceInTestMode();
    }

    private static <T> Maybe<T> taskToMaybe(final Task<T> task, @Blocking final Executor executor) {
        return Maybe.create(new MaybeOnSubscribe() { // from class: com.google.firebase.inappmessaging.internal.n0
            @Override // io.reactivex.MaybeOnSubscribe
            public final void subscribe(MaybeEmitter maybeEmitter) {
                InAppMessageStreamManager.lambda$taskToMaybe$30(Task.this, executor, maybeEmitter);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: triggeredInAppMessage, reason: merged with bridge method [inline-methods] */
    public Maybe<TriggeredInAppMessage> lambda$getTriggeredInAppMessageMaybe$27(CampaignProto.ThickContent thickContent, String str) {
        String campaignId;
        String campaignName;
        if (thickContent.getPayloadCase().equals(CampaignProto.ThickContent.PayloadCase.VANILLA_PAYLOAD)) {
            campaignId = thickContent.getVanillaPayload().getCampaignId();
            campaignName = thickContent.getVanillaPayload().getCampaignName();
        } else {
            if (!thickContent.getPayloadCase().equals(CampaignProto.ThickContent.PayloadCase.EXPERIMENTAL_PAYLOAD)) {
                return Maybe.empty();
            }
            campaignId = thickContent.getExperimentalPayload().getCampaignId();
            campaignName = thickContent.getExperimentalPayload().getCampaignName();
            if (!thickContent.getIsTestCampaign()) {
                this.abtIntegrationHelper.setExperimentActive(thickContent.getExperimentalPayload().getExperimentPayload());
            }
        }
        InAppMessage decode = ProtoMarshallerClient.decode(thickContent.getContent(), campaignId, campaignName, thickContent.getIsTestCampaign(), thickContent.getDataBundleMap());
        return decode.getMessageType().equals(MessageType.UNSUPPORTED) ? Maybe.empty() : Maybe.just(new TriggeredInAppMessage(decode, str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean validIID(InstallationIdResult installationIdResult) {
        return (TextUtils.isEmpty(installationIdResult.installationId()) || TextUtils.isEmpty(installationIdResult.installationTokenResult().getToken())) ? false : true;
    }

    public Flowable<TriggeredInAppMessage> createFirebaseInAppMessageStream() {
        return Flowable.merge(this.appForegroundEventFlowable, this.analyticsEventsManager.getAnalyticsEventsFlowable(), this.programmaticTriggerEventFlowable).doOnNext(new Consumer() { // from class: com.google.firebase.inappmessaging.internal.f1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                InAppMessageStreamManager.lambda$createFirebaseInAppMessageStream$0((String) obj);
            }
        }).observeOn(this.schedulers.io()).concatMap(new Function() { // from class: com.google.firebase.inappmessaging.internal.g1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                fb.b lambda$createFirebaseInAppMessageStream$21;
                lambda$createFirebaseInAppMessageStream$21 = InAppMessageStreamManager.this.lambda$createFirebaseInAppMessageStream$21((String) obj);
                return lambda$createFirebaseInAppMessageStream$21;
            }
        }).observeOn(this.schedulers.mainThread());
    }

    public static boolean isAppForegroundEvent(String str) {
        return str.equals(ON_FOREGROUND);
    }
}
