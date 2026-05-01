package com.taobao.accs.internal;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.text.TextUtils;
import anet.channel.SessionCenter;
import com.raizlabs.android.dbflow.sql.language.Operator;
import com.taobao.accs.ACCSClient;
import com.taobao.accs.ACCSManager;
import com.taobao.accs.AccsClientConfig;
import com.taobao.accs.ErrorCode;
import com.taobao.accs.IAppReceiver;
import com.taobao.accs.ILoginInfo;
import com.taobao.accs.base.AccsAbstractDataListener;
import com.taobao.accs.base.AccsConnectStateListener;
import com.taobao.accs.base.TaoBaseService;
import com.taobao.accs.client.GlobalClientInfo;
import com.taobao.accs.common.Constants;
import com.taobao.accs.common.ThreadPoolExecutorFactory;
import com.taobao.accs.data.Message;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.BaseMonitor;
import com.taobao.accs.utl.UtilityImpl;
import com.taobao.accs.utl.j;
import com.taobao.accs.utl.k;
import com.taobao.accs.utl.l;
import com.taobao.accs.utl.v;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.android.agoo.common.Config;

/* loaded from: classes3.dex */
public class ACCSManagerImpl implements com.taobao.accs.b {

    /* renamed from: c, reason: collision with root package name */
    private static String f9136c = "ACCSMgrImpl_";

    /* renamed from: b, reason: collision with root package name */
    private String f9138b;

    /* renamed from: d, reason: collision with root package name */
    private com.taobao.accs.c f9139d;

    /* renamed from: a, reason: collision with root package name */
    private int f9137a = 0;

    /* renamed from: e, reason: collision with root package name */
    private Random f9140e = new Random();

    /* renamed from: f, reason: collision with root package name */
    private l.b f9141f = new a(this);

    public ACCSManagerImpl(Context context, String str) {
        GlobalClientInfo.f9031a = context.getApplicationContext();
        this.f9138b = str;
        this.f9139d = new c(str);
        if (v.e(context)) {
            l.a().a(this.f9141f);
        }
        f9136c += this.f9138b;
    }

    @Override // com.taobao.accs.b
    public void c(Context context, String str) {
        if (UtilityImpl.d(context)) {
            return;
        }
        Intent b10 = b(context, 6);
        if (b10 == null) {
            a(context, 6, str, (String) null);
            return;
        }
        String c10 = this.f9139d.c();
        if (TextUtils.isEmpty(c10)) {
            return;
        }
        b10.putExtra(Constants.KEY_APP_KEY, c10);
        b10.putExtra(Constants.KEY_SERVICE_ID, str);
        if (UtilityImpl.isMainProcess(context)) {
            a(context, Message.buildUnbindService(this.f9139d.b((String) null), this.f9138b, b10), 6, false);
        }
    }

    @Override // com.taobao.accs.b
    public void e(Context context) {
        GlobalClientInfo.getInstance(context).clearLoginInfoImpl();
    }

    @Override // com.taobao.accs.b
    public void b(Context context, String str) {
        if (UtilityImpl.d(context) || UtilityImpl.d(context)) {
            return;
        }
        Intent b10 = b(context, 5);
        if (b10 == null) {
            a(context, 5, str, (String) null);
            return;
        }
        String c10 = this.f9139d.c();
        if (TextUtils.isEmpty(c10)) {
            return;
        }
        b10.putExtra(Constants.KEY_APP_KEY, c10);
        b10.putExtra(Constants.KEY_SERVICE_ID, str);
        if (UtilityImpl.isMainProcess(context)) {
            Message buildBindService = Message.buildBindService(this.f9139d.b((String) null), this.f9138b, b10);
            if (buildBindService != null && buildBindService.getNetPermanceMonitor() != null) {
                buildBindService.getNetPermanceMonitor().setDataId(buildBindService.dataId);
                buildBindService.getNetPermanceMonitor().setMsgType(3);
                buildBindService.getNetPermanceMonitor().setHost(buildBindService.host.toString());
            }
            a(context, buildBindService, 5, false);
        }
        this.f9139d.b();
    }

    @Override // com.taobao.accs.b
    public void d(Context context) {
        UtilityImpl.focusEnableService(context);
    }

