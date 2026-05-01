package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;

/* loaded from: classes.dex */
public interface IGmsCallbacks extends IInterface {
    void onPostInitComplete(int i10, IBinder iBinder, Bundle bundle);

    void zzb(int i10, Bundle bundle);

    void zzc(int i10, IBinder iBinder, zzj zzjVar);
}
