package com.raizlabs.android.dbflow.structure.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.raizlabs.android.dbflow.config.DatabaseDefinition;
import com.raizlabs.android.dbflow.config.FlowManager;

/* loaded from: classes3.dex */
public class FlowSQLiteOpenHelper extends SQLiteOpenHelper implements OpenHelper {
    private AndroidDatabase androidDatabase;
    private DatabaseHelperDelegate databaseHelperDelegate;

    public class BackupHelper extends SQLiteOpenHelper implements OpenHelper {
        private AndroidDatabase androidDatabase;
        private final BaseDatabaseHelper baseDatabaseHelper;

        public BackupHelper(Context context, String str, int i10, DatabaseDefinition databaseDefinition) {
            super(context, str, (SQLiteDatabase.CursorFactory) null, i10);
            this.baseDatabaseHelper = new BaseDatabaseHelper(databaseDefinition);
        }

        @Override // com.raizlabs.android.dbflow.structure.database.OpenHelper
        public void backupDB() {
        }

        @Override // com.raizlabs.android.dbflow.structure.database.OpenHelper
        public void closeDB() {
        }

        @Override // com.raizlabs.android.dbflow.structure.database.OpenHelper
        public DatabaseWrapper getDatabase() {
            if (this.androidDatabase == null) {
                this.androidDatabase = AndroidDatabase.from(getWritableDatabase());
            }
            return this.androidDatabase;
        }

        @Override // com.raizlabs.android.dbflow.structure.database.OpenHelper
        public DatabaseHelperDelegate getDelegate() {
            return null;
        }

        @Override // com.raizlabs.android.dbflow.structure.database.OpenHelper
        public boolean isDatabaseIntegrityOk() {
            return false;
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            this.baseDatabaseHelper.onCreate(AndroidDatabase.from(sQLiteDatabase));
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
            this.baseDatabaseHelper.onDowngrade(AndroidDatabase.from(sQLiteDatabase), i10, i11);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onOpen(SQLiteDatabase sQLiteDatabase) {
            this.baseDatabaseHelper.onOpen(AndroidDatabase.from(sQLiteDatabase));
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
            this.baseDatabaseHelper.onUpgrade(AndroidDatabase.from(sQLiteDatabase), i10, i11);
        }

        @Override // com.raizlabs.android.dbflow.structure.database.OpenHelper
        public void performRestoreFromBackup() {
        }

        @Override // com.raizlabs.android.dbflow.structure.database.OpenHelper
        public void setDatabaseListener(DatabaseHelperListener databaseHelperListener) {
        }
    }

    public FlowSQLiteOpenHelper(DatabaseDefinition databaseDefinition, DatabaseHelperListener databaseHelperListener) {
        super(FlowManager.getContext(), databaseDefinition.isInMemory() ? null : databaseDefinition.getDatabaseFileName(), (SQLiteDatabase.CursorFactory) null, databaseDefinition.getDatabaseVersion());
        this.databaseHelperDelegate = new DatabaseHelperDelegate(databaseHelperListener, databaseDefinition, databaseDefinition.backupEnabled() ? new BackupHelper(FlowManager.getContext(), DatabaseHelperDelegate.getTempDbFileName(databaseDefinition), databaseDefinition.getDatabaseVersion(), databaseDefinition) : null);
    }

    @Override // com.raizlabs.android.dbflow.structure.database.OpenHelper
    public void backupDB() {
        this.databaseHelperDelegate.backupDB();
    }

    @Override // com.raizlabs.android.dbflow.structure.database.OpenHelper
    public void closeDB() {
        getDatabase();
        this.androidDatabase.getDatabase().close();
    }

    @Override // com.raizlabs.android.dbflow.structure.database.OpenHelper
    public DatabaseWrapper getDatabase() {
        AndroidDatabase androidDatabase = this.androidDatabase;
        if (androidDatabase == null || !androidDatabase.getDatabase().isOpen()) {
            this.androidDatabase = AndroidDatabase.from(getWritableDatabase());
        }
        return this.androidDatabase;
    }

    @Override // com.raizlabs.android.dbflow.structure.database.OpenHelper
    public DatabaseHelperDelegate getDelegate() {
        return this.databaseHelperDelegate;
    }

    @Override // com.raizlabs.android.dbflow.structure.database.OpenHelper
    public boolean isDatabaseIntegrityOk() {
        return this.databaseHelperDelegate.isDatabaseIntegrityOk();
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        this.databaseHelperDelegate.onCreate(AndroidDatabase.from(sQLiteDatabase));
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
        this.databaseHelperDelegate.onDowngrade(AndroidDatabase.from(sQLiteDatabase), i10, i11);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onOpen(SQLiteDatabase sQLiteDatabase) {
        this.databaseHelperDelegate.onOpen(AndroidDatabase.from(sQLiteDatabase));
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
        this.databaseHelperDelegate.onUpgrade(AndroidDatabase.from(sQLiteDatabase), i10, i11);
    }

    @Override // com.raizlabs.android.dbflow.structure.database.OpenHelper
    public void performRestoreFromBackup() {
        this.databaseHelperDelegate.performRestoreFromBackup();
    }

    @Override // com.raizlabs.android.dbflow.structure.database.OpenHelper
    public void setDatabaseListener(DatabaseHelperListener databaseHelperListener) {
        this.databaseHelperDelegate.setDatabaseHelperListener(databaseHelperListener);
    }
}