    @Override // com.taobao.accs.b
    public void e(Context context, String str) {
        GlobalClientInfo.getInstance(context).unregisterListener(str);
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0086 A[Catch: all -> 0x00ff, TryCatch #0 {all -> 0x00ff, blocks: (B:19:0x005e, B:21:0x006e, B:23:0x0074, B:25:0x007a, B:30:0x0086, B:31:0x0096, B:33:0x00ab, B:34:0x00b1, B:36:0x00ba, B:38:0x00c9, B:40:0x00cf, B:41:0x00ec, B:42:0x00f9, B:45:0x00f0), top: B:18:0x005e }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00ab A[Catch: all -> 0x00ff, TryCatch #0 {all -> 0x00ff, blocks: (B:19:0x005e, B:21:0x006e, B:23:0x0074, B:25:0x007a, B:30:0x0086, B:31:0x0096, B:33:0x00ab, B:34:0x00b1, B:36:0x00ba, B:38:0x00c9, B:40:0x00cf, B:41:0x00ec, B:42:0x00f9, B:45:0x00f0), top: B:18:0x005e }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00ba A[Catch: all -> 0x00ff, TryCatch #0 {all -> 0x00ff, blocks: (B:19:0x005e, B:21:0x006e, B:23:0x0074, B:25:0x007a, B:30:0x0086, B:31:0x0096, B:33:0x00ab, B:34:0x00b1, B:36:0x00ba, B:38:0x00c9, B:40:0x00cf, B:41:0x00ec, B:42:0x00f9, B:45:0x00f0), top: B:18:0x005e }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00f0 A[Catch: all -> 0x00ff, TryCatch #0 {all -> 0x00ff, blocks: (B:19:0x005e, B:21:0x006e, B:23:0x0074, B:25:0x007a, B:30:0x0086, B:31:0x0096, B:33:0x00ab, B:34:0x00b1, B:36:0x00ba, B:38:0x00c9, B:40:0x00cf, B:41:0x00ec, B:42:0x00f9, B:45:0x00f0), top: B:18:0x005e }] */
    @Override // com.taobao.accs.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(android.content.Context r10, java.lang.String r11, java.lang.String r12, java.lang.String r13, com.taobao.accs.IAppReceiver r14) {
        /*
            Method dump skipped, instructions count: 266
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.accs.internal.ACCSManagerImpl.a(android.content.Context, java.lang.String, java.lang.String, java.lang.String, com.taobao.accs.IAppReceiver):void");
    }

    @Override // com.taobao.accs.b
    public void d(Context context, String str) {
        GlobalClientInfo.getInstance(context).unRegisterService(str);
    }

    @Override // com.taobao.accs.b
    public void c(Context context) {
        UtilityImpl.focusDisableService(context);
    }

    @Override // com.taobao.accs.b
    public Map<String, Boolean> c() {
        SessionCenter.getInstance(this.f9139d.c()).forceRecreateAccsSession();
        return b();
    }

    @Override // com.taobao.accs.b
    public String b(Context context, String str, String str2, byte[] bArr, String str3, String str4) {
        return b(context, str, str2, bArr, str3, str4, null);
    }

    @Override // com.taobao.accs.b
    public String b(Context context, String str, String str2, byte[] bArr, String str3, String str4, URL url) {
        return b(context, new ACCSManager.AccsRequest(str, str2, bArr, str3, str4, url, null));
    }

    @Override // com.taobao.accs.b
    public String b(Context context, ACCSManager.AccsRequest accsRequest) {
        return a(context, accsRequest, (String) null, true);
    }

    @Override // com.taobao.accs.b
    public boolean b(Context context) {
        return UtilityImpl.i(context);
    }

    private Intent b(Context context, int i10) {
        if (i10 != 1 && UtilityImpl.d(context)) {
            ALog.e(f9136c, "getIntent null command:" + i10 + " accs enabled:" + UtilityImpl.d(context), new Object[0]);
            return null;
        }
        Intent intent = new Intent();
        intent.setAction(Constants.ACTION_COMMAND);
        intent.setClassName(context.getPackageName(), j.channelService);
        intent.putExtra(Constants.KEY_PACKAGE_NAME, context.getPackageName());
        intent.putExtra("command", i10);
        intent.putExtra(Constants.KEY_APP_KEY, this.f9139d.c());
        intent.putExtra(Constants.KEY_CONFIG_TAG, this.f9138b);
        return intent;
    }

    @Override // com.taobao.accs.b
    public Map<String, Boolean> b() {
        String b10 = this.f9139d.b((String) null);
        HashMap hashMap = new HashMap();
        hashMap.put(b10, Boolean.FALSE);
        if (SessionCenter.getInstance(this.f9139d.c()).getThrowsException(b10, 60000L) != null) {
            hashMap.put(b10, Boolean.TRUE);
        }
        ALog.d(f9136c, "getChannelState " + hashMap.toString(), new Object[0]);
        return hashMap;
    }

    private void a(Context context, Message message, int i10, boolean z10) {
        boolean z11;
        this.f9139d.a();
        if (message == null) {
            ALog.e(f9136c, "message is null", new Object[0]);
            this.f9139d.a(Message.buildParameterError(context.getPackageName(), i10), -2);
            return;
        }
        if (i10 == 1) {
            String packageName = message.getPackageName();
            if (this.f9139d.e(packageName) && !z10) {
                ALog.i(f9136c, "isAppBinded", Constants.KEY_PACKAGE, packageName);
                this.f9139d.a(message, 200);
                z11 = false;
            }
            z11 = true;
        } else if (i10 != 2) {
            if (i10 == 3 && this.f9139d.a(message.getPackageName(), message.userinfo) && !z10) {
                ALog.i(f9136c, message.getPackageName() + Operator.Operation.DIVISION + message.userinfo + " isUserBinded", "isForceBind", Boolean.valueOf(z10));
                this.f9139d.a(message, 200);
                z11 = false;
            }
            z11 = true;
        } else {
            if (this.f9139d.f(message.getPackageName())) {
                ALog.i(f9136c, message.getPackageName() + " isAppUnbinded", new Object[0]);
                this.f9139d.a(message, 200);
                z11 = false;
            }
            z11 = true;
        }
        if (z11) {
            ALog.i(f9136c, "sendControlMessage", "command", Integer.valueOf(i10));
            this.f9139d.a(message, true);
        }
    }

    @Override // com.taobao.accs.b
    public void b(AccsConnectStateListener accsConnectStateListener) {
        if (accsConnectStateListener != null) {
            this.f9139d.b(accsConnectStateListener);
        }
    }

    @Override // com.taobao.accs.b
    public void a(Context context, String str) {
        a(context, str, false);
    }

    @Override // com.taobao.accs.b
    public void a(Context context, String str, boolean z10) {
        try {
            ALog.i(f9136c, "bindUser", "userId", str);
            if (UtilityImpl.d(context)) {
                ALog.e(f9136c, "accs disabled", new Object[0]);
                return;
            }
            Intent b10 = b(context, 3);
            if (b10 == null) {
                ALog.e(f9136c, "intent null", new Object[0]);
                a(context, 3, (String) null, (String) null);
                return;
            }
            String c10 = this.f9139d.c();
            if (TextUtils.isEmpty(c10)) {
                ALog.e(f9136c, "appKey null", new Object[0]);
                return;
            }
            if (UtilityImpl.c(context) || z10) {
                ALog.i(f9136c, "force bind User", new Object[0]);
                b10.putExtra(Constants.KEY_FOUCE_BIND, true);
                z10 = true;
            }
            b10.putExtra(Constants.KEY_APP_KEY, c10);
            b10.putExtra(Constants.KEY_USER_ID, str);
            if (UtilityImpl.isMainProcess(context)) {
                Message buildBindUser = Message.buildBindUser(this.f9139d.b((String) null), this.f9138b, b10);
                if (buildBindUser != null && buildBindUser.getNetPermanceMonitor() != null) {
                    buildBindUser.getNetPermanceMonitor().setDataId(buildBindUser.dataId);
                    buildBindUser.getNetPermanceMonitor().setMsgType(2);
                    buildBindUser.getNetPermanceMonitor().setHost(buildBindUser.host.toString());
                }
                a(context, buildBindUser, 3, z10);
            }
            this.f9139d.b();
        } catch (Throwable th) {
            ALog.e(f9136c, "bindUser", th, new Object[0]);
        }
    }

    @Override // com.taobao.accs.b
    public void a(Context context) {
        if (UtilityImpl.d(context) || UtilityImpl.d(context)) {
            return;
        }
        Intent b10 = b(context, 4);
        if (b10 == null) {
            a(context, 4, (String) null, (String) null);
            return;
        }
        String c10 = this.f9139d.c();
        if (TextUtils.isEmpty(c10)) {
            return;
        }
        b10.putExtra(Constants.KEY_APP_KEY, c10);
        if (UtilityImpl.isMainProcess(context)) {
            a(context, Message.buildUnbindUser(this.f9139d.b((String) null), this.f9138b, b10), 4, false);
        }
    }

    @Override // com.taobao.accs.b
    public String a(Context context, String str, String str2, byte[] bArr, String str3) {
        return a(context, str, str2, bArr, str3, (String) null);
    }

    @Override // com.taobao.accs.b
    public String a(Context context, String str, String str2, byte[] bArr, String str3, String str4) {
        return a(context, str, str2, bArr, str3, str4, null);
    }

    @Override // com.taobao.accs.b
    public String a(Context context, String str, String str2, byte[] bArr, String str3, String str4, URL url) {
        return a(context, new ACCSManager.AccsRequest(str, str2, bArr, str3, str4, url, null));
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x009f, code lost:
    
        com.taobao.accs.utl.k.a("accs", com.taobao.accs.utl.BaseMonitor.ALARM_POINT_REQ_ERROR, r17.serviceId, "1", "accs disable");
     */
    @Override // com.taobao.accs.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String a(android.content.Context r16, com.taobao.accs.ACCSManager.AccsRequest r17) {
        /*
            Method dump skipped, instructions count: 246
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.accs.internal.ACCSManagerImpl.a(android.content.Context, com.taobao.accs.ACCSManager$AccsRequest):java.lang.String");
    }

    @Override // com.taobao.accs.b
    public String a(Context context, ACCSManager.AccsRequest accsRequest, String str, boolean z10) {
        try {
        } catch (Throwable th) {
            if (accsRequest != null) {
                k.a("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, accsRequest.serviceId, "1", "request " + th.toString());
                ALog.e(f9136c, "sendRequest", th, Constants.KEY_DATA_ID, accsRequest.dataId);
            }
        }
        if (accsRequest == null) {
            ALog.e(f9136c, "sendRequest request null", new Object[0]);
            k.a("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, null, "1", "request null");
            return null;
        }
        if (!UtilityImpl.isMainProcess(context)) {
            ALog.e(f9136c, "sendRequest not in mainprocess", new Object[0]);
            return null;
        }
        if (UtilityImpl.d(context)) {
            ALog.e(f9136c, "sendRequest disable", new Object[0]);
            k.a("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, accsRequest.serviceId, "1", "accs disable");
            return null;
        }
        if (TextUtils.isEmpty(this.f9139d.c())) {
            k.a("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, accsRequest.serviceId, "1", "request appkey null");
            ALog.e(f9136c, "sendRequest appkey null", new Object[0]);
            return null;
        }
        this.f9139d.a();
        Message buildRequest = Message.buildRequest(context, this.f9139d.b((String) null), this.f9138b, "", str == null ? context.getPackageName() : str, Constants.TARGET_SERVICE_PRE, accsRequest, z10);
        if (buildRequest != null && buildRequest.getNetPermanceMonitor() != null) {
            buildRequest.getNetPermanceMonitor().onSend();
        }
        this.f9139d.a(buildRequest, true);
        return accsRequest.dataId;
    }

    @Override // com.taobao.accs.b
    public String a(Context context, ACCSManager.AccsRequest accsRequest, TaoBaseService.ExtraInfo extraInfo) {
        try {
        } catch (Throwable th) {
            k.a("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, accsRequest.serviceId, "1", "push response " + th.toString());
            ALog.e(f9136c, "sendPushResponse dataid:" + accsRequest.dataId, th, new Object[0]);
        }
        if (context != null && accsRequest != null) {
            k.a("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, "push response total");
            if (UtilityImpl.d(context)) {
                k.a("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, accsRequest.serviceId, "1", "sendPushResponse accs disable");
                return null;
            }
            String c10 = this.f9139d.c();
            if (TextUtils.isEmpty(c10)) {
                k.a("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, accsRequest.serviceId, "1", "sendPushResponse appkey null");
                ALog.e(f9136c, "sendPushResponse appkey null", new Object[0]);
                return null;
            }
            if (extraInfo == null) {
                extraInfo = new TaoBaseService.ExtraInfo();
            }
            extraInfo.connType = 1;
            extraInfo.fromHost = "https://" + AccsClientConfig.getConfigByTag(Config.c(context)).getInappHost();
            extraInfo.fromPackage = context.getPackageName();
            ALog.i(f9136c, "sendPushResponse", "isMainProcess", Boolean.valueOf(UtilityImpl.isMainProcess(context)));
            accsRequest.host = new URL(extraInfo.fromHost);
            if (UtilityImpl.isMainProcess(context)) {
                a(context, accsRequest, context.getPackageName(), false);
            } else {
                Intent intent = new Intent(Constants.ACTION_SEND);
                intent.setClassName(extraInfo.fromPackage, j.msgService);
                intent.putExtra(Constants.KEY_PACKAGE_NAME, context.getPackageName());
                intent.putExtra(Constants.KEY_SEND_REQDATA, accsRequest);
                intent.putExtra(Constants.KEY_APP_KEY, c10);
                intent.putExtra(Constants.KEY_CONFIG_TAG, this.f9138b);
                com.taobao.accs.a.a.a(context, intent);
            }
            return null;
        }
        ALog.e(f9136c, "sendPushResponse input null", com.umeng.analytics.pro.f.X, context, "response", accsRequest, "extraInfo", extraInfo);
        k.a("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, "", "1", "sendPushResponse null");
        return null;
    }

    @Override // com.taobao.accs.b
    public boolean a() {
        try {
            com.taobao.accs.c cVar = this.f9139d;
            if (cVar != null) {
                return cVar.f();
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // com.taobao.accs.b
    @Deprecated
    public void a(Context context, int i10) {
        ACCSClient.setEnvironment(context, i10);
    }

    private void a(Context context, int i10, String str, String str2) {
        Intent intent = new Intent(Constants.ACTION_RECEIVE);
        intent.setPackage(context.getPackageName());
        intent.putExtra("command", i10);
        intent.putExtra(Constants.KEY_SERVICE_ID, str);
        intent.putExtra(Constants.KEY_DATA_ID, str2);
        intent.putExtra(Constants.KEY_APP_KEY, this.f9139d.c());
        intent.putExtra(Constants.KEY_CONFIG_TAG, this.f9138b);
        intent.putExtra("errorCode", i10 == 2 ? 200 : 300);
        com.taobao.accs.data.g.a(context, intent);
    }

    @Override // com.taobao.accs.b
    public void a(Context context, String str, int i10) {
        SharedPreferences.Editor edit = context.getSharedPreferences(Constants.SP_FILE_NAME, 0).edit();
        if (!TextUtils.isEmpty(str)) {
            edit.putString(Constants.KEY_PROXY_HOST, str);
        }
        edit.putInt(Constants.KEY_PROXY_PORT, i10);
        edit.apply();
    }

    @Override // com.taobao.accs.b
    public void a(Context context, String str, String str2, IAppReceiver iAppReceiver) {
        GlobalClientInfo.getInstance(context).setAppReceiver(this.f9138b, iAppReceiver);
        if (!UtilityImpl.isMainProcess(context)) {
            ALog.d(f9136c, "inapp only init in main process!", new Object[0]);
            return;
        }
        ALog.d(f9136c, "startInAppConnection APPKEY:" + str, new Object[0]);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (!TextUtils.equals(this.f9139d.c(), str)) {
            this.f9139d.c(str2);
            this.f9139d.d(str);
        }
        this.f9139d.a();
    }

    @Override // com.taobao.accs.b
    public void a(Context context, ILoginInfo iLoginInfo) {
        GlobalClientInfo.getInstance(context).setLoginInfoImpl(this.f9138b, iLoginInfo);
    }

    @Override // com.taobao.accs.b
    public boolean a(String str) {
        return this.f9139d.a(str);
    }

    @Override // com.taobao.accs.b
    public boolean a(int i10) {
        return ErrorCode.isChannelError(i10);
    }

    @Override // com.taobao.accs.b
    public void a(Context context, String str, String str2) {
        GlobalClientInfo.getInstance(context).registerService(str, str2);
    }

    @Override // com.taobao.accs.b
    public void a(Context context, String str, AccsAbstractDataListener accsAbstractDataListener) {
        GlobalClientInfo.getInstance(context).registerListener(str, accsAbstractDataListener);
    }

    @Override // com.taobao.accs.b
    public void a(AccsConnectStateListener accsConnectStateListener) {
        if (accsConnectStateListener != null) {
            this.f9139d.a(accsConnectStateListener);
        }
    }

    @Override // com.taobao.accs.b
    public void a(String str, String str2, String str3, short s10, String str4, Map<Integer, String> map) {
        this.f9139d.a(Message.buildPushAck(this.f9139d.b((String) null), this.f9138b, str, str2, str3, true, s10, str4, map), true);
    }

    @Override // com.taobao.accs.b
    public void a(AccsClientConfig accsClientConfig) {
        this.f9139d.a(accsClientConfig);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.taobao.accs.c cVar) {
        ThreadPoolExecutorFactory.schedule(new b(this, cVar), this.f9140e.nextInt(6), TimeUnit.SECONDS);
    }
}
