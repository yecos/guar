package com.raizlabs.android.dbflow.structure.database.transaction;

import com.raizlabs.android.dbflow.config.DatabaseDefinition;
import com.raizlabs.android.dbflow.runtime.BaseTransactionManager;

/* loaded from: classes3.dex */
public class DefaultTransactionManager extends BaseTransactionManager {
    public DefaultTransactionManager(DatabaseDefinition databaseDefinition) {
        super(new DefaultTransactionQueue("DBFlow Transaction Queue"), databaseDefinition);
    }

    public DefaultTransactionManager(ITransactionQueue iTransactionQueue, DatabaseDefinition databaseDefinition) {
        super(iTransactionQueue, databaseDefinition);
    }
}
