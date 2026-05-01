package com.raizlabs.android.dbflow.sql.language;

import com.google.android.gms.actions.SearchIntents;
import com.raizlabs.android.dbflow.sql.language.property.IProperty;
import com.raizlabs.android.dbflow.structure.database.DatabaseWrapper;
import com.raizlabs.android.dbflow.structure.database.FlowCursor;
import java.util.List;

/* loaded from: classes3.dex */
public abstract class BaseTransformable<TModel> extends BaseModelQueriable<TModel> implements Transformable<TModel>, WhereBase<TModel> {
    public BaseTransformable(Class<TModel> cls) {
        super(cls);
    }

    private void checkSelect(String str) {
        if (getQueryBuilderBase() instanceof Select) {
            return;
        }
        throw new IllegalArgumentException("Please use " + str + "(). The beginning is not a Select");
    }

    @Override // com.raizlabs.android.dbflow.sql.language.Transformable
    public Where<TModel> groupBy(NameAlias... nameAliasArr) {
        return where(new SQLOperator[0]).groupBy(nameAliasArr);
    }

    @Override // com.raizlabs.android.dbflow.sql.language.Transformable
    public Where<TModel> having(SQLOperator... sQLOperatorArr) {
        return where(new SQLOperator[0]).having(sQLOperatorArr);
    }

    @Override // com.raizlabs.android.dbflow.sql.language.Transformable
    public Where<TModel> limit(int i10) {
        return where(new SQLOperator[0]).limit(i10);
    }

    @Override // com.raizlabs.android.dbflow.sql.language.Transformable
    public Where<TModel> offset(int i10) {
        return where(new SQLOperator[0]).offset(i10);
    }

    @Override // com.raizlabs.android.dbflow.sql.language.Transformable
    public Where<TModel> orderBy(NameAlias nameAlias, boolean z10) {
        return where(new SQLOperator[0]).orderBy(nameAlias, z10);
    }

    @Override // com.raizlabs.android.dbflow.sql.language.Transformable
    public Where<TModel> orderByAll(List<OrderBy> list) {
        return where(new SQLOperator[0]).orderByAll(list);
    }

    @Override // com.raizlabs.android.dbflow.sql.language.BaseQueriable, com.raizlabs.android.dbflow.sql.queriable.Queriable
    public FlowCursor query() {
        return where(new SQLOperator[0]).query();
    }

    @Override // com.raizlabs.android.dbflow.sql.language.BaseModelQueriable, com.raizlabs.android.dbflow.sql.queriable.ModelQueriable
    public List<TModel> queryList() {
        checkSelect(SearchIntents.EXTRA_QUERY);
        return super.queryList();
    }

    @Override // com.raizlabs.android.dbflow.sql.language.BaseModelQueriable, com.raizlabs.android.dbflow.sql.queriable.ModelQueriable
    public TModel querySingle() {
        checkSelect(SearchIntents.EXTRA_QUERY);
        limit(1);
        return (TModel) super.querySingle();
    }

    public Where<TModel> where(SQLOperator... sQLOperatorArr) {
        return new Where<>(this, sQLOperatorArr);
    }

    @Override // com.raizlabs.android.dbflow.sql.language.Transformable
    public Where<TModel> groupBy(IProperty... iPropertyArr) {
        return where(new SQLOperator[0]).groupBy(iPropertyArr);
    }

    @Override // com.raizlabs.android.dbflow.sql.language.Transformable
    public Where<TModel> orderBy(IProperty iProperty, boolean z10) {
        return where(new SQLOperator[0]).orderBy(iProperty, z10);
    }

    @Override // com.raizlabs.android.dbflow.sql.language.BaseQueriable, com.raizlabs.android.dbflow.sql.queriable.Queriable
    public FlowCursor query(DatabaseWrapper databaseWrapper) {
        return where(new SQLOperator[0]).query(databaseWrapper);
    }

    @Override // com.raizlabs.android.dbflow.sql.language.Transformable
    public Where<TModel> orderBy(OrderBy orderBy) {
        return where(new SQLOperator[0]).orderBy(orderBy);
    }
}
