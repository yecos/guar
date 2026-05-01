package com.raizlabs.android.dbflow.structure;

import com.raizlabs.android.dbflow.structure.database.DatabaseWrapper;

/* loaded from: classes3.dex */
public interface Model extends ReadOnlyModel {
    public static final long INVALID_ROW_ID = -1;

    AsyncModel<? extends Model> async();

    boolean delete();

    boolean delete(DatabaseWrapper databaseWrapper);

    long insert();

    long insert(DatabaseWrapper databaseWrapper);

    boolean save();

    boolean save(DatabaseWrapper databaseWrapper);

    boolean update();

    boolean update(DatabaseWrapper databaseWrapper);
}
