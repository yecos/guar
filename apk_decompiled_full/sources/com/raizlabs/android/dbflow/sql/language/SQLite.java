package com.raizlabs.android.dbflow.sql.language;

import com.raizlabs.android.dbflow.sql.language.property.IProperty;
import com.raizlabs.android.dbflow.sql.language.property.Property;

/* loaded from: classes3.dex */
public class SQLite {
    public static <TReturn> Case<TReturn> _case(Property<TReturn> property) {
        return new Case<>(property);
    }

    public static <TReturn> CaseCondition<TReturn> caseWhen(SQLOperator sQLOperator) {
        return new Case().when(sQLOperator);
    }

    public static Trigger createTrigger(String str) {
        return Trigger.create(str);
    }

    public static Delete delete() {
        return new Delete();
    }

    public static <TModel> Index<TModel> index(String str) {
        return new Index<>(str);
    }

    public static <TModel> Insert<TModel> insert(Class<TModel> cls) {
        return new Insert<>(cls);
    }

    public static Select select(IProperty... iPropertyArr) {
        return new Select(iPropertyArr);
    }

    public static Select selectCountOf(IProperty... iPropertyArr) {
        return new Select(Method.count(iPropertyArr));
    }

    public static <TModel> Update<TModel> update(Class<TModel> cls) {
        return new Update<>(cls);
    }

    public static <TReturn> Case<TReturn> _case(IProperty iProperty) {
        return new Case<>(iProperty);
    }

    public static <TModel> From<TModel> delete(Class<TModel> cls) {
        return delete().from(cls);
    }
}
