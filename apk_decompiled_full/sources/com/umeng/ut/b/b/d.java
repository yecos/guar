package com.umeng.ut.b.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.taobao.accs.common.Constants;
import java.io.ByteArrayOutputStream;
import java.util.Random;
import java.util.regex.Pattern;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.android.agoo.common.Config;

/* loaded from: classes3.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private static d f12379a;

    /* renamed from: a, reason: collision with other field name */
    private Context f65a;

    /* renamed from: c, reason: collision with root package name */
    private String f12381c = null;

    /* renamed from: d, reason: collision with root package name */
    private long f12382d = -1;

    /* renamed from: b, reason: collision with root package name */
    private static Pattern f12380b = Pattern.compile("[^0-9a-zA-Z=/+]+");

    /* renamed from: a, reason: collision with other field name */
    private static final Object f64a = new Object();

    private d(Context context) {
        this.f65a = context.getApplicationContext();
        com.umeng.ut.a.a.a().a(this.f65a);
    }

    public static d a(Context context) {
        if (context != null && f12379a == null) {
            synchronized (f64a) {
                if (f12379a == null) {
                    f12379a = new d(context);
                }
            }
        }
        return f12379a;
    }

    private boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.endsWith("\n")) {
            str = str.substring(0, str.length() - 1);
        }
        if (24 == str.length()) {
            return !f12380b.matcher(str).find();
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001f, code lost:
    
        if (r0 > 7776000) goto L7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private long c() {
        long j10;
        try {
            j10 = a("um_push_ut").getLong("v_i", 604800L);
        } catch (Throwable unused) {
            j10 = 0;
        }
        long j11 = j10 >= 600 ? 7776000L : 600L;
        j10 = j11;
        return j10 * 1000;
    }

    private void e() {
        try {
            a("um_push_ut").edit().remove("v_r").commit();
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:2|3|(7:8|(2:10|(2:18|(3:22|23|24))(3:14|15|16))|25|26|(5:28|(1:30)|31|32|33)|35|36)|39|(0)|25|26|(0)|35|36) */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0065, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0066, code lost:
    
        r0.printStackTrace();
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0017 A[Catch: all -> 0x006c, TryCatch #1 {, blocks: (B:3:0x0001, B:5:0x0009, B:10:0x0017, B:12:0x0023, B:14:0x002b, B:18:0x002f, B:20:0x003b, B:22:0x0043, B:26:0x004c, B:28:0x0052, B:30:0x005e, B:31:0x0061, B:38:0x0066), top: B:2:0x0001, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0052 A[Catch: Exception -> 0x0065, all -> 0x006c, TryCatch #0 {Exception -> 0x0065, blocks: (B:26:0x004c, B:28:0x0052, B:30:0x005e, B:31:0x0061), top: B:25:0x004c, outer: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private synchronized String j() {
        boolean z10;
        byte[] a10;
        if (!m75c() && com.umeng.ut.a.c.a.a(this.f65a)) {
            z10 = false;
            if (z10) {
                String l10 = l();
                this.f12381c = l10;
                if (!com.umeng.ut.b.a.a.d.isEmpty(l10) && b(this.f12381c)) {
                    return this.f12381c;
                }
                String k10 = k();
                this.f12381c = k10;
                if (!com.umeng.ut.b.a.a.d.isEmpty(k10) && b(this.f12381c)) {
                    a(this.f12381c, false);
                    return this.f12381c;
                }
            }
            a10 = a();
            if (a10 != null) {
                String a11 = com.umeng.ut.b.a.a.a.a(a10, 2);
                this.f12381c = a11;
                a(a11, true);
                if (!z10) {
                    e();
                }
                return this.f12381c;
            }
            return null;
        }
        z10 = true;
        if (z10) {
        }
        a10 = a();
        if (a10 != null) {
        }
        return null;
    }

    private String k() {
        try {
            SharedPreferences a10 = a(Config.PREFERENCES);
            String string = a10.getString("deviceId", null);
            if (string == null || string.length() <= 0) {
                return null;
            }
            String string2 = a10.getString("utdid", null);
            if (string2 != null) {
                try {
                    if (string2.length() == 0) {
                    }
                } catch (Throwable unused) {
                }
                return string2;
            }
            return a(Constants.SP_FILE_NAME).getString("utdid", null);
        } catch (Throwable unused2) {
            return null;
        }
    }

    private String l() {
        try {
            return a("um_push_ut").getString("d_id", null);
        } catch (Throwable unused) {
            return null;
        }
    }

    public boolean d() {
        try {
            return a("um_push_ut").getBoolean("t_f", false);
        } catch (Throwable unused) {
            return false;
        }
    }

    public void f() {
        try {
            a("um_push_ut").edit().remove("t_id").remove("t_f").commit();
        } catch (Throwable unused) {
        }
    }

    public synchronized String getValue() {
        String str = this.f12381c;
        if (str != null) {
            return str;
        }
        return j();
    }

    public String m() {
        String str;
        try {
            str = a("um_push_ut").getString("t_id", null);
        } catch (Throwable unused) {
            str = null;
        }
        if (str != null && !"-1".equals(str) && str.length() >= 2 && str.length() <= 128) {
            return str;
        }
        return null;
    }

    /* renamed from: c, reason: collision with other method in class */
    private boolean m75c() {
        try {
            return a("um_push_ut").getBoolean("v_r", true);
        } catch (Throwable unused) {
            return true;
        }
    }

    private void a(String str, boolean z10) {
        if (b(str)) {
            if (str.endsWith("\n")) {
                str = str.substring(0, str.length() - 1);
            }
            if (str.length() == 24) {
                b(str, z10);
            }
        }
    }

    public boolean b() {
        try {
            SharedPreferences a10 = a("um_push_ut");
            if (this.f12382d == -1) {
                this.f12382d = a10.getLong("v_ts", 0L);
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (Math.abs(currentTimeMillis - this.f12382d) >= c()) {
                this.f12382d = currentTimeMillis;
                a10.edit().putLong("v_ts", currentTimeMillis).commit();
                com.umeng.ut.a.c.e.m72a("UTUtdid", "req valid");
                return true;
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    private byte[] a() {
        String str;
        com.umeng.ut.a.c.e.m72a("UTUtdid", "generate UTDid");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        int nextInt = new Random().nextInt();
        byte[] bytes = com.umeng.ut.b.a.a.b.getBytes(currentTimeMillis);
        byte[] bytes2 = com.umeng.ut.b.a.a.b.getBytes(nextInt);
        byteArrayOutputStream.write(bytes, 0, 4);
        byteArrayOutputStream.write(bytes2, 0, 4);
        byteArrayOutputStream.write(3);
        byteArrayOutputStream.write(0);
        try {
            str = com.umeng.ut.b.a.a.c.f();
        } catch (Exception unused) {
            str = "" + new Random().nextInt();
        }
        byteArrayOutputStream.write(com.umeng.ut.b.a.a.b.getBytes(com.umeng.ut.b.a.a.d.a(str)), 0, 4);
        byteArrayOutputStream.write(com.umeng.ut.b.a.a.b.getBytes(com.umeng.ut.b.a.a.d.a(a(byteArrayOutputStream.toByteArray()))));
        return byteArrayOutputStream.toByteArray();
    }

    private void b(String str, boolean z10) {
        try {
            a("um_push_ut").edit().putString("d_id", str).putBoolean("t_f", z10).commit();
        } catch (Throwable unused) {
        }
    }

    private static String a(byte[] bArr) {
        byte[] bArr2 = {69, 114, 116, -33, 125, -54, -31, 86, -11, 11, -78, -96, -17, -99, SignedBytes.MAX_POWER_OF_TWO, Ascii.ETB, -95, -126, -82, -64, 113, 116, -16, -103, 49, -30, 9, -39, 33, -80, -68, -78, -117, 53, Ascii.RS, -122, SignedBytes.MAX_POWER_OF_TWO, -104, 74, -49, 106, 85, -38, -93};
        Mac mac = Mac.getInstance("HmacSHA1");
        mac.init(new SecretKeySpec(com.umeng.ut.a.c.d.b(bArr2), mac.getAlgorithm()));
        return com.umeng.ut.b.a.a.a.a(mac.doFinal(bArr), 2);
    }

    public void a(String str, long j10) {
        boolean z10;
        try {
            SharedPreferences.Editor edit = a("um_push_ut").edit();
            boolean z11 = true;
            if (j10 > 0) {
                edit.putLong("v_i", j10);
                edit.putLong("v_ts", System.currentTimeMillis());
                z10 = true;
            } else {
                z10 = false;
            }
            if (str == null || "-1".equals(str) || str.length() < 2 || str.length() > 128) {
                z11 = z10;
            } else {
                edit.putString("t_id", str);
                edit.putBoolean("v_r", false);
            }
            if (z11) {
                edit.commit();
            }
        } catch (Throwable unused) {
        }
    }

    private SharedPreferences a(String str) {
        return this.f65a.getSharedPreferences(str, 0);
    }
}
