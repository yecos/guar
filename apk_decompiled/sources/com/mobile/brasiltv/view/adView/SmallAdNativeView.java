package com.mobile.brasiltv.view.adView;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import com.mobile.brasiltv.R$styleable;
import com.zhy.autolayout.AutoFrameLayout;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class SmallAdNativeView extends AutoFrameLayout {
    public Map<Integer, View> _$_findViewCache;
    private boolean isShowIdenti;
    private String mAdUnitId;
    private NativeAdCallback mNativeAdCallback;

    public interface NativeAdCallback {
        void onAttachNativeAd();

        void onCloseNativeAd();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SmallAdNativeView(Context context) {
        this(context, null);
        t9.i.g(context, com.umeng.analytics.pro.f.X);
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

    public final void destroy() {
        removeAllViews();
    }

    public final void isShowIdenti(boolean z10) {
        this.isShowIdenti = z10;
    }

    public final void loadNativeAd() {
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        destroy();
        super.onDetachedFromWindow();
    }

    public final void setAdUnitId(String str) {
        t9.i.g(str, "adUnitId");
        this.mAdUnitId = str;
    }

    public final void setNativeAdCallback(NativeAdCallback nativeAdCallback) {
        t9.i.g(nativeAdCallback, "callback");
        this.mNativeAdCallback = nativeAdCallback;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SmallAdNativeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        t9.i.g(context, com.umeng.analytics.pro.f.X);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SmallAdNativeView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        t9.i.g(context, com.umeng.analytics.pro.f.X);
        this._$_findViewCache = new LinkedHashMap();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.f7805y, i10, i10);
        t9.i.f(obtainStyledAttributes, "context.obtainStyledAttr…View, defStyle, defStyle)");
        this.mAdUnitId = obtainStyledAttributes.getString(0);
        this.isShowIdenti = obtainStyledAttributes.getBoolean(1, false);
        obtainStyledAttributes.recycle();
    }
}
