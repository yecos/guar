package com.google.common.graph;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Iterator;
import java.util.Set;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* loaded from: classes2.dex */
interface GraphConnections<N, V> {
    void addPredecessor(N n10, V v10);

    @CanIgnoreReturnValue
    @CheckForNull
    V addSuccessor(N n10, V v10);

    Set<N> adjacentNodes();

    Iterator<EndpointPair<N>> incidentEdgeIterator(N n10);

    Set<N> predecessors();

    void removePredecessor(N n10);

    @CanIgnoreReturnValue
    @CheckForNull
    V removeSuccessor(N n10);

    Set<N> successors();

    @CheckForNull
    V value(N n10);
}
