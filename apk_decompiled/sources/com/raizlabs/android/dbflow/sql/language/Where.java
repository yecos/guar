package com.raizlabs.android.dbflow.sql.language;

import com.google.android.gms.actions.SearchIntents;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.sql.QueryBuilder;
import com.raizlabs.android.dbflow.sql.language.property.IProperty;
import com.raizlabs.android.dbflow.structure.BaseModel;
import com.raizlabs.android.dbflow.structure.database.DatabaseWrapper;
import com.raizlabs.android.dbflow.structure.database.FlowCursor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes3.dex */
public class Where<TModel> extends BaseModelQueriable<TModel> implements Transformable<TModel> {
    private static final int VALUE_UNSET = -1;
    private final List<NameAlias> groupByList;
    private OperatorGroup havingGroup;
    private int limit;
    private int offset;
    private OperatorGroup operatorGroup;
    private final List<OrderBy> orderByList;
    private final WhereBase<TModel> whereBase;

    public Where(WhereBase<TModel> whereBase, SQLOperator... sQLOperatorArr) {
        super(whereBase.getTable());
        this.groupByList = new ArrayList();
        this.orderByList = new ArrayList();
        this.limit = -1;
        this.offset = -1;
        this.whereBase = whereBase;
        this.operatorGroup = OperatorGroup.nonGroupingClause();
        this.havingGroup = OperatorGroup.nonGroupingClause();
        this.operatorGroup.andAll(sQLOperatorArr);
    }

    private void checkSelect(String str) {
        if (this.whereBase.getQueryBuilderBase() instanceof Select) {
            return;
        }
        throw new IllegalArgumentException("Please use " + str + "(). The beginning is not a ISelect");
    }

    public Where<TModel> and(SQLOperator sQLOperator) {
        this.operatorGroup.and(sQLOperator);
        return this;
    }

    public Where<TModel> andAll(List<SQLOperator> list) {
        this.operatorGroup.andAll(list);
        return this;
    }

    public Where<TModel> exists(Where where) {
        this.operatorGroup.and(new ExistenceOperator().where(where));
        return this;
    }

    @Override // com.raizlabs.android.dbflow.sql.language.BaseQueriable, com.raizlabs.android.dbflow.sql.queriable.Queriable, com.raizlabs.android.dbflow.sql.language.Actionable
    public BaseModel.Action getPrimaryAction() {
        return this.whereBase.getPrimaryAction();
    }

    @Override // com.raizlabs.android.dbflow.sql.Query
    public String getQuery() {
        QueryBuilder appendQualifier = new QueryBuilder().append(this.whereBase.getQuery().trim()).appendSpace().appendQualifier("WHERE", this.operatorGroup.getQuery()).appendQualifier("GROUP BY", QueryBuilder.join(",", this.groupByList)).appendQualifier("HAVING", this.havingGroup.getQuery()).appendQualifier("ORDER BY", QueryBuilder.join(",", this.orderByList));
        int i10 = this.limit;
        if (i10 > -1) {
            appendQualifier.appendQualifier("LIMIT", String.valueOf(i10));
        }
        int i11 = this.offset;
        if (i11 > -1) {
            appendQualifier.appendQualifier("OFFSET", String.valueOf(i11));
        }
        return appendQualifier.getQuery();
    }

    public WhereBase<TModel> getWhereBase() {
        return this.whereBase;
    }

    @Override // com.raizlabs.android.dbflow.sql.language.Transformable
    public Where<TModel> groupBy(NameAlias... nameAliasArr) {
        Collections.addAll(this.groupByList, nameAliasArr);
        return this;
    }

    @Override // com.raizlabs.android.dbflow.sql.language.Transformable
    public Where<TModel> having(SQLOperator... sQLOperatorArr) {
        this.havingGroup.andAll(sQLOperatorArr);
        return this;
    }

    @Override // com.raizlabs.android.dbflow.sql.language.Transformable
    public Where<TModel> limit(int i10) {
        this.limit = i10;
        return this;
    }

    @Override // com.raizlabs.android.dbflow.sql.language.Transformable
    public Where<TModel> offset(int i10) {
        this.offset = i10;
        return this;
    }

    public Where<TModel> or(SQLOperator sQLOperator) {
        this.operatorGroup.or(sQLOperator);
        return this;
    }

    @Override // com.raizlabs.android.dbflow.sql.language.Transformable
    public Where<TModel> orderBy(NameAlias nameAlias, boolean z10) {
        this.orderByList.add(new OrderBy(nameAlias, z10));
        return this;
    }

    @Override // com.raizlabs.android.dbflow.sql.language.Transformable
    public Where<TModel> orderByAll(List<OrderBy> list) {
        this.orderByList.addAll(list);
        return this;
    }

    @Override // com.raizlabs.android.dbflow.sql.language.BaseQueriable, com.raizlabs.android.dbflow.sql.queriable.Queriable
    public FlowCursor query(DatabaseWrapper databaseWrapper) {
        return this.whereBase.getQueryBuilderBase() instanceof Select ? databaseWrapper.rawQuery(getQuery(), null) : super.query(databaseWrapper);
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

    public Where<TModel> andAll(SQLOperator... sQLOperatorArr) {
        this.operatorGroup.andAll(sQLOperatorArr);
        return this;
    }

    @Override // com.raizlabs.android.dbflow.sql.language.Transformable
    public Where<TModel> groupBy(IProperty... iPropertyArr) {
        for (IProperty iProperty : iPropertyArr) {
            this.groupByList.add(iProperty.getNameAlias());
        }
        return this;
    }

    @Override // com.raizlabs.android.dbflow.sql.language.Transformable
    public Where<TModel> orderBy(IProperty iProperty, boolean z10) {
        this.orderByList.add(new OrderBy(iProperty.getNameAlias(), z10));
        return this;
    }

    @Override // com.raizlabs.android.dbflow.sql.language.Transformable
    public Where<TModel> orderBy(OrderBy orderBy) {
        this.orderByList.add(orderBy);
        return this;
    }

    @Override // com.raizlabs.android.dbflow.sql.language.BaseQueriable, com.raizlabs.android.dbflow.sql.queriable.Queriable
    public FlowCursor query() {
        return query(FlowManager.getDatabaseForTable(getTable()).getWritableDatabase());
    }
}
