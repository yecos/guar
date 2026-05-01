package com.umeng.analytics.pro;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class aa {

    /* renamed from: c, reason: collision with root package name */
    private static volatile aa f9834c;

    /* renamed from: a, reason: collision with root package name */
    private y f9835a = new z();

    /* renamed from: b, reason: collision with root package name */
    private String f9836b;

    /* renamed from: d, reason: collision with root package name */
    private List<a> f9837d;

    /* renamed from: e, reason: collision with root package name */
    private String f9838e;

    public interface a {
        void a(String str, long j10, long j11, long j12);

        void a(String str, String str2, long j10, long j11, long j12);
    }

    private aa() {
    }

    public static aa a() {
        if (f9834c == null) {
            synchronized (aa.class) {
                if (f9834c == null) {
                    f9834c = new aa();
                }
            }
        }
        return f9834c;
    }

    private String f(Context context) {
        try {
            SharedPreferences.Editor edit = PreferenceWrapper.getDefault(context).edit();
            edit.putString(w.f10578d, d(context));
            edit.commit();
        } catch (Exception unused) {
        }
        long h10 = h(context);
        long i10 = i(context);
        String str = this.f9836b;
        long a10 = w.a(context);
        long j10 = a10 * 5000;
        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>>*** 读取 foreground count 值完成，count次数：" + a10);
        if (!FieldManager.allow(com.umeng.commonsdk.utils.d.E)) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>>*** foreground count druation云控参数关闭。");
        } else if (UMWorkDispatch.eventHasExist()) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>>*** 读取 foreground count druation值完成，终止checker timer.");
            UMWorkDispatch.removeEvent();
        } else {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>>*** 读取 foreground count druation值完成，无未处理check timer事件。");
        }
        a(i10, h10, j10, str, false);
        this.f9836b = this.f9835a.a(context);
        a(i10, h10, j10, str, true);
        this.f9835a.a(context, this.f9836b);
        return this.f9836b;
    }

    private boolean g(Context context) {
        return !TextUtils.isEmpty(this.f9836b) && k.a(context).a(this.f9836b) > 0;
    }

    private long h(Context context) {
        return a(context, w.f10580f);
    }

    private long i(Context context) {
        return a(context, w.f10575a);
    }

    private boolean j(Context context) {
        Context appContext = UMGlobalContext.getAppContext(context);
        try {
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(appContext);
            long j10 = sharedPreferences.getLong(w.f10579e, 0L);
            long j11 = sharedPreferences.getLong(w.f10580f, 0L);
            if (FieldManager.allow(com.umeng.commonsdk.utils.d.E) && j10 > 0 && j11 == 0) {
                long a10 = w.a(appContext);
                if (a10 > 0) {
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> last session end time stamp = 0, reconstruct it by foreground count value.");
                    j11 = j10 + (a10 * 5000);
                }
            }
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> interval of last session is: " + (j11 - j10));
            return this.f9835a.a(j10, j11);
        } catch (Exception unused) {
            return false;
        }
    }

    public long b() {
        return this.f9835a.a();
    }

    public String c(Context context) {
        Context appContext = UMGlobalContext.getAppContext(context);
        if (appContext == null) {
            return "";
        }
        try {
            this.f9836b = f(appContext);
        } catch (Exception unused) {
        }
        return this.f9836b;
    }

    public String d(Context context) {
        if (TextUtils.isEmpty(this.f9836b)) {
            try {
                this.f9836b = PreferenceWrapper.getDefault(context).getString("session_id", null);
            } catch (Exception unused) {
            }
        }
        return this.f9836b;
    }

    public boolean e(Context context) {
        if (TextUtils.isEmpty(this.f9836b)) {
            this.f9836b = d(context);
        }
        return TextUtils.isEmpty(this.f9836b) || j(context) || g(context);
    }

    public synchronized String b(Context context) {
        Context appContext = UMGlobalContext.getAppContext(context);
        if (appContext == null) {
            return "";
        }
        this.f9836b = d(appContext);
        if (e(appContext)) {
            try {
                this.f9836b = f(appContext);
            } catch (Exception unused) {
            }
        }
        return this.f9836b;
    }

    public void a(long j10) {
        this.f9835a.a(j10);
    }

    public String a(Context context) {
        Context appContext = UMGlobalContext.getAppContext(context);
        if (appContext == null) {
            return "";
        }
        String str = "";
        try {
            synchronized (aa.class) {
                str = PreferenceWrapper.getDefault(appContext).getString(w.f10578d, "");
            }
        } catch (Exception unused) {
        }
        return str;
    }

    public void b(a aVar) {
        List<a> list;
        if (aVar == null || (list = this.f9837d) == null || list.size() == 0) {
            return;
        }
        this.f9837d.remove(aVar);
    }

    public String a(Context context, long j10) {
        if (TextUtils.isEmpty(this.f9838e)) {
            String str = "SUB" + j10;
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(String.format("%0" + (32 - str.length()) + "d", 0));
            this.f9838e = sb.toString();
        }
        return this.f9838e;
    }

    private long a(Context context, String str) {
        long j10;
        try {
            j10 = PreferenceWrapper.getDefault(context).getLong(str, 0L);
        } catch (Exception unused) {
            j10 = 0;
        }
        return j10 <= 0 ? System.currentTimeMillis() : j10;
    }

    private void a(long j10, long j11, long j12, String str, boolean z10) {
        List<a> list = this.f9837d;
        if (list != null) {
            for (a aVar : list) {
                if (z10) {
                    try {
                        aVar.a(str, this.f9836b, j10, j11, j12);
                    } catch (Exception unused) {
                    }
                } else {
                    aVar.a(this.f9836b, j10, j11, j12);
                }
            }
        }
    }

    public void a(a aVar) {
        if (aVar == null) {
            return;
        }
        if (this.f9837d == null) {
            this.f9837d = new ArrayList();
        }
        if (this.f9837d.contains(aVar)) {
            return;
        }
        this.f9837d.add(aVar);
    }
}
