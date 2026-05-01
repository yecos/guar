package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes.dex */
public final class zzbv implements Parcelable.Creator<MediaLiveSeekableRange> {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ MediaLiveSeekableRange createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        long j10 = 0;
        long j11 = 0;
        boolean z10 = false;
        boolean z11 = false;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            int fieldId = SafeParcelReader.getFieldId(readHeader);
            if (fieldId == 2) {
                j10 = SafeParcelReader.readLong(parcel, readHeader);
            } else if (fieldId == 3) {
                j11 = SafeParcelReader.readLong(parcel, readHeader);
            } else if (fieldId == 4) {
                z10 = SafeParcelReader.readBoolean(parcel, readHeader);
            } else if (fieldId != 5) {
                SafeParcelReader.skipUnknownField(parcel, readHeader);
            } else {
                z11 = SafeParcelReader.readBoolean(parcel, readHeader);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new MediaLiveSeekableRange(j10, j11, z10, z11);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ MediaLiveSeekableRange[] newArray(int i10) {
        return new MediaLiveSeekableRange[i10];
    }
}
