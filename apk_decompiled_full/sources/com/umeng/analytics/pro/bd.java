package com.umeng.analytics.pro;

import android.text.TextUtils;
import com.umeng.umcrash.UMCrash;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class bd {
    public static final String A = "rtd";
    public static final String B = "lepd";
    public static final String C = "ccfg";
    private static Map<String, String> D = null;
    private static String E = null;

    /* renamed from: a, reason: collision with root package name */
    public static final String f9974a = "env";

    /* renamed from: b, reason: collision with root package name */
    public static final String f9975b = "exp";

    /* renamed from: c, reason: collision with root package name */
    public static final String f9976c = "imp";

    /* renamed from: d, reason: collision with root package name */
    public static final String f9977d = "ua";

    /* renamed from: e, reason: collision with root package name */
    public static final String f9978e = "zc";

    /* renamed from: f, reason: collision with root package name */
    public static final String f9979f = "id";

    /* renamed from: g, reason: collision with root package name */
    public static final String f9980g = "zf";

    /* renamed from: h, reason: collision with root package name */
    public static final String f9981h = "exid";

    /* renamed from: i, reason: collision with root package name */
    public static final String f9982i = "ucc";

    /* renamed from: j, reason: collision with root package name */
    public static final String f9983j = "ugc";

    /* renamed from: k, reason: collision with root package name */
    public static final String f9984k = "usi";

    /* renamed from: l, reason: collision with root package name */
    public static final String f9985l = "uso";

    /* renamed from: m, reason: collision with root package name */
    public static final String f9986m = "user";

    /* renamed from: n, reason: collision with root package name */
    public static final String f9987n = "uspi";

    /* renamed from: o, reason: collision with root package name */
    public static final String f9988o = "dtfn";

    /* renamed from: p, reason: collision with root package name */
    public static final String f9989p = "pr";

    /* renamed from: q, reason: collision with root package name */
    public static final String f9990q = "upg";

    /* renamed from: r, reason: collision with root package name */
    public static final String f9991r = "pri";

    /* renamed from: s, reason: collision with root package name */
    public static final String f9992s = "probe";

    /* renamed from: t, reason: collision with root package name */
    public static final String f9993t = "bl";

    /* renamed from: u, reason: collision with root package name */
    public static final String f9994u = "wl";

    /* renamed from: v, reason: collision with root package name */
    public static final String f9995v = "subp";

    /* renamed from: w, reason: collision with root package name */
    public static final String f9996w = "subua";

    /* renamed from: x, reason: collision with root package name */
    public static final String f9997x = "sta";

    /* renamed from: y, reason: collision with root package name */
    public static final String f9998y = "emi";

    /* renamed from: z, reason: collision with root package name */
    public static final String f9999z = "sli";

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private static final bd f10000a = new bd();

        private a() {
        }
    }

    static {
        HashMap hashMap = new HashMap();
        D = hashMap;
        E = "";
        hashMap.put(f9974a, "envelope");
        D.put("exp", ".umeng");
        D.put(f9976c, ".imprint");
        D.put(f9977d, "ua.db");
        D.put(f9978e, "umeng_zero_cache.db");
        D.put("id", "umeng_it.cache");
        D.put(f9980g, "umeng_zcfg_flag");
        D.put(f9981h, "exid.dat");
        D.put(f9982i, "umeng_common_config");
        D.put(f9983j, "umeng_general_config");
        D.put(f9984k, UMCrash.KEY_CALLBACK_SESSION_ID);
        D.put(f9985l, "umeng_sp_oaid");
        D.put(f9986m, "mobclick_agent_user_");
        D.put(f9987n, "umeng_subprocess_info");
        D.put(f9988o, "delayed_transmission_flag_new");
        D.put("pr", "umeng_policy_result_flag");
        D.put(f9990q, "um_policy_grant");
        D.put(f9991r, "um_pri");
        D.put(f9992s, "UM_PROBE_DATA");
        D.put(f9993t, "ekv_bl");
        D.put(f9994u, "ekv_wl");
        D.put(f9995v, g.f10345a);
        D.put(f9996w, "ua_");
        D.put(f9997x, "stateless");
        D.put(f9998y, ".emitter");
        D.put(f9999z, "um_slmode_sp");
        D.put(A, "um_rtd_conf");
        D.put(B, "");
        D.put(C, ".dmpvedpogjhejs.cfg");
    }

    private bd() {
    }

    public void a(String str) {
        if (!TextUtils.isEmpty(str) && TextUtils.isEmpty(E)) {
            if (str.length() > 3) {
                E = str.substring(0, 3) + "_";
                return;
            }
            E = str + "_";
        }
    }

    public String b(String str) {
        if (!D.containsKey(str)) {
            return "";
        }
        String str2 = D.get(str);
        if (!"exp".equalsIgnoreCase(str) && !f9976c.equalsIgnoreCase(str) && !f9998y.equalsIgnoreCase(str)) {
            return E + str2;
        }
        return "." + E + str2.substring(1);
    }

    public void a() {
        E = "";
    }

    public static bd b() {
        return a.f10000a;
    }
}
