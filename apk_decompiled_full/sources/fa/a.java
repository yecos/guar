package fa;

import io.reactivex.functions.Function;
import retrofit2.adapter.rxjava2.HttpException;

/* loaded from: classes3.dex */
public abstract class a implements Function {

    /* renamed from: a, reason: collision with root package name */
    public int f13418a = 200;

    public abstract Object a(Object obj);

    @Override // io.reactivex.functions.Function
    public Object apply(Object obj) {
        b((Throwable) obj);
        return a(obj);
    }

    public final void b(Throwable th) {
        if (th == null || !(th instanceof HttpException)) {
            this.f13418a = -1;
        } else {
            this.f13418a = ((HttpException) th).code();
        }
    }
}
