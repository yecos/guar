package com.mobile.brasiltv.view.shortvideo;

import android.widget.SeekBar;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatSeekBar;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.view.shortvideo.ShortVideoSeekBar;
import com.msandroid.mobile.R;
import com.zhy.autolayout.AutoLinearLayout;
import com.zhy.autolayout.utils.AutoUtils;
import t9.i;

/* loaded from: classes3.dex */
public final class ShortVideoSeekBar$initListener$1 implements SeekBar.OnSeekBarChangeListener {
    final /* synthetic */ ShortVideoSeekBar this$0;

    public ShortVideoSeekBar$initListener$1(ShortVideoSeekBar shortVideoSeekBar) {
        this.this$0 = shortVideoSeekBar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onStopTrackingTouch$lambda$0(ShortVideoSeekBar shortVideoSeekBar, SeekBar seekBar) {
        Runnable runnable;
        Runnable runnable2;
        ShortVideoSeekBar.OnSeekListener onSeekListener;
        i.g(shortVideoSeekBar, "this$0");
        i.g(seekBar, "$seekBar");
        runnable = shortVideoSeekBar.resetSeekBarRunnable;
        shortVideoSeekBar.removeCallbacks(runnable);
        runnable2 = shortVideoSeekBar.resetSeekBarRunnable;
        shortVideoSeekBar.postDelayed(runnable2, 2000L);
        onSeekListener = shortVideoSeekBar.mSeekListener;
        if (onSeekListener != null) {
            onSeekListener.onSeekStop(seekBar.getProgress());
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onProgressChanged(SeekBar seekBar, int i10, boolean z10) {
        ShortVideoSeekBar.OnSeekListener onSeekListener;
        i.g(seekBar, "seekBar");
        this.this$0.setProgress(i10);
        onSeekListener = this.this$0.mSeekListener;
        if (onSeekListener != null) {
            onSeekListener.onSeeking(seekBar.getProgress());
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar seekBar) {
        ShortVideoSeekBar.OnSeekListener onSeekListener;
        Runnable runnable;
        i.g(seekBar, "seekBar");
        if (seekBar.isEnabled()) {
            ShortVideoSeekBar shortVideoSeekBar = this.this$0;
            int i10 = R$id.mSeekBar;
            ((AppCompatSeekBar) shortVideoSeekBar._$_findCachedViewById(i10)).setThumb(this.this$0.getContext().getResources().getDrawable(R.drawable.seekbar_thumb_shortvideo));
            ((TextView) this.this$0._$_findCachedViewById(R$id.mTvCurrentTime)).setVisibility(0);
            ((TextView) this.this$0._$_findCachedViewById(R$id.mTvMaxTime)).setVisibility(0);
            ((AppCompatSeekBar) this.this$0._$_findCachedViewById(i10)).setLayoutParams(new AutoLinearLayout.LayoutParams(-1, AutoUtils.getPercentHeightSize(64)));
            ((AppCompatSeekBar) this.this$0._$_findCachedViewById(i10)).setPadding(AutoUtils.getPercentWidthSize(6), AutoUtils.getPercentHeightSize(50), AutoUtils.getPercentWidthSize(6), AutoUtils.getPercentHeightSize(10));
            onSeekListener = this.this$0.mSeekListener;
            if (onSeekListener != null) {
                onSeekListener.onSeekStart();
            }
            ShortVideoSeekBar shortVideoSeekBar2 = this.this$0;
            runnable = shortVideoSeekBar2.resetSeekBarRunnable;
            shortVideoSeekBar2.removeCallbacks(runnable);
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(final SeekBar seekBar) {
        i.g(seekBar, "seekBar");
        if (seekBar.isEnabled()) {
            AppCompatSeekBar appCompatSeekBar = (AppCompatSeekBar) this.this$0._$_findCachedViewById(R$id.mSeekBar);
            final ShortVideoSeekBar shortVideoSeekBar = this.this$0;
            appCompatSeekBar.post(new Runnable() { // from class: com.mobile.brasiltv.view.shortvideo.b
                @Override // java.lang.Runnable
                public final void run() {
                    ShortVideoSeekBar$initListener$1.onStopTrackingTouch$lambda$0(ShortVideoSeekBar.this, seekBar);
                }
            });
        }
    }
}
