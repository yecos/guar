package com.efs.sdk.net;

import android.content.Context;
import com.efs.sdk.base.EfsReporter;
import java.util.Random;

/* loaded from: classes.dex */
public class NetConfigManager {

    /* renamed from: c, reason: collision with root package name */
    private EfsReporter f6333c;

    /* renamed from: d, reason: collision with root package name */
    private int f6334d;

    /* renamed from: e, reason: collision with root package name */
    private int f6335e;

    /* renamed from: f, reason: collision with root package name */
    private int f6336f;

    /* renamed from: g, reason: collision with root package name */
    private int f6337g;

    /* renamed from: h, reason: collision with root package name */
    private int f6338h;

    /* renamed from: i, reason: collision with root package name */
    private int f6339i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f6340j;

    /* renamed from: k, reason: collision with root package name */
    private Context f6341k;

    /* renamed from: l, reason: collision with root package name */
    private int f6342l;

    /* renamed from: a, reason: collision with root package name */
    private final String f6331a = "NetConfigManager";

    /* renamed from: b, reason: collision with root package name */
    private final int f6332b = 0;

    /* renamed from: m, reason: collision with root package name */
    private boolean f6343m = false;

    /* JADX WARN: Removed duplicated region for block: B:15:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x018d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public NetConfigManager(android.content.Context r20, com.efs.sdk.base.EfsReporter r21) {
        /*
            Method dump skipped, instructions count: 420
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.efs.sdk.net.NetConfigManager.<init>(android.content.Context, com.efs.sdk.base.EfsReporter):void");
    }

    public boolean enableTracer() {
        return this.f6340j;
    }

    public int getDataRate() {
        return this.f6339i;
    }

    public int getDayLimit() {
        return this.f6338h;
    }

    public int getExtraRateFlag() {
        return this.f6342l;
    }

    public boolean getNetRequestBodyCollectState() {
        return this.f6343m;
    }

    public void setNetRequestBodyCollectState(boolean z10) {
        this.f6343m = z10;
    }

    private static boolean a(int i10) {
        if (i10 == 0) {
            return false;
        }
        return i10 == 100 || new Random().nextInt(100) <= i10;
    }
}
