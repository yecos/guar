package com.mobile.brasiltv.view.adView;

import android.content.Context;
import android.content.res.Configuration;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.advertlib.bean.AdInfo;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.utils.i1;
import com.mobile.brasiltv.utils.j1;
import com.mobile.brasiltv.utils.r0;
import com.msandroid.mobile.R;
import com.titans.entity.CdnType;
import io.reactivex.disposables.Disposable;
import java.util.LinkedHashMap;
import java.util.Map;
import w6.i;

/* loaded from: classes3.dex */
public final class PauseAdView extends LinearLayout {
    public Map<Integer, View> _$_findViewCache;
    private boolean isCr;
    private final h9.g mAdLandUnitId$delegate;
    private final h9.g mAdPortUnitId$delegate;
    private s9.a mDetachAdCallback;
    private s9.p mLayoutAdCallback;
    private Disposable reportDelayedSubp;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PauseAdView(Context context, boolean z10) {
        super(context);
        t9.i.g(context, com.umeng.analytics.pro.f.X);
        this._$_findViewCache = new LinkedHashMap();
        this.isCr = z10;
        this.mAdPortUnitId$delegate = h9.h.b(new PauseAdView$mAdPortUnitId$2(context));
        this.mAdLandUnitId$delegate = h9.h.b(new PauseAdView$mAdLandUnitId$2(context));
        setOrientation(0);
        LayoutInflater.from(context).inflate(R.layout.layout_pause_ad_view, (ViewGroup) this, true);
        addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.mobile.brasiltv.view.adView.PauseAdView.1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                t9.i.g(view, "v");
                PauseAdView.this.showAdvert();
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                t9.i.g(view, "v");
                PauseAdView.this.removeAdvert();
            }
        });
        ((ImageView) _$_findCachedViewById(R$id.mIvOwnerAdClose)).setOnClickListener(new View.OnClickListener() { // from class: com.mobile.brasiltv.view.adView.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PauseAdView._init_$lambda$0(PauseAdView.this, view);
            }
        });
        ((ImageView) _$_findCachedViewById(R$id.mIvLandClose)).setOnClickListener(new View.OnClickListener() { // from class: com.mobile.brasiltv.view.adView.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PauseAdView._init_$lambda$1(PauseAdView.this, view);
            }
        });
        ((ImageView) _$_findCachedViewById(R$id.mIvPortClose)).setOnClickListener(new View.OnClickListener() { // from class: com.mobile.brasiltv.view.adView.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PauseAdView._init_$lambda$2(PauseAdView.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$0(PauseAdView pauseAdView, View view) {
        t9.i.g(pauseAdView, "this$0");
        pauseAdView.closeSelfAd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$1(PauseAdView pauseAdView, View view) {
        t9.i.g(pauseAdView, "this$0");
        pauseAdView.closeAdmobAd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$2(PauseAdView pauseAdView, View view) {
        t9.i.g(pauseAdView, "this$0");
        pauseAdView.closeAdmobAd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void adjustSelfAdOnAdmob() {
        int i10 = R$id.mIvOwnerAd2;
        ViewGroup.LayoutParams layoutParams = ((ImageView) _$_findCachedViewById(i10)).getLayoutParams();
        if (getResources().getConfiguration().orientation == 1) {
            controlAdmobRefWidget(false, true);
            layoutParams.width = j1.a(getContext(), 120);
            layoutParams.height = j1.a(getContext(), 100);
            i1.e(getContext(), "EVENT_AD_SELF_SHOW_PAUSE_ON_PORT");
        } else {
            controlAdmobRefWidget(true, false);
            layoutParams.width = j1.a(getContext(), 228);
            layoutParams.height = j1.a(getContext(), 190);
            i1.e(getContext(), "EVENT_AD_SELF_SHOW_PAUSE_ON_LAND");
        }
        ((ImageView) _$_findCachedViewById(i10)).setLayoutParams(layoutParams);
    }

    private final void closeAdmobAd() {
        int i10 = R$id.mFlAdmob;
        if (((FrameLayout) _$_findCachedViewById(i10)).getVisibility() != 8 || ((FrameLayout) _$_findCachedViewById(R$id.mFlOwner)).getVisibility() != 8) {
            ((FrameLayout) _$_findCachedViewById(i10)).setVisibility(8);
            controlAdmobRefWidget(true, true);
        } else {
            ViewParent parent = getParent();
            t9.i.e(parent, "null cannot be cast to non-null type android.view.ViewGroup");
            ((ViewGroup) parent).removeView(this);
        }
    }

    private final void closeSelfAd() {
        if (((FrameLayout) _$_findCachedViewById(R$id.mFlAdmob)).getVisibility() == 8 && ((FrameLayout) _$_findCachedViewById(R$id.mFlOwner)).getVisibility() == 8) {
            ViewParent parent = getParent();
            t9.i.e(parent, "null cannot be cast to non-null type android.view.ViewGroup");
            ((ViewGroup) parent).removeView(this);
        } else {
            ((FrameLayout) _$_findCachedViewById(R$id.mFlOwner)).setVisibility(8);
        }
        stopDelayedReport();
    }

    private final void controlAdmobRefWidget(boolean z10, boolean z11) {
        if (z10) {
            ((TextView) _$_findCachedViewById(R$id.mTvPortFlag)).setVisibility(8);
            ((ImageView) _$_findCachedViewById(R$id.mIvPortClose)).setVisibility(8);
        } else {
            ((TextView) _$_findCachedViewById(R$id.mTvPortFlag)).setVisibility(0);
            ((ImageView) _$_findCachedViewById(R$id.mIvPortClose)).setVisibility(0);
        }
        if (z11) {
            ((TextView) _$_findCachedViewById(R$id.mTvLandFlag)).setVisibility(8);
            ((ImageView) _$_findCachedViewById(R$id.mIvLandClose)).setVisibility(8);
        } else {
            ((TextView) _$_findCachedViewById(R$id.mTvLandFlag)).setVisibility(0);
            ((ImageView) _$_findCachedViewById(R$id.mIvLandClose)).setVisibility(0);
        }
    }

    private final String getMAdLandUnitId() {
        return (String) this.mAdLandUnitId$delegate.getValue();
    }

    private final String getMAdPortUnitId() {
        return (String) this.mAdPortUnitId$delegate.getValue();
    }

    private final void loadAdMob() {
        b0.U(this, "第一个暂停广告位，加载谷歌广告...");
    }

    private final void loadFirstAd() {
        String m10 = getResources().getConfiguration().orientation == 1 ? a6.a.f228a.m() : a6.a.f228a.l();
        s1.m mVar = s1.m.f18686a;
        Context context = getContext();
        t9.i.f(context, com.umeng.analytics.pro.f.X);
        i.c cVar = w6.i.f19214g;
        AdInfo H = mVar.H(context, m10, "picture", cVar.I(), true, cVar.r());
        if (H == null) {
            loadAdMob();
        } else {
            loadSelfAdOnAdmob(m10, H);
        }
    }

    private final void loadSelfAd() {
        s1.m mVar = s1.m.f18686a;
        Context context = getContext();
        t9.i.f(context, com.umeng.analytics.pro.f.X);
        a6.a aVar = a6.a.f228a;
        String k10 = aVar.k();
        i.c cVar = w6.i.f19214g;
        final AdInfo H = mVar.H(context, k10, "picture", cVar.I(), true, cVar.r());
        if (H == null) {
            return;
        }
        Context context2 = getContext();
        ImageView imageView = (ImageView) _$_findCachedViewById(R$id.mIvOwnerAd);
        String k11 = aVar.k();
        t9.i.f(context2, com.umeng.analytics.pro.f.X);
        t9.i.f(imageView, "mIvOwnerAd");
        mVar.g0(context2, imageView, k11, H, (r23 & 16) != 0 ? null : null, (r23 & 32) != 0 ? null : new PauseAdView$loadSelfAd$1(H, this), (r23 & 64) != 0 ? null : Integer.MIN_VALUE, (r23 & 128) != 0 ? false : false, (r23 & 256) != 0 ? -1 : 0);
        ((FrameLayout) _$_findCachedViewById(R$id.mFlOwner)).setOnClickListener(new View.OnClickListener() { // from class: com.mobile.brasiltv.view.adView.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PauseAdView.loadSelfAd$lambda$3(AdInfo.this, this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void loadSelfAd$lambda$3(AdInfo adInfo, PauseAdView pauseAdView, View view) {
        t9.i.g(pauseAdView, "this$0");
        if (!t9.i.b(adInfo.getAction_type(), "1") || TextUtils.isEmpty(adInfo.getAction())) {
            if (t9.i.b(adInfo.getAction_type(), CdnType.DIGITAL_TYPE_PCDN)) {
                Context context = pauseAdView.getContext();
                t9.i.f(context, com.umeng.analytics.pro.f.X);
                b0.m(context);
                return;
            }
            return;
        }
        String b10 = r0.f8743a.b(adInfo.getAction(), pauseAdView.isCr);
        Context context2 = pauseAdView.getContext();
        t9.i.f(context2, com.umeng.analytics.pro.f.X);
        b0.j0(context2, b10, false, true, false, false, 24, null);
        i1.e(pauseAdView.getContext(), "EVENT_AD_CLICK_PAUSE");
        s1.q qVar = s1.q.f18727a;
        Context context3 = pauseAdView.getContext();
        t9.i.f(context3, com.umeng.analytics.pro.f.X);
        d6.b bVar = d6.b.f12660a;
        Context context4 = pauseAdView.getContext();
        t9.i.f(context4, com.umeng.analytics.pro.f.X);
        qVar.h(context3, bVar.m(context4), a6.a.f228a.k(), adInfo);
    }

    private final void loadSelfAdOnAdmob(final String str, final AdInfo adInfo) {
        b0.U(this, "第一个暂停广告位，加载自有广告...");
        s1.m mVar = s1.m.f18686a;
        Context context = getContext();
        ImageView imageView = (ImageView) _$_findCachedViewById(R$id.mIvOwnerAd2);
        t9.i.f(context, com.umeng.analytics.pro.f.X);
        t9.i.f(imageView, "mIvOwnerAd2");
        mVar.g0(context, imageView, str, adInfo, (r23 & 16) != 0 ? null : null, (r23 & 32) != 0 ? null : new PauseAdView$loadSelfAdOnAdmob$1(this, adInfo, str), (r23 & 64) != 0 ? null : Integer.MIN_VALUE, (r23 & 128) != 0 ? false : false, (r23 & 256) != 0 ? -1 : 0);
        ((FrameLayout) _$_findCachedViewById(R$id.mFlAdmob)).setOnClickListener(new View.OnClickListener() { // from class: com.mobile.brasiltv.view.adView.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PauseAdView.loadSelfAdOnAdmob$lambda$4(AdInfo.this, this, str, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void loadSelfAdOnAdmob$lambda$4(AdInfo adInfo, PauseAdView pauseAdView, String str, View view) {
        t9.i.g(adInfo, "$adInfo");
        t9.i.g(pauseAdView, "this$0");
        t9.i.g(str, "$adtype");
        if (!t9.i.b(adInfo.getAction_type(), "1") || TextUtils.isEmpty(adInfo.getAction())) {
            if (t9.i.b(adInfo.getAction_type(), CdnType.DIGITAL_TYPE_PCDN)) {
                Context context = pauseAdView.getContext();
                t9.i.f(context, com.umeng.analytics.pro.f.X);
                b0.m(context);
                return;
            }
            return;
        }
        String b10 = r0.f8743a.b(adInfo.getAction(), pauseAdView.isCr);
        Context context2 = pauseAdView.getContext();
        t9.i.f(context2, com.umeng.analytics.pro.f.X);
        b0.j0(context2, b10, false, true, false, false, 24, null);
        s1.q qVar = s1.q.f18727a;
        Context context3 = pauseAdView.getContext();
        t9.i.f(context3, com.umeng.analytics.pro.f.X);
        d6.b bVar = d6.b.f12660a;
        Context context4 = pauseAdView.getContext();
        t9.i.f(context4, com.umeng.analytics.pro.f.X);
        qVar.h(context3, bVar.m(context4), str, adInfo);
        if (pauseAdView.getResources().getConfiguration().orientation == 1) {
            i1.e(pauseAdView.getContext(), "EVENT_AD_SELF_CLICK_PAUSE_ON_PORT");
        } else {
            i1.e(pauseAdView.getContext(), "EVENT_AD_SELF_CLICK_PAUSE_ON_LAND");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void removeAdvert() {
        ((FrameLayout) _$_findCachedViewById(R$id.mFlAdmob)).setVisibility(8);
        ((ImageView) _$_findCachedViewById(R$id.mIvOwnerAd2)).setVisibility(8);
        controlAdmobRefWidget(true, true);
        ((FrameLayout) _$_findCachedViewById(R$id.mFlOwner)).setVisibility(8);
        stopDelayedReport();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showAdvert() {
        removeAdvert();
        loadFirstAd();
        if (getResources().getConfiguration().orientation == 1) {
            return;
        }
        loadSelfAd();
    }

    private final void stopDelayedReport() {
        Disposable disposable;
        Disposable disposable2 = this.reportDelayedSubp;
        if ((disposable2 != null ? disposable2.isDisposed() : true) || (disposable = this.reportDelayedSubp) == null) {
            return;
        }
        disposable.dispose();
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    public View _$_findCachedViewById(int i10) {
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i10));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i10);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i10), findViewById);
        return findViewById;
    }

    public final boolean isCr() {
        return this.isCr;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        t9.i.g(configuration, "newConfig");
        showAdvert();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        s9.a aVar = this.mDetachAdCallback;
        if (aVar != null) {
            aVar.invoke();
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        s9.p pVar = this.mLayoutAdCallback;
        if (pVar != null) {
            pVar.invoke(Integer.valueOf(getWidth()), Integer.valueOf(getHeight()));
        }
    }

    public final void setCr(boolean z10) {
        this.isCr = z10;
    }

    public final void setDetachAdCallback(s9.a aVar) {
        t9.i.g(aVar, "callback");
        this.mDetachAdCallback = aVar;
    }

    public final void setLayoutAdCallback(s9.p pVar) {
        t9.i.g(pVar, "callback");
        this.mLayoutAdCallback = pVar;
    }
}
