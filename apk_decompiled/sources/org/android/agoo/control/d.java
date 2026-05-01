package org.android.agoo.control;

import android.text.TextUtils;
import com.hpplay.cybergarage.xml.XML;
import com.hpplay.sdk.source.common.global.Constant;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.BaseMonitor;
import org.android.agoo.common.AgooConstants;
import org.android.agoo.common.Config;
import org.android.agoo.message.MessageService;
import org.json.JSONObject;

/* loaded from: classes.dex */
class d implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ byte[] f17844a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ boolean f17845b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ AgooFactory f17846c;

    public d(AgooFactory agooFactory, byte[] bArr, boolean z10) {
        this.f17846c = agooFactory;
        this.f17844a = bArr;
        this.f17845b = z10;
    }

    @Override // java.lang.Runnable
    public void run() {
        MessageService messageService;
        MessageService messageService2;
        try {
            String str = new String(this.f17844a, XML.CHARSET_UTF8);
            if (TextUtils.isEmpty(str)) {
                com.taobao.accs.utl.k.a("accs", BaseMonitor.COUNT_AGOO_FAIL_ACK, "msg==null", 0.0d);
                return;
            }
            ALog.i("AgooFactory", "message = " + str, new Object[0]);
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString("api");
            String string2 = jSONObject.getString("id");
            String string3 = TextUtils.equals(string, "agooReport") ? jSONObject.getString(Constant.KEY_STATUS) : null;
            if (TextUtils.equals(string, AgooConstants.AGOO_SERVICE_AGOOACK)) {
                com.taobao.accs.utl.k.a("accs", BaseMonitor.COUNT_AGOO_SUCCESS_ACK, "handlerACKMessage", 0.0d);
            }
            if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2) && !TextUtils.isEmpty(string3)) {
                if (ALog.isPrintLog(ALog.Level.I)) {
                    ALog.i("AgooFactory", "updateMsg data begin,api=" + string + ",id=" + string2 + ",status=" + string3 + ",reportTimes=" + Config.f(AgooFactory.mContext), new Object[0]);
                }
                if (TextUtils.equals(string, "agooReport")) {
                    if (TextUtils.equals(string3, "4") && this.f17845b) {
                        messageService2 = this.f17846c.messageService;
                        messageService2.a(string2, "1");
                    } else if ((TextUtils.equals(string3, MessageService.MSG_ACCS_NOTIFY_CLICK) || TextUtils.equals(string3, MessageService.MSG_ACCS_NOTIFY_DISMISS)) && this.f17845b) {
                        messageService = this.f17846c.messageService;
                        messageService.a(string2, "100");
                    }
                    com.taobao.accs.utl.k.a("accs", BaseMonitor.COUNT_AGOO_SUCCESS_ACK, string3, 0.0d);
                    return;
                }
                return;
            }
            com.taobao.accs.utl.k.a("accs", BaseMonitor.COUNT_AGOO_FAIL_ACK, "json key null", 0.0d);
        } catch (Throwable th) {
            ALog.e("AgooFactory", "updateMsg get data error,e=" + th, new Object[0]);
            com.taobao.accs.utl.k.a("accs", BaseMonitor.COUNT_AGOO_FAIL_ACK, "json exception", 0.0d);
        }
    }
}
