package com.umeng.analytics.pro;

/* loaded from: classes3.dex */
public class cf {

    /* renamed from: a, reason: collision with root package name */
    private short[] f10166a;

    /* renamed from: b, reason: collision with root package name */
    private int f10167b = -1;

    public cf(int i10) {
        this.f10166a = new short[i10];
    }

    private void d() {
        short[] sArr = this.f10166a;
        short[] sArr2 = new short[sArr.length * 2];
        System.arraycopy(sArr, 0, sArr2, 0, sArr.length);
        this.f10166a = sArr2;
    }

    public short a() {
        short[] sArr = this.f10166a;
        int i10 = this.f10167b;
        this.f10167b = i10 - 1;
        return sArr[i10];
    }

    public short b() {
        return this.f10166a[this.f10167b];
    }

    public void c() {
        this.f10167b = -1;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("<ShortStack vector:[");
        for (int i10 = 0; i10 < this.f10166a.length; i10++) {
            if (i10 != 0) {
                sb.append(" ");
            }
            if (i10 == this.f10167b) {
                sb.append(">>");
            }
            sb.append((int) this.f10166a[i10]);
            if (i10 == this.f10167b) {
                sb.append("<<");
            }
        }
        sb.append("]>");
        return sb.toString();
    }

    public void a(short s10) {
        if (this.f10166a.length == this.f10167b + 1) {
            d();
        }
        short[] sArr = this.f10166a;
        int i10 = this.f10167b + 1;
        this.f10167b = i10;
        sArr[i10] = s10;
    }
}
