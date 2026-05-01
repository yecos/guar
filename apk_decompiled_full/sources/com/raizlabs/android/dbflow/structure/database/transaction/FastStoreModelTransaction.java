package com.raizlabs.android.dbflow.structure.database.transaction;

import com.raizlabs.android.dbflow.structure.InternalAdapter;
import com.raizlabs.android.dbflow.structure.database.DatabaseWrapper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/* loaded from: classes3.dex */
public class FastStoreModelTransaction<TModel> implements ITransaction {
    final InternalAdapter<TModel> internalAdapter;
    final List<TModel> models;
    final ProcessModelList<TModel> processModelList;

    public static final class Builder<TModel> {
        private final InternalAdapter<TModel> internalAdapter;
        List<TModel> models = new ArrayList();
        private final ProcessModelList<TModel> processModelList;

        public Builder(ProcessModelList<TModel> processModelList, InternalAdapter<TModel> internalAdapter) {
            this.processModelList = processModelList;
            this.internalAdapter = internalAdapter;
        }

        public Builder<TModel> add(TModel tmodel) {
            this.models.add(tmodel);
            return this;
        }

        @SafeVarargs
        public final Builder<TModel> addAll(TModel... tmodelArr) {
            this.models.addAll(Arrays.asList(tmodelArr));
            return this;
        }

        public FastStoreModelTransaction<TModel> build() {
            return new FastStoreModelTransaction<>(this);
        }

        public Builder<TModel> addAll(Collection<? extends TModel> collection) {
            if (collection != null) {
                this.models.addAll(collection);
            }
            return this;
        }
    }

    public interface ProcessModelList<TModel> {
        void processModel(List<TModel> list, InternalAdapter<TModel> internalAdapter, DatabaseWrapper databaseWrapper);
    }

    public FastStoreModelTransaction(Builder<TModel> builder) {
        this.models = builder.models;
        this.processModelList = ((Builder) builder).processModelList;
        this.internalAdapter = ((Builder) builder).internalAdapter;
    }

    public static <TModel> Builder<TModel> deleteBuilder(InternalAdapter<TModel> internalAdapter) {
        return new Builder<>(new ProcessModelList<TModel>() { // from class: com.raizlabs.android.dbflow.structure.database.transaction.FastStoreModelTransaction.4
            @Override // com.raizlabs.android.dbflow.structure.database.transaction.FastStoreModelTransaction.ProcessModelList
            public void processModel(List<TModel> list, InternalAdapter<TModel> internalAdapter2, DatabaseWrapper databaseWrapper) {
                internalAdapter2.deleteAll(list, databaseWrapper);
            }
        }, internalAdapter);
    }

    public static <TModel> Builder<TModel> insertBuilder(InternalAdapter<TModel> internalAdapter) {
        return new Builder<>(new ProcessModelList<TModel>() { // from class: com.raizlabs.android.dbflow.structure.database.transaction.FastStoreModelTransaction.2
            @Override // com.raizlabs.android.dbflow.structure.database.transaction.FastStoreModelTransaction.ProcessModelList
            public void processModel(List<TModel> list, InternalAdapter<TModel> internalAdapter2, DatabaseWrapper databaseWrapper) {
                internalAdapter2.insertAll(list, databaseWrapper);
            }
        }, internalAdapter);
    }

    public static <TModel> Builder<TModel> saveBuilder(InternalAdapter<TModel> internalAdapter) {
        return new Builder<>(new ProcessModelList<TModel>() { // from class: com.raizlabs.android.dbflow.structure.database.transaction.FastStoreModelTransaction.1
            @Override // com.raizlabs.android.dbflow.structure.database.transaction.FastStoreModelTransaction.ProcessModelList
            public void processModel(List<TModel> list, InternalAdapter<TModel> internalAdapter2, DatabaseWrapper databaseWrapper) {
                internalAdapter2.saveAll(list, databaseWrapper);
            }
        }, internalAdapter);
    }

    public static <TModel> Builder<TModel> updateBuilder(InternalAdapter<TModel> internalAdapter) {
        return new Builder<>(new ProcessModelList<TModel>() { // from class: com.raizlabs.android.dbflow.structure.database.transaction.FastStoreModelTransaction.3
            @Override // com.raizlabs.android.dbflow.structure.database.transaction.FastStoreModelTransaction.ProcessModelList
            public void processModel(List<TModel> list, InternalAdapter<TModel> internalAdapter2, DatabaseWrapper databaseWrapper) {
                internalAdapter2.updateAll(list, databaseWrapper);
            }
        }, internalAdapter);
    }

    @Override // com.raizlabs.android.dbflow.structure.database.transaction.ITransaction
    public void execute(DatabaseWrapper databaseWrapper) {
        List<TModel> list = this.models;
        if (list != null) {
            this.processModelList.processModel(list, this.internalAdapter, databaseWrapper);
        }
    }
}
