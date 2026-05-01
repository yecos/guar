package com.google.firebase.inappmessaging.internal;

import com.google.firebase.inappmessaging.internal.RateLimitProto;
import com.google.firebase.inappmessaging.internal.injection.qualifiers.RateLimit;
import com.google.firebase.inappmessaging.internal.time.Clock;
import io.reactivex.Completable;
import io.reactivex.CompletableSource;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes2.dex */
public class RateLimiterClient {
    private static final RateLimitProto.RateLimit EMPTY_RATE_LIMITS = RateLimitProto.RateLimit.getDefaultInstance();
    private Maybe<RateLimitProto.RateLimit> cachedRateLimts = Maybe.empty();
    private final Clock clock;
    private final ProtoStorageClient storageClient;

    @Inject
    public RateLimiterClient(@RateLimit ProtoStorageClient protoStorageClient, Clock clock) {
        this.storageClient = protoStorageClient;
        this.clock = clock;
    }

    private void clearInMemCache() {
        this.cachedRateLimts = Maybe.empty();
    }

    private Maybe<RateLimitProto.RateLimit> getRateLimits() {
        return this.cachedRateLimts.switchIfEmpty(this.storageClient.read(RateLimitProto.RateLimit.parser()).doOnSuccess(new Consumer() { // from class: com.google.firebase.inappmessaging.internal.a2
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                RateLimiterClient.this.lambda$increment$2((RateLimitProto.RateLimit) obj);
            }
        })).doOnError(new Consumer() { // from class: com.google.firebase.inappmessaging.internal.b2
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                RateLimiterClient.this.lambda$getRateLimits$7((Throwable) obj);
            }
        });
    }

    private static RateLimitProto.Counter increment(RateLimitProto.Counter counter) {
        return RateLimitProto.Counter.newBuilder(counter).clearValue().setValue(counter.getValue() + 1).build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: initInMemCache, reason: merged with bridge method [inline-methods] */
    public void lambda$increment$2(RateLimitProto.RateLimit rateLimit) {
        this.cachedRateLimts = Maybe.just(rateLimit);
    }

    private boolean isLimitExpired(RateLimitProto.Counter counter, com.google.firebase.inappmessaging.model.RateLimit rateLimit) {
        return this.clock.now() - counter.getStartTimeEpoch() > rateLimit.timeToLiveMillis();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getRateLimits$7(Throwable th) {
        clearInMemCache();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$increment$0(com.google.firebase.inappmessaging.model.RateLimit rateLimit, RateLimitProto.Counter counter) {
        return !isLimitExpired(counter, rateLimit);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ RateLimitProto.RateLimit lambda$increment$1(RateLimitProto.RateLimit rateLimit, com.google.firebase.inappmessaging.model.RateLimit rateLimit2, RateLimitProto.Counter counter) {
        return RateLimitProto.RateLimit.newBuilder(rateLimit).putLimits(rateLimit2.limiterKey(), increment(counter)).build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ CompletableSource lambda$increment$3(final RateLimitProto.RateLimit rateLimit) {
        return this.storageClient.write(rateLimit).doOnComplete(new Action() { // from class: com.google.firebase.inappmessaging.internal.i2
            @Override // io.reactivex.functions.Action
            public final void run() {
                RateLimiterClient.this.lambda$increment$2(rateLimit);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ CompletableSource lambda$increment$4(final com.google.firebase.inappmessaging.model.RateLimit rateLimit, final RateLimitProto.RateLimit rateLimit2) {
        return Observable.just(rateLimit2.getLimitsOrDefault(rateLimit.limiterKey(), newCounter())).filter(new Predicate() { // from class: com.google.firebase.inappmessaging.internal.f2
            @Override // io.reactivex.functions.Predicate
            public final boolean test(Object obj) {
                boolean lambda$increment$0;
                lambda$increment$0 = RateLimiterClient.this.lambda$increment$0(rateLimit, (RateLimitProto.Counter) obj);
                return lambda$increment$0;
            }
        }).switchIfEmpty(Observable.just(newCounter())).map(new Function() { // from class: com.google.firebase.inappmessaging.internal.g2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                RateLimitProto.RateLimit lambda$increment$1;
                lambda$increment$1 = RateLimiterClient.lambda$increment$1(RateLimitProto.RateLimit.this, rateLimit, (RateLimitProto.Counter) obj);
                return lambda$increment$1;
            }
        }).flatMapCompletable(new Function() { // from class: com.google.firebase.inappmessaging.internal.h2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                CompletableSource lambda$increment$3;
                lambda$increment$3 = RateLimiterClient.this.lambda$increment$3((RateLimitProto.RateLimit) obj);
                return lambda$increment$3;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ RateLimitProto.Counter lambda$isRateLimited$5(com.google.firebase.inappmessaging.model.RateLimit rateLimit, RateLimitProto.RateLimit rateLimit2) {
        return rateLimit2.getLimitsOrDefault(rateLimit.limiterKey(), newCounter());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$isRateLimited$6(com.google.firebase.inappmessaging.model.RateLimit rateLimit, RateLimitProto.Counter counter) {
        return isLimitExpired(counter, rateLimit) || counter.getValue() < rateLimit.limit();
    }

    private RateLimitProto.Counter newCounter() {
        return RateLimitProto.Counter.newBuilder().setValue(0L).setStartTimeEpoch(this.clock.now()).build();
    }

    public Single<Boolean> isRateLimited(final com.google.firebase.inappmessaging.model.RateLimit rateLimit) {
        return getRateLimits().switchIfEmpty(Maybe.just(RateLimitProto.RateLimit.getDefaultInstance())).map(new Function() { // from class: com.google.firebase.inappmessaging.internal.c2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                RateLimitProto.Counter lambda$isRateLimited$5;
                lambda$isRateLimited$5 = RateLimiterClient.this.lambda$isRateLimited$5(rateLimit, (RateLimitProto.RateLimit) obj);
                return lambda$isRateLimited$5;
            }
        }).filter(new Predicate() { // from class: com.google.firebase.inappmessaging.internal.d2
            @Override // io.reactivex.functions.Predicate
            public final boolean test(Object obj) {
                boolean lambda$isRateLimited$6;
                lambda$isRateLimited$6 = RateLimiterClient.this.lambda$isRateLimited$6(rateLimit, (RateLimitProto.Counter) obj);
                return lambda$isRateLimited$6;
            }
        }).isEmpty();
    }

    public Completable increment(final com.google.firebase.inappmessaging.model.RateLimit rateLimit) {
        return getRateLimits().defaultIfEmpty(EMPTY_RATE_LIMITS).flatMapCompletable(new Function() { // from class: com.google.firebase.inappmessaging.internal.e2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                CompletableSource lambda$increment$4;
                lambda$increment$4 = RateLimiterClient.this.lambda$increment$4(rateLimit, (RateLimitProto.RateLimit) obj);
                return lambda$increment$4;
            }
        });
    }
}
