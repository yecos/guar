package com.raizlabs.android.dbflow.sql.language;

import com.raizlabs.android.dbflow.sql.QueryBuilder;

/* loaded from: classes3.dex */
public interface SQLOperator {
    void appendConditionToQuery(QueryBuilder queryBuilder);

    String columnName();

    boolean hasSeparator();

    String operation();

    SQLOperator separator(String str);

    String separator();

    Object value();
}
