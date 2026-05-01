package com.mobile.brasiltv.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.zhy.autolayout.AutoRelativeLayout;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public final class AutoHideRelativeLayout extends AutoRelativeLayout {
    public Map<Integer, View> _$_findViewCache;
    private Disposable disposable;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AutoHideRelativeLayout(Context context) {
        this(context, null);
        t9.i.g(context, com.umeng.analytics.pro.f.X);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void delayHide$lambda$0(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void delayHide$lambda$1(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
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

    public final void cancelDelayHide() {
        Disposable disposable = this.disposable;
        if (disposable != null) {
            disposable.dispose();
        }
    }

    public final void delayHide() {
        Disposable disposable = this.disposable;
        if (disposable != null) {
            disposable.dispose();
        }
        Observable<Long> timer = Observable.timer(5L, TimeUnit.SECONDS, AndroidSchedulers.mainThread());
        final AutoHideRelativeLayout$delayHide$1 autoHideRelativeLayout$delayHide$1 = new AutoHideRelativeLayout$delayHide$1(this);
        Consumer<? super Long> consumer = new Consumer() { // from class: com.mobile.brasiltv.view.c
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                AutoHideRelativeLayout.delayHide$lambda$0(s9.l.this, obj);
            }
        };
        final AutoHideRelativeLayout$delayHide$2 autoHideRelativeLayout$delayHide$2 = AutoHideRelativeLayout$delayHide$2.INSTANCE;
        this.disposable = timer.subscribe(consumer, new Consumer() { // from class: com.mobile.brasiltv.view.d
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                AutoHideRelativeLayout.delayHide$lambda$1(s9.l.this, obj);
            }
        });
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (getVisibility() == 0) {
            if (motionEvent != null && motionEvent.getAction() == 0) {
                Disposable disposable = this.disposable;
                if (disposable != null) {
                    disposable.dispose();
                }
            } else {
                if (motionEvent != null && motionEvent.getAction() == 1) {
                    delayHide();
                }
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void setVisibility(int i10) {
        Disposable disposable;
        super.setVisibility(i10);
        if (i10 == 0) {
            delayHide();
        } else if (i10 == 8 && (disposable = this.disposable) != null) {
            disposable.dispose();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AutoHideRelativeLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        t9.i.g(context, com.umeng.analytics.pro.f.X);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AutoHideRelativeLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        t9.i.g(context, com.umeng.analytics.pro.f.X);
        this._$_findViewCache = new LinkedHashMap();
    }
}
