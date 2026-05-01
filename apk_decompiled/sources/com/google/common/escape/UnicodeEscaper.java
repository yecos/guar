package com.google.common.escape;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import javax.annotation.CheckForNull;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes2.dex */
public abstract class UnicodeEscaper extends Escaper {
    private static final int DEST_PAD = 32;

    public static int codePointAt(CharSequence charSequence, int i10, int i11) {
        Preconditions.checkNotNull(charSequence);
        if (i10 >= i11) {
            throw new IndexOutOfBoundsException("Index exceeds specified range");
        }
        int i12 = i10 + 1;
        char charAt = charSequence.charAt(i10);
        if (charAt < 55296 || charAt > 57343) {
            return charAt;
        }
        if (charAt > 56319) {
            String valueOf = String.valueOf(charSequence);
            StringBuilder sb = new StringBuilder(valueOf.length() + 88);
            sb.append("Unexpected low surrogate character '");
            sb.append(charAt);
            sb.append("' with value ");
            sb.append((int) charAt);
            sb.append(" at index ");
            sb.append(i12 - 1);
            sb.append(" in '");
            sb.append(valueOf);
            sb.append("'");
            throw new IllegalArgumentException(sb.toString());
        }
        if (i12 == i11) {
            return -charAt;
        }
        char charAt2 = charSequence.charAt(i12);
        if (Character.isLowSurrogate(charAt2)) {
            return Character.toCodePoint(charAt, charAt2);
        }
        String valueOf2 = String.valueOf(charSequence);
        StringBuilder sb2 = new StringBuilder(valueOf2.length() + 89);
        sb2.append("Expected low surrogate but got char '");
        sb2.append(charAt2);
        sb2.append("' with value ");
        sb2.append((int) charAt2);
        sb2.append(" at index ");
        sb2.append(i12);
        sb2.append(" in '");
        sb2.append(valueOf2);
        sb2.append("'");
        throw new IllegalArgumentException(sb2.toString());
    }

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
        int nextEscapeIndex = nextEscapeIndex(str, 0, length);
        return nextEscapeIndex == length ? str : escapeSlow(str, nextEscapeIndex);
    }

    @CheckForNull
    public abstract char[] escape(int i10);

    public final String escapeSlow(String str, int i10) {
        int length = str.length();
        char[] charBufferFromThreadLocal = Platform.charBufferFromThreadLocal();
        int i11 = 0;
        int i12 = 0;
        while (i10 < length) {
            int codePointAt = codePointAt(str, i10, length);
            if (codePointAt < 0) {
                throw new IllegalArgumentException("Trailing high surrogate at end of input");
            }
            char[] escape = escape(codePointAt);
            int i13 = (Character.isSupplementaryCodePoint(codePointAt) ? 2 : 1) + i10;
            if (escape != null) {
                int i14 = i10 - i11;
                int i15 = i12 + i14;
                int length2 = escape.length + i15;
                if (charBufferFromThreadLocal.length < length2) {
                    charBufferFromThreadLocal = growBuffer(charBufferFromThreadLocal, i12, length2 + (length - i10) + 32);
                }
                if (i14 > 0) {
                    str.getChars(i11, i10, charBufferFromThreadLocal, i12);
                    i12 = i15;
                }
                if (escape.length > 0) {
                    System.arraycopy(escape, 0, charBufferFromThreadLocal, i12, escape.length);
                    i12 += escape.length;
                }
                i11 = i13;
            }
            i10 = nextEscapeIndex(str, i13, length);
        }
        int i16 = length - i11;
        if (i16 > 0) {
            int i17 = i16 + i12;
            if (charBufferFromThreadLocal.length < i17) {
                charBufferFromThreadLocal = growBuffer(charBufferFromThreadLocal, i12, i17);
            }
            str.getChars(i11, length, charBufferFromThreadLocal, i12);
            i12 = i17;
        }
        return new String(charBufferFromThreadLocal, 0, i12);
    }

    public int nextEscapeIndex(CharSequence charSequence, int i10, int i11) {
        while (i10 < i11) {
            int codePointAt = codePointAt(charSequence, i10, i11);
            if (codePointAt < 0 || escape(codePointAt) != null) {
                break;
            }
            i10 += Character.isSupplementaryCodePoint(codePointAt) ? 2 : 1;
        }
        return i10;
    }
}
