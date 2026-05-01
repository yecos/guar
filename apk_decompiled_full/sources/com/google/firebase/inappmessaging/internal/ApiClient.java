package com.google.firebase.inappmessaging.internal;

import android.app.Application;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import com.google.developers.mobile.targeting.proto.ClientSignalsProto;
import com.google.firebase.FirebaseApp;
import com.google.firebase.inappmessaging.internal.injection.scopes.FirebaseAppScope;
import com.google.firebase.inappmessaging.internal.time.Clock;
import com.google.internal.firebase.inappmessaging.v1.sdkserving.CampaignImpressionList;
import com.google.internal.firebase.inappmessaging.v1.sdkserving.ClientAppInfo;
import com.google.internal.firebase.inappmessaging.v1.sdkserving.FetchEligibleCampaignsRequest;
import com.google.internal.firebase.inappmessaging.v1.sdkserving.FetchEligibleCampaignsResponse;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.inject.Provider;

@FirebaseAppScope
/* loaded from: classes2.dex */
public class ApiClient {
    private static final String FETCHING_CAMPAIGN_MESSAGE = "Fetching campaigns from service.";
    private final Application application;
    private final Clock clock;
    private final FirebaseApp firebaseApp;
    private final Provider<GrpcClient> grpcClient;
    private final ProviderInstaller providerInstaller;

    public ApiClient(Provider<GrpcClient> provider, FirebaseApp firebaseApp, Application application, Clock clock, ProviderInstaller providerInstaller) {
        this.grpcClient = provider;
        this.firebaseApp = firebaseApp;
        this.application = application;
        this.clock = clock;
        this.providerInstaller = providerInstaller;
    }

    private ClientAppInfo getClientAppInfo(InstallationIdResult installationIdResult) {
        return ClientAppInfo.newBuilder().setGmpAppId(this.firebaseApp.getOptions().getApplicationId()).setAppInstanceId(installationIdResult.installationId()).setAppInstanceIdToken(installationIdResult.installationTokenResult().getToken()).build();
    }

    private ClientSignalsProto.ClientSignals getClientSignals() {
        ClientSignalsProto.ClientSignals.Builder timeZone = ClientSignalsProto.ClientSignals.newBuilder().setPlatformVersion(String.valueOf(Build.VERSION.SDK_INT)).setLanguageCode(Locale.getDefault().toString()).setTimeZone(TimeZone.getDefault().getID());
        String versionName = getVersionName();
        if (!TextUtils.isEmpty(versionName)) {
            timeZone.setAppVersion(versionName);
        }
        return timeZone.build();
    }

    @Nullable
    private String getVersionName() {
        try {
            return this.application.getPackageManager().getPackageInfo(this.application.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e10) {
            Logging.loge("Error finding versionName : " + e10.getMessage());
            return null;
        }
    }

    private FetchEligibleCampaignsResponse withCacheExpirationSafeguards(FetchEligibleCampaignsResponse fetchEligibleCampaignsResponse) {
        return (fetchEligibleCampaignsResponse.getExpirationEpochTimestampMillis() < this.clock.now() + TimeUnit.MINUTES.toMillis(1L) || fetchEligibleCampaignsResponse.getExpirationEpochTimestampMillis() > this.clock.now() + TimeUnit.DAYS.toMillis(3L)) ? fetchEligibleCampaignsResponse.toBuilder().setExpirationEpochTimestampMillis(this.clock.now() + TimeUnit.DAYS.toMillis(1L)).build() : fetchEligibleCampaignsResponse;
    }

    public FetchEligibleCampaignsResponse getFiams(InstallationIdResult installationIdResult, CampaignImpressionList campaignImpressionList) {
        Logging.logi(FETCHING_CAMPAIGN_MESSAGE);
        this.providerInstaller.install();
        return withCacheExpirationSafeguards(this.grpcClient.get().fetchEligibleCampaigns(FetchEligibleCampaignsRequest.newBuilder().setProjectNumber(this.firebaseApp.getOptions().getGcmSenderId()).addAllAlreadySeenCampaigns(campaignImpressionList.getAlreadySeenCampaignsList()).setClientSignals(getClientSignals()).setRequestingClientApp(getClientAppInfo(installationIdResult)).build()));
    }
}
