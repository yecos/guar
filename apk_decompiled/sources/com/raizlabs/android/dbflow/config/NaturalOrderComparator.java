package com.raizlabs.android.dbflow.config;

import java.util.Comparator;

/* loaded from: classes3.dex */
public class NaturalOrderComparator implements Comparator<Object> {
    public static char charAt(String str, int i10) {
        if (i10 >= str.length()) {
            return (char) 0;
        }
        return str.charAt(i10);
    }

    @Override // java.util.Comparator
    public int compare(Object obj, Object obj2) {
        int compareRight;
        String obj3 = obj.toString();
        String obj4 = obj2.toString();
        int i10 = 0;
        int i11 = 0;
        while (true) {
            char charAt = charAt(obj3, i10);
            char charAt2 = charAt(obj4, i11);
            int i12 = 0;
            while (true) {
                if (!Character.isSpaceChar(charAt) && charAt != '0') {
                    break;
                }
                i12 = charAt == '0' ? i12 + 1 : 0;
                i10++;
                charAt = charAt(obj3, i10);
            }
            int i13 = 0;
            while (true) {
                if (!Character.isSpaceChar(charAt2) && charAt2 != '0') {
                    break;
                }
                i13 = charAt2 == '0' ? i13 + 1 : 0;
                i11++;
                charAt2 = charAt(obj4, i11);
            }
            if (Character.isDigit(charAt) && Character.isDigit(charAt2) && (compareRight = compareRight(obj3.substring(i10), obj4.substring(i11))) != 0) {
                return compareRight;
            }
            if (charAt == 0 && charAt2 == 0) {
                return i12 - i13;
            }
            if (charAt < charAt2) {
                return -1;
            }
            if (charAt > charAt2) {
                return 1;
            }
            i10++;
            i11++;
        }
    }

    public int compareRight(String str, String str2) {
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        while (true) {
            char charAt = charAt(str, i10);
            char charAt2 = charAt(str2, i11);
            if (!Character.isDigit(charAt) && !Character.isDigit(charAt2)) {
                return i12;
            }
            if (!Character.isDigit(charAt)) {
                return -1;
            }
            if (!Character.isDigit(charAt2)) {
                return 1;
            }
            if (charAt < charAt2) {
                if (i12 == 0) {
                    i12 = -1;
                }
            } else if (charAt > charAt2) {
                if (i12 == 0) {
                    i12 = 1;
                }
            } else if (charAt == 0 && charAt2 == 0) {
                return i12;
            }
            i10++;
            i11++;
        }
    }
}
