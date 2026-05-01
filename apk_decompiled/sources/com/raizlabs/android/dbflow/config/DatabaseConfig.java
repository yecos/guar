package com.raizlabs.android.dbflow.config;

import com.raizlabs.android.dbflow.StringUtils;
import com.raizlabs.android.dbflow.runtime.BaseTransactionManager;
import com.raizlabs.android.dbflow.runtime.ModelNotifier;
import com.raizlabs.android.dbflow.structure.database.DatabaseHelperListener;
import com.raizlabs.android.dbflow.structure.database.OpenHelper;
import com.umeng.analytics.process.a;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public final class DatabaseConfig {
    private final Class<?> databaseClass;
    private final String databaseExtensionName;
    private final String databaseName;
    private final DatabaseHelperListener helperListener;
    private final boolean inMemory;
    private final ModelNotifier modelNotifier;
    private final OpenHelperCreator openHelperCreator;
    private final Map<Class<?>, TableConfig> tableConfigMap;
    private final TransactionManagerCreator transactionManagerCreator;

    public static final class Builder {
        final Class<?> databaseClass;
        String databaseExtensionName;
        String databaseName;
        DatabaseHelperListener helperListener;
        ModelNotifier modelNotifier;
        OpenHelperCreator openHelperCreator;
        TransactionManagerCreator transactionManagerCreator;
        final Map<Class<?>, TableConfig> tableConfigMap = new HashMap();
        boolean inMemory = false;

        public Builder(Class<?> cls) {
            this.databaseClass = cls;
        }

        public Builder addTableConfig(TableConfig<?> tableConfig) {
            this.tableConfigMap.put(tableConfig.tableClass(), tableConfig);
            return this;
        }

        public DatabaseConfig build() {
            return new DatabaseConfig(this);
        }

        public Builder databaseName(String str) {
            this.databaseName = str;
            return this;
        }

        public Builder extensionName(String str) {
            this.databaseExtensionName = str;
            return this;
        }

        public Builder helperListener(DatabaseHelperListener databaseHelperListener) {
            this.helperListener = databaseHelperListener;
            return this;
        }

        public Builder inMemory() {
            this.inMemory = true;
            return this;
        }

        public Builder modelNotifier(ModelNotifier modelNotifier) {
            this.modelNotifier = modelNotifier;
            return this;
        }

        public Builder openHelper(OpenHelperCreator openHelperCreator) {
            this.openHelperCreator = openHelperCreator;
            return this;
        }

        public Builder transactionManagerCreator(TransactionManagerCreator transactionManagerCreator) {
            this.transactionManagerCreator = transactionManagerCreator;
            return this;
        }
    }

    public interface OpenHelperCreator {
        OpenHelper createHelper(DatabaseDefinition databaseDefinition, DatabaseHelperListener databaseHelperListener);
    }

    public interface TransactionManagerCreator {
        BaseTransactionManager createManager(DatabaseDefinition databaseDefinition);
    }

    public DatabaseConfig(Builder builder) {
        String str;
        this.openHelperCreator = builder.openHelperCreator;
        Class<?> cls = builder.databaseClass;
        this.databaseClass = cls;
        this.transactionManagerCreator = builder.transactionManagerCreator;
        this.helperListener = builder.helperListener;
        this.tableConfigMap = builder.tableConfigMap;
        this.modelNotifier = builder.modelNotifier;
        this.inMemory = builder.inMemory;
        String str2 = builder.databaseName;
        if (str2 == null) {
            this.databaseName = cls.getSimpleName();
        } else {
            this.databaseName = str2;
        }
        String str3 = builder.databaseExtensionName;
        if (str3 == null) {
            this.databaseExtensionName = a.f10619d;
            return;
        }
        if (StringUtils.isNotNullOrEmpty(str3)) {
            str = "." + builder.databaseExtensionName;
        } else {
            str = "";
        }
        this.databaseExtensionName = str;
    }

    public static Builder builder(Class<?> cls) {
        return new Builder(cls);
    }

    public static Builder inMemoryBuilder(Class<?> cls) {
        return new Builder(cls).inMemory();
    }

    public Class<?> databaseClass() {
        return this.databaseClass;
    }

    public String getDatabaseExtensionName() {
        return this.databaseExtensionName;
    }

    public String getDatabaseName() {
        return this.databaseName;
    }

    public <TModel> TableConfig<TModel> getTableConfigForTable(Class<TModel> cls) {
        return tableConfigMap().get(cls);
    }

    public OpenHelperCreator helperCreator() {
        return this.openHelperCreator;
    }

    public DatabaseHelperListener helperListener() {
        return this.helperListener;
    }

    public boolean isInMemory() {
        return this.inMemory;
    }

    public ModelNotifier modelNotifier() {
        return this.modelNotifier;
    }

    public Map<Class<?>, TableConfig> tableConfigMap() {
        return this.tableConfigMap;
    }

    public TransactionManagerCreator transactionManagerCreator() {
        return this.transactionManagerCreator;
    }
}
