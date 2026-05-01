package ja;

import java.util.List;
import okhttp3.Dns;
import t9.i;

/* loaded from: classes3.dex */
public final class c implements Dns {

    /* renamed from: a, reason: collision with root package name */
    public final String f14717a;

    /* renamed from: b, reason: collision with root package name */
    public b f14718b;

    public c(String str) {
        i.g(str, "alias");
        this.f14717a = str;
        this.f14718b = b.f14706f.a();
    }

    @Override // okhttp3.Dns
    public List lookup(String str) {
        i.g(str, "hostname");
        return this.f14718b.j(str, this.f14717a);
    }
}
