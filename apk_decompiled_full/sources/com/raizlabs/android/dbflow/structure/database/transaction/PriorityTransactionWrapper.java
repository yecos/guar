package com.raizlabs.android.dbflow.structure.database.transaction;

import com.raizlabs.android.dbflow.structure.database.DatabaseWrapper;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes3.dex */
public class PriorityTransactionWrapper implements ITransaction, Comparable<PriorityTransactionWrapper> {
    public static final int PRIORITY_HIGH = 2;
    public static final int PRIORITY_LOW = 0;
    public static final int PRIORITY_NORMAL = 1;
    public static final int PRIORITY_UI = 5;
    private final int priority;
    private final ITransaction transaction;

    public static class Builder {
        private int priority;
        private final ITransaction transaction;

        public Builder(ITransaction iTransaction) {
            this.transaction = iTransaction;
        }

        public PriorityTransactionWrapper build() {
            return new PriorityTransactionWrapper(this);
        }

        public Builder priority(int i10) {
            this.priority = i10;
            return this;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface Priority {
    }

    public PriorityTransactionWrapper(Builder builder) {
        if (builder.priority == 0) {
            this.priority = 1;
        } else {
            this.priority = builder.priority;
        }
        this.transaction = builder.transaction;
    }

    @Override // com.raizlabs.android.dbflow.structure.database.transaction.ITransaction
    public void execute(DatabaseWrapper databaseWrapper) {
        this.transaction.execute(databaseWrapper);
    }

    @Override // java.lang.Comparable
    public int compareTo(PriorityTransactionWrapper priorityTransactionWrapper) {
        return priorityTransactionWrapper.priority - this.priority;
    }
}
