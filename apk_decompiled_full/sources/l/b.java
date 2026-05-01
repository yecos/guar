package l;

import com.google.firebase.crashlytics.internal.common.IdManager;
import l.e;
import l.i;

/* loaded from: classes.dex */
public class b implements e.a {

    /* renamed from: d, reason: collision with root package name */
    public final a f15847d;

    /* renamed from: a, reason: collision with root package name */
    public i f15844a = null;

    /* renamed from: b, reason: collision with root package name */
    public float f15845b = 0.0f;

    /* renamed from: c, reason: collision with root package name */
    public boolean f15846c = false;

    /* renamed from: e, reason: collision with root package name */
    public boolean f15848e = false;

    public b(c cVar) {
        this.f15847d = new a(this, cVar);
    }

    @Override // l.e.a
    public i a(e eVar, boolean[] zArr) {
        return this.f15847d.g(zArr, null);
    }

    @Override // l.e.a
    public void b(e.a aVar) {
        if (!(aVar instanceof b)) {
            return;
        }
        b bVar = (b) aVar;
        this.f15844a = null;
        this.f15847d.c();
        int i10 = 0;
        while (true) {
            a aVar2 = bVar.f15847d;
            if (i10 >= aVar2.f15833a) {
                return;
            }
            this.f15847d.a(aVar2.h(i10), bVar.f15847d.i(i10), true);
            i10++;
        }
    }

    @Override // l.e.a
    public void c(i iVar) {
        int i10 = iVar.f15875d;
        float f10 = 1.0f;
        if (i10 != 1) {
            if (i10 == 2) {
                f10 = 1000.0f;
            } else if (i10 == 3) {
                f10 = 1000000.0f;
            } else if (i10 == 4) {
                f10 = 1.0E9f;
            } else if (i10 == 5) {
                f10 = 1.0E12f;
            }
        }
        this.f15847d.l(iVar, f10);
    }

    @Override // l.e.a
    public void clear() {
        this.f15847d.c();
        this.f15844a = null;
        this.f15845b = 0.0f;
    }

    public b d(e eVar, int i10) {
        this.f15847d.l(eVar.p(i10, "ep"), 1.0f);
        this.f15847d.l(eVar.p(i10, "em"), -1.0f);
        return this;
    }

    public b e(i iVar, int i10) {
        this.f15847d.l(iVar, i10);
        return this;
    }

    public boolean f(e eVar) {
        boolean z10;
        i b10 = this.f15847d.b(eVar);
        if (b10 == null) {
            z10 = true;
        } else {
            v(b10);
            z10 = false;
        }
        if (this.f15847d.f15833a == 0) {
            this.f15848e = true;
        }
        return z10;
    }

    public b g(i iVar, i iVar2, int i10, float f10, i iVar3, i iVar4, int i11) {
        if (iVar2 == iVar3) {
            this.f15847d.l(iVar, 1.0f);
            this.f15847d.l(iVar4, 1.0f);
            this.f15847d.l(iVar2, -2.0f);
            return this;
        }
        if (f10 == 0.5f) {
            this.f15847d.l(iVar, 1.0f);
            this.f15847d.l(iVar2, -1.0f);
            this.f15847d.l(iVar3, -1.0f);
            this.f15847d.l(iVar4, 1.0f);
            if (i10 > 0 || i11 > 0) {
                this.f15845b = (-i10) + i11;
            }
        } else if (f10 <= 0.0f) {
            this.f15847d.l(iVar, -1.0f);
            this.f15847d.l(iVar2, 1.0f);
            this.f15845b = i10;
        } else if (f10 >= 1.0f) {
            this.f15847d.l(iVar3, -1.0f);
            this.f15847d.l(iVar4, 1.0f);
            this.f15845b = i11;
        } else {
            float f11 = 1.0f - f10;
            this.f15847d.l(iVar, f11 * 1.0f);
            this.f15847d.l(iVar2, f11 * (-1.0f));
            this.f15847d.l(iVar3, (-1.0f) * f10);
            this.f15847d.l(iVar4, 1.0f * f10);
            if (i10 > 0 || i11 > 0) {
                this.f15845b = ((-i10) * f11) + (i11 * f10);
            }
        }
        return this;
    }

    @Override // l.e.a
    public i getKey() {
        return this.f15844a;
    }

    public b h(i iVar, int i10) {
        this.f15844a = iVar;
        float f10 = i10;
        iVar.f15876e = f10;
        this.f15845b = f10;
        this.f15848e = true;
        return this;
    }

    public b i(i iVar, i iVar2, i iVar3, float f10) {
        this.f15847d.l(iVar, -1.0f);
        this.f15847d.l(iVar2, 1.0f - f10);
        this.f15847d.l(iVar3, f10);
        return this;
    }

    public b j(i iVar, i iVar2, i iVar3, i iVar4, float f10) {
        this.f15847d.l(iVar, -1.0f);
        this.f15847d.l(iVar2, 1.0f);
        this.f15847d.l(iVar3, f10);
        this.f15847d.l(iVar4, -f10);
        return this;
    }

