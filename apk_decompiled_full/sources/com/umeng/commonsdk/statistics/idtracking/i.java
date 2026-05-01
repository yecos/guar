package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import android.content.SharedPreferences;
import com.umeng.analytics.pro.bd;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMRTLog;

/* loaded from: classes3.dex */
public class i extends a {

    /* renamed from: a, reason: collision with root package name */
    public static final String f11098a = bd.b().b(bd.f9985l);

    /* renamed from: b, reason: collision with root package name */
    public static final String f11099b = "key_umeng_sp_oaid";

    /* renamed from: c, reason: collision with root package name */
    public static final String f11100c = "key_umeng_sp_oaid_required_time";

    /* renamed from: d, reason: collision with root package name */
    private static final String f11101d = "oaid";

    /* renamed from: e, reason: collision with root package name */
    private Context f11102e;

    public i(Context context) {
        super(f11101d);
        this.f11102e = context;
    }

    @Override // com.umeng.commonsdk.statistics.idtracking.a
    public String f() {
        if (!UMConfigure.shouldCollectOaid()) {
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>>*** OaidTracking.getId(): oaid开关已关闭。");
            return null;
        }
        if (!FieldManager.allow(com.umeng.commonsdk.utils.d.G)) {
            return null;
        }
        try {
            SharedPreferences sharedPreferences = this.f11102e.getSharedPreferences(f11098a, 0);
            if (sharedPreferences != null) {
                return sharedPreferences.getString(f11099b, "");
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }
}
