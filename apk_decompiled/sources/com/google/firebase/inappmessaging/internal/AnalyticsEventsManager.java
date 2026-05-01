package com.google.firebase.inappmessaging.internal;

import android.text.TextUtils;
import com.google.common.annotations.VisibleForTesting;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.inappmessaging.CommonTypesProto;
import com.google.internal.firebase.inappmessaging.v1.CampaignProto;
import com.google.internal.firebase.inappmessaging.v1.sdkserving.FetchEligibleCampaignsResponse;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.flowables.ConnectableFlowable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import javax.annotation.Nullable;

/* loaded from: classes2.dex */
public class AnalyticsEventsManager {

    @VisibleForTesting
    static final String TOO_MANY_CONTEXTUAL_TRIGGERS_ERROR = "Too many contextual triggers defined - limiting to 50";
    private final AnalyticsConnector analyticsConnector;
    private final ConnectableFlowable<String> flowable;
    private AnalyticsConnector.AnalyticsConnectorHandle handle;

    public class AnalyticsFlowableSubscriber implements FlowableOnSubscribe<String> {
        public AnalyticsFlowableSubscriber() {
        }

        @Override // io.reactivex.FlowableOnSubscribe
        public void subscribe(FlowableEmitter<String> flowableEmitter) {
            Logging.logd("Subscribing to analytics events.");
            AnalyticsEventsManager analyticsEventsManager = AnalyticsEventsManager.this;
            analyticsEventsManager.handle = analyticsEventsManager.analyticsConnector.registerAnalyticsConnectorListener("fiam", new FiamAnalyticsConnectorListener(flowableEmitter));
        }
    }

    public AnalyticsEventsManager(AnalyticsConnector analyticsConnector) {
        this.analyticsConnector = analyticsConnector;
        ConnectableFlowable<String> publish = Flowable.create(new AnalyticsFlowableSubscriber(), BackpressureStrategy.BUFFER).publish();
        this.flowable = publish;
        publish.connect();
    }

    @VisibleForTesting
    public static Set<String> extractAnalyticsEventNames(FetchEligibleCampaignsResponse fetchEligibleCampaignsResponse) {
        HashSet hashSet = new HashSet();
        Iterator<CampaignProto.ThickContent> it = fetchEligibleCampaignsResponse.getMessagesList().iterator();
        while (it.hasNext()) {
            for (CommonTypesProto.TriggeringCondition triggeringCondition : it.next().getTriggeringConditionsList()) {
                if (!TextUtils.isEmpty(triggeringCondition.getEvent().getName())) {
                    hashSet.add(triggeringCondition.getEvent().getName());
                }
            }
        }
        if (hashSet.size() > 50) {
            Logging.logi(TOO_MANY_CONTEXTUAL_TRIGGERS_ERROR);
        }
        return hashSet;
    }

    public ConnectableFlowable<String> getAnalyticsEventsFlowable() {
        return this.flowable;
    }

    @Nullable
    public AnalyticsConnector.AnalyticsConnectorHandle getHandle() {
        return this.handle;
    }

    public void updateContextualTriggers(FetchEligibleCampaignsResponse fetchEligibleCampaignsResponse) {
        Set<String> extractAnalyticsEventNames = extractAnalyticsEventNames(fetchEligibleCampaignsResponse);
        Logging.logd("Updating contextual triggers for the following analytics events: " + extractAnalyticsEventNames);
        this.handle.registerEventNames(extractAnalyticsEventNames);
    }
}
