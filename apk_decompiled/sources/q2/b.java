package q2;

import java.util.concurrent.ConcurrentLinkedQueue;

/* loaded from: classes.dex */
public class b extends ConcurrentLinkedQueue {
    @Override // java.util.concurrent.ConcurrentLinkedQueue, java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection, java.util.Queue
    public boolean add(Object obj) {
        return true;
    }

    @Override // java.util.concurrent.ConcurrentLinkedQueue, java.util.Queue
    public Object poll() {
        return null;
    }

    @Override // java.util.concurrent.ConcurrentLinkedQueue, java.util.AbstractCollection, java.util.Collection
    public boolean remove(Object obj) {
        return true;
    }
}
