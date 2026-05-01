package anet.channel.strategy.utils;

import android.content.Context;
import anet.channel.GlobalAppRuntimeInfo;
import anet.channel.util.ALog;
import com.alibaba.sdk.android.httpdns.HttpDns;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public class c {
    public static String a(String str, String str2) {
        String str3;
        String str4;
        try {
            Context context = GlobalAppRuntimeInfo.getContext();
            int i10 = HttpDns.f5837a;
            Object invoke = HttpDns.class.getMethod("getService", Context.class, String.class).invoke(null, context, str);
            Class cls = Boolean.TYPE;
            Method method = HttpDns.class.getMethod("setExpiredIPEnabled", cls);
            Boolean bool = Boolean.TRUE;
            method.invoke(invoke, bool);
            HttpDns.class.getMethod("setHTTPSRequestEnabled", cls).invoke(invoke, bool);
            Method method2 = HttpDns.class.getMethod("getIpByHostAsync", String.class);
            str3 = null;
            int i11 = 0;
            while (true) {
                try {
                    str4 = (String) method2.invoke(invoke, str2);
                    if (str4 != null) {
                        break;
                    }
                    try {
                        Thread.sleep(100L);
                        i11++;
                        if (i11 >= 5) {
                            break;
                        }
                        str3 = str4;
                    } catch (Throwable th) {
                        th = th;
                        str3 = str4;
                        try {
                            ALog.i("awcn.LocalDnsStrategy", "httpDns", null, str2, th.getMessage());
                            ALog.i("awcn.LocalDnsStrategy", "httpDns", null, str2, str3);
                            return str3;
                        } catch (Throwable th2) {
                            ALog.i("awcn.LocalDnsStrategy", "httpDns", null, str2, str3);
                            throw th2;
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            }
            ALog.i("awcn.LocalDnsStrategy", "httpDns", null, str2, str4);
            return str4;
        } catch (Throwable th4) {
            th = th4;
            str3 = null;
        }
    }
}
