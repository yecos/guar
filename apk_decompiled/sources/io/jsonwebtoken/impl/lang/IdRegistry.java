package io.jsonwebtoken.impl.lang;

import io.jsonwebtoken.Identifiable;
import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.lang.Strings;
import java.util.Collection;

/* loaded from: classes3.dex */
public class IdRegistry<T extends Identifiable> extends StringRegistry<T> {
    public static final Function<Identifiable, String> FN = new Function<Identifiable, String>() { // from class: io.jsonwebtoken.impl.lang.IdRegistry.1
        @Override // io.jsonwebtoken.impl.lang.Function
        public String apply(Identifiable identifiable) {
            Assert.notNull(identifiable, "Identifiable argument cannot be null.");
            return (String) Assert.notNull(Strings.clean(identifiable.getId()), "Identifier cannot be null or empty.");
        }
    };

    public IdRegistry(String str, Collection<T> collection) {
        this(str, collection, true);
    }

    public static <T extends Identifiable> Function<T, String> fn() {
        return (Function<T, String>) FN;
    }

    public IdRegistry(String str, Collection<T> collection, boolean z10) {
        super(str, "id", Assert.notEmpty(collection, "Collection of Identifiable instances may not be null or empty."), fn(), z10);
    }
}
