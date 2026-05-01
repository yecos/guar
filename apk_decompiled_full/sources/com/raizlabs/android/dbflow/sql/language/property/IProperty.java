package com.raizlabs.android.dbflow.sql.language.property;

import com.raizlabs.android.dbflow.sql.Query;
import com.raizlabs.android.dbflow.sql.language.NameAlias;
import com.raizlabs.android.dbflow.sql.language.OrderBy;
import com.raizlabs.android.dbflow.sql.language.property.IProperty;

/* loaded from: classes3.dex */
public interface IProperty<P extends IProperty> extends Query {
    P as(String str);

    OrderBy asc();

    P concatenate(IProperty iProperty);

    OrderBy desc();

    P distinct();

    P div(IProperty iProperty);

    String getCursorKey();

    NameAlias getNameAlias();

    Class<?> getTable();

    P minus(IProperty iProperty);

    P plus(IProperty iProperty);

    P rem(IProperty iProperty);

    P times(IProperty iProperty);

    P withTable();

    P withTable(NameAlias nameAlias);
}
