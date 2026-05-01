package com.mobile.brasiltv.utils;

import android.content.Context;
import android.text.TextUtils;
import com.msandroid.mobile.R;

/* loaded from: classes3.dex */
public final class y {

    /* renamed from: a, reason: collision with root package name */
    public static final y f8771a = new y();

    /* renamed from: b, reason: collision with root package name */
    public static final String f8772b = "TIME_OUT";

    /* renamed from: c, reason: collision with root package name */
    public static final String f8773c = "NET_ERROR";

    /* renamed from: d, reason: collision with root package name */
    public static final String f8774d = "live";

    /* renamed from: e, reason: collision with root package name */
    public static final String f8775e = "vod";

    /* renamed from: f, reason: collision with root package name */
    public static final String f8776f = "record";

    /* renamed from: g, reason: collision with root package name */
    public static final String f8777g = "/api/portalCore/v3/snToken";

    /* renamed from: h, reason: collision with root package name */
    public static final String f8778h = "/api/portalCore/v6/active";

    /* renamed from: i, reason: collision with root package name */
    public static final String f8779i = "/api/portalCore/v6/login";

    /* renamed from: j, reason: collision with root package name */
    public static final String f8780j = "/api/portalCore/v5/login/thirdpart";

    /* renamed from: k, reason: collision with root package name */
    public static final String f8781k = "/api/portalCore/v3/getColumnContents";

    /* renamed from: l, reason: collision with root package name */
    public static final String f8782l = "/api/v2/dcs/getAddr";

    /* renamed from: m, reason: collision with root package name */
    public static final String f8783m = "/api/portalCore/v9/startPlayVOD";

    /* renamed from: n, reason: collision with root package name */
    public static final String f8784n = "/api/portalCore/v13_1/getSlbInfo";

    /* renamed from: o, reason: collision with root package name */
    public static final String f8785o = "/api/portalCore/v5/getLiveData";

    /* renamed from: p, reason: collision with root package name */
    public static final String f8786p = "/api/portalCore/getHome";

    /* renamed from: q, reason: collision with root package name */
    public static final String f8787q = "/api/portalCore/v3/getShelveData";

    /* renamed from: r, reason: collision with root package name */
    public static final String f8788r = "/api/portalCore/v3/getRecommends";

