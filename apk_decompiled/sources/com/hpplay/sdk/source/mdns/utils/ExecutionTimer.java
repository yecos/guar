package com.hpplay.sdk.source.mdns.utils;

import java.util.EmptyStackException;
import java.util.Stack;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public class ExecutionTimer {
    private static ExecutionTimer timer = new ExecutionTimer();
    private final Stack stack = new Stack();

    /* renamed from: com.hpplay.sdk.source.mdns.utils.ExecutionTimer$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$java$util$concurrent$TimeUnit;

        static {
            int[] iArr = new int[TimeUnit.values().length];
            $SwitchMap$java$util$concurrent$TimeUnit = iArr;
            try {
                iArr[TimeUnit.DAYS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$java$util$concurrent$TimeUnit[TimeUnit.HOURS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$java$util$concurrent$TimeUnit[TimeUnit.MICROSECONDS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$java$util$concurrent$TimeUnit[TimeUnit.MILLISECONDS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$java$util$concurrent$TimeUnit[TimeUnit.MINUTES.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$java$util$concurrent$TimeUnit[TimeUnit.NANOSECONDS.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$java$util$concurrent$TimeUnit[TimeUnit.SECONDS.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public static long _start() {
        return timer.start();
    }

    public static double _took(TimeUnit timeUnit) {
        return timer.took(timeUnit);
    }

    public long start() {
        return ((Long) this.stack.push(new Long(System.nanoTime()))).longValue();
    }

    public double took(TimeUnit timeUnit) {
        double d10;
        double d11;
        try {
            long nanoTime = System.nanoTime() - ((Long) this.stack.pop()).longValue();
            switch (AnonymousClass1.$SwitchMap$java$util$concurrent$TimeUnit[timeUnit.ordinal()]) {
                case 1:
                    d10 = nanoTime;
                    d11 = 8.64E13d;
                    Double.isNaN(d10);
                    break;
                case 2:
                    d10 = nanoTime;
                    d11 = 3.6E12d;
                    Double.isNaN(d10);
                    break;
                case 3:
                    d10 = nanoTime;
                    d11 = 1000.0d;
                    Double.isNaN(d10);
                    break;
                case 4:
                    d10 = nanoTime;
                    d11 = 1000000.0d;
                    Double.isNaN(d10);
                    break;
                case 5:
                    d10 = nanoTime;
                    d11 = 6.0E10d;
                    Double.isNaN(d10);
                    break;
                case 6:
                    return nanoTime;
                case 7:
                    d10 = nanoTime;
                    d11 = 1.0E9d;
                    Double.isNaN(d10);
                    break;
                default:
                    return 0.0d;
            }
            return d10 / d11;
        } catch (EmptyStackException unused) {
            return 0.0d;
        }
    }
}
