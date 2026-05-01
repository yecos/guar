package com.raizlabs.android.dbflow.sql.language;

import com.raizlabs.android.dbflow.sql.Query;
import com.raizlabs.android.dbflow.sql.QueryBuilder;
import com.raizlabs.android.dbflow.sql.language.property.IProperty;
import com.raizlabs.android.dbflow.sql.language.property.Property;
import com.taobao.accs.flowcontrol.FlowControl;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes3.dex */
public class Select implements Query {
    public static final int ALL = 1;
    public static final int DISTINCT = 0;
    public static final int NONE = -1;
    private int mSelectQualifier = -1;
    private final List<IProperty> propertyList;

    public Select(IProperty... iPropertyArr) {
        ArrayList arrayList = new ArrayList();
        this.propertyList = arrayList;
        Collections.addAll(arrayList, iPropertyArr);
        if (arrayList.isEmpty()) {
            arrayList.add(Property.ALL_PROPERTY);
        }
    }

    private Select selectQualifier(int i10) {
        this.mSelectQualifier = i10;
        return this;
    }

    public Select distinct() {
        return selectQualifier(0);
    }

    public <TModel> From<TModel> from(Class<TModel> cls) {
        return new From<>(this, cls);
    }

    @Override // com.raizlabs.android.dbflow.sql.Query
    public String getQuery() {
        QueryBuilder queryBuilder = new QueryBuilder("SELECT ");
        int i10 = this.mSelectQualifier;
        if (i10 != -1) {
            if (i10 == 0) {
                queryBuilder.append("DISTINCT");
            } else if (i10 == 1) {
                queryBuilder.append(FlowControl.SERVICE_ALL);
            }
            queryBuilder.appendSpace();
        }
        queryBuilder.append(QueryBuilder.join(",", this.propertyList));
        queryBuilder.appendSpace();
        return queryBuilder.getQuery();
    }

    public String toString() {
        return getQuery();
    }
}
