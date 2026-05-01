package z8;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.InvalidMarkException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class u extends z8.c {

    /* renamed from: e, reason: collision with root package name */
    public static final f f20932e = new a();

    /* renamed from: f, reason: collision with root package name */
    public static final f f20933f = new b();

    /* renamed from: g, reason: collision with root package name */
    public static final f f20934g = new c();

    /* renamed from: h, reason: collision with root package name */
    public static final f f20935h = new d();

    /* renamed from: i, reason: collision with root package name */
    public static final g f20936i = new e();

    /* renamed from: a, reason: collision with root package name */
    public final Deque f20937a;

    /* renamed from: b, reason: collision with root package name */
    public Deque f20938b;

    /* renamed from: c, reason: collision with root package name */
    public int f20939c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f20940d;

    public class a implements f {
        @Override // z8.u.g
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public int a(t1 t1Var, int i10, Void r32, int i11) {
            return t1Var.readUnsignedByte();
        }
    }

    public class b implements f {
        @Override // z8.u.g
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public int a(t1 t1Var, int i10, Void r32, int i11) {
            t1Var.skipBytes(i10);
            return 0;
        }
    }

    public class c implements f {
        @Override // z8.u.g
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public int a(t1 t1Var, int i10, byte[] bArr, int i11) {
            t1Var.C(bArr, i11, i10);
            return i11 + i10;
        }
    }

    public class d implements f {
        @Override // z8.u.g
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public int a(t1 t1Var, int i10, ByteBuffer byteBuffer, int i11) {
            int limit = byteBuffer.limit();
            byteBuffer.limit(byteBuffer.position() + i10);
            t1Var.r(byteBuffer);
            byteBuffer.limit(limit);
            return 0;
        }
    }

    public class e implements g {
        @Override // z8.u.g
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public int a(t1 t1Var, int i10, OutputStream outputStream, int i11) {
            t1Var.H(outputStream, i10);
            return 0;
        }
    }

    public interface f extends g {
    }

    public interface g {
        int a(t1 t1Var, int i10, Object obj, int i11);
    }

    public u(int i10) {
        this.f20937a = new ArrayDeque(i10);
    }

    @Override // z8.t1
    public void C(byte[] bArr, int i10, int i11) {
        n(f20934g, i11, bArr, i10);
    }

    @Override // z8.c, z8.t1
    public void D() {
        if (this.f20938b == null) {
            this.f20938b = new ArrayDeque(Math.min(this.f20937a.size(), 16));
        }
        while (!this.f20938b.isEmpty()) {
            ((t1) this.f20938b.remove()).close();
        }
        this.f20940d = true;
        t1 t1Var = (t1) this.f20937a.peek();
        if (t1Var != null) {
            t1Var.D();
        }
    }

    @Override // z8.t1
    public void H(OutputStream outputStream, int i10) {
        m(f20936i, i10, outputStream, 0);
    }

    public void b(t1 t1Var) {
        boolean z10 = this.f20940d && this.f20937a.isEmpty();
        f(t1Var);
        if (z10) {
            ((t1) this.f20937a.peek()).D();
        }
    }

    public final void c() {
        if (!this.f20940d) {
            ((t1) this.f20937a.remove()).close();
            return;
        }
        this.f20938b.add((t1) this.f20937a.remove());
        t1 t1Var = (t1) this.f20937a.peek();
        if (t1Var != null) {
            t1Var.D();
        }
    }

    @Override // z8.c, z8.t1, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        while (!this.f20937a.isEmpty()) {
            ((t1) this.f20937a.remove()).close();
        }
        if (this.f20938b != null) {
            while (!this.f20938b.isEmpty()) {
                ((t1) this.f20938b.remove()).close();
            }
        }
    }

    public final void e() {
        if (((t1) this.f20937a.peek()).h() == 0) {
            c();
        }
    }

    public final void f(t1 t1Var) {
        if (!(t1Var instanceof u)) {
            this.f20937a.add(t1Var);
            this.f20939c += t1Var.h();
            return;
        }
        u uVar = (u) t1Var;
        while (!uVar.f20937a.isEmpty()) {
            this.f20937a.add((t1) uVar.f20937a.remove());
        }
        this.f20939c += uVar.f20939c;
        uVar.f20939c = 0;
        uVar.close();
    }

    @Override // z8.t1
    public int h() {
        return this.f20939c;
    }

    @Override // z8.t1
    public t1 j(int i10) {
        t1 t1Var;
        int i11;
        t1 t1Var2;
        if (i10 <= 0) {
            return u1.a();
        }
        a(i10);
        this.f20939c -= i10;
        t1 t1Var3 = null;
        u uVar = null;
        while (true) {
            t1 t1Var4 = (t1) this.f20937a.peek();
            int h10 = t1Var4.h();
            if (h10 > i10) {
                t1Var2 = t1Var4.j(i10);
                i11 = 0;
            } else {
                if (this.f20940d) {
                    t1Var = t1Var4.j(h10);
                    c();
                } else {
                    t1Var = (t1) this.f20937a.poll();
                }
                t1 t1Var5 = t1Var;
                i11 = i10 - h10;
                t1Var2 = t1Var5;
            }
            if (t1Var3 == null) {
                t1Var3 = t1Var2;
            } else {
                if (uVar == null) {
                    uVar = new u(i11 != 0 ? Math.min(this.f20937a.size() + 2, 16) : 2);
                    uVar.b(t1Var3);
                    t1Var3 = uVar;
                }
                uVar.b(t1Var2);
            }
            if (i11 <= 0) {
                return t1Var3;
            }
            i10 = i11;
        }
    }

    public final int m(g gVar, int i10, Object obj, int i11) {
        a(i10);
        if (!this.f20937a.isEmpty()) {
            e();
        }
        while (i10 > 0 && !this.f20937a.isEmpty()) {
            t1 t1Var = (t1) this.f20937a.peek();
            int min = Math.min(i10, t1Var.h());
            i11 = gVar.a(t1Var, min, obj, i11);
            i10 -= min;
            this.f20939c -= min;
            e();
        }
        if (i10 <= 0) {
            return i11;
        }
        throw new AssertionError("Failed executing read operation");
    }

    @Override // z8.c, z8.t1
    public boolean markSupported() {
        Iterator it = this.f20937a.iterator();
        while (it.hasNext()) {
            if (!((t1) it.next()).markSupported()) {
                return false;
            }
        }
        return true;
    }

    public final int n(f fVar, int i10, Object obj, int i11) {
        try {
            return m(fVar, i10, obj, i11);
        } catch (IOException e10) {
            throw new AssertionError(e10);
        }
    }

    @Override // z8.t1
    public void r(ByteBuffer byteBuffer) {
        n(f20935h, byteBuffer.remaining(), byteBuffer, 0);
    }

    @Override // z8.t1
    public int readUnsignedByte() {
        return n(f20932e, 1, null, 0);
    }

    @Override // z8.c, z8.t1
    public void reset() {
        if (!this.f20940d) {
            throw new InvalidMarkException();
        }
        t1 t1Var = (t1) this.f20937a.peek();
        if (t1Var != null) {
            int h10 = t1Var.h();
            t1Var.reset();
            this.f20939c += t1Var.h() - h10;
        }
        while (true) {
            t1 t1Var2 = (t1) this.f20938b.pollLast();
            if (t1Var2 == null) {
                return;
            }
            t1Var2.reset();
            this.f20937a.addFirst(t1Var2);
            this.f20939c += t1Var2.h();
        }
    }

    @Override // z8.t1
    public void skipBytes(int i10) {
        n(f20933f, i10, null, 0);
    }

    public u() {
        this.f20937a = new ArrayDeque();
    }
}
