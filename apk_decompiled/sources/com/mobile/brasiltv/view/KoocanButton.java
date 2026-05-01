package com.mobile.brasiltv.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public final class KoocanButton extends Button {
    public Map<Integer, View> _$_findViewCache;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public KoocanButton(Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KoocanButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        t9.i.g(context, com.umeng.analytics.pro.f.X);
        this._$_findViewCache = new LinkedHashMap();
        setTransformationMethod(null);
    }

    public /* synthetic */ KoocanButton(Context context, AttributeSet attributeSet, int i10, t9.g gVar) {
        this(context, (i10 & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KoocanButton(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        t9.i.g(context, com.umeng.analytics.pro.f.X);
        this._$_findViewCache = new LinkedHashMap();
        setTransformationMethod(null);
    }
}
