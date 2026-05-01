package com.hpplay.component.protocol.srp6;

import java.math.BigInteger;

/* loaded from: classes2.dex */
public interface ServerEvidenceRoutine {
    BigInteger computeServerEvidence(SRP6CryptoParams sRP6CryptoParams, SRP6ServerEvidenceContext sRP6ServerEvidenceContext);
}
