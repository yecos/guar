package com.mobile.brasiltv.view.adView;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.advertlib.bean.AdInfo;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.utils.i1;
import com.mobile.brasiltv.view.adView.AdaptiveAdView;
import com.msandroid.mobile.R;
import com.titans.entity.CdnType;
import com.zhy.autolayout.AutoFrameLayout;
import g5.f3;
import java.util.LinkedHashMap;
import java.util.Map;
import w6.i;

/* loaded from: classes3.dex */
public final class AdaptiveAdContainer extends AutoFrameLayout implements IAdView {
    public Map<Integer, View> _$_findViewCache;
    private AdaptiveAdView.AdaptiveAdCallback mListener;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AdaptiveAdContainer(Context context) {
        this(context, null, 0, 6, null);
        t9.i.g(context, com.umeng.analytics.pro.f.X);
    }

    public static /* synthetic */ void hideView$default(AdaptiveAdContainer adaptiveAdContainer, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        adaptiveAdContainer.hideView(z10);
    }

    public static /* synthetic */ void loadAd$default(AdaptiveAdContainer adaptiveAdContainer, f3 f3Var, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        adaptiveAdContainer.loadAd(f3Var, z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void reportEvent(boolean z10) {
        int i10 = R$id.mIvAd;
        String adType = ((AdvertImageView) _$_findCachedViewById(i10)).getAdType();
        if (adType == null) {
            adType = "";
        }
        if (t9.i.b(adType, a6.a.f228a.f())) {
            if (!z10) {
                i1.e(getContext(), "EVENT_AD_SELF_SHOW_MOVIE_ON_FREE");
                return;
            }
            i1.e(getContext(), "EVENT_AD_SELF_CLICK_MOVIE_ON_FREE");
            s1.q qVar = s1.q.f18727a;
            Context context = getContext();
            t9.i.f(context, com.umeng.analytics.pro.f.X);
            d6.b bVar = d6.b.f12660a;
            Context context2 = getContext();
            t9.i.f(context2, com.umeng.analytics.pro.f.X);
            qVar.h(context, bVar.m(context2), adType, ((AdvertImageView) _$_findCachedViewById(i10)).getAdInfo());
        }
    }

    private final void showGoogleAdView(boolean z10, String str) {
        int i10 = R$id.mAavSmartAd;
        ((AdaptiveAdView) _$_findCachedViewById(i10)).destroy();
        if (!z10) {
            ((AdaptiveAdView) _$_findCachedViewById(i10)).setVisibility(8);
            return;
        }
        ((AdaptiveAdView) _$_findCachedViewById(i10)).setVisibility(0);
        ((AdaptiveAdView) _$_findCachedViewById(i10)).setAdUnitId(str);
        ((AdaptiveAdView) _$_findCachedViewById(i10)).setAdaptiveAdCallback(this.mListener);
        ((AdaptiveAdView) _$_findCachedViewById(i10)).loadAdaptiveAd(null);
    }

    private final void showOwnAdView(boolean z10, final boolean z11) {
        int i10 = R$id.mIvAd;
        ((AdvertImageView) _$_findCachedViewById(i10)).setVisibility(z10 ? 0 : 8);
        ((TextView) _$_findCachedViewById(R$id.mTvFlag)).setVisibility(8);
        if (z10) {
            ((AdvertImageView) _$_findCachedViewById(i10)).setShowAdListener(new AdaptiveAdContainer$showOwnAdView$1(this));
            ((AdvertImageView) _$_findCachedViewById(i10)).setOnClickListener(new View.OnClickListener() { // from class: com.mobile.brasiltv.view.adView.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AdaptiveAdContainer.showOwnAdView$lambda$0(AdaptiveAdContainer.this, z11, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showOwnAdView$lambda$0(AdaptiveAdContainer adaptiveAdContainer, boolean z10, View view) {
        t9.i.g(adaptiveAdContainer, "this$0");
        AdInfo adInfo = ((AdvertImageView) adaptiveAdContainer._$_findCachedViewById(R$id.mIvAd)).getAdInfo();
        if (adInfo != null) {
            String action = adInfo.getAction();
            if (!(action == null || action.length() == 0) && t9.i.b(adInfo.getAction_type(), "1")) {
                adaptiveAdContainer.reportEvent(true);
                a6.a aVar = a6.a.f228a;
                Context context = adaptiveAdContainer.getContext();
                t9.i.f(context, com.umeng.analytics.pro.f.X);
                aVar.t(context, adInfo.getAction(), z10);
                return;
            }
        }
        if (t9.i.b(adInfo != null ? adInfo.getAction_type() : null, CdnType.DIGITAL_TYPE_PCDN)) {
            Context context2 = adaptiveAdContainer.getContext();
            t9.i.f(context2, com.umeng.analytics.pro.f.X);
            b0.m(context2);
        }
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

    public final void hideView(boolean z10) {
        showGoogleAdView(false, "");
        showOwnAdView(false, z10);
    }

    @Override // com.mobile.brasiltv.view.adView.IAdView
    public void hostVisibilityChange(boolean z10, boolean z11) {
        ((AdvertImageView) _$_findCachedViewById(R$id.mIvAd)).hostVisibilityChange(z10, z11);
    }

    public final void loadAd(f3 f3Var, boolean z10) {
        t9.i.g(f3Var, "data");
        s1.m mVar = s1.m.f18686a;
        Context context = getContext();
        t9.i.f(context, com.umeng.analytics.pro.f.X);
        String a10 = f3Var.a();
        i.c cVar = w6.i.f19214g;
        if (b0.I(mVar.A(context, a10, cVar.I(), f3Var.c(), cVar.r()))) {
            ((AdvertImageView) _$_findCachedViewById(R$id.mIvAd)).setAdtype(f3Var.a(), f3Var.c());
            showGoogleAdView(false, "");
            showOwnAdView(true, z10);
        } else {
            AdvertImageView advertImageView = (AdvertImageView) _$_findCachedViewById(R$id.mIvAd);
            t9.i.f(advertImageView, "mIvAd");
            AdvertImageView.setAdtype$default(advertImageView, null, false, 2, null);
            showGoogleAdView(true, f3Var.b());
            showOwnAdView(false, z10);
        }
    }

    public final void setAdaptiveAdCallback(AdaptiveAdView.AdaptiveAdCallback adaptiveAdCallback) {
        this.mListener = adaptiveAdCallback;
    }

    public final void setKeep(boolean z10) {
        ((AdvertImageView) _$_findCachedViewById(R$id.mIvAd)).setKeep(z10);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AdaptiveAdContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        t9.i.g(context, com.umeng.analytics.pro.f.X);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdaptiveAdContainer(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        t9.i.g(context, com.umeng.analytics.pro.f.X);
        this._$_findViewCache = new LinkedHashMap();
        LayoutInflater.from(context).inflate(R.layout.layout_adaptive_container, (ViewGroup) this, true);
        hideView$default(this, false, 1, null);
    }

    public /* synthetic */ AdaptiveAdContainer(Context context, AttributeSet attributeSet, int i10, int i11, t9.g gVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }
}
