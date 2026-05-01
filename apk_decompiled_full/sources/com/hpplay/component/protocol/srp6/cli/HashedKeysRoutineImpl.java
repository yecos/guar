package com.hpplay.component.protocol.srp6.cli;

import com.hpplay.component.protocol.srp6.BigIntegerUtils;
import com.hpplay.component.protocol.srp6.SRP6CryptoParams;
import com.hpplay.component.protocol.srp6.URoutine;
import com.hpplay.component.protocol.srp6.URoutineContext;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: classes2.dex */
class HashedKeysRoutineImpl implements URoutine {
    @Override // com.hpplay.component.protocol.srp6.URoutine
    public BigInteger computeU(SRP6CryptoParams sRP6CryptoParams, URoutineContext uRoutineContext) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(sRP6CryptoParams.H);
            messageDigest.update(BigIntegerUtils.bigIntegerToBytes(uRoutineContext.A));
            messageDigest.update(BigIntegerUtils.bigIntegerToBytes(uRoutineContext.B));
            return BigIntegerUtils.bigIntegerFromBytes(messageDigest.digest());
        } catch (NoSuchAlgorithmException e10) {
            throw new RuntimeException("Could not locate requested algorithm", e10);
        }
    }
}
