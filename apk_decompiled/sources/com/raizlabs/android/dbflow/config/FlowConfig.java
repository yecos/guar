package com.raizlabs.android.dbflow.config;

import android.content.Context;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* loaded from: classes3.dex */
public final class FlowConfig {
    private final Context context;
    private final Map<Class<?>, DatabaseConfig> databaseConfigMap;
    private final Set<Class<? extends DatabaseHolder>> databaseHolders;
    private final boolean openDatabasesOnInit;

    public static class Builder {
        final Context context;
        boolean openDatabasesOnInit;
        Set<Class<? extends DatabaseHolder>> databaseHolders = new HashSet();
        final Map<Class<?>, DatabaseConfig> databaseConfigMap = new HashMap();

        public Builder(Context context) {
            this.context = context.getApplicationContext();
        }

        public Builder addDatabaseConfig(DatabaseConfig databaseConfig) {
            this.databaseConfigMap.put(databaseConfig.databaseClass(), databaseConfig);
            return this;
        }

        public Builder addDatabaseHolder(Class<? extends DatabaseHolder> cls) {
            this.databaseHolders.add(cls);
            return this;
        }

        public FlowConfig build() {
            return new FlowConfig(this);
        }

        public Builder openDatabasesOnInit(boolean z10) {
            this.openDatabasesOnInit = z10;
            return this;
        }
    }

    public FlowConfig(Builder builder) {
        this.databaseHolders = Collections.unmodifiableSet(builder.databaseHolders);
        this.databaseConfigMap = builder.databaseConfigMap;
        this.context = builder.context;
        this.openDatabasesOnInit = builder.openDatabasesOnInit;
    }

    public static Builder builder(Context context) {
        return new Builder(context);
    }

    public Map<Class<?>, DatabaseConfig> databaseConfigMap() {
        return this.databaseConfigMap;
    }

    public Set<Class<? extends DatabaseHolder>> databaseHolders() {
        return this.databaseHolders;
    }

    public DatabaseConfig getConfigForDatabase(Class<?> cls) {
        return databaseConfigMap().get(cls);
    }

    public Context getContext() {
        return this.context;
    }

    public boolean openDatabasesOnInit() {
        return this.openDatabasesOnInit;
    }
}
