package com.hpplay.sdk.source.protocol.browser.sonic;

import android.content.Context;
import com.hpplay.sdk.source.browse.api.IServiceInfoParseListener;
import com.hpplay.sdk.source.config.LelinkConfig;
import com.hpplay.sdk.source.permission.ContextCompat;

/* loaded from: classes3.dex */
public class SonicProxy {
    public static boolean canStartSonicBrowse(Context context) {
        return LelinkConfig.isSupportSonic() && ContextCompat.checkSelfPermission(context, "android.permission.RECORD_AUDIO") == 0;
    }

    public static boolean isBrowserSuccess() {
        if (LelinkConfig.isSupportSonic()) {
            return SonicBrowseBridge.getInstance().isBrowserSuccess();
        }
        return false;
    }

    public static void release() {
        if (LelinkConfig.isSupportSonic()) {
            SonicBrowseBridge.getInstance().release();
        }
    }

    public static void setServiceInfoParseListener(IServiceInfoParseListener iServiceInfoParseListener) {
        if (LelinkConfig.isSupportSonic()) {
            SonicBrowseBridge.getInstance().setServiceInfoParseListener(iServiceInfoParseListener);
        }
    }

    public static boolean startBrowse(Context context) {
        if (LelinkConfig.isSupportSonic()) {
            return SonicBrowseBridge.getInstance().startBrowse(context);
        }
        return false;
    }

    public static void stopBrowse(Context context) {
        if (LelinkConfig.isSupportSonic()) {
            SonicBrowseBridge.getInstance().stopBrowse(context);
        }
    }
}
