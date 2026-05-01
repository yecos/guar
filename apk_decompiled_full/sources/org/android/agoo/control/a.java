package org.android.agoo.control;

import android.text.TextUtils;
import com.hpplay.cybergarage.xml.XML;
import com.taobao.accs.utl.ALog;
import com.umeng.analytics.pro.bt;
import org.android.agoo.common.Config;
import org.android.agoo.message.MessageService;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ byte[] f17836a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f17837b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ AgooFactory f17838c;

    public a(AgooFactory agooFactory, byte[] bArr, String str) {
        this.f17838c = agooFactory;
        this.f17836a = bArr;
        this.f17837b = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        MessageService messageService;
        MessageService messageService2;
        try {
            String str = new String(this.f17836a, XML.CHARSET_UTF8);
            JSONArray jSONArray = new JSONArray(str);
            int length = jSONArray.length();
            if (length == 1) {
                String str2 = null;
                String str3 = null;
                for (int i10 = 0; i10 < length; i10++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i10);
                    if (jSONObject != null) {
                        str2 = jSONObject.getString(bt.aI);
                        str3 = jSONObject.getString(bt.aD);
                    }
                }
                if (ALog.isPrintLog(ALog.Level.I)) {
                    ALog.i("AgooFactory", "saveMsg msgId:" + str2 + ",message=" + str + ",currentPack=" + str3 + ",reportTimes=" + Config.f(AgooFactory.mContext), new Object[0]);
                }
                if (TextUtils.isEmpty(str3) || !TextUtils.equals(str3, AgooFactory.mContext.getPackageName())) {
                    return;
                }
                if (TextUtils.isEmpty(this.f17837b)) {
                    messageService2 = this.f17838c.messageService;
                    messageService2.a(str2, str, "0");
                } else {
                    messageService = this.f17838c.messageService;
                    messageService.a(str2, str, this.f17837b);
                }
            }
        } catch (Throwable th) {
            ALog.e("AgooFactory", "saveMsg fail:" + th.toString(), new Object[0]);
        }
    }
}
