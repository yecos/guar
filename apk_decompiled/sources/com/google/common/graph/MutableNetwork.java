package com.google.common.graph;

import com.google.common.annotations.Beta;
import com.google.errorprone.annotations.CanIgnoreReturnValue;

@Beta
@ElementTypesAreNonnullByDefault
/* loaded from: classes2.dex */
public interface MutableNetwork<N, E> extends Network<N, E> {
    @CanIgnoreReturnValue
    boolean addEdge(EndpointPair<N> endpointPair, E e10);

    @CanIgnoreReturnValue
    boolean addEdge(N n10, N n11, E e10);

    @CanIgnoreReturnValue
    boolean addNode(N n10);

    @CanIgnoreReturnValue
    boolean removeEdge(E e10);

    @CanIgnoreReturnValue
    boolean removeNode(N n10);
}
