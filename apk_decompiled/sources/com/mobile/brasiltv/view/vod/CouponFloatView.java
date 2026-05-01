package com.mobile.brasiltv.view.vod;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.mobile.brasiltv.mine.activity.MyBenefitsAty;
import com.mobile.brasiltv.utils.i1;
import com.mobile.brasiltv.utils.s0;
import com.msandroid.mobile.R;
import com.umeng.analytics.pro.f;
import java.util.LinkedHashMap;
import java.util.Map;
import t9.g;
import t9.i;

/* loaded from: classes3.dex */
public final class CouponFloatView extends RelativeLayout implements View.OnClickListener {
    public Map<Integer, View> _$_findViewCache;
    private f5.c activity;
    private ImageView imCoupon;
    private ImageView imCouponClose;
    private View view;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CouponFloatView(Context context) {
        this(context, null, 0, 6, null);
        i.g(context, f.X);
    }

    private final RelativeLayout.LayoutParams getParams() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(11);
        layoutParams.setMargins(layoutParams.leftMargin, s0.b(getContext()) / 2, layoutParams.rightMargin, layoutParams.bottomMargin);
        return layoutParams;
    }

    public static /* synthetic */ void slideIn$default(CouponFloatView couponFloatView, long j10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            j10 = 500;
        }
        couponFloatView.slideIn(j10);
    }

    public static /* synthetic */ void slideOut$default(CouponFloatView couponFloatView, long j10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            j10 = 500;
        }
        couponFloatView.slideOut(j10);
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

    public final void add(ViewGroup viewGroup) {
        i.g(viewGroup, "parent");
        viewGroup.addView(this);
    }

    public final void hide() {
        setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        if (valueOf == null || valueOf.intValue() != R.id.imCoupon) {
            if (valueOf != null && valueOf.intValue() == R.id.imCouponClose) {
                w6.i.f19214g.X(true);
                remove();
                return;
            }
            return;
        }
        i1.l(getContext());
        com.mobile.brasiltv.utils.f.f8648a.b();
        MyBenefitsAty.a aVar = MyBenefitsAty.f8389r;
        Context context = getContext();
        i.f(context, f.X);
        aVar.a(context, 0, true);
        f5.c cVar = this.activity;
        if (cVar != null) {
            cVar.overridePendingTransition(0, 0);
        }
    }

    public final void remove() {
        ViewParent parent = getParent();
        i.e(parent, "null cannot be cast to non-null type android.view.ViewGroup");
        ((ViewGroup) parent).removeView(this);
    }

    public final void setActivity(f5.c cVar) {
        this.activity = cVar;
    }

    public final void show() {
        setVisibility(0);
    }

    public final void slideIn(long j10) {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.view, "translationX", 170.0f).setDuration(j10);
        i.f(duration, "ofFloat(view, \"translati…()).setDuration(duration)");
        duration.setInterpolator(new DecelerateInterpolator());
        duration.start();
        View view = this.view;
        if (view == null) {
            return;
        }
        view.setAlpha(0.5f);
    }

    public final void slideOut(long j10) {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.view, "translationX", 0.0f).setDuration(j10);
        i.f(duration, "ofFloat(view, \"translati…0f).setDuration(duration)");
        duration.setInterpolator(new DecelerateInterpolator());
        duration.start();
        View view = this.view;
        if (view == null) {
            return;
        }
        view.setAlpha(1.0f);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CouponFloatView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        i.g(context, f.X);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CouponFloatView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        i.g(context, f.X);
        this._$_findViewCache = new LinkedHashMap();
        View inflate = LayoutInflater.from(context).inflate(R.layout.layout_coupon_float_view, (ViewGroup) this, true);
        this.view = inflate;
        this.imCoupon = inflate != null ? (ImageView) inflate.findViewById(R.id.imCoupon) : null;
        View view = this.view;
        this.imCouponClose = view != null ? (ImageView) view.findViewById(R.id.imCouponClose) : null;
        setLayoutParams(getParams());
        ImageView imageView = this.imCoupon;
        if (imageView != null) {
            imageView.setOnClickListener(this);
        }
        ImageView imageView2 = this.imCouponClose;
        if (imageView2 != null) {
            imageView2.setOnClickListener(this);
        }
    }

    public /* synthetic */ CouponFloatView(Context context, AttributeSet attributeSet, int i10, int i11, g gVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }
}
