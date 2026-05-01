package com.umeng.message.proguard;

import android.os.SystemClock;
import android.text.TextUtils;
import com.hpplay.cybergarage.http.HTTP;
import com.umeng.message.common.UPLog;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.UnknownHostException;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class g {
    public static JSONObject a(JSONObject jSONObject, String str, String str2, boolean z10) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        URL url = new URL(str);
        try {
            JSONObject jSONObject2 = new JSONObject(a(jSONObject.toString(), (HttpURLConnection) url.openConnection(), str2));
            if (UPLog.isEnable() && z10) {
                UPLog.i("Net", "req:", url, "\n", jSONObject, "\nresp:\n", jSONObject2, "\nconsume:", Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime));
            }
            return jSONObject2;
        } catch (Throwable th) {
            if (UPLog.isEnable() && z10) {
                UPLog.i("Net", "req:", url, "\n", jSONObject, "\nresp:\n", null, "\nconsume:", Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime));
            }
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void b(JSONObject jSONObject, String str, String str2) {
        InputStream inputStream;
        HttpURLConnection httpURLConnection;
        String jSONObject2 = jSONObject.toString();
        byte[] bytes = str2.getBytes();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bq.a(jSONObject2.getBytes(), byteArrayOutputStream);
        byte[] a10 = bl.a(byteArrayOutputStream.toByteArray(), bytes);
        SystemClock.elapsedRealtime();
        InputStream inputStream2 = null;
        try {
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(str).openConnection();
            try {
                httpURLConnection2.setRequestMethod("POST");
                httpURLConnection2.setReadTimeout(60000);
                httpURLConnection2.setConnectTimeout(60000);
                httpURLConnection2.addRequestProperty("Content-Type", "application/octet-stream");
                httpURLConnection2.addRequestProperty("Connection", HTTP.CLOSE);
                httpURLConnection2.addRequestProperty("appkey", str2);
                httpURLConnection2.setFixedLengthStreamingMode(a10.length);
                httpURLConnection2.setDoOutput(true);
                OutputStream outputStream = httpURLConnection2.getOutputStream();
                try {
                    outputStream.write(a10);
                    int responseCode = httpURLConnection2.getResponseCode();
                    inputStream2 = responseCode < 400 ? httpURLConnection2.getInputStream() : httpURLConnection2.getErrorStream();
                    byteArrayOutputStream.reset();
                    if (inputStream2 != null) {
                        byte[] bArr = new byte[8192];
                        while (true) {
                            int read = inputStream2.read(bArr);
                            if (read == -1) {
                                break;
                            } else {
                                byteArrayOutputStream.write(bArr, 0, read);
                            }
                        }
                    }
                    f.a(outputStream);
                    f.a(inputStream2);
                    try {
                        httpURLConnection2.disconnect();
                    } catch (Throwable unused) {
                    }
                    if (responseCode != 200) {
                        throw new Exception("response code:".concat(String.valueOf(responseCode)));
                    }
                } catch (Throwable th) {
                    th = th;
                    httpURLConnection = httpURLConnection2;
                    inputStream = inputStream2;
                    inputStream2 = outputStream;
                    f.a(inputStream2);
                    f.a(inputStream);
                    if (httpURLConnection != null) {
                        try {
                            httpURLConnection.disconnect();
                        } catch (Throwable unused2) {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                httpURLConnection = httpURLConnection2;
                inputStream = null;
            }
        } catch (Throwable th3) {
            th = th3;
            inputStream = null;
            httpURLConnection = null;
        }
    }

    public static JSONObject a(JSONObject jSONObject, String str, String str2) {
        try {
            return a(jSONObject, str, str2, true);
        } catch (UnknownHostException unused) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            String host = new URL(str).getHost();
            String a10 = bh.a("174658", host);
            if (a10 == null) {
                return null;
            }
            URL url = new URL(str.replaceFirst(host, a10));
            String jSONObject2 = jSONObject.toString();
            try {
                final HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestProperty("Host", host);
                if (httpURLConnection instanceof HttpsURLConnection) {
                    ((HttpsURLConnection) httpURLConnection).setHostnameVerifier(new HostnameVerifier() { // from class: com.umeng.message.proguard.g.1
                        @Override // javax.net.ssl.HostnameVerifier
                        public final boolean verify(String str3, SSLSession sSLSession) {
                            String requestProperty = httpURLConnection.getRequestProperty("Host");
                            if (requestProperty == null) {
                                requestProperty = httpURLConnection.getURL().getHost();
                            }
                            return HttpsURLConnection.getDefaultHostnameVerifier().verify(requestProperty, sSLSession);
                        }
                    });
                }
                JSONObject jSONObject3 = new JSONObject(a(jSONObject2, httpURLConnection, str2));
                if (UPLog.isEnable()) {
                    UPLog.i("Net", "req:", url, "\n", jSONObject, "\nresp:\n", jSONObject3, "\nconsume:", Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime));
                }
                return jSONObject3;
            } catch (Throwable th) {
                if (UPLog.isEnable()) {
                    UPLog.i("Net", "req:", url, "\n", jSONObject, "\nresp:\n", null, "\nconsume:", Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime));
                }
                throw th;
            }
        }
    }

    private static String a(String str, HttpURLConnection httpURLConnection, String str2) {
        OutputStream outputStream;
        InputStream inputStream;
        byte[] bytes = str2.getBytes();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bq.a(str.getBytes(), byteArrayOutputStream);
        byte[] a10 = bl.a(byteArrayOutputStream.toByteArray(), bytes);
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setReadTimeout(30000);
        httpURLConnection.setConnectTimeout(30000);
        httpURLConnection.addRequestProperty("Content-Type", "application/octet-stream");
        httpURLConnection.addRequestProperty("Content-Encoding", "xgzip");
        httpURLConnection.addRequestProperty("Connection", HTTP.CLOSE);
        httpURLConnection.addRequestProperty("appkey", str2);
        httpURLConnection.setFixedLengthStreamingMode(a10.length);
        httpURLConnection.setDoOutput(true);
        try {
            outputStream = httpURLConnection.getOutputStream();
            try {
                outputStream.write(a10);
                f.a(outputStream);
                int responseCode = httpURLConnection.getResponseCode();
                if (responseCode < 400) {
                    inputStream = httpURLConnection.getInputStream();
                } else {
                    inputStream = httpURLConnection.getErrorStream();
                }
                byteArrayOutputStream.reset();
                if (inputStream != null) {
                    byte[] bArr = new byte[8192];
                    while (true) {
                        try {
                            int read = inputStream.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            byteArrayOutputStream.write(bArr, 0, read);
                        } finally {
                            f.a(inputStream);
                        }
                    }
                }
                try {
                    httpURLConnection.disconnect();
                } catch (Throwable unused) {
                }
                if (responseCode == 200 && TextUtils.equals("xgzip", httpURLConnection.getHeaderField("Content-Encoding"))) {
                    byte[] a11 = bl.a(byteArrayOutputStream.toByteArray(), bytes);
                    byteArrayOutputStream.reset();
                    bq.b(a11, byteArrayOutputStream);
                }
                String byteArrayOutputStream2 = byteArrayOutputStream.toString();
                if (responseCode == 200) {
                    return byteArrayOutputStream2;
                }
                throw new IOException("code:" + responseCode + "msg:" + byteArrayOutputStream2);
            } catch (Throwable th) {
                th = th;
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            outputStream = null;
        }
    }

    public static JSONObject a(JSONObject jSONObject, String str, String str2, File file) {
        Throwable th;
        InputStream inputStream;
        OutputStream outputStream;
        HttpURLConnection httpURLConnection;
        OutputStream outputStream2;
        byte[] bArr;
        int responseCode;
        InputStream errorStream;
        InputStream inputStream2;
        String jSONObject2 = jSONObject.toString();
        byte[] bytes = str2.getBytes();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bq.a(jSONObject2.getBytes(), byteArrayOutputStream);
        byte[] a10 = bl.a(byteArrayOutputStream.toByteArray(), bytes);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        byte[] bytes2 = "--".getBytes();
        byte[] bytes3 = "\r\n".getBytes();
        try {
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            try {
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setReadTimeout(60000);
                httpURLConnection.setConnectTimeout(60000);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.addRequestProperty("Content-Type", "multipart/form-data;boundary=".concat("----WebKitFormBoundary7MA4YWxkTrZu0gW"));
                httpURLConnection.addRequestProperty("appkey", str2);
                httpURLConnection.addRequestProperty("Connection", HTTP.CLOSE);
                httpURLConnection.setDoOutput(true);
                outputStream2 = httpURLConnection.getOutputStream();
                try {
                    outputStream2.write(bytes2);
                    outputStream2.write("----WebKitFormBoundary7MA4YWxkTrZu0gW".getBytes());
                    outputStream2.write(bytes3);
                    outputStream2.write("Content-Disposition: form-data; name=\"msg\"".getBytes());
                    outputStream2.write(bytes3);
                    outputStream2.write(bytes3);
                    outputStream2.write(bf.b(a10));
                    outputStream2.write(bytes3);
                    outputStream2.write(bytes2);
                    outputStream2.write("----WebKitFormBoundary7MA4YWxkTrZu0gW".getBytes());
                    outputStream2.write(bytes3);
                    outputStream2.write(("Content-Disposition: form-data; name=\"file\"; filename=\"" + file.getName() + "\"").getBytes());
                    outputStream2.write(bytes3);
                    outputStream2.write("Content-Type: application/octet-stream".getBytes());
                    outputStream2.write(bytes3);
                    outputStream2.write(bytes3);
                    FileInputStream fileInputStream = new FileInputStream(file);
                    bArr = new byte[8192];
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        outputStream2.write(bArr, 0, read);
                    }
                    fileInputStream.close();
                    outputStream2.write(bytes3);
                    outputStream2.write(bytes2);
                    outputStream2.write("----WebKitFormBoundary7MA4YWxkTrZu0gW".getBytes());
                    outputStream2.write(bytes2);
                    outputStream2.write(bytes3);
                    responseCode = httpURLConnection.getResponseCode();
                    if (responseCode < 400) {
                        errorStream = httpURLConnection.getInputStream();
                    } else {
                        errorStream = httpURLConnection.getErrorStream();
                    }
                    inputStream2 = errorStream;
                } catch (Throwable th2) {
                    th = th2;
                    outputStream = outputStream2;
                    inputStream = null;
                }
            } catch (Throwable th3) {
                th = th3;
                inputStream = null;
                outputStream = null;
            }
        } catch (Throwable th4) {
            th = th4;
            inputStream = null;
            outputStream = null;
            httpURLConnection = null;
        }
        try {
            byteArrayOutputStream.reset();
            if (inputStream2 != null) {
                while (true) {
                    int read2 = inputStream2.read(bArr);
                    if (read2 == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read2);
                }
            }
            f.a(outputStream2);
            f.a(inputStream2);
            try {
                httpURLConnection.disconnect();
            } catch (Throwable unused) {
            }
            if (responseCode == 200 && TextUtils.equals("xgzip", httpURLConnection.getHeaderField("Content-Encoding"))) {
                byte[] a11 = bl.a(byteArrayOutputStream.toByteArray(), bytes);
                byteArrayOutputStream.reset();
                bq.b(a11, byteArrayOutputStream);
            }
            String byteArrayOutputStream2 = byteArrayOutputStream.toString();
            if (UPLog.isEnable()) {
                UPLog.i("Net", "req:", str, "\n", jSONObject2, "\nresp:\n", byteArrayOutputStream2, "\nconsume:", Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime));
            }
            if (responseCode == 200) {
                return new JSONObject(byteArrayOutputStream2);
            }
            throw new Exception("response code:".concat(String.valueOf(responseCode)));
        } catch (Throwable th5) {
            th = th5;
            inputStream = inputStream2;
            outputStream = outputStream2;
            f.a(outputStream);
            f.a(inputStream);
            if (httpURLConnection != null) {
                try {
                    httpURLConnection.disconnect();
                } catch (Throwable unused2) {
                }
            }
            throw th;
        }
    }
}
