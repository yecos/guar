package io.jsonwebtoken.impl;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ClaimsBuilder;
import io.jsonwebtoken.Clock;
import io.jsonwebtoken.CompressionCodecResolver;
import io.jsonwebtoken.Header;
import io.jsonwebtoken.IncorrectClaimException;
import io.jsonwebtoken.Jwe;
import io.jsonwebtoken.JweHeader;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwsHeader;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.JwtHandler;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.Locator;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.MissingClaimException;
import io.jsonwebtoken.SigningKeyResolver;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.impl.io.AbstractParser;
import io.jsonwebtoken.impl.io.BytesInputStream;
import io.jsonwebtoken.impl.io.CharSequenceReader;
import io.jsonwebtoken.impl.io.JsonObjectDeserializer;
import io.jsonwebtoken.impl.io.Streams;
import io.jsonwebtoken.impl.io.UncloseableInputStream;
import io.jsonwebtoken.impl.lang.Function;
import io.jsonwebtoken.impl.lang.Parameter;
import io.jsonwebtoken.impl.lang.RedactedSupplier;
import io.jsonwebtoken.impl.security.DefaultVerifySecureDigestRequest;
import io.jsonwebtoken.impl.security.ProviderKey;
import io.jsonwebtoken.io.CompressionAlgorithm;
import io.jsonwebtoken.io.Decoder;
import io.jsonwebtoken.io.Deserializer;
import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.lang.Collections;
import io.jsonwebtoken.lang.Objects;
import io.jsonwebtoken.lang.Registry;
import io.jsonwebtoken.lang.Strings;
import io.jsonwebtoken.security.AeadAlgorithm;
import io.jsonwebtoken.security.InvalidKeyException;
import io.jsonwebtoken.security.KeyAlgorithm;
import io.jsonwebtoken.security.SecureDigestAlgorithm;
import io.jsonwebtoken.security.SignatureException;
import io.jsonwebtoken.security.WeakKeyException;
import java.io.InputStream;
import java.io.Reader;
import java.io.SequenceInputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.security.PrivateKey;
import java.security.Provider;
import java.util.Collection;
import java.util.Date;
import java.util.Map;
import java.util.Set;

