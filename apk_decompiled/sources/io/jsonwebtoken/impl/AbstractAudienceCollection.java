package io.jsonwebtoken.impl;

import io.jsonwebtoken.ClaimsMutator;
import io.jsonwebtoken.impl.lang.DefaultNestedCollection;
import java.util.Collection;

/* loaded from: classes3.dex */
abstract class AbstractAudienceCollection<P> extends DefaultNestedCollection<String, P> implements ClaimsMutator.AudienceCollection<P> {
    public AbstractAudienceCollection(P p10, Collection<? extends String> collection) {
        super(p10, collection);
    }
}
