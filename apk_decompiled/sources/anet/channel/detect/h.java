package anet.channel.detect;

import anet.channel.Session;
import anet.channel.entity.EventCb;
import anet.channel.request.Request;
import anet.channel.session.TnetSpdySession;
import anet.channel.statist.HorseRaceStat;
import anet.channel.strategy.l;
import anet.channel.util.ALog;
import anet.channel.util.HttpUrl;

/* loaded from: classes.dex */
class h implements EventCb {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ HorseRaceStat f3925a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ long f3926b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ String f3927c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ l.e f3928d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ TnetSpdySession f3929e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ d f3930f;

    public h(d dVar, HorseRaceStat horseRaceStat, long j10, String str, l.e eVar, TnetSpdySession tnetSpdySession) {
        this.f3930f = dVar;
        this.f3925a = horseRaceStat;
        this.f3926b = j10;
        this.f3927c = str;
        this.f3928d = eVar;
        this.f3929e = tnetSpdySession;
    }

    @Override // anet.channel.entity.EventCb
    public void onEvent(Session session, int i10, anet.channel.entity.b bVar) {
        if (this.f3925a.connTime != 0) {
            return;
        }
        this.f3925a.connTime = System.currentTimeMillis() - this.f3926b;
        if (i10 != 1) {
            this.f3925a.connErrorCode = bVar.f3970b;
            synchronized (this.f3925a) {
                this.f3925a.notify();
            }
            return;
        }
        ALog.i("anet.HorseRaceDetector", "tnetSpdySession connect success", this.f3927c, new Object[0]);
        this.f3925a.connRet = 1;
        HttpUrl parse = HttpUrl.parse(session.getHost() + this.f3928d.f4246c);
        if (parse == null) {
            return;
        }
        this.f3929e.request(new Request.Builder().setUrl(parse).setReadTimeout(this.f3928d.f4245b.f4217d).setRedirectEnable(false).setSeq(this.f3927c).build(), new i(this));
    }
}
