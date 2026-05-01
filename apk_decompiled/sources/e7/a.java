package e7;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.google.zxing.Result;
import com.mobile.brasiltv.activity.ScanLoginActivity;
import com.msandroid.mobile.R;
import java.util.Vector;

/* loaded from: classes3.dex */
public final class a extends Handler {

    /* renamed from: a, reason: collision with root package name */
    public final ScanLoginActivity f12935a;

    /* renamed from: b, reason: collision with root package name */
    public final d f12936b;

    /* renamed from: c, reason: collision with root package name */
    public EnumC0214a f12937c;

    /* renamed from: e7.a$a, reason: collision with other inner class name */
    public enum EnumC0214a {
        PREVIEW,
        SUCCESS,
        DONE
    }

    public a(ScanLoginActivity scanLoginActivity, Vector vector, String str) {
        this.f12935a = scanLoginActivity;
        d dVar = new d(scanLoginActivity, vector, str, new f7.a(scanLoginActivity.V2()));
        this.f12936b = dVar;
        dVar.start();
        this.f12937c = EnumC0214a.SUCCESS;
        d7.c.c().j();
        b();
    }

    public void a() {
        this.f12937c = EnumC0214a.DONE;
        d7.c.c().k();
        Message.obtain(this.f12936b.a(), R.id.quit).sendToTarget();
        try {
            this.f12936b.join();
        } catch (InterruptedException unused) {
        }
        removeMessages(R.id.decode_succeeded);
        removeMessages(R.id.decode_failed);
        removeMessages(R.id.restart_preview);
    }

    public final void b() {
        if (this.f12937c == EnumC0214a.SUCCESS) {
            this.f12937c = EnumC0214a.PREVIEW;
            d7.c.c().i(this.f12936b.a(), R.id.decode);
            d7.c.c().h(this, R.id.auto_focus);
            this.f12935a.T2();
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        switch (message.what) {
            case R.id.auto_focus /* 2131361916 */:
                if (this.f12937c == EnumC0214a.PREVIEW) {
                    d7.c.c().h(this, R.id.auto_focus);
                    break;
                }
                break;
            case R.id.decode_failed /* 2131362015 */:
                this.f12937c = EnumC0214a.PREVIEW;
                d7.c.c().i(this.f12936b.a(), R.id.decode);
                break;
            case R.id.decode_succeeded /* 2131362016 */:
                this.f12937c = EnumC0214a.SUCCESS;
                Bundle data = message.getData();
                this.f12935a.W2((Result) message.obj, data == null ? null : (Bitmap) data.getParcelable("barcode_bitmap"));
                break;
            case R.id.launch_product_query /* 2131362154 */:
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse((String) message.obj));
                intent.addFlags(524288);
                if (this.f12935a.getPackageManager().resolveActivity(intent, 0) != null) {
                    this.f12935a.startActivity(intent);
                    break;
                }
                break;
            case R.id.restart_preview /* 2131363077 */:
                b();
                break;
            case R.id.return_scan_result /* 2131363079 */:
                this.f12935a.setResult(-1, (Intent) message.obj);
                this.f12935a.finish();
                break;
        }
    }
}
