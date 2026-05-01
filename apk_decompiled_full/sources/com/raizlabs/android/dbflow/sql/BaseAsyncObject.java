package com.raizlabs.android.dbflow.sql;

import com.raizlabs.android.dbflow.config.DatabaseDefinition;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.structure.database.transaction.ITransaction;
import com.raizlabs.android.dbflow.structure.database.transaction.Transaction;

/* loaded from: classes3.dex */
public class BaseAsyncObject<TAsync> {
    private Transaction currentTransaction;
    private final DatabaseDefinition databaseDefinition;
    private Transaction.Error errorCallback;
    private Transaction.Success successCallback;
    private final Class<?> table;
    private final Transaction.Error error = new Transaction.Error() { // from class: com.raizlabs.android.dbflow.sql.BaseAsyncObject.1
        @Override // com.raizlabs.android.dbflow.structure.database.transaction.Transaction.Error
        public void onError(Transaction transaction, Throwable th) {
            if (BaseAsyncObject.this.errorCallback != null) {
                BaseAsyncObject.this.errorCallback.onError(transaction, th);
            }
            BaseAsyncObject.this.onError(transaction, th);
            BaseAsyncObject.this.currentTransaction = null;
        }
    };
    private final Transaction.Success success = new Transaction.Success() { // from class: com.raizlabs.android.dbflow.sql.BaseAsyncObject.2
        @Override // com.raizlabs.android.dbflow.structure.database.transaction.Transaction.Success
        public void onSuccess(Transaction transaction) {
            if (BaseAsyncObject.this.successCallback != null) {
                BaseAsyncObject.this.successCallback.onSuccess(transaction);
            }
            BaseAsyncObject.this.onSuccess(transaction);
            BaseAsyncObject.this.currentTransaction = null;
        }
    };

    public BaseAsyncObject(Class<?> cls) {
        this.table = cls;
        this.databaseDefinition = FlowManager.getDatabaseForTable(cls);
    }

    public void cancel() {
        Transaction transaction = this.currentTransaction;
        if (transaction != null) {
            transaction.cancel();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public TAsync error(Transaction.Error error) {
        this.errorCallback = error;
        return this;
    }

    public void executeTransaction(ITransaction iTransaction) {
        cancel();
        Transaction build = this.databaseDefinition.beginTransactionAsync(iTransaction).error(this.error).success(this.success).build();
        this.currentTransaction = build;
        build.execute();
    }

    public Class<?> getTable() {
        return this.table;
    }

    public void onError(Transaction transaction, Throwable th) {
    }

    public void onSuccess(Transaction transaction) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public TAsync success(Transaction.Success success) {
        this.successCallback = success;
        return this;
    }
}
