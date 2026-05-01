package io.jsonwebtoken.impl;

/* loaded from: classes3.dex */
public interface TokenizedJwe extends TokenizedJwt {
    CharSequence getEncryptedKey();

    CharSequence getIv();
}
