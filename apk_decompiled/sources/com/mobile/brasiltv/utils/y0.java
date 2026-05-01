package com.mobile.brasiltv.utils;

import android.app.ActivityManager;
import android.app.RecoverableSecurityException;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.provider.MediaStore;
import android.provider.Settings;
import android.text.TextUtils;
import android.text.format.Formatter;
import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import com.hpplay.cybergarage.soap.SOAP;
import com.hpplay.sdk.source.common.store.Session;
import com.umeng.analytics.pro.bx;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import org.android.agoo.common.AgooConstants;
import w6.i;

/* loaded from: classes3.dex */
public final class y0 {

    /* renamed from: a, reason: collision with root package name */
    public static final y0 f8789a = new y0();

    /* renamed from: b, reason: collision with root package name */
    public static final String f8790b = "nsecived";

    public static final class a extends t9.j implements s9.l {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f8791a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Context context) {
            super(1);
            this.f8791a = context;
        }

        @Override // s9.l
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final String invoke(String str) {
            t9.i.g(str, "it");
            if (Build.VERSION.SDK_INT <= 29) {
                y0 y0Var = y0.f8789a;
                y0Var.S();
                y0Var.T(this.f8791a);
            } else {
                y0 y0Var2 = y0.f8789a;
                y0Var2.R(this.f8791a);
                y0Var2.T(this.f8791a);
            }
            return str;
        }
    }

    public static final class b extends t9.j implements s9.l {

        /* renamed from: a, reason: collision with root package name */
        public static final b f8792a = new b();

        public b() {
            super(1);
        }

        public final void invoke(String str) {
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((String) obj);
            return h9.t.f14242a;
        }
    }

    public static final class c extends t9.j implements s9.l {

        /* renamed from: a, reason: collision with root package name */
        public static final c f8793a = new c();

        public c() {
            super(1);
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return h9.t.f14242a;
        }

        public final void invoke(Throwable th) {
            th.printStackTrace();
        }
    }

    public static final String O(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        return (String) lVar.invoke(obj);
    }

    public static final void P(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void Q(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public final String A() {
        byte[] hardwareAddress;
        StringBuffer stringBuffer = new StringBuffer();
        try {
            NetworkInterface byName = NetworkInterface.getByName("wlan0");
            if (byName == null || (hardwareAddress = byName.getHardwareAddress()) == null) {
                return Session.DEFAULT_M;
            }
            for (byte b10 : hardwareAddress) {
                t9.z zVar = t9.z.f18964a;
                String format = String.format("%02X:", Arrays.copyOf(new Object[]{Byte.valueOf(b10)}, 1));
                t9.i.f(format, "format(format, *args)");
                stringBuffer.append(format);
            }
            if (stringBuffer.length() > 0) {
                stringBuffer.deleteCharAt(stringBuffer.length() - 1);
            }
            return stringBuffer.toString();
        } catch (Exception e10) {
            e10.printStackTrace();
            return Session.DEFAULT_M;
        }
    }

    public final boolean B(String str) {
        try {
            if (b0.J(str)) {
                return false;
            }
            String c10 = ma.i.c(str);
            if (b0.J(c10)) {
                return false;
            }
            t9.i.f(c10, "decryptedSn");
            List M = ba.t.M(c10, new String[]{","}, false, 0, 6, null);
            if (M.size() <= 1) {
                return false;
            }
            i.c cVar = w6.i.f19214g;
            cVar.u0((String) M.get(0));
            if (t9.i.b(Session.DEFAULT_M, cVar.E())) {
                j();
                return true;
            }
            cVar.a0((String) M.get(1));
            if (M.size() > 2) {
                cVar.w0((String) M.get(2));
            }
            return true;
        } catch (Exception e10) {
            e10.printStackTrace();
            return false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:162:0x0184, code lost:
    
        r2.close();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String C(java.lang.String r17, java.lang.String r18) {
        /*
            Method dump skipped, instructions count: 392
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mobile.brasiltv.utils.y0.C(java.lang.String, java.lang.String):java.lang.String");
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x013e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String D(android.content.Context r13) {
        /*
            Method dump skipped, instructions count: 324
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mobile.brasiltv.utils.y0.D(android.content.Context):java.lang.String");
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00f9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String E(android.content.Context r12) {
        /*
            Method dump skipped, instructions count: 255
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mobile.brasiltv.utils.y0.E(android.content.Context):java.lang.String");
    }

    public final boolean F(Context context) {
        t9.i.g(context, com.umeng.analytics.pro.f.X);
        if (!(p.a.checkSelfPermission(context, "android.permission.READ_MEDIA_IMAGES") == 0)) {
            return false;
        }
        if (!h(context)) {
            i(context);
        }
        return true;
    }

    public final boolean G(Context context) {
        t9.i.g(context, com.umeng.analytics.pro.f.X);
        na.f.k(context, "key_sn", "");
        boolean K = K(context);
        int i10 = Build.VERSION.SDK_INT;
        if (i10 <= 29) {
            if (K) {
                S();
                V(context);
                return true;
            }
            if (J()) {
                T(context);
                V(context);
            }
            return true;
        }
        if (K) {
            R(context);
            V(context);
            return true;
        }
        if (H(context)) {
            T(context);
            V(context);
            return true;
        }
        if (i10 > 33) {
            if (!(p.a.checkSelfPermission(context, "android.permission.READ_MEDIA_IMAGES") == 0) || !h(context)) {
                i(context);
            }
            return true;
        }
        if (i10 != 33) {
            if (!h(context)) {
                i(context);
            }
            return true;
        }
        if (!(p.a.checkSelfPermission(context, "android.permission.READ_MEDIA_IMAGES") == 0)) {
            return false;
        }
        if (!h(context)) {
            i(context);
        }
        return true;
    }

    public final boolean H(Context context) {
        return B(D(context));
    }

    public final boolean I(Context context) {
        return B(E(context));
    }

    public final boolean J() {
        Iterator it = s6.a.f18777a.a().n().iterator();
        while (it.hasNext()) {
            File file = new File((String) it.next());
            if (file.exists()) {
                try {
                    if (B(q9.c.b(file, null, 1, null))) {
                        return true;
                    }
                } catch (Exception e10) {
                    e10.printStackTrace();
                }
            }
        }
        return false;
    }

    public final boolean K(Context context) {
        t9.i.g(context, com.umeng.analytics.pro.f.X);
        return B(na.f.f(context, "SP_SN_BACKUP", ""));
    }

    public final void L() {
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x013b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void M(android.content.Context r8, java.lang.String r9, android.net.Uri r10, int r11) {
        /*
            Method dump skipped, instructions count: 321
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mobile.brasiltv.utils.y0.M(android.content.Context, java.lang.String, android.net.Uri, int):void");
    }

    public final void N(Context context) {
        t9.i.g(context, com.umeng.analytics.pro.f.X);
        V(context);
        Observable just = Observable.just("(write sn)");
        final a aVar = new a(context);
        Observable compose = just.map(new Function() { // from class: com.mobile.brasiltv.utils.v0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                String O;
                O = y0.O(s9.l.this, obj);
                return O;
            }
        }).compose(p0.c());
        final b bVar = b.f8792a;
        Consumer consumer = new Consumer() { // from class: com.mobile.brasiltv.utils.w0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                y0.P(s9.l.this, obj);
            }
        };
        final c cVar = c.f8793a;
        compose.subscribe(consumer, new Consumer() { // from class: com.mobile.brasiltv.utils.x0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                y0.Q(s9.l.this, obj);
            }
        });
    }

    public final void R(Context context) {
        Cursor cursor = null;
        try {
            try {
                Uri uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
                String[] strArr = {bx.f10121d, "_display_name", "title"};
                String[] strArr2 = {'%' + Environment.DIRECTORY_ALARMS + '/' + s6.a.f18777a.a().m() + "/%", "%google%"};
                StringBuilder sb = new StringBuilder();
                i.c cVar = w6.i.f19214g;
                sb.append(cVar.E());
                sb.append(ASCIIPropertyListParser.ARRAY_ITEM_DELIMITER_TOKEN);
                sb.append(cVar.l());
                sb.append(ASCIIPropertyListParser.ARRAY_ITEM_DELIMITER_TOKEN);
                sb.append(cVar.G());
                String g10 = ma.i.g(sb.toString());
                Cursor query = context.getContentResolver().query(uri, strArr, "relative_path LIKE ? AND title like ?", strArr2, "_id DESC");
                if (query != null) {
                    try {
                        try {
                            if (query.getCount() > 0) {
                                if (!query.moveToNext()) {
                                    query.close();
                                    return;
                                }
                                if (TextUtils.equals(g10, D(context))) {
                                    query.close();
                                    return;
                                }
                                try {
                                    Uri withAppendedId = ContentUris.withAppendedId(uri, query.getInt(0));
                                    t9.i.f(withAppendedId, "withAppendedId(uri, id.toLong())");
                                    context.getContentResolver().delete(withAppendedId, null);
                                    i1.G(context, AgooConstants.ACK_REMOVE_PACKAGE, "delete uri successful");
                                    t9.i.f(g10, "fileContent");
                                    t9.i.f(uri, "uri");
                                    M(context, g10, uri, 0);
                                } catch (RecoverableSecurityException e10) {
                                    e10.printStackTrace();
                                    i1.G(context, AgooConstants.ACK_BODY_NULL, "delete uri failure");
                                    String string = query.getString(1);
                                    t9.i.f(string, "displayName");
                                    int Y = b0.Y(ba.s.j(ba.s.j(string, ".wav", "", false, 4, null), "google", "", false, 4, null), 0) + 1;
                                    t9.i.f(g10, "fileContent");
                                    t9.i.f(uri, "uri");
                                    M(context, g10, uri, Y);
                                } catch (Exception e11) {
                                    e11.printStackTrace();
                                }
                                query.close();
                                return;
                            }
                        } catch (Exception e12) {
                            e = e12;
                            cursor = query;
                            e.printStackTrace();
                            if (cursor != null) {
                                cursor.close();
                                return;
                            }
                            return;
                        }
                    } catch (Throwable th) {
                        th = th;
                        cursor = query;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th;
                    }
                }
                t9.i.f(g10, "fileContent");
                t9.i.f(uri, "uri");
                M(context, g10, uri, 0);
                if (query != null) {
                    query.close();
                }
            } catch (Exception e13) {
                e = e13;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public final void S() {
        try {
            StringBuilder sb = new StringBuilder();
            i.c cVar = w6.i.f19214g;
            sb.append(cVar.E());
            sb.append(ASCIIPropertyListParser.ARRAY_ITEM_DELIMITER_TOKEN);
            sb.append(cVar.l());
            sb.append(ASCIIPropertyListParser.ARRAY_ITEM_DELIMITER_TOKEN);
            sb.append(cVar.G());
            String g10 = ma.i.g(sb.toString());
            for (String str : s6.a.f18777a.a().n()) {
                t9.i.f(g10, "encryptedSnData");
                U(str, g10);
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public final void T(Context context) {
        StringBuilder sb = new StringBuilder();
        i.c cVar = w6.i.f19214g;
        sb.append(cVar.E());
        sb.append(ASCIIPropertyListParser.ARRAY_ITEM_DELIMITER_TOKEN);
        sb.append(cVar.l());
        sb.append(ASCIIPropertyListParser.ARRAY_ITEM_DELIMITER_TOKEN);
        sb.append(cVar.G());
        na.f.k(context, "SP_SN_BACKUP", ma.i.g(sb.toString()));
    }

    public final void U(String str, String str2) {
        try {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            file.createNewFile();
            q9.c.e(file, str2, null, 2, null);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public final void V(Context context) {
        na.f.k(context, "key_sn", w6.i.f19214g.E());
    }

    public final String d(String str) {
        FileReader fileReader;
        BufferedReader bufferedReader;
        String str2 = null;
        try {
            fileReader = new FileReader(str);
        } catch (Throwable unused) {
        }
        try {
            bufferedReader = new BufferedReader(fileReader, 1024);
            try {
                str2 = bufferedReader.readLine();
                try {
                    fileReader.close();
                } catch (Throwable unused2) {
                }
                bufferedReader.close();
                return str2;
            } catch (Throwable th) {
                th = th;
                try {
                    fileReader.close();
                } catch (Throwable unused3) {
                }
                if (bufferedReader == null) {
                    throw th;
                }
                try {
                    bufferedReader.close();
                    throw th;
                } catch (Throwable unused4) {
                    throw th;
                }
            }
        } catch (Throwable th2) {
            th = th2;
            bufferedReader = null;
        }
    }

    public final boolean h(Context context) {
        if (!I(context)) {
            return false;
        }
        T(context);
        R(context);
        V(context);
        return true;
    }

    public final void i(Context context) {
        if (J()) {
            R(context);
            T(context);
            V(context);
        }
    }

    public final void j() {
        i.c cVar = w6.i.f19214g;
        cVar.u0("");
        cVar.a0("");
        cVar.w0("");
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0071  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String k(java.lang.String r7) {
        /*
            r6 = this;
            java.lang.StringBuffer r0 = new java.lang.StringBuffer
            r0.<init>()
            r1 = 0
            java.lang.Runtime r2 = java.lang.Runtime.getRuntime()     // Catch: java.lang.Throwable -> L4d java.lang.Exception -> L50
            java.lang.Process r7 = r2.exec(r7)     // Catch: java.lang.Throwable -> L4d java.lang.Exception -> L50
            if (r7 != 0) goto L13
            java.lang.String r7 = ""
            return r7
        L13:
            java.io.InputStream r7 = r7.getInputStream()     // Catch: java.lang.Throwable -> L4d java.lang.Exception -> L50
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L44 java.lang.Exception -> L48
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L44 java.lang.Exception -> L48
            r3.<init>(r7)     // Catch: java.lang.Throwable -> L44 java.lang.Exception -> L48
            r4 = 8192(0x2000, float:1.148E-41)
            r2.<init>(r3, r4)     // Catch: java.lang.Throwable -> L44 java.lang.Exception -> L48
        L23:
            java.lang.String r1 = r2.readLine()     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L3e
            if (r1 != 0) goto L32
            r2.close()
            if (r7 == 0) goto L5f
            r7.close()
            goto L5f
        L32:
            r0.append(r1)     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L3e
            java.lang.String r1 = "sb.append(line)"
            t9.i.f(r0, r1)     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L3e
            goto L23
        L3b:
            r0 = move-exception
            r1 = r2
            goto L45
        L3e:
            r1 = move-exception
            r5 = r2
            r2 = r7
            r7 = r1
            r1 = r5
            goto L52
        L44:
            r0 = move-exception
        L45:
            r2 = r7
            r7 = r0
            goto L6a
        L48:
            r2 = move-exception
            r5 = r2
            r2 = r7
            r7 = r5
            goto L52
        L4d:
            r7 = move-exception
            r2 = r1
            goto L6a
        L50:
            r7 = move-exception
            r2 = r1
        L52:
            r7.printStackTrace()     // Catch: java.lang.Throwable -> L69
            if (r1 == 0) goto L5a
            r1.close()
        L5a:
            if (r2 == 0) goto L5f
            r2.close()
        L5f:
            java.lang.String r7 = r0.toString()
            java.lang.String r0 = "sb.toString()"
            t9.i.f(r7, r0)
            return r7
        L69:
            r7 = move-exception
        L6a:
            if (r1 == 0) goto L6f
            r1.close()
        L6f:
            if (r2 == 0) goto L74
            r2.close()
        L74:
            goto L76
        L75:
            throw r7
        L76:
            goto L75
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mobile.brasiltv.utils.y0.k(java.lang.String):java.lang.String");
    }

    public final String l(Context context) {
        t9.i.g(context, com.umeng.analytics.pro.f.X);
        String string = Settings.System.getString(context.getContentResolver(), "android_id");
        return string == null ? "" : string;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x002e, code lost:
    
        r1 = r4.substring(ba.t.y(r4, "Serial", 0, false, 6, null) + 6);
        t9.i.f(r1, "this as java.lang.String).substring(startIndex)");
        r1 = new ba.i(" ").c(new ba.i(com.hpplay.cybergarage.soap.SOAP.DELIM).c(r1, ""), "");
        r3 = r1.length() - 1;
        r5 = 0;
        r6 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0062, code lost:
    
        if (r5 > r3) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0064, code lost:
    
        if (r6 != false) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0066, code lost:
    
        r7 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0073, code lost:
    
        if (t9.i.i(r1.charAt(r7), 32) > 0) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0075, code lost:
    
        r7 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0078, code lost:
    
        if (r6 != false) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0081, code lost:
    
        if (r7 != false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0084, code lost:
    
        r3 = r3 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0087, code lost:
    
        r0 = r1.subSequence(r5, r3 + 1).toString();
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x007a, code lost:
    
        if (r7 != false) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x007e, code lost:
    
        r5 = r5 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x007c, code lost:
    
        r6 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0077, code lost:
    
        r7 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0068, code lost:
    
        r7 = r3;
     */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00ae A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:49:0x0095 -> B:29:0x00a9). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String m() {
        /*
            r14 = this;
            java.lang.String r0 = ""
            r1 = 0
            java.lang.Runtime r2 = java.lang.Runtime.getRuntime()     // Catch: java.lang.Throwable -> L9b java.io.IOException -> L9d
            java.lang.String r3 = "cat proc/cpuinfo"
            java.lang.Process r2 = r2.exec(r3)     // Catch: java.lang.Throwable -> L9b java.io.IOException -> L9d
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch: java.io.IOException -> L99 java.lang.Throwable -> Laa
            java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch: java.io.IOException -> L99 java.lang.Throwable -> Laa
            java.io.InputStream r5 = r2.getInputStream()     // Catch: java.io.IOException -> L99 java.lang.Throwable -> Laa
            r4.<init>(r5)     // Catch: java.io.IOException -> L99 java.lang.Throwable -> Laa
            r3.<init>(r4)     // Catch: java.io.IOException -> L99 java.lang.Throwable -> Laa
        L1b:
            java.lang.String r4 = r3.readLine()     // Catch: java.io.IOException -> L99 java.lang.Throwable -> Laa
            if (r4 == 0) goto L90
            t9.i.d(r4)     // Catch: java.io.IOException -> L99 java.lang.Throwable -> Laa
            java.lang.String r5 = "Serial"
            r6 = 2
            r12 = 0
            boolean r5 = ba.t.o(r4, r5, r12, r6, r1)     // Catch: java.io.IOException -> L99 java.lang.Throwable -> Laa
            if (r5 == 0) goto L1b
            java.lang.String r7 = "Serial"
            r8 = 0
            r9 = 0
            r10 = 6
            r11 = 0
            r6 = r4
            int r1 = ba.t.y(r6, r7, r8, r9, r10, r11)     // Catch: java.io.IOException -> L99 java.lang.Throwable -> Laa
            int r1 = r1 + 6
            java.lang.String r1 = r4.substring(r1)     // Catch: java.io.IOException -> L99 java.lang.Throwable -> Laa
            java.lang.String r3 = "this as java.lang.String).substring(startIndex)"
            t9.i.f(r1, r3)     // Catch: java.io.IOException -> L99 java.lang.Throwable -> Laa
            ba.i r3 = new ba.i     // Catch: java.io.IOException -> L99 java.lang.Throwable -> Laa
            java.lang.String r4 = ":"
            r3.<init>(r4)     // Catch: java.io.IOException -> L99 java.lang.Throwable -> Laa
            java.lang.String r1 = r3.c(r1, r0)     // Catch: java.io.IOException -> L99 java.lang.Throwable -> Laa
            ba.i r3 = new ba.i     // Catch: java.io.IOException -> L99 java.lang.Throwable -> Laa
            java.lang.String r4 = " "
            r3.<init>(r4)     // Catch: java.io.IOException -> L99 java.lang.Throwable -> Laa
            java.lang.String r1 = r3.c(r1, r0)     // Catch: java.io.IOException -> L99 java.lang.Throwable -> Laa
            int r3 = r1.length()     // Catch: java.io.IOException -> L99 java.lang.Throwable -> Laa
            r4 = 1
            int r3 = r3 - r4
            r5 = 0
            r6 = 0
        L62:
            if (r5 > r3) goto L87
            if (r6 != 0) goto L68
            r7 = r5
            goto L69
        L68:
            r7 = r3
        L69:
            char r7 = r1.charAt(r7)     // Catch: java.io.IOException -> L99 java.lang.Throwable -> Laa
            r8 = 32
            int r7 = t9.i.i(r7, r8)     // Catch: java.io.IOException -> L99 java.lang.Throwable -> Laa
            if (r7 > 0) goto L77
            r7 = 1
            goto L78
        L77:
            r7 = 0
        L78:
            if (r6 != 0) goto L81
            if (r7 != 0) goto L7e
            r6 = 1
            goto L62
        L7e:
            int r5 = r5 + 1
            goto L62
        L81:
            if (r7 != 0) goto L84
            goto L87
        L84:
            int r3 = r3 + (-1)
            goto L62
        L87:
            int r3 = r3 + r4
            java.lang.CharSequence r1 = r1.subSequence(r5, r3)     // Catch: java.io.IOException -> L99 java.lang.Throwable -> Laa
            java.lang.String r0 = r1.toString()     // Catch: java.io.IOException -> L99 java.lang.Throwable -> Laa
        L90:
            r2.destroy()     // Catch: java.lang.Exception -> L94
            goto La9
        L94:
            r1 = move-exception
            r1.printStackTrace()
            goto La9
        L99:
            r1 = move-exception
            goto La1
        L9b:
            r0 = move-exception
            goto Lac
        L9d:
            r2 = move-exception
            r13 = r2
            r2 = r1
            r1 = r13
        La1:
            r1.printStackTrace()     // Catch: java.lang.Throwable -> Laa
            if (r2 == 0) goto La9
            r2.destroy()     // Catch: java.lang.Exception -> L94
        La9:
            return r0
        Laa:
            r0 = move-exception
            r1 = r2
        Lac:
            if (r1 == 0) goto Lb6
            r1.destroy()     // Catch: java.lang.Exception -> Lb2
            goto Lb6
        Lb2:
            r1 = move-exception
            r1.printStackTrace()
        Lb6:
            goto Lb8
        Lb7:
            throw r0
        Lb8:
            goto Lb7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mobile.brasiltv.utils.y0.m():java.lang.String");
    }

    public final String n() {
        String k10 = k("cat /sys/block/mmcblk0/device/type");
        String k11 = k("cat /sys/block/mmcblk0/device/name");
        String k12 = k("cat /sys/block/mmcblk0/device/cid");
        if (k10.length() == 0) {
            if (k11.length() == 0) {
                if (k12.length() == 0) {
                    return "";
                }
            }
        }
        return k10 + ASCIIPropertyListParser.ARRAY_ITEM_DELIMITER_TOKEN + k11 + ASCIIPropertyListParser.ARRAY_ITEM_DELIMITER_TOKEN + k12;
    }

    public final String o() {
        try {
            String d10 = d("/sys/class/net/eth0/address");
            if (d10 != null) {
                return d10;
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public final String p() {
        byte[] hardwareAddress;
        StringBuffer stringBuffer = new StringBuffer();
        try {
            NetworkInterface byName = NetworkInterface.getByName("eth1");
            if (byName == null || (hardwareAddress = byName.getHardwareAddress()) == null) {
                return Session.DEFAULT_M;
            }
            for (byte b10 : hardwareAddress) {
                t9.z zVar = t9.z.f18964a;
                String format = String.format("%02X:", Arrays.copyOf(new Object[]{Byte.valueOf(b10)}, 1));
                t9.i.f(format, "format(format, *args)");
                stringBuffer.append(format);
            }
            if (stringBuffer.length() > 0) {
                stringBuffer.deleteCharAt(stringBuffer.length() - 1);
            }
            return stringBuffer.toString();
        } catch (Exception e10) {
            e10.printStackTrace();
            return Session.DEFAULT_M;
        }
    }

    public final String q() {
        String p10 = p();
        String str = Session.DEFAULT_M;
        if (p10 == null) {
            p10 = Session.DEFAULT_M;
        }
        if (TextUtils.equals(Session.DEFAULT_M, p10) || TextUtils.isEmpty(p10)) {
            String o10 = o();
            if (o10 != null) {
                str = o10;
            }
            p10 = str;
        }
        if (!ba.t.o(p10, SOAP.DELIM, false, 2, null)) {
            p10 = Pattern.compile("(.{2}(?=.))").matcher(p10).replaceAll("$1:");
            t9.i.f(p10, "compile(\"(.{2}(?=.))\").m…er(mac).replaceAll(\"$1:\")");
        }
        Locale locale = Locale.getDefault();
        t9.i.f(locale, "getDefault()");
        String lowerCase = p10.toLowerCase(locale);
        t9.i.f(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        return lowerCase;
    }

    public final String r() {
        String s10 = s();
        if (s10 != null) {
            String[] strArr = (String[]) new ba.i("\\.").e(s10, 0).toArray(new String[0]);
            if (strArr.length >= 4) {
                strArr[3] = "1";
                String str = strArr[0] + '.' + strArr[1] + '.' + strArr[2] + '.' + strArr[3];
                strArr[3] = "254";
                return C(str, strArr[0] + '.' + strArr[1] + '.' + strArr[2] + '.' + strArr[3]);
            }
        }
        return "";
    }

    public final String s() {
        String str = null;
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            t9.i.f(networkInterfaces, "getNetworkInterfaces()");
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface nextElement = networkInterfaces.nextElement();
                t9.i.e(nextElement, "null cannot be cast to non-null type java.net.NetworkInterface");
                Enumeration<InetAddress> inetAddresses = nextElement.getInetAddresses();
                while (true) {
                    if (inetAddresses.hasMoreElements()) {
                        InetAddress nextElement2 = inetAddresses.nextElement();
                        if (!(nextElement2 instanceof Inet6Address) && !t9.i.b("127.0.0.1", nextElement2.getHostAddress())) {
                            str = nextElement2.getHostAddress();
                            break;
                        }
                    }
                }
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        return str;
    }

    public final String t() {
        String d10;
        try {
            String[] strArr = {"/sys/class/net/wlan0/address", "/sys/devices/virtual/net/wlan0/address"};
            for (int i10 = 0; i10 < 2; i10++) {
                try {
                    d10 = d(strArr[i10]);
                } catch (Throwable unused) {
                }
                if (d10 != null) {
                    return d10;
                }
            }
            return null;
        } catch (Throwable unused2) {
            return null;
        }
    }

    public final String u(Context context) {
        t9.i.g(context, com.umeng.analytics.pro.f.X);
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            if (activityManager == null) {
                return "";
            }
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            activityManager.getMemoryInfo(memoryInfo);
            String formatFileSize = Formatter.formatFileSize(context, memoryInfo.totalMem);
            t9.i.f(formatFileSize, "formatFileSize(context, totalSize)");
            return formatFileSize;
        } catch (Exception unused) {
            return "";
        }
    }

    public final String v(Context context) {
        String str;
        t9.i.g(context, com.umeng.analytics.pro.f.X);
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            str = Formatter.formatFileSize(context, statFs.getBlockSizeLong() * statFs.getBlockCountLong());
        } catch (Exception unused) {
            str = "";
        }
        t9.i.f(str, "{\n            try {\n    …\"\n            }\n        }");
        return str;
    }

    public final String w() {
        String str = Build.SERIAL;
        if (str == null) {
            str = "unknown";
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.equals("unknown", str)) {
            return str;
        }
        String x10 = x();
        return x10 != null ? x10 : "unknown";
    }

    public final String x() {
        try {
            return (String) Build.class.getMethod("getSerial", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    public final String y(Context context) {
        String str;
        t9.i.g(context, com.umeng.analytics.pro.f.X);
        int i10 = Build.VERSION.SDK_INT;
        String str2 = Session.DEFAULT_M;
        if (i10 >= 23 || (str = z(context)) == null) {
            str = Session.DEFAULT_M;
        }
        if (TextUtils.equals(Session.DEFAULT_M, str) || TextUtils.isEmpty(str)) {
            str = A();
        }
        if (TextUtils.equals(Session.DEFAULT_M, str) || TextUtils.isEmpty(str)) {
            String t10 = t();
            if (t10 != null) {
                str2 = t10;
            }
            str = str2;
        }
        if (!ba.t.o(str, SOAP.DELIM, false, 2, null)) {
            str = Pattern.compile("(.{2}(?=.))").matcher(str).replaceAll("$1:");
            t9.i.f(str, "compile(\"(.{2}(?=.))\").m…ifiMac).replaceAll(\"$1:\")");
        }
        Locale locale = Locale.getDefault();
        t9.i.f(locale, "getDefault()");
        String lowerCase = str.toLowerCase(locale);
        t9.i.f(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        return lowerCase;
    }

    public final String z(Context context) {
        Object systemService = context.getSystemService("wifi");
        t9.i.e(systemService, "null cannot be cast to non-null type android.net.wifi.WifiManager");
        WifiInfo connectionInfo = ((WifiManager) systemService).getConnectionInfo();
        if (connectionInfo != null) {
            return connectionInfo.getMacAddress();
        }
        return null;
    }
}
