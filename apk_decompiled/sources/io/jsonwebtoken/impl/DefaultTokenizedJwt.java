package io.jsonwebtoken.impl;

import io.jsonwebtoken.Header;
import io.jsonwebtoken.lang.Strings;
import java.util.Map;

/* loaded from: classes3.dex */
class DefaultTokenizedJwt implements TokenizedJwt {
    private final CharSequence digest;
    private final CharSequence payload;
    private final CharSequence protectedHeader;

    public DefaultTokenizedJwt(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3) {
        this.protectedHeader = charSequence;
        this.payload = charSequence2;
        this.digest = charSequence3;
    }

    @Override // io.jsonwebtoken.impl.TokenizedJwt
    public Header createHeader(Map<String, ?> map) {
        return Strings.hasText(getDigest()) ? new DefaultJwsHeader(map) : new DefaultHeader(map);
    }

    @Override // io.jsonwebtoken.impl.TokenizedJwt
    public CharSequence getDigest() {
        return this.digest;
    }

    @Override // io.jsonwebtoken.impl.TokenizedJwt
    public CharSequence getPayload() {
        return this.payload;
    }

    @Override // io.jsonwebtoken.impl.TokenizedJwt
    public CharSequence getProtected() {
        return this.protectedHeader;
    }
}
