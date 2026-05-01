package com.taobao.accs.internal;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Process;
import android.text.TextUtils;
import com.hpplay.cybergarage.http.HTTP;
import com.raizlabs.android.dbflow.sql.language.Operator;
import com.taobao.accs.ACCSManager;
import com.taobao.accs.client.GlobalClientInfo;
import com.taobao.accs.common.Constants;
import com.taobao.accs.common.ThreadPoolExecutorFactory;
import com.taobao.accs.data.Message;
import com.taobao.accs.net.v;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.BaseMonitor;
import com.taobao.accs.utl.UTMini;
import com.taobao.accs.utl.UtilityImpl;
import com.taobao.accs.utl.k;
import com.taobao.accs.utl.q;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.android.agoo.service.IMessageService;

/* loaded from: classes3.dex */
public class ServiceImpl extends d {

    /* renamed from: b, reason: collision with root package name */
    private Service f9142b;

    /* renamed from: c, reason: collision with root package name */
    private Context f9143c;

    /* renamed from: d, reason: collision with root package name */
    private long f9144d;

    /* renamed from: e, reason: collision with root package name */
    private String f9145e;

    /* renamed from: f, reason: collision with root package name */
    private final IMessageService.Stub f9146f;

    /* renamed from: com.taobao.accs.internal.ServiceImpl$1, reason: invalid class name */
    class AnonymousClass1 extends IMessageService.Stub {
        public AnonymousClass1() {
        }

        @Override // org.android.agoo.service.IMessageService
        public boolean ping() {
            return true;
        }

        @Override // org.android.agoo.service.IMessageService
        public void probe() {
            ALog.d("ServiceImpl", "ReceiverImpl probeTaoBao begin......messageServiceBinder [probe]", new Object[0]);
            ThreadPoolExecutorFactory.execute(new e(this));
        }
    }

    public ServiceImpl(Service service) {
        super(service);
        this.f9142b = null;
        this.f9145e = "unknown";
        this.f9146f = new AnonymousClass1();
        this.f9142b = service;
        this.f9143c = service.getApplicationContext();
    }

