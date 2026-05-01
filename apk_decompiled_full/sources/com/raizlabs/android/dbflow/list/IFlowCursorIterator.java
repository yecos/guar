package com.raizlabs.android.dbflow.list;

import android.database.Cursor;
import java.io.Closeable;

/* loaded from: classes3.dex */
public interface IFlowCursorIterator<TModel> extends Closeable {
    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    Cursor cursor();

    long getCount();

    TModel getItem(long j10);

    FlowCursorIterator<TModel> iterator();

    FlowCursorIterator<TModel> iterator(int i10, long j10);
}
