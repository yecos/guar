package com.google.firebase.encoders;

/* loaded from: classes2.dex */
public interface ValueEncoderContext {
    ValueEncoderContext add(double d10);

    ValueEncoderContext add(float f10);

    ValueEncoderContext add(int i10);

    ValueEncoderContext add(long j10);

    ValueEncoderContext add(String str);

    ValueEncoderContext add(boolean z10);

    ValueEncoderContext add(byte[] bArr);
}
