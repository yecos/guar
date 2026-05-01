package com.hpplay.component.protocol.srp6;

import java.math.BigInteger;

/* loaded from: classes2.dex */
public final class SRP6ClientCredentials {
    public final BigInteger A;
    public final BigInteger M1;

    public SRP6ClientCredentials(BigInteger bigInteger, BigInteger bigInteger2) {
        if (bigInteger == null) {
            throw new IllegalArgumentException("The public client value 'A' must not be null");
        }
        this.A = bigInteger;
        if (bigInteger2 == null) {
            throw new IllegalArgumentException("The client evidence message 'M1' must not be null");
        }
        this.M1 = bigInteger2;
    }
}
