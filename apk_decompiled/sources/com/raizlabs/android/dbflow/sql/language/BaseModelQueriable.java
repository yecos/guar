package com.raizlabs.android.dbflow.sql.language;

import com.raizlabs.android.dbflow.config.FlowLog;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.list.FlowCursorList;
import com.raizlabs.android.dbflow.list.FlowQueryList;
import com.raizlabs.android.dbflow.runtime.NotifyDistributor;
import com.raizlabs.android.dbflow.sql.Query;
import com.raizlabs.android.dbflow.sql.queriable.AsyncQuery;
import com.raizlabs.android.dbflow.sql.queriable.ListModelLoader;
import com.raizlabs.android.dbflow.sql.queriable.ModelQueriable;
import com.raizlabs.android.dbflow.sql.queriable.SingleModelLoader;
import com.raizlabs.android.dbflow.structure.InstanceAdapter;
import com.raizlabs.android.dbflow.structure.QueryModelAdapter;
import com.raizlabs.android.dbflow.structure.database.DatabaseStatement;
import com.raizlabs.android.dbflow.structure.database.DatabaseWrapper;
import java.util.List;

/* loaded from: classes3.dex */
public abstract class BaseModelQueriable<TModel> extends BaseQueriable<TModel> implements ModelQueriable<TModel>, Query {
    private boolean cachingEnabled;
    private InstanceAdapter<TModel> retrievalAdapter;

    public BaseModelQueriable(Class<TModel> cls) {
        super(cls);
        this.cachingEnabled = true;
    }

    private ListModelLoader<TModel> getListModelLoader() {
        return this.cachingEnabled ? getRetrievalAdapter().getListModelLoader() : getRetrievalAdapter().getNonCacheableListModelLoader();
    }

    private InstanceAdapter<TModel> getRetrievalAdapter() {
        if (this.retrievalAdapter == null) {
            this.retrievalAdapter = FlowManager.getInstanceAdapter(getTable());
        }
        return this.retrievalAdapter;
    }

    private SingleModelLoader<TModel> getSingleModelLoader() {
        return this.cachingEnabled ? getRetrievalAdapter().getSingleModelLoader() : getRetrievalAdapter().getNonCacheableSingleModelLoader();
    }

    @Override // com.raizlabs.android.dbflow.sql.queriable.ModelQueriable
    public AsyncQuery<TModel> async() {
        return new AsyncQuery<>(this);
    }

    @Override // com.raizlabs.android.dbflow.sql.queriable.ModelQueriable
    public FlowCursorList<TModel> cursorList() {
        return new FlowCursorList.Builder(getTable()).cacheModels(this.cachingEnabled).modelQueriable(this).build();
    }

    @Override // com.raizlabs.android.dbflow.sql.queriable.ModelQueriable
    public ModelQueriable<TModel> disableCaching() {
        this.cachingEnabled = false;
        return this;
    }

    @Override // com.raizlabs.android.dbflow.sql.queriable.Queriable
    public long executeUpdateDelete() {
        return executeUpdateDelete(FlowManager.getWritableDatabaseForTable(getTable()));
    }

    @Override // com.raizlabs.android.dbflow.sql.queriable.ModelQueriable
    public FlowQueryList<TModel> flowQueryList() {
        return new FlowQueryList.Builder(getTable()).cacheModels(this.cachingEnabled).modelQueriable(this).build();
    }

    @Override // com.raizlabs.android.dbflow.sql.queriable.ModelQueriable
    public <QueryClass> List<QueryClass> queryCustomList(Class<QueryClass> cls) {
        String query = getQuery();
        FlowLog.log(FlowLog.Level.V, "Executing query: " + query);
        QueryModelAdapter queryModelAdapter = FlowManager.getQueryModelAdapter(cls);
        return this.cachingEnabled ? queryModelAdapter.getListModelLoader().load(query) : queryModelAdapter.getNonCacheableListModelLoader().load(query);
    }

    @Override // com.raizlabs.android.dbflow.sql.queriable.ModelQueriable
    public <QueryClass> QueryClass queryCustomSingle(Class<QueryClass> cls) {
        String query = getQuery();
        FlowLog.log(FlowLog.Level.V, "Executing query: " + query);
        QueryModelAdapter queryModelAdapter = FlowManager.getQueryModelAdapter(cls);
        return this.cachingEnabled ? (QueryClass) queryModelAdapter.getSingleModelLoader().load(query) : (QueryClass) queryModelAdapter.getNonCacheableSingleModelLoader().load(query);
    }

    @Override // com.raizlabs.android.dbflow.sql.queriable.ModelQueriable
    public List<TModel> queryList() {
        String query = getQuery();
        FlowLog.log(FlowLog.Level.V, "Executing query: " + query);
        return getListModelLoader().load(query);
    }

    @Override // com.raizlabs.android.dbflow.sql.queriable.ModelQueriable
    public CursorResult<TModel> queryResults() {
        return new CursorResult<>(getRetrievalAdapter().getModelClass(), query());
    }

    @Override // com.raizlabs.android.dbflow.sql.queriable.ModelQueriable
    public TModel querySingle() {
        String query = getQuery();
        FlowLog.log(FlowLog.Level.V, "Executing query: " + query);
        return getSingleModelLoader().load(query);
    }

    @Override // com.raizlabs.android.dbflow.sql.queriable.Queriable
    public long executeUpdateDelete(DatabaseWrapper databaseWrapper) {
        DatabaseStatement compileStatement = databaseWrapper.compileStatement(getQuery());
        try {
            long executeUpdateDelete = compileStatement.executeUpdateDelete();
            if (executeUpdateDelete > 0) {
                NotifyDistributor.get().notifyTableChanged(getTable(), getPrimaryAction());
            }
            return executeUpdateDelete;
        } finally {
            compileStatement.close();
        }
    }

    @Override // com.raizlabs.android.dbflow.sql.queriable.ModelQueriable
    public List<TModel> queryList(DatabaseWrapper databaseWrapper) {
        String query = getQuery();
        FlowLog.log(FlowLog.Level.V, "Executing query: " + query);
        return getListModelLoader().load(databaseWrapper, query);
    }

    @Override // com.raizlabs.android.dbflow.sql.queriable.ModelQueriable
    public TModel querySingle(DatabaseWrapper databaseWrapper) {
        String query = getQuery();
        FlowLog.log(FlowLog.Level.V, "Executing query: " + query);
        return getSingleModelLoader().load(databaseWrapper, query);
    }
}
