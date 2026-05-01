package com.fasterxml.jackson.databind.ser.std;

import b3.k;
import java.net.InetAddress;

/* loaded from: classes.dex */
public class p extends h0 implements a4.i {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f6702a;

    public p() {
        this(false);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x001f  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0025 A[RETURN] */
    @Override // a4.i
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public k3.o b(k3.c0 c0Var, k3.d dVar) {
        boolean z10;
        k.d findFormatOverrides = findFormatOverrides(c0Var, dVar, handledType());
        if (findFormatOverrides != null) {
            k.c i10 = findFormatOverrides.i();
            if (i10.a() || i10 == k.c.ARRAY) {
                z10 = true;
                return z10 == this.f6702a ? new p(z10) : this;
            }
        }
        z10 = false;
        if (z10 == this.f6702a) {
        }
    }

    @Override // com.fasterxml.jackson.databind.ser.std.i0, k3.o
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void serialize(InetAddress inetAddress, c3.h hVar, k3.c0 c0Var) {
        String trim;
        if (this.f6702a) {
            trim = inetAddress.getHostAddress();
        } else {
            trim = inetAddress.toString().trim();
            int indexOf = trim.indexOf(47);
            if (indexOf >= 0) {
                trim = indexOf == 0 ? trim.substring(1) : trim.substring(0, indexOf);
            }
        }
        hVar.z0(trim);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.h0, k3.o
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void serializeWithType(InetAddress inetAddress, c3.h hVar, k3.c0 c0Var, w3.h hVar2) {
        i3.b g10 = hVar2.g(hVar, hVar2.f(inetAddress, InetAddress.class, c3.n.VALUE_STRING));
        serialize(inetAddress, hVar, c0Var);
        hVar2.h(hVar, g10);
    }

    public p(boolean z10) {
        super(InetAddress.class);
        this.f6702a = z10;
    }
}
