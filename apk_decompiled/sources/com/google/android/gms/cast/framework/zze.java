package com.google.android.gms.cast.framework;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.cast.LaunchOptions;
import com.google.android.gms.cast.framework.media.CastMediaOptions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class zze implements Parcelable.Creator<CastOptions> {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ CastOptions createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        String str = null;
        ArrayList<String> arrayList = null;
        LaunchOptions launchOptions = null;
        CastMediaOptions castMediaOptions = null;
        double d10 = 0.0d;
        boolean z10 = false;
        boolean z11 = false;
        boolean z12 = false;
        boolean z13 = false;
        boolean z14 = false;
        boolean z15 = false;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 2:
                    str = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 3:
                    arrayList = SafeParcelReader.createStringList(parcel, readHeader);
                    break;
                case 4:
                    z10 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 5:
                    launchOptions = (LaunchOptions) SafeParcelReader.createParcelable(parcel, readHeader, LaunchOptions.CREATOR);
                    break;
                case 6:
                    z11 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 7:
                    castMediaOptions = (CastMediaOptions) SafeParcelReader.createParcelable(parcel, readHeader, CastMediaOptions.CREATOR);
                    break;
                case 8:
                    z12 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 9:
                    d10 = SafeParcelReader.readDouble(parcel, readHeader);
                    break;
                case 10:
                    z13 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 11:
                    z14 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 12:
                    z15 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new CastOptions(str, arrayList, z10, launchOptions, z11, castMediaOptions, z12, d10, z13, z14, z15);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ CastOptions[] newArray(int i10) {
        return new CastOptions[i10];
    }
}
