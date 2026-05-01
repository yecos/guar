package org.simpleframework.xml.strategy;

/* loaded from: classes2.dex */
public interface Value {
    int getLength();

    Class getType();

    Object getValue();

    boolean isReference();

    void setValue(Object obj);
}
