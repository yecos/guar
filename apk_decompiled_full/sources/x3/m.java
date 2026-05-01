package x3;

/* loaded from: classes.dex */
public class m extends k {

    /* renamed from: d, reason: collision with root package name */
    public final String f19426d;

    /* renamed from: e, reason: collision with root package name */
    public final String f19427e;

    public m(k3.j jVar, c4.o oVar, w3.c cVar) {
        super(jVar, oVar, cVar);
        String name = jVar.q().getName();
        int lastIndexOf = name.lastIndexOf(46);
        if (lastIndexOf < 0) {
            this.f19426d = "";
            this.f19427e = ".";
        } else {
            this.f19427e = name.substring(0, lastIndexOf + 1);
            this.f19426d = name.substring(0, lastIndexOf);
        }
    }

    public static m j(k3.j jVar, m3.m mVar, w3.c cVar) {
        return new m(jVar, mVar.z(), cVar);
    }

    @Override // x3.k, w3.f
    public String a(Object obj) {
        String name = obj.getClass().getName();
        return name.startsWith(this.f19427e) ? name.substring(this.f19427e.length() - 1) : name;
    }

    @Override // x3.k
    public k3.j h(String str, k3.e eVar) {
        if (str.startsWith(".")) {
            StringBuilder sb = new StringBuilder(str.length() + this.f19426d.length());
            if (this.f19426d.isEmpty()) {
                sb.append(str.substring(1));
            } else {
                sb.append(this.f19426d);
                sb.append(str);
            }
            str = sb.toString();
        }
        return super.h(str, eVar);
    }
}
