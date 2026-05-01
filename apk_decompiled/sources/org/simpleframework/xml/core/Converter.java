package org.simpleframework.xml.core;

import org.simpleframework.xml.stream.InputNode;
import org.simpleframework.xml.stream.OutputNode;

/* loaded from: classes2.dex */
interface Converter {
    Object read(InputNode inputNode);

    Object read(InputNode inputNode, Object obj);

    boolean validate(InputNode inputNode);

    void write(OutputNode outputNode, Object obj);
}
