package com.raizlabs.android.dbflow.structure.database.transaction;

import android.os.Looper;
import android.os.Process;
import com.raizlabs.android.dbflow.config.FlowLog;
import com.raizlabs.android.dbflow.structure.database.transaction.PriorityTransactionWrapper;
import java.util.Iterator;
import java.util.concurrent.PriorityBlockingQueue;

/* loaded from: classes3.dex */
public class PriorityTransactionQueue extends Thread implements ITransactionQueue {
    private boolean isQuitting;
    private final PriorityBlockingQueue<PriorityEntry<Transaction>> queue;

    public class PriorityEntry<E extends Transaction> implements Comparable<PriorityEntry<Transaction>> {
        final E entry;
        final PriorityTransactionWrapper transactionWrapper;

        public PriorityEntry(E e10) {
            this.entry = e10;
            if (e10.transaction() instanceof PriorityTransactionWrapper) {
                this.transactionWrapper = (PriorityTransactionWrapper) e10.transaction();
            } else {
                this.transactionWrapper = new PriorityTransactionWrapper.Builder(e10.transaction()).build();
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            PriorityTransactionWrapper priorityTransactionWrapper = this.transactionWrapper;
            PriorityTransactionWrapper priorityTransactionWrapper2 = ((PriorityEntry) obj).transactionWrapper;
            return priorityTransactionWrapper != null ? priorityTransactionWrapper.equals(priorityTransactionWrapper2) : priorityTransactionWrapper2 == null;
        }

        public E getEntry() {
            return this.entry;
        }

        public int hashCode() {
            PriorityTransactionWrapper priorityTransactionWrapper = this.transactionWrapper;
            if (priorityTransactionWrapper != null) {
                return priorityTransactionWrapper.hashCode();
            }
            return 0;
        }

        @Override // java.lang.Comparable
        public int compareTo(PriorityEntry<Transaction> priorityEntry) {
            return this.transactionWrapper.compareTo(priorityEntry.transactionWrapper);
        }
    }

    public PriorityTransactionQueue(String str) {
        super(str);
        this.isQuitting = false;
        this.queue = new PriorityBlockingQueue<>();
    }

    private void throwInvalidTransactionType(Transaction transaction) {
        StringBuilder sb = new StringBuilder();
        sb.append("Transaction of type:");
        sb.append(transaction != null ? transaction.transaction().getClass() : "Unknown");
        sb.append(" should be of type PriorityTransactionWrapper");
        throw new IllegalArgumentException(sb.toString());
    }

    @Override // com.raizlabs.android.dbflow.structure.database.transaction.ITransactionQueue
    public void add(Transaction transaction) {
        synchronized (this.queue) {
            PriorityEntry<Transaction> priorityEntry = new PriorityEntry<>(transaction);
            if (!this.queue.contains(priorityEntry)) {
                this.queue.add(priorityEntry);
            }
        }
    }

    @Override // com.raizlabs.android.dbflow.structure.database.transaction.ITransactionQueue
    public void cancel(Transaction transaction) {
        synchronized (this.queue) {
            PriorityEntry priorityEntry = new PriorityEntry(transaction);
            if (this.queue.contains(priorityEntry)) {
                this.queue.remove(priorityEntry);
            }
        }
    }

    @Override // com.raizlabs.android.dbflow.structure.database.transaction.ITransactionQueue
    public void quit() {
        this.isQuitting = true;
        interrupt();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Looper.prepare();
        Process.setThreadPriority(10);
        while (true) {
            try {
                this.queue.take().entry.executeSync();
            } catch (InterruptedException unused) {
                if (this.isQuitting) {
                    synchronized (this.queue) {
                        this.queue.clear();
                        return;
                    }
                }
            }
        }
    }

    @Override // com.raizlabs.android.dbflow.structure.database.transaction.ITransactionQueue
    public void startIfNotAlive() {
        synchronized (this) {
            if (!isAlive()) {
                try {
                    start();
                } catch (IllegalThreadStateException e10) {
                    FlowLog.log(FlowLog.Level.E, e10);
                }
            }
        }
    }

    @Override // com.raizlabs.android.dbflow.structure.database.transaction.ITransactionQueue
    public void cancel(String str) {
        synchronized (this.queue) {
            Iterator<PriorityEntry<Transaction>> it = this.queue.iterator();
            while (it.hasNext()) {
                Transaction transaction = it.next().entry;
                if (transaction.name() != null && transaction.name().equals(str)) {
                    it.remove();
                }
            }
        }
    }
}
