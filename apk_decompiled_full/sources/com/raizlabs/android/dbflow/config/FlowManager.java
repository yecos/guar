package com.raizlabs.android.dbflow.config;

import android.content.Context;
import com.raizlabs.android.dbflow.config.FlowConfig;
import com.raizlabs.android.dbflow.config.FlowLog;
import com.raizlabs.android.dbflow.converter.TypeConverter;
import com.raizlabs.android.dbflow.runtime.ModelNotifier;
import com.raizlabs.android.dbflow.runtime.TableNotifierRegister;
import com.raizlabs.android.dbflow.sql.QueryBuilder;
import com.raizlabs.android.dbflow.sql.migration.Migration;
import com.raizlabs.android.dbflow.structure.InstanceAdapter;
import com.raizlabs.android.dbflow.structure.InvalidDBConfiguration;
import com.raizlabs.android.dbflow.structure.ModelAdapter;
import com.raizlabs.android.dbflow.structure.ModelViewAdapter;
import com.raizlabs.android.dbflow.structure.QueryModelAdapter;
import com.raizlabs.android.dbflow.structure.RetrievalAdapter;
import com.raizlabs.android.dbflow.structure.database.DatabaseWrapper;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class FlowManager {
    public static final String DEFAULT_AUTHORITY = "com.dbflow.authority";
    private static final String DEFAULT_DATABASE_HOLDER_CLASSNAME;
    private static final String DEFAULT_DATABASE_HOLDER_NAME = "GeneratedDatabaseHolder";
    private static final String DEFAULT_DATABASE_HOLDER_PACKAGE_NAME;
    static FlowConfig config;
    private static GlobalDatabaseHolder globalDatabaseHolder = new GlobalDatabaseHolder();
    private static HashSet<Class<? extends DatabaseHolder>> loadedModules = new HashSet<>();

    public static class GlobalDatabaseHolder extends DatabaseHolder {
        private boolean initialized;

        private GlobalDatabaseHolder() {
            this.initialized = false;
        }

        public void add(DatabaseHolder databaseHolder) {
            this.databaseDefinitionMap.putAll(databaseHolder.databaseDefinitionMap);
            this.databaseNameMap.putAll(databaseHolder.databaseNameMap);
            this.typeConverters.putAll(databaseHolder.typeConverters);
            this.databaseClassLookupMap.putAll(databaseHolder.databaseClassLookupMap);
            this.initialized = true;
        }

        public boolean isInitialized() {
            return this.initialized;
        }
    }

    public static class ModuleNotFoundException extends RuntimeException {
        public ModuleNotFoundException() {
        }

        public ModuleNotFoundException(String str) {
            super(str);
        }

        public ModuleNotFoundException(String str, Throwable th) {
            super(str, th);
        }

        public ModuleNotFoundException(Throwable th) {
            super(th);
        }
    }

    static {
        String name = FlowManager.class.getPackage().getName();
        DEFAULT_DATABASE_HOLDER_PACKAGE_NAME = name;
        DEFAULT_DATABASE_HOLDER_CLASSNAME = name + "." + DEFAULT_DATABASE_HOLDER_NAME;
    }

    private static void checkDatabaseHolder() {
        if (!globalDatabaseHolder.isInitialized()) {
            throw new IllegalStateException("The global database holder is not initialized. Ensure you call FlowManager.init() before accessing the database.");
        }
    }

    public static synchronized void close() {
        synchronized (FlowManager.class) {
            Iterator<Map.Entry<Class<?>, DatabaseDefinition>> it = globalDatabaseHolder.databaseClassLookupMap.entrySet().iterator();
            while (it.hasNext()) {
                it.next().getValue().close();
            }
            config = null;
            globalDatabaseHolder = new GlobalDatabaseHolder();
            loadedModules.clear();
        }
    }

    public static synchronized void destroy() {
        synchronized (FlowManager.class) {
            Iterator<Map.Entry<Class<?>, DatabaseDefinition>> it = globalDatabaseHolder.databaseClassLookupMap.entrySet().iterator();
            while (it.hasNext()) {
                it.next().getValue().destroy();
            }
            config = null;
            globalDatabaseHolder = new GlobalDatabaseHolder();
            loadedModules.clear();
        }
    }

    public static FlowConfig getConfig() {
        FlowConfig flowConfig = config;
        if (flowConfig != null) {
            return flowConfig;
        }
        throw new IllegalStateException("Configuration is not initialized. Please call init(FlowConfig) in your application class.");
    }

    public static Context getContext() {
        FlowConfig flowConfig = config;
        if (flowConfig != null) {
            return flowConfig.getContext();
        }
        throw new IllegalStateException("You must provide a valid FlowConfig instance. We recommend calling init() in your application class.");
    }

    public static DatabaseDefinition getDatabase(Class<?> cls) {
        checkDatabaseHolder();
        DatabaseDefinition database = globalDatabaseHolder.getDatabase(cls);
        if (database != null) {
            return database;
        }
        throw new InvalidDBConfiguration("Database: " + cls.getName() + " is not a registered Database. Did you forget the @Database annotation?");
    }

    public static DatabaseDefinition getDatabaseForTable(Class<?> cls) {
        checkDatabaseHolder();
        DatabaseDefinition databaseForTable = globalDatabaseHolder.getDatabaseForTable(cls);
        if (databaseForTable != null) {
            return databaseForTable;
        }
        throw new InvalidDBConfiguration("Model object: " + cls.getName() + " is not registered with a Database. Did you forget an annotation?");
    }

    public static String getDatabaseName(Class<?> cls) {
        return getDatabase(cls).getDatabaseName();
    }

    public static <TModel> InstanceAdapter<TModel> getInstanceAdapter(Class<TModel> cls) {
        InstanceAdapter<TModel> modelAdapterOrNull = getModelAdapterOrNull(cls);
        if (modelAdapterOrNull == null && (modelAdapterOrNull = getModelViewAdapterOrNull(cls)) == null) {
            modelAdapterOrNull = getQueryModelAdapterOrNull(cls);
        }
        if (modelAdapterOrNull == null) {
            throwCannotFindAdapter("InstanceAdapter", cls);
        }
        return modelAdapterOrNull;
    }

    public static Map<Integer, List<Migration>> getMigrations(String str) {
        return getDatabase(str).getMigrations();
    }

    public static <TModel> ModelAdapter<TModel> getModelAdapter(Class<TModel> cls) {
        ModelAdapter<TModel> modelAdapterOrNull = getModelAdapterOrNull(cls);
        if (modelAdapterOrNull == null) {
            throwCannotFindAdapter("ModelAdapter", cls);
        }
        return modelAdapterOrNull;
    }

    private static <T> ModelAdapter<T> getModelAdapterOrNull(Class<T> cls) {
        return getDatabaseForTable(cls).getModelAdapterForTable(cls);
    }

    public static ModelNotifier getModelNotifierForTable(Class<?> cls) {
        return getDatabaseForTable(cls).getModelNotifier();
    }

    public static <TModelView> ModelViewAdapter<TModelView> getModelViewAdapter(Class<TModelView> cls) {
        ModelViewAdapter<TModelView> modelViewAdapterOrNull = getModelViewAdapterOrNull(cls);
        if (modelViewAdapterOrNull == null) {
            throwCannotFindAdapter("ModelViewAdapter", cls);
        }
        return modelViewAdapterOrNull;
    }

    private static <T> ModelViewAdapter<T> getModelViewAdapterOrNull(Class<T> cls) {
        return getDatabaseForTable(cls).getModelViewAdapterForTable(cls);
    }

    public static <TQueryModel> QueryModelAdapter<TQueryModel> getQueryModelAdapter(Class<TQueryModel> cls) {
        QueryModelAdapter<TQueryModel> queryModelAdapterOrNull = getQueryModelAdapterOrNull(cls);
        if (queryModelAdapterOrNull == null) {
            throwCannotFindAdapter("QueryModelAdapter", cls);
        }
        return queryModelAdapterOrNull;
    }

    private static <T> QueryModelAdapter<T> getQueryModelAdapterOrNull(Class<T> cls) {
        return getDatabaseForTable(cls).getQueryModelAdapterForQueryClass(cls);
    }

    public static <TModel> RetrievalAdapter<TModel> getRetrievalAdapter(Class<TModel> cls) {
        RetrievalAdapter<TModel> modelAdapterOrNull = getModelAdapterOrNull(cls);
        if (modelAdapterOrNull == null && (modelAdapterOrNull = getModelViewAdapterOrNull(cls)) == null) {
            modelAdapterOrNull = getQueryModelAdapterOrNull(cls);
        }
        if (modelAdapterOrNull == null) {
            throwCannotFindAdapter("RetrievalAdapter", cls);
        }
        return modelAdapterOrNull;
    }

    public static Class<?> getTableClassForName(String str, String str2) {
        DatabaseDefinition database = getDatabase(str);
        Class<?> modelClassForName = database.getModelClassForName(str2);
        if (modelClassForName == null && (modelClassForName = database.getModelClassForName(QueryBuilder.quote(str2))) == null) {
            throw new IllegalArgumentException(String.format("The specified table %1s was not found. Did you forget to add the @Table annotation and point it to %1s?", str2, str));
        }
        return modelClassForName;
    }

    public static String getTableName(Class<?> cls) {
        ModelAdapter modelAdapterOrNull = getModelAdapterOrNull(cls);
        if (modelAdapterOrNull != null) {
            return modelAdapterOrNull.getTableName();
        }
        ModelViewAdapter modelViewAdapterOrNull = getModelViewAdapterOrNull(cls);
        if (modelViewAdapterOrNull != null) {
            return modelViewAdapterOrNull.getViewName();
        }
        throwCannotFindAdapter("ModelAdapter/ModelViewAdapter", cls);
        return null;
    }

    public static TypeConverter getTypeConverterForClass(Class<?> cls) {
        checkDatabaseHolder();
        return globalDatabaseHolder.getTypeConverterForClass(cls);
    }

    public static DatabaseWrapper getWritableDatabase(String str) {
        return getDatabase(str).getWritableDatabase();
    }

    public static DatabaseWrapper getWritableDatabaseForTable(Class<?> cls) {
        return getDatabaseForTable(cls).getWritableDatabase();
    }

    public static void init(Context context) {
        init(new FlowConfig.Builder(context).build());
    }

    public static void initModule(Class<? extends DatabaseHolder> cls) {
        loadDatabaseHolder(cls);
    }

    public static boolean isDatabaseIntegrityOk(String str) {
        return getDatabase(str).getHelper().isDatabaseIntegrityOk();
    }

    public static void loadDatabaseHolder(Class<? extends DatabaseHolder> cls) {
        if (loadedModules.contains(cls)) {
            return;
        }
        try {
            DatabaseHolder newInstance = cls.newInstance();
            if (newInstance != null) {
                globalDatabaseHolder.add(newInstance);
                loadedModules.add(cls);
            }
        } catch (Throwable th) {
            th.printStackTrace();
            throw new ModuleNotFoundException("Cannot load " + cls, th);
        }
    }

    public static TableNotifierRegister newRegisterForTable(Class<?> cls) {
        return getModelNotifierForTable(cls).newRegister();
    }

    public static void reset() {
        Iterator<Map.Entry<Class<?>, DatabaseDefinition>> it = globalDatabaseHolder.databaseClassLookupMap.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().reset();
        }
        globalDatabaseHolder.reset();
        loadedModules.clear();
    }

    private static void throwCannotFindAdapter(String str, Class<?> cls) {
        throw new IllegalArgumentException("Cannot find " + str + " for " + cls + ". Ensure the class is annotated with proper annotation.");
    }

    public static DatabaseWrapper getWritableDatabase(Class<?> cls) {
        return getDatabase(cls).getWritableDatabase();
    }

    public static void init(FlowConfig flowConfig) {
        config = flowConfig;
        try {
            loadDatabaseHolder(Class.forName(DEFAULT_DATABASE_HOLDER_CLASSNAME));
        } catch (ModuleNotFoundException e10) {
            FlowLog.log(FlowLog.Level.W, e10.getMessage());
        } catch (ClassNotFoundException unused) {
            FlowLog.log(FlowLog.Level.W, "Could not find the default GeneratedDatabaseHolder");
        }
        if (!flowConfig.databaseHolders().isEmpty()) {
            Iterator<Class<? extends DatabaseHolder>> it = flowConfig.databaseHolders().iterator();
            while (it.hasNext()) {
                loadDatabaseHolder(it.next());
            }
        }
        if (flowConfig.openDatabasesOnInit()) {
            Iterator<DatabaseDefinition> it2 = globalDatabaseHolder.getDatabaseDefinitions().iterator();
            while (it2.hasNext()) {
                it2.next().getWritableDatabase();
            }
        }
    }

    public static DatabaseDefinition getDatabase(String str) {
        checkDatabaseHolder();
        DatabaseDefinition database = globalDatabaseHolder.getDatabase(str);
        if (database != null) {
            return database;
        }
        throw new InvalidDBConfiguration("The specified database" + str + " was not found. Did you forget the @Database annotation?");
    }

    public static Class<?> getTableClassForName(Class<?> cls, String str) {
        DatabaseDefinition database = getDatabase(cls);
        Class<?> modelClassForName = database.getModelClassForName(str);
        if (modelClassForName == null && (modelClassForName = database.getModelClassForName(QueryBuilder.quote(str))) == null) {
            throw new IllegalArgumentException(String.format("The specified table %1s was not found. Did you forget to add the @Table annotation and point it to %1s?", str, cls));
        }
        return modelClassForName;
    }
}
