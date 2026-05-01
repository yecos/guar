package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.analytics.pro.bd;
import com.umeng.analytics.pro.bt;
import com.umeng.analytics.pro.ck;
import com.umeng.analytics.pro.cq;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
import com.umeng.commonsdk.statistics.common.DataHelper;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import com.umeng.commonsdk.statistics.common.ULog;
import com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback;
import com.umeng.commonsdk.statistics.internal.UMImprintPreProcessCallback;
import com.umeng.commonsdk.utils.FileLockCallback;
import com.umeng.commonsdk.utils.FileLockUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: classes3.dex */
public class ImprintHandler implements FileLockCallback {

    /* renamed from: a, reason: collision with root package name */
    private static final String f11050a = "ImprintHandler";

    /* renamed from: k, reason: collision with root package name */
    private static Context f11057k = null;

    /* renamed from: l, reason: collision with root package name */
    private static FileLockUtil f11058l = null;

    /* renamed from: m, reason: collision with root package name */
    private static final int f11059m = 0;

    /* renamed from: n, reason: collision with root package name */
    private static final int f11060n = 1;

    /* renamed from: e, reason: collision with root package name */
    private com.umeng.commonsdk.statistics.internal.d f11063e;

    /* renamed from: h, reason: collision with root package name */
    private a f11064h = new a();

    /* renamed from: i, reason: collision with root package name */
    private com.umeng.commonsdk.statistics.proto.d f11065i = null;

    /* renamed from: b, reason: collision with root package name */
    private static Object f11051b = new Object();

    /* renamed from: c, reason: collision with root package name */
    private static final String f11052c = bd.b().b(bd.f9976c);

    /* renamed from: d, reason: collision with root package name */
    private static final byte[] f11053d = "pbl0".getBytes();

    /* renamed from: f, reason: collision with root package name */
    private static Map<String, ArrayList<UMImprintChangeCallback>> f11054f = new HashMap();

    /* renamed from: g, reason: collision with root package name */
    private static Object f11055g = new Object();

    /* renamed from: j, reason: collision with root package name */
    private static ImprintHandler f11056j = null;

    /* renamed from: o, reason: collision with root package name */
    private static Map<String, UMImprintPreProcessCallback> f11061o = new HashMap();

    /* renamed from: p, reason: collision with root package name */
    private static Object f11062p = new Object();

    private ImprintHandler(Context context) {
        f11057k = context.getApplicationContext();
    }

    private static void a(String str, UMImprintChangeCallback uMImprintChangeCallback) {
        synchronized (f11055g) {
            try {
                int i10 = 0;
                if (f11054f.containsKey(str)) {
                    ArrayList<UMImprintChangeCallback> arrayList = f11054f.get(str);
                    int size = arrayList.size();
                    ULog.i("--->>> addCallback: before add: callbacks size is: " + size);
                    while (i10 < size) {
                        if (uMImprintChangeCallback == arrayList.get(i10)) {
                            ULog.i("--->>> addCallback: callback has exist, just exit");
                            return;
                        }
                        i10++;
                    }
                    arrayList.add(uMImprintChangeCallback);
                    ULog.i("--->>> addCallback: after add: callbacks size is: " + arrayList.size());
                } else {
                    ArrayList<UMImprintChangeCallback> arrayList2 = new ArrayList<>();
                    int size2 = arrayList2.size();
                    ULog.i("--->>> addCallback: before add: callbacks size is: " + size2);
                    while (i10 < size2) {
                        if (uMImprintChangeCallback == arrayList2.get(i10)) {
                            ULog.i("--->>> addCallback: callback has exist, just exit");
                            return;
                        }
                        i10++;
                    }
                    arrayList2.add(uMImprintChangeCallback);
                    ULog.i("--->>> addCallback: after add: callbacks size is: " + arrayList2.size());
                    f11054f.put(str, arrayList2);
                }
            } catch (Throwable th) {
                UMCrashManager.reportCrash(f11057k, th);
            }
        }
    }

