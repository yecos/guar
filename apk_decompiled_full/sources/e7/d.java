package e7;

import android.os.Handler;
import android.os.Looper;
import com.google.zxing.DecodeHintType;
import com.google.zxing.ResultPointCallback;
import com.mobile.brasiltv.activity.ScanLoginActivity;
import java.util.Hashtable;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;

/* loaded from: classes3.dex */
public final class d extends Thread {

    /* renamed from: a, reason: collision with root package name */
    public final ScanLoginActivity f12949a;

    /* renamed from: b, reason: collision with root package name */
    public final Hashtable f12950b;

    /* renamed from: c, reason: collision with root package name */
    public Handler f12951c;

    /* renamed from: d, reason: collision with root package name */
    public final CountDownLatch f12952d = new CountDownLatch(1);

    public d(ScanLoginActivity scanLoginActivity, Vector vector, String str, ResultPointCallback resultPointCallback) {
        this.f12949a = scanLoginActivity;
        Hashtable hashtable = new Hashtable(3);
        this.f12950b = hashtable;
        if (vector == null || vector.isEmpty()) {
            vector = new Vector();
            vector.addAll(b.f12944c);
            vector.addAll(b.f12945d);
            vector.addAll(b.f12946e);
        }
        hashtable.put(DecodeHintType.POSSIBLE_FORMATS, vector);
        if (str != null) {
            hashtable.put(DecodeHintType.CHARACTER_SET, str);
        }
        hashtable.put(DecodeHintType.NEED_RESULT_POINT_CALLBACK, resultPointCallback);
    }

    public Handler a() {
        try {
            this.f12952d.await();
        } catch (InterruptedException unused) {
        }
        return this.f12951c;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Looper.prepare();
        this.f12951c = new c(this.f12949a, this.f12950b);
        this.f12952d.countDown();
        Looper.loop();
    }
}
