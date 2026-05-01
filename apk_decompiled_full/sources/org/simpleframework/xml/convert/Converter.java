package org.simpleframework.xml.convert;

import org.simpleframework.xml.stream.InputNode;
import org.simpleframework.xml.stream.OutputNode;

/* loaded from: classes2.dex */
public interface Converter<T> {
    T read(InputNode inputNode);

    void write(OutputNode outputNode, T t10);
}
