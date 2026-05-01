package anet.channel;

import anet.channel.security.ISecurity;
import anet.channel.strategy.dispatch.IAmdcSign;

/* loaded from: classes.dex */
class d implements IAmdcSign {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f3899a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ ISecurity f3900b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ SessionCenter f3901c;

    public d(SessionCenter sessionCenter, String str, ISecurity iSecurity) {
        this.f3901c = sessionCenter;
        this.f3899a = str;
        this.f3900b = iSecurity;
    }

    @Override // anet.channel.strategy.dispatch.IAmdcSign
    public String getAppkey() {
        return this.f3899a;
    }

    @Override // anet.channel.strategy.dispatch.IAmdcSign
    public String sign(String str) {
        return this.f3900b.sign(this.f3901c.f3840b, ISecurity.SIGN_ALGORITHM_HMAC_SHA1, getAppkey(), str);
    }

    @Override // anet.channel.strategy.dispatch.IAmdcSign
    public boolean useSecurityGuard() {
        return !this.f3900b.isSecOff();
    }
}
