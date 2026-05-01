package com.taobao.accs.ut.a;

import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.UTMini;
import java.util.HashMap;

/* loaded from: classes3.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public String f9286a;

    /* renamed from: b, reason: collision with root package name */
    public String f9287b;

    /* renamed from: c, reason: collision with root package name */
    public String f9288c;

    /* renamed from: d, reason: collision with root package name */
    public String f9289d;

    /* renamed from: e, reason: collision with root package name */
    public String f9290e;

    /* renamed from: f, reason: collision with root package name */
    public String f9291f;

    /* renamed from: g, reason: collision with root package name */
    private final String f9292g = "sendAck";

    /* renamed from: h, reason: collision with root package name */
    private boolean f9293h = false;

    public void a() {
        String str;
        String str2;
        if (this.f9293h) {
            return;
        }
        this.f9293h = true;
        HashMap hashMap = new HashMap();
        try {
            str = this.f9286a;
            try {
                str2 = String.valueOf(Constants.SDK_VERSION_CODE);
                try {
                    hashMap.put("device_id", this.f9286a);
                    hashMap.put("session_id", this.f9287b);
                    hashMap.put("data_id", this.f9288c);
                    hashMap.put("ack_date", this.f9289d);
                    hashMap.put("service_id", this.f9290e);
                    hashMap.put("fail_reasons", this.f9291f);
                    UTMini.getInstance().commitEvent(66001, "sendAck", str, (Object) null, str2, hashMap);
                } catch (Throwable th) {
                    th = th;
                    ALog.d("accs.SendAckStatistic", UTMini.getCommitInfo(66001, str, (String) null, str2, hashMap) + " " + th.toString(), new Object[0]);
                }
            } catch (Throwable th2) {
                th = th2;
                str2 = null;
            }
        } catch (Throwable th3) {
            th = th3;
            str = null;
            str2 = null;
        }
    }
}
