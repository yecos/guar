package com.hpplay.component.protocol.srp6;

/* loaded from: classes2.dex */
public class SRP6Exception extends Exception {
    private static final long serialVersionUID = 4640494990301260666L;
    private CauseType cause;

    public enum CauseType {
        BAD_PUBLIC_VALUE,
        BAD_CREDENTIALS,
        TIMEOUT
    }

    public SRP6Exception(String str, CauseType causeType) {
        super(str);
        if (causeType == null) {
            throw new IllegalArgumentException("The cause type must not be null");
        }
        this.cause = causeType;
    }

    public CauseType getCauseType() {
        return this.cause;
    }
}
