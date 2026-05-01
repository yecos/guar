package com.raizlabs.android.dbflow.sql.language;

import com.raizlabs.android.dbflow.sql.Query;
import com.raizlabs.android.dbflow.sql.QueryBuilder;

/* loaded from: classes3.dex */
public class ExistenceOperator implements SQLOperator, Query {
    private Where innerWhere;

    @Override // com.raizlabs.android.dbflow.sql.language.SQLOperator
    public void appendConditionToQuery(QueryBuilder queryBuilder) {
        queryBuilder.appendQualifier("EXISTS", "(" + this.innerWhere.getQuery().trim() + ")");
    }

    @Override // com.raizlabs.android.dbflow.sql.language.SQLOperator
    public String columnName() {
        throw new RuntimeException("Method not valid for ExistenceOperator");
    }

    @Override // com.raizlabs.android.dbflow.sql.Query
    public String getQuery() {
        QueryBuilder queryBuilder = new QueryBuilder();
        appendConditionToQuery(queryBuilder);
        return queryBuilder.getQuery();
    }

    @Override // com.raizlabs.android.dbflow.sql.language.SQLOperator
    public boolean hasSeparator() {
        return false;
    }

    @Override // com.raizlabs.android.dbflow.sql.language.SQLOperator
    public String operation() {
        return "";
    }

    @Override // com.raizlabs.android.dbflow.sql.language.SQLOperator
    public String separator() {
        throw new RuntimeException("Method not valid for ExistenceOperator");
    }

    @Override // com.raizlabs.android.dbflow.sql.language.SQLOperator
    public Object value() {
        return this.innerWhere;
    }

    public ExistenceOperator where(Where where) {
        this.innerWhere = where;
        return this;
    }

    @Override // com.raizlabs.android.dbflow.sql.language.SQLOperator
    public SQLOperator separator(String str) {
        throw new RuntimeException("Method not valid for ExistenceOperator");
    }
}
