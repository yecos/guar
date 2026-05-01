package com.raizlabs.android.dbflow.structure;

import android.content.ContentValues;
import com.raizlabs.android.dbflow.structure.database.DatabaseStatement;
import com.raizlabs.android.dbflow.structure.database.DatabaseWrapper;
import java.util.Collection;

/* loaded from: classes3.dex */
public interface InternalAdapter<TModel> {
    void bindToContentValues(ContentValues contentValues, TModel tmodel);

    void bindToDeleteStatement(DatabaseStatement databaseStatement, TModel tmodel);

    void bindToInsertStatement(DatabaseStatement databaseStatement, TModel tmodel);

    void bindToInsertStatement(DatabaseStatement databaseStatement, TModel tmodel, int i10);

    void bindToInsertValues(ContentValues contentValues, TModel tmodel);

    void bindToStatement(DatabaseStatement databaseStatement, TModel tmodel);

    void bindToUpdateStatement(DatabaseStatement databaseStatement, TModel tmodel);

    boolean cachingEnabled();

    boolean delete(TModel tmodel);

    boolean delete(TModel tmodel, DatabaseWrapper databaseWrapper);

    void deleteAll(Collection<TModel> collection);

    void deleteAll(Collection<TModel> collection, DatabaseWrapper databaseWrapper);

    Number getAutoIncrementingId(TModel tmodel);

    String getTableName();

    long insert(TModel tmodel);

    long insert(TModel tmodel, DatabaseWrapper databaseWrapper);

    void insertAll(Collection<TModel> collection);

    void insertAll(Collection<TModel> collection, DatabaseWrapper databaseWrapper);

    boolean save(TModel tmodel);

    boolean save(TModel tmodel, DatabaseWrapper databaseWrapper);

    void saveAll(Collection<TModel> collection);

    void saveAll(Collection<TModel> collection, DatabaseWrapper databaseWrapper);

    boolean update(TModel tmodel);

    boolean update(TModel tmodel, DatabaseWrapper databaseWrapper);

    void updateAll(Collection<TModel> collection);

    void updateAll(Collection<TModel> collection, DatabaseWrapper databaseWrapper);

    void updateAutoIncrement(TModel tmodel, Number number);
}
