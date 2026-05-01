package com.alibaba.sdk.android.utils.crashdefend;

import android.content.Context;
import android.text.TextUtils;
import com.taobao.accs.common.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;

/* loaded from: classes.dex */
public class b {

    /* renamed from: b, reason: collision with root package name */
    private static b f5987b;

    /* renamed from: a, reason: collision with root package name */
    private com.alibaba.sdk.android.utils.a f5988a;

    /* renamed from: a, reason: collision with other field name */
    private c f46a;

    /* renamed from: a, reason: collision with other field name */
    private ExecutorService f48a;
    private Context context;

    /* renamed from: a, reason: collision with other field name */
    private com.alibaba.sdk.android.utils.crashdefend.a f45a = new com.alibaba.sdk.android.utils.crashdefend.a();

    /* renamed from: a, reason: collision with other field name */
    private final List<c> f47a = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    private Map<String, String> f5989d = new HashMap();

    /* renamed from: a, reason: collision with other field name */
    private final int[] f49a = new int[5];

    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private d f5990a;

        public a(d dVar) {
            this.f5990a = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d dVar;
            int i10;
            do {
                try {
                    Thread.sleep(1000L);
                    dVar = this.f5990a;
                    i10 = dVar.f5996d - 1;
                    dVar.f5996d = i10;
                } catch (InterruptedException unused) {
                    return;
                } catch (Exception e10) {
                    e10.getMessage();
                    return;
                }
            } while (i10 > 0);
            if (i10 <= 0) {
                b.this.b(dVar.f5995b);
                e.a(b.this.context, b.this.f45a, (List<c>) b.this.f47a);
            }
        }
    }

    private b(Context context, com.alibaba.sdk.android.utils.a aVar) {
        this.f48a = null;
        this.context = context;
        this.f5988a = aVar;
        this.f48a = new f().a();
        for (int i10 = 0; i10 < 5; i10++) {
            this.f49a[i10] = (i10 * 5) + 5;
        }
        this.f5989d.put("sdkId", "utils");
        this.f5989d.put(Constants.KEY_SDK_VERSION, "2.0.0");
        try {
            a();
            b();
        } catch (Exception e10) {
            e10.getMessage();
        }
    }

    public void b(String str, String str2) {
    }

    private void b() {
        this.f46a = null;
        ArrayList arrayList = new ArrayList();
        synchronized (this.f47a) {
            for (c cVar : this.f47a) {
                if (cVar.crashCount >= cVar.f5992a) {
                    arrayList.add(cVar);
                }
            }
            Iterator it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                c cVar2 = (c) it.next();
                if (cVar2.f5994c < 5) {
                    long j10 = this.f45a.f5986a - this.f49a[r3];
                    g.a("UtilsSDK", "after restart " + ((cVar2.f50a - j10) + 1) + " times, sdk will be restore");
                    if (cVar2.f50a < j10) {
                        this.f46a = cVar2;
                        break;
                    }
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("SDK ");
                    sb.append(cVar2.f52a);
                    sb.append(" has been closed");
                }
            }
            c cVar3 = this.f46a;
            if (cVar3 != null) {
                cVar3.f5994c++;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(this.f46a.f52a);
                sb2.append(" will restore --- startSerialNumber:");
                sb2.append(this.f46a.f50a);
                sb2.append("   crashCount:");
                sb2.append(this.f46a.crashCount);
            }
        }
    }

    public static synchronized b a(Context context, com.alibaba.sdk.android.utils.a aVar) {
        b bVar;
        synchronized (b.class) {
            if (f5987b == null) {
                f5987b = new b(context, aVar);
            }
            bVar = f5987b;
        }
        return bVar;
    }

    private void a() {
        if (e.m27a(this.context, this.f45a, this.f47a)) {
            this.f45a.f5986a++;
        } else {
            this.f45a.f5986a = 1L;
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m25a(c cVar, SDKMessageCallback sDKMessageCallback) {
        c a10;
        if (cVar != null && sDKMessageCallback != null) {
            try {
                if (TextUtils.isEmpty(cVar.f54b) || TextUtils.isEmpty(cVar.f52a) || (a10 = a(cVar, sDKMessageCallback)) == null) {
                    return false;
                }
                boolean m24a = m24a(a10);
                int i10 = a10.crashCount;
                int i11 = a10.f5992a;
                if (i10 == i11) {
                    a(a10.f52a, a10.f54b, i10, i11);
                }
                a10.crashCount++;
                e.a(this.context, this.f45a, this.f47a);
                if (m24a) {
                    a(a10);
                    StringBuilder sb = new StringBuilder();
                    sb.append("START:");
                    sb.append(a10.f52a);
                    sb.append(" --- limit:");
                    sb.append(a10.f5992a);
                    sb.append("  count:");
                    sb.append(a10.crashCount - 1);
                    sb.append("  restore:");
                    sb.append(a10.f5994c);
                    sb.append("  startSerialNumber:");
                    sb.append(a10.f50a);
                    sb.append("  registerSerialNumber:");
                    sb.append(a10.f53b);
                } else {
                    sDKMessageCallback.crashDefendMessage(a10.f5992a, a10.crashCount - 1);
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("STOP:");
                    sb2.append(a10.f52a);
                    sb2.append(" --- limit:");
                    sb2.append(a10.f5992a);
                    sb2.append("  count:");
                    sb2.append(a10.crashCount - 1);
                    sb2.append("  restore:");
                    sb2.append(a10.f5994c);
                    sb2.append("  startSerialNumber:");
                    sb2.append(a10.f50a);
                    sb2.append("  registerSerialNumber:");
                    sb2.append(a10.f53b);
                }
                return true;
            } catch (Exception e10) {
                e10.getMessage();
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(c cVar) {
        if (cVar == null) {
            return;
        }
        int i10 = cVar.f5994c;
        if (i10 > 0) {
            b(cVar.f52a, cVar.f54b, i10, 5);
        }
        cVar.crashCount = 0;
        cVar.f5994c = 0;
    }

    private c a(c cVar, SDKMessageCallback sDKMessageCallback) {
        synchronized (this.f47a) {
            List<c> list = this.f47a;
            c cVar2 = null;
            if (list != null && list.size() > 0) {
                Iterator<c> it = this.f47a.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    c next = it.next();
                    if (next != null && next.f52a.equals(cVar.f52a)) {
                        if (!next.f54b.equals(cVar.f54b)) {
                            next.f54b = cVar.f54b;
                            next.f5992a = cVar.f5992a;
                            next.f5993b = cVar.f5993b;
                            next.crashCount = 0;
                            next.f5994c = 0;
                        }
                        if (next.f55c) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("SDK ");
                            sb.append(cVar.f52a);
                            sb.append(" has been registered");
                            return null;
                        }
                        next.f55c = true;
                        next.f51a = sDKMessageCallback;
                        next.f53b = this.f45a.f5986a;
                        cVar2 = next;
                    }
                }
            }
            if (cVar2 == null) {
                cVar2 = (c) cVar.clone();
                cVar2.f55c = true;
                cVar2.f51a = sDKMessageCallback;
                cVar2.crashCount = 0;
                cVar2.f53b = this.f45a.f5986a;
                this.f47a.add(cVar2);
            }
            return cVar2;
        }
    }

    private void b(String str, String str2, int i10, int i11) {
        if (this.f5988a == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.putAll(this.f5989d);
        hashMap.put("crashSdkId", str);
        hashMap.put("crashSdkVer", str2);
        hashMap.put("recoverCount", String.valueOf(i10));
        hashMap.put("recoverThreshold", String.valueOf(i11));
        this.f5988a.sendCustomHit("utils_biz_recover", 0L, hashMap);
    }

    /* renamed from: a, reason: collision with other method in class */
    private boolean m24a(c cVar) {
        if (cVar.crashCount < cVar.f5992a) {
            cVar.f50a = cVar.f53b;
            return true;
        }
        c cVar2 = this.f46a;
        if (cVar2 == null || !cVar2.f52a.equals(cVar.f52a)) {
            return false;
        }
        cVar.crashCount = cVar.f5992a - 1;
        cVar.f50a = cVar.f53b;
        return true;
    }

    private void a(c cVar) {
        if (cVar == null) {
            return;
        }
        d dVar = new d();
        dVar.f5995b = cVar;
        dVar.f5996d = cVar.f5993b;
        a(dVar);
        SDKMessageCallback sDKMessageCallback = cVar.f51a;
        if (sDKMessageCallback != null) {
            sDKMessageCallback.crashDefendMessage(cVar.f5992a, cVar.crashCount - 1);
        }
    }

    private void a(d dVar) {
        if (dVar == null || dVar.f5995b == null) {
            return;
        }
        this.f48a.execute(new a(dVar));
    }

    private void a(String str, String str2, int i10, int i11) {
        if (this.f5988a == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.putAll(this.f5989d);
        hashMap.put("crashSdkId", str);
        hashMap.put("crashSdkVer", str2);
        hashMap.put("curCrashCount", String.valueOf(i10));
        hashMap.put("crashThreshold", String.valueOf(i11));
        this.f5988a.sendCustomHit("utils_biz_crash", 0L, hashMap);
    }
}
