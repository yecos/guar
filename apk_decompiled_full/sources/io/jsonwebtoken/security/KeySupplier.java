package io.jsonwebtoken.security;

import java.security.Key;

/* loaded from: classes3.dex */
public interface KeySupplier<K extends Key> {
    K getKey();
}
