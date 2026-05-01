package u0;

import android.database.sqlite.SQLiteStatement;

/* loaded from: classes.dex */
public class f extends e implements t0.f {

    /* renamed from: b, reason: collision with root package name */
    public final SQLiteStatement f19001b;

    public f(SQLiteStatement sQLiteStatement) {
        super(sQLiteStatement);
        this.f19001b = sQLiteStatement;
    }

    @Override // t0.f
    public long executeInsert() {
        return this.f19001b.executeInsert();
    }

    @Override // t0.f
    public int executeUpdateDelete() {
        return this.f19001b.executeUpdateDelete();
    }
}
