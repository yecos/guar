package y8;

import com.google.common.base.Preconditions;
import com.raizlabs.android.dbflow.sql.language.Operator;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import y8.a;

/* loaded from: classes3.dex */
public final class x {

    /* renamed from: d, reason: collision with root package name */
    public static final a.c f20066d = a.c.a("io.grpc.EquivalentAddressGroup.ATTR_AUTHORITY_OVERRIDE");

    /* renamed from: a, reason: collision with root package name */
    public final List f20067a;

    /* renamed from: b, reason: collision with root package name */
    public final a f20068b;

    /* renamed from: c, reason: collision with root package name */
    public final int f20069c;

    public x(List list) {
        this(list, a.f19771c);
    }

    public List a() {
        return this.f20067a;
    }

    public a b() {
        return this.f20068b;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof x)) {
            return false;
        }
        x xVar = (x) obj;
        if (this.f20067a.size() != xVar.f20067a.size()) {
            return false;
        }
        for (int i10 = 0; i10 < this.f20067a.size(); i10++) {
            if (!((SocketAddress) this.f20067a.get(i10)).equals(xVar.f20067a.get(i10))) {
                return false;
            }
        }
        return this.f20068b.equals(xVar.f20068b);
    }

    public int hashCode() {
        return this.f20069c;
    }

    public String toString() {
        return "[" + this.f20067a + Operator.Operation.DIVISION + this.f20068b + "]";
    }

    public x(List list, a aVar) {
        Preconditions.checkArgument(!list.isEmpty(), "addrs is empty");
        List unmodifiableList = Collections.unmodifiableList(new ArrayList(list));
        this.f20067a = unmodifiableList;
        this.f20068b = (a) Preconditions.checkNotNull(aVar, "attrs");
        this.f20069c = unmodifiableList.hashCode();
    }

    public x(SocketAddress socketAddress) {
        this(socketAddress, a.f19771c);
    }

    public x(SocketAddress socketAddress, a aVar) {
        this(Collections.singletonList(socketAddress), aVar);
    }
}
