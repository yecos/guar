package com.raizlabs.android.dbflow.sql;

import android.content.ContentValues;
import android.database.ContentObserver;
import android.net.Uri;
import com.google.common.primitives.UnsignedBytes;
import com.raizlabs.android.dbflow.StringUtils;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.runtime.NotifyDistributor;
import com.raizlabs.android.dbflow.sql.language.NameAlias;
import com.raizlabs.android.dbflow.sql.language.Operator;
import com.raizlabs.android.dbflow.sql.language.OperatorGroup;
import com.raizlabs.android.dbflow.sql.language.SQLOperator;
import com.raizlabs.android.dbflow.structure.BaseModel;
import com.raizlabs.android.dbflow.structure.ModelAdapter;
import com.raizlabs.android.dbflow.structure.database.DatabaseStatement;
import com.raizlabs.android.dbflow.structure.database.DatabaseWrapper;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes3.dex */
public class SqlUtils {
    public static final String TABLE_QUERY_PARAM = "tableName";
    private static final char[] hexArray = "0123456789ABCDEF".toCharArray();

    public static void addContentValues(ContentValues contentValues, OperatorGroup operatorGroup) {
        Iterator<Map.Entry<String, Object>> it = contentValues.valueSet().iterator();
        while (it.hasNext()) {
            String key = it.next().getKey();
            operatorGroup.and(Operator.op(new NameAlias.Builder(key).build()).is((Operator) contentValues.get(key)));
        }
    }

    public static String byteArrayToHexString(byte[] bArr) {
        char[] cArr = new char[bArr.length * 2];
        for (int i10 = 0; i10 < bArr.length; i10++) {
            int i11 = bArr[i10] & UnsignedBytes.MAX_VALUE;
            int i12 = i10 * 2;
            char[] cArr2 = hexArray;
            cArr[i12] = cArr2[i11 >>> 4];
            cArr[i12 + 1] = cArr2[i11 & 15];
        }
        return new String(cArr);
    }

    public static double doubleForQuery(DatabaseWrapper databaseWrapper, String str) {
        DatabaseStatement compileStatement = databaseWrapper.compileStatement(str);
        try {
            return compileStatement.simpleQueryForLong();
        } finally {
            compileStatement.close();
        }
    }

    public static void dropIndex(DatabaseWrapper databaseWrapper, String str) {
        databaseWrapper.execSQL(new QueryBuilder("DROP INDEX IF EXISTS ").append(QueryBuilder.quoteIfNeeded(str)).getQuery());
    }

    public static void dropTrigger(Class<?> cls, String str) {
        FlowManager.getDatabaseForTable(cls).getWritableDatabase().execSQL(new QueryBuilder("DROP TRIGGER IF EXISTS ").append(str).getQuery());
    }

    public static String getContentValuesKey(ContentValues contentValues, String str) {
        String quoteIfNeeded = QueryBuilder.quoteIfNeeded(str);
        if (contentValues.containsKey(quoteIfNeeded)) {
            return quoteIfNeeded;
        }
        String stripQuotes = QueryBuilder.stripQuotes(str);
        if (contentValues.containsKey(stripQuotes)) {
            return stripQuotes;
        }
        throw new IllegalArgumentException("Could not find the specified key in the Content Values object.");
    }

    public static Uri getNotificationUri(String str, Class<?> cls, BaseModel.Action action, Iterable<SQLOperator> iterable) {
        Uri.Builder appendQueryParameter = new Uri.Builder().scheme("dbflow").authority(str).appendQueryParameter(TABLE_QUERY_PARAM, FlowManager.getTableName(cls));
        if (action != null) {
            appendQueryParameter.fragment(action.name());
        }
        if (iterable != null) {
            for (SQLOperator sQLOperator : iterable) {
                appendQueryParameter.appendQueryParameter(Uri.encode(sQLOperator.columnName()), Uri.encode(String.valueOf(sQLOperator.value())));
            }
        }
        return appendQueryParameter.build();
    }

    public static long longForQuery(DatabaseWrapper databaseWrapper, String str) {
        DatabaseStatement compileStatement = databaseWrapper.compileStatement(str);
        try {
            return compileStatement.simpleQueryForLong();
        } finally {
            compileStatement.close();
        }
    }

    @Deprecated
    public static void notifyModelChanged(String str, Class<?> cls, BaseModel.Action action, Iterable<SQLOperator> iterable) {
        FlowManager.getContext().getContentResolver().notifyChange(getNotificationUri(str, cls, action, iterable), (ContentObserver) null, true);
    }

    @Deprecated
    public static <TModel> void notifyTableChanged(Class<TModel> cls, BaseModel.Action action) {
        NotifyDistributor.get().notifyTableChanged(cls, action);
    }

    public static void dropIndex(Class<?> cls, String str) {
        dropIndex(FlowManager.getDatabaseForTable(cls).getWritableDatabase(), str);
    }

    public static void dropTrigger(DatabaseWrapper databaseWrapper, String str) {
        databaseWrapper.execSQL(new QueryBuilder("DROP TRIGGER IF EXISTS ").append(str).getQuery());
    }

    @Deprecated
    public static <TModel> void notifyModelChanged(TModel tmodel, ModelAdapter<TModel> modelAdapter, BaseModel.Action action) {
        NotifyDistributor.get().notifyModelChanged(tmodel, modelAdapter, action);
    }

    public static Uri getNotificationUri(String str, Class<?> cls, BaseModel.Action action, SQLOperator[] sQLOperatorArr) {
        Uri.Builder appendQueryParameter = new Uri.Builder().scheme("dbflow").authority(str).appendQueryParameter(TABLE_QUERY_PARAM, FlowManager.getTableName(cls));
        if (action != null) {
            appendQueryParameter.fragment(action.name());
        }
        if (sQLOperatorArr != null && sQLOperatorArr.length > 0) {
            for (SQLOperator sQLOperator : sQLOperatorArr) {
                if (sQLOperator != null) {
                    appendQueryParameter.appendQueryParameter(Uri.encode(sQLOperator.columnName()), Uri.encode(String.valueOf(sQLOperator.value())));
                }
            }
        }
        return appendQueryParameter.build();
    }

    public static Uri getNotificationUri(String str, Class<?> cls, BaseModel.Action action, String str2, Object obj) {
        return getNotificationUri(str, cls, action, new SQLOperator[]{StringUtils.isNotNullOrEmpty(str2) ? Operator.op(new NameAlias.Builder(str2).build()).value(obj) : null});
    }

    public static Uri getNotificationUri(String str, Class<?> cls, BaseModel.Action action) {
        return getNotificationUri(str, cls, action, "", null);
    }
}
