package h9;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* loaded from: classes.dex */
public final class n implements g, Serializable {

    /* renamed from: d, reason: collision with root package name */
    public static final a f14233d = new a(null);

    /* renamed from: e, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f14234e = AtomicReferenceFieldUpdater.newUpdater(n.class, Object.class, c8.b.f5629b);

    /* renamed from: a, reason: collision with root package name */
    public volatile s9.a f14235a;

    /* renamed from: b, reason: collision with root package name */
    public volatile Object f14236b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f14237c;

    /* loaded from: classes3.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(t9.g gVar) {
            this();
        }
    }

    public n(s9.a aVar) {
        t9.i.g(aVar, "initializer");
        this.f14235a = aVar;
        r rVar = r.f14241a;
        this.f14236b = rVar;
        this.f14237c = rVar;
    }

    public boolean a() {
        return this.f14236b != r.f14241a;
    }

    @Override // h9.g
    public Object getValue() {
        Object obj = this.f14236b;
        r rVar = r.f14241a;
        if (obj != rVar) {
            return obj;
        }
        s9.a aVar = this.f14235a;
        if (aVar != null) {
            Object invoke = aVar.invoke();
            if (androidx.concurrent.futures.b.a(f14234e, this, rVar, invoke)) {
                this.f14235a = null;
                return invoke;
            }
        }
        return this.f14236b;
    }

    public String toString() {
        return a() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }
}
