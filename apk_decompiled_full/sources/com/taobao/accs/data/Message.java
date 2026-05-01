package com.taobao.accs.data;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.google.common.primitives.SignedBytes;
import com.google.common.primitives.UnsignedBytes;
import com.hpplay.cybergarage.xml.XML;
import com.taobao.accs.ACCSManager;
import com.taobao.accs.base.TaoBaseService;
import com.taobao.accs.client.GlobalClientInfo;
import com.taobao.accs.common.Constants;
import com.taobao.accs.ut.monitor.NetPerformanceMonitor;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.UtilityImpl;
import com.taobao.accs.utl.o;
import com.taobao.accs.utl.p;
import com.taobao.accs.utl.r;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.zip.GZIPOutputStream;
import org.json.JSONException;

/* loaded from: classes3.dex */
public class Message implements Serializable {
    public static int CONTROL_MAX_RETRY_TIMES = 5;
    public static final int EXT_HEADER_VALUE_MAX_LEN = 1023;
    public static final int FLAG_ACK_TYPE = 32;
    public static final int FLAG_BIZ_RET = 64;
    public static final int FLAG_DATA_TYPE = 32768;
    public static final int FLAG_ERR = 4096;
    public static final int FLAG_REQ_BIT1 = 16384;
    public static final int FLAG_REQ_BIT2 = 8192;
    public static final int FLAG_RET = 2048;
    public static final String KEY_BINDAPP = "ctrl_bindapp";
    public static final String KEY_BINDSERVICE = "ctrl_bindservice";
    public static final String KEY_BINDUSER = "ctrl_binduser";
    public static final String KEY_UNBINDAPP = "ctrl_unbindapp";
    public static final String KEY_UNBINDSERVICE = "ctrl_unbindservice";
    public static final String KEY_UNBINDUSER = "ctrl_unbinduser";
    public static final int MAX_RETRY_TIMES = 3;

    /* renamed from: a, reason: collision with root package name */
    static long f9062a = 1;
    byte[] D;
    int E;
    long F;
    transient NetPerformanceMonitor G;
    Id I;
    public String cunstomDataId;

    /* renamed from: d, reason: collision with root package name */
    short f9065d;
    public String dataId;

    /* renamed from: e, reason: collision with root package name */
    short f9066e;

    /* renamed from: f, reason: collision with root package name */
    short f9067f;

    /* renamed from: g, reason: collision with root package name */
    byte f9068g;

    /* renamed from: h, reason: collision with root package name */
    byte f9069h;
    public URL host;

    /* renamed from: i, reason: collision with root package name */
    String f9070i;

    /* renamed from: j, reason: collision with root package name */
    String f9071j;

    /* renamed from: l, reason: collision with root package name */
    Map<Integer, String> f9073l;
    public long startSendTime;
    public boolean isAck = false;
    public boolean force = false;
    public boolean isCancel = false;

    /* renamed from: b, reason: collision with root package name */
    byte f9063b = 0;

    /* renamed from: c, reason: collision with root package name */
    byte f9064c = 0;

    /* renamed from: k, reason: collision with root package name */
    int f9072k = -1;

    /* renamed from: m, reason: collision with root package name */
    String f9074m = null;
    public Integer command = null;

    /* renamed from: n, reason: collision with root package name */
    Integer f9075n = 0;

    /* renamed from: o, reason: collision with root package name */
    String f9076o = null;
    public String appSign = null;

    /* renamed from: p, reason: collision with root package name */
    Integer f9077p = null;

    /* renamed from: q, reason: collision with root package name */
    String f9078q = null;

    /* renamed from: r, reason: collision with root package name */
    String f9079r = null;

    /* renamed from: s, reason: collision with root package name */
    String f9080s = null;

    /* renamed from: t, reason: collision with root package name */
    String f9081t = null;

    /* renamed from: u, reason: collision with root package name */
    String f9082u = null;

    /* renamed from: v, reason: collision with root package name */
    Integer f9083v = null;

    /* renamed from: w, reason: collision with root package name */
    String f9084w = null;

    /* renamed from: x, reason: collision with root package name */
    String f9085x = null;
    public String userinfo = null;
    public String serviceId = null;

    /* renamed from: y, reason: collision with root package name */
    String f9086y = null;

    /* renamed from: z, reason: collision with root package name */
    String f9087z = null;
    String A = null;
    String B = null;
    String C = null;
    public long delyTime = 0;
    public int retryTimes = 0;
    public int timeout = com.taobao.accs.net.a.ACCS_RECEIVE_TIMEOUT;
    public String bizId = null;
    String H = null;

    public static class Id implements Serializable {

        /* renamed from: a, reason: collision with root package name */
        private int f9088a;

