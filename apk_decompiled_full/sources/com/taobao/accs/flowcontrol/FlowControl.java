package com.taobao.accs.flowcontrol;

import android.content.Context;
import android.text.TextUtils;
import com.taobao.accs.base.TaoBaseService;
import com.taobao.accs.utl.ALog;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes3.dex */
public class FlowControl {
    public static final int DELAY_MAX = -1;
    public static final int DELAY_MAX_BRUSH = -1000;
    public static final int HIGH_FLOW_CTRL = 2;
    public static final int HIGH_FLOW_CTRL_BRUSH = 3;
    public static final int LOW_FLOW_CTRL = 1;
    public static final int NO_FLOW_CTRL = 0;
    public static final String SERVICE_ALL = "ALL";
    public static final String SERVICE_ALL_BRUSH = "ALL_BRUSH";
    public static final int STATUS_FLOW_CTRL_ALL = 420;
    public static final int STATUS_FLOW_CTRL_BRUSH = 422;
    public static final int STATUS_FLOW_CTRL_CUR = 421;

    /* renamed from: a, reason: collision with root package name */
    private Context f9134a;

    /* renamed from: b, reason: collision with root package name */
    private FlowCtrlInfoHolder f9135b;

    public static class FlowControlInfo implements Serializable {
        private static final long serialVersionUID = -2259991484877844919L;
        public String bizId;
        public long delayTime;
        public long expireTime;
        public String serviceId;
        public long startTime;
        public int status;

        public FlowControlInfo(String str, String str2, int i10, long j10, long j11, long j12) {
            this.serviceId = str;
            this.bizId = str2;
            this.status = i10;
            this.delayTime = j10;
            this.expireTime = j11 <= 0 ? 0L : j11;
            this.startTime = j12 <= 0 ? 0L : j12;
        }

