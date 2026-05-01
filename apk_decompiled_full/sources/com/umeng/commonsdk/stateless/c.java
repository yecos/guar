package com.umeng.commonsdk.stateless;

import android.content.Context;
import android.text.TextUtils;
import com.raizlabs.android.dbflow.sql.language.Operator;
import com.umeng.analytics.pro.bt;
import com.umeng.analytics.pro.by;
import com.umeng.analytics.pro.cc;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.statistics.SdkVersion;
import com.umeng.commonsdk.statistics.common.DataHelper;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.statistics.common.ULog;
import java.io.OutputStream;
import java.net.URL;
import java.security.SecureRandom;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLHandshakeException;
import org.apache.http.conn.ssl.SSLSocketFactory;

/* loaded from: classes3.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private String f11000a = "10.0.0.172";

    /* renamed from: b, reason: collision with root package name */
    private int f11001b = 80;

    /* renamed from: c, reason: collision with root package name */
    private Context f11002c;

    public c(Context context) {
        this.f11002c = context;
    }

    public void a() {
        String imprintProperty = UMEnvelopeBuild.imprintProperty(this.f11002c, "sl_domain_p", "");
        if (TextUtils.isEmpty(imprintProperty)) {
            return;
        }
        a.f10984h = DataHelper.assembleStatelessURL(imprintProperty);
    }

    public void b() {
        String imprintProperty = UMEnvelopeBuild.imprintProperty(this.f11002c, "sl_domain_p", "");
        String imprintProperty2 = UMEnvelopeBuild.imprintProperty(this.f11002c, "oversea_sl_domain_p", "");
        if (!TextUtils.isEmpty(imprintProperty)) {
            a.f10983g = DataHelper.assembleStatelessURL(imprintProperty);
        }
        if (!TextUtils.isEmpty(imprintProperty2)) {
            a.f10986j = DataHelper.assembleStatelessURL(imprintProperty2);
        }
        a.f10984h = a.f10986j;
        if (TextUtils.isEmpty(com.umeng.commonsdk.statistics.b.f11010b)) {
            return;
        }
        if (com.umeng.commonsdk.statistics.b.f11010b.startsWith("460") || com.umeng.commonsdk.statistics.b.f11010b.startsWith("461")) {
            a.f10984h = a.f10983g;
        }
    }

    public boolean a(byte[] bArr, String str, String str2, String str3) {
        String str4 = str2 + Operator.Operation.DIVISION + str;
        if (SdkVersion.SDK_TYPE == 1) {
            return a(bArr, str4, str3);
        }
        if (by.a().b()) {
            String replace = str4.replace("ulogs", "cnlogs");
            String c10 = cc.b().c();
            if (!TextUtils.isEmpty(c10)) {
                replace = by.a(c10, str);
            }
            boolean a10 = a(bArr, replace, str3);
            if (!a10) {
                String a11 = by.a().a(str);
                if (!TextUtils.isEmpty(a11) && !replace.equalsIgnoreCase(a11)) {
                    return a(bArr, a11, str3);
                }
            }
            return a10;
        }
        return a(bArr, str4, str3);
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0119, code lost:
    
        if (r5 == null) goto L41;
     */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0129 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:44:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0122 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean a(byte[] bArr, String str, String str2) {
        OutputStream outputStream;
        HttpsURLConnection httpsURLConnection;
        boolean z10 = false;
        if (bArr != null && !TextUtils.isEmpty(str)) {
            UMRTLog.i(UMRTLog.RTLOG_TAG, "[无状态] 上报url：" + str);
            HttpsURLConnection httpsURLConnection2 = null;
            r3 = null;
            r3 = null;
            OutputStream outputStream2 = null;
            try {
                try {
                    httpsURLConnection = (HttpsURLConnection) new URL(str).openConnection();
                } catch (Throwable unused) {
                }
            } catch (SSLHandshakeException e10) {
                e = e10;
                httpsURLConnection = null;
            } catch (Throwable th) {
                th = th;
                outputStream = null;
            }
            try {
                httpsURLConnection.setHostnameVerifier(SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
                SSLContext sSLContext = SSLContext.getInstance("TLS");
                sSLContext.init(null, null, new SecureRandom());
                httpsURLConnection.setSSLSocketFactory(sSLContext.getSocketFactory());
                httpsURLConnection.setRequestProperty("X-Umeng-UTC", String.valueOf(System.currentTimeMillis()));
                httpsURLConnection.setRequestProperty("Msg-Type", "envelope/json");
                httpsURLConnection.setRequestProperty("Content-Type", bt.aW + str2);
                httpsURLConnection.setRequestProperty("SM-IMP", "1");
                httpsURLConnection.setRequestProperty("User-Agent", DeviceConfig.getCustomAgt());
                httpsURLConnection.setConnectTimeout(30000);
                httpsURLConnection.setReadTimeout(30000);
                httpsURLConnection.setRequestMethod("POST");
                httpsURLConnection.setDoOutput(true);
                httpsURLConnection.setDoInput(true);
                httpsURLConnection.setUseCaches(false);
                outputStream2 = httpsURLConnection.getOutputStream();
                outputStream2.write(bArr);
                outputStream2.flush();
                httpsURLConnection.connect();
                if (httpsURLConnection.getResponseCode() == 200) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> send stateless message success : " + str);
                    z10 = true;
                }
                try {
                    outputStream2.close();
                } catch (Exception unused2) {
                }
            } catch (SSLHandshakeException e11) {
                e = e11;
                try {
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "SSLHandshakeException, Failed to send message.\n" + e);
                    if (outputStream2 != null) {
                        try {
                            outputStream2.close();
                        } catch (Exception unused3) {
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    outputStream = outputStream2;
                    httpsURLConnection2 = httpsURLConnection;
                    if (outputStream != null) {
                    }
                    if (httpsURLConnection2 == null) {
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                outputStream = outputStream2;
                httpsURLConnection2 = httpsURLConnection;
                try {
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "Exception,Failed to send message.\n" + th);
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (Exception unused4) {
                        }
                    }
                    if (httpsURLConnection2 != null) {
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> stateless: disconnect connection.");
                        httpsURLConnection2.disconnect();
                    }
                    return z10;
                } catch (Throwable th4) {
                    th = th4;
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (Exception unused5) {
                        }
                    }
                    if (httpsURLConnection2 == null) {
                        try {
                            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> stateless: disconnect connection.");
                            httpsURLConnection2.disconnect();
                            throw th;
                        } catch (Throwable unused6) {
                            throw th;
                        }
                    }
                    throw th;
                }
            }
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> stateless: disconnect connection.");
            httpsURLConnection.disconnect();
            return z10;
        }
        ULog.i("walle", "[stateless] sendMessage, envelopeByte == null || url is empty ");
        return false;
    }
}
