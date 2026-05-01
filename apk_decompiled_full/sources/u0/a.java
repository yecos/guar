package u0;

import android.database.Cursor;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQuery;
import android.os.CancellationSignal;
import java.util.List;

/* loaded from: classes.dex */
public class a implements t0.b {

    /* renamed from: b, reason: collision with root package name */
    public static final String[] f18981b = {"", " OR ROLLBACK ", " OR ABORT ", " OR FAIL ", " OR IGNORE ", " OR REPLACE "};

    /* renamed from: c, reason: collision with root package name */
    public static final String[] f18982c = new String[0];

    /* renamed from: a, reason: collision with root package name */
    public final SQLiteDatabase f18983a;

    /* renamed from: u0.a$a, reason: collision with other inner class name */
    public class C0325a implements SQLiteDatabase.CursorFactory {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ t0.e f18984a;

        public C0325a(t0.e eVar) {
            this.f18984a = eVar;
        }

        @Override // android.database.sqlite.SQLiteDatabase.CursorFactory
        public Cursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
            this.f18984a.a(new e(sQLiteQuery));
            return new SQLiteCursor(sQLiteCursorDriver, str, sQLiteQuery);
        }
    }

    public class b implements SQLiteDatabase.CursorFactory {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ t0.e f18986a;

        public b(t0.e eVar) {
            this.f18986a = eVar;
        }

        @Override // android.database.sqlite.SQLiteDatabase.CursorFactory
        public Cursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
            this.f18986a.a(new e(sQLiteQuery));
            return new SQLiteCursor(sQLiteCursorDriver, str, sQLiteQuery);
        }
    }

    public a(SQLiteDatabase sQLiteDatabase) {
        this.f18983a = sQLiteDatabase;
    }

    @Override // t0.b
    public Cursor B(String str) {
        return w(new t0.a(str));
    }

    @Override // t0.b
    public boolean G() {
        return this.f18983a.inTransaction();
    }

    public boolean a(SQLiteDatabase sQLiteDatabase) {
        return this.f18983a == sQLiteDatabase;
    }

    @Override // t0.b
    public void beginTransaction() {
        this.f18983a.beginTransaction();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f18983a.close();
    }

    @Override // t0.b
    public t0.f compileStatement(String str) {
        return new f(this.f18983a.compileStatement(str));
    }

    @Override // t0.b
    public void endTransaction() {
        this.f18983a.endTransaction();
    }

    @Override // t0.b
    public void execSQL(String str) {
        this.f18983a.execSQL(str);
    }

    @Override // t0.b
    public String getPath() {
        return this.f18983a.getPath();
    }

    @Override // t0.b
    public List i() {
        return this.f18983a.getAttachedDbs();
    }

    @Override // t0.b
    public boolean isOpen() {
        return this.f18983a.isOpen();
    }

    @Override // t0.b
    public Cursor k(t0.e eVar, CancellationSignal cancellationSignal) {
        return this.f18983a.rawQueryWithFactory(new b(eVar), eVar.b(), f18982c, null, cancellationSignal);
    }

    @Override // t0.b
    public void l(String str, Object[] objArr) {
        this.f18983a.execSQL(str, objArr);
    }

    @Override // t0.b
    public void setTransactionSuccessful() {
        this.f18983a.setTransactionSuccessful();
    }

    @Override // t0.b
    public Cursor w(t0.e eVar) {
        return this.f18983a.rawQueryWithFactory(new C0325a(eVar), eVar.b(), f18982c, null);
    }
}
