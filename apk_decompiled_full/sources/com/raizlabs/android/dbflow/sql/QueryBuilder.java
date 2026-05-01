package com.raizlabs.android.dbflow.sql;

import com.raizlabs.android.dbflow.sql.QueryBuilder;
import com.raizlabs.android.dbflow.sql.language.Operator;
import java.util.List;
import java.util.regex.Pattern;

/* loaded from: classes3.dex */
public class QueryBuilder<QueryClass extends QueryBuilder> implements Query {
    private static final char QUOTE = '`';
    private static final Pattern QUOTE_PATTERN = Pattern.compile("`.*`");
    protected StringBuilder query = new StringBuilder();

    public QueryBuilder() {
    }

    public static boolean isQuoted(String str) {
        return QUOTE_PATTERN.matcher(str).find();
    }

    public static String join(CharSequence charSequence, Object[] objArr) {
        StringBuilder sb = new StringBuilder();
        boolean z10 = true;
        for (Object obj : objArr) {
            if (z10) {
                z10 = false;
            } else {
                sb.append(charSequence);
            }
            sb.append(obj);
        }
        return sb.toString();
    }

    public static String quote(String str) {
        return QUOTE + str.replace(".", "`.`") + QUOTE;
    }

    public static String quoteIfNeeded(String str) {
        return (str == null || isQuoted(str)) ? str : quote(str);
    }

    public static String stripQuotes(String str) {
        return (str == null || !isQuoted(str)) ? str : str.replace("`", "");
    }

    public QueryClass append(Object obj) {
        this.query.append(obj);
        return castThis();
    }

    public QueryClass appendArray(Object... objArr) {
        return append(join(", ", objArr));
    }

    public QueryClass appendList(List<?> list) {
        return append(join(", ", list));
    }

    public QueryClass appendNotEmpty(String str) {
        if (str != null && !str.isEmpty()) {
            append(str);
        }
        return castThis();
    }

    public QueryClass appendOptional(Object obj) {
        if (obj != null) {
            append(obj);
        }
        return castThis();
    }

    public QueryClass appendParenthesisEnclosed(Object obj) {
        return (QueryClass) append("(").append(obj).append(")");
    }

    public QueryClass appendQualifier(String str, String str2) {
        if (str2 != null && str2.length() > 0) {
            if (str != null) {
                append(str);
            }
            appendSpaceSeparated(str2);
        }
        return castThis();
    }

    public QueryClass appendQuoted(String str) {
        if (str.equals(Operator.Operation.MULTIPLY)) {
            return append(str);
        }
        append(quote(str));
        return castThis();
    }

    public QueryClass appendQuotedArray(Object... objArr) {
        return appendQuoted(join("`, `", objArr));
    }

    public QueryClass appendQuotedIfNeeded(String str) {
        if (str.equals(Operator.Operation.MULTIPLY)) {
            return append(str);
        }
        append(quoteIfNeeded(str));
        return castThis();
    }

    public QueryClass appendQuotedList(List<?> list) {
        return appendQuoted(join("`, `", list));
    }

    public QueryClass appendSQLiteType(SQLiteType sQLiteType) {
        return append(sQLiteType.name());
    }

    public QueryClass appendSpace() {
        return append(" ");
    }

    public QueryClass appendSpaceSeparated(Object obj) {
        return (QueryClass) appendSpace().append(obj).appendSpace();
    }

    public QueryClass appendType(String str) {
        return appendSQLiteType(SQLiteType.get(str));
    }

    public QueryClass castThis() {
        return this;
    }

    @Override // com.raizlabs.android.dbflow.sql.Query
    public String getQuery() {
        return this.query.toString();
    }

    public String toString() {
        return getQuery();
    }

    public QueryBuilder(Object obj) {
        append(obj);
    }

    public static String join(CharSequence charSequence, Iterable iterable) {
        StringBuilder sb = new StringBuilder();
        boolean z10 = true;
        for (Object obj : iterable) {
            if (z10) {
                z10 = false;
            } else {
                sb.append(charSequence);
            }
            sb.append(obj);
        }
        return sb.toString();
    }
}
