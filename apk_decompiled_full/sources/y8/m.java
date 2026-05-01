package y8;

import com.google.common.base.Preconditions;
import java.util.concurrent.Executor;
import y8.b;

/* loaded from: classes3.dex */
public final class m extends b {

    /* renamed from: a, reason: collision with root package name */
    public final b f19939a;

    /* renamed from: b, reason: collision with root package name */
    public final b f19940b;

    public final class a extends b.a {

        /* renamed from: a, reason: collision with root package name */
        public final b.AbstractC0344b f19941a;

        /* renamed from: b, reason: collision with root package name */
        public final Executor f19942b;

        /* renamed from: c, reason: collision with root package name */
        public final b.a f19943c;

        /* renamed from: d, reason: collision with root package name */
        public final r f19944d;

        public a(b.AbstractC0344b abstractC0344b, Executor executor, b.a aVar, r rVar) {
            this.f19941a = abstractC0344b;
            this.f19942b = executor;
            this.f19943c = (b.a) Preconditions.checkNotNull(aVar, "delegate");
            this.f19944d = (r) Preconditions.checkNotNull(rVar, com.umeng.analytics.pro.f.X);
        }
    }

    public m(b bVar, b bVar2) {
        this.f19939a = (b) Preconditions.checkNotNull(bVar, "creds1");
        this.f19940b = (b) Preconditions.checkNotNull(bVar2, "creds2");
    }

    @Override // y8.b
    public void a(b.AbstractC0344b abstractC0344b, Executor executor, b.a aVar) {
        this.f19939a.a(abstractC0344b, executor, new a(abstractC0344b, executor, aVar, r.e()));
    }
}
