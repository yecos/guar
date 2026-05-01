package retrofit2;

import ca.n0;
import com.google.firebase.analytics.FirebaseAnalytics;
import h9.l;
import h9.t;
import java.lang.reflect.Method;
import kotlin.coroutines.Continuation;

/* loaded from: classes2.dex */
public final class KotlinExtensions {
    public static final <T> Object await(Call<T> call, Continuation<? super T> continuation) {
        final ca.k kVar = new ca.k(l9.b.b(continuation), 1);
        kVar.g(new KotlinExtensions$await$$inlined$suspendCancellableCoroutine$lambda$1(call));
        call.enqueue(new Callback<T>() { // from class: retrofit2.KotlinExtensions$await$2$2
            @Override // retrofit2.Callback
            public void onFailure(Call<T> call2, Throwable th) {
                t9.i.h(call2, "call");
                t9.i.h(th, "t");
                ca.j jVar = ca.j.this;
                l.a aVar = h9.l.f14231a;
                jVar.resumeWith(h9.l.a(h9.m.a(th)));
            }

            @Override // retrofit2.Callback
            public void onResponse(Call<T> call2, Response<T> response) {
                t9.i.h(call2, "call");
                t9.i.h(response, "response");
                if (!response.isSuccessful()) {
                    ca.j jVar = ca.j.this;
                    HttpException httpException = new HttpException(response);
                    l.a aVar = h9.l.f14231a;
                    jVar.resumeWith(h9.l.a(h9.m.a(httpException)));
                    return;
                }
                T body = response.body();
                if (body != null) {
                    ca.j.this.resumeWith(h9.l.a(body));
                    return;
                }
                Object tag = call2.request().tag(Invocation.class);
                if (tag == null) {
                    t9.i.q();
                }
                t9.i.c(tag, "call.request().tag(Invocation::class.java)!!");
                Method method = ((Invocation) tag).method();
                StringBuilder sb = new StringBuilder();
                sb.append("Response from ");
                t9.i.c(method, FirebaseAnalytics.Param.METHOD);
                Class<?> declaringClass = method.getDeclaringClass();
                t9.i.c(declaringClass, "method.declaringClass");
                sb.append(declaringClass.getName());
                sb.append('.');
                sb.append(method.getName());
                sb.append(" was null but response body type was declared as non-null");
                h9.d dVar = new h9.d(sb.toString());
                ca.j jVar2 = ca.j.this;
                l.a aVar2 = h9.l.f14231a;
                jVar2.resumeWith(h9.l.a(h9.m.a(dVar)));
            }
        });
        Object r10 = kVar.r();
        if (r10 == l9.c.c()) {
            m9.g.c(continuation);
        }
        return r10;
    }

    public static final <T> Object awaitNullable(Call<T> call, Continuation<? super T> continuation) {
        final ca.k kVar = new ca.k(l9.b.b(continuation), 1);
        kVar.g(new KotlinExtensions$await$$inlined$suspendCancellableCoroutine$lambda$2(call));
        call.enqueue(new Callback<T>() { // from class: retrofit2.KotlinExtensions$await$4$2
            @Override // retrofit2.Callback
            public void onFailure(Call<T> call2, Throwable th) {
                t9.i.h(call2, "call");
                t9.i.h(th, "t");
                ca.j jVar = ca.j.this;
                l.a aVar = h9.l.f14231a;
                jVar.resumeWith(h9.l.a(h9.m.a(th)));
            }

            @Override // retrofit2.Callback
            public void onResponse(Call<T> call2, Response<T> response) {
                t9.i.h(call2, "call");
                t9.i.h(response, "response");
                if (response.isSuccessful()) {
                    ca.j.this.resumeWith(h9.l.a(response.body()));
                    return;
                }
                ca.j jVar = ca.j.this;
                HttpException httpException = new HttpException(response);
                l.a aVar = h9.l.f14231a;
                jVar.resumeWith(h9.l.a(h9.m.a(httpException)));
            }
        });
        Object r10 = kVar.r();
        if (r10 == l9.c.c()) {
            m9.g.c(continuation);
        }
        return r10;
    }

    public static final <T> Object awaitResponse(Call<T> call, Continuation<? super Response<T>> continuation) {
        final ca.k kVar = new ca.k(l9.b.b(continuation), 1);
        kVar.g(new KotlinExtensions$awaitResponse$$inlined$suspendCancellableCoroutine$lambda$1(call));
        call.enqueue(new Callback<T>() { // from class: retrofit2.KotlinExtensions$awaitResponse$2$2
            @Override // retrofit2.Callback
            public void onFailure(Call<T> call2, Throwable th) {
                t9.i.h(call2, "call");
                t9.i.h(th, "t");
                ca.j jVar = ca.j.this;
                l.a aVar = h9.l.f14231a;
                jVar.resumeWith(h9.l.a(h9.m.a(th)));
            }

            @Override // retrofit2.Callback
            public void onResponse(Call<T> call2, Response<T> response) {
                t9.i.h(call2, "call");
                t9.i.h(response, "response");
                ca.j.this.resumeWith(h9.l.a(response));
            }
        });
        Object r10 = kVar.r();
        if (r10 == l9.c.c()) {
            m9.g.c(continuation);
        }
        return r10;
    }

    public static final /* synthetic */ <T> T create(Retrofit retrofit) {
        t9.i.h(retrofit, "$this$create");
        t9.i.l(4, "T");
        return (T) retrofit.create(Object.class);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object suspendAndThrow(final Exception exc, Continuation<?> continuation) {
        final KotlinExtensions$suspendAndThrow$1 kotlinExtensions$suspendAndThrow$1;
        int i10;
        if (continuation instanceof KotlinExtensions$suspendAndThrow$1) {
            kotlinExtensions$suspendAndThrow$1 = (KotlinExtensions$suspendAndThrow$1) continuation;
            int i11 = kotlinExtensions$suspendAndThrow$1.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                kotlinExtensions$suspendAndThrow$1.label = i11 - Integer.MIN_VALUE;
                Object obj = kotlinExtensions$suspendAndThrow$1.result;
                Object c10 = l9.c.c();
                i10 = kotlinExtensions$suspendAndThrow$1.label;
                if (i10 != 0) {
                    h9.m.b(obj);
                    kotlinExtensions$suspendAndThrow$1.L$0 = exc;
                    kotlinExtensions$suspendAndThrow$1.label = 1;
                    n0.a().L(kotlinExtensions$suspendAndThrow$1.getContext(), new Runnable() { // from class: retrofit2.KotlinExtensions$suspendAndThrow$$inlined$suspendCoroutineUninterceptedOrReturn$lambda$1
                        @Override // java.lang.Runnable
                        public final void run() {
                            Continuation b10 = l9.b.b(Continuation.this);
                            Exception exc2 = exc;
                            l.a aVar = h9.l.f14231a;
                            b10.resumeWith(h9.l.a(h9.m.a(exc2)));
                        }
                    });
                    Object c11 = l9.c.c();
                    if (c11 == l9.c.c()) {
                        m9.g.c(kotlinExtensions$suspendAndThrow$1);
                    }
                    if (c11 == c10) {
                        return c10;
                    }
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    h9.m.b(obj);
                }
                return t.f14242a;
            }
        }
        kotlinExtensions$suspendAndThrow$1 = new KotlinExtensions$suspendAndThrow$1(continuation);
        Object obj2 = kotlinExtensions$suspendAndThrow$1.result;
        Object c102 = l9.c.c();
        i10 = kotlinExtensions$suspendAndThrow$1.label;
        if (i10 != 0) {
        }
        return t.f14242a;
    }
}
