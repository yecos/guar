package com.raizlabs.android.dbflow.sql.queriable;

import com.raizlabs.android.dbflow.list.FlowCursorList;
import com.raizlabs.android.dbflow.list.FlowQueryList;
import com.raizlabs.android.dbflow.sql.language.CursorResult;
import com.raizlabs.android.dbflow.structure.database.DatabaseWrapper;
import java.util.List;

/* loaded from: classes3.dex */
public interface ModelQueriable<TModel> extends Queriable {
    AsyncQuery<TModel> async();

    FlowCursorList<TModel> cursorList();

    ModelQueriable<TModel> disableCaching();

    FlowQueryList<TModel> flowQueryList();

    Class<TModel> getTable();

    <TQueryModel> List<TQueryModel> queryCustomList(Class<TQueryModel> cls);

    <TQueryModel> TQueryModel queryCustomSingle(Class<TQueryModel> cls);

    List<TModel> queryList();

    List<TModel> queryList(DatabaseWrapper databaseWrapper);

    CursorResult<TModel> queryResults();

    TModel querySingle();

    TModel querySingle(DatabaseWrapper databaseWrapper);
}
