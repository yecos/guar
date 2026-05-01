package ra;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import ta.g;
import ta.h;
import ua.f;

/* loaded from: classes3.dex */
public class a {

    /* renamed from: c, reason: collision with root package name */
    public static HashMap f18583c = new HashMap();

    /* renamed from: a, reason: collision with root package name */
    public SQLiteDatabase f18584a;

    /* renamed from: b, reason: collision with root package name */
    public C0317a f18585b;

    /* renamed from: ra.a$a, reason: collision with other inner class name */
    public static class C0317a {

        /* renamed from: a, reason: collision with root package name */
        public Context f18586a = null;

        /* renamed from: b, reason: collision with root package name */
        public String f18587b = "afinal.db";

        /* renamed from: c, reason: collision with root package name */
        public int f18588c = 1;

        /* renamed from: d, reason: collision with root package name */
        public boolean f18589d = true;

        /* renamed from: e, reason: collision with root package name */
        public b f18590e;

        /* renamed from: f, reason: collision with root package name */
        public String f18591f;

        public Context a() {
            return this.f18586a;
        }

        public String b() {
            return this.f18587b;
        }

        public b c() {
            return this.f18590e;
        }

        public int d() {
            return this.f18588c;
        }

        public String e() {
            return this.f18591f;
        }

        public boolean f() {
            return this.f18589d;
        }

        public void g(Context context) {
            this.f18586a = context;
        }

        public void h(String str) {
            this.f18587b = str;
        }

        public void i(b bVar) {
            this.f18590e = bVar;
        }

        public void j(int i10) {
            this.f18588c = i10;
        }

        public void k(boolean z10) {
            this.f18589d = z10;
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        void onCreate(SQLiteDatabase sQLiteDatabase);

        void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11);
    }

    public class c extends SQLiteOpenHelper {

        /* renamed from: a, reason: collision with root package name */
        public b f18592a;

        public c(Context context, String str, int i10, b bVar) {
            super(context, str, (SQLiteDatabase.CursorFactory) null, i10);
            this.f18592a = bVar;
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
            b bVar = this.f18592a;
            if (bVar != null) {
                bVar.onUpgrade(sQLiteDatabase, i10, i11);
            } else {
                a.this.i();
            }
        }
    }

    public a(C0317a c0317a) {
        if (c0317a == null) {
            throw new va.b("daoConfig is null");
        }
        if (c0317a.a() == null) {
            throw new va.b("android context is null");
        }
        if (c0317a.e() == null || c0317a.e().trim().length() <= 0) {
            this.f18584a = new c(c0317a.a().getApplicationContext(), c0317a.b(), c0317a.d(), c0317a.c()).getWritableDatabase();
        } else {
            this.f18584a = ta.c.a(new ta.b(c0317a.a(), c0317a.e()), c0317a.b(), c0317a.d(), c0317a.c()).getWritableDatabase();
        }
        this.f18585b = c0317a;
    }

    public static a b(Context context, String str, boolean z10, int i10, b bVar) {
        C0317a c0317a = new C0317a();
        c0317a.g(context);
        c0317a.h(str);
        c0317a.k(z10);
        c0317a.j(i10);
        c0317a.i(bVar);
        return c(c0317a);
    }

    public static a c(C0317a c0317a) {
        return p(c0317a);
    }

    public static synchronized a p(C0317a c0317a) {
        a aVar;
        synchronized (a.class) {
            aVar = (a) f18583c.get(c0317a.b());
            if (aVar == null) {
                aVar = new a(c0317a);
                f18583c.put(c0317a.b(), aVar);
            }
        }
        return aVar;
    }

    public final void a(Class cls) {
        if (s(f.a(cls))) {
            return;
        }
        String e10 = g.e(cls);
        d(e10);
        this.f18584a.execSQL(e10);
    }

    public final void d(String str) {
        C0317a c0317a = this.f18585b;
        if (c0317a == null || !c0317a.f()) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(">>>>>>  ");
        sb.append(str);
    }

    public void e(Object obj) {
        a(obj.getClass());
        j(g.c(obj));
    }

    public void f(Class cls) {
        a(cls);
        String a10 = g.a(cls, null);
        d(a10);
        this.f18584a.execSQL(a10);
    }

    public void g(Class cls, Object obj) {
        a(cls);
        j(g.b(cls, obj));
    }

    public void h(Class cls, String str) {
        a(cls);
        String a10 = g.a(cls, str);
        d(a10);
        this.f18584a.execSQL(a10);
    }

    public void i() {
        Cursor rawQuery = this.f18584a.rawQuery("SELECT name FROM sqlite_master WHERE type ='table' AND name != 'sqlite_sequence'", null);
        if (rawQuery != null) {
            while (rawQuery.moveToNext()) {
                this.f18584a.execSQL("DROP TABLE " + rawQuery.getString(0));
            }
        }
        if (rawQuery != null) {
            rawQuery.close();
        }
    }

