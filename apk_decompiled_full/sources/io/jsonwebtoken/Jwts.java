package io.jsonwebtoken;

import io.jsonwebtoken.io.CompressionAlgorithm;
import io.jsonwebtoken.lang.Builder;
import io.jsonwebtoken.lang.Classes;
import io.jsonwebtoken.lang.Registry;
import io.jsonwebtoken.security.AeadAlgorithm;
import io.jsonwebtoken.security.KeyAlgorithm;
import io.jsonwebtoken.security.MacAlgorithm;
import io.jsonwebtoken.security.Password;
import io.jsonwebtoken.security.SecretKeyAlgorithm;
import io.jsonwebtoken.security.SecureDigestAlgorithm;
import io.jsonwebtoken.security.X509Builder;
import java.security.Key;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Map;
import javax.crypto.SecretKey;

/* loaded from: classes3.dex */
public final class Jwts {

    public static final class ENC {
        private static final String IMPL_CLASSNAME = "io.jsonwebtoken.impl.security.StandardEncryptionAlgorithms";
        private static final Registry<String, AeadAlgorithm> REGISTRY = (Registry) Classes.newInstance(IMPL_CLASSNAME);
        public static final AeadAlgorithm A128CBC_HS256 = get().forKey("A128CBC-HS256");
        public static final AeadAlgorithm A192CBC_HS384 = get().forKey("A192CBC-HS384");
        public static final AeadAlgorithm A256CBC_HS512 = get().forKey("A256CBC-HS512");
        public static final AeadAlgorithm A128GCM = get().forKey("A128GCM");
        public static final AeadAlgorithm A192GCM = get().forKey("A192GCM");
        public static final AeadAlgorithm A256GCM = get().forKey("A256GCM");

        private ENC() {
        }

        public static Registry<String, AeadAlgorithm> get() {
            return REGISTRY;
        }
    }

    public interface HeaderBuilder extends JweHeaderMutator<HeaderBuilder>, X509Builder<HeaderBuilder>, Builder<Header> {
    }

    public static final class KEY {
        public static final SecretKeyAlgorithm A128GCMKW;
        public static final SecretKeyAlgorithm A128KW;
        public static final SecretKeyAlgorithm A192GCMKW;
        public static final SecretKeyAlgorithm A192KW;
        public static final SecretKeyAlgorithm A256GCMKW;
        public static final SecretKeyAlgorithm A256KW;
        public static final KeyAlgorithm<SecretKey, SecretKey> DIRECT;
        public static final KeyAlgorithm<PublicKey, PrivateKey> ECDH_ES;
        public static final KeyAlgorithm<PublicKey, PrivateKey> ECDH_ES_A128KW;
        public static final KeyAlgorithm<PublicKey, PrivateKey> ECDH_ES_A192KW;
        public static final KeyAlgorithm<PublicKey, PrivateKey> ECDH_ES_A256KW;
        private static final String IMPL_CLASSNAME = "io.jsonwebtoken.impl.security.StandardKeyAlgorithms";
        public static final KeyAlgorithm<Password, Password> PBES2_HS256_A128KW;
        public static final KeyAlgorithm<Password, Password> PBES2_HS384_A192KW;
        public static final KeyAlgorithm<Password, Password> PBES2_HS512_A256KW;
        private static final Registry<String, KeyAlgorithm<?, ?>> REGISTRY;
        public static final KeyAlgorithm<PublicKey, PrivateKey> RSA1_5;
        public static final KeyAlgorithm<PublicKey, PrivateKey> RSA_OAEP;
        public static final KeyAlgorithm<PublicKey, PrivateKey> RSA_OAEP_256;

        static {
            Registry<String, KeyAlgorithm<?, ?>> registry = (Registry) Classes.newInstance(IMPL_CLASSNAME);
            REGISTRY = registry;
            DIRECT = (KeyAlgorithm) Jwts.get(registry, "dir");
            A128KW = (SecretKeyAlgorithm) Jwts.get(registry, "A128KW");
            A192KW = (SecretKeyAlgorithm) Jwts.get(registry, "A192KW");
            A256KW = (SecretKeyAlgorithm) Jwts.get(registry, "A256KW");
            A128GCMKW = (SecretKeyAlgorithm) Jwts.get(registry, "A128GCMKW");
            A192GCMKW = (SecretKeyAlgorithm) Jwts.get(registry, "A192GCMKW");
            A256GCMKW = (SecretKeyAlgorithm) Jwts.get(registry, "A256GCMKW");
            PBES2_HS256_A128KW = (KeyAlgorithm) Jwts.get(registry, "PBES2-HS256+A128KW");
            PBES2_HS384_A192KW = (KeyAlgorithm) Jwts.get(registry, "PBES2-HS384+A192KW");
            PBES2_HS512_A256KW = (KeyAlgorithm) Jwts.get(registry, "PBES2-HS512+A256KW");
            RSA1_5 = (KeyAlgorithm) Jwts.get(registry, "RSA1_5");
            RSA_OAEP = (KeyAlgorithm) Jwts.get(registry, "RSA-OAEP");
            RSA_OAEP_256 = (KeyAlgorithm) Jwts.get(registry, "RSA-OAEP-256");
            ECDH_ES = (KeyAlgorithm) Jwts.get(registry, "ECDH-ES");
            ECDH_ES_A128KW = (KeyAlgorithm) Jwts.get(registry, "ECDH-ES+A128KW");
            ECDH_ES_A192KW = (KeyAlgorithm) Jwts.get(registry, "ECDH-ES+A192KW");
            ECDH_ES_A256KW = (KeyAlgorithm) Jwts.get(registry, "ECDH-ES+A256KW");
        }

