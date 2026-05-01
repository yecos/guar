package c3;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.io.Serializable;

/* loaded from: classes.dex */
public class w implements Comparable, Serializable {

    /* renamed from: g, reason: collision with root package name */
    public static final w f5519g = new w(0, 0, 0, null, null, null);

    /* renamed from: a, reason: collision with root package name */
    public final int f5520a;

    /* renamed from: b, reason: collision with root package name */
    public final int f5521b;

    /* renamed from: c, reason: collision with root package name */
    public final int f5522c;

    /* renamed from: d, reason: collision with root package name */
    public final String f5523d;

    /* renamed from: e, reason: collision with root package name */
    public final String f5524e;

    /* renamed from: f, reason: collision with root package name */
    public final String f5525f;

    public w(int i10, int i11, int i12, String str, String str2, String str3) {
        this.f5520a = i10;
        this.f5521b = i11;
        this.f5522c = i12;
        this.f5525f = str;
        this.f5523d = str2 == null ? "" : str2;
        this.f5524e = str3 == null ? "" : str3;
    }

    public static w c() {
        return f5519g;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(w wVar) {
        if (wVar == this) {
            return 0;
        }
        int compareTo = this.f5523d.compareTo(wVar.f5523d);
        if (compareTo != 0) {
            return compareTo;
        }
        int compareTo2 = this.f5524e.compareTo(wVar.f5524e);
        if (compareTo2 != 0) {
            return compareTo2;
        }
        int i10 = this.f5520a - wVar.f5520a;
        if (i10 != 0) {
            return i10;
        }
        int i11 = this.f5521b - wVar.f5521b;
        return i11 == 0 ? this.f5522c - wVar.f5522c : i11;
    }

    public boolean b() {
        String str = this.f5525f;
        return str != null && str.length() > 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        w wVar = (w) obj;
        return wVar.f5520a == this.f5520a && wVar.f5521b == this.f5521b && wVar.f5522c == this.f5522c && wVar.f5524e.equals(this.f5524e) && wVar.f5523d.equals(this.f5523d);
    }

    public int hashCode() {
        return this.f5524e.hashCode() ^ (((this.f5523d.hashCode() + this.f5520a) - this.f5521b) + this.f5522c);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f5520a);
        sb.append('.');
        sb.append(this.f5521b);
        sb.append('.');
        sb.append(this.f5522c);
        if (b()) {
            sb.append(ASCIIPropertyListParser.DATE_DATE_FIELD_DELIMITER);
            sb.append(this.f5525f);
        }
        return sb.toString();
    }
}
