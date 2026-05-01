package o3;

import java.util.Map;

/* loaded from: classes.dex */
public abstract class x {

    /* renamed from: a, reason: collision with root package name */
    public final x f17576a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f17577b;

    public static final class a extends x {

        /* renamed from: c, reason: collision with root package name */
        public final n3.s f17578c;

        /* renamed from: d, reason: collision with root package name */
        public final String f17579d;

        public a(x xVar, Object obj, n3.s sVar, String str) {
            super(xVar, obj);
            this.f17578c = sVar;
            this.f17579d = str;
        }

        @Override // o3.x
        public void a(Object obj) {
            this.f17578c.i(obj, this.f17579d, this.f17577b);
        }
    }

    public static final class b extends x {

        /* renamed from: c, reason: collision with root package name */
        public final Object f17580c;

        public b(x xVar, Object obj, Object obj2) {
            super(xVar, obj);
            this.f17580c = obj2;
        }

        @Override // o3.x
        public void a(Object obj) {
            ((Map) obj).put(this.f17580c, this.f17577b);
        }
    }

    public static final class c extends x {

        /* renamed from: c, reason: collision with root package name */
        public final n3.t f17581c;

        public c(x xVar, Object obj, n3.t tVar) {
            super(xVar, obj);
            this.f17581c = tVar;
        }

        @Override // o3.x
        public void a(Object obj) {
            this.f17581c.C(obj, this.f17577b);
        }
    }

    public x(x xVar, Object obj) {
        this.f17576a = xVar;
        this.f17577b = obj;
    }

    public abstract void a(Object obj);
}
