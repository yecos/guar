package com.raizlabs.android.dbflow.runtime;

import android.database.ContentObserver;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.sql.SqlUtils;
import com.raizlabs.android.dbflow.sql.language.SQLOperator;
import com.raizlabs.android.dbflow.structure.BaseModel;
import com.raizlabs.android.dbflow.structure.ModelAdapter;

/* loaded from: classes3.dex */
public class ContentResolverNotifier implements ModelNotifier {
    private final String contentAuthority;

    public static class FlowContentTableNotifierRegister implements TableNotifierRegister {
        private final FlowContentObserver flowContentObserver;
        private final OnTableChangedListener internalContentChangeListener;
        private OnTableChangedListener tableChangedListener;

        public FlowContentTableNotifierRegister(String str) {
            OnTableChangedListener onTableChangedListener = new OnTableChangedListener() { // from class: com.raizlabs.android.dbflow.runtime.ContentResolverNotifier.FlowContentTableNotifierRegister.1
                @Override // com.raizlabs.android.dbflow.runtime.OnTableChangedListener
                public void onTableChanged(Class<?> cls, BaseModel.Action action) {
                    if (FlowContentTableNotifierRegister.this.tableChangedListener != null) {
                        FlowContentTableNotifierRegister.this.tableChangedListener.onTableChanged(cls, action);
                    }
                }
            };
            this.internalContentChangeListener = onTableChangedListener;
            FlowContentObserver flowContentObserver = new FlowContentObserver(str);
            this.flowContentObserver = flowContentObserver;
            flowContentObserver.addOnTableChangedListener(onTableChangedListener);
        }

        @Override // com.raizlabs.android.dbflow.runtime.TableNotifierRegister
        public boolean isSubscribed() {
            return !this.flowContentObserver.isSubscribed();
        }

        @Override // com.raizlabs.android.dbflow.runtime.TableNotifierRegister
        public <T> void register(Class<T> cls) {
            this.flowContentObserver.registerForContentChanges(FlowManager.getContext(), (Class<?>) cls);
        }

        @Override // com.raizlabs.android.dbflow.runtime.TableNotifierRegister
        public void setListener(OnTableChangedListener onTableChangedListener) {
            this.tableChangedListener = onTableChangedListener;
        }

        @Override // com.raizlabs.android.dbflow.runtime.TableNotifierRegister
        public <T> void unregister(Class<T> cls) {
            this.flowContentObserver.unregisterForContentChanges(FlowManager.getContext());
        }

        @Override // com.raizlabs.android.dbflow.runtime.TableNotifierRegister
        public void unregisterAll() {
            this.flowContentObserver.removeTableChangedListener(this.internalContentChangeListener);
            this.tableChangedListener = null;
        }
    }

    public ContentResolverNotifier(String str) {
        this.contentAuthority = str;
    }

    @Override // com.raizlabs.android.dbflow.runtime.ModelNotifier
    public TableNotifierRegister newRegister() {
        return new FlowContentTableNotifierRegister(this.contentAuthority);
    }

    @Override // com.raizlabs.android.dbflow.runtime.ModelNotifier
    public <T> void notifyModelChanged(T t10, ModelAdapter<T> modelAdapter, BaseModel.Action action) {
        if (FlowContentObserver.shouldNotify()) {
            FlowManager.getContext().getContentResolver().notifyChange(SqlUtils.getNotificationUri(this.contentAuthority, (Class<?>) modelAdapter.getModelClass(), action, (Iterable<SQLOperator>) modelAdapter.getPrimaryConditionClause(t10).getConditions()), (ContentObserver) null, true);
        }
    }

    @Override // com.raizlabs.android.dbflow.runtime.ModelNotifier
    public <T> void notifyTableChanged(Class<T> cls, BaseModel.Action action) {
        if (FlowContentObserver.shouldNotify()) {
            FlowManager.getContext().getContentResolver().notifyChange(SqlUtils.getNotificationUri(this.contentAuthority, (Class<?>) cls, action, (SQLOperator[]) null), (ContentObserver) null, true);
        }
    }
}
