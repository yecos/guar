package com.hpplay.component.protocol.encrypt;

import com.hpplay.component.common.utils.CLog;

/* loaded from: classes2.dex */
public class MirrorFrameEcrypto {
    public static final String TAG = "MirrorFrameEcrypto";
    private byte[] iv;
    private byte[] key;
    private ED25519Encrypt mEd25519Encrypt = new ED25519Encrypt();

    public MirrorFrameEcrypto(byte[] bArr, byte[] bArr2) {
        this.key = bArr;
        this.iv = bArr2;
    }

    public void frameEncrypt(byte[] bArr, int i10, int i11, byte[] bArr2, int i12) {
        try {
            this.mEd25519Encrypt.aecrypt(this.key, this.iv, bArr, i10, i11, bArr2, i12, true);
        } catch (Exception e10) {
            CLog.w(TAG, e10);
        }
    }
}
