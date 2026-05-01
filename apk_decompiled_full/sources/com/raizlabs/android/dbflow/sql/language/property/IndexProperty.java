package com.raizlabs.android.dbflow.sql.language.property;

import com.raizlabs.android.dbflow.sql.QueryBuilder;
import com.raizlabs.android.dbflow.sql.language.Index;
import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.raizlabs.android.dbflow.structure.database.DatabaseWrapper;

/* loaded from: classes3.dex */
public class IndexProperty<T> {
    private final Index<T> index;

    public IndexProperty(String str, boolean z10, Class<T> cls, IProperty... iPropertyArr) {
        Index<T> index = SQLite.index(str);
        this.index = index;
        index.on(cls, iPropertyArr).unique(z10);
    }

    public void createIfNotExists(DatabaseWrapper databaseWrapper) {
        this.index.enable(databaseWrapper);
    }

    public void drop() {
        this.index.disable();
    }

    public Index<T> getIndex() {
        return this.index;
    }

    public String getIndexName() {
        return QueryBuilder.quoteIfNeeded(this.index.getIndexName());
    }

    public void createIfNotExists() {
        this.index.enable();
    }

    public void drop(DatabaseWrapper databaseWrapper) {
        this.index.disable(databaseWrapper);
    }
}
