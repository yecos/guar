package ha;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hpplay.component.common.ParamsMap;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.concurrent.TimeoutException;
import ma.e;
import ma.g;
import ma.k;
import ma.n;
import ma.p;
import ma.s;
import ma.u;
import mobile.com.requestframe.util.RemoteLoginAndMsgEvent;
import mobile.com.requestframe.utils.bean.ResultException;
import org.json.JSONObject;
import retrofit2.HttpException;

/* loaded from: classes3.dex */
public abstract class a implements Observer {
    public final Gson a() {
        return new GsonBuilder().disableHtmlEscaping().create();
    }

    public final boolean b(ResultException resultException) {
        return resultException == null || TextUtils.isEmpty(resultException.getReturnCode());
    }

    public final void c(String str, String str2, String str3) {
        str.hashCode();
        switch (str) {
            case "portal100024":
                xa.c.c().j(new e());
                break;
            case "portal100071":
                handleGoogleAccountNotBind(str, str3);
                break;
            case "aaa100027":
            case "aaa100028":
            case "aaa100029":
            case "aaa100030":
                xa.c.c().j(new g());
                break;
            case "aaa100082":
                handleNeedToLogin(str);
                break;
            case "aaa100083":
                xa.c.c().j(new g());
                d(str3);
                break;
            case "aaa100091":
                handleVerifyTokenError();
                break;
            case "aaa100094":
                handleLoginNumberLimit(str, str3);
                break;
        }
    }

    public final void d(String str) {
        RemoteLoginAndMsgEvent remoteLoginAndMsgEvent;
        try {
            remoteLoginAndMsgEvent = (RemoteLoginAndMsgEvent) a().fromJson(str, RemoteLoginAndMsgEvent.class);
        } catch (Exception e10) {
            RemoteLoginAndMsgEvent remoteLoginAndMsgEvent2 = new RemoteLoginAndMsgEvent("unknown", "unknown", "unknown", "unknown");
            e10.printStackTrace();
            remoteLoginAndMsgEvent = remoteLoginAndMsgEvent2;
        }
        if (remoteLoginAndMsgEvent != null) {
            sendRemoteLoginEvent(remoteLoginAndMsgEvent);
        }
    }

    public final void e(Throwable th) {
        try {
            th.printStackTrace();
        } catch (Throwable unused) {
        }
    }

    public void handleGoogleAccountNotBind(String str, String str2) {
    }

    public void handleLoginNumberLimit(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject(str2);
            xa.c.c().j(new k(jSONObject.optString(ParamsMap.DeviceParams.KEY_AUTH_TOKEN), jSONObject.optString("userId")));
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public void handleNeedToLogin(String str) {
        xa.c.c().j(new n());
    }

    public void handleTokenInvalid(String str) {
        xa.c.c().j(new s());
    }

    public void handleVerifyTokenError() {
        xa.c.c().j(new u());
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
    }

    @Override // io.reactivex.Observer
    public void onError(Throwable th) {
        if (th instanceof ResultException) {
            ResultException resultException = (ResultException) th;
            if (b(resultException)) {
                p.c("CustomPortalSubscriber", "find exception obj and obj or obj.field is null.");
                return;
            } else {
                c(resultException.getReturnCode(), resultException.getErrorMessage(), resultException.getErrorData());
                showErrorHint(resultException.getReturnCode());
                return;
            }
        }
        if (th instanceof TimeoutException) {
            showErrorHint("50010");
            return;
        }
        if (th instanceof ConnectException) {
            showErrorHint("50011");
            return;
        }
        if (th instanceof SocketTimeoutException) {
            showErrorHint("50012");
            return;
        }
        if (th instanceof HttpException) {
            showErrorHint(((HttpException) th).code() + "");
            return;
        }
        if (th instanceof UnknownHostException) {
            showErrorHint("50014");
            return;
        }
        e(th);
        try {
            th.printStackTrace();
        } catch (Throwable unused) {
        }
    }

    @Override // io.reactivex.Observer
    public void onNext(Object obj) {
    }

    @Override // io.reactivex.Observer
    public void onSubscribe(Disposable disposable) {
    }

    public void sendRemoteLoginEvent(RemoteLoginAndMsgEvent remoteLoginAndMsgEvent) {
        xa.c.c().j(remoteLoginAndMsgEvent);
    }

    public abstract void showErrorHint(String str);
}
