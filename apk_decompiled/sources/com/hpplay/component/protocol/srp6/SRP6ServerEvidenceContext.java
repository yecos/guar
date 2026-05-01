package com.hpplay.component.protocol.srp6;

import java.math.BigInteger;

/* loaded from: classes2.dex */
public class SRP6ServerEvidenceContext {
    public final BigInteger A;
    public final BigInteger M1;
    public final BigInteger S;

    public SRP6ServerEvidenceContext(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
        this.A = bigInteger;
        this.M1 = bigInteger2;
        this.S = bigInteger3;
    }
}
