package b4;

import com.fasterxml.jackson.databind.ser.std.i0;
import k3.c0;

/* loaded from: classes.dex */
public class c extends i0 {

    /* renamed from: a, reason: collision with root package name */
    public final String f4586a;

    public c(String str) {
        super(Object.class);
        this.f4586a = str;
    }

    @Override // com.fasterxml.jackson.databind.ser.std.i0, k3.o
    public void serialize(Object obj, c3.h hVar, c0 c0Var) {
        c0Var.r0(this.f4586a, new Object[0]);
    }
}
