package io.jsonwebtoken.impl.lang;

import io.jsonwebtoken.lang.Arrays;
import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.lang.Objects;
import io.jsonwebtoken.lang.Registry;
import java.math.BigInteger;
import java.net.URI;
import java.security.MessageDigest;
import java.security.cert.X509Certificate;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/* loaded from: classes3.dex */
public final class Parameters {
    private Parameters() {
    }

    public static ParameterBuilder<BigInteger> bigInt(String str, String str2) {
        return builder(BigInteger.class).setConverter(Converters.BIGINT).setId(str).setName(str2);
    }

    public static <T> ParameterBuilder<T> builder(Class<T> cls) {
        return new DefaultParameterBuilder(cls);
    }

    public static ParameterBuilder<byte[]> bytes(String str, String str2) {
        return builder(byte[].class).setConverter(Converters.BASE64URL_BYTES).setId(str).setName(str2);
    }

    public static boolean bytesEquals(BigInteger bigInteger, BigInteger bigInteger2) {
        if (bigInteger == bigInteger2) {
            return true;
        }
        if (bigInteger == null || bigInteger2 == null) {
            return false;
        }
        byte[] bytes = bytes(bigInteger);
        byte[] bytes2 = bytes(bigInteger2);
        try {
            return MessageDigest.isEqual(bytes, bytes2);
        } finally {
            Bytes.clear(bytes);
            Bytes.clear(bytes2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static <T> boolean equals(T t10, T t11, Parameter<T> parameter) {
        if (t10 == t11) {
            return true;
        }
        if (t10 == 0 || t11 == 0) {
            return false;
        }
        if (parameter.isSecret()) {
            if (t10 instanceof byte[]) {
                return (t11 instanceof byte[]) && MessageDigest.isEqual((byte[]) t10, (byte[]) t11);
            }
            if (t10 instanceof BigInteger) {
                return (t11 instanceof BigInteger) && bytesEquals((BigInteger) t10, (BigInteger) t11);
            }
        }
        return Objects.nullSafeEquals(t10, t11);
    }

    public static Registry<String, Parameter<?>> registry(Parameter<?>... parameterArr) {
        return registry(Arrays.asList(parameterArr));
    }

    public static Registry<String, ? extends Parameter<?>> replace(Registry<String, ? extends Parameter<?>> registry, Parameter<?> parameter) {
        Assert.notEmpty(registry, "Registry cannot be null or empty.");
        Assert.notNull(parameter, "Parameter cannot be null.");
        String str = (String) Assert.hasText(parameter.getId(), "Parameter id cannot be null or empty.");
        LinkedHashMap linkedHashMap = new LinkedHashMap(registry);
        linkedHashMap.remove(str);
        linkedHashMap.put(str, parameter);
        return registry((Collection<Parameter<?>>) linkedHashMap.values());
    }

    public static Parameter<Date> rfcDate(String str, String str2) {
        return (Parameter) builder(Date.class).setConverter(JwtDateConverter.INSTANCE).setId(str).setName(str2).build();
    }

    public static Parameter<BigInteger> secretBigInt(String str, String str2) {
        return (Parameter) bigInt(str, str2).setSecret(true).build();
    }

    public static Parameter<String> string(String str, String str2) {
        return (Parameter) builder(String.class).setId(str).setName(str2).build();
    }

    public static Parameter<Set<String>> stringSet(String str, String str2) {
        return (Parameter) builder(String.class).set().setId(str).setName(str2).build();
    }

    public static Parameter<URI> uri(String str, String str2) {
        return (Parameter) builder(URI.class).setConverter(Converters.URI).setId(str).setName(str2).build();
    }

    public static Parameter<List<X509Certificate>> x509Chain(String str, String str2) {
        return (Parameter) builder(X509Certificate.class).setConverter(Converters.X509_CERTIFICATE).list().setId(str).setName(str2).build();
    }

    private static byte[] bytes(BigInteger bigInteger) {
        if (bigInteger != null) {
            return bigInteger.toByteArray();
        }
        return null;
    }

    public static Registry<String, Parameter<?>> registry(Collection<Parameter<?>> collection) {
        return new IdRegistry("Parameter", collection, true);
    }

    public static Registry<String, Parameter<?>> registry(Registry<String, Parameter<?>> registry, Parameter<?>... parameterArr) {
        LinkedHashSet linkedHashSet = new LinkedHashSet(registry.size() + parameterArr.length);
        linkedHashSet.addAll(registry.values());
        linkedHashSet.addAll(Arrays.asList(parameterArr));
        return new IdRegistry("Parameter", linkedHashSet, true);
    }

    public static <T> boolean equals(ParameterReadable parameterReadable, Object obj, Parameter<T> parameter) {
        if (parameterReadable == obj) {
            return true;
        }
        if (parameterReadable == null || !(obj instanceof ParameterReadable)) {
            return false;
        }
        return equals(parameterReadable.get(parameter), ((ParameterReadable) obj).get(parameter), parameter);
    }
}
