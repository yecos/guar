package com.hpplay.component.protocol.mirror;

import com.google.android.gms.cast.framework.media.NotificationOptions;
import com.hpplay.component.common.protocol.IMirrorStateListener;
import com.hpplay.component.common.utils.CLog;

/* loaded from: classes2.dex */
public class AutoStrategy {
    public static final int BITRATE_HIGH = 8388608;
    public static final int BITRATE_LOW = 4194304;
    public static final float BITRATE_LOW1 = 3670016.0f;
    public static final int BITRATE_LOW2 = 3145728;
    public static final float BITRATE_LOW3 = 2621440.0f;
    public static final int BITRATE_LOW4 = 2097152;
    public static final float BITRATE_LOW5 = 1992294.4f;
    public static final int BITRATE_MID = 6291456;
    public static final int BITRATE_SUPER = 10485760;
    public static final int DELAY_LOW = 2;
    public static final int DELAY_TINY = 1;
    public static final int HIGH_DELAY = 4;
    private static final int MAX_SMOOTH_COUNT = 3000;
    public static final int MID_DELAY = 3;
    public static final int SUPER_HIGH_DELAY = 5;
    private static final String TAG = "AutoStrategy";
    private boolean isAutoBitrate;
    private boolean isPauseEncode;
    private int lowDelayCount;
    private int mFrameRate;
    private int mHistoryBitrate;
    private int mJamCountkMonitor;
    private int mRepeatRiseCount;
    private int mSmoothCount;
    private IMirrorStateListener mStrategyListener;
    private int mBitrate = BITRATE_HIGH;
    private long delayMarkTime = System.currentTimeMillis();
    private long smoothInterval = 0;
    private int mQueueMaxRemain = 4;

    public AutoStrategy(IMirrorStateListener iMirrorStateListener, int i10) {
        this.mStrategyListener = iMirrorStateListener;
        this.mFrameRate = i10;
        CLog.i(TAG, "===> " + this.mFrameRate);
    }

    private synchronized boolean bitrateAdjust(boolean z10) {
        boolean z11;
        int i10 = this.mBitrate;
        int i11 = 1992294;
        int i12 = BITRATE_LOW4;
        if (i10 != 1992294) {
            if (i10 != 2097152) {
                int i13 = BITRATE_LOW2;
                if (i10 == 2621440) {
                    if (!z10) {
                        i12 = BITRATE_LOW2;
                    }
                    this.mBitrate = i12;
                } else if (i10 != 3145728) {
                    int i14 = 3670016;
                    int i15 = BITRATE_LOW;
                    if (i10 != 3670016) {
                        int i16 = BITRATE_MID;
                        if (i10 != 4194304) {
                            int i17 = BITRATE_HIGH;
                            if (i10 == 6291456) {
                                if (!z10) {
                                    i15 = BITRATE_HIGH;
                                }
                                this.mBitrate = i15;
                            } else if (i10 == 8388608) {
                                if (!z10) {
                                    i16 = BITRATE_SUPER;
                                }
                                this.mBitrate = i16;
                            } else if (i10 == 10485760) {
                                if (!z10) {
                                    i17 = BITRATE_SUPER;
                                }
                                this.mBitrate = i17;
                            }
                        } else {
                            if (!z10) {
                                i14 = BITRATE_MID;
                            }
                            this.mBitrate = i14;
                        }
                    } else {
                        if (!z10) {
                            i13 = BITRATE_LOW;
                        }
                        this.mBitrate = i13;
                    }
                } else {
                    if (!z10) {
                        r1 = 3670016.0f;
                    }
                    this.mBitrate = (int) r1;
                }
            } else {
                this.mBitrate = (int) (z10 ? 1992294.4f : 2621440.0f);
            }
            z11 = false;
        } else {
            if (!z10) {
                i11 = BITRATE_LOW4;
            }
            this.mBitrate = i11;
            z11 = true;
        }
        return z11;
    }

    private boolean checkHistoryIsExceed() {
        if (this.mBitrate == this.mHistoryBitrate) {
            this.mRepeatRiseCount++;
            CLog.i(TAG, " checkHistoryIsExceed  repeat count " + this.mRepeatRiseCount);
        }
        if (this.mRepeatRiseCount <= 2) {
            this.mHistoryBitrate = this.mBitrate;
            return false;
        }
        this.mRepeatRiseCount = 0;
        int i10 = this.mQueueMaxRemain;
        if (i10 > 2) {
            this.mQueueMaxRemain = i10 - 1;
        }
        this.mQueueMaxRemain = i10;
        this.mHistoryBitrate = this.mBitrate;
        return true;
    }

