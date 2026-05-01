package com.umeng.analytics.pro;

import android.content.Context;
import org.repackage.com.zui.opendeviceidlibrary.OpenDeviceId;

/* loaded from: classes3.dex */
public class bk implements be {

    /* renamed from: a, reason: collision with root package name */
    private static final int f10024a = 1;

    /* renamed from: b, reason: collision with root package name */
    private OpenDeviceId f10025b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f10026c = false;

    /* renamed from: d, reason: collision with root package name */
    private boolean f10027d = false;

    @Override // com.umeng.analytics.pro.be
    public String a(Context context) {
        if (context == null) {
            return null;
        }
        if (!this.f10026c) {
            OpenDeviceId openDeviceId = new OpenDeviceId();
            this.f10025b = openDeviceId;
            this.f10027d = openDeviceId.a(context, (OpenDeviceId.CallBack<String>) null) == 1;
            this.f10026c = true;
        }
        bs.a("getOAID", "isSupported", Boolean.valueOf(this.f10027d));
        if (this.f10027d && this.f10025b.c()) {
            return this.f10025b.a();
        }
        return null;
    }
}