        /* renamed from: b, reason: collision with root package name */
        private String f9089b;

        public Id(int i10, String str) {
            this.f9088a = i10;
            this.f9089b = str;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Id id = (Id) obj;
            return this.f9088a == id.getId() || this.f9089b.equals(id.getDataId());
        }

        public String getDataId() {
            return this.f9089b;
        }

        public int getId() {
            return this.f9088a;
        }

        public int hashCode() {
            return this.f9089b.hashCode();
        }
    }

    public static class MsgResType implements Serializable {
        public static final int INVALID = -1;
        public static final int NEED_ACK = 1;
        public static final int NO_ACK = 0;

        public static String name(int i10) {
            return i10 != 0 ? i10 != 1 ? "INVALID" : "NEED_ACK" : "NO_ACK";
        }

        public static int valueOf(int i10) {
            return i10 != 0 ? 1 : 0;
        }
    }

    public static class MsgType implements Serializable {
        public static final int CONTROL = 0;
        public static final int DATA = 1;
        public static final int HANDSHAKE = 3;
        public static final int INVALID = -1;
        public static final int PING = 2;

        public static String name(int i10) {
            return i10 != 0 ? i10 != 1 ? i10 != 2 ? i10 != 3 ? "INVALID" : "HANDSHAKE" : "PING" : "DATA" : "CONTROL";
        }

        public static int valueOf(int i10) {
            int i11 = 1;
            if (i10 != 1) {
                i11 = 2;
                if (i10 != 2) {
                    i11 = 3;
                    if (i10 != 3) {
                        return 0;
                    }
                }
            }
            return i11;
        }
    }

    public enum ReqType {
        DATA,
        ACK,
        REQ,
        RES;

        public static ReqType valueOf(int i10) {
            return i10 != 0 ? i10 != 1 ? i10 != 2 ? i10 != 3 ? DATA : RES : REQ : ACK : DATA;
        }
    }

    private Message() {
        synchronized (Message.class) {
            this.startSendTime = System.currentTimeMillis();
            String str = this.startSendTime + "." + f9062a;
            this.dataId = str;
            long j10 = f9062a;
            f9062a = 1 + j10;
            this.I = new Id((int) j10, str);
        }
    }

    public static Message BuildPing(boolean z10, int i10) {
        Message message = new Message();
        message.f9072k = 2;
        message.command = 201;
        message.force = z10;
        message.delyTime = i10;
        return message;
    }

    public static Message buildBackground(String str) {
        Message message = new Message();
        message.a(1, ReqType.DATA, 0);
        message.command = 100;
        message.f9070i = Constants.TARGET_BACK;
        a(str, message);
        return message;
    }

    @Deprecated
    public static Message buildBindApp(com.taobao.accs.net.a aVar, Context context, Intent intent) {
        return buildBindApp(aVar.b((String) null), aVar.f9169m, context, intent);
    }

    @Deprecated
    public static Message buildBindService(com.taobao.accs.net.a aVar, Context context, Intent intent) {
        return buildBindService(aVar.b((String) null), aVar.f9169m, intent);
    }

    @Deprecated
    public static Message buildBindUser(com.taobao.accs.net.a aVar, Context context, Intent intent) {
        return buildBindUser(aVar.b((String) null), aVar.f9169m, intent);
    }

    public static Message buildErrorReportMessage(String str, String str2, String str3, int i10) {
        Message message = new Message();
        try {
            message.host = new URL(str3);
        } catch (MalformedURLException e10) {
            e10.printStackTrace();
        }
        message.f9070i = Constants.TARGET_SERVICE_ST;
        message.a(1, ReqType.DATA, 0);
        message.command = 100;
        message.D = ("0|" + i10 + "|" + str + "|" + com.taobao.accs.utl.j.b(GlobalClientInfo.getContext()) + "|" + str2).getBytes();
        return message;
    }

    public static Message buildForeground(String str) {
        Message message = new Message();
        message.a(1, ReqType.DATA, 0);
        message.command = 100;
        message.f9070i = Constants.TARGET_FORE;
        a(str, message);
        return message;
    }

    public static Message buildHandshake(String str) {
        Message message = new Message();
        message.a(3, ReqType.DATA, 1);
        message.f9074m = str;
        message.f9070i = Constants.TARGET_CONTROL;
        message.command = 200;
        return message;
    }

    public static Message buildParameterError(String str, int i10) {
        Message message = new Message();
        message.a(1, ReqType.ACK, 0);
        message.command = Integer.valueOf(i10);
        message.f9074m = str;
        return message;
    }

    @Deprecated
    public static Message buildPushAck(com.taobao.accs.net.a aVar, String str, String str2, String str3, boolean z10, short s10, String str4, Map<Integer, String> map) {
        return buildPushAck(aVar.b((String) null), aVar.f9169m, str, str2, str3, z10, s10, str4, map);
    }

