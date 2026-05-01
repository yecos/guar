package com.raizlabs.android.dbflow.list;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import com.raizlabs.android.dbflow.StringUtils;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.list.FlowCursorList;
import com.raizlabs.android.dbflow.runtime.FlowContentObserver;
import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.raizlabs.android.dbflow.sql.queriable.ModelQueriable;
import com.raizlabs.android.dbflow.structure.InstanceAdapter;
import com.raizlabs.android.dbflow.structure.ModelAdapter;
import com.raizlabs.android.dbflow.structure.cache.ModelCache;
import com.raizlabs.android.dbflow.structure.database.DatabaseWrapper;
import com.raizlabs.android.dbflow.structure.database.transaction.ProcessModelTransaction;
import com.raizlabs.android.dbflow.structure.database.transaction.QueryTransaction;
import com.raizlabs.android.dbflow.structure.database.transaction.Transaction;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/* loaded from: classes3.dex */
public class FlowQueryList<TModel> extends FlowContentObserver implements List<TModel>, IFlowCursorIterator<TModel> {
    private static final Handler REFRESH_HANDLER = new Handler(Looper.myLooper());
    private boolean changeInTransaction;
    private final ProcessModelTransaction.ProcessModel<TModel> deleteModel;
    private final Transaction.Error errorCallback;
    private final FlowCursorList<TModel> internalCursorList;
    private final Transaction.Error internalErrorCallback;
    private final Transaction.Success internalSuccessCallback;
    private boolean pendingRefresh;
    private final Runnable refreshRunnable;
    private final ProcessModelTransaction.ProcessModel<TModel> saveModel;
    private final Transaction.Success successCallback;
    private boolean transact;
    private final ProcessModelTransaction.ProcessModel<TModel> updateModel;

    public static class Builder<TModel> {
        private boolean cacheModels;
        private boolean changeInTransaction;
        private String contentAuthority;
        private Cursor cursor;
        private Transaction.Error error;
        private ModelCache<TModel, ?> modelCache;
        private ModelQueriable<TModel> modelQueriable;
        private Transaction.Success success;
        private final Class<TModel> table;
        private boolean transact;

        public FlowQueryList<TModel> build() {
            return new FlowQueryList<>(this);
        }

        public Builder<TModel> cacheModels(boolean z10) {
            this.cacheModels = z10;
            return this;
        }

        public Builder<TModel> changeInTransaction(boolean z10) {
            this.changeInTransaction = z10;
            return this;
        }

        public Builder<TModel> contentAuthority(String str) {
            this.contentAuthority = str;
            return this;
        }

        public Builder<TModel> cursor(Cursor cursor) {
            this.cursor = cursor;
            return this;
        }

        public Builder<TModel> error(Transaction.Error error) {
            this.error = error;
            return this;
        }

        public Builder<TModel> modelCache(ModelCache<TModel, ?> modelCache) {
            this.modelCache = modelCache;
            return this;
        }

        public Builder<TModel> modelQueriable(ModelQueriable<TModel> modelQueriable) {
            this.modelQueriable = modelQueriable;
            return this;
        }

        public Builder<TModel> success(Transaction.Success success) {
            this.success = success;
            return this;
        }

        public Builder<TModel> transact(boolean z10) {
            this.transact = z10;
            return this;
        }

        private Builder(FlowCursorList<TModel> flowCursorList) {
            this.cacheModels = true;
            this.table = flowCursorList.table();
            this.cursor = flowCursorList.cursor();
            this.cacheModels = flowCursorList.cachingEnabled();
            this.modelQueriable = flowCursorList.modelQueriable();
            this.modelCache = flowCursorList.modelCache();
        }

        public Builder(Class<TModel> cls) {
            this.cacheModels = true;
            this.table = cls;
        }

        public Builder(ModelQueriable<TModel> modelQueriable) {
            this(modelQueriable.getTable());
            modelQueriable(modelQueriable);
        }
    }

    @Override // java.util.List
    public void add(int i10, TModel tmodel) {
        add(tmodel);
    }

    @Override // java.util.List
    public boolean addAll(int i10, Collection<? extends TModel> collection) {
        return addAll(collection);
    }

    public void addOnCursorRefreshListener(FlowCursorList.OnCursorRefreshListener<TModel> onCursorRefreshListener) {
        this.internalCursorList.addOnCursorRefreshListener(onCursorRefreshListener);
    }

