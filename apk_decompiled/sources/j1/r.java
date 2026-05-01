package j1;

import android.database.Cursor;
import com.hpplay.component.protocol.push.IPushHandler;
import com.raizlabs.android.dbflow.sql.language.Operator;
import j1.p;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class r implements q {

    /* renamed from: a, reason: collision with root package name */
    public final q0.e f14603a;

    /* renamed from: b, reason: collision with root package name */
    public final q0.b f14604b;

    /* renamed from: c, reason: collision with root package name */
    public final q0.k f14605c;

    /* renamed from: d, reason: collision with root package name */
    public final q0.k f14606d;

    /* renamed from: e, reason: collision with root package name */
    public final q0.k f14607e;

    /* renamed from: f, reason: collision with root package name */
    public final q0.k f14608f;

    /* renamed from: g, reason: collision with root package name */
    public final q0.k f14609g;

    /* renamed from: h, reason: collision with root package name */
    public final q0.k f14610h;

    /* renamed from: i, reason: collision with root package name */
    public final q0.k f14611i;

    /* renamed from: j, reason: collision with root package name */
    public final q0.k f14612j;

    public class a extends q0.b {
        public a(q0.e eVar) {
            super(eVar);
        }

        @Override // q0.k
        public String d() {
            return "INSERT OR IGNORE INTO `WorkSpec` (`id`,`state`,`worker_class_name`,`input_merger_class_name`,`input`,`output`,`initial_delay`,`interval_duration`,`flex_duration`,`run_attempt_count`,`backoff_policy`,`backoff_delay_duration`,`period_start_time`,`minimum_retention_duration`,`schedule_requested_at`,`run_in_foreground`,`out_of_quota_policy`,`required_network_type`,`requires_charging`,`requires_device_idle`,`requires_battery_not_low`,`requires_storage_not_low`,`trigger_content_update_delay`,`trigger_max_content_delay`,`content_uri_triggers`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }

        @Override // q0.b
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public void g(t0.f fVar, p pVar) {
            String str = pVar.f14583a;
            if (str == null) {
                fVar.bindNull(1);
            } else {
                fVar.bindString(1, str);
            }
            fVar.bindLong(2, v.j(pVar.f14584b));
            String str2 = pVar.f14585c;
            if (str2 == null) {
                fVar.bindNull(3);
            } else {
                fVar.bindString(3, str2);
            }
            String str3 = pVar.f14586d;
            if (str3 == null) {
                fVar.bindNull(4);
            } else {
                fVar.bindString(4, str3);
            }
            byte[] k10 = androidx.work.b.k(pVar.f14587e);
            if (k10 == null) {
                fVar.bindNull(5);
            } else {
                fVar.bindBlob(5, k10);
            }
            byte[] k11 = androidx.work.b.k(pVar.f14588f);
            if (k11 == null) {
                fVar.bindNull(6);
            } else {
                fVar.bindBlob(6, k11);
            }
            fVar.bindLong(7, pVar.f14589g);
            fVar.bindLong(8, pVar.f14590h);
            fVar.bindLong(9, pVar.f14591i);
            fVar.bindLong(10, pVar.f14593k);
            fVar.bindLong(11, v.a(pVar.f14594l));
            fVar.bindLong(12, pVar.f14595m);
            fVar.bindLong(13, pVar.f14596n);
            fVar.bindLong(14, pVar.f14597o);
            fVar.bindLong(15, pVar.f14598p);
            fVar.bindLong(16, pVar.f14599q ? 1L : 0L);
            fVar.bindLong(17, v.i(pVar.f14600r));
            a1.b bVar = pVar.f14592j;
            if (bVar == null) {
                fVar.bindNull(18);
                fVar.bindNull(19);
                fVar.bindNull(20);
                fVar.bindNull(21);
                fVar.bindNull(22);
                fVar.bindNull(23);
                fVar.bindNull(24);
                fVar.bindNull(25);
                return;
            }
            fVar.bindLong(18, v.h(bVar.b()));
            fVar.bindLong(19, bVar.g() ? 1L : 0L);
            fVar.bindLong(20, bVar.h() ? 1L : 0L);
            fVar.bindLong(21, bVar.f() ? 1L : 0L);
            fVar.bindLong(22, bVar.i() ? 1L : 0L);
            fVar.bindLong(23, bVar.c());
            fVar.bindLong(24, bVar.d());
            byte[] c10 = v.c(bVar.a());
            if (c10 == null) {
                fVar.bindNull(25);
            } else {
                fVar.bindBlob(25, c10);
            }
        }
    }

    public class b extends q0.k {
        public b(q0.e eVar) {
            super(eVar);
        }

        @Override // q0.k
        public String d() {
            return "DELETE FROM workspec WHERE id=?";
        }
    }

    public class c extends q0.k {
        public c(q0.e eVar) {
            super(eVar);
        }

        @Override // q0.k
        public String d() {
            return "UPDATE workspec SET output=? WHERE id=?";
        }
    }

    public class d extends q0.k {
        public d(q0.e eVar) {
            super(eVar);
        }

        @Override // q0.k
        public String d() {
            return "UPDATE workspec SET period_start_time=? WHERE id=?";
        }
    }

    public class e extends q0.k {
        public e(q0.e eVar) {
            super(eVar);
        }

        @Override // q0.k
        public String d() {
            return "UPDATE workspec SET run_attempt_count=run_attempt_count+1 WHERE id=?";
        }
    }

    public class f extends q0.k {
        public f(q0.e eVar) {
            super(eVar);
        }

        @Override // q0.k
        public String d() {
            return "UPDATE workspec SET run_attempt_count=0 WHERE id=?";
        }
    }

    public class g extends q0.k {
        public g(q0.e eVar) {
            super(eVar);
        }

        @Override // q0.k
        public String d() {
            return "UPDATE workspec SET schedule_requested_at=? WHERE id=?";
        }
    }

    public class h extends q0.k {
        public h(q0.e eVar) {
            super(eVar);
        }

        @Override // q0.k
        public String d() {
            return "UPDATE workspec SET schedule_requested_at=-1 WHERE state NOT IN (2, 3, 5)";
        }
    }

    public class i extends q0.k {
        public i(q0.e eVar) {
            super(eVar);
        }

        @Override // q0.k
        public String d() {
            return "DELETE FROM workspec WHERE state IN (2, 3, 5) AND (SELECT COUNT(*)=0 FROM dependency WHERE     prerequisite_id=id AND     work_spec_id NOT IN         (SELECT id FROM workspec WHERE state IN (2, 3, 5)))";
        }
    }

    public r(q0.e eVar) {
        this.f14603a = eVar;
        this.f14604b = new a(eVar);
        this.f14605c = new b(eVar);
        this.f14606d = new c(eVar);
        this.f14607e = new d(eVar);
        this.f14608f = new e(eVar);
        this.f14609g = new f(eVar);
        this.f14610h = new g(eVar);
        this.f14611i = new h(eVar);
        this.f14612j = new i(eVar);
    }

    @Override // j1.q
    public void a(String str) {
        this.f14603a.b();
        t0.f a10 = this.f14605c.a();
        if (str == null) {
            a10.bindNull(1);
        } else {
            a10.bindString(1, str);
        }
        this.f14603a.c();
        try {
            a10.executeUpdateDelete();
            this.f14603a.r();
        } finally {
            this.f14603a.g();
            this.f14605c.f(a10);
        }
    }

    @Override // j1.q
    public List b(long j10) {
        q0.h hVar;
        q0.h c10 = q0.h.c("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground`, `WorkSpec`.`out_of_quota_policy` AS `out_of_quota_policy` FROM workspec WHERE period_start_time >= ? AND state IN (2, 3, 5) ORDER BY period_start_time DESC", 1);
        c10.bindLong(1, j10);
        this.f14603a.b();
        Cursor b10 = s0.c.b(this.f14603a, c10, false, null);
        try {
            int b11 = s0.b.b(b10, "required_network_type");
            int b12 = s0.b.b(b10, "requires_charging");
            int b13 = s0.b.b(b10, "requires_device_idle");
            int b14 = s0.b.b(b10, "requires_battery_not_low");
            int b15 = s0.b.b(b10, "requires_storage_not_low");
            int b16 = s0.b.b(b10, "trigger_content_update_delay");
            int b17 = s0.b.b(b10, "trigger_max_content_delay");
            int b18 = s0.b.b(b10, "content_uri_triggers");
            int b19 = s0.b.b(b10, "id");
            int b20 = s0.b.b(b10, IPushHandler.STATE);
            int b21 = s0.b.b(b10, "worker_class_name");
            int b22 = s0.b.b(b10, "input_merger_class_name");
            int b23 = s0.b.b(b10, "input");
            int b24 = s0.b.b(b10, "output");
            hVar = c10;
            try {
                int b25 = s0.b.b(b10, "initial_delay");
                int b26 = s0.b.b(b10, "interval_duration");
                int b27 = s0.b.b(b10, "flex_duration");
                int b28 = s0.b.b(b10, "run_attempt_count");
                int b29 = s0.b.b(b10, "backoff_policy");
                int b30 = s0.b.b(b10, "backoff_delay_duration");
                int b31 = s0.b.b(b10, "period_start_time");
                int b32 = s0.b.b(b10, "minimum_retention_duration");
                int b33 = s0.b.b(b10, "schedule_requested_at");
                int b34 = s0.b.b(b10, "run_in_foreground");
                int b35 = s0.b.b(b10, "out_of_quota_policy");
                int i10 = b24;
                ArrayList arrayList = new ArrayList(b10.getCount());
                while (b10.moveToNext()) {
                    String string = b10.getString(b19);
                    int i11 = b19;
                    String string2 = b10.getString(b21);
                    int i12 = b21;
                    a1.b bVar = new a1.b();
                    int i13 = b11;
                    bVar.k(v.e(b10.getInt(b11)));
                    bVar.m(b10.getInt(b12) != 0);
                    bVar.n(b10.getInt(b13) != 0);
                    bVar.l(b10.getInt(b14) != 0);
                    bVar.o(b10.getInt(b15) != 0);
                    int i14 = b12;
                    int i15 = b13;
                    bVar.p(b10.getLong(b16));
                    bVar.q(b10.getLong(b17));
                    bVar.j(v.b(b10.getBlob(b18)));
                    p pVar = new p(string, string2);
                    pVar.f14584b = v.g(b10.getInt(b20));
                    pVar.f14586d = b10.getString(b22);
                    pVar.f14587e = androidx.work.b.g(b10.getBlob(b23));
                    int i16 = i10;
                    pVar.f14588f = androidx.work.b.g(b10.getBlob(i16));
                    int i17 = b25;
                    i10 = i16;
                    pVar.f14589g = b10.getLong(i17);
                    int i18 = b22;
                    int i19 = b26;
                    pVar.f14590h = b10.getLong(i19);
                    int i20 = b14;
                    int i21 = b27;
                    pVar.f14591i = b10.getLong(i21);
                    int i22 = b28;
                    pVar.f14593k = b10.getInt(i22);
                    int i23 = b29;
                    pVar.f14594l = v.d(b10.getInt(i23));
                    b27 = i21;
                    int i24 = b30;
                    pVar.f14595m = b10.getLong(i24);
                    int i25 = b31;
                    pVar.f14596n = b10.getLong(i25);
                    b31 = i25;
                    int i26 = b32;
                    pVar.f14597o = b10.getLong(i26);
                    int i27 = b33;
                    pVar.f14598p = b10.getLong(i27);
                    int i28 = b34;
                    pVar.f14599q = b10.getInt(i28) != 0;
                    int i29 = b35;
                    pVar.f14600r = v.f(b10.getInt(i29));
                    pVar.f14592j = bVar;
                    arrayList.add(pVar);
                    b12 = i14;
                    b35 = i29;
                    b22 = i18;
                    b25 = i17;
                    b26 = i19;
                    b28 = i22;
                    b33 = i27;
                    b19 = i11;
                    b21 = i12;
                    b11 = i13;
                    b34 = i28;
                    b32 = i26;
                    b13 = i15;
                    b30 = i24;
                    b14 = i20;
                    b29 = i23;
                }
                b10.close();
                hVar.release();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                b10.close();
                hVar.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            hVar = c10;
        }
    }

    @Override // j1.q
    public List c() {
        q0.h hVar;
        q0.h c10 = q0.h.c("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground`, `WorkSpec`.`out_of_quota_policy` AS `out_of_quota_policy` FROM workspec WHERE state=0 AND schedule_requested_at<>-1", 0);
        this.f14603a.b();
        Cursor b10 = s0.c.b(this.f14603a, c10, false, null);
        try {
            int b11 = s0.b.b(b10, "required_network_type");
            int b12 = s0.b.b(b10, "requires_charging");
            int b13 = s0.b.b(b10, "requires_device_idle");
            int b14 = s0.b.b(b10, "requires_battery_not_low");
            int b15 = s0.b.b(b10, "requires_storage_not_low");
            int b16 = s0.b.b(b10, "trigger_content_update_delay");
            int b17 = s0.b.b(b10, "trigger_max_content_delay");
            int b18 = s0.b.b(b10, "content_uri_triggers");
            int b19 = s0.b.b(b10, "id");
            int b20 = s0.b.b(b10, IPushHandler.STATE);
            int b21 = s0.b.b(b10, "worker_class_name");
            int b22 = s0.b.b(b10, "input_merger_class_name");
            int b23 = s0.b.b(b10, "input");
            int b24 = s0.b.b(b10, "output");
            hVar = c10;
            try {
                int b25 = s0.b.b(b10, "initial_delay");
                int b26 = s0.b.b(b10, "interval_duration");
                int b27 = s0.b.b(b10, "flex_duration");
                int b28 = s0.b.b(b10, "run_attempt_count");
                int b29 = s0.b.b(b10, "backoff_policy");
                int b30 = s0.b.b(b10, "backoff_delay_duration");
                int b31 = s0.b.b(b10, "period_start_time");
                int b32 = s0.b.b(b10, "minimum_retention_duration");
                int b33 = s0.b.b(b10, "schedule_requested_at");
                int b34 = s0.b.b(b10, "run_in_foreground");
                int b35 = s0.b.b(b10, "out_of_quota_policy");
                int i10 = b24;
                ArrayList arrayList = new ArrayList(b10.getCount());
                while (b10.moveToNext()) {
                    String string = b10.getString(b19);
                    int i11 = b19;
                    String string2 = b10.getString(b21);
                    int i12 = b21;
                    a1.b bVar = new a1.b();
                    int i13 = b11;
                    bVar.k(v.e(b10.getInt(b11)));
                    bVar.m(b10.getInt(b12) != 0);
                    bVar.n(b10.getInt(b13) != 0);
                    bVar.l(b10.getInt(b14) != 0);
                    bVar.o(b10.getInt(b15) != 0);
                    int i14 = b12;
                    int i15 = b13;
                    bVar.p(b10.getLong(b16));
                    bVar.q(b10.getLong(b17));
                    bVar.j(v.b(b10.getBlob(b18)));
                    p pVar = new p(string, string2);
                    pVar.f14584b = v.g(b10.getInt(b20));
                    pVar.f14586d = b10.getString(b22);
                    pVar.f14587e = androidx.work.b.g(b10.getBlob(b23));
                    int i16 = i10;
                    pVar.f14588f = androidx.work.b.g(b10.getBlob(i16));
                    i10 = i16;
                    int i17 = b25;
                    pVar.f14589g = b10.getLong(i17);
                    int i18 = b23;
                    int i19 = b26;
                    pVar.f14590h = b10.getLong(i19);
                    int i20 = b14;
                    int i21 = b27;
                    pVar.f14591i = b10.getLong(i21);
                    int i22 = b28;
                    pVar.f14593k = b10.getInt(i22);
                    int i23 = b29;
                    pVar.f14594l = v.d(b10.getInt(i23));
                    b27 = i21;
                    int i24 = b30;
                    pVar.f14595m = b10.getLong(i24);
                    int i25 = b31;
                    pVar.f14596n = b10.getLong(i25);
                    b31 = i25;
                    int i26 = b32;
                    pVar.f14597o = b10.getLong(i26);
                    int i27 = b33;
                    pVar.f14598p = b10.getLong(i27);
                    int i28 = b34;
                    pVar.f14599q = b10.getInt(i28) != 0;
                    int i29 = b35;
                    pVar.f14600r = v.f(b10.getInt(i29));
                    pVar.f14592j = bVar;
                    arrayList.add(pVar);
                    b35 = i29;
                    b12 = i14;
                    b23 = i18;
                    b25 = i17;
                    b26 = i19;
                    b28 = i22;
                    b33 = i27;
                    b19 = i11;
                    b21 = i12;
                    b11 = i13;
                    b34 = i28;
                    b32 = i26;
                    b13 = i15;
                    b30 = i24;
                    b14 = i20;
                    b29 = i23;
                }
                b10.close();
                hVar.release();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                b10.close();
                hVar.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            hVar = c10;
        }
    }

    @Override // j1.q
    public int d(a1.s sVar, String... strArr) {
        this.f14603a.b();
        StringBuilder b10 = s0.e.b();
        b10.append("UPDATE workspec SET state=");
        b10.append(Operator.Operation.EMPTY_PARAM);
        b10.append(" WHERE id IN (");
        s0.e.a(b10, strArr.length);
        b10.append(")");
        t0.f d10 = this.f14603a.d(b10.toString());
        d10.bindLong(1, v.j(sVar));
        int i10 = 2;
        for (String str : strArr) {
            if (str == null) {
                d10.bindNull(i10);
            } else {
                d10.bindString(i10, str);
            }
            i10++;
        }
        this.f14603a.c();
        try {
            int executeUpdateDelete = d10.executeUpdateDelete();
            this.f14603a.r();
            return executeUpdateDelete;
        } finally {
            this.f14603a.g();
        }
    }

    @Override // j1.q
    public void e(p pVar) {
        this.f14603a.b();
        this.f14603a.c();
        try {
            this.f14604b.h(pVar);
            this.f14603a.r();
        } finally {
            this.f14603a.g();
        }
    }

    @Override // j1.q
    public List f(String str) {
        q0.h c10 = q0.h.c("SELECT id FROM workspec WHERE state NOT IN (2, 3, 5) AND id IN (SELECT work_spec_id FROM workname WHERE name=?)", 1);
        if (str == null) {
            c10.bindNull(1);
        } else {
            c10.bindString(1, str);
        }
        this.f14603a.b();
        Cursor b10 = s0.c.b(this.f14603a, c10, false, null);
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

    @Override // j1.q
    public a1.s g(String str) {
        q0.h c10 = q0.h.c("SELECT state FROM workspec WHERE id=?", 1);
        if (str == null) {
            c10.bindNull(1);
        } else {
            c10.bindString(1, str);
        }
        this.f14603a.b();
        Cursor b10 = s0.c.b(this.f14603a, c10, false, null);
        try {
            return b10.moveToFirst() ? v.g(b10.getInt(0)) : null;
        } finally {
            b10.close();
            c10.release();
        }
    }

    @Override // j1.q
    public p h(String str) {
        q0.h hVar;
        p pVar;
        q0.h c10 = q0.h.c("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground`, `WorkSpec`.`out_of_quota_policy` AS `out_of_quota_policy` FROM workspec WHERE id=?", 1);
        if (str == null) {
            c10.bindNull(1);
        } else {
            c10.bindString(1, str);
        }
        this.f14603a.b();
        Cursor b10 = s0.c.b(this.f14603a, c10, false, null);
        try {
            int b11 = s0.b.b(b10, "required_network_type");
            int b12 = s0.b.b(b10, "requires_charging");
            int b13 = s0.b.b(b10, "requires_device_idle");
            int b14 = s0.b.b(b10, "requires_battery_not_low");
            int b15 = s0.b.b(b10, "requires_storage_not_low");
            int b16 = s0.b.b(b10, "trigger_content_update_delay");
            int b17 = s0.b.b(b10, "trigger_max_content_delay");
            int b18 = s0.b.b(b10, "content_uri_triggers");
            int b19 = s0.b.b(b10, "id");
            int b20 = s0.b.b(b10, IPushHandler.STATE);
            int b21 = s0.b.b(b10, "worker_class_name");
            int b22 = s0.b.b(b10, "input_merger_class_name");
            int b23 = s0.b.b(b10, "input");
            int b24 = s0.b.b(b10, "output");
            hVar = c10;
            try {
                int b25 = s0.b.b(b10, "initial_delay");
                int b26 = s0.b.b(b10, "interval_duration");
                int b27 = s0.b.b(b10, "flex_duration");
                int b28 = s0.b.b(b10, "run_attempt_count");
                int b29 = s0.b.b(b10, "backoff_policy");
                int b30 = s0.b.b(b10, "backoff_delay_duration");
                int b31 = s0.b.b(b10, "period_start_time");
                int b32 = s0.b.b(b10, "minimum_retention_duration");
                int b33 = s0.b.b(b10, "schedule_requested_at");
                int b34 = s0.b.b(b10, "run_in_foreground");
                int b35 = s0.b.b(b10, "out_of_quota_policy");
                if (b10.moveToFirst()) {
                    String string = b10.getString(b19);
                    String string2 = b10.getString(b21);
                    a1.b bVar = new a1.b();
                    bVar.k(v.e(b10.getInt(b11)));
                    bVar.m(b10.getInt(b12) != 0);
                    bVar.n(b10.getInt(b13) != 0);
                    bVar.l(b10.getInt(b14) != 0);
                    bVar.o(b10.getInt(b15) != 0);
                    bVar.p(b10.getLong(b16));
                    bVar.q(b10.getLong(b17));
                    bVar.j(v.b(b10.getBlob(b18)));
                    p pVar2 = new p(string, string2);
                    pVar2.f14584b = v.g(b10.getInt(b20));
                    pVar2.f14586d = b10.getString(b22);
                    pVar2.f14587e = androidx.work.b.g(b10.getBlob(b23));
                    pVar2.f14588f = androidx.work.b.g(b10.getBlob(b24));
                    pVar2.f14589g = b10.getLong(b25);
                    pVar2.f14590h = b10.getLong(b26);
                    pVar2.f14591i = b10.getLong(b27);
                    pVar2.f14593k = b10.getInt(b28);
                    pVar2.f14594l = v.d(b10.getInt(b29));
                    pVar2.f14595m = b10.getLong(b30);
                    pVar2.f14596n = b10.getLong(b31);
                    pVar2.f14597o = b10.getLong(b32);
                    pVar2.f14598p = b10.getLong(b33);
                    pVar2.f14599q = b10.getInt(b34) != 0;
                    pVar2.f14600r = v.f(b10.getInt(b35));
                    pVar2.f14592j = bVar;
                    pVar = pVar2;
                } else {
                    pVar = null;
                }
                b10.close();
                hVar.release();
                return pVar;
            } catch (Throwable th) {
                th = th;
                b10.close();
                hVar.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            hVar = c10;
        }
    }

    @Override // j1.q
    public List i(String str) {
        q0.h c10 = q0.h.c("SELECT output FROM workspec WHERE id IN (SELECT prerequisite_id FROM dependency WHERE work_spec_id=?)", 1);
        if (str == null) {
            c10.bindNull(1);
        } else {
            c10.bindString(1, str);
        }
        this.f14603a.b();
        Cursor b10 = s0.c.b(this.f14603a, c10, false, null);
        try {
            ArrayList arrayList = new ArrayList(b10.getCount());
            while (b10.moveToNext()) {
                arrayList.add(androidx.work.b.g(b10.getBlob(0)));
            }
            return arrayList;
        } finally {
            b10.close();
            c10.release();
        }
    }

    @Override // j1.q
    public List j(int i10) {
        q0.h hVar;
        q0.h c10 = q0.h.c("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground`, `WorkSpec`.`out_of_quota_policy` AS `out_of_quota_policy` FROM workspec WHERE state=0 ORDER BY period_start_time LIMIT ?", 1);
        c10.bindLong(1, i10);
        this.f14603a.b();
        Cursor b10 = s0.c.b(this.f14603a, c10, false, null);
        try {
            int b11 = s0.b.b(b10, "required_network_type");
            int b12 = s0.b.b(b10, "requires_charging");
            int b13 = s0.b.b(b10, "requires_device_idle");
            int b14 = s0.b.b(b10, "requires_battery_not_low");
            int b15 = s0.b.b(b10, "requires_storage_not_low");
            int b16 = s0.b.b(b10, "trigger_content_update_delay");
            int b17 = s0.b.b(b10, "trigger_max_content_delay");
            int b18 = s0.b.b(b10, "content_uri_triggers");
            int b19 = s0.b.b(b10, "id");
            int b20 = s0.b.b(b10, IPushHandler.STATE);
            int b21 = s0.b.b(b10, "worker_class_name");
            int b22 = s0.b.b(b10, "input_merger_class_name");
            int b23 = s0.b.b(b10, "input");
            int b24 = s0.b.b(b10, "output");
            hVar = c10;
            try {
                int b25 = s0.b.b(b10, "initial_delay");
                int b26 = s0.b.b(b10, "interval_duration");
                int b27 = s0.b.b(b10, "flex_duration");
                int b28 = s0.b.b(b10, "run_attempt_count");
                int b29 = s0.b.b(b10, "backoff_policy");
                int b30 = s0.b.b(b10, "backoff_delay_duration");
                int b31 = s0.b.b(b10, "period_start_time");
                int b32 = s0.b.b(b10, "minimum_retention_duration");
                int b33 = s0.b.b(b10, "schedule_requested_at");
                int b34 = s0.b.b(b10, "run_in_foreground");
                int b35 = s0.b.b(b10, "out_of_quota_policy");
                int i11 = b24;
                ArrayList arrayList = new ArrayList(b10.getCount());
                while (b10.moveToNext()) {
                    String string = b10.getString(b19);
                    int i12 = b19;
                    String string2 = b10.getString(b21);
                    int i13 = b21;
                    a1.b bVar = new a1.b();
                    int i14 = b11;
                    bVar.k(v.e(b10.getInt(b11)));
                    bVar.m(b10.getInt(b12) != 0);
                    bVar.n(b10.getInt(b13) != 0);
                    bVar.l(b10.getInt(b14) != 0);
                    bVar.o(b10.getInt(b15) != 0);
                    int i15 = b12;
                    int i16 = b13;
                    bVar.p(b10.getLong(b16));
                    bVar.q(b10.getLong(b17));
                    bVar.j(v.b(b10.getBlob(b18)));
                    p pVar = new p(string, string2);
                    pVar.f14584b = v.g(b10.getInt(b20));
                    pVar.f14586d = b10.getString(b22);
                    pVar.f14587e = androidx.work.b.g(b10.getBlob(b23));
                    int i17 = i11;
                    pVar.f14588f = androidx.work.b.g(b10.getBlob(i17));
                    i11 = i17;
                    int i18 = b25;
                    pVar.f14589g = b10.getLong(i18);
                    int i19 = b22;
                    int i20 = b26;
                    pVar.f14590h = b10.getLong(i20);
                    int i21 = b14;
                    int i22 = b27;
                    pVar.f14591i = b10.getLong(i22);
                    int i23 = b28;
                    pVar.f14593k = b10.getInt(i23);
                    int i24 = b29;
                    pVar.f14594l = v.d(b10.getInt(i24));
                    b27 = i22;
                    int i25 = b30;
                    pVar.f14595m = b10.getLong(i25);
                    int i26 = b31;
                    pVar.f14596n = b10.getLong(i26);
                    b31 = i26;
                    int i27 = b32;
                    pVar.f14597o = b10.getLong(i27);
                    int i28 = b33;
                    pVar.f14598p = b10.getLong(i28);
                    int i29 = b34;
                    pVar.f14599q = b10.getInt(i29) != 0;
                    int i30 = b35;
                    pVar.f14600r = v.f(b10.getInt(i30));
                    pVar.f14592j = bVar;
                    arrayList.add(pVar);
                    b35 = i30;
                    b12 = i15;
                    b22 = i19;
                    b25 = i18;
                    b26 = i20;
                    b28 = i23;
                    b33 = i28;
                    b19 = i12;
                    b21 = i13;
                    b11 = i14;
                    b34 = i29;
                    b32 = i27;
                    b13 = i16;
                    b30 = i25;
                    b14 = i21;
                    b29 = i24;
                }
                b10.close();
                hVar.release();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                b10.close();
                hVar.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            hVar = c10;
        }
    }

    @Override // j1.q
    public int k() {
        this.f14603a.b();
        t0.f a10 = this.f14611i.a();
        this.f14603a.c();
        try {
            int executeUpdateDelete = a10.executeUpdateDelete();
            this.f14603a.r();
            return executeUpdateDelete;
        } finally {
            this.f14603a.g();
            this.f14611i.f(a10);
        }
    }

    @Override // j1.q
    public int l(String str, long j10) {
        this.f14603a.b();
        t0.f a10 = this.f14610h.a();
        a10.bindLong(1, j10);
        if (str == null) {
            a10.bindNull(2);
        } else {
            a10.bindString(2, str);
        }
        this.f14603a.c();
        try {
            int executeUpdateDelete = a10.executeUpdateDelete();
            this.f14603a.r();
            return executeUpdateDelete;
        } finally {
            this.f14603a.g();
            this.f14610h.f(a10);
        }
    }

    @Override // j1.q
    public List m(String str) {
        q0.h c10 = q0.h.c("SELECT id, state FROM workspec WHERE id IN (SELECT work_spec_id FROM workname WHERE name=?)", 1);
        if (str == null) {
            c10.bindNull(1);
        } else {
            c10.bindString(1, str);
        }
        this.f14603a.b();
        Cursor b10 = s0.c.b(this.f14603a, c10, false, null);
        try {
            int b11 = s0.b.b(b10, "id");
            int b12 = s0.b.b(b10, IPushHandler.STATE);
            ArrayList arrayList = new ArrayList(b10.getCount());
            while (b10.moveToNext()) {
                p.b bVar = new p.b();
                bVar.f14601a = b10.getString(b11);
                bVar.f14602b = v.g(b10.getInt(b12));
                arrayList.add(bVar);
            }
            return arrayList;
        } finally {
            b10.close();
            c10.release();
        }
    }

    @Override // j1.q
    public List n(int i10) {
        q0.h hVar;
        q0.h c10 = q0.h.c("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground`, `WorkSpec`.`out_of_quota_policy` AS `out_of_quota_policy` FROM workspec WHERE state=0 AND schedule_requested_at=-1 ORDER BY period_start_time LIMIT (SELECT MAX(?-COUNT(*), 0) FROM workspec WHERE schedule_requested_at<>-1 AND state NOT IN (2, 3, 5))", 1);
        c10.bindLong(1, i10);
        this.f14603a.b();
        Cursor b10 = s0.c.b(this.f14603a, c10, false, null);
        try {
            int b11 = s0.b.b(b10, "required_network_type");
            int b12 = s0.b.b(b10, "requires_charging");
            int b13 = s0.b.b(b10, "requires_device_idle");
            int b14 = s0.b.b(b10, "requires_battery_not_low");
            int b15 = s0.b.b(b10, "requires_storage_not_low");
            int b16 = s0.b.b(b10, "trigger_content_update_delay");
            int b17 = s0.b.b(b10, "trigger_max_content_delay");
            int b18 = s0.b.b(b10, "content_uri_triggers");
            int b19 = s0.b.b(b10, "id");
            int b20 = s0.b.b(b10, IPushHandler.STATE);
            int b21 = s0.b.b(b10, "worker_class_name");
            int b22 = s0.b.b(b10, "input_merger_class_name");
            int b23 = s0.b.b(b10, "input");
            int b24 = s0.b.b(b10, "output");
            hVar = c10;
            try {
                int b25 = s0.b.b(b10, "initial_delay");
                int b26 = s0.b.b(b10, "interval_duration");
                int b27 = s0.b.b(b10, "flex_duration");
                int b28 = s0.b.b(b10, "run_attempt_count");
                int b29 = s0.b.b(b10, "backoff_policy");
                int b30 = s0.b.b(b10, "backoff_delay_duration");
                int b31 = s0.b.b(b10, "period_start_time");
                int b32 = s0.b.b(b10, "minimum_retention_duration");
                int b33 = s0.b.b(b10, "schedule_requested_at");
                int b34 = s0.b.b(b10, "run_in_foreground");
                int b35 = s0.b.b(b10, "out_of_quota_policy");
                int i11 = b24;
                ArrayList arrayList = new ArrayList(b10.getCount());
                while (b10.moveToNext()) {
                    String string = b10.getString(b19);
                    int i12 = b19;
                    String string2 = b10.getString(b21);
                    int i13 = b21;
                    a1.b bVar = new a1.b();
                    int i14 = b11;
                    bVar.k(v.e(b10.getInt(b11)));
                    bVar.m(b10.getInt(b12) != 0);
                    bVar.n(b10.getInt(b13) != 0);
                    bVar.l(b10.getInt(b14) != 0);
                    bVar.o(b10.getInt(b15) != 0);
                    int i15 = b12;
                    int i16 = b13;
                    bVar.p(b10.getLong(b16));
                    bVar.q(b10.getLong(b17));
                    bVar.j(v.b(b10.getBlob(b18)));
                    p pVar = new p(string, string2);
                    pVar.f14584b = v.g(b10.getInt(b20));
                    pVar.f14586d = b10.getString(b22);
                    pVar.f14587e = androidx.work.b.g(b10.getBlob(b23));
                    int i17 = i11;
                    pVar.f14588f = androidx.work.b.g(b10.getBlob(i17));
                    i11 = i17;
                    int i18 = b25;
                    pVar.f14589g = b10.getLong(i18);
                    int i19 = b22;
                    int i20 = b26;
                    pVar.f14590h = b10.getLong(i20);
                    int i21 = b14;
                    int i22 = b27;
                    pVar.f14591i = b10.getLong(i22);
                    int i23 = b28;
                    pVar.f14593k = b10.getInt(i23);
                    int i24 = b29;
                    pVar.f14594l = v.d(b10.getInt(i24));
                    b27 = i22;
                    int i25 = b30;
                    pVar.f14595m = b10.getLong(i25);
                    int i26 = b31;
                    pVar.f14596n = b10.getLong(i26);
                    b31 = i26;
                    int i27 = b32;
                    pVar.f14597o = b10.getLong(i27);
                    int i28 = b33;
                    pVar.f14598p = b10.getLong(i28);
                    int i29 = b34;
                    pVar.f14599q = b10.getInt(i29) != 0;
                    int i30 = b35;
                    pVar.f14600r = v.f(b10.getInt(i30));
                    pVar.f14592j = bVar;
                    arrayList.add(pVar);
                    b35 = i30;
                    b12 = i15;
                    b22 = i19;
                    b25 = i18;
                    b26 = i20;
                    b28 = i23;
                    b33 = i28;
                    b19 = i12;
                    b21 = i13;
                    b11 = i14;
                    b34 = i29;
                    b32 = i27;
                    b13 = i16;
                    b30 = i25;
                    b14 = i21;
                    b29 = i24;
                }
                b10.close();
                hVar.release();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                b10.close();
                hVar.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            hVar = c10;
        }
    }

    @Override // j1.q
    public void o(String str, androidx.work.b bVar) {
        this.f14603a.b();
        t0.f a10 = this.f14606d.a();
        byte[] k10 = androidx.work.b.k(bVar);
        if (k10 == null) {
            a10.bindNull(1);
        } else {
            a10.bindBlob(1, k10);
        }
        if (str == null) {
            a10.bindNull(2);
        } else {
            a10.bindString(2, str);
        }
        this.f14603a.c();
        try {
            a10.executeUpdateDelete();
            this.f14603a.r();
        } finally {
            this.f14603a.g();
            this.f14606d.f(a10);
        }
    }

    @Override // j1.q
    public List p() {
        q0.h hVar;
        q0.h c10 = q0.h.c("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground`, `WorkSpec`.`out_of_quota_policy` AS `out_of_quota_policy` FROM workspec WHERE state=1", 0);
        this.f14603a.b();
        Cursor b10 = s0.c.b(this.f14603a, c10, false, null);
        try {
            int b11 = s0.b.b(b10, "required_network_type");
            int b12 = s0.b.b(b10, "requires_charging");
            int b13 = s0.b.b(b10, "requires_device_idle");
            int b14 = s0.b.b(b10, "requires_battery_not_low");
            int b15 = s0.b.b(b10, "requires_storage_not_low");
            int b16 = s0.b.b(b10, "trigger_content_update_delay");
            int b17 = s0.b.b(b10, "trigger_max_content_delay");
            int b18 = s0.b.b(b10, "content_uri_triggers");
            int b19 = s0.b.b(b10, "id");
            int b20 = s0.b.b(b10, IPushHandler.STATE);
            int b21 = s0.b.b(b10, "worker_class_name");
            int b22 = s0.b.b(b10, "input_merger_class_name");
            int b23 = s0.b.b(b10, "input");
            int b24 = s0.b.b(b10, "output");
            hVar = c10;
            try {
                int b25 = s0.b.b(b10, "initial_delay");
                int b26 = s0.b.b(b10, "interval_duration");
                int b27 = s0.b.b(b10, "flex_duration");
                int b28 = s0.b.b(b10, "run_attempt_count");
                int b29 = s0.b.b(b10, "backoff_policy");
                int b30 = s0.b.b(b10, "backoff_delay_duration");
                int b31 = s0.b.b(b10, "period_start_time");
                int b32 = s0.b.b(b10, "minimum_retention_duration");
                int b33 = s0.b.b(b10, "schedule_requested_at");
                int b34 = s0.b.b(b10, "run_in_foreground");
                int b35 = s0.b.b(b10, "out_of_quota_policy");
                int i10 = b24;
                ArrayList arrayList = new ArrayList(b10.getCount());
                while (b10.moveToNext()) {
                    String string = b10.getString(b19);
                    int i11 = b19;
                    String string2 = b10.getString(b21);
                    int i12 = b21;
                    a1.b bVar = new a1.b();
                    int i13 = b11;
                    bVar.k(v.e(b10.getInt(b11)));
                    bVar.m(b10.getInt(b12) != 0);
                    bVar.n(b10.getInt(b13) != 0);
                    bVar.l(b10.getInt(b14) != 0);
                    bVar.o(b10.getInt(b15) != 0);
                    int i14 = b12;
                    int i15 = b13;
                    bVar.p(b10.getLong(b16));
                    bVar.q(b10.getLong(b17));
                    bVar.j(v.b(b10.getBlob(b18)));
                    p pVar = new p(string, string2);
                    pVar.f14584b = v.g(b10.getInt(b20));
                    pVar.f14586d = b10.getString(b22);
                    pVar.f14587e = androidx.work.b.g(b10.getBlob(b23));
                    int i16 = i10;
                    pVar.f14588f = androidx.work.b.g(b10.getBlob(i16));
                    i10 = i16;
                    int i17 = b25;
                    pVar.f14589g = b10.getLong(i17);
                    int i18 = b23;
                    int i19 = b26;
                    pVar.f14590h = b10.getLong(i19);
                    int i20 = b14;
                    int i21 = b27;
                    pVar.f14591i = b10.getLong(i21);
                    int i22 = b28;
                    pVar.f14593k = b10.getInt(i22);
                    int i23 = b29;
                    pVar.f14594l = v.d(b10.getInt(i23));
                    b27 = i21;
                    int i24 = b30;
                    pVar.f14595m = b10.getLong(i24);
                    int i25 = b31;
                    pVar.f14596n = b10.getLong(i25);
                    b31 = i25;
                    int i26 = b32;
                    pVar.f14597o = b10.getLong(i26);
                    int i27 = b33;
                    pVar.f14598p = b10.getLong(i27);
                    int i28 = b34;
                    pVar.f14599q = b10.getInt(i28) != 0;
                    int i29 = b35;
                    pVar.f14600r = v.f(b10.getInt(i29));
                    pVar.f14592j = bVar;
                    arrayList.add(pVar);
                    b35 = i29;
                    b12 = i14;
                    b23 = i18;
                    b25 = i17;
                    b26 = i19;
                    b28 = i22;
                    b33 = i27;
                    b19 = i11;
                    b21 = i12;
                    b11 = i13;
                    b34 = i28;
                    b32 = i26;
                    b13 = i15;
                    b30 = i24;
                    b14 = i20;
                    b29 = i23;
                }
                b10.close();
                hVar.release();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                b10.close();
                hVar.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            hVar = c10;
        }
    }

    @Override // j1.q
    public boolean q() {
        boolean z10 = false;
        q0.h c10 = q0.h.c("SELECT COUNT(*) > 0 FROM workspec WHERE state NOT IN (2, 3, 5) LIMIT 1", 0);
        this.f14603a.b();
        Cursor b10 = s0.c.b(this.f14603a, c10, false, null);
        try {
            if (b10.moveToFirst()) {
                if (b10.getInt(0) != 0) {
                    z10 = true;
                }
            }
            return z10;
        } finally {
            b10.close();
            c10.release();
        }
    }

    @Override // j1.q
    public int r(String str) {
        this.f14603a.b();
        t0.f a10 = this.f14609g.a();
        if (str == null) {
            a10.bindNull(1);
        } else {
            a10.bindString(1, str);
        }
        this.f14603a.c();
        try {
            int executeUpdateDelete = a10.executeUpdateDelete();
            this.f14603a.r();
            return executeUpdateDelete;
        } finally {
            this.f14603a.g();
            this.f14609g.f(a10);
        }
    }

    @Override // j1.q
    public int s(String str) {
        this.f14603a.b();
        t0.f a10 = this.f14608f.a();
        if (str == null) {
            a10.bindNull(1);
        } else {
            a10.bindString(1, str);
        }
        this.f14603a.c();
        try {
            int executeUpdateDelete = a10.executeUpdateDelete();
            this.f14603a.r();
            return executeUpdateDelete;
        } finally {
            this.f14603a.g();
            this.f14608f.f(a10);
        }
    }

    @Override // j1.q
    public void t(String str, long j10) {
        this.f14603a.b();
        t0.f a10 = this.f14607e.a();
        a10.bindLong(1, j10);
        if (str == null) {
            a10.bindNull(2);
        } else {
            a10.bindString(2, str);
        }
        this.f14603a.c();
        try {
            a10.executeUpdateDelete();
            this.f14603a.r();
        } finally {
            this.f14603a.g();
            this.f14607e.f(a10);
        }
    }
}
