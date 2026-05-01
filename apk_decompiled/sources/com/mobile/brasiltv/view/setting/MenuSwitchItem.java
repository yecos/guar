package com.mobile.brasiltv.view.setting;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.R$styleable;
import com.msandroid.mobile.R;
import com.umeng.analytics.pro.f;
import com.zhy.autolayout.AutoRelativeLayout;
import java.util.LinkedHashMap;
import java.util.Map;
import t9.g;
import t9.i;

/* loaded from: classes3.dex */
public final class MenuSwitchItem extends AutoRelativeLayout {
    public Map<Integer, View> _$_findViewCache;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MenuSwitchItem(Context context) {
        this(context, null, 0, 6, null);
        i.g(context, f.X);
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

    public final boolean isSwitchOn() {
        return ((ImageView) _$_findCachedViewById(R$id.mIvMenuSwitch)).isSelected();
    }

    public final void setOnSwitchClickListener(View.OnClickListener onClickListener) {
        i.g(onClickListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        ((ImageView) _$_findCachedViewById(R$id.mIvMenuSwitch)).setOnClickListener(onClickListener);
    }

    public final void switchMenu(boolean z10) {
        ((ImageView) _$_findCachedViewById(R$id.mIvMenuSwitch)).setSelected(z10);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MenuSwitchItem(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        i.g(context, f.X);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MenuSwitchItem(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        i.g(context, f.X);
        this._$_findViewCache = new LinkedHashMap();
        LayoutInflater.from(context).inflate(R.layout.layout_menu_switch_item, (ViewGroup) this, true);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.f7796p, i10, 0);
        i.f(obtainStyledAttributes, "context.obtainStyledAttr…tchItem, defStyleAttr, 0)");
        ((ImageView) _$_findCachedViewById(R$id.mIvMenuIcon)).setImageResource(obtainStyledAttributes.getResourceId(0, 0));
        String string = obtainStyledAttributes.getString(1);
        ((TextView) _$_findCachedViewById(R$id.mTvMenuName)).setText(string == null ? "" : string);
        ((ImageView) _$_findCachedViewById(R$id.mIvMenuSwitch)).setImageResource(obtainStyledAttributes.getResourceId(2, 0));
        obtainStyledAttributes.recycle();
    }

    public /* synthetic */ MenuSwitchItem(Context context, AttributeSet attributeSet, int i10, int i11, g gVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }
}
