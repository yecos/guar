package com.raizlabs.android.dbflow.structure;

import com.raizlabs.android.dbflow.config.DatabaseConfig;
import com.raizlabs.android.dbflow.config.DatabaseDefinition;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.config.TableConfig;
import com.raizlabs.android.dbflow.sql.language.OperatorGroup;
import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.raizlabs.android.dbflow.sql.language.property.IProperty;
import com.raizlabs.android.dbflow.sql.queriable.ListModelLoader;
import com.raizlabs.android.dbflow.sql.queriable.SingleModelLoader;
import com.raizlabs.android.dbflow.structure.database.DatabaseWrapper;
import com.raizlabs.android.dbflow.structure.database.FlowCursor;

/* loaded from: classes3.dex */
public abstract class RetrievalAdapter<TModel> {
    private ListModelLoader<TModel> listModelLoader;
    private SingleModelLoader<TModel> singleModelLoader;
    private TableConfig<TModel> tableConfig;

    public RetrievalAdapter(DatabaseDefinition databaseDefinition) {
        DatabaseConfig configForDatabase = FlowManager.getConfig().getConfigForDatabase(databaseDefinition.getAssociatedDatabaseClassFile());
        if (configForDatabase != null) {
            TableConfig<TModel> tableConfigForTable = configForDatabase.getTableConfigForTable(getModelClass());
            this.tableConfig = tableConfigForTable;
            if (tableConfigForTable != null) {
                if (tableConfigForTable.singleModelLoader() != null) {
                    this.singleModelLoader = this.tableConfig.singleModelLoader();
                }
                if (this.tableConfig.listModelLoader() != null) {
                    this.listModelLoader = this.tableConfig.listModelLoader();
                }
            }
        }
    }

    public ListModelLoader<TModel> createListModelLoader() {
        return new ListModelLoader<>(getModelClass());
    }

    public SingleModelLoader<TModel> createSingleModelLoader() {
        return new SingleModelLoader<>(getModelClass());
    }

    public boolean exists(TModel tmodel) {
        return exists(tmodel, FlowManager.getDatabaseForTable(getModelClass()).getWritableDatabase());
    }

    public abstract boolean exists(TModel tmodel, DatabaseWrapper databaseWrapper);

    public ListModelLoader<TModel> getListModelLoader() {
        if (this.listModelLoader == null) {
            this.listModelLoader = createListModelLoader();
        }
        return this.listModelLoader;
    }

    public abstract Class<TModel> getModelClass();

    public ListModelLoader<TModel> getNonCacheableListModelLoader() {
        return new ListModelLoader<>(getModelClass());
    }

    public SingleModelLoader<TModel> getNonCacheableSingleModelLoader() {
        return new SingleModelLoader<>(getModelClass());
    }

    public abstract OperatorGroup getPrimaryConditionClause(TModel tmodel);

    public SingleModelLoader<TModel> getSingleModelLoader() {
        if (this.singleModelLoader == null) {
            this.singleModelLoader = createSingleModelLoader();
        }
        return this.singleModelLoader;
    }

    public TableConfig<TModel> getTableConfig() {
        return this.tableConfig;
    }

    public void load(TModel tmodel) {
        load(tmodel, FlowManager.getDatabaseForTable(getModelClass()).getWritableDatabase());
    }

    public abstract void loadFromCursor(FlowCursor flowCursor, TModel tmodel);

    public void setListModelLoader(ListModelLoader<TModel> listModelLoader) {
        this.listModelLoader = listModelLoader;
    }

    public void setSingleModelLoader(SingleModelLoader<TModel> singleModelLoader) {
        this.singleModelLoader = singleModelLoader;
    }

    public void load(TModel tmodel, DatabaseWrapper databaseWrapper) {
        getNonCacheableSingleModelLoader().load(databaseWrapper, SQLite.select(new IProperty[0]).from(getModelClass()).where(getPrimaryConditionClause(tmodel)).getQuery(), tmodel);
    }
}
