package t0;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public interface c extends Closeable {

    public static abstract class a {

        /* renamed from: a, reason: collision with root package name */
        public final int f18789a;

        public a(int i10) {
            this.f18789a = i10;
        }

        public final void a(String str) {
            if (str.equalsIgnoreCase(":memory:") || str.trim().length() == 0) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("deleting the database file: ");
            sb.append(str);
            try {
                SQLiteDatabase.deleteDatabase(new File(str));
            } catch (Exception unused) {
            }
        }

        public void b(t0.b bVar) {
        }

        public void c(t0.b bVar) {
            Log.e("SupportSQLite", "Corruption reported by sqlite on database: " + bVar.getPath());
            if (!bVar.isOpen()) {
                a(bVar.getPath());
                return;
            }
            List list = null;
            try {
                try {
                    list = bVar.i();
                } catch (SQLiteException unused) {
                }
                try {
                    bVar.close();
                } catch (IOException unused2) {
                }
            } finally {
                if (list != null) {
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        a((String) ((Pair) it.next()).second);
                    }
                } else {
                    a(bVar.getPath());
                }
            }
        }

        public abstract void d(t0.b bVar);

        public abstract void e(t0.b bVar, int i10, int i11);

        public void f(t0.b bVar) {
        }

        public abstract void g(t0.b bVar, int i10, int i11);
    }

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public final Context f18790a;

        /* renamed from: b, reason: collision with root package name */
        public final String f18791b;

        /* renamed from: c, reason: collision with root package name */
        public final a f18792c;

        /* renamed from: d, reason: collision with root package name */
        public final boolean f18793d;

        public static class a {

            /* renamed from: a, reason: collision with root package name */
            public Context f18794a;

            /* renamed from: b, reason: collision with root package name */
            public String f18795b;

            /* renamed from: c, reason: collision with root package name */
            public a f18796c;

            /* renamed from: d, reason: collision with root package name */
            public boolean f18797d;

            public a(Context context) {
                this.f18794a = context;
            }

            public b a() {
                if (this.f18796c == null) {
                    throw new IllegalArgumentException("Must set a callback to create the configuration.");
                }
                if (this.f18794a == null) {
                    throw new IllegalArgumentException("Must set a non-null context to create the configuration.");
                }
                if (this.f18797d && TextUtils.isEmpty(this.f18795b)) {
                    throw new IllegalArgumentException("Must set a non-null database name to a configuration that uses the no backup directory.");
                }
                return new b(this.f18794a, this.f18795b, this.f18796c, this.f18797d);
            }

            public a b(a aVar) {
                this.f18796c = aVar;
                return this;
            }

            public a c(String str) {
                this.f18795b = str;
                return this;
            }

            public a d(boolean z10) {
                this.f18797d = z10;
                return this;
            }
        }

        public b(Context context, String str, a aVar, boolean z10) {
            this.f18790a = context;
            this.f18791b = str;
            this.f18792c = aVar;
            this.f18793d = z10;
        }

        public static a a(Context context) {
            return new a(context);
        }
    }

    /* renamed from: t0.c$c, reason: collision with other inner class name */
    public interface InterfaceC0321c {
        c a(b bVar);
    }

    t0.b A();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    String getDatabaseName();

    void setWriteAheadLoggingEnabled(boolean z10);
}
