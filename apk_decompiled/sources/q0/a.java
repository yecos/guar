package q0;

import android.content.Context;
import java.io.File;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import q0.e;
import t0.c;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public final c.InterfaceC0321c f18103a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f18104b;

    /* renamed from: c, reason: collision with root package name */
    public final String f18105c;

    /* renamed from: d, reason: collision with root package name */
    public final e.d f18106d;

    /* renamed from: e, reason: collision with root package name */
    public final List f18107e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f18108f;

    /* renamed from: g, reason: collision with root package name */
    public final e.c f18109g;

    /* renamed from: h, reason: collision with root package name */
    public final Executor f18110h;

    /* renamed from: i, reason: collision with root package name */
    public final Executor f18111i;

    /* renamed from: j, reason: collision with root package name */
    public final boolean f18112j;

    /* renamed from: k, reason: collision with root package name */
    public final boolean f18113k;

    /* renamed from: l, reason: collision with root package name */
    public final boolean f18114l;

    /* renamed from: m, reason: collision with root package name */
    public final Set f18115m;

    /* renamed from: n, reason: collision with root package name */
    public final String f18116n;

    /* renamed from: o, reason: collision with root package name */
    public final File f18117o;

    public a(Context context, String str, c.InterfaceC0321c interfaceC0321c, e.d dVar, List list, boolean z10, e.c cVar, Executor executor, Executor executor2, boolean z11, boolean z12, boolean z13, Set set, String str2, File file) {
        this.f18103a = interfaceC0321c;
        this.f18104b = context;
        this.f18105c = str;
        this.f18106d = dVar;
        this.f18107e = list;
        this.f18108f = z10;
        this.f18109g = cVar;
        this.f18110h = executor;
        this.f18111i = executor2;
        this.f18112j = z11;
        this.f18113k = z12;
        this.f18114l = z13;
        this.f18115m = set;
        this.f18116n = str2;
        this.f18117o = file;
    }

    public boolean a(int i10, int i11) {
        Set set;
        return !((i10 > i11) && this.f18114l) && this.f18113k && ((set = this.f18115m) == null || !set.contains(Integer.valueOf(i10)));
    }
}
