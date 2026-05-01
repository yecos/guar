package z8;

import com.google.common.base.Preconditions;
import com.google.common.base.Stopwatch;
import com.raizlabs.android.dbflow.sql.language.Operator;
import com.taobao.accs.utl.BaseMonitor;
import java.net.URI;
import y8.y0;

/* loaded from: classes3.dex */
public final class d0 extends y8.z0 {
    @Override // y8.y0.c
    public String a() {
        return BaseMonitor.COUNT_POINT_DNS;
    }

    @Override // y8.z0
    public boolean d() {
        return true;
    }

    @Override // y8.z0
    public int e() {
        return 5;
    }

    @Override // y8.y0.c
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public c0 b(URI uri, y0.a aVar) {
        if (!BaseMonitor.COUNT_POINT_DNS.equals(uri.getScheme())) {
            return null;
        }
        String str = (String) Preconditions.checkNotNull(uri.getPath(), "targetPath");
        Preconditions.checkArgument(str.startsWith(Operator.Operation.DIVISION), "the path component (%s) of the target (%s) must start with '/'", str, uri);
        return new c0(uri.getAuthority(), str.substring(1), aVar, q0.f20853u, Stopwatch.createUnstarted(), y8.k0.a(d0.class.getClassLoader()));
    }
}