    private void b(Intent intent) {
        Message message;
        Message.ReqType reqType;
        URL url;
        Message buildRequest;
        int intExtra = intent.getIntExtra("command", -1);
        ALog.i("ServiceImpl", "handleCommand", "command", Integer.valueOf(intExtra));
        String stringExtra = intent.getStringExtra(Constants.KEY_PACKAGE_NAME);
        String stringExtra2 = intent.getStringExtra(Constants.KEY_SERVICE_ID);
        String stringExtra3 = intent.getStringExtra(Constants.KEY_USER_ID);
        String stringExtra4 = intent.getStringExtra(Constants.KEY_APP_KEY);
        String stringExtra5 = intent.getStringExtra(Constants.KEY_CONFIG_TAG);
        String stringExtra6 = intent.getStringExtra(Constants.KEY_TTID);
        intent.getStringExtra("sid");
        intent.getStringExtra(Constants.KEY_ANTI_BRUSH_COOKIE);
        if (intExtra == 201) {
            a(Message.BuildPing(true, 0), true);
            d();
        }
        if (intExtra <= 0 || TextUtils.isEmpty(stringExtra)) {
            return;
        }
        com.taobao.accs.net.a b10 = d.b(this.f9143c, stringExtra5, true);
        if (b10 == null) {
            ALog.e("ServiceImpl", "no connection", Constants.KEY_CONFIG_TAG, stringExtra5, "command", Integer.valueOf(intExtra));
            return;
        }
        b10.a();
        if (intExtra != 1) {
            message = null;
            if (intExtra == 2) {
                ALog.e("ServiceImpl", "onHostStartCommand COMMAND_UNBIND_APP", new Object[0]);
                if (b10.j().d(stringExtra)) {
                    Message buildUnbindApp = Message.buildUnbindApp(b10.b((String) null), stringExtra);
                    ALog.i("ServiceImpl", stringExtra + " isAppUnbinded", new Object[0]);
                    b10.b(buildUnbindApp, 200);
                    return;
                }
            } else if (intExtra == 5) {
                message = Message.buildBindService(b10.b((String) null), stringExtra2);
            } else if (intExtra == 6) {
                message = Message.buildUnbindService(stringExtra, stringExtra2);
            } else if (intExtra == 3) {
                message = Message.buildBindUser(stringExtra, stringExtra3);
                if (b10.j().b(stringExtra, stringExtra3) && !intent.getBooleanExtra(Constants.KEY_FOUCE_BIND, false)) {
                    ALog.i("ServiceImpl", stringExtra + Operator.Operation.DIVISION + stringExtra3 + " isUserBinded", new Object[0]);
                    if (message != null) {
                        b10.b(message, 200);
                        return;
                    }
                    return;
                }
            } else if (intExtra == 4) {
                message = Message.buildUnbindUser(stringExtra);
            } else if (intExtra == 100) {
                byte[] byteArrayExtra = intent.getByteArrayExtra("data");
                String stringExtra7 = intent.getStringExtra(Constants.KEY_DATA_ID);
                String stringExtra8 = intent.getStringExtra("target");
                String stringExtra9 = intent.getStringExtra(Constants.KEY_BUSINESSID);
                String stringExtra10 = intent.getStringExtra(Constants.KEY_EXT_TAG);
                try {
                    reqType = (Message.ReqType) intent.getSerializableExtra(Constants.KEY_SEND_TYPE);
                } catch (Exception unused) {
                    reqType = null;
                }
                if (byteArrayExtra != null) {
                    try {
                        url = new URL("https://" + ((v) b10).p());
                    } catch (MalformedURLException e10) {
                        e10.printStackTrace();
                        url = null;
                    }
                    ACCSManager.AccsRequest accsRequest = new ACCSManager.AccsRequest(stringExtra3, stringExtra2, byteArrayExtra, stringExtra7, stringExtra8, url, stringExtra9);
                    accsRequest.setTag(stringExtra10);
                    if (reqType == null) {
                        buildRequest = Message.buildSendData(b10.b((String) null), stringExtra5, b10.f9165i.getStoreId(), this.f9143c, stringExtra, accsRequest, false);
                    } else if (reqType == Message.ReqType.REQ) {
                        buildRequest = Message.buildRequest(this.f9143c, b10.b((String) null), stringExtra5, b10.f9165i.getStoreId(), stringExtra, Constants.TARGET_SERVICE_PRE, accsRequest, false);
                    }
                    message = buildRequest;
                }
            } else if (intExtra == 106) {
                intent.setAction(Constants.ACTION_RECEIVE);
                intent.putExtra("command", -1);
                com.taobao.accs.data.g.a().b(this.f9143c, intent);
                return;
            }
        } else {
            if (!stringExtra.equals(this.f9143c.getPackageName())) {
                ALog.e("ServiceImpl", "handleCommand bindapp pkg error", new Object[0]);
                return;
            }
            message = Message.buildBindApp(this.f9143c, stringExtra5, stringExtra4, intent.getStringExtra("app_sercet"), stringExtra, stringExtra6, intent.getStringExtra("appVersion"));
            b10.f9157a = stringExtra6;
            if (b10.j().c(stringExtra) && !intent.getBooleanExtra(Constants.KEY_FOUCE_BIND, false)) {
                ALog.i("ServiceImpl", stringExtra + " isAppBinded", new Object[0]);
                b10.b(message, 200);
                return;
            }
        }
        if (message == null) {
            ALog.e("ServiceImpl", "message is null", new Object[0]);
            b10.b(Message.buildParameterError(stringExtra, intExtra), -2);
        } else {
            ALog.d("ServiceImpl", "try send message", new Object[0]);
            if (message.getNetPermanceMonitor() != null) {
                message.getNetPermanceMonitor().onSend();
            }
            b10.b(message, true);
        }
    }

