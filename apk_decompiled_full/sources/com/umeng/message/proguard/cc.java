package com.umeng.message.proguard;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.os.SystemClock;
import android.text.TextUtils;
import com.google.common.net.HttpHeaders;
import com.hpplay.cybergarage.xml.XML;
import com.umeng.commonsdk.utils.UMUtils;
import com.umeng.message.proguard.df;
import io.jsonwebtoken.Header;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.zip.GZIPOutputStream;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class cc {

    public interface a {
        void a(Bitmap bitmap);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0078 A[Catch: all -> 0x0122, TryCatch #1 {all -> 0x0122, blocks: (B:13:0x006d, B:15:0x0078, B:16:0x0081, B:18:0x0086, B:19:0x008a, B:21:0x0091, B:45:0x007d), top: B:12:0x006d }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0086 A[Catch: all -> 0x0122, TryCatch #1 {all -> 0x0122, blocks: (B:13:0x006d, B:15:0x0078, B:16:0x0081, B:18:0x0086, B:19:0x008a, B:21:0x0091, B:45:0x007d), top: B:12:0x006d }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x007d A[Catch: all -> 0x0122, TryCatch #1 {all -> 0x0122, blocks: (B:13:0x006d, B:15:0x0078, B:16:0x0081, B:18:0x0086, B:19:0x008a, B:21:0x0091, B:45:0x007d), top: B:12:0x006d }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static JSONObject a(JSONObject jSONObject, String str, String str2) {
        GZIPOutputStream gZIPOutputStream;
        byte[] a10;
        InputStream inputStream;
        HttpURLConnection httpURLConnection;
        OutputStream outputStream;
        int responseCode;
        String str3;
        String jSONObject2 = jSONObject.toString();
        byte[] bytes = str2.getBytes();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bytes2 = jSONObject2.getBytes();
        InputStream inputStream2 = null;
        try {
            gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            try {
                gZIPOutputStream.write(bytes2);
            } catch (Throwable th) {
                th = th;
                try {
                    ce.d(Header.COMPRESSION_ALGORITHM, th.getMessage());
                    a10 = dz.a(byteArrayOutputStream.toByteArray(), bytes);
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                    try {
                        httpURLConnection.setRequestMethod("POST");
                        httpURLConnection.setReadTimeout(30000);
                        httpURLConnection.setConnectTimeout(30000);
                        httpURLConnection.addRequestProperty("Content-Type", "application/octet-stream");
                        httpURLConnection.addRequestProperty("appkey", str2);
                        httpURLConnection.setFixedLengthStreamingMode(a10.length);
                        httpURLConnection.setDoOutput(true);
                        outputStream = httpURLConnection.getOutputStream();
                        try {
                            outputStream.write(a10);
                            responseCode = httpURLConnection.getResponseCode();
                            if (responseCode >= 400) {
                            }
                            byteArrayOutputStream.reset();
                            if (gZIPOutputStream != null) {
                            }
                            eb.a(outputStream);
                            httpURLConnection.disconnect();
                            if (responseCode == 200) {
                            }
                            String byteArrayOutputStream2 = byteArrayOutputStream.toString();
                            if (q.a().f12148a) {
                            }
                            if (responseCode != 200) {
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            inputStream = inputStream2;
                            inputStream2 = outputStream;
                            eb.a(inputStream2);
                            eb.a(inputStream);
                            if (httpURLConnection != null) {
                                try {
                                    httpURLConnection.disconnect();
                                } catch (Throwable unused) {
                                }
                            }
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        inputStream = null;
                    }
                } finally {
                    eb.a(gZIPOutputStream);
                }
            }
        } catch (Throwable th4) {
            th = th4;
            gZIPOutputStream = null;
        }
        a10 = dz.a(byteArrayOutputStream.toByteArray(), bytes);
        long elapsedRealtime2 = SystemClock.elapsedRealtime();
        try {
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setReadTimeout(30000);
            httpURLConnection.setConnectTimeout(30000);
            httpURLConnection.addRequestProperty("Content-Type", "application/octet-stream");
            httpURLConnection.addRequestProperty("appkey", str2);
            httpURLConnection.setFixedLengthStreamingMode(a10.length);
            httpURLConnection.setDoOutput(true);
            outputStream = httpURLConnection.getOutputStream();
            outputStream.write(a10);
            responseCode = httpURLConnection.getResponseCode();
            gZIPOutputStream = responseCode >= 400 ? httpURLConnection.getInputStream() : httpURLConnection.getErrorStream();
            byteArrayOutputStream.reset();
            if (gZIPOutputStream != null) {
                byte[] bArr = new byte[8192];
                while (true) {
                    int read = gZIPOutputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
            }
            eb.a(outputStream);
            try {
                httpURLConnection.disconnect();
            } catch (Throwable unused2) {
            }
            if (responseCode == 200) {
                byte[] a11 = dz.a(byteArrayOutputStream.toByteArray(), bytes);
                byteArrayOutputStream.reset();
                ee.a(a11, byteArrayOutputStream);
            }
            String byteArrayOutputStream22 = byteArrayOutputStream.toString();
            if (q.a().f12148a) {
                ce.a("Net", "req: ", str, "\n", jSONObject2);
                if (responseCode == 200) {
                    JSONObject jSONObject3 = new JSONObject(byteArrayOutputStream22);
                    jSONObject3.remove(com.umeng.analytics.pro.bd.f9976c);
                    jSONObject3.remove("clk");
                    jSONObject3.remove("al");
                    str3 = jSONObject3.toString();
                } else {
                    str3 = byteArrayOutputStream22;
                }
                ce.a("Net", "resp:\n", str3, "\nconsume:", Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime2));
            }
            if (responseCode != 200) {
                return new JSONObject(byteArrayOutputStream22);
            }
            throw new Exception("response code ".concat(String.valueOf(responseCode)));
        } catch (Throwable th5) {
            th = th5;
            inputStream = null;
            httpURLConnection = null;
        }
    }

    public static boolean a(int i10, ck ckVar, String str) {
        int i11;
        cq a10;
        HttpURLConnection httpURLConnection;
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        String str2 = "unknown";
        try {
            URL url = new URL(dy.a(str, ckVar));
            str2 = url.getHost();
            httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setConnectTimeout(30000);
            httpURLConnection.setReadTimeout(30000);
            i11 = httpURLConnection.getResponseCode();
        } catch (Throwable th) {
            th = th;
            i11 = -1;
        }
        try {
            if (i11 < 400) {
                eb.a(httpURLConnection.getInputStream());
            } else {
                eb.a(httpURLConnection.getErrorStream());
            }
            try {
                httpURLConnection.disconnect();
            } catch (Throwable unused) {
            }
            ce.a("Net", Integer.valueOf(i10), " host:".concat(String.valueOf(str2)), " code:", Integer.valueOf(i11), " consume:", Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime));
        } catch (Throwable th2) {
            th = th2;
            try {
                ce.a("Net", Integer.valueOf(i10), " host:".concat(String.valueOf(str2)), " error:", th.getMessage(), " consume:", Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime));
                if (i11 != 200) {
                    a10 = cr.a();
                    a10.a(ckVar, i10, i11, str2);
                }
                return false;
            } catch (Throwable th3) {
                if (i11 != 200) {
                    cr.a().a(ckVar, i10, i11, str2);
                }
                throw th3;
            }
        }
        if (i11 == 200) {
            if (i11 != 200) {
                cr.a().a(ckVar, i10, i11, str2);
            }
            return true;
        }
        if (i11 != 200) {
            a10 = cr.a();
            a10.a(ckVar, i10, i11, str2);
        }
        return false;
    }

    /* JADX WARN: Not initialized variable reg: 11, insn: 0x013c: MOVE (r4 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r11 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:66:0x013c */
    public static boolean a(String str) {
        boolean z10;
        int responseCode;
        boolean z11;
        boolean z12;
        df unused;
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        String str2 = "unknown";
        try {
            URL url = new URL(str);
            str2 = url.getHost();
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setConnectTimeout(10000);
            httpURLConnection.setReadTimeout(10000);
            httpURLConnection.setRequestProperty("Content-Type", "application/json; utf-8");
            httpURLConnection.setRequestProperty(HttpHeaders.ACCEPT, "application/json");
            httpURLConnection.setDoOutput(true);
            JSONObject jSONObject = new JSONObject();
            Context a10 = de.a();
            try {
                jSONObject.put("oaid", ca.c(a10));
                jSONObject.put("idfa", ca.a(a10));
            } catch (Throwable unused2) {
            }
            jSONObject.put("imei_md5", ca.f(a10));
            jSONObject.put("android_id", ca.b(a10));
            jSONObject.put("device_token", UMUtils.getDeviceToken(a10));
            jSONObject.put(com.umeng.analytics.pro.bt.al, UMUtils.getZid(a10));
            String jSONObject2 = jSONObject.toString();
            OutputStream outputStream = httpURLConnection.getOutputStream();
            try {
                outputStream.write(jSONObject2.getBytes(XML.CHARSET_UTF8));
                eb.a(outputStream);
                responseCode = httpURLConnection.getResponseCode();
                if (responseCode == 200) {
                    try {
                        InputStream inputStream = httpURLConnection.getInputStream();
                        try {
                            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                            byte[] bArr = new byte[512];
                            while (true) {
                                int read = inputStream.read(bArr);
                                if (read == -1) {
                                    break;
                                }
                                byteArrayOutputStream.write(bArr, 0, read);
                            }
                            byte[] byteArray = byteArrayOutputStream.toByteArray();
                            eb.a(byteArrayOutputStream);
                            String str3 = new String(byteArray);
                            ce.b("Net", "pre check host:", str2, " resp:\n", str3);
                            JSONObject optJSONObject = new JSONObject(str3).optJSONObject("data");
                            if (optJSONObject != null) {
                                z12 = optJSONObject.optBoolean("allow", true);
                                try {
                                    JSONArray optJSONArray = optJSONObject.optJSONArray("activity_deny");
                                    if (optJSONArray != null) {
                                        int length = optJSONArray.length();
                                        ArrayList arrayList = new ArrayList(length);
                                        for (int i10 = 0; i10 < length; i10++) {
                                            String optString = optJSONArray.optString(i10);
                                            if (!TextUtils.isEmpty(optString)) {
                                                try {
                                                    arrayList.add(Class.forName(optString));
                                                } catch (Throwable unused3) {
                                                    ce.b("Net", "pre check activity not found: ", optString);
                                                }
                                            }
                                        }
                                        unused = df.a.f11883a;
                                        dt.a().a(arrayList);
                                    }
                                } catch (Throwable th) {
                                    th = th;
                                    eb.a(inputStream);
                                    throw th;
                                }
                            } else {
                                z12 = true;
                            }
                            eb.a(inputStream);
                            z10 = z12;
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        z10 = z11;
                        ce.b("Net", "pre check host:".concat(String.valueOf(str2)), " error:", th.getMessage(), " consume:", Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime));
                        return z10;
                    }
                } else {
                    z10 = true;
                }
                try {
                    httpURLConnection.disconnect();
                } catch (Throwable unused4) {
                }
            } catch (Throwable th4) {
                eb.a(outputStream);
                throw th4;
            }
        } catch (Throwable th5) {
            th = th5;
            z10 = true;
        }
        try {
            ce.b("Net", "pre check host:".concat(String.valueOf(str2)), " code:", Integer.valueOf(responseCode), " consume:", Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime));
        } catch (Throwable th6) {
            th = th6;
            ce.b("Net", "pre check host:".concat(String.valueOf(str2)), " error:", th.getMessage(), " consume:", Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime));
            return z10;
        }
        return z10;
    }

    public static Bitmap a(Context context, String str) {
        HttpURLConnection httpURLConnection;
        InputStream inputStream;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        Bitmap bitmap = null;
        try {
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            try {
                httpURLConnection.setConnectTimeout(30000);
                httpURLConnection.setReadTimeout(30000);
                inputStream = httpURLConnection.getInputStream();
            } catch (Throwable th) {
                th = th;
                inputStream = null;
            }
        } catch (Throwable th2) {
            th = th2;
            httpURLConnection = null;
            inputStream = null;
        }
        try {
            Bitmap decodeStream = BitmapFactory.decodeStream(inputStream);
            if (decodeStream != null) {
                Point a10 = ed.a(context);
                int min = Math.min(a10.x, a10.y);
                if (decodeStream.getWidth() <= min || decodeStream.getHeight() <= 0) {
                    bitmap = decodeStream;
                } else {
                    Bitmap createScaledBitmap = Bitmap.createScaledBitmap(decodeStream, min, (decodeStream.getHeight() * min) / decodeStream.getWidth(), true);
                    decodeStream.recycle();
                    bitmap = createScaledBitmap;
                }
            }
            eb.a(inputStream);
            try {
                httpURLConnection.disconnect();
            } catch (Throwable unused) {
            }
            ce.b("Net", "image download consume:", Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime));
            return bitmap;
        } catch (Throwable th3) {
            th = th3;
            try {
                ce.d("Net", "image download error:", th.getMessage());
                eb.a(inputStream);
                if (httpURLConnection != null) {
                    try {
                        httpURLConnection.disconnect();
                    } catch (Throwable unused2) {
                    }
                }
                ce.b("Net", "image download consume:", Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime));
                return null;
            } catch (Throwable th4) {
                eb.a(inputStream);
                if (httpURLConnection != null) {
                    try {
                        httpURLConnection.disconnect();
                    } catch (Throwable unused3) {
                    }
                }
                ce.b("Net", "image download consume:", Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime));
                throw th4;
            }
        }
    }
}
