package com.hpplay.component.protocol.srp6;

import java.math.BigInteger;
import java.security.MessageDigest;

/* loaded from: classes2.dex */
public interface XRoutine {
    BigInteger computeX(MessageDigest messageDigest, byte[] bArr, byte[] bArr2, byte[] bArr3);
}
