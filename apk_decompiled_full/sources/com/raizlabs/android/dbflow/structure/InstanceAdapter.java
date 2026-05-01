package com.raizlabs.android.dbflow.structure;

import com.raizlabs.android.dbflow.config.DatabaseDefinition;

/* loaded from: classes3.dex */
public abstract class InstanceAdapter<TModel> extends RetrievalAdapter<TModel> {
    public InstanceAdapter(DatabaseDefinition databaseDefinition) {
        super(databaseDefinition);
    }

    public abstract TModel newInstance();
}
