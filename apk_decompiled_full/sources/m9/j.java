package m9;

import kotlin.coroutines.Continuation;
import t9.x;

/* loaded from: classes3.dex */
public abstract class j extends c implements t9.h {

    /* renamed from: a, reason: collision with root package name */
    public final int f16847a;

    public j(int i10, Continuation continuation) {
        super(continuation);
        this.f16847a = i10;
    }

    @Override // t9.h
    public int getArity() {
        return this.f16847a;
    }

    @Override // m9.a
    public String toString() {
        if (getCompletion() != null) {
            return super.toString();
        }
        String f10 = x.f(this);
        t9.i.f(f10, "renderLambdaToString(this)");
        return f10;
    }
}
