package com.google.common.hash;

import com.google.common.annotations.Beta;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

@CanIgnoreReturnValue
@Beta
@ElementTypesAreNonnullByDefault
/* loaded from: classes2.dex */
public interface Hasher extends PrimitiveSink {
    HashCode hash();

    @Deprecated
    int hashCode();

    @Override // com.google.common.hash.PrimitiveSink
    Hasher putBoolean(boolean z10);

    @Override // com.google.common.hash.PrimitiveSink
    /* bridge */ /* synthetic */ PrimitiveSink putBoolean(boolean z10);

    @Override // com.google.common.hash.PrimitiveSink
    Hasher putByte(byte b10);

    @Override // com.google.common.hash.PrimitiveSink
    /* bridge */ /* synthetic */ PrimitiveSink putByte(byte b10);

    @Override // com.google.common.hash.PrimitiveSink
    Hasher putBytes(ByteBuffer byteBuffer);

    @Override // com.google.common.hash.PrimitiveSink
    Hasher putBytes(byte[] bArr);

    @Override // com.google.common.hash.PrimitiveSink
    Hasher putBytes(byte[] bArr, int i10, int i11);

    @Override // com.google.common.hash.PrimitiveSink
    /* bridge */ /* synthetic */ PrimitiveSink putBytes(ByteBuffer byteBuffer);

    @Override // com.google.common.hash.PrimitiveSink
    /* bridge */ /* synthetic */ PrimitiveSink putBytes(byte[] bArr);

    @Override // com.google.common.hash.PrimitiveSink
    /* bridge */ /* synthetic */ PrimitiveSink putBytes(byte[] bArr, int i10, int i11);

    @Override // com.google.common.hash.PrimitiveSink
    Hasher putChar(char c10);

    @Override // com.google.common.hash.PrimitiveSink
    /* bridge */ /* synthetic */ PrimitiveSink putChar(char c10);

    @Override // com.google.common.hash.PrimitiveSink
    Hasher putDouble(double d10);

    @Override // com.google.common.hash.PrimitiveSink
    /* bridge */ /* synthetic */ PrimitiveSink putDouble(double d10);

    @Override // com.google.common.hash.PrimitiveSink
    Hasher putFloat(float f10);

    @Override // com.google.common.hash.PrimitiveSink
    /* bridge */ /* synthetic */ PrimitiveSink putFloat(float f10);

    @Override // com.google.common.hash.PrimitiveSink
    Hasher putInt(int i10);

    @Override // com.google.common.hash.PrimitiveSink
    /* bridge */ /* synthetic */ PrimitiveSink putInt(int i10);

    @Override // com.google.common.hash.PrimitiveSink
    Hasher putLong(long j10);

    @Override // com.google.common.hash.PrimitiveSink
    /* bridge */ /* synthetic */ PrimitiveSink putLong(long j10);

    <T> Hasher putObject(@ParametricNullness T t10, Funnel<? super T> funnel);

    @Override // com.google.common.hash.PrimitiveSink
    Hasher putShort(short s10);

    @Override // com.google.common.hash.PrimitiveSink
    /* bridge */ /* synthetic */ PrimitiveSink putShort(short s10);

    @Override // com.google.common.hash.PrimitiveSink
    Hasher putString(CharSequence charSequence, Charset charset);

    @Override // com.google.common.hash.PrimitiveSink
    /* bridge */ /* synthetic */ PrimitiveSink putString(CharSequence charSequence, Charset charset);

    @Override // com.google.common.hash.PrimitiveSink
    Hasher putUnencodedChars(CharSequence charSequence);

    @Override // com.google.common.hash.PrimitiveSink
    /* bridge */ /* synthetic */ PrimitiveSink putUnencodedChars(CharSequence charSequence);
}
