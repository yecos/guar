package fb;

/* loaded from: classes.dex */
public interface c {
    void onComplete();

    void onError(Throwable th);

    void onNext(Object obj);

    void onSubscribe(d dVar);
}
