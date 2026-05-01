package org.simpleframework.xml.core;

/* loaded from: classes2.dex */
interface Instance {
    Object getInstance();

    Class getType();

    boolean isReference();

    Object setInstance(Object obj);
}
