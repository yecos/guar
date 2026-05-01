package c6;

import android.content.Context;
import android.os.Looper;
import com.mobile.brasiltv.utils.f1;
import com.msandroid.mobile.R;
import com.umeng.analytics.MobclickAgent;
import java.lang.Thread;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class a implements Thread.UncaughtExceptionHandler {

    /* renamed from: d, reason: collision with root package name */
    public static a f5621d = new a();

    /* renamed from: a, reason: collision with root package name */
    public Context f5622a;

    /* renamed from: b, reason: collision with root package name */
    public Map f5623b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    public Thread.UncaughtExceptionHandler f5624c;

    /* renamed from: c6.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC0082a implements Runnable {
        public RunnableC0082a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Looper.prepare();
            f1.f8649a.w(R.string.app_restart);
            Looper.loop();
        }
    }

    public static a a() {
        return f5621d;
    }

    public void b(Context context) {
        this.f5622a = context;
        this.f5624c = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        Context context = this.f5622a;
        if (context == null) {
            return;
        }
        MobclickAgent.onKillProcess(context);
        new Thread(new RunnableC0082a()).start();
        try {
            Thread.currentThread();
            Thread.sleep(2000L);
        } catch (InterruptedException e10) {
            e10.printStackTrace();
        }
        com.mobile.brasiltv.utils.a.b().e();
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f5624c;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
        }
    }
}
