package q0;

import android.database.Cursor;
import java.util.Iterator;
import java.util.List;
import t0.c;

/* loaded from: classes.dex */
public class g extends c.a {

    /* renamed from: b, reason: collision with root package name */
    public q0.a f18153b;

    /* renamed from: c, reason: collision with root package name */
    public final a f18154c;

    /* renamed from: d, reason: collision with root package name */
    public final String f18155d;

    /* renamed from: e, reason: collision with root package name */
    public final String f18156e;

    public static abstract class a {

        /* renamed from: a, reason: collision with root package name */
        public final int f18157a;

        public a(int i10) {
            this.f18157a = i10;
        }

        public abstract void a(t0.b bVar);

        public abstract void b(t0.b bVar);

        public abstract void c(t0.b bVar);

        public abstract void d(t0.b bVar);

        public abstract void e(t0.b bVar);

        public abstract void f(t0.b bVar);

        public abstract b g(t0.b bVar);
    }

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public final boolean f18158a;

        /* renamed from: b, reason: collision with root package name */
        public final String f18159b;

        public b(boolean z10, String str) {
            this.f18158a = z10;
            this.f18159b = str;
        }
    }

    public g(q0.a aVar, a aVar2, String str, String str2) {
        super(aVar2.f18157a);
        this.f18153b = aVar;
        this.f18154c = aVar2;
        this.f18155d = str;
        this.f18156e = str2;
    }

    public static boolean j(t0.b bVar) {
        Cursor B = bVar.B("SELECT count(*) FROM sqlite_master WHERE name != 'android_metadata'");
        try {
            boolean z10 = false;
            if (B.moveToFirst()) {
                if (B.getInt(0) == 0) {
                    z10 = true;
                }
            }
            return z10;
        } finally {
            B.close();
        }
    }

    public static boolean k(t0.b bVar) {
        Cursor B = bVar.B("SELECT 1 FROM sqlite_master WHERE type = 'table' AND name='room_master_table'");
        try {
            boolean z10 = false;
            if (B.moveToFirst()) {
                if (B.getInt(0) != 0) {
                    z10 = true;
                }
            }
            return z10;
        } finally {
            B.close();
        }
    }

    @Override // t0.c.a
    public void b(t0.b bVar) {
        super.b(bVar);
    }

    @Override // t0.c.a
    public void d(t0.b bVar) {
        boolean j10 = j(bVar);
        this.f18154c.a(bVar);
        if (!j10) {
            b g10 = this.f18154c.g(bVar);
            if (!g10.f18158a) {
                throw new IllegalStateException("Pre-packaged database has an invalid schema: " + g10.f18159b);
            }
        }
        l(bVar);
        this.f18154c.c(bVar);
    }

    @Override // t0.c.a
    public void e(t0.b bVar, int i10, int i11) {
        g(bVar, i10, i11);
    }

    @Override // t0.c.a
    public void f(t0.b bVar) {
        super.f(bVar);
        h(bVar);
        this.f18154c.d(bVar);
        this.f18153b = null;
    }

    @Override // t0.c.a
    public void g(t0.b bVar, int i10, int i11) {
        boolean z10;
        List c10;
        q0.a aVar = this.f18153b;
        if (aVar == null || (c10 = aVar.f18106d.c(i10, i11)) == null) {
            z10 = false;
        } else {
            this.f18154c.f(bVar);
            Iterator it = c10.iterator();
            while (it.hasNext()) {
                ((r0.a) it.next()).a(bVar);
            }
            b g10 = this.f18154c.g(bVar);
            if (!g10.f18158a) {
                throw new IllegalStateException("Migration didn't properly handle: " + g10.f18159b);
            }
            this.f18154c.e(bVar);
            l(bVar);
            z10 = true;
        }
        if (z10) {
            return;
        }
        q0.a aVar2 = this.f18153b;
        if (aVar2 != null && !aVar2.a(i10, i11)) {
            this.f18154c.b(bVar);
            this.f18154c.a(bVar);
            return;
        }
        throw new IllegalStateException("A migration from " + i10 + " to " + i11 + " was required but not found. Please provide the necessary Migration path via RoomDatabase.Builder.addMigration(Migration ...) or allow for destructive migrations via one of the RoomDatabase.Builder.fallbackToDestructiveMigration* methods.");
    }

    public final void h(t0.b bVar) {
        if (!k(bVar)) {
            b g10 = this.f18154c.g(bVar);
            if (g10.f18158a) {
                this.f18154c.e(bVar);
                l(bVar);
                return;
            } else {
                throw new IllegalStateException("Pre-packaged database has an invalid schema: " + g10.f18159b);
            }
        }
        Cursor w10 = bVar.w(new t0.a("SELECT identity_hash FROM room_master_table WHERE id = 42 LIMIT 1"));
        try {
            String string = w10.moveToFirst() ? w10.getString(0) : null;
            w10.close();
            if (!this.f18155d.equals(string) && !this.f18156e.equals(string)) {
                throw new IllegalStateException("Room cannot verify the data integrity. Looks like you've changed schema but forgot to update the version number. You can simply fix this by increasing the version number.");
            }
        } catch (Throwable th) {
            w10.close();
            throw th;
        }
    }

    public final void i(t0.b bVar) {
        bVar.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
    }

    public final void l(t0.b bVar) {
        i(bVar);
        bVar.execSQL(f.a(this.f18155d));
    }
}
