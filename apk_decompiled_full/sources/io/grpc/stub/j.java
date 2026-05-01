package io.grpc.stub;

/* loaded from: classes3.dex */
public interface j {
    void onCompleted();

    void onError(Throwable th);

    void onNext(Object obj);
}
