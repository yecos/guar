package o3;

/* loaded from: classes.dex */
public class h extends com.fasterxml.jackson.databind.deser.std.b0 {

    /* renamed from: a, reason: collision with root package name */
    public final String f17529a;

    public h(String str) {
        this(Object.class, str);
    }

    @Override // k3.k
    public Object deserialize(c3.k kVar, k3.g gVar) {
        gVar.z0(this, this.f17529a, new Object[0]);
        return null;
    }

    public h(Class cls, String str) {
        super(cls);
        this.f17529a = str;
    }
}
