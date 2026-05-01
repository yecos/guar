package d4;

import java.io.Serializable;

/* loaded from: classes.dex */
public abstract class q {

    /* renamed from: a, reason: collision with root package name */
    public static final q f12559a = new e();

    public class a extends q {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f12560b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f12561c;

        public a(String str, String str2) {
            this.f12560b = str;
            this.f12561c = str2;
        }

        @Override // d4.q
        public String c(String str) {
            return this.f12560b + str + this.f12561c;
        }

        public String toString() {
            return "[PreAndSuffixTransformer('" + this.f12560b + "','" + this.f12561c + "')]";
        }
    }

    public class b extends q {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f12562b;

        public b(String str) {
            this.f12562b = str;
        }

        @Override // d4.q
        public String c(String str) {
            return this.f12562b + str;
        }

        public String toString() {
            return "[PrefixTransformer('" + this.f12562b + "')]";
        }
    }

    public class c extends q {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f12563b;

        public c(String str) {
            this.f12563b = str;
        }

        @Override // d4.q
        public String c(String str) {
            return str + this.f12563b;
        }

        public String toString() {
            return "[SuffixTransformer('" + this.f12563b + "')]";
        }
    }

    public static class d extends q implements Serializable {

        /* renamed from: b, reason: collision with root package name */
        public final q f12564b;

        /* renamed from: c, reason: collision with root package name */
        public final q f12565c;

        public d(q qVar, q qVar2) {
            this.f12564b = qVar;
            this.f12565c = qVar2;
        }

        @Override // d4.q
        public String c(String str) {
            return this.f12564b.c(this.f12565c.c(str));
        }

        public String toString() {
            return "[ChainedTransformer(" + this.f12564b + ", " + this.f12565c + ")]";
        }
    }

    public static final class e extends q implements Serializable {
        @Override // d4.q
        public String c(String str) {
            return str;
        }
    }

    public static q a(q qVar, q qVar2) {
        return new d(qVar, qVar2);
    }

    public static q b(String str, String str2) {
        boolean z10 = (str == null || str.isEmpty()) ? false : true;
        boolean z11 = (str2 == null || str2.isEmpty()) ? false : true;
        return z10 ? z11 ? new a(str, str2) : new b(str) : z11 ? new c(str2) : f12559a;
    }

    public abstract String c(String str);
}