/* loaded from: classes3.dex */
public class DefaultJwtParser extends AbstractParser<Jwt<?, ?>> implements JwtParser {
    private static final String B64_DECOMPRESSION_MSG;
    private static final String B64_MISSING_PAYLOAD = "Unable to verify JWS signature: the parser has encountered an Unencoded Payload JWS with detached payload, but the detached payload value required for signature verification has not been provided. If you expect to receive and parse Unencoded Payload JWSs in your application, the overloaded JwtParser.parseSignedContent or JwtParser.parseSignedClaims methods that accept a byte[] or InputStream must be used for these kinds of JWSs. Header: %s";
    private static final String CRIT_MISSING_MSG;
    private static final String CRIT_UNSECURED_MSG;
    private static final String CRIT_UNSUPPORTED_MSG;
    public static final String INCORRECT_EXPECTED_CLAIM_MESSAGE_TEMPLATE = "Expected %s claim to be: %s, but was: %s.";
    private static final String JWE_NONE_MSG;
    private static final String JWS_NONE_SIG_MISMATCH_MSG;
    private static final String MISSING_ENC_MSG = "JWE header does not contain a required 'enc' (Encryption Algorithm) header parameter.  This header parameter is mandatory per the JWE Specification, Section 4.1.2. See https://www.rfc-editor.org/rfc/rfc7516.html#section-4.1.2 for more information.";
    public static final String MISSING_EXPECTED_CLAIM_VALUE_MESSAGE_TEMPLATE = "Missing expected '%s' value in '%s' claim %s.";
    public static final String MISSING_JWE_ALG_MSG = "JWE header does not contain a required 'alg' (Algorithm) header parameter.  This header parameter is mandatory per the JWE Specification, Section 4.1.1. See https://www.rfc-editor.org/rfc/rfc7516.html#section-4.1.1 for more information.";
    public static final String MISSING_JWE_DIGEST_MSG_FMT = "The JWE header references key management algorithm '%s' but the compact JWE string is missing the required AAD authentication tag.";
    public static final String MISSING_JWS_ALG_MSG = "JWS header does not contain a required 'alg' (Algorithm) header parameter.  This header parameter is mandatory per the JWS Specification, Section 4.1.1. See https://www.rfc-editor.org/rfc/rfc7515.html#section-4.1.1 for more information.";
    public static final String MISSING_JWS_DIGEST_MSG_FMT = "The JWS header references signature algorithm '%s' but the compact JWE string is missing the required signature.";
    static final String PRIV_KEY_VERIFY_MSG = "PrivateKeys may not be used to verify digital signatures. PrivateKeys are used to sign, and PublicKeys are used to verify.";
    static final String PUB_KEY_DECRYPT_MSG = "PublicKeys may not be used to decrypt data. PublicKeys are used to encrypt, and PrivateKeys are used to decrypt.";
    static final char SEPARATOR_CHAR = '.';
    private static final String UNPROTECTED_DECOMPRESSION_MSG;
    private static final String UNSECURED_DISABLED_MSG_PREFIX;
    private static final JwtTokenizer jwtTokenizer = new JwtTokenizer();
    private final long allowedClockSkewMillis;
    private final Clock clock;
    private final Set<String> critical;
    private final Decoder<InputStream, InputStream> decoder;
    private final Deserializer<Map<String, ?>> deserializer;
    private final Function<JweHeader, AeadAlgorithm> encAlgs;
    private final ClaimsBuilder expectedClaims;
    private final Function<JweHeader, KeyAlgorithm<?, ?>> keyAlgs;
    private final Locator<? extends Key> keyLocator;
    private final Provider provider;
    private final Function<JwsHeader, SecureDigestAlgorithm<?, ?>> sigAlgs;
    private final SigningKeyResolver signingKeyResolver;
    private final boolean unsecured;
    private final boolean unsecuredDecompression;
    private final Function<Header, CompressionAlgorithm> zipAlgs;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append("Unsecured JWSs (those with an ");
        Parameter<String> parameter = DefaultHeader.ALGORITHM;
        sb.append(parameter);
        sb.append(" header value of '");
        SecureDigestAlgorithm<Key, Key> secureDigestAlgorithm = Jwts.SIG.NONE;
        sb.append(secureDigestAlgorithm.getId());
        sb.append("') are disallowed by ");
        sb.append("default as mandated by https://www.rfc-editor.org/rfc/rfc7518.html#section-3.6. If you wish to ");
        sb.append("allow them to be parsed, call the JwtParserBuilder.unsecured() method, but please read the ");
        sb.append("security considerations covered in that method's JavaDoc before doing so. Header: ");
        UNSECURED_DISABLED_MSG_PREFIX = sb.toString();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Unsecured JWSs (those with an ");
        sb2.append(parameter);
        sb2.append(" header value of '");
        sb2.append(secureDigestAlgorithm.getId());
        sb2.append("') may not use the ");
        Parameter<Set<String>> parameter2 = DefaultProtectedHeader.CRIT;
        sb2.append(parameter2);
        sb2.append(" header parameter per https://www.rfc-editor.org/rfc/rfc7515.html#section-4.1.11 (\"the [crit] Header ");
        sb2.append("Parameter MUST be integrity protected; therefore, it MUST occur only within [a] JWS Protected Header)\".");
        sb2.append(" Header: %s");
        CRIT_UNSECURED_MSG = sb2.toString();
        CRIT_MISSING_MSG = "Protected Header " + parameter2 + " set references header name '%s', but the header does not contain an associated '%s' header parameter as required by https://www.rfc-editor.org/rfc/rfc7515.html#section-4.1.11. Header: %s";
        CRIT_UNSUPPORTED_MSG = "Protected Header " + parameter2 + " set references unsupported header name '%s'. Application developers expecting to support a JWT extension using header '%s' in their application code must indicate it is supported by using the JwtParserBuilder.critical method. Header: %s";
        JWE_NONE_MSG = "JWEs do not support key management " + parameter + " header value '" + secureDigestAlgorithm.getId() + "' per https://www.rfc-editor.org/rfc/rfc7518.html#section-4.1";
        StringBuilder sb3 = new StringBuilder();
        sb3.append("The JWS header references signature algorithm '");
        sb3.append(secureDigestAlgorithm.getId());
        sb3.append("' yet the compact JWS string contains a signature. This is not permitted ");
        sb3.append("per https://tools.ietf.org/html/rfc7518#section-3.6.");
        JWS_NONE_SIG_MISMATCH_MSG = sb3.toString();
        StringBuilder sb4 = new StringBuilder();
        sb4.append("The JWT header references compression algorithm '%s', but payload decompression for Unencoded JWSs (those with an ");
        Parameter<Boolean> parameter3 = DefaultJwsHeader.B64;
        sb4.append(parameter3);
        sb4.append(" header value of false) that rely on a SigningKeyResolver are disallowed ");
        sb4.append("by default to protect against [Denial of Service attacks](");
        sb4.append("https://www.usenix.org/system/files/conference/usenixsecurity15/sec15-paper-pellegrino.pdf).  If you ");
        sb4.append("wish to enable Unencoded JWS payload decompression, configure the JwtParserBuilder.");
        sb4.append("keyLocator(Locator) and do not configure a SigningKeyResolver.");
        B64_DECOMPRESSION_MSG = sb4.toString();
        UNPROTECTED_DECOMPRESSION_MSG = "The JWT header references compression algorithm '%s', but payload decompression for Unprotected JWTs (those with an " + parameter + " header value of '" + secureDigestAlgorithm.getId() + "') or Unencoded JWSs (those with a " + parameter3 + " header value of false) that also rely on a SigningKeyResolver are disallowed by default to protect against [Denial of Service attacks](https://www.usenix.org/system/files/conference/usenixsecurity15/sec15-paper-pellegrino.pdf).  If you wish to enable Unsecure JWS or Unencoded JWS payload decompression, call the JwtParserBuilder.unsecuredDecompression() method, but please read the security considerations covered in that method's JavaDoc before doing so.";
    }

