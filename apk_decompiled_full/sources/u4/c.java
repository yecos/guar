package u4;

import android.text.TextUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import v4.a;
import w4.a;

/* loaded from: classes3.dex */
public class c implements a.InterfaceC0328a, a.InterfaceC0330a {

    /* renamed from: a, reason: collision with root package name */
    public final ExecutorService f19052a;

    /* renamed from: b, reason: collision with root package name */
    public final u4.a f19053b;

    /* renamed from: c, reason: collision with root package name */
    public final y4.a f19054c;

    /* renamed from: d, reason: collision with root package name */
    public final t4.a f19055d;

    /* renamed from: f, reason: collision with root package name */
    public final a f19057f;

    /* renamed from: h, reason: collision with root package name */
    public long f19059h;

    /* renamed from: g, reason: collision with root package name */
    public long f19058g = System.currentTimeMillis();

    /* renamed from: i, reason: collision with root package name */
    public volatile AtomicBoolean f19060i = new AtomicBoolean(false);

    /* renamed from: e, reason: collision with root package name */
    public final List f19056e = new ArrayList();

    public interface a {
        void a(y4.a aVar);
    }

    public c(ExecutorService executorService, u4.a aVar, y4.a aVar2, t4.a aVar3, a aVar4) {
        this.f19052a = executorService;
        this.f19053b = aVar;
        this.f19054c = aVar2;
        this.f19055d = aVar3;
        this.f19057f = aVar4;
    }

    @Override // v4.a.InterfaceC0328a
    public void a(long j10, boolean z10) {
        this.f19054c.E(z10);
        this.f19054c.B(j10);
        d(this.f19054c.h());
        ArrayList arrayList = new ArrayList();
        if (z10) {
            long j11 = this.f19054c.j();
            int f10 = this.f19055d.f();
            long j12 = j11 / f10;
            int i10 = 0;
            while (i10 < f10) {
                long j13 = j12 * i10;
                int i11 = i10;
                y4.b bVar = new y4.b(i11, this.f19054c.g(), this.f19054c.m(), this.f19054c.a(), j13, i10 == f10 + (-1) ? j11 - 1 : (j13 + j12) - 1);
                arrayList.add(bVar);
                w4.a aVar = new w4.a(bVar, this.f19053b, this.f19055d, this.f19054c, this);
                this.f19052a.submit(aVar);
                this.f19056e.add(aVar);
                i10 = i11 + 1;
            }
        } else {
            y4.b bVar2 = new y4.b(0, this.f19054c.g(), this.f19054c.m(), this.f19054c.a(), 0L, this.f19054c.j() - 1);
            arrayList.add(bVar2);
            w4.a aVar2 = new w4.a(bVar2, this.f19053b, this.f19055d, this.f19054c, this);
            this.f19052a.submit(aVar2);
            this.f19056e.add(aVar2);
        }
        this.f19054c.v(arrayList);
        this.f19054c.C(2);
        this.f19053b.a(this.f19054c);
    }

    @Override // w4.a.InterfaceC0330a
    public void b() {
        e();
        if (this.f19054c.i() == this.f19054c.j()) {
            this.f19054c.C(5);
            this.f19053b.a(this.f19054c);
            a aVar = this.f19057f;
            if (aVar != null) {
                aVar.a(this.f19054c);
            }
        }
    }

    @Override // w4.a.InterfaceC0330a
    public void c() {
        if (this.f19060i.get()) {
            return;
        }
        synchronized (this) {
            if (!this.f19060i.get()) {
                this.f19060i.set(true);
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.f19058g > 1000) {
                    e();
                    this.f19053b.a(this.f19054c);
                    this.f19058g = currentTimeMillis;
                }
                this.f19060i.set(false);
            }
        }
    }

    public final void d(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            File file = new File(str);
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            if (file.exists()) {
                file.delete();
            }
        } catch (SecurityException e10) {
            e10.printStackTrace();
        }
    }

    public final void e() {
        this.f19059h = 0L;
        Iterator it = this.f19054c.e().iterator();
        while (it.hasNext()) {
            this.f19059h += ((y4.b) it.next()).e();
        }
        this.f19054c.A(this.f19059h);
    }

    public final void f() {
        this.f19052a.submit(new v4.a(this.f19053b, this.f19054c, this));
    }

    public void g() {
        if (this.f19054c.j() <= 0) {
            f();
            return;
        }
        List e10 = this.f19054c.e();
        if (e10.size() == 0) {
            this.f19054c.A(0L);
            f();
            return;
        }
        Iterator it = e10.iterator();
        while (it.hasNext()) {
            w4.a aVar = new w4.a((y4.b) it.next(), this.f19053b, this.f19055d, this.f19054c, this);
            this.f19052a.submit(aVar);
            this.f19056e.add(aVar);
        }
        this.f19054c.C(2);
        this.f19053b.a(this.f19054c);
    }
}
