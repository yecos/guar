package com.google.firebase.dynamiclinks.internal;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "DynamicLinkDataCreator")
/* loaded from: classes2.dex */
public class DynamicLinkData extends AbstractSafeParcelable {
    public static final Parcelable.Creator<DynamicLinkData> CREATOR = new DynamicLinkDataCreator();

    @SafeParcelable.Field(getter = "getClickTimestamp", id = 4)
    private long clickTimestamp;

    @SafeParcelable.Field(getter = "getDeepLink", id = 2)
    private String deepLink;

    @SafeParcelable.Field(getter = "getDynamicLink", id = 1)
    private String dynamicLink;

    @SafeParcelable.Field(getter = "getExtensionBundle", id = 5)
    private Bundle extensionBundle;

    @SafeParcelable.Field(getter = "getMinVersion", id = 3)
    private int minVersion;

    @SafeParcelable.Field(getter = "getRedirectUrl", id = 6)
    private Uri redirectUrl;

    @SafeParcelable.Constructor
    public DynamicLinkData(@SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 2) String str2, @SafeParcelable.Param(id = 3) int i10, @SafeParcelable.Param(id = 4) long j10, @SafeParcelable.Param(id = 5) Bundle bundle, @SafeParcelable.Param(id = 6) Uri uri) {
        this.dynamicLink = str;
        this.deepLink = str2;
        this.minVersion = i10;
        this.clickTimestamp = j10;
        this.extensionBundle = bundle;
        this.redirectUrl = uri;
    }

    public long getClickTimestamp() {
        return this.clickTimestamp;
    }

    public String getDeepLink() {
        return this.deepLink;
    }

    public String getDynamicLink() {
        return this.dynamicLink;
    }

    public Bundle getExtensionBundle() {
        Bundle bundle = this.extensionBundle;
        return bundle == null ? new Bundle() : bundle;
    }

    public int getMinVersion() {
        return this.minVersion;
    }

    public Uri getRedirectUrl() {
        return this.redirectUrl;
    }

    public void setClickTimestamp(long j10) {
        this.clickTimestamp = j10;
    }

    public void setDeepLink(String str) {
        this.deepLink = str;
    }

    public void setDynamicLink(String str) {
        this.dynamicLink = str;
    }

    public void setExtensionData(Bundle bundle) {
        this.extensionBundle = bundle;
    }

    public void setMinVersion(int i10) {
        this.minVersion = i10;
    }

    public void setRedirectUrl(Uri uri) {
        this.redirectUrl = uri;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        DynamicLinkDataCreator.writeToParcel(this, parcel, i10);
    }
}
