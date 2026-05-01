package com.google.firebase.inappmessaging.internal;

import android.text.TextUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplayCallbacks;
import com.google.firebase.inappmessaging.internal.time.Clock;
import com.google.firebase.inappmessaging.model.Action;
import com.google.firebase.inappmessaging.model.InAppMessage;
import com.google.firebase.inappmessaging.model.RateLimit;
import com.google.internal.firebase.inappmessaging.v1.sdkserving.CampaignImpression;
import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.MaybeSource;
import io.reactivex.Scheduler;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
public class DisplayCallbacksImpl implements FirebaseInAppMessagingDisplayCallbacks {
    private static final String MESSAGE_CLICK = "message click to metrics logger";
    private final RateLimit appForegroundRateLimit;
    private final CampaignCacheClient campaignCacheClient;
    private final Clock clock;
    private final DataCollectionHelper dataCollectionHelper;
    private final ImpressionStorageClient impressionStorageClient;
    private final InAppMessage inAppMessage;
    private final MetricsLoggerClient metricsLoggerClient;
    private final RateLimiterClient rateLimiterClient;
    private final Schedulers schedulers;
    private final String triggeringEvent;
    private boolean wasImpressed = false;

    @VisibleForTesting
    public DisplayCallbacksImpl(ImpressionStorageClient impressionStorageClient, Clock clock, Schedulers schedulers, RateLimiterClient rateLimiterClient, CampaignCacheClient campaignCacheClient, RateLimit rateLimit, MetricsLoggerClient metricsLoggerClient, DataCollectionHelper dataCollectionHelper, InAppMessage inAppMessage, String str) {
        this.impressionStorageClient = impressionStorageClient;
        this.clock = clock;
        this.schedulers = schedulers;
        this.rateLimiterClient = rateLimiterClient;
        this.campaignCacheClient = campaignCacheClient;
        this.appForegroundRateLimit = rateLimit;
        this.metricsLoggerClient = metricsLoggerClient;
        this.dataCollectionHelper = dataCollectionHelper;
        this.inAppMessage = inAppMessage;
        this.triggeringEvent = str;
    }

