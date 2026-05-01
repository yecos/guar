package c4;

import com.raizlabs.android.dbflow.sql.language.Operator;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/* loaded from: classes.dex */
public class q implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final o f5605a;

    public static final class a extends StringTokenizer {

        /* renamed from: a, reason: collision with root package name */
        public final String f5606a;

        /* renamed from: b, reason: collision with root package name */
        public int f5607b;

        /* renamed from: c, reason: collision with root package name */
        public String f5608c;

        public a(String str) {
            super(str, "<,>", true);
            this.f5606a = str;
        }

        public String a() {
            return this.f5606a;
        }

        public String b() {
            return this.f5606a.substring(this.f5607b);
        }

        public void c(String str) {
            this.f5608c = str;
        }

        @Override // java.util.StringTokenizer
        public boolean hasMoreTokens() {
            return this.f5608c != null || super.hasMoreTokens();
        }

        @Override // java.util.StringTokenizer
        public String nextToken() {
            String str = this.f5608c;
            if (str != null) {
                this.f5608c = null;
                return str;
            }
            String nextToken = super.nextToken();
            this.f5607b += nextToken.length();
            return nextToken.trim();
        }
    }

    public q(o oVar) {
        this.f5605a = oVar;
    }

    public IllegalArgumentException a(a aVar, String str) {
        return new IllegalArgumentException(String.format("Failed to parse type '%s' (remaining: '%s'): %s", aVar.a(), aVar.b(), str));
    }

    public Class b(String str, a aVar) {
        try {
            return this.f5605a.J(str);
        } catch (Exception e10) {
            d4.h.j0(e10);
            throw a(aVar, "Cannot locate class '" + str + "', problem: " + e10.getMessage());
        }
    }

    public k3.j c(String str) {
        a aVar = new a(str.trim());
        k3.j d10 = d(aVar);
        if (aVar.hasMoreTokens()) {
            throw a(aVar, "Unexpected tokens after complete type");
        }
        return d10;
    }

    public k3.j d(a aVar) {
        if (!aVar.hasMoreTokens()) {
            throw a(aVar, "Unexpected end-of-string");
        }
        Class b10 = b(aVar.nextToken(), aVar);
        if (aVar.hasMoreTokens()) {
            String nextToken = aVar.nextToken();
            if (Operator.Operation.LESS_THAN.equals(nextToken)) {
                return this.f5605a.i(null, b10, n.b(b10, e(aVar)));
            }
            aVar.c(nextToken);
        }
        return this.f5605a.i(null, b10, n.i());
    }

    public List e(a aVar) {
        ArrayList arrayList = new ArrayList();
        while (aVar.hasMoreTokens()) {
            arrayList.add(d(aVar));
            if (!aVar.hasMoreTokens()) {
                break;
            }
            String nextToken = aVar.nextToken();
            if (Operator.Operation.GREATER_THAN.equals(nextToken)) {
                return arrayList;
            }
            if (!",".equals(nextToken)) {
                throw a(aVar, "Unexpected token '" + nextToken + "', expected ',' or '>')");
            }
        }
        throw a(aVar, "Unexpected end-of-string");
    }
}
