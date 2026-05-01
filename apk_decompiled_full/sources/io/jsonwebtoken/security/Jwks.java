package io.jsonwebtoken.security;

import io.jsonwebtoken.lang.Classes;
import io.jsonwebtoken.lang.Registry;

/* loaded from: classes3.dex */
public final class Jwks {
    private static final String BUILDER_FQCN = "io.jsonwebtoken.impl.security.DefaultDynamicJwkBuilder";
    private static final String JWKS_BRIDGE_FQCN = "io.jsonwebtoken.impl.security.JwksBridge";
    private static final String PARSER_BUILDER_FQCN = "io.jsonwebtoken.impl.security.DefaultJwkParserBuilder";
    private static final String SET_BUILDER_FQCN = "io.jsonwebtoken.impl.security.DefaultJwkSetBuilder";
    private static final String SET_PARSER_BUILDER_FQCN = "io.jsonwebtoken.impl.security.DefaultJwkSetParserBuilder";

    public static final class CRV {
        private static final String IMPL_CLASSNAME = "io.jsonwebtoken.impl.security.StandardCurves";
        private static final Registry<String, Curve> REGISTRY = (Registry) Classes.newInstance(IMPL_CLASSNAME);
        public static final Curve P256 = get().forKey("P-256");
        public static final Curve P384 = get().forKey("P-384");
        public static final Curve P521 = get().forKey("P-521");
        public static final Curve Ed25519 = get().forKey("Ed25519");
        public static final Curve Ed448 = get().forKey("Ed448");
        public static final Curve X25519 = get().forKey("X25519");
        public static final Curve X448 = get().forKey("X448");

        private CRV() {
        }

        public static Registry<String, Curve> get() {
            return REGISTRY;
        }
    }

    public static final class HASH {
        private static final String IMPL_CLASSNAME = "io.jsonwebtoken.impl.security.StandardHashAlgorithms";
        private static final Registry<String, HashAlgorithm> REGISTRY = (Registry) Classes.newInstance(IMPL_CLASSNAME);
        public static final HashAlgorithm SHA256 = get().forKey("sha-256");
        public static final HashAlgorithm SHA384 = get().forKey("sha-384");
        public static final HashAlgorithm SHA512 = get().forKey("sha-512");
        public static final HashAlgorithm SHA3_256 = get().forKey("sha3-256");
        public static final HashAlgorithm SHA3_384 = get().forKey("sha3-384");
        public static final HashAlgorithm SHA3_512 = get().forKey("sha3-512");

        private HASH() {
        }

        public static Registry<String, HashAlgorithm> get() {
            return REGISTRY;
        }
    }

    public static final class OP {
        private static final String BUILDER_CLASSNAME = "io.jsonwebtoken.impl.security.DefaultKeyOperationBuilder";
        private static final String POLICY_BUILDER_CLASSNAME = "io.jsonwebtoken.impl.security.DefaultKeyOperationPolicyBuilder";
        private static final String IMPL_CLASSNAME = "io.jsonwebtoken.impl.security.StandardKeyOperations";
        private static final Registry<String, KeyOperation> REGISTRY = (Registry) Classes.newInstance(IMPL_CLASSNAME);
        public static final KeyOperation SIGN = get().forKey("sign");
        public static final KeyOperation VERIFY = get().forKey("verify");
        public static final KeyOperation ENCRYPT = get().forKey("encrypt");
        public static final KeyOperation DECRYPT = get().forKey("decrypt");
        public static final KeyOperation WRAP_KEY = get().forKey("wrapKey");
        public static final KeyOperation UNWRAP_KEY = get().forKey("unwrapKey");
        public static final KeyOperation DERIVE_KEY = get().forKey("deriveKey");
        public static final KeyOperation DERIVE_BITS = get().forKey("deriveBits");

        private OP() {
        }

        public static KeyOperationBuilder builder() {
            return (KeyOperationBuilder) Classes.newInstance(BUILDER_CLASSNAME);
        }

        public static Registry<String, KeyOperation> get() {
            return REGISTRY;
        }

        public static KeyOperationPolicyBuilder policy() {
            return (KeyOperationPolicyBuilder) Classes.newInstance(POLICY_BUILDER_CLASSNAME);
        }
    }

    private Jwks() {
    }

    public static String UNSAFE_JSON(Jwk<?> jwk) {
        return (String) Classes.invokeStatic(JWKS_BRIDGE_FQCN, "UNSAFE_JSON", (Class<?>[]) new Class[]{Jwk.class}, jwk);
    }

    public static DynamicJwkBuilder<?, ?> builder() {
        return (DynamicJwkBuilder) Classes.newInstance(BUILDER_FQCN);
    }

    public static String json(PublicJwk<?> publicJwk) {
        return UNSAFE_JSON(publicJwk);
    }

    public static JwkParserBuilder parser() {
        return (JwkParserBuilder) Classes.newInstance(PARSER_BUILDER_FQCN);
    }

    public static JwkSetBuilder set() {
        return (JwkSetBuilder) Classes.newInstance(SET_BUILDER_FQCN);
    }

    public static JwkSetParserBuilder setParser() {
        return (JwkSetParserBuilder) Classes.newInstance(SET_PARSER_BUILDER_FQCN);
    }
}
