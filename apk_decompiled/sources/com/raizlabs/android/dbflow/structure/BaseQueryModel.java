package com.raizlabs.android.dbflow.structure;

import com.raizlabs.android.dbflow.structure.NoModificationModel;
import com.raizlabs.android.dbflow.structure.database.DatabaseWrapper;

/* loaded from: classes3.dex */
public class BaseQueryModel extends NoModificationModel {
    @Override // com.raizlabs.android.dbflow.structure.NoModificationModel, com.raizlabs.android.dbflow.structure.ReadOnlyModel
    public boolean exists() {
        throw new NoModificationModel.InvalidSqlViewOperationException("Query " + getClass().getName() + " does not exist as a table.It's a convenient representation of a complex SQLite query.");
    }

    @Override // com.raizlabs.android.dbflow.structure.NoModificationModel
    public /* bridge */ /* synthetic */ RetrievalAdapter getRetrievalAdapter() {
        return super.getRetrievalAdapter();
    }

    @Override // com.raizlabs.android.dbflow.structure.NoModificationModel, com.raizlabs.android.dbflow.structure.ReadOnlyModel
    public /* bridge */ /* synthetic */ void load() {
        super.load();
    }

    @Override // com.raizlabs.android.dbflow.structure.NoModificationModel, com.raizlabs.android.dbflow.structure.ReadOnlyModel
    public boolean exists(DatabaseWrapper databaseWrapper) {
        return exists();
    }

    @Override // com.raizlabs.android.dbflow.structure.NoModificationModel, com.raizlabs.android.dbflow.structure.ReadOnlyModel
    public /* bridge */ /* synthetic */ void load(DatabaseWrapper databaseWrapper) {
        super.load(databaseWrapper);
    }
}
