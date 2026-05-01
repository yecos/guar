package com.raizlabs.android.dbflow.sql.migration;

import com.raizlabs.android.dbflow.sql.language.Index;
import com.raizlabs.android.dbflow.sql.language.property.IProperty;
import com.raizlabs.android.dbflow.structure.database.DatabaseWrapper;

/* loaded from: classes3.dex */
public abstract class IndexMigration<TModel> extends BaseMigration {
    private Index<TModel> index;
    private Class<TModel> onTable;

    public IndexMigration(Class<TModel> cls) {
        this.onTable = cls;
    }

    public IndexMigration<TModel> addColumn(IProperty iProperty) {
        getIndex().and(iProperty);
        return this;
    }

    public Index<TModel> getIndex() {
        if (this.index == null) {
            this.index = new Index(getName()).on(this.onTable, new IProperty[0]);
        }
        return this.index;
    }

    public String getIndexQuery() {
        return getIndex().getQuery();
    }

    public abstract String getName();

    @Override // com.raizlabs.android.dbflow.sql.migration.BaseMigration, com.raizlabs.android.dbflow.sql.migration.Migration
    public final void migrate(DatabaseWrapper databaseWrapper) {
        databaseWrapper.execSQL(getIndex().getQuery());
    }

    @Override // com.raizlabs.android.dbflow.sql.migration.BaseMigration, com.raizlabs.android.dbflow.sql.migration.Migration
    public void onPostMigrate() {
        this.onTable = null;
        this.index = null;
    }

    @Override // com.raizlabs.android.dbflow.sql.migration.BaseMigration, com.raizlabs.android.dbflow.sql.migration.Migration
    public void onPreMigrate() {
        this.index = getIndex();
    }

    public IndexMigration<TModel> unique() {
        getIndex().unique(true);
        return this;
    }
}
