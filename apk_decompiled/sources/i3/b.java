package i3;

import c3.n;

/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public Object f14298a;

    /* renamed from: b, reason: collision with root package name */
    public Class f14299b;

    /* renamed from: c, reason: collision with root package name */
    public Object f14300c;

    /* renamed from: d, reason: collision with root package name */
    public String f14301d;

    /* renamed from: e, reason: collision with root package name */
    public a f14302e;

    /* renamed from: f, reason: collision with root package name */
    public n f14303f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f14304g;

    public enum a {
        WRAPPER_ARRAY,
        WRAPPER_OBJECT,
        METADATA_PROPERTY,
        PAYLOAD_PROPERTY,
        PARENT_PROPERTY;

        public boolean a() {
            return this == METADATA_PROPERTY || this == PAYLOAD_PROPERTY;
        }
    }

    public b(Object obj, n nVar) {
        this(obj, nVar, null);
    }

    public b(Object obj, n nVar, Object obj2) {
        this.f14298a = obj;
        this.f14300c = obj2;
        this.f14303f = nVar;
    }
}
