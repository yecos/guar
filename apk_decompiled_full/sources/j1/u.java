package j1;

import android.database.Cursor;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class u implements t {

    /* renamed from: a, reason: collision with root package name */
    public final q0.e f14624a;

    /* renamed from: b, reason: collision with root package name */
    public final q0.b f14625b;

    public class a extends q0.b {
        public a(q0.e eVar) {
            super(eVar);
        }

        @Override // q0.k
        public String d() {
            return "INSERT OR IGNORE INTO `WorkTag` (`tag`,`work_spec_id`) VALUES (?,?)";
        }

        @Override // q0.b
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public void g(t0.f fVar, s sVar) {
            String str = sVar.f14622a;
            if (str == null) {
                fVar.bindNull(1);
            } else {
                fVar.bindString(1, str);
            }
            String str2 = sVar.f14623b;
            if (str2 == null) {
                fVar.bindNull(2);
            } else {
                fVar.bindString(2, str2);
            }
        }
    }

    public u(q0.e eVar) {
        this.f14624a = eVar;
        this.f14625b = new a(eVar);
    }

    @Override // j1.t
    public List a(String str) {
        q0.h c10 = q0.h.c("SELECT DISTINCT tag FROM worktag WHERE work_spec_id=?", 1);
        if (str == null) {
            c10.bindNull(1);
        } else {
            c10.bindString(1, str);
        }
        this.f14624a.b();
        Cursor b10 = s0.c.b(this.f14624a, c10, false, null);
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

    @Override // j1.t
    public void b(s sVar) {
        this.f14624a.b();
        this.f14624a.c();
        try {
            this.f14625b.h(sVar);
            this.f14624a.r();
        } finally {
            this.f14624a.g();
        }
    }
}
