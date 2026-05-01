package com.google.firebase.inappmessaging.internal;

import com.google.common.annotations.VisibleForTesting;
import com.google.internal.firebase.inappmessaging.v1.CampaignProto;
import com.google.internal.firebase.inappmessaging.v1.sdkserving.FetchEligibleCampaignsResponse;
import java.util.Iterator;
import javax.inject.Inject;

/* loaded from: classes2.dex */
public class TestDeviceHelper {

    @VisibleForTesting
    static final String FRESH_INSTALL_PREFERENCES = "fresh_install";

    @VisibleForTesting
    static final int MAX_FETCH_COUNT = 5;

    @VisibleForTesting
    static final String TEST_DEVICE_PREFERENCES = "test_device";
    private int fetchCount = 0;
    private boolean isFreshInstall = readFreshInstallStatusFromPreferences();
    private boolean isTestDevice = readTestDeviceStatusFromPreferences();
    private final SharedPreferencesUtils sharedPreferencesUtils;

    @Inject
    public TestDeviceHelper(SharedPreferencesUtils sharedPreferencesUtils) {
        this.sharedPreferencesUtils = sharedPreferencesUtils;
    }

    private boolean readFreshInstallStatusFromPreferences() {
        return this.sharedPreferencesUtils.getAndSetBooleanPreference(FRESH_INSTALL_PREFERENCES, true);
    }

    private boolean readTestDeviceStatusFromPreferences() {
        return this.sharedPreferencesUtils.getAndSetBooleanPreference(TEST_DEVICE_PREFERENCES, false);
    }

    private void setFreshInstallStatus(boolean z10) {
        this.isFreshInstall = z10;
        this.sharedPreferencesUtils.setBooleanPreference(FRESH_INSTALL_PREFERENCES, z10);
    }

    private void setTestDeviceStatus(boolean z10) {
        this.isTestDevice = z10;
        this.sharedPreferencesUtils.setBooleanPreference(TEST_DEVICE_PREFERENCES, z10);
    }

    private void updateFreshInstallStatus() {
        if (this.isFreshInstall) {
            int i10 = this.fetchCount + 1;
            this.fetchCount = i10;
            if (i10 >= 5) {
                setFreshInstallStatus(false);
            }
        }
    }

    public boolean isAppInstallFresh() {
        return this.isFreshInstall;
    }

    public boolean isDeviceInTestMode() {
        return this.isTestDevice;
    }

    public void processCampaignFetch(FetchEligibleCampaignsResponse fetchEligibleCampaignsResponse) {
        if (this.isTestDevice) {
            return;
        }
        updateFreshInstallStatus();
        Iterator<CampaignProto.ThickContent> it = fetchEligibleCampaignsResponse.getMessagesList().iterator();
        while (it.hasNext()) {
            if (it.next().getIsTestCampaign()) {
                setTestDeviceStatus(true);
                Logging.logi("Setting this device as a test device");
                return;
            }
        }
    }
}
