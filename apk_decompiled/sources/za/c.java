package za;

/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public a f21219a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f21220b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f21221c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f21222d;

    /* renamed from: e, reason: collision with root package name */
    public byte f21223e;

    /* renamed from: f, reason: collision with root package name */
    public String f21224f;

    /* renamed from: h, reason: collision with root package name */
    public ab.b f21226h = null;

    /* renamed from: g, reason: collision with root package name */
    public ab.b[] f21225g = new ab.b[3];

    public enum a {
        PURE_ASCII,
        ESC_ASCII,
        HIGHBYTE
    }

    public c(za.a aVar) {
        int i10 = 0;
        while (true) {
            ab.b[] bVarArr = this.f21225g;
            if (i10 >= bVarArr.length) {
                e();
                return;
            } else {
                bVarArr[i10] = null;
                i10++;
            }
        }
    }

    public void a() {
        ab.b[] bVarArr;
        if (this.f21222d) {
            if (this.f21224f != null) {
                this.f21220b = true;
                return;
            }
            if (this.f21219a == a.HIGHBYTE) {
                int i10 = 0;
                int i11 = 0;
                float f10 = 0.0f;
                while (true) {
                    bVarArr = this.f21225g;
                    if (i10 >= bVarArr.length) {
                        break;
                    }
                    float d10 = bVarArr[i10].d();
                    if (d10 > f10) {
                        i11 = i10;
                        f10 = d10;
                    }
                    i10++;
                }
                if (f10 > 0.2f) {
                    this.f21224f = bVarArr[i11].c();
                }
            }
        }
    }

    public String b() {
        return this.f21224f;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0074  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void c(byte[] r10, int r11, int r12) {
        /*
            Method dump skipped, instructions count: 295
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: za.c.c(byte[], int, int):void");
    }

    public boolean d() {
        return this.f21220b;
    }

    public void e() {
        int i10 = 0;
        this.f21220b = false;
        this.f21221c = true;
        this.f21224f = null;
        this.f21222d = false;
        this.f21219a = a.PURE_ASCII;
        this.f21223e = (byte) 0;
        ab.b bVar = this.f21226h;
        if (bVar != null) {
            bVar.i();
        }
        while (true) {
            ab.b[] bVarArr = this.f21225g;
            if (i10 >= bVarArr.length) {
                return;
            }
            ab.b bVar2 = bVarArr[i10];
            if (bVar2 != null) {
                bVar2.i();
            }
            i10++;
        }
    }
}
