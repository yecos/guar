package u0;

import android.database.sqlite.SQLiteProgram;

/* loaded from: classes.dex */
public class e implements t0.d {

    /* renamed from: a, reason: collision with root package name */
    public final SQLiteProgram f19000a;

    public e(SQLiteProgram sQLiteProgram) {
        this.f19000a = sQLiteProgram;
    }

    @Override // t0.d
    public void bindBlob(int i10, byte[] bArr) {
        this.f19000a.bindBlob(i10, bArr);
    }

    @Override // t0.d
    public void bindDouble(int i10, double d10) {
        this.f19000a.bindDouble(i10, d10);
    }

    @Override // t0.d
    public void bindLong(int i10, long j10) {
        this.f19000a.bindLong(i10, j10);
    }

    @Override // t0.d
    public void bindNull(int i10) {
        this.f19000a.bindNull(i10);
    }

    @Override // t0.d
    public void bindString(int i10, String str) {
        this.f19000a.bindString(i10, str);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f19000a.close();
    }
}
