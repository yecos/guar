package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.os.Build;
import android.os.UserManager;

/* loaded from: classes.dex */
public final class zzhb {
    private static UserManager zza;
    private static volatile boolean zzb = !zzb();

    private zzhb() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x003d, code lost:
    
        if (r4.isUserRunning(android.os.Process.myUserHandle()) == false) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x003f, code lost:
    
        r7 = true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean zza(Context context) {
        boolean z10;
        boolean isUserUnlocked;
        Object systemService;
        if (zzb() && !zzb) {
            synchronized (zzhb.class) {
                if (!zzb) {
                    int i10 = 1;
                    while (true) {
                        if (i10 > 2) {
                            break;
                        }
                        if (zza == null) {
                            systemService = context.getSystemService((Class<Object>) UserManager.class);
                            zza = (UserManager) systemService;
                        }
                        UserManager userManager = zza;
                        if (userManager == null) {
                            z10 = true;
                            break;
                        }
                        try {
                            isUserUnlocked = userManager.isUserUnlocked();
                            if (isUserUnlocked) {
                                break;
                            }
                        } catch (NullPointerException unused) {
                            zza = null;
                            i10++;
                        }
                    }
                    z10 = false;
                    if (z10) {
                        zza = null;
                    }
                    if (z10) {
                        zzb = true;
                    }
                    if (!z10) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean zzb() {
        return Build.VERSION.SDK_INT >= 24;
    }
}
