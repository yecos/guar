package androidx.work;

import a1.f;
import a1.p;
import a1.v;
import android.net.Network;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class WorkerParameters {

    /* renamed from: a, reason: collision with root package name */
    public UUID f3607a;

    /* renamed from: b, reason: collision with root package name */
    public b f3608b;

    /* renamed from: c, reason: collision with root package name */
    public Set f3609c;

    /* renamed from: d, reason: collision with root package name */
    public a f3610d;

    /* renamed from: e, reason: collision with root package name */
    public int f3611e;

    /* renamed from: f, reason: collision with root package name */
    public Executor f3612f;

    /* renamed from: g, reason: collision with root package name */
    public m1.a f3613g;

    /* renamed from: h, reason: collision with root package name */
    public v f3614h;

    /* renamed from: i, reason: collision with root package name */
    public p f3615i;

    /* renamed from: j, reason: collision with root package name */
    public f f3616j;

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public List f3617a = Collections.emptyList();

        /* renamed from: b, reason: collision with root package name */
        public List f3618b = Collections.emptyList();

        /* renamed from: c, reason: collision with root package name */
        public Network f3619c;
    }

    public WorkerParameters(UUID uuid, b bVar, Collection collection, a aVar, int i10, Executor executor, m1.a aVar2, v vVar, p pVar, f fVar) {
        this.f3607a = uuid;
        this.f3608b = bVar;
        this.f3609c = new HashSet(collection);
        this.f3610d = aVar;
        this.f3611e = i10;
        this.f3612f = executor;
        this.f3613g = aVar2;
        this.f3614h = vVar;
        this.f3615i = pVar;
        this.f3616j = fVar;
    }

    public Executor a() {
        return this.f3612f;
    }

    public f b() {
        return this.f3616j;
    }

    public UUID c() {
        return this.f3607a;
    }

    public b d() {
        return this.f3608b;
    }

    public m1.a e() {
        return this.f3613g;
    }

    public v f() {
        return this.f3614h;
    }
}
