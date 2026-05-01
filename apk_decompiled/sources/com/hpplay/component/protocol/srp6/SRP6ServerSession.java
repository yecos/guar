package com.hpplay.component.protocol.srp6;

import com.hpplay.component.protocol.srp6.SRP6Exception;
import java.math.BigInteger;
import java.security.MessageDigest;

/* loaded from: classes2.dex */
public class SRP6ServerSession extends SRP6Session {
    private static final long serialVersionUID = -4076520488632450473L;

    /* renamed from: b, reason: collision with root package name */
    private BigInteger f7366b;
    private boolean noSuchUserIdentity;
    private State state;

    /* renamed from: v, reason: collision with root package name */
    private BigInteger f7367v;

    public enum State {
        INIT,
        STEP_1,
        STEP_2
    }

    public SRP6ServerSession(SRP6CryptoParams sRP6CryptoParams, int i10) {
        super(i10);
        this.noSuchUserIdentity = false;
        this.f7367v = null;
        this.f7366b = null;
        if (sRP6CryptoParams == null) {
            throw new IllegalArgumentException("The SRP-6a crypto parameters must not be null");
        }
        this.config = sRP6CryptoParams;
        if (sRP6CryptoParams.getMessageDigestInstance() != null) {
            this.state = State.INIT;
            updateLastActivityTime();
        } else {
            throw new IllegalArgumentException("Unsupported hash algorithm 'H': " + sRP6CryptoParams.H);
        }
    }

    public State getState() {
        return this.state;
    }

    public BigInteger mockStep1(String str, BigInteger bigInteger, BigInteger bigInteger2) {
        this.noSuchUserIdentity = true;
        return step1(str, bigInteger, bigInteger2);
    }

    public BigInteger step1(String str, BigInteger bigInteger, BigInteger bigInteger2) {
        if (str == null || str.trim().isEmpty()) {
            throw new IllegalArgumentException("The user identity 'I' must not be null or empty");
        }
        this.userID = str;
        if (bigInteger == null) {
            throw new IllegalArgumentException("The salt 's' must not be null");
        }
        this.f7369s = bigInteger;
        if (bigInteger2 == null) {
            throw new IllegalArgumentException("The verifier 'v' must not be null");
        }
        this.f7367v = bigInteger2;
        if (this.state != State.INIT) {
            throw new IllegalStateException("State violation: Session must be in INIT state");
        }
        MessageDigest messageDigestInstance = this.config.getMessageDigestInstance();
        SRP6Routines sRP6Routines = this.srp6Routines;
        SRP6CryptoParams sRP6CryptoParams = this.config;
        this.f7368k = sRP6Routines.computeK(messageDigestInstance, sRP6CryptoParams.N, sRP6CryptoParams.f7365g);
        messageDigestInstance.reset();
        this.f7366b = this.srp6Routines.generatePrivateValue(this.config.N, this.random);
        messageDigestInstance.reset();
        SRP6Routines sRP6Routines2 = this.srp6Routines;
        SRP6CryptoParams sRP6CryptoParams2 = this.config;
        this.B = sRP6Routines2.computePublicServerValue(sRP6CryptoParams2.N, sRP6CryptoParams2.f7365g, this.f7368k, bigInteger2, this.f7366b);
        this.state = State.STEP_1;
        updateLastActivityTime();
        return this.B;
    }

    public BigInteger step2(BigInteger bigInteger, BigInteger bigInteger2) {
        BigInteger computeClientEvidence;
        if (bigInteger == null) {
            throw new IllegalArgumentException("The client public value 'A' must not be null");
        }
        this.A = bigInteger;
        if (bigInteger2 == null) {
            throw new IllegalArgumentException("The client evidence message 'M1' must not be null");
        }
        this.M1 = bigInteger2;
        if (this.state != State.STEP_1) {
            throw new IllegalStateException("State violation: Session must be in STEP_1 state");
        }
        if (hasTimedOut()) {
            throw new SRP6Exception("Session timeout", SRP6Exception.CauseType.TIMEOUT);
        }
        if (!this.srp6Routines.isValidPublicValue(this.config.N, bigInteger)) {
            throw new SRP6Exception("Bad client public value 'A'", SRP6Exception.CauseType.BAD_PUBLIC_VALUE);
        }
        MessageDigest messageDigestInstance = this.config.getMessageDigestInstance();
        if (this.hashedKeysRoutine != null) {
            this.f7370u = this.hashedKeysRoutine.computeU(this.config, new URoutineContext(bigInteger, this.B));
        } else {
            this.f7370u = this.srp6Routines.computeU(messageDigestInstance, this.config.N, bigInteger, this.B);
            messageDigestInstance.reset();
        }
        BigInteger computeSessionKey = this.srp6Routines.computeSessionKey(this.config.N, this.f7367v, this.f7370u, bigInteger, this.f7366b);
        this.S = computeSessionKey;
        if (this.clientEvidenceRoutine != null) {
            computeClientEvidence = this.clientEvidenceRoutine.computeClientEvidence(this.config, new SRP6ClientEvidenceContext(this.userID, this.f7369s, bigInteger, this.B, computeSessionKey));
        } else {
            computeClientEvidence = this.srp6Routines.computeClientEvidence(messageDigestInstance, bigInteger, this.B, computeSessionKey);
            messageDigestInstance.reset();
        }
        if (this.noSuchUserIdentity || !computeClientEvidence.equals(bigInteger2)) {
            throw new SRP6Exception("Bad client credentials", SRP6Exception.CauseType.BAD_CREDENTIALS);
        }
        this.state = State.STEP_2;
        if (this.serverEvidenceRoutine != null) {
            this.M2 = this.serverEvidenceRoutine.computeServerEvidence(this.config, new SRP6ServerEvidenceContext(bigInteger, bigInteger2, this.S));
        } else {
            this.M2 = this.srp6Routines.computeServerEvidence(messageDigestInstance, bigInteger, bigInteger2, this.S);
            messageDigestInstance.reset();
        }
        updateLastActivityTime();
        return this.M2;
    }

    public SRP6ServerSession(SRP6CryptoParams sRP6CryptoParams) {
        this(sRP6CryptoParams, 0);
    }
}
