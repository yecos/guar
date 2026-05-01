package org.simpleframework.xml.transform;

/* loaded from: classes2.dex */
class DefaultMatcher implements Matcher {
    private Matcher matcher;
    private Matcher primitive = new PrimitiveMatcher();
    private Matcher stock = new PackageMatcher();
    private Matcher array = new ArrayMatcher(this);

    public DefaultMatcher(Matcher matcher) {
        this.matcher = matcher;
    }

    private Transform matchType(Class cls) {
        return cls.isArray() ? this.array.match(cls) : cls.isPrimitive() ? this.primitive.match(cls) : this.stock.match(cls);
    }

    @Override // org.simpleframework.xml.transform.Matcher
    public Transform match(Class cls) {
        Transform match = this.matcher.match(cls);
        return match != null ? match : matchType(cls);
    }
}
