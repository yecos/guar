package z8;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import java.io.Closeable;
import java.net.SocketAddress;
import java.util.concurrent.ScheduledExecutorService;

/* loaded from: classes3.dex */
public interface t extends Closeable {

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public String f20922a = "unknown-authority";

        /* renamed from: b, reason: collision with root package name */
        public y8.a f20923b = y8.a.f19771c;

        /* renamed from: c, reason: collision with root package name */
        public String f20924c;

        /* renamed from: d, reason: collision with root package name */
        public y8.b0 f20925d;

        public String a() {
            return this.f20922a;
        }

        public y8.a b() {
            return this.f20923b;
        }

        public y8.b0 c() {
            return this.f20925d;
        }

        public String d() {
            return this.f20924c;
        }

        public a e(String str) {
            this.f20922a = (String) Preconditions.checkNotNull(str, "authority");
            return this;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f20922a.equals(aVar.f20922a) && this.f20923b.equals(aVar.f20923b) && Objects.equal(this.f20924c, aVar.f20924c) && Objects.equal(this.f20925d, aVar.f20925d);
        }

        public a f(y8.a aVar) {
            Preconditions.checkNotNull(aVar, "eagAttributes");
            this.f20923b = aVar;
            return this;
        }

        public a g(y8.b0 b0Var) {
            this.f20925d = b0Var;
            return this;
        }

        public a h(String str) {
            this.f20924c = str;
            return this;
        }

        public int hashCode() {
            return Objects.hashCode(this.f20922a, this.f20923b, this.f20924c, this.f20925d);
        }
    }

    v J(SocketAddress socketAddress, a aVar, y8.f fVar);

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    ScheduledExecutorService p();
}
