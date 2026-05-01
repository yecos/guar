package io.jsonwebtoken.security;

import io.jsonwebtoken.security.KeyBuilder;
import java.security.Key;

/* loaded from: classes3.dex */
public interface KeyBuilderSupplier<K extends Key, B extends KeyBuilder<K, B>> {
    B key();
}
