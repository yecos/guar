package com.raizlabs.android.dbflow.structure;

import com.raizlabs.android.dbflow.config.DatabaseDefinition;

/* loaded from: classes3.dex */
public abstract class ModelViewAdapter<TModelView> extends InstanceAdapter<TModelView> {
    public ModelViewAdapter(DatabaseDefinition databaseDefinition) {
        super(databaseDefinition);
    }

    public abstract String getCreationQuery();

    public abstract String getViewName();
}
