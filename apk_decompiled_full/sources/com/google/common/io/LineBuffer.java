package com.google.common.io;

import com.google.common.annotations.GwtIncompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;

@ElementTypesAreNonnullByDefault
@GwtIncompatible
/* loaded from: classes2.dex */
abstract class LineBuffer {
    private StringBuilder line = new StringBuilder();
    private boolean sawReturn;

    @CanIgnoreReturnValue
    private boolean finishLine(boolean z10) {
        handleLine(this.line.toString(), this.sawReturn ? z10 ? "\r\n" : "\r" : z10 ? "\n" : "");
        this.line = new StringBuilder();
        this.sawReturn = false;
        return z10;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x001f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void add(char[] cArr, int i10, int i11) {
        int i12;
        int i13;
        if (this.sawReturn && i11 > 0) {
            if (finishLine(cArr[i10] == '\n')) {
                i12 = i10 + 1;
                i13 = i10 + i11;
                int i14 = i12;
                while (i12 < i13) {
                    char c10 = cArr[i12];
                    if (c10 == '\n') {
                        this.line.append(cArr, i14, i12 - i14);
                        finishLine(true);
                    } else if (c10 != '\r') {
                        i12++;
                    } else {
                        this.line.append(cArr, i14, i12 - i14);
                        this.sawReturn = true;
                        int i15 = i12 + 1;
                        if (i15 < i13) {
                            if (finishLine(cArr[i15] == '\n')) {
                                i12 = i15;
                            }
                        }
                    }
                    i14 = i12 + 1;
                    i12++;
                }
                this.line.append(cArr, i14, i13 - i14);
            }
        }
        i12 = i10;
        i13 = i10 + i11;
        int i142 = i12;
        while (i12 < i13) {
        }
        this.line.append(cArr, i142, i13 - i142);
    }

    public void finish() {
        if (this.sawReturn || this.line.length() > 0) {
            finishLine(false);
        }
    }

    public abstract void handleLine(String str, String str2);
}
