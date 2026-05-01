package com.raizlabs.android.dbflow.config;

import com.bigbee.db.BBDatabase;
import com.bigbee.db.EventDbModel_Table;

/* loaded from: classes3.dex */
public final class BBDatabaseBBDatabase_Database extends DatabaseDefinition {
    public BBDatabaseBBDatabase_Database(DatabaseHolder databaseHolder) {
        addModelAdapter(new EventDbModel_Table(this), databaseHolder);
    }

    @Override // com.raizlabs.android.dbflow.config.DatabaseDefinition
    public final boolean areConsistencyChecksEnabled() {
        return false;
    }

    @Override // com.raizlabs.android.dbflow.config.DatabaseDefinition
    public final boolean backupEnabled() {
        return false;
    }

    @Override // com.raizlabs.android.dbflow.config.DatabaseDefinition
    public final Class<?> getAssociatedDatabaseClassFile() {
        return BBDatabase.class;
    }

    @Override // com.raizlabs.android.dbflow.config.DatabaseDefinition
    public final String getDatabaseName() {
        return BBDatabase.NAME;
    }

    @Override // com.raizlabs.android.dbflow.config.DatabaseDefinition
    public final int getDatabaseVersion() {
        return 1;
    }

    @Override // com.raizlabs.android.dbflow.config.DatabaseDefinition
    public final boolean isForeignKeysSupported() {
        return false;
    }
}
