package io.jsonwebtoken.security;

import java.io.InputStream;
import javax.crypto.SecretKey;

/* loaded from: classes3.dex */
public interface AeadRequest extends SecureRequest<InputStream, SecretKey>, AssociatedDataSupplier {
}
