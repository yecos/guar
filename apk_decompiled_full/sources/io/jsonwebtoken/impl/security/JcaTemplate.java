package io.jsonwebtoken.impl.security;

import io.jsonwebtoken.Identifiable;
import io.jsonwebtoken.impl.io.Streams;
import io.jsonwebtoken.impl.lang.Bytes;
import io.jsonwebtoken.impl.lang.CheckedFunction;
import io.jsonwebtoken.impl.lang.CheckedSupplier;
import io.jsonwebtoken.impl.lang.DefaultRegistry;
import io.jsonwebtoken.impl.lang.Function;
import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.lang.Collections;
import io.jsonwebtoken.lang.Objects;
import io.jsonwebtoken.lang.Registry;
import io.jsonwebtoken.lang.Strings;
import io.jsonwebtoken.security.SecurityException;
import io.jsonwebtoken.security.SignatureException;
import java.security.AlgorithmParameters;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import javax.crypto.Cipher;
import javax.crypto.KeyAgreement;
import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import org.android.agoo.common.AgooConstants;

/* loaded from: classes3.dex */
public class JcaTemplate {
    private static final List<InstanceFactory<?>> FACTORIES;
    private static final Registry<Class<?>, InstanceFactory<?>> REGISTRY;
    private final String jcaName;
    private final Provider provider;
    private final SecureRandom secureRandom;

    public static class AlgorithmParametersFactory extends JcaInstanceFactory<AlgorithmParameters> {
        public AlgorithmParametersFactory() {
            super(AlgorithmParameters.class);
        }

        @Override // io.jsonwebtoken.impl.security.JcaTemplate.JcaInstanceFactory
        public AlgorithmParameters doGet(String str, Provider provider) {
            return provider != null ? AlgorithmParameters.getInstance(str, provider) : AlgorithmParameters.getInstance(str);
        }
    }

    public static class CertificateFactoryFactory extends JcaInstanceFactory<CertificateFactory> {
        public CertificateFactoryFactory() {
            super(CertificateFactory.class);
        }

        @Override // io.jsonwebtoken.impl.security.JcaTemplate.JcaInstanceFactory
        public CertificateFactory doGet(String str, Provider provider) {
            return provider != null ? CertificateFactory.getInstance(str, provider) : CertificateFactory.getInstance(str);
        }
    }

    public static class CipherFactory extends JcaInstanceFactory<Cipher> {
        public CipherFactory() {
            super(Cipher.class);
        }

        @Override // io.jsonwebtoken.impl.security.JcaTemplate.JcaInstanceFactory
        public Cipher doGet(String str, Provider provider) {
            return provider != null ? Cipher.getInstance(str, provider) : Cipher.getInstance(str);
        }
    }

    public interface InstanceFactory<T> extends Identifiable {
        T get(String str, Provider provider);

        Class<T> getInstanceClass();
    }

    public static class KeyAgreementFactory extends JcaInstanceFactory<KeyAgreement> {
        public KeyAgreementFactory() {
            super(KeyAgreement.class);
        }

        @Override // io.jsonwebtoken.impl.security.JcaTemplate.JcaInstanceFactory
        public KeyAgreement doGet(String str, Provider provider) {
            return provider != null ? KeyAgreement.getInstance(str, provider) : KeyAgreement.getInstance(str);
        }
    }

    public static class KeyFactoryFactory extends JcaInstanceFactory<KeyFactory> {
        public KeyFactoryFactory() {
            super(KeyFactory.class);
        }

        @Override // io.jsonwebtoken.impl.security.JcaTemplate.JcaInstanceFactory
        public KeyFactory doGet(String str, Provider provider) {
            return provider != null ? KeyFactory.getInstance(str, provider) : KeyFactory.getInstance(str);
        }
    }

    public static class KeyGeneratorFactory extends JcaInstanceFactory<KeyGenerator> {
        public KeyGeneratorFactory() {
            super(KeyGenerator.class);
        }

        @Override // io.jsonwebtoken.impl.security.JcaTemplate.JcaInstanceFactory
        public KeyGenerator doGet(String str, Provider provider) {
            return provider != null ? KeyGenerator.getInstance(str, provider) : KeyGenerator.getInstance(str);
        }
    }

