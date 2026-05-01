package com.raizlabs.android.dbflow.structure.database.transaction;

import com.raizlabs.android.dbflow.structure.database.DatabaseWrapper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class TransactionWrapper implements ITransaction {
    private final List<ITransaction> transactions;

    public TransactionWrapper(ITransaction... iTransactionArr) {
        ArrayList arrayList = new ArrayList();
        this.transactions = arrayList;
        arrayList.addAll(Arrays.asList(iTransactionArr));
    }

    @Override // com.raizlabs.android.dbflow.structure.database.transaction.ITransaction
    public void execute(DatabaseWrapper databaseWrapper) {
        Iterator<ITransaction> it = this.transactions.iterator();
        while (it.hasNext()) {
            it.next().execute(databaseWrapper);
        }
    }

    public TransactionWrapper(Collection<ITransaction> collection) {
        ArrayList arrayList = new ArrayList();
        this.transactions = arrayList;
        arrayList.addAll(collection);
    }
}
