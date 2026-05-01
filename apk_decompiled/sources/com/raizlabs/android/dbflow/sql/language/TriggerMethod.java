package com.raizlabs.android.dbflow.sql.language;

import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.sql.Query;
import com.raizlabs.android.dbflow.sql.QueryBuilder;
import com.raizlabs.android.dbflow.sql.language.property.IProperty;

/* loaded from: classes3.dex */
public class TriggerMethod<TModel> implements Query {
    public static final String DELETE = "DELETE";
    public static final String INSERT = "INSERT";
    public static final String UPDATE = "UPDATE";
    boolean forEachRow = false;
    private final String methodName;
    Class<TModel> onTable;
    private IProperty[] properties;
    final Trigger trigger;
    private SQLOperator whenCondition;

    public TriggerMethod(Trigger trigger, String str, Class<TModel> cls, IProperty... iPropertyArr) {
        this.trigger = trigger;
        this.methodName = str;
        this.onTable = cls;
        if (iPropertyArr == null || iPropertyArr.length <= 0 || iPropertyArr[0] == null) {
            return;
        }
        if (!str.equals(UPDATE)) {
            throw new IllegalArgumentException("An Trigger OF can only be used with an UPDATE method");
        }
        this.properties = iPropertyArr;
    }

    public CompletedTrigger<TModel> begin(Query query) {
        return new CompletedTrigger<>(this, query);
    }

    public TriggerMethod<TModel> forEachRow() {
        this.forEachRow = true;
        return this;
    }

    @Override // com.raizlabs.android.dbflow.sql.Query
    public String getQuery() {
        QueryBuilder append = new QueryBuilder(this.trigger.getQuery()).append(this.methodName);
        IProperty[] iPropertyArr = this.properties;
        if (iPropertyArr != null && iPropertyArr.length > 0) {
            append.appendSpaceSeparated("OF").appendArray(this.properties);
        }
        append.appendSpaceSeparated("ON").append(FlowManager.getTableName(this.onTable));
        if (this.forEachRow) {
            append.appendSpaceSeparated("FOR EACH ROW");
        }
        if (this.whenCondition != null) {
            append.append(" WHEN ");
            this.whenCondition.appendConditionToQuery(append);
            append.appendSpace();
        }
        append.appendSpace();
        return append.getQuery();
    }

    public TriggerMethod<TModel> when(SQLOperator sQLOperator) {
        this.whenCondition = sQLOperator;
        return this;
    }
}