    private void onBandwidthReduce(int i10) {
        setBitrateLevel(i10);
        boolean bitrateAdjust = bitrateAdjust(true);
        IMirrorStateListener iMirrorStateListener = this.mStrategyListener;
        if (iMirrorStateListener != null) {
            iMirrorStateListener.onBitrateCallback(this.mBitrate);
            if (bitrateAdjust) {
                this.mStrategyListener.onFrameCallback(25);
            }
        }
    }

    private void onBandwidthRise() {
        IMirrorStateListener iMirrorStateListener;
        if (checkHistoryIsExceed()) {
            return;
        }
        bitrateAdjust(false);
        CLog.i(TAG, " onBandwidthRise ===> " + ((this.mBitrate / 1000) / 1000));
        if (this.mBitrate == 10485760 && (iMirrorStateListener = this.mStrategyListener) != null) {
            iMirrorStateListener.onFrameCallback(this.mFrameRate);
        }
        IMirrorStateListener iMirrorStateListener2 = this.mStrategyListener;
        if (iMirrorStateListener2 != null) {
            iMirrorStateListener2.onBitrateCallback(this.mBitrate);
        }
    }

    private void setBitrateLevel(int i10) {
        if (i10 != 1) {
            if (i10 != 2) {
                if (i10 != 3) {
                    if (i10 != 4) {
                        if (i10 == 5) {
                            this.mBitrate = 1992294;
                        }
                    } else if (this.mBitrate <= 2621440.0f) {
                        return;
                    } else {
                        this.mBitrate = 2621440;
                    }
                } else if (this.mBitrate <= 3145728) {
                    return;
                } else {
                    this.mBitrate = BITRATE_LOW2;
                }
            } else if (this.mBitrate <= 3670016.0f) {
                return;
            } else {
                this.mBitrate = 3670016;
            }
            CLog.i(TAG, "setBitrateLevel " + ((this.mBitrate / 1000) / 1000));
        }
    }

    public void setAutoBitrate(boolean z10) {
        CLog.i(TAG, "===> " + z10);
        this.isAutoBitrate = z10;
    }

    public void videoBufferSizeCheck(int i10, int i11) {
        if (i10 > i11) {
            if (this.mStrategyListener == null || this.isPauseEncode) {
                return;
            }
            this.isPauseEncode = true;
            this.delayMarkTime = System.currentTimeMillis();
            this.mStrategyListener.onPauseEncode();
            this.mJamCountkMonitor++;
            return;
        }
        if (i10 < this.mQueueMaxRemain) {
            this.mSmoothCount++;
        } else {
            this.mSmoothCount = 0;
        }
        if (this.mSmoothCount > 3000) {
            this.mSmoothCount = 0;
            if (this.isAutoBitrate) {
                onBandwidthRise();
            }
        }
    }

    public void writeDelayCheck(int i10) {
        int i11;
        int i12;
        if (i10 == 0 && this.isPauseEncode) {
            this.isPauseEncode = false;
            long currentTimeMillis = System.currentTimeMillis() - this.delayMarkTime;
            if (currentTimeMillis <= 500) {
                if (this.smoothInterval <= 0 || System.currentTimeMillis() - this.smoothInterval <= NotificationOptions.SKIP_STEP_TEN_SECONDS_IN_MS || (i12 = this.lowDelayCount) <= 0) {
                    this.lowDelayCount++;
                } else {
                    this.lowDelayCount = i12 - 1;
                }
                this.smoothInterval = System.currentTimeMillis();
                i11 = 2;
            } else if (currentTimeMillis <= 1000) {
                this.lowDelayCount = 0;
                i11 = 3;
            } else if (currentTimeMillis <= 1500) {
                this.lowDelayCount = 0;
                i11 = 4;
            } else if (currentTimeMillis > 2000) {
                this.lowDelayCount = 0;
                i11 = 5;
            } else {
                i11 = 1;
            }
            CLog.i(TAG, "-----> remain send time --- > " + currentTimeMillis + "  level  " + i11 + " lowDelayCount  " + this.lowDelayCount);
            if (i11 == 2 && this.lowDelayCount > 5) {
                if (this.isAutoBitrate) {
                    onBandwidthReduce(1);
                }
                this.lowDelayCount = 0;
            } else if (this.isAutoBitrate) {
                onBandwidthReduce(i11);
            }
            if (currentTimeMillis > NotificationOptions.SKIP_STEP_TEN_SECONDS_IN_MS || (currentTimeMillis > 5000 && this.mJamCountkMonitor > 5)) {
                CLog.i(TAG, "-----> onNetworkPoor --- > ");
                this.mJamCountkMonitor = 0;
                IMirrorStateListener iMirrorStateListener = this.mStrategyListener;
                if (iMirrorStateListener != null && iMirrorStateListener.onNetworkPoor()) {
                    return;
                }
            }
            IMirrorStateListener iMirrorStateListener2 = this.mStrategyListener;
            if (iMirrorStateListener2 != null) {
                iMirrorStateListener2.onResumeEncode();
            }
        }
    }
}
