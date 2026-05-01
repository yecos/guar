package com.taobao.accs.data;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import anet.channel.GlobalAppRuntimeInfo;
import anet.channel.appmonitor.AppMonitor;
import com.taobao.accs.ErrorCode;
import com.taobao.accs.antibrush.AntiBrush;
import com.taobao.accs.base.TaoBaseService;
import com.taobao.accs.common.Constants;
import com.taobao.accs.common.ThreadPoolExecutorFactory;
import com.taobao.accs.data.Message;
import com.taobao.accs.flowcontrol.FlowControl;
import com.taobao.accs.ut.monitor.NetPerformanceMonitor;
import com.taobao.accs.ut.monitor.TrafficsMonitor;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.BaseMonitor;
import com.taobao.accs.utl.UTMini;
import com.taobao.accs.utl.UtilityImpl;
import com.taobao.accs.utl.p;
import com.taobao.accs.utl.s;
import com.umeng.message.common.inter.ITagManager;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ScheduledFuture;
import java.util.zip.GZIPInputStream;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class d {

    /* renamed from: b, reason: collision with root package name */
    public int f9104b;

    /* renamed from: c, reason: collision with root package name */
    protected TrafficsMonitor f9105c;

    /* renamed from: d, reason: collision with root package name */
    public FlowControl f9106d;

    /* renamed from: e, reason: collision with root package name */
    public AntiBrush f9107e;

    /* renamed from: i, reason: collision with root package name */
    private Context f9111i;

    /* renamed from: j, reason: collision with root package name */
    private com.taobao.accs.ut.a.d f9112j;

    /* renamed from: k, reason: collision with root package name */
    private Message f9113k;

    /* renamed from: l, reason: collision with root package name */
    private com.taobao.accs.net.a f9114l;

    /* renamed from: m, reason: collision with root package name */
    private String f9115m;

    /* renamed from: g, reason: collision with root package name */
    private ConcurrentMap<Message.Id, Message> f9109g = new ConcurrentHashMap();

    /* renamed from: a, reason: collision with root package name */
    public ConcurrentMap<String, ScheduledFuture<?>> f9103a = new ConcurrentHashMap();

    /* renamed from: h, reason: collision with root package name */
    private boolean f9110h = false;

    /* renamed from: f, reason: collision with root package name */
    public String f9108f = "";

    /* renamed from: n, reason: collision with root package name */
    private LinkedHashMap<String, String> f9116n = new LinkedHashMap<String, String>() { // from class: com.taobao.accs.data.MessageHandler$1
        @Override // java.util.LinkedHashMap
        public boolean removeEldestEntry(Map.Entry<String, String> entry) {
            return size() > 50;
        }
    };

    /* renamed from: o, reason: collision with root package name */
    private Map<String, a> f9117o = new HashMap();

    /* renamed from: p, reason: collision with root package name */
    private Runnable f9118p = new f(this);

    public d(Context context, com.taobao.accs.net.a aVar) {
        String str;
        this.f9115m = "MsgRecv_";
        this.f9111i = context;
        this.f9114l = aVar;
        this.f9105c = new TrafficsMonitor(context);
        this.f9106d = new FlowControl(this.f9111i);
        this.f9107e = new AntiBrush(this.f9111i);
        if (aVar == null) {
            str = this.f9115m;
        } else {
            str = this.f9115m + aVar.f9169m;
        }
        this.f9115m = str;
        i();
        h();
    }

    private boolean b(int i10) {
        return i10 == -1 || i10 == -9 || i10 == -10 || i10 == -11;
    }

    private void i() {
        try {
            File file = new File(this.f9111i.getDir("accs", 0), Constants.SHARED_MESSAGE_ID_FILE + this.f9114l.i());
            if (!file.exists()) {
                ALog.d(this.f9115m, "message file not exist", new Object[0]);
                return;
            }
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    bufferedReader.close();
                    return;
                }
                this.f9116n.put(readLine, readLine);
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    private void j() {
        try {
            FileWriter fileWriter = new FileWriter(new File(this.f9111i.getDir("accs", 0), Constants.SHARED_MESSAGE_ID_FILE + this.f9114l.i()));
            fileWriter.write("");
            Iterator<String> it = this.f9116n.keySet().iterator();
            while (it.hasNext()) {
                fileWriter.append((CharSequence) it.next()).append((CharSequence) "\r\n");
            }
            fileWriter.close();
        } catch (IOException e10) {
            e10.printStackTrace();
        }
    }

    public void a(byte[] bArr) {
        a(bArr, (String) null);
    }

    public boolean c() {
        return this.f9110h;
    }

    public int d() {
        return this.f9109g.size();
    }

    public Collection<Message> e() {
        return this.f9109g.values();
    }

    public Set<Message.Id> f() {
        return this.f9109g.keySet();
    }

    public com.taobao.accs.ut.a.d g() {
        return this.f9112j;
    }

    public void h() {
        try {
            ThreadPoolExecutorFactory.getScheduledExecutor().execute(this.f9118p);
        } catch (Throwable th) {
            ALog.e(this.f9115m, "restoreTraffics", th, new Object[0]);
        }
    }

    private boolean c(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return this.f9116n.containsKey(str);
    }

    private void d(String str) {
        if (TextUtils.isEmpty(str) || this.f9116n.containsKey(str)) {
            return;
        }
        this.f9116n.put(str, str);
        j();
    }

    public void a(byte[] bArr, String str) {
        if (ALog.isPrintLog(ALog.Level.I)) {
            ALog.i(this.f9115m, "onMessage", Constants.KEY_HOST, str);
        }
        s sVar = new s(bArr);
        try {
            int a10 = sVar.a();
            int i10 = (a10 & 240) >> 4;
            ALog.Level level = ALog.Level.D;
            if (ALog.isPrintLog(level)) {
                ALog.d(this.f9115m, "version:" + i10, new Object[0]);
            }
            int i11 = a10 & 15;
            if (ALog.isPrintLog(level)) {
                ALog.d(this.f9115m, "compress:" + i11, new Object[0]);
            }
            sVar.a();
            int b10 = sVar.b();
            if (ALog.isPrintLog(level)) {
                ALog.d(this.f9115m, "totalLen:" + b10, new Object[0]);
            }
            int i12 = 0;
            while (i12 < b10) {
                int b11 = sVar.b();
                int i13 = i12 + 2;
                if (b11 <= 0) {
                    throw new IOException("data format error");
                }
                byte[] bArr2 = new byte[b11];
                sVar.read(bArr2);
                if (ALog.isPrintLog(ALog.Level.D)) {
                    ALog.d(this.f9115m, "buf len:" + b11, new Object[0]);
                }
                i12 = i13 + b11;
                a(i11, bArr2, str, i10);
            }
        } finally {
            try {
            } finally {
            }
        }
    }

    public void b() {
        ALog.d(this.f9115m, "onRcvPing", new Object[0]);
        synchronized (d.class) {
            this.f9110h = false;
        }
    }

    private Intent c(Message message) {
        Intent intent = new Intent(Constants.ACTION_RECEIVE);
        intent.setPackage(message.f9074m);
        intent.putExtra("command", message.command);
        intent.putExtra(Constants.KEY_SERVICE_ID, message.serviceId);
        intent.putExtra(Constants.KEY_USER_ID, message.userinfo);
        Integer num = message.command;
        if (num != null && num.intValue() == 100) {
            intent.putExtra(Constants.KEY_DATA_ID, message.cunstomDataId);
        }
        NetPerformanceMonitor netPerformanceMonitor = message.G;
        if (netPerformanceMonitor != null) {
            intent.putExtra(Constants.KEY_MONIROT, netPerformanceMonitor);
        }
        return intent;
    }

    public void b(Message message) {
        if (this.f9109g.keySet().size() > 0) {
            Iterator<Message.Id> it = this.f9109g.keySet().iterator();
            while (it.hasNext()) {
                Message message2 = this.f9109g.get(it.next());
                if (message2 != null && message2.command != null && message2.getPackageName().equals(message.getPackageName())) {
                    switch (message.command.intValue()) {
                        case 1:
                        case 2:
                            if (message2.command.intValue() == 1 || message2.command.intValue() == 2) {
                                message2.isCancel = true;
                                break;
                            }
                            break;
                        case 3:
                        case 4:
                            if (message2.command.intValue() == 3 || message2.command.intValue() == 4) {
                                message2.isCancel = true;
                                break;
                            }
                            break;
                        case 5:
                        case 6:
                            if (message2.command.intValue() == 5 || message2.command.intValue() == 6) {
                                message2.isCancel = true;
                                break;
                            }
                            break;
                    }
                }
                if (message2 != null && message2.isCancel) {
                    ALog.e(this.f9115m, "cancelControlMessage", "command", message2.command);
                }
            }
        }
    }

    public Message b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.f9109g.remove(new Message.Id(0, str));
    }

    private void b(Message message, int i10) {
        if (message == null) {
            return;
        }
        String j10 = UtilityImpl.j(this.f9111i);
        String str = System.currentTimeMillis() + "";
        boolean z10 = i10 == 200;
        int intValue = message.command.intValue();
        if (intValue == 1) {
            com.taobao.accs.ut.a.a aVar = new com.taobao.accs.ut.a.a();
            aVar.f9251a = j10;
            aVar.f9252b = str;
            aVar.f9253c = z10;
            aVar.a(i10);
            aVar.a();
            return;
        }
        if (intValue != 3) {
            return;
        }
        com.taobao.accs.ut.a.b bVar = new com.taobao.accs.ut.a.b();
        bVar.f9257a = j10;
        bVar.f9258b = str;
        bVar.f9259c = z10;
        bVar.f9261e = message.userinfo;
        bVar.a(i10);
        bVar.a();
    }

    /* JADX WARN: Can't wrap try/catch for region: R(22:107|(1:109)(1:188)|110|(6:(2:112|(2:114|(8:116|117|(5:123|124|125|126|(1:128))|137|124|125|126|(0))(1:138)))(1:187)|173|174|175|176|(0)(0))|(2:140|(2:142|143)(2:144|(3:146|(1:148)|149)))(1:186)|150|(1:152)|153|154|155|156|(1:158)(2:183|(1:185))|159|(1:161)|162|(1:164)(1:182)|165|(1:167)(1:181)|168|(1:170)(1:180)|171|172) */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x0669, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x066a, code lost:
    
        r45 = r51;
        r1 = r13;
        r2 = r18;
        r6 = r19;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:116:0x05f1 A[Catch: Exception -> 0x0669, TRY_LEAVE, TryCatch #3 {Exception -> 0x0669, blocks: (B:116:0x05f1, B:120:0x05fb, B:123:0x0602, B:124:0x0621, B:137:0x0613, B:155:0x046f, B:158:0x0479, B:159:0x04b8, B:161:0x04d0, B:162:0x04d6, B:164:0x04da, B:165:0x04e5, B:167:0x0535, B:168:0x0543, B:171:0x05a3, B:176:0x05e6, B:180:0x05a2, B:183:0x0495, B:185:0x049d), top: B:154:0x046f }] */
    /* JADX WARN: Removed duplicated region for block: B:128:0x065b A[Catch: Exception -> 0x069f, TryCatch #1 {Exception -> 0x069f, blocks: (B:126:0x064b, B:128:0x065b, B:189:0x0672), top: B:105:0x03d1 }] */
    /* JADX WARN: Removed duplicated region for block: B:138:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v10, types: [com.taobao.accs.utl.ALog$Level] */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v24 */
    /* JADX WARN: Type inference failed for: r1v35 */
    /* JADX WARN: Type inference failed for: r1v55 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v71 */
    /* JADX WARN: Type inference failed for: r1v72 */
    /* JADX WARN: Type inference failed for: r21v0, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v37 */
    /* JADX WARN: Type inference failed for: r2v42 */
    /* JADX WARN: Type inference failed for: r2v43 */
    /* JADX WARN: Type inference failed for: r2v44 */
    /* JADX WARN: Type inference failed for: r2v45 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8, types: [byte[]] */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r3v82, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r47v0, types: [com.taobao.accs.data.d] */
    /* JADX WARN: Type inference failed for: r5v37, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r5v40, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r9v13 */
    /* JADX WARN: Type inference failed for: r9v14 */
    /* JADX WARN: Type inference failed for: r9v7 */
    /* JADX WARN: Type inference failed for: r9v8, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r9v9, types: [java.util.Map] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void a(int r48, byte[] r49, java.lang.String r50, int r51) {
        /*
            Method dump skipped, instructions count: 1839
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.accs.data.d.a(int, byte[], java.lang.String, int):void");
    }

    private byte[] a(InputStream inputStream) {
        if (inputStream == null) {
            return null;
        }
        GZIPInputStream gZIPInputStream = new GZIPInputStream(inputStream);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            try {
                byte[] bArr = new byte[8192];
                while (true) {
                    int read = gZIPInputStream.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                try {
                    gZIPInputStream.close();
                    byteArrayOutputStream.close();
                } catch (Exception unused) {
                }
                return byteArray;
            } catch (Exception e10) {
                ALog.e(this.f9115m, "uncompress data error " + e10.toString(), new Object[0]);
                com.taobao.accs.utl.k.a("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, "", "1", this.f9104b + " uncompress data error " + e10.toString());
                try {
                    gZIPInputStream.close();
                    byteArrayOutputStream.close();
                } catch (Exception unused2) {
                }
                return null;
            }
        } catch (Throwable th) {
            try {
                gZIPInputStream.close();
                byteArrayOutputStream.close();
            } catch (Exception unused3) {
            }
            throw th;
        }
    }

    private void a(Message message, byte[] bArr, byte[] bArr2, String str) {
        JSONArray jSONArray;
        int i10 = -8;
        try {
            try {
                JSONObject jSONObject = new JSONObject(new String(bArr));
                if (ALog.isPrintLog(ALog.Level.D)) {
                    ALog.d(this.f9115m, "handleControlMessage parse", "json", jSONObject.toString());
                }
                i10 = message.command.intValue() == 100 ? 200 : jSONObject.getInt(Constants.KEY_HTTP_CODE);
                if (i10 == 200) {
                    int intValue = message.command.intValue();
                    if (intValue == 1) {
                        UtilityImpl.c(Constants.SP_FILE_NAME, this.f9111i);
                        try {
                            this.f9114l.j().a(this.f9111i.getPackageName());
                            JSONObject jSONObject2 = jSONObject.getJSONObject("data");
                            this.f9108f = p.a(jSONObject2, Constants.KEY_DEVICE_TOKEN, null);
                            if (jSONObject2 != null && (jSONArray = jSONObject2.getJSONArray(Constants.KEY_PACKAGE_NAMES)) != null) {
                                for (int i11 = 0; i11 < jSONArray.length(); i11++) {
                                    String string = jSONArray.getString(i11);
                                    if (UtilityImpl.a(this.f9111i, string)) {
                                        this.f9114l.j().a(message.f9074m);
                                    } else {
                                        ALog.d(this.f9115m, "unbind app", "pkg", string);
                                        com.taobao.accs.net.a aVar = this.f9114l;
                                        aVar.b(Message.buildUnbindApp(aVar.b((String) null), string), true);
                                    }
                                }
                            }
                        } catch (Throwable th) {
                            ALog.i(this.f9115m, "no token/invalid app", th);
                        }
                    } else if (intValue == 2) {
                        this.f9114l.j().b(message.f9074m);
                    } else if (intValue == 3) {
                        this.f9114l.j().a(message.f9074m, message.userinfo);
                    } else if (intValue != 4) {
                        if (intValue == 100 && (this.f9114l instanceof com.taobao.accs.net.k) && "4|sal|accs-iot".equals(message.f9070i)) {
                            ((com.taobao.accs.net.k) this.f9114l).a(jSONObject);
                        }
                    } else {
                        this.f9114l.j().e(message.f9074m);
                    }
                } else if (message.command.intValue() == 3 && i10 == 300) {
                    this.f9114l.j().b(message.f9074m);
                }
            } catch (Throwable th2) {
                th = th2;
                ALog.e(this.f9115m, "handleControlMessage", th, new Object[0]);
                com.taobao.accs.utl.k.a("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, "handleControlMessage", "", this.f9104b + th.toString());
                a(message, i10, null, bArr, null);
                a(new TrafficsMonitor.a(message.serviceId, GlobalAppRuntimeInfo.isAppBackground(), str, bArr2.length));
            }
        } catch (Throwable th3) {
            th = th3;
        }
        a(message, i10, null, bArr, null);
        a(new TrafficsMonitor.a(message.serviceId, GlobalAppRuntimeInfo.isAppBackground(), str, bArr2.length));
    }

    private Map<Integer, String> a(s sVar) {
        HashMap hashMap = null;
        if (sVar == null) {
            return null;
        }
        try {
            int b10 = sVar.b();
            if (ALog.isPrintLog(ALog.Level.D)) {
                ALog.d(this.f9115m, "extHeaderLen:" + b10, new Object[0]);
            }
            int i10 = 0;
            while (i10 < b10) {
                int b11 = sVar.b();
                int i11 = (64512 & b11) >> 10;
                int i12 = b11 & Message.EXT_HEADER_VALUE_MAX_LEN;
                String a10 = sVar.a(i12);
                i10 = i10 + 2 + i12;
                if (hashMap == null) {
                    hashMap = new HashMap();
                }
                hashMap.put(Integer.valueOf(i11), a10);
                if (ALog.isPrintLog(ALog.Level.D)) {
                    ALog.d(this.f9115m, "", "extHeaderType", Integer.valueOf(i11), "value", a10);
                }
            }
        } catch (Exception e10) {
            ALog.e(this.f9115m, "parseExtHeader", e10, new Object[0]);
        }
        return hashMap;
    }

    public void a(Message message, int i10) {
        a(message, i10, null, null, null);
    }

    public void a(Message message, int i10, Map<Integer, String> map) {
        a(message, i10, null, null, map);
    }

    public void a(Message message, int i10, Message.ReqType reqType, byte[] bArr, Map<Integer, String> map) {
        if (message.command != null && message.getType() >= 0 && message.getType() != 2) {
            String str = message.cunstomDataId;
            if (str != null) {
                this.f9103a.remove(str);
            }
            Message.ReqType reqType2 = null;
            if (this.f9107e.checkAntiBrush(message.host, map)) {
                i10 = ErrorCode.SERVIER_ANTI_BRUSH;
                reqType = null;
                bArr = null;
                map = null;
            }
            int a10 = this.f9106d.a(map, message.serviceId);
            if (a10 != 0) {
                i10 = a10 == 2 ? ErrorCode.SERVIER_HIGH_LIMIT : a10 == 3 ? ErrorCode.SERVIER_HIGH_LIMIT_BRUSH : ErrorCode.SERVIER_LOW_LIMIT;
                bArr = null;
                map = null;
            } else {
                reqType2 = reqType;
            }
            if (ALog.isPrintLog(ALog.Level.D)) {
                ALog.d(this.f9115m, "onResult", "command", message.command, "erorcode", Integer.valueOf(i10));
            }
            if (message.command.intValue() == 102) {
                return;
            }
            if (!message.isCancel) {
                if (b(i10) && message.command.intValue() != 100 && message.retryTimes <= Message.CONTROL_MAX_RETRY_TIMES) {
                    message.startSendTime = System.currentTimeMillis();
                    int i11 = message.retryTimes + 1;
                    message.retryTimes = i11;
                    ALog.d(this.f9115m, "onResult", "retryTimes", Integer.valueOf(i11));
                    this.f9114l.b(message, true);
                    a(message, i10, true);
                } else {
                    a(message, i10, false);
                    Intent c10 = c(message);
                    c10.putExtra("errorCode", i10);
                    Message.ReqType valueOf = Message.ReqType.valueOf((message.f9067f >> 13) & 3);
                    if (reqType2 == Message.ReqType.RES || valueOf == Message.ReqType.REQ) {
                        c10.putExtra(Constants.KEY_SEND_TYPE, Constants.SEND_TYPE_RES);
                    }
                    if (i10 == 200) {
                        c10.putExtra("data", bArr);
                    }
                    c10.putExtra(Constants.KEY_APP_KEY, this.f9114l.f9158b);
                    c10.putExtra(Constants.KEY_CONFIG_TAG, this.f9114l.f9169m);
                    a(map, c10);
                    g.a().b(this.f9111i, c10);
                    if (!TextUtils.isEmpty(message.serviceId)) {
                        UTMini.getInstance().commitEvent(66001, "MsgToBuss0", "commandId=" + message.command, "serviceId=" + message.serviceId + " errorCode=" + i10 + " dataId=" + message.dataId, Integer.valueOf(Constants.SDK_VERSION_CODE));
                        StringBuilder sb = new StringBuilder();
                        sb.append("1commandId=");
                        sb.append(message.command);
                        sb.append("serviceId=");
                        sb.append(message.serviceId);
                        com.taobao.accs.utl.k.a("accs", BaseMonitor.COUNT_POINT_TO_BUSS, sb.toString(), 0.0d);
                    }
                }
            } else {
                ALog.e(this.f9115m, "onResult message is cancel", "command", message.command);
                a(message, i10, true);
            }
            b(message, i10);
            return;
        }
        ALog.d(this.f9115m, "onError, skip ping/ack", new Object[0]);
    }

    private void a(Message message, int i10, boolean z10) {
        boolean z11;
        try {
            NetPerformanceMonitor netPermanceMonitor = message.getNetPermanceMonitor();
            if (netPermanceMonitor == null) {
                return;
            }
            netPermanceMonitor.onToBizDate();
            URL url = message.host;
            String url2 = url == null ? null : url.toString();
            if (i10 == 200) {
                if (message.retryTimes > 0) {
                    com.taobao.accs.utl.k.a("accs", BaseMonitor.COUNT_POINT_RESEND, "succ", 0.0d);
                    com.taobao.accs.utl.k.a("accs", BaseMonitor.COUNT_POINT_RESEND, "succ_" + message.retryTimes, 0.0d);
                } else {
                    com.taobao.accs.utl.k.a("accs", BaseMonitor.ALARM_POINT_REQUEST, url2);
                }
                z11 = true;
            } else {
                if (message.retryTimes > 0) {
                    com.taobao.accs.utl.k.a("accs", BaseMonitor.COUNT_POINT_RESEND, "fail＿" + i10, 0.0d);
                    com.taobao.accs.utl.k.a("accs", BaseMonitor.COUNT_POINT_RESEND, ITagManager.FAIL, 0.0d);
                } else if (i10 != -13) {
                    com.taobao.accs.utl.k.a("accs", BaseMonitor.ALARM_POINT_REQUEST, url2, UtilityImpl.a(i10), this.f9104b + message.serviceId + message.timeout);
                }
                netPermanceMonitor.setFailReason(i10);
                z11 = false;
            }
            netPermanceMonitor.setRet(z11);
            if (z10) {
                if (message.isCancel) {
                    netPermanceMonitor.setRet(false);
                    netPermanceMonitor.setFailReason("msg cancel");
                }
                AppMonitor.getInstance().commitStat(message.getNetPermanceMonitor());
            }
        } catch (Throwable th) {
            ALog.e(this.f9115m, "monitorPerf", th, new Object[0]);
        }
    }

    public void a() {
        ALog.d(this.f9115m, "onSendPing", new Object[0]);
        synchronized (d.class) {
            this.f9110h = true;
        }
    }

    public void a(Message message) {
        String str;
        Message message2 = this.f9113k;
        if (message2 != null && (str = message.cunstomDataId) != null && message.serviceId != null && message2.cunstomDataId.equals(str) && this.f9113k.serviceId.equals(message.serviceId)) {
            UTMini.getInstance().commitEvent(66001, "SEND_REPEAT", message.serviceId, message.cunstomDataId, Long.valueOf(Thread.currentThread().getId()));
        }
        if (message.getType() == -1 || message.getType() == 2 || message.isAck) {
            return;
        }
        this.f9109g.put(message.getMsgId(), message);
    }

    public void a(int i10) {
        this.f9110h = false;
        Message.Id[] idArr = (Message.Id[]) this.f9109g.keySet().toArray(new Message.Id[0]);
        if (idArr.length > 0) {
            ALog.d(this.f9115m, "onNetworkFail", new Object[0]);
            for (Message.Id id : idArr) {
                Message remove = this.f9109g.remove(id);
                if (remove != null) {
                    a(remove, i10);
                }
            }
        }
    }

    public Message a(String str) {
        return this.f9109g.get(new Message.Id(0, str));
    }

    private byte[] a(String str, Map<Integer, String> map, byte[] bArr) {
        if (bArr != null) {
            try {
                if (bArr.length != 0) {
                    int parseInt = Integer.parseInt(map.get(17));
                    int parseInt2 = Integer.parseInt(map.get(16));
                    if (parseInt2 <= 1) {
                        throw new RuntimeException("burstNums <= 1");
                    }
                    if (parseInt >= 0 && parseInt < parseInt2) {
                        String str2 = map.get(18);
                        long j10 = 0;
                        try {
                            String str3 = map.get(15);
                            if (!TextUtils.isEmpty(str3)) {
                                j10 = Long.parseLong(str3);
                            }
                        } catch (Throwable th) {
                            ALog.w(this.f9115m, "putBurstMessage", th, new Object[0]);
                        }
                        a aVar = this.f9117o.get(str);
                        if (aVar == null) {
                            if (ALog.isPrintLog(ALog.Level.I)) {
                                ALog.i(this.f9115m, "putBurstMessage", Constants.KEY_DATA_ID, str, "burstLength", Integer.valueOf(parseInt2));
                            }
                            aVar = new a(str, parseInt2, str2);
                            aVar.a(j10);
                            this.f9117o.put(str, aVar);
                        }
                        return aVar.a(parseInt, parseInt2, bArr);
                    }
                    throw new RuntimeException(String.format("burstNums:%s burstIndex:%s", Integer.valueOf(parseInt2), Integer.valueOf(parseInt)));
                }
            } catch (Throwable th2) {
                ALog.w(this.f9115m, "putBurstMessage", th2, new Object[0]);
                return null;
            }
        }
        throw new RuntimeException("burstLength == 0");
    }

    private void a(Map<Integer, String> map, Intent intent) {
        if (map == null || intent == null) {
            return;
        }
        intent.putExtra(TaoBaseService.ExtraInfo.EXT_HEADER, (HashMap) map);
    }

    private void a(Intent intent, String str, String str2, short s10) {
        if (intent != null) {
            if (!TextUtils.isEmpty(str)) {
                intent.putExtra("source", str);
            }
            if (!TextUtils.isEmpty(str2)) {
                intent.putExtra("target", str2);
            }
            intent.putExtra(Constants.KEY_FLAGS, s10);
        }
    }

    private void a(String str, String str2) {
        com.taobao.accs.ut.a.e eVar = new com.taobao.accs.ut.a.e();
        eVar.f9286a = UtilityImpl.j(this.f9111i);
        eVar.f9288c = str;
        eVar.f9289d = "" + System.currentTimeMillis();
        eVar.f9291f = "";
        eVar.f9290e = str2;
        eVar.f9287b = "";
        eVar.a();
    }

    public void a(TrafficsMonitor.a aVar) {
        try {
            ThreadPoolExecutorFactory.getScheduledExecutor().execute(new e(this, aVar));
        } catch (Throwable th) {
            ALog.e(this.f9115m, "addTrafficsInfo", th, new Object[0]);
        }
    }
}
