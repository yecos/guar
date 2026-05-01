package com.google.android.gms.internal.common;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;

/* loaded from: classes.dex */
final class zzl extends zzk {
    private final char zza;

    public zzl(char c10) {
        this.zza = c10;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CharMatcher.is('");
        int i10 = this.zza;
        char[] cArr = {ASCIIPropertyListParser.QUOTEDSTRING_ESCAPE_TOKEN, 'u', 0, 0, 0, 0};
        for (int i11 = 0; i11 < 4; i11++) {
            cArr[5 - i11] = "0123456789ABCDEF".charAt(i10 & 15);
            i10 >>= 4;
        }
        sb.append(String.copyValueOf(cArr));
        sb.append("')");
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.common.zzo
    public final boolean zza(char c10) {
        return c10 == this.zza;
    }
}
