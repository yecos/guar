package com.umeng.message.proguard;

import android.content.Context;
import android.text.TextUtils;
import com.google.firebase.messaging.Constants;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.commonsdk.utils.UMUtils;
import com.umeng.message.common.UPLog;
import com.umeng.message.common.inter.ITagManager;
import com.umeng.message.entity.UInAppMessage;
import com.umeng.message.inapp.InAppMessageManager;
import com.umeng.message.proguard.af;
import com.umeng.message.proguard.h;
import java.io.File;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class aj {

    /* renamed from: b, reason: collision with root package name */
    private static boolean f11484b = false;

    /* renamed from: c, reason: collision with root package name */
    private static volatile aj f11485c;

    /* renamed from: a, reason: collision with root package name */
    private final Context f11486a;

    private aj(Context context) {
        this.f11486a = context.getApplicationContext();
    }

    public static /* synthetic */ boolean b() {
        f11484b = false;
        return false;
    }

    private void c() {
        if (f11484b) {
            UMLog.mutlInfo("UmengInAppMessageTracker", 2, "sendInAppCacheLog已经在队列里，忽略该请求");
            return;
        }
        f11484b = true;
        UMLog.mutlInfo("UmengInAppMessageTracker", 2, "sendInAppCacheLog开始");
        b.c(new Runnable() { // from class: com.umeng.message.proguard.aj.4
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    Iterator<af> it = InAppMessageManager.getInstance(aj.this.f11486a).b().iterator();
                    while (it.hasNext()) {
                        af next = it.next();
                        JSONObject b10 = aj.b(next.f11458b, next.f11459c, next.f11460d, next.f11461e, next.f11462f, next.f11463g, next.f11464h, next.f11465i, next.f11466j);
                        if (b10 != null && TextUtils.equals(b10.getString("success"), ITagManager.SUCCESS)) {
                            InAppMessageManager inAppMessageManager = InAppMessageManager.getInstance(aj.this.f11486a);
                            inAppMessageManager.f11370b.getContentResolver().delete(h.e(inAppMessageManager.f11370b), "MsgId=?", new String[]{next.f11458b});
                        }
                    }
                } catch (Exception e10) {
                    UPLog.w("UmengInAppMessageTracker", "sendInAppCacheLog error:" + e10.getMessage());
                } finally {
                    aj.b();
                }
            }
        });
    }

    public static aj a(Context context) {
        if (f11485c == null) {
            synchronized (aj.class) {
                if (f11485c == null) {
                    f11485c = new aj(context);
                }
            }
        }
        return f11485c;
    }

    public static /* synthetic */ JSONObject b(String str, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("header", e.a());
        jSONObject.put("msg_id", str);
        jSONObject.put("msg_type", i10);
        jSONObject.put("num_display", i11);
        jSONObject.put("num_open_full", i12);
        jSONObject.put("num_open_top", i13);
        jSONObject.put("num_open_bottom", i14);
        jSONObject.put("num_close", i15);
        jSONObject.put("num_duration", i16);
        jSONObject.put("num_custom", i17);
        return g.a(jSONObject, "https://msg.umengcloud.com/admsg/v3/stats", UMUtils.getAppkey(y.a()), true);
    }

    public final void a(final ae aeVar) {
        if (f.b()) {
            UPLog.i("UmengInAppMessageTracker", "getSplashMsg failed, silent mode!");
        } else {
            c();
            b.c(new Runnable() { // from class: com.umeng.message.proguard.aj.1
                @Override // java.lang.Runnable
                public final void run() {
                    UInAppMessage uInAppMessage;
                    UMLog.mutlInfo("UmengInAppMessageTracker", 2, "get splash message begin");
                    try {
                        JSONObject a10 = g.a(aj.a(), "https://msg.umengcloud.com/admsg/v3/launch", UMUtils.getAppkey(y.a()), true);
                        if (TextUtils.equals(a10.getString("success"), ITagManager.SUCCESS)) {
                            UMLog.mutlInfo("UmengInAppMessageTracker", 2, "get splash message success".concat(String.valueOf(a10)));
                            JSONObject jSONObject = a10.getJSONObject("data");
                            InAppMessageManager.f11367d = jSONObject.getInt("pduration") * 1000;
                            InAppMessageManager.f11368e = jSONObject.getInt("sduration") * 1000;
                            aeVar.a(new UInAppMessage(jSONObject.getJSONObject("launch")));
                            InAppMessageManager inAppMessageManager = InAppMessageManager.getInstance(aj.this.f11486a);
                            StringBuilder sb = new StringBuilder();
                            sb.append(System.currentTimeMillis());
                            inAppMessageManager.b("KEY_SPLASH_TS", sb.toString());
                            return;
                        }
                        if (!TextUtils.equals(a10.getString("success"), ITagManager.FAIL) || !TextUtils.equals(a10.getString("error"), "no message")) {
                            aeVar.a(null);
                            return;
                        }
                        String a11 = InAppMessageManager.getInstance(aj.this.f11486a).a();
                        if (TextUtils.isEmpty(a11)) {
                            return;
                        }
                        try {
                            uInAppMessage = new UInAppMessage(new JSONObject(a11));
                        } catch (JSONException e10) {
                            e10.printStackTrace();
                            uInAppMessage = null;
                        }
                        if (uInAppMessage != null) {
                            InAppMessageManager.getInstance(aj.this.f11486a).a(new File(f.a(aj.this.f11486a, uInAppMessage.msg_id)));
                            InAppMessageManager.getInstance(aj.this.f11486a).a((UInAppMessage) null);
                        }
                    } catch (Exception e11) {
                        UPLog.w("UmengInAppMessageTracker", "getSplashMsg error: ", e11.getMessage());
                        aeVar.a(null);
                    }
                }
            });
        }
    }

    public final void a(final String str, final ae aeVar) {
        if (f.b()) {
            UPLog.i("UmengInAppMessageTracker", "getCardMsg failed, silent mode!");
        } else {
            c();
            b.c(new Runnable() { // from class: com.umeng.message.proguard.aj.2
                @Override // java.lang.Runnable
                public final void run() {
                    UInAppMessage uInAppMessage;
                    UMLog.mutlInfo("UmengInAppMessageTracker", 2, "get card message begin");
                    try {
                        JSONObject a10 = aj.a();
                        a10.put(Constants.ScionAnalytics.PARAM_LABEL, str);
                        JSONObject a11 = g.a(a10, "https://msg.umengcloud.com/admsg/v3/getmsg", UMUtils.getAppkey(y.a()), true);
                        if (TextUtils.equals(a11.getString("success"), ITagManager.SUCCESS)) {
                            UMLog.mutlInfo("UmengInAppMessageTracker", 2, "get card message success".concat(String.valueOf(a11)));
                            JSONObject jSONObject = a11.getJSONObject("data");
                            InAppMessageManager.f11367d = jSONObject.getInt("pduration") * 1000;
                            InAppMessageManager.f11368e = jSONObject.getInt("sduration") * 1000;
                            aeVar.b(new UInAppMessage(jSONObject.getJSONObject("card")));
                            InAppMessageManager inAppMessageManager = InAppMessageManager.getInstance(aj.this.f11486a);
                            String concat = "KEY_CARD_TS_".concat(String.valueOf(a10.optString(Constants.ScionAnalytics.PARAM_LABEL, "")));
                            StringBuilder sb = new StringBuilder();
                            sb.append(System.currentTimeMillis());
                            inAppMessageManager.b(concat, sb.toString());
                            return;
                        }
                        if (!TextUtils.equals(a11.getString("success"), ITagManager.FAIL) || !TextUtils.equals(a11.getString("error"), "no message")) {
                            aeVar.b(null);
                            return;
                        }
                        String a12 = InAppMessageManager.getInstance(aj.this.f11486a).a(str);
                        if (TextUtils.isEmpty(a12)) {
                            return;
                        }
                        try {
                            uInAppMessage = new UInAppMessage(new JSONObject(a12));
                        } catch (JSONException e10) {
                            e10.printStackTrace();
                            uInAppMessage = null;
                        }
                        if (uInAppMessage != null) {
                            InAppMessageManager.getInstance(aj.this.f11486a).a(new File(f.a(aj.this.f11486a, uInAppMessage.msg_id)));
                            InAppMessageManager.getInstance(aj.this.f11486a).a((UInAppMessage) null, str);
                        }
                    } catch (Exception e11) {
                        UPLog.w("UmengInAppMessageTracker", "getCardMsg error: ", e11.getMessage());
                        aeVar.b(null);
                    }
                }
            });
        }
    }

    public final void a(final String str, final int i10, final int i11, final int i12, final int i13, final int i14, final int i15, final int i16, final int i17) {
        b.c(new Runnable() { // from class: com.umeng.message.proguard.aj.3
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    UMLog.mutlInfo("UmengInAppMessageTracker", 2, "track in app msg begin");
                    JSONObject b10 = aj.b(str, i10, i11, i12, i13, i14, i15, i16, i17);
                    if (b10 == null || !TextUtils.equals(b10.getString("success"), ITagManager.SUCCESS)) {
                        return;
                    }
                    UMLog.mutlInfo("UmengInAppMessageTracker", 2, "track in app msg success");
                } catch (Exception e10) {
                    UPLog.w("UmengInAppMessageTracker", "trackInAppMessage error:" + e10.getMessage());
                    final InAppMessageManager inAppMessageManager = InAppMessageManager.getInstance(aj.this.f11486a);
                    final String str2 = str;
                    final int i18 = i10;
                    final int i19 = i11;
                    final int i20 = i12;
                    final int i21 = i13;
                    final int i22 = i14;
                    final int i23 = i15;
                    final int i24 = i16;
                    final int i25 = i17;
                    if (TextUtils.isEmpty(str2)) {
                        return;
                    }
                    b.c(new Runnable() { // from class: com.umeng.message.inapp.InAppMessageManager.1

                        /* renamed from: a */
                        final /* synthetic */ String f11374a;

                        /* renamed from: b */
                        final /* synthetic */ int f11375b;

                        /* renamed from: c */
                        final /* synthetic */ int f11376c;

                        /* renamed from: d */
                        final /* synthetic */ int f11377d;

                        /* renamed from: e */
                        final /* synthetic */ int f11378e;

                        /* renamed from: f */
                        final /* synthetic */ int f11379f;

                        /* renamed from: g */
                        final /* synthetic */ int f11380g;

                        /* renamed from: h */
                        final /* synthetic */ int f11381h;

                        /* renamed from: i */
                        final /* synthetic */ int f11382i;

                        public AnonymousClass1(final String str22, final int i182, final int i192, final int i202, final int i212, final int i222, final int i232, final int i242, final int i252) {
                            r2 = str22;
                            r3 = i182;
                            r4 = i192;
                            r5 = i202;
                            r6 = i212;
                            r7 = i222;
                            r8 = i232;
                            r9 = i242;
                            r10 = i252;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            try {
                                af a10 = InAppMessageManager.a(InAppMessageManager.this, r2);
                                if (a10 != null) {
                                    InAppMessageManager.this.f11370b.getContentResolver().update(h.e(InAppMessageManager.this.f11370b), new af(r2, r3, a10.f11460d + r4, a10.f11461e + r5, a10.f11462f + r6, a10.f11463g + r7, a10.f11464h + r8, a10.f11465i + r9, a10.f11466j).a(), "MsgId=?", new String[]{r2});
                                } else {
                                    InAppMessageManager.this.f11370b.getContentResolver().insert(h.e(InAppMessageManager.this.f11370b), new af(r2, r3, r4, r5, r6, r7, r8, r9, r10).a());
                                }
                                UMLog.mutlInfo("InAppMessageManager", 2, "store in app cache log success");
                            } catch (Exception e11) {
                                UMLog.mutlInfo("InAppMessageManager", 0, "store in app cache log fail");
                                e11.printStackTrace();
                            }
                        }
                    });
                }
            }
        });
    }

    public static /* synthetic */ JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("header", e.a());
        jSONObject.put("pmode", InAppMessageManager.f11366a ? "0" : "1");
        return jSONObject;
    }
}
