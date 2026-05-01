package org.repackage.com.vivo.identifier;

import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import com.hpplay.component.common.ParamsMap;
import com.hpplay.cybergarage.soap.SOAP;
import com.taobao.accs.common.Constants;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class IdentifierIdClient {
    private static int A = 13;
    private static IdentifierIdObserver B = null;
    private static IdentifierIdObserver C = null;
    private static IdentifierIdObserver D = null;
    private static IdentifierIdObserver E = null;
    private static HandlerThread F = null;
    private static Handler G = null;
    private static String H = null;
    private static String I = null;
    private static String J = null;
    private static String K = null;
    private static String L = null;
    private static String M = null;
    private static String N = null;
    private static volatile IdentifierIdClient O = null;
    private static volatile DataBaseOperation P = null;
    private static int R = 0;
    private static int S = 0;
    private static int T = 0;
    private static int U = 0;
    private static int V = 0;
    private static int W = 0;
    private static int X = 0;
    private static int Y = 0;
    private static int Z = 0;

    /* renamed from: a, reason: collision with root package name */
    public static final String f17940a = "persist.sys.identifierid";

    /* renamed from: aa, reason: collision with root package name */
    private static int f17941aa = 0;

    /* renamed from: ab, reason: collision with root package name */
    private static int f17942ab = 0;
    private static int ac = 0;

    /* renamed from: b, reason: collision with root package name */
    private static final String f17943b = "VMS_SDK_Client";

    /* renamed from: c, reason: collision with root package name */
    private static final String f17944c = "content://com.vivo.vms.IdProvider/IdentifierId";

    /* renamed from: d, reason: collision with root package name */
    private static final String f17945d = "persist.sys.identifierid.supported";

    /* renamed from: e, reason: collision with root package name */
    private static final String f17946e = "com.vivo.vms";

    /* renamed from: f, reason: collision with root package name */
    private static final String f17947f = "appid";

    /* renamed from: g, reason: collision with root package name */
    private static final String f17948g = "type";

    /* renamed from: h, reason: collision with root package name */
    private static final String f17949h = "OAID";

    /* renamed from: i, reason: collision with root package name */
    private static final String f17950i = "VAID";

    /* renamed from: j, reason: collision with root package name */
    private static final String f17951j = "OAIDSTATUS";

    /* renamed from: k, reason: collision with root package name */
    private static Object f17952k = new Object();

    /* renamed from: l, reason: collision with root package name */
    private static final int f17953l = 0;

    /* renamed from: m, reason: collision with root package name */
    private static final int f17954m = 1;

    /* renamed from: n, reason: collision with root package name */
    private static final int f17955n = 2;

    /* renamed from: o, reason: collision with root package name */
    private static final int f17956o = 3;

    /* renamed from: p, reason: collision with root package name */
    private static final int f17957p = 4;

    /* renamed from: q, reason: collision with root package name */
    private static final int f17958q = 5;

    /* renamed from: r, reason: collision with root package name */
    private static final int f17959r = 6;

    /* renamed from: s, reason: collision with root package name */
    private static final int f17960s = 7;

    /* renamed from: t, reason: collision with root package name */
    private static final int f17961t = 8;

    /* renamed from: u, reason: collision with root package name */
    private static final int f17962u = 9;

    /* renamed from: v, reason: collision with root package name */
    private static final int f17963v = 10;

    /* renamed from: w, reason: collision with root package name */
    private static final int f17964w = 11;

    /* renamed from: x, reason: collision with root package name */
    private static final int f17965x = 2000;

    /* renamed from: y, reason: collision with root package name */
    private static Context f17966y = null;

    /* renamed from: z, reason: collision with root package name */
    private static boolean f17967z = false;
    private final int Q;

    private IdentifierIdClient() {
        D();
        P = new DataBaseOperation(f17966y);
        this.Q = c(f17966y);
    }

    private void C() {
        Executors.newScheduledThreadPool(1).scheduleWithFixedDelay(new Runnable() { // from class: org.repackage.com.vivo.identifier.IdentifierIdClient.1
            @Override // java.lang.Runnable
            public void run() {
                if (IdentifierIdClient.R + IdentifierIdClient.S + IdentifierIdClient.X + IdentifierIdClient.f17941aa + IdentifierIdClient.T + IdentifierIdClient.U + IdentifierIdClient.Z + IdentifierIdClient.f17941aa + IdentifierIdClient.V + IdentifierIdClient.W + IdentifierIdClient.f17942ab + IdentifierIdClient.ac > 0) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("oaid", IdentifierIdClient.this.a(IdentifierIdClient.R, IdentifierIdClient.S, IdentifierIdClient.X, IdentifierIdClient.Y));
                    contentValues.put("vaid", IdentifierIdClient.this.a(IdentifierIdClient.T, IdentifierIdClient.U, IdentifierIdClient.Z, IdentifierIdClient.f17941aa));
                    contentValues.put("aaid", IdentifierIdClient.this.a(IdentifierIdClient.V, IdentifierIdClient.W, IdentifierIdClient.f17942ab, IdentifierIdClient.ac));
                    IdentifierIdClient.P.a(7, "vivo", new ContentValues[]{contentValues});
                    int unused = IdentifierIdClient.R = IdentifierIdClient.S = IdentifierIdClient.T = IdentifierIdClient.U = IdentifierIdClient.V = IdentifierIdClient.W = 0;
                    int unused2 = IdentifierIdClient.X = IdentifierIdClient.Y = IdentifierIdClient.Z = IdentifierIdClient.f17941aa = IdentifierIdClient.f17942ab = IdentifierIdClient.ac = 0;
                }
            }
        }, 600L, 600L, TimeUnit.SECONDS);
    }

    private static void D() {
        HandlerThread handlerThread = new HandlerThread("SqlWorkThread");
        F = handlerThread;
        handlerThread.start();
        G = new Handler(F.getLooper()) { // from class: org.repackage.com.vivo.identifier.IdentifierIdClient.2
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what != 11) {
                    Log.e(IdentifierIdClient.f17943b, "message type valid");
                    return;
                }
                int i10 = message.getData().getInt("type");
                try {
                    String a10 = IdentifierIdClient.P.a(i10, message.getData().getString("appid"));
                    if (i10 == 0) {
                        String unused = IdentifierIdClient.H = a10;
                        IdentifierIdClient.c(8, IdentifierIdClient.H);
                    } else if (i10 == 1) {
                        if (a10 != null) {
                            String unused2 = IdentifierIdClient.I = a10;
                        } else {
                            Log.e(IdentifierIdClient.f17943b, "get vaid failed");
                        }
                        IdentifierIdClient.c(9, IdentifierIdClient.I);
                    } else if (i10 == 2) {
                        if (a10 != null) {
                            String unused3 = IdentifierIdClient.J = a10;
                        } else {
                            Log.e(IdentifierIdClient.f17943b, "get aaid failed");
                        }
                        IdentifierIdClient.c(10, IdentifierIdClient.J);
                    } else if (i10 != 3) {
                        if (i10 == 4) {
                            String unused4 = IdentifierIdClient.L = a10;
                        } else if (i10 == 5) {
                            if (a10 != null) {
                                String unused5 = IdentifierIdClient.M = a10;
                            } else {
                                Log.e(IdentifierIdClient.f17943b, "get guid failed");
                            }
                        }
                    } else if (a10 != null) {
                        String unused6 = IdentifierIdClient.K = a10;
                    } else {
                        Log.e(IdentifierIdClient.f17943b, "get udid failed");
                    }
                } catch (Exception e10) {
                    Log.e(IdentifierIdClient.f17943b, "readException:" + e10.toString());
                }
                synchronized (IdentifierIdClient.f17952k) {
                    IdentifierIdClient.f17952k.notify();
                }
            }
        };
    }

    private static void E() {
        f17967z = "1".equals(a(f17945d, "0")) || "1".equals(a(f17940a, "0"));
    }

    public String g() {
        String str = J;
        if (str != null) {
            c(2, str);
            return J;
        }
        e(2, "vivo");
        if (D == null) {
            a(f17966y, 2, "vivo");
        }
        c(2, J);
        return J;
    }

    public String h() {
        String str = J;
        if (str != null) {
            c(2, str);
            return J;
        }
        d(2, "vivo");
        if (D == null) {
            a(f17966y, 2, "vivo");
        }
        c(2, J);
        return J;
    }

    public String i() {
        e(4, null);
        return L;
    }

    public String j() {
        String str = M;
        if (str != null) {
            return str;
        }
        e(5, "vivo");
        return M;
    }

    public String k() {
        String str = M;
        if (str != null) {
            return str;
        }
        d(5, "vivo");
        return M;
    }

    private static int c(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(f17946e, 0).versionCode;
        } catch (PackageManager.NameNotFoundException e10) {
            e10.printStackTrace();
            return 0;
        }
    }

    public String d() {
        String str = H;
        if (str != null) {
            c(0, str);
            return H;
        }
        d(0, null);
        if (B == null) {
            a(f17966y, 0, null);
        }
        c(0, H);
        return H;
    }

    public String e() {
        String str = I;
        if (str != null) {
            c(1, str);
            return I;
        }
        e(1, "vivo");
        if (C == null) {
            a(f17966y, 1, "vivo");
        }
        c(1, I);
        return I;
    }

    public String f() {
        String str = I;
        if (str != null) {
            c(1, str);
            return I;
        }
        d(1, "vivo");
        if (C == null) {
            a(f17966y, 1, "vivo");
        }
        c(1, I);
        return I;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(int i10, int i11, int i12, int i13) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(i10);
        stringBuffer.append(",");
        stringBuffer.append(i11);
        stringBuffer.append(";");
        stringBuffer.append(i12);
        stringBuffer.append(",");
        stringBuffer.append(i13);
        return stringBuffer.toString();
    }

    public static IdentifierIdClient b(Context context) {
        if (a()) {
            return a(context);
        }
        return null;
    }

    public static IdentifierIdClient a(Context context) {
        if (f17966y == null) {
            if (context == null) {
                return null;
            }
            Context applicationContext = context.getApplicationContext();
            if (applicationContext != null) {
                context = applicationContext;
            }
            f17966y = context;
        }
        if (O == null) {
            synchronized (IdentifierIdClient.class) {
                if (O == null) {
                    O = new IdentifierIdClient();
                    O.C();
                }
            }
        }
        return O;
    }

    public String b() {
        String str = K;
        if (str != null) {
            return str;
        }
        e(3, null);
        return K;
    }

    public String c() {
        String str = H;
        if (str != null) {
            c(0, str);
            return H;
        }
        e(0, null);
        if (B == null) {
            a(f17966y, 0, null);
        }
        c(0, H);
        return H;
    }

    public List b(List<String> list) {
        if (this.Q < A) {
            return null;
        }
        if (list != null && list.size() != 0) {
            try {
                ArrayList arrayList = new ArrayList();
                for (int i10 = 0; i10 < list.size(); i10++) {
                    String[] split = list.get(i10).split(SOAP.DELIM);
                    if (split.length == 2) {
                        arrayList.add(Boolean.valueOf(P.a(6, "vivo", split[0], split[1])));
                    }
                }
                return arrayList;
            } catch (Exception unused) {
                Log.e(f17943b, "delete OAIDBLACK failure");
                return null;
            }
        }
        Log.e(f17943b, "List is null when delete OAIDBLACK");
        return null;
    }

    private void d(int i10, String str) {
        a(i10, str);
    }

    private void e(int i10, String str) {
        synchronized (f17952k) {
            a(i10, str);
            long uptimeMillis = SystemClock.uptimeMillis();
            try {
                f17952k.wait(2000L);
            } catch (InterruptedException unused) {
                Log.e(f17943b, "queryId: lock error");
            }
            int i11 = ((SystemClock.uptimeMillis() - uptimeMillis) > 2000L ? 1 : ((SystemClock.uptimeMillis() - uptimeMillis) == 2000L ? 0 : -1));
        }
    }

    public static boolean a() {
        if (!f17967z) {
            E();
        }
        return f17967z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(int i10, String str) {
        if (i10 == 0) {
            if (str == null) {
                S++;
                return;
            } else {
                R++;
            }
        }
        if (i10 == 1) {
            if (str == null) {
                U++;
                return;
            } else {
                T++;
                return;
            }
        }
        if (i10 == 2) {
            if (str == null) {
                W++;
                return;
            } else {
                V++;
                return;
            }
        }
        switch (i10) {
            case 8:
                if (str != null) {
                    X++;
                    break;
                } else {
                    Y++;
                    break;
                }
            case 9:
                if (str != null) {
                    Z++;
                    break;
                } else {
                    f17941aa++;
                    break;
                }
            case 10:
                if (str != null) {
                    f17942ab++;
                    break;
                } else {
                    ac++;
                    break;
                }
        }
    }

    public boolean a(List<String> list) {
        if (this.Q < A) {
            return false;
        }
        if (list != null && list.size() != 0) {
            try {
                ContentValues[] contentValuesArr = new ContentValues[list.size()];
                String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(System.currentTimeMillis()));
                for (int i10 = 0; i10 < list.size(); i10++) {
                    ContentValues contentValues = new ContentValues();
                    String[] split = list.get(i10).split(SOAP.DELIM);
                    if (split.length != 2) {
                        return false;
                    }
                    String str = split[0];
                    String str2 = split[1];
                    contentValues.put(Constants.KEY_PACKAGE_NAME, str);
                    contentValues.put(ParamsMap.DeviceParams.KEY_UID, str2);
                    contentValues.put("value", format);
                    contentValuesArr[i10] = contentValues;
                }
                return P.a(6, "vivo", contentValuesArr);
            } catch (Exception unused) {
                Log.e(f17943b, "insert OAIDBLACK failure");
                return false;
            }
        }
        Log.e(f17943b, "List is null when insert OAIDBLACK");
        return false;
    }

    public void a(int i10, String str) {
        Message obtainMessage = G.obtainMessage();
        obtainMessage.what = 11;
        Bundle bundle = new Bundle();
        bundle.putInt("type", i10);
        if (i10 == 1 || i10 == 2 || i10 == 6) {
            bundle.putString("appid", str);
        }
        obtainMessage.setData(bundle);
        G.sendMessage(obtainMessage);
    }

    private static String a(String str, String str2) {
        try {
            try {
                Class<?> cls = Class.forName("android.os.SystemProperties");
                return (String) cls.getMethod("get", String.class, String.class).invoke(cls, str, "0");
            } catch (Exception e10) {
                Log.e(f17943b, "getProperty: invoke is error" + e10.getMessage());
                return str2;
            }
        } catch (Throwable unused) {
            return str2;
        }
    }

    private static synchronized void a(Context context, int i10, String str) {
        synchronized (IdentifierIdClient.class) {
            if (i10 != 0) {
                if (i10 != 1) {
                    if (i10 == 2) {
                        if (D == null) {
                            D = new IdentifierIdObserver(O, 2, str);
                            context.getContentResolver().registerContentObserver(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/" + context.getPackageName()), false, D);
                        }
                    }
                } else if (C == null) {
                    C = new IdentifierIdObserver(O, 1, str);
                    context.getContentResolver().registerContentObserver(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/VAID_" + str), false, C);
                }
            } else if (B == null) {
                B = new IdentifierIdObserver(O, 0, null);
                context.getContentResolver().registerContentObserver(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID"), true, B);
            }
        }
    }
}
