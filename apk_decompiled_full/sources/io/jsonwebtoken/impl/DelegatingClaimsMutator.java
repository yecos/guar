package io.jsonwebtoken.impl;

import io.jsonwebtoken.ClaimsMutator;
import io.jsonwebtoken.impl.lang.DelegatingMapMutator;
import io.jsonwebtoken.impl.lang.Parameter;
import io.jsonwebtoken.impl.lang.Parameters;
import io.jsonwebtoken.lang.Collections;
import io.jsonwebtoken.lang.MapMutator;
import io.jsonwebtoken.lang.Registry;
import io.jsonwebtoken.lang.Strings;
import java.util.Date;
import java.util.Map;
import java.util.Set;

/* loaded from: classes3.dex */
public class DelegatingClaimsMutator<T extends MapMutator<String, Object, T> & ClaimsMutator<T>> extends DelegatingMapMutator<String, Object, ParameterMap, T> implements ClaimsMutator<T> {
    private static final Parameter<String> AUDIENCE_STRING;

    static {
        Parameter<Set<String>> parameter = DefaultClaims.AUDIENCE;
        AUDIENCE_STRING = Parameters.string(parameter.getId(), parameter.getName());
    }

    public DelegatingClaimsMutator() {
        super(new ParameterMap(DefaultClaims.PARAMS));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Incorrect return type in method signature: (Ljava/lang/String;)TT; */
    public MapMutator audienceSingle(String str) {
        if (!Strings.hasText(str)) {
            return put((Parameter) DefaultClaims.AUDIENCE, (Object) null);
        }
        Parameter<String> parameter = AUDIENCE_STRING;
        remove(parameter.getId());
        setDelegate(((ParameterMap) this.DELEGATE).replace(parameter));
        return put((Parameter) parameter, (Object) str);
    }

    private Set<String> getAudience() {
        Registry<String, ? extends Parameter<?>> registry = ((ParameterMap) this.DELEGATE).PARAMS;
        Parameter parameter = AUDIENCE_STRING;
        if (!registry.get(parameter.getId()).supports(Collections.emptySet())) {
            String str = (String) get(parameter);
            remove(parameter.getId());
            ParameterMap parameterMap = (ParameterMap) this.DELEGATE;
            Parameter<Set<String>> parameter2 = DefaultClaims.AUDIENCE;
            setDelegate(parameterMap.replace(parameter2));
            put((Parameter) parameter2, (Object) Collections.setOf(str));
        }
        return (Set) get(DefaultClaims.AUDIENCE);
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [io.jsonwebtoken.lang.MapMutator] */
    @Override // io.jsonwebtoken.ClaimsMutator
    public ClaimsMutator.AudienceCollection<T> audience() {
        return new AbstractAudienceCollection<T>(self(), getAudience()) { // from class: io.jsonwebtoken.impl.DelegatingClaimsMutator.1
            @Override // io.jsonwebtoken.impl.lang.DefaultCollectionMutator
            public void changed() {
                DelegatingClaimsMutator.this.put((Parameter) DefaultClaims.AUDIENCE, (Object) Collections.asSet(getCollection()));
            }

            /* JADX WARN: Incorrect return type in method signature: (Ljava/lang/String;)TT; */
            @Override // io.jsonwebtoken.ClaimsMutator.AudienceCollection
            public MapMutator single(String str) {
                return DelegatingClaimsMutator.this.audienceSingle(str);
            }
        };
    }

    @Override // io.jsonwebtoken.ClaimsMutator
    public /* bridge */ /* synthetic */ ClaimsMutator expiration(Date date) {
        return (ClaimsMutator) m78expiration(date);
    }

    <F> F get(Parameter<F> parameter) {
        return (F) ((ParameterMap) this.DELEGATE).get((Parameter) parameter);
    }

    @Override // io.jsonwebtoken.ClaimsMutator
    public /* bridge */ /* synthetic */ ClaimsMutator id(String str) {
        return (ClaimsMutator) m79id(str);
    }

    @Override // io.jsonwebtoken.ClaimsMutator
    public /* bridge */ /* synthetic */ ClaimsMutator issuedAt(Date date) {
        return (ClaimsMutator) m80issuedAt(date);
    }

    @Override // io.jsonwebtoken.ClaimsMutator
    public /* bridge */ /* synthetic */ ClaimsMutator issuer(String str) {
        return (ClaimsMutator) m81issuer(str);
    }

    @Override // io.jsonwebtoken.ClaimsMutator
    public /* bridge */ /* synthetic */ ClaimsMutator notBefore(Date date) {
        return (ClaimsMutator) m82notBefore(date);
    }

    @Override // io.jsonwebtoken.impl.lang.DelegatingMap, java.util.Map
    public void putAll(Map<? extends String, ?> map) {
        if (map == null) {
            return;
        }
        for (Map.Entry<? extends String, ?> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // io.jsonwebtoken.ClaimsMutator
    public /* bridge */ /* synthetic */ ClaimsMutator setAudience(String str) {
        return (ClaimsMutator) m83setAudience(str);
    }

    @Override // io.jsonwebtoken.ClaimsMutator
    public /* bridge */ /* synthetic */ ClaimsMutator setExpiration(Date date) {
        return (ClaimsMutator) m84setExpiration(date);
    }

    @Override // io.jsonwebtoken.ClaimsMutator
    public /* bridge */ /* synthetic */ ClaimsMutator setId(String str) {
        return (ClaimsMutator) m85setId(str);
    }

    @Override // io.jsonwebtoken.ClaimsMutator
    public /* bridge */ /* synthetic */ ClaimsMutator setIssuedAt(Date date) {
        return (ClaimsMutator) m86setIssuedAt(date);
    }

    @Override // io.jsonwebtoken.ClaimsMutator
    public /* bridge */ /* synthetic */ ClaimsMutator setIssuer(String str) {
        return (ClaimsMutator) m87setIssuer(str);
    }

    @Override // io.jsonwebtoken.ClaimsMutator
    public /* bridge */ /* synthetic */ ClaimsMutator setNotBefore(Date date) {
        return (ClaimsMutator) m88setNotBefore(date);
    }

    @Override // io.jsonwebtoken.ClaimsMutator
    public /* bridge */ /* synthetic */ ClaimsMutator setSubject(String str) {
        return (ClaimsMutator) m89setSubject(str);
    }

    @Override // io.jsonwebtoken.ClaimsMutator
    public /* bridge */ /* synthetic */ ClaimsMutator subject(String str) {
        return (ClaimsMutator) m90subject(str);
    }

    /* JADX WARN: Incorrect return type in method signature: (Ljava/util/Date;)TT; */
    /* renamed from: expiration, reason: collision with other method in class */
    public MapMutator m78expiration(Date date) {
        return put((Parameter) DefaultClaims.EXPIRATION, (Object) date);
    }

    /* JADX WARN: Incorrect return type in method signature: (Ljava/lang/String;)TT; */
    /* renamed from: id, reason: collision with other method in class */
    public MapMutator m79id(String str) {
        return put((Parameter) DefaultClaims.JTI, (Object) str);
    }

    /* JADX WARN: Incorrect return type in method signature: (Ljava/util/Date;)TT; */
    /* renamed from: issuedAt, reason: collision with other method in class */
    public MapMutator m80issuedAt(Date date) {
        return put((Parameter) DefaultClaims.ISSUED_AT, (Object) date);
    }

    /* JADX WARN: Incorrect return type in method signature: (Ljava/lang/String;)TT; */
    /* renamed from: issuer, reason: collision with other method in class */
    public MapMutator m81issuer(String str) {
        return put((Parameter) DefaultClaims.ISSUER, (Object) str);
    }

    /* JADX WARN: Incorrect return type in method signature: (Ljava/util/Date;)TT; */
    /* renamed from: notBefore, reason: collision with other method in class */
    public MapMutator m82notBefore(Date date) {
        return put((Parameter) DefaultClaims.NOT_BEFORE, (Object) date);
    }

    /* JADX WARN: Incorrect return type in method signature: <F:Ljava/lang/Object;>(Lio/jsonwebtoken/impl/lang/Parameter<TF;>;TF;)TT; */
    /* JADX WARN: Type inference failed for: r2v1, types: [io.jsonwebtoken.lang.MapMutator] */
    public MapMutator put(Parameter parameter, Object obj) {
        ((ParameterMap) this.DELEGATE).put(parameter, obj);
        return self();
    }

    /* JADX WARN: Incorrect return type in method signature: (Ljava/lang/String;)TT; */
    /* renamed from: setAudience, reason: collision with other method in class */
    public MapMutator m83setAudience(String str) {
        return (MapMutator) audience().single(str);
    }

    /* JADX WARN: Incorrect return type in method signature: (Ljava/util/Date;)TT; */
    /* renamed from: setExpiration, reason: collision with other method in class */
    public MapMutator m84setExpiration(Date date) {
        return m78expiration(date);
    }

    /* JADX WARN: Incorrect return type in method signature: (Ljava/lang/String;)TT; */
    /* renamed from: setId, reason: collision with other method in class */
    public MapMutator m85setId(String str) {
        return m79id(str);
    }

    /* JADX WARN: Incorrect return type in method signature: (Ljava/util/Date;)TT; */
    /* renamed from: setIssuedAt, reason: collision with other method in class */
    public MapMutator m86setIssuedAt(Date date) {
        return m80issuedAt(date);
    }

    /* JADX WARN: Incorrect return type in method signature: (Ljava/lang/String;)TT; */
    /* renamed from: setIssuer, reason: collision with other method in class */
    public MapMutator m87setIssuer(String str) {
        return m81issuer(str);
    }

    /* JADX WARN: Incorrect return type in method signature: (Ljava/util/Date;)TT; */
    /* renamed from: setNotBefore, reason: collision with other method in class */
    public MapMutator m88setNotBefore(Date date) {
        return m82notBefore(date);
    }

    /* JADX WARN: Incorrect return type in method signature: (Ljava/lang/String;)TT; */
    /* renamed from: setSubject, reason: collision with other method in class */
    public MapMutator m89setSubject(String str) {
        return m90subject(str);
    }

    /* JADX WARN: Incorrect return type in method signature: (Ljava/lang/String;)TT; */
    /* renamed from: subject, reason: collision with other method in class */
    public MapMutator m90subject(String str) {
        return put((Parameter) DefaultClaims.SUBJECT, (Object) str);
    }

    @Override // io.jsonwebtoken.impl.lang.DelegatingMap, java.util.Map
    public Object put(String str, Object obj) {
        if (AUDIENCE_STRING.getId().equals(str)) {
            if (obj instanceof String) {
                Object obj2 = get(str);
                audience().single((String) obj);
                return obj2;
            }
            getAudience();
        }
        return super.put((DelegatingClaimsMutator<T>) str, (String) obj);
    }
}
