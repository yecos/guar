package u1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.umeng.analytics.pro.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import t9.g;
import t9.i;
import u1.a;

/* loaded from: classes.dex */
public final class b extends SQLiteOpenHelper {

    /* renamed from: a, reason: collision with root package name */
    public static final a f19017a = new a(null);

    /* renamed from: b, reason: collision with root package name */
    public static final int f19018b = 2;

    /* renamed from: c, reason: collision with root package name */
    public static final String f19019c = "addb";

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(Context context) {
        super(context, f19019c, (SQLiteDatabase.CursorFactory) null, f19018b);
        i.g(context, f.X);
    }

    public final void a(SQLiteDatabase sQLiteDatabase, c cVar) {
        String str = "ALTER TABLE " + u1.a.f19002c.l() + " ADD COLUMN " + cVar.a() + ' ' + cVar.b();
        if (sQLiteDatabase != null) {
            sQLiteDatabase.execSQL(str);
        }
    }

    public final String b(String str, String str2, List list) {
        StringBuffer stringBuffer = new StringBuffer("create table ");
        stringBuffer.append(str);
        stringBuffer.append(" (");
        stringBuffer.append(str2);
        stringBuffer.append(" integer primary key autoincrement");
        Iterator it = list.iterator();
        while (it.hasNext()) {
            c cVar = (c) it.next();
            stringBuffer.append(",");
            stringBuffer.append(cVar.a());
            stringBuffer.append(" ");
            stringBuffer.append(cVar.b());
        }
        stringBuffer.append(")");
        String stringBuffer2 = stringBuffer.toString();
        i.f(stringBuffer2, "stringBuilder.toString()");
        return stringBuffer2;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        i.g(sQLiteDatabase, "db");
        ArrayList arrayList = new ArrayList();
        a.C0327a c0327a = u1.a.f19002c;
        arrayList.add(new c(c0327a.a(), "text(40)"));
        arrayList.add(new c(c0327a.b(), "text(40)"));
        arrayList.add(new c(c0327a.f(), "integer"));
        arrayList.add(new c(c0327a.e(), "integer"));
        arrayList.add(new c(c0327a.k(), "text(60)"));
        arrayList.add(new c(c0327a.d(), "integer"));
        arrayList.add(new c(c0327a.j(), "text(40)"));
        arrayList.add(new c(c0327a.c(), "text(40)"));
        arrayList.add(new c(c0327a.i(), "Long"));
        arrayList.add(new c(c0327a.g(), "Long"));
        sQLiteDatabase.execSQL(b(c0327a.l(), c0327a.h(), arrayList));
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
        if (i10 > i11) {
            return;
        }
        while (true) {
            if (i10 == 1) {
                a(sQLiteDatabase, new c(u1.a.f19002c.g(), "Long"));
            }
            if (i10 == i11) {
                return;
            } else {
                i10++;
            }
        }
    }
}
