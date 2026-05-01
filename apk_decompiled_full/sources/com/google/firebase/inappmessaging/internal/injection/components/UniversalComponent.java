package com.google.firebase.inappmessaging.internal.injection.components;

import android.app.Application;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.annotations.concurrent.Blocking;
import com.google.firebase.annotations.concurrent.Lightweight;
import com.google.firebase.events.Subscriber;
import com.google.firebase.inappmessaging.dagger.Component;
import com.google.firebase.inappmessaging.internal.AnalyticsEventsManager;
import com.google.firebase.inappmessaging.internal.CampaignCacheClient;
import com.google.firebase.inappmessaging.internal.DeveloperListenerManager;
import com.google.firebase.inappmessaging.internal.ImpressionStorageClient;
import com.google.firebase.inappmessaging.internal.ProgramaticContextualTriggers;
import com.google.firebase.inappmessaging.internal.ProviderInstaller;
import com.google.firebase.inappmessaging.internal.RateLimiterClient;
import com.google.firebase.inappmessaging.internal.Schedulers;
import com.google.firebase.inappmessaging.internal.injection.modules.AnalyticsEventsModule;
import com.google.firebase.inappmessaging.internal.injection.modules.AppMeasurementModule;
import com.google.firebase.inappmessaging.internal.injection.modules.ApplicationModule;
import com.google.firebase.inappmessaging.internal.injection.modules.ExecutorsModule;
import com.google.firebase.inappmessaging.internal.injection.modules.ForegroundFlowableModule;
import com.google.firebase.inappmessaging.internal.injection.modules.GrpcChannelModule;
import com.google.firebase.inappmessaging.internal.injection.modules.ProgrammaticContextualTriggerFlowableModule;
import com.google.firebase.inappmessaging.internal.injection.modules.ProtoStorageClientModule;
import com.google.firebase.inappmessaging.internal.injection.modules.RateLimitModule;
import com.google.firebase.inappmessaging.internal.injection.modules.SchedulerModule;
import com.google.firebase.inappmessaging.internal.injection.modules.SystemClockModule;
import com.google.firebase.inappmessaging.internal.injection.qualifiers.AnalyticsListener;
import com.google.firebase.inappmessaging.internal.injection.qualifiers.AppForeground;
import com.google.firebase.inappmessaging.internal.injection.qualifiers.ProgrammaticTrigger;
import com.google.firebase.inappmessaging.internal.time.Clock;
import com.google.firebase.inappmessaging.model.ProtoMarshallerClient;
import com.google.firebase.inappmessaging.model.RateLimit;
import io.reactivex.flowables.ConnectableFlowable;
import java.util.concurrent.Executor;
import javax.inject.Singleton;
import y8.d;

@Singleton
@Component(modules = {GrpcChannelModule.class, SchedulerModule.class, ApplicationModule.class, ForegroundFlowableModule.class, ProgrammaticContextualTriggerFlowableModule.class, AnalyticsEventsModule.class, ProtoStorageClientModule.class, SystemClockModule.class, RateLimitModule.class, AppMeasurementModule.class, ExecutorsModule.class})
/* loaded from: classes2.dex */
public interface UniversalComponent {
    AnalyticsConnector analyticsConnector();

    @AnalyticsListener
    ConnectableFlowable<String> analyticsEventsFlowable();

    AnalyticsEventsManager analyticsEventsManager();

    @AppForeground
    ConnectableFlowable<String> appForegroundEventFlowable();

    @AppForeground
    RateLimit appForegroundRateLimit();

    Application application();

    @Blocking
    Executor blockingExecutor();

    CampaignCacheClient campaignCacheClient();

    Clock clock();

    DeveloperListenerManager developerListenerManager();

    Subscriber firebaseEventsSubscriber();

    d gRPCChannel();

    ImpressionStorageClient impressionStorageClient();

    @Lightweight
    Executor lightWeightExecutor();

    ProviderInstaller probiderInstaller();

    @ProgrammaticTrigger
    ConnectableFlowable<String> programmaticContextualTriggerFlowable();

    @ProgrammaticTrigger
    ProgramaticContextualTriggers programmaticContextualTriggers();

    ProtoMarshallerClient protoMarshallerClient();

    RateLimiterClient rateLimiterClient();

    Schedulers schedulers();
}
