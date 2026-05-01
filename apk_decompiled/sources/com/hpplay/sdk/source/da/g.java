package com.hpplay.sdk.source.da;

import android.content.Context;
import android.text.TextUtils;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.hpplay.common.asyncmanager.AsyncHttpParameter;
import com.hpplay.common.asyncmanager.AsyncHttpRequestListener;
import com.hpplay.common.asyncmanager.AsyncManager;
import com.hpplay.common.datareport.ReportBean;
import com.hpplay.common.utils.DeviceUtil;
import com.hpplay.common.utils.NetworkUtil;
import com.hpplay.component.common.ParamsMap;
import com.hpplay.component.protocol.ProtocolBuilder;
import com.hpplay.sdk.source.bean.OutParameter;
import com.hpplay.sdk.source.browse.api.LelinkServiceInfo;
import com.hpplay.sdk.source.business.cloud.CloudAPI;
import com.hpplay.sdk.source.business.cloud.SourceDataReport;
import com.hpplay.sdk.source.common.utils.HapplayUtils;
import com.hpplay.sdk.source.log.SourceLog;
import com.hpplay.sdk.source.utils.AppContextUtils;
import com.hpplay.sdk.source.utils.LeboUtil;
import com.umeng.analytics.pro.bd;
import com.umeng.analytics.pro.bt;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    private static final String f7657a = "DaReport";

    /* renamed from: b, reason: collision with root package name */
    private static final String f7658b = "__IP__";

    /* renamed from: c, reason: collision with root package name */
    private static final String f7659c = "__DURATION__";

    /* renamed from: d, reason: collision with root package name */
    private static g f7660d;

    /* renamed from: e, reason: collision with root package name */
    private String f7661e;

    private g() {
    }

    public static synchronized g a() {
        g gVar;
        synchronized (g.class) {
            if (f7660d == null) {
                f7660d = new g();
            }
            gVar = f7660d;
        }
        return gVar;
    }

    public void b(OutParameter outParameter, String str, String str2, int i10, boolean z10, String str3) {
        if (outParameter == null) {
            SourceLog.w(f7657a, "onDaStart empty playInfo");
            return;
        }
        Map<String, String> a10 = a("100", outParameter, str, str2, i10, z10, str3);
        SourceLog.i(f7657a, "onDaStart");
        a(CloudAPI.sReportDa, a10);
    }

    public void c(OutParameter outParameter, String str, String str2, int i10, boolean z10, String str3) {
        if (outParameter == null) {
            SourceLog.w(f7657a, "onDaEnd empty playInfo");
            return;
        }
        Map<String, String> a10 = a(ParamsMap.PushParams.MEDIA_TYPE_VIDEO, outParameter, str, str2, i10, z10, str3);
        SourceLog.i(f7657a, "onDaEnd");
        a(CloudAPI.sReportDa, a10);
    }

    public void a(OutParameter outParameter, String str, String str2, int i10, boolean z10, String str3) {
        if (outParameter == null) {
            SourceLog.w(f7657a, "onDaRequestComplete empty playInfo");
            return;
        }
        this.f7661e = outParameter.urlID;
        Map<String, String> a10 = a("3", outParameter, str, str2, i10, z10, str3);
        SourceLog.i(f7657a, "onDaRequestComplete");
        a(CloudAPI.sReportDa, a10);
    }

    public static void b() {
        f7660d = null;
    }

    public void a(Context context, String str, boolean z10, int i10, int i11) {
        if (TextUtils.isEmpty(str)) {
            SourceLog.w(f7657a, "thirdReport ignore,reason: url is empty");
            return;
        }
        String a10 = a(f7658b, DeviceUtil.getIPAddress(context), str);
        if (z10) {
            SourceLog.i(f7657a, "thirdReport duration: " + i10);
            a10 = a(f7659c, i10 + "", a10);
        }
        SourceLog.debug(f7657a, "thirdReport url: " + a10);
        AsyncHttpParameter asyncHttpParameter = new AsyncHttpParameter(a10, null);
        asyncHttpParameter.in.tryCount = 1;
        if (i11 == 0) {
            HashMap hashMap = new HashMap();
            hashMap.put("User-Agent", "");
            asyncHttpParameter.in.requestHeaders = hashMap;
        }
        AsyncManager.getInstance().exeHttpTask(asyncHttpParameter, new AsyncHttpRequestListener() { // from class: com.hpplay.sdk.source.da.g.1
            @Override // com.hpplay.common.asyncmanager.AsyncHttpRequestListener
            public void onRequestResult(AsyncHttpParameter asyncHttpParameter2) {
                if (asyncHttpParameter2.out.resultType == 0) {
                    SourceLog.debug(g.f7657a, "thirdReport success");
                } else {
                    SourceLog.debug(g.f7657a, "thirdReport fail");
                }
            }
        });
    }

    private String a(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str3) && str2 != null && !TextUtils.equals(str, str2)) {
            while (str3.contains(str)) {
                str3 = str3.replace(str, str2);
            }
        }
        return str3;
    }

    private Map<String, String> a(String str, OutParameter outParameter, String str2, String str3, int i10, boolean z10, String str4) {
        HashMap hashMap = new HashMap();
        hashMap.put("st", ProtocolBuilder.LELINK_STATE_SUCCESS);
        hashMap.put("sn", str);
        hashMap.put("s", outParameter.session);
        hashMap.put("uri", this.f7661e);
        hashMap.put("amid", String.valueOf(i10));
        hashMap.put(bt.aD, String.valueOf(SourceDataReport.getInstance().getProtocol(outParameter)));
        hashMap.put("ads", str2);
        String upperCase = NetworkUtil.getWifiBSSIDNoneColon(AppContextUtils.getInstance().getAppContext()).toUpperCase();
        if (!TextUtils.isEmpty(upperCase)) {
            hashMap.put("bssdc", LeboUtil.anonymizeByMD5(upperCase));
            hashMap.put("bssds", LeboUtil.anonymizeBySHA256(upperCase));
        }
        hashMap.put("adpos", str3);
        hashMap.put("apv", "1.1");
        hashMap.put(bd.f9997x, z10 ? "1" : "0");
        if (!z10) {
            hashMap.put("ec", str4);
        }
        LelinkServiceInfo lelinkServiceInfo = outParameter.serviceInfo;
        if (lelinkServiceInfo != null) {
            int i11 = outParameter.protocol;
            if (i11 == 5 || i11 == 1) {
                hashMap.put("rud", lelinkServiceInfo.getUid());
                hashMap.put("rsc", String.valueOf(outParameter.serviceInfo.getAppId()));
            } else if (i11 == 3) {
                hashMap.put("udn", lelinkServiceInfo.getUdnUuid());
            }
        }
        hashMap.put("lt", String.valueOf(System.currentTimeMillis()));
        return hashMap;
    }

    private void a(String str, Map<String, String> map) {
        ReportBean reportBean = new ReportBean();
        reportBean.httpParameter = new AsyncHttpParameter(str, SourceDataReport.getInstance().getPreParameter() + DispatchConstants.SIGN_SPLIT_SYMBOL + HapplayUtils.getMapParams(map));
        SourceDataReport.getInstance().addTask(reportBean);
    }
}
