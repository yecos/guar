package com.hpplay.sdk.source.mdns.xbill.dns;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/* loaded from: classes3.dex */
public final class Options {
    private static Map table;

    static {
        try {
            refresh();
        } catch (SecurityException unused) {
        }
    }

    private Options() {
    }

    public static boolean check(String str) {
        Map map = table;
        return (map == null || map.get(str.toLowerCase()) == null) ? false : true;
    }

    public static void clear() {
        table = null;
    }

    public static int intValue(String str) {
        String value = value(str);
        if (value == null) {
            return -1;
        }
        try {
            int parseInt = Integer.parseInt(value);
            if (parseInt > 0) {
                return parseInt;
            }
            return -1;
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    public static void refresh() {
        String property = System.getProperty("dnsjava.options");
        if (property != null) {
            StringTokenizer stringTokenizer = new StringTokenizer(property, ",");
            while (stringTokenizer.hasMoreTokens()) {
                String nextToken = stringTokenizer.nextToken();
                int indexOf = nextToken.indexOf(61);
                if (indexOf == -1) {
                    set(nextToken);
                } else {
                    set(nextToken.substring(0, indexOf), nextToken.substring(indexOf + 1));
                }
            }
        }
    }

    public static void set(String str) {
        if (table == null) {
            table = new HashMap();
        }
        table.put(str.toLowerCase(), "true");
    }

    public static void unset(String str) {
        Map map = table;
        if (map != null) {
            map.remove(str.toLowerCase());
        }
    }

    public static String value(String str) {
        Map map = table;
        if (map == null) {
            return null;
        }
        return (String) map.get(str.toLowerCase());
    }

    public static void set(String str, String str2) {
        if (table == null) {
            table = new HashMap();
        }
        table.put(str.toLowerCase(), str2.toLowerCase());
    }
}
