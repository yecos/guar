package a7;

import java.util.List;
import okhttp3.Dns;
import t9.i;

/* loaded from: classes3.dex */
public final class f implements Dns {

    /* renamed from: a, reason: collision with root package name */
    public ja.b f291a = ja.b.f14706f.a();

    @Override // okhttp3.Dns
    public List lookup(String str) {
        i.g(str, "hostname");
        return this.f291a.lookup(str);
    }
}
