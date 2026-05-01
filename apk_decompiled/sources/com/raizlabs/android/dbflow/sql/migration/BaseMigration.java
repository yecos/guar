package com.raizlabs.android.dbflow.sql.migration;

import com.raizlabs.android.dbflow.structure.database.DatabaseWrapper;

/* loaded from: classes3.dex */
public abstract class BaseMigration implements Migration {
    @Override // com.raizlabs.android.dbflow.sql.migration.Migration
    public abstract void migrate(DatabaseWrapper databaseWrapper);

    @Override // com.raizlabs.android.dbflow.sql.migration.Migration
    public void onPostMigrate() {
    }

    @Override // com.raizlabs.android.dbflow.sql.migration.Migration
    public void onPreMigrate() {
    }
}
