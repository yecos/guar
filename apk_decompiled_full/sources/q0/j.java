package q0;

import java.io.File;
import t0.c;

/* loaded from: classes.dex */
public class j implements c.InterfaceC0321c {

    /* renamed from: a, reason: collision with root package name */
    public final String f18176a;

    /* renamed from: b, reason: collision with root package name */
    public final File f18177b;

    /* renamed from: c, reason: collision with root package name */
    public final c.InterfaceC0321c f18178c;

    public j(String str, File file, c.InterfaceC0321c interfaceC0321c) {
        this.f18176a = str;
        this.f18177b = file;
        this.f18178c = interfaceC0321c;
    }

    @Override // t0.c.InterfaceC0321c
    public t0.c a(c.b bVar) {
        return new i(bVar.f18790a, this.f18176a, this.f18177b, bVar.f18792c.f18789a, this.f18178c.a(bVar));
    }
}
