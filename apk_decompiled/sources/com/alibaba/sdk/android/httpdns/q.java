package com.alibaba.sdk.android.httpdns;

import android.content.Context;
import com.raizlabs.android.dbflow.sql.language.Operator;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
class q implements Callable<String[]> {

    /* renamed from: a, reason: collision with root package name */
    private static Context f5951a;

    /* renamed from: a, reason: collision with other field name */
    private s f37a;

    /* renamed from: d, reason: collision with root package name */
    private int f5952d;

    /* renamed from: d, reason: collision with other field name */
    private long f38d;

    /* renamed from: e, reason: collision with root package name */
    private String[] f5953e;
    private Map<String, String> extra;
    private String hostName;

    /* renamed from: j, reason: collision with root package name */
    private boolean f5954j;

    /* renamed from: k, reason: collision with root package name */
    private String f5955k;

    /* renamed from: l, reason: collision with root package name */
    private String f5956l;
    private static d hostManager = d.a();

    /* renamed from: a, reason: collision with other field name */
    private static final Object f36a = new Object();

    public q(String str, s sVar) {
        this.f5952d = 1;
        this.f5955k = null;
        this.f5953e = f.f20c;
        this.f5954j = false;
        this.f5956l = null;
        this.extra = new HashMap();
        this.f38d = 0L;
        this.hostName = str;
        this.f37a = sVar;
    }

    private boolean d(String str) {
        return str.matches("[a-zA-Z0-9\\-_]+");
    }

    private boolean e(String str) {
        return str.matches("[a-zA-Z0-9\\-_=]+");
    }

    private String getExtra() {
        boolean z10;
        StringBuilder sb = new StringBuilder();
        Map<String, String> map = this.extra;
        boolean z11 = true;
        if (map != null) {
            z10 = true;
            for (Map.Entry<String, String> entry : map.entrySet()) {
                sb.append("&sdns-");
                sb.append(entry.getKey());
                sb.append(Operator.Operation.EQUALS);
                sb.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
                if (!d(entry.getKey())) {
                    i.f("设置自定义参数失败，自定义key不合法：" + entry.getKey());
                    z11 = false;
                }
                if (!e(entry.getValue())) {
                    i.f("设置自定义参数失败，自定义value不合法：" + entry.getValue());
                    z10 = false;
                }
            }
        } else {
            z10 = true;
        }
        if (z11 && z10) {
            String sb2 = sb.toString();
            if (sb2.getBytes("UTF-8").length <= 1000) {
                return sb2;
            }
            i.f("设置自定义参数失败，自定义参数过长");
        }
        return "";
    }

    public static void setContext(Context context) {
        f5951a = context;
    }

    public void a(int i10) {
        if (i10 >= 0) {
            this.f5952d = i10;
        }
    }

    public q(String str, s sVar, Map<String, String> map, String str2) {
        this.f5952d = 1;
        this.f5955k = null;
        this.f5953e = f.f20c;
        this.f5954j = false;
        this.f5956l = null;
        HashMap hashMap = new HashMap();
        this.extra = hashMap;
        this.f38d = 0L;
        this.hostName = str;
        this.f37a = sVar;
        this.f5956l = str2;
        hashMap.putAll(map);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:75:0x03bd A[Catch: all -> 0x03ea, TryCatch #5 {all -> 0x03ea, blocks: (B:73:0x03af, B:75:0x03bd, B:82:0x03c4), top: B:72:0x03af }] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x03cc  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x03d1 A[Catch: IOException -> 0x03d5, TRY_ENTER, TryCatch #2 {IOException -> 0x03d5, blocks: (B:26:0x038a, B:28:0x038f, B:79:0x03d1, B:81:0x03d9), top: B:19:0x0049 }] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x03d9 A[Catch: IOException -> 0x03d5, TRY_LEAVE, TryCatch #2 {IOException -> 0x03d5, blocks: (B:26:0x038a, B:28:0x038f, B:79:0x03d1, B:81:0x03d9), top: B:19:0x0049 }] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x03c4 A[Catch: all -> 0x03ea, TRY_LEAVE, TryCatch #5 {all -> 0x03ea, blocks: (B:73:0x03af, B:75:0x03bd, B:82:0x03c4), top: B:72:0x03af }] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r3v43 */
    /* JADX WARN: Type inference failed for: r3v64 */
    /* JADX WARN: Type inference failed for: r3v65 */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v6 */
    @Override // java.util.concurrent.Callable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String[] call() {
        /*
            Method dump skipped, instructions count: 1028
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.httpdns.q.call():java.lang.String[]");
    }
}
