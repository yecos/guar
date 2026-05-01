package com.mobile.brasiltv.view.adView;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.mobile.brasiltv.utils.i1;
import io.reactivex.disposables.Disposable;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public final class ReportImageView extends AdvertImageView {
    public Map<Integer, View> _$_findViewCache;
    private Disposable reportDelayedSubp;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ReportImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        t9.i.g(context, com.umeng.analytics.pro.f.X);
    }

    private final void stopReortDelayed() {
        Disposable disposable;
        Disposable disposable2 = this.reportDelayedSubp;
        if ((disposable2 != null ? disposable2.isDisposed() : true) || (disposable = this.reportDelayedSubp) == null) {
            return;
        }
        disposable.dispose();
    }

    @Override // com.mobile.brasiltv.view.adView.AdvertImageView
    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Override // com.mobile.brasiltv.view.adView.AdvertImageView
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

    @Override // com.mobile.brasiltv.view.adView.AdvertImageView
    public void visibilityChanged(boolean z10) {
        super.visibilityChanged(z10);
        if (!z10) {
            stopReortDelayed();
        } else {
            i1.e(getContext(), "EVENT_AD_SHOW_HOME");
            this.reportDelayedSubp = i1.p(getContext(), "EVENT_AD_LONG_SHOW_HOME");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReportImageView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        t9.i.g(context, com.umeng.analytics.pro.f.X);
        this._$_findViewCache = new LinkedHashMap();
    }

    public /* synthetic */ ReportImageView(Context context, AttributeSet attributeSet, int i10, int i11, t9.g gVar) {
        this(context, attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }
}