    private boolean actionMatches(Action action, Action action2) {
        return action == null ? action2 == null || TextUtils.isEmpty(action2.getActionUrl()) : action.getActionUrl().equals(action2.getActionUrl());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$displayErrorEncountered$4(FirebaseInAppMessagingDisplayCallbacks.InAppMessagingErrorReason inAppMessagingErrorReason) {
        this.metricsLoggerClient.logRenderError(this.inAppMessage, inAppMessagingErrorReason);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$impressionDetected$0() {
        this.metricsLoggerClient.logImpression(this.inAppMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$logMessageClick$3(Action action) {
        this.metricsLoggerClient.logMessageClick(this.inAppMessage, action);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ MaybeSource lambda$maybeToTask$10(TaskCompletionSource taskCompletionSource, Throwable th) {
        if (th instanceof Exception) {
            taskCompletionSource.setException((Exception) th);
        } else {
            taskCompletionSource.setException(new RuntimeException(th));
        }
        return Maybe.empty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$maybeToTask$9(TaskCompletionSource taskCompletionSource) {
        taskCompletionSource.setResult(null);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$messageDismissed$2(FirebaseInAppMessagingDisplayCallbacks.InAppMessagingDismissType inAppMessagingDismissType) {
        this.metricsLoggerClient.logDismiss(this.inAppMessage, inAppMessagingDismissType);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateWasImpressed$1() {
        this.wasImpressed = true;
    }

    private void logActionNotTaken(String str, Maybe<String> maybe) {
        if (maybe != null) {
            Logging.logd(String.format("Not recording: %s. Reason: %s", str, maybe));
            return;
        }
        if (this.inAppMessage.getCampaignMetadata().getIsTestMessage()) {
            Logging.logd(String.format("Not recording: %s. Reason: Message is test message", str));
        } else if (this.dataCollectionHelper.isAutomaticDataCollectionEnabled()) {
            Logging.logd(String.format("Not recording: %s", str));
        } else {
            Logging.logd(String.format("Not recording: %s. Reason: Data collection is disabled", str));
        }
    }

    private Task<Void> logImpressionIfNeeded(Completable completable) {
        if (!this.wasImpressed) {
            impressionDetected();
        }
        return maybeToTask(completable.toMaybe(), this.schedulers.io());
    }

    private Task<Void> logMessageClick(final Action action) {
        Logging.logd("Attempting to record: message click to metrics logger");
        return logImpressionIfNeeded(Completable.fromAction(new io.reactivex.functions.Action() { // from class: com.google.firebase.inappmessaging.internal.s
            @Override // io.reactivex.functions.Action
            public final void run() {
                DisplayCallbacksImpl.this.lambda$logMessageClick$3(action);
            }
        }));
    }

    private Completable logToImpressionStore() {
        String campaignId = this.inAppMessage.getCampaignMetadata().getCampaignId();
        Logging.logd("Attempting to record message impression in impression store for id: " + campaignId);
        Completable doOnComplete = this.impressionStorageClient.storeImpression(CampaignImpression.newBuilder().setImpressionTimestampMillis(this.clock.now()).setCampaignId(campaignId).build()).doOnError(new Consumer() { // from class: com.google.firebase.inappmessaging.internal.t
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                Logging.loge("Impression store write failure");
            }
        }).doOnComplete(new io.reactivex.functions.Action() { // from class: com.google.firebase.inappmessaging.internal.u
            @Override // io.reactivex.functions.Action
            public final void run() {
                Logging.logd("Impression store write success");
            }
        });
        return InAppMessageStreamManager.isAppForegroundEvent(this.triggeringEvent) ? this.rateLimiterClient.increment(this.appForegroundRateLimit).doOnError(new Consumer() { // from class: com.google.firebase.inappmessaging.internal.v
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                Logging.loge("Rate limiter client write failure");
            }
        }).doOnComplete(new io.reactivex.functions.Action() { // from class: com.google.firebase.inappmessaging.internal.w
            @Override // io.reactivex.functions.Action
            public final void run() {
                Logging.logd("Rate limiter client write success");
            }
        }).onErrorComplete().andThen(doOnComplete) : doOnComplete;
    }

    private static <T> Task<T> maybeToTask(Maybe<T> maybe, Scheduler scheduler) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        maybe.doOnSuccess(new Consumer() { // from class: com.google.firebase.inappmessaging.internal.m
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                TaskCompletionSource.this.setResult(obj);
            }
        }).switchIfEmpty(Maybe.fromCallable(new Callable() { // from class: com.google.firebase.inappmessaging.internal.p
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Object lambda$maybeToTask$9;
                lambda$maybeToTask$9 = DisplayCallbacksImpl.lambda$maybeToTask$9(TaskCompletionSource.this);
                return lambda$maybeToTask$9;
            }
        })).onErrorResumeNext(new Function() { // from class: com.google.firebase.inappmessaging.internal.q
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                MaybeSource lambda$maybeToTask$10;
                lambda$maybeToTask$10 = DisplayCallbacksImpl.lambda$maybeToTask$10(TaskCompletionSource.this, (Throwable) obj);
                return lambda$maybeToTask$10;
            }
        }).subscribeOn(scheduler).subscribe();
        return taskCompletionSource.getTask();
    }

    private boolean shouldLog() {
        return this.dataCollectionHelper.isAutomaticDataCollectionEnabled();
    }

    private Completable updateWasImpressed() {
        return Completable.fromAction(new io.reactivex.functions.Action() { // from class: com.google.firebase.inappmessaging.internal.o
            @Override // io.reactivex.functions.Action
            public final void run() {
                DisplayCallbacksImpl.this.lambda$updateWasImpressed$1();
            }
        });
    }

    @Override // com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplayCallbacks
    public Task<Void> displayErrorEncountered(final FirebaseInAppMessagingDisplayCallbacks.InAppMessagingErrorReason inAppMessagingErrorReason) {
        if (!shouldLog()) {
            logActionNotTaken("render error to metrics logger");
            return new TaskCompletionSource().getTask();
        }
        Logging.logd("Attempting to record: render error to metrics logger");
        return maybeToTask(logToImpressionStore().andThen(Completable.fromAction(new io.reactivex.functions.Action() { // from class: com.google.firebase.inappmessaging.internal.x
            @Override // io.reactivex.functions.Action
            public final void run() {
                DisplayCallbacksImpl.this.lambda$displayErrorEncountered$4(inAppMessagingErrorReason);
            }
        })).andThen(updateWasImpressed()).toMaybe(), this.schedulers.io());
    }

    @Override // com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplayCallbacks
    public Task<Void> impressionDetected() {
        if (!shouldLog() || this.wasImpressed) {
            logActionNotTaken("message impression to metrics logger");
            return new TaskCompletionSource().getTask();
        }
        Logging.logd("Attempting to record: message impression to metrics logger");
        return maybeToTask(logToImpressionStore().andThen(Completable.fromAction(new io.reactivex.functions.Action() { // from class: com.google.firebase.inappmessaging.internal.n
            @Override // io.reactivex.functions.Action
            public final void run() {
                DisplayCallbacksImpl.this.lambda$impressionDetected$0();
            }
        })).andThen(updateWasImpressed()).toMaybe(), this.schedulers.io());
    }

    @Deprecated
    public Task<Void> messageClicked() {
        return messageClicked(this.inAppMessage.getAction());
    }

    @Override // com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplayCallbacks
    public Task<Void> messageDismissed(final FirebaseInAppMessagingDisplayCallbacks.InAppMessagingDismissType inAppMessagingDismissType) {
        if (!shouldLog()) {
            logActionNotTaken("message dismissal to metrics logger");
            return new TaskCompletionSource().getTask();
        }
        Logging.logd("Attempting to record: message dismissal to metrics logger");
        return logImpressionIfNeeded(Completable.fromAction(new io.reactivex.functions.Action() { // from class: com.google.firebase.inappmessaging.internal.r
            @Override // io.reactivex.functions.Action
            public final void run() {
                DisplayCallbacksImpl.this.lambda$messageDismissed$2(inAppMessagingDismissType);
            }
        }));
    }

    @VisibleForTesting
    public boolean wasImpressed() {
        return this.wasImpressed;
    }

    @Override // com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplayCallbacks
    public Task<Void> messageClicked(Action action) {
        if (shouldLog()) {
            return action.getActionUrl() == null ? messageDismissed(FirebaseInAppMessagingDisplayCallbacks.InAppMessagingDismissType.CLICK) : logMessageClick(action);
        }
        logActionNotTaken(MESSAGE_CLICK);
        return new TaskCompletionSource().getTask();
    }

    private void logActionNotTaken(String str) {
        logActionNotTaken(str, null);
    }
}
