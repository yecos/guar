package com.google.firebase.inappmessaging.internal;

import com.google.firebase.abt.AbtException;
import com.google.firebase.abt.AbtExperimentInfo;
import com.google.firebase.abt.FirebaseABTesting;
import com.google.firebase.annotations.concurrent.Blocking;
import com.google.firebase.inappmessaging.ExperimentPayloadProto;
import com.google.firebase.inappmessaging.internal.injection.scopes.FirebaseAppScope;
import com.google.internal.firebase.inappmessaging.v1.CampaignProto;
import com.google.internal.firebase.inappmessaging.v1.sdkserving.FetchEligibleCampaignsResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.Executor;
import javax.inject.Inject;

@FirebaseAppScope
/* loaded from: classes2.dex */
public class AbtIntegrationHelper {
    private final FirebaseABTesting abTesting;

    @Inject
    @Blocking
    Executor executor;

    @Inject
    public AbtIntegrationHelper(FirebaseABTesting firebaseABTesting) {
        this.abTesting = firebaseABTesting;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setExperimentActive$1(ExperimentPayloadProto.ExperimentPayload experimentPayload) {
        try {
            Logging.logd("Updating active experiment: " + experimentPayload.toString());
            this.abTesting.reportActiveExperiment(new AbtExperimentInfo(experimentPayload.getExperimentId(), experimentPayload.getVariantId(), experimentPayload.getTriggerEvent(), new Date(experimentPayload.getExperimentStartTimeMillis()), experimentPayload.getTriggerTimeoutMillis(), experimentPayload.getTimeToLiveMillis()));
        } catch (AbtException e10) {
            Logging.loge("Unable to set experiment as active with ABT, missing analytics?\n" + e10.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateRunningExperiments$0(ArrayList arrayList) {
        try {
            Logging.logd("Updating running experiments with: " + arrayList.size() + " experiments");
            this.abTesting.validateRunningExperiments(arrayList);
        } catch (AbtException e10) {
            Logging.loge("Unable to register experiments with ABT, missing analytics?\n" + e10.getMessage());
        }
    }

    public void setExperimentActive(final ExperimentPayloadProto.ExperimentPayload experimentPayload) {
        this.executor.execute(new Runnable() { // from class: com.google.firebase.inappmessaging.internal.b
            @Override // java.lang.Runnable
            public final void run() {
                AbtIntegrationHelper.this.lambda$setExperimentActive$1(experimentPayload);
            }
        });
    }

    public void updateRunningExperiments(FetchEligibleCampaignsResponse fetchEligibleCampaignsResponse) {
        final ArrayList arrayList = new ArrayList();
        for (CampaignProto.ThickContent thickContent : fetchEligibleCampaignsResponse.getMessagesList()) {
            if (!thickContent.getIsTestCampaign() && thickContent.getPayloadCase().equals(CampaignProto.ThickContent.PayloadCase.EXPERIMENTAL_PAYLOAD)) {
                ExperimentPayloadProto.ExperimentPayload experimentPayload = thickContent.getExperimentalPayload().getExperimentPayload();
                arrayList.add(new AbtExperimentInfo(experimentPayload.getExperimentId(), experimentPayload.getVariantId(), experimentPayload.getTriggerEvent(), new Date(experimentPayload.getExperimentStartTimeMillis()), experimentPayload.getTriggerTimeoutMillis(), experimentPayload.getTimeToLiveMillis()));
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        this.executor.execute(new Runnable() { // from class: com.google.firebase.inappmessaging.internal.a
            @Override // java.lang.Runnable
            public final void run() {
                AbtIntegrationHelper.this.lambda$updateRunningExperiments$0(arrayList);
            }
        });
    }
}
