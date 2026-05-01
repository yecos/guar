package com.raizlabs.android.dbflow.sql.language;

import android.database.Cursor;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.list.FlowCursorIterator;
import com.raizlabs.android.dbflow.list.IFlowCursorIterator;
import com.raizlabs.android.dbflow.structure.InstanceAdapter;
import com.raizlabs.android.dbflow.structure.database.FlowCursor;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class CursorResult<TModel> implements IFlowCursorIterator<TModel> {
    private FlowCursor cursor;
    private final InstanceAdapter<TModel> retrievalAdapter;

    public CursorResult(Class<TModel> cls, Cursor cursor) {
        if (cursor != null) {
            this.cursor = FlowCursor.from(cursor);
        }
        this.retrievalAdapter = FlowManager.getInstanceAdapter(cls);
    }

    @Override // com.raizlabs.android.dbflow.list.IFlowCursorIterator, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        FlowCursor flowCursor = this.cursor;
        if (flowCursor != null) {
            flowCursor.close();
        }
    }

    @Override // com.raizlabs.android.dbflow.list.IFlowCursorIterator
    public Cursor cursor() {
        return this.cursor;
    }

    @Override // com.raizlabs.android.dbflow.list.IFlowCursorIterator
    public long getCount() {
        if (this.cursor == null) {
            return 0L;
        }
        return r0.getCount();
    }

    @Override // com.raizlabs.android.dbflow.list.IFlowCursorIterator
    public TModel getItem(long j10) {
        FlowCursor flowCursor = this.cursor;
        if (flowCursor == null || !flowCursor.moveToPosition((int) j10)) {
            return null;
        }
        return this.retrievalAdapter.getSingleModelLoader().convertToData(this.cursor, null, false);
    }

    @Override // com.raizlabs.android.dbflow.list.IFlowCursorIterator
    public FlowCursorIterator<TModel> iterator() {
        return new FlowCursorIterator<>(this);
    }

    public void swapCursor(FlowCursor flowCursor) {
        FlowCursor flowCursor2 = this.cursor;
        if (flowCursor2 != null && !flowCursor2.isClosed()) {
            this.cursor.close();
        }
        this.cursor = flowCursor;
    }

    public <TCustom> List<TCustom> toCustomList(Class<TCustom> cls) {
        return this.cursor != null ? FlowManager.getQueryModelAdapter(cls).getListModelLoader().convertToData(this.cursor, (List<TQueryModel>) null) : new ArrayList();
    }

    public <TCustom> List<TCustom> toCustomListClose(Class<TCustom> cls) {
        List<TCustom> load = this.cursor != null ? FlowManager.getQueryModelAdapter(cls).getListModelLoader().load(this.cursor) : new ArrayList<>();
        close();
        return load;
    }

    public <TCustom> TCustom toCustomModel(Class<TCustom> cls) {
        if (this.cursor != null) {
            return (TCustom) FlowManager.getQueryModelAdapter(cls).getSingleModelLoader().convertToData(this.cursor, null);
        }
        return null;
    }

    public <TCustom> TCustom toCustomModelClose(Class<TCustom> cls) {
        TCustom tcustom = this.cursor != null ? (TCustom) FlowManager.getQueryModelAdapter(cls).getSingleModelLoader().load(this.cursor) : null;
        close();
        return tcustom;
    }

    public List<TModel> toList() {
        return this.cursor != null ? this.retrievalAdapter.getListModelLoader().convertToData(this.cursor, (List) null) : new ArrayList();
    }

    public List<TModel> toListClose() {
        List<TModel> load = this.cursor != null ? this.retrievalAdapter.getListModelLoader().load(this.cursor) : new ArrayList<>();
        close();
        return load;
    }

    public TModel toModel() {
        if (this.cursor != null) {
            return this.retrievalAdapter.getSingleModelLoader().convertToData(this.cursor, null);
        }
        return null;
    }

    public TModel toModelClose() {
        TModel load = this.cursor != null ? this.retrievalAdapter.getSingleModelLoader().load(this.cursor) : null;
        close();
        return load;
    }

    @Override // com.raizlabs.android.dbflow.list.IFlowCursorIterator
    public FlowCursorIterator<TModel> iterator(int i10, long j10) {
        return new FlowCursorIterator<>(this, i10, j10);
    }
}
