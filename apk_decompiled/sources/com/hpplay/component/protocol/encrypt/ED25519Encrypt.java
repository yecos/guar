package com.hpplay.component.protocol.encrypt;

/* loaded from: classes2.dex */
public class ED25519Encrypt {
    static {
        try {
            System.loadLibrary("ed25519");
        } catch (Exception unused) {
        }
    }

    public native boolean aecrypt(byte[] bArr, byte[] bArr2, byte[] bArr3, int i10, int i11, byte[] bArr4, int i12, boolean z10);

    public native void mdDoFinal(byte[] bArr);

    public native void mdInit();

    public native void mdUpdate(byte[] bArr, int i10);

    public native boolean publicKeyGen(byte[] bArr, byte[] bArr2, byte[] bArr3);

    public native boolean sign(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4);

    public native void strcrypt(byte[] bArr, int i10, byte[] bArr2);

    public native boolean verify(byte[] bArr, byte[] bArr2, byte[] bArr3);
}
