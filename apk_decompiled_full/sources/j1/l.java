package j1;

import android.database.Cursor;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class l implements k {

    /* renamed from: a, reason: collision with root package name */
    public final q0.e f14571a;

    /* renamed from: b, reason: collision with root package name */
    public final q0.b f14572b;

    public class a extends q0.b {
        public a(q0.e eVar) {
            super(eVar);
        }

        @Override // q0.k
        public String d() {
            return "INSERT OR IGNORE INTO `WorkName` (`name`,`work_spec_id`) VALUES (?,?)";
        }

        @Override // q0.b
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public void g(t0.f fVar, j jVar) {
            String str = jVar.f14569a;
            if (str == null) {
                fVar.bindNull(1);
            } else {
                fVar.bindString(1, str);
            }
            String str2 = jVar.f14570b;
            if (str2 == null) {
                fVar.bindNull(2);
            } else {
                fVar.bindString(2, str2);
            }
        }
    }

    public l(q0.e eVar) {
        this.f14571a = eVar;
        this.f14572b = new a(eVar);
    }

    @Override // j1.k
    public void a(j jVar) {
        this.f14571a.b();
        this.f14571a.c();
        try {
            this.f14572b.h(jVar);
            this.f14571a.r();
        } finally {
            this.f14571a.g();
        }
    }

    @Override // j1.k
    public List b(String str) {
        q0.h c10 = q0.h.c("SELECT name FROM workname WHERE work_spec_id=?", 1);
        if (str == null) {
            c10.bindNull(1);
        } else {
            c10.bindString(1, str);
        }
        this.f14571a.b();
        Cursor b10 = s0.c.b(this.f14571a, c10, false, null);
        try {
            ArrayList arrayList = new ArrayList(b10.getCount());
            while (b10.moveToNext()) {
                arrayList.add(b10.getString(0));
            }
            return arrayList;
        } finally {
            b10.close();
            c10.release();
        }
    }
}
