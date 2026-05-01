package r;

import android.graphics.Insets;
import android.graphics.Rect;
import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: e, reason: collision with root package name */
    public static final c f18257e = new c(0, 0, 0, 0);

    /* renamed from: a, reason: collision with root package name */
    public final int f18258a;

    /* renamed from: b, reason: collision with root package name */
    public final int f18259b;

    /* renamed from: c, reason: collision with root package name */
    public final int f18260c;

    /* renamed from: d, reason: collision with root package name */
    public final int f18261d;

    public c(int i10, int i11, int i12, int i13) {
        this.f18258a = i10;
        this.f18259b = i11;
        this.f18260c = i12;
        this.f18261d = i13;
    }

    public static c a(c cVar, c cVar2) {
        return b(Math.max(cVar.f18258a, cVar2.f18258a), Math.max(cVar.f18259b, cVar2.f18259b), Math.max(cVar.f18260c, cVar2.f18260c), Math.max(cVar.f18261d, cVar2.f18261d));
    }

    public static c b(int i10, int i11, int i12, int i13) {
        return (i10 == 0 && i11 == 0 && i12 == 0 && i13 == 0) ? f18257e : new c(i10, i11, i12, i13);
    }

    public static c c(Rect rect) {
        return b(rect.left, rect.top, rect.right, rect.bottom);
    }

    public static c d(Insets insets) {
        int i10;
        int i11;
        int i12;
        int i13;
        i10 = insets.left;
        i11 = insets.top;
        i12 = insets.right;
        i13 = insets.bottom;
        return b(i10, i11, i12, i13);
    }

    public Insets e() {
        Insets of;
        of = Insets.of(this.f18258a, this.f18259b, this.f18260c, this.f18261d);
        return of;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || c.class != obj.getClass()) {
            return false;
        }
        c cVar = (c) obj;
        return this.f18261d == cVar.f18261d && this.f18258a == cVar.f18258a && this.f18260c == cVar.f18260c && this.f18259b == cVar.f18259b;
    }

    public int hashCode() {
        return (((((this.f18258a * 31) + this.f18259b) * 31) + this.f18260c) * 31) + this.f18261d;
    }

    public String toString() {
        return "Insets{left=" + this.f18258a + ", top=" + this.f18259b + ", right=" + this.f18260c + ", bottom=" + this.f18261d + ASCIIPropertyListParser.DICTIONARY_END_TOKEN;
    }
}
