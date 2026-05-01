package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;

/* loaded from: classes2.dex */
interface Extractor<T extends Annotation> {
    T[] getAnnotations();

    Label getLabel(T t10);

    Class getType(T t10);
}