    public static class KeyPairGeneratorFactory extends JcaInstanceFactory<KeyPairGenerator> {
        public KeyPairGeneratorFactory() {
            super(KeyPairGenerator.class);
        }

        @Override // io.jsonwebtoken.impl.security.JcaTemplate.JcaInstanceFactory
        public KeyPairGenerator doGet(String str, Provider provider) {
            return provider != null ? KeyPairGenerator.getInstance(str, provider) : KeyPairGenerator.getInstance(str);
        }
    }

    public static class MacFactory extends JcaInstanceFactory<Mac> {
        public MacFactory() {
            super(Mac.class);
        }

        @Override // io.jsonwebtoken.impl.security.JcaTemplate.JcaInstanceFactory
        public Mac doGet(String str, Provider provider) {
            return provider != null ? Mac.getInstance(str, provider) : Mac.getInstance(str);
        }
    }

    public static class MessageDigestFactory extends JcaInstanceFactory<MessageDigest> {
        public MessageDigestFactory() {
            super(MessageDigest.class);
        }

        @Override // io.jsonwebtoken.impl.security.JcaTemplate.JcaInstanceFactory
        public MessageDigest doGet(String str, Provider provider) {
            return provider != null ? MessageDigest.getInstance(str, provider) : MessageDigest.getInstance(str);
        }
    }

    public static class SecretKeyFactoryFactory extends JcaInstanceFactory<SecretKeyFactory> {
        public SecretKeyFactoryFactory() {
            super(SecretKeyFactory.class);
        }

        @Override // io.jsonwebtoken.impl.security.JcaTemplate.JcaInstanceFactory
        public SecretKeyFactory doGet(String str, Provider provider) {
            return provider != null ? SecretKeyFactory.getInstance(str, provider) : SecretKeyFactory.getInstance(str);
        }
    }

    public static class SignatureFactory extends JcaInstanceFactory<Signature> {
        public SignatureFactory() {
            super(Signature.class);
        }

        @Override // io.jsonwebtoken.impl.security.JcaTemplate.JcaInstanceFactory
        public Signature doGet(String str, Provider provider) {
            return provider != null ? Signature.getInstance(str, provider) : Signature.getInstance(str);
        }
    }

    static {
        List<InstanceFactory<?>> of = Collections.of(new CipherFactory(), new KeyFactoryFactory(), new SecretKeyFactoryFactory(), new KeyGeneratorFactory(), new KeyPairGeneratorFactory(), new KeyAgreementFactory(), new MessageDigestFactory(), new SignatureFactory(), new MacFactory(), new AlgorithmParametersFactory(), new CertificateFactoryFactory());
        FACTORIES = of;
        REGISTRY = new DefaultRegistry("JCA Instance Factory", "instance class", of, new Function<InstanceFactory<?>, Class<?>>() { // from class: io.jsonwebtoken.impl.security.JcaTemplate.1
            @Override // io.jsonwebtoken.impl.lang.Function
            public Class<?> apply(InstanceFactory<?> instanceFactory) {
                return instanceFactory.getInstanceClass();
            }
        });
    }

