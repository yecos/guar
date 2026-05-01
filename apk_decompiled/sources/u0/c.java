package u0;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import java.io.File;
import t0.c;

/* loaded from: classes.dex */
public class c implements t0.c {

    /* renamed from: a, reason: collision with root package name */
    public final Context f18988a;

    /* renamed from: b, reason: collision with root package name */
    public final String f18989b;

    /* renamed from: c, reason: collision with root package name */
    public final c.a f18990c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f18991d;

    /* renamed from: e, reason: collision with root package name */
    public final Object f18992e = new Object();

    /* renamed from: f, reason: collision with root package name */
    public a f18993f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f18994g;

    public static class a extends SQLiteOpenHelper {

        /* renamed from: a, reason: collision with root package name */
        public final u0.a[] f18995a;

        /* renamed from: b, reason: collision with root package name */
        public final c.a f18996b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f18997c;

        /* renamed from: u0.c$a$a, reason: collision with other inner class name */
        public class C0326a implements DatabaseErrorHandler {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ c.a f18998a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ u0.a[] f18999b;

            public C0326a(c.a aVar, u0.a[] aVarArr) {
                this.f18998a = aVar;
                this.f18999b = aVarArr;
            }

            @Override // android.database.DatabaseErrorHandler
            public void onCorruption(SQLiteDatabase sQLiteDatabase) {
                this.f18998a.c(a.b(this.f18999b, sQLiteDatabase));
            }
        }

        public a(Context context, String str, u0.a[] aVarArr, c.a aVar) {
            super(context, str, null, aVar.f18789a, new C0326a(aVar, aVarArr));
            this.f18996b = aVar;
            this.f18995a = aVarArr;
        }

        public static u0.a b(u0.a[] aVarArr, SQLiteDatabase sQLiteDatabase) {
            u0.a aVar = aVarArr[0];
            if (aVar == null || !aVar.a(sQLiteDatabase)) {
                aVarArr[0] = new u0.a(sQLiteDatabase);
            }
            return aVarArr[0];
        }

        public u0.a a(SQLiteDatabase sQLiteDatabase) {
            return b(this.f18995a, sQLiteDatabase);
        }

        public synchronized t0.b c() {
            this.f18997c = false;
            SQLiteDatabase writableDatabase = super.getWritableDatabase();
            if (!this.f18997c) {
                return a(writableDatabase);
            }
            close();
            return c();
        }

        @Override // android.database.sqlite.SQLiteOpenHelper, java.lang.AutoCloseable
        public synchronized void close() {
            super.close();
            this.f18995a[0] = null;
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onConfigure(SQLiteDatabase sQLiteDatabase) {
            this.f18996b.b(a(sQLiteDatabase));
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            this.f18996b.d(a(sQLiteDatabase));
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
            this.f18997c = true;
            this.f18996b.e(a(sQLiteDatabase), i10, i11);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onOpen(SQLiteDatabase sQLiteDatabase) {
            if (this.f18997c) {
                return;
            }
            this.f18996b.f(a(sQLiteDatabase));
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
            this.f18997c = true;
            this.f18996b.g(a(sQLiteDatabase), i10, i11);
        }
    }

    public c(Context context, String str, c.a aVar, boolean z10) {
        this.f18988a = context;
        this.f18989b = str;
        this.f18990c = aVar;
        this.f18991d = z10;
    }

    @Override // t0.c
    public t0.b A() {
        return a().c();
    }

    public final a a() {
        a aVar;
        File noBackupFilesDir;
        synchronized (this.f18992e) {
            if (this.f18993f == null) {
                u0.a[] aVarArr = new u0.a[1];
                if (Build.VERSION.SDK_INT < 23 || this.f18989b == null || !this.f18991d) {
                    this.f18993f = new a(this.f18988a, this.f18989b, aVarArr, this.f18990c);
                } else {
                    noBackupFilesDir = this.f18988a.getNoBackupFilesDir();
                    this.f18993f = new a(this.f18988a, new File(noBackupFilesDir, this.f18989b).getAbsolutePath(), aVarArr, this.f18990c);
                }
                this.f18993f.setWriteAheadLoggingEnabled(this.f18994g);
            }
            aVar = this.f18993f;
        }
        return aVar;
    }

    @Override // t0.c, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        a().close();
    }

    @Override // t0.c
    public String getDatabaseName() {
        return this.f18989b;
    }

    @Override // t0.c
    public void setWriteAheadLoggingEnabled(boolean z10) {
        synchronized (this.f18992e) {
            a aVar = this.f18993f;
            if (aVar != null) {
                aVar.setWriteAheadLoggingEnabled(z10);
            }
            this.f18994g = z10;
        }
    }
}
