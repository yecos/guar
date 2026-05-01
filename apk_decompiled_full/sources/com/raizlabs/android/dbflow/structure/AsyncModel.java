package com.raizlabs.android.dbflow.structure;

import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.sql.BaseAsyncObject;
import com.raizlabs.android.dbflow.structure.database.DatabaseWrapper;
import com.raizlabs.android.dbflow.structure.database.transaction.ProcessModelTransaction;
import com.raizlabs.android.dbflow.structure.database.transaction.Transaction;
import java.lang.ref.WeakReference;

/* loaded from: classes3.dex */
public class AsyncModel<TModel> extends BaseAsyncObject<AsyncModel<TModel>> implements Model {
    private final TModel model;
    private ModelAdapter<TModel> modelAdapter;
    private transient WeakReference<OnModelChangedListener<TModel>> onModelChangedListener;

    public interface OnModelChangedListener<T> {
        void onModelChanged(T t10);
    }

    public AsyncModel(TModel tmodel) {
        super(tmodel.getClass());
        this.model = tmodel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ModelAdapter<TModel> getModelAdapter() {
        if (this.modelAdapter == null) {
            this.modelAdapter = FlowManager.getModelAdapter(this.model.getClass());
        }
        return this.modelAdapter;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.raizlabs.android.dbflow.structure.Model
    public AsyncModel<? extends Model> async() {
        return this;
    }

    @Override // com.raizlabs.android.dbflow.structure.Model
    public boolean delete(DatabaseWrapper databaseWrapper) {
        return delete();
    }

    @Override // com.raizlabs.android.dbflow.structure.ReadOnlyModel
    public boolean exists(DatabaseWrapper databaseWrapper) {
        return exists();
    }

    @Override // com.raizlabs.android.dbflow.structure.Model
    public long insert(DatabaseWrapper databaseWrapper) {
        return insert();
    }

    @Override // com.raizlabs.android.dbflow.structure.ReadOnlyModel
    public void load(DatabaseWrapper databaseWrapper) {
        load();
    }

    @Override // com.raizlabs.android.dbflow.sql.BaseAsyncObject
    public void onSuccess(Transaction transaction) {
        WeakReference<OnModelChangedListener<TModel>> weakReference = this.onModelChangedListener;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.onModelChangedListener.get().onModelChanged(this.model);
    }

    @Override // com.raizlabs.android.dbflow.structure.Model
    public boolean save(DatabaseWrapper databaseWrapper) {
        return save();
    }

    @Override // com.raizlabs.android.dbflow.structure.Model
    public boolean update(DatabaseWrapper databaseWrapper) {
        return update();
    }

    public AsyncModel<TModel> withListener(OnModelChangedListener<TModel> onModelChangedListener) {
        this.onModelChangedListener = new WeakReference<>(onModelChangedListener);
        return this;
    }

    @Override // com.raizlabs.android.dbflow.structure.Model
    public boolean delete() {
        executeTransaction(new ProcessModelTransaction.Builder(new ProcessModelTransaction.ProcessModel<TModel>() { // from class: com.raizlabs.android.dbflow.structure.AsyncModel.2
            @Override // com.raizlabs.android.dbflow.structure.database.transaction.ProcessModelTransaction.ProcessModel
            public void processModel(TModel tmodel, DatabaseWrapper databaseWrapper) {
                AsyncModel.this.getModelAdapter().delete(tmodel, databaseWrapper);
            }
        }).add(this.model).build());
        return false;
    }

    @Override // com.raizlabs.android.dbflow.structure.ReadOnlyModel
    public boolean exists() {
        return getModelAdapter().exists(this.model);
    }

    @Override // com.raizlabs.android.dbflow.structure.Model
    public long insert() {
        executeTransaction(new ProcessModelTransaction.Builder(new ProcessModelTransaction.ProcessModel<TModel>() { // from class: com.raizlabs.android.dbflow.structure.AsyncModel.4
            @Override // com.raizlabs.android.dbflow.structure.database.transaction.ProcessModelTransaction.ProcessModel
            public void processModel(TModel tmodel, DatabaseWrapper databaseWrapper) {
                AsyncModel.this.getModelAdapter().insert(tmodel, databaseWrapper);
            }
        }).add(this.model).build());
        return -1L;
    }

    @Override // com.raizlabs.android.dbflow.structure.ReadOnlyModel
    public void load() {
        executeTransaction(new ProcessModelTransaction.Builder(new ProcessModelTransaction.ProcessModel<TModel>() { // from class: com.raizlabs.android.dbflow.structure.AsyncModel.5
            @Override // com.raizlabs.android.dbflow.structure.database.transaction.ProcessModelTransaction.ProcessModel
            public void processModel(TModel tmodel, DatabaseWrapper databaseWrapper) {
                AsyncModel.this.getModelAdapter().load(tmodel, databaseWrapper);
            }
        }).add(this.model).build());
    }

    @Override // com.raizlabs.android.dbflow.structure.Model
    public boolean save() {
        executeTransaction(new ProcessModelTransaction.Builder(new ProcessModelTransaction.ProcessModel<TModel>() { // from class: com.raizlabs.android.dbflow.structure.AsyncModel.1
            @Override // com.raizlabs.android.dbflow.structure.database.transaction.ProcessModelTransaction.ProcessModel
            public void processModel(TModel tmodel, DatabaseWrapper databaseWrapper) {
                AsyncModel.this.getModelAdapter().save(tmodel, databaseWrapper);
            }
        }).add(this.model).build());
        return false;
    }

    @Override // com.raizlabs.android.dbflow.structure.Model
    public boolean update() {
        executeTransaction(new ProcessModelTransaction.Builder(new ProcessModelTransaction.ProcessModel<TModel>() { // from class: com.raizlabs.android.dbflow.structure.AsyncModel.3
            @Override // com.raizlabs.android.dbflow.structure.database.transaction.ProcessModelTransaction.ProcessModel
            public void processModel(TModel tmodel, DatabaseWrapper databaseWrapper) {
                AsyncModel.this.getModelAdapter().update(tmodel, databaseWrapper);
            }
        }).add(this.model).build());
        return false;
    }
}
