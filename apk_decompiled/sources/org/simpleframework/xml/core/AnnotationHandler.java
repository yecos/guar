package org.simpleframework.xml.core;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/* loaded from: classes2.dex */
class AnnotationHandler implements InvocationHandler {
    private static final String ATTRIBUTE = "attribute";
    private static final String CLASS = "annotationType";
    private static final String EQUAL = "equals";
    private static final String REQUIRED = "required";
    private static final String STRING = "toString";
    private final boolean attribute;
    private final Comparer comparer;
    private final boolean required;
    private final Class type;

    public AnnotationHandler(Class cls) {
        this(cls, true);
    }

    private void attributes(StringBuilder sb) {
        Method[] declaredMethods = this.type.getDeclaredMethods();
        for (int i10 = 0; i10 < declaredMethods.length; i10++) {
            String name = declaredMethods[i10].getName();
            Object value = value(declaredMethods[i10]);
            if (i10 > 0) {
                sb.append(ASCIIPropertyListParser.ARRAY_ITEM_DELIMITER_TOKEN);
                sb.append(' ');
            }
            sb.append(name);
            sb.append(ASCIIPropertyListParser.DICTIONARY_ASSIGN_TOKEN);
            sb.append(value);
        }
        sb.append(ASCIIPropertyListParser.ARRAY_END_TOKEN);
    }

    private boolean equals(Object obj, Object[] objArr) {
        Annotation annotation = (Annotation) obj;
        Annotation annotation2 = (Annotation) objArr[0];
        if (annotation.annotationType() == annotation2.annotationType()) {
            return this.comparer.equals(annotation, annotation2);
        }
        throw new PersistenceException("Annotation %s is not the same as %s", annotation, annotation2);
    }

    private void name(StringBuilder sb) {
        String name = this.type.getName();
        sb.append('@');
        sb.append(name);
        sb.append(ASCIIPropertyListParser.ARRAY_BEGIN_TOKEN);
    }

    private Object value(Method method) {
        String name = method.getName();
        return name.equals(REQUIRED) ? Boolean.valueOf(this.required) : name.equals(ATTRIBUTE) ? Boolean.valueOf(this.attribute) : method.getDefaultValue();
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) {
        String name = method.getName();
        return name.equals(STRING) ? toString() : name.equals(EQUAL) ? Boolean.valueOf(equals(obj, objArr)) : name.equals(CLASS) ? this.type : name.equals(REQUIRED) ? Boolean.valueOf(this.required) : name.equals(ATTRIBUTE) ? Boolean.valueOf(this.attribute) : method.getDefaultValue();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.type != null) {
            name(sb);
            attributes(sb);
        }
        return sb.toString();
    }

    public AnnotationHandler(Class cls, boolean z10) {
        this(cls, z10, false);
    }

    public AnnotationHandler(Class cls, boolean z10, boolean z11) {
        this.comparer = new Comparer();
        this.attribute = z11;
        this.required = z10;
        this.type = cls;
    }
}
