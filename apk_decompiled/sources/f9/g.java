package f9;

import com.umeng.analytics.pro.bt;
import f9.e;
import java.util.List;
import java.util.Map;
import y8.k1;
import y8.o0;
import y8.p0;
import y8.q0;
import y8.y0;
import z8.a1;
import z8.c2;
import z8.j2;

/* loaded from: classes3.dex */
public final class g extends p0 {
    @Override // y8.o0.c
    public o0 a(o0.d dVar) {
        return new e(dVar, j2.f20666a);
    }

    @Override // y8.p0
    public String b() {
        return "outlier_detection_experimental";
    }

    @Override // y8.p0
    public int c() {
        return 5;
    }

    @Override // y8.p0
    public boolean d() {
        return true;
    }

    @Override // y8.p0
    public y0.b e(Map map) {
        Long l10 = a1.l(map, bt.f10040ba);
        Long l11 = a1.l(map, "baseEjectionTime");
        Long l12 = a1.l(map, "maxEjectionTime");
        Integer i10 = a1.i(map, "maxEjectionPercentage");
        e.g.a aVar = new e.g.a();
        if (l10 != null) {
            aVar.e(l10);
        }
        if (l11 != null) {
            aVar.b(l11);
        }
        if (l12 != null) {
            aVar.g(l12);
        }
        if (i10 != null) {
            aVar.f(i10);
        }
        Map j10 = a1.j(map, "successRateEjection");
        if (j10 != null) {
            e.g.c.a aVar2 = new e.g.c.a();
            Integer i11 = a1.i(j10, "stdevFactor");
            Integer i12 = a1.i(j10, "enforcementPercentage");
            Integer i13 = a1.i(j10, "minimumHosts");
            Integer i14 = a1.i(j10, "requestVolume");
            if (i11 != null) {
                aVar2.e(i11);
            }
            if (i12 != null) {
                aVar2.b(i12);
            }
            if (i13 != null) {
                aVar2.c(i13);
            }
            if (i14 != null) {
                aVar2.d(i14);
            }
            aVar.h(aVar2.a());
        }
        Map j11 = a1.j(map, "failurePercentageEjection");
        if (j11 != null) {
            e.g.b.a aVar3 = new e.g.b.a();
            Integer i15 = a1.i(j11, "threshold");
            Integer i16 = a1.i(j11, "enforcementPercentage");
            Integer i17 = a1.i(j11, "minimumHosts");
            Integer i18 = a1.i(j11, "requestVolume");
            if (i15 != null) {
                aVar3.e(i15);
            }
            if (i16 != null) {
                aVar3.b(i16);
            }
            if (i17 != null) {
                aVar3.c(i17);
            }
            if (i18 != null) {
                aVar3.d(i18);
            }
            aVar.d(aVar3.a());
        }
        List A = c2.A(a1.f(map, "childPolicy"));
        if (A == null || A.isEmpty()) {
            return y0.b.b(k1.f19903t.r("No child policy in outlier_detection_experimental LB policy: " + map));
        }
        y0.b y10 = c2.y(A, q0.b());
        if (y10.d() != null) {
            return y10;
        }
        aVar.c((c2.b) y10.c());
        return y0.b.a(aVar.a());
    }
}
