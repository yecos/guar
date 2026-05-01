package io.jsonwebtoken.security;

import javax.crypto.SecretKey;
import javax.security.auth.Destroyable;

/* loaded from: classes3.dex */
public interface Password extends SecretKey, Destroyable {
    char[] toCharArray();
}
