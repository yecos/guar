package com.uc.crashsdk;

import android.os.Bundle;
import android.webkit.ValueCallback;
import com.uc.crashsdk.export.ICrashClient;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    private static ICrashClient f9688a = null;

    /* renamed from: b, reason: collision with root package name */
    private static int f9689b = 3;

    /* renamed from: c, reason: collision with root package name */
    private static volatile List<ValueCallback<Bundle>> f9690c;

    /* renamed from: d, reason: collision with root package name */
    private static volatile List<ValueCallback<Bundle>> f9691d;

    /* renamed from: e, reason: collision with root package name */
    private static volatile List<ValueCallback<Bundle>> f9692e;

    /* renamed from: f, reason: collision with root package name */
    private static volatile List<ValueCallback<Bundle>> f9693f;

    /* renamed from: g, reason: collision with root package name */
    private static final Object f9694g = new Object();

    public static void a(ICrashClient iCrashClient) {
        f9688a = iCrashClient;
    }

    public static boolean b(ValueCallback<Bundle> valueCallback) {
        if (f9691d == null) {
            synchronized (f9694g) {
                if (f9691d == null) {
                    f9691d = new ArrayList();
                }
            }
        }
        synchronized (f9691d) {
            if (f9691d.size() >= f9689b) {
                return false;
            }
            f9691d.add(valueCallback);
            return true;
        }
    }

    public static boolean c(ValueCallback<Bundle> valueCallback) {
        if (f9692e == null) {
            synchronized (f9694g) {
                if (f9692e == null) {
                    f9692e = new ArrayList();
                }
            }
        }
        synchronized (f9692e) {
            if (f9692e.size() >= f9689b) {
                return false;
            }
            f9692e.add(valueCallback);
            return true;
        }
    }

    public static boolean d(ValueCallback<Bundle> valueCallback) {
        if (f9693f == null) {
            synchronized (f9694g) {
                if (f9693f == null) {
                    f9693f = new ArrayList();
                }
            }
        }
        synchronized (f9693f) {
            if (f9693f.size() >= f9689b) {
                return false;
            }
            f9693f.add(valueCallback);
            return true;
        }
    }

    public static void a(String str, String str2, String str3) {
        if (com.uc.crashsdk.a.g.a(str)) {
            com.uc.crashsdk.a.a.a("crashsdk", "onLogGenerated file name is null!", null);
            return;
        }
        boolean equals = e.h().equals(str2);
        if (f9688a != null) {
            File file = new File(str);
            try {
                if (equals) {
                    f9688a.onLogGenerated(file, str3);
                } else {
                    f9688a.onClientProcessLogGenerated(str2, file, str3);
                }
            } catch (Throwable th) {
                com.uc.crashsdk.a.g.a(th);
            }
        }
        List<ValueCallback<Bundle>> list = f9690c;
        if (!equals) {
            list = f9691d;
        }
        if (list != null) {
            synchronized (list) {
                for (ValueCallback<Bundle> valueCallback : list) {
                    try {
                        Bundle bundle = new Bundle();
                        bundle.putString("filePathName", str);
                        if (!equals) {
                            bundle.putString("processName", str2);
                        }
                        bundle.putString("logType", str3);
                        valueCallback.onReceiveValue(bundle);
                    } catch (Throwable th2) {
                        com.uc.crashsdk.a.g.a(th2);
                    }
                }
            }
        }
    }

    public static File a(File file) {
        ICrashClient iCrashClient = f9688a;
        if (iCrashClient != null) {
            try {
                return iCrashClient.onBeforeUploadLog(file);
            } catch (Throwable th) {
                com.uc.crashsdk.a.g.a(th);
            }
        }
        return file;
    }

    public static void a(boolean z10) {
        ICrashClient iCrashClient = f9688a;
        if (iCrashClient != null) {
            try {
                iCrashClient.onCrashRestarting(z10);
            } catch (Throwable th) {
                com.uc.crashsdk.a.g.a(th);
            }
        }
        if (f9692e != null) {
            synchronized (f9692e) {
                for (ValueCallback<Bundle> valueCallback : f9692e) {
                    try {
                        Bundle bundle = new Bundle();
                        bundle.putBoolean("isJava", z10);
                        valueCallback.onReceiveValue(bundle);
                    } catch (Throwable th2) {
                        com.uc.crashsdk.a.g.a(th2);
                    }
                }
            }
        }
    }

    public static void a(String str, int i10, int i11) {
        ICrashClient iCrashClient = f9688a;
        if (iCrashClient != null) {
            iCrashClient.onAddCrashStats(str, i10, i11);
        }
        if (f9693f != null) {
            synchronized (f9693f) {
                for (ValueCallback<Bundle> valueCallback : f9693f) {
                    try {
                        Bundle bundle = new Bundle();
                        bundle.putString("processName", str);
                        bundle.putInt("key", i10);
                        bundle.putInt("count", i11);
                        valueCallback.onReceiveValue(bundle);
                    } catch (Throwable th) {
                        com.uc.crashsdk.a.g.a(th);
                    }
                }
            }
        }
    }

    public static String a(String str, boolean z10) {
        ICrashClient iCrashClient = f9688a;
        return iCrashClient != null ? iCrashClient.onGetCallbackInfo(str, z10) : "";
    }

    public static boolean a(ValueCallback<Bundle> valueCallback) {
        if (f9690c == null) {
            synchronized (f9694g) {
                if (f9690c == null) {
                    f9690c = new ArrayList();
                }
            }
        }
        synchronized (f9690c) {
            if (f9690c.size() >= f9689b) {
                return false;
            }
            f9690c.add(valueCallback);
            return true;
        }
    }
}
