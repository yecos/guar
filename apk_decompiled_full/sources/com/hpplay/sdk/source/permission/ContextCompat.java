package com.hpplay.sdk.source.permission;

import android.content.Context;
import android.os.Process;

/* loaded from: classes3.dex */
public class ContextCompat {
    private static final String TAG = "ContextCompat";

    public static int checkSelfPermission(Context context, String str) {
        if (str != null) {
            return context.checkPermission(str, Process.myPid(), Process.myUid());
        }
        throw new IllegalArgumentException("permission is null");
    }
}
