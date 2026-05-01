package com.raizlabs.android.dbflow.structure.database.transaction;

/* loaded from: classes3.dex */
public interface ITransactionQueue {
    void add(Transaction transaction);

    void cancel(Transaction transaction);

    void cancel(String str);

    void quit();

    void startIfNotAlive();
}
