package com.raizlabs.android.dbflow.structure.database.transaction;

import com.raizlabs.android.dbflow.sql.language.CursorResult;
import com.raizlabs.android.dbflow.sql.queriable.ModelQueriable;
import com.raizlabs.android.dbflow.structure.database.DatabaseWrapper;
import java.util.List;

/* loaded from: classes3.dex */
public class QueryTransaction<TResult> implements ITransaction {
    final ModelQueriable<TResult> modelQueriable;
    final QueryResultCallback<TResult> queryResultCallback;
    final QueryResultListCallback<TResult> queryResultListCallback;
    final QueryResultSingleCallback<TResult> queryResultSingleCallback;
    final boolean runResultCallbacksOnSameThread;

    public static final class Builder<TResult> {
        final ModelQueriable<TResult> modelQueriable;
        QueryResultCallback<TResult> queryResultCallback;
        QueryResultListCallback<TResult> queryResultListCallback;
        QueryResultSingleCallback<TResult> queryResultSingleCallback;
        boolean runResultCallbacksOnSameThread;

        public Builder(ModelQueriable<TResult> modelQueriable) {
            this.modelQueriable = modelQueriable;
        }

        public QueryTransaction<TResult> build() {
            return new QueryTransaction<>(this);
        }

        public Builder<TResult> queryListResult(QueryResultListCallback<TResult> queryResultListCallback) {
            this.queryResultListCallback = queryResultListCallback;
            return this;
        }

        public Builder<TResult> queryResult(QueryResultCallback<TResult> queryResultCallback) {
            this.queryResultCallback = queryResultCallback;
            return this;
        }

        public Builder<TResult> querySingleResult(QueryResultSingleCallback<TResult> queryResultSingleCallback) {
            this.queryResultSingleCallback = queryResultSingleCallback;
            return this;
        }

        public Builder<TResult> runResultCallbacksOnSameThread(boolean z10) {
            this.runResultCallbacksOnSameThread = z10;
            return this;
        }
    }

    public interface QueryResultCallback<TResult> {
        void onQueryResult(QueryTransaction<TResult> queryTransaction, CursorResult<TResult> cursorResult);
    }

    public interface QueryResultListCallback<TResult> {
        void onListQueryResult(QueryTransaction queryTransaction, List<TResult> list);
    }

    public interface QueryResultSingleCallback<TResult> {
        void onSingleQueryResult(QueryTransaction queryTransaction, TResult tresult);
    }

    public QueryTransaction(Builder<TResult> builder) {
        this.modelQueriable = builder.modelQueriable;
        this.queryResultCallback = builder.queryResultCallback;
        this.queryResultListCallback = builder.queryResultListCallback;
        this.queryResultSingleCallback = builder.queryResultSingleCallback;
        this.runResultCallbacksOnSameThread = builder.runResultCallbacksOnSameThread;
    }

    @Override // com.raizlabs.android.dbflow.structure.database.transaction.ITransaction
    public void execute(DatabaseWrapper databaseWrapper) {
        final CursorResult<TResult> queryResults = this.modelQueriable.queryResults();
        QueryResultCallback<TResult> queryResultCallback = this.queryResultCallback;
        if (queryResultCallback != null) {
            if (this.runResultCallbacksOnSameThread) {
                queryResultCallback.onQueryResult(this, queryResults);
            } else {
                Transaction.getTransactionHandler().post(new Runnable() { // from class: com.raizlabs.android.dbflow.structure.database.transaction.QueryTransaction.1
                    @Override // java.lang.Runnable
                    public void run() {
                        QueryTransaction<TResult> queryTransaction = QueryTransaction.this;
                        queryTransaction.queryResultCallback.onQueryResult(queryTransaction, queryResults);
                    }
                });
            }
        }
        if (this.queryResultListCallback != null) {
            final List<TResult> listClose = queryResults.toListClose();
            if (this.runResultCallbacksOnSameThread) {
                this.queryResultListCallback.onListQueryResult(this, listClose);
            } else {
                Transaction.getTransactionHandler().post(new Runnable() { // from class: com.raizlabs.android.dbflow.structure.database.transaction.QueryTransaction.2
                    @Override // java.lang.Runnable
                    public void run() {
                        QueryTransaction queryTransaction = QueryTransaction.this;
                        queryTransaction.queryResultListCallback.onListQueryResult(queryTransaction, listClose);
                    }
                });
            }
        }
        if (this.queryResultSingleCallback != null) {
            final TResult modelClose = queryResults.toModelClose();
            if (this.runResultCallbacksOnSameThread) {
                this.queryResultSingleCallback.onSingleQueryResult(this, modelClose);
            } else {
                Transaction.getTransactionHandler().post(new Runnable() { // from class: com.raizlabs.android.dbflow.structure.database.transaction.QueryTransaction.3
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.lang.Runnable
                    public void run() {
                        QueryTransaction queryTransaction = QueryTransaction.this;
                        queryTransaction.queryResultSingleCallback.onSingleQueryResult(queryTransaction, modelClose);
                    }
                });
            }
        }
    }
}
