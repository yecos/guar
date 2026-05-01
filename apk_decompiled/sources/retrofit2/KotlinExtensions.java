package retrofit2;

import com.google.firebase.analytics.FirebaseAnalytics;
import h9.l;
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
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object suspendAndThrow(final java.lang.Exception r4, kotlin.coroutines.Continuation<?> r5) {
        /*
            boolean r0 = r5 instanceof retrofit2.KotlinExtensions$suspendAndThrow$1
            if (r0 == 0) goto L13
            r0 = r5
            retrofit2.KotlinExtensions$suspendAndThrow$1 r0 = (retrofit2.KotlinExtensions$suspendAndThrow$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            retrofit2.KotlinExtensions$suspendAndThrow$1 r0 = new retrofit2.KotlinExtensions$suspendAndThrow$1
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = l9.c.c()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r4 = r0.L$0
            java.lang.Exception r4 = (java.lang.Exception) r4
            h9.m.b(r5)
            goto L5c
        L2d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L35:
            h9.m.b(r5)
            r0.L$0 = r4
            r0.label = r3
            ca.y r5 = ca.n0.a()
            k9.f r2 = r0.getContext()
            retrofit2.KotlinExtensions$suspendAndThrow$$inlined$suspendCoroutineUninterceptedOrReturn$lambda$1 r3 = new retrofit2.KotlinExtensions$suspendAndThrow$$inlined$suspendCoroutineUninterceptedOrReturn$lambda$1
            r3.<init>()
            r5.L(r2, r3)
            java.lang.Object r4 = l9.c.c()
            java.lang.Object r5 = l9.c.c()
            if (r4 != r5) goto L59
            m9.g.c(r0)
        L59:
            if (r4 != r1) goto L5c
            return r1
        L5c:
            h9.t r4 = h9.t.f14242a
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: retrofit2.KotlinExtensions.suspendAndThrow(java.lang.Exception, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
