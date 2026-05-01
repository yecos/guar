package com.raizlabs.android.dbflow.sql.language;

import com.raizlabs.android.dbflow.sql.Query;

/* loaded from: classes3.dex */
public interface WhereBase<TModel> extends Query, Actionable {
    Query getQueryBuilderBase();

    Class<TModel> getTable();
}
