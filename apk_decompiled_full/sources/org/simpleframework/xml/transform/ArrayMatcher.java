package org.simpleframework.xml.transform;

/* loaded from: classes2.dex */
class ArrayMatcher implements Matcher {
    private final Matcher primary;

    public ArrayMatcher(Matcher matcher) {
        this.primary = matcher;
    }

    private Transform matchArray(Class cls) {
        Transform match = this.primary.match(cls);
        if (match == null) {
            return null;
        }
        return new ArrayTransform(match, cls);
    }

    @Override // org.simpleframework.xml.transform.Matcher
    public Transform match(Class cls) {
        Class<?> componentType = cls.getComponentType();
        return componentType == Character.TYPE ? new CharacterArrayTransform(componentType) : componentType == Character.class ? new CharacterArrayTransform(componentType) : componentType == String.class ? new StringArrayTransform() : matchArray(componentType);
    }
}
