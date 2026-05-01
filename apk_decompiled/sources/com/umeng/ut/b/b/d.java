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
        To view partially-correct add '--show-bad-code' argument
    */
    private long c() {
        /*
            r5 = this;
            java.lang.String r0 = "um_push_ut"
            android.content.SharedPreferences r0 = r5.a(r0)     // Catch: java.lang.Throwable -> L10
            java.lang.String r1 = "v_i"
            r2 = 604800(0x93a80, double:2.98811E-318)
            long r0 = r0.getLong(r1, r2)     // Catch: java.lang.Throwable -> L10
            goto L12
        L10:
            r0 = 0
        L12:
            r2 = 600(0x258, double:2.964E-321)
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 >= 0) goto L1a
        L18:
            r0 = r2
            goto L22
        L1a:
            r2 = 7776000(0x76a700, double:3.8418545E-317)
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 <= 0) goto L22
            goto L18
        L22:
            r2 = 1000(0x3e8, double:4.94E-321)
            long r0 = r0 * r2
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.ut.b.b.d.c():long");
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
        To view partially-correct add '--show-bad-code' argument
    */
    private synchronized java.lang.String j() {
        /*
            r4 = this;
            monitor-enter(r4)
            boolean r0 = r4.m75c()     // Catch: java.lang.Throwable -> L6c
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L14
            android.content.Context r0 = r4.f65a     // Catch: java.lang.Throwable -> L6c
            boolean r0 = com.umeng.ut.a.c.a.a(r0)     // Catch: java.lang.Throwable -> L6c
            if (r0 != 0) goto L12
            goto L14
        L12:
            r0 = 0
            goto L15
        L14:
            r0 = 1
        L15:
            if (r0 == 0) goto L4c
            java.lang.String r3 = r4.l()     // Catch: java.lang.Throwable -> L6c
            r4.f12381c = r3     // Catch: java.lang.Throwable -> L6c
            boolean r3 = com.umeng.ut.b.a.a.d.isEmpty(r3)     // Catch: java.lang.Throwable -> L6c
            if (r3 != 0) goto L2f
            java.lang.String r3 = r4.f12381c     // Catch: java.lang.Throwable -> L6c
            boolean r3 = r4.b(r3)     // Catch: java.lang.Throwable -> L6c
            if (r3 == 0) goto L2f
            java.lang.String r0 = r4.f12381c     // Catch: java.lang.Throwable -> L6c
            monitor-exit(r4)
            return r0
        L2f:
            java.lang.String r3 = r4.k()     // Catch: java.lang.Throwable -> L6c
            r4.f12381c = r3     // Catch: java.lang.Throwable -> L6c
            boolean r3 = com.umeng.ut.b.a.a.d.isEmpty(r3)     // Catch: java.lang.Throwable -> L6c
            if (r3 != 0) goto L4c
            java.lang.String r3 = r4.f12381c     // Catch: java.lang.Throwable -> L6c
            boolean r3 = r4.b(r3)     // Catch: java.lang.Throwable -> L6c
            if (r3 == 0) goto L4c
            java.lang.String r0 = r4.f12381c     // Catch: java.lang.Throwable -> L6c
            r4.a(r0, r1)     // Catch: java.lang.Throwable -> L6c
            java.lang.String r0 = r4.f12381c     // Catch: java.lang.Throwable -> L6c
            monitor-exit(r4)
            return r0
        L4c:
            byte[] r1 = r4.a()     // Catch: java.lang.Exception -> L65 java.lang.Throwable -> L6c
            if (r1 == 0) goto L69
            r3 = 2
            java.lang.String r1 = com.umeng.ut.b.a.a.a.a(r1, r3)     // Catch: java.lang.Exception -> L65 java.lang.Throwable -> L6c
            r4.f12381c = r1     // Catch: java.lang.Exception -> L65 java.lang.Throwable -> L6c
            r4.a(r1, r2)     // Catch: java.lang.Exception -> L65 java.lang.Throwable -> L6c
            if (r0 != 0) goto L61
            r4.e()     // Catch: java.lang.Exception -> L65 java.lang.Throwable -> L6c
        L61:
            java.lang.String r0 = r4.f12381c     // Catch: java.lang.Exception -> L65 java.lang.Throwable -> L6c
            monitor-exit(r4)
            return r0
        L65:
            r0 = move-exception
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L6c
        L69:
            monitor-exit(r4)
            r0 = 0
            return r0
        L6c:
            r0 = move-exception
            monitor-exit(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.ut.b.b.d.j():java.lang.String");
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