    @Deprecated
    public static Message buildRequest(com.taobao.accs.net.a aVar, Context context, String str, String str2, String str3, ACCSManager.AccsRequest accsRequest, boolean z10) {
        return buildRequest(context, aVar.b((String) null), aVar.f9169m, aVar.f9165i.getStoreId(), str, str2, accsRequest, z10);
    }

    @Deprecated
    public static Message buildSendData(com.taobao.accs.net.a aVar, Context context, String str, String str2, ACCSManager.AccsRequest accsRequest) {
        return buildSendData(aVar.b((String) null), aVar.f9169m, aVar.f9165i.getStoreId(), context, str, accsRequest, true);
    }

    @Deprecated
    public static Message buildUnbindApp(com.taobao.accs.net.a aVar, Context context, Intent intent) {
        return buildUnbindApp(aVar.b((String) null), intent);
    }

    @Deprecated
    public static Message buildUnbindService(com.taobao.accs.net.a aVar, Context context, Intent intent) {
        return buildUnbindService(aVar.b((String) null), aVar.f9169m, intent);
    }

    @Deprecated
    public static Message buildUnbindUser(com.taobao.accs.net.a aVar, Context context, Intent intent) {
        return buildUnbindUser(aVar.b((String) null), aVar.f9169m, intent);
    }

    private String c() {
        return "Msg_" + this.H;
    }

    public short a(Map<Integer, String> map) {
        short s10 = 0;
        if (map != null) {
            try {
                Iterator<Integer> it = map.keySet().iterator();
                while (it.hasNext()) {
                    String str = map.get(Integer.valueOf(it.next().intValue()));
                    if (!TextUtils.isEmpty(str)) {
                        s10 = (short) (s10 + ((short) (str.getBytes(XML.CHARSET_UTF8).length & EXT_HEADER_VALUE_MAX_LEN)) + 2);
                    }
                }
            } catch (Exception e10) {
                e10.toString();
            }
        }
        return s10;
    }

    public void b() {
        Integer num = this.command;
        if (num == null || num.intValue() == 100 || this.command.intValue() == 102) {
            return;
        }
        this.D = new p.a().a("command", this.command.intValue() == 100 ? null : this.command).a(Constants.KEY_APP_KEY, this.f9076o).a(Constants.KEY_OS_TYPE, this.f9077p).a("sign", this.appSign).a(Constants.KEY_SDK_VERSION, this.f9083v).a("appVersion", this.f9082u).a(Constants.KEY_TTID, this.f9084w).a(Constants.KEY_MODEL, this.f9086y).a(Constants.KEY_BRAND, this.f9087z).a("imei", this.A).a(Constants.KEY_IMSI, this.B).a(Constants.KYE_MAC_ADDRESS, this.f9085x).a("os", this.f9078q).a(Constants.KEY_EXTS, this.f9081t).a().toString().getBytes(XML.CHARSET_UTF8);
    }

