package com.raizlabs.android.dbflow.config;

import android.content.Context;
import com.raizlabs.android.dbflow.runtime.BaseTransactionManager;
import com.raizlabs.android.dbflow.runtime.ContentResolverNotifier;
import com.raizlabs.android.dbflow.runtime.ModelNotifier;
import com.raizlabs.android.dbflow.sql.migration.Migration;
import com.raizlabs.android.dbflow.structure.ModelAdapter;
import com.raizlabs.android.dbflow.structure.ModelViewAdapter;
import com.raizlabs.android.dbflow.structure.QueryModelAdapter;
import com.raizlabs.android.dbflow.structure.database.DatabaseHelperListener;
import com.raizlabs.android.dbflow.structure.database.DatabaseWrapper;
import com.raizlabs.android.dbflow.structure.database.FlowSQLiteOpenHelper;
import com.raizlabs.android.dbflow.structure.database.OpenHelper;
import com.raizlabs.android.dbflow.structure.database.transaction.DefaultTransactionManager;
import com.raizlabs.android.dbflow.structure.database.transaction.ITransaction;
import com.raizlabs.android.dbflow.structure.database.transaction.Transaction;
import com.umeng.analytics.process.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public abstract class DatabaseDefinition {
    private DatabaseConfig databaseConfig;
    private DatabaseHelperListener helperListener;
    private ModelNotifier modelNotifier;
    private OpenHelper openHelper;
    private BaseTransactionManager transactionManager;
    private final Map<Integer, List<Migration>> migrationMap = new HashMap();
    private final Map<Class<?>, ModelAdapter> modelAdapters = new HashMap();
    private final Map<String, Class<?>> modelTableNames = new HashMap();
    private final Map<Class<?>, ModelViewAdapter> modelViewAdapterMap = new LinkedHashMap();
    private final Map<Class<?>, QueryModelAdapter> queryModelAdapterMap = new LinkedHashMap();
    private boolean isResetting = false;

    public DatabaseDefinition() {
        applyDatabaseConfig(FlowManager.getConfig().databaseConfigMap().get(getAssociatedDatabaseClassFile()));
    }

    public void addMigration(int i10, Migration migration) {
        List<Migration> list = this.migrationMap.get(Integer.valueOf(i10));
        if (list == null) {
            list = new ArrayList<>();
            this.migrationMap.put(Integer.valueOf(i10), list);
        }
        list.add(migration);
    }

    public <T> void addModelAdapter(ModelAdapter<T> modelAdapter, DatabaseHolder databaseHolder) {
        databaseHolder.putDatabaseForTable(modelAdapter.getModelClass(), this);
        this.modelTableNames.put(modelAdapter.getTableName(), modelAdapter.getModelClass());
        this.modelAdapters.put(modelAdapter.getModelClass(), modelAdapter);
    }

    public <T> void addModelViewAdapter(ModelViewAdapter<T> modelViewAdapter, DatabaseHolder databaseHolder) {
        databaseHolder.putDatabaseForTable(modelViewAdapter.getModelClass(), this);
        this.modelViewAdapterMap.put(modelViewAdapter.getModelClass(), modelViewAdapter);
    }

    public <T> void addQueryModelAdapter(QueryModelAdapter<T> queryModelAdapter, DatabaseHolder databaseHolder) {
        databaseHolder.putDatabaseForTable(queryModelAdapter.getModelClass(), this);
        this.queryModelAdapterMap.put(queryModelAdapter.getModelClass(), queryModelAdapter);
    }

    public void applyDatabaseConfig(DatabaseConfig databaseConfig) {
        this.databaseConfig = databaseConfig;
        if (databaseConfig != null) {
            for (TableConfig tableConfig : databaseConfig.tableConfigMap().values()) {
                ModelAdapter modelAdapter = this.modelAdapters.get(tableConfig.tableClass());
                if (modelAdapter != null) {
                    if (tableConfig.listModelLoader() != null) {
                        modelAdapter.setListModelLoader(tableConfig.listModelLoader());
                    }
                    if (tableConfig.singleModelLoader() != null) {
                        modelAdapter.setSingleModelLoader(tableConfig.singleModelLoader());
                    }
                    if (tableConfig.modelSaver() != null) {
                        modelAdapter.setModelSaver(tableConfig.modelSaver());
                    }
                }
            }
            this.helperListener = databaseConfig.helperListener();
        }
        if (databaseConfig == null || databaseConfig.transactionManagerCreator() == null) {
            this.transactionManager = new DefaultTransactionManager(this);
        } else {
            this.transactionManager = databaseConfig.transactionManagerCreator().createManager(this);
        }
    }

    public abstract boolean areConsistencyChecksEnabled();

    public void backupDatabase() {
        getHelper().backupDB();
    }

    public abstract boolean backupEnabled();

    public Transaction.Builder beginTransactionAsync(ITransaction iTransaction) {
        return new Transaction.Builder(iTransaction, this);
    }

    public void close() {
        getTransactionManager().stopQueue();
        for (ModelAdapter modelAdapter : this.modelAdapters.values()) {
            modelAdapter.closeInsertStatement();
            modelAdapter.closeCompiledStatement();
            modelAdapter.closeDeleteStatement();
            modelAdapter.closeUpdateStatement();
        }
        getHelper().closeDB();
    }

    public void destroy() {
        if (this.isResetting) {
            return;
        }
        this.isResetting = true;
        close();
        FlowManager.getContext().deleteDatabase(getDatabaseFileName());
        this.openHelper = null;
        this.isResetting = false;
    }

    public void executeTransaction(ITransaction iTransaction) {
        DatabaseWrapper writableDatabase = getWritableDatabase();
        try {
            writableDatabase.beginTransaction();
            iTransaction.execute(writableDatabase);
            writableDatabase.setTransactionSuccessful();
        } finally {
            writableDatabase.endTransaction();
        }
    }

    public abstract Class<?> getAssociatedDatabaseClassFile();

    public String getDatabaseExtensionName() {
        DatabaseConfig databaseConfig = this.databaseConfig;
        return databaseConfig != null ? databaseConfig.getDatabaseExtensionName() : a.f10619d;
    }

    public String getDatabaseFileName() {
        return getDatabaseName() + getDatabaseExtensionName();
    }

    public String getDatabaseName() {
        DatabaseConfig databaseConfig = this.databaseConfig;
        return databaseConfig != null ? databaseConfig.getDatabaseName() : getAssociatedDatabaseClassFile().getSimpleName();
    }

    public abstract int getDatabaseVersion();

    public synchronized OpenHelper getHelper() {
        if (this.openHelper == null) {
            DatabaseConfig databaseConfig = FlowManager.getConfig().databaseConfigMap().get(getAssociatedDatabaseClassFile());
            if (databaseConfig != null && databaseConfig.helperCreator() != null) {
                this.openHelper = databaseConfig.helperCreator().createHelper(this, this.helperListener);
                this.openHelper.performRestoreFromBackup();
            }
            this.openHelper = new FlowSQLiteOpenHelper(this, this.helperListener);
            this.openHelper.performRestoreFromBackup();
        }
        return this.openHelper;
    }

    public Map<Integer, List<Migration>> getMigrations() {
        return this.migrationMap;
    }

    public <T> ModelAdapter<T> getModelAdapterForTable(Class<T> cls) {
        return this.modelAdapters.get(cls);
    }

    public List<ModelAdapter> getModelAdapters() {
        return new ArrayList(this.modelAdapters.values());
    }

    public Class<?> getModelClassForName(String str) {
        return this.modelTableNames.get(str);
    }

    public List<Class<?>> getModelClasses() {
        return new ArrayList(this.modelAdapters.keySet());
    }

    public ModelNotifier getModelNotifier() {
        if (this.modelNotifier == null) {
            DatabaseConfig databaseConfig = FlowManager.getConfig().databaseConfigMap().get(getAssociatedDatabaseClassFile());
            if (databaseConfig == null || databaseConfig.modelNotifier() == null) {
                this.modelNotifier = new ContentResolverNotifier(FlowManager.DEFAULT_AUTHORITY);
            } else {
                this.modelNotifier = databaseConfig.modelNotifier();
            }
        }
        return this.modelNotifier;
    }

    public List<QueryModelAdapter> getModelQueryAdapters() {
        return new ArrayList(this.queryModelAdapterMap.values());
    }

    public <T> ModelViewAdapter<T> getModelViewAdapterForTable(Class<T> cls) {
        return this.modelViewAdapterMap.get(cls);
    }

    public List<ModelViewAdapter> getModelViewAdapters() {
        return new ArrayList(this.modelViewAdapterMap.values());
    }

    public List<Class<?>> getModelViews() {
        return new ArrayList(this.modelViewAdapterMap.keySet());
    }

    public <T> QueryModelAdapter<T> getQueryModelAdapterForQueryClass(Class<T> cls) {
        return this.queryModelAdapterMap.get(cls);
    }

    public BaseTransactionManager getTransactionManager() {
        return this.transactionManager;
    }

    public DatabaseWrapper getWritableDatabase() {
        return getHelper().getDatabase();
    }

    public boolean isDatabaseIntegrityOk() {
        return getHelper().isDatabaseIntegrityOk();
    }

    public abstract boolean isForeignKeysSupported();

    public boolean isInMemory() {
        DatabaseConfig databaseConfig = this.databaseConfig;
        return databaseConfig != null && databaseConfig.isInMemory();
    }

    public void reopen(DatabaseConfig databaseConfig) {
        if (this.isResetting) {
            return;
        }
        close();
        this.openHelper = null;
        applyDatabaseConfig(databaseConfig);
        getHelper().getDatabase();
        this.isResetting = false;
    }

    @Deprecated
    public void reset(Context context) {
        reset(this.databaseConfig);
    }

    public void reset() {
        reset(this.databaseConfig);
    }

    public void reset(DatabaseConfig databaseConfig) {
        if (this.isResetting) {
            return;
        }
        destroy();
        applyDatabaseConfig(databaseConfig);
        getHelper().getDatabase();
    }

    public void reopen() {
        reopen(this.databaseConfig);
    }
}
