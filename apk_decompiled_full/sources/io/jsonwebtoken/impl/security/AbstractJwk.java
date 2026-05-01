package io.jsonwebtoken.impl.security;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import io.jsonwebtoken.JwsHeader;
import io.jsonwebtoken.impl.io.Streams;
import io.jsonwebtoken.impl.lang.Nameable;
import io.jsonwebtoken.impl.lang.Parameter;
import io.jsonwebtoken.impl.lang.ParameterReadable;
import io.jsonwebtoken.impl.lang.Parameters;
import io.jsonwebtoken.lang.Arrays;
import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.lang.Collections;
import io.jsonwebtoken.lang.Objects;
import io.jsonwebtoken.lang.Strings;
import io.jsonwebtoken.lang.Supplier;
import io.jsonwebtoken.security.HashAlgorithm;
import io.jsonwebtoken.security.Jwk;
import io.jsonwebtoken.security.JwkThumbprint;
import io.jsonwebtoken.security.Jwks;
import io.jsonwebtoken.security.KeyOperation;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes3.dex */
public abstract class AbstractJwk<K extends Key> implements Jwk<K>, ParameterReadable, Nameable {
    static final Parameter<String> ALG;
    public static final String IMMUTABLE_MSG = "JWKs are immutable and may not be modified.";
    static final Parameter<Set<KeyOperation>> KEY_OPS;
    public static final Parameter<String> KID;
    static final Parameter<String> KTY;
    static final Set<Parameter<?>> PARAMS;
    private final List<Parameter<?>> THUMBPRINT_PARAMS;
    protected final JwkContext<K> context;
    private final int hashCode;

    static {
        Parameter<String> string = Parameters.string("alg", "Algorithm");
        ALG = string;
        Parameter<String> string2 = Parameters.string(JwsHeader.KEY_ID, "Key ID");
        KID = string2;
        Parameter<Set<KeyOperation>> parameter = (Parameter) Parameters.builder(KeyOperation.class).setConverter(KeyOperationConverter.DEFAULT).set().setId("key_ops").setName("Key Operations").build();
        KEY_OPS = parameter;
        Parameter<String> string3 = Parameters.string("kty", "Key Type");
        KTY = string3;
        PARAMS = Collections.setOf(string, string2, parameter, string3);
    }

    public AbstractJwk(JwkContext<K> jwkContext, List<Parameter<?>> list) {
        this.context = (JwkContext) Assert.notNull(jwkContext, "JwkContext cannot be null.");
        Assert.isTrue(!jwkContext.isEmpty(), "JwkContext cannot be empty.");
        Assert.hasText(jwkContext.getType(), "JwkContext type cannot be null or empty.");
        Assert.notNull(jwkContext.getKey(), "JwkContext key cannot be null.");
        this.THUMBPRINT_PARAMS = (List) Assert.notEmpty(list, "JWK Thumbprint parameters cannot be null or empty.");
        HashAlgorithm idThumbprintAlgorithm = jwkContext.getIdThumbprintAlgorithm();
        if (!Strings.hasText(getId()) && idThumbprintAlgorithm != null) {
            jwkContext.setId(thumbprint(idThumbprintAlgorithm).toString());
        }
        this.hashCode = computeHashCode();
    }

    private int computeHashCode() {
        ArrayList arrayList = new ArrayList(this.THUMBPRINT_PARAMS.size() + 1);
        Key key = (Key) Assert.notNull(toKey(), "JWK toKey() value cannot be null.");
        if (key instanceof PublicKey) {
            arrayList.add("Public");
        } else if (key instanceof PrivateKey) {
            arrayList.add("Private");
        }
        Iterator<Parameter<?>> it = this.THUMBPRINT_PARAMS.iterator();
        while (it.hasNext()) {
            arrayList.add(Assert.notNull(get((Parameter) it.next()), "computeHashCode: Parameter idiomatic value cannot be null."));
        }
        return Objects.nullSafeHashCode(arrayList.toArray());
    }

    private String getRequiredThumbprintValue(Parameter<?> parameter) {
        Object obj = get(parameter.getId());
        if (obj instanceof Supplier) {
            obj = ((Supplier) obj).get();
        }
        return (String) Assert.isInstanceOf(String.class, obj, "Parameter canonical value is not a String.");
    }

