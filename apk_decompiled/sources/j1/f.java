package j1;

import android.database.Cursor;

/* loaded from: classes.dex */
public final class f implements e {

    /* renamed from: a, reason: collision with root package name */
    public final q0.e f14559a;

    /* renamed from: b, reason: collision with root package name */
    public final q0.b f14560b;

    public class a extends q0.b {
        public a(q0.e eVar) {
            super(eVar);
        }

        @Override // q0.k
        public String d() {
            return "INSERT OR REPLACE INTO `Preference` (`key`,`long_value`) VALUES (?,?)";
        }

        @Override // q0.b
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public void g(t0.f fVar, d dVar) {
            String str = dVar.f14557a;
            if (str == null) {
                fVar.bindNull(1);
            } else {
                fVar.bindString(1, str);
            }
            Long l10 = dVar.f14558b;
            if (l10 == null) {
                fVar.bindNull(2);
            } else {
                fVar.bindLong(2, l10.longValue());
            }
        }
    }

    public f(q0.e eVar) {
        this.f14559a = eVar;
        this.f14560b = new a(eVar);
    }

    @Override // j1.e
    public void a(d dVar) {
        this.f14559a.b();
        this.f14559a.c();
        try {
            this.f14560b.h(dVar);
            this.f14559a.r();
        } finally {
            this.f14559a.g();
        }
    }

    @Override // j1.e
    public Long b(String str) {
        q0.h c10 = q0.h.c("SELECT long_value FROM Preference where `key`=?", 1);
        if (str == null) {
            c10.bindNull(1);
        } else {
            c10.bindString(1, str);
        }
        this.f14559a.b();
        Long l10 = null;
        Cursor b10 = s0.c.b(this.f14559a, c10, false, null);
        try {
            if (b10.moveToFirst() && !b10.isNull(0)) {
                l10 = Long.valueOf(b10.getLong(0));
            }
            return l10;
        } finally {
            b10.close();
            c10.release();
        }
    }
}
