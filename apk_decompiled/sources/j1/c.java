package j1;

import android.database.Cursor;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class c implements b {

    /* renamed from: a, reason: collision with root package name */
    public final q0.e f14554a;

    /* renamed from: b, reason: collision with root package name */
    public final q0.b f14555b;

    public class a extends q0.b {
        public a(q0.e eVar) {
            super(eVar);
        }

        @Override // q0.k
        public String d() {
            return "INSERT OR IGNORE INTO `Dependency` (`work_spec_id`,`prerequisite_id`) VALUES (?,?)";
        }

        @Override // q0.b
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public void g(t0.f fVar, j1.a aVar) {
            String str = aVar.f14552a;
            if (str == null) {
                fVar.bindNull(1);
            } else {
                fVar.bindString(1, str);
            }
            String str2 = aVar.f14553b;
            if (str2 == null) {
                fVar.bindNull(2);
            } else {
                fVar.bindString(2, str2);
            }
        }
    }

    public c(q0.e eVar) {
        this.f14554a = eVar;
        this.f14555b = new a(eVar);
    }

    @Override // j1.b
    public List a(String str) {
        q0.h c10 = q0.h.c("SELECT work_spec_id FROM dependency WHERE prerequisite_id=?", 1);
        if (str == null) {
            c10.bindNull(1);
        } else {
            c10.bindString(1, str);
        }
        this.f14554a.b();
        Cursor b10 = s0.c.b(this.f14554a, c10, false, null);
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

    @Override // j1.b
    public boolean b(String str) {
        q0.h c10 = q0.h.c("SELECT COUNT(*)=0 FROM dependency WHERE work_spec_id=? AND prerequisite_id IN (SELECT id FROM workspec WHERE state!=2)", 1);
        if (str == null) {
            c10.bindNull(1);
        } else {
            c10.bindString(1, str);
        }
        this.f14554a.b();
        boolean z10 = false;
        Cursor b10 = s0.c.b(this.f14554a, c10, false, null);
        try {
            if (b10.moveToFirst()) {
                z10 = b10.getInt(0) != 0;
            }
            return z10;
        } finally {
            b10.close();
            c10.release();
        }
    }

    @Override // j1.b
    public void c(j1.a aVar) {
        this.f14554a.b();
        this.f14554a.c();
        try {
            this.f14555b.h(aVar);
            this.f14554a.r();
        } finally {
            this.f14554a.g();
        }
    }

    @Override // j1.b
    public boolean d(String str) {
        q0.h c10 = q0.h.c("SELECT COUNT(*)>0 FROM dependency WHERE prerequisite_id=?", 1);
        if (str == null) {
            c10.bindNull(1);
        } else {
            c10.bindString(1, str);
        }
        this.f14554a.b();
        boolean z10 = false;
        Cursor b10 = s0.c.b(this.f14554a, c10, false, null);
        try {
            if (b10.moveToFirst()) {
                z10 = b10.getInt(0) != 0;
            }
            return z10;
        } finally {
            b10.close();
            c10.release();
        }
    }
}
