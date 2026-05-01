package com.raizlabs.android.dbflow.sql.saveable;

import com.raizlabs.android.dbflow.structure.database.DatabaseStatement;
import com.raizlabs.android.dbflow.structure.database.DatabaseWrapper;
import java.util.Collection;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class ListModelSaver<TModel> {
    private final ModelSaver<TModel> modelSaver;

    public ListModelSaver(ModelSaver<TModel> modelSaver) {
        this.modelSaver = modelSaver;
    }

    public synchronized void deleteAll(Collection<TModel> collection) {
        deleteAll(collection, this.modelSaver.getWritableDatabase());
    }

    public ModelSaver<TModel> getModelSaver() {
        return this.modelSaver;
    }

    public synchronized void insertAll(Collection<TModel> collection) {
        insertAll(collection, this.modelSaver.getWritableDatabase());
    }

    public synchronized void saveAll(Collection<TModel> collection) {
        saveAll(collection, this.modelSaver.getWritableDatabase());
    }

    public synchronized void updateAll(Collection<TModel> collection) {
        updateAll(collection, this.modelSaver.getWritableDatabase());
    }

    public synchronized void deleteAll(Collection<TModel> collection, DatabaseWrapper databaseWrapper) {
        if (collection.isEmpty()) {
            return;
        }
        DatabaseStatement deleteStatement = this.modelSaver.getModelAdapter().getDeleteStatement(databaseWrapper);
        try {
            Iterator<TModel> it = collection.iterator();
            while (it.hasNext()) {
                this.modelSaver.delete(it.next(), deleteStatement, databaseWrapper);
            }
        } finally {
            deleteStatement.close();
        }
    }

    public synchronized void insertAll(Collection<TModel> collection, DatabaseWrapper databaseWrapper) {
        if (collection.isEmpty()) {
            return;
        }
        DatabaseStatement insertStatement = this.modelSaver.getModelAdapter().getInsertStatement(databaseWrapper);
        try {
            Iterator<TModel> it = collection.iterator();
            while (it.hasNext()) {
                this.modelSaver.insert(it.next(), insertStatement, databaseWrapper);
            }
        } finally {
            insertStatement.close();
        }
    }

    public synchronized void saveAll(Collection<TModel> collection, DatabaseWrapper databaseWrapper) {
        if (collection.isEmpty()) {
            return;
        }
        DatabaseStatement insertStatement = this.modelSaver.getModelAdapter().getInsertStatement(databaseWrapper);
        DatabaseStatement updateStatement = this.modelSaver.getModelAdapter().getUpdateStatement(databaseWrapper);
        try {
            Iterator<TModel> it = collection.iterator();
            while (it.hasNext()) {
                this.modelSaver.save((ModelSaver<TModel>) it.next(), databaseWrapper, insertStatement, updateStatement);
            }
        } finally {
            insertStatement.close();
            updateStatement.close();
        }
    }

    public synchronized void updateAll(Collection<TModel> collection, DatabaseWrapper databaseWrapper) {
        if (collection.isEmpty()) {
            return;
        }
        DatabaseStatement updateStatement = this.modelSaver.getModelAdapter().getUpdateStatement(databaseWrapper);
        try {
            Iterator<TModel> it = collection.iterator();
            while (it.hasNext()) {
                this.modelSaver.update((ModelSaver<TModel>) it.next(), databaseWrapper, updateStatement);
            }
        } finally {
            updateStatement.close();
        }
    }
}