    private static void b(String str, UMImprintChangeCallback uMImprintChangeCallback) {
        if (TextUtils.isEmpty(str) || uMImprintChangeCallback == null) {
            return;
        }
        synchronized (f11055g) {
            try {
                if (f11054f.containsKey(str)) {
                    ArrayList<UMImprintChangeCallback> arrayList = f11054f.get(str);
                    if (arrayList.size() > 0) {
                        int size = arrayList.size();
                        ULog.i("--->>> removeCallback: before remove: callbacks size is: " + size);
                        int i10 = 0;
                        while (true) {
                            if (i10 >= size) {
                                break;
                            }
                            if (uMImprintChangeCallback == arrayList.get(i10)) {
                                ULog.i("--->>> removeCallback: remove index " + i10);
                                arrayList.remove(i10);
                                break;
                            }
                            i10++;
                        }
                        ULog.i("--->>> removeCallback: after remove: callbacks size is: " + arrayList.size());
                        if (arrayList.size() == 0) {
                            ULog.i("--->>> removeCallback: remove key from map: key = " + str);
                            f11054f.remove(str);
                        }
                    }
                }
            } finally {
            }
        }
    }

    private boolean c(com.umeng.commonsdk.statistics.proto.d dVar) {
        if (!dVar.i().equals(a(dVar))) {
            return false;
        }
        for (com.umeng.commonsdk.statistics.proto.e eVar : dVar.c().values()) {
            String h10 = eVar.h();
            if (!TextUtils.isEmpty(h10)) {
                byte[] reverseHexString = DataHelper.reverseHexString(h10);
                byte[] a10 = a(eVar);
                for (int i10 = 0; i10 < 4; i10++) {
                    if (reverseHexString[i10] != a10[i10]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private com.umeng.commonsdk.statistics.proto.d d(com.umeng.commonsdk.statistics.proto.d dVar) {
        Map<String, com.umeng.commonsdk.statistics.proto.e> c10 = dVar.c();
        if (c10.containsKey(bt.f10045f)) {
            c10.remove(bt.f10045f);
            this.f11064h.a(bt.f10045f);
            dVar.a(dVar.f());
            dVar.a(a(dVar));
        }
        return dVar;
    }

    private com.umeng.commonsdk.statistics.proto.d e(com.umeng.commonsdk.statistics.proto.d dVar) {
        ArrayList<UMImprintChangeCallback> arrayList;
        boolean z10;
        ArrayList<UMImprintChangeCallback> arrayList2;
        UMImprintPreProcessCallback uMImprintPreProcessCallback;
        Map<String, com.umeng.commonsdk.statistics.proto.e> c10 = dVar.c();
        ArrayList<String> arrayList3 = new ArrayList(c10.size() / 2);
        Iterator<Map.Entry<String, com.umeng.commonsdk.statistics.proto.e>> it = c10.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Map.Entry<String, com.umeng.commonsdk.statistics.proto.e> next = it.next();
            if (next.getValue().d()) {
                String key = next.getKey();
                String str = next.getValue().f11216a;
                synchronized (f11062p) {
                    z10 = !TextUtils.isEmpty(key) && f11061o.containsKey(key) && (uMImprintPreProcessCallback = f11061o.get(key)) != null && uMImprintPreProcessCallback.onPreProcessImprintKey(key, str);
                }
                if (z10) {
                    arrayList3.add(key);
                }
                synchronized (f11055g) {
                    if (!TextUtils.isEmpty(key) && f11054f.containsKey(key) && (arrayList2 = f11054f.get(key)) != null) {
                        for (int i10 = 0; i10 < arrayList2.size(); i10++) {
                            arrayList2.get(i10).onImprintValueChanged(key, str);
                        }
                    }
                }
            } else {
                arrayList3.add(next.getKey());
            }
        }
        for (String str2 : arrayList3) {
            synchronized (f11055g) {
                if (!TextUtils.isEmpty(str2) && f11054f.containsKey(str2) && (arrayList = f11054f.get(str2)) != null) {
                    for (int i11 = 0; i11 < arrayList.size(); i11++) {
                        arrayList.get(i11).onImprintValueChanged(str2, null);
                    }
                }
            }
            c10.remove(str2);
        }
        return dVar;
    }

    public static synchronized ImprintHandler getImprintService(Context context) {
        ImprintHandler imprintHandler;
        synchronized (ImprintHandler.class) {
            if (f11056j == null) {
                f11056j = new ImprintHandler(context);
                f11058l = new FileLockUtil();
                f11058l.doFileOperateion(new File(f11057k.getFilesDir(), f11052c), f11056j, 0);
            }
            imprintHandler = f11056j;
        }
        return imprintHandler;
    }

    @Override // com.umeng.commonsdk.utils.FileLockCallback
    public boolean onFileLock(String str) {
        return false;
    }

    public void registImprintCallback(String str, UMImprintChangeCallback uMImprintChangeCallback) {
        if (TextUtils.isEmpty(str) || uMImprintChangeCallback == null) {
            return;
        }
        a(str, uMImprintChangeCallback);
    }

    public void registPreProcessCallback(String str, UMImprintPreProcessCallback uMImprintPreProcessCallback) {
        if (TextUtils.isEmpty(str) || uMImprintPreProcessCallback == null) {
            return;
        }
        synchronized (f11062p) {
            try {
                if (f11061o.containsKey(str)) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> key : " + str + " PreProcesser has registed!");
                } else {
                    f11061o.put(str, uMImprintPreProcessCallback);
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> registPreProcessCallback: key : " + str + " regist success.");
                }
            } finally {
            }
        }
    }

    public void unregistImprintCallback(String str, UMImprintChangeCallback uMImprintChangeCallback) {
        if (TextUtils.isEmpty(str) || uMImprintChangeCallback == null) {
            return;
        }
        b(str, uMImprintChangeCallback);
    }

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private Map<String, String> f11066a = new HashMap();

        public a() {
        }

        private synchronized void b(com.umeng.commonsdk.statistics.proto.d dVar) {
            com.umeng.commonsdk.statistics.proto.e eVar;
            if (dVar != null) {
                if (dVar.e()) {
                    Map<String, com.umeng.commonsdk.statistics.proto.e> c10 = dVar.c();
                    for (String str : c10.keySet()) {
                        if (!TextUtils.isEmpty(str) && (eVar = c10.get(str)) != null) {
                            String b10 = eVar.b();
                            if (!TextUtils.isEmpty(b10)) {
                                this.f11066a.put(str, b10);
                                if (AnalyticsConstants.UM_DEBUG) {
                                    StringBuilder sb = new StringBuilder();
                                    sb.append("imKey is ");
                                    sb.append(str);
                                    sb.append(", imValue is ");
                                    sb.append(b10);
                                }
                            }
                        }
                    }
                }
            }
        }

        public synchronized void a(String str) {
            Map<String, String> map = this.f11066a;
            if (map != null && map.size() > 0 && !TextUtils.isEmpty(str) && this.f11066a.containsKey(str)) {
                this.f11066a.remove(str);
            }
        }

        public a(com.umeng.commonsdk.statistics.proto.d dVar) {
            a(dVar);
        }

        public void a(com.umeng.commonsdk.statistics.proto.d dVar) {
            if (dVar == null) {
                return;
            }
            b(dVar);
        }

        public synchronized String a(String str, String str2) {
            if (!TextUtils.isEmpty(str) && this.f11066a.size() > 0) {
                String str3 = this.f11066a.get(str);
                return !TextUtils.isEmpty(str3) ? str3 : str2;
            }
            return str2;
        }
    }

    @Override // com.umeng.commonsdk.utils.FileLockCallback
    public boolean onFileLock(String str, Object obj) {
        return false;
    }

    @Override // com.umeng.commonsdk.utils.FileLockCallback
    public boolean onFileLock(File file, int i10) {
        if (i10 == 0) {
            f11056j.e();
        } else if (i10 == 1) {
            f11056j.a(file);
        }
        return true;
    }

    public void d() {
        if (this.f11065i == null || f11058l == null) {
            return;
        }
        File file = new File(f11057k.getFilesDir(), f11052c);
        if (!file.exists()) {
            try {
                try {
                    file.createNewFile();
                } catch (IOException e10) {
                    UMCrashManager.reportCrash(f11057k, e10);
                }
            } catch (IOException unused) {
                file.createNewFile();
            }
        }
        f11058l.doFileOperateion(file, f11056j, 1);
    }

    public a c() {
        return this.f11064h;
    }

    public void b(com.umeng.commonsdk.statistics.proto.d dVar) {
        com.umeng.commonsdk.statistics.proto.d a10;
        boolean z10;
        if (dVar == null) {
            if (AnalyticsConstants.UM_DEBUG) {
                UMRTLog.d(UMRTLog.RTLOG_TAG, "Imprint is null");
                return;
            }
            return;
        }
        if (!c(dVar)) {
            if (AnalyticsConstants.UM_DEBUG) {
                UMRTLog.e(UMRTLog.RTLOG_TAG, "Imprint is not valid");
                return;
            }
            return;
        }
        String str = AnalyticsConstants.OS;
        HashMap hashMap = new HashMap();
        synchronized (this) {
            com.umeng.commonsdk.statistics.proto.d dVar2 = this.f11065i;
            com.umeng.commonsdk.statistics.proto.d d10 = d(dVar);
            String str2 = null;
            String i10 = dVar2 == null ? null : dVar2.i();
            if (dVar2 == null) {
                a10 = e(d10);
            } else {
                a10 = a(dVar2, d10, hashMap);
            }
            this.f11065i = a10;
            if (a10 != null) {
                str2 = a10.i();
            }
            z10 = !a(i10, str2);
        }
        com.umeng.commonsdk.statistics.proto.d dVar3 = this.f11065i;
        if (dVar3 != null && z10) {
            this.f11064h.a(dVar3);
            com.umeng.commonsdk.statistics.internal.d dVar4 = this.f11063e;
            if (dVar4 != null) {
                dVar4.onImprintChanged(this.f11064h);
            }
        }
        if (hashMap.size() > 0) {
            synchronized (f11055g) {
                for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                    String key = entry.getKey();
                    String value = entry.getValue();
                    if (!TextUtils.isEmpty(key) && f11054f.containsKey(key)) {
                        ULog.i("--->>> target imprint key is: " + key + "; value is: " + value);
                        ArrayList<UMImprintChangeCallback> arrayList = f11054f.get(key);
                        if (arrayList != null) {
                            for (int i11 = 0; i11 < arrayList.size(); i11++) {
                                arrayList.get(i11).onImprintValueChanged(key, value);
                            }
                        }
                    }
                }
            }
        }
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (f11062p) {
            try {
                if (f11061o.containsKey(str)) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> unregistPreProcessCallback: unregist [" + str + "] success.");
                    f11054f.remove(str);
                } else {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> unregistPreProcessCallback: can't find [" + str + "], pls regist first.");
                }
            } finally {
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0036 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v7, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r3v3, types: [android.content.Context] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void e() {
        Throwable th;
        FileInputStream fileInputStream;
        File filesDir = f11057k.getFilesDir();
        ?? r22 = f11052c;
        File file = new File(filesDir, (String) r22);
        synchronized (f11051b) {
            if (file.exists()) {
                byte[] bArr = null;
                try {
                    try {
                        fileInputStream = f11057k.openFileInput(r22);
                        try {
                            bArr = HelperUtils.readStreamToByteArray(fileInputStream);
                            r22 = fileInputStream;
                        } catch (Exception e10) {
                            e = e10;
                            e.printStackTrace();
                            r22 = fileInputStream;
                            HelperUtils.safeClose((InputStream) r22);
                            if (bArr != null) {
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        HelperUtils.safeClose((InputStream) r22);
                        throw th;
                    }
                } catch (Exception e11) {
                    e = e11;
                    fileInputStream = null;
                } catch (Throwable th3) {
                    r22 = 0;
                    th = th3;
                    HelperUtils.safeClose((InputStream) r22);
                    throw th;
                }
                HelperUtils.safeClose((InputStream) r22);
                if (bArr != null) {
                    try {
                        com.umeng.commonsdk.statistics.proto.d dVar = new com.umeng.commonsdk.statistics.proto.d();
                        new ck().a(dVar, bArr);
                        this.f11065i = dVar;
                        this.f11064h.a(dVar);
                        this.f11065i = d(this.f11065i);
                    } catch (Exception e12) {
                        e12.printStackTrace();
                    }
                }
            }
        }
    }

    public void a(com.umeng.commonsdk.statistics.internal.d dVar) {
        this.f11063e = dVar;
    }

    public String a(com.umeng.commonsdk.statistics.proto.d dVar) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry entry : new TreeMap(dVar.c()).entrySet()) {
            sb.append((String) entry.getKey());
            if (((com.umeng.commonsdk.statistics.proto.e) entry.getValue()).d()) {
                sb.append(((com.umeng.commonsdk.statistics.proto.e) entry.getValue()).b());
            }
        }
        sb.append(dVar.f11198b);
        return HelperUtils.MD5(sb.toString()).toLowerCase(Locale.US);
    }

    public byte[] a(com.umeng.commonsdk.statistics.proto.e eVar) {
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.order(null);
        allocate.putLong(eVar.e());
        byte[] array = allocate.array();
        byte[] bArr = f11053d;
        byte[] bArr2 = new byte[4];
        for (int i10 = 0; i10 < 4; i10++) {
            bArr2[i10] = (byte) (array[i10] ^ bArr[i10]);
        }
        return bArr2;
    }

    public byte[] a() {
        try {
            synchronized (this) {
                com.umeng.commonsdk.statistics.proto.d dVar = this.f11065i;
                if (dVar == null) {
                    return null;
                }
                if (dVar.b() <= 0) {
                    return null;
                }
                return new cq().a(this.f11065i);
            }
        } catch (Throwable th) {
            UMCrashManager.reportCrash(f11057k, th);
            return null;
        }
    }

    public synchronized com.umeng.commonsdk.statistics.proto.d b() {
        return this.f11065i;
    }

    private boolean a(String str, String str2) {
        if (str == null) {
            return str2 == null;
        }
        return str.equals(str2);
    }

    private com.umeng.commonsdk.statistics.proto.d a(com.umeng.commonsdk.statistics.proto.d dVar, com.umeng.commonsdk.statistics.proto.d dVar2, Map<String, String> map) {
        UMImprintPreProcessCallback uMImprintPreProcessCallback;
        ArrayList<UMImprintChangeCallback> arrayList;
        if (dVar2 == null) {
            return dVar;
        }
        Map<String, com.umeng.commonsdk.statistics.proto.e> c10 = dVar.c();
        for (Map.Entry<String, com.umeng.commonsdk.statistics.proto.e> entry : dVar2.c().entrySet()) {
            int i10 = 0;
            if (entry.getValue().d()) {
                String key = entry.getKey();
                String str = entry.getValue().f11216a;
                synchronized (f11062p) {
                    if (!TextUtils.isEmpty(key) && f11061o.containsKey(key) && (uMImprintPreProcessCallback = f11061o.get(key)) != null && uMImprintPreProcessCallback.onPreProcessImprintKey(key, str)) {
                        i10 = 1;
                    }
                }
                if (i10 == 0) {
                    c10.put(entry.getKey(), entry.getValue());
                    synchronized (f11055g) {
                        if (!TextUtils.isEmpty(key) && f11054f.containsKey(key) && f11054f.get(key) != null) {
                            map.put(key, str);
                        }
                    }
                } else {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> merge: [" + key + "] should be ignored.");
                }
            } else {
                String key2 = entry.getKey();
                synchronized (f11055g) {
                    if (!TextUtils.isEmpty(key2) && f11054f.containsKey(key2) && (arrayList = f11054f.get(key2)) != null) {
                        while (i10 < arrayList.size()) {
                            arrayList.get(i10).onImprintValueChanged(key2, null);
                            i10++;
                        }
                    }
                }
                c10.remove(key2);
                this.f11064h.a(key2);
            }
        }
        dVar.a(dVar2.f());
        dVar.a(a(dVar));
        return dVar;
    }

    private void a(File file) {
        if (this.f11065i == null) {
            return;
        }
        try {
            synchronized (f11051b) {
                byte[] a10 = new cq().a(this.f11065i);
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                try {
                    fileOutputStream.write(a10);
                    fileOutputStream.flush();
                } finally {
                    HelperUtils.safeClose(fileOutputStream);
                }
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }
}
