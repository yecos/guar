package com.raizlabs.android.dbflow.runtime;

import com.raizlabs.android.dbflow.structure.BaseModel;

/* loaded from: classes3.dex */
public interface OnTableChangedListener {
    void onTableChanged(Class<?> cls, BaseModel.Action action);
}
