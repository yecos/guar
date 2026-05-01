package com.mobile.brasiltv.utils;

import android.app.ActivityManager;
import android.app.RecoverableSecurityException;
import android.content.ContentUris;
import android.content.ContentValues;
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
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
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
    */
    public final String C(String str, String str2) {
        String obj;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/net/arp"));
            while (true) {
                String readLine = bufferedReader.readLine();
                t9.i.f(readLine, "it");
                if (readLine == null) {
                    break;
                }
                try {
                    int length = readLine.length() - 1;
                    int i10 = 0;
                    boolean z10 = false;
                    while (i10 <= length) {
                        boolean z11 = t9.i.i(readLine.charAt(!z10 ? i10 : length), 32) <= 0;
                        if (z10) {
                            if (!z11) {
                                break;
                            }
                            length--;
                        } else if (z11) {
                            i10++;
                        } else {
                            z10 = true;
                        }
                    }
                    obj = readLine.subSequence(i10, length + 1).toString();
                } catch (Exception unused) {
                }
                if (obj.length() >= 63) {
                    Locale locale = Locale.US;
                    t9.i.f(locale, "US");
                    String upperCase = obj.toUpperCase(locale);
                    t9.i.f(upperCase, "this as java.lang.String).toUpperCase(locale)");
                    if (!ba.t.o(upperCase, "IP", false, 2, null)) {
                        String substring = obj.substring(0, 17);
                        t9.i.f(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                        int length2 = substring.length() - 1;
                        int i11 = 0;
                        boolean z12 = false;
                        while (i11 <= length2) {
                            boolean z13 = t9.i.i(substring.charAt(!z12 ? i11 : length2), 32) <= 0;
                            if (z12) {
                                if (!z13) {
                                    break;
                                }
                                length2--;
                            } else if (z13) {
                                i11++;
                            } else {
                                z12 = true;
                            }
                        }
                        String obj2 = substring.subSequence(i11, length2 + 1).toString();
                        String substring2 = obj.substring(29, 32);
                        t9.i.f(substring2, "this as java.lang.String…ing(startIndex, endIndex)");
                        int length3 = substring2.length() - 1;
                        int i12 = 0;
                        boolean z14 = false;
                        while (i12 <= length3) {
                            boolean z15 = t9.i.i(substring2.charAt(!z14 ? i12 : length3), 32) <= 0;
                            if (z14) {
                                if (!z15) {
                                    break;
                                }
                                length3--;
                            } else if (z15) {
                                i12++;
                            } else {
                                z14 = true;
                            }
                        }
                        substring2.subSequence(i12, length3 + 1).toString();
                        String substring3 = obj.substring(41, 63);
                        t9.i.f(substring3, "this as java.lang.String…ing(startIndex, endIndex)");
                        int length4 = substring3.length() - 1;
                        int i13 = 0;
                        boolean z16 = false;
                        while (i13 <= length4) {
                            boolean z17 = t9.i.i(substring3.charAt(!z16 ? i13 : length4), 32) <= 0;
                            if (z16) {
                                if (!z17) {
                                    break;
                                }
                                length4--;
                            } else if (z17) {
                                i13++;
                            } else {
                                z16 = true;
                            }
                        }
                        String obj3 = substring3.subSequence(i13, length4 + 1).toString();
                        if (!ba.t.o(obj3, "00:00:00:00:00:00", false, 2, null)) {
                            if (!TextUtils.isEmpty(obj3)) {
                                if (!TextUtils.isEmpty(str)) {
                                    try {
                                        if (t9.i.b(str, obj2)) {
                                            String replaceAll = Pattern.compile("(.{2}(?=.))").matcher(new ba.i(SOAP.DELIM).c(obj3, "")).replaceAll("$1:");
                                            t9.i.f(replaceAll, "compile(\"(.{2}(?=.))\").m…er(mac).replaceAll(\"$1:\")");
                                            return replaceAll;
                                        }
                                    } catch (Exception unused2) {
                                    }
                                }
                                if (!TextUtils.isEmpty(str2)) {
                                    try {
                                        if (t9.i.b(str2, obj2)) {
                                            String replaceAll2 = Pattern.compile("(.{2}(?=.))").matcher(new ba.i(SOAP.DELIM).c(obj3, "")).replaceAll("$1:");
                                            t9.i.f(replaceAll2, "compile(\"(.{2}(?=.))\").m…er(mac).replaceAll(\"$1:\")");
                                            return replaceAll2;
                                        }
                                        continue;
                                    } catch (Exception unused3) {
                                        continue;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception unused4) {
        }
        return "";
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
    */
    public final String D(Context context) {
        InputStream inputStream;
        InputStream inputStream2;
        BufferedInputStream bufferedInputStream;
        Exception e10;
        Cursor cursor;
        String message;
        Cursor cursor2 = null;
        try {
            try {
                Uri uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
                cursor = context.getContentResolver().query(uri, new String[]{bx.f10121d, "_display_name", "title"}, "relative_path LIKE ? AND title like ?", new String[]{'%' + Environment.DIRECTORY_ALARMS + '/' + s6.a.f18777a.a().m() + "/%", "%google%"}, "_id DESC");
                try {
                    StringBuilder sb = new StringBuilder();
                    t9.i.d(cursor);
                    if (cursor.getCount() > 0 && cursor.moveToNext()) {
                        inputStream = context.getContentResolver().openInputStream(Uri.withAppendedPath(uri, String.valueOf(cursor.getInt(0))));
                        if (inputStream == null) {
                            cursor.close();
                            return "";
                        }
                        try {
                            if (inputStream.skip(8046L) != 8046) {
                                cursor.close();
                                inputStream.close();
                                return "";
                            }
                            bufferedInputStream = new BufferedInputStream(inputStream);
                            try {
                                t9.u uVar = new t9.u();
                                byte[] bArr = new byte[1024];
                                while (true) {
                                    int read = bufferedInputStream.read(bArr, 0, 1024);
                                    uVar.f18959a = read;
                                    if (read == -1) {
                                        break;
                                    }
                                    sb.append(new String(bArr, 0, read, ba.c.f5214b));
                                }
                                if (TextUtils.isEmpty(w6.i.f19214g.E())) {
                                    i1.G(context, "3", "3:");
                                }
                                String sb2 = sb.toString();
                                t9.i.f(sb2, "snData.toString()");
                                cursor.close();
                                inputStream.close();
                                bufferedInputStream.close();
                                return sb2;
                            } catch (Exception e11) {
                                e10 = e11;
                                e10.printStackTrace();
                                StringBuilder sb3 = new StringBuilder();
                                sb3.append("2:");
                                message = e10.getMessage();
                                if (message == null) {
                                    message = "";
                                }
                                sb3.append(message);
                                i1.G(context, "2", sb3.toString());
                                if (cursor != null) {
                                    cursor.close();
                                }
                                if (inputStream != null) {
                                    inputStream.close();
                                }
                                if (bufferedInputStream != null) {
                                    bufferedInputStream.close();
                                }
                                return "";
                            }
                        } catch (Exception e12) {
                            e = e12;
                            bufferedInputStream = null;
                            e10 = e;
                            e10.printStackTrace();
                            StringBuilder sb32 = new StringBuilder();
                            sb32.append("2:");
                            message = e10.getMessage();
                            if (message == null) {
                            }
                            sb32.append(message);
                            i1.G(context, "2", sb32.toString());
                            if (cursor != null) {
                            }
                            if (inputStream != null) {
                            }
                            if (bufferedInputStream != null) {
                            }
                            return "";
                        } catch (Throwable th) {
                            th = th;
                            inputStream2 = null;
                            cursor2 = cursor;
                            if (cursor2 != null) {
                                cursor2.close();
                            }
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            if (inputStream2 != null) {
                                inputStream2.close();
                            }
                            throw th;
                        }
                    }
                    cursor.close();
                    return "";
                } catch (Exception e13) {
                    e = e13;
                    inputStream = null;
                    bufferedInputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                    inputStream = null;
                    inputStream2 = null;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Exception e14) {
            inputStream = null;
            bufferedInputStream = null;
            e10 = e14;
            cursor = null;
        } catch (Throwable th4) {
            th = th4;
            inputStream = null;
            inputStream2 = null;
            if (cursor2 != null) {
            }
            if (inputStream != null) {
            }
            if (inputStream2 != null) {
            }
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00f9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String E(Context context) {
        InputStream inputStream;
        BufferedInputStream bufferedInputStream;
        Exception e10;
        Cursor cursor;
        Uri uri;
        Cursor cursor2 = null;
        try {
            try {
                uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                cursor = context.getContentResolver().query(uri, new String[]{bx.f10121d, "_display_name", "title"}, "title like '%" + s6.a.f18777a.a().l() + "%'", null, "_id DESC");
            } catch (Throwable th) {
                th = th;
            }
            try {
                StringBuilder sb = new StringBuilder();
                t9.i.d(cursor);
                if (cursor.getCount() > 0 && cursor.moveToNext()) {
                    bufferedInputStream = new BufferedInputStream(context.getContentResolver().openInputStream(Uri.withAppendedPath(uri, String.valueOf(cursor.getInt(0)))));
                    try {
                        t9.u uVar = new t9.u();
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int read = bufferedInputStream.read(bArr, 0, 1024);
                            uVar.f18959a = read;
                            if (read == -1) {
                                break;
                            }
                            sb.append(new String(bArr, 0, read, ba.c.f5214b));
                        }
                        if (TextUtils.isEmpty(w6.i.f19214g.E())) {
                            i1.G(context, "3", "3:");
                        }
                        String sb2 = sb.toString();
                        t9.i.f(sb2, "snData.toString()");
                        cursor.close();
                        bufferedInputStream.close();
                        return sb2;
                    } catch (Exception e11) {
                        e10 = e11;
                        e10.printStackTrace();
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("2:");
                        String message = e10.getMessage();
                        if (message == null) {
                            message = "";
                        }
                        sb3.append(message);
                        i1.G(context, "2", sb3.toString());
                        if (cursor != null) {
                            cursor.close();
                        }
                        if (bufferedInputStream != null) {
                            bufferedInputStream.close();
                        }
                        return "";
                    }
                }
                cursor.close();
                return "";
            } catch (Exception e12) {
                bufferedInputStream = null;
                e10 = e12;
            } catch (Throwable th2) {
                th = th2;
                inputStream = null;
                cursor2 = cursor;
                if (cursor2 != null) {
                    cursor2.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                throw th;
            }
        } catch (Exception e13) {
            bufferedInputStream = null;
            e10 = e13;
            cursor = null;
        } catch (Throwable th3) {
            th = th3;
            inputStream = null;
            if (cursor2 != null) {
            }
            if (inputStream != null) {
            }
            throw th;
        }
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
    */
    public final void M(Context context, String str, Uri uri, int i10) {
        String str2;
        InputStream inputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        BufferedOutputStream bufferedOutputStream;
        byte[] bytes;
        ContentValues contentValues = new ContentValues();
        contentValues.put("relative_path", Environment.DIRECTORY_ALARMS + File.separator + s6.a.f18777a.a().m());
        if (i10 == 0) {
            str2 = "google.wav";
        } else {
            str2 = "google" + i10 + ".wav";
        }
        contentValues.put("_display_name", str2);
        contentValues.put("mime_type", "audio/wav");
        contentValues.put("title", "google");
        BufferedOutputStream bufferedOutputStream2 = null;
        try {
            Uri insert = context.getContentResolver().insert(uri, contentValues);
            t9.i.d(insert);
            i1.H(context, insert);
            bufferedOutputStream = new BufferedOutputStream(context.getContentResolver().openOutputStream(insert, "rw"));
            try {
                inputStream = context.getAssets().open("google.wav");
                try {
                    Charset charset = StandardCharsets.UTF_8;
                    t9.i.f(charset, "UTF_8");
                    bytes = str.getBytes(charset);
                    t9.i.f(bytes, "this as java.lang.String).getBytes(charset)");
                    byteArrayOutputStream = new ByteArrayOutputStream();
                } catch (Exception e10) {
                    e = e10;
                    byteArrayOutputStream = null;
                } catch (Throwable th) {
                    th = th;
                    byteArrayOutputStream = null;
                }
            } catch (Exception e11) {
                e = e11;
                inputStream = null;
                byteArrayOutputStream = null;
            } catch (Throwable th2) {
                th = th2;
                inputStream = null;
                byteArrayOutputStream = null;
            }
        } catch (Exception e12) {
            e = e12;
            inputStream = null;
            byteArrayOutputStream = null;
        } catch (Throwable th3) {
            th = th3;
            inputStream = null;
            byteArrayOutputStream = null;
        }
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    break;
                } else {
                    byteArrayOutputStream.write(bArr, 0, read);
                }
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byte[] bArr2 = new byte[byteArray.length + bytes.length];
            if (byteArray.length > 8) {
                int length = (byteArray.length - 8) + bytes.length;
                byteArray[7] = (byte) (length >> 24);
                byteArray[6] = (byte) ((length << 8) >> 24);
                byteArray[5] = (byte) ((length << 16) >> 24);
                byteArray[4] = (byte) ((length << 24) >> 24);
            }
            System.arraycopy(byteArray, 0, bArr2, 0, byteArray.length);
            System.arraycopy(bytes, 0, bArr2, byteArray.length, bytes.length);
            bufferedOutputStream.write(bArr2);
            bufferedOutputStream.close();
            inputStream.close();
        } catch (Exception e13) {
            e = e13;
            bufferedOutputStream2 = bufferedOutputStream;
            try {
                e.printStackTrace();
                i1.G(context, AgooConstants.ACK_PACK_NULL, "insert uri failure and msg is " + e.getMessage());
                if (bufferedOutputStream2 != null) {
                    bufferedOutputStream2.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                if (byteArrayOutputStream == null) {
                    return;
                }
                byteArrayOutputStream.close();
            } catch (Throwable th4) {
                th = th4;
                if (bufferedOutputStream2 != null) {
                    bufferedOutputStream2.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                throw th;
            }
        } catch (Throwable th5) {
            th = th5;
            bufferedOutputStream2 = bufferedOutputStream;
            if (bufferedOutputStream2 != null) {
            }
            if (inputStream != null) {
            }
            if (byteArrayOutputStream != null) {
            }
            throw th;
        }
        byteArrayOutputStream.close();
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
    */
    public final String k(String str) {
        InputStream inputStream;
        Process exec;
        StringBuffer stringBuffer = new StringBuffer();
        BufferedReader bufferedReader = null;
        try {
            exec = Runtime.getRuntime().exec(str);
        } catch (Exception e10) {
            e = e10;
            inputStream = null;
        } catch (Throwable th) {
            th = th;
            inputStream = null;
        }
        if (exec == null) {
            return "";
        }
        InputStream inputStream2 = exec.getInputStream();
        try {
            BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(inputStream2), 8192);
            while (true) {
                try {
                    String readLine = bufferedReader2.readLine();
                    if (readLine == null) {
                        break;
                    }
                    stringBuffer.append(readLine);
                    t9.i.f(stringBuffer, "sb.append(line)");
                } catch (Exception e11) {
                    inputStream = inputStream2;
                    e = e11;
                    bufferedReader = bufferedReader2;
                    try {
                        e.printStackTrace();
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        String stringBuffer2 = stringBuffer.toString();
                        t9.i.f(stringBuffer2, "sb.toString()");
                        return stringBuffer2;
                    } catch (Throwable th2) {
                        th = th2;
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    bufferedReader = bufferedReader2;
                    inputStream = inputStream2;
                    th = th;
                    if (bufferedReader != null) {
                    }
                    if (inputStream != null) {
                    }
                    throw th;
                }
            }
            bufferedReader2.close();
            if (inputStream2 != null) {
                inputStream2.close();
            }
        } catch (Exception e12) {
            inputStream = inputStream2;
            e = e12;
        } catch (Throwable th4) {
            th = th4;
        }
        String stringBuffer22 = stringBuffer.toString();
        t9.i.f(stringBuffer22, "sb.toString()");
        return stringBuffer22;
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
    */
    public final String m() {
        Process process;
        IOException e10;
        String str = "";
        Process process2 = null;
        try {
            try {
                process = Runtime.getRuntime().exec("cat proc/cpuinfo");
                try {
                    try {
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                        while (true) {
                            String readLine = bufferedReader.readLine();
                            if (readLine == null) {
                                break;
                            }
                            t9.i.d(readLine);
                            if (ba.t.o(readLine, "Serial", false, 2, null)) {
                                break;
                            }
                        }
                        process.destroy();
                    } catch (IOException e11) {
                        e10 = e11;
                        e10.printStackTrace();
                        if (process != null) {
                            process.destroy();
                        }
                        return str;
                    }
                } catch (Throwable th) {
                    th = th;
                    process2 = process;
                    if (process2 != null) {
                        try {
                            process2.destroy();
                        } catch (Exception e12) {
                            e12.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Exception e13) {
                e13.printStackTrace();
            }
        } catch (IOException e14) {
            process = null;
            e10 = e14;
        } catch (Throwable th2) {
            th = th2;
            if (process2 != null) {
            }
            throw th;
        }
        return str;
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
