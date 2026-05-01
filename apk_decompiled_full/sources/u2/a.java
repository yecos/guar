package u2;

import io.reactivex.functions.Function;
import retrofit2.HttpException;

/* loaded from: classes.dex */
public abstract class a implements Function {

    /* renamed from: a, reason: collision with root package name */
    public int f19022a = 200;

    public abstract Object a(Object obj);

    @Override // io.reactivex.functions.Function
    public Object apply(Object obj) {
        c((Throwable) obj);
        return a(obj);
    }

    public int b() {
        return this.f19022a;
    }

    public final void c(Throwable th) {
        if (th == null || !(th instanceof HttpException)) {
            this.f19022a = -1;
        } else {
            this.f19022a = ((HttpException) th).code();
        }
    }
}
