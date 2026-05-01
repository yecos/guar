package com.raizlabs.android.dbflow.runtime;

import com.raizlabs.android.dbflow.config.DatabaseDefinition;
import com.raizlabs.android.dbflow.config.FlowLog;
import com.raizlabs.android.dbflow.structure.database.transaction.ITransactionQueue;
import com.raizlabs.android.dbflow.structure.database.transaction.Transaction;

/* loaded from: classes3.dex */
public abstract class BaseTransactionManager {
    private DBBatchSaveQueue saveQueue;
    private final ITransactionQueue transactionQueue;

    public BaseTransactionManager(ITransactionQueue iTransactionQueue, DatabaseDefinition databaseDefinition) {
        this.transactionQueue = iTransactionQueue;
        this.saveQueue = new DBBatchSaveQueue(databaseDefinition);
        checkQueue();
    }

    public void addTransaction(Transaction transaction) {
        getQueue().add(transaction);
    }

    public void cancelTransaction(Transaction transaction) {
        getQueue().cancel(transaction);
    }

    public void checkQueue() {
        getQueue().startIfNotAlive();
    }

    public ITransactionQueue getQueue() {
        return this.transactionQueue;
    }

    public DBBatchSaveQueue getSaveQueue() {
        try {
            if (!this.saveQueue.isAlive()) {
                this.saveQueue.start();
            }
        } catch (IllegalThreadStateException e10) {
            FlowLog.logError(e10);
        }
        return this.saveQueue;
    }

    public void stopQueue() {
        getQueue().quit();
    }
}