    private void c() {
        ConcurrentHashMap<String, com.taobao.accs.net.a> concurrentHashMap = d.f9151a;
        if (concurrentHashMap == null || concurrentHashMap.size() == 0) {
            return;
        }
        Iterator<Map.Entry<String, com.taobao.accs.net.a>> it = d.f9151a.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().b();
        }
    }

    private void d() {
        ConcurrentHashMap<String, com.taobao.accs.net.a> concurrentHashMap = d.f9151a;
        if (concurrentHashMap == null || concurrentHashMap.size() == 0) {
            return;
        }
        Iterator<Map.Entry<String, com.taobao.accs.net.a>> it = d.f9151a.entrySet().iterator();
        while (it.hasNext()) {
            com.taobao.accs.ut.a.c c10 = it.next().getValue().c();
            if (c10 != null) {
                c10.f9271h = this.f9144d;
                c10.a();
            }
        }
    }

    private void e() {
        ConcurrentHashMap<String, com.taobao.accs.net.a> concurrentHashMap = d.f9151a;
        if (concurrentHashMap == null || concurrentHashMap.size() == 0) {
            return;
        }
        Iterator<Map.Entry<String, com.taobao.accs.net.a>> it = d.f9151a.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().e();
        }
    }

    @Override // com.taobao.accs.internal.d, com.taobao.accs.base.IBaseService
    public IBinder onBind(Intent intent) {
        String action = intent.getAction();
        ALog.d("ServiceImpl", "accs probeTaoBao begin......action=" + action, new Object[0]);
        if (TextUtils.isEmpty(action) || !TextUtils.equals(action, "org.agoo.android.intent.action.PING_V4")) {
            return null;
        }
        UTMini.getInstance().commitEvent(66001, "probeChannelService", UtilityImpl.j(this.f9143c), intent.getStringExtra("source"));
        return this.f9146f;
    }

    @Override // com.taobao.accs.internal.d, com.taobao.accs.base.IBaseService
    public void onCreate() {
        super.onCreate();
        a();
    }

    @Override // com.taobao.accs.internal.d, com.taobao.accs.base.IBaseService
    public void onDestroy() {
        super.onDestroy();
        ALog.e("ServiceImpl", "Service onDestroy", new Object[0]);
        UtilityImpl.a(this.f9143c, Constants.SP_KEY_SERVICE_END, System.currentTimeMillis());
        this.f9142b = null;
        this.f9143c = null;
        e();
        Process.killProcess(Process.myPid());
    }

    @Override // com.taobao.accs.internal.d, com.taobao.accs.base.IBaseService
    public boolean onUnbind(Intent intent) {
        return false;
    }

    @Override // com.taobao.accs.internal.d
    public int a(Intent intent) {
        String action;
        Bundle extras;
        if (ALog.isPrintLog(ALog.Level.I)) {
            ALog.i("ServiceImpl", "onHostStartCommand", "intent", intent);
        }
        try {
            if (ALog.isPrintLog(ALog.Level.D) && intent != null && (extras = intent.getExtras()) != null) {
                for (String str : extras.keySet()) {
                    ALog.d("ServiceImpl", "onHostStartCommand", "key", str, " value", extras.get(str));
                }
            }
            int c10 = q.c();
            if (c10 > 3) {
                ALog.e("ServiceImpl", "onHostStartCommand load SO fail 4 times, don't auto restart", new Object[0]);
                k.a("accs", BaseMonitor.COUNT_POINT_SOFAIL, UtilityImpl.a(c10), 0.0d);
            }
            action = intent == null ? null : intent.getAction();
        } finally {
            try {
                return 2;
            } finally {
            }
        }
        if (!TextUtils.isEmpty(action)) {
            a(intent, action);
            return 2;
        }
        b();
        a(false, false);
        return 2;
    }

    private void a() {
        ALog.d("ServiceImpl", "init start", new Object[0]);
        GlobalClientInfo.getInstance(this.f9143c);
        com.taobao.accs.client.a.f9050f.incrementAndGet();
        this.f9144d = System.currentTimeMillis();
        this.f9145e = UtilityImpl.h(this.f9143c);
        if (ALog.isPrintLog(ALog.Level.I)) {
            ALog.i("ServiceImpl", "init", Constants.KEY_SDK_VERSION, Integer.valueOf(Constants.SDK_VERSION_CODE), "procStart", Integer.valueOf(com.taobao.accs.client.a.f9050f.intValue()));
        }
        UTMini.getInstance().commitEvent(66001, "START", UtilityImpl.h(), "PROXY");
        long k10 = UtilityImpl.k(this.f9143c);
        ALog.d("ServiceImpl", "getServiceAliveTime", "aliveTime", Long.valueOf(k10));
        if (k10 > 20000) {
            k.a("accs", BaseMonitor.COUNT_SERVICE_ALIVE, "", k10 / 1000);
        }
        UtilityImpl.a(this.f9143c, Constants.SP_KEY_SERVICE_START, System.currentTimeMillis());
        UTMini.getInstance().commitEvent(66001, HTTP.NOTIFY, UtilityImpl.o(this.f9143c));
    }

    private void a(Intent intent, String str) {
        ALog.d("ServiceImpl", "handleAction", "action", str);
        try {
            if (!TextUtils.isEmpty(str) && "org.agoo.android.intent.action.PING_V4".equals(str)) {
                String stringExtra = intent.getStringExtra("source");
                ALog.i("ServiceImpl", "org.agoo.android.intent.action.PING_V4,start channel by brothers", "serviceStart", Integer.valueOf(com.taobao.accs.client.a.f9050f.intValue()), "source" + stringExtra);
                k.a("accs", "startChannel", stringExtra, 0.0d);
                if (com.taobao.accs.client.a.c()) {
                    k.a("accs", "createChannel", stringExtra, 0.0d);
                }
            }
            b();
            if (TextUtils.equals(str, "android.intent.action.PACKAGE_REMOVED")) {
                return;
            }
            if (TextUtils.equals(str, "android.net.conn.CONNECTIVITY_CHANGE")) {
                String h10 = UtilityImpl.h(this.f9143c);
                boolean i10 = UtilityImpl.i(this.f9143c);
                ALog.i("ServiceImpl", "network change:" + this.f9145e + " to " + h10, new Object[0]);
                if (i10) {
                    this.f9145e = h10;
                    c();
                    a(true, false);
                    UTMini.getInstance().commitEvent(66001, "CONNECTIVITY_CHANGE", h10, UtilityImpl.h(), "0");
                }
                if (h10.equals("unknown")) {
                    c();
                    this.f9145e = h10;
                    return;
                }
                return;
            }
            if (TextUtils.equals(str, "android.intent.action.BOOT_COMPLETED")) {
                a(true, false);
                return;
            }
            if (TextUtils.equals(str, "android.intent.action.USER_PRESENT")) {
                ALog.d("ServiceImpl", "action android.intent.action.USER_PRESENT", new Object[0]);
                a(true, false);
            } else if (str.equals(Constants.ACTION_COMMAND)) {
                b(intent);
            } else if (str.equals(Constants.ACTION_START_FROM_AGOO)) {
                ALog.i("ServiceImpl", "ACTION_START_FROM_AGOO", new Object[0]);
            }
        } catch (Throwable th) {
            ALog.e("ServiceImpl", "handleAction", th, new Object[0]);
        }
    }

    private synchronized void b() {
        ConcurrentHashMap<String, com.taobao.accs.net.a> concurrentHashMap = d.f9151a;
        if (concurrentHashMap != null && concurrentHashMap.size() != 0) {
            for (Map.Entry<String, com.taobao.accs.net.a> entry : d.f9151a.entrySet()) {
                com.taobao.accs.net.a value = entry.getValue();
                if (value == null) {
                    ALog.e("ServiceImpl", "tryConnect connection null", "appkey", value.i());
                    return;
                }
                ALog.i("ServiceImpl", "tryConnect", "appkey", value.i(), Constants.KEY_CONFIG_TAG, entry.getKey());
                if (value.l() && TextUtils.isEmpty(value.f9165i.getAppSecret())) {
                    ALog.e("ServiceImpl", "tryConnect secret is null", new Object[0]);
                } else {
                    value.a();
                }
            }
            return;
        }
        ALog.w("ServiceImpl", "tryConnect no connections", new Object[0]);
    }

    private void a(Message message, boolean z10) {
        ConcurrentHashMap<String, com.taobao.accs.net.a> concurrentHashMap = d.f9151a;
        if (concurrentHashMap == null || concurrentHashMap.size() == 0) {
            return;
        }
        Iterator<Map.Entry<String, com.taobao.accs.net.a>> it = d.f9151a.entrySet().iterator();
        while (it.hasNext()) {
            com.taobao.accs.net.a value = it.next().getValue();
            if (value instanceof com.taobao.accs.net.k) {
                value.a(true, false);
            } else {
                value.b(message, z10);
            }
        }
    }

    private void a(boolean z10, boolean z11) {
        ConcurrentHashMap<String, com.taobao.accs.net.a> concurrentHashMap = d.f9151a;
        if (concurrentHashMap == null || concurrentHashMap.size() == 0) {
            return;
        }
        Iterator<Map.Entry<String, com.taobao.accs.net.a>> it = d.f9151a.entrySet().iterator();
        while (it.hasNext()) {
            com.taobao.accs.net.a value = it.next().getValue();
            value.a(z10, z11);
            ALog.i("ServiceImpl", "ping connection", "appkey", value.i());
        }
    }
}
