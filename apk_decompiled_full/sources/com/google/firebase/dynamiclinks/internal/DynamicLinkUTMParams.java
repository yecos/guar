package com.google.firebase.dynamiclinks.internal;

import android.os.Bundle;
import android.text.TextUtils;

/* loaded from: classes2.dex */
public class DynamicLinkUTMParams {
    public static final String KEY_CAMPAIGN = "campaign";
    public static final String KEY_CAMPAIGN_BUNDLE = "_cmp";
    public static final String KEY_MEDIUM = "medium";
    public static final String KEY_SCION_DATA_BUNDLE = "scionData";
    public static final String KEY_SOURCE = "source";
    public static final String KEY_UTM_CAMPAIGN = "utm_campaign";
    public static final String KEY_UTM_MEDIUM = "utm_medium";
    public static final String KEY_UTM_SOURCE = "utm_source";
    private final DynamicLinkData dynamicLinkData;
    private final Bundle utmParamsBundle;

    public DynamicLinkUTMParams(DynamicLinkData dynamicLinkData) {
        this.dynamicLinkData = dynamicLinkData;
        this.utmParamsBundle = initUTMParamsBundle(dynamicLinkData);
    }

    private static void checkAndAdd(String str, String str2, Bundle bundle, Bundle bundle2) {
        String string = bundle.getString(str);
        if (TextUtils.isEmpty(string)) {
            return;
        }
        bundle2.putString(str2, string);
    }

    private static Bundle initUTMParamsBundle(DynamicLinkData dynamicLinkData) {
        Bundle bundle = new Bundle();
        if (dynamicLinkData != null && dynamicLinkData.getExtensionBundle() != null) {
            Bundle bundle2 = dynamicLinkData.getExtensionBundle().getBundle("scionData");
            if (bundle2 == null) {
                return bundle;
            }
            Bundle bundle3 = bundle2.getBundle("_cmp");
            if (bundle3 == null) {
                return bundle;
            }
            checkAndAdd("medium", "utm_medium", bundle3, bundle);
            checkAndAdd("source", "utm_source", bundle3, bundle);
            checkAndAdd("campaign", "utm_campaign", bundle3, bundle);
        }
        return bundle;
    }

    public Bundle asBundle() {
        return new Bundle(this.utmParamsBundle);
    }
}
