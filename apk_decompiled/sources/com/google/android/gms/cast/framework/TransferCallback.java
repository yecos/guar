package com.google.android.gms.cast.framework;

import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.cast.SessionState;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.ShowFirstParty;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@ShowFirstParty
@KeepForSdk
/* loaded from: classes.dex */
public abstract class TransferCallback {

    @KeepForSdk
    public static final int TRANSFER_TYPE_FROM_CAST_TO_LOCAL = 1;

    @KeepForSdk
    public static final int TRANSFER_TYPE_UNKNOWN = 0;

    @KeepForSdk
    @Retention(RetentionPolicy.SOURCE)
    public @interface TransferType {
    }

    @KeepForSdk
    public void onTransfer(int i10, @RecentlyNonNull SessionState sessionState) {
    }
}
