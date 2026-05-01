package com.taobao.accs.ut.a;

import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.UTMini;
import java.util.HashMap;

/* loaded from: classes3.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public String f9275a;

    /* renamed from: b, reason: collision with root package name */
    public String f9276b;

    /* renamed from: c, reason: collision with root package name */
    public String f9277c;

    /* renamed from: d, reason: collision with root package name */
    public String f9278d;

    /* renamed from: e, reason: collision with root package name */
    public String f9279e;

    /* renamed from: f, reason: collision with root package name */
    public String f9280f;

    /* renamed from: g, reason: collision with root package name */
    public String f9281g;

    /* renamed from: i, reason: collision with root package name */
    public String f9283i;

    /* renamed from: j, reason: collision with root package name */
    private final String f9284j = "receiveMessage";

    /* renamed from: h, reason: collision with root package name */
    public boolean f9282h = false;

    /* renamed from: k, reason: collision with root package name */
    private boolean f9285k = false;

    public void a() {
        String str;
        String str2;
        if (this.f9285k) {
            return;
        }
        this.f9285k = true;
        HashMap hashMap = new HashMap();
        try {
            str = this.f9275a;
            try {
                str2 = String.valueOf(Constants.SDK_VERSION_CODE);
                try {
                    hashMap.put("device_id", this.f9275a);
                    hashMap.put("data_id", this.f9276b);
                    hashMap.put("receive_date", this.f9277c);
                    hashMap.put("to_bz_date", this.f9278d);
                    hashMap.put("service_id", this.f9279e);
                    hashMap.put("data_length", this.f9280f);
                    hashMap.put("msg_type", this.f9281g);
                    hashMap.put("repeat", this.f9282h ? "y" : "n");
                    hashMap.put("user_id", this.f9283i);
                    UTMini.getInstance().commitEvent(66001, "receiveMessage", str, (Object) null, str2, hashMap);
                } catch (Throwable th) {
                    th = th;
                    ALog.d("ReceiveMessage", UTMini.getCommitInfo(66001, str, (String) null, str2, hashMap) + " " + th.toString(), new Object[0]);
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
