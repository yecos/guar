package com.raizlabs.android.dbflow.sql.language;

import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.sql.Query;
import com.raizlabs.android.dbflow.sql.QueryBuilder;
import com.raizlabs.android.dbflow.sql.language.Join;
import com.raizlabs.android.dbflow.sql.language.NameAlias;
import com.raizlabs.android.dbflow.sql.language.property.IndexProperty;
import com.raizlabs.android.dbflow.sql.queriable.ModelQueriable;
import com.raizlabs.android.dbflow.structure.BaseModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

/* loaded from: classes3.dex */
public class From<TModel> extends BaseTransformable<TModel> {
    private final List<Join> joins;
    private Query queryBase;
    private NameAlias tableAlias;

    public From(Query query, Class<TModel> cls) {
        super(cls);
        this.joins = new ArrayList();
        this.queryBase = query;
    }

    private NameAlias getTableAlias() {
        if (this.tableAlias == null) {
            this.tableAlias = new NameAlias.Builder(FlowManager.getTableName(getTable())).build();
        }
        return this.tableAlias;
    }

    public From<TModel> as(String str) {
        this.tableAlias = getTableAlias().newBuilder().as(str).build();
        return this;
    }

    public <TJoin> Join<TJoin, TModel> crossJoin(Class<TJoin> cls) {
        return join(cls, Join.JoinType.CROSS);
    }

    public java.util.Set<Class<?>> getAssociatedTables() {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.add(getTable());
        Iterator<Join> it = this.joins.iterator();
        while (it.hasNext()) {
            linkedHashSet.add(it.next().getTable());
        }
        return linkedHashSet;
    }

    @Override // com.raizlabs.android.dbflow.sql.language.BaseQueriable, com.raizlabs.android.dbflow.sql.queriable.Queriable, com.raizlabs.android.dbflow.sql.language.Actionable
    public BaseModel.Action getPrimaryAction() {
        return this.queryBase instanceof Delete ? BaseModel.Action.DELETE : BaseModel.Action.CHANGE;
    }

    @Override // com.raizlabs.android.dbflow.sql.Query
    public String getQuery() {
        QueryBuilder append = new QueryBuilder().append(this.queryBase.getQuery());
        if (!(this.queryBase instanceof Update)) {
            append.append("FROM ");
        }
        append.append(getTableAlias());
        if (this.queryBase instanceof Select) {
            if (!this.joins.isEmpty()) {
                append.appendSpace();
            }
            Iterator<Join> it = this.joins.iterator();
            while (it.hasNext()) {
                append.append(it.next().getQuery());
            }
        } else {
            append.appendSpace();
        }
        return append.getQuery();
    }

    @Override // com.raizlabs.android.dbflow.sql.language.WhereBase
    public Query getQueryBuilderBase() {
        return this.queryBase;
    }

    public IndexedBy<TModel> indexedBy(IndexProperty<TModel> indexProperty) {
        return new IndexedBy<>(indexProperty, this);
    }

    public <TJoin> Join<TJoin, TModel> innerJoin(Class<TJoin> cls) {
        return join(cls, Join.JoinType.INNER);
    }

    public <TJoin> Join<TJoin, TModel> join(Class<TJoin> cls, Join.JoinType joinType) {
        Join<TJoin, TModel> join = new Join<>(this, cls, joinType);
        this.joins.add(join);
        return join;
    }

    public <TJoin> Join<TJoin, TModel> leftOuterJoin(Class<TJoin> cls) {
        return join(cls, Join.JoinType.LEFT_OUTER);
    }

    public <TJoin> Join<TJoin, TModel> naturalJoin(Class<TJoin> cls) {
        return join(cls, Join.JoinType.NATURAL);
    }

    public <TJoin> Join<TJoin, TModel> crossJoin(ModelQueriable<TJoin> modelQueriable) {
        return join(modelQueriable, Join.JoinType.CROSS);
    }

    public <TJoin> Join<TJoin, TModel> innerJoin(ModelQueriable<TJoin> modelQueriable) {
        return join(modelQueriable, Join.JoinType.INNER);
    }

    public <TJoin> Join<TJoin, TModel> leftOuterJoin(ModelQueriable<TJoin> modelQueriable) {
        return join(modelQueriable, Join.JoinType.LEFT_OUTER);
    }

    public <TJoin> Join<TJoin, TModel> naturalJoin(ModelQueriable<TJoin> modelQueriable) {
        return join(modelQueriable, Join.JoinType.NATURAL);
    }

    public <TJoin> Join<TJoin, TModel> join(ModelQueriable<TJoin> modelQueriable, Join.JoinType joinType) {
        Join<TJoin, TModel> join = new Join<>(this, joinType, modelQueriable);
        this.joins.add(join);
        return join;
    }
}
