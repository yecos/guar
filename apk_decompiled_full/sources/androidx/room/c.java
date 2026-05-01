package androidx.room;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.util.Log;
import com.raizlabs.android.dbflow.sql.language.TriggerMethod;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import q0.e;
import t0.f;

/* loaded from: classes.dex */
public class c {

    /* renamed from: m, reason: collision with root package name */
    public static final String[] f3295m = {TriggerMethod.UPDATE, "DELETE", TriggerMethod.INSERT};

    /* renamed from: b, reason: collision with root package name */
    public final String[] f3297b;

    /* renamed from: c, reason: collision with root package name */
    public Map f3298c;

    /* renamed from: d, reason: collision with root package name */
    public final e f3299d;

    /* renamed from: g, reason: collision with root package name */
    public volatile f f3302g;

    /* renamed from: h, reason: collision with root package name */
    public b f3303h;

    /* renamed from: i, reason: collision with root package name */
    public final q0.c f3304i;

    /* renamed from: k, reason: collision with root package name */
    public androidx.room.d f3306k;

    /* renamed from: e, reason: collision with root package name */
    public AtomicBoolean f3300e = new AtomicBoolean(false);

    /* renamed from: f, reason: collision with root package name */
    public volatile boolean f3301f = false;

    /* renamed from: j, reason: collision with root package name */
    public final i.b f3305j = new i.b();

    /* renamed from: l, reason: collision with root package name */
    public Runnable f3307l = new a();

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f3296a = new HashMap();

    public class a implements Runnable {
        public a() {
        }

        public final Set a() {
            HashSet hashSet = new HashSet();
            Cursor p10 = c.this.f3299d.p(new t0.a("SELECT * FROM room_table_modification_log WHERE invalidated = 1;"));
            while (p10.moveToNext()) {
                try {
                    hashSet.add(Integer.valueOf(p10.getInt(0)));
                } catch (Throwable th) {
                    p10.close();
                    throw th;
                }
            }
            p10.close();
            if (!hashSet.isEmpty()) {
                c.this.f3302g.executeUpdateDelete();
            }
            return hashSet;
        }

        @Override // java.lang.Runnable
        public void run() {
            Lock h10 = c.this.f3299d.h();
            Set set = null;
            try {
                try {
                    h10.lock();
                } finally {
                    h10.unlock();
                }
            } catch (SQLiteException | IllegalStateException e10) {
                Log.e("ROOM", "Cannot run invalidation tracker. Is the db closed?", e10);
            }
            if (c.this.c()) {
                if (c.this.f3300e.compareAndSet(true, false)) {
                    if (c.this.f3299d.k()) {
                        return;
                    }
                    e eVar = c.this.f3299d;
                    if (eVar.f18126g) {
                        t0.b A = eVar.i().A();
                        A.beginTransaction();
                        try {
                            set = a();
                            A.setTransactionSuccessful();
                            A.endTransaction();
                        } catch (Throwable th) {
                            A.endTransaction();
                            throw th;
                        }
                    } else {
                        set = a();
                    }
                    if (set == null || set.isEmpty()) {
                        return;
                    }
                    synchronized (c.this.f3305j) {
                        Iterator it = c.this.f3305j.iterator();
                        while (it.hasNext()) {
                            ((d) ((Map.Entry) it.next()).getValue()).a(set);
                        }
                    }
                }
            }
        }
    }

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public final long[] f3309a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean[] f3310b;

        /* renamed from: c, reason: collision with root package name */
        public final int[] f3311c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f3312d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f3313e;

        public b(int i10) {
            long[] jArr = new long[i10];
            this.f3309a = jArr;
            boolean[] zArr = new boolean[i10];
            this.f3310b = zArr;
            this.f3311c = new int[i10];
            Arrays.fill(jArr, 0L);
            Arrays.fill(zArr, false);
        }

        public int[] a() {
            synchronized (this) {
                if (this.f3312d && !this.f3313e) {
                    int length = this.f3309a.length;
                    int i10 = 0;
                    while (true) {
                        int i11 = 1;
                        if (i10 >= length) {
                            this.f3313e = true;
                            this.f3312d = false;
                            return this.f3311c;
                        }
                        boolean z10 = this.f3309a[i10] > 0;
                        boolean[] zArr = this.f3310b;
                        if (z10 != zArr[i10]) {
                            int[] iArr = this.f3311c;
                            if (!z10) {
                                i11 = 2;
                            }
                            iArr[i10] = i11;
                        } else {
                            this.f3311c[i10] = 0;
                        }
                        zArr[i10] = z10;
                        i10++;
                    }
                }
                return null;
            }
        }

        public boolean b(int... iArr) {
            boolean z10;
            synchronized (this) {
                z10 = false;
                for (int i10 : iArr) {
                    long[] jArr = this.f3309a;
                    long j10 = jArr[i10];
                    jArr[i10] = 1 + j10;
                    if (j10 == 0) {
                        z10 = true;
                        this.f3312d = true;
                    }
                }
            }
            return z10;
        }

