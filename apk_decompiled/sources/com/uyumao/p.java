package com.uyumao;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

/* loaded from: classes3.dex */
public class p {

    /* renamed from: a, reason: collision with root package name */
    public final String f12434a;

    /* renamed from: b, reason: collision with root package name */
    public final String f12435b;

    /* renamed from: c, reason: collision with root package name */
    public final String f12436c;

    /* renamed from: d, reason: collision with root package name */
    public final long f12437d;

    /* renamed from: e, reason: collision with root package name */
    public final long f12438e;

    /* renamed from: f, reason: collision with root package name */
    public final int f12439f;

    public p(Object obj, Object obj2) {
        String str;
        PackageManager packageManager = (PackageManager) obj;
        PackageInfo packageInfo = (PackageInfo) obj2;
        this.f12434a = packageInfo.packageName;
        this.f12436c = packageInfo.versionName;
        this.f12437d = packageInfo.firstInstallTime;
        this.f12438e = packageInfo.lastUpdateTime;
        this.f12439f = a(packageInfo);
        try {
            str = String.valueOf(packageManager.getApplicationLabel(packageInfo.applicationInfo));
        } catch (Throwable unused) {
            str = "";
        }
        this.f12435b = str;
    }

    public final int a(PackageInfo packageInfo) {
        ApplicationInfo applicationInfo = packageInfo.applicationInfo;
        if (applicationInfo == null) {
            return -1;
        }
        int i10 = applicationInfo.flags;
        return ((i10 & 1) == 0 && (i10 & 128) == 0) ? 1 : 0;
    }
}
