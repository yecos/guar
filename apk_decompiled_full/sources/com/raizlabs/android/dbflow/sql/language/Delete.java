package com.raizlabs.android.dbflow.sql.language;

import com.raizlabs.android.dbflow.sql.Query;
import com.raizlabs.android.dbflow.sql.QueryBuilder;

/* loaded from: classes3.dex */
public class Delete implements Query {
    public static <TModel> void table(Class<TModel> cls, SQLOperator... sQLOperatorArr) {
        new Delete().from(cls).where(sQLOperatorArr).executeUpdateDelete();
    }

    public static void tables(Class<?>... clsArr) {
        for (Class<?> cls : clsArr) {
            table(cls, new SQLOperator[0]);
        }
    }

    public <TModel> From<TModel> from(Class<TModel> cls) {
        return new From<>(this, cls);
    }

    @Override // com.raizlabs.android.dbflow.sql.Query
    public String getQuery() {
        return new QueryBuilder().append("DELETE").appendSpace().getQuery();
    }
}
