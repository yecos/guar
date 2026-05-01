package s1;

import android.content.Context;
import android.os.SystemClock;
import com.advertlib.bean.AdInfo;
import com.advertlib.bean.AdReportBean;
import com.advertlib.bean.ReportWrapperBean;
import com.advertlib.bean.TimeInfoBean;
import h9.t;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import s2.d;

/* loaded from: classes.dex */
public final class q {

    /* renamed from: b, reason: collision with root package name */
    public static volatile u1.a f18728b;

    /* renamed from: a, reason: collision with root package name */
    public static final q f18727a = new q();

    /* renamed from: c, reason: collision with root package name */
    public static List f18729c = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    public static final String f18730d = q.class.getSimpleName();

    public static final void e(List list) {
        t9.i.g(list, "$ids");
        u1.a aVar = f18728b;
        if (aVar != null) {
            aVar.m(list);
        }
    }

    public static final void l(ReportWrapperBean reportWrapperBean, TimeInfoBean timeInfoBean) {
        t9.i.g(reportWrapperBean, "$bean");
        boolean isClickEvent = reportWrapperBean.isClickEvent();
        int i10 = !isClickEvent ? 1 : 0;
        String ad_id = reportWrapperBean.getAdInfo().getAd_id();
        String ad_name = reportWrapperBean.getAdInfo().getAd_name();
        if (ad_name == null) {
            ad_name = "unknown";
        }
        String userName = reportWrapperBean.getUserName();
        int appVersion = reportWrapperBean.getAppVersion();
        String pagekegeName = reportWrapperBean.getPagekegeName();
        String media_type = reportWrapperBean.getAdInfo().getMedia_type();
        if (media_type == null) {
            media_type = "";
        }
        AdReportBean adReportBean = new AdReportBean(ad_id, ad_name, i10, isClickEvent ? 1 : 0, "", "", userName, appVersion, pagekegeName, media_type, reportWrapperBean.getAdType(), timeInfoBean.getCurrTime(reportWrapperBean.getLocalTime()), reportWrapperBean.getGameStayTime());
        u1.a aVar = f18728b;
        if (aVar != null) {
            aVar.q(adReportBean);
        }
    }

    public final void c() {
        if (f18729c.isEmpty()) {
            return;
        }
        List list = f18729c;
        f18729c = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            f18727a.k((ReportWrapperBean) it.next());
        }
    }

    public final void d(final List list) {
        t9.i.g(list, "ids");
        m.f18686a.Q().execute(new d.e("delete report", new Runnable() { // from class: s1.p
            @Override // java.lang.Runnable
            public final void run() {
                q.e(list);
            }
        }, false));
    }

    public final List f(Context context) {
        t9.i.g(context, com.umeng.analytics.pro.f.X);
        u1.a aVar = f18728b;
        if (aVar != null) {
            return aVar.n();
        }
        return null;
    }

    public final void g(Context context) {
        t9.i.g(context, com.umeng.analytics.pro.f.X);
        if (f18728b == null) {
            synchronized (q.class) {
                if (f18728b == null) {
                    f18728b = new u1.a(context);
                }
                t tVar = t.f14242a;
            }
        }
    }

    public final void h(Context context, String str, String str2, AdInfo adInfo) {
        t9.i.g(context, com.umeng.analytics.pro.f.X);
        t9.i.g(str2, "adType");
        if (adInfo == null) {
            return;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        String packageName = context.getPackageName();
        t9.i.f(packageName, "context.packageName");
        k(new ReportWrapperBean(true, elapsedRealtime, packageName, y1.f.f19726a.b(context), str == null ? "unknown" : str, str2, adInfo, 0L, 128, null));
    }

    public final void i(Context context, String str, String str2, long j10) {
        t9.i.g(context, com.umeng.analytics.pro.f.X);
        t9.i.g(str, "adType");
        AdInfo adInfo = new AdInfo("0", "", "", "", "", "", 1, 0, null, null);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        String packageName = context.getPackageName();
        t9.i.f(packageName, "context.packageName");
        k(new ReportWrapperBean(false, elapsedRealtime, packageName, y1.f.f19726a.b(context), str2 == null ? "unknown" : str2, str, adInfo, j10));
    }

    public final void j(Context context, String str, String str2, AdInfo adInfo) {
        t9.i.g(context, com.umeng.analytics.pro.f.X);
        t9.i.g(str2, "adType");
        t9.i.g(adInfo, "adInfo");
        long elapsedRealtime = SystemClock.elapsedRealtime();
        String packageName = context.getPackageName();
        t9.i.f(packageName, "context.packageName");
        k(new ReportWrapperBean(false, elapsedRealtime, packageName, y1.f.f19726a.b(context), str == null ? "unknown" : str, str2, adInfo, 0L, 128, null));
    }

    public final void k(final ReportWrapperBean reportWrapperBean) {
        m mVar = m.f18686a;
        final TimeInfoBean R = mVar.R();
        if (R == null || f18728b == null) {
            f18729c.add(reportWrapperBean);
        } else {
            mVar.Q().execute(new d.e("report event", new Runnable() { // from class: s1.o
                @Override // java.lang.Runnable
                public final void run() {
                    q.l(ReportWrapperBean.this, R);
                }
            }, false));
        }
    }

    public final void m(Context context, String str, String str2, AdInfo adInfo) {
        t9.i.g(context, com.umeng.analytics.pro.f.X);
        t9.i.g(str, "adType");
        t9.i.g(adInfo, "adInfo");
        long elapsedRealtime = SystemClock.elapsedRealtime();
        String packageName = context.getPackageName();
        t9.i.f(packageName, "context.packageName");
        k(new ReportWrapperBean(true, elapsedRealtime, packageName, y1.f.f19726a.b(context), str2 == null ? "unknown" : str2, str, adInfo, 0L, 128, null));
    }
}
