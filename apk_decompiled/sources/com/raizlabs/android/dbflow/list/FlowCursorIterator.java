package com.raizlabs.android.dbflow.list;

import android.database.Cursor;
import java.util.ConcurrentModificationException;
import java.util.ListIterator;

/* loaded from: classes3.dex */
public class FlowCursorIterator<TModel> implements ListIterator<TModel>, AutoCloseable {
    private long count;
    private final IFlowCursorIterator<TModel> cursorList;
    private long reverseIndex;
    private long startingCount;

    public FlowCursorIterator(IFlowCursorIterator<TModel> iFlowCursorIterator) {
        this(iFlowCursorIterator, 0, iFlowCursorIterator.getCount());
    }

    private void checkSizes() {
        if (this.startingCount != this.cursorList.getCount()) {
            throw new ConcurrentModificationException("Cannot change Cursor data during iteration.");
        }
    }

    @Override // java.util.ListIterator
    public void add(TModel tmodel) {
        throw new UnsupportedOperationException("Cursor Iterator: Cannot add a model in the iterator");
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        this.cursorList.close();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public boolean hasNext() {
        checkSizes();
        return this.reverseIndex > 0;
    }

    @Override // java.util.ListIterator
    public boolean hasPrevious() {
        checkSizes();
        return this.reverseIndex < this.count;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public TModel next() {
        checkSizes();
        TModel item = this.cursorList.getItem(this.count - this.reverseIndex);
        this.reverseIndex--;
        return item;
    }

    @Override // java.util.ListIterator
    public int nextIndex() {
        return (int) (this.reverseIndex + 1);
    }

    @Override // java.util.ListIterator
    public TModel previous() {
        checkSizes();
        TModel item = this.cursorList.getItem(this.count - this.reverseIndex);
        this.reverseIndex++;
        return item;
    }

    @Override // java.util.ListIterator
    public int previousIndex() {
        return (int) this.reverseIndex;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Cursor Iterator: cannot remove from an active Iterator ");
    }

    @Override // java.util.ListIterator
    public void set(TModel tmodel) {
        throw new UnsupportedOperationException("Cursor Iterator: cannot set on an active Iterator ");
    }

    public FlowCursorIterator(IFlowCursorIterator<TModel> iFlowCursorIterator, int i10) {
        this(iFlowCursorIterator, i10, iFlowCursorIterator.getCount() - i10);
    }

    public FlowCursorIterator(IFlowCursorIterator<TModel> iFlowCursorIterator, int i10, long j10) {
        this.cursorList = iFlowCursorIterator;
        this.count = j10;
        Cursor cursor = iFlowCursorIterator.cursor();
        if (cursor != null) {
            if (this.count > cursor.getCount() - i10) {
                this.count = cursor.getCount() - i10;
            }
            cursor.moveToPosition(i10 - 1);
            this.startingCount = iFlowCursorIterator.getCount();
            long j11 = this.count - i10;
            this.reverseIndex = j11;
            if (j11 < 0) {
                this.reverseIndex = 0L;
            }
        }
    }
}
