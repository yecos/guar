package com.mobile.brasiltv.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.R$styleable;
import com.msandroid.mobile.R;
import com.zhy.autolayout.AutoFrameLayout;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public final class TitleBarView extends AutoFrameLayout {
    public Map<Integer, View> _$_findViewCache;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TitleBarView(Context context) {
        this(context, null, 0, 6, null);
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

    public final void isShowClose(boolean z10) {
        ((ImageView) _$_findCachedViewById(R$id.mIvClose)).setVisibility(z10 ? 0 : 8);
    }

    public final void setBackVisibility(int i10) {
        ((ImageView) _$_findCachedViewById(R$id.mIvBack)).setVisibility(i10);
    }

    public final void setMenuVisibility(int i10) {
        ((ImageView) _$_findCachedViewById(R$id.mIvMenu)).setVisibility(i10);
    }

    public final void setOnBackClickListener(View.OnClickListener onClickListener) {
        ((ImageView) _$_findCachedViewById(R$id.mIvBack)).setOnClickListener(onClickListener);
    }

    public final void setOnCloseClickListener(View.OnClickListener onClickListener) {
        ((ImageView) _$_findCachedViewById(R$id.mIvClose)).setOnClickListener(onClickListener);
    }

    public final void setOnMenuClickListener(View.OnClickListener onClickListener) {
        ((ImageView) _$_findCachedViewById(R$id.mIvMenu)).setOnClickListener(onClickListener);
    }

    public final void setTitleBarBgColor(int i10) {
        setBackgroundColor(i10);
    }

    public final void setTitleText(String str) {
        t9.i.g(str, "title");
        ((TextView) _$_findCachedViewById(R$id.mTvTitle)).setText(str);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TitleBarView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        t9.i.g(context, com.umeng.analytics.pro.f.X);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TitleBarView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        t9.i.g(context, com.umeng.analytics.pro.f.X);
        this._$_findViewCache = new LinkedHashMap();
        LayoutInflater.from(context).inflate(R.layout.layout_title_bar_view, (ViewGroup) this, true);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.C, i10, 0);
        t9.i.f(obtainStyledAttributes, "context.obtainStyledAttr…BarView, defStyleAttr, 0)");
        int color = obtainStyledAttributes.getColor(2, 0);
        if (color != 0) {
            setTitleBarBgColor(color);
        }
        int resourceId = obtainStyledAttributes.getResourceId(1, 0);
        if (resourceId != 0) {
            ((ImageView) _$_findCachedViewById(R$id.mIvBack)).setImageResource(resourceId);
        }
        int resourceId2 = obtainStyledAttributes.getResourceId(3, 0);
        if (resourceId2 != 0) {
            int i11 = R$id.mIvClose;
            ((ImageView) _$_findCachedViewById(i11)).setVisibility(0);
            ((ImageView) _$_findCachedViewById(i11)).setImageResource(resourceId2);
        }
        String string = obtainStyledAttributes.getString(5);
        string = string == null ? "" : string;
        int i12 = R$id.mTvTitle;
        ((TextView) _$_findCachedViewById(i12)).setText(string);
        ((TextView) _$_findCachedViewById(i12)).setTextColor(obtainStyledAttributes.getColor(6, 0));
        int resourceId3 = obtainStyledAttributes.getResourceId(4, 0);
        if (resourceId3 != 0) {
            ((ImageView) _$_findCachedViewById(R$id.mIvMenu)).setImageResource(resourceId3);
        }
        if (obtainStyledAttributes.getBoolean(0, true)) {
            ViewGroup.LayoutParams layoutParams = ((AutoFrameLayout) _$_findCachedViewById(R$id.mAflTitleWrapper)).getLayoutParams();
            t9.i.e(layoutParams, "null cannot be cast to non-null type com.zhy.autolayout.AutoFrameLayout.LayoutParams");
            ((AutoFrameLayout.LayoutParams) layoutParams).setMargins(0, n5.a.f17268a.a(context), 0, 0);
        }
        obtainStyledAttributes.recycle();
    }

    public /* synthetic */ TitleBarView(Context context, AttributeSet attributeSet, int i10, int i11, t9.g gVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }
}
