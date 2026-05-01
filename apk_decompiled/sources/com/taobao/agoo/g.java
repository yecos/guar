package com.taobao.agoo;

import android.content.Context;
import android.text.TextUtils;
import com.taobao.accs.ACCSManager;
import com.taobao.accs.IAgooAppReceiver;
import com.taobao.accs.client.GlobalClientInfo;
import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.UtilityImpl;
import com.taobao.accs.utl.l;
import java.util.Map;
import org.android.agoo.common.Config;

/* loaded from: classes3.dex */
final class g implements IAgooAppReceiver {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f9419a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Context f9420b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ IRegister f9421c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ String f9422d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ String f9423e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ com.taobao.accs.b f9424f;

    public g(Context context, Context context2, IRegister iRegister, String str, String str2, com.taobao.accs.b bVar) {
        this.f9419a = context;
        this.f9420b = context2;
        this.f9421c = iRegister;
        this.f9422d = str;
        this.f9423e = str2;
        this.f9424f = bVar;
    }

    @Override // com.taobao.accs.IAppReceiver
    public Map<String, String> getAllServices() {
        return null;
    }

    @Override // com.taobao.accs.IAgooAppReceiver
    public String getAppkey() {
        return this.f9422d;
    }

    @Override // com.taobao.accs.IAppReceiver
    public String getService(String str) {
        return null;
    }

    @Override // com.taobao.accs.IAppReceiver
    public void onBindApp(int i10) {
    }

    @Override // com.taobao.accs.IAppReceiver
    public void onBindUser(String str, int i10) {
    }

    @Override // com.taobao.accs.IAppReceiver
    public void onData(String str, String str2, byte[] bArr) {
    }

    @Override // com.taobao.accs.IAppReceiver
    public void onSendData(String str, int i10) {
    }

    @Override // com.taobao.accs.IAppReceiver
    public void onUnbindApp(int i10) {
    }

    @Override // com.taobao.accs.IAppReceiver
    public void onUnbindUser(int i10) {
    }

    @Override // com.taobao.accs.IAppReceiverV1
    public void onBindApp(int i10, String str) {
        com.taobao.agoo.a.b bVar;
        com.taobao.agoo.a.b bVar2;
        com.taobao.agoo.a.b bVar3;
        try {
            ALog.i("TaobaoRegister", "onBindApp", "errorCode", Integer.valueOf(i10));
            if (i10 != 200) {
                IRegister iRegister = this.f9421c;
                if (iRegister != null) {
                    iRegister.onFailure(String.valueOf(i10), "accs bindapp error!");
                    return;
                }
                return;
            }
            bVar = TaobaoRegister.mRequestListener;
            if (bVar == null) {
                com.taobao.agoo.a.b unused = TaobaoRegister.mRequestListener = new com.taobao.agoo.a.b(this.f9419a);
            }
            GlobalClientInfo globalClientInfo = GlobalClientInfo.getInstance(this.f9420b);
            bVar2 = TaobaoRegister.mRequestListener;
            globalClientInfo.registerListener("AgooDeviceCmd", bVar2);
            if (!Config.a() && com.taobao.agoo.a.b.f9417b.b(this.f9419a.getPackageName()) && !UtilityImpl.b(Constants.SP_CHANNEL_FILE_NAME, this.f9420b)) {
                String g10 = Config.g(this.f9419a);
                if (!TextUtils.isEmpty(g10)) {
                    boolean unused2 = TaobaoRegister.isRegisterSuccess = true;
                    l.a().b();
                    ALog.i("TaobaoRegister", "agoo already Registered return ", new Object[0]);
                    IRegister iRegister2 = this.f9421c;
                    if (iRegister2 != null) {
                        iRegister2.onSuccess(g10);
                        return;
                    }
                    return;
                }
            }
            byte[] a10 = com.taobao.agoo.a.a.c.a(this.f9419a, this.f9422d, this.f9423e);
            if (a10 == null) {
                IRegister iRegister3 = this.f9421c;
                if (iRegister3 != null) {
                    iRegister3.onFailure("503.1", "req data null");
                    return;
                }
                return;
            }
            String b10 = this.f9424f.b(this.f9419a, new ACCSManager.AccsRequest(null, "AgooDeviceCmd", a10, null));
            if (TextUtils.isEmpty(b10)) {
                IRegister iRegister4 = this.f9421c;
                if (iRegister4 != null) {
                    iRegister4.onFailure("503.1", "accs channel disabled!");
                    return;
                }
                return;
            }
            if (this.f9421c != null) {
                bVar3 = TaobaoRegister.mRequestListener;
                bVar3.f9418a.put(b10, this.f9421c);
            }
        } catch (Throwable th) {
            ALog.e("TaobaoRegister", "register onBindApp", th, new Object[0]);
        }
    }
}