        public boolean isExpired() {
            return System.currentTimeMillis() - (this.startTime + this.expireTime) > 0;
        }

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("flow ctrl serviceId:");
            stringBuffer.append(this.serviceId);
            stringBuffer.append(" bizId:");
            stringBuffer.append(this.bizId);
            stringBuffer.append(" status:");
            stringBuffer.append(this.status);
            stringBuffer.append(" delayTime:");
            stringBuffer.append(this.delayTime);
            stringBuffer.append(" startTime:");
            stringBuffer.append(this.startTime);
            stringBuffer.append(" expireTime:");
            stringBuffer.append(this.expireTime);
            return stringBuffer.toString();
        }
    }

    public static class FlowCtrlInfoHolder implements Serializable {
        private static final long serialVersionUID = 6307563052429742524L;
        Map<String, FlowControlInfo> flowCtrlMap = null;

        public FlowControlInfo get(String str, String str2) {
            if (this.flowCtrlMap == null) {
                return null;
            }
            if (!TextUtils.isEmpty(str2)) {
                str = str + "_" + str2;
            }
            return this.flowCtrlMap.get(str);
        }

        public void put(String str, String str2, FlowControlInfo flowControlInfo) {
            if (!TextUtils.isEmpty(str2)) {
                str = str + "_" + str2;
            }
            if (this.flowCtrlMap == null) {
                this.flowCtrlMap = new HashMap();
            }
            this.flowCtrlMap.put(str, flowControlInfo);
        }
    }

    public FlowControl(Context context) {
        this.f9134a = context;
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x0142 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0144  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int a(Map<Integer, String> map, String str) {
        long j10;
        int i10;
        long j11;
        FlowControlInfo flowControlInfo;
        if (map != null) {
            try {
                String str2 = map.get(Integer.valueOf(TaoBaseService.ExtHeaderType.TYPE_STATUS.ordinal()));
                String str3 = map.get(Integer.valueOf(TaoBaseService.ExtHeaderType.TYPE_DELAY.ordinal()));
                String str4 = map.get(Integer.valueOf(TaoBaseService.ExtHeaderType.TYPE_EXPIRE.ordinal()));
                String str5 = map.get(Integer.valueOf(TaoBaseService.ExtHeaderType.TYPE_BUSINESS.ordinal()));
                i10 = TextUtils.isEmpty(str2) ? 0 : Integer.valueOf(str2).intValue();
                try {
                    j10 = TextUtils.isEmpty(str3) ? 0L : Long.valueOf(str3).longValue();
                    try {
                        long longValue = TextUtils.isEmpty(str4) ? 0L : Long.valueOf(str4).longValue();
                        if ((i10 != 420 && i10 != 421 && i10 != 422) || !a(j10, longValue)) {
                            return 0;
                        }
                        try {
                            synchronized (this) {
                                try {
                                    if (this.f9135b == null) {
                                        this.f9135b = new FlowCtrlInfoHolder();
                                    }
                                    if (i10 == 420) {
                                        j11 = j10;
                                        flowControlInfo = new FlowControlInfo(SERVICE_ALL, "", i10, j10, longValue, System.currentTimeMillis());
                                        this.f9135b.put(SERVICE_ALL, "", flowControlInfo);
                                    } else {
                                        j11 = j10;
                                        if (i10 == 422) {
                                            flowControlInfo = new FlowControlInfo(SERVICE_ALL_BRUSH, "", i10, j11, longValue, System.currentTimeMillis());
                                            this.f9135b.put(SERVICE_ALL_BRUSH, "", flowControlInfo);
                                        } else if (i10 != 421 || TextUtils.isEmpty(str)) {
                                            flowControlInfo = null;
                                        } else {
                                            FlowControlInfo flowControlInfo2 = new FlowControlInfo(str, str5, i10, j11, longValue, System.currentTimeMillis());
                                            this.f9135b.put(str, str5, flowControlInfo2);
                                            flowControlInfo = flowControlInfo2;
                                        }
                                    }
                                    if (flowControlInfo != null) {
                                        ALog.e("FlowControl", "updateFlowCtrlInfo " + flowControlInfo.toString(), new Object[0]);
                                    }
                                    j10 = j11;
                                } catch (Throwable th) {
                                    th = th;
                                    long j12 = j10;
                                    try {
                                        throw th;
                                    } catch (Throwable th2) {
                                        th = th2;
                                        j10 = j12;
                                        ALog.e("FlowControl", "updateFlowCtrlInfo", th, new Object[0]);
                                        if (j10 <= 0) {
                                        }
                                    }
                                }
                            }
                        } catch (Throwable th3) {
                            th = th3;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                    }
                } catch (Throwable th5) {
                    th = th5;
                    j10 = 0;
                }
            } catch (Throwable th6) {
                th = th6;
                j10 = 0;
                i10 = 0;
            }
        } else {
            j10 = 0;
            i10 = 0;
        }
        if (j10 <= 0) {
            return 1;
        }
        if (j10 == 0) {
            return 0;
        }
        return 422 == i10 ? 3 : 2;
    }

    private boolean a(long j10, long j11) {
        if (j10 != 0 && j11 > 0) {
            return true;
        }
        ALog.e("FlowControl", "error flow ctrl info", new Object[0]);
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x008c, code lost:
    
        if (r5.isExpired() != false) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0096, code lost:
    
        a();
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0094, code lost:
    
        if (r0.isExpired() != false) goto L58;
     */
    /* JADX WARN: Removed duplicated region for block: B:21:0x004c A[Catch: all -> 0x00dc, TryCatch #0 {, blocks: (B:9:0x0013, B:11:0x0032, B:14:0x0039, B:16:0x003f, B:19:0x0046, B:21:0x004c, B:24:0x0053, B:26:0x0059, B:29:0x0060, B:49:0x0088, B:51:0x0096, B:52:0x0099, B:58:0x0090), top: B:8:0x0013 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0059 A[Catch: all -> 0x00dc, TryCatch #0 {, blocks: (B:9:0x0013, B:11:0x0032, B:14:0x0039, B:16:0x003f, B:19:0x0046, B:21:0x004c, B:24:0x0053, B:26:0x0059, B:29:0x0060, B:49:0x0088, B:51:0x0096, B:52:0x0099, B:58:0x0090), top: B:8:0x0013 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0090 A[Catch: all -> 0x00dc, TryCatch #0 {, blocks: (B:9:0x0013, B:11:0x0032, B:14:0x0039, B:16:0x003f, B:19:0x0046, B:21:0x004c, B:24:0x0053, B:26:0x0059, B:29:0x0060, B:49:0x0088, B:51:0x0096, B:52:0x0099, B:58:0x0090), top: B:8:0x0013 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long a(String str, String str2) {
        long j10;
        long j11;
        long j12;
        long j13;
        FlowCtrlInfoHolder flowCtrlInfoHolder = this.f9135b;
        long j14 = 0;
        if (flowCtrlInfoHolder == null || flowCtrlInfoHolder.flowCtrlMap == null || TextUtils.isEmpty(str)) {
            return 0L;
        }
        synchronized (this) {
            FlowControlInfo flowControlInfo = this.f9135b.get(SERVICE_ALL, null);
            FlowControlInfo flowControlInfo2 = this.f9135b.get(SERVICE_ALL_BRUSH, null);
            FlowControlInfo flowControlInfo3 = this.f9135b.get(str, null);
            FlowControlInfo flowControlInfo4 = this.f9135b.get(str, str2);
            if (flowControlInfo != null && !flowControlInfo.isExpired()) {
                j10 = flowControlInfo.delayTime;
                if (flowControlInfo2 != null && !flowControlInfo2.isExpired()) {
                    j11 = flowControlInfo2.delayTime;
                    if (flowControlInfo3 != null && !flowControlInfo3.isExpired()) {
                        j12 = flowControlInfo3.delayTime;
                        if (flowControlInfo4 != null && !flowControlInfo4.isExpired()) {
                            j14 = flowControlInfo4.delayTime;
                        }
                        j13 = -1;
                        if (j10 != -1 && j14 != -1 && j12 != -1) {
                            if (j11 != -1) {
                                j13 = -1000;
                            } else {
                                long j15 = j10 > j14 ? j10 : j14;
                                j13 = j15 > j12 ? j15 : j12;
                            }
                        }
                        if (flowControlInfo != null) {
                        }
                    }
                    j12 = 0;
                    if (flowControlInfo4 != null) {
                        j14 = flowControlInfo4.delayTime;
                    }
                    j13 = -1;
                    if (j10 != -1) {
                        if (j11 != -1) {
                        }
                    }
                    if (flowControlInfo != null) {
                    }
                }
                j11 = 0;
                if (flowControlInfo3 != null) {
                    j12 = flowControlInfo3.delayTime;
                    if (flowControlInfo4 != null) {
                    }
                    j13 = -1;
                    if (j10 != -1) {
                    }
                    if (flowControlInfo != null) {
                    }
                }
                j12 = 0;
                if (flowControlInfo4 != null) {
                }
                j13 = -1;
                if (j10 != -1) {
                }
                if (flowControlInfo != null) {
                }
            }
            j10 = 0;
            if (flowControlInfo2 != null) {
                j11 = flowControlInfo2.delayTime;
                if (flowControlInfo3 != null) {
                }
                j12 = 0;
                if (flowControlInfo4 != null) {
                }
                j13 = -1;
                if (j10 != -1) {
                }
                if (flowControlInfo != null) {
                }
            }
            j11 = 0;
            if (flowControlInfo3 != null) {
            }
            j12 = 0;
            if (flowControlInfo4 != null) {
            }
            j13 = -1;
            if (j10 != -1) {
            }
            if (flowControlInfo != null) {
            }
        }
        ALog.e("FlowControl", "getFlowCtrlDelay service " + str + " biz " + str2 + " result:" + j13 + " global:" + j10 + " serviceDelay:" + j12 + " bidDelay:" + j14, new Object[0]);
        return j13;
    }

    private void a() {
        FlowCtrlInfoHolder flowCtrlInfoHolder = this.f9135b;
        if (flowCtrlInfoHolder == null || flowCtrlInfoHolder.flowCtrlMap == null) {
            return;
        }
        synchronized (this) {
            Iterator<Map.Entry<String, FlowControlInfo>> it = this.f9135b.flowCtrlMap.entrySet().iterator();
            while (it.hasNext()) {
                if (it.next().getValue().isExpired()) {
                    it.remove();
                }
            }
        }
    }
}
