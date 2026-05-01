package com.hpplay.common.utils;

/* loaded from: classes2.dex */
public class WifiInfoCache {
    public static String wIdbss;
    public static String wIdbssNoneColon;
    public static String wIdss;

    public static void clearCache() {
        wIdss = null;
        wIdbss = null;
        wIdbssNoneColon = null;
    }
}
