package com.mobile.brasiltv.view.webview;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.autofill.AutofillValue;
import android.webkit.WebView;
import com.umeng.analytics.pro.f;
import java.util.LinkedHashMap;
import java.util.Map;
import t9.g;
import t9.i;

/* loaded from: classes3.dex */
public final class LollipopFixedWebView extends WebView {
    public static final Companion Companion = new Companion(null);
    public Map<Integer, View> _$_findViewCache;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Context getFixedContext(Context context) {
            int i10 = Build.VERSION.SDK_INT;
            if (i10 < 21 || i10 >= 23) {
                return context;
            }
            Context createConfigurationContext = context.createConfigurationContext(new Configuration());
            i.f(createConfigurationContext, "context.createConfigurat…nContext(Configuration())");
            return createConfigurationContext;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LollipopFixedWebView(Context context) {
        super(Companion.getFixedContext(context));
        i.g(context, f.X);
        this._$_findViewCache = new LinkedHashMap();
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

    @Override // android.view.View
    public void autofill(AutofillValue autofillValue) {
        try {
            super.autofill(autofillValue);
        } catch (IllegalStateException e10) {
            e10.printStackTrace();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LollipopFixedWebView(Context context, AttributeSet attributeSet) {
        super(Companion.getFixedContext(context), attributeSet);
        i.g(context, f.X);
        this._$_findViewCache = new LinkedHashMap();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LollipopFixedWebView(Context context, AttributeSet attributeSet, int i10) {
        super(Companion.getFixedContext(context), attributeSet, i10);
        i.g(context, f.X);
        this._$_findViewCache = new LinkedHashMap();
    }

    @Override // android.webkit.WebView, android.view.View
    public void autofill(SparseArray<AutofillValue> sparseArray) {
        i.g(sparseArray, "values");
        try {
            super.autofill(sparseArray);
        } catch (IllegalStateException e10) {
            e10.printStackTrace();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LollipopFixedWebView(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(Companion.getFixedContext(context), attributeSet, i10, i11);
        i.g(context, f.X);
        this._$_findViewCache = new LinkedHashMap();
    }
}
