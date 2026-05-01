package com.raizlabs.android.dbflow.sql.queriable;

import com.raizlabs.android.dbflow.sql.BaseAsyncObject;
import com.raizlabs.android.dbflow.structure.database.transaction.QueryTransaction;

/* loaded from: classes3.dex */
public class AsyncQuery<TModel> extends BaseAsyncObject<AsyncQuery<TModel>> {
    private final ModelQueriable<TModel> modelQueriable;
    private QueryTransaction.QueryResultCallback<TModel> queryResultCallback;
    private QueryTransaction.QueryResultListCallback<TModel> queryResultListCallback;
    private QueryTransaction.QueryResultSingleCallback<TModel> queryResultSingleCallback;

    public AsyncQuery(ModelQueriable<TModel> modelQueriable) {
        super(modelQueriable.getTable());
        this.modelQueriable = modelQueriable;
    }

    public void execute() {
        executeTransaction(new QueryTransaction.Builder(this.modelQueriable).queryResult(this.queryResultCallback).queryListResult(this.queryResultListCallback).querySingleResult(this.queryResultSingleCallback).build());
    }

    @Override // com.raizlabs.android.dbflow.sql.BaseAsyncObject
    public Class<TModel> getTable() {
        return this.modelQueriable.getTable();
    }

    public AsyncQuery<TModel> queryListResultCallback(QueryTransaction.QueryResultListCallback<TModel> queryResultListCallback) {
        this.queryResultListCallback = queryResultListCallback;
        return this;
    }

    public AsyncQuery<TModel> queryResultCallback(QueryTransaction.QueryResultCallback<TModel> queryResultCallback) {
        this.queryResultCallback = queryResultCallback;
        return this;
    }

    public AsyncQuery<TModel> querySingleResultCallback(QueryTransaction.QueryResultSingleCallback<TModel> queryResultSingleCallback) {
        this.queryResultSingleCallback = queryResultSingleCallback;
        return this;
    }
}
