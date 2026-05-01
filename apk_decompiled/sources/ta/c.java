package ta;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import ra.a;

/* loaded from: classes3.dex */
public class c extends SQLiteOpenHelper {

    /* renamed from: b, reason: collision with root package name */
    public static c f18966b;

    /* renamed from: a, reason: collision with root package name */
    public a.b f18967a;

    public c(Context context, String str, int i10, a.b bVar) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, i10);
        this.f18967a = bVar;
    }

    public static c a(Context context, String str, int i10, a.b bVar) {
        if (f18966b == null) {
            f18966b = new c(context, str, i10, bVar);
        }
        return f18966b;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        a.b bVar = this.f18967a;
        if (bVar != null) {
            bVar.onCreate(sQLiteDatabase);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
        a.b bVar = this.f18967a;
        if (bVar != null) {
            bVar.onUpgrade(sQLiteDatabase, i10, i11);
        }
    }
}