    public final void j(h hVar) {
        if (hVar == null) {
            Log.e("FinalDb", "sava error:sqlInfo is null");
        } else {
            d(hVar.d());
            this.f18584a.execSQL(hVar.d(), hVar.b());
        }
    }

    public List k(Class cls) {
        a(cls);
        return l(cls, g.h(cls));
    }

    public final List l(Class cls, String str) {
        a(cls);
        d(str);
        Cursor rawQuery = this.f18584a.rawQuery(str, null);
        try {
            try {
                ArrayList arrayList = new ArrayList();
                while (rawQuery.moveToNext()) {
                    arrayList.add(ta.a.a(rawQuery, cls, this));
                }
                rawQuery.close();
                return arrayList;
            } catch (Exception e10) {
                e10.printStackTrace();
                if (rawQuery != null) {
                    rawQuery.close();
                }
                return null;
            }
        } catch (Throwable th) {
            if (rawQuery != null) {
                rawQuery.close();
            }
            throw th;
        }
    }

    public List m(Class cls, String str) {
        a(cls);
        return l(cls, g.i(cls, str));
    }

    public List n(Class cls, String str, String str2) {
        a(cls);
        return l(cls, g.i(cls, str) + " ORDER BY " + str2);
    }

    public Object o(Object obj, Class cls) {
        a(cls);
        h j10 = g.j(cls, obj);
        if (j10 == null) {
            return null;
        }
        d(j10.d());
        Cursor rawQuery = this.f18584a.rawQuery(j10.d(), j10.c());
        try {
            try {
                if (rawQuery.moveToNext()) {
                    return ta.a.a(rawQuery, cls, this);
                }
            } catch (Exception e10) {
                e10.printStackTrace();
            }
            return null;
        } finally {
            rawQuery.close();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x004a A[Catch: Exception -> 0x0097, TryCatch #0 {Exception -> 0x0097, blocks: (B:5:0x0002, B:6:0x0010, B:8:0x0016, B:11:0x0028, B:13:0x002e, B:18:0x0040, B:22:0x0047, B:24:0x004a, B:31:0x0059, B:34:0x006b, B:41:0x0075, B:43:0x007b, B:44:0x0087, B:37:0x0092, B:26:0x0053), top: B:4:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0092 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0075 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0056 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object q(ta.d r10, java.lang.Object r11, java.lang.Class r12, java.lang.Class... r13) {
        /*
            r9 = this;
            if (r11 == 0) goto L9b
            ua.f r10 = ua.f.a(r12)     // Catch: java.lang.Exception -> L97
            java.util.HashMap r10 = r10.f19090f     // Catch: java.lang.Exception -> L97
            java.util.Collection r10 = r10.values()     // Catch: java.lang.Exception -> L97
            java.util.Iterator r10 = r10.iterator()     // Catch: java.lang.Exception -> L97
        L10:
            boolean r0 = r10.hasNext()     // Catch: java.lang.Exception -> L97
            if (r0 == 0) goto L9b
            java.lang.Object r0 = r10.next()     // Catch: java.lang.Exception -> L97
            ua.c r0 = (ua.c) r0     // Catch: java.lang.Exception -> L97
            java.lang.Object r1 = r0.d(r11)     // Catch: java.lang.Exception -> L97
            java.lang.Class r1 = r1.getClass()     // Catch: java.lang.Exception -> L97
            java.lang.Class<ta.e> r2 = ta.e.class
            if (r1 != r2) goto L39
            java.lang.Object r1 = r0.d(r11)     // Catch: java.lang.Exception -> L97
            if (r1 == 0) goto L39
            java.lang.Object r1 = r0.d(r11)     // Catch: java.lang.Exception -> L97
            ta.e r1 = (ta.e) r1     // Catch: java.lang.Exception -> L97
            java.lang.Object r1 = r1.b()     // Catch: java.lang.Exception -> L97
            goto L3a
        L39:
            r1 = 0
        L3a:
            if (r1 == 0) goto L10
            r3 = 0
            r4 = 1
            if (r13 == 0) goto L46
            int r5 = r13.length     // Catch: java.lang.Exception -> L97
            if (r5 != 0) goto L44
            goto L46
        L44:
            r5 = 0
            goto L47
        L46:
            r5 = 1
        L47:
            int r6 = r13.length     // Catch: java.lang.Exception -> L97
        L48:
            if (r3 >= r6) goto L56
            r7 = r13[r3]     // Catch: java.lang.Exception -> L97
            java.lang.Class r8 = r0.m()     // Catch: java.lang.Exception -> L97
            if (r8 != r7) goto L53
            goto L57
        L53:
            int r3 = r3 + 1
            goto L48
        L56:
            r4 = r5
        L57:
            if (r4 == 0) goto L10
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Exception -> L97
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch: java.lang.Exception -> L97
            java.lang.Class r3 = r0.m()     // Catch: java.lang.Exception -> L97
            java.lang.Object r1 = r9.o(r1, r3)     // Catch: java.lang.Exception -> L97
            if (r1 == 0) goto L10
            java.lang.Object r3 = r0.d(r11)     // Catch: java.lang.Exception -> L97
            java.lang.Class r3 = r3.getClass()     // Catch: java.lang.Exception -> L97
            if (r3 != r2) goto L92
            java.lang.Object r2 = r0.d(r11)     // Catch: java.lang.Exception -> L97
            if (r2 != 0) goto L87
            ta.e r2 = new ta.e     // Catch: java.lang.Exception -> L97
            java.lang.Class r3 = r0.m()     // Catch: java.lang.Exception -> L97
            r2.<init>(r11, r12, r3, r9)     // Catch: java.lang.Exception -> L97
            r0.l(r11, r2)     // Catch: java.lang.Exception -> L97
        L87:
            java.lang.Object r0 = r0.d(r11)     // Catch: java.lang.Exception -> L97
            ta.e r0 = (ta.e) r0     // Catch: java.lang.Exception -> L97
            r0.c(r1)     // Catch: java.lang.Exception -> L97
            goto L10
        L92:
            r0.l(r11, r1)     // Catch: java.lang.Exception -> L97
            goto L10
        L97:
            r10 = move-exception
            r10.printStackTrace()
        L9b:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: ra.a.q(ta.d, java.lang.Object, java.lang.Class, java.lang.Class[]):java.lang.Object");
    }

    public void r(Object obj) {
        a(obj.getClass());
        j(g.d(obj));
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0051, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x004e, code lost:
    
        if (r2 == null) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean s(ua.f r6) {
        /*
            r5 = this;
            boolean r0 = r6.d()
            r1 = 1
            if (r0 == 0) goto L8
            return r1
        L8:
            r0 = 0
            r2 = 0
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L48 java.lang.Exception -> L4a
            r3.<init>()     // Catch: java.lang.Throwable -> L48 java.lang.Exception -> L4a
            java.lang.String r4 = "SELECT COUNT(*) AS c FROM sqlite_master WHERE type ='table' AND name ='"
            r3.append(r4)     // Catch: java.lang.Throwable -> L48 java.lang.Exception -> L4a
            java.lang.String r4 = r6.c()     // Catch: java.lang.Throwable -> L48 java.lang.Exception -> L4a
            r3.append(r4)     // Catch: java.lang.Throwable -> L48 java.lang.Exception -> L4a
            java.lang.String r4 = "' "
            r3.append(r4)     // Catch: java.lang.Throwable -> L48 java.lang.Exception -> L4a
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> L48 java.lang.Exception -> L4a
            r5.d(r3)     // Catch: java.lang.Throwable -> L48 java.lang.Exception -> L4a
            android.database.sqlite.SQLiteDatabase r4 = r5.f18584a     // Catch: java.lang.Throwable -> L48 java.lang.Exception -> L4a
            android.database.Cursor r2 = r4.rawQuery(r3, r2)     // Catch: java.lang.Throwable -> L48 java.lang.Exception -> L4a
            if (r2 == 0) goto L42
            boolean r3 = r2.moveToNext()     // Catch: java.lang.Throwable -> L48 java.lang.Exception -> L4a
            if (r3 == 0) goto L42
            int r3 = r2.getInt(r0)     // Catch: java.lang.Throwable -> L48 java.lang.Exception -> L4a
            if (r3 <= 0) goto L42
            r6.e(r1)     // Catch: java.lang.Throwable -> L48 java.lang.Exception -> L4a
            r2.close()
            return r1
        L42:
            if (r2 == 0) goto L51
        L44:
            r2.close()
            goto L51
        L48:
            r6 = move-exception
            goto L52
        L4a:
            r6 = move-exception
            r6.printStackTrace()     // Catch: java.lang.Throwable -> L48
            if (r2 == 0) goto L51
            goto L44
        L51:
            return r0
        L52:
            if (r2 == 0) goto L57
            r2.close()
        L57:
            goto L59
        L58:
            throw r6
        L59:
            goto L58
        */
        throw new UnsupportedOperationException("Method not decompiled: ra.a.s(ua.f):boolean");
    }

    public void t(Object obj) {
        a(obj.getClass());
        j(g.l(obj));
    }

    public void u(Object obj, String str) {
        a(obj.getClass());
        j(g.m(obj, str));
    }
}
