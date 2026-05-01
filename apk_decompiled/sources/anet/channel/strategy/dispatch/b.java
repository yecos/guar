package anet.channel.strategy.dispatch;

import android.util.Base64InputStream;
import anet.channel.GlobalAppRuntimeInfo;
import anet.channel.appmonitor.AppMonitor;
import anet.channel.flow.FlowStat;
import anet.channel.flow.NetworkAnalysis;
import anet.channel.statist.AmdcStatistic;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.strategy.ConnEvent;
import anet.channel.strategy.IConnStrategy;
import anet.channel.strategy.StrategyCenter;
import anet.channel.util.ALog;
import anet.channel.util.HttpConstant;
import com.hpplay.cybergarage.soap.SOAP;
import com.hpplay.cybergarage.xml.XML;
import com.taobao.accs.common.Constants;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.HostnameVerifier;

/* loaded from: classes.dex */
class b {

    /* renamed from: a, reason: collision with root package name */
    static AtomicInteger f4195a = new AtomicInteger(0);

    /* renamed from: b, reason: collision with root package name */
    static HostnameVerifier f4196b = new c();

    /* renamed from: c, reason: collision with root package name */
    static Random f4197c = new Random();

    public static List<IConnStrategy> a(String str) {
        List<IConnStrategy> list = Collections.EMPTY_LIST;
        if (!NetworkStatusHelper.isProxy()) {
            list = StrategyCenter.getInstance().getConnStrategyListByHost(DispatchConstants.getAmdcServerDomain());
            ListIterator<IConnStrategy> listIterator = list.listIterator();
            while (listIterator.hasNext()) {
                if (!listIterator.next().getProtocol().protocol.equalsIgnoreCase(str)) {
                    listIterator.remove();
                }
            }
        }
        return list;
    }

    public static void a(Map map) {
        String a10;
        IConnStrategy iConnStrategy;
        String str;
        if (map == null) {
            return;
        }
        String schemeByHost = AmdcRuntimeInfo.isForceHttps() ? "https" : StrategyCenter.getInstance().getSchemeByHost(DispatchConstants.getAmdcServerDomain(), HttpConstant.HTTP);
        List<IConnStrategy> a11 = a(schemeByHost);
        for (int i10 = 0; i10 < 3; i10++) {
            HashMap hashMap = new HashMap(map);
            if (i10 != 2) {
                iConnStrategy = !a11.isEmpty() ? a11.remove(0) : null;
                if (iConnStrategy != null) {
                    str = a(schemeByHost, iConnStrategy.getIp(), iConnStrategy.getPort(), hashMap, i10);
                } else {
                    str = a(schemeByHost, (String) null, 0, hashMap, i10);
                }
            } else {
                String[] amdcServerFixIp = DispatchConstants.getAmdcServerFixIp();
                if (amdcServerFixIp != null && amdcServerFixIp.length > 0) {
                    a10 = a(schemeByHost, amdcServerFixIp[f4197c.nextInt(amdcServerFixIp.length)], 0, hashMap, i10);
                } else {
                    a10 = a(schemeByHost, (String) null, 0, hashMap, i10);
                }
                String str2 = a10;
                iConnStrategy = null;
                str = str2;
            }
            int a12 = a(str, hashMap, i10);
            if (iConnStrategy != null) {
                ConnEvent connEvent = new ConnEvent();
                connEvent.isSuccess = a12 == 0;
                StrategyCenter.getInstance().notifyConnEvent(DispatchConstants.getAmdcServerDomain(), iConnStrategy, connEvent);
            }
            if (a12 == 0 || a12 == 2) {
                return;
            }
        }
    }

    private static String a(String str, String str2, int i10, Map<String, String> map, int i11) {
        StringBuilder sb = new StringBuilder(64);
        if (!AmdcRuntimeInfo.isForceHttps() && i11 == 2 && "https".equalsIgnoreCase(str) && f4197c.nextBoolean()) {
            str = HttpConstant.HTTP;
        }
        sb.append(str);
        sb.append(HttpConstant.SCHEME_SPLIT);
        if (str2 != null) {
            if (anet.channel.util.c.a() && anet.channel.strategy.utils.d.a(str2)) {
                try {
                    str2 = anet.channel.util.c.a(str2);
                } catch (Exception unused) {
                }
            }
            if (anet.channel.strategy.utils.d.b(str2)) {
                sb.append('[');
                sb.append(str2);
                sb.append(']');
            } else {
                sb.append(str2);
            }
            if (i10 == 0) {
                i10 = "https".equalsIgnoreCase(str) ? Constants.PORT : 80;
            }
            sb.append(SOAP.DELIM);
            sb.append(i10);
        } else {
            sb.append(DispatchConstants.getAmdcServerDomain());
        }
        sb.append(DispatchConstants.serverPath);
        TreeMap treeMap = new TreeMap();
        treeMap.put("appkey", map.remove("appkey"));
        treeMap.put("v", map.remove("v"));
        treeMap.put(DispatchConstants.PLATFORM, map.remove(DispatchConstants.PLATFORM));
        sb.append('?');
        sb.append(anet.channel.strategy.utils.d.a(treeMap, XML.CHARSET_UTF8));
        return sb.toString();
    }

