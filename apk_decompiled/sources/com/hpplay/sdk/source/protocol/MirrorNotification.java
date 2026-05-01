package com.hpplay.sdk.source.protocol;

import android.R;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.text.TextUtils;
import com.hpplay.sdk.source.common.utils.HapplayUtils;
import com.hpplay.sdk.source.log.SourceLog;
import com.hpplay.sdk.source.process.LelinkReceiver;
import com.hpplay.sdk.source.utils.Feature;

/* loaded from: classes3.dex */
public class MirrorNotification {
    private static final int PENDING_INTENT_FLAG_MUTABLE = 33554432;
    private static final String TAG = "MirrorNotification";
    public static final String ZTE_ACTION_CASTING_SERVICE_CLICK_FILTER = "casting.service.notification.click.filter";
    public static final String ZTE_CHANNEL_ID = "smart_cast_channel";
    public static final int ZTE_NOTIFICATION_ID = 110;

    private static Notification createZTENotification(Context context, String str) {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 < 26) {
            return null;
        }
        Notification.Builder builder = new Notification.Builder(context);
        Bitmap icon = getIcon(context);
        Icon createWithBitmap = icon != null ? Icon.createWithBitmap(icon) : null;
        if (createWithBitmap != null) {
            builder.setSmallIcon(createWithBitmap);
        } else {
            builder.setSmallIcon(R.drawable.sym_def_app_icon);
        }
        try {
            builder.setContentIntent(PendingIntent.getBroadcast(context, 1, new Intent(ZTE_ACTION_CASTING_SERVICE_CLICK_FILTER), i10 >= 31 ? PENDING_INTENT_FLAG_MUTABLE : 268435456));
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
        }
        builder.setAutoCancel(false);
        builder.setContentTitle(str);
        builder.setChannelId(ZTE_CHANNEL_ID);
        builder.setAutoCancel(false);
        builder.setOngoing(true);
        return builder.build();
    }

    private static NotificationChannel createZTENotificationChannel(Context context) {
        String appName = HapplayUtils.getAppName(context);
        if (Build.VERSION.SDK_INT < 26) {
            return null;
        }
        NotificationChannel notificationChannel = new NotificationChannel(ZTE_CHANNEL_ID, appName, 1);
        notificationChannel.enableLights(false);
        notificationChannel.enableVibration(false);
        notificationChannel.setSound(null, null);
        notificationChannel.setShowBadge(false);
        return notificationChannel;
    }

    public static synchronized Bitmap getIcon(Context context) {
        Bitmap bitmap;
        synchronized (MirrorNotification.class) {
            try {
                PackageManager packageManager = context.getApplicationContext().getPackageManager();
                bitmap = ((BitmapDrawable) packageManager.getApplicationIcon(packageManager.getApplicationInfo(context.getPackageName(), 0))).getBitmap();
            } catch (Exception unused) {
                return null;
            }
        }
        return bitmap;
    }

    public Notification createNotification(Context context, String str, int i10) {
        String str2;
        Notification.Action build;
        if (Feature.isZTEChannel()) {
            return createZTENotification(context, str);
        }
        SourceLog.i(TAG, "createNotification");
        int i11 = Build.VERSION.SDK_INT;
        if (i11 < 26) {
            Notification build2 = new Notification.Builder(context).build();
            build2.flags = 64;
            build2.defaults = 1;
            return build2;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("已连接到 ");
        if (TextUtils.isEmpty(str)) {
            str = "接收端";
        }
        sb.append(str);
        String sb2 = sb.toString();
        Notification.Builder builder = new Notification.Builder(context);
        builder.setAutoCancel(false);
        builder.setShowWhen(false);
        Bitmap icon = getIcon(context);
        Icon createWithBitmap = icon != null ? Icon.createWithBitmap(icon) : null;
        if (createWithBitmap != null) {
            builder.setSmallIcon(createWithBitmap);
        } else {
            builder.setSmallIcon(R.drawable.sym_def_app_icon);
        }
        builder.setContentTitle(sb2);
        builder.setChannelId("DlnaService");
        if (i10 != 2) {
            try {
                Intent intent = new Intent(context, (Class<?>) LelinkReceiver.class);
                intent.setAction("com.hpplay.source.service.close");
                intent.setPackage(context.getPackageName());
                intent.setClass(context, LelinkReceiver.class);
                PendingIntent broadcast = PendingIntent.getBroadcast(context, 0, intent, i11 >= 31 ? PENDING_INTENT_FLAG_MUTABLE : 268435456);
                try {
                    str2 = context.getResources().getString(context.getResources().getIdentifier("dlna_disconnect", "string", context.getPackageName()));
                } catch (Exception unused) {
                    str2 = null;
                }
                if (TextUtils.isEmpty(str2)) {
                    str2 = "停止镜像";
                }
                build = new Notification.Action.Builder((Icon) null, str2, broadcast).build();
                builder.addAction(build);
                builder.setContentIntent(broadcast);
            } catch (Exception e10) {
                SourceLog.w(TAG, e10);
            }
        }
        return builder.build();
    }

    public NotificationChannel createNotificationChannel(Context context) {
        if (Feature.isZTEChannel()) {
            return createZTENotificationChannel(context);
        }
        if (Build.VERSION.SDK_INT < 26) {
            return null;
        }
        NotificationChannel notificationChannel = new NotificationChannel("DlnaService", "乐播截屏", 3);
        notificationChannel.enableLights(false);
        notificationChannel.enableVibration(false);
        notificationChannel.setSound(null, null);
        notificationChannel.setShowBadge(false);
        return notificationChannel;
    }
}
