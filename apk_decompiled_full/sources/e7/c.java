package e7;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.ReaderException;
import com.google.zxing.Result;
import com.google.zxing.common.HybridBinarizer;
import com.mobile.brasiltv.activity.ScanLoginActivity;
import com.msandroid.mobile.R;
import java.util.Hashtable;

/* loaded from: classes3.dex */
public final class c extends Handler {

    /* renamed from: a, reason: collision with root package name */
    public final ScanLoginActivity f12947a;

    /* renamed from: b, reason: collision with root package name */
    public final MultiFormatReader f12948b;

    public c(ScanLoginActivity scanLoginActivity, Hashtable hashtable) {
        MultiFormatReader multiFormatReader = new MultiFormatReader();
        this.f12948b = multiFormatReader;
        multiFormatReader.setHints(hashtable);
        this.f12947a = scanLoginActivity;
    }

    public final void a(byte[] bArr, int i10, int i11) {
        Result result;
        long currentTimeMillis = System.currentTimeMillis();
        byte[] bArr2 = new byte[bArr.length];
        for (int i12 = 0; i12 < i11; i12++) {
            for (int i13 = 0; i13 < i10; i13++) {
                bArr2[(((i13 * i11) + i11) - i12) - 1] = bArr[(i12 * i10) + i13];
            }
        }
        d7.e a10 = d7.c.c().a(bArr2, i11, i10);
        try {
            result = this.f12948b.decodeWithState(new BinaryBitmap(new HybridBinarizer(a10)));
            this.f12948b.reset();
        } catch (ReaderException unused) {
            this.f12948b.reset();
            result = null;
        } catch (Throwable th) {
            this.f12948b.reset();
            throw th;
        }
        if (result == null) {
            Message.obtain(this.f12947a.U2(), R.id.decode_failed).sendToTarget();
            return;
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        sb.append("Found barcode (");
        sb.append(currentTimeMillis2 - currentTimeMillis);
        sb.append(" ms):\n");
        sb.append(result.toString());
        Message obtain = Message.obtain(this.f12947a.U2(), R.id.decode_succeeded, result);
        Bundle bundle = new Bundle();
        bundle.putParcelable("barcode_bitmap", a10.a());
        obtain.setData(bundle);
        obtain.sendToTarget();
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        int i10 = message.what;
        if (i10 == R.id.decode) {
            a((byte[]) message.obj, message.arg1, message.arg2);
        } else {
            if (i10 != R.id.quit) {
                return;
            }
            Looper.myLooper().quit();
        }
    }
}
