package com.hpplay.component.protocol.srp6;

import com.hpplay.component.protocol.srp6.SRP6Exception;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.security.MessageDigest;

/* loaded from: classes2.dex */
public class SRP6ClientSession extends SRP6Session {
    private static final long serialVersionUID = -479060216624675478L;

    /* renamed from: a, reason: collision with root package name */
    private BigInteger f7363a;
    private String password;
    private State state;

    /* renamed from: x, reason: collision with root package name */
    private BigInteger f7364x;
    private XRoutine xRoutine;

    public enum State {
        INIT,
        STEP_1,
        STEP_2,
        STEP_3
    }

    public SRP6ClientSession(int i10) {
        super(i10);
        this.f7364x = null;
        this.f7363a = null;
        this.xRoutine = null;
        this.state = State.INIT;
        updateLastActivityTime();
    }

    public State getState() {
        return this.state;
    }

    public XRoutine getXRoutine() {
        return this.xRoutine;
    }

    public void setXRoutine(XRoutine xRoutine) {
        this.xRoutine = xRoutine;
    }

    public void step1(String str, String str2) {
        if (str == null || str.trim().isEmpty()) {
            throw new IllegalArgumentException("The user identity 'I' must not be null or empty");
        }
        this.userID = str;
        if (str2 == null) {
            throw new IllegalArgumentException("The user password 'P' must not be null");
        }
        this.password = str2;
        if (this.state != State.INIT) {
            throw new IllegalStateException("State violation: Session must be in INIT state");
        }
        this.state = State.STEP_1;
        updateLastActivityTime();
    }

    public SRP6ClientCredentials step2(SRP6CryptoParams sRP6CryptoParams, BigInteger bigInteger, BigInteger bigInteger2) {
        if (sRP6CryptoParams == null) {
            throw new IllegalArgumentException("The SRP-6a crypto parameters must not be null");
        }
        this.config = sRP6CryptoParams;
        MessageDigest messageDigestInstance = sRP6CryptoParams.getMessageDigestInstance();
        if (messageDigestInstance == null) {
            throw new IllegalArgumentException("Unsupported hash algorithm 'H': " + sRP6CryptoParams.H);
        }
        if (bigInteger == null) {
            throw new IllegalArgumentException("The salt 's' must not be null");
        }
        this.f7369s = bigInteger;
        if (bigInteger2 == null) {
            throw new IllegalArgumentException("The public server value 'B' must not be null");
        }
        this.B = bigInteger2;
        if (this.state != State.STEP_1) {
            throw new IllegalStateException("State violation: Session must be in STEP_1 state");
        }
        if (hasTimedOut()) {
            throw new SRP6Exception("Session timeout", SRP6Exception.CauseType.TIMEOUT);
        }
        if (!this.srp6Routines.isValidPublicValue(sRP6CryptoParams.N, bigInteger2)) {
            throw new SRP6Exception("Bad server public value 'B'", SRP6Exception.CauseType.BAD_PUBLIC_VALUE);
        }
        XRoutine xRoutine = this.xRoutine;
        if (xRoutine != null) {
            this.f7364x = xRoutine.computeX(sRP6CryptoParams.getMessageDigestInstance(), BigIntegerUtils.bigIntegerToBytes(bigInteger), this.userID.getBytes(Charset.forName("UTF-8")), this.password.getBytes(Charset.forName("UTF-8")));
        } else {
            this.f7364x = this.srp6Routines.computeX(messageDigestInstance, BigIntegerUtils.bigIntegerToBytes(bigInteger), this.password.getBytes(Charset.forName("UTF-8")));
            messageDigestInstance.reset();
        }
        this.f7363a = this.srp6Routines.generatePrivateValue(sRP6CryptoParams.N, this.random);
        messageDigestInstance.reset();
        this.A = this.srp6Routines.computePublicClientValue(sRP6CryptoParams.N, sRP6CryptoParams.f7365g, this.f7363a);
        this.f7368k = this.srp6Routines.computeK(messageDigestInstance, sRP6CryptoParams.N, sRP6CryptoParams.f7365g);
        messageDigestInstance.reset();
        if (this.hashedKeysRoutine != null) {
            this.f7370u = this.hashedKeysRoutine.computeU(sRP6CryptoParams, new URoutineContext(this.A, bigInteger2));
        } else {
            this.f7370u = this.srp6Routines.computeU(messageDigestInstance, sRP6CryptoParams.N, this.A, bigInteger2);
            messageDigestInstance.reset();
        }
        BigInteger computeSessionKey = this.srp6Routines.computeSessionKey(sRP6CryptoParams.N, sRP6CryptoParams.f7365g, this.f7368k, this.f7364x, this.f7370u, this.f7363a, bigInteger2);
        this.S = computeSessionKey;
        if (this.clientEvidenceRoutine != null) {
            this.M1 = this.clientEvidenceRoutine.computeClientEvidence(sRP6CryptoParams, new SRP6ClientEvidenceContext(this.userID, bigInteger, this.A, bigInteger2, computeSessionKey));
        } else {
            this.M1 = this.srp6Routines.computeClientEvidence(messageDigestInstance, this.A, bigInteger2, computeSessionKey);
            messageDigestInstance.reset();
        }
        this.state = State.STEP_2;
        updateLastActivityTime();
        return new SRP6ClientCredentials(this.A, this.M1);
    }

    public void step3(BigInteger bigInteger) {
        BigInteger computeServerEvidence;
        if (bigInteger == null) {
            throw new IllegalArgumentException("The server evidence message 'M2' must not be null");
        }
        this.M2 = bigInteger;
        if (this.state != State.STEP_2) {
            throw new IllegalStateException("State violation: Session must be in STEP_2 state");
        }
        if (hasTimedOut()) {
            throw new SRP6Exception("Session timeout", SRP6Exception.CauseType.TIMEOUT);
        }
        if (this.serverEvidenceRoutine != null) {
            computeServerEvidence = this.serverEvidenceRoutine.computeServerEvidence(this.config, new SRP6ServerEvidenceContext(this.A, this.M1, this.S));
        } else {
            computeServerEvidence = this.srp6Routines.computeServerEvidence(this.config.getMessageDigestInstance(), this.A, this.M1, this.S);
        }
        if (!computeServerEvidence.equals(bigInteger)) {
            throw new SRP6Exception("Bad server credentials", SRP6Exception.CauseType.BAD_CREDENTIALS);
        }
        this.state = State.STEP_3;
        updateLastActivityTime();
    }

    public SRP6ClientSession() {
        this(0);
    }
}
