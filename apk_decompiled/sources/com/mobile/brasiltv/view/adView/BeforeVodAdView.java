package com.mobile.brasiltv.view.adView;

import android.content.Context;
import android.content.res.Configuration;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.advertlib.bean.AdInfo;
import com.advertlib.bean.AdInfoWrapper;
import com.hpplay.sdk.source.common.global.Constant;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.utils.f1;
import com.mobile.brasiltv.view.RoundedDrawable;
import com.msandroid.mobile.R;
import com.titans.entity.CdnType;
import com.zhy.autolayout.AutoFrameLayout;
import com.zhy.autolayout.AutoLinearLayout;
import java.util.LinkedHashMap;
import java.util.Map;
import w6.i;

/* loaded from: classes3.dex */
public final class BeforeVodAdView extends AutoFrameLayout {
    private final long COUNT_DOWN_TIME;
    private final String KEY_VIP_PLAY_PREFIX;
    private final int MSG_COUNT_DOWN;
    public Map<Integer, View> _$_findViewCache;
    private boolean isCr;
    private AdInfoWrapper mAdInfoWrapper;
    private BeforeVodCallback mBeforeVodCallback;
    private CountDownHandler mCountDownHandler;
    private long mCountDownTime;
    private int mPlayProgress;
    private int mStatusBarHeight;

    public interface BeforeVodCallback {
        void onBack();

        void onCountDownFinished();

        void onFullScreen();
    }

