package com.raizlabs.android.dbflow.sql.language;

import com.raizlabs.android.dbflow.sql.Query;
import com.raizlabs.android.dbflow.sql.QueryBuilder;
import com.raizlabs.android.dbflow.sql.language.Operator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class OperatorGroup extends BaseOperator implements Query, Iterable<SQLOperator> {
    private boolean allCommaSeparated;
    private final List<SQLOperator> conditionsList;
    private boolean isChanged;
    private QueryBuilder query;
    private boolean useParenthesis;

    public OperatorGroup(NameAlias nameAlias) {
        super(nameAlias);
        this.conditionsList = new ArrayList();
        this.useParenthesis = true;
        this.separator = Operator.Operation.AND;
    }

    public static OperatorGroup clause() {
        return new OperatorGroup();
    }

    private QueryBuilder getQuerySafe() {
        QueryBuilder queryBuilder = new QueryBuilder();
        appendConditionToQuery(queryBuilder);
        return queryBuilder;
    }

    public static OperatorGroup nonGroupingClause() {
        return new OperatorGroup().setUseParenthesis(false);
    }

    private OperatorGroup operator(String str, SQLOperator sQLOperator) {
        if (sQLOperator != null) {
            setPreviousSeparator(str);
            this.conditionsList.add(sQLOperator);
            this.isChanged = true;
        }
        return this;
    }

    private void setPreviousSeparator(String str) {
        if (this.conditionsList.size() > 0) {
            this.conditionsList.get(r0.size() - 1).separator(str);
        }
    }

    public OperatorGroup and(SQLOperator sQLOperator) {
        return operator(Operator.Operation.AND, sQLOperator);
    }

    public OperatorGroup andAll(SQLOperator... sQLOperatorArr) {
        for (SQLOperator sQLOperator : sQLOperatorArr) {
            and(sQLOperator);
        }
        return this;
    }

    @Override // com.raizlabs.android.dbflow.sql.language.SQLOperator
    public void appendConditionToQuery(QueryBuilder queryBuilder) {
        int size = this.conditionsList.size();
        if (this.useParenthesis && size > 0) {
            queryBuilder.append("(");
        }
        for (int i10 = 0; i10 < size; i10++) {
            SQLOperator sQLOperator = this.conditionsList.get(i10);
            sQLOperator.appendConditionToQuery(queryBuilder);
            if (!this.allCommaSeparated && sQLOperator.hasSeparator() && i10 < size - 1) {
                queryBuilder.appendSpaceSeparated(sQLOperator.separator());
            } else if (i10 < size - 1) {
                queryBuilder.append(", ");
            }
        }
        if (!this.useParenthesis || size <= 0) {
            return;
        }
        queryBuilder.append(")");
    }

    public List<SQLOperator> getConditions() {
        return this.conditionsList;
    }

    @Override // com.raizlabs.android.dbflow.sql.Query
    public String getQuery() {
        if (this.isChanged) {
            this.query = getQuerySafe();
        }
        QueryBuilder queryBuilder = this.query;
        return queryBuilder == null ? "" : queryBuilder.toString();
    }

    @Override // java.lang.Iterable
    public Iterator<SQLOperator> iterator() {
        return this.conditionsList.iterator();
    }

    public OperatorGroup or(SQLOperator sQLOperator) {
        return operator(Operator.Operation.OR, sQLOperator);
    }

    public OperatorGroup orAll(SQLOperator... sQLOperatorArr) {
        for (SQLOperator sQLOperator : sQLOperatorArr) {
            or(sQLOperator);
        }
        return this;
    }

    public OperatorGroup setAllCommaSeparated(boolean z10) {
        this.allCommaSeparated = z10;
        this.isChanged = true;
        return this;
    }

    public OperatorGroup setUseParenthesis(boolean z10) {
        this.useParenthesis = z10;
        this.isChanged = true;
        return this;
    }

    public int size() {
        return this.conditionsList.size();
    }

    public String toString() {
        return getQuerySafe().toString();
    }

    public static OperatorGroup clause(SQLOperator... sQLOperatorArr) {
        return new OperatorGroup().andAll(sQLOperatorArr);
    }

    public static OperatorGroup nonGroupingClause(SQLOperator... sQLOperatorArr) {
        return new OperatorGroup().setUseParenthesis(false).andAll(sQLOperatorArr);
    }

    public OperatorGroup andAll(Collection<SQLOperator> collection) {
        Iterator<SQLOperator> it = collection.iterator();
        while (it.hasNext()) {
            and(it.next());
        }
        return this;
    }

    public OperatorGroup orAll(Collection<SQLOperator> collection) {
        Iterator<SQLOperator> it = collection.iterator();
        while (it.hasNext()) {
            or(it.next());
        }
        return this;
    }

    public OperatorGroup() {
        this(null);
    }
}
