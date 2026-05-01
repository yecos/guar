package com.raizlabs.android.dbflow.sql.language;

import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.sql.Query;
import com.raizlabs.android.dbflow.sql.QueryBuilder;
import com.raizlabs.android.dbflow.sql.SqlUtils;
import com.raizlabs.android.dbflow.sql.language.property.IProperty;
import com.raizlabs.android.dbflow.structure.database.DatabaseWrapper;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class Index<TModel> implements Query {
    private final String indexName;
    private Class<TModel> table;
    private boolean isUnique = false;
    private List<NameAlias> columns = new ArrayList();

    public Index(String str) {
        this.indexName = str;
    }

    public Index<TModel> and(IProperty iProperty) {
        if (!this.columns.contains(iProperty.getNameAlias())) {
            this.columns.add(iProperty.getNameAlias());
        }
        return this;
    }

    public void disable() {
        SqlUtils.dropIndex(FlowManager.getDatabaseForTable(this.table).getWritableDatabase(), this.indexName);
    }

    public void enable(DatabaseWrapper databaseWrapper) {
        if (this.table == null) {
            throw new IllegalStateException("Please call on() to set a table to use this index on.");
        }
        List<NameAlias> list = this.columns;
        if (list == null || list.isEmpty()) {
            throw new IllegalStateException("There should be at least one column in this index");
        }
        databaseWrapper.execSQL(getQuery());
    }

    public String getIndexName() {
        return this.indexName;
    }

    @Override // com.raizlabs.android.dbflow.sql.Query
    public String getQuery() {
        return new QueryBuilder("CREATE ").append(this.isUnique ? "UNIQUE " : "").append("INDEX IF NOT EXISTS ").appendQuotedIfNeeded(this.indexName).append(" ON ").append(FlowManager.getTableName(this.table)).append("(").appendList(this.columns).append(")").getQuery();
    }

    public Class<TModel> getTable() {
        return this.table;
    }

    public boolean isUnique() {
        return this.isUnique;
    }

    public Index<TModel> on(Class<TModel> cls, IProperty... iPropertyArr) {
        this.table = cls;
        for (IProperty iProperty : iPropertyArr) {
            and(iProperty);
        }
        return this;
    }

    public Index<TModel> unique(boolean z10) {
        this.isUnique = z10;
        return this;
    }

    public void disable(DatabaseWrapper databaseWrapper) {
        SqlUtils.dropIndex(databaseWrapper, this.indexName);
    }

    public Index<TModel> and(NameAlias nameAlias) {
        if (!this.columns.contains(nameAlias)) {
            this.columns.add(nameAlias);
        }
        return this;
    }

    public Index<TModel> on(Class<TModel> cls, NameAlias nameAlias, NameAlias... nameAliasArr) {
        this.table = cls;
        and(nameAlias);
        for (NameAlias nameAlias2 : nameAliasArr) {
            and(nameAlias2);
        }
        return this;
    }

    public void enable() {
        enable(FlowManager.getDatabaseForTable(this.table).getWritableDatabase());
    }
}
