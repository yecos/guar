package com.umeng.message.proguard;

import android.util.Log;
import anet.channel.util.ALog;
import com.taobao.accs.utl.ALog;

/* loaded from: classes3.dex */
public final class q implements ALog.ILog, ALog.ILog {

    /* renamed from: c, reason: collision with root package name */
    private static final q f12147c = new q();

    /* renamed from: a, reason: collision with root package name */
    public boolean f12148a = false;

    /* renamed from: d, reason: collision with root package name */
    private final boolean f12150d = "1".equals(d.k());

    /* renamed from: b, reason: collision with root package name */
    public final p f12149b = new p();

    private q() {
    }

    public static q a() {
        return f12147c;
    }

    private static void b(int i10, String str, String str2) {
        switch (i10) {
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
                Log.println(i10, str, str2);
                break;
        }
    }

    @Override // anet.channel.util.ALog.ILog
    public final void d(String str, String str2) {
        if (this.f12148a) {
            a(3, str, str2);
        }
    }

    @Override // anet.channel.util.ALog.ILog
    public final void e(String str, String str2) {
        if (this.f12150d || this.f12148a) {
            a(6, str, str2);
        }
        if (this.f12149b.a()) {
            this.f12149b.a(6, str, str2);
        }
    }

    @Override // anet.channel.util.ALog.ILog
    public final void i(String str, String str2) {
        if (this.f12150d || this.f12148a) {
            a(4, str, str2);
        }
        if (this.f12149b.a()) {
            this.f12149b.a(4, str, str2);
        }
    }

    @Override // anet.channel.util.ALog.ILog
    public final boolean isPrintLog(int i10) {
        return true;
    }

    @Override // anet.channel.util.ALog.ILog
    public final boolean isValid() {
        return true;
    }

    @Override // anet.channel.util.ALog.ILog
    public final void setLogLevel(int i10) {
    }

    @Override // anet.channel.util.ALog.ILog
    public final void w(String str, String str2) {
        if (this.f12150d || this.f12148a) {
            a(5, str, str2);
        }
        if (this.f12149b.a()) {
            this.f12149b.a(5, str, str2);
        }
    }

    private static void a(int i10, String str, String str2) {
        if (str2 == null) {
            return;
        }
        while (str2.length() > 3072) {
            b(i10, str, str2.substring(0, 3072));
            str2 = str2.substring(3072);
        }
        if (str2.length() > 0) {
            b(i10, str, str2);
        }
    }

    @Override // anet.channel.util.ALog.ILog
    public final void e(String str, String str2, Throwable th) {
        if (this.f12150d || this.f12148a) {
            a(6, str, str2 + "\n" + Log.getStackTraceString(th));
        }
        if (this.f12149b.a()) {
            this.f12149b.a(6, str, str2 + "\n" + Log.getStackTraceString(th));
        }
    }

    @Override // anet.channel.util.ALog.ILog
    public final void w(String str, String str2, Throwable th) {
        if (this.f12150d || this.f12148a) {
            a(5, str, str2 + "\n" + Log.getStackTraceString(th));
        }
        if (this.f12149b.a()) {
            this.f12149b.a(5, str, str2 + "\n" + Log.getStackTraceString(th));
        }
    }
}
