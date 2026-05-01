package io.jsonwebtoken.security;

import io.jsonwebtoken.lang.Builder;

/* loaded from: classes3.dex */
public interface KeyOperationBuilder extends Builder<KeyOperation> {
    KeyOperationBuilder description(String str);

    KeyOperationBuilder id(String str);

    KeyOperationBuilder related(String str);
}
