package io.jsonwebtoken.impl.security;

import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.lang.Strings;
import io.jsonwebtoken.security.Curve;
import io.jsonwebtoken.security.KeyPairBuilder;
import java.security.Key;

/* loaded from: classes3.dex */
abstract class AbstractCurve implements Curve {
    private final String ID;
    private final String JCA_NAME;

    public AbstractCurve(String str, String str2) {
        this.ID = (String) Assert.notNull(Strings.clean(str), "Curve ID cannot be null or empty.");
        this.JCA_NAME = (String) Assert.notNull(Strings.clean(str2), "Curve jcaName cannot be null or empty.");
    }

    public abstract boolean contains(Key key);

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Curve) {
            return this.ID.equals(((Curve) obj).getId());
        }
        return false;
    }

    @Override // io.jsonwebtoken.Identifiable
    public String getId() {
        return this.ID;
    }

    public String getJcaName() {
        return this.JCA_NAME;
    }

    public int hashCode() {
        return this.ID.hashCode();
    }

    @Override // io.jsonwebtoken.security.KeyPairBuilderSupplier
    public KeyPairBuilder keyPair() {
        return new DefaultKeyPairBuilder(this.JCA_NAME);
    }

    public String toString() {
        return this.ID;
    }
}