    private static Object immutable() {
        throw new UnsupportedOperationException(IMMUTABLE_MSG);
    }

    private String toThumbprintJson() {
        StringBuilder sb = new StringBuilder();
        sb.append(ASCIIPropertyListParser.DICTIONARY_BEGIN_TOKEN);
        Iterator<Parameter<?>> it = this.THUMBPRINT_PARAMS.iterator();
        while (it.hasNext()) {
            Parameter<?> next = it.next();
            String requiredThumbprintValue = getRequiredThumbprintValue(next);
            sb.append('\"');
            sb.append(next.getId());
            sb.append("\":\"");
            sb.append(requiredThumbprintValue);
            sb.append('\"');
            if (it.hasNext()) {
                sb.append(",");
            }
        }
        sb.append(ASCIIPropertyListParser.DICTIONARY_END_TOKEN);
        return sb.toString();
    }

    @Override // java.util.Map
    public void clear() {
        immutable();
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return this.context.containsKey(obj);
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        return this.context.containsValue(obj);
    }

    @Override // java.util.Map
    public Set<Map.Entry<String, Object>> entrySet() {
        return Collections.immutable((Set) this.context.entrySet());
    }

    public abstract boolean equals(Jwk<?> jwk);

    @Override // java.util.Map
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Jwk)) {
            return false;
        }
        Jwk<?> jwk = (Jwk) obj;
        return getType().equals(jwk.getType()) && equals(jwk);
    }

    @Override // java.util.Map
    public Object get(Object obj) {
        Object obj2 = this.context.get(obj);
        return obj2 instanceof Map ? Collections.immutable((Map) obj2) : obj2 instanceof Collection ? Collections.immutable((Collection) obj2) : Objects.isArray(obj2) ? Arrays.copy(obj2) : obj2;
    }

    @Override // io.jsonwebtoken.security.Jwk
    public String getAlgorithm() {
        return this.context.getAlgorithm();
    }

    @Override // io.jsonwebtoken.Identifiable
    public String getId() {
        return this.context.getId();
    }

    @Override // io.jsonwebtoken.impl.lang.Nameable
    public String getName() {
        return this.context.getName();
    }

    @Override // io.jsonwebtoken.security.Jwk
    public Set<KeyOperation> getOperations() {
        return Collections.immutable((Set) this.context.getOperations());
    }

    @Override // io.jsonwebtoken.security.Jwk
    public String getType() {
        return this.context.getType();
    }

    @Override // java.util.Map
    public final int hashCode() {
        return this.hashCode;
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return this.context.isEmpty();
    }

    @Override // java.util.Map
    public Set<String> keySet() {
        return Collections.immutable((Set) this.context.keySet());
    }

    @Override // java.util.Map
    public void putAll(Map<? extends String, ? extends Object> map) {
        immutable();
    }

    @Override // java.util.Map
    public Object remove(Object obj) {
        return immutable();
    }

    @Override // java.util.Map
    public int size() {
        return this.context.size();
    }

    @Override // io.jsonwebtoken.security.Jwk
    public JwkThumbprint thumbprint() {
        return thumbprint(Jwks.HASH.SHA256);
    }

    @Override // io.jsonwebtoken.security.Jwk
    public K toKey() {
        return this.context.getKey();
    }

    public String toString() {
        return this.context.toString();
    }

    @Override // java.util.Map
    public Collection<Object> values() {
        return Collections.immutable(this.context.values());
    }

    @Override // java.util.Map
    public Object put(String str, Object obj) {
        return immutable();
    }

    @Override // io.jsonwebtoken.security.Jwk
    public JwkThumbprint thumbprint(HashAlgorithm hashAlgorithm) {
        String thumbprintJson = toThumbprintJson();
        Assert.hasText(thumbprintJson, "Canonical JWK Thumbprint JSON cannot be null or empty.");
        return new DefaultJwkThumbprint(hashAlgorithm.digest(new DefaultRequest(Streams.of(thumbprintJson.getBytes(StandardCharsets.UTF_8)), this.context.getProvider(), this.context.getRandom())), hashAlgorithm);
    }

    @Override // io.jsonwebtoken.impl.lang.ParameterReadable
    public <T> T get(Parameter<T> parameter) {
        return (T) this.context.get((Parameter) parameter);
    }
}
