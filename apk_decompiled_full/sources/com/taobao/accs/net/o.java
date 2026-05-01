package com.taobao.accs.net;

import anet.channel.GlobalAppRuntimeInfo;
import anet.channel.Session;
import anet.channel.SessionCenter;
import anet.channel.entity.ConnType;
import com.hpplay.sdk.source.common.global.Constant;
import com.taobao.accs.common.Constants;
import com.taobao.accs.data.Message;
import com.taobao.accs.ut.monitor.TrafficsMonitor;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.BaseMonitor;
import java.util.Objects;

/* loaded from: classes3.dex */
class o implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Message f9212a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ k f9213b;

    public o(k kVar, Message message) {
        this.f9213b = kVar;
        this.f9212a = message;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x024a  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01b2 A[Catch: all -> 0x0308, TryCatch #0 {all -> 0x0308, blocks: (B:8:0x002b, B:11:0x0035, B:15:0x0063, B:17:0x0069, B:48:0x0074, B:50:0x008d, B:53:0x00b9, B:56:0x00d9, B:59:0x00e4, B:61:0x00ec, B:64:0x011a, B:65:0x0119, B:66:0x0179, B:68:0x018b, B:70:0x0197, B:73:0x01a3, B:75:0x01b2, B:76:0x01c4, B:78:0x01ca, B:79:0x01d7, B:81:0x01e4, B:82:0x01ed, B:83:0x01bc, B:84:0x0133, B:87:0x0161, B:88:0x0160, B:92:0x00a6, B:93:0x022f, B:94:0x003f), top: B:7:0x002b, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01ca A[Catch: all -> 0x0308, TryCatch #0 {all -> 0x0308, blocks: (B:8:0x002b, B:11:0x0035, B:15:0x0063, B:17:0x0069, B:48:0x0074, B:50:0x008d, B:53:0x00b9, B:56:0x00d9, B:59:0x00e4, B:61:0x00ec, B:64:0x011a, B:65:0x0119, B:66:0x0179, B:68:0x018b, B:70:0x0197, B:73:0x01a3, B:75:0x01b2, B:76:0x01c4, B:78:0x01ca, B:79:0x01d7, B:81:0x01e4, B:82:0x01ed, B:83:0x01bc, B:84:0x0133, B:87:0x0161, B:88:0x0160, B:92:0x00a6, B:93:0x022f, B:94:0x003f), top: B:7:0x002b, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01e4 A[Catch: all -> 0x0308, TryCatch #0 {all -> 0x0308, blocks: (B:8:0x002b, B:11:0x0035, B:15:0x0063, B:17:0x0069, B:48:0x0074, B:50:0x008d, B:53:0x00b9, B:56:0x00d9, B:59:0x00e4, B:61:0x00ec, B:64:0x011a, B:65:0x0119, B:66:0x0179, B:68:0x018b, B:70:0x0197, B:73:0x01a3, B:75:0x01b2, B:76:0x01c4, B:78:0x01ca, B:79:0x01d7, B:81:0x01e4, B:82:0x01ed, B:83:0x01bc, B:84:0x0133, B:87:0x0161, B:88:0x0160, B:92:0x00a6, B:93:0x022f, B:94:0x003f), top: B:7:0x002b, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01bc A[Catch: all -> 0x0308, TryCatch #0 {all -> 0x0308, blocks: (B:8:0x002b, B:11:0x0035, B:15:0x0063, B:17:0x0069, B:48:0x0074, B:50:0x008d, B:53:0x00b9, B:56:0x00d9, B:59:0x00e4, B:61:0x00ec, B:64:0x011a, B:65:0x0119, B:66:0x0179, B:68:0x018b, B:70:0x0197, B:73:0x01a3, B:75:0x01b2, B:76:0x01c4, B:78:0x01ca, B:79:0x01d7, B:81:0x01e4, B:82:0x01ed, B:83:0x01bc, B:84:0x0133, B:87:0x0161, B:88:0x0160, B:92:0x00a6, B:93:0x022f, B:94:0x003f), top: B:7:0x002b, inners: #1 }] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        int i10;
        boolean z10;
        String obj;
        Message message = this.f9212a;
        if (message != null) {
            if (message.getNetPermanceMonitor() != null) {
                this.f9212a.getNetPermanceMonitor().onTakeFromQueue();
            }
            int type = this.f9212a.getType();
            try {
                if (ALog.isPrintLog(ALog.Level.D) || "accs-impaas".equals(this.f9212a.serviceId)) {
                    ALog.e(this.f9213b.d(), "sendMessage start", Constants.KEY_DATA_ID, this.f9212a.getDataId(), "type", Message.MsgType.name(type));
                }
                String str = null;
                Session session = null;
                if (type == 1) {
                    Message message2 = this.f9212a;
                    if (message2.host != null) {
                        SessionCenter sessionCenter = SessionCenter.getInstance(this.f9213b.f9165i.getAppKey());
                        this.f9213b.a(sessionCenter, this.f9212a.host.getHost(), false);
                        try {
                            session = sessionCenter.getThrowsException(this.f9212a.host.toString(), ConnType.TypeLevel.SPDY, com.taobao.accs.utl.t.d());
                            obj = null;
                        } catch (Exception e10) {
                            ALog.e(this.f9213b.d(), "get session null", e10, new Object[0]);
                            obj = e10.toString();
                        }
                        if (session != null) {
                            Message message3 = this.f9212a;
                            k kVar = this.f9213b;
                            byte[] build = message3.build(kVar.f9160d, kVar.f9159c);
                            if (!"accs".equals(this.f9212a.serviceId) && !"accs-impaas".equals(this.f9212a.serviceId)) {
                                if (ALog.isPrintLog(ALog.Level.I)) {
                                    String d10 = this.f9213b.d();
                                    Object[] objArr = new Object[10];
                                    objArr[0] = Constants.KEY_DATA_ID;
                                    objArr[1] = this.f9212a.getDataId();
                                    objArr[2] = "command";
                                    Message message4 = this.f9212a;
                                    objArr[3] = message4.command;
                                    objArr[4] = Constants.KEY_HOST;
                                    objArr[5] = message4.host;
                                    objArr[6] = "len";
                                    objArr[7] = Integer.valueOf(build == null ? 0 : build.length);
                                    objArr[8] = "utdid";
                                    objArr[9] = this.f9213b.f9166j;
                                    ALog.d(d10, "sendMessage", objArr);
                                }
                                this.f9212a.setSendTime(System.currentTimeMillis());
                                Objects.requireNonNull(build);
                                if (build.length > 49152 || this.f9212a.command.intValue() == 102) {
                                    this.f9213b.f9161e.a(this.f9212a);
                                    Message message5 = this.f9212a;
                                    int id = !message5.isAck ? -message5.getMsgId().getId() : message5.getMsgId().getId();
                                    if (this.f9212a.isAck) {
                                        this.f9213b.f9168l.put(Integer.valueOf(id), this.f9212a);
                                    }
                                    session.sendCustomFrame(id, build, 200);
                                    if (this.f9212a.getNetPermanceMonitor() != null) {
                                        this.f9212a.getNetPermanceMonitor().onSendData();
                                    }
                                    this.f9213b.a(this.f9212a.getDataId(), this.f9213b.f9165i.isQuickReconnect(), this.f9212a.timeout);
                                    this.f9213b.f9161e.a(new TrafficsMonitor.a(this.f9212a.serviceId, GlobalAppRuntimeInfo.isAppBackground(), this.f9212a.host.toString(), build.length));
                                } else {
                                    this.f9213b.f9161e.a(this.f9212a, -4);
                                }
                                z10 = true;
                            }
                            String d11 = this.f9213b.d();
                            Object[] objArr2 = new Object[10];
                            objArr2[0] = Constants.KEY_DATA_ID;
                            objArr2[1] = this.f9212a.getDataId();
                            objArr2[2] = "command";
                            Message message6 = this.f9212a;
                            objArr2[3] = message6.command;
                            objArr2[4] = Constants.KEY_HOST;
                            objArr2[5] = message6.host;
                            objArr2[6] = "len";
                            objArr2[7] = Integer.valueOf(build == null ? 0 : build.length);
                            objArr2[8] = "utdid";
                            objArr2[9] = this.f9213b.f9166j;
                            ALog.e(d11, "sendMessage", objArr2);
                            this.f9212a.setSendTime(System.currentTimeMillis());
                            Objects.requireNonNull(build);
                            if (build.length > 49152) {
                            }
                            this.f9213b.f9161e.a(this.f9212a);
                            Message message52 = this.f9212a;
                            if (!message52.isAck) {
                            }
                            if (this.f9212a.isAck) {
                            }
                            session.sendCustomFrame(id, build, 200);
                            if (this.f9212a.getNetPermanceMonitor() != null) {
                            }
                            this.f9213b.a(this.f9212a.getDataId(), this.f9213b.f9165i.isQuickReconnect(), this.f9212a.timeout);
                            this.f9213b.f9161e.a(new TrafficsMonitor.a(this.f9212a.serviceId, GlobalAppRuntimeInfo.isAppBackground(), this.f9212a.host.toString(), build.length));
                            z10 = true;
                        } else {
                            z10 = false;
                        }
                        str = obj;
                        i10 = 1;
                        if (!z10) {
                            if (type == i10) {
                                if (this.f9212a.isTimeOut() || !this.f9213b.a(this.f9212a, 2000)) {
                                    this.f9213b.f9161e.a(this.f9212a, -11);
                                    String str2 = this.f9212a.serviceId;
                                    if (str == null) {
                                        str = "conn time out";
                                    }
                                    com.taobao.accs.utl.k.a("accs", BaseMonitor.COUNT_SESSION_ERROR, str2, str, String.valueOf(-11));
                                }
                                Message message7 = this.f9212a;
                                if (message7.retryTimes == 1 && message7.getNetPermanceMonitor() != null) {
                                    com.taobao.accs.utl.k.a("accs", BaseMonitor.COUNT_POINT_RESEND, "total_accs", 0.0d);
                                }
                            } else {
                                this.f9213b.f9161e.a(this.f9212a, -11);
                                String str3 = this.f9212a.serviceId;
                                if (str == null) {
                                    str = "conn time out";
                                }
                                com.taobao.accs.utl.k.a("accs", BaseMonitor.COUNT_SESSION_ERROR, str3, str, String.valueOf(-11));
                            }
                        }
                        if (!"accs".equals(this.f9212a.serviceId) || "accs-impaas".equals(this.f9212a.serviceId)) {
                            ALog.e(this.f9213b.d(), "sendMessage end", Constants.KEY_DATA_ID, this.f9212a.getDataId(), Constant.KEY_STATUS, Boolean.valueOf(z10));
                        } else {
                            ALog.e(this.f9213b.d(), "sendMessage end", Constants.KEY_DATA_ID, this.f9212a.getDataId(), Constant.KEY_STATUS, Boolean.valueOf(z10));
                            return;
                        }
                    }
                    this.f9213b.f9161e.a(message2, -5);
                    i10 = 1;
                } else {
                    i10 = 1;
                    ALog.e(this.f9213b.d(), "sendMessage skip", "type", Message.MsgType.name(type));
                }
                z10 = true;
                if (!z10) {
                }
                if ("accs".equals(this.f9212a.serviceId)) {
                }
                ALog.e(this.f9213b.d(), "sendMessage end", Constants.KEY_DATA_ID, this.f9212a.getDataId(), Constant.KEY_STATUS, Boolean.valueOf(z10));
            } catch (Throwable th) {
                try {
                    com.taobao.accs.utl.k.a("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, this.f9212a.serviceId, "", this.f9213b.f9159c + th.toString());
                    ALog.e(this.f9213b.d(), "sendMessage", th, new Object[0]);
                    if ("accs".equals(this.f9212a.serviceId) || "accs-impaas".equals(this.f9212a.serviceId)) {
                        ALog.e(this.f9213b.d(), "sendMessage end", Constants.KEY_DATA_ID, this.f9212a.getDataId(), Constant.KEY_STATUS, Boolean.TRUE);
                    } else {
                        ALog.e(this.f9213b.d(), "sendMessage end", Constants.KEY_DATA_ID, this.f9212a.getDataId(), Constant.KEY_STATUS, Boolean.TRUE);
                    }
                } catch (Throwable th2) {
                    if ("accs".equals(this.f9212a.serviceId) || "accs-impaas".equals(this.f9212a.serviceId)) {
                        ALog.e(this.f9213b.d(), "sendMessage end", Constants.KEY_DATA_ID, this.f9212a.getDataId(), Constant.KEY_STATUS, Boolean.TRUE);
                    } else {
                        ALog.e(this.f9213b.d(), "sendMessage end", Constants.KEY_DATA_ID, this.f9212a.getDataId(), Constant.KEY_STATUS, Boolean.TRUE);
                    }
                    throw th2;
                }
            }
        }
    }
}
