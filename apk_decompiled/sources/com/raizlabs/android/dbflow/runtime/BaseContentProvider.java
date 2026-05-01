package com.raizlabs.android.dbflow.runtime;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.net.Uri;
import com.raizlabs.android.dbflow.config.DatabaseDefinition;
import com.raizlabs.android.dbflow.config.DatabaseHolder;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.sql.language.property.IProperty;
import com.raizlabs.android.dbflow.structure.database.DatabaseWrapper;
import com.raizlabs.android.dbflow.structure.database.transaction.ITransaction;

/* loaded from: classes3.dex */
public abstract class BaseContentProvider extends ContentProvider {
    protected DatabaseDefinition database;
    protected Class<? extends DatabaseHolder> moduleClass;

    public interface PropertyConverter {
        IProperty fromName(String str);
    }

    public BaseContentProvider() {
    }

    public abstract int bulkInsert(Uri uri, ContentValues contentValues);

    @Override // android.content.ContentProvider
    public int bulkInsert(final Uri uri, final ContentValues[] contentValuesArr) {
        final int[] iArr = {0};
        getDatabase().executeTransaction(new ITransaction() { // from class: com.raizlabs.android.dbflow.runtime.BaseContentProvider.1
            @Override // com.raizlabs.android.dbflow.structure.database.transaction.ITransaction
            public void execute(DatabaseWrapper databaseWrapper) {
                for (ContentValues contentValues : contentValuesArr) {
                    int[] iArr2 = iArr;
                    iArr2[0] = iArr2[0] + BaseContentProvider.this.bulkInsert(uri, contentValues);
                }
            }
        });
        getContext().getContentResolver().notifyChange(uri, null);
        return iArr[0];
    }

    public DatabaseDefinition getDatabase() {
        if (this.database == null) {
            this.database = FlowManager.getDatabase(getDatabaseName());
        }
        return this.database;
    }

    public abstract String getDatabaseName();

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        Class<? extends DatabaseHolder> cls = this.moduleClass;
        if (cls != null) {
            FlowManager.initModule(cls);
            return true;
        }
        if (getContext() == null) {
            return true;
        }
        FlowManager.init(getContext());
        return true;
    }

    public BaseContentProvider(Class<? extends DatabaseHolder> cls) {
        this.moduleClass = cls;
    }
}
