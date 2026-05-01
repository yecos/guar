package com.hpplay.component.protocol.srp6.cli;

import com.hpplay.component.common.utils.CLog;
import com.hpplay.component.protocol.srp6.BigIntegerUtils;
import com.hpplay.component.protocol.srp6.SRP6ClientSession;
import com.hpplay.component.protocol.srp6.XRoutineWithUserIdentity;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.MessageDigest;

/* loaded from: classes2.dex */
public class ClientSessionImpl extends SRP6ClientSession {
    private final String TAG = "ClientSessionImpl";

    public ClientSessionImpl() {
        setClientEvidenceRoutine(new ClientEvidenceRoutineImpl(this));
        setServerEvidenceRoutine(new ServerEvidenceRoutineImpl(this));
        setXRoutine(new XRoutineWithUserIdentity());
        setHashedKeysRoutine(new HashedKeysRoutineImpl());
    }

    @Override // com.hpplay.component.protocol.srp6.SRP6Session
    public byte[] getSessionKeyHash() {
        if (this.S == null) {
            return null;
        }
        MessageDigest messageDigestInstance = this.config.getMessageDigestInstance();
        if (messageDigestInstance == null) {
            throw new IllegalArgumentException("Unsupported hash algorithm 'H': " + this.config.H);
        }
        messageDigestInstance.update(BigIntegerUtils.bigIntegerToBytes(this.S));
        messageDigestInstance.update(new byte[]{0, 0, 0, 0});
        byte[] digest = messageDigestInstance.digest();
        messageDigestInstance.update(BigIntegerUtils.bigIntegerToBytes(this.S));
        messageDigestInstance.update(new byte[]{0, 0, 0, 1});
        byte[] digest2 = messageDigestInstance.digest();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(digest);
            byteArrayOutputStream.write(digest2);
        } catch (IOException e10) {
            CLog.w("ClientSessionImpl", e10);
        }
        return byteArrayOutputStream.toByteArray();
    }
}
