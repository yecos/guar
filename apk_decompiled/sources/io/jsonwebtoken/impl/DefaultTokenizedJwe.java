package io.jsonwebtoken.impl;

import io.jsonwebtoken.Header;
import java.util.Map;

/* loaded from: classes3.dex */
class DefaultTokenizedJwe extends DefaultTokenizedJwt implements TokenizedJwe {
    private final CharSequence encryptedKey;
    private final CharSequence iv;

    public DefaultTokenizedJwe(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4, CharSequence charSequence5) {
        super(charSequence, charSequence2, charSequence3);
        this.encryptedKey = charSequence4;
        this.iv = charSequence5;
    }

    @Override // io.jsonwebtoken.impl.DefaultTokenizedJwt, io.jsonwebtoken.impl.TokenizedJwt
    public Header createHeader(Map<String, ?> map) {
        return new DefaultJweHeader(map);
    }

    @Override // io.jsonwebtoken.impl.TokenizedJwe
    public CharSequence getEncryptedKey() {
        return this.encryptedKey;
    }

    @Override // io.jsonwebtoken.impl.TokenizedJwe
    public CharSequence getIv() {
        return this.iv;
    }
}
