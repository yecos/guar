package com.hpplay.sdk.source.browser.view;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import com.hpplay.common.log.LeLog;
import com.hpplay.glide.Glide;
import com.hpplay.glide.load.engine.DiskCacheStrategy;
import com.hpplay.sdk.source.browser.a.b;
import com.mobile.brasiltv.view.RoundedDrawable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class a extends RelativeLayout {
    private static final int A = 60000;

    /* renamed from: b, reason: collision with root package name */
    private static final String f7544b = "BrowserDeviceView";

    /* renamed from: k, reason: collision with root package name */
    private static final long f7545k = 3000;
    private Runnable B;
    private com.hpplay.sdk.source.browser.b C;
    private final AdapterView.OnItemClickListener D;

    /* renamed from: a, reason: collision with root package name */
    public HeaderView f7546a;

    /* renamed from: c, reason: collision with root package name */
    private Context f7547c;

    /* renamed from: d, reason: collision with root package name */
    private ListView f7548d;

    /* renamed from: e, reason: collision with root package name */
    private FooterView f7549e;

    /* renamed from: f, reason: collision with root package name */
    private ImageView f7550f;

    /* renamed from: g, reason: collision with root package name */
    private ImageView f7551g;

    /* renamed from: h, reason: collision with root package name */
    private com.hpplay.sdk.source.browser.c f7552h;

    /* renamed from: i, reason: collision with root package name */
    private DeviceAdapter f7553i;

    /* renamed from: j, reason: collision with root package name */
    private long f7554j;

    /* renamed from: l, reason: collision with root package name */
    private boolean f7555l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f7556m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f7557n;

    /* renamed from: o, reason: collision with root package name */
    private NotFoundView f7558o;

    /* renamed from: p, reason: collision with root package name */
    private NetWorkView f7559p;

    /* renamed from: q, reason: collision with root package name */
    private FailView f7560q;

    /* renamed from: r, reason: collision with root package name */
    private String f7561r;

    /* renamed from: s, reason: collision with root package name */
    private String f7562s;

    /* renamed from: t, reason: collision with root package name */
    private String f7563t;

    /* renamed from: u, reason: collision with root package name */
    private String f7564u;

    /* renamed from: v, reason: collision with root package name */
    private List<com.hpplay.sdk.source.browser.a.a> f7565v;

    /* renamed from: w, reason: collision with root package name */
    private AnimationDrawable f7566w;

    /* renamed from: x, reason: collision with root package name */
    private int f7567x;

    /* renamed from: y, reason: collision with root package name */
    private com.hpplay.sdk.source.browser.a.a f7568y;

    /* renamed from: z, reason: collision with root package name */
    private Handler f7569z;

    public a(Context context, String str) {
        super(context);
        this.f7553i = null;
        this.f7554j = 0L;
        this.f7556m = false;
        this.f7557n = false;
        this.f7561r = null;
        this.f7562s = null;
        this.f7563t = null;
        this.f7565v = new ArrayList();
        this.f7567x = -1;
        this.f7568y = null;
        this.f7569z = new Handler(Looper.getMainLooper());
        this.B = new Runnable() { // from class: com.hpplay.sdk.source.browser.view.a.1
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.f7553i != null) {
                    a.this.h();
                }
            }
        };
        this.C = new com.hpplay.sdk.source.browser.b() { // from class: com.hpplay.sdk.source.browser.view.a.4
            @Override // com.hpplay.sdk.source.browser.b
            public void a(String str2) {
                a.this.c(str2);
            }
        };
        this.D = new AdapterView.OnItemClickListener() { // from class: com.hpplay.sdk.source.browser.view.a.5
            /* JADX WARN: Removed duplicated region for block: B:12:? A[RETURN, SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:6:0x0058  */
            /* JADX WARN: Removed duplicated region for block: B:9:0x0072  */
            @Override // android.widget.AdapterView.OnItemClickListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
                com.hpplay.sdk.source.browser.a.a aVar;
                LeLog.i(a.f7544b, "onItemClick position:" + i10 + ",adapterView:" + adapterView + ", view:" + view);
                a.this.f7567x = i10;
                if (a.this.f7565v != null) {
                    try {
                        aVar = (com.hpplay.sdk.source.browser.a.a) a.this.f7565v.get(a.this.f7567x);
                    } catch (Exception e10) {
                        LeLog.w(a.f7544b, e10);
                    }
                    a.this.f7568y = aVar;
                    if (a.this.f7553i != null) {
                        a.this.f7553i.a(aVar);
                        a.this.f7553i.notifyDataSetChanged();
                    }
                    if (a.this.f7552h == null) {
                        a.this.f7552h.onSelect(a.this.f7567x, aVar);
                        return;
                    }
                    return;
                }
                aVar = null;
                a.this.f7568y = aVar;
                if (a.this.f7553i != null) {
                }
                if (a.this.f7552h == null) {
                }
            }
        };
        LeLog.i(f7544b, "BrowserDeviceView,bannerData " + str);
        this.f7547c = context;
        this.f7564u = str;
        com.hpplay.sdk.source.browser.b.b.d(context);
        this.f7555l = context.getResources().getConfiguration().orientation == 2;
        setClickable(true);
        b();
        i();
    }

    private List<b.a> getBannerData() {
        com.hpplay.sdk.source.browser.a.b bVar;
        List<b.a> list;
        if (TextUtils.isEmpty(this.f7564u)) {
            LeLog.w(f7544b, "getBannerData,data is invalid");
            return null;
        }
        LeLog.w(f7544b, "getBannerData,mBannerData:" + this.f7564u);
        try {
            bVar = com.hpplay.sdk.source.browser.a.b.a(this.f7564u);
        } catch (Exception e10) {
            LeLog.w(f7544b, e10);
            bVar = null;
        }
        if (bVar != null && (list = bVar.f7449b) != null && list.size() > 0) {
            return bVar.f7449b;
        }
        LeLog.w(f7544b, "getBannerData,data is null");
        return null;
    }

    private GradientDrawable getDefaultBackgroundDrawable() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(-14868961);
        gradientDrawable.setCornerRadius(30.0f);
        return gradientDrawable;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        com.hpplay.sdk.source.browser.b.b.d(this.f7547c);
        if (configuration.orientation == 2) {
            this.f7555l = true;
        } else {
            this.f7555l = false;
        }
        m();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        h();
    }

    public void setBusinessCallback(com.hpplay.sdk.source.browser.c cVar) {
        this.f7552h = cVar;
    }

    private void b() {
        RelativeLayout.LayoutParams layoutParams;
        RelativeLayout.LayoutParams layoutParams2;
        RelativeLayout.LayoutParams layoutParams3;
        LeLog.i(f7544b, "initView");
        setBackgroundColor(RoundedDrawable.DEFAULT_BORDER_COLOR);
        this.f7550f = new ImageView(this.f7547c);
        if (this.f7555l) {
            layoutParams = new RelativeLayout.LayoutParams(com.hpplay.sdk.source.browser.b.b.b(this.f7547c, 48.0d), com.hpplay.sdk.source.browser.b.b.b(this.f7547c, 48.0d));
            layoutParams.setMargins(com.hpplay.sdk.source.browser.b.b.b(this.f7547c, 28.0d), com.hpplay.sdk.source.browser.b.b.b(this.f7547c, 24.0d), com.hpplay.sdk.source.browser.b.b.b(this.f7547c, 28.0d), com.hpplay.sdk.source.browser.b.b.b(this.f7547c, 24.0d));
        } else {
            layoutParams = new RelativeLayout.LayoutParams(com.hpplay.sdk.source.browser.b.b.a(this.f7547c, 48.0d), com.hpplay.sdk.source.browser.b.b.a(this.f7547c, 48.0d));
            layoutParams.setMargins(com.hpplay.sdk.source.browser.b.b.a(this.f7547c, 28.0d), com.hpplay.sdk.source.browser.b.b.a(this.f7547c, 24.0d), com.hpplay.sdk.source.browser.b.b.a(this.f7547c, 28.0d), com.hpplay.sdk.source.browser.b.b.a(this.f7547c, 24.0d));
        }
        layoutParams.addRule(9);
        this.f7550f.setOnClickListener(new View.OnClickListener() { // from class: com.hpplay.sdk.source.browser.view.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.f();
            }
        });
        addView(this.f7550f, layoutParams);
        Glide.with(this.f7547c).load(b.f7591e).into(this.f7550f);
        this.f7551g = new ImageView(this.f7547c);
        if (this.f7555l) {
            layoutParams2 = new RelativeLayout.LayoutParams(com.hpplay.sdk.source.browser.b.b.b(this.f7547c, 48.0d), com.hpplay.sdk.source.browser.b.b.b(this.f7547c, 48.0d));
            layoutParams2.setMargins(com.hpplay.sdk.source.browser.b.b.b(this.f7547c, 21.0d), com.hpplay.sdk.source.browser.b.b.b(this.f7547c, 19.0d), com.hpplay.sdk.source.browser.b.b.b(this.f7547c, 21.0d), com.hpplay.sdk.source.browser.b.b.b(this.f7547c, 21.0d));
        } else {
            layoutParams2 = new RelativeLayout.LayoutParams(com.hpplay.sdk.source.browser.b.b.a(this.f7547c, 48.0d), com.hpplay.sdk.source.browser.b.b.a(this.f7547c, 48.0d));
            layoutParams2.setMargins(com.hpplay.sdk.source.browser.b.b.a(this.f7547c, 21.0d), com.hpplay.sdk.source.browser.b.b.a(this.f7547c, 19.0d), com.hpplay.sdk.source.browser.b.b.a(this.f7547c, 21.0d), com.hpplay.sdk.source.browser.b.b.a(this.f7547c, 21.0d));
        }
        layoutParams2.addRule(11);
        addView(this.f7551g, layoutParams2);
        this.f7551g.setOnClickListener(new View.OnClickListener() { // from class: com.hpplay.sdk.source.browser.view.a.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.i();
            }
        });
        Glide.with(this.f7547c).load(b.f7595i).into(this.f7551g);
        if (this.f7546a == null) {
            this.f7546a = new HeaderView(this.f7547c);
        }
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
        int a10 = com.hpplay.sdk.source.browser.b.b.a(this.f7547c, 32.0d);
        layoutParams4.rightMargin = a10;
        layoutParams4.leftMargin = a10;
        layoutParams4.topMargin = com.hpplay.sdk.source.browser.b.b.a(this.f7547c, 108.0d);
        if (this.f7555l) {
            layoutParams4.width = com.hpplay.sdk.source.browser.b.b.b(this.f7547c, 986.0d);
            layoutParams4.height = -2;
            if (!b("SDK_UI_LIST_BANNER_HORIZONTAL")) {
                layoutParams4.addRule(14);
            }
        }
        this.f7546a.setLayoutParams(layoutParams4);
        this.f7546a.setId(com.hpplay.sdk.source.browser.b.c.a());
        addView(this.f7546a);
        FooterView footerView = new FooterView(this.f7547c);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, com.hpplay.sdk.source.browser.b.b.a(this.f7547c, 70.0d));
        layoutParams5.addRule(12);
        if (this.f7555l) {
            layoutParams5.bottomMargin = com.hpplay.sdk.source.browser.b.b.b(this.f7547c, 22.0d);
            if (!b("SDK_UI_LIST_BANNER_HORIZONTAL")) {
                layoutParams5.addRule(14);
            }
        } else {
            layoutParams5.bottomMargin = com.hpplay.sdk.source.browser.b.b.a(this.f7547c, 320.0d);
        }
        addView(footerView, layoutParams5);
        this.f7549e = footerView;
        footerView.setCallback(this.C);
        ListView listView = new ListView(this.f7547c);
        this.f7548d = listView;
        listView.setId(com.hpplay.sdk.source.browser.b.c.a());
        this.f7548d.setBackgroundDrawable(getDefaultBackgroundDrawable());
        DeviceAdapter deviceAdapter = new DeviceAdapter(this.f7547c, this.f7565v);
        this.f7553i = deviceAdapter;
        this.f7548d.setAdapter((ListAdapter) deviceAdapter);
        this.f7548d.setOnItemClickListener(this.D);
        if (this.f7555l) {
            layoutParams3 = new RelativeLayout.LayoutParams(com.hpplay.sdk.source.browser.b.b.b(this.f7547c, 986.0d), -2);
            layoutParams3.bottomMargin = com.hpplay.sdk.source.browser.b.b.b(this.f7547c, 75.0d);
            if (b("SDK_UI_LIST_BANNER_HORIZONTAL")) {
                int b10 = com.hpplay.sdk.source.browser.b.b.b(this.f7547c, 32.0d);
                layoutParams3.rightMargin = b10;
                layoutParams3.leftMargin = b10;
            } else {
                layoutParams3.addRule(14);
            }
        } else {
            layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams3.bottomMargin = com.hpplay.sdk.source.browser.b.b.a(this.f7547c, 400.0d);
            int a11 = com.hpplay.sdk.source.browser.b.b.a(this.f7547c, 32.0d);
            layoutParams3.rightMargin = a11;
            layoutParams3.leftMargin = a11;
        }
        layoutParams3.addRule(3, this.f7546a.getId());
        addView(this.f7548d, layoutParams3);
        c();
    }

    private void c() {
        String str;
        final String str2;
        LeLog.i(f7544b, "addBanner");
        List<b.a> bannerData = getBannerData();
        if (bannerData == null) {
            LeLog.w(f7544b, "addBanner,data is null");
            return;
        }
        ImageView imageView = new ImageView(this.f7547c);
        imageView.setId(com.hpplay.sdk.source.browser.b.c.a());
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        if (this.f7555l) {
            String[] a10 = a("SDK_UI_LIST_BANNER_HORIZONTAL", bannerData);
            if (a10 == null || a10.length < 2) {
                return;
            }
            str = a10[0];
            str2 = a10[1];
            RelativeLayout relativeLayout = new RelativeLayout(this.f7547c);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.hpplay.sdk.source.browser.b.b.b(this.f7547c, 542.0d), -1);
            layoutParams.addRule(3, this.f7551g.getId());
            layoutParams.addRule(11);
            layoutParams.rightMargin = com.hpplay.sdk.source.browser.b.b.b(this.f7547c, 32.0d);
            addView(relativeLayout, layoutParams);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(com.hpplay.sdk.source.browser.b.b.b(this.f7547c, 542.0d), com.hpplay.sdk.source.browser.b.b.b(this.f7547c, 542.0d));
            layoutParams2.addRule(15);
            relativeLayout.addView(imageView, layoutParams2);
        } else {
            String[] a11 = a("SDK_UI_LIST_BANNER", bannerData);
            if (a11 == null || a11.length < 2) {
                return;
            }
            str = a11[0];
            str2 = a11[1];
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, com.hpplay.sdk.source.browser.b.b.a(this.f7547c, 160.0d));
            layoutParams3.addRule(12);
            layoutParams3.bottomMargin = com.hpplay.sdk.source.browser.b.b.a(this.f7547c, 24.0d);
            layoutParams3.leftMargin = com.hpplay.sdk.source.browser.b.b.a(this.f7547c, 24.0d);
            layoutParams3.rightMargin = com.hpplay.sdk.source.browser.b.b.a(this.f7547c, 24.0d);
            addView(imageView, layoutParams3);
        }
        LeLog.i(f7544b, "addBanner,imageUrl:" + str + ", clickUrl:" + str2);
        if (!TextUtils.isEmpty(str)) {
            Glide.with(this.f7547c).load(str).skipMemoryCache(false).diskCacheStrategy(DiskCacheStrategy.NONE).into(imageView);
        }
        if (TextUtils.isEmpty(str2)) {
            LeLog.w(f7544b, "value is invalid");
        } else {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.hpplay.sdk.source.browser.view.a.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    try {
                        a.this.f7547c.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str2)));
                    } catch (Exception e10) {
                        LeLog.w(a.f7544b, e10);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        e();
        j();
        this.f7556m = true;
        this.f7558o = new NotFoundView(this.f7547c);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(6, this.f7546a.getId());
        layoutParams.addRule(5, this.f7546a.getId());
        layoutParams.addRule(7, this.f7546a.getId());
        layoutParams.addRule(12);
        addView(this.f7558o, layoutParams);
        this.f7558o.setCallback(this.C);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        try {
            this.f7556m = false;
            removeView(this.f7558o);
            this.f7558o = null;
        } catch (Exception e10) {
            LeLog.w(f7544b, e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        LeLog.i(f7544b, "onViewDestroy");
        a();
        com.hpplay.sdk.source.browser.c cVar = this.f7552h;
        if (cVar != null) {
            cVar.onDestroy();
        }
    }

    private void g() {
        HeaderView headerView = this.f7546a;
        if (headerView == null) {
            return;
        }
        headerView.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        HeaderView headerView = this.f7546a;
        if (headerView == null) {
            return;
        }
        headerView.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        LeLog.i(f7544b, "refreshDeviceList");
        if (System.currentTimeMillis() - this.f7554j < f7545k) {
            return;
        }
        e();
        j();
        a((List<com.hpplay.sdk.source.browser.a.a>) null);
        if (!com.hpplay.sdk.source.browser.b.c.a(this.f7547c)) {
            a("网络异常", "请检查\n大屏和手机端网络后重试");
            return;
        }
        this.f7554j = System.currentTimeMillis();
        a(this.f7551g);
        this.f7556m = false;
        this.f7557n = false;
        com.hpplay.sdk.source.browser.c cVar = this.f7552h;
        if (cVar != null) {
            cVar.onRefresh();
        }
        DeviceAdapter deviceAdapter = this.f7553i;
        if (deviceAdapter != null) {
            deviceAdapter.a(null);
        }
        this.f7569z.removeCallbacks(this.B);
        this.f7569z.postDelayed(this.B, 60000L);
        g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        try {
            this.f7557n = false;
            removeView(this.f7560q);
            this.f7560q = null;
        } catch (Exception e10) {
            LeLog.w(f7544b, e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        removeView(this.f7549e);
    }

    private void l() {
        if (this.f7548d.getAdapter().getCount() > 1) {
            return;
        }
        NetWorkView netWorkView = this.f7559p;
        if ((netWorkView == null || netWorkView.getChildCount() <= 0) && this.f7553i != null) {
            this.f7569z.post(new Runnable() { // from class: com.hpplay.sdk.source.browser.view.a.10
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.f7553i.getCount() <= 0) {
                        a.this.k();
                        a.this.d();
                    }
                }
            });
        }
    }

    private void m() {
        this.f7550f = null;
        this.f7548d = null;
        b(this.f7551g);
        this.f7551g = null;
        removeAllViews();
        b();
        DeviceAdapter deviceAdapter = this.f7553i;
        if (deviceAdapter != null) {
            deviceAdapter.a(this.f7568y);
        }
        if (this.f7556m) {
            l();
        }
        if (this.f7557n) {
            a(this.f7562s, this.f7563t);
        }
        NetWorkView netWorkView = this.f7559p;
        if (netWorkView == null || netWorkView.getChildCount() <= 0) {
            return;
        }
        c(this.f7561r);
    }

    public void a(String str) {
        if (this.f7555l && TextUtils.isEmpty(this.f7564u)) {
            LeLog.i(f7544b, "updateBannerData,ignore");
            this.f7564u = str;
        } else {
            this.f7564u = str;
            c();
        }
    }

    private String[] a(String str, List<b.a> list) {
        String[] strArr = new String[2];
        Iterator<b.a> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            b.a next = it.next();
            if (str.equalsIgnoreCase(next.f7450a)) {
                strArr[0] = next.f7452c;
                strArr[1] = next.f7459j;
                break;
            }
        }
        return strArr;
    }

    private void a(View view) {
        LeLog.i(f7544b, "rotateView view:" + view);
        if (view == null) {
            return;
        }
        view.clearAnimation();
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 359.0f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setDuration(1000L);
        rotateAnimation.setRepeatCount(3);
        rotateAnimation.setFillAfter(true);
        rotateAnimation.setInterpolator(new LinearInterpolator());
        view.startAnimation(rotateAnimation);
    }

    public void a(final String str, final String str2) {
        if (this.f7553i != null) {
            this.f7569z.post(new Runnable() { // from class: com.hpplay.sdk.source.browser.view.a.2
                @Override // java.lang.Runnable
                public void run() {
                    a.this.b(str, str2);
                }
            });
        }
    }

    public void a(final List<com.hpplay.sdk.source.browser.a.a> list) {
        this.f7569z.post(new Runnable() { // from class: com.hpplay.sdk.source.browser.view.a.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    List list2 = list;
                    if (list2 != null && list2.size() > 0) {
                        a.this.e();
                    }
                    if (a.this.f7565v != null) {
                        a.this.f7565v.clear();
                        if (list != null) {
                            a.this.f7565v.addAll(list);
                        }
                    }
                } catch (Exception e10) {
                    LeLog.w(a.f7544b, e10);
                }
                if (a.this.f7553i != null) {
                    a.this.f7553i.notifyDataSetChanged();
                }
            }
        });
    }

    public void a(int i10) {
        l();
    }

    public void a() {
        this.f7569z.removeCallbacks(this.B);
        this.f7569z.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        this.f7561r = str;
        if (this.f7559p == null) {
            this.f7559p = new NetWorkView(this.f7547c);
        }
        this.f7559p.setCallback(new com.hpplay.sdk.source.browser.d() { // from class: com.hpplay.sdk.source.browser.view.a.11
            @Override // com.hpplay.sdk.source.browser.d
            public void a() {
                a.this.f7569z.post(new Runnable() { // from class: com.hpplay.sdk.source.browser.view.a.11.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (a.this.f7559p == null || a.this.f7559p.getParent() == null) {
                            return;
                        }
                        try {
                            ((ViewGroup) a.this.f7559p.getParent()).removeView(a.this.f7559p);
                            a.this.f7559p = null;
                        } catch (Exception e10) {
                            LeLog.w(a.f7544b, e10);
                        }
                    }
                });
            }
        });
        addView(this.f7559p, new RelativeLayout.LayoutParams(-1, -1));
        this.f7559p.a(str);
    }

    private boolean b(String str) {
        String[] a10;
        List<b.a> bannerData = getBannerData();
        return (bannerData == null || (a10 = a(str, bannerData)) == null || a10.length < 2 || TextUtils.isEmpty(a10[0])) ? false : true;
    }

    private void b(View view) {
        LeLog.i(f7544b, "stopRotate view:" + view);
        if (view == null) {
            return;
        }
        view.clearAnimation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, String str2) {
        e();
        j();
        this.f7557n = true;
        this.f7562s = str;
        this.f7563t = str2;
        this.f7560q = new FailView(this.f7547c, str, str2);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        this.f7560q.setBackgroundColor(Integer.MIN_VALUE);
        addView(this.f7560q, layoutParams);
        this.f7560q.setCallback(new com.hpplay.sdk.source.browser.d() { // from class: com.hpplay.sdk.source.browser.view.a.9
            @Override // com.hpplay.sdk.source.browser.d
            public void a() {
                a.this.f7569z.post(new Runnable() { // from class: com.hpplay.sdk.source.browser.view.a.9.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.j();
                    }
                });
            }
        });
    }
}
