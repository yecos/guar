package io.jsonwebtoken.impl.security;

import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.security.DecryptAeadRequest;
import java.io.InputStream;
import javax.crypto.SecretKey;

/* loaded from: classes3.dex */
public class DefaultDecryptAeadRequest extends DefaultAeadRequest implements DecryptAeadRequest {
    private final byte[] TAG;

    public DefaultDecryptAeadRequest(InputStream inputStream, SecretKey secretKey, InputStream inputStream2, byte[] bArr, byte[] bArr2) {
        super(inputStream, null, null, secretKey, inputStream2, Assert.notEmpty(bArr, "Initialization Vector cannot be null or empty."));
        this.TAG = Assert.notEmpty(bArr2, "AAD Authentication Tag cannot be null or empty.");
    }

    @Override // io.jsonwebtoken.security.DigestSupplier
    public byte[] getDigest() {
        return this.TAG;
    }
}
