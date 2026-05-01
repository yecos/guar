package io.jsonwebtoken.security;

import io.jsonwebtoken.io.ParserBuilder;

/* loaded from: classes3.dex */
public interface JwkSetParserBuilder extends ParserBuilder<JwkSet, JwkSetParserBuilder>, KeyOperationPolicied<JwkSetParserBuilder> {
    JwkSetParserBuilder ignoreUnsupported(boolean z10);
}
