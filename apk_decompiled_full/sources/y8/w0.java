package y8;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.raizlabs.android.dbflow.sql.language.Operator;
import java.io.InputStream;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* loaded from: classes3.dex */
public final class w0 {

    /* renamed from: a, reason: collision with root package name */
    public final d f20042a;

    /* renamed from: b, reason: collision with root package name */
    public final String f20043b;

    /* renamed from: c, reason: collision with root package name */
    public final String f20044c;

    /* renamed from: d, reason: collision with root package name */
    public final c f20045d;

    /* renamed from: e, reason: collision with root package name */
    public final c f20046e;

    /* renamed from: f, reason: collision with root package name */
    public final Object f20047f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f20048g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f20049h;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f20050i;

    /* renamed from: j, reason: collision with root package name */
    public final AtomicReferenceArray f20051j;

    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public c f20052a;

        /* renamed from: b, reason: collision with root package name */
        public c f20053b;

        /* renamed from: c, reason: collision with root package name */
        public d f20054c;

        /* renamed from: d, reason: collision with root package name */
        public String f20055d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f20056e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f20057f;

        /* renamed from: g, reason: collision with root package name */
        public Object f20058g;

        /* renamed from: h, reason: collision with root package name */
        public boolean f20059h;

        public b() {
        }

        public w0 a() {
            return new w0(this.f20054c, this.f20055d, this.f20052a, this.f20053b, this.f20058g, this.f20056e, this.f20057f, this.f20059h);
        }

        public b b(String str) {
            this.f20055d = str;
            return this;
        }

        public b c(c cVar) {
            this.f20052a = cVar;
            return this;
        }

        public b d(c cVar) {
            this.f20053b = cVar;
            return this;
        }

        public b e(boolean z10) {
            this.f20059h = z10;
            return this;
        }

        public b f(d dVar) {
            this.f20054c = dVar;
            return this;
        }
    }

    public interface c {
        InputStream a(Object obj);

        Object parse(InputStream inputStream);
    }

    public enum d {
        UNARY,
        CLIENT_STREAMING,
        SERVER_STREAMING,
        BIDI_STREAMING,
        UNKNOWN;

        public final boolean a() {
            return this == UNARY || this == SERVER_STREAMING;
        }
    }

    public static String a(String str) {
        int lastIndexOf = ((String) Preconditions.checkNotNull(str, "fullMethodName")).lastIndexOf(47);
        if (lastIndexOf == -1) {
            return null;
        }
        return str.substring(0, lastIndexOf);
    }

    public static String b(String str, String str2) {
        return ((String) Preconditions.checkNotNull(str, "fullServiceName")) + Operator.Operation.DIVISION + ((String) Preconditions.checkNotNull(str2, "methodName"));
    }

    public static b g() {
        return h(null, null);
    }

    public static b h(c cVar, c cVar2) {
        return new b().c(cVar).d(cVar2);
    }

    public String c() {
        return this.f20043b;
    }

    public String d() {
        return this.f20044c;
    }

    public d e() {
        return this.f20042a;
    }

    public boolean f() {
        return this.f20049h;
    }

    public Object i(InputStream inputStream) {
        return this.f20046e.parse(inputStream);
    }

    public InputStream j(Object obj) {
        return this.f20045d.a(obj);
    }

    public String toString() {
        return MoreObjects.toStringHelper(this).add("fullMethodName", this.f20043b).add("type", this.f20042a).add("idempotent", this.f20048g).add("safe", this.f20049h).add("sampledToLocalTracing", this.f20050i).add("requestMarshaller", this.f20045d).add("responseMarshaller", this.f20046e).add("schemaDescriptor", this.f20047f).omitNullValues().toString();
    }

    public w0(d dVar, String str, c cVar, c cVar2, Object obj, boolean z10, boolean z11, boolean z12) {
        this.f20051j = new AtomicReferenceArray(2);
        this.f20042a = (d) Preconditions.checkNotNull(dVar, "type");
        this.f20043b = (String) Preconditions.checkNotNull(str, "fullMethodName");
        this.f20044c = a(str);
        this.f20045d = (c) Preconditions.checkNotNull(cVar, "requestMarshaller");
        this.f20046e = (c) Preconditions.checkNotNull(cVar2, "responseMarshaller");
        this.f20047f = obj;
        this.f20048g = z10;
        this.f20049h = z11;
        this.f20050i = z12;
    }
}
