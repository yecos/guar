package com.taobao.accs.ut.a;

import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.UTMini;
import java.util.HashMap;

/* loaded from: classes3.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public String f9251a;

    /* renamed from: b, reason: collision with root package name */
    public String f9252b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f9253c;

    /* renamed from: d, reason: collision with root package name */
    public String f9254d;

    /* renamed from: e, reason: collision with root package name */
    private final String f9255e = "BindApp";

    /* renamed from: f, reason: collision with root package name */
    private boolean f9256f = false;

    private void b(String str) {
        String str2;
        String str3;
        if (this.f9256f) {
            return;
        }
        this.f9256f = true;
        HashMap hashMap = new HashMap();
        try {
            str2 = this.f9251a;
            try {
                str3 = String.valueOf(Constants.SDK_VERSION_CODE);
                try {
                    hashMap.put("device_id", this.f9251a);
                    hashMap.put("bind_date", this.f9252b);
                    hashMap.put("ret", this.f9253c ? "y" : "n");
                    hashMap.put("fail_reasons", this.f9254d);
                    hashMap.put("push_token", "");
                    UTMini.getInstance().commitEvent(66001, str, str2, (Object) null, str3, hashMap);
                } catch (Throwable th) {
                    th = th;
                    ALog.d("BindAppStatistic", UTMini.getCommitInfo(66001, str2, (String) null, str3, hashMap) + " " + th.toString(), new Object[0]);
                }
            } catch (Throwable th2) {
                th = th2;
                str3 = null;
            }
        } catch (Throwable th3) {
            th = th3;
            str2 = null;
            str3 = null;
        }
    }

    public void a(String str) {
        this.f9254d = str;
    }

    public void a(int i10) {
        if (i10 == -4) {
            a("msg too large");
            return;
        }
        if (i10 == -3) {
            a("service not available");
            return;
        }
        if (i10 == -2) {
            a("param error");
            return;
        }
        if (i10 == -1) {
            a("network fail");
        } else if (i10 != 200) {
            if (i10 != 300) {
                a(String.valueOf(i10));
            } else {
                a("app not bind");
            }
        }
    }

    public void a() {
        b("BindApp");
    }
}
