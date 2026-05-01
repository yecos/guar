package com.umeng.message.proguard;

import android.app.Application;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.Process;
import com.hpplay.cybergarage.soap.SOAP;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.utils.UMUtils;
import com.umeng.message.MessageSharedPrefs;
import com.umeng.message.MsgConstant;
import com.umeng.message.common.UPLog;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.TimeZone;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class p {

    /* renamed from: a, reason: collision with root package name */
    Boolean f12127a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f12128b;

    /* renamed from: c, reason: collision with root package name */
    private Handler f12129c;

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        final String f12130a;

        /* renamed from: b, reason: collision with root package name */
        final String f12131b;

        /* renamed from: c, reason: collision with root package name */
        final long f12132c;

        /* renamed from: d, reason: collision with root package name */
        final int f12133d;

        /* renamed from: e, reason: collision with root package name */
        final int f12134e;

        /* renamed from: f, reason: collision with root package name */
        final long f12135f;

        public a(long j10, int i10, long j11, int i11, String str, String str2) {
            this.f12133d = i11;
            this.f12130a = str;
            this.f12131b = str2;
            this.f12132c = j10;
            this.f12134e = i10;
            this.f12135f = j11;
        }
    }

    public class c implements Handler.Callback {

        /* renamed from: b, reason: collision with root package name */
        private long f12141b = 0;

        /* renamed from: c, reason: collision with root package name */
        private PrintWriter f12142c;

        /* renamed from: d, reason: collision with root package name */
        private final DateFormat f12143d;

        /* renamed from: e, reason: collision with root package name */
        private final DateFormat f12144e;

        /* renamed from: f, reason: collision with root package name */
        private final File f12145f;

        /* renamed from: g, reason: collision with root package name */
        private String f12146g;

        public c() {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd", Locale.getDefault());
            this.f12143d = simpleDateFormat;
            simpleDateFormat.setTimeZone(TimeZone.getDefault());
            SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("HH:mm:ss.SSS", Locale.getDefault());
            this.f12144e = simpleDateFormat2;
            simpleDateFormat2.setTimeZone(TimeZone.getDefault());
            Application a10 = y.a();
            this.f12145f = new File(a10.getFilesDir(), ".upush_log");
            String a11 = f.a(a10);
            this.f12146g = a11;
            int lastIndexOf = a11.lastIndexOf(SOAP.DELIM);
            if (lastIndexOf < 0) {
                this.f12146g = "";
                return;
            }
            this.f12146g = this.f12146g.substring(lastIndexOf + 1) + "_";
        }

        private void a() {
            PrintWriter printWriter = this.f12142c;
            if (printWriter != null) {
                try {
                    printWriter.close();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            this.f12142c = null;
        }

        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message message) {
            int i10;
            try {
                i10 = message.what;
            } catch (Throwable th) {
                UPLog.d("Log", UPLog.getStackTrace(th));
            }
            if (i10 != 1) {
                if (i10 != 2) {
                    return true;
                }
                a();
                long currentTimeMillis = (System.currentTimeMillis() / 86400000) * 86400000;
                if (Math.abs(currentTimeMillis - this.f12141b) > 86400000) {
                    this.f12141b = currentTimeMillis;
                    File[] listFiles = this.f12145f.listFiles();
                    if (listFiles != null) {
                        for (File file : listFiles) {
                            long lastModified = file.lastModified() / 86400000;
                            Long.signum(lastModified);
                            if (Math.abs(currentTimeMillis - (lastModified * 86400000)) > 86400000) {
                                file.delete();
                            }
                        }
                    }
                }
                return true;
            }
            try {
                if (!this.f12145f.exists()) {
                    this.f12145f.mkdirs();
                }
                a aVar = (a) message.obj;
                String format = String.format("%s%s", this.f12146g, this.f12143d.format(Long.valueOf(aVar.f12132c)));
                int i11 = aVar.f12133d;
                String format2 = String.format("%s %s-%s %s %s %s", this.f12144e.format(Long.valueOf(aVar.f12132c)), Integer.valueOf(aVar.f12134e), Long.valueOf(aVar.f12135f), i11 == 3 ? "D" : i11 == 4 ? "I" : i11 == 5 ? "W" : i11 == 6 ? "E" : "U", aVar.f12130a, aVar.f12131b);
                File file2 = new File(this.f12145f, format + ".log");
                if (file2.exists() && file2.length() + format2.length() > com.hpplay.logwriter.b.f7378a) {
                    File file3 = new File(this.f12145f, format + ".bak");
                    if (file3.exists()) {
                        file3.delete();
                    }
                    file2.renameTo(file3);
                    file2.delete();
                }
                if (!file2.exists()) {
                    a();
                }
                if (this.f12142c == null) {
                    this.f12142c = new PrintWriter(new FileWriter(file2, true));
                }
                this.f12142c.println(format2);
                this.f12142c.flush();
                p.this.b().removeMessages(2);
                p.this.b().sendEmptyMessageDelayed(2, 5000L);
            } catch (Throwable th2) {
                UPLog.d("Log", UPLog.getStackTrace(th2));
                a();
            }
            return true;
        }
    }

    public final boolean a() {
        if (!f.f12084b) {
            return false;
        }
        if (this.f12127a == null) {
            this.f12127a = Boolean.valueOf(MessageSharedPrefs.getInstance(y.a()).m());
        }
        return this.f12127a.booleanValue();
    }

    public final Handler b() {
        Handler handler;
        Handler handler2 = this.f12129c;
        if (handler2 != null) {
            return handler2;
        }
        synchronized (this) {
            if (this.f12129c == null) {
                try {
                    HandlerThread handlerThread = new HandlerThread("upush_log", 10);
                    handlerThread.start();
                    this.f12129c = new Handler(handlerThread.getLooper(), new c());
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            handler = this.f12129c;
        }
        return handler;
    }

    public final void a(int i10, String str, String str2) {
        Handler b10;
        if (i10 < 4 || str2 == null || (b10 = b()) == null) {
            return;
        }
        b10.obtainMessage(1, new a(System.currentTimeMillis(), Process.myPid(), Thread.currentThread().getId(), i10, str, str2)).sendToTarget();
    }

    public static class b {
        public static JSONObject a(String str, String str2, String str3) {
            String str4;
            try {
                Application a10 = y.a();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("ts", System.currentTimeMillis());
                jSONObject.put("appkey", str);
                jSONObject.put("device_token", str2);
                jSONObject.put("android_id", str3);
                jSONObject.put("utdid", d.o(a10));
                jSONObject.put(com.umeng.analytics.pro.bt.f10046g, d.k(a10));
                try {
                    str4 = UMUtils.getZid(a10);
                    try {
                        jSONObject.put("oaid", DeviceConfig.getOaid(a10));
                    } catch (Throwable unused) {
                    }
                } catch (Throwable unused2) {
                    str4 = null;
                }
                jSONObject.put(com.umeng.analytics.pro.bt.al, str4);
                jSONObject.put("sdk_v", MsgConstant.SDK_VERSION);
                return g.a(jSONObject, "https://offmsg.umeng.com/log/switch", str, true);
            } catch (Throwable th) {
                UPLog.i("Log", UPLog.getStackTrace(th));
                return null;
            }
        }

        public final void a(File file, File file2) {
            File[] listFiles;
            if (!file.exists() || (listFiles = file.listFiles(new FileFilter() { // from class: com.umeng.message.proguard.p.b.2
                @Override // java.io.FileFilter
                public final boolean accept(File file3) {
                    if (file3.isDirectory() || file3.length() > com.hpplay.logwriter.b.f7378a) {
                        return false;
                    }
                    String name = file3.getName();
                    return name.endsWith(".log") || name.endsWith(".bak");
                }
            })) == null || listFiles.length == 0) {
                return;
            }
            if (listFiles.length > 8) {
                File[] fileArr = new File[8];
                System.arraycopy(listFiles, 0, fileArr, 0, 8);
                listFiles = fileArr;
            }
            ZipOutputStream zipOutputStream = null;
            try {
                ZipOutputStream zipOutputStream2 = new ZipOutputStream(new FileOutputStream(file2));
                try {
                    for (File file3 : listFiles) {
                        a(file3, zipOutputStream2);
                        file3.delete();
                    }
                    zipOutputStream2.finish();
                    f.a(zipOutputStream2);
                } catch (Throwable th) {
                    th = th;
                    zipOutputStream = zipOutputStream2;
                    try {
                        UPLog.i("Log", UPLog.getStackTrace(th));
                    } finally {
                        f.a(zipOutputStream);
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }

        private static void a(File file, ZipOutputStream zipOutputStream) {
            if (!file.exists() || file.length() < 256) {
                return;
            }
            FileInputStream fileInputStream = null;
            try {
                FileInputStream fileInputStream2 = new FileInputStream(file);
                try {
                    zipOutputStream.putNextEntry(new ZipEntry(file.getName()));
                    byte[] bArr = new byte[8192];
                    while (true) {
                        int read = fileInputStream2.read(bArr);
                        if (read != -1) {
                            zipOutputStream.write(bArr, 0, read);
                        } else {
                            zipOutputStream.closeEntry();
                            f.a(fileInputStream2);
                            return;
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    fileInputStream = fileInputStream2;
                    try {
                        UPLog.i("Log", UPLog.getStackTrace(th));
                    } finally {
                        f.a(fileInputStream);
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }
}
