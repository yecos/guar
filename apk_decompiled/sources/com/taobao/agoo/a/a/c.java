package com.taobao.agoo.a.a;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.hpplay.cybergarage.xml.XML;
import com.taobao.accs.client.GlobalClientInfo;
import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.UtilityImpl;
import com.taobao.accs.utl.j;
import com.taobao.accs.utl.o;
import com.taobao.accs.utl.p;
import com.umeng.analytics.pro.bt;
import com.umeng.commonsdk.utils.UMUtils;
import com.umeng.message.MsgConstant;

/* loaded from: classes3.dex */
public class c extends b {
    public static final String JSON_CMD_REGISTER = "register";

    /* renamed from: a, reason: collision with root package name */
    public String f9395a;

    /* renamed from: b, reason: collision with root package name */
    public String f9396b;

    /* renamed from: c, reason: collision with root package name */
    public String f9397c;

    /* renamed from: d, reason: collision with root package name */
    public String f9398d = String.valueOf(Constants.SDK_VERSION_CODE);

    /* renamed from: f, reason: collision with root package name */
    public String f9399f;

    /* renamed from: g, reason: collision with root package name */
    public String f9400g;

    /* renamed from: h, reason: collision with root package name */
    public String f9401h;

    /* renamed from: i, reason: collision with root package name */
    public String f9402i;

    /* renamed from: j, reason: collision with root package name */
    public String f9403j;

    /* renamed from: k, reason: collision with root package name */
    public String f9404k;

    /* renamed from: l, reason: collision with root package name */
    public String f9405l;

    /* renamed from: m, reason: collision with root package name */
    public String f9406m;

    /* renamed from: n, reason: collision with root package name */
    public String f9407n;

    /* renamed from: o, reason: collision with root package name */
    public String f9408o;

    /* renamed from: p, reason: collision with root package name */
    public String f9409p;

    /* renamed from: q, reason: collision with root package name */
    private String f9410q;

    /* renamed from: r, reason: collision with root package name */
    private String f9411r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f9412s;

    /* renamed from: t, reason: collision with root package name */
    private String f9413t;

    public byte[] a() {
        try {
            String jSONObject = new p.a().a(b.JSON_CMD, this.f9394e).a(Constants.KEY_APP_KEY, this.f9395a).a("utdid", this.f9396b).a("appVersion", this.f9397c).a(Constants.KEY_SDK_VERSION, this.f9398d).a(Constants.KEY_TTID, this.f9399f).a(Constants.KEY_PACKAGE_NAME, this.f9400g).a("notifyEnable", this.f9401h).a("romInfo", this.f9402i).a("c0", this.f9403j).a("c1", this.f9404k).a("c2", this.f9405l).a("c3", this.f9406m).a("c4", this.f9407n).a("c5", this.f9408o).a("c6", this.f9409p).a("pSdkV", this.f9410q).a(bt.f10046g, this.f9411r).a("ohos", String.valueOf(this.f9412s)).a("ohosV", this.f9413t).a().toString();
            ALog.i("RegisterDO", "buildData", "data", jSONObject);
            return jSONObject.getBytes(XML.CHARSET_UTF8);
        } catch (Throwable th) {
            ALog.e("RegisterDO", "buildData", th, new Object[0]);
            return null;
        }
    }

    public static byte[] a(Context context, String str, String str2) {
        c cVar;
        String j10;
        String packageName;
        String str3;
        try {
            j10 = UtilityImpl.j(context);
            packageName = context.getPackageName();
            str3 = GlobalClientInfo.getInstance(context).getPackageInfo().versionName;
        } catch (Throwable th) {
            th = th;
            cVar = null;
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(j10) && !TextUtils.isEmpty(str3)) {
            cVar = new c();
            try {
                cVar.f9394e = JSON_CMD_REGISTER;
                cVar.f9395a = str;
                cVar.f9396b = j10;
                cVar.f9397c = str3;
                cVar.f9399f = str2;
                cVar.f9400g = packageName;
                cVar.f9403j = Build.BRAND;
                cVar.f9404k = Build.MODEL;
                String c10 = j.c(context);
                cVar.f9401h = c10;
                UtilityImpl.a(context, Constants.SP_CHANNEL_FILE_NAME, c10);
                cVar.f9402i = new o().a();
                try {
                    cVar.f9410q = (String) MsgConstant.class.getField("SDK_VERSION").get(null);
                } catch (Throwable unused) {
                }
                try {
                    String str4 = UMUtils.UNKNOW;
                    cVar.f9411r = (String) UMUtils.class.getMethod("getUMId", Context.class).invoke(null, context);
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
                try {
                    boolean j11 = UtilityImpl.j();
                    cVar.f9412s = j11;
                    if (j11) {
                        cVar.f9413t = UtilityImpl.k();
                    }
                } catch (Throwable unused2) {
                }
            } catch (Throwable th3) {
                th = th3;
                try {
                    ALog.w("RegisterDO", "buildRegister", th.getMessage());
                    if (cVar == null) {
                        return null;
                    }
                    return cVar.a();
                } finally {
                    if (cVar != null) {
                        cVar.a();
                    }
                }
            }
            return cVar.a();
        }
        ALog.e("RegisterDO", "buildRegister param null", Constants.KEY_APP_KEY, str, "utdid", j10, "appVersion", str3);
        return null;
    }
}
