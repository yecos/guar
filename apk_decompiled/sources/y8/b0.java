package y8;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import java.net.InetSocketAddress;
import java.net.SocketAddress;

/* loaded from: classes3.dex */
public final class b0 extends c1 {

    /* renamed from: a, reason: collision with root package name */
    public final SocketAddress f19786a;

    /* renamed from: b, reason: collision with root package name */
    public final InetSocketAddress f19787b;

    /* renamed from: c, reason: collision with root package name */
    public final String f19788c;

    /* renamed from: d, reason: collision with root package name */
    public final String f19789d;

    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public SocketAddress f19790a;

        /* renamed from: b, reason: collision with root package name */
        public InetSocketAddress f19791b;

        /* renamed from: c, reason: collision with root package name */
        public String f19792c;

        /* renamed from: d, reason: collision with root package name */
        public String f19793d;

        public b0 a() {
            return new b0(this.f19790a, this.f19791b, this.f19792c, this.f19793d);
        }

        public b b(String str) {
            this.f19793d = str;
            return this;
        }

        public b c(SocketAddress socketAddress) {
            this.f19790a = (SocketAddress) Preconditions.checkNotNull(socketAddress, "proxyAddress");
            return this;
        }

        public b d(InetSocketAddress inetSocketAddress) {
            this.f19791b = (InetSocketAddress) Preconditions.checkNotNull(inetSocketAddress, "targetAddress");
            return this;
        }

        public b e(String str) {
            this.f19792c = str;
            return this;
        }

        public b() {
        }
    }

    public static b e() {
        return new b();
    }

    public String a() {
        return this.f19789d;
    }

    public SocketAddress b() {
        return this.f19786a;
    }

    public InetSocketAddress c() {
        return this.f19787b;
    }

    public String d() {
        return this.f19788c;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof b0)) {
            return false;
        }
        b0 b0Var = (b0) obj;
        return Objects.equal(this.f19786a, b0Var.f19786a) && Objects.equal(this.f19787b, b0Var.f19787b) && Objects.equal(this.f19788c, b0Var.f19788c) && Objects.equal(this.f19789d, b0Var.f19789d);
    }

    public int hashCode() {
        return Objects.hashCode(this.f19786a, this.f19787b, this.f19788c, this.f19789d);
    }

    public String toString() {
        return MoreObjects.toStringHelper(this).add("proxyAddr", this.f19786a).add("targetAddr", this.f19787b).add("username", this.f19788c).add("hasPassword", this.f19789d != null).toString();
    }

    public b0(SocketAddress socketAddress, InetSocketAddress inetSocketAddress, String str, String str2) {
        Preconditions.checkNotNull(socketAddress, "proxyAddress");
        Preconditions.checkNotNull(inetSocketAddress, "targetAddress");
        if (socketAddress instanceof InetSocketAddress) {
            Preconditions.checkState(!((InetSocketAddress) socketAddress).isUnresolved(), "The proxy address %s is not resolved", socketAddress);
        }
        this.f19786a = socketAddress;
        this.f19787b = inetSocketAddress;
        this.f19788c = str;
        this.f19789d = str2;
    }
}
