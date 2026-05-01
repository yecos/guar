package com.mobile.brasiltv.view.shortvideo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatSeekBar;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.mobile.brasiltv.R$id;
import com.msandroid.mobile.R;
import com.umeng.analytics.pro.f;
import com.zhy.autolayout.AutoLinearLayout;
import com.zhy.autolayout.utils.AutoUtils;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import t9.i;
import t9.z;

/* loaded from: classes3.dex */
public final class ShortVideoSeekBar extends AutoLinearLayout {
    public Map<Integer, View> _$_findViewCache;
    private OnSeekListener mSeekListener;
    private final Runnable resetSeekBarRunnable;

    public interface OnSeekListener {
        void onSeekReset();

        void onSeekStart();

        void onSeekStop(int i10);

        void onSeeking(int i10);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShortVideoSeekBar(Context context) {
        super(context);
        i.g(context, f.X);
        this._$_findViewCache = new LinkedHashMap();
        this.resetSeekBarRunnable = new Runnable() { // from class: com.mobile.brasiltv.view.shortvideo.a
            @Override // java.lang.Runnable
            public final void run() {
                ShortVideoSeekBar.resetSeekBarRunnable$lambda$0(ShortVideoSeekBar.this);
            }
        };
        initView();
    }

    private final String getShowTime(int i10) {
        int i11 = i10 / 60000;
        int i12 = i11 / 60;
        int i13 = (i10 / 1000) % 60;
        int i14 = i11 % 60;
        if (i12 > 0) {
            z zVar = z.f18964a;
            String format = String.format(Locale.US, "%02d:%02d:%02d", Arrays.copyOf(new Object[]{Integer.valueOf(i12), Integer.valueOf(i14), Integer.valueOf(i13)}, 3));
            i.f(format, "format(locale, format, *args)");
            return format;
        }
        z zVar2 = z.f18964a;
        String format2 = String.format(Locale.US, "%02d:%02d", Arrays.copyOf(new Object[]{Integer.valueOf(i14), Integer.valueOf(i13)}, 2));
        i.f(format2, "format(locale, format, *args)");
        return format2;
    }

    private final void initListener() {
        int i10 = R$id.mSeekBar;
        ((AppCompatSeekBar) _$_findCachedViewById(i10)).setEnabled(false);
        ((AppCompatSeekBar) _$_findCachedViewById(i10)).setThumb(null);
        ((AppCompatSeekBar) _$_findCachedViewById(i10)).setProgressDrawable(getContext().getResources().getDrawable(R.drawable.bg_progress_shortvideo));
        ((AppCompatSeekBar) _$_findCachedViewById(i10)).setLayoutParams(new AutoLinearLayout.LayoutParams(-1, AutoUtils.getPercentHeightSize(62)));
        ((AppCompatSeekBar) _$_findCachedViewById(i10)).setPadding(AutoUtils.getPercentWidthSize(6), AutoUtils.getPercentHeightSize(50), AutoUtils.getPercentWidthSize(6), AutoUtils.getPercentHeightSize(10));
        ((AppCompatSeekBar) _$_findCachedViewById(i10)).setOnSeekBarChangeListener(new ShortVideoSeekBar$initListener$1(this));
    }

    private final void initView() {
        setOrientation(1);
        LayoutInflater.from(getContext()).inflate(R.layout.layout_shortvideo_seekbar, (ViewGroup) this, true);
        initListener();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void resetSeekBarRunnable$lambda$0(ShortVideoSeekBar shortVideoSeekBar) {
        i.g(shortVideoSeekBar, "this$0");
        int i10 = R$id.mSeekBar;
        ((AppCompatSeekBar) shortVideoSeekBar._$_findCachedViewById(i10)).setThumb(null);
        ((TextView) shortVideoSeekBar._$_findCachedViewById(R$id.mTvCurrentTime)).setVisibility(8);
        ((TextView) shortVideoSeekBar._$_findCachedViewById(R$id.mTvMaxTime)).setVisibility(8);
        ((AppCompatSeekBar) shortVideoSeekBar._$_findCachedViewById(i10)).setLayoutParams(new AutoLinearLayout.LayoutParams(-1, AutoUtils.getPercentHeightSize(62)));
        ((AppCompatSeekBar) shortVideoSeekBar._$_findCachedViewById(i10)).setPadding(AutoUtils.getPercentWidthSize(6), AutoUtils.getPercentHeightSize(50), AutoUtils.getPercentWidthSize(6), AutoUtils.getPercentHeightSize(10));
        OnSeekListener onSeekListener = shortVideoSeekBar.mSeekListener;
        if (onSeekListener != null) {
            onSeekListener.onSeekReset();
        }
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

    public final void removeCallbacks() {
        removeCallbacks(this.resetSeekBarRunnable);
        post(this.resetSeekBarRunnable);
    }

    public final void setMax(int i10) {
        int i11 = R$id.mSeekBar;
        ((AppCompatSeekBar) _$_findCachedViewById(i11)).setEnabled(true);
        ((AppCompatSeekBar) _$_findCachedViewById(i11)).setMax(i10);
        ((TextView) _$_findCachedViewById(R$id.mTvCurrentTime)).setText(getShowTime(0));
        ((TextView) _$_findCachedViewById(R$id.mTvMaxTime)).setText('/' + getShowTime(i10));
    }

    public final void setProgress(int i10) {
        ((AppCompatSeekBar) _$_findCachedViewById(R$id.mSeekBar)).setProgress(i10);
        ((TextView) _$_findCachedViewById(R$id.mTvCurrentTime)).setText(getShowTime(i10));
    }

    public final void setSeekListener(OnSeekListener onSeekListener) {
        i.g(onSeekListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.mSeekListener = onSeekListener;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShortVideoSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        i.g(context, f.X);
        this._$_findViewCache = new LinkedHashMap();
        this.resetSeekBarRunnable = new Runnable() { // from class: com.mobile.brasiltv.view.shortvideo.a
            @Override // java.lang.Runnable
            public final void run() {
                ShortVideoSeekBar.resetSeekBarRunnable$lambda$0(ShortVideoSeekBar.this);
            }
        };
        initView();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShortVideoSeekBar(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        i.g(context, f.X);
        this._$_findViewCache = new LinkedHashMap();
        this.resetSeekBarRunnable = new Runnable() { // from class: com.mobile.brasiltv.view.shortvideo.a
            @Override // java.lang.Runnable
            public final void run() {
                ShortVideoSeekBar.resetSeekBarRunnable$lambda$0(ShortVideoSeekBar.this);
            }
        };
        initView();
    }
}
