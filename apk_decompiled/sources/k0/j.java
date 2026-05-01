package k0;

import android.text.TextUtils;

/* loaded from: classes.dex */
public class j implements e {

    /* renamed from: a, reason: collision with root package name */
    public String f14728a;

    /* renamed from: b, reason: collision with root package name */
    public int f14729b;

    /* renamed from: c, reason: collision with root package name */
    public int f14730c;

    public j(String str, int i10, int i11) {
        this.f14728a = str;
        this.f14729b = i10;
        this.f14730c = i11;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        return (this.f14729b < 0 || jVar.f14729b < 0) ? TextUtils.equals(this.f14728a, jVar.f14728a) && this.f14730c == jVar.f14730c : TextUtils.equals(this.f14728a, jVar.f14728a) && this.f14729b == jVar.f14729b && this.f14730c == jVar.f14730c;
    }

    public int hashCode() {
        return a0.c.b(this.f14728a, Integer.valueOf(this.f14730c));
    }
}
