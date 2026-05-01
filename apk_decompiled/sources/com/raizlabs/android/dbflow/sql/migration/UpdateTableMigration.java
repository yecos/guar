package com.raizlabs.android.dbflow.sql.migration;

import com.raizlabs.android.dbflow.sql.language.BaseQueriable;
import com.raizlabs.android.dbflow.sql.language.OperatorGroup;
import com.raizlabs.android.dbflow.sql.language.SQLOperator;
import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.raizlabs.android.dbflow.structure.database.DatabaseWrapper;

/* loaded from: classes3.dex */
public class UpdateTableMigration<TModel> extends BaseMigration {
    private OperatorGroup setOperatorGroup;
    private final Class<TModel> table;
    private OperatorGroup whereOperatorGroup;

    public UpdateTableMigration(Class<TModel> cls) {
        this.table = cls;
    }

    public BaseQueriable<TModel> getUpdateStatement() {
        return SQLite.update(this.table).set(this.setOperatorGroup).where(this.whereOperatorGroup);
    }

    @Override // com.raizlabs.android.dbflow.sql.migration.BaseMigration, com.raizlabs.android.dbflow.sql.migration.Migration
    public final void migrate(DatabaseWrapper databaseWrapper) {
        getUpdateStatement().execute(databaseWrapper);
    }

    @Override // com.raizlabs.android.dbflow.sql.migration.BaseMigration, com.raizlabs.android.dbflow.sql.migration.Migration
    public void onPostMigrate() {
        this.setOperatorGroup = null;
        this.whereOperatorGroup = null;
    }

    public UpdateTableMigration<TModel> set(SQLOperator... sQLOperatorArr) {
        if (this.setOperatorGroup == null) {
            this.setOperatorGroup = OperatorGroup.nonGroupingClause();
        }
        this.setOperatorGroup.andAll(sQLOperatorArr);
        return this;
    }

    public UpdateTableMigration<TModel> where(SQLOperator... sQLOperatorArr) {
        if (this.whereOperatorGroup == null) {
            this.whereOperatorGroup = OperatorGroup.nonGroupingClause();
        }
        this.whereOperatorGroup.andAll(sQLOperatorArr);
        return this;
    }
}
