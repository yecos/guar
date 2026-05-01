package j3;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.io.Serializable;

/* loaded from: classes.dex */
public class l implements c3.p, Serializable {

    /* renamed from: a, reason: collision with root package name */
    public String f14666a;

    /* renamed from: b, reason: collision with root package name */
    public n f14667b;

    public l() {
        this(c3.p.T.toString());
    }

    @Override // c3.p
    public void a(c3.h hVar) {
        hVar.m0(this.f14667b.c());
    }

    @Override // c3.p
    public void b(c3.h hVar) {
        hVar.m0('[');
    }

    @Override // c3.p
    public void c(c3.h hVar) {
    }

    @Override // c3.p
    public void d(c3.h hVar, int i10) {
        hVar.m0(']');
    }

    @Override // c3.p
    public void e(c3.h hVar) {
        hVar.m0(ASCIIPropertyListParser.DICTIONARY_BEGIN_TOKEN);
    }

    @Override // c3.p
    public void g(c3.h hVar) {
        hVar.m0(this.f14667b.b());
    }

    @Override // c3.p
    public void h(c3.h hVar) {
        hVar.m0(this.f14667b.d());
    }

    @Override // c3.p
    public void i(c3.h hVar, int i10) {
        hVar.m0(ASCIIPropertyListParser.DICTIONARY_END_TOKEN);
    }

    @Override // c3.p
    public void j(c3.h hVar) {
        String str = this.f14666a;
        if (str != null) {
            hVar.o0(str);
        }
    }

    @Override // c3.p
    public void k(c3.h hVar) {
    }

    public l(String str) {
        this.f14666a = str;
        this.f14667b = c3.p.R;
    }
}
