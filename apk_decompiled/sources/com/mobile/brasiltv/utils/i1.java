package com.mobile.brasiltv.utils;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hpplay.sdk.source.common.global.Constant;
import com.mobile.brasiltv.view.dialog.DialogManager;
import com.titans.entity.CdnType;
import com.umeng.analytics.AnalyticsConfig;
import com.umeng.analytics.MobclickAgent;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public abstract class i1 {

    public class a implements Consumer {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f8720a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f8721b;

        public a(Context context, String str) {
            this.f8720a = context;
            this.f8721b = str;
        }

        @Override // io.reactivex.functions.Consumer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Long l10) {
            i1.e(this.f8720a, this.f8721b);
        }
    }

    public static void A(Context context, String str, long j10) {
        int intValue = Long.valueOf((System.currentTimeMillis() - j10) / 1000).intValue();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        HashMap hashMap = new HashMap();
        hashMap.put(AnalyticsConfig.RTD_START_TIME, simpleDateFormat.format(new Date()));
        hashMap.put("channelName", str);
        MobclickAgent.onEventValue(context, "CH_PLAY_LIVE", hashMap, intValue);
    }

    public static void B(Context context) {
        HashMap hashMap = new HashMap();
        hashMap.put(AnalyticsConfig.RTD_START_TIME, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        hashMap.put("apkVersion", e.a(context));
        hashMap.put("deviceModel", Build.MODEL);
        hashMap.put("sysVersion", Build.VERSION.RELEASE);
        MobclickAgent.onEvent(context.getApplicationContext(), "EVENT_NO_KEEP_ACTIVITIES", hashMap);
    }

    public static void C(Context context, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("userId", w6.i.f19214g.H());
        bundle.putString("sysVersion", Build.VERSION.RELEASE);
        bundle.putString("deviceModel", Build.MODEL);
        bundle.putString("buttonName", str);
        b(context).logEvent("EVENT_ORDER_CONFIRM", bundle);
    }

    public static void D(Context context, String str, int i10) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(AnalyticsConfig.RTD_START_TIME, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        hashMap.put("recommend_pos", String.valueOf(i10));
        d(context, str, hashMap);
    }

    public static void E(Context context, String str, String str2, String str3, long j10) {
        int intValue = Long.valueOf((System.currentTimeMillis() - j10) / 1000).intValue();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        HashMap hashMap = new HashMap();
        hashMap.put(AnalyticsConfig.RTD_START_TIME, simpleDateFormat.format(new Date()));
        hashMap.put("channelID", str);
        hashMap.put("channelName", str2);
        hashMap.put("recommendType", str3 + " ," + str2);
        MobclickAgent.onEventValue(context, "CH_PLAY_RECOMMEND", hashMap, intValue);
    }

    public static void F(Context context) {
        Bundle bundle = new Bundle();
        bundle.putString("sysVersion", Build.VERSION.RELEASE);
        bundle.putString("deviceModel", Build.MODEL);
        b(context).logEvent("EVENT_REFRESH_POPULAR_SEARCH", bundle);
    }

    public static void G(Context context, String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put(AnalyticsConfig.RTD_START_TIME, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        hashMap.put("sn", w6.i.f19214g.E());
        hashMap.put("deviceModel", Build.MODEL);
        hashMap.put("apkVersion", "6.2.1");
        hashMap.put("sysVersion", Build.VERSION.RELEASE);
        hashMap.put("step", str);
        hashMap.put("info", str2);
        d(context, "EVENT_REVIEW_CODE_NODE", hashMap);
        MobclickAgent.onEvent(context.getApplicationContext(), "EVENT_REVIEW_CODE_NODE", hashMap);
    }

    public static void H(Context context, Uri uri) {
        HashMap hashMap = new HashMap();
        hashMap.put(AnalyticsConfig.RTD_START_TIME, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        hashMap.put("deviceModel", Build.MODEL);
        hashMap.put("apkVersion", "6.2.1");
        hashMap.put("uri", uri.toString());
        d(context, "EVENT_SAVE_SN_URI", hashMap);
        MobclickAgent.onEvent(context.getApplicationContext(), "EVENT_SAVE_SN_URI", hashMap);
    }

    public static void I(Context context, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("userId", w6.i.f19214g.H());
        bundle.putString("shareFrom", str);
        b(context).logEvent("EVENT_SHARE_APP_CLICK", bundle);
    }

    public static void J(Context context, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("userId", w6.i.f19214g.H());
        bundle.putString("sysVersion", Build.VERSION.RELEASE);
        bundle.putString("deviceModel", Build.MODEL);
        bundle.putString("shortVideoName", str);
        b(context).logEvent("EVENT_SHORT_WATCH_FULL_VIDEO", bundle);
    }

    public static void K(Context context, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("userId", w6.i.f19214g.H());
        bundle.putString("bindFrom", str);
        b(context).logEvent("EVENT_TO_BIND_EMAIL_CLICK", bundle);
    }

    public static void L(Context context, String str, String str2, String str3, long j10) {
        int intValue = Long.valueOf((System.currentTimeMillis() - j10) / 1000).intValue();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        HashMap hashMap = new HashMap();
        hashMap.put(AnalyticsConfig.RTD_START_TIME, simpleDateFormat.format(new Date()));
        hashMap.put("topicName", str + " ," + str3);
        hashMap.put("channelID", str2);
        hashMap.put("channelName", str3);
        MobclickAgent.onEventValue(context, "CH_PLAY_TOPIC", hashMap, intValue);
    }

    public static void M(Context context, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("userId", w6.i.f19214g.H());
        bundle.putString("sysVersion", Build.VERSION.RELEASE);
        bundle.putString("deviceModel", Build.MODEL);
        bundle.putString("tag", str);
        b(context).logEvent("EVENT_TV_DEVICE", bundle);
    }

    public static void N(Context context) {
        Bundle bundle = new Bundle();
        bundle.putString("sysVersion", Build.VERSION.RELEASE);
        bundle.putString("deviceModel", Build.MODEL);
        b(context).logEvent("EVENT_VISITOR_CLICK_BIND_TIP", bundle);
    }

    public static void O(Context context, String str, String str2, long j10) {
        int intValue = Long.valueOf((System.currentTimeMillis() - j10) / 1000).intValue();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        HashMap hashMap = new HashMap();
        hashMap.put(AnalyticsConfig.RTD_START_TIME, simpleDateFormat.format(new Date()));
        hashMap.put("channelID", str);
        hashMap.put("channelName", str2);
        MobclickAgent.onEventValue(context, "CH_PLAY_VOD", hashMap, intValue);
    }

    public static void P(Context context, String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put(AnalyticsConfig.RTD_START_TIME, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        hashMap.put("userId", w6.i.f19214g.H());
        hashMap.put("subtitleSwitch", str);
        hashMap.put("audio", str2);
        hashMap.put("apkVersion", e.a(context));
        d(context, "EVENT_CLICK_VOD_SUBTITLE_SWITCH", hashMap);
    }

    public static FirebaseAnalytics b(Context context) {
        return FirebaseAnalytics.getInstance(context.getApplicationContext());
    }

    public static /* synthetic */ void c(Throwable th) {
    }

    public static void d(Context context, String str, HashMap hashMap) {
        MobclickAgent.onEvent(context.getApplicationContext(), str, hashMap);
        Bundle bundle = new Bundle();
        for (Map.Entry entry : hashMap.entrySet()) {
            bundle.putString((String) entry.getKey(), (String) entry.getValue());
        }
        b(context).logEvent(str, bundle);
    }

    public static void e(Context context, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(AnalyticsConfig.RTD_START_TIME, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        MobclickAgent.onEvent(context.getApplicationContext(), str, hashMap);
    }

    public static void f(Context context, String str, String str2, String str3) {
        Bundle bundle = new Bundle();
        bundle.putString("userId", str);
        bundle.putString("sysVersion", Build.VERSION.RELEASE);
        bundle.putString("deviceModel", Build.MODEL);
        bundle.putString("castMode", str2);
        bundle.putString("castDevice", str3);
        b(context).logEvent("EVENT_CAST_COUNT", bundle);
    }

    public static void g(Context context, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(AnalyticsConfig.RTD_START_TIME, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        d(context, str, hashMap);
    }

    public static void h(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
        Bundle bundle = new Bundle();
        bundle.putString("userId", str);
        bundle.putString("sysVersion", Build.VERSION.RELEASE);
        bundle.putString("deviceModel", Build.MODEL);
        bundle.putString("castMode", str2);
        bundle.putString("castDevice", str3);
        bundle.putString("castResourceId", str4);
        b(context).logEvent("EVENT_CAST_FAILURE", bundle);
        c2.d.f5311a.h(str7, str10, str8, TextUtils.isDigitsOnly(str9) ? CdnType.INSTANCE.transform(str9) : str9, str6, str5, str11, str2, str3, "", "", "", null);
    }

    public static void i(Context context, String str, String str2, String str3, boolean z10) {
        Bundle bundle = new Bundle();
        bundle.putString("userId", str);
        bundle.putString("sysVersion", Build.VERSION.RELEASE);
        bundle.putString("deviceModel", Build.MODEL);
        bundle.putString("castMode", str2);
        bundle.putString("castDevice", str3);
        bundle.putString("castStatus", z10 ? "true" : "false");
        b(context).logEvent("EVENT_CAST_LINK", bundle);
    }

    public static void j(Context context, String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString("userId", str);
        bundle.putString("sysVersion", Build.VERSION.RELEASE);
        bundle.putString("deviceModel", Build.MODEL);
        bundle.putString("castMode", str2);
        b(context).logEvent("EVENT_CAST_MODE", bundle);
    }

    public static void k(Context context, String str, String str2, String str3, long j10) {
        int intValue = Long.valueOf((System.currentTimeMillis() - j10) / 1000).intValue();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        HashMap hashMap = new HashMap();
        hashMap.put(AnalyticsConfig.RTD_START_TIME, simpleDateFormat.format(new Date()));
        hashMap.put("categoryType", str + " ," + str3);
        hashMap.put("channelID", str2);
        hashMap.put("channelName", str3);
        MobclickAgent.onEventValue(context, "CH_PLAY_CATEGORY_LIST", hashMap, intValue);
    }

    public static void l(Context context) {
        HashMap hashMap = new HashMap();
        hashMap.put(AnalyticsConfig.RTD_START_TIME, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        hashMap.put("userId", w6.i.f19214g.H());
        hashMap.put("apkVersion", e.a(context));
        MobclickAgent.onEvent(context.getApplicationContext(), "EVENT_COUPON_FLOAT_VIEW_CLICK", hashMap);
    }

    public static void m(Context context, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("userId", ma.m.e(str));
        MobclickAgent.onEvent(context, "EVENT_EXCHANGE_CODE_ENTRANCE", hashMap);
    }

    public static void n(Context context) {
        HashMap hashMap = new HashMap();
        hashMap.put(AnalyticsConfig.RTD_START_TIME, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        hashMap.put("userId", w6.i.f19214g.H());
        hashMap.put("apkVersion", e.a(context));
        MobclickAgent.onEvent(context.getApplicationContext(), "EVENT_CLICK_PREVIOUS_CHANNEL", hashMap);
    }

    public static void o(Context context, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(AnalyticsConfig.RTD_START_TIME, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        hashMap.put("userId", w6.i.f19214g.H());
        hashMap.put("apkVersion", e.a(context));
        hashMap.put("vodSearchKey", str);
        d(context, "EVENT_CLICK_VOD_SEARCH", hashMap);
    }

    public static Disposable p(Context context, String str) {
        return Observable.timer(1L, TimeUnit.SECONDS).subscribeOn(Schedulers.io()).subscribe(new a(context, str), new Consumer() { // from class: com.mobile.brasiltv.utils.h1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                i1.c((Throwable) obj);
            }
        });
    }

    public static void q(Context context, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("apkVersion", e.a(context));
        hashMap.put("deviceModel", Build.MODEL);
        hashMap.put("sysVersion", Build.VERSION.RELEASE);
        hashMap.put("devId", str);
        MobclickAgent.onEvent(context.getApplicationContext(), "EVENT_DONT_INSTALL_GP", hashMap);
    }

    public static void r(Context context, String str, int i10, boolean z10, boolean z11) {
        HashMap hashMap = new HashMap();
        String binaryString = Integer.toBinaryString(i10);
        int length = 3 - binaryString.length();
        while (true) {
            if (length <= 0) {
                break;
            }
            binaryString = "0" + binaryString;
            length--;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("_");
        sb.append(binaryString);
        sb.append("_");
        sb.append(z10 ? "1" : "0");
        sb.append("_");
        sb.append(z11 ? "1" : "0");
        hashMap.put("urlPath", sb.toString());
        hashMap.put("isLogin", "" + i10);
        d(context, "EVENT_EMPTY_TOKEN", hashMap);
    }

    public static void s(Context context, String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put(AnalyticsConfig.RTD_START_TIME, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        hashMap.put("userId", w6.i.f19214g.H());
        hashMap.put("apkVersion", e.a(context));
        hashMap.put("vodSearchKey", str);
        d(context, "EVENT_ENTER_VOD_PLAY_FROM_SEARCH", hashMap);
    }

    public static void t(Context context) {
        HashMap hashMap = new HashMap();
        hashMap.put(AnalyticsConfig.RTD_START_TIME, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        hashMap.put("userId", w6.i.f19214g.H());
        hashMap.put("apkVersion", e.a(context));
        d(context, "EVENT_ENTER_VOD_SEARCH", hashMap);
    }

    public static void u(Context context, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("Tag", str);
        hashMap.put(Constant.KEY_MSG, e.a(context) + ";" + na.c.f17339a + Build.MODEL + ";" + Build.VERSION.RELEASE + ";" + str);
        MobclickAgent.onEvent(context.getApplicationContext(), "EVENT_REVERSE_TOOL", hashMap);
    }

    public static void v(Context context, String str) {
        b(context).setUserProperty("user_identity", (TextUtils.isEmpty(str) || "1".equals(str)) ? "visitor" : "2".equals(str) ? DialogManager.DIALOG_EXPIRED : "3".equals(str) ? "experienced" : "4".equals(str) ? "members" : "");
    }

    public static void w(Context context, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("userId", w6.i.f19214g.H());
        bundle.putString("sysVersion", Build.VERSION.RELEASE);
        bundle.putString("deviceModel", Build.MODEL);
        bundle.putString("buttonName", str);
        b(context).logEvent("EVENT_GET_PRIORITY_VIP", bundle);
    }

    public static void x(Context context, String str, int i10) {
        HashMap hashMap = new HashMap();
        hashMap.put("apkVersion", e.a(context));
        hashMap.put("deviceModel", Build.MODEL);
        hashMap.put("sysVersion", Build.VERSION.RELEASE);
        hashMap.put("devId", str);
        hashMap.put("gAvailableCode", String.valueOf(i10));
        MobclickAgent.onEvent(context.getApplicationContext(), "EVENT_EXCEPTION_GOOGLE_SERVICE", hashMap);
    }

    public static void y(Context context, String str, String str2, String str3, long j10) {
        int intValue = Long.valueOf((System.currentTimeMillis() - j10) / 1000).intValue();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        HashMap hashMap = new HashMap();
        hashMap.put(AnalyticsConfig.RTD_START_TIME, simpleDateFormat.format(new Date()));
        hashMap.put("categoryType", str + " ," + str3);
        hashMap.put("channelID", str2);
        hashMap.put("channelName", str3);
        MobclickAgent.onEventValue(context, "CH_PLAY_HOME", hashMap, intValue);
    }

    public static void z(Context context) {
        Bundle bundle = new Bundle();
        bundle.putString("userId", w6.i.f19214g.H());
        b(context).logEvent("EVENT_LATER_TO_BIND_EMAIL_CLICK", bundle);
    }
}
