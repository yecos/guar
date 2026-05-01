package com.raizlabs.android.dbflow.sql.language;

import com.raizlabs.android.dbflow.sql.Query;
import com.raizlabs.android.dbflow.sql.QueryBuilder;
import com.raizlabs.android.dbflow.sql.language.property.IndexProperty;
import com.raizlabs.android.dbflow.structure.BaseModel;

/* loaded from: classes3.dex */
public class IndexedBy<TModel> extends BaseTransformable<TModel> {
    private final IndexProperty<TModel> indexProperty;
    private final WhereBase<TModel> whereBase;

    public IndexedBy(IndexProperty<TModel> indexProperty, WhereBase<TModel> whereBase) {
        super(whereBase.getTable());
        this.indexProperty = indexProperty;
        this.whereBase = whereBase;
    }

    @Override // com.raizlabs.android.dbflow.sql.language.BaseQueriable, com.raizlabs.android.dbflow.sql.queriable.Queriable, com.raizlabs.android.dbflow.sql.language.Actionable
    public BaseModel.Action getPrimaryAction() {
        return this.whereBase.getPrimaryAction();
    }

    @Override // com.raizlabs.android.dbflow.sql.Query
    public String getQuery() {
        return new QueryBuilder(this.whereBase.getQuery()).append(" INDEXED BY ").append(QueryBuilder.quoteIfNeeded(this.indexProperty.getIndexName())).appendSpace().getQuery();
    }

    @Override // com.raizlabs.android.dbflow.sql.language.WhereBase
    public Query getQueryBuilderBase() {
        return this.whereBase.getQueryBuilderBase();
    }
}
