package anet.channel.session;

import android.content.Context;
import anet.channel.AwcnConfig;
import anet.channel.RequestCb;
import anet.channel.Session;
import anet.channel.entity.ConnType;
import anet.channel.request.Cancelable;
import anet.channel.request.Request;
import anet.channel.statist.RequestStatistic;
import anet.channel.strategy.IConnStrategy;
import anet.channel.thread.ThreadPoolExecutorFactory;
import anet.channel.util.ALog;
import anet.channel.util.ErrorConstant;
import anet.channel.util.Utils;
import com.taobao.accs.common.Constants;
import javax.net.ssl.SSLSocketFactory;

/* loaded from: classes.dex */
public class d extends Session {

    /* renamed from: w, reason: collision with root package name */
    private SSLSocketFactory f4107w;

    public d(Context context, anet.channel.entity.a aVar) {
        super(context, aVar);
        if (this.f3822k == null) {
            String str = this.f3814c;
            this.f3821j = (str == null || !str.startsWith("https")) ? ConnType.HTTP : ConnType.HTTPS;
        } else if (AwcnConfig.isHttpsSniEnable() && this.f3821j.equals(ConnType.HTTPS)) {
            this.f4107w = new anet.channel.util.j(this.f3815d);
        }
    }

    @Override // anet.channel.Session
    public void close() {
        notifyStatus(6, null);
    }

    @Override // anet.channel.Session
    public void connect() {
        try {
            IConnStrategy iConnStrategy = this.f3822k;
            if (iConnStrategy != null && iConnStrategy.getIpSource() == 1) {
                notifyStatus(4, new anet.channel.entity.b(1));
                return;
            }
            Request.Builder redirectEnable = new Request.Builder().setUrl(this.f3814c).setSeq(this.f3827p).setConnectTimeout((int) (this.f3829r * Utils.getNetworkTimeFactor())).setReadTimeout((int) (this.f3830s * Utils.getNetworkTimeFactor())).setRedirectEnable(false);
            SSLSocketFactory sSLSocketFactory = this.f4107w;
            if (sSLSocketFactory != null) {
                redirectEnable.setSslSocketFactory(sSLSocketFactory);
            }
            if (this.f3824m) {
                redirectEnable.addHeader("Host", this.f3816e);
            }
            if (anet.channel.util.c.a() && anet.channel.strategy.utils.d.a(this.f3816e)) {
                try {
                    this.f3817f = anet.channel.util.c.a(this.f3816e);
                } catch (Exception unused) {
                }
            }
            ALog.i("awcn.HttpSession", "HttpSession connect", null, Constants.KEY_HOST, this.f3814c, "ip", this.f3817f, "port", Integer.valueOf(this.f3818g));
            Request build = redirectEnable.build();
            build.setDnsOptimize(this.f3817f, this.f3818g);
            ThreadPoolExecutorFactory.submitPriorityTask(new e(this, build), ThreadPoolExecutorFactory.Priority.LOW);
        } catch (Throwable th) {
            ALog.e("awcn.HttpSession", "HTTP connect fail.", null, th, new Object[0]);
        }
    }

    @Override // anet.channel.Session
    public Runnable getRecvTimeOutRunnable() {
        return null;
    }

    @Override // anet.channel.Session
    public boolean isAvailable() {
        return this.f3825n == 4;
    }

    @Override // anet.channel.Session
    public Cancelable request(Request request, RequestCb requestCb) {
        anet.channel.request.b bVar = anet.channel.request.b.NULL;
        Request.Builder builder = null;
        RequestStatistic requestStatistic = request != null ? request.f4045a : new RequestStatistic(this.f3815d, null);
        requestStatistic.setConnType(this.f3821j);
        if (requestStatistic.start == 0) {
            long currentTimeMillis = System.currentTimeMillis();
            requestStatistic.reqStart = currentTimeMillis;
            requestStatistic.start = currentTimeMillis;
        }
        if (request == null || requestCb == null) {
            if (requestCb != null) {
                requestCb.onFinish(-102, ErrorConstant.getErrMsg(-102), requestStatistic);
            }
            return bVar;
        }
        try {
            if (request.getSslSocketFactory() == null && this.f4107w != null) {
                builder = request.newBuilder().setSslSocketFactory(this.f4107w);
            }
            if (this.f3824m) {
                if (builder == null) {
                    builder = request.newBuilder();
                }
                builder.addHeader("Host", this.f3816e);
            }
            if (builder != null) {
                request = builder.build();
            }
            if (this.f3817f == null) {
                String host = request.getHttpUrl().host();
                if (anet.channel.util.c.a() && anet.channel.strategy.utils.d.a(host)) {
                    try {
                        this.f3817f = anet.channel.util.c.a(host);
                    } catch (Exception unused) {
                    }
                }
            }
            request.setDnsOptimize(this.f3817f, this.f3818g);
            request.setUrlScheme(this.f3821j.isSSL());
            IConnStrategy iConnStrategy = this.f3822k;
            if (iConnStrategy != null) {
                request.f4045a.setIpInfo(iConnStrategy.getIpSource(), this.f3822k.getIpType());
            } else {
                request.f4045a.setIpInfo(1, 1);
            }
            request.f4045a.unit = this.f3823l;
            return new anet.channel.request.b(ThreadPoolExecutorFactory.submitPriorityTask(new f(this, request, requestCb, requestStatistic), anet.channel.util.h.a(request)), request.getSeq());
        } catch (Throwable th) {
            requestCb.onFinish(-101, ErrorConstant.formatMsg(-101, th.toString()), requestStatistic);
            return bVar;
        }
    }

    @Override // anet.channel.Session
    public void close(boolean z10) {
        this.f3831t = false;
        close();
    }
}
