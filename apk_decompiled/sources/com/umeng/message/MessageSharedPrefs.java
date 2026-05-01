package com.umeng.message;

import android.app.Application;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import com.umeng.analytics.pro.bt;
import com.umeng.message.common.UPLog;
import com.umeng.message.proguard.bd;
import com.umeng.message.proguard.f;
import com.umeng.message.proguard.h;
import com.umeng.message.proguard.y;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import org.android.agoo.common.AgooConstants;

/* loaded from: classes3.dex */
public class MessageSharedPrefs {

    /* renamed from: d, reason: collision with root package name */
    private static volatile MessageSharedPrefs f11342d;

    /* renamed from: a, reason: collision with root package name */
    public final Context f11343a;

    /* renamed from: b, reason: collision with root package name */
    public final bd f11344b = new bd("push");

    /* renamed from: c, reason: collision with root package name */
    public Boolean f11345c = null;

    private MessageSharedPrefs(Context context) {
        this.f11343a = context.getApplicationContext();
    }

    public static MessageSharedPrefs getInstance(Context context) {
        if (f11342d == null) {
            synchronized (MessageSharedPrefs.class) {
                if (f11342d == null) {
                    f11342d = new MessageSharedPrefs(context);
                }
            }
        }
        return f11342d;
    }

    private void setMessageAppKey(String str) {
        if (f.b(this.f11343a)) {
            if (TextUtils.isEmpty(str)) {
                UPLog.e("Prefs", "appkey is empty!");
            } else {
                this.f11344b.a("appkey", str);
            }
        }
    }

    private void setMessageAppSecret(String str) {
        if (f.b(this.f11343a)) {
            if (TextUtils.isEmpty(str)) {
                UPLog.e("Prefs", "message secret is empty!");
            } else {
                this.f11344b.a("message_secret", str);
            }
        }
    }

    private void setMessageChannel(String str) {
        if (f.b(this.f11343a)) {
            this.f11344b.a("channel", str);
        }
    }

