package io.jsonwebtoken.impl;

import io.jsonwebtoken.Header;
import java.util.Map;

/* loaded from: classes3.dex */
public interface TokenizedJwt {
    Header createHeader(Map<String, ?> map);

    CharSequence getDigest();

    CharSequence getPayload();

    CharSequence getProtected();
}
