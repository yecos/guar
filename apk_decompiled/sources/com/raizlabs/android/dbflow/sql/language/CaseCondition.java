package com.raizlabs.android.dbflow.sql.language;

import com.raizlabs.android.dbflow.sql.Query;
import com.raizlabs.android.dbflow.sql.QueryBuilder;
import com.raizlabs.android.dbflow.sql.language.property.IProperty;

/* loaded from: classes3.dex */
public class CaseCondition<TReturn> implements Query {
    private final Case<TReturn> caze;
    private boolean isThenPropertySet;
    private IProperty property;
    private SQLOperator sqlOperator;
    private IProperty thenProperty;
    private TReturn thenValue;
    private TReturn whenValue;

    public CaseCondition(Case<TReturn> r12, SQLOperator sQLOperator) {
        this.caze = r12;
        this.sqlOperator = sQLOperator;
    }

    @Override // com.raizlabs.android.dbflow.sql.Query
    public String getQuery() {
        QueryBuilder queryBuilder = new QueryBuilder(" WHEN ");
        if (this.caze.isEfficientCase()) {
            Object obj = this.property;
            if (obj == null) {
                obj = this.whenValue;
            }
            queryBuilder.append(BaseOperator.convertValueToString(obj, false));
        } else {
            this.sqlOperator.appendConditionToQuery(queryBuilder);
        }
        queryBuilder.append(" THEN ").append(BaseOperator.convertValueToString(this.isThenPropertySet ? this.thenProperty : this.thenValue, false));
        return queryBuilder.getQuery();
    }

    public Case<TReturn> then(TReturn treturn) {
        this.thenValue = treturn;
        return this.caze;
    }

    public String toString() {
        return getQuery();
    }

    public Case<TReturn> then(IProperty iProperty) {
        this.thenProperty = iProperty;
        this.isThenPropertySet = true;
        return this.caze;
    }

    public CaseCondition(Case<TReturn> r12, TReturn treturn) {
        this.caze = r12;
        this.whenValue = treturn;
    }

    public CaseCondition(Case<TReturn> r12, IProperty iProperty) {
        this.caze = r12;
        this.property = iProperty;
    }
}
