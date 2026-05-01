package com.hpplay.sdk.source.pass;

import android.os.SystemClock;

/* loaded from: classes3.dex */
public class HarassCode {
    public static final int CODE_RIGHT = 0;
    public static final int TIMEOUT = 2;
    public static final int WRONG = 1;
    String mCode;
    long mReceiveTime;
    int mTimeout;

    public static final class Instance {
        static HarassCode instance = new HarassCode();

        private Instance() {
        }
    }

    private HarassCode() {
    }

    public static HarassCode getInstance() {
        return Instance.instance;
    }

    public int canSend(String str) {
        if (this.mCode.equals(str)) {
            return SystemClock.elapsedRealtime() - this.mReceiveTime >= ((long) (this.mTimeout * 1000)) ? 2 : 0;
        }
        return 1;
    }

    public String getCode() {
        return this.mCode;
    }

    public long getReceiveTime() {
        return this.mReceiveTime;
    }

    public int getTimeout() {
        return this.mTimeout;
    }

    public void setCode(String str) {
        this.mCode = str;
    }

    public void setHarass(String str, int i10) {
        setCode(str);
        setTimeout(i10);
        setReceiveTime(SystemClock.elapsedRealtime());
    }

    public void setReceiveTime(long j10) {
        this.mReceiveTime = j10;
    }

    public void setTimeout(int i10) {
        this.mTimeout = i10;
    }
}
