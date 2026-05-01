package com.hpplay.cybergarage.util;

import com.hpplay.component.common.utils.CLog;

/* loaded from: classes2.dex */
public final class StringUtil {
    private static final String TAG = "Cyber-StringUtil";

    public static final int findFirstNotOf(String str, String str2) {
        return findOf(str, str2, 0, str.length() - 1, 1, false);
    }

    public static final int findFirstOf(String str, String str2) {
        return findOf(str, str2, 0, str.length() - 1, 1, true);
    }

    public static final int findLastNotOf(String str, String str2) {
        return findOf(str, str2, str.length() - 1, 0, -1, false);
    }

    public static final int findLastOf(String str, String str2) {
        return findOf(str, str2, str.length() - 1, 0, -1, true);
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x000f, code lost:
    
        return -1;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final int findOf(String str, String str2, int i10, int i11, int i12, boolean z10) {
        int i13;
        if (i12 == 0) {
            return -1;
        }
        int length = str2.length();
        while (true) {
            if (i12 > 0) {
                if (i11 < i10) {
                    break;
                }
                char charAt = str.charAt(i10);
                int i14 = 0;
                for (i13 = 0; i13 < length; i13++) {
                    char charAt2 = str2.charAt(i13);
                    if (!z10) {
                        if (charAt != charAt2) {
                            i14++;
                        }
                        if (i14 == length) {
                            return i10;
                        }
                    } else if (charAt == charAt2) {
                        return i10;
                    }
                }
                i10 += i12;
            } else {
                if (i10 < i11) {
                    break;
                }
                char charAt3 = str.charAt(i10);
                int i142 = 0;
                while (i13 < length) {
                }
                i10 += i12;
            }
        }
    }

    public static final boolean hasData(String str) {
        return str != null && str.length() > 0;
    }

    public static final int toInteger(String str) {
        try {
            return Integer.parseInt(str);
        } catch (Exception e10) {
            CLog.d(TAG, null, e10);
            return 0;
        }
    }

    public static final long toLong(String str) {
        try {
            return Long.parseLong(str);
        } catch (Exception e10) {
            CLog.d(TAG, null, e10);
            return 0L;
        }
    }

    public static final String trim(String str, String str2) {
        int findFirstNotOf = findFirstNotOf(str, str2);
        if (findFirstNotOf < 0) {
            return str;
        }
        String substring = str.substring(findFirstNotOf, str.length());
        int findLastNotOf = findLastNotOf(substring, str2);
        return findLastNotOf < 0 ? substring : substring.substring(0, findLastNotOf + 1);
    }
}