    /* JADX WARN: Can't wrap try/catch for region: R(7:21|(5:26|27|28|29|30)|35|27|28|29|30) */
    /* JADX WARN: Can't wrap try/catch for region: R(7:38|(5:43|44|45|46|47)|51|44|45|46|47) */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0123, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0124, code lost:
    
        anet.channel.util.ALog.e("awcn.DispatchCore", "http disconnect failed", null, r0, new java.lang.Object[0]);
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0166, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0167, code lost:
    
        anet.channel.util.ALog.e("awcn.DispatchCore", "http disconnect failed", null, r0, new java.lang.Object[0]);
     */
    /* JADX WARN: Removed duplicated region for block: B:122:0x02a5 A[Catch: all -> 0x02e1, TryCatch #0 {all -> 0x02e1, blocks: (B:120:0x029b, B:122:0x02a5, B:123:0x02a9, B:126:0x02b1, B:128:0x02b5, B:130:0x02b9, B:132:0x02bd, B:133:0x02c7, B:142:0x02c3), top: B:119:0x029b }] */
    /* JADX WARN: Removed duplicated region for block: B:126:0x02b1 A[Catch: all -> 0x02e1, TRY_ENTER, TryCatch #0 {all -> 0x02e1, blocks: (B:120:0x029b, B:122:0x02a5, B:123:0x02a9, B:126:0x02b1, B:128:0x02b5, B:130:0x02b9, B:132:0x02bd, B:133:0x02c7, B:142:0x02c3), top: B:119:0x029b }] */
    /* JADX WARN: Removed duplicated region for block: B:136:0x02d3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int a(java.lang.String r18, java.util.Map r19, int r20) {
        /*
            Method dump skipped, instructions count: 755
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: anet.channel.strategy.dispatch.b.a(java.lang.String, java.util.Map, int):int");
    }

    public static String a(InputStream inputStream, boolean z10) {
        IOException e10;
        FilterInputStream base64InputStream;
        FilterInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
        try {
            if (z10) {
                try {
                    bufferedInputStream = new GZIPInputStream(bufferedInputStream);
                } catch (IOException e11) {
                    e10 = e11;
                    ALog.e("awcn.DispatchCore", "", null, e10, new Object[0]);
                    try {
                        bufferedInputStream.close();
                    } catch (IOException unused) {
                    }
                    return null;
                }
            }
            base64InputStream = new Base64InputStream(bufferedInputStream, 0);
        } catch (Throwable th) {
            th = th;
        }
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int read = base64InputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
            String str = new String(byteArrayOutputStream.toByteArray(), XML.CHARSET_UTF8);
            try {
                base64InputStream.close();
            } catch (IOException unused2) {
            }
            return str;
        } catch (IOException e12) {
            e10 = e12;
            bufferedInputStream = base64InputStream;
            ALog.e("awcn.DispatchCore", "", null, e10, new Object[0]);
            bufferedInputStream.close();
            return null;
        } catch (Throwable th2) {
            th = th2;
            bufferedInputStream = base64InputStream;
            try {
                bufferedInputStream.close();
            } catch (IOException unused3) {
            }
            throw th;
        }
    }

    public static void a(String str, String str2, URL url, int i10, int i11) {
        if ((i11 != 1 || i10 == 2) && GlobalAppRuntimeInfo.isTargetProcess()) {
            try {
                AmdcStatistic amdcStatistic = new AmdcStatistic();
                amdcStatistic.errorCode = str;
                amdcStatistic.errorMsg = str2;
                if (url != null) {
                    amdcStatistic.host = url.getHost();
                    amdcStatistic.url = url.toString();
                }
                amdcStatistic.retryTimes = i10;
                AppMonitor.getInstance().commitStat(amdcStatistic);
            } catch (Exception unused) {
            }
        }
    }

    public static void a(String str, long j10, long j11) {
        try {
            FlowStat flowStat = new FlowStat();
            flowStat.refer = "amdc";
            flowStat.protocoltype = HttpConstant.HTTP;
            flowStat.req_identifier = str;
            flowStat.upstream = j10;
            flowStat.downstream = j11;
            NetworkAnalysis.getInstance().commitFlow(flowStat);
        } catch (Exception e10) {
            ALog.e("awcn.DispatchCore", "commit flow info failed!", null, e10, new Object[0]);
        }
    }
}
