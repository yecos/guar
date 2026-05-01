package com.hpplay.component.protocol.srp6.cli;

import com.hpplay.component.protocol.srp6.BigIntegerUtils;
import com.hpplay.component.protocol.srp6.SRP6ClientSession;
import com.hpplay.component.protocol.srp6.SRP6CryptoParams;
import com.hpplay.component.protocol.srp6.SRP6ServerEvidenceContext;
import com.hpplay.component.protocol.srp6.ServerEvidenceRoutine;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: classes2.dex */
class ServerEvidenceRoutineImpl implements ServerEvidenceRoutine {
    private final SRP6ClientSession srp6ClientSession;

    public ServerEvidenceRoutineImpl(SRP6ClientSession sRP6ClientSession) {
        this.srp6ClientSession = sRP6ClientSession;
    }

    @Override // com.hpplay.component.protocol.srp6.ServerEvidenceRoutine
    public BigInteger computeServerEvidence(SRP6CryptoParams sRP6CryptoParams, SRP6ServerEvidenceContext sRP6ServerEvidenceContext) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(sRP6CryptoParams.H);
            messageDigest.update(BigIntegerUtils.bigIntegerToBytes(sRP6ServerEvidenceContext.A));
            messageDigest.update(BigIntegerUtils.bigIntegerToBytes(sRP6ServerEvidenceContext.M1));
            messageDigest.update(this.srp6ClientSession.getSessionKeyHash());
            return new BigInteger(1, messageDigest.digest());
        } catch (NoSuchAlgorithmException e10) {
            throw new RuntimeException("Could not locate requested algorithm", e10);
        }
    }
}
