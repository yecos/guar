package anet.channel.fulltrace;

import anet.channel.statist.RequestStatistic;
import anet.channel.util.ALog;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static volatile IFullTraceAnalysis f3978a = new C0065a(null);

    /* renamed from: b, reason: collision with root package name */
    private static boolean f3979b = false;

    /* renamed from: anet.channel.fulltrace.a$a, reason: collision with other inner class name */
    public static class C0065a implements IFullTraceAnalysis {

        /* renamed from: a, reason: collision with root package name */
        private IFullTraceAnalysis f3980a;

        public C0065a(IFullTraceAnalysis iFullTraceAnalysis) {
            this.f3980a = iFullTraceAnalysis;
            boolean unused = a.f3979b = true;
        }

        @Override // anet.channel.fulltrace.IFullTraceAnalysis
        public void commitRequest(String str, RequestStatistic requestStatistic) {
            IFullTraceAnalysis iFullTraceAnalysis;
            if (a.f3979b && (iFullTraceAnalysis = this.f3980a) != null) {
                try {
                    iFullTraceAnalysis.commitRequest(str, requestStatistic);
                } catch (Throwable th) {
                    boolean unused = a.f3979b = false;
                    ALog.e("anet.AnalysisFactory", "fulltrace commit fail.", null, th, new Object[0]);
                }
            }
        }

        @Override // anet.channel.fulltrace.IFullTraceAnalysis
        public String createRequest() {
            IFullTraceAnalysis iFullTraceAnalysis;
            if (!a.f3979b || (iFullTraceAnalysis = this.f3980a) == null) {
                return null;
            }
            try {
                return iFullTraceAnalysis.createRequest();
            } catch (Throwable th) {
                boolean unused = a.f3979b = false;
                ALog.e("anet.AnalysisFactory", "createRequest fail.", null, th, new Object[0]);
                return null;
            }
        }

        @Override // anet.channel.fulltrace.IFullTraceAnalysis
        public b getSceneInfo() {
            IFullTraceAnalysis iFullTraceAnalysis;
            if (!a.f3979b || (iFullTraceAnalysis = this.f3980a) == null) {
                return null;
            }
            try {
                return iFullTraceAnalysis.getSceneInfo();
            } catch (Throwable th) {
                boolean unused = a.f3979b = false;
                ALog.e("anet.AnalysisFactory", "getSceneInfo fail", null, th, new Object[0]);
                return null;
            }
        }
    }

    public static IFullTraceAnalysis a() {
        return f3978a;
    }

    public static void a(IFullTraceAnalysis iFullTraceAnalysis) {
        f3978a = new C0065a(iFullTraceAnalysis);
    }
}