    public DefaultJwtParser(Provider provider, SigningKeyResolver signingKeyResolver, boolean z10, boolean z11, Locator<? extends Key> locator, Clock clock, Set<String> set, long j10, DefaultClaims defaultClaims, Decoder<InputStream, InputStream> decoder, Deserializer<Map<String, ?>> deserializer, CompressionCodecResolver compressionCodecResolver, Registry<String, CompressionAlgorithm> registry, Registry<String, SecureDigestAlgorithm<?, ?>> registry2, Registry<String, KeyAlgorithm<?, ?>> registry3, Registry<String, AeadAlgorithm> registry4) {
        this.provider = provider;
        this.unsecured = z10;
        this.unsecuredDecompression = z11;
        this.signingKeyResolver = signingKeyResolver;
        this.keyLocator = (Locator) Assert.notNull(locator, "Key Locator cannot be null.");
        this.clock = (Clock) Assert.notNull(clock, "Clock cannot be null.");
        this.critical = Collections.nullSafe((Set) set);
        this.allowedClockSkewMillis = j10;
        this.expectedClaims = Jwts.claims().add(defaultClaims);
        this.decoder = (Decoder) Assert.notNull(decoder, "base64UrlDecoder cannot be null.");
        this.deserializer = (Deserializer) Assert.notNull(deserializer, "JSON Deserializer cannot be null.");
        Parameter<String> parameter = DefaultHeader.ALGORITHM;
        this.sigAlgs = new IdLocator(parameter, registry2, MISSING_JWS_ALG_MSG);
        this.keyAlgs = new IdLocator(parameter, registry3, MISSING_JWE_ALG_MSG);
        this.encAlgs = new IdLocator(DefaultJweHeader.ENCRYPTION_ALGORITHM, registry4, MISSING_ENC_MSG);
        this.zipAlgs = compressionCodecResolver != null ? new CompressionCodecLocator(compressionCodecResolver) : new IdLocator<>(DefaultHeader.COMPRESSION_ALGORITHM, registry, null);
    }

    private static boolean hasContentType(Header header) {
        return header != null && Strings.hasText(header.getContentType());
    }

    private static Object normalize(Object obj) {
        return obj instanceof Integer ? Long.valueOf(((Integer) obj).longValue()) : obj;
    }

    private static Payload payloadFor(InputStream inputStream) {
        return inputStream instanceof BytesInputStream ? new Payload(Streams.bytes(inputStream, "Unable to obtain payload InputStream bytes."), (String) null) : new Payload(inputStream, (String) null);
    }

