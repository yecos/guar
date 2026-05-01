package org.simpleframework.xml.core;

import org.simpleframework.xml.stream.InputNode;

/* loaded from: classes2.dex */
interface Repeater extends Converter {
    @Override // org.simpleframework.xml.core.Converter
    Object read(InputNode inputNode, Object obj);
}
