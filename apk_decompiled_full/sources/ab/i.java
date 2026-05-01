package ab;

import ab.b;
import com.google.common.primitives.UnsignedBytes;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public class i extends b {

    /* renamed from: d, reason: collision with root package name */
    public static final byte[] f532d = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 1, 1, 1, 1, 1, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 1, 1, 1, 1, 1, 1, 0, 1, 7, 1, 1, 1, 1, 1, 1, 5, 1, 5, 0, 5, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 7, 1, 7, 0, 7, 5, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 4, 4, 4, 4, 4, 4, 5, 5, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 4, 4, 4, 4, 4, 1, 4, 4, 4, 4, 4, 5, 5, 5, 6, 6, 6, 6, 6, 6, 7, 7, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 6, 6, 6, 6, 6, 1, 6, 6, 6, 6, 6, 7, 7, 7};

    /* renamed from: e, reason: collision with root package name */
    public static final byte[] f533e = {0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 3, 3, 3, 3, 3, 3, 0, 3, 3, 3, 3, 3, 3, 3, 0, 3, 3, 3, 1, 1, 3, 3, 0, 3, 3, 3, 1, 2, 1, 2, 0, 3, 3, 3, 3, 3, 3, 3, 0, 3, 1, 3, 1, 1, 1, 3, 0, 3, 1, 3, 1, 1, 3, 3};

    /* renamed from: a, reason: collision with root package name */
    public b.a f534a;

    /* renamed from: b, reason: collision with root package name */
    public byte f535b;

    /* renamed from: c, reason: collision with root package name */
    public int[] f536c = new int[4];

    public i() {
        i();
    }

    @Override // ab.b
    public String c() {
        return za.b.f21210r;
    }

    @Override // ab.b
    public float d() {
        int[] iArr;
        float f10;
        if (this.f534a == b.a.NOT_ME) {
            return 0.01f;
        }
        int i10 = 0;
        int i11 = 0;
        while (true) {
            iArr = this.f536c;
            if (i10 >= iArr.length) {
                break;
            }
            i11 += iArr[i10];
            i10++;
        }
        if (i11 <= 0) {
            f10 = 0.0f;
        } else {
            float f11 = i11;
            f10 = ((iArr[3] * 1.0f) / f11) - ((iArr[1] * 20.0f) / f11);
        }
        return (f10 >= 0.0f ? f10 : 0.0f) * 0.5f;
    }

    @Override // ab.b
    public b.a e() {
        return this.f534a;
    }

    @Override // ab.b
    public b.a f(byte[] bArr, int i10, int i11) {
        ByteBuffer a10 = a(bArr, i10, i11);
        byte[] array = a10.array();
        int position = a10.position();
        int i12 = 0;
        while (true) {
            if (i12 >= position) {
                break;
            }
            byte b10 = f532d[array[i12] & UnsignedBytes.MAX_VALUE];
            byte b11 = f533e[(this.f535b * 8) + b10];
            if (b11 == 0) {
                this.f534a = b.a.NOT_ME;
                break;
            }
            int[] iArr = this.f536c;
            iArr[b11] = iArr[b11] + 1;
            this.f535b = b10;
            i12++;
        }
        return this.f534a;
    }

    @Override // ab.b
    public void i() {
        this.f534a = b.a.DETECTING;
        this.f535b = (byte) 1;
        int i10 = 0;
        while (true) {
            int[] iArr = this.f536c;
            if (i10 >= iArr.length) {
                return;
            }
            iArr[i10] = 0;
            i10++;
        }
    }
}
