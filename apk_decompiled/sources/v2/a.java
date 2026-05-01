package v2;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.concurrent.TimeoutException;
import retrofit2.HttpException;

/* loaded from: classes.dex */
public abstract class a implements Observer {
    public final void a(Throwable th) {
        try {
            th.printStackTrace();
        } catch (Throwable unused) {
        }
    }

    public abstract void b(String str);

    @Override // io.reactivex.Observer
    public void onComplete() {
    }

    @Override // io.reactivex.Observer
    public void onError(Throwable th) {
        if (th instanceof TimeoutException) {
            b("50010");
            return;
        }
        if (th instanceof ConnectException) {
            b("50011");
            return;
        }
        if (th instanceof SocketTimeoutException) {
            b("50012");
            return;
        }
        if (th instanceof HttpException) {
            b(((HttpException) th).code() + "");
            return;
        }
        if (th instanceof UnknownHostException) {
            b("50014");
            return;
        }
        a(th);
        try {
            th.printStackTrace();
        } catch (Throwable unused) {
        }
    }

    @Override // io.reactivex.Observer
    public void onSubscribe(Disposable disposable) {
    }
}
