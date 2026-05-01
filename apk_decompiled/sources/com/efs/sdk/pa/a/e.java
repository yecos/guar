package com.efs.sdk.pa.a;

import android.os.SystemClock;
import android.util.Printer;
import com.raizlabs.android.dbflow.sql.language.Operator;
import java.util.Iterator;
import java.util.Vector;

/* loaded from: classes.dex */
final class e implements Printer {

    /* renamed from: f, reason: collision with root package name */
    private long f6481f;

    /* renamed from: b, reason: collision with root package name */
    private boolean f6477b = false;

    /* renamed from: c, reason: collision with root package name */
    private String f6478c = null;

    /* renamed from: d, reason: collision with root package name */
    private long f6479d = -1;

    /* renamed from: e, reason: collision with root package name */
    private long f6480e = -1;

    /* renamed from: a, reason: collision with root package name */
    Vector<d> f6476a = new Vector<>();

    @Override // android.util.Printer
    public final void println(String str) {
        if (str.startsWith(Operator.Operation.GREATER_THAN)) {
            this.f6479d = SystemClock.elapsedRealtime();
            this.f6480e = SystemClock.currentThreadTimeMillis();
            this.f6478c = str;
            this.f6477b = true;
            Iterator<d> it = this.f6476a.iterator();
            while (it.hasNext()) {
                it.next();
            }
            return;
        }
        if (this.f6477b && str.startsWith(Operator.Operation.LESS_THAN)) {
            this.f6477b = false;
            long elapsedRealtime = SystemClock.elapsedRealtime() - this.f6479d;
            if (elapsedRealtime > this.f6481f) {
                long currentThreadTimeMillis = SystemClock.currentThreadTimeMillis() - this.f6480e;
                Iterator<d> it2 = this.f6476a.iterator();
                while (it2.hasNext()) {
                    it2.next().a(this.f6478c, elapsedRealtime, currentThreadTimeMillis);
                }
            }
        }
    }
}
