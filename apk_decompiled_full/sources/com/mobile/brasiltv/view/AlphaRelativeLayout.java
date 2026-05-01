package com.mobile.brasiltv.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.mobile.brasiltv.utils.p0;
import com.zhy.autolayout.AutoRelativeLayout;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public class AlphaRelativeLayout extends AutoRelativeLayout {
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    private OnVisibility listener;
    private boolean mEnableProxyVisibility;
    private boolean mVisibilitySwitch;
    private Disposable subscription;

    public interface OnVisibility {
        void onVisible(int i10);
    }

    public AlphaRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mVisibilitySwitch = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void delayHide$lambda$0(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void hide() {
        super.setVisibility(8);
    }

    private final void show() {
        super.setVisibility(0);
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

    public final void cancelDalayHide() {
        Disposable disposable = this.subscription;
        if (disposable != null) {
            disposable.dispose();
        }
    }

    public final void delayHide() {
        Disposable disposable = this.subscription;
        if (disposable != null) {
            disposable.dispose();
        }
        Observable<R> compose = Observable.timer(5L, TimeUnit.SECONDS).compose(p0.a());
        final AlphaRelativeLayout$delayHide$1 alphaRelativeLayout$delayHide$1 = new AlphaRelativeLayout$delayHide$1(this);
        this.subscription = compose.subscribe((Consumer<? super R>) new Consumer() { // from class: com.mobile.brasiltv.view.a
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                AlphaRelativeLayout.delayHide$lambda$0(s9.l.this, obj);
            }
        });
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (getVisibility() == 0) {
            boolean z10 = false;
            if (motionEvent != null && motionEvent.getAction() == 0) {
                z10 = true;
            }
            if (z10) {
                delayHide();
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public final void enableProxyVisibility(boolean z10) {
        this.mEnableProxyVisibility = z10;
    }

    public final OnVisibility getListener() {
        return this.listener;
    }

    public final boolean getMEnableProxyVisibility() {
        return this.mEnableProxyVisibility;
    }

    public final boolean getMVisibilitySwitch() {
        return this.mVisibilitySwitch;
    }

    public final Disposable getSubscription() {
        return this.subscription;
    }

    public final void setListener(OnVisibility onVisibility) {
        this.listener = onVisibility;
    }

    public final void setMEnableProxyVisibility(boolean z10) {
        this.mEnableProxyVisibility = z10;
    }

    public final void setMVisibilitySwitch(boolean z10) {
        this.mVisibilitySwitch = z10;
    }

    public final void setSubscription(Disposable disposable) {
        this.subscription = disposable;
    }

    @Override // android.view.View
    public void setVisibility(int i10) {
        OnVisibility onVisibility;
        if (this.mVisibilitySwitch) {
            if (this.mEnableProxyVisibility && (onVisibility = this.listener) != null) {
                onVisibility.onVisible(i10);
            }
            if (i10 != 0) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "alpha", 1.0f, 0.0f);
                ofFloat.setDuration(200L);
                ofFloat.addListener(new AnimatorListenerAdapter() { // from class: com.mobile.brasiltv.view.AlphaRelativeLayout$setVisibility$1
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        t9.i.g(animator, "animation");
                        AlphaRelativeLayout.this.hide();
                    }
                });
                ofFloat.start();
                return;
            }
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this, "alpha", 0.0f, 1.0f);
            ofFloat2.setDuration(200L);
            ofFloat2.start();
            show();
            delayHide();
        }
    }

    public final void setVisibilityListener(OnVisibility onVisibility) {
        t9.i.g(onVisibility, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.listener = onVisibility;
    }

    public final void setVisibilitySwitch(boolean z10) {
        this.mVisibilitySwitch = z10;
    }
}
