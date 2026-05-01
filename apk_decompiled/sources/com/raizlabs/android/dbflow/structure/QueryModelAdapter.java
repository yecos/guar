package com.raizlabs.android.dbflow.structure;

import com.raizlabs.android.dbflow.config.DatabaseDefinition;
import com.raizlabs.android.dbflow.sql.language.OperatorGroup;
import com.raizlabs.android.dbflow.structure.database.DatabaseWrapper;

/* loaded from: classes3.dex */
public abstract class QueryModelAdapter<TQueryModel> extends InstanceAdapter<TQueryModel> {
    public QueryModelAdapter(DatabaseDefinition databaseDefinition) {
        super(databaseDefinition);
    }

    @Override // com.raizlabs.android.dbflow.structure.RetrievalAdapter
    public boolean exists(TQueryModel tquerymodel) {
        throw new UnsupportedOperationException("QueryModels cannot check for existence");
    }

    @Override // com.raizlabs.android.dbflow.structure.RetrievalAdapter
    public OperatorGroup getPrimaryConditionClause(TQueryModel tquerymodel) {
        throw new UnsupportedOperationException("QueryModels cannot check for existence");
    }

    @Override // com.raizlabs.android.dbflow.structure.RetrievalAdapter
    public boolean exists(TQueryModel tquerymodel, DatabaseWrapper databaseWrapper) {
        throw new UnsupportedOperationException("QueryModels cannot check for existence");
    }
}
