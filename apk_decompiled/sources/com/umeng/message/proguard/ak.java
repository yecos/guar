package com.umeng.message.proguard;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.umeng.message.MessageSharedPrefs;
import com.umeng.message.api.UPushInAppMessageHandler;
import com.umeng.message.common.UPLog;
import com.umeng.message.proguard.ao;
import java.util.Calendar;
import java.util.Locale;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class ak extends al {

    /* renamed from: e, reason: collision with root package name */
    private static final ak f11503e = new ak();

    /* renamed from: a, reason: collision with root package name */
    private Future<?> f11504a;

    /* renamed from: b, reason: collision with root package name */
    private Future<?> f11505b;

    /* renamed from: d, reason: collision with root package name */
    private final an f11507d = new an();

    /* renamed from: c, reason: collision with root package name */
    private final am f11506c = new am();

    private ak() {
    }

    @Override // com.umeng.message.proguard.al
    public final an c() {
        return this.f11507d;
    }

    @Override // com.umeng.message.proguard.al
    public final void b() {
        if (this.f11507d.a() || this.f11506c.f11517a) {
            return;
        }
        Future<?> future = this.f11504a;
        if (future == null || future.isDone() || future.isCancelled()) {
            long e10 = u.e();
            long j10 = this.f11507d.f11525c;
            long j11 = 500;
            if (e10 < j10) {
                long j12 = j10 - e10;
                if (j12 >= 500) {
                    j11 = j12;
                }
            }
            this.f11504a = b.a(new Runnable() { // from class: com.umeng.message.proguard.ak.2
                @Override // java.lang.Runnable
                public final void run() {
                    boolean z10;
                    try {
                        ap a10 = ak.this.f11506c.a();
                        if (a10 != null && u.c()) {
                            final MessageSharedPrefs messageSharedPrefs = MessageSharedPrefs.getInstance(y.a());
                            if (messageSharedPrefs.s() >= messageSharedPrefs.f11344b.b("ia_count", 0)) {
                                UPLog.i("Pop", "count not allow");
                                return;
                            }
                            long j13 = 0;
                            if (Math.abs(System.currentTimeMillis() - messageSharedPrefs.f11344b.b("ia_last", 0L)) < messageSharedPrefs.r()) {
                                UPLog.i("Pop", "ttl not allow");
                                long r10 = messageSharedPrefs.r() - Math.abs(System.currentTimeMillis() - messageSharedPrefs.f11344b.b("ia_last", 0L));
                                if (ak.this.f11506c.f11517a) {
                                    return;
                                }
                                ak.this.a(r10);
                                return;
                            }
                            Activity d10 = u.d();
                            if (d10 != null && !d10.isFinishing()) {
                                an anVar = ak.this.f11507d;
                                String name = d10.getClass().getName();
                                String[] strArr = anVar.f11530h;
                                if (strArr != null) {
                                    for (String str : strArr) {
                                        if (TextUtils.equals(str, name)) {
                                            z10 = true;
                                            break;
                                        }
                                    }
                                }
                                z10 = false;
                                if (z10) {
                                    UPLog.i("Pop", "trigger activity name not match ", d10.getClass().getName());
                                    return;
                                }
                                UPushInAppMessageHandler inAppMessageHandler = v.a().getInAppMessageHandler();
                                if (inAppMessageHandler == null || inAppMessageHandler.canShowMessage(y.a(), a10.f11535a)) {
                                    ao.a(d10, a10, new ao.a() { // from class: com.umeng.message.proguard.ak.2.1
                                        @Override // com.umeng.message.proguard.ao.a
                                        public final void a(ap apVar, boolean z11) {
                                            if (!z11) {
                                                UPLog.i("Pop", "trigger not show msgId:", apVar.f11535a.getMsgId());
                                                long currentTimeMillis = System.currentTimeMillis() - messageSharedPrefs.q();
                                                if (currentTimeMillis >= ak.this.f11507d.f11523a) {
                                                    currentTimeMillis = 0;
                                                }
                                                ak akVar = ak.this;
                                                akVar.a(Math.max(akVar.f11507d.f11526d, ak.this.f11507d.f11523a) - currentTimeMillis);
                                                return;
                                            }
                                            ak.this.f11506c.b(apVar);
                                            messageSharedPrefs.f11344b.a("ia_latest_ts", apVar.f11535a.getMsgTime());
                                            messageSharedPrefs.f11344b.a("ia_last", System.currentTimeMillis());
                                            int s10 = messageSharedPrefs.s() + 1;
                                            MessageSharedPrefs messageSharedPrefs2 = messageSharedPrefs;
                                            Calendar calendar = Calendar.getInstance();
                                            messageSharedPrefs2.f11344b.a("ia_times", String.format(Locale.getDefault(), "%d.%d.%d", Integer.valueOf(calendar.get(1)), Integer.valueOf(calendar.get(6)), Integer.valueOf(s10)));
                                            if (ak.this.f11506c.f11517a) {
                                                return;
                                            }
                                            ak akVar2 = ak.this;
                                            akVar2.a(Math.max(akVar2.f11507d.f11526d, ak.this.f11507d.f11523a));
                                        }
                                    });
                                    return;
                                }
                                ak.this.f11506c.b(a10);
                                UPLog.i("Pop", "show allowed: false. msgId:", a10.f11535a.getMsgId());
                                inAppMessageHandler.onMessageIgnored(y.a(), a10.f11535a);
                                long currentTimeMillis = System.currentTimeMillis() - messageSharedPrefs.q();
                                if (currentTimeMillis < ak.this.f11507d.f11523a) {
                                    j13 = currentTimeMillis;
                                }
                                ak akVar = ak.this;
                                akVar.a(Math.max(akVar.f11507d.f11526d, ak.this.f11507d.f11523a) - j13);
                                return;
                            }
                            UPLog.i("Pop", "trigger activity finish");
                        }
                    } catch (Throwable unused) {
                    }
                }
            }, j11, TimeUnit.MILLISECONDS);
            UPLog.i("Pop", "trigger msg task delay:", Long.valueOf(j11));
        }
    }

    public static al a() {
        return f11503e;
    }

    @Override // com.umeng.message.proguard.al
    public final void a(final Context context) {
        b.b(new Runnable() { // from class: com.umeng.message.proguard.ak.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    if (ak.this.f11507d.a()) {
                        String b10 = MessageSharedPrefs.getInstance(context).f11344b.b("ia_cfg", (String) null);
                        if (b10 != null && b10.length() > 0) {
                            b10 = new String(bf.a(b10));
                        }
                        if (b10 != null && b10.length() > 0) {
                            UPLog.i("Pop", "init config", b10);
                            ak.this.f11507d.a(new JSONObject(b10));
                            MessageSharedPrefs messageSharedPrefs = MessageSharedPrefs.getInstance(y.a());
                            messageSharedPrefs.b(ak.this.f11507d.f11524b);
                            messageSharedPrefs.b(ak.this.f11507d.f11526d);
                        }
                    }
                    ak.this.f11506c.b();
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // com.umeng.message.proguard.al
    public final void a(Activity activity) {
        ao.a(activity);
    }

    @Override // com.umeng.message.proguard.al
    public final void a(ap apVar) {
        try {
            if (this.f11507d.a()) {
                this.f11506c.a(apVar);
                UPLog.i("Pop", "config empty. cached");
            } else {
                this.f11506c.a(apVar);
                a(500L);
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j10) {
        if (j10 < 500) {
            j10 = 500;
        }
        Future<?> future = this.f11505b;
        if (future != null && !future.isDone() && !future.isCancelled()) {
            future.cancel(false);
        }
        Runnable runnable = new Runnable() { // from class: com.umeng.message.proguard.ak.3
            @Override // java.lang.Runnable
            public final void run() {
                if (u.c() && u.d() != null) {
                    ak.this.b();
                }
            }
        };
        UPLog.i("Pop", "check delay:", Long.valueOf(j10));
        this.f11505b = b.a(runnable, j10, TimeUnit.MILLISECONDS);
    }

    @Override // com.umeng.message.proguard.al
    public final void a(String str) {
        ao.a(str);
        am amVar = this.f11506c;
        ap a10 = amVar.a(str);
        boolean b10 = a10 != null ? amVar.b(a10) : false;
        Object[] objArr = new Object[3];
        objArr[0] = "recall";
        objArr[1] = str;
        objArr[2] = b10 ? "success" : "not exist";
        UPLog.i("Pop", objArr);
    }

    @Override // com.umeng.message.proguard.al
    public final void a(final String str, final Object obj) {
        b.b(new Runnable() { // from class: com.umeng.message.proguard.ak.4
            @Override // java.lang.Runnable
            public final void run() {
                JSONObject optJSONObject;
                JSONArray optJSONArray;
                JSONObject optJSONObject2;
                MessageSharedPrefs messageSharedPrefs = MessageSharedPrefs.getInstance(y.a());
                try {
                    Object obj2 = obj;
                    if (obj2 instanceof JSONObject) {
                        JSONObject jSONObject = (JSONObject) obj2;
                        if (jSONObject.length() == 0 || (optJSONObject = jSONObject.optJSONObject(com.umeng.ccg.a.f10641a)) == null) {
                            return;
                        }
                        UPLog.i("Pop", "tag:", str);
                        JSONObject optJSONObject3 = optJSONObject.optJSONObject("push_inapp");
                        if (optJSONObject3 == null || (optJSONArray = optJSONObject3.optJSONArray(com.umeng.ccg.a.f10652l)) == null || optJSONArray.length() == 0 || (optJSONObject2 = optJSONArray.optJSONObject(0)) == null) {
                            return;
                        }
                        UPLog.i("Pop", "config:", optJSONObject2);
                        String jSONObject2 = optJSONObject2.toString();
                        if (jSONObject2 != null && jSONObject2.length() > 0) {
                            jSONObject2 = bf.a(jSONObject2.getBytes());
                        } else if (jSONObject2 == null) {
                            jSONObject2 = "";
                        }
                        messageSharedPrefs.f11344b.a("ia_cfg", jSONObject2);
                        ak.this.f11507d.a(optJSONObject2);
                        messageSharedPrefs.b(ak.this.f11507d.f11524b);
                        messageSharedPrefs.b(ak.this.f11507d.f11526d);
                    }
                } catch (Throwable unused) {
                }
            }
        });
    }
}
