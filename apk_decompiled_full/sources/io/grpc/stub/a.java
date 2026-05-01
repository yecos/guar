package io.grpc.stub;

import io.grpc.stub.d;
import io.grpc.stub.g;

/* loaded from: classes3.dex */
public abstract class a extends d {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    public a(y8.d dVar, y8.c cVar) {
        super(dVar, cVar);
    }

    public static <T extends d> T newStub(d.a aVar, y8.d dVar) {
        return (T) newStub(aVar, dVar, y8.c.f19794k);
    }

    public static <T extends d> T newStub(d.a aVar, y8.d dVar, y8.c cVar) {
        return (T) aVar.newStub(dVar, cVar.s(g.f14426c, g.f.ASYNC));
    }
}
