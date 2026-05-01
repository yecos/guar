package k8;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;
import java.util.List;
import l8.h;
import t9.i;
import x8.a;

/* loaded from: classes3.dex */
public final class a extends x8.a {

    /* renamed from: l, reason: collision with root package name */
    public final String f15693l;

    /* renamed from: m, reason: collision with root package name */
    public Gson f15694m;

    /* renamed from: n, reason: collision with root package name */
    public Gson f15695n;

    public a(int i10) {
        super(i10);
        String simpleName = a.class.getSimpleName();
        i.c(simpleName, "javaClass.simpleName");
        this.f15693l = simpleName;
        this.f15694m = new Gson();
        this.f15695n = new GsonBuilder().setPrettyPrinting().create();
    }

    @Override // x8.a
    public a.m p(a.k kVar) {
        return u(kVar);
    }

    public final a.m u(a.k kVar) {
        if (a.l.GET != (kVar != null ? kVar.getMethod() : null) || !i.b("/playinfo", kVar.a())) {
            return v(404, "", "Request not support!");
        }
        List list = (List) kVar.getParameters().get("instance");
        int parseInt = Integer.parseInt(String.valueOf(list != null ? (String) list.get(0) : null));
        return v(200, new JsonParser().parse(h.f16357m.a().n(parseInt)), "Request successfully:" + parseInt);
    }

    public final a.m v(int i10, Object obj, String str) {
        a.m l10 = x8.a.l(this.f15695n.toJson(new b(i10, obj, str)));
        i.c(l10, "newFixedLengthResponse(m…ttyGson.toJson(response))");
        return l10;
    }
}
