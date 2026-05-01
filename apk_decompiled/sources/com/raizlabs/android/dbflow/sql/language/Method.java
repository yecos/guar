package com.raizlabs.android.dbflow.sql.language;

import com.raizlabs.android.dbflow.sql.SQLiteType;
import com.raizlabs.android.dbflow.sql.language.property.IProperty;
import com.raizlabs.android.dbflow.sql.language.property.Property;
import com.raizlabs.android.dbflow.sql.language.property.PropertyFactory;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class Method extends Property {
    private final IProperty methodProperty;
    private List<String> operationsList;
    private final List<IProperty> propertyList;

    public static class Cast {
        private final IProperty property;

        public IProperty as(SQLiteType sQLiteType) {
            return new Method("CAST", new Property(this.property.getTable(), this.property.getNameAlias().newBuilder().shouldAddIdentifierToAliasName(false).as(sQLiteType.name()).build()));
        }

        private Cast(IProperty iProperty) {
            this.property = iProperty;
        }
    }

    public Method(IProperty... iPropertyArr) {
        this(null, iPropertyArr);
    }

    public static Method avg(IProperty... iPropertyArr) {
        return new Method("AVG", iPropertyArr);
    }

    public static Cast cast(IProperty iProperty) {
        return new Cast(iProperty);
    }

    public static Method count(IProperty... iPropertyArr) {
        return new Method("COUNT", iPropertyArr);
    }

    public static Method date(String str, String... strArr) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(PropertyFactory.from(str));
        for (String str2 : strArr) {
            arrayList.add(PropertyFactory.from(str2));
        }
        return new Method("date", (IProperty[]) arrayList.toArray(new IProperty[arrayList.size()]));
    }

    public static Method datetime(long j10, String... strArr) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(PropertyFactory.from(j10));
        for (String str : strArr) {
            arrayList.add(PropertyFactory.from(str));
        }
        return new Method("datetime", (IProperty[]) arrayList.toArray(new IProperty[arrayList.size()]));
    }

    public static Method group_concat(IProperty... iPropertyArr) {
        return new Method("GROUP_CONCAT", iPropertyArr);
    }

    public static Method ifNull(IProperty iProperty, IProperty iProperty2) {
        return new Method("IFNULL", iProperty, iProperty2);
    }

    public static Method max(IProperty... iPropertyArr) {
        return new Method("MAX", iPropertyArr);
    }

    public static Method min(IProperty... iPropertyArr) {
        return new Method("MIN", iPropertyArr);
    }

    public static Method nullIf(IProperty iProperty, IProperty iProperty2) {
        return new Method("NULLIF", iProperty, iProperty2);
    }

    public static Method replace(IProperty iProperty, String str, String str2) {
        return new Method("REPLACE", iProperty, PropertyFactory.from(str), PropertyFactory.from(str2));
    }

    public static Method strftime(String str, String str2, String... strArr) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(PropertyFactory.from(str));
        arrayList.add(PropertyFactory.from(str2));
        for (String str3 : strArr) {
            arrayList.add(PropertyFactory.from(str3));
        }
        return new Method("strftime", (IProperty[]) arrayList.toArray(new IProperty[arrayList.size()]));
    }

    public static Method sum(IProperty... iPropertyArr) {
        return new Method("SUM", iPropertyArr);
    }

    public static Method total(IProperty... iPropertyArr) {
        return new Method("TOTAL", iPropertyArr);
    }

    public Method addProperty(IProperty iProperty) {
        return append(iProperty, ",");
    }

    public Method append(IProperty iProperty, String str) {
        if (this.propertyList.size() == 1 && this.propertyList.get(0) == Property.ALL_PROPERTY) {
            this.propertyList.remove(0);
        }
        this.propertyList.add(iProperty);
        this.operationsList.add(str);
        return this;
    }

    @Override // com.raizlabs.android.dbflow.sql.language.property.Property, com.raizlabs.android.dbflow.sql.language.property.IProperty
    public NameAlias getNameAlias() {
        if (this.nameAlias == null) {
            String query = this.methodProperty.getQuery();
            if (query == null) {
                query = "";
            }
            String str = query + "(";
            List<IProperty> propertyList = getPropertyList();
            for (int i10 = 0; i10 < propertyList.size(); i10++) {
                IProperty iProperty = propertyList.get(i10);
                if (i10 > 0) {
                    str = str + this.operationsList.get(i10) + " ";
                }
                str = str + iProperty.toString();
            }
            this.nameAlias = NameAlias.rawBuilder(str + ")").build();
        }
        return this.nameAlias;
    }

    public List<IProperty> getPropertyList() {
        return this.propertyList;
    }

    public Method(String str, IProperty... iPropertyArr) {
        super((Class<?>) null, (String) null);
        ArrayList arrayList = new ArrayList();
        this.propertyList = arrayList;
        this.operationsList = new ArrayList();
        this.methodProperty = new Property((Class<?>) null, NameAlias.rawBuilder(str).build());
        if (iPropertyArr.length == 0) {
            arrayList.add(Property.ALL_PROPERTY);
            return;
        }
        for (IProperty iProperty : iPropertyArr) {
            addProperty(iProperty);
        }
    }

    @Override // com.raizlabs.android.dbflow.sql.language.property.Property, com.raizlabs.android.dbflow.sql.language.property.IProperty
    public Property div(IProperty iProperty) {
        return append(iProperty, " /");
    }

    @Override // com.raizlabs.android.dbflow.sql.language.property.Property, com.raizlabs.android.dbflow.sql.language.property.IProperty
    public Property rem(IProperty iProperty) {
        return append(iProperty, " %");
    }

    @Override // com.raizlabs.android.dbflow.sql.language.property.Property, com.raizlabs.android.dbflow.sql.language.property.IProperty
    public Property times(IProperty iProperty) {
        return append(iProperty, " *");
    }

    @Override // com.raizlabs.android.dbflow.sql.language.property.Property, com.raizlabs.android.dbflow.sql.language.property.IProperty
    public Method minus(IProperty iProperty) {
        return append(iProperty, " -");
    }

    @Override // com.raizlabs.android.dbflow.sql.language.property.Property, com.raizlabs.android.dbflow.sql.language.property.IProperty
    public Method plus(IProperty iProperty) {
        return append(iProperty, " +");
    }
}
