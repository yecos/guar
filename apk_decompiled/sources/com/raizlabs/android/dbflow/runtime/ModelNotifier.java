package com.raizlabs.android.dbflow.runtime;

import com.raizlabs.android.dbflow.structure.BaseModel;
import com.raizlabs.android.dbflow.structure.ModelAdapter;

/* loaded from: classes3.dex */
public interface ModelNotifier {
    TableNotifierRegister newRegister();

    <T> void notifyModelChanged(T t10, ModelAdapter<T> modelAdapter, BaseModel.Action action);

    <T> void notifyTableChanged(Class<T> cls, BaseModel.Action action);
}
