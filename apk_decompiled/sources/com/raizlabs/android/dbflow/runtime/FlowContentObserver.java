package com.raizlabs.android.dbflow.runtime;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.sql.SqlUtils;
import com.raizlabs.android.dbflow.sql.language.NameAlias;
import com.raizlabs.android.dbflow.sql.language.Operator;
import com.raizlabs.android.dbflow.sql.language.SQLOperator;
import com.raizlabs.android.dbflow.structure.BaseModel;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes3.dex */
public class FlowContentObserver extends ContentObserver {
    private static final AtomicInteger REGISTERED_COUNT = new AtomicInteger(0);
    private static boolean forceNotify = false;
    private final String contentAuthority;
    protected boolean isInTransaction;
    private final Set<OnModelStateChangedListener> modelChangeListeners;
    private final Set<Uri> notificationUris;
    private boolean notifyAllUris;
    private final Set<OnTableChangedListener> onTableChangedListeners;
    private final Map<String, Class<?>> registeredTables;
    private final Set<Uri> tableUris;

    public interface ContentChangeListener extends OnModelStateChangedListener, OnTableChangedListener {
    }

    public interface OnModelStateChangedListener {
        void onModelStateChanged(Class<?> cls, BaseModel.Action action, SQLOperator[] sQLOperatorArr);
    }

    public FlowContentObserver(String str) {
        super(null);
        this.modelChangeListeners = new CopyOnWriteArraySet();
        this.onTableChangedListeners = new CopyOnWriteArraySet();
        this.registeredTables = new HashMap();
        this.notificationUris = new HashSet();
        this.tableUris = new HashSet();
        this.isInTransaction = false;
        this.notifyAllUris = false;
        this.contentAuthority = str;
    }

    public static void clearRegisteredObserverCount() {
        REGISTERED_COUNT.set(0);
    }

    public static void setShouldForceNotify(boolean z10) {
        forceNotify = z10;
    }

    public static boolean shouldNotify() {
        return forceNotify || REGISTERED_COUNT.get() > 0;
    }

    public void addContentChangeListener(ContentChangeListener contentChangeListener) {
        this.modelChangeListeners.add(contentChangeListener);
        this.onTableChangedListeners.add(contentChangeListener);
    }

    public void addModelChangeListener(OnModelStateChangedListener onModelStateChangedListener) {
        this.modelChangeListeners.add(onModelStateChangedListener);
    }

    public void addOnTableChangedListener(OnTableChangedListener onTableChangedListener) {
        this.onTableChangedListeners.add(onTableChangedListener);
    }

    public void beginTransaction() {
        if (this.isInTransaction) {
            return;
        }
        this.isInTransaction = true;
    }

    public void endTransactionAndNotify() {
        if (this.isInTransaction) {
            this.isInTransaction = false;
            synchronized (this.notificationUris) {
                Iterator<Uri> it = this.notificationUris.iterator();
                while (it.hasNext()) {
                    onChange(true, it.next(), true);
                }
                this.notificationUris.clear();
            }
            synchronized (this.tableUris) {
                for (Uri uri : this.tableUris) {
                    Iterator<OnTableChangedListener> it2 = this.onTableChangedListeners.iterator();
                    while (it2.hasNext()) {
                        it2.next().onTableChanged(this.registeredTables.get(uri.getAuthority()), BaseModel.Action.valueOf(uri.getFragment()));
                    }
                }
                this.tableUris.clear();
            }
        }
    }

    public boolean isSubscribed() {
        return !this.registeredTables.isEmpty();
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z10) {
        Iterator<OnModelStateChangedListener> it = this.modelChangeListeners.iterator();
        while (it.hasNext()) {
            it.next().onModelStateChanged(null, BaseModel.Action.CHANGE, new SQLOperator[0]);
        }
        Iterator<OnTableChangedListener> it2 = this.onTableChangedListeners.iterator();
        while (it2.hasNext()) {
            it2.next().onTableChanged(null, BaseModel.Action.CHANGE);
        }
    }

