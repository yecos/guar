package b4;

import com.fasterxml.jackson.databind.ser.std.i0;
import k3.c0;

/* loaded from: classes.dex */
public class q extends i0 {

    /* renamed from: a, reason: collision with root package name */
    public final k3.j f4639a;

    /* renamed from: b, reason: collision with root package name */
    public final String f4640b;

    public q(k3.j jVar, String str) {
        super(Object.class);
        this.f4639a = jVar;
        this.f4640b = str;
    }

    @Override // com.fasterxml.jackson.databind.ser.std.i0, k3.o
    public void serialize(Object obj, c3.h hVar, c0 c0Var) {
        c0Var.q(this.f4639a, this.f4640b);
    }
}
