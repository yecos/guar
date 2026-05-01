package com.umeng.message.proguard;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.taobao.accs.common.Constants;
import com.umeng.message.api.UPushThirdTokenCallback;
import com.umeng.message.common.UPLog;
import org.simpleframework.xml.strategy.Name;

/* loaded from: classes3.dex */
public final class bj {

    /* renamed from: a, reason: collision with root package name */
    private static Boolean f11646a;

    /* renamed from: b, reason: collision with root package name */
    private static int f11647b;

    /* renamed from: c, reason: collision with root package name */
    private static final Handler f11648c = new Handler(Looper.getMainLooper()) { // from class: com.umeng.message.proguard.bj.4
        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            int i10 = message.what;
            if (1 == i10) {
                bj.a(message.arg1);
                removeMessages(2);
                Message obtainMessage = obtainMessage(2);
                obtainMessage.obj = message.obj;
                message.obj = null;
                sendMessageDelayed(obtainMessage, 500L);
                return;
            }
            if (2 == i10) {
                final int i11 = bj.f11647b;
                bj.c();
                final Context context = (Context) message.obj;
                message.obj = null;
                if (context == null) {
                    return;
                }
                b.c(new Runnable() { // from class: com.umeng.message.proguard.bj.4.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        String str;
                        if (bj.f11646a == null || bj.f11646a.booleanValue()) {
                            try {
                                ComponentName a10 = bj.a(context);
                                if (a10 == null) {
                                    Boolean unused = bj.f11646a = Boolean.FALSE;
                                    return;
                                }
                                Uri parse = Uri.parse("content://com.huawei.android.launcher.settings/badge/");
                                try {
                                    str = context.getContentResolver().getType(parse);
                                } catch (Throwable unused2) {
                                    str = null;
                                }
                                if (TextUtils.isEmpty(str)) {
                                    parse = Uri.parse("content://com.hihonor.android.launcher.settings/badge/");
                                    str = context.getContentResolver().getType(parse);
                                }
                                if (str == null) {
                                    Boolean unused3 = bj.f11646a = Boolean.FALSE;
                                    return;
                                }
                                UPLog.i("Badge", "hw changeBadgeNum:", Integer.valueOf(i11));
                                Bundle bundle = new Bundle();
                                bundle.putString(Constants.KEY_PACKAGE, a10.getPackageName());
                                bundle.putString(Name.LABEL, a10.getClassName());
                                Bundle call = context.getContentResolver().call(parse, "getbadgeNumber", (String) null, bundle);
                                int i12 = call != null ? call.getInt("badgenumber", 0) : 0;
                                int max = Math.max(0, i11 + i12);
                                if (i12 != max) {
                                    bundle.putInt("badgenumber", max);
                                    context.getContentResolver().call(parse, "change_badge", (String) null, bundle);
                                }
                                UPLog.i("Badge", "hw changeBadgeNum cur:", Integer.valueOf(max), "last:", Integer.valueOf(i12));
                                Boolean unused4 = bj.f11646a = Boolean.TRUE;
                            } catch (Throwable unused5) {
                                Boolean unused6 = bj.f11646a = Boolean.FALSE;
                            }
                        }
                    }
                });
            }
        }
    };

    public static /* synthetic */ int a(int i10) {
        int i11 = f11647b + i10;
        f11647b = i11;
        return i11;
    }

    public static /* synthetic */ int c() {
        f11647b = 0;
        return 0;
    }

    public static void b(Context context, int i10) {
        Boolean bool = f11646a;
        if (bool == null || bool.booleanValue()) {
            String str = Build.MANUFACTURER;
            if ("huawei".equalsIgnoreCase(str) || UPushThirdTokenCallback.TYPE_HONOR.equalsIgnoreCase(str)) {
                Handler handler = f11648c;
                Message obtainMessage = handler.obtainMessage(1);
                obtainMessage.arg1 = i10;
                obtainMessage.obj = context;
                handler.sendMessage(obtainMessage);
            }
        }
    }

    public static void a(final Context context, final int i10) {
        Boolean bool = f11646a;
        if (bool == null || bool.booleanValue()) {
            String str = Build.MANUFACTURER;
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if ("oppo".equalsIgnoreCase(str)) {
                b.b(new Runnable() { // from class: com.umeng.message.proguard.bj.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (bj.f11646a == null || bj.f11646a.booleanValue()) {
                            try {
                                Bundle bundle = new Bundle();
                                bundle.putInt("app_badge_count", i10);
                                context.getContentResolver().call(Uri.parse("content://com.android.badge/badge"), "setAppBadgeCount", (String) null, bundle);
                                UPLog.i("Badge", "oppo setBadgeNum:", Integer.valueOf(i10));
                                Boolean unused = bj.f11646a = Boolean.TRUE;
                            } catch (Throwable unused2) {
                                Boolean unused3 = bj.f11646a = Boolean.FALSE;
                            }
                        }
                    }
                });
                return;
            }
            if ("vivo".equalsIgnoreCase(str)) {
                b.b(new Runnable() { // from class: com.umeng.message.proguard.bj.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (bj.f11646a == null || bj.f11646a.booleanValue()) {
                            try {
                                ComponentName a10 = bj.a(context);
                                if (a10 == null) {
                                    Boolean unused = bj.f11646a = Boolean.FALSE;
                                    return;
                                }
                                Intent intent = new Intent();
                                intent.setAction("launcher.action.CHANGE_APPLICATION_NOTIFICATION_NUM");
                                intent.putExtra(Constants.KEY_PACKAGE_NAME, a10.getPackageName());
                                intent.putExtra("className", a10.getClassName());
                                intent.putExtra("notificationNum", i10);
                                if (Build.VERSION.SDK_INT >= 26) {
                                    intent.addFlags(16777216);
                                }
                                context.sendBroadcast(intent);
                                UPLog.i("Badge", "vivo setBadgeNum:", Integer.valueOf(i10));
                                Boolean unused2 = bj.f11646a = Boolean.TRUE;
                            } catch (Throwable unused3) {
                                Boolean unused4 = bj.f11646a = Boolean.FALSE;
                            }
                        }
                    }
                });
            } else if ("huawei".equalsIgnoreCase(str) || UPushThirdTokenCallback.TYPE_HONOR.equalsIgnoreCase(str)) {
                b.b(new Runnable() { // from class: com.umeng.message.proguard.bj.3
                    @Override // java.lang.Runnable
                    public final void run() {
                        String str2;
                        if (bj.f11646a == null || bj.f11646a.booleanValue()) {
                            try {
                                Uri parse = Uri.parse("content://com.huawei.android.launcher.settings/badge/");
                                try {
                                    str2 = context.getContentResolver().getType(parse);
                                } catch (Throwable unused) {
                                    str2 = null;
                                }
                                if (TextUtils.isEmpty(str2)) {
                                    parse = Uri.parse("content://com.hihonor.android.launcher.settings/badge/");
                                    str2 = context.getContentResolver().getType(parse);
                                }
                                if (str2 == null) {
                                    Boolean unused2 = bj.f11646a = Boolean.FALSE;
                                    return;
                                }
                                ComponentName a10 = bj.a(context);
                                if (a10 == null) {
                                    Boolean unused3 = bj.f11646a = Boolean.FALSE;
                                    return;
                                }
                                Bundle bundle = new Bundle();
                                bundle.putString(Constants.KEY_PACKAGE, a10.getPackageName());
                                bundle.putString(Name.LABEL, a10.getClassName());
                                bundle.putInt("badgenumber", i10);
                                context.getContentResolver().call(parse, "change_badge", (String) null, bundle);
                                UPLog.i("Badge", "hw setBadgeNum:", Integer.valueOf(i10));
                                Boolean unused4 = bj.f11646a = Boolean.TRUE;
                            } catch (Throwable unused5) {
                                Boolean unused6 = bj.f11646a = Boolean.FALSE;
                            }
                        }
                    }
                });
            }
        }
    }

    public static /* synthetic */ ComponentName a(Context context) {
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());
        if (launchIntentForPackage != null) {
            return launchIntentForPackage.getComponent();
        }
        return null;
    }
}
