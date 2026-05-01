package io.grpc.stub;

import com.google.common.base.Preconditions;
import y8.g;
import y8.v0;
import y8.w0;
import y8.y;

/* loaded from: classes3.dex */
public abstract class h {

    public static final class a implements y8.h {

        /* renamed from: a, reason: collision with root package name */
        public final v0 f14449a;

        /* renamed from: io.grpc.stub.h$a$a, reason: collision with other inner class name */
        public final class C0236a extends y.a {
            public C0236a(y8.g gVar) {
                super(gVar);
            }

            @Override // y8.y, y8.g
            public void e(g.a aVar, v0 v0Var) {
                v0Var.l(a.this.f14449a);
                super.e(aVar, v0Var);
            }
        }

        public a(v0 v0Var) {
            this.f14449a = (v0) Preconditions.checkNotNull(v0Var, "extraHeaders");
        }

        @Override // y8.h
        public y8.g a(w0 w0Var, y8.c cVar, y8.d dVar) {
            return new C0236a(dVar.h(w0Var, cVar));
        }
    }

    public static y8.h a(v0 v0Var) {
        return new a(v0Var);
    }
}
