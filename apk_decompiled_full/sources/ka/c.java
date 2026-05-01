package ka;

import okhttp3.Interceptor;
import okhttp3.Response;

/* loaded from: classes3.dex */
public class c implements Interceptor {

    /* renamed from: a, reason: collision with root package name */
    public d f15715a;

    public c(d dVar) {
        this.f15715a = dVar;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) {
        Response proceed = chain.proceed(chain.request());
        return proceed.newBuilder().body(new e(proceed.body(), this.f15715a)).build();
    }
}
