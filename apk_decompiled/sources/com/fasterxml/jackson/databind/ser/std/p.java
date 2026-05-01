package com.fasterxml.jackson.databind.ser.std;

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
        To view partially-correct add '--show-bad-code' argument
    */
    public k3.o b(k3.c0 r2, k3.d r3) {
        /*
            r1 = this;
            java.lang.Class r0 = r1.handledType()
            b3.k$d r2 = r1.findFormatOverrides(r2, r3, r0)
            if (r2 == 0) goto L1a
            b3.k$c r2 = r2.i()
            boolean r3 = r2.a()
            if (r3 != 0) goto L18
            b3.k$c r3 = b3.k.c.ARRAY
            if (r2 != r3) goto L1a
        L18:
            r2 = 1
            goto L1b
        L1a:
            r2 = 0
        L1b:
            boolean r3 = r1.f6702a
            if (r2 == r3) goto L25
            com.fasterxml.jackson.databind.ser.std.p r3 = new com.fasterxml.jackson.databind.ser.std.p
            r3.<init>(r2)
            return r3
        L25:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.ser.std.p.b(k3.c0, k3.d):k3.o");
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
