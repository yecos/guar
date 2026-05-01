package io.jsonwebtoken.impl.security;

import io.jsonwebtoken.Identifiable;
import io.jsonwebtoken.impl.X509Context;
import io.jsonwebtoken.impl.lang.Nameable;
import io.jsonwebtoken.impl.lang.Parameter;
import io.jsonwebtoken.impl.lang.ParameterReadable;
import io.jsonwebtoken.security.HashAlgorithm;
import io.jsonwebtoken.security.KeyOperation;
import java.security.Key;
import java.security.Provider;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* loaded from: classes3.dex */
public interface JwkContext<K extends Key> extends Identifiable, Map<String, Object>, ParameterReadable, Nameable, X509Context<JwkContext<K>> {
    String getAlgorithm();

    HashAlgorithm getIdThumbprintAlgorithm();

    K getKey();

    Set<KeyOperation> getOperations();

    Provider getProvider();

    PublicKey getPublicKey();

    String getPublicKeyUse();

    SecureRandom getRandom();

    String getType();

    boolean isSigUse();

    JwkContext<K> parameter(Parameter<?> parameter);

    JwkContext<K> setAlgorithm(String str);

    JwkContext<K> setId(String str);

    JwkContext<K> setIdThumbprintAlgorithm(HashAlgorithm hashAlgorithm);

    JwkContext<K> setKey(K k10);

    JwkContext<K> setOperations(Collection<? extends KeyOperation> collection);

    JwkContext<K> setProvider(Provider provider);

    JwkContext<K> setPublicKey(PublicKey publicKey);

    JwkContext<K> setPublicKeyUse(String str);

    JwkContext<K> setRandom(SecureRandom secureRandom);

    JwkContext<K> setType(String str);
}