    public byte[] build(Context context, int i10) {
        byte[] bytes;
        try {
            b();
        } catch (UnsupportedEncodingException e10) {
            ALog.e(c(), "build2", e10, new Object[0]);
        } catch (JSONException e11) {
            ALog.e(c(), "build1", e11, new Object[0]);
        }
        byte[] bArr = this.D;
        String str = bArr != null ? new String(bArr) : "";
        a();
        if (!this.isAck) {
            StringBuilder sb = new StringBuilder();
            sb.append(UtilityImpl.j(context));
            sb.append("|");
            sb.append(this.f9074m);
            sb.append("|");
            String str2 = this.serviceId;
            if (str2 == null) {
                str2 = "";
            }
            sb.append(str2);
            sb.append("|");
            String str3 = this.userinfo;
            if (str3 == null) {
                str3 = "";
            }
            sb.append(str3);
            this.f9071j = sb.toString();
        }
        try {
            bytes = (this.dataId + "").getBytes(XML.CHARSET_UTF8);
            this.f9069h = (byte) this.f9071j.getBytes(XML.CHARSET_UTF8).length;
            this.f9068g = (byte) this.f9070i.getBytes(XML.CHARSET_UTF8).length;
        } catch (Exception e12) {
            e12.printStackTrace();
            ALog.e(c(), "build3", e12, new Object[0]);
            bytes = (this.dataId + "").getBytes();
            this.f9069h = (byte) this.f9071j.getBytes().length;
            this.f9068g = (byte) this.f9070i.getBytes().length;
        }
        short a10 = a(this.f9073l);
        int length = this.f9068g + 3 + 1 + this.f9069h + 1 + bytes.length;
        byte[] bArr2 = this.D;
        short length2 = (short) (length + (bArr2 == null ? 0 : bArr2.length) + a10 + 2);
        this.f9066e = length2;
        this.f9065d = (short) (length2 + 2);
        r rVar = new r(this.f9065d + 2 + 4);
        ALog.Level level = ALog.Level.D;
        if (ALog.isPrintLog(level)) {
            ALog.d(c(), "Build Message", Constants.KEY_DATA_ID, new String(bytes));
        }
        try {
            rVar.a((byte) (this.f9063b | 32));
            if (ALog.isPrintLog(level)) {
                ALog.d(c(), "\tversion:2 compress:" + ((int) this.f9063b), new Object[0]);
            }
            if (i10 == 0) {
                rVar.a(UnsignedBytes.MAX_POWER_OF_TWO);
                if (ALog.isPrintLog(level)) {
                    ALog.d(c(), "\tflag: 0x80", new Object[0]);
                }
            } else {
                rVar.a(SignedBytes.MAX_POWER_OF_TWO);
                if (ALog.isPrintLog(level)) {
                    ALog.d(c(), "\tflag: 0x40", new Object[0]);
                }
            }
            rVar.a(this.f9065d);
            if (ALog.isPrintLog(level)) {
                ALog.d(c(), "\ttotalLength:" + ((int) this.f9065d), new Object[0]);
            }
            rVar.a(this.f9066e);
            if (ALog.isPrintLog(level)) {
                ALog.d(c(), "\tdataLength:" + ((int) this.f9066e), new Object[0]);
            }
            rVar.a(this.f9067f);
            if (ALog.isPrintLog(level)) {
                ALog.d(c(), "\tflags:" + Integer.toHexString(this.f9067f), new Object[0]);
            }
            rVar.a(this.f9068g);
            if (ALog.isPrintLog(level)) {
                ALog.d(c(), "\ttargetLength:" + ((int) this.f9068g), new Object[0]);
            }
            rVar.write(this.f9070i.getBytes(XML.CHARSET_UTF8));
            if (ALog.isPrintLog(level)) {
                ALog.d(c(), "\ttarget:" + this.f9070i, new Object[0]);
            }
            rVar.a(this.f9069h);
            if (ALog.isPrintLog(level)) {
                ALog.d(c(), "\tsourceLength:" + ((int) this.f9069h), new Object[0]);
            }
            rVar.write(this.f9071j.getBytes(XML.CHARSET_UTF8));
            if (ALog.isPrintLog(level)) {
                ALog.d(c(), "\tsource:" + this.f9071j, new Object[0]);
            }
            rVar.a((byte) bytes.length);
            if (ALog.isPrintLog(level)) {
                ALog.d(c(), "\tdataIdLength:" + bytes.length, new Object[0]);
            }
            rVar.write(bytes);
            if (ALog.isPrintLog(level)) {
                ALog.d(c(), "\tdataId:" + new String(bytes), new Object[0]);
            }
            rVar.a(a10);
            if (ALog.isPrintLog(level)) {
                ALog.d(c(), "\textHeader len:" + ((int) a10), new Object[0]);
            }
            Map<Integer, String> map = this.f9073l;
            if (map != null) {
                Iterator<Integer> it = map.keySet().iterator();
                while (it.hasNext()) {
                    int intValue = it.next().intValue();
                    String str4 = this.f9073l.get(Integer.valueOf(intValue));
                    if (!TextUtils.isEmpty(str4)) {
                        rVar.a((short) ((((short) intValue) << 10) | ((short) (str4.getBytes(XML.CHARSET_UTF8).length & EXT_HEADER_VALUE_MAX_LEN))));
                        rVar.write(str4.getBytes(XML.CHARSET_UTF8));
                        if (ALog.isPrintLog(ALog.Level.D)) {
                            ALog.d(c(), "\textHeader key:" + intValue + " value:" + str4, new Object[0]);
                        }
                    }
                }
            }
            byte[] bArr3 = this.D;
            if (bArr3 != null) {
                rVar.write(bArr3);
            }
            if (ALog.isPrintLog(ALog.Level.D)) {
                ALog.d(c(), "\toriData:" + str, new Object[0]);
            }
            rVar.flush();
        } catch (IOException e13) {
            ALog.e(c(), "build4", e13, new Object[0]);
        }
        byte[] byteArray = rVar.toByteArray();
        try {
            rVar.close();
        } catch (IOException e14) {
            ALog.e(c(), "build5", e14, new Object[0]);
        }
        return byteArray;
    }

    public String getDataId() {
        return this.dataId;
    }

    public long getDelyTime() {
        return this.delyTime;
    }

    public Id getMsgId() {
        return this.I;
    }

    public NetPerformanceMonitor getNetPermanceMonitor() {
        return this.G;
    }

