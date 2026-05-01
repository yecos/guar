package s5;

import java.util.HashMap;
import t5.f;
import t5.k;
import t5.o;
import t9.i;

/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f18751a;

    public a() {
        HashMap hashMap = new HashMap();
        this.f18751a = hashMap;
        hashMap.put(c.QR, new k());
        hashMap.put(c.QUICK_LOGIN, new f());
        hashMap.put(c.THIRD_PART_LOGIN, new o());
    }

    public final void a(u8.a aVar, e eVar, b bVar) {
        i.g(aVar, "activity");
        i.g(eVar, "loginInfo");
        i.g(bVar, "callback");
        if (eVar.c() == null) {
            return;
        }
        t5.b bVar2 = new t5.b();
        t5.a aVar2 = (t5.a) this.f18751a.get(eVar.c());
        if (aVar2 != null) {
            aVar2.d(bVar);
        }
        t5.a aVar3 = (t5.a) this.f18751a.get(eVar.c());
        if (aVar3 != null) {
            aVar3.b(bVar2);
        }
        t5.a aVar4 = (t5.a) this.f18751a.get(eVar.c());
        if (aVar4 != null) {
            aVar4.a(aVar, eVar);
        }
    }
}
