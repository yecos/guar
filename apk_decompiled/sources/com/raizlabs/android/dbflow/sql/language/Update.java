package com.raizlabs.android.dbflow.sql.language;

import com.raizlabs.android.dbflow.annotation.ConflictAction;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.sql.Query;
import com.raizlabs.android.dbflow.sql.QueryBuilder;
import com.raizlabs.android.dbflow.sql.language.Operator;

/* loaded from: classes3.dex */
public class Update<TModel> implements Query {
    private ConflictAction conflictAction = ConflictAction.NONE;
    private final Class<TModel> table;

    public Update(Class<TModel> cls) {
        this.table = cls;
    }

    public Update<TModel> conflictAction(ConflictAction conflictAction) {
        this.conflictAction = conflictAction;
        return this;
    }

    @Override // com.raizlabs.android.dbflow.sql.Query
    public String getQuery() {
        QueryBuilder queryBuilder = new QueryBuilder("UPDATE ");
        ConflictAction conflictAction = this.conflictAction;
        if (conflictAction != null && !conflictAction.equals(ConflictAction.NONE)) {
            queryBuilder.append(Operator.Operation.OR).appendSpaceSeparated(this.conflictAction.name());
        }
        queryBuilder.append(FlowManager.getTableName(this.table)).appendSpace();
        return queryBuilder.getQuery();
    }

    public Class<TModel> getTable() {
        return this.table;
    }

    public Update<TModel> or(ConflictAction conflictAction) {
        return conflictAction(conflictAction);
    }

    public Update<TModel> orAbort() {
        return conflictAction(ConflictAction.ABORT);
    }

    public Update<TModel> orFail() {
        return conflictAction(ConflictAction.FAIL);
    }

    public Update<TModel> orIgnore() {
        return conflictAction(ConflictAction.IGNORE);
    }

    public Update<TModel> orReplace() {
        return conflictAction(ConflictAction.REPLACE);
    }

    public Update<TModel> orRollback() {
        return conflictAction(ConflictAction.ROLLBACK);
    }

    public Set<TModel> set(SQLOperator... sQLOperatorArr) {
        return new Set(this, this.table).conditions(sQLOperatorArr);
    }
}
