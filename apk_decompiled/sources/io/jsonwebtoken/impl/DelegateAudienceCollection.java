package io.jsonwebtoken.impl;

import io.jsonwebtoken.ClaimsMutator;
import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.lang.CollectionMutator;
import java.util.Collection;

/* loaded from: classes3.dex */
public class DelegateAudienceCollection<P> implements ClaimsMutator.AudienceCollection<P> {
    private final ClaimsMutator.AudienceCollection<?> delegate;
    private final P parent;

    public DelegateAudienceCollection(P p10, ClaimsMutator.AudienceCollection<?> audienceCollection) {
        this.parent = (P) Assert.notNull(p10, "Parent cannot be null.");
        this.delegate = (ClaimsMutator.AudienceCollection) Assert.notNull(audienceCollection, "Delegate cannot be null.");
    }

    @Override // io.jsonwebtoken.lang.Conjunctor
    public P and() {
        this.delegate.and();
        return this.parent;
    }

    @Override // io.jsonwebtoken.ClaimsMutator.AudienceCollection
    public P single(String str) {
        this.delegate.single(str);
        return this.parent;
    }

    @Override // io.jsonwebtoken.lang.CollectionMutator
    public /* bridge */ /* synthetic */ CollectionMutator add(Collection collection) {
        return add((Collection<? extends String>) collection);
    }

    @Override // io.jsonwebtoken.lang.CollectionMutator
    public ClaimsMutator.AudienceCollection<P> clear() {
        this.delegate.clear();
        return this;
    }

    @Override // io.jsonwebtoken.lang.CollectionMutator
    public ClaimsMutator.AudienceCollection<P> remove(String str) {
        this.delegate.remove(str);
        return this;
    }

    @Override // io.jsonwebtoken.lang.CollectionMutator
    public ClaimsMutator.AudienceCollection<P> add(String str) {
        this.delegate.add((ClaimsMutator.AudienceCollection<?>) str);
        return this;
    }

    @Override // io.jsonwebtoken.lang.CollectionMutator
    public ClaimsMutator.AudienceCollection<P> add(Collection<? extends String> collection) {
        this.delegate.add((Collection) collection);
        return this;
    }
}