    public final boolean a() {
        Throwable th;
        long j10;
        try {
            j10 = this.f11344b.b(com.umeng.analytics.pro.f.f10334p, 0L);
            if (j10 > 0) {
                try {
                    UPLog.i("Prefs", "today first start:", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date(j10)));
                } catch (Throwable th2) {
                    th = th2;
                    UPLog.e("Prefs", th);
                    return f.a(j10);
                }
            }
        } catch (Throwable th3) {
            th = th3;
            j10 = 0;
        }
        return f.a(j10);
    }

    public final int b() {
        return this.f11344b.b("notification_number", 5);
    }

    public final String c() {
        return this.f11344b.b("appkey", "");
    }

    public final int d() {
        return this.f11344b.b("tag_remain", 64);
    }

    public final String e() {
        String b10 = this.f11344b.b("service_class", "");
        if (!TextUtils.isEmpty(b10)) {
            try {
                Class.forName(b10);
                return b10;
            } catch (Throwable unused) {
                UPLog.e("Prefs", "custom service not exist:", b10, "if has removed. pls invoke PushAgent.setPushIntentServiceClass(null)");
            }
        }
        return "";
    }

    public final String f() {
        return this.f11344b.b("last_click_msg_id", "");
    }

    public final int g() {
        return this.f11344b.b("mute_duration", 60);
    }

    public final String h() {
        return this.f11344b.b("res_pkg", "");
    }

    public final int i() {
        return this.f11344b.b("notification_vibrate", 0);
    }

    public final int j() {
        return this.f11344b.b("notification_light", 0);
    }

    public final int k() {
        return this.f11344b.b("notification_sound", 0);
    }

    public final String l() {
        return this.f11344b.b("device_token", "");
    }

    public final boolean m() {
        return this.f11344b.b("l_u_e", false);
    }

    public final long n() {
        return this.f11344b.b("smart_lc", 0L);
    }

    public final int o() {
        return this.f11344b.b("re_pop_cfg", 0);
    }

    public final int p() {
        Calendar calendar = Calendar.getInstance();
        String format = String.format(Locale.getDefault(), "%d.%d.", Integer.valueOf(calendar.get(1)), Integer.valueOf(calendar.get(6)));
        String b10 = this.f11344b.b("re_pop_times", "");
        if (b10.startsWith(format)) {
            try {
                return Integer.parseInt(b10.replace(format, ""));
            } catch (Throwable unused) {
            }
        }
        return 0;
    }

    public final long q() {
        return this.f11344b.b("ia_last", 0L);
    }

    public final long r() {
        return Math.max(0L, this.f11344b.b("ia_ttl", 0L));
    }

    public final int s() {
        Calendar calendar = Calendar.getInstance();
        String format = String.format(Locale.getDefault(), "%d.%d.", Integer.valueOf(calendar.get(1)), Integer.valueOf(calendar.get(6)));
        String b10 = this.f11344b.b("ia_times", "");
        if (b10.startsWith(format)) {
            try {
                return Integer.parseInt(b10.replace(format, ""));
            } catch (Throwable unused) {
            }
        }
        return 0;
    }

    public final void b(String str) {
        this.f11344b.a(str + bt.f10040ba);
        this.f11344b.a(str + "ts");
    }

    public final void c(String str) {
        this.f11344b.a("last_click_msg_id", str);
    }

    public final void b(long j10) {
        this.f11344b.a("ia_ttl", j10);
    }

    public final void a(String str, String str2, int i10, long j10) {
        Cursor cursor = null;
        try {
            Application a10 = y.a();
            try {
                this.f11343a.getContentResolver().delete(h.a(this.f11343a), "type=?", new String[]{str2});
            } catch (Exception e10) {
                UPLog.e("Prefs", e10);
            }
            String[] strArr = {str, str2, String.valueOf(i10)};
            cursor = a10.getContentResolver().query(h.a(a10), null, "alias=? and type=? and exclusive=?", strArr, "time desc");
            ContentValues contentValues = new ContentValues();
            contentValues.put(AgooConstants.MESSAGE_TIME, Long.valueOf(System.currentTimeMillis()));
            contentValues.put("ttl", Long.valueOf(j10));
            contentValues.put("type", str2);
            contentValues.put("alias", str);
            contentValues.put("exclusive", Integer.valueOf(i10));
            if (cursor != null && cursor.getCount() > 0) {
                this.f11343a.getContentResolver().update(h.a(a10), contentValues, "alias=? and type=? and exclusive=?", strArr);
            } else {
                this.f11343a.getContentResolver().insert(h.a(a10), contentValues);
            }
        } catch (Exception e11) {
            UPLog.e("Prefs", e11);
        }
        if (cursor != null) {
            try {
                cursor.close();
            } catch (Throwable th) {
                UPLog.e("Prefs", th);
            }
        }
    }

    public final void b(int i10) {
        this.f11344b.a("ia_count", i10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:39:0x006b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String a(int r10, java.lang.String r11) {
        /*
            r9 = this;
            java.lang.String r0 = "alias"
            java.lang.String r1 = "Prefs"
            r2 = 0
            java.lang.String r6 = "type=? and exclusive=?"
            r3 = 2
            java.lang.String[] r7 = new java.lang.String[r3]     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L57
            r3 = 0
            r7[r3] = r11     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L57
            java.lang.String r10 = java.lang.String.valueOf(r10)     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L57
            r11 = 1
            r7[r11] = r10     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L57
            java.lang.String r8 = "time desc"
            android.content.Context r10 = r9.f11343a     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L57
            android.content.ContentResolver r10 = r10.getContentResolver()     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L57
            android.content.Context r4 = r9.f11343a     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L57
            android.net.Uri r4 = com.umeng.message.proguard.h.a(r4)     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L57
            java.lang.String[] r5 = new java.lang.String[r11]     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L57
            r5[r3] = r0     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L57
            r3 = r10
            android.database.Cursor r10 = r3.query(r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L57
            if (r10 == 0) goto L4a
            int r11 = r10.getCount()     // Catch: java.lang.Exception -> L48 java.lang.Throwable -> L67
            if (r11 > 0) goto L34
            goto L4a
        L34:
            r10.moveToFirst()     // Catch: java.lang.Exception -> L48 java.lang.Throwable -> L67
            int r11 = r10.getColumnIndex(r0)     // Catch: java.lang.Exception -> L48 java.lang.Throwable -> L67
            java.lang.String r11 = r10.getString(r11)     // Catch: java.lang.Exception -> L48 java.lang.Throwable -> L67
            r10.close()     // Catch: java.lang.Throwable -> L43
            goto L47
        L43:
            r10 = move-exception
            com.umeng.message.common.UPLog.e(r1, r10)
        L47:
            return r11
        L48:
            r11 = move-exception
            goto L59
        L4a:
            if (r10 == 0) goto L54
            r10.close()     // Catch: java.lang.Throwable -> L50
            goto L54
        L50:
            r10 = move-exception
            com.umeng.message.common.UPLog.e(r1, r10)
        L54:
            return r2
        L55:
            r11 = move-exception
            goto L69
        L57:
            r11 = move-exception
            r10 = r2
        L59:
            com.umeng.message.common.UPLog.e(r1, r11)     // Catch: java.lang.Throwable -> L67
            if (r10 == 0) goto L66
            r10.close()     // Catch: java.lang.Throwable -> L62
            goto L66
        L62:
            r10 = move-exception
            com.umeng.message.common.UPLog.e(r1, r10)
        L66:
            return r2
        L67:
            r11 = move-exception
            r2 = r10
        L69:
            if (r2 == 0) goto L73
            r2.close()     // Catch: java.lang.Throwable -> L6f
            goto L73
        L6f:
            r10 = move-exception
            com.umeng.message.common.UPLog.e(r1, r10)
        L73:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.message.MessageSharedPrefs.a(int, java.lang.String):java.lang.String");
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x011e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:60:? A[SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:63:0x0115 -> B:33:0x0119). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean a(int r25, java.lang.String r26, java.lang.String r27) {
        /*
            Method dump skipped, instructions count: 296
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.message.MessageSharedPrefs.a(int, java.lang.String, java.lang.String):boolean");
    }

    public final void a(String... strArr) {
        if (strArr == null || strArr.length == 0) {
            return;
        }
        Set<String> b10 = this.f11344b.b("tags", new HashSet());
        b10.addAll(Arrays.asList(strArr));
        this.f11344b.a("tags", b10);
    }

    public final void a(long j10) {
        a("smart_", j10);
    }

    public final void a(String str, long j10) {
        this.f11344b.a(str + bt.f10040ba, j10);
        this.f11344b.a(str + "ts", System.currentTimeMillis());
    }

    public final boolean a(String str) {
        long b10 = this.f11344b.b(str + bt.f10040ba, 0L);
        if (b10 <= 0) {
            return true;
        }
        bd bdVar = this.f11344b;
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("ts");
        return Math.abs(System.currentTimeMillis() - bdVar.b(sb.toString(), 0L)) / 1000 >= b10;
    }

    public final void a(int i10) {
        this.f11344b.a("tag_remain", i10);
    }
}
