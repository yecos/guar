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
    */
    public final String a(int i10, String str) {
        Cursor cursor;
        Cursor cursor2 = null;
        try {
            try {
                cursor = this.f11343a.getContentResolver().query(h.a(this.f11343a), new String[]{"alias"}, "type=? and exclusive=?", new String[]{str, String.valueOf(i10)}, "time desc");
                if (cursor != null) {
                    try {
                        if (cursor.getCount() > 0) {
                            cursor.moveToFirst();
                            String string = cursor.getString(cursor.getColumnIndex("alias"));
                            try {
                                cursor.close();
                            } catch (Throwable th) {
                                UPLog.e("Prefs", th);
                            }
                            return string;
                        }
                    } catch (Exception e10) {
                        e = e10;
                        UPLog.e("Prefs", e);
                        if (cursor != null) {
                            try {
                                cursor.close();
                            } catch (Throwable th2) {
                                UPLog.e("Prefs", th2);
                            }
                        }
                        return null;
                    }
                }
                if (cursor != null) {
                    try {
                        cursor.close();
                    } catch (Throwable th3) {
                        UPLog.e("Prefs", th3);
                    }
                }
                return null;
            } catch (Throwable th4) {
                th = th4;
                cursor2 = i10;
                if (cursor2 != null) {
                    try {
                        cursor2.close();
                    } catch (Throwable th5) {
                        UPLog.e("Prefs", th5);
                    }
                }
                throw th;
            }
        } catch (Exception e11) {
            e = e11;
            cursor = null;
        } catch (Throwable th6) {
            th = th6;
            if (cursor2 != null) {
            }
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x011e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:60:? A[SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:63:0x0115 -> B:33:0x0119). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean a(int i10, String str, String str2) {
        Throwable th;
        Cursor cursor;
        Cursor query;
        int count;
        try {
            try {
                String[] strArr = {str2, str, String.valueOf(i10)};
                UPLog.i("Prefs", "type", str2, "alias", str, "exclusive", Integer.valueOf(i10));
                query = this.f11343a.getContentResolver().query(h.a(this.f11343a), null, "type=? and alias=? and exclusive=?", strArr, null);
            } catch (Throwable th2) {
                UPLog.e("Prefs", th2);
            }
        } catch (Exception e10) {
            e = e10;
            cursor = null;
        } catch (Throwable th3) {
            th = th3;
            cursor = null;
        }
        if (query == null) {
            if (query != null) {
                try {
                    query.close();
                } catch (Throwable th4) {
                    UPLog.e("Prefs", th4);
                }
            }
            return false;
        }
        try {
            count = query.getCount();
            UPLog.i("Prefs", "count", Integer.valueOf(count));
        } catch (Exception e11) {
            e = e11;
            cursor = query;
            try {
                UPLog.e("Prefs", e);
                if (cursor != null) {
                    cursor.close();
                }
                return false;
            } catch (Throwable th5) {
                th = th5;
                if (cursor == null) {
                    try {
                        cursor.close();
                        throw th;
                    } catch (Throwable th6) {
                        UPLog.e("Prefs", th6);
                        throw th;
                    }
                }
                throw th;
            }
        } catch (Throwable th7) {
            th = th7;
            cursor = query;
            if (cursor == null) {
            }
        }
        if (count <= 0) {
            try {
                query.close();
            } catch (Throwable th8) {
                UPLog.e("Prefs", th8);
            }
            return false;
        }
        query.moveToFirst();
        String string = query.getString(query.getColumnIndex("type"));
        String string2 = query.getString(query.getColumnIndex("alias"));
        long j10 = query.getLong(query.getColumnIndex("ttl"));
        boolean z10 = Math.abs(System.currentTimeMillis() - query.getLong(query.getColumnIndex(AgooConstants.MESSAGE_TIME))) < 1000 * j10;
        UPLog.i("Prefs", "type", string, "alias", string2, "alive", Boolean.valueOf(z10), "ttl", Long.valueOf(j10));
        if (z10 && TextUtils.equals(string, str2)) {
            if (TextUtils.equals(str, string2)) {
                try {
                    query.close();
                } catch (Throwable th9) {
                    UPLog.e("Prefs", th9);
                }
                return true;
            }
        }
        query.close();
        return false;
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
