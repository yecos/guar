package com.hpplay.component.protocol.srp6;

import java.math.BigInteger;

/* loaded from: classes2.dex */
public class SRP6ClientEvidenceContext {
    public final BigInteger A;
    public final BigInteger B;
    public final BigInteger S;

    /* renamed from: s, reason: collision with root package name */
    public final BigInteger f7362s;
    public final String userID;

    public SRP6ClientEvidenceContext(String str, BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4) {
        this.userID = str;
        this.f7362s = bigInteger;
        this.A = bigInteger2;
        this.B = bigInteger3;
        this.S = bigInteger4;
    }
}
