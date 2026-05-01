package com.mobile.brasiltv.utils;

import android.content.Context;
import android.content.Intent;
import android.os.Process;

/* loaded from: classes3.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final d f8644a = new d();

    public final void a(Context context) {
        t9.i.g(context, com.umeng.analytics.pro.f.X);
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());
        if (launchIntentForPackage == null) {
            return;
        }
        context.startActivity(Intent.makeRestartActivityTask(launchIntentForPackage.getComponent()));
        try {
            a.b().e();
            System.exit(0);
            throw new RuntimeException("System.exit returned normally, while it was supposed to halt JVM.");
        } catch (Exception unused) {
        } finally {
            Process.killProcess(Process.myPid());
        }
    }
}
