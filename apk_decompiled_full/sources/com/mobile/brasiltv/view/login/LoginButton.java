package com.mobile.brasiltv.view.login;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
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
public final class LoginButton extends AutoFrameLayout {
    public Map<Integer, View> _$_findViewCache;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LoginButton(Context context) {
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

    public final void setGrayMode(boolean z10) {
        if (z10) {
            ColorMatrix colorMatrix = new ColorMatrix();
            colorMatrix.setSaturation(0.0f);
            Paint paint = new Paint(1);
            paint.setFlags(6);
            paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
            setLayerType(2, paint);
            invalidate();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LoginButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        t9.i.g(context, com.umeng.analytics.pro.f.X);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoginButton(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        t9.i.g(context, com.umeng.analytics.pro.f.X);
        this._$_findViewCache = new LinkedHashMap();
        LayoutInflater.from(context).inflate(R.layout.layout_login_button, (ViewGroup) this, true);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.f7792l, i10, 0);
        t9.i.f(obtainStyledAttributes, "context.obtainStyledAttr…nButton, defStyleAttr, 0)");
        setBackgroundResource(obtainStyledAttributes.getResourceId(0, 0));
        ((ImageView) _$_findCachedViewById(R$id.mIvLoginIcon)).setImageResource(obtainStyledAttributes.getResourceId(1, 0));
        String string = obtainStyledAttributes.getString(2);
        string = string == null ? "" : string;
        int i11 = R$id.mTvLoginMethod;
        ((TextView) _$_findCachedViewById(i11)).setText(string);
        int color = obtainStyledAttributes.getColor(3, 0);
        if (color != 0) {
            ((TextView) _$_findCachedViewById(i11)).setTextColor(color);
        }
        obtainStyledAttributes.recycle();
    }

    public /* synthetic */ LoginButton(Context context, AttributeSet attributeSet, int i10, int i11, t9.g gVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }
}
