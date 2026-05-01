package io.jsonwebtoken.security;

import io.jsonwebtoken.Identifiable;

/* loaded from: classes3.dex */
public interface KeyOperation extends Identifiable {
    String getDescription();

    boolean isRelated(KeyOperation keyOperation);
}
