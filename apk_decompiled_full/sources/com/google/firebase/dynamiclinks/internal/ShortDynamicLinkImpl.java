package com.google.firebase.dynamiclinks.internal;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.firebase.dynamiclinks.ShortDynamicLink;
import java.util.ArrayList;
import java.util.List;

@SafeParcelable.Class(creator = "ShortDynamicLinkImplCreator")
/* loaded from: classes2.dex */
public final class ShortDynamicLinkImpl extends AbstractSafeParcelable implements ShortDynamicLink {
    public static final Parcelable.Creator<ShortDynamicLinkImpl> CREATOR = new ShortDynamicLinkImplCreator();

    @SafeParcelable.Field(getter = "getPreviewLink", id = 2)
    private final Uri previewLink;

    @SafeParcelable.Field(getter = "getShortLink", id = 1)
    private final Uri shortLink;

    @SafeParcelable.Field(getter = "getWarnings", id = 3)
    private final List<WarningImpl> warnings;

    @SafeParcelable.Class(creator = "WarningImplCreator")
    public static class WarningImpl extends AbstractSafeParcelable implements ShortDynamicLink.Warning {
        public static final Parcelable.Creator<WarningImpl> CREATOR = new WarningImplCreator();

        @SafeParcelable.Field(getter = "getMessage", id = 2)
        @SafeParcelable.Reserved({1})
        private final String message;

        @SafeParcelable.Constructor
        public WarningImpl(@SafeParcelable.Param(id = 2) String str) {
            this.message = str;
        }

        @Override // com.google.firebase.dynamiclinks.ShortDynamicLink.Warning
        public String getCode() {
            return null;
        }

        @Override // com.google.firebase.dynamiclinks.ShortDynamicLink.Warning
        public String getMessage() {
            return this.message;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            WarningImplCreator.writeToParcel(this, parcel, i10);
        }
    }

    @SafeParcelable.Constructor
    public ShortDynamicLinkImpl(@SafeParcelable.Param(id = 1) Uri uri, @SafeParcelable.Param(id = 2) Uri uri2, @SafeParcelable.Param(id = 3) List<WarningImpl> list) {
        this.shortLink = uri;
        this.previewLink = uri2;
        this.warnings = list == null ? new ArrayList<>() : list;
    }

    @Override // com.google.firebase.dynamiclinks.ShortDynamicLink
    public Uri getPreviewLink() {
        return this.previewLink;
    }

    @Override // com.google.firebase.dynamiclinks.ShortDynamicLink
    public Uri getShortLink() {
        return this.shortLink;
    }

    @Override // com.google.firebase.dynamiclinks.ShortDynamicLink
    public List<WarningImpl> getWarnings() {
        return this.warnings;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        ShortDynamicLinkImplCreator.writeToParcel(this, parcel, i10);
    }
}
