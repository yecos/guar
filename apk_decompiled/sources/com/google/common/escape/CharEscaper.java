package com.google.common.escape;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import javax.annotation.CheckForNull;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes2.dex */
public abstract class CharEscaper extends Escaper {
    private static final int DEST_PAD_MULTIPLIER = 2;

    private static char[] growBuffer(char[] cArr, int i10, int i11) {
        if (i11 < 0) {
            throw new AssertionError("Cannot increase internal buffer any further");
        }
        char[] cArr2 = new char[i11];
        if (i10 > 0) {
            System.arraycopy(cArr, 0, cArr2, 0, i10);
        }
        return cArr2;
    }

    @Override // com.google.common.escape.Escaper
    public String escape(String str) {
        Preconditions.checkNotNull(str);
        int length = str.length();
        for (int i10 = 0; i10 < length; i10++) {
            if (escape(str.charAt(i10)) != null) {
                return escapeSlow(str, i10);
            }
        }
        return str;
    }

    @CheckForNull
    public abstract char[] escape(char c10);

    public final String escapeSlow(String str, int i10) {
        int length = str.length();
        char[] charBufferFromThreadLocal = Platform.charBufferFromThreadLocal();
        int length2 = charBufferFromThreadLocal.length;
        int i11 = 0;
        int i12 = 0;
        while (i10 < length) {
            char[] escape = escape(str.charAt(i10));
            if (escape != null) {
                int length3 = escape.length;
                int i13 = i10 - i11;
                int i14 = i12 + i13;
                int i15 = i14 + length3;
                if (length2 < i15) {
                    length2 = ((length - i10) * 2) + i15;
                    charBufferFromThreadLocal = growBuffer(charBufferFromThreadLocal, i12, length2);
                }
                if (i13 > 0) {
                    str.getChars(i11, i10, charBufferFromThreadLocal, i12);
                    i12 = i14;
                }
                if (length3 > 0) {
                    System.arraycopy(escape, 0, charBufferFromThreadLocal, i12, length3);
                    i12 += length3;
                }
                i11 = i10 + 1;
            }
            i10++;
        }
        int i16 = length - i11;
        if (i16 > 0) {
            int i17 = i16 + i12;
            if (length2 < i17) {
                charBufferFromThreadLocal = growBuffer(charBufferFromThreadLocal, i12, i17);
            }
            str.getChars(i11, length, charBufferFromThreadLocal, i12);
            i12 = i17;
        }
        return new String(charBufferFromThreadLocal, 0, i12);
    }
}
