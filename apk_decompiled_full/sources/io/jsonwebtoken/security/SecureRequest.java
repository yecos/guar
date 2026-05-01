package io.jsonwebtoken.security;

import java.security.Key;

/* loaded from: classes3.dex */
public interface SecureRequest<T, K extends Key> extends Request<T>, KeySupplier<K> {
}