    public int getNode() {
        return this.E;
    }

    public String getPackageName() {
        String str = this.f9074m;
        return str == null ? "" : str;
    }

    public int getRetryTimes() {
        return this.retryTimes;
    }

    public int getType() {
        return this.f9072k;
    }

    public boolean isControlFrame() {
        return Constants.TARGET_CONTROL.equals(this.f9070i);
    }

    public boolean isTimeOut() {
        boolean z10 = (System.currentTimeMillis() - this.startSendTime) + this.delyTime >= ((long) this.timeout);
        if (z10) {
            ALog.e(c(), "delay time:" + this.delyTime + " beforeSendTime:" + (System.currentTimeMillis() - this.startSendTime) + " timeout" + this.timeout, new Object[0]);
        }
        return z10;
    }

    public void setSendTime(long j10) {
        this.F = j10;
    }

    public static Message buildBindApp(String str, String str2, Context context, Intent intent) {
        Message message = null;
        try {
            message = buildBindApp(context, str2, intent.getStringExtra(Constants.KEY_APP_KEY), intent.getStringExtra("app_sercet"), intent.getStringExtra(Constants.KEY_PACKAGE_NAME), intent.getStringExtra(Constants.KEY_TTID), intent.getStringExtra("appVersion"));
            a(str, message);
            return message;
        } catch (Exception e10) {
            ALog.e("Msg", "buildBindApp", e10.getMessage());
            return message;
        }
    }

    public static Message buildBindService(String str, String str2, Intent intent) {
        Message message = null;
        try {
            message = buildBindService(intent.getStringExtra(Constants.KEY_PACKAGE_NAME), intent.getStringExtra(Constants.KEY_SERVICE_ID));
            message.H = str2;
            a(str, message);
            return message;
        } catch (Exception e10) {
            ALog.e("Msg", "buildBindService", e10, new Object[0]);
            e10.printStackTrace();
            return message;
        }
    }

    public static Message buildBindUser(String str, String str2, Intent intent) {
        Message message = null;
        try {
            message = buildBindUser(intent.getStringExtra(Constants.KEY_PACKAGE_NAME), intent.getStringExtra(Constants.KEY_USER_ID));
            if (message != null) {
                message.H = str2;
                a(str, message);
            }
        } catch (Exception e10) {
            ALog.e("Msg", "buildBindUser", e10, new Object[0]);
            e10.printStackTrace();
        }
        return message;
    }

    public static Message buildPushAck(String str, String str2, String str3, String str4, String str5, boolean z10, short s10, String str6, Map<Integer, String> map) {
        Message message = new Message();
        message.E = 1;
        message.a(s10, z10);
        message.f9071j = str3;
        message.f9070i = str4;
        message.dataId = str5;
        message.isAck = true;
        message.f9073l = map;
        try {
            try {
                if (TextUtils.isEmpty(str6)) {
                    message.host = new URL(str);
                } else {
                    message.host = new URL(str6);
                }
                message.H = str2;
                if (message.host == null) {
                    message.host = new URL(str);
                }
            } catch (Throwable th) {
                try {
                    ALog.e("Msg", "buildPushAck", th, new Object[0]);
                    if (message.host == null) {
                        message.host = new URL(str);
                    }
                } catch (Throwable th2) {
                    if (message.host == null) {
                        try {
                            message.host = new URL(str);
                        } catch (MalformedURLException e10) {
                            e10.printStackTrace();
                        }
                    }
                    throw th2;
                }
            }
        } catch (MalformedURLException e11) {
            e11.printStackTrace();
        }
        return message;
    }

    public static Message buildRequest(Context context, String str, String str2, String str3, String str4, String str5, ACCSManager.AccsRequest accsRequest, boolean z10) {
        if (TextUtils.isEmpty(str4)) {
            return null;
        }
        Message message = new Message();
        message.E = 1;
        message.a(1, ReqType.REQ, 1);
        message.command = 100;
        message.f9074m = str4;
        message.serviceId = accsRequest.serviceId;
        message.userinfo = accsRequest.userId;
        message.D = accsRequest.data;
        String str6 = TextUtils.isEmpty(accsRequest.targetServiceName) ? accsRequest.serviceId : accsRequest.targetServiceName;
        StringBuilder sb = new StringBuilder();
        sb.append(str5);
        sb.append(str6);
        sb.append("|");
        String str7 = accsRequest.target;
        if (str7 == null) {
            str7 = "";
        }
        sb.append(str7);
        message.f9070i = sb.toString();
        if (TextUtils.isEmpty(accsRequest.dataId)) {
            accsRequest.dataId = message.getMsgId().getDataId();
        }
        message.cunstomDataId = accsRequest.dataId;
        message.bizId = accsRequest.businessId;
        message.H = str2;
        int i10 = accsRequest.timeout;
        if (i10 > 0) {
            message.timeout = i10;
        }
        if (z10) {
            a(str, message, accsRequest);
        } else {
            message.host = accsRequest.host;
        }
        a(message, GlobalClientInfo.getInstance(context).getSid(str2), GlobalClientInfo.getInstance(context).getUserId(str2), str3, GlobalClientInfo.f9033c, accsRequest.businessId, accsRequest.tag);
        NetPerformanceMonitor netPerformanceMonitor = new NetPerformanceMonitor();
        message.G = netPerformanceMonitor;
        netPerformanceMonitor.setDataId(accsRequest.dataId);
        message.G.setServiceId(accsRequest.serviceId);
        message.G.setHost(message.host.toString());
        message.H = str2;
        return message;
    }

