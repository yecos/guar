package com.google.firebase.dynamiclinks.internal;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* loaded from: classes2.dex */
public class DynamicLinkDataCreator implements Parcelable.Creator<DynamicLinkData> {
    public static final int CONTENT_DESCRIPTION = 0;

    public static void writeToParcel(DynamicLinkData dynamicLinkData, Parcel parcel, int i10) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, dynamicLinkData.getDynamicLink(), false);
        SafeParcelWriter.writeString(parcel, 2, dynamicLinkData.getDeepLink(), false);
        SafeParcelWriter.writeInt(parcel, 3, dynamicLinkData.getMinVersion());
        SafeParcelWriter.writeLong(parcel, 4, dynamicLinkData.getClickTimestamp());
        SafeParcelWriter.writeBundle(parcel, 5, dynamicLinkData.getExtensionBundle(), false);
        SafeParcelWriter.writeParcelable(parcel, 6, dynamicLinkData.getRedirectUrl(), i10, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public DynamicLinkData createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        String str = null;
        String str2 = null;
        Bundle bundle = null;
        Uri uri = null;
        long j10 = 0;
        int i10 = 0;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 1:
                    str = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 2:
                    str2 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 3:
                    i10 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 4:
                    j10 = SafeParcelReader.readLong(parcel, readHeader);
                    break;
                case 5:
                    bundle = SafeParcelReader.createBundle(parcel, readHeader);
                    break;
                case 6:
                    uri = (Uri) SafeParcelReader.createParcelable(parcel, readHeader, Uri.CREATOR);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new DynamicLinkData(str, str2, i10, j10, bundle, uri);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public DynamicLinkData[] newArray(int i10) {
        return new DynamicLinkData[i10];
    }
}
