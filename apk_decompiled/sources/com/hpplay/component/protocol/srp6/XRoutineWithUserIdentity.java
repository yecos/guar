package com.hpplay.component.protocol.srp6;

import java.math.BigInteger;
import java.security.MessageDigest;

/* loaded from: classes2.dex */
public class XRoutineWithUserIdentity implements XRoutine {
    @Override // com.hpplay.component.protocol.srp6.XRoutine
    public BigInteger computeX(MessageDigest messageDigest, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        messageDigest.update(bArr2);
        messageDigest.update((byte) 58);
        messageDigest.update(bArr3);
        byte[] digest = messageDigest.digest();
        messageDigest.update(bArr);
        return BigIntegerUtils.bigIntegerFromBytes(messageDigest.digest(digest));
    }

    public String toString() {
        return "H(s | H(I | \":\" | P))";
    }
}
