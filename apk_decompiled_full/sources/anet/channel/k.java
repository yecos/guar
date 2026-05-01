package anet.channel;

import anet.channel.util.HttpConstant;
import java.util.Map;

/* loaded from: classes.dex */
class k implements n1.c {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ j f4004a;

    public k(j jVar) {
        this.f4004a = jVar;
    }

    public boolean handleCache(String str, Map<String, String> map) {
        return "weex".equals(map.get(HttpConstant.F_REFER));
    }
}
