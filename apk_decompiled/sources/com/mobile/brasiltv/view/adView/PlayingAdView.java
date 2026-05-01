package com.mobile.brasiltv.view.adView;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.hpplay.sdk.source.common.global.Constant;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.R$styleable;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.utils.p0;
import com.mobile.brasiltv.view.adView.SmallAdNativeView;
import com.msandroid.mobile.R;
import com.zhy.autolayout.AutoLinearLayout;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import w6.i;

/* loaded from: classes3.dex */
public final class PlayingAdView extends AutoLinearLayout implements SmallAdNativeView.NativeAdCallback {
    private final long COUNT_DOWN_TIME;
    private final int MSG_COUNT_DOWN;
    private final long SCHEDULE_TIME;
    public Map<Integer, View> _$_findViewCache;
    private String mAdUnitId;
    private CountDownHandler mCountDownHandler;
    private long mCountDownTime;
    private PlayingAdCallback mPlayingAdCallback;
    private Disposable mScheduleSubscribe;

    public final class CountDownHandler extends Handler {
        public CountDownHandler() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            t9.i.g(message, Constant.KEY_MSG);
            super.handleMessage(message);
            PlayingAdView playingAdView = PlayingAdView.this;
            playingAdView.mCountDownTime--;
            if (PlayingAdView.this.mCountDownTime == 0) {
                PlayingAdView.this.countDownFinished();
            } else {
                PlayingAdView.this.updateCountDown();
            }
        }
    }

    public interface PlayingAdCallback {
        boolean canShowPlayingAd();

        void showControlPanel(boolean z10);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PlayingAdView(Context context) {
        this(context, null);
        t9.i.g(context, com.umeng.analytics.pro.f.X);
    }

    private final void cancelDelayEvent() {
        Disposable disposable;
        Disposable disposable2 = this.mScheduleSubscribe;
        if (((disposable2 == null || disposable2.isDisposed()) ? false : true) && (disposable = this.mScheduleSubscribe) != null) {
            disposable.dispose();
        }
        this.mCountDownHandler.removeMessages(this.MSG_COUNT_DOWN);
        PlayingAdCallback playingAdCallback = this.mPlayingAdCallback;
        if (playingAdCallback != null) {
            playingAdCallback.showControlPanel(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void countDownFinished() {
        setVisibility(8);
        ((SmallAdNativeView) _$_findCachedViewById(R$id.mSanvAd)).destroy();
        PlayingAdCallback playingAdCallback = this.mPlayingAdCallback;
        if (playingAdCallback != null) {
            playingAdCallback.showControlPanel(false);
        }
    }

    private final void innerScheduleLoadPlayingAd() {
        b0.U(this, "inner schedule playing ad");
        long j10 = this.SCHEDULE_TIME;
        Observable<R> compose = Observable.interval(j10, j10, TimeUnit.MINUTES).compose(p0.b());
        final PlayingAdView$innerScheduleLoadPlayingAd$1 playingAdView$innerScheduleLoadPlayingAd$1 = new PlayingAdView$innerScheduleLoadPlayingAd$1(this);
        Consumer consumer = new Consumer() { // from class: com.mobile.brasiltv.view.adView.p
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                PlayingAdView.innerScheduleLoadPlayingAd$lambda$1(s9.l.this, obj);
            }
        };
        final PlayingAdView$innerScheduleLoadPlayingAd$2 playingAdView$innerScheduleLoadPlayingAd$2 = new PlayingAdView$innerScheduleLoadPlayingAd$2(this);
        this.mScheduleSubscribe = compose.subscribe(consumer, new Consumer() { // from class: com.mobile.brasiltv.view.adView.q
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                PlayingAdView.innerScheduleLoadPlayingAd$lambda$2(s9.l.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void innerScheduleLoadPlayingAd$lambda$1(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void innerScheduleLoadPlayingAd$lambda$2(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void loadPlayingAd() {
        b0.U(this, "load playing ad and mAdUnitId is " + this.mAdUnitId);
        String str = this.mAdUnitId;
        if (str == null || str.length() == 0) {
            return;
        }
        int i10 = R$id.mSanvAd;
        SmallAdNativeView smallAdNativeView = (SmallAdNativeView) _$_findCachedViewById(i10);
        String str2 = this.mAdUnitId;
        t9.i.d(str2);
        smallAdNativeView.setAdUnitId(str2);
        ((SmallAdNativeView) _$_findCachedViewById(i10)).setNativeAdCallback(this);
        ((SmallAdNativeView) _$_findCachedViewById(i10)).loadNativeAd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onAttachNativeAd$lambda$0(PlayingAdView playingAdView, View view) {
        t9.i.g(playingAdView, "this$0");
        StringBuilder sb = new StringBuilder();
        sb.append("beVipUrl:");
        i.c cVar = w6.i.f19214g;
        sb.append(cVar.g());
        b0.U(playingAdView, sb.toString());
        if (cVar.g().length() > 0) {
            Context context = playingAdView.getContext();
            t9.i.f(context, com.umeng.analytics.pro.f.X);
            b0.j0(context, cVar.g(), false, true, false, false, 24, null);
        }
    }

    private final void scheduleResume() {
        PlayingAdCallback playingAdCallback = this.mPlayingAdCallback;
        boolean z10 = false;
        if (playingAdCallback != null && playingAdCallback.canShowPlayingAd()) {
            z10 = true;
        }
        if (z10) {
            scheduleLoadPlayingAd();
        } else {
            cancelScheduleStrategy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateCountDown() {
        ((TextView) _$_findCachedViewById(R$id.mTvCountDown)).setText(this.mCountDownTime + "s " + getContext().getString(R.string.no_ad_for_vips));
        this.mCountDownHandler.sendEmptyMessageDelayed(this.MSG_COUNT_DOWN, 1000L);
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

    public final void cancelScheduleStrategy() {
        b0.U(this, "cancel schedule ad strategy");
        setVisibility(8);
        ((SmallAdNativeView) _$_findCachedViewById(R$id.mSanvAd)).destroy();
        cancelDelayEvent();
    }

    @Override // com.mobile.brasiltv.view.adView.SmallAdNativeView.NativeAdCallback
    public void onAttachNativeAd() {
        b0.U(this, "attach native ad");
        if (getResources().getConfiguration().orientation == 1) {
            return;
        }
        PlayingAdCallback playingAdCallback = this.mPlayingAdCallback;
        if (playingAdCallback != null) {
            playingAdCallback.showControlPanel(true);
        }
        setVisibility(0);
        this.mCountDownTime = this.COUNT_DOWN_TIME;
        updateCountDown();
        ((TextView) _$_findCachedViewById(R$id.mTvCountDown)).setOnClickListener(new View.OnClickListener() { // from class: com.mobile.brasiltv.view.adView.r
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PlayingAdView.onAttachNativeAd$lambda$0(PlayingAdView.this, view);
            }
        });
    }

    @Override // com.mobile.brasiltv.view.adView.SmallAdNativeView.NativeAdCallback
    public void onCloseNativeAd() {
        setVisibility(8);
        PlayingAdCallback playingAdCallback = this.mPlayingAdCallback;
        if (playingAdCallback != null) {
            playingAdCallback.showControlPanel(false);
        }
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (getResources().getConfiguration().orientation == 1) {
            cancelScheduleStrategy();
        } else {
            scheduleResume();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        cancelScheduleStrategy();
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i10) {
        super.onWindowVisibilityChanged(i10);
        if (i10 == 8) {
            cancelDelayEvent();
        } else {
            if (this.mCountDownTime == 0 || getResources().getConfiguration().orientation == 1) {
                return;
            }
            innerScheduleLoadPlayingAd();
            updateCountDown();
        }
    }

    public final void scheduleLoadPlayingAd() {
        if (getResources().getConfiguration().orientation == 1) {
            return;
        }
        cancelScheduleStrategy();
        innerScheduleLoadPlayingAd();
    }

    public final void setPlayingAdCallback(PlayingAdCallback playingAdCallback) {
        t9.i.g(playingAdCallback, "callback");
        this.mPlayingAdCallback = playingAdCallback;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PlayingAdView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        t9.i.g(context, com.umeng.analytics.pro.f.X);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PlayingAdView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        t9.i.g(context, com.umeng.analytics.pro.f.X);
        this._$_findViewCache = new LinkedHashMap();
        this.MSG_COUNT_DOWN = 1;
        this.COUNT_DOWN_TIME = 5L;
        this.SCHEDULE_TIME = 20L;
        this.mCountDownHandler = new CountDownHandler();
        setOrientation(1);
        LayoutInflater.from(context).inflate(R.layout.layout_playing_ad, (ViewGroup) this, true);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.f7800t, i10, i10);
        t9.i.f(obtainStyledAttributes, "context.obtainStyledAttr…View, defStyle, defStyle)");
        this.mAdUnitId = obtainStyledAttributes.getString(0);
        obtainStyledAttributes.recycle();
    }
}
