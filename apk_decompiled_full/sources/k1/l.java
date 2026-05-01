package k1;

import androidx.work.WorkerParameters;

/* loaded from: classes.dex */
public class l implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public b1.j f14758a;

    /* renamed from: b, reason: collision with root package name */
    public String f14759b;

    /* renamed from: c, reason: collision with root package name */
    public WorkerParameters.a f14760c;

    public l(b1.j jVar, String str, WorkerParameters.a aVar) {
        this.f14758a = jVar;
        this.f14759b = str;
        this.f14760c = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f14758a.l().k(this.f14759b, this.f14760c);
    }
}
