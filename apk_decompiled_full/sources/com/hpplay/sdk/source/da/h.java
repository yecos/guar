package com.hpplay.sdk.source.da;

import android.content.Context;
import com.hpplay.sdk.source.bean.OutParameter;
import com.hpplay.sdk.source.da.a.a;
import com.hpplay.sdk.source.log.SourceLog;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    private static final String f7663a = "DaReportProcessor";

    /* renamed from: b, reason: collision with root package name */
    private static h f7664b;

    public static synchronized h a() {
        h hVar;
        synchronized (h.class) {
            if (f7664b == null) {
                f7664b = new h();
            }
            hVar = f7664b;
        }
        return hVar;
    }

    public static void b() {
        f7664b = null;
    }

    public void a(Context context, OutParameter outParameter) {
        if (outParameter == null) {
            return;
        }
        a.C0129a a10 = f.a().a(outParameter.session);
        if (a10 == null) {
            SourceLog.i(f7663a, "onDaStart ignore , daData is null");
            return;
        }
        g.a().b(outParameter, a10.f7613c, String.valueOf(1), a10.f7614d, true, "");
        List<String> list = a10.f7615e;
        if (list != null) {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                g.a().a(context, it.next(), false, 0, a10.f7611a);
            }
        }
    }

    public void a(Context context, OutParameter outParameter, long j10) {
        if (outParameter == null) {
            return;
        }
        a.C0129a a10 = f.a().a(outParameter.session);
        if (a10 == null) {
            SourceLog.i(f7663a, "onDaEnd ignore , daData is null");
            return;
        }
        g.a().c(outParameter, a10.f7613c, String.valueOf(1), a10.f7614d, true, "");
        int i10 = ((int) j10) * 1000;
        if (i10 <= 0) {
            SourceLog.i(f7663a, "onDaEnd ignore , duration: " + i10);
            return;
        }
        List<String> list = a10.f7616f;
        if (list != null) {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                g.a().a(context, it.next(), true, i10, a10.f7611a);
            }
        }
    }
}
