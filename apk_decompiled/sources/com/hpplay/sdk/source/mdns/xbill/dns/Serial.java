package com.hpplay.sdk.source.mdns.xbill.dns;

import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* loaded from: classes3.dex */
public final class Serial {
    private static final long MAX32 = 4294967295L;

    private Serial() {
    }

    public static int compare(long j10, long j11) {
        if (j10 < 0 || j10 > MAX32) {
            throw new IllegalArgumentException(j10 + " out of range");
        }
        if (j11 < 0 || j11 > MAX32) {
            throw new IllegalArgumentException(j11 + " out of range");
        }
        long j12 = j10 - j11;
        if (j12 >= MAX32) {
            j12 -= IjkMediaMeta.AV_CH_WIDE_RIGHT;
        } else if (j12 < -4294967295L) {
            j12 += IjkMediaMeta.AV_CH_WIDE_RIGHT;
        }
        return (int) j12;
    }
}
