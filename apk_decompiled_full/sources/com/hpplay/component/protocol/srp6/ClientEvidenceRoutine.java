package com.hpplay.component.protocol.srp6;

import java.math.BigInteger;

/* loaded from: classes2.dex */
public interface ClientEvidenceRoutine {
    BigInteger computeClientEvidence(SRP6CryptoParams sRP6CryptoParams, SRP6ClientEvidenceContext sRP6ClientEvidenceContext);
}
