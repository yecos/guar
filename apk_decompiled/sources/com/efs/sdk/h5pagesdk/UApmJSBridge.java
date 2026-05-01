package com.efs.sdk.h5pagesdk;

import android.webkit.JavascriptInterface;

/* loaded from: classes.dex */
public class UApmJSBridge {
    @JavascriptInterface
    public String getLaunchOptionsSync() {
        if (H5Manager.getH5ConfigMananger() == null) {
            String str = H5Manager.TAG;
            return "";
        }
        String generateLaunchOptions = H5Manager.getH5ConfigMananger().generateLaunchOptions();
        String str2 = H5Manager.TAG;
        return generateLaunchOptions;
    }

    @JavascriptInterface
    public void sendData(String str) {
        if (str != null) {
            try {
                if (str.length() != 0) {
                    boolean z10 = H5Manager.isDebug;
                    if (H5Manager.getH5ConfigMananger() != null) {
                        H5Manager.getH5ConfigMananger().sendData(str);
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }
}
