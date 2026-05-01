package com.umeng.message.proguard;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

/* loaded from: classes3.dex */
final class l {

    /* renamed from: a, reason: collision with root package name */
    final String f12108a;

    /* renamed from: b, reason: collision with root package name */
    final String f12109b;

    /* renamed from: c, reason: collision with root package name */
    final String f12110c;

    /* renamed from: d, reason: collision with root package name */
    final long f12111d;

    /* renamed from: e, reason: collision with root package name */
    final int f12112e;

    public l(Object obj, Object obj2) {
        int i10;
        String str;
        PackageManager packageManager = (PackageManager) obj;
        PackageInfo packageInfo = (PackageInfo) obj2;
        this.f12108a = packageInfo.packageName;
        this.f12110c = packageInfo.versionName;
        this.f12111d = packageInfo.lastUpdateTime;
        ApplicationInfo applicationInfo = packageInfo.applicationInfo;
        if (applicationInfo == null) {
            i10 = -1;
        } else {
            int i11 = applicationInfo.flags;
            i10 = ((i11 & 1) == 0 && (i11 & 128) == 0) ? 1 : 0;
        }
        this.f12112e = i10;
        try {
            str = String.valueOf(packageManager.getApplicationLabel(applicationInfo));
        } catch (Throwable unused) {
            str = "";
        }
        this.f12109b = str;
    }
}
