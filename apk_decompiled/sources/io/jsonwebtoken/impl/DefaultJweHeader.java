package io.jsonwebtoken.impl;

import io.jsonwebtoken.JweHeader;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.impl.lang.Converter;
import io.jsonwebtoken.impl.lang.Converters;
import io.jsonwebtoken.impl.lang.Parameter;
import io.jsonwebtoken.impl.lang.ParameterBuilder;
import io.jsonwebtoken.impl.lang.Parameters;
import io.jsonwebtoken.impl.lang.PositiveIntegerConverter;
import io.jsonwebtoken.impl.lang.RequiredBitLengthConverter;
import io.jsonwebtoken.impl.security.JwkConverter;
import io.jsonwebtoken.lang.Registry;
import io.jsonwebtoken.lang.Strings;
import io.jsonwebtoken.security.PublicJwk;
import java.util.Map;

/* loaded from: classes3.dex */
public class DefaultJweHeader extends DefaultProtectedHeader implements JweHeader {
    static final Parameter<byte[]> APU;
    static final Parameter<byte[]> APV;
    static final Parameter<String> ENCRYPTION_ALGORITHM;
    public static final Parameter<PublicJwk<?>> EPK;
    public static final Parameter<byte[]> IV;
    public static final Parameter<Integer> P2C;
    public static final Parameter<byte[]> P2S;
    static final Registry<String, Parameter<?>> PARAMS;
    public static final Parameter<byte[]> TAG;

    /* JADX WARN: Multi-variable type inference failed */
    static {
        Parameter<String> string = Parameters.string("enc", "Encryption Algorithm");
        ENCRYPTION_ALGORITHM = string;
        Parameter<PublicJwk<?>> parameter = (Parameter) Parameters.builder(JwkConverter.PUBLIC_JWK_CLASS).setId("epk").setName("Ephemeral Public Key").setConverter(JwkConverter.PUBLIC_JWK).build();
        EPK = parameter;
        Parameter<byte[]> parameter2 = (Parameter) Parameters.bytes("apu", "Agreement PartyUInfo").build();
        APU = parameter2;
        Parameter<byte[]> parameter3 = (Parameter) Parameters.bytes("apv", "Agreement PartyVInfo").build();
        APV = parameter3;
        ParameterBuilder<byte[]> bytes = Parameters.bytes("iv", "Initialization Vector");
        Converter<byte[], Object> converter = Converters.BASE64URL_BYTES;
        Parameter<byte[]> parameter4 = (Parameter) bytes.setConverter(new RequiredBitLengthConverter(converter, 96)).build();
        IV = parameter4;
        Parameter<byte[]> parameter5 = (Parameter) Parameters.bytes("tag", "Authentication Tag").setConverter(new RequiredBitLengthConverter(converter, 128)).build();
        TAG = parameter5;
        Parameter<byte[]> parameter6 = (Parameter) Parameters.bytes("p2s", "PBES2 Salt Input").setConverter(new RequiredBitLengthConverter(converter, 64, false)).build();
        P2S = parameter6;
        Parameter<Integer> parameter7 = (Parameter) Parameters.builder(Integer.class).setConverter(PositiveIntegerConverter.INSTANCE).setId("p2c").setName("PBES2 Count").build();
        P2C = parameter7;
        PARAMS = Parameters.registry(DefaultProtectedHeader.PARAMS, string, parameter, parameter2, parameter3, parameter4, parameter5, parameter6, parameter7);
    }

    public DefaultJweHeader(Map<String, ?> map) {
        super(PARAMS, map);
    }

    public static boolean isCandidate(ParameterMap parameterMap) {
        String str = (String) parameterMap.get((Parameter) DefaultHeader.ALGORITHM);
        return Strings.hasText(str) && !str.equalsIgnoreCase(Jwts.SIG.NONE.getId()) && Strings.hasText((String) parameterMap.get((Parameter) ENCRYPTION_ALGORITHM));
    }

    @Override // io.jsonwebtoken.JweHeader
    public byte[] getAgreementPartyUInfo() {
        return (byte[]) get((Parameter) APU);
    }

    @Override // io.jsonwebtoken.JweHeader
    public byte[] getAgreementPartyVInfo() {
        return (byte[]) get((Parameter) APV);
    }

    @Override // io.jsonwebtoken.JweHeader
    public byte[] getAuthenticationTag() {
        return (byte[]) get((Parameter) TAG);
    }

    @Override // io.jsonwebtoken.JweHeader
    public String getEncryptionAlgorithm() {
        return (String) get((Parameter) ENCRYPTION_ALGORITHM);
    }

    @Override // io.jsonwebtoken.JweHeader
    public PublicJwk<?> getEphemeralPublicKey() {
        return (PublicJwk) get((Parameter) EPK);
    }

    @Override // io.jsonwebtoken.JweHeader
    public byte[] getInitializationVector() {
        return (byte[]) get((Parameter) IV);
    }

    @Override // io.jsonwebtoken.impl.DefaultHeader, io.jsonwebtoken.impl.ParameterMap, io.jsonwebtoken.impl.lang.Nameable
    public String getName() {
        return "JWE header";
    }

    @Override // io.jsonwebtoken.JweHeader
    public Integer getPbes2Count() {
        return (Integer) get((Parameter) P2C);
    }

    @Override // io.jsonwebtoken.JweHeader
    public byte[] getPbes2Salt() {
        return (byte[]) get((Parameter) P2S);
    }
}