    private void validateExpectedClaims(Header header, Claims claims) {
        Claims build = this.expectedClaims.build();
        for (String str : build.keySet()) {
            Object normalize = normalize(build.get(str));
            Object normalize2 = normalize(claims.get(str));
            if (normalize instanceof Date) {
                try {
                    normalize2 = claims.get(str, Date.class);
                } catch (Exception unused) {
                    throw new IncorrectClaimException(header, claims, str, normalize, "JWT Claim '" + str + "' was expected to be a Date, but its value cannot be converted to a Date using current heuristics.  Value: " + normalize2);
                }
            }
            if (normalize2 == null) {
                String str2 = "Missing '" + str + "' claim. Expected value";
                throw new MissingClaimException(header, claims, str, normalize, normalize instanceof Collection ? str2 + "s: " + normalize : str2 + ": " + normalize);
            }
            if (normalize instanceof Collection) {
                Collection collection = (Collection) normalize;
                Collection of = normalize2 instanceof Collection ? (Collection) normalize2 : Collections.setOf(normalize2);
                for (Object obj : collection) {
                    if (!Collections.contains(of.iterator(), obj)) {
                        throw new IncorrectClaimException(header, claims, str, normalize, String.format(MISSING_EXPECTED_CLAIM_VALUE_MESSAGE_TEMPLATE, obj, str, of));
                    }
                }
            } else if (!normalize.equals(normalize2)) {
                throw new IncorrectClaimException(header, claims, str, normalize, String.format("Expected %s claim to be: %s, but was: %s.", str, normalize, normalize2));
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v23, types: [java.io.InputStream] */
    private byte[] verifySignature(TokenizedJwt tokenizedJwt, JwsHeader jwsHeader, String str, SigningKeyResolver signingKeyResolver, Claims claims, Payload payload) {
        InputStream inputStream;
        SequenceInputStream sequenceInputStream;
        Assert.notNull(signingKeyResolver, "SigningKeyResolver instance cannot be null.");
        try {
            SecureDigestAlgorithm<?, ?> apply = this.sigAlgs.apply(jwsHeader);
            Assert.stateNotNull(apply, "JWS Signature Algorithm cannot be null.");
            Key resolveSigningKey = claims != null ? signingKeyResolver.resolveSigningKey(jwsHeader, claims) : signingKeyResolver.resolveSigningKey(jwsHeader, payload.getBytes());
            if (resolveSigningKey == null) {
                throw new UnsupportedJwtException("Cannot verify JWS signature: unable to locate signature verification key for JWS with header: " + jwsHeader);
            }
            Provider provider = ProviderKey.getProvider(resolveSigningKey, this.provider);
            Key key = ProviderKey.getKey(resolveSigningKey);
            Assert.stateNotNull(key, "ProviderKey cannot be null.");
            if (key instanceof PrivateKey) {
                throw new InvalidKeyException(PRIV_KEY_VERIFY_MSG);
            }
            byte[] decode = decode(tokenizedJwt.getDigest(), "JWS signature");
            if (jwsHeader.isPayloadEncoded()) {
                CharBuffer allocate = CharBuffer.allocate(tokenizedJwt.getProtected().length() + 1 + tokenizedJwt.getPayload().length());
                allocate.put(Strings.wrap(tokenizedJwt.getProtected()));
                allocate.put(SEPARATOR_CHAR);
                allocate.put(Strings.wrap(tokenizedJwt.getPayload()));
                allocate.rewind();
                ByteBuffer encode = StandardCharsets.US_ASCII.encode(allocate);
                encode.rewind();
                byte[] bArr = new byte[encode.remaining()];
                encode.get(bArr);
                ?? of = Streams.of(bArr);
                inputStream = null;
                sequenceInputStream = of;
            } else {
                ByteBuffer encode2 = StandardCharsets.US_ASCII.encode(Strings.wrap(tokenizedJwt.getProtected()));
                encode2.rewind();
                ByteBuffer allocate2 = ByteBuffer.allocate(encode2.remaining() + 1);
                allocate2.put(encode2);
                allocate2.put((byte) 46);
                allocate2.rewind();
                byte[] bArr2 = new byte[allocate2.remaining()];
                allocate2.get(bArr2);
                InputStream of2 = Streams.of(bArr2);
                inputStream = payload.toInputStream();
                sequenceInputStream = new SequenceInputStream(of2, new UncloseableInputStream(inputStream));
            }
            try {
                try {
                    if (apply.verify(new DefaultVerifySecureDigestRequest(sequenceInputStream, provider, null, key, decode))) {
                        return decode;
                    }
                    throw new SignatureException("JWT signature does not match locally computed signature. JWT validity cannot be asserted and should not be trusted.");
                } catch (WeakKeyException e10) {
                    throw e10;
                } catch (InvalidKeyException e11) {
                    e = e11;
                    String id = apply.getId();
                    throw new UnsupportedJwtException("The parsed JWT indicates it was signed with the '" + id + "' signature algorithm, but the provided " + key.getClass().getName() + " key may not be used to verify " + id + " signatures.  Because the specified key reflects a specific and expected algorithm, and the JWT does not reflect this algorithm, it is likely that the JWT was not expected and therefore should not be trusted.  Another possibility is that the parser was provided the incorrect signature verification key, but this cannot be assumed for security reasons.", e);
                } catch (IllegalArgumentException e12) {
                    e = e12;
                    String id2 = apply.getId();
                    throw new UnsupportedJwtException("The parsed JWT indicates it was signed with the '" + id2 + "' signature algorithm, but the provided " + key.getClass().getName() + " key may not be used to verify " + id2 + " signatures.  Because the specified key reflects a specific and expected algorithm, and the JWT does not reflect this algorithm, it is likely that the JWT was not expected and therefore should not be trusted.  Another possibility is that the parser was provided the incorrect signature verification key, but this cannot be assumed for security reasons.", e);
                }
            } finally {
                Streams.reset(inputStream);
            }
        } catch (UnsupportedJwtException e13) {
            throw new SignatureException("Unsupported signature algorithm '" + str + "'", e13);
        }
    }

    public byte[] decode(CharSequence charSequence, String str) {
        try {
            return Streams.bytes(this.decoder.decode(Streams.of(Strings.utf8(charSequence))), "Unable to Base64Url-decode input.");
        } catch (Throwable th) {
            throw new MalformedJwtException("Invalid Base64Url " + str + ": " + ("payload".equals(str) ? RedactedSupplier.REDACTED_VALUE : charSequence.toString()), th);
        }
    }

    public Map<String, ?> deserialize(InputStream inputStream, String str) {
        try {
            Map<String, ?> apply = new JsonObjectDeserializer(this.deserializer, str).apply(Streams.reader(inputStream));
            Objects.nullSafeClose(inputStream);
            return apply;
        } catch (Throwable th) {
            Objects.nullSafeClose(inputStream);
            throw th;
        }
    }

    @Override // io.jsonwebtoken.JwtParser
    public boolean isSigned(CharSequence charSequence) {
        if (!Strings.hasText(charSequence)) {
            return false;
        }
        try {
            TokenizedJwt tokenizedJwt = jwtTokenizer.tokenize(new CharSequenceReader(charSequence));
            if (tokenizedJwt instanceof TokenizedJwe) {
                return false;
            }
            return Strings.hasText(tokenizedJwt.getDigest());
        } catch (MalformedJwtException unused) {
            return false;
        }
    }

    @Override // io.jsonwebtoken.impl.io.AbstractParser, io.jsonwebtoken.io.Parser
    public /* bridge */ /* synthetic */ Jwt<?, ?> parse(CharSequence charSequence) {
        return (Jwt) super.parse(charSequence);
    }

    @Override // io.jsonwebtoken.JwtParser
    public Jws<Claims> parseClaimsJws(CharSequence charSequence) {
        return parseSignedClaims(charSequence);
    }

    @Override // io.jsonwebtoken.JwtParser
    public Jwt<Header, Claims> parseClaimsJwt(CharSequence charSequence) {
        return (Jwt) parse(charSequence).accept(Jwt.UNSECURED_CLAIMS);
    }

    @Override // io.jsonwebtoken.JwtParser
    public Jws<byte[]> parseContentJws(CharSequence charSequence) {
        return parseSignedContent(charSequence);
    }

    @Override // io.jsonwebtoken.JwtParser
    public Jwt<Header, byte[]> parseContentJwt(CharSequence charSequence) {
        return (Jwt) parse(charSequence).accept(Jwt.UNSECURED_CONTENT);
    }

    @Override // io.jsonwebtoken.JwtParser
    public Jwe<Claims> parseEncryptedClaims(CharSequence charSequence) {
        return (Jwe) parse(charSequence).accept(Jwe.CLAIMS);
    }

    @Override // io.jsonwebtoken.JwtParser
    public Jwe<byte[]> parseEncryptedContent(CharSequence charSequence) {
        return (Jwe) parse(charSequence).accept(Jwe.CONTENT);
    }

    @Override // io.jsonwebtoken.JwtParser
    public Jws<Claims> parseSignedClaims(CharSequence charSequence) {
        return (Jws) parse(charSequence).accept(Jws.CLAIMS);
    }

    @Override // io.jsonwebtoken.JwtParser
    public Jws<byte[]> parseSignedContent(CharSequence charSequence) {
        return (Jws) parse(charSequence).accept(Jws.CONTENT);
    }

    @Override // io.jsonwebtoken.JwtParser
    public Jwt<Header, Claims> parseUnsecuredClaims(CharSequence charSequence) {
        return (Jwt) parse(charSequence).accept(Jwt.UNSECURED_CLAIMS);
    }

    @Override // io.jsonwebtoken.JwtParser
    public Jwt<Header, byte[]> parseUnsecuredContent(CharSequence charSequence) {
        return (Jwt) parse(charSequence).accept(Jwt.UNSECURED_CONTENT);
    }

    private Jws<Claims> parseSignedClaims(CharSequence charSequence, Payload payload) {
        payload.setClaimsExpected(true);
        return (Jws) parse(charSequence, payload).accept(Jws.CLAIMS);
    }

    private Jws<byte[]> parseSignedContent(CharSequence charSequence, Payload payload) {
        return (Jws) parse(charSequence, payload).accept(Jws.CONTENT);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.jsonwebtoken.io.Parser
    public Jwt<?, ?> parse(Reader reader) {
        Assert.notNull(reader, "Reader cannot be null.");
        return parse(reader, Payload.EMPTY);
    }

    @Override // io.jsonwebtoken.JwtParser
    public Jws<byte[]> parseSignedContent(CharSequence charSequence, byte[] bArr) {
        Assert.notEmpty(bArr, "unencodedPayload argument cannot be null or empty.");
        return parseSignedContent(charSequence, new Payload(bArr, (String) null));
    }

    @Override // io.jsonwebtoken.JwtParser
    public Jws<Claims> parseSignedClaims(CharSequence charSequence, byte[] bArr) {
        Assert.notEmpty(bArr, "unencodedPayload argument cannot be null or empty.");
        return parseSignedClaims(charSequence, new Payload(bArr, (String) null));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:101:0x041a  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0436  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x043b  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0466  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x046b  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0468  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0444  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x038b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:148:0x03ef A[Catch: all -> 0x03f6, TRY_LEAVE, TryCatch #2 {all -> 0x03f6, blocks: (B:176:0x03b7, B:168:0x03d2, B:169:0x03ec, B:148:0x03ef, B:160:0x03c2, B:164:0x03c9), top: B:145:0x0393, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:163:0x03c9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:189:0x0380  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0345  */
    /* JADX WARN: Type inference failed for: r5v1, types: [io.jsonwebtoken.impl.DefaultClaims] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private io.jsonwebtoken.Jwt<?, ?> parse(java.io.Reader r28, io.jsonwebtoken.impl.Payload r29) {
        /*
            Method dump skipped, instructions count: 1390
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.jsonwebtoken.impl.DefaultJwtParser.parse(java.io.Reader, io.jsonwebtoken.impl.Payload):io.jsonwebtoken.Jwt");
    }

    @Override // io.jsonwebtoken.JwtParser
    public Jws<byte[]> parseSignedContent(CharSequence charSequence, InputStream inputStream) {
        Assert.notNull(inputStream, "unencodedPayload InputStream cannot be null.");
        return parseSignedContent(charSequence, payloadFor(inputStream));
    }

    @Override // io.jsonwebtoken.JwtParser
    public Jws<Claims> parseSignedClaims(CharSequence charSequence, InputStream inputStream) {
        Assert.notNull(inputStream, "unencodedPayload InputStream cannot be null.");
        return parseSignedClaims(charSequence, new Payload(Streams.bytes(inputStream, "Unable to obtain Claims bytes from unencodedPayload InputStream"), (String) null));
    }

    @Override // io.jsonwebtoken.JwtParser
    public <T> T parse(CharSequence charSequence, JwtHandler<T> jwtHandler) {
        return (T) parse(charSequence, Payload.EMPTY).accept(jwtHandler);
    }

    private Jwt<?, ?> parse(CharSequence charSequence, Payload payload) {
        Assert.hasText(charSequence, "JWT String argument cannot be null or empty.");
        return parse(new CharSequenceReader(charSequence), payload);
    }
}
