package com.umeng.message.inapp;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.message.common.UPLog;
import com.umeng.message.entity.UInAppMessage;
import com.umeng.message.proguard.af;
import com.umeng.message.proguard.ah;
import com.umeng.message.proguard.aj;
import com.umeng.message.proguard.b;
import com.umeng.message.proguard.bd;
import com.umeng.message.proguard.f;
import com.umeng.message.proguard.h;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Locale;

/* loaded from: classes3.dex */
public class InAppMessageManager {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f11366a = false;

    /* renamed from: d, reason: collision with root package name */
    public static int f11367d = 1800000;

    /* renamed from: e, reason: collision with root package name */
    public static int f11368e = 1000;

    /* renamed from: f, reason: collision with root package name */
    private static InAppMessageManager f11369f;

    /* renamed from: b, reason: collision with root package name */
    public final Context f11370b;

    /* renamed from: c, reason: collision with root package name */
    String f11371c;

    /* renamed from: h, reason: collision with root package name */
    private final bd f11373h = new bd("in_app");

    /* renamed from: g, reason: collision with root package name */
    private UInAppHandler f11372g = new UmengInAppClickHandler();

    private InAppMessageManager(Context context) {
        this.f11370b = context.getApplicationContext();
    }

    private int d(String str) {
        return Integer.parseInt(a(str, "0"));
    }

    public static InAppMessageManager getInstance(Context context) {
        if (f11369f == null) {
            synchronized (InAppMessageManager.class) {
                if (f11369f == null) {
                    f11369f = new InAppMessageManager(context);
                }
            }
        }
        return f11369f;
    }

    public final long c(String str) {
        return Long.parseLong(a("KEY_LAST_SHOW_CARD_TS_".concat(String.valueOf(str)), "0"));
    }

    public UInAppHandler getInAppHandler() {
        return this.f11372g;
    }

    public void setInAppHandler(UInAppHandler uInAppHandler) {
        this.f11372g = uInAppHandler;
    }

    public void setInAppMsgDebugMode(boolean z10) {
        f11366a = z10;
    }

    public void setMainActivityPath(String str) {
        this.f11371c = str;
    }

    public void setPlainTextSize(int i10, int i11, int i12) {
        if (i10 <= 0 || i11 <= 0 || i12 <= 0) {
            UMLog.mutlInfo("InAppMessageManager", 0, "纯文本字体大小不能小于0");
            return;
        }
        b("KEY_PLAIN_TEXT_SIZE", i10 + "," + i11 + "," + i12);
    }

    public void showCardMessage(Activity activity, String str, IUmengInAppMsgCloseCallback iUmengInAppMsgCloseCallback) {
        if (f.b()) {
            UPLog.i("InAppMessageManager", "showCardMessage failed, silent mode!");
            return;
        }
        ah ahVar = new ah(activity, str, iUmengInAppMsgCloseCallback);
        if (TextUtils.isEmpty(ahVar.f11473c.trim())) {
            UMLog.mutlInfo(ah.f11471a, 0, "插屏消息的标签不能为空");
            return;
        }
        if (!ahVar.a(ahVar.f11473c)) {
            UMLog.mutlInfo(ah.f11471a, 0, "插屏消息的最大标签数为 10");
            return;
        }
        if (f11366a) {
            aj.a(ahVar.f11472b).a(ahVar.f11473c, ahVar);
        } else if (System.currentTimeMillis() - Long.parseLong(getInstance(ahVar.f11472b).a("KEY_CARD_TS_".concat(String.valueOf(ahVar.f11473c)), "0")) > f11367d) {
            aj.a(ahVar.f11472b).a(ahVar.f11473c, ahVar);
        } else {
            ahVar.b((UInAppMessage) null);
        }
    }

    public final void a(UInAppMessage uInAppMessage) {
        if (uInAppMessage == null) {
            b("KEY_LAST_SPLASH_ID", "");
        } else if (uInAppMessage.getRaw() != null) {
            b("KEY_LAST_SPLASH_ID", uInAppMessage.getRaw().toString());
        }
    }

    public final void b(String str) {
        String concat = "KEY_LAST_SHOW_CARD_TS_".concat(String.valueOf(str));
        StringBuilder sb = new StringBuilder();
        sb.append(System.currentTimeMillis());
        b(concat, sb.toString());
    }

    public final boolean c(UInAppMessage uInAppMessage) {
        return uInAppMessage.show_times == 0 || d(uInAppMessage.msg_id) < uInAppMessage.show_times;
    }