    @Deprecated
    public static Message buildSendData(com.taobao.accs.net.a aVar, Context context, String str, String str2, ACCSManager.AccsRequest accsRequest, boolean z10) {
        return buildSendData(aVar.b((String) null), aVar.f9169m, aVar.f9165i.getStoreId(), context, str, accsRequest, z10);
    }

    public static Message buildUnbindApp(String str, Intent intent) {
        ALog.e("Msg", "buildUnbindApp1" + UtilityImpl.a(new Exception()), new Object[0]);
        Message message = null;
        try {
            message = buildUnbindApp(str, intent.getStringExtra(Constants.KEY_PACKAGE_NAME));
            a(str, message);
            return message;
        } catch (Exception e10) {
            ALog.e("Msg", "buildUnbindApp1", e10.getMessage());
            return message;
        }
    }

    public static Message buildUnbindService(String str, String str2, Intent intent) {
        Message message = null;
        try {
            message = buildUnbindService(intent.getStringExtra(Constants.KEY_PACKAGE_NAME), intent.getStringExtra(Constants.KEY_SERVICE_ID));
            message.H = str2;
            a(str, message);
            return message;
        } catch (Exception e10) {
            ALog.e("Msg", "buildUnbindService", e10, new Object[0]);
            e10.printStackTrace();
            return message;
        }
    }

    public static Message buildUnbindUser(String str, String str2, Intent intent) {
        Message message = null;
        try {
            message = buildUnbindUser(intent.getStringExtra(Constants.KEY_PACKAGE_NAME));
            message.H = str2;
            a(str, message);
            return message;
        } catch (Exception e10) {
            ALog.e("Msg", "buildUnbindUser", e10, new Object[0]);
            e10.printStackTrace();
            return message;
        }
    }

    public static Message buildSendData(String str, String str2, String str3, Context context, String str4, ACCSManager.AccsRequest accsRequest) {
        return buildSendData(str, str2, str3, context, str4, accsRequest, true);
    }

    public static Message buildSendData(String str, String str2, String str3, Context context, String str4, ACCSManager.AccsRequest accsRequest, boolean z10) {
        if (TextUtils.isEmpty(str4)) {
            return null;
        }
        Message message = new Message();
        message.E = 1;
        message.a(1, ReqType.DATA, 1);
        message.command = 100;
        message.f9074m = str4;
        message.serviceId = accsRequest.serviceId;
        message.userinfo = accsRequest.userId;
        message.D = accsRequest.data;
        String str5 = TextUtils.isEmpty(accsRequest.targetServiceName) ? accsRequest.serviceId : accsRequest.targetServiceName;
        StringBuilder sb = new StringBuilder();
        sb.append(Constants.TARGET_SERVICE_PRE);
        sb.append(str5);
        sb.append("|");
        String str6 = accsRequest.target;
        if (str6 == null) {
            str6 = "";
        }
        sb.append(str6);
        message.f9070i = sb.toString();
        if (TextUtils.isEmpty(accsRequest.dataId)) {
            accsRequest.dataId = message.getMsgId().getDataId();
        }
        message.cunstomDataId = accsRequest.dataId;
        message.bizId = accsRequest.businessId;
        int i10 = accsRequest.timeout;
        if (i10 > 0) {
            message.timeout = i10;
        }
        if (z10) {
            a(str, message, accsRequest);
        } else {
            message.host = accsRequest.host;
        }
        a(message, GlobalClientInfo.getInstance(context).getSid(str2), GlobalClientInfo.getInstance(context).getUserId(str2), str3, GlobalClientInfo.f9033c, accsRequest.businessId, accsRequest.tag);
        NetPerformanceMonitor netPerformanceMonitor = new NetPerformanceMonitor();
        message.G = netPerformanceMonitor;
        netPerformanceMonitor.setMsgType(0);
        message.G.setDataId(accsRequest.dataId);
        message.G.setServiceId(accsRequest.serviceId);
        message.G.setHost(message.host.toString());
        message.H = str2;
        return message;
    }

