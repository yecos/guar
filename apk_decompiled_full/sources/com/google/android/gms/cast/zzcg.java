package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes.dex */
public final class zzcg implements Parcelable.Creator<MediaQueueItem> {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ MediaQueueItem createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        MediaInfo mediaInfo = null;
        long[] jArr = null;
        String str = null;
        double d10 = 0.0d;
        double d11 = 0.0d;
        double d12 = 0.0d;
        int i10 = 0;
        boolean z10 = false;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 2:
                    mediaInfo = (MediaInfo) SafeParcelReader.createParcelable(parcel, readHeader, MediaInfo.CREATOR);
                    break;
                case 3:
                    i10 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 4:
                    z10 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 5:
                    d10 = SafeParcelReader.readDouble(parcel, readHeader);
                    break;
                case 6:
                    d11 = SafeParcelReader.readDouble(parcel, readHeader);
                    break;
                case 7:
                    d12 = SafeParcelReader.readDouble(parcel, readHeader);
                    break;
                case 8:
                    jArr = SafeParcelReader.createLongArray(parcel, readHeader);
                    break;
                case 9:
                    str = SafeParcelReader.createString(parcel, readHeader);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new MediaQueueItem(mediaInfo, i10, z10, d10, d11, d12, jArr, str);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ MediaQueueItem[] newArray(int i10) {
        return new MediaQueueItem[i10];
    }
}
