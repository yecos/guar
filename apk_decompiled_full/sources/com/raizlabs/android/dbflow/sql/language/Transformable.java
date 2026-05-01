package com.raizlabs.android.dbflow.sql.language;

import com.raizlabs.android.dbflow.sql.language.property.IProperty;
import java.util.List;

/* loaded from: classes3.dex */
public interface Transformable<T> {
    Where<T> groupBy(NameAlias... nameAliasArr);

    Where<T> groupBy(IProperty... iPropertyArr);

    Where<T> having(SQLOperator... sQLOperatorArr);

    Where<T> limit(int i10);

    Where<T> offset(int i10);

    Where<T> orderBy(NameAlias nameAlias, boolean z10);

    Where<T> orderBy(OrderBy orderBy);

    Where<T> orderBy(IProperty iProperty, boolean z10);

    Where<T> orderByAll(List<OrderBy> list);
}
