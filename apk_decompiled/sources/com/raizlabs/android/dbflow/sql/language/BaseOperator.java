package com.raizlabs.android.dbflow.sql.language;

import android.database.DatabaseUtils;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.converter.TypeConverter;
import com.raizlabs.android.dbflow.data.Blob;
import com.raizlabs.android.dbflow.sql.Query;
import com.raizlabs.android.dbflow.sql.QueryBuilder;
import com.raizlabs.android.dbflow.sql.SqlUtils;
import com.raizlabs.android.dbflow.sql.language.Operator;

/* loaded from: classes3.dex */
public abstract class BaseOperator implements SQLOperator {
    protected boolean isValueSet;
    protected NameAlias nameAlias;
    protected String operation = "";
    protected String postArg;
    protected String separator;
    protected Object value;

    public BaseOperator(NameAlias nameAlias) {
        this.nameAlias = nameAlias;
    }

    public static String convertValueToString(Object obj, boolean z10) {
        return convertValueToString(obj, z10, true);
    }

    public static String joinArguments(CharSequence charSequence, Iterable iterable, BaseOperator baseOperator) {
        StringBuilder sb = new StringBuilder();
        boolean z10 = true;
        for (Object obj : iterable) {
            if (z10) {
                z10 = false;
            } else {
                sb.append(charSequence);
            }
            sb.append(baseOperator.convertObjectToString(obj, false));
        }
        return sb.toString();
    }

    public NameAlias columnAlias() {
        return this.nameAlias;
    }

    @Override // com.raizlabs.android.dbflow.sql.language.SQLOperator
    public String columnName() {
        return this.nameAlias.getQuery();
    }

    public String convertObjectToString(Object obj, boolean z10) {
        return convertValueToString(obj, z10);
    }

    @Override // com.raizlabs.android.dbflow.sql.language.SQLOperator
    public boolean hasSeparator() {
        String str = this.separator;
        return str != null && str.length() > 0;
    }

    @Override // com.raizlabs.android.dbflow.sql.language.SQLOperator
    public String operation() {
        return this.operation;
    }

    public String postArgument() {
        return this.postArg;
    }

    @Override // com.raizlabs.android.dbflow.sql.language.SQLOperator
    public SQLOperator separator(String str) {
        this.separator = str;
        return this;
    }

    @Override // com.raizlabs.android.dbflow.sql.language.SQLOperator
    public Object value() {
        return this.value;
    }

    public static String convertValueToString(Object obj, boolean z10, boolean z11) {
        TypeConverter typeConverterForClass;
        if (obj == null) {
            return "NULL";
        }
        if (z11 && (typeConverterForClass = FlowManager.getTypeConverterForClass(obj.getClass())) != null) {
            obj = typeConverterForClass.getDBValue(obj);
        }
        if (obj instanceof Number) {
            return String.valueOf(obj);
        }
        if (obj instanceof Enum) {
            return DatabaseUtils.sqlEscapeString(((Enum) obj).name());
        }
        if (z10 && (obj instanceof BaseModelQueriable)) {
            return String.format("(%1s)", ((BaseModelQueriable) obj).getQuery().trim());
        }
        if (obj instanceof NameAlias) {
            return ((NameAlias) obj).getQuery();
        }
        if (obj instanceof SQLOperator) {
            QueryBuilder queryBuilder = new QueryBuilder();
            ((SQLOperator) obj).appendConditionToQuery(queryBuilder);
            return queryBuilder.toString();
        }
        if (obj instanceof Query) {
            return ((Query) obj).getQuery();
        }
        boolean z12 = obj instanceof Blob;
        if (!z12 && !(obj instanceof byte[])) {
            String valueOf = String.valueOf(obj);
            return !valueOf.equals(Operator.Operation.EMPTY_PARAM) ? DatabaseUtils.sqlEscapeString(valueOf) : valueOf;
        }
        return "X" + DatabaseUtils.sqlEscapeString(SqlUtils.byteArrayToHexString(z12 ? ((Blob) obj).getBlob() : (byte[]) obj));
    }

    @Override // com.raizlabs.android.dbflow.sql.language.SQLOperator
    public String separator() {
        return this.separator;
    }

    public static String joinArguments(CharSequence charSequence, Object[] objArr) {
        StringBuilder sb = new StringBuilder();
        boolean z10 = true;
        for (Object obj : objArr) {
            if (z10) {
                z10 = false;
            } else {
                sb.append(charSequence);
            }
            sb.append(convertValueToString(obj, false, true));
        }
        return sb.toString();
    }

    public static String joinArguments(CharSequence charSequence, Iterable iterable) {
        StringBuilder sb = new StringBuilder();
        boolean z10 = true;
        for (Object obj : iterable) {
            if (z10) {
                z10 = false;
            } else {
                sb.append(charSequence);
            }
            sb.append(convertValueToString(obj, false, true));
        }
        return sb.toString();
    }
}