        private KEY() {
        }

        public static Registry<String, KeyAlgorithm<?, ?>> get() {
            return REGISTRY;
        }
    }

    public static final class SIG {
        public static final io.jsonwebtoken.security.SignatureAlgorithm ES256;
        public static final io.jsonwebtoken.security.SignatureAlgorithm ES384;
        public static final io.jsonwebtoken.security.SignatureAlgorithm ES512;
        public static final io.jsonwebtoken.security.SignatureAlgorithm EdDSA;
        public static final MacAlgorithm HS256;
        public static final MacAlgorithm HS384;
        public static final MacAlgorithm HS512;
        private static final String IMPL_CLASSNAME = "io.jsonwebtoken.impl.security.StandardSecureDigestAlgorithms";
        public static final SecureDigestAlgorithm<Key, Key> NONE;
        public static final io.jsonwebtoken.security.SignatureAlgorithm PS256;
        public static final io.jsonwebtoken.security.SignatureAlgorithm PS384;
        public static final io.jsonwebtoken.security.SignatureAlgorithm PS512;
        private static final Registry<String, SecureDigestAlgorithm<?, ?>> REGISTRY;
        public static final io.jsonwebtoken.security.SignatureAlgorithm RS256;
        public static final io.jsonwebtoken.security.SignatureAlgorithm RS384;
        public static final io.jsonwebtoken.security.SignatureAlgorithm RS512;

        static {
            Registry<String, SecureDigestAlgorithm<?, ?>> registry = (Registry) Classes.newInstance(IMPL_CLASSNAME);
            REGISTRY = registry;
            NONE = (SecureDigestAlgorithm) Jwts.get(registry, "none");
            HS256 = (MacAlgorithm) Jwts.get(registry, "HS256");
            HS384 = (MacAlgorithm) Jwts.get(registry, "HS384");
            HS512 = (MacAlgorithm) Jwts.get(registry, "HS512");
            RS256 = (io.jsonwebtoken.security.SignatureAlgorithm) Jwts.get(registry, "RS256");
            RS384 = (io.jsonwebtoken.security.SignatureAlgorithm) Jwts.get(registry, "RS384");
            RS512 = (io.jsonwebtoken.security.SignatureAlgorithm) Jwts.get(registry, "RS512");
            PS256 = (io.jsonwebtoken.security.SignatureAlgorithm) Jwts.get(registry, "PS256");
            PS384 = (io.jsonwebtoken.security.SignatureAlgorithm) Jwts.get(registry, "PS384");
            PS512 = (io.jsonwebtoken.security.SignatureAlgorithm) Jwts.get(registry, "PS512");
            ES256 = (io.jsonwebtoken.security.SignatureAlgorithm) Jwts.get(registry, "ES256");
            ES384 = (io.jsonwebtoken.security.SignatureAlgorithm) Jwts.get(registry, "ES384");
            ES512 = (io.jsonwebtoken.security.SignatureAlgorithm) Jwts.get(registry, "ES512");
            EdDSA = (io.jsonwebtoken.security.SignatureAlgorithm) Jwts.get(registry, "EdDSA");
        }

        private SIG() {
        }

        public static Registry<String, SecureDigestAlgorithm<?, ?>> get() {
            return REGISTRY;
        }
    }

    public static final class ZIP {
        private static final String IMPL_CLASSNAME = "io.jsonwebtoken.impl.io.StandardCompressionAlgorithms";
        private static final Registry<String, CompressionAlgorithm> REGISTRY = (Registry) Classes.newInstance(IMPL_CLASSNAME);
        public static final CompressionAlgorithm DEF = get().forKey("DEF");
        public static final CompressionAlgorithm GZIP = get().forKey("GZIP");

        private ZIP() {
        }

        public static Registry<String, CompressionAlgorithm> get() {
            return REGISTRY;
        }
    }

    private Jwts() {
    }

    public static JwtBuilder builder() {
        return (JwtBuilder) Classes.newInstance("io.jsonwebtoken.impl.DefaultJwtBuilder");
    }

    public static ClaimsBuilder claims() {
        return (ClaimsBuilder) Classes.newInstance("io.jsonwebtoken.impl.DefaultClaimsBuilder");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <T> T get(Registry<String, ?> registry, String str) {
        return (T) registry.forKey(str);
    }

    public static HeaderBuilder header() {
        return (HeaderBuilder) Classes.newInstance("io.jsonwebtoken.impl.DefaultJwtHeaderBuilder");
    }

    public static JwtParserBuilder parser() {
        return (JwtParserBuilder) Classes.newInstance("io.jsonwebtoken.impl.DefaultJwtParserBuilder");
    }

    @Deprecated
    public static Claims claims(Map<String, Object> map) {
        return claims().add(map).build();
    }
}
