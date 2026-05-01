package com.taobao.accs.data;

import android.text.TextUtils;
import anet.channel.appmonitor.AppMonitor;
import com.google.android.gms.cast.framework.media.NotificationOptions;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hpplay.sdk.source.common.global.Constant;
import com.taobao.accs.common.Constants;
import com.taobao.accs.common.ThreadPoolExecutorFactory;
import com.taobao.accs.ut.monitor.AssembleMonitor;
import com.taobao.accs.utl.ALog;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public class a {
    public static final int SPLITTED_DATA_INDEX = 17;
    public static final int SPLITTED_DATA_MD5 = 18;
    public static final int SPLITTED_DATA_NUMS = 16;
    public static final int SPLITTED_TIME_OUT = 15;

    /* renamed from: a, reason: collision with root package name */
    private static final char[] f9093a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* renamed from: b, reason: collision with root package name */
    private String f9094b;

    /* renamed from: c, reason: collision with root package name */
    private int f9095c;

    /* renamed from: d, reason: collision with root package name */
    private String f9096d;

    /* renamed from: e, reason: collision with root package name */
    private long f9097e;

    /* renamed from: g, reason: collision with root package name */
    private ScheduledFuture<?> f9099g;

    /* renamed from: f, reason: collision with root package name */
    private volatile int f9098f = 0;

    /* renamed from: h, reason: collision with root package name */
    private Map<Integer, byte[]> f9100h = new TreeMap(new b(this));

    public a(String str, int i10, String str2) {
        this.f9094b = str;
        this.f9095c = i10;
        this.f9096d = str2;
    }

    public void a(long j10) {
        if (j10 <= 0) {
            j10 = NotificationOptions.SKIP_STEP_THIRTY_SECONDS_IN_MS;
        }
        this.f9099g = ThreadPoolExecutorFactory.getScheduledExecutor().schedule(new c(this), j10, TimeUnit.MILLISECONDS);
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x00e9 A[Catch: all -> 0x015a, TryCatch #0 {, blocks: (B:13:0x003e, B:15:0x0042, B:17:0x004e, B:18:0x0057, B:20:0x0059, B:22:0x0061, B:23:0x0067, B:25:0x007a, B:26:0x0085, B:28:0x008b, B:31:0x0095, B:38:0x00a5, B:40:0x00af, B:42:0x00c4, B:44:0x00e9, B:45:0x011d, B:47:0x013e, B:48:0x0141, B:52:0x0158, B:54:0x0143), top: B:12:0x003e }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x013e A[Catch: all -> 0x015a, TryCatch #0 {, blocks: (B:13:0x003e, B:15:0x0042, B:17:0x004e, B:18:0x0057, B:20:0x0059, B:22:0x0061, B:23:0x0067, B:25:0x007a, B:26:0x0085, B:28:0x008b, B:31:0x0095, B:38:0x00a5, B:40:0x00af, B:42:0x00c4, B:44:0x00e9, B:45:0x011d, B:47:0x013e, B:48:0x0141, B:52:0x0158, B:54:0x0143), top: B:12:0x003e }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x011a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public byte[] a(int i10, int i11, byte[] bArr) {
        long j10;
        long j11;
        ScheduledFuture<?> scheduledFuture;
        if (ALog.isPrintLog(ALog.Level.D)) {
            ALog.d("AssembleMessage", "putBurst", Constants.KEY_DATA_ID, this.f9094b, FirebaseAnalytics.Param.INDEX, Integer.valueOf(i10));
        }
        byte[] bArr2 = null;
        if (i11 != this.f9095c) {
            ALog.e("AssembleMessage", "putBurst fail as burstNums not match", new Object[0]);
            return null;
        }
        if (i10 >= 0 && i10 < i11) {
            synchronized (this) {
                if (this.f9098f != 0) {
                    ALog.e("AssembleMessage", "putBurst fail", Constant.KEY_STATUS, Integer.valueOf(this.f9098f));
                } else {
                    if (this.f9100h.get(Integer.valueOf(i10)) != null) {
                        ALog.e("AssembleMessage", "putBurst fail as exist old", new Object[0]);
                        return null;
                    }
                    if (this.f9100h.isEmpty()) {
                        this.f9097e = System.currentTimeMillis();
                    }
                    this.f9100h.put(Integer.valueOf(i10), bArr);
                    if (this.f9100h.size() == this.f9095c) {
                        byte[] bArr3 = null;
                        for (byte[] bArr4 : this.f9100h.values()) {
                            if (bArr3 == null) {
                                bArr3 = bArr4;
                            } else {
                                byte[] bArr5 = new byte[bArr3.length + bArr4.length];
                                System.arraycopy(bArr3, 0, bArr5, 0, bArr3.length);
                                System.arraycopy(bArr4, 0, bArr5, bArr3.length, bArr4.length);
                                bArr3 = bArr5;
                            }
                        }
                        if (!TextUtils.isEmpty(this.f9096d)) {
                            String str = new String(a(org.android.agoo.common.a.a(bArr3)));
                            if (!this.f9096d.equals(str)) {
                                ALog.w("AssembleMessage", "putBurst fail", Constants.KEY_DATA_ID, this.f9094b, "dataMd5", this.f9096d, "finalDataMd5", str);
                                this.f9098f = 3;
                                if (bArr2 == null) {
                                    j10 = bArr2.length;
                                    j11 = System.currentTimeMillis() - this.f9097e;
                                    this.f9098f = 2;
                                    ALog.i("AssembleMessage", "putBurst completed", Constants.KEY_DATA_ID, this.f9094b, "length", Long.valueOf(j10), "cost", Long.valueOf(j11));
                                } else {
                                    j10 = 0;
                                    j11 = 0;
                                }
                                AssembleMonitor assembleMonitor = new AssembleMonitor(this.f9094b, String.valueOf(this.f9098f));
                                assembleMonitor.assembleLength = j10;
                                assembleMonitor.assembleTimes = j11;
                                AppMonitor.getInstance().commitStat(assembleMonitor);
                                this.f9100h.clear();
                                scheduledFuture = this.f9099g;
                                if (scheduledFuture != null) {
                                    scheduledFuture.cancel(false);
                                }
                                return bArr2;
                            }
                        }
                        bArr2 = bArr3;
                        if (bArr2 == null) {
                        }
                        AssembleMonitor assembleMonitor2 = new AssembleMonitor(this.f9094b, String.valueOf(this.f9098f));
                        assembleMonitor2.assembleLength = j10;
                        assembleMonitor2.assembleTimes = j11;
                        AppMonitor.getInstance().commitStat(assembleMonitor2);
                        this.f9100h.clear();
                        scheduledFuture = this.f9099g;
                        if (scheduledFuture != null) {
                        }
                        return bArr2;
                    }
                }
                return null;
            }
        }
        ALog.e("AssembleMessage", "putBurst fail as burstIndex invalid", new Object[0]);
        return null;
    }

    private static char[] a(byte[] bArr) {
        char[] cArr = new char[bArr.length << 1];
        int i10 = 0;
        for (byte b10 : bArr) {
            int i11 = i10 + 1;
            char[] cArr2 = f9093a;
            cArr[i10] = cArr2[(b10 & 240) >>> 4];
            i10 = i11 + 1;
            cArr[i11] = cArr2[b10 & 15];
        }
        return cArr;
    }
}
