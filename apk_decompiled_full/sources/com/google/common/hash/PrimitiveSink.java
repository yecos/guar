package com.google.common.hash;

import com.google.common.annotations.Beta;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

@CanIgnoreReturnValue
@Beta
@ElementTypesAreNonnullByDefault
/* loaded from: classes2.dex */
public interface PrimitiveSink {
    PrimitiveSink putBoolean(boolean z10);

    PrimitiveSink putByte(byte b10);

    PrimitiveSink putBytes(ByteBuffer byteBuffer);

    PrimitiveSink putBytes(byte[] bArr);

    PrimitiveSink putBytes(byte[] bArr, int i10, int i11);

    PrimitiveSink putChar(char c10);

    PrimitiveSink putDouble(double d10);

    PrimitiveSink putFloat(float f10);

    PrimitiveSink putInt(int i10);

    PrimitiveSink putLong(long j10);

    PrimitiveSink putShort(short s10);

    PrimitiveSink putString(CharSequence charSequence, Charset charset);

    PrimitiveSink putUnencodedChars(CharSequence charSequence);
}
