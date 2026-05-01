package cn.bingoogolapple.bgabanner;

import android.view.View;

/* loaded from: classes.dex */
public abstract class BGAOnNoDoubleClickListener implements View.OnClickListener {
    private long mLastClickTime;
    private int mThrottleFirstTime;

    public BGAOnNoDoubleClickListener() {
        this.mThrottleFirstTime = 1000;
        this.mLastClickTime = 0L;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.mLastClickTime > this.mThrottleFirstTime) {
            this.mLastClickTime = currentTimeMillis;
            onNoDoubleClick(view);
        }
    }

    public abstract void onNoDoubleClick(View view);

    public BGAOnNoDoubleClickListener(int i10) {
        this.mLastClickTime = 0L;
        this.mThrottleFirstTime = i10;
    }
}
