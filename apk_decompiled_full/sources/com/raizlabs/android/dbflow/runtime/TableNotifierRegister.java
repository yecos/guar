package com.raizlabs.android.dbflow.runtime;

/* loaded from: classes3.dex */
public interface TableNotifierRegister {
    boolean isSubscribed();

    <T> void register(Class<T> cls);

    void setListener(OnTableChangedListener onTableChangedListener);

    <T> void unregister(Class<T> cls);

    void unregisterAll();
}