    public void registerForContentChanges(Context context, Class<?> cls) {
        registerForContentChanges(context.getContentResolver(), cls);
    }

    public void removeContentChangeListener(ContentChangeListener contentChangeListener) {
        this.modelChangeListeners.remove(contentChangeListener);
        this.onTableChangedListeners.remove(contentChangeListener);
    }

    public void removeModelChangeListener(OnModelStateChangedListener onModelStateChangedListener) {
        this.modelChangeListeners.remove(onModelStateChangedListener);
    }

    public void removeTableChangedListener(OnTableChangedListener onTableChangedListener) {
        this.onTableChangedListeners.remove(onTableChangedListener);
    }

    public void setNotifyAllUris(boolean z10) {
        this.notifyAllUris = z10;
    }

    public void unregisterForContentChanges(Context context) {
        context.getContentResolver().unregisterContentObserver(this);
        REGISTERED_COUNT.decrementAndGet();
        this.registeredTables.clear();
    }

    public void registerForContentChanges(ContentResolver contentResolver, Class<?> cls) {
        contentResolver.registerContentObserver(SqlUtils.getNotificationUri(this.contentAuthority, cls, null), true, this);
        REGISTERED_COUNT.incrementAndGet();
        if (this.registeredTables.containsValue(cls)) {
            return;
        }
        this.registeredTables.put(FlowManager.getTableName(cls), cls);
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z10, Uri uri) {
        onChange(z10, uri, false);
    }

    private void onChange(boolean z10, Uri uri, boolean z11) {
        String fragment = uri.getFragment();
        String queryParameter = uri.getQueryParameter(SqlUtils.TABLE_QUERY_PARAM);
        Set<String> queryParameterNames = uri.getQueryParameterNames();
        SQLOperator[] sQLOperatorArr = new SQLOperator[queryParameterNames.size() - 1];
        if (!queryParameterNames.isEmpty()) {
            int i10 = 0;
            for (String str : queryParameterNames) {
                if (!SqlUtils.TABLE_QUERY_PARAM.equals(str)) {
                    sQLOperatorArr[i10] = Operator.op(new NameAlias.Builder(Uri.decode(str)).build()).eq((Operator) Uri.decode(uri.getQueryParameter(str)));
                    i10++;
                }
            }
        }
        Class<?> cls = this.registeredTables.get(queryParameter);
        BaseModel.Action valueOf = BaseModel.Action.valueOf(fragment);
        if (!this.isInTransaction) {
            Iterator<OnModelStateChangedListener> it = this.modelChangeListeners.iterator();
            while (it.hasNext()) {
                it.next().onModelStateChanged(cls, valueOf, sQLOperatorArr);
            }
            if (z11) {
                return;
            }
            Iterator<OnTableChangedListener> it2 = this.onTableChangedListeners.iterator();
            while (it2.hasNext()) {
                it2.next().onTableChanged(cls, valueOf);
            }
            return;
        }
        if (!this.notifyAllUris) {
            valueOf = BaseModel.Action.CHANGE;
            uri = SqlUtils.getNotificationUri(this.contentAuthority, cls, valueOf);
        }
        synchronized (this.notificationUris) {
            this.notificationUris.add(uri);
        }
        synchronized (this.tableUris) {
            this.tableUris.add(SqlUtils.getNotificationUri(this.contentAuthority, cls, valueOf));
        }
    }

    public FlowContentObserver(Handler handler, String str) {
        super(handler);
        this.modelChangeListeners = new CopyOnWriteArraySet();
        this.onTableChangedListeners = new CopyOnWriteArraySet();
        this.registeredTables = new HashMap();
        this.notificationUris = new HashSet();
        this.tableUris = new HashSet();
        this.isInTransaction = false;
        this.notifyAllUris = false;
        this.contentAuthority = str;
    }
}
