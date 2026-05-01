package com.raizlabs.android.dbflow.runtime;

import com.raizlabs.android.dbflow.structure.BaseModel;
import com.raizlabs.android.dbflow.structure.ModelAdapter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes3.dex */
public class DirectModelNotifier implements ModelNotifier {
    private static DirectModelNotifier notifier;
    private final Map<Class<?>, Set<OnModelStateChangedListener>> modelChangedListenerMap = new LinkedHashMap();
    private final Map<Class<?>, Set<OnTableChangedListener>> tableChangedListenerMap = new LinkedHashMap();
    private final TableNotifierRegister singleRegister = new DirectTableNotifierRegister();

    public class DirectTableNotifierRegister implements TableNotifierRegister {
        private final OnTableChangedListener internalChangeListener;
        private OnTableChangedListener modelChangedListener;
        private List<Class> registeredTables;

        private DirectTableNotifierRegister() {
            this.registeredTables = new ArrayList();
            this.internalChangeListener = new OnTableChangedListener() { // from class: com.raizlabs.android.dbflow.runtime.DirectModelNotifier.DirectTableNotifierRegister.1
                @Override // com.raizlabs.android.dbflow.runtime.OnTableChangedListener
                public void onTableChanged(Class<?> cls, BaseModel.Action action) {
                    if (DirectTableNotifierRegister.this.modelChangedListener != null) {
                        DirectTableNotifierRegister.this.modelChangedListener.onTableChanged(cls, action);
                    }
                }
            };
        }

        @Override // com.raizlabs.android.dbflow.runtime.TableNotifierRegister
        public boolean isSubscribed() {
            return !this.registeredTables.isEmpty();
        }

        @Override // com.raizlabs.android.dbflow.runtime.TableNotifierRegister
        public <T> void register(Class<T> cls) {
            this.registeredTables.add(cls);
            DirectModelNotifier.this.registerForTableChanges(cls, this.internalChangeListener);
        }

        @Override // com.raizlabs.android.dbflow.runtime.TableNotifierRegister
        public void setListener(OnTableChangedListener onTableChangedListener) {
            this.modelChangedListener = onTableChangedListener;
        }

        @Override // com.raizlabs.android.dbflow.runtime.TableNotifierRegister
        public <T> void unregister(Class<T> cls) {
            this.registeredTables.remove(cls);
            DirectModelNotifier.this.unregisterForTableChanges(cls, this.internalChangeListener);
        }

        @Override // com.raizlabs.android.dbflow.runtime.TableNotifierRegister
        public void unregisterAll() {
            Iterator<Class> it = this.registeredTables.iterator();
            while (it.hasNext()) {
                DirectModelNotifier.this.unregisterForTableChanges(it.next(), this.internalChangeListener);
            }
            this.modelChangedListener = null;
        }
    }

    public interface ModelChangedListener<T> extends OnModelStateChangedListener<T>, OnTableChangedListener {
    }

    public interface OnModelStateChangedListener<T> {
        void onModelChanged(T t10, BaseModel.Action action);
    }

    private DirectModelNotifier() {
        if (notifier != null) {
            throw new IllegalStateException("Cannot instantiate more than one DirectNotifier. Use DirectNotifier.get()");
        }
    }

    public static DirectModelNotifier get() {
        if (notifier == null) {
            notifier = new DirectModelNotifier();
        }
        return notifier;
    }

    @Override // com.raizlabs.android.dbflow.runtime.ModelNotifier
    public TableNotifierRegister newRegister() {
        return this.singleRegister;
    }

    @Override // com.raizlabs.android.dbflow.runtime.ModelNotifier
    public <T> void notifyModelChanged(T t10, ModelAdapter<T> modelAdapter, BaseModel.Action action) {
        Set<OnModelStateChangedListener> set = this.modelChangedListenerMap.get(modelAdapter.getModelClass());
        if (set != null) {
            for (OnModelStateChangedListener onModelStateChangedListener : set) {
                if (onModelStateChangedListener != null) {
                    onModelStateChangedListener.onModelChanged(t10, action);
                }
            }
        }
    }

    @Override // com.raizlabs.android.dbflow.runtime.ModelNotifier
    public <T> void notifyTableChanged(Class<T> cls, BaseModel.Action action) {
        Set<OnTableChangedListener> set = this.tableChangedListenerMap.get(cls);
        if (set != null) {
            for (OnTableChangedListener onTableChangedListener : set) {
                if (onTableChangedListener != null) {
                    onTableChangedListener.onTableChanged(cls, action);
                }
            }
        }
    }

    public <T> void registerForModelChanges(Class<T> cls, ModelChangedListener<T> modelChangedListener) {
        registerForModelStateChanges(cls, modelChangedListener);
        registerForTableChanges(cls, modelChangedListener);
    }

    public <T> void registerForModelStateChanges(Class<T> cls, OnModelStateChangedListener<T> onModelStateChangedListener) {
        Set<OnModelStateChangedListener> set = this.modelChangedListenerMap.get(cls);
        if (set == null) {
            set = new LinkedHashSet<>();
            this.modelChangedListenerMap.put(cls, set);
        }
        set.add(onModelStateChangedListener);
    }

    public <T> void registerForTableChanges(Class<T> cls, OnTableChangedListener onTableChangedListener) {
        Set<OnTableChangedListener> set = this.tableChangedListenerMap.get(cls);
        if (set == null) {
            set = new LinkedHashSet<>();
            this.tableChangedListenerMap.put(cls, set);
        }
        set.add(onTableChangedListener);
    }

    public <T> void unregisterForModelChanges(Class<T> cls, ModelChangedListener<T> modelChangedListener) {
        unregisterForModelStateChanges(cls, modelChangedListener);
        unregisterForTableChanges(cls, modelChangedListener);
    }

    public <T> void unregisterForModelStateChanges(Class<T> cls, OnModelStateChangedListener<T> onModelStateChangedListener) {
        Set<OnModelStateChangedListener> set = this.modelChangedListenerMap.get(cls);
        if (set != null) {
            set.remove(onModelStateChangedListener);
        }
    }

    public <T> void unregisterForTableChanges(Class<T> cls, OnTableChangedListener onTableChangedListener) {
        Set<OnTableChangedListener> set = this.tableChangedListenerMap.get(cls);
        if (set != null) {
            set.remove(onTableChangedListener);
        }
    }
}
