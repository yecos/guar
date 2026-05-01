package c2;

import android.text.TextUtils;
import com.bigbee.bean.CommonParamBean;
import com.taobao.accs.common.Constants;

/* loaded from: classes.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    public static final l f5383a = new l();

    /* renamed from: b, reason: collision with root package name */
    public static final String f5384b = l.class.getSimpleName();

    /* renamed from: c, reason: collision with root package name */
    public static CommonParamBean f5385c = new CommonParamBean();

    public final String a() {
        String userName;
        CommonParamBean commonParamBean = f5385c;
        return (commonParamBean == null || (userName = commonParamBean.getUserName()) == null) ? "" : userName;
    }

    public final CommonParamBean b() {
        return f5385c;
    }

    public final void c(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        t9.i.g(str, "appId");
        t9.i.g(str2, "appVer");
        t9.i.g(str3, "sysVer");
        t9.i.g(str4, Constants.KEY_MODEL);
        t9.i.g(str5, "macAddr");
        t9.i.g(str6, "reserve1");
        t9.i.g(str7, "sn");
        f5385c.setAppId(str);
        f5385c.setAppVer(str2);
        f5385c.setSysVer(str3);
        f5385c.setModel(str4);
        f5385c.setMacAddr(str5);
        f5385c.setReserve1(str6);
        f5385c.setSn(str7);
    }

    public final void d(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        t9.i.g(str, "appId");
        t9.i.g(str2, "appVer");
        t9.i.g(str3, "sysVer");
        t9.i.g(str4, Constants.KEY_MODEL);
        t9.i.g(str5, "macAddr");
        t9.i.g(str6, "reserve1");
        t9.i.g(str7, "sn");
        t9.i.g(str8, "userId");
        t9.i.g(str9, "userName");
        c(str, str2, str3, str4, str5, str6, str7);
        f5385c.setUserId(str8);
        f5385c.setUserName(str9);
    }

    public final void e(String str, String str2) {
        t9.i.g(str, "userId");
        t9.i.g(str2, "sn");
        f5385c.setUserId(str);
        f5385c.setSn(str2);
    }

    public final void f(String str, String str2) {
        t9.i.g(str, "userName");
        f5385c.setUserName(str);
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        f5385c.setUserId(str2);
    }
}
