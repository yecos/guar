package a9;

import com.google.common.base.Preconditions;
import com.hpplay.sdk.source.mdns.xbill.dns.Message;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import okio.Buffer;

/* loaded from: classes3.dex */
public class q {

    /* renamed from: a, reason: collision with root package name */
    public final d f467a;

    /* renamed from: b, reason: collision with root package name */
    public final c9.c f468b;

    /* renamed from: c, reason: collision with root package name */
    public int f469c = Message.MAXLENGTH;

    /* renamed from: d, reason: collision with root package name */
    public final c f470d = new c(0, Message.MAXLENGTH, null);

    public interface b {
        void b(int i10);
    }

    public final class c {

        /* renamed from: b, reason: collision with root package name */
        public Runnable f472b;

        /* renamed from: c, reason: collision with root package name */
        public final int f473c;

        /* renamed from: d, reason: collision with root package name */
        public int f474d;

        /* renamed from: e, reason: collision with root package name */
        public int f475e;

        /* renamed from: f, reason: collision with root package name */
        public final b f476f;

        /* renamed from: a, reason: collision with root package name */
        public final Buffer f471a = new Buffer();

        /* renamed from: g, reason: collision with root package name */
        public boolean f477g = false;

        public c(int i10, int i11, b bVar) {
            this.f473c = i10;
            this.f474d = i11;
            this.f476f = bVar;
        }

        public void a(int i10) {
            this.f475e += i10;
        }

        public int b() {
            return this.f475e;
        }

        public void c() {
            this.f475e = 0;
        }

        public void d(Buffer buffer, int i10, boolean z10) {
            this.f471a.write(buffer, i10);
            this.f477g |= z10;
        }

        public boolean e() {
            return this.f471a.size() > 0;
        }

        public int f(int i10) {
            if (i10 <= 0 || Integer.MAX_VALUE - i10 >= this.f474d) {
                int i11 = this.f474d + i10;
                this.f474d = i11;
                return i11;
            }
            throw new IllegalArgumentException("Window size overflow for stream: " + this.f473c);
        }

        public int g() {
            return Math.max(0, Math.min(this.f474d, (int) this.f471a.size()));
        }

        public int h() {
            return g() - this.f475e;
        }

        public int i() {
            return this.f474d;
        }

        public int j() {
            return Math.min(this.f474d, q.this.f470d.i());
        }

        public void k(Buffer buffer, int i10, boolean z10) {
            do {
                int min = Math.min(i10, q.this.f468b.maxDataLength());
                int i11 = -min;
                q.this.f470d.f(i11);
                f(i11);
                try {
                    q.this.f468b.data(buffer.size() == ((long) min) && z10, this.f473c, buffer, min);
                    this.f476f.b(min);
                    i10 -= min;
                } catch (IOException e10) {
                    throw new RuntimeException(e10);
                }
            } while (i10 > 0);
        }

        public int l(int i10, e eVar) {
            Runnable runnable;
            int min = Math.min(i10, j());
            int i11 = 0;
            while (e() && min > 0) {
                if (min >= this.f471a.size()) {
                    i11 += (int) this.f471a.size();
                    Buffer buffer = this.f471a;
                    k(buffer, (int) buffer.size(), this.f477g);
                } else {
                    i11 += min;
                    k(this.f471a, min, false);
                }
                eVar.b();
                min = Math.min(i10 - i11, j());
            }
            if (!e() && (runnable = this.f472b) != null) {
                runnable.run();
                this.f472b = null;
            }
            return i11;
        }
    }

    public interface d {
        c[] a();
    }

    public static final class e {

        /* renamed from: a, reason: collision with root package name */
        public int f479a;

        public e() {
        }

        public boolean a() {
            return this.f479a > 0;
        }

        public void b() {
            this.f479a++;
        }
    }

    public q(d dVar, c9.c cVar) {
        this.f467a = (d) Preconditions.checkNotNull(dVar, "transport");
        this.f468b = (c9.c) Preconditions.checkNotNull(cVar, "frameWriter");
    }

    public c c(b bVar, int i10) {
        return new c(i10, this.f469c, (b) Preconditions.checkNotNull(bVar, "stream"));
    }

    public void d(boolean z10, c cVar, Buffer buffer, boolean z11) {
        Preconditions.checkNotNull(buffer, "source");
        int j10 = cVar.j();
        boolean e10 = cVar.e();
        int size = (int) buffer.size();
        if (e10 || j10 < size) {
            if (!e10 && j10 > 0) {
                cVar.k(buffer, j10, false);
            }
            cVar.d(buffer, (int) buffer.size(), z10);
        } else {
            cVar.k(buffer, size, z10);
        }
        if (z11) {
            e();
        }
    }

    public void e() {
        try {
            this.f468b.flush();
        } catch (IOException e10) {
            throw new RuntimeException(e10);
        }
    }

    public boolean f(int i10) {
        if (i10 < 0) {
            throw new IllegalArgumentException("Invalid initial window size: " + i10);
        }
        int i11 = i10 - this.f469c;
        this.f469c = i10;
        for (c cVar : this.f467a.a()) {
            cVar.f(i11);
        }
        return i11 > 0;
    }

    public int g(c cVar, int i10) {
        if (cVar == null) {
            int f10 = this.f470d.f(i10);
            h();
            return f10;
        }
        int f11 = cVar.f(i10);
        e eVar = new e();
        cVar.l(cVar.j(), eVar);
        if (eVar.a()) {
            e();
        }
        return f11;
    }

    public void h() {
        int i10;
        c[] a10 = this.f467a.a();
        Collections.shuffle(Arrays.asList(a10));
        int i11 = this.f470d.i();
        int length = a10.length;
        while (true) {
            i10 = 0;
            if (length <= 0 || i11 <= 0) {
                break;
            }
            int ceil = (int) Math.ceil(i11 / length);
            for (int i12 = 0; i12 < length && i11 > 0; i12++) {
                c cVar = a10[i12];
                int min = Math.min(i11, Math.min(cVar.h(), ceil));
                if (min > 0) {
                    cVar.a(min);
                    i11 -= min;
                }
                if (cVar.h() > 0) {
                    a10[i10] = cVar;
                    i10++;
                }
            }
            length = i10;
        }
        e eVar = new e();
        c[] a11 = this.f467a.a();
        int length2 = a11.length;
        while (i10 < length2) {
            c cVar2 = a11[i10];
            cVar2.l(cVar2.b(), eVar);
            cVar2.c();
            i10++;
        }
        if (eVar.a()) {
            e();
        }
    }
}
