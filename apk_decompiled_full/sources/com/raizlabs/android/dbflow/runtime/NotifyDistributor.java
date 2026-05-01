package com.raizlabs.android.dbflow.runtime;

import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.structure.BaseModel;
import com.raizlabs.android.dbflow.structure.ModelAdapter;

/* loaded from: classes3.dex */
public class NotifyDistributor implements ModelNotifier {
    private static NotifyDistributor distributor;

    public static NotifyDistributor get() {
        if (distributor == null) {
            distributor = new NotifyDistributor();
        }
        return distributor;
    }

    @Override // com.raizlabs.android.dbflow.runtime.ModelNotifier
    public TableNotifierRegister newRegister() {
        throw new RuntimeException("Cannot create a register from the distributor class");
    }

    @Override // com.raizlabs.android.dbflow.runtime.ModelNotifier
    public <TModel> void notifyModelChanged(TModel tmodel, ModelAdapter<TModel> modelAdapter, BaseModel.Action action) {
        FlowManager.getModelNotifierForTable(modelAdapter.getModelClass()).notifyModelChanged(tmodel, modelAdapter, action);
    }

    @Override // com.raizlabs.android.dbflow.runtime.ModelNotifier
    public <TModel> void notifyTableChanged(Class<TModel> cls, BaseModel.Action action) {
        FlowManager.getModelNotifierForTable(cls).notifyTableChanged(cls, action);
    }
}
