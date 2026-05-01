package com.raizlabs.android.dbflow.structure;

import com.raizlabs.android.dbflow.structure.database.DatabaseWrapper;

/* loaded from: classes3.dex */
public abstract class BaseModelView extends NoModificationModel {
    @Override // com.raizlabs.android.dbflow.structure.NoModificationModel, com.raizlabs.android.dbflow.structure.ReadOnlyModel
    public /* bridge */ /* synthetic */ boolean exists() {
        return super.exists();
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
    public /* bridge */ /* synthetic */ boolean exists(DatabaseWrapper databaseWrapper) {
        return super.exists(databaseWrapper);
    }

    @Override // com.raizlabs.android.dbflow.structure.NoModificationModel, com.raizlabs.android.dbflow.structure.ReadOnlyModel
    public /* bridge */ /* synthetic */ void load(DatabaseWrapper databaseWrapper) {
        super.load(databaseWrapper);
    }
}