    public b k(float f10, float f11, float f12, i iVar, i iVar2, i iVar3, i iVar4) {
        this.f15845b = 0.0f;
        if (f11 == 0.0f || f10 == f12) {
            this.f15847d.l(iVar, 1.0f);
            this.f15847d.l(iVar2, -1.0f);
            this.f15847d.l(iVar4, 1.0f);
            this.f15847d.l(iVar3, -1.0f);
        } else if (f10 == 0.0f) {
            this.f15847d.l(iVar, 1.0f);
            this.f15847d.l(iVar2, -1.0f);
        } else if (f12 == 0.0f) {
            this.f15847d.l(iVar3, 1.0f);
            this.f15847d.l(iVar4, -1.0f);
        } else {
            float f13 = (f10 / f11) / (f12 / f11);
            this.f15847d.l(iVar, 1.0f);
            this.f15847d.l(iVar2, -1.0f);
            this.f15847d.l(iVar4, f13);
            this.f15847d.l(iVar3, -f13);
        }
        return this;
    }

    public b l(i iVar, int i10) {
        if (i10 < 0) {
            this.f15845b = i10 * (-1);
            this.f15847d.l(iVar, 1.0f);
        } else {
            this.f15845b = i10;
            this.f15847d.l(iVar, -1.0f);
        }
        return this;
    }

    public b m(i iVar, i iVar2, int i10) {
        boolean z10 = false;
        if (i10 != 0) {
            if (i10 < 0) {
                i10 *= -1;
                z10 = true;
            }
            this.f15845b = i10;
        }
        if (z10) {
            this.f15847d.l(iVar, 1.0f);
            this.f15847d.l(iVar2, -1.0f);
        } else {
            this.f15847d.l(iVar, -1.0f);
            this.f15847d.l(iVar2, 1.0f);
        }
        return this;
    }

    public b n(i iVar, i iVar2, i iVar3, int i10) {
        boolean z10 = false;
        if (i10 != 0) {
            if (i10 < 0) {
                i10 *= -1;
                z10 = true;
            }
            this.f15845b = i10;
        }
        if (z10) {
            this.f15847d.l(iVar, 1.0f);
            this.f15847d.l(iVar2, -1.0f);
            this.f15847d.l(iVar3, -1.0f);
        } else {
            this.f15847d.l(iVar, -1.0f);
            this.f15847d.l(iVar2, 1.0f);
            this.f15847d.l(iVar3, 1.0f);
        }
        return this;
    }

    public b o(i iVar, i iVar2, i iVar3, int i10) {
        boolean z10 = false;
        if (i10 != 0) {
            if (i10 < 0) {
                i10 *= -1;
                z10 = true;
            }
            this.f15845b = i10;
        }
        if (z10) {
            this.f15847d.l(iVar, 1.0f);
            this.f15847d.l(iVar2, -1.0f);
            this.f15847d.l(iVar3, 1.0f);
        } else {
            this.f15847d.l(iVar, -1.0f);
            this.f15847d.l(iVar2, 1.0f);
            this.f15847d.l(iVar3, -1.0f);
        }
        return this;
    }

    public b p(i iVar, i iVar2, i iVar3, i iVar4, float f10) {
        this.f15847d.l(iVar3, 0.5f);
        this.f15847d.l(iVar4, 0.5f);
        this.f15847d.l(iVar, -0.5f);
        this.f15847d.l(iVar2, -0.5f);
        this.f15845b = -f10;
        return this;
    }

    public void q() {
        float f10 = this.f15845b;
        if (f10 < 0.0f) {
            this.f15845b = f10 * (-1.0f);
            this.f15847d.j();
        }
    }

    public boolean r() {
        i iVar = this.f15844a;
        return iVar != null && (iVar.f15878g == i.a.UNRESTRICTED || this.f15845b >= 0.0f);
    }

    public boolean s(i iVar) {
        return this.f15847d.d(iVar);
    }

    public boolean t() {
        return this.f15844a == null && this.f15845b == 0.0f && this.f15847d.f15833a == 0;
    }

    public String toString() {
        return x();
    }

    public i u(i iVar) {
        return this.f15847d.g(null, iVar);
    }

    public void v(i iVar) {
        i iVar2 = this.f15844a;
        if (iVar2 != null) {
            this.f15847d.l(iVar2, -1.0f);
            this.f15844a = null;
        }
        float m10 = this.f15847d.m(iVar, true) * (-1.0f);
        this.f15844a = iVar;
        if (m10 == 1.0f) {
            return;
        }
        this.f15845b /= m10;
        this.f15847d.e(m10);
    }

    public void w() {
        this.f15844a = null;
        this.f15847d.c();
        this.f15845b = 0.0f;
        this.f15848e = false;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00d0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String x() {
        boolean z10;
        String str = (this.f15844a == null ? "0" : "" + this.f15844a) + " = ";
        if (this.f15845b != 0.0f) {
            str = str + this.f15845b;
            z10 = true;
        } else {
            z10 = false;
        }
        int i10 = this.f15847d.f15833a;
        for (int i11 = 0; i11 < i10; i11++) {
            i h10 = this.f15847d.h(i11);
            if (h10 != null) {
                float i12 = this.f15847d.i(i11);
                if (i12 != 0.0f) {
                    String iVar = h10.toString();
                    if (!z10) {
                        if (i12 < 0.0f) {
                            str = str + "- ";
                            i12 *= -1.0f;
                        }
                        str = i12 == 1.0f ? str + iVar : str + i12 + " " + iVar;
                        z10 = true;
                    } else if (i12 > 0.0f) {
                        str = str + " + ";
                        if (i12 == 1.0f) {
                        }
                        z10 = true;
                    } else {
                        str = str + " - ";
                        i12 *= -1.0f;
                        if (i12 == 1.0f) {
                        }
                        z10 = true;
                    }
                }
            }
        }
        if (z10) {
            return str;
        }
        return str + IdManager.DEFAULT_VERSION_NAME;
    }
}