    public boolean changeInTransaction() {
        return this.changeInTransaction;
    }

    @Override // java.util.List, java.util.Collection
    public void clear() {
        Transaction build = FlowManager.getDatabaseForTable(this.internalCursorList.table()).beginTransactionAsync(new QueryTransaction.Builder(SQLite.delete().from(this.internalCursorList.table())).build()).error(this.internalErrorCallback).success(this.internalSuccessCallback).build();
        if (this.transact) {
            build.execute();
        } else {
            build.executeSync();
        }
    }

    @Override // com.raizlabs.android.dbflow.list.IFlowCursorIterator, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.internalCursorList.close();
    }

    @Override // java.util.List, java.util.Collection
    public boolean contains(Object obj) {
        if (obj == null || !this.internalCursorList.table().isAssignableFrom(obj.getClass())) {
            return false;
        }
        return this.internalCursorList.getInstanceAdapter().exists(obj);
    }

    @Override // java.util.List, java.util.Collection
    public boolean containsAll(Collection<?> collection) {
        boolean z10 = !collection.isEmpty();
        if (!z10) {
            return z10;
        }
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return z10;
    }

    @Override // com.raizlabs.android.dbflow.list.IFlowCursorIterator
    public Cursor cursor() {
        return this.internalCursorList.cursor();
    }

    public FlowCursorList<TModel> cursorList() {
        return this.internalCursorList;
    }

    @Override // com.raizlabs.android.dbflow.runtime.FlowContentObserver
    public void endTransactionAndNotify() {
        if (this.changeInTransaction) {
            this.changeInTransaction = false;
            refresh();
        }
        super.endTransactionAndNotify();
    }

    public Transaction.Error error() {
        return this.errorCallback;
    }

    @Override // java.util.List
    public TModel get(int i10) {
        return this.internalCursorList.getItem(i10);
    }

    public List<TModel> getCopy() {
        return this.internalCursorList.getAll();
    }

    @Override // com.raizlabs.android.dbflow.list.IFlowCursorIterator
    public long getCount() {
        return this.internalCursorList.getCount();
    }

    public InstanceAdapter<TModel> getInstanceAdapter() {
        return this.internalCursorList.getInstanceAdapter();
    }

    @Override // com.raizlabs.android.dbflow.list.IFlowCursorIterator
    public TModel getItem(long j10) {
        return this.internalCursorList.getItem(j10);
    }

    public ModelAdapter<TModel> getModelAdapter() {
        return this.internalCursorList.getModelAdapter();
    }

    @Override // java.util.List
    public int indexOf(Object obj) {
        throw new UnsupportedOperationException("We cannot determine which index in the table this item exists at efficiently");
    }

    @Override // java.util.List, java.util.Collection
    public boolean isEmpty() {
        return this.internalCursorList.isEmpty();
    }

    @Override // java.util.List
    public int lastIndexOf(Object obj) {
        throw new UnsupportedOperationException("We cannot determine which index in the table this item exists at efficiently");
    }

    @Override // java.util.List
    public ListIterator<TModel> listIterator() {
        return new FlowCursorIterator(this);
    }

    public Builder<TModel> newBuilder() {
        return new Builder(this.internalCursorList).success(this.successCallback).error(this.errorCallback).changeInTransaction(this.changeInTransaction).transact(this.transact);
    }

    @Override // com.raizlabs.android.dbflow.runtime.FlowContentObserver, android.database.ContentObserver
    public void onChange(boolean z10) {
        super.onChange(z10);
        if (this.isInTransaction) {
            this.changeInTransaction = true;
        } else {
            refreshAsync();
        }
    }

    public void refresh() {
        this.internalCursorList.refresh();
    }

    public void refreshAsync() {
        synchronized (this) {
            if (this.pendingRefresh) {
                return;
            }
            this.pendingRefresh = true;
            REFRESH_HANDLER.post(this.refreshRunnable);
        }
    }

    public void registerForContentChanges(Context context) {
        super.registerForContentChanges(context, this.internalCursorList.table());
    }

    @Override // java.util.List
    public TModel remove(int i10) {
        TModel item = this.internalCursorList.getItem(i10);
        Transaction build = FlowManager.getDatabaseForTable(this.internalCursorList.table()).beginTransactionAsync(new ProcessModelTransaction.Builder(this.deleteModel).add(item).build()).error(this.internalErrorCallback).success(this.internalSuccessCallback).build();
        if (this.transact) {
            build.execute();
        } else {
            build.executeSync();
        }
        return item;
    }

    @Override // java.util.List, java.util.Collection
    public boolean removeAll(Collection<?> collection) {
        Transaction build = FlowManager.getDatabaseForTable(this.internalCursorList.table()).beginTransactionAsync(new ProcessModelTransaction.Builder(this.deleteModel).addAll(collection).build()).error(this.internalErrorCallback).success(this.internalSuccessCallback).build();
        if (this.transact) {
            build.execute();
            return true;
        }
        build.executeSync();
        return true;
    }

    public void removeOnCursorRefreshListener(FlowCursorList.OnCursorRefreshListener<TModel> onCursorRefreshListener) {
        this.internalCursorList.removeOnCursorRefreshListener(onCursorRefreshListener);
    }

    @Override // java.util.List, java.util.Collection
    public boolean retainAll(Collection<?> collection) {
        List<TModel> all = this.internalCursorList.getAll();
        all.removeAll(collection);
        Transaction build = FlowManager.getDatabaseForTable(this.internalCursorList.table()).beginTransactionAsync(new ProcessModelTransaction.Builder(all, this.deleteModel).build()).error(this.internalErrorCallback).success(this.internalSuccessCallback).build();
        if (this.transact) {
            build.execute();
            return true;
        }
        build.executeSync();
        return true;
    }

    @Override // java.util.List
    public TModel set(int i10, TModel tmodel) {
        return set(tmodel);
    }

    @Override // java.util.List, java.util.Collection
    public int size() {
        return (int) this.internalCursorList.getCount();
    }

    @Override // java.util.List
    public List<TModel> subList(int i10, int i11) {
        return this.internalCursorList.getAll().subList(i10, i11);
    }

    public Transaction.Success success() {
        return this.successCallback;
    }

    @Override // java.util.List, java.util.Collection
    public Object[] toArray() {
        return this.internalCursorList.getAll().toArray();
    }

    public boolean transact() {
        return this.transact;
    }

    private FlowQueryList(Builder<TModel> builder) {
        super(StringUtils.isNotNullOrEmpty(((Builder) builder).contentAuthority) ? ((Builder) builder).contentAuthority : FlowManager.DEFAULT_AUTHORITY);
        this.transact = false;
        this.changeInTransaction = false;
        this.pendingRefresh = false;
        this.saveModel = new ProcessModelTransaction.ProcessModel<TModel>() { // from class: com.raizlabs.android.dbflow.list.FlowQueryList.1
            @Override // com.raizlabs.android.dbflow.structure.database.transaction.ProcessModelTransaction.ProcessModel
            public void processModel(TModel tmodel, DatabaseWrapper databaseWrapper) {
                FlowQueryList.this.getModelAdapter().save(tmodel);
            }
        };
        this.updateModel = new ProcessModelTransaction.ProcessModel<TModel>() { // from class: com.raizlabs.android.dbflow.list.FlowQueryList.2
            @Override // com.raizlabs.android.dbflow.structure.database.transaction.ProcessModelTransaction.ProcessModel
            public void processModel(TModel tmodel, DatabaseWrapper databaseWrapper) {
                FlowQueryList.this.getModelAdapter().update(tmodel);
            }
        };
        this.deleteModel = new ProcessModelTransaction.ProcessModel<TModel>() { // from class: com.raizlabs.android.dbflow.list.FlowQueryList.3
            @Override // com.raizlabs.android.dbflow.structure.database.transaction.ProcessModelTransaction.ProcessModel
            public void processModel(TModel tmodel, DatabaseWrapper databaseWrapper) {
                FlowQueryList.this.getModelAdapter().delete(tmodel);
            }
        };
        this.internalErrorCallback = new Transaction.Error() { // from class: com.raizlabs.android.dbflow.list.FlowQueryList.4
            @Override // com.raizlabs.android.dbflow.structure.database.transaction.Transaction.Error
            public void onError(Transaction transaction, Throwable th) {
                if (FlowQueryList.this.errorCallback != null) {
                    FlowQueryList.this.errorCallback.onError(transaction, th);
                }
            }
        };
        this.internalSuccessCallback = new Transaction.Success() { // from class: com.raizlabs.android.dbflow.list.FlowQueryList.5
            @Override // com.raizlabs.android.dbflow.structure.database.transaction.Transaction.Success
            public void onSuccess(Transaction transaction) {
                if (((FlowContentObserver) FlowQueryList.this).isInTransaction) {
                    FlowQueryList.this.changeInTransaction = true;
                } else {
                    FlowQueryList.this.refreshAsync();
                }
                if (FlowQueryList.this.successCallback != null) {
                    FlowQueryList.this.successCallback.onSuccess(transaction);
                }
            }
        };
        this.refreshRunnable = new Runnable() { // from class: com.raizlabs.android.dbflow.list.FlowQueryList.6
            @Override // java.lang.Runnable
            public void run() {
                synchronized (this) {
                    FlowQueryList.this.pendingRefresh = false;
                }
                FlowQueryList.this.refresh();
            }
        };
        this.transact = ((Builder) builder).transact;
        this.changeInTransaction = ((Builder) builder).changeInTransaction;
        this.successCallback = ((Builder) builder).success;
        this.errorCallback = ((Builder) builder).error;
        this.internalCursorList = new FlowCursorList.Builder(((Builder) builder).table).cursor(((Builder) builder).cursor).cacheModels(((Builder) builder).cacheModels).modelQueriable(((Builder) builder).modelQueriable).modelCache(((Builder) builder).modelCache).build();
    }

    @Override // java.util.List, java.util.Collection
    public boolean add(TModel tmodel) {
        if (tmodel == null) {
            return false;
        }
        Transaction build = FlowManager.getDatabaseForTable(this.internalCursorList.table()).beginTransactionAsync(new ProcessModelTransaction.Builder(this.saveModel).add(tmodel).build()).error(this.internalErrorCallback).success(this.internalSuccessCallback).build();
        if (this.transact) {
            build.execute();
            return true;
        }
        build.executeSync();
        return true;
    }

    @Override // java.util.List, java.util.Collection
    public boolean addAll(Collection<? extends TModel> collection) {
        Transaction build = FlowManager.getDatabaseForTable(this.internalCursorList.table()).beginTransactionAsync(new ProcessModelTransaction.Builder(this.saveModel).addAll(collection).build()).error(this.internalErrorCallback).success(this.internalSuccessCallback).build();
        if (this.transact) {
            build.execute();
            return true;
        }
        build.executeSync();
        return true;
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public FlowCursorIterator<TModel> iterator() {
        return new FlowCursorIterator<>(this);
    }

    @Override // java.util.List
    public ListIterator<TModel> listIterator(int i10) {
        return new FlowCursorIterator(this, i10);
    }

    @Override // com.raizlabs.android.dbflow.runtime.FlowContentObserver
    public void registerForContentChanges(Context context, Class<?> cls) {
        throw new RuntimeException("This method is not to be used in the FlowQueryList. We should only ever receive notifications for one class here. Call registerForContentChanges(Context) instead");
    }

    public TModel set(TModel tmodel) {
        Transaction build = FlowManager.getDatabaseForTable(this.internalCursorList.table()).beginTransactionAsync(new ProcessModelTransaction.Builder(this.updateModel).add(tmodel).build()).error(this.internalErrorCallback).success(this.internalSuccessCallback).build();
        if (this.transact) {
            build.execute();
        } else {
            build.executeSync();
        }
        return tmodel;
    }

    @Override // com.raizlabs.android.dbflow.list.IFlowCursorIterator
    public FlowCursorIterator<TModel> iterator(int i10, long j10) {
        return new FlowCursorIterator<>(this, i10, j10);
    }

    @Override // java.util.List, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        return (T[]) this.internalCursorList.getAll().toArray(tArr);
    }

    @Override // com.raizlabs.android.dbflow.runtime.FlowContentObserver, android.database.ContentObserver
    public void onChange(boolean z10, Uri uri) {
        super.onChange(z10, uri);
        if (!this.isInTransaction) {
            refreshAsync();
        } else {
            this.changeInTransaction = true;
        }
    }

    @Override // java.util.List, java.util.Collection
    public boolean remove(Object obj) {
        if (!this.internalCursorList.table().isAssignableFrom(obj.getClass())) {
            return false;
        }
        Transaction build = FlowManager.getDatabaseForTable(this.internalCursorList.table()).beginTransactionAsync(new ProcessModelTransaction.Builder(this.deleteModel).add(obj).build()).error(this.internalErrorCallback).success(this.internalSuccessCallback).build();
        if (this.transact) {
            build.execute();
        } else {
            build.executeSync();
        }
        return true;
    }
}
