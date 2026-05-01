package tv.danmaku.ijk.media.player.widget.media;

import android.view.View;
import java.lang.ref.WeakReference;

/* loaded from: classes2.dex */
public final class MeasureHelper {
    private int mCurrentAspectRatio = 0;
    private int mMeasuredHeight;
    private int mMeasuredWidth;
    private int mVideoHeight;
    private int mVideoRotationDegree;
    private int mVideoSarDen;
    private int mVideoSarNum;
    private int mVideoWidth;
    private WeakReference<View> mWeakView;

    public MeasureHelper(View view) {
        this.mWeakView = new WeakReference<>(view);
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x00a6, code lost:
    
        if (r4 != false) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00ab, code lost:
    
        r12 = (int) (r0 / r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00af, code lost:
    
        r11 = (int) (r3 * r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00a9, code lost:
    
        if (r4 != false) goto L50;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void doMeasure(int i10, int i11) {
        int i12;
        float f10;
        int i13;
        int i14 = this.mVideoRotationDegree;
        if (i14 == 90 || i14 == 270) {
            i11 = i10;
            i10 = i11;
        }
        int defaultSize = View.getDefaultSize(this.mVideoWidth, i10);
        int defaultSize2 = View.getDefaultSize(this.mVideoHeight, i11);
        if (this.mCurrentAspectRatio != 3) {
            if (this.mVideoWidth <= 0 || this.mVideoHeight <= 0) {
                i10 = defaultSize;
                i11 = defaultSize2;
            } else {
                int mode = View.MeasureSpec.getMode(i10);
                i10 = View.MeasureSpec.getSize(i10);
                int mode2 = View.MeasureSpec.getMode(i11);
                i11 = View.MeasureSpec.getSize(i11);
                if (mode == Integer.MIN_VALUE && mode2 == Integer.MIN_VALUE) {
                    float f11 = i10;
                    float f12 = i11;
                    float f13 = f11 / f12;
                    int i15 = this.mCurrentAspectRatio;
                    if (i15 == 4) {
                        int i16 = this.mVideoRotationDegree;
                        f10 = (i16 == 90 || i16 == 270) ? 0.5625f : 1.7777778f;
                    } else if (i15 != 5) {
                        f10 = this.mVideoWidth / this.mVideoHeight;
                        int i17 = this.mVideoSarNum;
                        if (i17 > 0 && (i13 = this.mVideoSarDen) > 0) {
                            f10 = (f10 * i17) / i13;
                        }
                    } else {
                        int i18 = this.mVideoRotationDegree;
                        f10 = (i18 == 90 || i18 == 270) ? 0.75f : 1.3333334f;
                    }
                    boolean z10 = f10 > f13;
                    if (i15 != 0) {
                        if (i15 != 1) {
                            if (i15 != 4 && i15 != 5) {
                                if (z10) {
                                    i10 = Math.min(this.mVideoWidth, i10);
                                    i11 = (int) (i10 / f10);
                                } else {
                                    int min = Math.min(this.mVideoHeight, i11);
                                    i11 = min;
                                    i10 = (int) (min * f10);
                                }
                            }
                        }
                    }
                } else if (mode == 1073741824 && mode2 == 1073741824) {
                    int i19 = this.mVideoWidth;
                    int i20 = i19 * i11;
                    int i21 = this.mVideoHeight;
                    if (i20 < i10 * i21) {
                        i10 = (i19 * i11) / i21;
                    } else if (i19 * i11 > i10 * i21) {
                        i11 = (i21 * i10) / i19;
                    }
                } else if (mode == 1073741824) {
                    int i22 = (this.mVideoHeight * i10) / this.mVideoWidth;
                    if (mode2 != Integer.MIN_VALUE || i22 <= i11) {
                        i11 = i22;
                    }
                } else if (mode2 == 1073741824) {
                    int i23 = (this.mVideoWidth * i11) / this.mVideoHeight;
                    if (mode != Integer.MIN_VALUE || i23 <= i10) {
                        i10 = i23;
                    }
                } else {
                    int i24 = this.mVideoWidth;
                    int i25 = this.mVideoHeight;
                    if (mode2 != Integer.MIN_VALUE || i25 <= i11) {
                        i12 = i24;
                        i11 = i25;
                    } else {
                        i12 = (i11 * i24) / i25;
                    }
                    if (mode != Integer.MIN_VALUE || i12 <= i10) {
                        i10 = i12;
                    } else {
                        i11 = (i25 * i10) / i24;
                    }
                }
            }
        }
        this.mMeasuredWidth = i10;
        this.mMeasuredHeight = i11;
    }

    public int getMeasuredHeight() {
        return this.mMeasuredHeight;
    }

    public int getMeasuredWidth() {
        return this.mMeasuredWidth;
    }

    public View getView() {
        WeakReference<View> weakReference = this.mWeakView;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public void setAspectRatio(int i10) {
        this.mCurrentAspectRatio = i10;
    }

    public void setVideoRotation(int i10) {
        this.mVideoRotationDegree = i10;
    }

    public void setVideoSampleAspectRatio(int i10, int i11) {
        this.mVideoSarNum = i10;
        this.mVideoSarDen = i11;
    }

    public void setVideoSize(int i10, int i11) {
        this.mVideoWidth = i10;
        this.mVideoHeight = i11;
    }
}
