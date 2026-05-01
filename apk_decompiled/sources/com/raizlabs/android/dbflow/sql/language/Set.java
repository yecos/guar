package com.raizlabs.android.dbflow.sql.language;

import android.content.ContentValues;
import com.raizlabs.android.dbflow.sql.Query;
import com.raizlabs.android.dbflow.sql.QueryBuilder;
import com.raizlabs.android.dbflow.sql.SqlUtils;
import com.raizlabs.android.dbflow.structure.BaseModel;

/* loaded from: classes3.dex */
public class Set<TModel> extends BaseTransformable<TModel> {
    private OperatorGroup operatorGroup;
    private Query update;

    public Set(Query query, Class<TModel> cls) {
        super(cls);
        this.update = query;
        this.operatorGroup = OperatorGroup.nonGroupingClause().setAllCommaSeparated(true);
    }

    public Set<TModel> conditionValues(ContentValues contentValues) {
        SqlUtils.addContentValues(contentValues, this.operatorGroup);
        return this;
    }

    public Set<TModel> conditions(SQLOperator... sQLOperatorArr) {
        this.operatorGroup.andAll(sQLOperatorArr);
        return this;
    }

    @Override // com.raizlabs.android.dbflow.sql.language.BaseQueriable, com.raizlabs.android.dbflow.sql.queriable.Queriable, com.raizlabs.android.dbflow.sql.language.Actionable
    public BaseModel.Action getPrimaryAction() {
        return BaseModel.Action.UPDATE;
    }

    @Override // com.raizlabs.android.dbflow.sql.Query
    public String getQuery() {
        return new QueryBuilder(this.update.getQuery()).append("SET ").append(this.operatorGroup.getQuery()).appendSpace().getQuery();
    }

    @Override // com.raizlabs.android.dbflow.sql.language.WhereBase
    public Query getQueryBuilderBase() {
        return this.update;
    }
}
