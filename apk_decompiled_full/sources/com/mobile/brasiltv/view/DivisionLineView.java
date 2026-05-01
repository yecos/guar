package com.mobile.brasiltv.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.msandroid.mobile.R;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public final class DivisionLineView extends View {
    public Map<Integer, View> _$_findViewCache;

    public DivisionLineView(Context context) {
        this(context, null);
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
    public DivisionLineView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this._$_findViewCache = new LinkedHashMap();
        setBackgroundColor(getResources().getColor(R.color.color_659D9D9D));
    }
}
