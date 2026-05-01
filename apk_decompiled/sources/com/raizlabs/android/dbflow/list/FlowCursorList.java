package com.raizlabs.android.dbflow.list;

import android.database.Cursor;
import com.raizlabs.android.dbflow.config.FlowLog;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.sql.language.From;
import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.raizlabs.android.dbflow.sql.language.property.IProperty;
import com.raizlabs.android.dbflow.sql.queriable.ModelQueriable;
import com.raizlabs.android.dbflow.structure.InstanceAdapter;
import com.raizlabs.android.dbflow.structure.ModelAdapter;
import com.raizlabs.android.dbflow.structure.cache.ModelCache;
import com.raizlabs.android.dbflow.structure.cache.ModelLruCache;
import com.raizlabs.android.dbflow.structure.database.FlowCursor;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: classes3.dex */
public class FlowCursorList<TModel> implements Iterable<TModel>, IFlowCursorIterator<TModel> {
    public static final int DEFAULT_CACHE_SIZE = 50;
    public static final int MIN_CACHE_SIZE = 20;
    private boolean cacheModels;
    private FlowCursor cursor;
    private final Set<OnCursorRefreshListener<TModel>> cursorRefreshListenerSet;
    private InstanceAdapter<TModel> instanceAdapter;
    private ModelCache<TModel, ?> modelCache;
    private ModelQueriable<TModel> modelQueriable;
    private Class<TModel> table;

    public interface OnCursorRefreshListener<TModel> {
        void onCursorRefreshed(FlowCursorList<TModel> flowCursorList);
    }

    private void throwIfCursorClosed() {
        FlowCursor flowCursor = this.cursor;
        if (flowCursor != null && flowCursor.isClosed()) {
            throw new IllegalStateException("Cursor has been closed for FlowCursorList");
        }
    }

    private void warnEmptyCursor() {
        if (this.cursor == null) {
            FlowLog.log(FlowLog.Level.W, "Cursor was null for FlowCursorList");
        }
    }

    public void addOnCursorRefreshListener(OnCursorRefreshListener<TModel> onCursorRefreshListener) {
        synchronized (this.cursorRefreshListenerSet) {
            this.cursorRefreshListenerSet.add(onCursorRefreshListener);
        }
    }

    public boolean cachingEnabled() {
        return this.cacheModels;
    }

    public void clearCache() {
        if (this.cacheModels) {
            this.modelCache.clear();
        }
    }

