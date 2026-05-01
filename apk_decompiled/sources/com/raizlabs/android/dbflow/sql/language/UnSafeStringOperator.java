package com.raizlabs.android.dbflow.sql.language;

import com.raizlabs.android.dbflow.StringUtils;
import com.raizlabs.android.dbflow.sql.Query;
import com.raizlabs.android.dbflow.sql.QueryBuilder;

/* loaded from: classes3.dex */
public class UnSafeStringOperator implements SQLOperator, Query {
    private final String conditionString;
    private String separator = "";

    public UnSafeStringOperator(String str, String[] strArr) {
        if (str != null) {
            for (String str2 : strArr) {
                str = str.replaceFirst("\\?", str2);
            }
        }
        this.conditionString = str;
    }

    @Override // com.raizlabs.android.dbflow.sql.language.SQLOperator
    public void appendConditionToQuery(QueryBuilder queryBuilder) {
        queryBuilder.append(this.conditionString);
    }

    @Override // com.raizlabs.android.dbflow.sql.language.SQLOperator
    public String columnName() {
        return "";
    }

    @Override // com.raizlabs.android.dbflow.sql.Query
    public String getQuery() {
        QueryBuilder queryBuilder = new QueryBuilder();
        appendConditionToQuery(queryBuilder);
        return queryBuilder.getQuery();
    }

    @Override // com.raizlabs.android.dbflow.sql.language.SQLOperator
    public boolean hasSeparator() {
        return StringUtils.isNotNullOrEmpty(this.separator);
    }

    @Override // com.raizlabs.android.dbflow.sql.language.SQLOperator
    public String operation() {
        return "";
    }

    @Override // com.raizlabs.android.dbflow.sql.language.SQLOperator
    public String separator() {
        return this.separator;
    }

    @Override // com.raizlabs.android.dbflow.sql.language.SQLOperator
    public Object value() {
        return "";
    }

    @Override // com.raizlabs.android.dbflow.sql.language.SQLOperator
    public SQLOperator separator(String str) {
        this.separator = str;
        return this;
    }
}