    public static boolean b(UInAppMessage uInAppMessage) {
        try {
            return System.currentTimeMillis() < new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA).parse(uInAppMessage.expire_time).getTime();
        } catch (Exception e10) {
            e10.printStackTrace();
            return false;
        }
    }

    public final String a() {
        return a("KEY_LAST_SPLASH_ID", "");
    }

    public final void a(UInAppMessage uInAppMessage, String str) {
        if (uInAppMessage == null) {
            b("KEY_LAST_CARD_ID_".concat(String.valueOf(str)), "");
        } else if (uInAppMessage.getRaw() != null) {
            b("KEY_LAST_CARD_ID_".concat(String.valueOf(str)), uInAppMessage.getRaw().toString());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0031, code lost:
    
        if (r1 != null) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x003f, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x003c, code lost:
    
        r1.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x003a, code lost:
    
        if (r1 == null) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.ArrayList<com.umeng.message.proguard.af> b() {
        /*
            r9 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 0
            android.content.Context r2 = r9.f11370b     // Catch: java.lang.Throwable -> L34 java.lang.Exception -> L36
            android.content.ContentResolver r3 = r2.getContentResolver()     // Catch: java.lang.Throwable -> L34 java.lang.Exception -> L36
            android.content.Context r2 = r9.f11370b     // Catch: java.lang.Throwable -> L34 java.lang.Exception -> L36
            android.net.Uri r4 = com.umeng.message.proguard.h.e(r2)     // Catch: java.lang.Throwable -> L34 java.lang.Exception -> L36
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            android.database.Cursor r1 = r3.query(r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L34 java.lang.Exception -> L36
            if (r1 == 0) goto L21
            boolean r2 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L34 java.lang.Exception -> L36
            goto L22
        L21:
            r2 = 0
        L22:
            if (r2 == 0) goto L31
            com.umeng.message.proguard.af r2 = new com.umeng.message.proguard.af     // Catch: java.lang.Throwable -> L34 java.lang.Exception -> L36
            r2.<init>(r1)     // Catch: java.lang.Throwable -> L34 java.lang.Exception -> L36
            r0.add(r2)     // Catch: java.lang.Throwable -> L34 java.lang.Exception -> L36
            boolean r2 = r1.moveToNext()     // Catch: java.lang.Throwable -> L34 java.lang.Exception -> L36
            goto L22
        L31:
            if (r1 == 0) goto L3f
            goto L3c
        L34:
            r0 = move-exception
            goto L40
        L36:
            r2 = move-exception
            r2.printStackTrace()     // Catch: java.lang.Throwable -> L34
            if (r1 == 0) goto L3f
        L3c:
            r1.close()
        L3f:
            return r0
        L40:
            if (r1 == 0) goto L45
            r1.close()
        L45:
            goto L47
        L46:
            throw r0
        L47:
            goto L46
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.message.inapp.InAppMessageManager.b():java.util.ArrayList");
    }

    public final String a(String str) {
        return a("KEY_LAST_CARD_ID_".concat(String.valueOf(str)), "");
    }

    public final void a(String str, int i10) {
        if (i10 == 0) {
            b(str, "0");
        }
        if (i10 == 1) {
            b(str, String.valueOf(d(str) + 1));
        }
    }

    public final String a(String str, String str2) {
        return this.f11373h.b(str, str2);
    }

    public final void a(final File file) {
        b.c(new Runnable() { // from class: com.umeng.message.inapp.InAppMessageManager.3
            @Override // java.lang.Runnable
            public final void run() {
                File file2 = file;
                if (file2 != null && file2.exists() && file.canWrite() && file.isDirectory()) {
                    for (File file3 : file.listFiles()) {
                        if (!file3.isDirectory()) {
                            file3.delete();
                        }
                    }
                    file.delete();
                }
            }
        });
    }

    public static /* synthetic */ af a(InAppMessageManager inAppMessageManager, String str) {
        Cursor query = inAppMessageManager.f11370b.getContentResolver().query(h.e(inAppMessageManager.f11370b), null, "MsgId=?", new String[]{str}, null);
        af afVar = query != null ? query.moveToFirst() : false ? new af(query) : null;
        if (query != null) {
            query.close();
        }
        return afVar;
    }

    public final void b(final String str, final String str2) {
        b.c(new Runnable() { // from class: com.umeng.message.inapp.InAppMessageManager.2
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    InAppMessageManager.this.f11373h.a(str, str2);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }
}
