package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import android.content.SharedPreferences;
import com.umeng.analytics.pro.bd;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMRTLog;

/* loaded from: classes3.dex */
public class c extends a {

    /* renamed from: a, reason: collision with root package name */
    public static final String f11074a = bd.b().b(bd.f9985l);

    /* renamed from: b, reason: collision with root package name */
    public static final String f11075b = "key_umeng_sp_honor_oaid";

    /* renamed from: c, reason: collision with root package name */
    private static final String f11076c = "honor_oaid";

    /* renamed from: d, reason: collision with root package name */
    private Context f11077d;

    public c(Context context) {
        super(f11076c);
        this.f11077d = context;
    }

    @Override // com.umeng.commonsdk.statistics.idtracking.a
    public String f() {
        if (!UMConfigure.shouldCollectOaid()) {
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>>*** HonorOaidTracker.getId(): oaid开关已关闭。");
            return null;
        }
        if (!FieldManager.allow(com.umeng.commonsdk.utils.d.G)) {
            return null;
        }
        try {
            SharedPreferences sharedPreferences = this.f11077d.getSharedPreferences(f11074a, 0);
            if (sharedPreferences != null) {
                return sharedPreferences.getString(f11075b, "");
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }
}
