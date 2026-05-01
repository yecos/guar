package com.raizlabs.android.dbflow.sql.saveable;

import com.raizlabs.android.dbflow.structure.ModelAdapter;
import com.raizlabs.android.dbflow.structure.database.DatabaseStatement;
import com.raizlabs.android.dbflow.structure.database.DatabaseWrapper;
import java.util.Collection;

/* loaded from: classes3.dex */
public class CacheableListModelSaver<TModel> extends ListModelSaver<TModel> {
    public CacheableListModelSaver(ModelSaver<TModel> modelSaver) {
        super(modelSaver);
    }

    @Override // com.raizlabs.android.dbflow.sql.saveable.ListModelSaver
    public synchronized void deleteAll(Collection<TModel> collection, DatabaseWrapper databaseWrapper) {
        if (collection.isEmpty()) {
            return;
        }
        ModelSaver<TModel> modelSaver = getModelSaver();
        for (TModel tmodel : collection) {
            if (modelSaver.delete(tmodel, databaseWrapper)) {
                getModelSaver().getModelAdapter().removeModelFromCache(tmodel);
            }
        }
    }

    @Override // com.raizlabs.android.dbflow.sql.saveable.ListModelSaver
    public synchronized void insertAll(Collection<TModel> collection, DatabaseWrapper databaseWrapper) {
        if (collection.isEmpty()) {
            return;
        }
        ModelSaver<TModel> modelSaver = getModelSaver();
        ModelAdapter<TModel> modelAdapter = modelSaver.getModelAdapter();
        DatabaseStatement insertStatement = modelAdapter.getInsertStatement(databaseWrapper);
        try {
            for (TModel tmodel : collection) {
                if (modelSaver.insert(tmodel, insertStatement, databaseWrapper) > 0) {
                    modelAdapter.storeModelInCache(tmodel);
                }
            }
        } finally {
            insertStatement.close();
        }
    }

    @Override // com.raizlabs.android.dbflow.sql.saveable.ListModelSaver
    public synchronized void saveAll(Collection<TModel> collection, DatabaseWrapper databaseWrapper) {
        if (collection.isEmpty()) {
            return;
        }
        ModelSaver<TModel> modelSaver = getModelSaver();
        ModelAdapter<TModel> modelAdapter = modelSaver.getModelAdapter();
        DatabaseStatement insertStatement = modelAdapter.getInsertStatement(databaseWrapper);
        DatabaseStatement updateStatement = modelAdapter.getUpdateStatement(databaseWrapper);
        try {
            for (TModel tmodel : collection) {
                if (modelSaver.save((ModelSaver<TModel>) tmodel, databaseWrapper, insertStatement, updateStatement)) {
                    modelAdapter.storeModelInCache(tmodel);
                }
            }
        } finally {
            updateStatement.close();
            insertStatement.close();
        }
    }

    @Override // com.raizlabs.android.dbflow.sql.saveable.ListModelSaver
    public synchronized void updateAll(Collection<TModel> collection, DatabaseWrapper databaseWrapper) {
        if (collection.isEmpty()) {
            return;
        }
        ModelSaver<TModel> modelSaver = getModelSaver();
        ModelAdapter<TModel> modelAdapter = modelSaver.getModelAdapter();
        DatabaseStatement updateStatement = modelAdapter.getUpdateStatement(databaseWrapper);
        try {
            for (TModel tmodel : collection) {
                if (modelSaver.update((ModelSaver<TModel>) tmodel, databaseWrapper, updateStatement)) {
                    modelAdapter.storeModelInCache(tmodel);
                }
            }
        } finally {
            updateStatement.close();
        }
    }
}