    public void a() {
        GZIPOutputStream gZIPOutputStream;
        Throwable th;
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            try {
            } catch (Throwable th2) {
                gZIPOutputStream = null;
                th = th2;
                byteArrayOutputStream = null;
            }
            if (this.D == null) {
                return;
            }
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                try {
                    gZIPOutputStream.write(this.D);
                    gZIPOutputStream.finish();
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    if (byteArray != null && byteArray.length < this.D.length) {
                        this.D = byteArray;
                        this.f9063b = (byte) 1;
                    }
                    gZIPOutputStream.close();
                } catch (Throwable th3) {
                    th = th3;
                    try {
                        Log.e(c(), th.toString());
                        th.printStackTrace();
                        if (gZIPOutputStream != null) {
                            gZIPOutputStream.close();
                        }
                        if (byteArrayOutputStream == null) {
                            return;
                        }
                        byteArrayOutputStream.close();
                    } catch (Throwable th4) {
                        if (gZIPOutputStream != null) {
                            try {
                                gZIPOutputStream.close();
                            } catch (Exception unused) {
                                throw th4;
                            }
                        }
                        if (byteArrayOutputStream != null) {
                            byteArrayOutputStream.close();
                        }
                        throw th4;
                    }
                }
            } catch (Throwable th5) {
                gZIPOutputStream = null;
                th = th5;
            }
            byteArrayOutputStream.close();
        } catch (Exception unused2) {
        }
    }

    @Deprecated
    public static Message buildUnbindApp(com.taobao.accs.net.a aVar, Context context, String str, String str2, String str3, String str4) {
        return buildUnbindApp(aVar.b((String) null), str);
    }

    public static Message buildUnbindApp(String str, String str2) {
        Message message = null;
        try {
            ALog.d("Msg", "buildUnbindApp", new Object[0]);
            if (TextUtils.isEmpty(str2)) {
                return null;
            }
            Message message2 = new Message();
            try {
                message2.E = 1;
                message2.a(1, ReqType.DATA, 1);
                message2.f9074m = str2;
                message2.f9070i = Constants.TARGET_CONTROL;
                message2.command = 2;
                message2.f9074m = str2;
                message2.f9083v = Integer.valueOf(Constants.SDK_VERSION_CODE);
                message2.cunstomDataId = KEY_UNBINDAPP;
                a(str, message2);
                return message2;
            } catch (Exception e10) {
                e = e10;
                message = message2;
                ALog.e("Msg", "buildUnbindApp", e.getMessage());
                return message;
            }
        } catch (Exception e11) {
            e = e11;
        }
    }

    @Deprecated
    public static Message buildUnbindUser(Context context, String str, String str2, String str3, String str4, String str5) {
        return buildUnbindUser(str);
    }

    @Deprecated
    public static Message buildBindService(Context context, String str, String str2, String str3, String str4, String str5, String str6) {
        return buildBindService(str, str3);
    }

    @Deprecated
    public static Message buildBindUser(Context context, String str, String str2, String str3, String str4, String str5) {
        return buildBindUser(str, str4);
    }

    @Deprecated
    public static Message buildUnbindService(Context context, String str, String str2, String str3, String str4, String str5, String str6) {
        return buildUnbindService(str, str3);
    }

    public static Message buildUnbindUser(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Message message = new Message();
        message.E = 1;
        message.a(1, ReqType.DATA, 1);
        message.f9074m = str;
        message.f9070i = Constants.TARGET_CONTROL;
        message.command = 4;
        message.f9083v = Integer.valueOf(Constants.SDK_VERSION_CODE);
        message.cunstomDataId = KEY_UNBINDUSER;
        return message;
    }

    @Deprecated
    public static Message buildBindApp(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        return buildBindApp(context, str, str2, str3, str4, str5, str6);
    }

    public static Message buildBindService(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        Message message = new Message();
        message.E = 1;
        message.a(1, ReqType.DATA, 1);
        message.f9074m = str;
        message.serviceId = str2;
        message.f9070i = Constants.TARGET_CONTROL;
        message.command = 5;
        message.f9074m = str;
        message.serviceId = str2;
        message.f9083v = Integer.valueOf(Constants.SDK_VERSION_CODE);
        message.cunstomDataId = KEY_BINDSERVICE;
        return message;
    }

    public static Message buildBindUser(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        Message message = new Message();
        message.E = 1;
        message.a(1, ReqType.DATA, 1);
        message.f9074m = str;
        message.userinfo = str2;
        message.f9070i = Constants.TARGET_CONTROL;
        message.command = 3;
        message.f9074m = str;
        message.userinfo = str2;
        message.f9083v = Integer.valueOf(Constants.SDK_VERSION_CODE);
        message.cunstomDataId = KEY_BINDUSER;
        return message;
    }

    public static Message buildUnbindService(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        Message message = new Message();
        message.E = 1;
        message.a(1, ReqType.DATA, 1);
        message.f9074m = str;
        message.serviceId = str2;
        message.f9070i = Constants.TARGET_CONTROL;
        message.command = 6;
        message.f9074m = str;
        message.serviceId = str2;
        message.f9083v = Integer.valueOf(Constants.SDK_VERSION_CODE);
        message.cunstomDataId = KEY_UNBINDSERVICE;
        return message;
    }

    public static Message buildBindApp(Context context, String str, String str2, String str3, String str4, String str5, String str6) {
        if (TextUtils.isEmpty(str4)) {
            return null;
        }
        Message message = new Message();
        message.E = 1;
        message.a(1, ReqType.DATA, 1);
        message.f9077p = 1;
        message.f9078q = Build.VERSION.SDK_INT + "";
        message.f9074m = str4;
        message.f9070i = Constants.TARGET_CONTROL;
        message.command = 1;
        message.f9076o = str2;
        message.appSign = UtilityImpl.a(str2, str3, UtilityImpl.j(context));
        message.f9083v = Integer.valueOf(Constants.SDK_VERSION_CODE);
        message.f9082u = str6;
        message.f9074m = str4;
        message.f9084w = str5;
        message.f9086y = Build.MODEL;
        message.f9087z = Build.BRAND;
        message.cunstomDataId = KEY_BINDAPP;
        message.H = str;
        p.a aVar = new p.a();
        aVar.a("notifyEnable", UtilityImpl.o(context));
        aVar.a("romInfo", new o().a());
        message.f9081t = aVar.a().toString();
        UtilityImpl.a(context, Constants.SP_FILE_NAME, UtilityImpl.o(context));
        return message;
    }

    private static void a(String str, Message message, ACCSManager.AccsRequest accsRequest) {
        URL url = accsRequest.host;
        if (url == null) {
            try {
                message.host = new URL(str);
                return;
            } catch (MalformedURLException e10) {
                ALog.e("Msg", "setUnit", e10, new Object[0]);
                e10.printStackTrace();
                return;
            }
        }
        message.host = url;
    }

    private static void a(String str, Message message) {
        try {
            message.host = new URL(str);
        } catch (Exception e10) {
            ALog.e("Msg", "setControlHost", e10, new Object[0]);
        }
    }

    private static void a(Message message, String str, String str2, String str3, String str4, String str5, String str6) {
        if (TextUtils.isEmpty(str5) && TextUtils.isEmpty(str) && TextUtils.isEmpty(str2) && TextUtils.isEmpty(str6) && str4 == null) {
            return;
        }
        message.f9073l = new HashMap();
        if (str5 != null && UtilityImpl.a(str5) <= 1023) {
            message.f9073l.put(Integer.valueOf(TaoBaseService.ExtHeaderType.TYPE_BUSINESS.ordinal()), str5);
        }
        if (str != null && UtilityImpl.a(str) <= 1023) {
            message.f9073l.put(Integer.valueOf(TaoBaseService.ExtHeaderType.TYPE_SID.ordinal()), str);
        }
        if (str2 != null && UtilityImpl.a(str2) <= 1023) {
            message.f9073l.put(Integer.valueOf(TaoBaseService.ExtHeaderType.TYPE_USERID.ordinal()), str2);
        }
        if (str6 != null && UtilityImpl.a(str6) <= 1023) {
            message.f9073l.put(Integer.valueOf(TaoBaseService.ExtHeaderType.TYPE_TAG.ordinal()), str6);
        }
        if (str4 != null && UtilityImpl.a(str4) <= 1023) {
            message.f9073l.put(Integer.valueOf(TaoBaseService.ExtHeaderType.TYPE_COOKIE.ordinal()), str4);
        }
        if (str3 == null || UtilityImpl.a(str3) > 1023) {
            return;
        }
        message.f9073l.put(19, str3);
    }

    private void a(int i10, ReqType reqType, int i11) {
        this.f9072k = i10;
        if (i10 != 2) {
            this.f9067f = (short) (((((i10 & 1) << 4) | (reqType.ordinal() << 2)) | i11) << 11);
        }
    }

    private void a(short s10, boolean z10) {
        this.f9072k = 1;
        short s11 = (short) (((short) (((short) (((short) (s10 & (-16385))) | 8192)) & (-2049))) & (-65));
        this.f9067f = s11;
        if (z10) {
            this.f9067f = (short) (s11 | 32);
        }
    }
}
