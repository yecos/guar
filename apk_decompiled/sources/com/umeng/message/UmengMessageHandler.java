package com.umeng.message;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Build;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.widget.RemoteViews;
import com.umeng.commonsdk.utils.UMUtils;
import com.umeng.message.api.UPushMessageHandler;
import com.umeng.message.common.UPLog;
import com.umeng.message.common.UPushNotificationChannel;
import com.umeng.message.component.UmengNotificationClickActivity;
import com.umeng.message.component.UmengNotificationReceiver;
import com.umeng.message.entity.UMessage;
import com.umeng.message.proguard.ad;
import com.umeng.message.proguard.ak;
import com.umeng.message.proguard.az;
import com.umeng.message.proguard.bj;
import com.umeng.message.proguard.bo;
import com.umeng.message.proguard.d;
import com.umeng.message.proguard.f;
import com.umeng.message.proguard.x;
import com.umeng.message.proguard.z;
import com.umeng.message.push.R;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/* loaded from: classes3.dex */
public class UmengMessageHandler implements UPushMessageHandler {

    /* renamed from: a, reason: collision with root package name */
    private static Date f11348a;

    /* renamed from: b, reason: collision with root package name */
    private int f11349b;

    /* JADX WARN: Multi-variable type inference failed */
    private Notification a(Context context, UMessage uMessage) {
        Bitmap bitmap;
        String str;
        String str2;
        int i10;
        String id;
        Notification.Builder builder = new Notification.Builder(context);
        String category = uMessage.getCategory();
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 21 && !TextUtils.isEmpty(category)) {
            builder.setCategory(category);
        }
        if (i11 >= 26) {
            NotificationChannel notificationChannel = getNotificationChannel(context, uMessage);
            if (notificationChannel == null) {
                notificationChannel = (uMessage.getImportance() == 1 && d.g()) ? UPushNotificationChannel.getSilenceMode(context) : isInNoDisturbTime(context) ? UPushNotificationChannel.getSilenceMode(context) : UPushNotificationChannel.getDefaultMode(context);
            }
            if (notificationChannel == null) {
                UPLog.e("MsgHandler", "notification channel null!");
                return null;
            }
            id = notificationChannel.getId();
            builder.setChannelId(id);
        }
        int smallIconId = getSmallIconId(context, uMessage);
        if (smallIconId < 0) {
            UPLog.e("MsgHandler", "notification small icon error!");
            return null;
        }
        Bitmap largeIcon = getLargeIcon(context, uMessage);
        Bitmap expandImage = getExpandImage(context, uMessage);
        String title = uMessage.getTitle();
        String content = uMessage.getContent();
        String titleColor = uMessage.getTitleColor();
        if (!TextUtils.isEmpty(titleColor) && !TextUtils.isEmpty(title)) {
            try {
                int parseColor = Color.parseColor(titleColor);
                SpannableString spannableString = new SpannableString(title);
                spannableString.setSpan(new ForegroundColorSpan(parseColor), 0, title.length(), 34);
                title = spannableString;
            } catch (Exception unused) {
            }
        }
        String textColor = uMessage.getTextColor();
        if (!TextUtils.isEmpty(textColor) && !TextUtils.isEmpty(content)) {
            try {
                int parseColor2 = Color.parseColor(textColor);
                SpannableString spannableString2 = new SpannableString(content);
                spannableString2.setSpan(new ForegroundColorSpan(parseColor2), 0, content.length(), 34);
                content = spannableString2;
            } catch (Exception unused2) {
            }
        }
        builder.setTicker(uMessage.getTicker());
        builder.setSmallIcon(smallIconId);
        builder.setContentTitle(title);
        builder.setContentText(content);
        builder.setAutoCancel(true);
        int i12 = Build.VERSION.SDK_INT;
        Bitmap backgroundImage = (i12 < 26 || !uMessage.hasBackgroundImage()) ? null : getBackgroundImage(context, uMessage);
        if (i12 < 26 || backgroundImage == null) {
            bitmap = expandImage;
            str = titleColor;
            str2 = textColor;
            if (!TextUtils.isEmpty(uMessage.getBarImageUrl())) {
                RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.upush_notification_banner_layout);
                remoteViews.setImageViewBitmap(R.id.upush_notification_banner, getBarImage(context, uMessage));
                if (i12 >= 24) {
                    builder.setCustomContentView(remoteViews);
                    if (context.getApplicationInfo().targetSdkVersion >= 31) {
                        builder.setCustomBigContentView(remoteViews);
                    }
                } else {
                    builder.setContent(remoteViews);
                }
            } else if (largeIcon != null) {
                builder.setLargeIcon(largeIcon);
            }
        } else {
            builder.setGroupSummary(d.h());
            builder.setGroup(uMessage.msg_id);
            int i13 = R.layout.upush_notification_shade_layout;
            int i14 = R.id.upush_notification_small_icon;
            int i15 = R.id.upush_notification_app_name;
            int i16 = R.id.upush_notification_date;
            int i17 = R.id.upush_notification_title;
            int i18 = R.id.upush_notification_content;
            int i19 = R.id.upush_notification_shade_iv;
            str2 = textColor;
            int i20 = R.id.upush_notification_large_iv;
            str = titleColor;
            bitmap = expandImage;
            RemoteViews remoteViews2 = new RemoteViews(context.getPackageName(), i13);
            remoteViews2.setImageViewResource(i14, smallIconId);
            remoteViews2.setTextViewText(i15, UMUtils.getAppName(context));
            long msgTime = uMessage.getMsgTime();
            remoteViews2.setTextViewText(i16, (f.a(msgTime) ? new SimpleDateFormat("HH:mm", Locale.getDefault()) : new SimpleDateFormat("yyyy/MM/dd", Locale.getDefault())).format(Long.valueOf(msgTime)));
            remoteViews2.setTextViewText(i17, title);
            if (TextUtils.isEmpty(content)) {
                remoteViews2.setViewVisibility(i18, 8);
                i10 = 0;
            } else {
                i10 = 0;
                remoteViews2.setViewVisibility(i18, 0);
                remoteViews2.setTextViewText(i18, content);
            }
            if (largeIcon != null) {
                remoteViews2.setViewVisibility(i20, i10);
                remoteViews2.setImageViewBitmap(i20, largeIcon);
            } else {
                remoteViews2.setViewVisibility(i20, 8);
            }
            remoteViews2.setViewVisibility(i19, i10);
            remoteViews2.setImageViewBitmap(i19, backgroundImage);
            builder.setCustomContentView(remoteViews2);
            if (context.getApplicationInfo().targetSdkVersion >= 31) {
                builder.setCustomBigContentView(remoteViews2);
            }
            builder.setStyle(new Notification.DecoratedCustomViewStyle());
        }
        if (bitmap != null) {
            Notification.BigPictureStyle bigPictureStyle = new Notification.BigPictureStyle();
            bigPictureStyle.bigPicture(bitmap);
            bigPictureStyle.bigLargeIcon(largeIcon);
            builder.setStyle(bigPictureStyle);
        } else if (!TextUtils.isEmpty(uMessage.getBigBody())) {
            String bigTitle = uMessage.getBigTitle();
            if (bigTitle != null && bigTitle.length() != 0) {
                title = bigTitle;
            }
            String bigBody = uMessage.getBigBody();
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(title)) {
                try {
                    int parseColor3 = Color.parseColor(str);
                    SpannableString spannableString3 = new SpannableString(title);
                    spannableString3.setSpan(new ForegroundColorSpan(parseColor3), 0, title.length(), 34);
                    title = spannableString3;
                } catch (Exception unused3) {
                }
            }
            if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(bigBody)) {
                try {
                    int parseColor4 = Color.parseColor(str2);
                    SpannableString spannableString4 = new SpannableString(bigBody);
                    spannableString4.setSpan(new ForegroundColorSpan(parseColor4), 0, bigBody.length(), 34);
                    bigBody = spannableString4;
                } catch (Exception unused4) {
                }
            }
            Notification.BigTextStyle bigTextStyle = new Notification.BigTextStyle();
            bigTextStyle.setBigContentTitle(title);
            bigTextStyle.bigText(bigBody);
            builder.setStyle(bigTextStyle);
        }
        return builder.getNotification();
    }

    public void dealWithCustomMessage(Context context, UMessage uMessage) {
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0126 A[Catch: Exception -> 0x01db, TryCatch #0 {Exception -> 0x01db, blocks: (B:23:0x0083, B:27:0x009f, B:28:0x00da, B:31:0x00ea, B:34:0x0126, B:37:0x012f, B:39:0x0139, B:41:0x013f, B:42:0x0157, B:45:0x0163, B:46:0x016c, B:49:0x0174, B:51:0x017a, B:55:0x0182, B:56:0x0187, B:61:0x0194, B:63:0x019e, B:65:0x01ae, B:67:0x01b2, B:69:0x01b6, B:71:0x01bc, B:72:0x00f4, B:75:0x00fa, B:78:0x0107, B:80:0x0113, B:82:0x0119, B:83:0x00c6, B:86:0x00d1), top: B:22:0x0083 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x012f A[Catch: Exception -> 0x01db, TryCatch #0 {Exception -> 0x01db, blocks: (B:23:0x0083, B:27:0x009f, B:28:0x00da, B:31:0x00ea, B:34:0x0126, B:37:0x012f, B:39:0x0139, B:41:0x013f, B:42:0x0157, B:45:0x0163, B:46:0x016c, B:49:0x0174, B:51:0x017a, B:55:0x0182, B:56:0x0187, B:61:0x0194, B:63:0x019e, B:65:0x01ae, B:67:0x01b2, B:69:0x01b6, B:71:0x01bc, B:72:0x00f4, B:75:0x00fa, B:78:0x0107, B:80:0x0113, B:82:0x0119, B:83:0x00c6, B:86:0x00d1), top: B:22:0x0083 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void dealWithNotificationMessage(android.content.Context r14, com.umeng.message.entity.UMessage r15) {
        /*
            Method dump skipped, instructions count: 483
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.message.UmengMessageHandler.dealWithNotificationMessage(android.content.Context, com.umeng.message.entity.UMessage):void");
    }

    public Bitmap getBackgroundImage(Context context, UMessage uMessage) {
        try {
            String backgroundImageUrl = uMessage.getBackgroundImageUrl();
            if (TextUtils.isEmpty(backgroundImageUrl)) {
                return null;
            }
            return f.a(new File(f.g(context), UMUtils.MD5(backgroundImageUrl)), bo.a(), bo.a(64.0f));
        } catch (Throwable th) {
            UPLog.e("MsgHandler", th);
            return null;
        }
    }

    public Bitmap getBarImage(Context context, UMessage uMessage) {
        try {
            String barImageUrl = uMessage.getBarImageUrl();
            if (TextUtils.isEmpty(barImageUrl)) {
                return null;
            }
            return f.a(new File(f.g(context), UMUtils.MD5(barImageUrl)), bo.a(), bo.a(64.0f));
        } catch (Throwable th) {
            UPLog.e("MsgHandler", th);
            return null;
        }
    }

    public PendingIntent getClickPendingIntent(Context context, UMessage uMessage) {
        Intent intent = new Intent();
        intent.setFlags(335544320);
        intent.setClass(context, UmengNotificationClickActivity.class);
        intent.putExtra("MSG", uMessage.getRaw().toString());
        intent.putExtra("NOTIFICATION_ID", this.f11349b);
        return PendingIntent.getActivity(context, (int) System.currentTimeMillis(), intent, Build.VERSION.SDK_INT < 23 ? 268435456 : 335544320);
    }

    public PendingIntent getDismissPendingIntent(Context context, UMessage uMessage) {
        Intent intent = new Intent();
        intent.setClass(context, UmengNotificationReceiver.class);
        intent.putExtra("MSG", uMessage.getRaw().toString());
        intent.putExtra("ACTION", 11);
        intent.putExtra("NOTIFICATION_ID", this.f11349b);
        return PendingIntent.getBroadcast(context, (int) (System.currentTimeMillis() + 1), intent, Build.VERSION.SDK_INT >= 23 ? 335544320 : 268435456);
    }

    public Bitmap getExpandImage(Context context, UMessage uMessage) {
        try {
            String bigImage = uMessage.getBigImage();
            if (TextUtils.isEmpty(bigImage)) {
                return null;
            }
            return f.a(new File(f.g(context), UMUtils.MD5(bigImage)), bo.a(), bo.a(256.0f));
        } catch (Throwable th) {
            UPLog.e("MsgHandler", th);
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0055 A[Catch: all -> 0x005e, TRY_LEAVE, TryCatch #2 {all -> 0x005e, blocks: (B:3:0x0003, B:5:0x0009, B:9:0x0014, B:11:0x0033, B:25:0x003d, B:16:0x0055, B:14:0x0047, B:28:0x0043, B:22:0x004f), top: B:2:0x0003, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.graphics.Bitmap getLargeIcon(android.content.Context r6, com.umeng.message.entity.UMessage r7) {
        /*
            r5 = this;
            java.lang.String r0 = "MsgHandler"
            r1 = 0
            boolean r2 = r7.isLargeIconFromInternet()     // Catch: java.lang.Throwable -> L5e
            if (r2 == 0) goto L30
            java.lang.String r2 = r7.getLargeIconUrl()     // Catch: java.lang.Throwable -> L5e
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Throwable -> L5e
            if (r3 == 0) goto L14
            return r1
        L14:
            java.io.File r3 = new java.io.File     // Catch: java.lang.Throwable -> L5e
            java.io.File r4 = com.umeng.message.proguard.f.g(r6)     // Catch: java.lang.Throwable -> L5e
            java.lang.String r2 = com.umeng.commonsdk.utils.UMUtils.MD5(r2)     // Catch: java.lang.Throwable -> L5e
            r3.<init>(r4, r2)     // Catch: java.lang.Throwable -> L5e
            r2 = 1111490560(0x42400000, float:48.0)
            int r4 = com.umeng.message.proguard.bo.a(r2)     // Catch: java.lang.Throwable -> L5e
            int r2 = com.umeng.message.proguard.bo.a(r2)     // Catch: java.lang.Throwable -> L5e
            android.graphics.Bitmap r2 = com.umeng.message.proguard.f.a(r3, r4, r2)     // Catch: java.lang.Throwable -> L5e
            goto L31
        L30:
            r2 = r1
        L31:
            if (r2 != 0) goto L5d
            java.lang.String r7 = r7.getLargeIconDrawableName()     // Catch: java.lang.Throwable -> L5e
            boolean r3 = android.text.TextUtils.isEmpty(r7)     // Catch: java.lang.Throwable -> L5e
            if (r3 != 0) goto L47
            int r7 = com.umeng.message.proguard.a.c(r7)     // Catch: java.lang.Exception -> L42 java.lang.Throwable -> L5e
            goto L53
        L42:
            r7 = move-exception
            com.umeng.message.common.UPLog.w(r0, r7)     // Catch: java.lang.Throwable -> L5e
            goto L52
        L47:
            java.lang.String r7 = "umeng_push_notification_default_large_icon"
            int r7 = com.umeng.message.proguard.a.c(r7)     // Catch: java.lang.Exception -> L4e java.lang.Throwable -> L5e
            goto L53
        L4e:
            r7 = move-exception
            com.umeng.message.common.UPLog.w(r0, r7)     // Catch: java.lang.Throwable -> L5e
        L52:
            r7 = -1
        L53:
            if (r7 <= 0) goto L5d
            android.content.res.Resources r6 = r6.getResources()     // Catch: java.lang.Throwable -> L5e
            android.graphics.Bitmap r2 = android.graphics.BitmapFactory.decodeResource(r6, r7)     // Catch: java.lang.Throwable -> L5e
        L5d:
            return r2
        L5e:
            r6 = move-exception
            com.umeng.message.common.UPLog.e(r0, r6)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.message.UmengMessageHandler.getLargeIcon(android.content.Context, com.umeng.message.entity.UMessage):android.graphics.Bitmap");
    }

    public Notification getNotification(Context context, UMessage uMessage) {
        return null;
    }

    public NotificationChannel getNotificationChannel() {
        return null;
    }

    public int getNotificationDefaults(Context context, UMessage uMessage) {
        Calendar calendar = Calendar.getInstance();
        if (isInNoDisturbTime(context)) {
            return 0;
        }
        MessageSharedPrefs messageSharedPrefs = MessageSharedPrefs.getInstance(context);
        long g10 = messageSharedPrefs.g() * 1000;
        if (f11348a != null && calendar.getTimeInMillis() - f11348a.getTime() < g10) {
            return 0;
        }
        int i10 = messageSharedPrefs.i();
        UPLog.i("MsgHandler", "vibrate:", Integer.valueOf(i10));
        int i11 = (i10 != 1 && (i10 == 2 || !uMessage.isVibrate())) ? 0 : 2;
        int j10 = messageSharedPrefs.j();
        UPLog.i("MsgHandler", "lights:", Integer.valueOf(j10));
        if (j10 == 1 || (j10 != 2 && uMessage.isLights())) {
            i11 |= 4;
        }
        int k10 = messageSharedPrefs.k();
        UPLog.i("MsgHandler", "sound:", Integer.valueOf(k10));
        if (k10 == 1 || (k10 != 2 && uMessage.isSound())) {
            i11 |= 1;
        }
        f11348a = calendar.getTime();
        return i11;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0038 A[Catch: all -> 0x0042, TRY_LEAVE, TryCatch #1 {all -> 0x0042, blocks: (B:3:0x0003, B:19:0x000d, B:9:0x0026, B:11:0x0038, B:6:0x0017, B:22:0x0013, B:17:0x001f), top: B:2:0x0003, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0026 A[Catch: all -> 0x0042, TryCatch #1 {all -> 0x0042, blocks: (B:3:0x0003, B:19:0x000d, B:9:0x0026, B:11:0x0038, B:6:0x0017, B:22:0x0013, B:17:0x001f), top: B:2:0x0003, inners: #0, #2 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int getSmallIconId(android.content.Context r6, com.umeng.message.entity.UMessage r7) {
        /*
            r5 = this;
            java.lang.String r0 = "MsgHandler"
            r1 = -1
            java.lang.String r7 = r7.getSmallIconDrawableName()     // Catch: java.lang.Throwable -> L42
            boolean r2 = android.text.TextUtils.isEmpty(r7)     // Catch: java.lang.Throwable -> L42
            if (r2 != 0) goto L17
            int r1 = com.umeng.message.proguard.a.c(r7)     // Catch: java.lang.Exception -> L12 java.lang.Throwable -> L42
            goto L22
        L12:
            r7 = move-exception
            com.umeng.message.common.UPLog.w(r0, r7)     // Catch: java.lang.Throwable -> L42
            goto L22
        L17:
            java.lang.String r7 = "umeng_push_notification_default_small_icon"
            int r1 = com.umeng.message.proguard.a.c(r7)     // Catch: java.lang.Exception -> L1e java.lang.Throwable -> L42
            goto L22
        L1e:
            r7 = move-exception
            com.umeng.message.common.UPLog.w(r0, r7)     // Catch: java.lang.Throwable -> L42
        L22:
            r7 = 0
            r2 = 1
            if (r1 >= 0) goto L36
            java.lang.Object[] r3 = new java.lang.Object[r2]     // Catch: java.lang.Throwable -> L42
            java.lang.String r4 = "no custom notification small icon! change to use app icon"
            r3[r7] = r4     // Catch: java.lang.Throwable -> L42
            com.umeng.message.common.UPLog.i(r0, r3)     // Catch: java.lang.Throwable -> L42
            android.content.pm.ApplicationInfo r6 = r6.getApplicationInfo()     // Catch: java.lang.Throwable -> L42
            int r6 = r6.icon     // Catch: java.lang.Throwable -> L42
            r1 = r6
        L36:
            if (r1 >= 0) goto L46
            java.lang.Object[] r6 = new java.lang.Object[r2]     // Catch: java.lang.Throwable -> L42
            java.lang.String r2 = "can't find notification small icon"
            r6[r7] = r2     // Catch: java.lang.Throwable -> L42
            com.umeng.message.common.UPLog.e(r0, r6)     // Catch: java.lang.Throwable -> L42
            goto L46
        L42:
            r6 = move-exception
            com.umeng.message.common.UPLog.e(r0, r6)
        L46:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.message.UmengMessageHandler.getSmallIconId(android.content.Context, com.umeng.message.entity.UMessage):int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0020, code lost:
    
        if (r1.exists() == false) goto L7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.net.Uri getSound(android.content.Context r5, com.umeng.message.entity.UMessage r6) {
        /*
            r4 = this;
            r0 = 0
            boolean r1 = r6.isSoundFromInternet()     // Catch: java.lang.Throwable -> L64
            if (r1 == 0) goto L22
            java.io.File r1 = new java.io.File     // Catch: java.lang.Throwable -> L64
            java.io.File r2 = com.umeng.message.proguard.f.g(r5)     // Catch: java.lang.Throwable -> L64
            java.lang.String r3 = r6.getSoundUri()     // Catch: java.lang.Throwable -> L64
            java.lang.String r3 = com.umeng.commonsdk.utils.UMUtils.MD5(r3)     // Catch: java.lang.Throwable -> L64
            r1.<init>(r2, r3)     // Catch: java.lang.Throwable -> L64
            java.lang.String r2 = r1.getPath()     // Catch: java.lang.Throwable -> L64
            boolean r1 = r1.exists()     // Catch: java.lang.Throwable -> L64
            if (r1 != 0) goto L23
        L22:
            r2 = r0
        L23:
            if (r2 != 0) goto L5d
            java.lang.String r1 = r6.getSoundUri()     // Catch: java.lang.Throwable -> L64
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Throwable -> L64
            if (r1 != 0) goto L38
            java.lang.String r6 = r6.getSoundUri()     // Catch: java.lang.Throwable -> L64
            int r6 = com.umeng.message.proguard.a.d(r6)     // Catch: java.lang.Throwable -> L64
            goto L39
        L38:
            r6 = -1
        L39:
            if (r6 >= 0) goto L41
            java.lang.String r6 = "umeng_push_notification_default_sound"
            int r6 = com.umeng.message.proguard.a.d(r6)     // Catch: java.lang.Throwable -> L64
        L41:
            if (r6 <= 0) goto L5d
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L64
            java.lang.String r2 = "android.resource://"
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L64
            java.lang.String r5 = r5.getPackageName()     // Catch: java.lang.Throwable -> L64
            r1.append(r5)     // Catch: java.lang.Throwable -> L64
            java.lang.String r5 = "/"
            r1.append(r5)     // Catch: java.lang.Throwable -> L64
            r1.append(r6)     // Catch: java.lang.Throwable -> L64
            java.lang.String r2 = r1.toString()     // Catch: java.lang.Throwable -> L64
        L5d:
            if (r2 == 0) goto L6a
            android.net.Uri r5 = android.net.Uri.parse(r2)     // Catch: java.lang.Throwable -> L64
            return r5
        L64:
            r5 = move-exception
            java.lang.String r6 = "MsgHandler"
            com.umeng.message.common.UPLog.w(r6, r5)
        L6a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.message.UmengMessageHandler.getSound(android.content.Context, com.umeng.message.entity.UMessage):android.net.Uri");
    }

    @Override // com.umeng.message.api.UPushMessageHandler
    public void handleMessage(Context context, UMessage uMessage) {
        if ("notification".equals(uMessage.getDisplayType())) {
            dealWithNotificationMessage(context, uMessage);
            return;
        }
        if ("custom".equals(uMessage.getDisplayType())) {
            if (TextUtils.isEmpty(uMessage.getRecallMsgId())) {
                dealWithCustomMessage(context, uMessage);
                return;
            }
            try {
                x a10 = x.a();
                ad a11 = a10.a(uMessage.getRecallMsgId());
                if (a11 != null) {
                    NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
                    if (notificationManager != null) {
                        notificationManager.cancel("um", a11.f11453a);
                    }
                    a10.b(a11);
                    az.a(a11);
                    z.a().a(uMessage.getRecallMsgId(), 4);
                } else {
                    z.a().a(uMessage.getRecallMsgId(), 5);
                }
                ak.a().a(uMessage.getRecallMsgId());
            } catch (Throwable th) {
                UPLog.e("MsgHandler", th);
            }
        }
    }

    public boolean isInNoDisturbTime(Context context) {
        Calendar calendar = Calendar.getInstance();
        int i10 = (calendar.get(11) * 60) + calendar.get(12);
        boolean z10 = i10 >= (PushAgent.getInstance(context).getNoDisturbStartHour() * 60) + PushAgent.getInstance(context).getNoDisturbStartMinute();
        boolean z11 = i10 <= (PushAgent.getInstance(context).getNoDisturbEndHour() * 60) + PushAgent.getInstance(context).getNoDisturbEndMinute();
        return (PushAgent.getInstance(context).getNoDisturbEndHour() * 60) + PushAgent.getInstance(context).getNoDisturbEndMinute() >= (PushAgent.getInstance(context).getNoDisturbStartHour() * 60) + PushAgent.getInstance(context).getNoDisturbStartMinute() ? z10 && z11 : z10 || z11;
    }

    public void setBadgeNum(Context context, UMessage uMessage) {
        if (uMessage.getBadgeSet() >= 0) {
            bj.a(context, uMessage.getBadgeSet());
            UPLog.i("MsgHandler", "setBadgeNum:", Integer.valueOf(uMessage.getBadgeSet()));
        } else if (uMessage.getBadgeAdd() != 0) {
            bj.b(context, uMessage.getBadgeAdd());
            UPLog.i("MsgHandler", "changeBadgeNum:", Integer.valueOf(uMessage.getBadgeAdd()));
        }
    }

    public NotificationChannel getNotificationChannel(Context context, UMessage uMessage) {
        return getNotificationChannel();
    }
}
