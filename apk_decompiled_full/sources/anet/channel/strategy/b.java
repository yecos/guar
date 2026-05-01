package anet.channel.strategy;

import android.text.TextUtils;
import anet.channel.entity.ConnType;
import anet.channel.util.ALog;
import com.taobao.accs.common.Constants;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.LinkedList;

/* loaded from: classes.dex */
class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f4177a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ a f4178b;

    public b(a aVar, String str) {
        this.f4178b = aVar;
        this.f4177a = str;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x004a A[Catch: Exception -> 0x0022, TryCatch #2 {Exception -> 0x0022, blocks: (B:3:0x000a, B:5:0x0014, B:6:0x0036, B:8:0x003c, B:9:0x0044, B:11:0x004a, B:13:0x005b, B:16:0x006c, B:17:0x0095, B:19:0x00c4, B:24:0x007b, B:25:0x00e2, B:26:0x00e9, B:29:0x0027), top: B:2:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00e2 A[Catch: Exception -> 0x0022, TryCatch #2 {Exception -> 0x0022, blocks: (B:3:0x000a, B:5:0x0014, B:6:0x0036, B:8:0x003c, B:9:0x0044, B:11:0x004a, B:13:0x005b, B:16:0x006c, B:17:0x0095, B:19:0x00c4, B:24:0x007b, B:25:0x00e2, B:26:0x00e9, B:29:0x0027), top: B:2:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x003c A[Catch: Exception -> 0x0022, TryCatch #2 {Exception -> 0x0022, blocks: (B:3:0x000a, B:5:0x0014, B:6:0x0036, B:8:0x003c, B:9:0x0044, B:11:0x004a, B:13:0x005b, B:16:0x006c, B:17:0x0095, B:19:0x00c4, B:24:0x007b, B:25:0x00e2, B:26:0x00e9, B:29:0x0027), top: B:2:0x000a }] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        String str;
        try {
            try {
                str = InetAddress.getByName(this.f4177a).getHostAddress();
                try {
                    ALog.i("awcn.LocalDnsStrategy", "localDns", null, this.f4177a, str);
                } catch (UnknownHostException e10) {
                    e = e10;
                    ALog.e("awcn.LocalDnsStrategy", "localDns", null, this.f4177a, e.getMessage());
                    if (TextUtils.isEmpty(str)) {
                    }
                    if (!TextUtils.isEmpty(str)) {
                    }
                }
            } catch (UnknownHostException e11) {
                e = e11;
                str = null;
            }
            if (TextUtils.isEmpty(str)) {
                str = anet.channel.strategy.utils.c.a("174658", this.f4177a);
            }
            if (!TextUtils.isEmpty(str)) {
                throw new UnknownHostException(this.f4177a);
            }
            LinkedList linkedList = new LinkedList();
            ConnProtocol connProtocol = StrategyTemplate.getInstance().getConnProtocol(this.f4177a);
            if (connProtocol != null) {
                linkedList.add(IPConnStrategy.a(str, !this.f4178b.a(connProtocol) ? 80 : Constants.PORT, connProtocol, 0, 0, 1, 45000));
            } else {
                linkedList.add(IPConnStrategy.a(str, Constants.PORT, ConnProtocol.valueOf(ConnType.HTTP2, ConnType.RTT_0, ConnType.PK_OPEN), 0, 0, 1, 45000));
            }
            linkedList.add(IPConnStrategy.a(str, Constants.PORT, ConnProtocol.HTTPS, 0, 0, 0, 0));
            linkedList.add(IPConnStrategy.a(str, 80, ConnProtocol.HTTP, 0, 0, 0, 0));
            this.f4178b.f4176a.put(this.f4177a, linkedList);
            if (ALog.isPrintLog(1)) {
                ALog.d("awcn.LocalDnsStrategy", "resolve ip by local dns", null, Constants.KEY_HOST, this.f4177a, "ip", str, "list", linkedList);
            }
        } catch (Exception unused) {
            if (ALog.isPrintLog(1)) {
                ALog.d("awcn.LocalDnsStrategy", "resolve ip by local dns failed", null, Constants.KEY_HOST, this.f4177a);
            }
        }
    }
}
