package com.raizlabs.android.dbflow.sql.migration;

import com.raizlabs.android.dbflow.structure.database.DatabaseWrapper;

/* loaded from: classes3.dex */
public interface Migration {
    void migrate(DatabaseWrapper databaseWrapper);

    void onPostMigrate();

    void onPreMigrate();
}
