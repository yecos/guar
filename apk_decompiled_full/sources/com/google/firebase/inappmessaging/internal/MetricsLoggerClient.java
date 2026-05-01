package com.google.firebase.inappmessaging.internal;

import android.os.Bundle;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.annotations.concurrent.Blocking;
import com.google.firebase.inappmessaging.CampaignAnalytics;
import com.google.firebase.inappmessaging.ClientAppInfo;
import com.google.firebase.inappmessaging.DismissType;
import com.google.firebase.inappmessaging.EventType;
import com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplayCallbacks;
import com.google.firebase.inappmessaging.RenderErrorReason;
import com.google.firebase.inappmessaging.internal.time.Clock;
import com.google.firebase.inappmessaging.model.Action;
import com.google.firebase.inappmessaging.model.BannerMessage;
import com.google.firebase.inappmessaging.model.CardMessage;
import com.google.firebase.inappmessaging.model.ImageOnlyMessage;
import com.google.firebase.inappmessaging.model.InAppMessage;
import com.google.firebase.inappmessaging.model.MessageType;
import com.google.firebase.inappmessaging.model.ModalMessage;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.messaging.Constants;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

/* loaded from: classes2.dex */
public class MetricsLoggerClient {
    private static final Map<FirebaseInAppMessagingDisplayCallbacks.InAppMessagingDismissType, DismissType> dismissTransform;
    private static final Map<FirebaseInAppMessagingDisplayCallbacks.InAppMessagingErrorReason, RenderErrorReason> errorTransform;
    private final AnalyticsConnector analyticsConnector;

    @Blocking
    private final Executor blockingExecutor;
    private final Clock clock;
    private final DeveloperListenerManager developerListenerManager;
    private final EngagementMetricsLoggerInterface engagementMetricsLogger;
    private final FirebaseApp firebaseApp;
    private final FirebaseInstallationsApi firebaseInstallations;

