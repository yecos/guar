package io.jsonwebtoken.impl.lang;

import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.lang.NestedCollection;
import java.util.Collection;

/* loaded from: classes3.dex */
public class DefaultNestedCollection<E, P> extends DefaultCollectionMutator<E, NestedCollection<E, P>> implements NestedCollection<E, P> {
    private final P parent;

    public DefaultNestedCollection(P p10, Collection<? extends E> collection) {
        super(collection);
        this.parent = (P) Assert.notNull(p10, "Parent cannot be null.");
    }

    @Override // io.jsonwebtoken.lang.Conjunctor
    public P and() {
        return this.parent;
    }
}