    public JcaTemplate(String str) {
        this(str, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public <T, R> R execute(Class<T> cls, CheckedFunction<T, R> checkedFunction, Provider provider) {
        InstanceFactory<?> instanceFactory = REGISTRY.get(cls);
        Assert.notNull(instanceFactory, "Unsupported JCA instance class.");
        return (R) checkedFunction.apply(Assert.isInstanceOf(cls, instanceFactory.get(this.jcaName, provider), "Factory instance does not match expected type."));
    }

    private int getJdk8213363BugExpectedSize(InvalidKeyException invalidKeyException) {
        String message = invalidKeyException.getMessage();
        if (!Strings.hasText(message) || !message.startsWith("key length must be ")) {
            return -1;
        }
        try {
            return Integer.parseInt(message.substring(19));
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    private boolean isJdk8213363Bug(InvalidKeySpecException invalidKeySpecException) {
        if (isJdk11()) {
            return ("XDH".equals(this.jcaName) || "X25519".equals(this.jcaName) || "X448".equals(this.jcaName)) && (invalidKeySpecException.getCause() instanceof InvalidKeyException) && !Objects.isEmpty((Object[]) invalidKeySpecException.getStackTrace()) && "sun.security.ec.XDHKeyFactory".equals(invalidKeySpecException.getStackTrace()[0].getClassName()) && "engineGeneratePrivate".equals(invalidKeySpecException.getStackTrace()[0].getMethodName());
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public KeySpec respecIfNecessary(InvalidKeySpecException invalidKeySpecException, KeySpec keySpec) {
        int jdk8213363BugExpectedSize;
        if (!(keySpec instanceof PKCS8EncodedKeySpec)) {
            return null;
        }
        byte[] encoded = ((PKCS8EncodedKeySpec) keySpec).getEncoded();
        if (!isJdk8213363Bug(invalidKeySpecException) || (!((jdk8213363BugExpectedSize = getJdk8213363BugExpectedSize((InvalidKeyException) Assert.isInstanceOf(InvalidKeyException.class, invalidKeySpecException.getCause(), "Unexpected argument."))) == 32 || jdk8213363BugExpectedSize == 56) || Bytes.length(encoded) < jdk8213363BugExpectedSize)) {
            return null;
        }
        byte[] bArr = new byte[jdk8213363BugExpectedSize];
        System.arraycopy(encoded, encoded.length - jdk8213363BugExpectedSize, bArr, 0, jdk8213363BugExpectedSize);
        return (jdk8213363BugExpectedSize == 32 ? EdwardsCurve.X25519 : EdwardsCurve.X448).privateKeySpec(bArr, false);
    }

    public <T, R> R fallback(final Class<T> cls, final CheckedFunction<T, R> checkedFunction) {
        return (R) execute((Class<?>) cls, (CheckedSupplier) new CheckedSupplier<R>() { // from class: io.jsonwebtoken.impl.security.JcaTemplate.3
            @Override // io.jsonwebtoken.impl.lang.CheckedSupplier
            public R get() {
                try {
                    JcaTemplate jcaTemplate = JcaTemplate.this;
                    return (R) jcaTemplate.execute(cls, checkedFunction, jcaTemplate.provider);
                } catch (Exception e10) {
                    try {
                        Provider findBouncyCastle = JcaTemplate.this.findBouncyCastle();
                        if (findBouncyCastle != null) {
                            return (R) JcaTemplate.this.execute(cls, checkedFunction, findBouncyCastle);
                        }
                    } catch (Throwable unused) {
                    }
                    throw e10;
                }
            }
        });
    }

    public Provider findBouncyCastle() {
        return Providers.findBouncyCastle();
    }

    public KeyPair generateKeyPair() {
        return (KeyPair) withKeyPairGenerator(new CheckedFunction<KeyPairGenerator, KeyPair>() { // from class: io.jsonwebtoken.impl.security.JcaTemplate.5
            @Override // io.jsonwebtoken.impl.lang.CheckedFunction
            public KeyPair apply(KeyPairGenerator keyPairGenerator) {
                return keyPairGenerator.generateKeyPair();
            }
        });
    }

    public PrivateKey generatePrivate(KeyFactory keyFactory, KeySpec keySpec) {
        return keyFactory.generatePrivate(keySpec);
    }

    public PublicKey generatePublic(final KeySpec keySpec) {
        return (PublicKey) fallback(KeyFactory.class, new CheckedFunction<KeyFactory, PublicKey>() { // from class: io.jsonwebtoken.impl.security.JcaTemplate.8
            @Override // io.jsonwebtoken.impl.lang.CheckedFunction
            public PublicKey apply(KeyFactory keyFactory) {
                return keyFactory.generatePublic(keySpec);
            }
        });
    }

    public SecretKey generateSecretKey(final int i10) {
        return (SecretKey) withKeyGenerator(new CheckedFunction<KeyGenerator, SecretKey>() { // from class: io.jsonwebtoken.impl.security.JcaTemplate.4
            @Override // io.jsonwebtoken.impl.lang.CheckedFunction
            public SecretKey apply(KeyGenerator keyGenerator) {
                keyGenerator.init(i10, JcaTemplate.this.secureRandom);
                return keyGenerator.generateKey();
            }
        });
    }

    public X509Certificate generateX509Certificate(final byte[] bArr) {
        return (X509Certificate) fallback(CertificateFactory.class, new CheckedFunction<CertificateFactory, X509Certificate>() { // from class: io.jsonwebtoken.impl.security.JcaTemplate.10
            @Override // io.jsonwebtoken.impl.lang.CheckedFunction
            public X509Certificate apply(CertificateFactory certificateFactory) {
                return (X509Certificate) certificateFactory.generateCertificate(Streams.of(bArr));
            }
        });
    }

    public boolean isJdk11() {
        return System.getProperty("java.version").startsWith(AgooConstants.ACK_BODY_NULL);
    }

    public <R> R withAlgorithmParameters(CheckedFunction<AlgorithmParameters, R> checkedFunction) {
        return (R) execute(AlgorithmParameters.class, checkedFunction);
    }

    public <R> R withCertificateFactory(CheckedFunction<CertificateFactory, R> checkedFunction) {
        return (R) execute(CertificateFactory.class, checkedFunction);
    }

    public <R> R withCipher(CheckedFunction<Cipher, R> checkedFunction) {
        return (R) execute(Cipher.class, checkedFunction);
    }

    public <R> R withKeyAgreement(CheckedFunction<KeyAgreement, R> checkedFunction) {
        return (R) execute(KeyAgreement.class, checkedFunction);
    }

    public <R> R withKeyFactory(CheckedFunction<KeyFactory, R> checkedFunction) {
        return (R) execute(KeyFactory.class, checkedFunction);
    }

    public <R> R withKeyGenerator(CheckedFunction<KeyGenerator, R> checkedFunction) {
        return (R) execute(KeyGenerator.class, checkedFunction);
    }

    public <R> R withKeyPairGenerator(CheckedFunction<KeyPairGenerator, R> checkedFunction) {
        return (R) execute(KeyPairGenerator.class, checkedFunction);
    }

    public <R> R withMac(CheckedFunction<Mac, R> checkedFunction) {
        return (R) execute(Mac.class, checkedFunction);
    }

    public <R> R withMessageDigest(CheckedFunction<MessageDigest, R> checkedFunction) {
        return (R) execute(MessageDigest.class, checkedFunction);
    }

    public <R> R withSecretKeyFactory(CheckedFunction<SecretKeyFactory, R> checkedFunction) {
        return (R) execute(SecretKeyFactory.class, checkedFunction);
    }

    public <R> R withSignature(CheckedFunction<Signature, R> checkedFunction) {
        return (R) execute(Signature.class, checkedFunction);
    }

    public JcaTemplate(String str, Provider provider) {
        this(str, provider, null);
    }

    public KeyPair generateKeyPair(final int i10) {
        return (KeyPair) withKeyPairGenerator(new CheckedFunction<KeyPairGenerator, KeyPair>() { // from class: io.jsonwebtoken.impl.security.JcaTemplate.6
            @Override // io.jsonwebtoken.impl.lang.CheckedFunction
            public KeyPair apply(KeyPairGenerator keyPairGenerator) {
                keyPairGenerator.initialize(i10, JcaTemplate.this.secureRandom);
                return keyPairGenerator.generateKeyPair();
            }
        });
    }

    public PrivateKey generatePrivate(final KeySpec keySpec) {
        return (PrivateKey) fallback(KeyFactory.class, new CheckedFunction<KeyFactory, PrivateKey>() { // from class: io.jsonwebtoken.impl.security.JcaTemplate.9
            @Override // io.jsonwebtoken.impl.lang.CheckedFunction
            public PrivateKey apply(KeyFactory keyFactory) {
                try {
                    return JcaTemplate.this.generatePrivate(keyFactory, keySpec);
                } catch (InvalidKeySpecException e10) {
                    KeySpec respecIfNecessary = JcaTemplate.this.respecIfNecessary(e10, keySpec);
                    if (respecIfNecessary != null) {
                        return JcaTemplate.this.generatePrivate(keyFactory, respecIfNecessary);
                    }
                    throw e10;
                }
            }
        });
    }

    public JcaTemplate(String str, Provider provider, SecureRandom secureRandom) {
        this.jcaName = (String) Assert.hasText(str, "jcaName string cannot be null or empty.");
        this.secureRandom = secureRandom == null ? Randoms.secureRandom() : secureRandom;
        this.provider = provider;
    }

    public KeyPair generateKeyPair(final AlgorithmParameterSpec algorithmParameterSpec) {
        return (KeyPair) withKeyPairGenerator(new CheckedFunction<KeyPairGenerator, KeyPair>() { // from class: io.jsonwebtoken.impl.security.JcaTemplate.7
            @Override // io.jsonwebtoken.impl.lang.CheckedFunction
            public KeyPair apply(KeyPairGenerator keyPairGenerator) {
                keyPairGenerator.initialize(algorithmParameterSpec, JcaTemplate.this.secureRandom);
                return keyPairGenerator.generateKeyPair();
            }
        });
    }

    public static abstract class JcaInstanceFactory<T> implements InstanceFactory<T> {
        private final ConcurrentMap<String, Boolean> FALLBACK_ATTEMPTS = new ConcurrentHashMap();
        private final Class<T> clazz;

        public JcaInstanceFactory(Class<T> cls) {
            this.clazz = (Class) Assert.notNull(cls, "Class argument cannot be null.");
        }

        public abstract T doGet(String str, Provider provider);

        public Provider findBouncyCastle() {
            return Providers.findBouncyCastle();
        }

        @Override // io.jsonwebtoken.impl.security.JcaTemplate.InstanceFactory
        public final T get(String str, Provider provider) {
            Provider findBouncyCastle;
            Assert.hasText(str, "jcaName cannot be null or empty.");
            Boolean bool = this.FALLBACK_ATTEMPTS.get(str);
            try {
                return doGet(str, (provider == null && bool != null && bool.booleanValue()) ? findBouncyCastle() : provider);
            } catch (NoSuchAlgorithmException e10) {
                if (provider == null && bool == null && (findBouncyCastle = findBouncyCastle()) != null) {
                    try {
                        T doGet = doGet(str, findBouncyCastle);
                        this.FALLBACK_ATTEMPTS.putIfAbsent(str, Boolean.TRUE);
                        return doGet;
                    } catch (Throwable unused) {
                        this.FALLBACK_ATTEMPTS.putIfAbsent(str, Boolean.FALSE);
                        throw wrap(e10, str, provider, null);
                    }
                }
                throw wrap(e10, str, provider, null);
            } catch (Exception e11) {
                throw wrap(e11, str, provider, null);
            }
        }

        @Override // io.jsonwebtoken.Identifiable
        public String getId() {
            return this.clazz.getSimpleName();
        }

        @Override // io.jsonwebtoken.impl.security.JcaTemplate.InstanceFactory
        public Class<T> getInstanceClass() {
            return this.clazz;
        }

        public Exception wrap(Exception exc, String str, Provider provider, Provider provider2) {
            String str2;
            String str3 = "Unable to obtain '" + str + "' " + getId() + " instance from ";
            if (provider != null) {
                str2 = str3 + "specified '" + provider + "' Provider";
            } else {
                str2 = str3 + "default JCA Provider";
            }
            if (provider2 != null) {
                str2 = str2 + " or fallback '" + provider2 + "' Provider";
            }
            return wrap(str2 + ": " + exc.getMessage(), exc);
        }

        public Exception wrap(String str, Exception exc) {
            if (!Signature.class.isAssignableFrom(this.clazz) && !Mac.class.isAssignableFrom(this.clazz)) {
                return new SecurityException(str, exc);
            }
            return new SignatureException(str, exc);
        }
    }

    private <T> T execute(Class<?> cls, CheckedSupplier<T> checkedSupplier) {
        try {
            return checkedSupplier.get();
        } catch (SecurityException e10) {
            throw e10;
        } catch (Throwable th) {
            throw new SecurityException(cls.getSimpleName() + " callback execution failed: " + th.getMessage(), th);
        }
    }

    private <T, R> R execute(final Class<T> cls, final CheckedFunction<T, R> checkedFunction) {
        return (R) execute((Class<?>) cls, (CheckedSupplier) new CheckedSupplier<R>() { // from class: io.jsonwebtoken.impl.security.JcaTemplate.2
            @Override // io.jsonwebtoken.impl.lang.CheckedSupplier
            public R get() {
                JcaTemplate jcaTemplate = JcaTemplate.this;
                return (R) jcaTemplate.execute(cls, checkedFunction, jcaTemplate.provider);
            }
        });
    }
}