    /* renamed from: com.google.firebase.inappmessaging.internal.MetricsLoggerClient$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$firebase$inappmessaging$model$MessageType;

        static {
            int[] iArr = new int[MessageType.values().length];
            $SwitchMap$com$google$firebase$inappmessaging$model$MessageType = iArr;
            try {
                iArr[MessageType.CARD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$firebase$inappmessaging$model$MessageType[MessageType.MODAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$firebase$inappmessaging$model$MessageType[MessageType.BANNER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$firebase$inappmessaging$model$MessageType[MessageType.IMAGE_ONLY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public interface EngagementMetricsLoggerInterface {
        void logEvent(byte[] bArr);
    }

    static {
        HashMap hashMap = new HashMap();
        errorTransform = hashMap;
        HashMap hashMap2 = new HashMap();
        dismissTransform = hashMap2;
        hashMap.put(FirebaseInAppMessagingDisplayCallbacks.InAppMessagingErrorReason.UNSPECIFIED_RENDER_ERROR, RenderErrorReason.UNSPECIFIED_RENDER_ERROR);
        hashMap.put(FirebaseInAppMessagingDisplayCallbacks.InAppMessagingErrorReason.IMAGE_FETCH_ERROR, RenderErrorReason.IMAGE_FETCH_ERROR);
        hashMap.put(FirebaseInAppMessagingDisplayCallbacks.InAppMessagingErrorReason.IMAGE_DISPLAY_ERROR, RenderErrorReason.IMAGE_DISPLAY_ERROR);
        hashMap.put(FirebaseInAppMessagingDisplayCallbacks.InAppMessagingErrorReason.IMAGE_UNSUPPORTED_FORMAT, RenderErrorReason.IMAGE_UNSUPPORTED_FORMAT);
        hashMap2.put(FirebaseInAppMessagingDisplayCallbacks.InAppMessagingDismissType.AUTO, DismissType.AUTO);
        hashMap2.put(FirebaseInAppMessagingDisplayCallbacks.InAppMessagingDismissType.CLICK, DismissType.CLICK);
        hashMap2.put(FirebaseInAppMessagingDisplayCallbacks.InAppMessagingDismissType.SWIPE, DismissType.SWIPE);
        hashMap2.put(FirebaseInAppMessagingDisplayCallbacks.InAppMessagingDismissType.UNKNOWN_DISMISS_TYPE, DismissType.UNKNOWN_DISMISS_TYPE);
    }

    public MetricsLoggerClient(EngagementMetricsLoggerInterface engagementMetricsLoggerInterface, AnalyticsConnector analyticsConnector, FirebaseApp firebaseApp, FirebaseInstallationsApi firebaseInstallationsApi, Clock clock, DeveloperListenerManager developerListenerManager, @Blocking Executor executor) {
        this.engagementMetricsLogger = engagementMetricsLoggerInterface;
        this.analyticsConnector = analyticsConnector;
        this.firebaseApp = firebaseApp;
        this.firebaseInstallations = firebaseInstallationsApi;
        this.clock = clock;
        this.developerListenerManager = developerListenerManager;
        this.blockingExecutor = executor;
    }

    private CampaignAnalytics.Builder createCampaignAnalyticsBuilder(InAppMessage inAppMessage, String str) {
        return CampaignAnalytics.newBuilder().setFiamSdkVersion("20.3.1").setProjectNumber(this.firebaseApp.getOptions().getGcmSenderId()).setCampaignId(inAppMessage.getCampaignMetadata().getCampaignId()).setClientApp(ClientAppInfo.newBuilder().setGoogleAppId(this.firebaseApp.getOptions().getApplicationId()).setFirebaseInstanceId(str)).setClientTimestampMillis(this.clock.now());
    }

    private CampaignAnalytics createDismissEntry(InAppMessage inAppMessage, String str, DismissType dismissType) {
        return createCampaignAnalyticsBuilder(inAppMessage, str).setDismissType(dismissType).build();
    }

    private CampaignAnalytics createEventEntry(InAppMessage inAppMessage, String str, EventType eventType) {
        return createCampaignAnalyticsBuilder(inAppMessage, str).setEventType(eventType).build();
    }

    private CampaignAnalytics createRenderErrorEntry(InAppMessage inAppMessage, String str, RenderErrorReason renderErrorReason) {
        return createCampaignAnalyticsBuilder(inAppMessage, str).setRenderErrorReason(renderErrorReason).build();
    }

    private boolean impressionCountsAsConversion(InAppMessage inAppMessage) {
        int i10 = AnonymousClass1.$SwitchMap$com$google$firebase$inappmessaging$model$MessageType[inAppMessage.getMessageType().ordinal()];
        if (i10 == 1) {
            CardMessage cardMessage = (CardMessage) inAppMessage;
            return (isValidAction(cardMessage.getPrimaryAction()) ^ true) && (isValidAction(cardMessage.getSecondaryAction()) ^ true);
        }
        if (i10 == 2) {
            return !isValidAction(((ModalMessage) inAppMessage).getAction());
        }
        if (i10 == 3) {
            return !isValidAction(((BannerMessage) inAppMessage).getAction());
        }
        if (i10 == 4) {
            return !isValidAction(((ImageOnlyMessage) inAppMessage).getAction());
        }
        Logging.loge("Unable to determine if impression should be counted as conversion.");
        return false;
    }

    private boolean isTestCampaign(InAppMessage inAppMessage) {
        return inAppMessage.getCampaignMetadata().getIsTestMessage();
    }

    private boolean isValidAction(@Nullable Action action) {
        return (action == null || action.getActionUrl() == null || action.getActionUrl().isEmpty()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$logDismiss$3(InAppMessage inAppMessage, FirebaseInAppMessagingDisplayCallbacks.InAppMessagingDismissType inAppMessagingDismissType, String str) {
        this.engagementMetricsLogger.logEvent(createDismissEntry(inAppMessage, str, dismissTransform.get(inAppMessagingDismissType)).toByteArray());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$logImpression$0(InAppMessage inAppMessage, String str) {
        this.engagementMetricsLogger.logEvent(createEventEntry(inAppMessage, str, EventType.IMPRESSION_EVENT_TYPE).toByteArray());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$logMessageClick$1(InAppMessage inAppMessage, String str) {
        this.engagementMetricsLogger.logEvent(createEventEntry(inAppMessage, str, EventType.CLICK_EVENT_TYPE).toByteArray());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$logRenderError$2(InAppMessage inAppMessage, FirebaseInAppMessagingDisplayCallbacks.InAppMessagingErrorReason inAppMessagingErrorReason, String str) {
        this.engagementMetricsLogger.logEvent(createRenderErrorEntry(inAppMessage, str, errorTransform.get(inAppMessagingErrorReason)).toByteArray());
    }

    private void logEventAsync(InAppMessage inAppMessage, String str, boolean z10) {
        String campaignId = inAppMessage.getCampaignMetadata().getCampaignId();
        Bundle collectAnalyticsParams = collectAnalyticsParams(inAppMessage.getCampaignMetadata().getCampaignName(), campaignId);
        Logging.logd("Sending event=" + str + " params=" + collectAnalyticsParams);
        AnalyticsConnector analyticsConnector = this.analyticsConnector;
        if (analyticsConnector == null) {
            Logging.logw("Unable to log event: analytics library is missing");
            return;
        }
        analyticsConnector.logEvent("fiam", str, collectAnalyticsParams);
        if (z10) {
            this.analyticsConnector.setUserProperty("fiam", Constants.ScionAnalytics.USER_PROPERTY_FIREBASE_LAST_NOTIFICATION, "fiam:" + campaignId);
        }
    }

    public Bundle collectAnalyticsParams(String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString("_nmid", str2);
        bundle.putString(Constants.ScionAnalytics.PARAM_MESSAGE_NAME, str);
        try {
            bundle.putInt(Constants.ScionAnalytics.PARAM_MESSAGE_DEVICE_TIME, (int) (this.clock.now() / 1000));
        } catch (NumberFormatException e10) {
            Logging.logw("Error while parsing use_device_time in FIAM event: " + e10.getMessage());
        }
        return bundle;
    }

    public void logDismiss(final InAppMessage inAppMessage, final FirebaseInAppMessagingDisplayCallbacks.InAppMessagingDismissType inAppMessagingDismissType) {
        if (!isTestCampaign(inAppMessage)) {
            this.firebaseInstallations.getId().addOnSuccessListener(this.blockingExecutor, new OnSuccessListener() { // from class: com.google.firebase.inappmessaging.internal.u1
                @Override // com.google.android.gms.tasks.OnSuccessListener
                public final void onSuccess(Object obj) {
                    MetricsLoggerClient.this.lambda$logDismiss$3(inAppMessage, inAppMessagingDismissType, (String) obj);
                }
            });
            logEventAsync(inAppMessage, "fiam_dismiss", false);
        }
        this.developerListenerManager.messageDismissed(inAppMessage);
    }

    public void logImpression(final InAppMessage inAppMessage) {
        if (!isTestCampaign(inAppMessage)) {
            this.firebaseInstallations.getId().addOnSuccessListener(this.blockingExecutor, new OnSuccessListener() { // from class: com.google.firebase.inappmessaging.internal.s1
                @Override // com.google.android.gms.tasks.OnSuccessListener
                public final void onSuccess(Object obj) {
                    MetricsLoggerClient.this.lambda$logImpression$0(inAppMessage, (String) obj);
                }
            });
            logEventAsync(inAppMessage, "fiam_impression", impressionCountsAsConversion(inAppMessage));
        }
        this.developerListenerManager.impressionDetected(inAppMessage);
    }

    public void logMessageClick(final InAppMessage inAppMessage, Action action) {
        if (!isTestCampaign(inAppMessage)) {
            this.firebaseInstallations.getId().addOnSuccessListener(this.blockingExecutor, new OnSuccessListener() { // from class: com.google.firebase.inappmessaging.internal.t1
                @Override // com.google.android.gms.tasks.OnSuccessListener
                public final void onSuccess(Object obj) {
                    MetricsLoggerClient.this.lambda$logMessageClick$1(inAppMessage, (String) obj);
                }
            });
            logEventAsync(inAppMessage, "fiam_action", true);
        }
        this.developerListenerManager.messageClicked(inAppMessage, action);
    }

    public void logRenderError(final InAppMessage inAppMessage, final FirebaseInAppMessagingDisplayCallbacks.InAppMessagingErrorReason inAppMessagingErrorReason) {
        if (!isTestCampaign(inAppMessage)) {
            this.firebaseInstallations.getId().addOnSuccessListener(this.blockingExecutor, new OnSuccessListener() { // from class: com.google.firebase.inappmessaging.internal.v1
                @Override // com.google.android.gms.tasks.OnSuccessListener
                public final void onSuccess(Object obj) {
                    MetricsLoggerClient.this.lambda$logRenderError$2(inAppMessage, inAppMessagingErrorReason, (String) obj);
                }
            });
        }
        this.developerListenerManager.displayErrorEncountered(inAppMessage, inAppMessagingErrorReason);
    }
}
