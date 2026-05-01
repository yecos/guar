package com.raizlabs.android.dbflow.structure.provider;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import com.raizlabs.android.dbflow.config.FlowLog;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.sql.language.OperatorGroup;
import com.raizlabs.android.dbflow.structure.ModelAdapter;
import com.raizlabs.android.dbflow.structure.database.FlowCursor;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class ContentUtils {
    public static final String BASE_CONTENT_URI = "content://";

    public static Uri buildUri(String str, String str2, String... strArr) {
        Uri.Builder buildUpon = Uri.parse(str + str2).buildUpon();
        for (String str3 : strArr) {
            buildUpon.appendPath(str3);
        }
        return buildUpon.build();
    }

    public static Uri buildUriWithAuthority(String str, String... strArr) {
        return buildUri(BASE_CONTENT_URI, str, strArr);
    }

    public static <TableClass> int bulkInsert(ContentResolver contentResolver, Uri uri, Class<TableClass> cls, List<TableClass> list) {
        int size = list == null ? 0 : list.size();
        ContentValues[] contentValuesArr = new ContentValues[size];
        ModelAdapter modelAdapter = FlowManager.getModelAdapter(cls);
        if (list != null) {
            for (int i10 = 0; i10 < size; i10++) {
                ContentValues contentValues = new ContentValues();
                contentValuesArr[i10] = contentValues;
                modelAdapter.bindToInsertValues(contentValues, list.get(i10));
            }
        }
        return contentResolver.bulkInsert(uri, contentValuesArr);
    }

    public static <TableClass> int delete(Uri uri, TableClass tableclass) {
        return delete(FlowManager.getContext().getContentResolver(), uri, tableclass);
    }

    public static <TableClass> Uri insert(Uri uri, TableClass tableclass) {
        return insert(FlowManager.getContext().getContentResolver(), uri, tableclass);
    }

    public static Cursor query(ContentResolver contentResolver, Uri uri, OperatorGroup operatorGroup, String str, String... strArr) {
        return contentResolver.query(uri, strArr, operatorGroup.getQuery(), null, str);
    }

    public static <TableClass> List<TableClass> queryList(Uri uri, Class<TableClass> cls, OperatorGroup operatorGroup, String str, String... strArr) {
        return queryList(FlowManager.getContext().getContentResolver(), uri, cls, operatorGroup, str, strArr);
    }

    public static <TableClass> TableClass querySingle(Uri uri, Class<TableClass> cls, OperatorGroup operatorGroup, String str, String... strArr) {
        return (TableClass) querySingle(FlowManager.getContext().getContentResolver(), uri, cls, operatorGroup, str, strArr);
    }

    public static <TableClass> int update(Uri uri, TableClass tableclass) {
        return update(FlowManager.getContext().getContentResolver(), uri, tableclass);
    }

    public static <TableClass> int delete(ContentResolver contentResolver, Uri uri, TableClass tableclass) {
        ModelAdapter modelAdapter = FlowManager.getModelAdapter(tableclass.getClass());
        int delete = contentResolver.delete(uri, modelAdapter.getPrimaryConditionClause(tableclass).getQuery(), null);
        if (delete > 0) {
            modelAdapter.updateAutoIncrement(tableclass, 0);
        } else {
            FlowLog.log(FlowLog.Level.W, "A delete on " + tableclass.getClass() + " within the ContentResolver appeared to fail.");
        }
        return delete;
    }

    public static <TableClass> Uri insert(ContentResolver contentResolver, Uri uri, TableClass tableclass) {
        ModelAdapter modelAdapter = FlowManager.getModelAdapter(tableclass.getClass());
        ContentValues contentValues = new ContentValues();
        modelAdapter.bindToInsertValues(contentValues, tableclass);
        Uri insert = contentResolver.insert(uri, contentValues);
        modelAdapter.updateAutoIncrement(tableclass, Long.valueOf(insert.getPathSegments().get(insert.getPathSegments().size() - 1)));
        return insert;
    }

    public static <TableClass> List<TableClass> queryList(ContentResolver contentResolver, Uri uri, Class<TableClass> cls, OperatorGroup operatorGroup, String str, String... strArr) {
        FlowCursor from = FlowCursor.from(contentResolver.query(uri, strArr, operatorGroup.getQuery(), null, str));
        return from != null ? FlowManager.getModelAdapter(cls).getListModelLoader().load(from) : new ArrayList();
    }

    public static <TableClass> TableClass querySingle(ContentResolver contentResolver, Uri uri, Class<TableClass> cls, OperatorGroup operatorGroup, String str, String... strArr) {
        List queryList = queryList(contentResolver, uri, cls, operatorGroup, str, strArr);
        if (queryList.size() > 0) {
            return (TableClass) queryList.get(0);
        }
        return null;
    }

    public static <TableClass> int update(ContentResolver contentResolver, Uri uri, TableClass tableclass) {
        ModelAdapter modelAdapter = FlowManager.getModelAdapter(tableclass.getClass());
        ContentValues contentValues = new ContentValues();
        modelAdapter.bindToContentValues(contentValues, tableclass);
        int update = contentResolver.update(uri, contentValues, modelAdapter.getPrimaryConditionClause(tableclass).getQuery(), null);
        if (update == 0) {
            FlowLog.log(FlowLog.Level.W, "Updated failed of: " + tableclass.getClass());
        }
        return update;
    }

    public static <TableClass> int bulkInsert(Uri uri, Class<TableClass> cls, List<TableClass> list) {
        return bulkInsert(FlowManager.getContext().getContentResolver(), uri, cls, list);
    }
}