    public final class CountDownHandler extends Handler {
        public CountDownHandler() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            t9.i.g(message, Constant.KEY_MSG);
            super.handleMessage(message);
            BeforeVodAdView beforeVodAdView = BeforeVodAdView.this;
            beforeVodAdView.mCountDownTime--;
            if (BeforeVodAdView.this.mCountDownTime == 0) {
                BeforeVodAdView.this.countDownFinished();
            } else {
                BeforeVodAdView.this.updateCountDown();
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BeforeVodAdView(Context context) {
        this(context, null);
        t9.i.g(context, com.umeng.analytics.pro.f.X);
    }

    private final void adjustFullScreenMargin(int i10, int i11) {
        int i12 = R$id.mIvFullScreen;
        ViewGroup.LayoutParams layoutParams = ((ImageView) _$_findCachedViewById(i12)).getLayoutParams();
        t9.i.e(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        layoutParams2.rightMargin = i10;
        layoutParams2.bottomMargin = i11;
        ((ImageView) _$_findCachedViewById(i12)).setLayoutParams(layoutParams2);
    }

    private final void clearCountDown() {
        this.mCountDownTime = 0L;
        this.mCountDownHandler.removeMessages(this.MSG_COUNT_DOWN);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void countDownFinished() {
        clearCountDown();
        releaseAd();
        BeforeVodCallback beforeVodCallback = this.mBeforeVodCallback;
        if (beforeVodCallback != null) {
            beforeVodCallback.onCountDownFinished();
        }
    }

    private final boolean handleVipPlayToday() {
        d6.b bVar = d6.b.f12660a;
        if (!bVar.x()) {
            return true;
        }
        String c10 = na.b.c("yyyyMMdd");
        if (t9.i.b(na.f.f(getContext(), this.KEY_VIP_PLAY_PREFIX + bVar.l(), ""), c10)) {
            return false;
        }
        na.f.k(getContext(), this.KEY_VIP_PLAY_PREFIX + bVar.l(), c10);
        return true;
    }

    private final void initView(final Context context) {
        setBackgroundColor(RoundedDrawable.DEFAULT_BORDER_COLOR);
        LayoutInflater.from(context).inflate(R.layout.layout_before_vod_ad, (ViewGroup) this, true);
        this.mStatusBarHeight = n5.a.f17268a.a(context);
        int i10 = R$id.mIvBack;
        ViewGroup.LayoutParams layoutParams = ((ImageView) _$_findCachedViewById(i10)).getLayoutParams();
        t9.i.e(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        ((FrameLayout.LayoutParams) layoutParams).topMargin = this.mStatusBarHeight;
        ViewGroup.LayoutParams layoutParams2 = ((TextView) _$_findCachedViewById(R$id.mTvTitle)).getLayoutParams();
        t9.i.e(layoutParams2, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        ((FrameLayout.LayoutParams) layoutParams2).topMargin = this.mStatusBarHeight;
        ViewGroup.LayoutParams layoutParams3 = ((AutoLinearLayout) _$_findCachedViewById(R$id.mAllAdFlagWrapper)).getLayoutParams();
        t9.i.e(layoutParams3, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        ((FrameLayout.LayoutParams) layoutParams3).topMargin = this.mStatusBarHeight;
        ((ImageView) _$_findCachedViewById(i10)).setOnClickListener(new View.OnClickListener() { // from class: com.mobile.brasiltv.view.adView.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BeforeVodAdView.initView$lambda$0(BeforeVodAdView.this, view);
            }
        });
        ((ImageView) _$_findCachedViewById(R$id.mIvFullScreen)).setOnClickListener(new View.OnClickListener() { // from class: com.mobile.brasiltv.view.adView.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BeforeVodAdView.initView$lambda$1(BeforeVodAdView.this, view);
            }
        });
        ((AutoLinearLayout) _$_findCachedViewById(R$id.mAllCountDownWrap)).setOnClickListener(new View.OnClickListener() { // from class: com.mobile.brasiltv.view.adView.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BeforeVodAdView.initView$lambda$2(BeforeVodAdView.this, context, view);
            }
        });
        ((ImageView) _$_findCachedViewById(R$id.mIvBeforeVodAd)).setOnClickListener(new View.OnClickListener() { // from class: com.mobile.brasiltv.view.adView.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BeforeVodAdView.initView$lambda$3(BeforeVodAdView.this, view);
            }
        });
        ((AutoFrameLayout) _$_findCachedViewById(R$id.mAflVideoWrapper)).setOnClickListener(new View.OnClickListener() { // from class: com.mobile.brasiltv.view.adView.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BeforeVodAdView.initView$lambda$4(BeforeVodAdView.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$0(BeforeVodAdView beforeVodAdView, View view) {
        t9.i.g(beforeVodAdView, "this$0");
        BeforeVodCallback beforeVodCallback = beforeVodAdView.mBeforeVodCallback;
        if (beforeVodCallback != null) {
            beforeVodCallback.onBack();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1(BeforeVodAdView beforeVodAdView, View view) {
        t9.i.g(beforeVodAdView, "this$0");
        BeforeVodCallback beforeVodCallback = beforeVodAdView.mBeforeVodCallback;
        if (beforeVodCallback != null) {
            beforeVodCallback.onFullScreen();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$2(BeforeVodAdView beforeVodAdView, Context context, View view) {
        t9.i.g(beforeVodAdView, "this$0");
        t9.i.g(context, "$context");
        d6.b bVar = d6.b.f12660a;
        if (bVar.x()) {
            beforeVodAdView.countDownFinished();
            return;
        }
        if (bVar.y()) {
            f1.f8649a.t(R.string.ads_bind_account);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("beVipUrl:");
        i.c cVar = w6.i.f19214g;
        sb.append(cVar.g());
        b0.U(beforeVodAdView, sb.toString());
        if (cVar.g().length() > 0) {
            b0.j0(context, cVar.g(), false, true, false, false, 24, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$3(BeforeVodAdView beforeVodAdView, View view) {
        t9.i.g(beforeVodAdView, "this$0");
        beforeVodAdView.openAdLink(beforeVodAdView.isCr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$4(BeforeVodAdView beforeVodAdView, View view) {
        t9.i.g(beforeVodAdView, "this$0");
        beforeVodAdView.openAdLink(beforeVodAdView.isCr);
    }

    private final void openAdLink(boolean z10) {
        AdInfoWrapper adInfoWrapper = this.mAdInfoWrapper;
        if ((adInfoWrapper != null ? adInfoWrapper.getAdInfo() : null) == null) {
            return;
        }
        AdInfoWrapper adInfoWrapper2 = this.mAdInfoWrapper;
        AdInfo adInfo = adInfoWrapper2 != null ? adInfoWrapper2.getAdInfo() : null;
        t9.i.d(adInfo);
        String action = adInfo.getAction();
        if ((action == null || action.length() == 0) || !t9.i.b(adInfo.getAction_type(), "1")) {
            if (t9.i.b(adInfo.getAction_type(), CdnType.DIGITAL_TYPE_PCDN)) {
                Context context = getContext();
                t9.i.f(context, com.umeng.analytics.pro.f.X);
                b0.m(context);
                return;
            }
            return;
        }
        a6.a aVar = a6.a.f228a;
        Context context2 = getContext();
        t9.i.f(context2, com.umeng.analytics.pro.f.X);
        aVar.t(context2, adInfo.getAction(), z10);
        s1.q qVar = s1.q.f18727a;
        Context context3 = getContext();
        t9.i.f(context3, com.umeng.analytics.pro.f.X);
        d6.b bVar = d6.b.f12660a;
        Context context4 = getContext();
        t9.i.f(context4, com.umeng.analytics.pro.f.X);
        qVar.h(context3, bVar.m(context4), adInfo.getMedia_type(), adInfo);
    }

    public static /* synthetic */ void openAdLink$default(BeforeVodAdView beforeVodAdView, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        beforeVodAdView.openAdLink(z10);
    }

    private final void pauseVideo() {
        Object tag = ((AutoFrameLayout) _$_findCachedViewById(R$id.mAflVideoWrapper)).getTag();
        if (tag != null) {
            MediaPlayer mediaPlayer = (MediaPlayer) tag;
            this.mPlayProgress = mediaPlayer.getCurrentPosition();
            mediaPlayer.pause();
        }
    }

    private final void playVideo() {
        final MediaPlayer mediaPlayer = new MediaPlayer();
        mediaPlayer.setLooping(false);
        mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.mobile.brasiltv.view.adView.i
            @Override // android.media.MediaPlayer.OnPreparedListener
            public final void onPrepared(MediaPlayer mediaPlayer2) {
                BeforeVodAdView.playVideo$lambda$5(BeforeVodAdView.this, mediaPlayer, mediaPlayer2);
            }
        });
        mediaPlayer.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.mobile.brasiltv.view.adView.j
            @Override // android.media.MediaPlayer.OnErrorListener
            public final boolean onError(MediaPlayer mediaPlayer2, int i10, int i11) {
                boolean playVideo$lambda$6;
                playVideo$lambda$6 = BeforeVodAdView.playVideo$lambda$6(BeforeVodAdView.this, mediaPlayer2, i10, i11);
                return playVideo$lambda$6;
            }
        });
        SurfaceView surfaceView = new SurfaceView(getContext());
        surfaceView.setZOrderOnTop(false);
        surfaceView.setKeepScreenOn(true);
        surfaceView.getHolder().addCallback(new SurfaceHolder.Callback() { // from class: com.mobile.brasiltv.view.adView.BeforeVodAdView$playVideo$3
            @Override // android.view.SurfaceHolder.Callback
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i10, int i11, int i12) {
                t9.i.g(surfaceHolder, "holder");
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                AdInfoWrapper adInfoWrapper;
                AdInfoWrapper adInfoWrapper2;
                t9.i.g(surfaceHolder, "holder");
                adInfoWrapper = BeforeVodAdView.this.mAdInfoWrapper;
                String cachePath = adInfoWrapper != null ? adInfoWrapper.getCachePath() : null;
                if (cachePath == null || cachePath.length() == 0) {
                    return;
                }
                mediaPlayer.reset();
                MediaPlayer mediaPlayer2 = mediaPlayer;
                adInfoWrapper2 = BeforeVodAdView.this.mAdInfoWrapper;
                mediaPlayer2.setDataSource(adInfoWrapper2 != null ? adInfoWrapper2.getCachePath() : null);
                mediaPlayer.setDisplay(surfaceHolder);
                mediaPlayer.prepare();
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                t9.i.g(surfaceHolder, "holder");
            }
        });
        int i10 = R$id.mAflVideoWrapper;
        ((AutoFrameLayout) _$_findCachedViewById(i10)).addView(surfaceView, -1, -1);
        ((AutoFrameLayout) _$_findCachedViewById(i10)).setTag(mediaPlayer);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void playVideo$lambda$5(BeforeVodAdView beforeVodAdView, MediaPlayer mediaPlayer, MediaPlayer mediaPlayer2) {
        t9.i.g(beforeVodAdView, "this$0");
        t9.i.g(mediaPlayer, "$player");
        int i10 = beforeVodAdView.mPlayProgress;
        if (i10 != 0) {
            mediaPlayer.seekTo(i10);
        }
        mediaPlayer.start();
        beforeVodAdView.clearCountDown();
        beforeVodAdView.mCountDownTime = (mediaPlayer.getDuration() - beforeVodAdView.mPlayProgress) / 1000;
        beforeVodAdView.updateCountDown();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean playVideo$lambda$6(BeforeVodAdView beforeVodAdView, MediaPlayer mediaPlayer, int i10, int i11) {
        t9.i.g(beforeVodAdView, "this$0");
        beforeVodAdView.countDownFinished();
        return true;
    }

    private final void releaseAd() {
        setVisibility(8);
        releaseVideo();
    }

    private final void releaseVideo() {
        this.mPlayProgress = 0;
        this.mAdInfoWrapper = null;
        int i10 = R$id.mAflVideoWrapper;
        ((AutoFrameLayout) _$_findCachedViewById(i10)).removeAllViews();
        if (((AutoFrameLayout) _$_findCachedViewById(i10)).getTag() == null) {
            return;
        }
        Object tag = ((AutoFrameLayout) _$_findCachedViewById(i10)).getTag();
        t9.i.e(tag, "null cannot be cast to non-null type android.media.MediaPlayer");
        ((MediaPlayer) tag).stop();
        Object tag2 = ((AutoFrameLayout) _$_findCachedViewById(i10)).getTag();
        t9.i.e(tag2, "null cannot be cast to non-null type android.media.MediaPlayer");
        ((MediaPlayer) tag2).release();
        ((AutoFrameLayout) _$_findCachedViewById(i10)).setTag(null);
    }

    private final void showUIByOrientation() {
        if (getResources().getConfiguration().orientation == 1) {
            ((ImageView) _$_findCachedViewById(R$id.mIvBack)).setVisibility(8);
            ((TextView) _$_findCachedViewById(R$id.mTvTitle)).setVisibility(8);
            ((ImageView) _$_findCachedViewById(R$id.mIvBeforeVodAd)).setScaleType(ImageView.ScaleType.FIT_XY);
            adjustFullScreenMargin(10, 0);
            return;
        }
        int i10 = R$id.mIvBack;
        ((ImageView) _$_findCachedViewById(i10)).setVisibility(0);
        int i11 = R$id.mTvTitle;
        ((TextView) _$_findCachedViewById(i11)).setVisibility(0);
        ((ImageView) _$_findCachedViewById(R$id.mIvBeforeVodAd)).setScaleType(ImageView.ScaleType.FIT_CENTER);
        adjustFullScreenMargin(20, 20);
        ViewGroup.LayoutParams layoutParams = ((ImageView) _$_findCachedViewById(i10)).getLayoutParams();
        t9.i.e(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        ((FrameLayout.LayoutParams) layoutParams).topMargin = 0;
        ViewGroup.LayoutParams layoutParams2 = ((TextView) _$_findCachedViewById(i11)).getLayoutParams();
        t9.i.e(layoutParams2, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        ((FrameLayout.LayoutParams) layoutParams2).topMargin = 0;
        ViewGroup.LayoutParams layoutParams3 = ((AutoLinearLayout) _$_findCachedViewById(R$id.mAllAdFlagWrapper)).getLayoutParams();
        t9.i.e(layoutParams3, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        ((FrameLayout.LayoutParams) layoutParams3).topMargin = 0;
    }

    private final void startVideo() {
        Object tag = ((AutoFrameLayout) _$_findCachedViewById(R$id.mAflVideoWrapper)).getTag();
        if (tag != null) {
            ((MediaPlayer) tag).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateCountDown() {
        TextView textView = (TextView) _$_findCachedViewById(R$id.mTvCountDown);
        StringBuilder sb = new StringBuilder();
        sb.append(this.mCountDownTime);
        sb.append('s');
        textView.setText(sb.toString());
        if (d6.b.f12660a.x()) {
            ((TextView) _$_findCachedViewById(R$id.mTvCountDownHint)).setText(getContext().getString(R.string.ads_skip));
        } else {
            ((TextView) _$_findCachedViewById(R$id.mTvCountDownHint)).setText(String.valueOf(getContext().getString(R.string.no_ad_for_vips)));
        }
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

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchWindowVisibilityChanged(int i10) {
        super.dispatchWindowVisibilityChanged(i10);
        if (i10 == 8) {
            pauseVideo();
            this.mCountDownHandler.removeMessages(this.MSG_COUNT_DOWN);
        } else if (this.mCountDownTime != 0) {
            startVideo();
            updateCountDown();
        }
    }

    public final void hideBeforeVodAd() {
        setVisibility(8);
        ((ImageView) _$_findCachedViewById(R$id.mIvBeforeVodAd)).setVisibility(8);
        ((AutoFrameLayout) _$_findCachedViewById(R$id.mAflVideoWrapper)).setVisibility(8);
        clearCountDown();
        releaseAd();
    }

    public final boolean isCr() {
        return this.isCr;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        showUIByOrientation();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        clearCountDown();
        releaseAd();
        super.onDetachedFromWindow();
    }

    public final void setBeforeVodCallback(BeforeVodCallback beforeVodCallback) {
        t9.i.g(beforeVodCallback, "callback");
        this.mBeforeVodCallback = beforeVodCallback;
    }

    public final void setCr(boolean z10) {
        this.isCr = z10;
    }

    public final void setTitle(String str) {
        t9.i.g(str, "title");
        ((TextView) _$_findCachedViewById(R$id.mTvTitle)).setText(str);
    }

    public final void showBeforeVodAd(AdInfoWrapper adInfoWrapper, String str) {
        AdInfo adInfo;
        t9.i.g(adInfoWrapper, "adInfoWrapper");
        t9.i.g(str, "adType");
        AdInfo adInfo2 = adInfoWrapper.getAdInfo();
        String str2 = null;
        String url = adInfo2 != null ? adInfo2.getUrl() : null;
        if (url == null || url.length() == 0) {
            return;
        }
        hideBeforeVodAd();
        this.mAdInfoWrapper = adInfoWrapper;
        AdInfo adInfo3 = adInfoWrapper.getAdInfo();
        if (!t9.i.b(adInfo3 != null ? adInfo3.getMedia_type() : null, "picture")) {
            AdInfoWrapper adInfoWrapper2 = this.mAdInfoWrapper;
            if (adInfoWrapper2 != null && (adInfo = adInfoWrapper2.getAdInfo()) != null) {
                str2 = adInfo.getMedia_type();
            }
            if (t9.i.b(str2, "video")) {
                setVisibility(0);
                ((AutoFrameLayout) _$_findCachedViewById(R$id.mAflVideoWrapper)).setVisibility(0);
                showUIByOrientation();
                playVideo();
                return;
            }
            return;
        }
        setVisibility(0);
        int i10 = R$id.mIvBeforeVodAd;
        ((ImageView) _$_findCachedViewById(i10)).setVisibility(0);
        showUIByOrientation();
        this.mCountDownTime = this.COUNT_DOWN_TIME;
        updateCountDown();
        s1.m mVar = s1.m.f18686a;
        Context context = getContext();
        t9.i.f(context, com.umeng.analytics.pro.f.X);
        ImageView imageView = (ImageView) _$_findCachedViewById(i10);
        t9.i.f(imageView, "mIvBeforeVodAd");
        AdInfoWrapper adInfoWrapper3 = this.mAdInfoWrapper;
        mVar.g0(context, imageView, str, adInfoWrapper3 != null ? adInfoWrapper3.getAdInfo() : null, (r23 & 16) != 0 ? null : null, (r23 & 32) != 0 ? null : null, (r23 & 64) != 0 ? null : null, (r23 & 128) != 0 ? false : false, (r23 & 256) != 0 ? -1 : 0);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BeforeVodAdView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        t9.i.g(context, com.umeng.analytics.pro.f.X);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BeforeVodAdView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        t9.i.g(context, com.umeng.analytics.pro.f.X);
        this._$_findViewCache = new LinkedHashMap();
        this.KEY_VIP_PLAY_PREFIX = "key_vip_play_";
        this.MSG_COUNT_DOWN = 1;
        this.COUNT_DOWN_TIME = 5L;
        this.mCountDownHandler = new CountDownHandler();
        initView(context);
    }
}
