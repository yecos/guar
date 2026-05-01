package org.android.agoo.control;

import android.content.Context;
import android.text.TextUtils;
import com.hpplay.component.common.ParamsMap;
import com.taobao.accs.ACCSManager;
import com.taobao.accs.base.TaoBaseService;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.UTMini;
import java.util.HashMap;
import org.android.agoo.common.AgooConstants;
import org.android.agoo.common.Config;
import org.json.JSONObject;

/* loaded from: classes.dex */
class l implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f17858a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f17859b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ String f17860c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ boolean f17861d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ NotifManager f17862e;

    public l(NotifManager notifManager, String str, String str2, String str3, boolean z10) {
        this.f17862e = notifManager;
        this.f17858a = str;
        this.f17859b = str2;
        this.f17860c = str3;
        this.f17861d = z10;
    }

    @Override // java.lang.Runnable
    public void run() {
        Context context;
        Context context2;
        Context context3;
        Context context4;
        Context context5;
        Context context6;
        Context context7;
        Context context8;
        String a10;
        Context context9;
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("thirdTokenType", this.f17858a);
            hashMap.put(ParamsMap.DeviceParams.KEY_AUTH_TOKEN, this.f17859b);
            context2 = this.f17862e.mContext;
            hashMap.put("appkey", Config.a(context2));
            context3 = this.f17862e.mContext;
            hashMap.put("utdid", com.taobao.accs.utl.j.b(context3));
            if (!TextUtils.isEmpty(this.f17860c)) {
                hashMap.put("vendorSdkVersion", this.f17860c);
            }
            StringBuilder sb = new StringBuilder();
            sb.append("report,utdid=");
            context4 = this.f17862e.mContext;
            sb.append(com.taobao.accs.utl.j.b(context4));
            sb.append(",regId=");
            sb.append(this.f17859b);
            sb.append(",type=");
            sb.append(this.f17858a);
            ALog.d("NotifManager", sb.toString(), new Object[0]);
            ACCSManager.AccsRequest accsRequest = new ACCSManager.AccsRequest(null, "agooTokenReport", new JSONObject(hashMap).toString().getBytes("UTF-8"), null, null, null, null);
            context5 = this.f17862e.mContext;
            context6 = this.f17862e.mContext;
            String a11 = Config.a(context6);
            context7 = this.f17862e.mContext;
            com.taobao.accs.b accsInstance = ACCSManager.getAccsInstance(context5, a11, Config.c(context7));
            if (this.f17861d) {
                context9 = this.f17862e.mContext;
                a10 = accsInstance.a(context9, accsRequest);
            } else {
                context8 = this.f17862e.mContext;
                a10 = accsInstance.a(context8, accsRequest, new TaoBaseService.ExtraInfo());
            }
            if (ALog.isPrintLog(ALog.Level.D)) {
                ALog.i("NotifManager", "reportThirdPushToken,dataId=" + a10 + ",regId=" + this.f17859b + ",type=" + this.f17858a, new Object[0]);
            }
        } catch (Throwable th) {
            UTMini uTMini = UTMini.getInstance();
            context = this.f17862e.mContext;
            uTMini.commitEvent(AgooConstants.AGOO_EVENT_ID, "reportThirdPushToken", com.taobao.accs.utl.j.b(context), th.toString());
            if (ALog.isPrintLog(ALog.Level.E)) {
                ALog.e("NotifManager", "[report] is error", th, new Object[0]);
            }
        }
    }
}
