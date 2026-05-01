package org.android.spdy;

/* loaded from: classes.dex */
public class NetTimeGaurd {
    public static final int CREATE = 0;
    public static final int ERROR = 2;
    public static final int PING = 1;
    public static final int STREAM = 3;
    private static final long calltime = 10;
    private static final long total = 50;
    private static long[] totaltime = new long[4];

    public static long begin() {
        if (SpdyAgent.enableTimeGaurd) {
            return System.currentTimeMillis();
        }
        return 0L;
    }

    public static void end(String str, int i10, long j10) {
        if (SpdyAgent.enableTimeGaurd) {
            long currentTimeMillis = System.currentTimeMillis() - j10;
            long[] jArr = totaltime;
            jArr[i10] = jArr[i10] + currentTimeMillis;
            StringBuilder sb = new StringBuilder();
            sb.append("NetTimeGaurd[end]");
            sb.append(str);
            sb.append(" time=");
            sb.append(currentTimeMillis);
            sb.append(" total=");
            sb.append(totaltime[i10]);
            if (currentTimeMillis <= calltime) {
                return;
            }
            throw new SpdyErrorException("CallBack:" + str + " timeconsuming:" + currentTimeMillis + "  mustlessthan:" + calltime, -1);
        }
    }

    public static void finish(int i10) {
        if (SpdyAgent.enableTimeGaurd) {
            StringBuilder sb = new StringBuilder();
            sb.append("NetTimeGaurd[finish]:time=");
            sb.append(totaltime[i10]);
            if (totaltime[i10] <= total) {
                return;
            }
            throw new SpdyErrorException("CallBack totaltimeconsuming:" + totaltime[i10] + "  mustlessthan:" + total, -1);
        }
    }

    public static void start(int i10) {
        if (SpdyAgent.enableTimeGaurd) {
            totaltime[i10] = 0;
        }
    }
}
