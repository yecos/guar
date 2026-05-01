package ab;

import ab.b;
import db.o;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public class k extends b {

    /* renamed from: f, reason: collision with root package name */
    public static final db.l f542f = new db.n();

    /* renamed from: g, reason: collision with root package name */
    public static final db.l f543g = new db.g();

    /* renamed from: h, reason: collision with root package name */
    public static final db.l f544h = new db.i();

    /* renamed from: i, reason: collision with root package name */
    public static final db.l f545i = new db.k();

    /* renamed from: j, reason: collision with root package name */
    public static final db.l f546j = new db.f();

    /* renamed from: k, reason: collision with root package name */
    public static final db.l f547k = new db.e();

    /* renamed from: l, reason: collision with root package name */
    public static final db.l f548l = new db.j();

    /* renamed from: m, reason: collision with root package name */
    public static final db.l f549m = new o();

    /* renamed from: n, reason: collision with root package name */
    public static final db.l f550n = new db.h();

    /* renamed from: o, reason: collision with root package name */
    public static final db.l f551o = new db.m();

    /* renamed from: p, reason: collision with root package name */
    public static final db.l f552p = new db.d();

    /* renamed from: a, reason: collision with root package name */
    public b.a f553a;

    /* renamed from: b, reason: collision with root package name */
    public b[] f554b;

    /* renamed from: c, reason: collision with root package name */
    public boolean[] f555c = new boolean[13];

    /* renamed from: d, reason: collision with root package name */
    public int f556d;

    /* renamed from: e, reason: collision with root package name */
    public int f557e;

    public k() {
        b[] bVarArr = new b[13];
        this.f554b = bVarArr;
        bVarArr[0] = new m(f542f);
        this.f554b[1] = new m(f543g);
        this.f554b[2] = new m(f544h);
        this.f554b[3] = new m(f545i);
        this.f554b[4] = new m(f546j);
        this.f554b[5] = new m(f547k);
        this.f554b[6] = new m(f548l);
        this.f554b[7] = new m(f549m);
        this.f554b[8] = new m(f550n);
        this.f554b[9] = new m(f551o);
        h hVar = new h();
        b[] bVarArr2 = this.f554b;
        bVarArr2[10] = hVar;
        db.l lVar = f552p;
        bVarArr2[11] = new m(lVar, false, hVar);
        this.f554b[12] = new m(lVar, true, hVar);
        b[] bVarArr3 = this.f554b;
        hVar.l(bVarArr3[11], bVarArr3[12]);
        i();
    }

    @Override // ab.b
    public String c() {
        if (this.f556d == -1) {
            d();
            if (this.f556d == -1) {
                this.f556d = 0;
            }
        }
        return this.f554b[this.f556d].c();
    }

    @Override // ab.b
    public float d() {
        b.a aVar = this.f553a;
        if (aVar == b.a.FOUND_IT) {
            return 0.99f;
        }
        if (aVar == b.a.NOT_ME) {
            return 0.01f;
        }
        float f10 = 0.0f;
        int i10 = 0;
        while (true) {
            b[] bVarArr = this.f554b;
            if (i10 >= bVarArr.length) {
                return f10;
            }
            if (this.f555c[i10]) {
                float d10 = bVarArr[i10].d();
                if (f10 < d10) {
                    this.f556d = i10;
                    f10 = d10;
                }
            }
            i10++;
        }
    }

    @Override // ab.b
    public b.a e() {
        return this.f553a;
    }

    @Override // ab.b
    public b.a f(byte[] bArr, int i10, int i11) {
        b.a aVar;
        ByteBuffer b10 = b(bArr, i10, i11);
        if (b10.position() != 0) {
            int i12 = 0;
            while (true) {
                b[] bVarArr = this.f554b;
                if (i12 >= bVarArr.length) {
                    break;
                }
                if (this.f555c[i12]) {
                    b.a f10 = bVarArr[i12].f(b10.array(), 0, b10.position());
                    aVar = b.a.FOUND_IT;
                    if (f10 == aVar) {
                        this.f556d = i12;
                        break;
                    }
                    aVar = b.a.NOT_ME;
                    if (f10 == aVar) {
                        this.f555c[i12] = false;
                        int i13 = this.f557e - 1;
                        this.f557e = i13;
                        if (i13 <= 0) {
                            break;
                        }
                    } else {
                        continue;
                    }
                }
                i12++;
            }
            this.f553a = aVar;
        }
        return this.f553a;
    }

    @Override // ab.b
    public void i() {
        int i10 = 0;
        this.f557e = 0;
        while (true) {
            b[] bVarArr = this.f554b;
            if (i10 >= bVarArr.length) {
                this.f556d = -1;
                this.f553a = b.a.DETECTING;
                return;
            } else {
                bVarArr[i10].i();
                this.f555c[i10] = true;
                this.f557e++;
                i10++;
            }
        }
    }
}
