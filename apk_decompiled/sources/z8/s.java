package z8;

import java.util.concurrent.Executor;

/* loaded from: classes3.dex */
public interface s extends y8.h0 {

    public interface a {
        void a(long j10);

        void onFailure(Throwable th);
    }

    q b(y8.w0 w0Var, y8.v0 v0Var, y8.c cVar, y8.k[] kVarArr);

    void f(a aVar, Executor executor);
}
