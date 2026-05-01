package com.raizlabs.android.dbflow.structure;

import com.raizlabs.android.dbflow.structure.database.DatabaseWrapper;

/* loaded from: classes3.dex */
public interface ReadOnlyModel {
    boolean exists();

    boolean exists(DatabaseWrapper databaseWrapper);

    void load();

    void load(DatabaseWrapper databaseWrapper);
}
