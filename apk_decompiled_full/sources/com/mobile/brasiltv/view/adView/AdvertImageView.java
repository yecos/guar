package com.mobile.brasiltv.view.adView;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.advertlib.bean.AdInfo;
import com.msandroid.mobile.R;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import w6.i;

/* loaded from: classes3.dex */
public class AdvertImageView extends ImageView implements IAdView {
    private final String TAG;
    public Map<Integer, View> _$_findViewCache;
    private boolean isCountAsOnce;
    private boolean isKeep;
    private Integer lastHeight;
    private Integer lastWidth;
    private AdInfo mAdInfo;
    private String mAdType;
    private Disposable mAutoRefreshAdD;
    private long mAutoRefreshAdTime;
    private boolean mIsAutoRefresh;
    private boolean mIsHostVisible;
    private boolean mIsVisible;
    private s9.p mShowAdListener;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AdvertImageView(Context context) {
        this(context, null, 0, 6, null);
        t9.i.g(context, com.umeng.analytics.pro.f.X);
    }

    private final void refreshAd() {
        stopAutoTask();
        if (this.mAdType != null) {
            s1.m mVar = s1.m.f18686a;
            Context context = getContext();
            t9.i.f(context, com.umeng.analytics.pro.f.X);
            String str = this.mAdType;
            if (str == null) {
                str = "";
            }
            String str2 = str;
            i.c cVar = w6.i.f19214g;
            List A = mVar.A(context, str2, cVar.I(), this.isCountAsOnce, cVar.r());
            if (A == null || A.isEmpty()) {
                return;
            }
            if (A.size() <= 1 || !this.mIsAutoRefresh) {
                showAd();
            } else {
                startAutoTask();
            }
        }
    }

    public static /* synthetic */ void setAdtype$default(AdvertImageView advertImageView, String str, boolean z10, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setAdtype");
        }
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        advertImageView.setAdtype(str, z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showAd() {
        s1.m mVar = s1.m.f18686a;
        Context context = getContext();
        t9.i.f(context, com.umeng.analytics.pro.f.X);
        String str = this.mAdType;
        String str2 = str == null ? "" : str;
        i.c cVar = w6.i.f19214g;
        AdInfo H = mVar.H(context, str2, "picture", cVar.I(), this.isCountAsOnce, cVar.r());
        this.mAdInfo = H;
        if (H == null) {
            stopAutoTask();
            return;
        }
        Context context2 = getContext();
        t9.i.f(context2, com.umeng.analytics.pro.f.X);
        String str3 = this.mAdType;
        mVar.g0(context2, this, str3 == null ? "" : str3, this.mAdInfo, (r23 & 16) != 0 ? null : Integer.valueOf(R.drawable.column_image_placeholder), (r23 & 32) != 0 ? null : new AdvertImageView$showAd$1(this), (r23 & 64) != 0 ? null : null, (r23 & 128) != 0 ? false : false, (r23 & 256) != 0 ? -1 : 0);
    }

    private final void startAutoTask() {
        Observable<Long> observeOn = Observable.interval(0L, this.mAutoRefreshAdTime, TimeUnit.SECONDS).subscribeOn(Schedulers.computation()).observeOn(AndroidSchedulers.mainThread());
        final AdvertImageView$startAutoTask$1 advertImageView$startAutoTask$1 = new AdvertImageView$startAutoTask$1(this);
        Consumer<? super Long> consumer = new Consumer() { // from class: com.mobile.brasiltv.view.adView.b
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                AdvertImageView.startAutoTask$lambda$1(s9.l.this, obj);
            }
        };
        final AdvertImageView$startAutoTask$2 advertImageView$startAutoTask$2 = AdvertImageView$startAutoTask$2.INSTANCE;
        this.mAutoRefreshAdD = observeOn.subscribe(consumer, new Consumer() { // from class: com.mobile.brasiltv.view.adView.c
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                AdvertImageView.startAutoTask$lambda$2(s9.l.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startAutoTask$lambda$1(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startAutoTask$lambda$2(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    private final void stopAutoTask() {
        Disposable disposable;
        Disposable disposable2 = this.mAutoRefreshAdD;
        if ((disposable2 != null ? disposable2.isDisposed() : true) || (disposable = this.mAutoRefreshAdD) == null) {
            return;
        }
        disposable.dispose();
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

    public final AdInfo getAdInfo() {
        return this.mAdInfo;
    }

    public final String getAdType() {
        return this.mAdType;
    }

    @Override // com.mobile.brasiltv.view.adView.IAdView
    public void hostVisibilityChange(boolean z10, boolean z11) {
        this.mIsHostVisible = z10;
        if (z11) {
            visibilityChanged(this.mIsVisible && z10);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stopAutoTask();
        setImageResource(0);
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i10) {
        super.onWindowVisibilityChanged(i10);
        boolean z10 = i10 == 0;
        this.mIsVisible = z10;
        visibilityChanged(z10 && this.mIsHostVisible);
    }

    public final void setAdtype(String str, boolean z10) {
        this.mAdType = str;
        this.isCountAsOnce = z10;
        visibilityChanged(this.mIsVisible && this.mIsHostVisible);
    }

    public final void setAutoRefreshTime(long j10) {
        this.mAutoRefreshAdTime = j10;
        visibilityChanged(this.mIsVisible && this.mIsHostVisible);
    }

    public final void setKeep(boolean z10) {
        this.isKeep = z10;
    }

    public final void setShowAdListener(s9.p pVar) {
        t9.i.g(pVar, "showAdListener");
        this.mShowAdListener = pVar;
    }

    public void visibilityChanged(boolean z10) {
        if (z10) {
            refreshAd();
        } else {
            stopAutoTask();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AdvertImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        t9.i.g(context, com.umeng.analytics.pro.f.X);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdvertImageView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        t9.i.g(context, com.umeng.analytics.pro.f.X);
        this._$_findViewCache = new LinkedHashMap();
        this.TAG = "AdvertImageView";
        this.mAutoRefreshAdTime = 10L;
        this.mIsHostVisible = true;
        this.mIsAutoRefresh = true;
    }

    public /* synthetic */ AdvertImageView(Context context, AttributeSet attributeSet, int i10, int i11, t9.g gVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }
}
