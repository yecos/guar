package com.raizlabs.android.dbflow.structure.database.transaction;

import android.os.Handler;
import android.os.Looper;
import com.raizlabs.android.dbflow.config.DatabaseDefinition;
import com.raizlabs.android.dbflow.config.FlowLog;

/* loaded from: classes3.dex */
public final class Transaction {
    private static Handler TRANSACTION_HANDLER;
    final DatabaseDefinition databaseDefinition;
    final Error errorCallback;
    final String name;
    final boolean runCallbacksOnSameThread;
    final boolean shouldRunInTransaction;
    final Success successCallback;
    final ITransaction transaction;

    public static final class Builder {
        final DatabaseDefinition databaseDefinition;
        Error errorCallback;
        String name;
        private boolean runCallbacksOnSameThread;
        boolean shouldRunInTransaction = true;
        Success successCallback;
        final ITransaction transaction;

        public Builder(ITransaction iTransaction, DatabaseDefinition databaseDefinition) {
            this.transaction = iTransaction;
            this.databaseDefinition = databaseDefinition;
        }

        public Transaction build() {
            return new Transaction(this);
        }

        public Builder error(Error error) {
            this.errorCallback = error;
            return this;
        }

        public void execute() {
            build().execute();
        }

        public Builder name(String str) {
            this.name = str;
            return this;
        }

        public Builder runCallbacksOnSameThread(boolean z10) {
            this.runCallbacksOnSameThread = z10;
            return this;
        }

        public Builder shouldRunInTransaction(boolean z10) {
            this.shouldRunInTransaction = z10;
            return this;
        }

        public Builder success(Success success) {
            this.successCallback = success;
            return this;
        }
    }

    public interface Error {
        void onError(Transaction transaction, Throwable th);
    }

    public interface Success {
        void onSuccess(Transaction transaction);
    }

    public Transaction(Builder builder) {
        this.databaseDefinition = builder.databaseDefinition;
        this.errorCallback = builder.errorCallback;
        this.successCallback = builder.successCallback;
        this.transaction = builder.transaction;
        this.name = builder.name;
        this.shouldRunInTransaction = builder.shouldRunInTransaction;
        this.runCallbacksOnSameThread = builder.runCallbacksOnSameThread;
    }

    public static Handler getTransactionHandler() {
        if (TRANSACTION_HANDLER == null) {
            TRANSACTION_HANDLER = new Handler(Looper.getMainLooper());
        }
        return TRANSACTION_HANDLER;
    }

    public void cancel() {
        this.databaseDefinition.getTransactionManager().cancelTransaction(this);
    }

    public Error error() {
        return this.errorCallback;
    }

    public void execute() {
        this.databaseDefinition.getTransactionManager().addTransaction(this);
    }

    public void executeSync() {
        try {
            if (this.shouldRunInTransaction) {
                this.databaseDefinition.executeTransaction(this.transaction);
            } else {
                this.transaction.execute(this.databaseDefinition.getWritableDatabase());
            }
            Success success = this.successCallback;
            if (success != null) {
                if (this.runCallbacksOnSameThread) {
                    success.onSuccess(this);
                } else {
                    getTransactionHandler().post(new Runnable() { // from class: com.raizlabs.android.dbflow.structure.database.transaction.Transaction.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Transaction transaction = Transaction.this;
                            transaction.successCallback.onSuccess(transaction);
                        }
                    });
                }
            }
        } catch (Throwable th) {
            FlowLog.logError(th);
            Error error = this.errorCallback;
            if (error == null) {
                throw new RuntimeException("An exception occurred while executing a transaction", th);
            }
            if (this.runCallbacksOnSameThread) {
                error.onError(this, th);
            } else {
                getTransactionHandler().post(new Runnable() { // from class: com.raizlabs.android.dbflow.structure.database.transaction.Transaction.2
                    @Override // java.lang.Runnable
                    public void run() {
                        Transaction transaction = Transaction.this;
                        transaction.errorCallback.onError(transaction, th);
                    }
                });
            }
        }
    }

    public String name() {
        return this.name;
    }

    public Builder newBuilder() {
        return new Builder(this.transaction, this.databaseDefinition).error(this.errorCallback).success(this.successCallback).name(this.name).shouldRunInTransaction(this.shouldRunInTransaction).runCallbacksOnSameThread(this.runCallbacksOnSameThread);
    }

    public Success success() {
        return this.successCallback;
    }

    public ITransaction transaction() {
        return this.transaction;
    }
}
