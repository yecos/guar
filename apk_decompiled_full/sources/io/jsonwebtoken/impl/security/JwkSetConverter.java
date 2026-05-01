package io.jsonwebtoken.impl.security;

import io.jsonwebtoken.impl.lang.Converter;
import io.jsonwebtoken.impl.lang.Parameter;
import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.lang.Collections;
import io.jsonwebtoken.lang.Supplier;
import io.jsonwebtoken.security.DynamicJwkBuilder;
import io.jsonwebtoken.security.Jwk;
import io.jsonwebtoken.security.JwkSet;
import io.jsonwebtoken.security.KeyException;
import io.jsonwebtoken.security.MalformedKeySetException;
import io.jsonwebtoken.security.UnsupportedKeyException;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/* loaded from: classes3.dex */
public class JwkSetConverter implements Converter<JwkSet, Object> {
    private final Converter<Jwk<?>, Object> JWK_CONVERTER;
    private final Parameter<Set<Jwk<?>>> PARAM;
    private final boolean ignoreUnsupported;

    public JwkSetConverter() {
        this((Supplier<DynamicJwkBuilder<?, ?>>) JwkBuilderSupplier.DEFAULT, true);
    }

    @Override // io.jsonwebtoken.impl.lang.Converter
    public Object applyTo(JwkSet jwkSet) {
        return jwkSet;
    }

    public boolean isIgnoreUnsupported() {
        return this.ignoreUnsupported;
    }

    public JwkSetConverter(boolean z10) {
        this(JwkBuilderSupplier.DEFAULT, z10);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00d4 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00f8 A[SYNTHETIC] */
    @Override // io.jsonwebtoken.impl.lang.Converter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public JwkSet applyFrom(Object obj) {
        Assert.notNull(obj, "Value cannot be null.");
        if (obj instanceof JwkSet) {
            return (JwkSet) obj;
        }
        if (!(obj instanceof Map)) {
            throw new IllegalArgumentException("Value must be a Map<String,?> (JSON Object). Type found: " + obj.getClass().getName() + ".");
        }
        Map map = (Map) obj;
        Map immutable = Collections.immutable(map);
        if (Collections.isEmpty((Map<?, ?>) immutable) || !immutable.containsKey(this.PARAM.getId())) {
            throw new MalformedKeySetException("Missing required " + this.PARAM + " parameter.");
        }
        Object obj2 = immutable.get(this.PARAM.getId());
        if (obj2 == null) {
            throw new MalformedKeySetException("JWK Set " + this.PARAM + " value cannot be null.");
        }
        if (obj2 instanceof Supplier) {
            obj2 = ((Supplier) obj2).get();
        }
        if (!(obj2 instanceof Collection)) {
            throw new MalformedKeySetException("JWK Set " + this.PARAM + " value must be a Collection (JSON Array). Type found: " + obj2.getClass().getName());
        }
        Collection collection = (Collection) obj2;
        int size = Collections.size((Collection<?>) collection);
        if (size == 0) {
            throw new MalformedKeySetException("JWK Set " + this.PARAM + " collection cannot be empty.");
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(Collections.size((Map<?, ?>) map));
        for (Map.Entry entry : map.entrySet()) {
            Object notNull = Assert.notNull(entry.getKey(), "JWK Set map key cannot be null.");
            if (!(notNull instanceof String)) {
                throw new IllegalArgumentException("JWK Set map keys must be Strings. Encountered key '" + notNull + "' of type " + notNull.getClass().getName());
            }
            linkedHashMap.put((String) notNull, entry.getValue());
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(size);
        Iterator it = collection.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            try {
                linkedHashSet.add(this.JWK_CONVERTER.applyFrom(it.next()));
            } catch (UnsupportedKeyException e10) {
                if (!this.ignoreUnsupported) {
                    throw new UnsupportedKeyException("JWK Set keys[" + i10 + "]: " + e10.getMessage(), e10);
                }
            } catch (KeyException e11) {
                e = e11;
                if (this.ignoreUnsupported) {
                    throw new MalformedKeySetException("JWK Set keys[" + i10 + "]: " + e.getMessage(), e);
                }
            } catch (IllegalArgumentException e12) {
                e = e12;
                if (this.ignoreUnsupported) {
                }
            }
            i10++;
        }
        linkedHashMap.remove(this.PARAM.getId());
        linkedHashMap.put(this.PARAM.getId(), linkedHashSet);
        return new DefaultJwkSet(this.PARAM, linkedHashMap);
    }

    public JwkSetConverter(Supplier<DynamicJwkBuilder<?, ?>> supplier, boolean z10) {
        this(new JwkConverter(supplier), z10);
    }

    public JwkSetConverter(Converter<Jwk<?>, Object> converter, boolean z10) {
        this.JWK_CONVERTER = (Converter) Assert.notNull(converter, "JWK converter cannot be null.");
        this.PARAM = DefaultJwkSet.param(converter);
        this.ignoreUnsupported = z10;
    }
}