    @Override // com.raizlabs.android.dbflow.list.IFlowCursorIterator, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        warnEmptyCursor();
        FlowCursor flowCursor = this.cursor;
        if (flowCursor != null) {
            flowCursor.close();
        }
        this.cursor = null;
    }

    @Override // com.raizlabs.android.dbflow.list.IFlowCursorIterator
    public Cursor cursor() {
        throwIfCursorClosed();
        warnEmptyCursor();
        return this.cursor;
    }

    public List<TModel> getAll() {
        throwIfCursorClosed();
        warnEmptyCursor();
        if (!this.cacheModels) {
            return this.cursor == null ? new ArrayList() : FlowManager.getModelAdapter(this.table).getListModelLoader().convertToData(this.cursor, (List) null);
        }
        ArrayList arrayList = new ArrayList();
        FlowCursorIterator<TModel> it = iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList;
    }

    @Override // com.raizlabs.android.dbflow.list.IFlowCursorIterator
    public long getCount() {
        throwIfCursorClosed();
        warnEmptyCursor();
        if (this.cursor != null) {
            return r0.getCount();
        }
        return 0L;
    }

    public InstanceAdapter<TModel> getInstanceAdapter() {
        return this.instanceAdapter;
    }

    @Override // com.raizlabs.android.dbflow.list.IFlowCursorIterator
    public TModel getItem(long j10) {
        FlowCursor flowCursor;
        throwIfCursorClosed();
        warnEmptyCursor();
        if (!this.cacheModels) {
            FlowCursor flowCursor2 = this.cursor;
            if (flowCursor2 == null || !flowCursor2.moveToPosition((int) j10)) {
                return null;
            }
            return this.instanceAdapter.getSingleModelLoader().convertToData(this.cursor, null, false);
        }
        TModel tmodel = this.modelCache.get(Long.valueOf(j10));
        if (tmodel != null || (flowCursor = this.cursor) == null || !flowCursor.moveToPosition((int) j10)) {
            return tmodel;
        }
        TModel convertToData = this.instanceAdapter.getSingleModelLoader().convertToData(this.cursor, null, false);
        this.modelCache.addModel(Long.valueOf(j10), convertToData);
        return convertToData;
    }

    public ModelAdapter<TModel> getModelAdapter() {
        return (ModelAdapter) this.instanceAdapter;
    }

    public boolean isEmpty() {
        throwIfCursorClosed();
        warnEmptyCursor();
        return getCount() == 0;
    }

    public ModelCache<TModel, ?> modelCache() {
        return this.modelCache;
    }

    public ModelQueriable<TModel> modelQueriable() {
        return this.modelQueriable;
    }

    public Builder<TModel> newBuilder() {
        return new Builder(this.table).modelQueriable(this.modelQueriable).cursor(this.cursor).cacheModels(this.cacheModels).modelCache(this.modelCache);
    }

    public synchronized void refresh() {
        warnEmptyCursor();
        FlowCursor flowCursor = this.cursor;
        if (flowCursor != null) {
            flowCursor.close();
        }
        ModelQueriable<TModel> modelQueriable = this.modelQueriable;
        if (modelQueriable == null) {
            throw new IllegalStateException("Cannot refresh this FlowCursorList. This list was instantiated from a Cursor. Once closed, we cannot reopen it. Construct a new instance and swap with this instance.");
        }
        this.cursor = modelQueriable.query();
        if (this.cacheModels) {
            this.modelCache.clear();
            setCacheModels(true);
        }
        synchronized (this.cursorRefreshListenerSet) {
            Iterator<OnCursorRefreshListener<TModel>> it = this.cursorRefreshListenerSet.iterator();
            while (it.hasNext()) {
                it.next().onCursorRefreshed(this);
            }
        }
    }

    public void removeOnCursorRefreshListener(OnCursorRefreshListener<TModel> onCursorRefreshListener) {
        synchronized (this.cursorRefreshListenerSet) {
            this.cursorRefreshListenerSet.remove(onCursorRefreshListener);
        }
    }

    public void setCacheModels(boolean z10) {
        this.cacheModels = z10;
        if (z10) {
            return;
        }
        clearCache();
    }

    public Class<TModel> table() {
        return this.table;
    }

    private FlowCursorList(Builder<TModel> builder) {
        this.cursorRefreshListenerSet = new HashSet();
        this.table = ((Builder) builder).modelClass;
        this.modelQueriable = ((Builder) builder).modelQueriable;
        if (((Builder) builder).modelQueriable == null) {
            FlowCursor flowCursor = ((Builder) builder).cursor;
            this.cursor = flowCursor;
            if (flowCursor == null) {
                From<TModel> from = SQLite.select(new IProperty[0]).from(this.table);
                this.modelQueriable = from;
                this.cursor = from.query();
            }
        } else {
            this.cursor = ((Builder) builder).modelQueriable.query();
        }
        boolean z10 = ((Builder) builder).cacheModels;
        this.cacheModels = z10;
        if (z10) {
            ModelCache<TModel, ?> modelCache = ((Builder) builder).modelCache;
            this.modelCache = modelCache;
            if (modelCache == null) {
                this.modelCache = ModelLruCache.newInstance(0);
            }
        }
        this.instanceAdapter = FlowManager.getInstanceAdapter(((Builder) builder).modelClass);
        setCacheModels(this.cacheModels);
    }

    @Override // java.lang.Iterable
    public FlowCursorIterator<TModel> iterator() {
        return new FlowCursorIterator<>(this);
    }

    public static class Builder<TModel> {
        private boolean cacheModels = true;
        private FlowCursor cursor;
        private ModelCache<TModel, ?> modelCache;
        private final Class<TModel> modelClass;
        private ModelQueriable<TModel> modelQueriable;

        public Builder(Class<TModel> cls) {
            this.modelClass = cls;
        }

        public FlowCursorList<TModel> build() {
            return new FlowCursorList<>(this);
        }

        public Builder<TModel> cacheModels(boolean z10) {
            this.cacheModels = z10;
            return this;
        }

        public Builder<TModel> cursor(Cursor cursor) {
            if (cursor != null) {
                this.cursor = FlowCursor.from(cursor);
            }
            return this;
        }

        public Builder<TModel> modelCache(ModelCache<TModel, ?> modelCache) {
            this.modelCache = modelCache;
            if (modelCache != null) {
                cacheModels(true);
            }
            return this;
        }

        public Builder<TModel> modelQueriable(ModelQueriable<TModel> modelQueriable) {
            this.modelQueriable = modelQueriable;
            return this;
        }

        public Builder(ModelQueriable<TModel> modelQueriable) {
            this.modelClass = modelQueriable.getTable();
            modelQueriable(modelQueriable);
        }
    }

    @Override // com.raizlabs.android.dbflow.list.IFlowCursorIterator
    public FlowCursorIterator<TModel> iterator(int i10, long j10) {
        return new FlowCursorIterator<>(this, i10, j10);
    }
}