        public boolean c(int... iArr) {
            boolean z10;
            synchronized (this) {
                z10 = false;
                for (int i10 : iArr) {
                    long[] jArr = this.f3309a;
                    long j10 = jArr[i10];
                    jArr[i10] = j10 - 1;
                    if (j10 == 1) {
                        z10 = true;
                        this.f3312d = true;
                    }
                }
            }
            return z10;
        }

        public void d() {
            synchronized (this) {
                this.f3313e = false;
            }
        }
    }

    /* renamed from: androidx.room.c$c, reason: collision with other inner class name */
    public static abstract class AbstractC0051c {

        /* renamed from: a, reason: collision with root package name */
        public final String[] f3314a;

        public AbstractC0051c(String[] strArr) {
            this.f3314a = (String[]) Arrays.copyOf(strArr, strArr.length);
        }

        public abstract boolean a();

        public abstract void b(Set set);
    }

    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public final int[] f3315a;

        /* renamed from: b, reason: collision with root package name */
        public final String[] f3316b;

        /* renamed from: c, reason: collision with root package name */
        public final AbstractC0051c f3317c;

        /* renamed from: d, reason: collision with root package name */
        public final Set f3318d;

        public d(AbstractC0051c abstractC0051c, int[] iArr, String[] strArr) {
            this.f3317c = abstractC0051c;
            this.f3315a = iArr;
            this.f3316b = strArr;
            if (iArr.length != 1) {
                this.f3318d = null;
                return;
            }
            HashSet hashSet = new HashSet();
            hashSet.add(strArr[0]);
            this.f3318d = Collections.unmodifiableSet(hashSet);
        }

        public void a(Set set) {
            int length = this.f3315a.length;
            Set set2 = null;
            for (int i10 = 0; i10 < length; i10++) {
                if (set.contains(Integer.valueOf(this.f3315a[i10]))) {
                    if (length == 1) {
                        set2 = this.f3318d;
                    } else {
                        if (set2 == null) {
                            set2 = new HashSet(length);
                        }
                        set2.add(this.f3316b[i10]);
                    }
                }
            }
            if (set2 != null) {
                this.f3317c.b(set2);
            }
        }

        public void b(String[] strArr) {
            Set set = null;
            if (this.f3316b.length == 1) {
                int length = strArr.length;
                int i10 = 0;
                while (true) {
                    if (i10 >= length) {
                        break;
                    }
                    if (strArr[i10].equalsIgnoreCase(this.f3316b[0])) {
                        set = this.f3318d;
                        break;
                    }
                    i10++;
                }
            } else {
                HashSet hashSet = new HashSet();
                for (String str : strArr) {
                    String[] strArr2 = this.f3316b;
                    int length2 = strArr2.length;
                    int i11 = 0;
                    while (true) {
                        if (i11 < length2) {
                            String str2 = strArr2[i11];
                            if (str2.equalsIgnoreCase(str)) {
                                hashSet.add(str2);
                                break;
                            }
                            i11++;
                        }
                    }
                }
                if (hashSet.size() > 0) {
                    set = hashSet;
                }
            }
            if (set != null) {
                this.f3317c.b(set);
            }
        }
    }

    public c(e eVar, Map map, Map map2, String... strArr) {
        this.f3299d = eVar;
        this.f3303h = new b(strArr.length);
        this.f3298c = map2;
        this.f3304i = new q0.c(eVar);
        int length = strArr.length;
        this.f3297b = new String[length];
        for (int i10 = 0; i10 < length; i10++) {
            String str = strArr[i10];
            Locale locale = Locale.US;
            String lowerCase = str.toLowerCase(locale);
            this.f3296a.put(lowerCase, Integer.valueOf(i10));
            String str2 = (String) map.get(strArr[i10]);
            if (str2 != null) {
                this.f3297b[i10] = str2.toLowerCase(locale);
            } else {
                this.f3297b[i10] = lowerCase;
            }
        }
        for (Map.Entry entry : map.entrySet()) {
            String str3 = (String) entry.getValue();
            Locale locale2 = Locale.US;
            String lowerCase2 = str3.toLowerCase(locale2);
            if (this.f3296a.containsKey(lowerCase2)) {
                String lowerCase3 = ((String) entry.getKey()).toLowerCase(locale2);
                HashMap hashMap = this.f3296a;
                hashMap.put(lowerCase3, hashMap.get(lowerCase2));
            }
        }
    }

    public static void b(StringBuilder sb, String str, String str2) {
        sb.append("`");
        sb.append("room_table_modification_trigger_");
        sb.append(str);
        sb.append("_");
        sb.append(str2);
        sb.append("`");
    }

    public void a(AbstractC0051c abstractC0051c) {
        d dVar;
        String[] h10 = h(abstractC0051c.f3314a);
        int[] iArr = new int[h10.length];
        int length = h10.length;
        for (int i10 = 0; i10 < length; i10++) {
            Integer num = (Integer) this.f3296a.get(h10[i10].toLowerCase(Locale.US));
            if (num == null) {
                throw new IllegalArgumentException("There is no table with name " + h10[i10]);
            }
            iArr[i10] = num.intValue();
        }
        d dVar2 = new d(abstractC0051c, iArr, h10);
        synchronized (this.f3305j) {
            dVar = (d) this.f3305j.f(abstractC0051c, dVar2);
        }
        if (dVar == null && this.f3303h.b(iArr)) {
            l();
        }
    }

    public boolean c() {
        if (!this.f3299d.o()) {
            return false;
        }
        if (!this.f3301f) {
            this.f3299d.i().A();
        }
        if (this.f3301f) {
            return true;
        }
        Log.e("ROOM", "database is not initialized even though it is open");
        return false;
    }

    public void d(t0.b bVar) {
        synchronized (this) {
            if (this.f3301f) {
                Log.e("ROOM", "Invalidation tracker is initialized twice :/.");
                return;
            }
            bVar.execSQL("PRAGMA temp_store = MEMORY;");
            bVar.execSQL("PRAGMA recursive_triggers='ON';");
            bVar.execSQL("CREATE TEMP TABLE room_table_modification_log(table_id INTEGER PRIMARY KEY, invalidated INTEGER NOT NULL DEFAULT 0)");
            m(bVar);
            this.f3302g = bVar.compileStatement("UPDATE room_table_modification_log SET invalidated = 0 WHERE invalidated = 1 ");
            this.f3301f = true;
        }
    }

    public void e(String... strArr) {
        synchronized (this.f3305j) {
            Iterator it = this.f3305j.iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                if (!((AbstractC0051c) entry.getKey()).a()) {
                    ((d) entry.getValue()).b(strArr);
                }
            }
        }
    }

    public void f() {
        if (this.f3300e.compareAndSet(false, true)) {
            this.f3299d.j().execute(this.f3307l);
        }
    }

    public void g(AbstractC0051c abstractC0051c) {
        d dVar;
        synchronized (this.f3305j) {
            dVar = (d) this.f3305j.g(abstractC0051c);
        }
        if (dVar == null || !this.f3303h.c(dVar.f3315a)) {
            return;
        }
        l();
    }

    public final String[] h(String[] strArr) {
        HashSet hashSet = new HashSet();
        for (String str : strArr) {
            String lowerCase = str.toLowerCase(Locale.US);
            if (this.f3298c.containsKey(lowerCase)) {
                hashSet.addAll((Collection) this.f3298c.get(lowerCase));
            } else {
                hashSet.add(str);
            }
        }
        return (String[]) hashSet.toArray(new String[hashSet.size()]);
    }

    public void i(Context context, String str) {
        this.f3306k = new androidx.room.d(context, str, this, this.f3299d.j());
    }

    public final void j(t0.b bVar, int i10) {
        bVar.execSQL("INSERT OR IGNORE INTO room_table_modification_log VALUES(" + i10 + ", 0)");
        String str = this.f3297b[i10];
        StringBuilder sb = new StringBuilder();
        for (String str2 : f3295m) {
            sb.setLength(0);
            sb.append("CREATE TEMP TRIGGER IF NOT EXISTS ");
            b(sb, str, str2);
            sb.append(" AFTER ");
            sb.append(str2);
            sb.append(" ON `");
            sb.append(str);
            sb.append("` BEGIN UPDATE ");
            sb.append("room_table_modification_log");
            sb.append(" SET ");
            sb.append("invalidated");
            sb.append(" = 1");
            sb.append(" WHERE ");
            sb.append("table_id");
            sb.append(" = ");
            sb.append(i10);
            sb.append(" AND ");
            sb.append("invalidated");
            sb.append(" = 0");
            sb.append("; END");
            bVar.execSQL(sb.toString());
        }
    }

    public final void k(t0.b bVar, int i10) {
        String str = this.f3297b[i10];
        StringBuilder sb = new StringBuilder();
        for (String str2 : f3295m) {
            sb.setLength(0);
            sb.append("DROP TRIGGER IF EXISTS ");
            b(sb, str, str2);
            bVar.execSQL(sb.toString());
        }
    }

    public void l() {
        if (this.f3299d.o()) {
            m(this.f3299d.i().A());
        }
    }

    public void m(t0.b bVar) {
        if (bVar.G()) {
            return;
        }
        while (true) {
            try {
                Lock h10 = this.f3299d.h();
                h10.lock();
                try {
                    int[] a10 = this.f3303h.a();
                    if (a10 == null) {
                        return;
                    }
                    int length = a10.length;
                    bVar.beginTransaction();
                    for (int i10 = 0; i10 < length; i10++) {
                        try {
                            int i11 = a10[i10];
                            if (i11 == 1) {
                                j(bVar, i10);
                            } else if (i11 == 2) {
                                k(bVar, i10);
                            }
                        } finally {
                        }
                    }
                    bVar.setTransactionSuccessful();
                    bVar.endTransaction();
                    this.f3303h.d();
                } finally {
                    h10.unlock();
                }
            } catch (SQLiteException | IllegalStateException e10) {
                Log.e("ROOM", "Cannot run invalidation tracker. Is the db closed?", e10);
                return;
            }
        }
    }
}
