package com.google.firebase.dynamiclinks;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.firebase.dynamiclinks.internal.DynamicLinkData;
import com.google.firebase.dynamiclinks.internal.DynamicLinkUTMParams;

/* loaded from: classes2.dex */
public class PendingDynamicLinkData {
    private final DynamicLinkData dynamicLinkData;
    private final DynamicLinkUTMParams dynamicLinkUTMParams;

    @VisibleForTesting
    @KeepForSdk
    public PendingDynamicLinkData(DynamicLinkData dynamicLinkData) {
        if (dynamicLinkData == null) {
            this.dynamicLinkData = null;
            this.dynamicLinkUTMParams = null;
        } else {
            if (dynamicLinkData.getClickTimestamp() == 0) {
                dynamicLinkData.setClickTimestamp(DefaultClock.getInstance().currentTimeMillis());
            }
            this.dynamicLinkData = dynamicLinkData;
            this.dynamicLinkUTMParams = new DynamicLinkUTMParams(dynamicLinkData);
        }
    }

    public long getClickTimestamp() {
        DynamicLinkData dynamicLinkData = this.dynamicLinkData;
        if (dynamicLinkData == null) {
            return 0L;
        }
        return dynamicLinkData.getClickTimestamp();
    }

    @KeepForSdk
    public Bundle getExtensions() {
        DynamicLinkData dynamicLinkData = this.dynamicLinkData;
        return dynamicLinkData == null ? new Bundle() : dynamicLinkData.getExtensionBundle();
    }

    public Uri getLink() {
        String deepLink;
        DynamicLinkData dynamicLinkData = this.dynamicLinkData;
        if (dynamicLinkData == null || (deepLink = dynamicLinkData.getDeepLink()) == null) {
            return null;
        }
        return Uri.parse(deepLink);
    }

    public int getMinimumAppVersion() {
        DynamicLinkData dynamicLinkData = this.dynamicLinkData;
        if (dynamicLinkData == null) {
            return 0;
        }
        return dynamicLinkData.getMinVersion();
    }

    @VisibleForTesting
    public Uri getRedirectUrl() {
        DynamicLinkData dynamicLinkData = this.dynamicLinkData;
        if (dynamicLinkData == null) {
            return null;
        }
        return dynamicLinkData.getRedirectUrl();
    }

    public Intent getUpdateAppIntent(Context context) {
        if (getMinimumAppVersion() == 0) {
            return null;
        }
        try {
            if (context.getPackageManager().getPackageInfo(context.getApplicationContext().getPackageName(), 0).versionCode < getMinimumAppVersion() && getRedirectUrl() != null) {
                return new Intent("android.intent.action.VIEW").setData(getRedirectUrl()).setPackage("com.android.vending");
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return null;
    }

    public Bundle getUtmParameters() {
        DynamicLinkUTMParams dynamicLinkUTMParams = this.dynamicLinkUTMParams;
        return dynamicLinkUTMParams == null ? new Bundle() : dynamicLinkUTMParams.asBundle();
    }

    public PendingDynamicLinkData(String str, int i10, long j10, Uri uri) {
        DynamicLinkData dynamicLinkData = new DynamicLinkData(null, str, i10, j10, null, uri);
        this.dynamicLinkData = dynamicLinkData;
        this.dynamicLinkUTMParams = new DynamicLinkUTMParams(dynamicLinkData);
    }
}
