package com.raizlabs.android.dbflow.sql.migration;

import com.raizlabs.android.dbflow.sql.language.property.IndexProperty;
import com.raizlabs.android.dbflow.structure.database.DatabaseWrapper;

/* loaded from: classes3.dex */
public abstract class IndexPropertyMigration extends BaseMigration {
    public abstract IndexProperty getIndexProperty();

    @Override // com.raizlabs.android.dbflow.sql.migration.BaseMigration, com.raizlabs.android.dbflow.sql.migration.Migration
    public void migrate(DatabaseWrapper databaseWrapper) {
        if (shouldCreate()) {
            getIndexProperty().createIfNotExists(databaseWrapper);
        } else {
            getIndexProperty().drop(databaseWrapper);
        }
    }

    public boolean shouldCreate() {
        return true;
    }
}
