package com.google.android.gms.cast.framework.media;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class zzab implements Parcelable.Creator<NotificationOptions> {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ NotificationOptions createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        ArrayList<String> arrayList = null;
        int[] iArr = null;
        String str = null;
        IBinder iBinder = null;
        long j10 = 0;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        int i16 = 0;
        int i17 = 0;
        int i18 = 0;
        int i19 = 0;
        int i20 = 0;
        int i21 = 0;
        int i22 = 0;
        int i23 = 0;
        int i24 = 0;
        int i25 = 0;
        int i26 = 0;
        int i27 = 0;
        int i28 = 0;
        int i29 = 0;
        int i30 = 0;
        int i31 = 0;
        int i32 = 0;
        int i33 = 0;
        int i34 = 0;
        int i35 = 0;
        int i36 = 0;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 2:
                    arrayList = SafeParcelReader.createStringList(parcel, readHeader);
                    break;
                case 3:
                    iArr = SafeParcelReader.createIntArray(parcel, readHeader);
                    break;
                case 4:
                    j10 = SafeParcelReader.readLong(parcel, readHeader);
                    break;
                case 5:
                    str = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 6:
                    i10 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 7:
                    i11 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 8:
                    i12 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 9:
                    i13 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 10:
                    i14 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 11:
                    i15 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 12:
                    i16 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 13:
                    i17 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 14:
                    i18 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 15:
                    i19 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 16:
                    i20 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 17:
                    i21 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 18:
                    i22 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 19:
                    i23 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 20:
                    i24 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 21:
                    i25 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 22:
                    i26 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 23:
                    i27 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 24:
                    i28 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 25:
                    i29 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 26:
                    i30 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 27:
                    i31 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 28:
                    i32 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 29:
                    i33 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 30:
                    i34 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 31:
                    i35 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 32:
                    i36 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 33:
                    iBinder = SafeParcelReader.readIBinder(parcel, readHeader);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new NotificationOptions(arrayList, iArr, j10, str, i10, i11, i12, i13, i14, i15, i16, i17, i18, i19, i20, i21, i22, i23, i24, i25, i26, i27, i28, i29, i30, i31, i32, i33, i34, i35, i36, iBinder);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ NotificationOptions[] newArray(int i10) {
        return new NotificationOptions[i10];
    }
}
