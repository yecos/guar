package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class zzci implements Parcelable.Creator<MediaStatus> {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ MediaStatus createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        MediaInfo mediaInfo = null;
        long[] jArr = null;
        String str = null;
        ArrayList arrayList = null;
        AdBreakStatus adBreakStatus = null;
        VideoInfo videoInfo = null;
        MediaLiveSeekableRange mediaLiveSeekableRange = null;
        MediaQueueData mediaQueueData = null;
        long j10 = 0;
        long j11 = 0;
        long j12 = 0;
        double d10 = 0.0d;
        double d11 = 0.0d;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        boolean z10 = false;
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        boolean z11 = false;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 2:
                    mediaInfo = (MediaInfo) SafeParcelReader.createParcelable(parcel, readHeader, MediaInfo.CREATOR);
                    break;
                case 3:
                    j10 = SafeParcelReader.readLong(parcel, readHeader);
                    break;
                case 4:
                    i10 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 5:
                    d10 = SafeParcelReader.readDouble(parcel, readHeader);
                    break;
                case 6:
                    i11 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 7:
                    i12 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 8:
                    j11 = SafeParcelReader.readLong(parcel, readHeader);
                    break;
                case 9:
                    j12 = SafeParcelReader.readLong(parcel, readHeader);
                    break;
                case 10:
                    d11 = SafeParcelReader.readDouble(parcel, readHeader);
                    break;
                case 11:
                    z10 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 12:
                    jArr = SafeParcelReader.createLongArray(parcel, readHeader);
                    break;
                case 13:
                    i13 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 14:
                    i14 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 15:
                    str = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 16:
                    i15 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 17:
                    arrayList = SafeParcelReader.createTypedList(parcel, readHeader, MediaQueueItem.CREATOR);
                    break;
                case 18:
                    z11 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 19:
                    adBreakStatus = (AdBreakStatus) SafeParcelReader.createParcelable(parcel, readHeader, AdBreakStatus.CREATOR);
                    break;
                case 20:
                    videoInfo = (VideoInfo) SafeParcelReader.createParcelable(parcel, readHeader, VideoInfo.CREATOR);
                    break;
                case 21:
                    mediaLiveSeekableRange = (MediaLiveSeekableRange) SafeParcelReader.createParcelable(parcel, readHeader, MediaLiveSeekableRange.CREATOR);
                    break;
                case 22:
                    mediaQueueData = (MediaQueueData) SafeParcelReader.createParcelable(parcel, readHeader, MediaQueueData.CREATOR);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new MediaStatus(mediaInfo, j10, i10, d10, i11, i12, j11, j12, d11, z10, jArr, i13, i14, str, i15, arrayList, z11, adBreakStatus, videoInfo, mediaLiveSeekableRange, mediaQueueData);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ MediaStatus[] newArray(int i10) {
        return new MediaStatus[i10];
    }
}