    public static /* synthetic */ String p(y yVar, String str, String str2, String str3, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str2 = "";
        }
        if ((i10 & 4) != 0) {
            str3 = "";
        }
        return yVar.o(str, str2, str3);
    }

    public final String a() {
        return f8778h;
    }

    public final String b() {
        return f8781k;
    }

    public final String c(String str) {
        t9.i.g(str, "returnCode");
        String b10 = na.d.b(str);
        if (t9.i.b(b10, "no_report_type")) {
            b10 = na.d.c(str);
        }
        if (t9.i.b(b10, "no_report_type")) {
            b10 = na.d.d(str);
        }
        if (t9.i.b(b10, "no_report_type")) {
            b10 = na.d.e(str);
        }
        if (t9.i.b(b10, "no_report_type")) {
            b10 = na.d.f(str);
        }
        if (t9.i.b(b10, "no_report_type")) {
            b10 = na.d.g(str);
        }
        t9.i.f(b10, "errCode");
        return b10;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterative(DepthRegionTraversal.java:31)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visit(SwitchOverStringVisitor.java:60)
     */
    public final String d(String str) {
        t9.i.g(str, "errorCode");
        Context a10 = a.a();
        int hashCode = str.hashCode();
        switch (hashCode) {
            case -396103086:
                if (str.equals("portal100029")) {
                    return "portal100029-" + a10.getResources().getString(R.string.not_associated);
                }
                return "";
            case 68467:
                if (str.equals("ED2")) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("ED2-");
                    x xVar = x.f8754a;
                    t9.i.f(a10, com.umeng.analytics.pro.f.X);
                    sb.append(xVar.y(a10, R.string.ed2));
                    return sb.toString();
                }
                return "";
            case 68498:
                if (str.equals("EE2")) {
                    return "EE2-" + a10.getResources().getString(R.string.ee2);
                }
                return "";
            case 2119612:
                if (str.equals("EA11")) {
                    return "EA11-" + a10.getResources().getString(R.string.ea11);
                }
                return "";
            case 2119618:
                if (str.equals("EA17")) {
                    return "EA17-" + a10.getResources().getString(R.string.ea17);
                }
                return "";
            default:
                switch (hashCode) {
                    case 68373:
                        if (str.equals("EA1")) {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("EA1-");
                            x xVar2 = x.f8754a;
                            t9.i.f(a10, com.umeng.analytics.pro.f.X);
                            sb2.append(xVar2.y(a10, R.string.login_failed));
                            return sb2.toString();
                        }
                        return "";
                    case 68374:
                        if (str.equals("EA2")) {
                            return "EA2-" + a10.getResources().getString(R.string.ea2);
                        }
                        return "";
                    case 68375:
                        if (str.equals("EA3")) {
                            return "EA3-" + a10.getResources().getString(R.string.not_use_area);
                        }
                        return "";
                    case 68376:
                        if (str.equals("EA4")) {
                            return "EA4-" + a10.getResources().getString(R.string.not_use_area);
                        }
                        return "";
                    case 68377:
                        if (str.equals("EA5")) {
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append("EA5-");
                            x xVar3 = x.f8754a;
                            t9.i.f(a10, com.umeng.analytics.pro.f.X);
                            sb3.append(xVar3.y(a10, R.string.login_failed));
                            return sb3.toString();
                        }
                        return "";
                    case 68378:
                        if (str.equals("EA6")) {
                            StringBuilder sb4 = new StringBuilder();
                            sb4.append("EA6-");
                            x xVar4 = x.f8754a;
                            t9.i.f(a10, com.umeng.analytics.pro.f.X);
                            sb4.append(xVar4.y(a10, R.string.system_error));
                            return sb4.toString();
                        }
                        return "";
                    case 68379:
                        if (str.equals("EA7")) {
                            return "EA7-" + a10.getResources().getString(R.string.bad_network);
                        }
                        return "";
                    case 68380:
                        if (str.equals("EA8")) {
                            return "EA8-" + a10.getResources().getString(R.string.no_mac);
                        }
                        return "";
                    case 68381:
                        if (str.equals("EA9")) {
                            return "EA9-" + a10.getResources().getString(R.string.bad_network);
                        }
                        return "";
                    default:
                        switch (hashCode) {
                            case 68404:
                                if (str.equals("EB1")) {
                                    return "EB1-" + a10.getResources().getString(R.string.eb1);
                                }
                                return "";
                            case 68405:
                                if (str.equals("EB2")) {
                                    return "EB2-" + a10.getResources().getString(R.string.no_program_list);
                                }
                                return "";
                            case 68406:
                                if (str.equals("EB3")) {
                                    return "EB3-" + a10.getResources().getString(R.string.no_program_list);
                                }
                                return "";
                            default:
                                switch (hashCode) {
                                    case 68435:
                                        if (str.equals("EC1")) {
                                            return "EC1-" + a10.getResources().getString(R.string.failed_play_exit_retry);
                                        }
                                        return "";
                                    case 68436:
                                        if (str.equals("EC2")) {
                                            StringBuilder sb5 = new StringBuilder();
                                            sb5.append("EC2-");
                                            x xVar5 = x.f8754a;
                                            t9.i.f(a10, com.umeng.analytics.pro.f.X);
                                            sb5.append(xVar5.y(a10, R.string.failed_ec5));
                                            return sb5.toString();
                                        }
                                        return "";
                                    case 68437:
                                        if (str.equals("EC3")) {
                                            return "EC3-" + a10.getResources().getString(R.string.failed_play_exit_retry);
                                        }
                                        return "";
                                    case 68438:
                                        if (str.equals("EC4")) {
                                            x xVar6 = x.f8754a;
                                            t9.i.f(a10, com.umeng.analytics.pro.f.X);
                                            xVar6.y(a10, R.string.failed_ec5);
                                        }
                                        return "";
                                    case 68439:
                                        if (str.equals("EC5")) {
                                            StringBuilder sb6 = new StringBuilder();
                                            sb6.append("EC5-");
                                            x xVar7 = x.f8754a;
                                            t9.i.f(a10, com.umeng.analytics.pro.f.X);
                                            sb6.append(xVar7.y(a10, R.string.failed_ec5));
                                            return sb6.toString();
                                        }
                                        return "";
                                    default:
                                        switch (hashCode) {
                                            case 68528:
                                                if (str.equals("EF1")) {
                                                    String string = a10.getResources().getString(R.string.ef1);
                                                    t9.i.f(string, "context.resources.getString(R.string.ef1)");
                                                    return string;
                                                }
                                                return "";
                                            case 68529:
                                                if (str.equals("EF2")) {
                                                    String string2 = a10.getResources().getString(R.string.ef2);
                                                    t9.i.f(string2, "context.resources.getString(R.string.ef2)");
                                                    return string2;
                                                }
                                                return "";
                                            case 68530:
                                                if (str.equals("EF3")) {
                                                    String string3 = a10.getResources().getString(R.string.ef3);
                                                    t9.i.f(string3, "context.resources.getString(R.string.ef3)");
                                                    return string3;
                                                }
                                                return "";
                                            case 68531:
                                                if (str.equals("EF4")) {
                                                    String string4 = a10.getResources().getString(R.string.ef4);
                                                    t9.i.f(string4, "context.resources.getString(R.string.ef4)");
                                                    return string4;
                                                }
                                                return "";
                                            case 68532:
                                                if (str.equals("EF5")) {
                                                    String string5 = a10.getResources().getString(R.string.ef5);
                                                    t9.i.f(string5, "context.resources.getString(R.string.ef5)");
                                                    return string5;
                                                }
                                                return "";
                                            case 68533:
                                                if (str.equals("EF6")) {
                                                    String string6 = a10.getResources().getString(R.string.ef6);
                                                    t9.i.f(string6, "context.resources.getString(R.string.ef6)");
                                                    return string6;
                                                }
                                                return "";
                                            case 68534:
                                                if (str.equals("EF7")) {
                                                    String string7 = a10.getResources().getString(R.string.ef7);
                                                    t9.i.f(string7, "context.resources.getString(R.string.ef7)");
                                                    return string7;
                                                }
                                                return "";
                                            case 68535:
                                                if (str.equals("EF8")) {
                                                    String string8 = a10.getResources().getString(R.string.ef8);
                                                    t9.i.f(string8, "context.resources.getString(R.string.ef8)");
                                                    return string8;
                                                }
                                                return "";
                                            case 68536:
                                                if (str.equals("EF9")) {
                                                    String string9 = a10.getResources().getString(R.string.ef9);
                                                    t9.i.f(string9, "context.resources.getString(R.string.ef9)");
                                                    return string9;
                                                }
                                                return "";
                                            default:
                                                switch (hashCode) {
                                                    case 2124416:
                                                        if (str.equals("EF10")) {
                                                            String string10 = a10.getResources().getString(R.string.ef10);
                                                            t9.i.f(string10, "context.resources.getString(R.string.ef10)");
                                                            return string10;
                                                        }
                                                        return "";
                                                    case 2124417:
                                                        if (str.equals("EF11")) {
                                                            String string11 = a10.getResources().getString(R.string.pwd_wrong);
                                                            t9.i.f(string11, "context.resources.getString(R.string.pwd_wrong)");
                                                            return string11;
                                                        }
                                                        return "";
                                                    case 2124418:
                                                        if (str.equals("EF12")) {
                                                            String string12 = a10.getResources().getString(R.string.ef1);
                                                            t9.i.f(string12, "context.resources.getString(R.string.ef1)");
                                                            return string12;
                                                        }
                                                        return "";
                                                    case 2124419:
                                                        if (str.equals("EF13")) {
                                                            String string13 = a10.getResources().getString(R.string.ef13);
                                                            t9.i.f(string13, "context.resources.getString(R.string.ef13)");
                                                            return string13;
                                                        }
                                                        return "";
                                                    default:
                                                        switch (hashCode) {
                                                            case 2124422:
                                                                if (str.equals("EF16")) {
                                                                    String string14 = a10.getResources().getString(R.string.ef16);
                                                                    t9.i.f(string14, "context.resources.getString(R.string.ef16)");
                                                                    return string14;
                                                                }
                                                                return "";
                                                            case 2124423:
                                                                if (str.equals("EF17")) {
                                                                    String string15 = a10.getResources().getString(R.string.sms_limit);
                                                                    t9.i.f(string15, "context.resources.getString(R.string.sms_limit)");
                                                                    return string15;
                                                                }
                                                                return "";
                                                            case 2124424:
                                                                if (str.equals("EF18")) {
                                                                    String string16 = a10.getResources().getString(R.string.phone_been_bound);
                                                                    t9.i.f(string16, "context.resources.getStr….string.phone_been_bound)");
                                                                    return string16;
                                                                }
                                                                return "";
                                                            case 2124425:
                                                                if (str.equals("EF19")) {
                                                                    String string17 = a10.getResources().getString(R.string.verification_invalid);
                                                                    t9.i.f(string17, "context.resources.getStr…ing.verification_invalid)");
                                                                    return string17;
                                                                }
                                                                return "";
                                                            default:
                                                                switch (hashCode) {
                                                                    case 2124447:
                                                                        if (str.equals("EF20")) {
                                                                            String string18 = a10.getResources().getString(R.string.sms_send_and_retry);
                                                                            t9.i.f(string18, "context.resources.getStr…tring.sms_send_and_retry)");
                                                                            return string18;
                                                                        }
                                                                        return "";
                                                                    case 2124448:
                                                                        if (str.equals("EF21")) {
                                                                            String string19 = a10.getResources().getString(R.string.scan_qr_expired);
                                                                            t9.i.f(string19, "context.resources.getStr…R.string.scan_qr_expired)");
                                                                            return string19;
                                                                        }
                                                                        return "";
                                                                    default:
                                                                        switch (hashCode) {
                                                                            case 3103679:
                                                                                if (str.equals("ea14")) {
                                                                                    return "ea14-" + a10.getResources().getString(R.string.ea14);
                                                                                }
                                                                                return "";
                                                                            case 3103680:
                                                                                if (str.equals("ea15")) {
                                                                                    return "ea15-" + a10.getResources().getString(R.string.ea15);
                                                                                }
                                                                                return "";
                                                                            default:
                                                                                return "";
                                                                        }
                                                                }
                                                        }
                                                }
                                        }
                                }
                        }
                }
        }
    }

    public final String e() {
        return f8786p;
    }

    public final String f() {
        return f8785o;
    }

    public final String g() {
        return f8788r;
    }

    public final String h() {
        return f8774d;
    }

    public final String i() {
        return f8779i;
    }

    public final String j() {
        return f8780j;
    }

    public final String k() {
        return f8787q;
    }

    public final String l() {
        return f8777g;
    }

    public final String m() {
        return f8783m;
    }

    public final String n() {
        return f8775e;
    }

    public final String o(String str, String str2, String str3) {
        t9.i.g(str, "errorCode");
        t9.i.g(str2, "uri");
        t9.i.g(str3, "ecCode");
        String c10 = c(str);
        if (TextUtils.isEmpty(str3) || t9.i.b(str3, "no_report_type")) {
            str3 = c10;
        }
        if (!TextUtils.isEmpty(str2)) {
            c2.d dVar = c2.d.f5311a;
            String str4 = na.e.f17342b;
            t9.i.f(str4, "dcsMark");
            dVar.g("", "", str4, "", "", str3, str, str2);
        }
        return d(str3);
    }
}
