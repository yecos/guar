package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.Sets;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.SortedSet;
import javax.annotation.CheckForNull;

@GwtIncompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes2.dex */
public abstract class ForwardingNavigableSet<E> extends ForwardingSortedSet<E> implements NavigableSet<E> {

    @Beta
    public class StandardDescendingSet extends Sets.DescendingSet<E> {
        public StandardDescendingSet(ForwardingNavigableSet forwardingNavigableSet) {
            super(forwardingNavigableSet);
        }
    }

    @Override // java.util.NavigableSet
    @CheckForNull
    public E ceiling(@ParametricNullness E e10) {
        return delegate().ceiling(e10);
    }

    @Override // com.google.common.collect.ForwardingSortedSet, com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    public abstract NavigableSet<E> delegate();

    @Override // java.util.NavigableSet
    public Iterator<E> descendingIterator() {
        return delegate().descendingIterator();
    }

    @Override // java.util.NavigableSet
    public NavigableSet<E> descendingSet() {
        return delegate().descendingSet();
    }

    @Override // java.util.NavigableSet
    @CheckForNull
    public E floor(@ParametricNullness E e10) {
        return delegate().floor(e10);
    }

    @Override // java.util.NavigableSet
    public NavigableSet<E> headSet(@ParametricNullness E e10, boolean z10) {
        return delegate().headSet(e10, z10);
    }

    @Override // java.util.NavigableSet
    @CheckForNull
    public E higher(@ParametricNullness E e10) {
        return delegate().higher(e10);
    }

    @Override // java.util.NavigableSet
    @CheckForNull
    public E lower(@ParametricNullness E e10) {
        return delegate().lower(e10);
    }

    @Override // java.util.NavigableSet
    @CheckForNull
    public E pollFirst() {
        return delegate().pollFirst();
    }

    @Override // java.util.NavigableSet
    @CheckForNull
    public E pollLast() {
        return delegate().pollLast();
    }

    @CheckForNull
    public E standardCeiling(@ParametricNullness E e10) {
        return (E) Iterators.getNext(tailSet(e10, true).iterator(), null);
    }

    @ParametricNullness
    public E standardFirst() {
        return iterator().next();
    }

    @CheckForNull
    public E standardFloor(@ParametricNullness E e10) {
        return (E) Iterators.getNext(headSet(e10, true).descendingIterator(), null);
    }

    public SortedSet<E> standardHeadSet(@ParametricNullness E e10) {
        return headSet(e10, false);
    }

    @CheckForNull
    public E standardHigher(@ParametricNullness E e10) {
        return (E) Iterators.getNext(tailSet(e10, false).iterator(), null);
    }

    @ParametricNullness
    public E standardLast() {
        return descendingIterator().next();
    }

    @CheckForNull
    public E standardLower(@ParametricNullness E e10) {
        return (E) Iterators.getNext(headSet(e10, false).descendingIterator(), null);
    }

    @CheckForNull
    public E standardPollFirst() {
        return (E) Iterators.pollNext(iterator());
    }

    @CheckForNull
    public E standardPollLast() {
        return (E) Iterators.pollNext(descendingIterator());
    }

    @Beta
    public NavigableSet<E> standardSubSet(@ParametricNullness E e10, boolean z10, @ParametricNullness E e11, boolean z11) {
        return tailSet(e10, z10).headSet(e11, z11);
    }

    public SortedSet<E> standardTailSet(@ParametricNullness E e10) {
        return tailSet(e10, true);
    }

    @Override // java.util.NavigableSet
    public NavigableSet<E> subSet(@ParametricNullness E e10, boolean z10, @ParametricNullness E e11, boolean z11) {
        return delegate().subSet(e10, z10, e11, z11);
    }

    @Override // java.util.NavigableSet
    public NavigableSet<E> tailSet(@ParametricNullness E e10, boolean z10) {
        return delegate().tailSet(e10, z10);
    }

    @Override // com.google.common.collect.ForwardingSortedSet
    public SortedSet<E> standardSubSet(@ParametricNullness E e10, @ParametricNullness E e11) {
        return subSet(e10, true, e11, false);
    }
}
