package c3;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.io.Serializable;
import java.nio.charset.Charset;

/* loaded from: classes.dex */
public class i implements Serializable {

    /* renamed from: f, reason: collision with root package name */
    public static final i f5449f = new i(null, -1, -1, -1, -1);

    /* renamed from: a, reason: collision with root package name */
    public final long f5450a;

    /* renamed from: b, reason: collision with root package name */
    public final long f5451b;

    /* renamed from: c, reason: collision with root package name */
    public final int f5452c;

    /* renamed from: d, reason: collision with root package name */
    public final int f5453d;

    /* renamed from: e, reason: collision with root package name */
    public final transient Object f5454e;

    public i(Object obj, long j10, int i10, int i11) {
        this(obj, -1L, j10, i10, i11);
    }

    public final int a(StringBuilder sb, String str) {
        sb.append('\"');
        sb.append(str);
        sb.append('\"');
        return str.length();
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0098  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public StringBuilder b(StringBuilder sb) {
        int length;
        int a10;
        Object obj = this.f5454e;
        if (obj == null) {
            sb.append("UNKNOWN");
            return sb;
        }
        Class<?> cls = obj instanceof Class ? (Class) obj : obj.getClass();
        String name = cls.getName();
        if (name.startsWith("java.")) {
            name = cls.getSimpleName();
        } else if (obj instanceof byte[]) {
            name = "byte[]";
        } else if (obj instanceof char[]) {
            name = "char[]";
        }
        sb.append(ASCIIPropertyListParser.ARRAY_BEGIN_TOKEN);
        sb.append(name);
        sb.append(ASCIIPropertyListParser.ARRAY_END_TOKEN);
        int i10 = 0;
        String str = " chars";
        if (obj instanceof CharSequence) {
            CharSequence charSequence = (CharSequence) obj;
            length = charSequence.length();
            a10 = a(sb, charSequence.subSequence(0, Math.min(length, 500)).toString());
        } else {
            if (!(obj instanceof char[])) {
                if (obj instanceof byte[]) {
                    byte[] bArr = (byte[]) obj;
                    int min = Math.min(bArr.length, 500);
                    a(sb, new String(bArr, 0, min, Charset.forName("UTF-8")));
                    i10 = bArr.length - min;
                    str = " bytes";
                }
                if (i10 > 0) {
                    sb.append("[truncated ");
                    sb.append(i10);
                    sb.append(str);
                    sb.append(']');
                }
                return sb;
            }
            char[] cArr = (char[]) obj;
            length = cArr.length;
            a10 = a(sb, new String(cArr, 0, Math.min(length, 500)));
        }
        i10 = length - a10;
        if (i10 > 0) {
        }
        return sb;
    }

    public long c() {
        return this.f5450a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        Object obj2 = this.f5454e;
        if (obj2 == null) {
            if (iVar.f5454e != null) {
                return false;
            }
        } else if (!obj2.equals(iVar.f5454e)) {
            return false;
        }
        return this.f5452c == iVar.f5452c && this.f5453d == iVar.f5453d && this.f5451b == iVar.f5451b && c() == iVar.c();
    }

    public int hashCode() {
        Object obj = this.f5454e;
        return ((((obj == null ? 1 : obj.hashCode()) ^ this.f5452c) + this.f5453d) ^ ((int) this.f5451b)) + ((int) this.f5450a);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(80);
        sb.append("[Source: ");
        b(sb);
        sb.append("; line: ");
        sb.append(this.f5452c);
        sb.append(", column: ");
        sb.append(this.f5453d);
        sb.append(']');
        return sb.toString();
    }

    public i(Object obj, long j10, long j11, int i10, int i11) {
        this.f5454e = obj;
        this.f5450a = j10;
        this.f5451b = j11;
        this.f5452c = i10;
        this.f5453d = i11;
    }
}
