package cn.bingoogolapple.bgabanner;

import android.content.Context;
import android.widget.Scroller;

/* loaded from: classes.dex */
public class BGABannerScroller extends Scroller {
    private int mDuration;

    public BGABannerScroller(Context context, int i10) {
        super(context);
        this.mDuration = i10;
    }

    @Override // android.widget.Scroller
    public void startScroll(int i10, int i11, int i12, int i13) {
        super.startScroll(i10, i11, i12, i13, this.mDuration);
    }

    @Override // android.widget.Scroller
    public void startScroll(int i10, int i11, int i12, int i13, int i14) {
        super.startScroll(i10, i11, i12, i13, this.mDuration);
    }
}
