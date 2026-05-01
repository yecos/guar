package com.umeng.analytics.pro;

import com.umeng.analytics.pro.da;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/* loaded from: classes3.dex */
public class ck {

    /* renamed from: a, reason: collision with root package name */
    private final dg f10182a;

    /* renamed from: b, reason: collision with root package name */
    private final dt f10183b;

    public ck() {
        this(new da.a());
    }

    private db j(byte[] bArr, co coVar, co... coVarArr) {
        this.f10183b.a(bArr);
        int length = coVarArr.length + 1;
        co[] coVarArr2 = new co[length];
        int i10 = 0;
        coVarArr2[0] = coVar;
        int i11 = 0;
        while (i11 < coVarArr.length) {
            int i12 = i11 + 1;
            coVarArr2[i12] = coVarArr[i11];
            i11 = i12;
        }
        this.f10182a.j();
        db dbVar = null;
        while (i10 < length) {
            dbVar = this.f10182a.l();
            if (dbVar.f10263b == 0 || dbVar.f10264c > coVarArr2[i10].a()) {
                return null;
            }
            if (dbVar.f10264c != coVarArr2[i10].a()) {
                dj.a(this.f10182a, dbVar.f10263b);
                this.f10182a.m();
            } else {
                i10++;
                if (i10 < length) {
                    this.f10182a.j();
                }
            }
        }
        return dbVar;
    }

    public void a(ch chVar, byte[] bArr) {
        try {
            this.f10183b.a(bArr);
            chVar.read(this.f10182a);
        } finally {
            this.f10183b.e();
            this.f10182a.B();
        }
    }

    public Byte b(byte[] bArr, co coVar, co... coVarArr) {
        return (Byte) a((byte) 3, bArr, coVar, coVarArr);
    }

    public Double c(byte[] bArr, co coVar, co... coVarArr) {
        return (Double) a((byte) 4, bArr, coVar, coVarArr);
    }

    public Short d(byte[] bArr, co coVar, co... coVarArr) {
        return (Short) a((byte) 6, bArr, coVar, coVarArr);
    }

    public Integer e(byte[] bArr, co coVar, co... coVarArr) {
        return (Integer) a((byte) 8, bArr, coVar, coVarArr);
    }

    public Long f(byte[] bArr, co coVar, co... coVarArr) {
        return (Long) a((byte) 10, bArr, coVar, coVarArr);
    }

    public String g(byte[] bArr, co coVar, co... coVarArr) {
        return (String) a((byte) 11, bArr, coVar, coVarArr);
    }

    public ByteBuffer h(byte[] bArr, co coVar, co... coVarArr) {
        return (ByteBuffer) a((byte) 100, bArr, coVar, coVarArr);
    }

    public Short i(byte[] bArr, co coVar, co... coVarArr) {
        try {
            try {
                if (j(bArr, coVar, coVarArr) != null) {
                    this.f10182a.j();
                    return Short.valueOf(this.f10182a.l().f10264c);
                }
                this.f10183b.e();
                this.f10182a.B();
                return null;
            } catch (Exception e10) {
                throw new cn(e10);
            }
        } finally {
            this.f10183b.e();
            this.f10182a.B();
        }
    }

    public ck(di diVar) {
        dt dtVar = new dt();
        this.f10183b = dtVar;
        this.f10182a = diVar.a(dtVar);
    }

    public void a(ch chVar, String str, String str2) {
        try {
            try {
                a(chVar, str.getBytes(str2));
            } catch (UnsupportedEncodingException unused) {
                throw new cn("JVM DOES NOT SUPPORT ENCODING: " + str2);
            }
        } finally {
            this.f10182a.B();
        }
    }

    public void a(ch chVar, byte[] bArr, co coVar, co... coVarArr) {
        try {
            try {
                if (j(bArr, coVar, coVarArr) != null) {
                    chVar.read(this.f10182a);
                }
            } catch (Exception e10) {
                throw new cn(e10);
            }
        } finally {
            this.f10183b.e();
            this.f10182a.B();
        }
    }

    public Boolean a(byte[] bArr, co coVar, co... coVarArr) {
        return (Boolean) a((byte) 2, bArr, coVar, coVarArr);
    }

    private Object a(byte b10, byte[] bArr, co coVar, co... coVarArr) {
        try {
            try {
                db j10 = j(bArr, coVar, coVarArr);
                if (j10 != null) {
                    if (b10 != 2) {
                        if (b10 != 3) {
                            if (b10 != 4) {
                                if (b10 != 6) {
                                    if (b10 != 8) {
                                        if (b10 != 100) {
                                            if (b10 != 10) {
                                                if (b10 == 11 && j10.f10263b == 11) {
                                                    return this.f10182a.z();
                                                }
                                            } else if (j10.f10263b == 10) {
                                                return Long.valueOf(this.f10182a.x());
                                            }
                                        } else if (j10.f10263b == 11) {
                                            return this.f10182a.A();
                                        }
                                    } else if (j10.f10263b == 8) {
                                        return Integer.valueOf(this.f10182a.w());
                                    }
                                } else if (j10.f10263b == 6) {
                                    return Short.valueOf(this.f10182a.v());
                                }
                            } else if (j10.f10263b == 4) {
                                return Double.valueOf(this.f10182a.y());
                            }
                        } else if (j10.f10263b == 3) {
                            return Byte.valueOf(this.f10182a.u());
                        }
                    } else if (j10.f10263b == 2) {
                        return Boolean.valueOf(this.f10182a.t());
                    }
                }
                this.f10183b.e();
                this.f10182a.B();
                return null;
            } catch (Exception e10) {
                throw new cn(e10);
            }
        } finally {
            this.f10183b.e();
            this.f10182a.B();
        }
    }

    public void a(ch chVar, String str) {
        a(chVar, str.getBytes());
    }
}
