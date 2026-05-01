package androidx.work.impl.workers;

import a1.k;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import androidx.work.impl.WorkDatabase;
import b1.j;
import j1.g;
import j1.h;
import j1.p;
import j1.q;
import j1.t;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class DiagnosticsWorker extends Worker {

    /* renamed from: g, reason: collision with root package name */
    public static final String f3760g = k.f("DiagnosticsWrkr");

    public DiagnosticsWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
    }

    public static String s(p pVar, String str, Integer num, String str2) {
        return String.format("\n%s\t %s\t %s\t %s\t %s\t %s\t", pVar.f14583a, pVar.f14585c, num, pVar.f14584b.name(), str, str2);
    }

    public static String t(j1.k kVar, t tVar, h hVar, List list) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("\n Id \t Class Name\t %s\t State\t Unique Name\t Tags\t", Build.VERSION.SDK_INT >= 23 ? "Job Id" : "Alarm Id"));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            p pVar = (p) it.next();
            g b10 = hVar.b(pVar.f14583a);
            sb.append(s(pVar, TextUtils.join(",", kVar.b(pVar.f14583a)), b10 != null ? Integer.valueOf(b10.f14563b) : null, TextUtils.join(",", tVar.a(pVar.f14583a))));
        }
        return sb.toString();
    }

    @Override // androidx.work.Worker
    public ListenableWorker.a r() {
        WorkDatabase n10 = j.j(a()).n();
        q B = n10.B();
        j1.k z10 = n10.z();
        t C = n10.C();
        h y10 = n10.y();
        List b10 = B.b(System.currentTimeMillis() - TimeUnit.DAYS.toMillis(1L));
        List p10 = B.p();
        List j10 = B.j(200);
        if (b10 != null && !b10.isEmpty()) {
            k c10 = k.c();
            String str = f3760g;
            c10.d(str, "Recently completed work:\n\n", new Throwable[0]);
            k.c().d(str, t(z10, C, y10, b10), new Throwable[0]);
        }
        if (p10 != null && !p10.isEmpty()) {
            k c11 = k.c();
            String str2 = f3760g;
            c11.d(str2, "Running work:\n\n", new Throwable[0]);
            k.c().d(str2, t(z10, C, y10, p10), new Throwable[0]);
        }
        if (j10 != null && !j10.isEmpty()) {
            k c12 = k.c();
            String str3 = f3760g;
            c12.d(str3, "Enqueued work:\n\n", new Throwable[0]);
            k.c().d(str3, t(z10, C, y10, j10), new Throwable[0]);
        }
        return ListenableWorker.a.c();
    }
}
