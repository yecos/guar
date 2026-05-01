package y;

import a0.h;
import android.util.Base64;
import com.raizlabs.android.dbflow.sql.language.Operator;
import java.util.List;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final String f19671a;

    /* renamed from: b, reason: collision with root package name */
    public final String f19672b;

    /* renamed from: c, reason: collision with root package name */
    public final String f19673c;

    /* renamed from: d, reason: collision with root package name */
    public final List f19674d;

    /* renamed from: e, reason: collision with root package name */
    public final int f19675e = 0;

    /* renamed from: f, reason: collision with root package name */
    public final String f19676f;

    public d(String str, String str2, String str3, List list) {
        this.f19671a = (String) h.d(str);
        this.f19672b = (String) h.d(str2);
        this.f19673c = (String) h.d(str3);
        this.f19674d = (List) h.d(list);
        this.f19676f = a(str, str2, str3);
    }

    public final String a(String str, String str2, String str3) {
        return str + Operator.Operation.MINUS + str2 + Operator.Operation.MINUS + str3;
    }

    public List b() {
        return this.f19674d;
    }

    public int c() {
        return this.f19675e;
    }

    public String d() {
        return this.f19676f;
    }

    public String e() {
        return this.f19671a;
    }

    public String f() {
        return this.f19672b;
    }

    public String g() {
        return this.f19673c;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FontRequest {mProviderAuthority: " + this.f19671a + ", mProviderPackage: " + this.f19672b + ", mQuery: " + this.f19673c + ", mCertificates:");
        for (int i10 = 0; i10 < this.f19674d.size(); i10++) {
            sb.append(" [");
            List list = (List) this.f19674d.get(i10);
            for (int i11 = 0; i11 < list.size(); i11++) {
                sb.append(" \"");
                sb.append(Base64.encodeToString((byte[]) list.get(i11), 0));
                sb.append("\"");
            }
            sb.append(" ]");
        }
        sb.append("}");
        sb.append("mCertificatesArray: " + this.f19675e);
        return sb.toString();
    }
}
