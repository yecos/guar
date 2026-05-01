package com.umeng.message.common;

import android.app.Application;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.taobao.accs.common.Constants;
import com.umeng.commonsdk.utils.UMUtils;
import com.umeng.message.MessageSharedPrefs;
import com.umeng.message.MsgConstant;
import com.umeng.message.PushAgent;
import com.umeng.message.common.UPLog;
import com.umeng.message.proguard.b;
import com.umeng.message.proguard.f;
import com.umeng.message.proguard.p;
import com.umeng.message.proguard.q;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class UPLog {
    private static String a(String str) {
        return TextUtils.isEmpty(str) ? "UPush" : "UPush.".concat(String.valueOf(str));
    }

    public static void d(String str, Object... objArr) {
        q.a().d(a(str), a(objArr));
    }

    public static void e(String str, Object... objArr) {
        q.a().e(a(str), a(objArr));
    }

    public static String getStackTrace(Throwable th) {
        return Log.getStackTraceString(th);
    }

    public static void i(String str, Object... objArr) {
        q.a().i(a(str), a(objArr));
    }

    public static boolean isEnable() {
        return q.a().f12148a;
    }

    public static void setEnable(boolean z10) {
        q.a().f12148a = z10;
    }

    public static void upload() {
        q a10 = q.a();
        if (f.f12084b) {
            final p pVar = a10.f12149b;
            if (pVar.f12128b) {
                return;
            }
            final p.b bVar = new p.b();
            b.b(new Runnable() { // from class: com.umeng.message.proguard.p.b.1
                @Override // java.lang.Runnable
                public final void run() {
                    boolean z10;
                    Application a11 = y.a();
                    if (UMUtils.isMainProgress(a11)) {
                        MessageSharedPrefs messageSharedPrefs = MessageSharedPrefs.getInstance(a11);
                        String c10 = messageSharedPrefs.c();
                        if (TextUtils.isEmpty(c10)) {
                            UPLog.d("Log", "init skipped.");
                            return;
                        }
                        String l10 = messageSharedPrefs.l();
                        String e10 = d.e(a11);
                        if (TextUtils.isEmpty(l10) && TextUtils.isEmpty(e10)) {
                            UPLog.d("Log", "id skipped.");
                            return;
                        }
                        if (!messageSharedPrefs.a("l_u_q")) {
                            UPLog.i("Log", "req skipped.");
                            return;
                        }
                        JSONObject a12 = b.a(c10, l10, e10);
                        long j10 = 86400;
                        if (a12 != null) {
                            z10 = a12.optBoolean("enable");
                            j10 = Math.max(60L, a12.optLong(com.umeng.analytics.pro.bt.f10040ba, 86400L));
                        } else {
                            z10 = false;
                        }
                        boolean m10 = messageSharedPrefs.m();
                        messageSharedPrefs.f11344b.a("l_u_e", z10);
                        messageSharedPrefs.a("l_u_q", j10);
                        if (z10) {
                            com.umeng.message.proguard.b.b(new Runnable() { // from class: com.umeng.message.proguard.p.b.1.1
                                @Override // java.lang.Runnable
                                public final void run() {
                                    try {
                                        b bVar2 = b.this;
                                        Application a13 = y.a();
                                        File file = new File(a13.getFilesDir(), ".upush_log");
                                        File file2 = new File(file, new SimpleDateFormat("yyMMddHHmmssSSS", Locale.getDefault()).format(Long.valueOf(System.currentTimeMillis())));
                                        try {
                                            bVar2.a(file, file2);
                                            if (file2.length() < 512) {
                                                UPLog.i("Log", "len small skipped! ", Long.valueOf(file2.length()));
                                                return;
                                            }
                                            if (file2.length() > 1048576) {
                                                UPLog.i("Log", "len large skipped! ", Long.valueOf(file2.length()));
                                                return;
                                            }
                                            String messageAppkey = PushAgent.getInstance(a13).getMessageAppkey();
                                            JSONObject jSONObject = new JSONObject();
                                            jSONObject.put("appkey", messageAppkey);
                                            jSONObject.put("utdid", d.o(a13));
                                            jSONObject.put(com.umeng.analytics.pro.bt.f10046g, d.k(a13));
                                            jSONObject.put("device_token", PushAgent.getInstance(a13).getRegistrationId());
                                            jSONObject.put("md5", UMUtils.getFileMD5(file2));
                                            jSONObject.put("ts", System.currentTimeMillis());
                                            jSONObject.put("app_v", d.b(a13));
                                            jSONObject.put("sdk_v", MsgConstant.SDK_VERSION);
                                            jSONObject.put("os_v", Build.VERSION.RELEASE);
                                            jSONObject.put(Constants.KEY_BRAND, d.f());
                                            jSONObject.put(Constants.KEY_MODEL, d.d());
                                            jSONObject.put("android_id", d.e(a13));
                                            jSONObject.put(com.umeng.analytics.pro.bt.al, UMUtils.getZid(a13));
                                            jSONObject.put("os_i", Build.VERSION.SDK_INT);
                                            g.a(jSONObject, "https://offmsg.umeng.com/log/upload", messageAppkey, file2);
                                        } catch (Throwable th) {
                                            try {
                                                UPLog.i("Log", UPLog.getStackTrace(th));
                                            } finally {
                                                bm.a(file2.getPath());
                                            }
                                        }
                                    } catch (Throwable th2) {
                                        UPLog.i("Log", UPLog.getStackTrace(th2));
                                    }
                                }
                            }, m10 ? 0L : 1L, TimeUnit.MINUTES);
                        } else {
                            UPLog.i("Log", "enable skipped.");
                        }
                        pVar.f12127a = Boolean.valueOf(z10);
                    }
                }
            });
            pVar.f12128b = true;
        }
    }

    public static void w(String str, Object... objArr) {
        q.a().w(a(str), a(objArr));
    }

    public static void e(String str, Throwable th) {
        q.a().e(a(str), getStackTrace(th));
    }

    public static void w(String str, Throwable th) {
        q.a().w(a(str), getStackTrace(th));
    }

    private static String a(Object... objArr) {
        if (objArr == null || objArr.length == 0) {
            return "";
        }
        if (objArr.length == 1) {
            return String.valueOf(objArr[0]);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(objArr[0]);
        for (int i10 = 1; i10 < objArr.length; i10++) {
            Object obj = objArr[i10];
            if (obj != null) {
                sb.append(" ");
                sb.append(obj);
            }
        }
        return sb.toString();
    }
}
