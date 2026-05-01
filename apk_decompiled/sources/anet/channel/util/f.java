package anet.channel.util;

import com.raizlabs.android.dbflow.sql.language.Operator;
import java.net.Inet6Address;

/* loaded from: classes.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    public int f4280a;

    /* renamed from: b, reason: collision with root package name */
    public Inet6Address f4281b;

    public f(Inet6Address inet6Address, int i10) {
        this.f4280a = i10;
        this.f4281b = inet6Address;
    }

    public String toString() {
        return this.f4281b.getHostAddress() + Operator.Operation.DIVISION + this.f4280a;
    }
}
