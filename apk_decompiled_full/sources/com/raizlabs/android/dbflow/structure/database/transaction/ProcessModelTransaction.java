package com.raizlabs.android.dbflow.structure.database.transaction;

import com.raizlabs.android.dbflow.structure.database.DatabaseWrapper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/* loaded from: classes3.dex */
public class ProcessModelTransaction<TModel> implements ITransaction {
    final List<TModel> models;
    final OnModelProcessListener<TModel> processListener;
    final ProcessModel<TModel> processModel;
    final boolean runProcessListenerOnSameThread;

    public static final class Builder<TModel> {
        List<TModel> models;
        OnModelProcessListener<TModel> processListener;
        private final ProcessModel<TModel> processModel;
        private boolean runProcessListenerOnSameThread;

        public Builder(ProcessModel<TModel> processModel) {
            this.models = new ArrayList();
            this.processModel = processModel;
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

        public ProcessModelTransaction<TModel> build() {
            return new ProcessModelTransaction<>(this);
        }

        public Builder<TModel> processListener(OnModelProcessListener<TModel> onModelProcessListener) {
            this.processListener = onModelProcessListener;
            return this;
        }

        public Builder<TModel> runProcessListenerOnSameThread(boolean z10) {
            this.runProcessListenerOnSameThread = z10;
            return this;
        }

        public Builder<TModel> addAll(Collection<? extends TModel> collection) {
            if (collection != null) {
                this.models.addAll(collection);
            }
            return this;
        }

        public Builder(Collection<TModel> collection, ProcessModel<TModel> processModel) {
            this.models = new ArrayList();
            this.processModel = processModel;
            this.models = new ArrayList(collection);
        }
    }

    public interface OnModelProcessListener<TModel> {
        void onModelProcessed(long j10, long j11, TModel tmodel);
    }

    public interface ProcessModel<TModel> {
        void processModel(TModel tmodel, DatabaseWrapper databaseWrapper);
    }

    public ProcessModelTransaction(Builder<TModel> builder) {
        this.processListener = builder.processListener;
        this.models = builder.models;
        this.processModel = ((Builder) builder).processModel;
        this.runProcessListenerOnSameThread = ((Builder) builder).runProcessListenerOnSameThread;
    }

    @Override // com.raizlabs.android.dbflow.structure.database.transaction.ITransaction
    public void execute(DatabaseWrapper databaseWrapper) {
        List<TModel> list = this.models;
        if (list != null) {
            final int size = list.size();
            for (final int i10 = 0; i10 < size; i10++) {
                final TModel tmodel = this.models.get(i10);
                this.processModel.processModel(tmodel, databaseWrapper);
                OnModelProcessListener<TModel> onModelProcessListener = this.processListener;
                if (onModelProcessListener != null) {
                    if (this.runProcessListenerOnSameThread) {
                        onModelProcessListener.onModelProcessed(i10, size, tmodel);
                    } else {
                        Transaction.getTransactionHandler().post(new Runnable() { // from class: com.raizlabs.android.dbflow.structure.database.transaction.ProcessModelTransaction.1
                            /* JADX WARN: Multi-variable type inference failed */
                            @Override // java.lang.Runnable
                            public void run() {
                                ProcessModelTransaction.this.processListener.onModelProcessed(i10, size, tmodel);
                            }
                        });
                    }
                }
            }
        }
    }
}
