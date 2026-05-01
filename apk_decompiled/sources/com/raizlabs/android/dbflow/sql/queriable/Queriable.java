package com.raizlabs.android.dbflow.sql.queriable;

import com.raizlabs.android.dbflow.sql.Query;
import com.raizlabs.android.dbflow.structure.BaseModel;
import com.raizlabs.android.dbflow.structure.database.DatabaseStatement;
import com.raizlabs.android.dbflow.structure.database.DatabaseWrapper;
import com.raizlabs.android.dbflow.structure.database.FlowCursor;

/* loaded from: classes3.dex */
public interface Queriable extends Query {
    DatabaseStatement compileStatement();

    DatabaseStatement compileStatement(DatabaseWrapper databaseWrapper);

    @Deprecated
    long count();

    @Deprecated
    long count(DatabaseWrapper databaseWrapper);

    void execute();

    void execute(DatabaseWrapper databaseWrapper);

    long executeInsert();

    long executeInsert(DatabaseWrapper databaseWrapper);

    long executeUpdateDelete();

    long executeUpdateDelete(DatabaseWrapper databaseWrapper);

    BaseModel.Action getPrimaryAction();

    boolean hasData();

    boolean hasData(DatabaseWrapper databaseWrapper);

    long longValue();

    long longValue(DatabaseWrapper databaseWrapper);

    FlowCursor query();

    FlowCursor query(DatabaseWrapper databaseWrapper);
}
